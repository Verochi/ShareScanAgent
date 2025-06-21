package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class DownloaderManagerConfiguration {
    private int mAutoRetryTimes;
    private java.lang.String mCk;
    private android.content.Context mContext;
    private java.util.Map<java.lang.String, java.lang.String> mDbExtFieldMap;
    private com.aliyun.svideo.downloader.DbUpgradeListener mDbUpgradeListener;
    private int mDbVersion;
    private boolean mDebug;
    private java.lang.String mDownloadStorePath;
    private okhttp3.Headers mHeaders;
    private boolean mIsCipher;
    private int mMaxDownloadingCount;

    public static class Builder {
        private java.lang.String mCk;
        private android.content.Context mContext;
        private java.util.Map<java.lang.String, java.lang.String> mDbExtFieldMap;
        private com.aliyun.svideo.downloader.DbUpgradeListener mDbUpgradeListener;
        private boolean mDebug;
        private java.lang.String mDownloadStorePath;
        private boolean mIsCipher;
        private int mMaxDownloadingCount = 1;
        private int mDbVersion = 1;
        private int mAutoRetryTimes = 3;
        private okhttp3.Headers.Builder mHeaders = new okhttp3.Headers.Builder();

        public Builder(android.content.Context context) {
            this.mContext = context;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder addHeader(java.lang.String str) {
            this.mHeaders.add(str);
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.mHeaders.add(str, str2);
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration build() {
            return new com.aliyun.svideo.downloader.DownloaderManagerConfiguration(this, null);
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setAutoRetryTimes(int i) {
            this.mAutoRetryTimes = i;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setCK(java.lang.String str) {
            this.mCk = str;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setCipher(boolean z) {
            this.mIsCipher = z;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setDbExtField(java.util.Map<java.lang.String, java.lang.String> map) {
            this.mDbExtFieldMap = map;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setDbUpgradeListener(com.aliyun.svideo.downloader.DbUpgradeListener dbUpgradeListener) {
            this.mDbUpgradeListener = dbUpgradeListener;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setDbVersion(int i) {
            this.mDbVersion = i;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setDownloadStorePath(java.lang.String str) {
            this.mDownloadStorePath = str;
            return this;
        }

        public com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder setMaxDownloadingCount(int i) {
            this.mMaxDownloadingCount = i;
            return this;
        }
    }

    private DownloaderManagerConfiguration(com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder builder) {
        this.mMaxDownloadingCount = 3;
        this.mContext = builder.mContext;
        this.mDownloadStorePath = builder.mDownloadStorePath;
        this.mDbExtFieldMap = builder.mDbExtFieldMap;
        this.mDbVersion = builder.mDbVersion;
        this.mDbUpgradeListener = builder.mDbUpgradeListener;
        this.mDebug = builder.mDebug;
        this.mCk = builder.mCk;
        this.mIsCipher = builder.mIsCipher;
        if (builder.mMaxDownloadingCount > 0) {
            this.mMaxDownloadingCount = builder.mMaxDownloadingCount;
        }
        this.mAutoRetryTimes = builder.mAutoRetryTimes;
        this.mHeaders = builder.mHeaders.build();
    }

    public /* synthetic */ DownloaderManagerConfiguration(com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder builder, defpackage.i50 i50Var) {
        this(builder);
    }

    public int getAutoRetryTimes() {
        return this.mAutoRetryTimes;
    }

    public java.lang.String getCk() {
        return this.mCk;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public java.util.Map<java.lang.String, java.lang.String> getDbExtField() {
        return this.mDbExtFieldMap;
    }

    public com.aliyun.svideo.downloader.DbUpgradeListener getDbUpgradeListener() {
        return this.mDbUpgradeListener;
    }

    public int getDbVersion() {
        return this.mDbVersion;
    }

    public java.lang.String getDownloadStorePath() {
        return this.mDownloadStorePath;
    }

    public okhttp3.Headers getHeaders() {
        return this.mHeaders;
    }

    public int getMaxDownloadingCount() {
        return this.mMaxDownloadingCount;
    }

    public boolean iCipher() {
        return this.mIsCipher;
    }

    public boolean isDebug() {
        return this.mDebug;
    }
}
