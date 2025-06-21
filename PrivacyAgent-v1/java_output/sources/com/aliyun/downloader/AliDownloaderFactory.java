package com.aliyun.downloader;

/* loaded from: classes.dex */
public class AliDownloaderFactory {
    public static com.aliyun.downloader.AliMediaDownloader create(android.content.Context context) {
        return new com.aliyun.downloader.ApsaraDownloader(context.getApplicationContext());
    }

    public static int deleteFile(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        return com.aliyun.downloader.AliMediaDownloader.deleteFile(str, str2, str3, i);
    }
}
