package com.lucksoft.commonui.io;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.text.TextUtils;

import com.lucksoft.commonui.util.CollectionUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class FileManager {
    private static Application context;
    private final FileStreamManager fileStreamManager;
    private static final String FRESCO_CACHE_DIR = "img_disk_cache";

    private FileManager() {
        if (context == null) {
            throw new RuntimeException("you must call init before getInstance");
        }
        fileStreamManager = new FileStreamManager();
    }

    public void deleteFiles(@NonNull File file) {
        fileStreamManager.deleteFiles(file);
    }

    private static class FileManagerHolder {
        private static final FileManager INSTANCE = new FileManager();
        private FileManagerHolder() { }
    }

    public static FileManager getInstance() {
        return FileManagerHolder.INSTANCE;
    }

    public static void init(Application c) {
        context = c;
    }

    public File getCachePath(String subName) {
        File rootPath;
        if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()) {
            rootPath = context.getExternalCacheDir();
        } else {
            rootPath = context.getCacheDir();
        }
        return appendDir(rootPath, subName);
    }

    public File getDownloadFile(String subName) {
        File rootPath = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        return appendDir(rootPath, subName);
    }

    public List<File> getCachePaths(String subName) {
        List<File> files = new ArrayList<>();
        if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()) {
            File file = context.getExternalCacheDir();
            files.add(appendDir(file, subName));
        } else {
            File file = context.getCacheDir();
            files.add(appendDir(file, subName));
        }
        return files;
    }

    public File getAppStoragePath(String subName) {
        File rootPath = null;
        if (supportExternalStorage()) {
            rootPath = Environment.getExternalStorageDirectory();
        }
        if (rootPath != null) {
            return appendDir(rootPath, subName);
        } else {
            return null;
        }
    }

    public File getFileStoragePath(String subName) {
        File rootPath;
        if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()) {
            rootPath = context.getExternalFilesDir(null);
        } else {
            rootPath = context.getFilesDir();
        }
        return appendDir(rootPath, subName);
    }

    public long getFoldersSize(List<File> folders, final List<File> excludes) {
        long size = 0;
        if (folders == null || folders.size() == 0) return size;

        for (File folder : folders) {
            try {
                size += getFolderSize(folder, excludes);
            } catch (Exception e) {
                // do nothing
            }
        }
        return size;
    }

    public boolean writeStreamToAppStorage(InputStream stream, String fileName) {
        File file = getAppStoragePath(fileName);
        return fileStreamManager.writeStream(file, stream);
    }

    public boolean writeBitmapToAppStorage(Bitmap bitmap, String fileName, boolean isRecycleBitmap) {
        File file = getAppStoragePath(fileName);
        return fileStreamManager.writeBitmap(file, bitmap, isRecycleBitmap);
    }

    public boolean writeBitmap(@Nullable File file, @NonNull Bitmap bitmap, boolean isRecycleBitmap) {
        return fileStreamManager.writeBitmap(file, bitmap, isRecycleBitmap);
    }


    public Rect saveCameraBitmap(String filePath, byte[] data, FileStreamManager.CameraType cameraType) {
        return fileStreamManager.saveCameraBitmap(new File(filePath), data, cameraType);
    }

    public File copyToAppStorage(File source, String fileName) {
        File file = getAppStoragePath(fileName);
        return fileStreamManager.copyFileToFile(source, file);
    }

    public File copyToAppCache(File source, String fileName) {
        File file = getCachePath(fileName);
        return fileStreamManager.copyFileToFile(source, file);
    }

    public static boolean deleteFile(String filePath) {
        return new File(filePath).delete();
    }

    public static String parseExtName(@NonNull String filePath) {
        int dot = filePath.lastIndexOf('.');
        if ((dot > -1) && (dot < (filePath.length() - 1))) {
            return filePath.substring(dot + 1);
        }
        return null;
    }

    private boolean supportExternalStorage() {
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) ||
                        !Environment.isExternalStorageRemovable());
    }

    private File appendDir(File rootPath, String subName) {
        File file = new File(rootPath, subName);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                return null;
            }
        }
        return file;
    }

    private List<File> getCaches() {
        List<File> files = new ArrayList<>();
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())) {
            files.add(context.getExternalCacheDir());
        }
        files.add(context.getCacheDir());
        return files;
    }

    /**
     * 清除Android  cache
     */
    public boolean clearAppCache() {
        List<File> files = getCaches();
        if (CollectionUtil.isEmpty(files)) {
            return false;
        }
        for (File file : files) {
            if (file != null) {
                fileStreamManager.deleteFiles(file);
            }
        }
        return true;
    }

    /**
     * 获取可删除缓存的目录大小
     * @return
     * @param excludeDir
     */
    private long getCacheSize(File excludeDir) {
        long size = 0;
        List<File> files = getCaches();
        if (CollectionUtil.isEmpty(files)) {
            return 0;
        }
        for (File file : files) {
            try {
                size += getFolderSize(file, excludeDir);
            } catch (Exception e) {
                // do nothing
            }
        }
        return size;
    }


    private long getFolderSize(File file, final File excludeFile) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return !TextUtils.equals(pathname.getAbsolutePath(), excludeFile.getAbsolutePath());
                }
            });
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i], excludeFile);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            // do nothing
        }
        return size;
    }

    File getFrescoCacheDir() {
        return FileManager.getInstance().getCachePath(FRESCO_CACHE_DIR);
    }

    /**
     * 清除整体APP的临时cache目录
     * Fresco的缓存目录通过fresco单独获取，故屏蔽掉Fresco目录
     * @return
     */
    long getAppCacheSizeExcludeFresco() {
        return FileManager.getInstance().getCacheSize(getFrescoCacheDir());
    }

    private long getFolderSize(File folder, final List<File> excludes) {
        long size = 0;

        File[] fileList = folder.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if (excludes != null && excludes.size() > 0) {
                    for (int i = 0; i < excludes.size(); i++) {
                        File f = excludes.get(i);
                        if (TextUtils.equals(pathname.getAbsolutePath(), f.getAbsolutePath())) {
                            return false;
                        }
                    }
                }
                return true;
            }

        });

        for (File f : fileList) {
            if (f.isDirectory()) {
                size = size + getFolderSize(f, excludes);
            } else {
                size = size + f.length();
            }
        }
        return size;
    }

    public File getFrescoCache() {
        return FileManager.getInstance().getCachePath(FRESCO_CACHE_DIR);
    }
}
