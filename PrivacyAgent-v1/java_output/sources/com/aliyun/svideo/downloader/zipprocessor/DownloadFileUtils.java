package com.aliyun.svideo.downloader.zipprocessor;

/* loaded from: classes.dex */
public final class DownloadFileUtils {
    public static java.io.File getAssetPackageDir(android.content.Context context, java.lang.String str, long j) {
        return new java.io.File(com.aliyun.common.utils.StorageUtils.getFilesDirectory(context), str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + java.lang.String.valueOf(j));
    }

    public static java.lang.String initDownloadPath(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static boolean isPasterExist(android.content.Context context, java.lang.String str, long j) {
        java.io.File assetPackageDir = getAssetPackageDir(context, str, j);
        return assetPackageDir.exists() && assetPackageDir.isDirectory();
    }
}
