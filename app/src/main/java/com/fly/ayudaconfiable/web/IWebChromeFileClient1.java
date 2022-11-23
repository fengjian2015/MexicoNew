//package com.fly.ayudaconfiable.web;
//
//import static android.app.Activity.RESULT_OK;
//
//import android.app.Activity;
//import android.content.ContentResolver;
//import android.content.ContentUris;
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Environment;
//import android.os.Parcelable;
//import android.provider.DocumentsContract;
//import android.provider.MediaStore;
//import android.view.View;
//import android.webkit.ValueCallback;
//import android.webkit.WebChromeClient;
//import android.webkit.WebView;
//import android.widget.ProgressBar;
//
//import com.fly.ayudaconfiable.utils.CommonUtil;
//import com.hjq.permissions.OnPermissionCallback;
//import com.hjq.permissions.Permission;
//import com.hjq.permissions.XXPermissions;
//import com.intertive.hiperempresito.R;
//import com.intertive.hiperempresito.androidlib.util.BitmapUtil;
//import com.intertive.hiperempresito.androidlib.util.ContextUtil;
//import com.intertive.hiperempresito.androidlib.util.FileProviderUtil;
//import com.intertive.hiperempresito.androidlib.util.FileUtil;
//import com.intertive.hiperempresito.androidlib.util.Logan;
//import com.intertive.hiperempresito.androidlib.util.TimeUtil;
//import com.intertive.hiperempresito.androidlib.util.ToastUtil;
//import com.intertive.hiperempresito.business.component.AppsFlyerManager;
//
//import java.io.File;
//import java.util.List;
//
//
///**
// * author: Rea.X
// * date: 2017/9/21.
// */
//
//public class IWebChromeFileClient1 extends WebChromeClient {
//
//    public static final int INPUT_FILE_REQUEST_CODE = 1;
//
//    protected Context context;
//    protected WebView view;
//    private ValueCallback<Uri[]> mFilePathCallback;
//    private final ProgressBar progressBar;
//    //    private Uri imageUri;
//    private File cameraFile;
//
//
//    public IWebChromeFileClient1(WebView view, ProgressBar progressBar) {
//        this.view = view;
//        this.context = view.getContext();
//        this.progressBar = progressBar;
//    }
//
//
//    @Override
//    public void onProgressChanged(WebView webView, int newProgress) {
//        super.onProgressChanged(webView, newProgress);
//        if (progressBar != null) {
//            this.progressBar.setVisibility(View.VISIBLE);
//            this.progressBar.setProgress(newProgress);
//            if (newProgress >= 80) {
//                this.progressBar.setVisibility(View.GONE);
//            }
//        }
//    }
//
//    @Override
//    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
//        mFilePathCallback = filePathCallback;
//        openAlbum();
//        return true;
//    }
//
//    private void startActivityForResult(Intent intent, int code) {
//        Logan.w("startActivityForResult");
//        if (context instanceof Activity) {
//            Activity activity = (Activity) context;
//            activity.startActivityForResult(intent, code);
//        }
//    }
//
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Logan.w("onActivityResult");
//        if (requestCode == INPUT_FILE_REQUEST_CODE && mFilePathCallback != null) {
//            chooseAbove(resultCode, data);
//        } else {
//            Logan.w("发生错误");
//        }
//    }
//
//    private void openAlbum() {
//        XXPermissions.with(context)
//                .permission(Permission.CAMERA)
//                .request(new OnPermissionCallback() {
//                    @Override
//                    public void onGranted(List<String> permissions, boolean all) {
//                        openCamera();
//                    }
//
//                    @Override
//                    public void onDenied(List<String> permissions, boolean never) {
//                        if (mFilePathCallback != null){
//                            mFilePathCallback.onReceiveValue(null);
//                        }
//                    }
//                });
//    }
//
//    private void openCamera() {
//        try {
//            String filePath = CommonUtil.INSTANCE.getImageDir();
//            String fileName = System.currentTimeMillis() + ".jpg";
//            cameraFile = new File(filePath + fileName);
//            Uri imageUri = FileProviderUtil.getUriForFile(ContextUtil.getAppContext(), cameraFile);
//            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//            startActivityForResult(captureIntent, INPUT_FILE_REQUEST_CODE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (mFilePathCallback != null){
//                mFilePathCallback.onReceiveValue(null);
//            }
//        }
//    }
//
//    private void openPhotoSelector(List<String> permissions, boolean all) {
//        Logan.w("openPhotoSelector");
//
//        try {
//            if (all) {
//                // 指定拍照存储位置的方式调起相机
//                String filePath = FileUtil.getInnerImgPath(context);
//                String fileName = TimeUtil.getMilliTimestamp() + ".jpg";
//                cameraFile = new File(filePath + fileName);
//                Uri imageUri = FileProviderUtil.getUriForFile(ContextUtil.getAppContext(), cameraFile);
//                Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                Intent Photo = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                Intent chooserIntent = Intent.createChooser(Photo, "选择照片");
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Parcelable[]{captureIntent});
//                startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE);
//
//            } else if (permissions.contains(Permission.CAMERA)) {
//                String filePath = FileUtil.getInnerImgPath(context);
//                String fileName = TimeUtil.getMilliTimestamp() + ".jpg";
//                cameraFile = new File(filePath + fileName);
//                Uri imageUri = FileProviderUtil.getUriForFile(ContextUtil.getAppContext(), cameraFile);
//                Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
////                Intent Photo = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
////                Intent chooserIntent = Intent.createChooser(captureIntent, "拍照");
////                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Parcelable[]{captureIntent});
//                startActivityForResult(captureIntent, INPUT_FILE_REQUEST_CODE);
//
//            } else if (permissions.contains(Permission.WRITE_EXTERNAL_STORAGE)
//                    && permissions.contains(Permission.READ_EXTERNAL_STORAGE)) {
////                String filePath = FileUtil.getInnerImgPath(context);
////                String fileName = TimeUtil.getMilliTimestamp() + ".jpg";
////                cameraFile = new File(filePath + fileName);
//                Intent Photo = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                Intent chooserIntent = Intent.createChooser(Photo, "选择照片");
////                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Parcelable[]{captureIntent});
//                startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private void chooseAbove(int resultCode, Intent data) {
//        if (RESULT_OK == resultCode) {
////            updatePhotos();
//            if (data != null) {
////                处理选择的照片
//                Uri[] results;
//                Uri uriData = data.getData();
//                if (uriData != null) {
//                    results = new Uri[]{uriData};
//                    try {
//                        Uri compressImageUri = BitmapUtil.compressBmpFromBmp(uriToString(uriData));
//                        mFilePathCallback.onReceiveValue(new Uri[]{compressImageUri});
//                    } catch (Exception e) {
//                        e.printStackTrace();
////                        requestWritePermission();
//                    }
//                } else {
//                    mFilePathCallback.onReceiveValue(null);
//                }
//            } else {
////                处理拍照的照片
//                try {
//                    Uri compressImageUri = BitmapUtil.compressBmpFromBmp(cameraFile.getAbsolutePath());
//                    mFilePathCallback.onReceiveValue(new Uri[]{compressImageUri});
//                } catch (Exception e) {
//                    e.printStackTrace();
////                    requestWritePermission();
//                }
//            }
//        } else {
//            mFilePathCallback.onReceiveValue(null);
//        }
//        mFilePathCallback = null;
//    }
//
//    private String uriToString(Uri uri) {
//        String path = null;
//        if (ContentResolver.SCHEME_CONTENT.equals(uri.getScheme())) {
//            if (DocumentsContract.isDocumentUri(context, uri)) {
//                // ExternalStorageProvider
//                if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
//                    String docId = DocumentsContract.getDocumentId(uri);
//                    String[] split = docId.split(":");
//                    String type = split[0];
//                    if ("primary".equalsIgnoreCase(type)) {
//                        path = Environment.getExternalStorageDirectory() + "/" + split[1];
//                    }
//
//                } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
//                    // DownloadsProvider
//                    String id = DocumentsContract.getDocumentId(uri);
//                    Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
//                    path = getDataColumn(context, contentUri, null, null);
//
//                } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
//                    // MediaProvider
//                    String docId = DocumentsContract.getDocumentId(uri);
//                    String[] split = docId.split(":");
//                    String type = split[0];
//                    Uri contentUri = null;
//                    if ("image".equals(type)) {
//                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                    } else if ("video".equals(type)) {
//                        contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                    } else if ("audio".equals(type)) {
//                        contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                    }
//                    String selection = "_id=?";
//                    String[] selectionArgs = new String[]{split[1]};
//                    path = getDataColumn(context, contentUri, selection, selectionArgs);
//                }
//
//            } else {
//                path = getRealPathFromUri(context, uri);
//            }
//        }
//        return path;
//    }
//
//    private String getRealPathFromUri(Context context, Uri contentUri) {
//        Cursor cursor = null;
//        try {
//            String[] proj = {MediaStore.Files.FileColumns.DATA};
//            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
//            cursor.moveToFirst();
//            return cursor.getString(column_index);
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }
//    }
//
//    private String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
//        Cursor cursor = null;
//        final String column = "_data";
//        final String[] projection = {column};
//        try {
//            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
//            if (cursor != null && cursor.moveToFirst()) {
//                final int column_index = cursor.getColumnIndexOrThrow(column);
//                return cursor.getString(column_index);
//            }
//        } finally {
//            if (cursor != null)
//                cursor.close();
//        }
//        return null;
//    }
//
//    private void updatePhotos() {
//        // 该广播即使多发（即选取照片成功时也发送）也没有关系，只是唤醒系统刷新媒体文件
//        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
////        intent.setData(imageUri);
////        sendBroadcast(intent);
//    }
//
//
//}
