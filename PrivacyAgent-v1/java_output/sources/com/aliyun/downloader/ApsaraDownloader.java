package com.aliyun.downloader;

/* loaded from: classes.dex */
class ApsaraDownloader extends com.aliyun.downloader.AliMediaDownloader {
    private android.content.Context mAppContext;
    private com.aliyun.downloader.nativeclass.JniDownloader mCoreDownloader;
    private com.aliyun.downloader.AliMediaDownloader.OnCompletionListener mOuterCompletionListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnErrorListener mOuterOnErrorListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnPreparedListener mOuterOnPreparedListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnProgressListener mOuterOnProgressListener = null;

    public static class InnerCompletionListener implements com.aliyun.downloader.AliMediaDownloader.OnCompletionListener {
        private java.lang.ref.WeakReference<com.aliyun.downloader.ApsaraDownloader> downloaderWk;

        private InnerCompletionListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader) {
            this.downloaderWk = new java.lang.ref.WeakReference<>(apsaraDownloader);
        }

        public /* synthetic */ InnerCompletionListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader, com.aliyun.downloader.ApsaraDownloader.AnonymousClass1 anonymousClass1) {
            this(apsaraDownloader);
        }

        @Override // com.aliyun.downloader.AliMediaDownloader.OnCompletionListener
        public void onCompletion() {
            com.aliyun.downloader.ApsaraDownloader apsaraDownloader = this.downloaderWk.get();
            if (apsaraDownloader != null) {
                apsaraDownloader.onCompletion();
            }
        }
    }

    public static class InnerErrorListener implements com.aliyun.downloader.AliMediaDownloader.OnErrorListener {
        private java.lang.ref.WeakReference<com.aliyun.downloader.ApsaraDownloader> downloaderWk;

        private InnerErrorListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader) {
            this.downloaderWk = new java.lang.ref.WeakReference<>(apsaraDownloader);
        }

        public /* synthetic */ InnerErrorListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader, com.aliyun.downloader.ApsaraDownloader.AnonymousClass1 anonymousClass1) {
            this(apsaraDownloader);
        }

        @Override // com.aliyun.downloader.AliMediaDownloader.OnErrorListener
        public void onError(com.aliyun.player.bean.ErrorInfo errorInfo) {
            com.aliyun.downloader.ApsaraDownloader apsaraDownloader = this.downloaderWk.get();
            if (apsaraDownloader != null) {
                apsaraDownloader.onError(errorInfo);
            }
        }
    }

    public static class InnerOnProgressListener implements com.aliyun.downloader.AliMediaDownloader.OnProgressListener {
        private java.lang.ref.WeakReference<com.aliyun.downloader.ApsaraDownloader> downloaderWk;

        private InnerOnProgressListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader) {
            this.downloaderWk = new java.lang.ref.WeakReference<>(apsaraDownloader);
        }

        public /* synthetic */ InnerOnProgressListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader, com.aliyun.downloader.ApsaraDownloader.AnonymousClass1 anonymousClass1) {
            this(apsaraDownloader);
        }

        @Override // com.aliyun.downloader.AliMediaDownloader.OnProgressListener
        public void onDownloadingProgress(int i) {
            com.aliyun.downloader.ApsaraDownloader apsaraDownloader = this.downloaderWk.get();
            if (apsaraDownloader != null) {
                apsaraDownloader.onDownloadingProgress(i);
            }
        }

        @Override // com.aliyun.downloader.AliMediaDownloader.OnProgressListener
        public void onProcessingProgress(int i) {
            com.aliyun.downloader.ApsaraDownloader apsaraDownloader = this.downloaderWk.get();
            if (apsaraDownloader != null) {
                apsaraDownloader.onProcessingProgress(i);
            }
        }
    }

    public static class InnerPreparedListener implements com.aliyun.downloader.AliMediaDownloader.OnPreparedListener {
        private java.lang.ref.WeakReference<com.aliyun.downloader.ApsaraDownloader> downloaderWk;

        private InnerPreparedListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader) {
            this.downloaderWk = new java.lang.ref.WeakReference<>(apsaraDownloader);
        }

        public /* synthetic */ InnerPreparedListener(com.aliyun.downloader.ApsaraDownloader apsaraDownloader, com.aliyun.downloader.ApsaraDownloader.AnonymousClass1 anonymousClass1) {
            this(apsaraDownloader);
        }

        @Override // com.aliyun.downloader.AliMediaDownloader.OnPreparedListener
        public void onPrepared(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            com.aliyun.downloader.ApsaraDownloader apsaraDownloader = this.downloaderWk.get();
            if (apsaraDownloader != null) {
                apsaraDownloader.onPrepared(mediaInfo);
            }
        }
    }

    public ApsaraDownloader(android.content.Context context) {
        this.mAppContext = context;
        com.aliyun.downloader.nativeclass.JniDownloader jniDownloader = new com.aliyun.downloader.nativeclass.JniDownloader(context);
        this.mCoreDownloader = jniDownloader;
        jniDownloader.setOnCompletionListener(new com.aliyun.downloader.ApsaraDownloader.InnerCompletionListener(this, null));
        this.mCoreDownloader.setOnErrorListener(new com.aliyun.downloader.ApsaraDownloader.InnerErrorListener(this, null));
        this.mCoreDownloader.setOnPreparedListener(new com.aliyun.downloader.ApsaraDownloader.InnerPreparedListener(this, null));
        this.mCoreDownloader.setOnProgressListener(new com.aliyun.downloader.ApsaraDownloader.InnerOnProgressListener(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompletion() {
        com.aliyun.downloader.AliMediaDownloader.OnCompletionListener onCompletionListener = this.mOuterCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadingProgress(int i) {
        com.aliyun.downloader.AliMediaDownloader.OnProgressListener onProgressListener = this.mOuterOnProgressListener;
        if (onProgressListener != null) {
            onProgressListener.onDownloadingProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.aliyun.player.bean.ErrorInfo errorInfo) {
        com.aliyun.downloader.AliMediaDownloader.OnErrorListener onErrorListener = this.mOuterOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(errorInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
        com.aliyun.downloader.AliMediaDownloader.OnPreparedListener onPreparedListener = this.mOuterOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(mediaInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessingProgress(int i) {
        com.aliyun.downloader.AliMediaDownloader.OnProgressListener onProgressListener = this.mOuterOnProgressListener;
        if (onProgressListener != null) {
            onProgressListener.onProcessingProgress(i);
        }
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void deleteFile() {
        this.mCoreDownloader.deleteFile();
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public java.lang.String getFilePath() {
        return this.mCoreDownloader.getFilePath();
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void prepare(com.aliyun.player.source.VidAuth vidAuth) {
        this.mCoreDownloader.prepare(vidAuth);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void prepare(com.aliyun.player.source.VidSts vidSts) {
        this.mCoreDownloader.prepare(vidSts);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void release() {
        this.mCoreDownloader.release();
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void selectItem(int i) {
        this.mCoreDownloader.selectItem(i);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setDownloaderConfig(com.aliyun.downloader.DownloaderConfig downloaderConfig) {
        this.mCoreDownloader.setDownloaderConfig(downloaderConfig);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setOnCompletionListener(com.aliyun.downloader.AliMediaDownloader.OnCompletionListener onCompletionListener) {
        this.mOuterCompletionListener = onCompletionListener;
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setOnErrorListener(com.aliyun.downloader.AliMediaDownloader.OnErrorListener onErrorListener) {
        this.mOuterOnErrorListener = onErrorListener;
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setOnPreparedListener(com.aliyun.downloader.AliMediaDownloader.OnPreparedListener onPreparedListener) {
        this.mOuterOnPreparedListener = onPreparedListener;
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setOnProgressListener(com.aliyun.downloader.AliMediaDownloader.OnProgressListener onProgressListener) {
        this.mOuterOnProgressListener = onProgressListener;
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void setSaveDir(java.lang.String str) {
        this.mCoreDownloader.setSaveDir(str);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void start() {
        this.mCoreDownloader.start();
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void stop() {
        this.mCoreDownloader.stop();
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void updateSource(com.aliyun.player.source.VidAuth vidAuth) {
        this.mCoreDownloader.updateSource(vidAuth);
    }

    @Override // com.aliyun.downloader.AliMediaDownloader
    public void updateSource(com.aliyun.player.source.VidSts vidSts) {
        this.mCoreDownloader.updateSource(vidSts);
    }
}
