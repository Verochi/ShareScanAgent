package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class FileUtils {
    public static void clearDirectory(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public static boolean deleteDirectory(java.io.File file) {
        clearDirectory(file);
        return file.delete();
    }

    public static boolean deleteFD(java.io.File file) {
        if (file.exists()) {
            return file.isDirectory() ? deleteDirectory(file) : file.delete();
        }
        return false;
    }

    public static boolean deleteFD(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(file.getAbsolutePath() + java.lang.System.currentTimeMillis());
        file.renameTo(file2);
        return deleteFD(file2);
    }

    public static java.io.File getApplicationSdcardPath(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MOVIES);
        return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
    }

    private static java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor query = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        java.lang.String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String getFilePathByUri(android.content.Context context, android.net.Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        "content".equals(uri.getScheme());
        android.net.Uri uri2 = null;
        if ("content".equals(uri.getScheme()) && android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                java.lang.String[] split = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return android.os.Environment.getExternalStorageDirectory() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(android.provider.DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    java.lang.String[] split2 = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    java.lang.String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new java.lang.String[]{split2[1]});
                }
            }
        }
        return null;
    }

    public static long getSdcardAvailableSize() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static long getSdcardTotalSize() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    private static boolean isDownloadsDocument(android.net.Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isExternalStorageDocument(android.net.Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(android.net.Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
