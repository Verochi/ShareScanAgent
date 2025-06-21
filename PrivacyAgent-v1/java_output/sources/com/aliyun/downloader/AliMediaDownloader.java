package com.aliyun.downloader;

/* loaded from: classes.dex */
public abstract class AliMediaDownloader {

    public interface ConvertURLCallback {
        java.lang.String convertURL(java.lang.String str, java.lang.String str2);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnErrorListener {
        void onError(com.aliyun.player.bean.ErrorInfo errorInfo);
    }

    public interface OnPreparedListener {
        void onPrepared(com.aliyun.player.nativeclass.MediaInfo mediaInfo);
    }

    public interface OnProgressListener {
        void onDownloadingProgress(int i);

        void onProcessingProgress(int i);
    }

    public static int deleteFile(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        return com.aliyun.downloader.nativeclass.JniDownloader.deleteFile(str, str2, str3, i);
    }

    public static void setConvertURLCallback(com.aliyun.downloader.AliMediaDownloader.ConvertURLCallback convertURLCallback) {
        com.aliyun.downloader.nativeclass.JniDownloader.setConvertURLCallback(convertURLCallback);
    }

    public abstract void deleteFile();

    public abstract java.lang.String getFilePath();

    public abstract void prepare(com.aliyun.player.source.VidAuth vidAuth);

    public abstract void prepare(com.aliyun.player.source.VidSts vidSts);

    public abstract void release();

    public abstract void selectItem(int i);

    public abstract void setDownloaderConfig(com.aliyun.downloader.DownloaderConfig downloaderConfig);

    public abstract void setOnCompletionListener(com.aliyun.downloader.AliMediaDownloader.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(com.aliyun.downloader.AliMediaDownloader.OnErrorListener onErrorListener);

    public abstract void setOnPreparedListener(com.aliyun.downloader.AliMediaDownloader.OnPreparedListener onPreparedListener);

    public abstract void setOnProgressListener(com.aliyun.downloader.AliMediaDownloader.OnProgressListener onProgressListener);

    public abstract void setSaveDir(java.lang.String str);

    public abstract void start();

    public abstract void stop();

    public abstract void updateSource(com.aliyun.player.source.VidAuth vidAuth);

    public abstract void updateSource(com.aliyun.player.source.VidSts vidSts);
}
