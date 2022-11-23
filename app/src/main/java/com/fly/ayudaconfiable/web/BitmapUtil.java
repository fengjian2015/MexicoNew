package com.fly.ayudaconfiable.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;

import com.fly.ayudaconfiable.MyApplication;
import com.fly.ayudaconfiable.utils.CommonUtil;
import com.fly.ayudaconfiable.utils.FileUtil;
import com.fly.ayudaconfiable.utils.TimeUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Nevio
 * on 2022/10/4
 */
public class BitmapUtil {


    public static String getImageDir() {
        Context context = MyApplication.getApplication();
        String path = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File f = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (f == null) {
                path = context.getFilesDir().getAbsolutePath();
            } else {
                path = f.getAbsolutePath();
            }
        } else {
            path = context.getFilesDir().getAbsolutePath();
        }
        try {
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static Uri compressBmpFromBmp(String srcPath) {
//        String srcPathStr = srcPath;
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        newOptions.inJustDecodeBounds = true;//只读边，不读内容
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOptions);

        newOptions.inJustDecodeBounds = false;
        int w = newOptions.outWidth;
        int h = newOptions.outHeight;
        float hh = 2000f;
        float ww = 2000f;
        int be = 1;
        if (w > h && w > ww) {
            be = (int) (newOptions.outWidth / ww);
        } else if (w < h && h > hh) {
            be = (int) (newOptions.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOptions.inSampleSize = be;//设置采样率
        newOptions.inPreferredConfig = Bitmap.Config.RGB_565;//
        newOptions.inPurgeable = true;//同时设置才会有效
        newOptions.inInputShareable = true;//当系统内存不够时候图片会自动被回收

        bitmap = BitmapFactory.decodeFile(srcPath, newOptions);
        int degree = readPictureDegree(srcPath);
        bitmap = rotateBitmap(bitmap, degree);
        return compressBmpToFile(bitmap);

    }


    /**
     * @param bmp
     * @description 将图片保存到本地时进行压缩, 即将图片从Bitmap形式变为File形式时进行压缩,
     * 特点是: File形式的图片确实被压缩了, 但是当你重新读取压缩后的file为 Bitmap是,它占用的内存并没有改变
     * 所谓的质量压缩，即为改变其图像的位深和每个像素的透明度，也就是说JPEG格式压缩后，原来图片中透明的元素将消失，所以这种格式很可能造成失真
     */
    public static Uri compressBmpToFile(Bitmap bmp) {
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shoppingMall/compressImgs/";
        String path = CommonUtil.INSTANCE.getImageDir()+ "/compressImg/";

        File file = new File(path + System.currentTimeMillis() + ".jpg");
        //判断文件夹是否存在,如果不存在则创建文件夹
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 100;
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length / 1024 > 900) {
            baos.reset();
            options -= 10;
            bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
//            copyExif(srcPathStr,file.getAbsolutePath());
//            return file.getAbsolutePath();
            return Uri.fromFile(file);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取图片旋转角度
     *
     * @param srcPath
     * @return
     */
    private static int readPictureDegree(String srcPath) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(srcPath);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    //处理图片旋转
    private static Bitmap rotateBitmap(Bitmap bitmap, int rotate) {
        if (bitmap == null)
            return null;

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        // Setting post rotate to 90
        Matrix mtx = new Matrix();
        mtx.postRotate(rotate);
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    public Bitmap compress(Context context, String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath,newOpts);//此时返回bm为空

        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;
        float ww = 480f;
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0){
            be = 1;
        }
        newOpts.inSampleSize = be;//设置缩放比例
        newOpts.inJustDecodeBounds = false;
        newOpts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }

    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 90;
        int length = baos.toByteArray().length / 1024;

        if (length > 5000) {
            //重置baos即清空baos
            baos.reset();
            //质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
            image.compress(Bitmap.CompressFormat.JPEG, 10, baos);
        } else if (length > 4000) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        } else if (length > 3000) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        } else if (length > 2000) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        }
        //循环判断如果压缩后图片是否大于1M,大于继续压缩
        while (baos.toByteArray().length / 1024 > 1024) {
            //重置baos即清空baos
            baos.reset();
            //这里压缩options%，把压缩后的数据存放到baos中
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            //每次都减少10
            options -= 10;
        }
        //把压缩后的数据baos存放到ByteArrayInputStream中
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        //把ByteArrayInputStream数据生成图片
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        return bitmap;
    }



}
