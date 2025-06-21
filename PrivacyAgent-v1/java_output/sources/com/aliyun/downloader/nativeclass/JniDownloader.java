package com.aliyun.downloader.nativeclass;

/* loaded from: classes.dex */
public class JniDownloader {
    static final java.lang.String TAG = "JniDownloader";
    private static com.aliyun.downloader.AliMediaDownloader.ConvertURLCallback sConvertURLCallback;
    private com.aliyun.downloader.nativeclass.JniDownloader.MainHandler mCurrentThreadHandler;
    private long mNativeContext;
    private com.aliyun.downloader.AliMediaDownloader.OnPreparedListener mOnPreparedListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnErrorListener mOnErrorListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnProgressListener mOnProgressListener = null;
    private com.aliyun.downloader.AliMediaDownloader.OnCompletionListener mOnCompletionListener = null;

    /* renamed from: com.aliyun.downloader.nativeclass.JniDownloader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.nativeclass.MediaInfo val$info;

        public AnonymousClass1(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            this.val$info = mediaInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.downloader.nativeclass.JniDownloader.this.mOnPreparedListener != null) {
                com.aliyun.downloader.nativeclass.JniDownloader.this.mOnPreparedListener.onPrepared(this.val$info);
            }
        }
    }

    /* renamed from: com.aliyun.downloader.nativeclass.JniDownloader$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$extra;
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ java.lang.String val$msg;

        public AnonymousClass2(com.aliyun.player.bean.ErrorCode errorCode, java.lang.String str, java.lang.String str2) {
            this.val$finalErrorCode = errorCode;
            this.val$msg = str;
            this.val$extra = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.downloader.nativeclass.JniDownloader.this.mOnErrorListener != null) {
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$msg);
                errorInfo.setExtra(this.val$extra);
                com.aliyun.downloader.nativeclass.JniDownloader.this.mOnErrorListener.onError(errorInfo);
            }
        }
    }

    /* renamed from: com.aliyun.downloader.nativeclass.JniDownloader$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int val$percent;
        final /* synthetic */ int val$type;

        public AnonymousClass3(int i, int i2) {
            this.val$type = i;
            this.val$percent = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.downloader.nativeclass.JniDownloader.this.mOnProgressListener != null) {
                if (this.val$type == 0) {
                    com.aliyun.downloader.nativeclass.JniDownloader.this.mOnProgressListener.onDownloadingProgress(this.val$percent);
                } else {
                    com.aliyun.downloader.nativeclass.JniDownloader.this.mOnProgressListener.onProcessingProgress(this.val$percent);
                }
            }
        }
    }

    /* renamed from: com.aliyun.downloader.nativeclass.JniDownloader$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.downloader.nativeclass.JniDownloader.this.mOnCompletionListener != null) {
                com.aliyun.downloader.nativeclass.JniDownloader.this.mOnCompletionListener.onCompletion();
            }
        }
    }

    public static class MainHandler extends android.os.Handler {
        private java.lang.ref.WeakReference<com.aliyun.downloader.nativeclass.JniDownloader> downloaderWeakReference;

        public MainHandler(com.aliyun.downloader.nativeclass.JniDownloader jniDownloader, android.os.Looper looper) {
            super(looper);
            this.downloaderWeakReference = new java.lang.ref.WeakReference<>(jniDownloader);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.aliyun.downloader.nativeclass.JniDownloader jniDownloader = this.downloaderWeakReference.get();
            if (jniDownloader != null) {
                jniDownloader.handleMessage(message);
            }
            super.handleMessage(message);
        }
    }

    static {
        com.aliyun.utils.f.f();
        com.aliyun.utils.f.e();
        sConvertURLCallback = null;
    }

    public JniDownloader(android.content.Context context) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        } else if (!com.aliyun.utils.f.a()) {
            com.aliyun.utils.f.e();
        } else {
            this.mCurrentThreadHandler = new com.aliyun.downloader.nativeclass.JniDownloader.MainHandler(this, android.os.Looper.getMainLooper());
            nConstruct();
        }
    }

    public static int deleteFile(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            return sDeleteFile(str, str2, str3, i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(android.os.Message message) {
    }

    public static java.lang.String nConvertURLCallback(java.lang.String str, java.lang.String str2) {
        com.aliyun.downloader.AliMediaDownloader.ConvertURLCallback convertURLCallback = sConvertURLCallback;
        if (convertURLCallback != null) {
            return convertURLCallback.convertURL(str, str2);
        }
        return null;
    }

    private void onCompletion() {
        com.cicada.player.utils.Logger.v(TAG, "onCompletion() ");
        this.mCurrentThreadHandler.post(new com.aliyun.downloader.nativeclass.JniDownloader.AnonymousClass4());
    }

    private void onError(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.cicada.player.utils.Logger.v(TAG, "onError() .. code = " + i + " , msg = " + str + " , extra = " + str2 + " , requestid = " + str3);
        com.aliyun.player.bean.ErrorCode errorCode = com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN;
        com.aliyun.player.bean.ErrorCode[] values = com.aliyun.player.bean.ErrorCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            com.aliyun.player.bean.ErrorCode errorCode2 = values[i2];
            if (errorCode2.getValue() == i) {
                errorCode = errorCode2;
                break;
            }
            i2++;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.downloader.nativeclass.JniDownloader.AnonymousClass2(errorCode, str, str2));
    }

    private void onPrepared(java.lang.Object obj) {
        com.cicada.player.utils.Logger.v(TAG, "onPrepared(mediaInfo) = " + obj);
        if (obj == null) {
            return;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.downloader.nativeclass.JniDownloader.AnonymousClass1((com.aliyun.player.nativeclass.MediaInfo) obj));
    }

    private void onProgress(int i, int i2) {
        com.cicada.player.utils.Logger.v(TAG, "onProgress() .. type = " + i + ", percent = " + i2 + "%");
        this.mCurrentThreadHandler.post(new com.aliyun.downloader.nativeclass.JniDownloader.AnonymousClass3(i, i2));
    }

    public static native int sDeleteFile(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    public static void setConvertURLCallback(com.aliyun.downloader.AliMediaDownloader.ConvertURLCallback convertURLCallback) {
        sConvertURLCallback = convertURLCallback;
    }

    public void deleteFile() {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "deleteFile()");
            nDeleteFile();
        }
    }

    public java.lang.String getFilePath() {
        if (!com.aliyun.utils.f.b() || !com.aliyun.utils.f.a()) {
            return "";
        }
        java.lang.String nGetFilePath = nGetFilePath();
        com.cicada.player.utils.Logger.v(TAG, "getFilePath() , return = " + nGetFilePath);
        return nGetFilePath;
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }

    public native void nConstruct();

    public native void nDeleteFile();

    public native java.lang.String nGetFilePath();

    public native void nPrepare(com.aliyun.player.source.VidAuth vidAuth);

    public native void nPrepare(com.aliyun.player.source.VidSts vidSts);

    public native void nRelease();

    public native void nSelectItem(int i);

    public native void nSetConnectivityManager(java.lang.Object obj);

    public native void nSetDownloaderConfig(java.lang.Object obj);

    public native void nSetSaveDir(java.lang.String str);

    public native void nStart();

    public native void nStop();

    public native void nUpdateSource(com.aliyun.player.source.VidAuth vidAuth);

    public native void nUpdateSource(com.aliyun.player.source.VidSts vidSts);

    public void prepare(com.aliyun.player.source.VidAuth vidAuth) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "prepare(vidAuth) vid :" + vidAuth.getVid());
            nPrepare(vidAuth);
        }
    }

    public void prepare(com.aliyun.player.source.VidSts vidSts) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "prepare(vidSts) vid :" + vidSts.getVid());
            nPrepare(vidSts);
        }
    }

    public void release() {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "release()");
            nRelease();
        }
    }

    public void selectItem(int i) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "selectItem(index) index :" + i);
            nSelectItem(i);
        }
    }

    public void setDownloaderConfig(com.aliyun.downloader.DownloaderConfig downloaderConfig) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "setDownloaderConfig() ");
            nSetDownloaderConfig(downloaderConfig);
        }
    }

    public void setNativeContext(long j) {
        com.cicada.player.utils.Logger.d(TAG, "setNativeContext " + j);
        this.mNativeContext = j;
    }

    public void setOnCompletionListener(com.aliyun.downloader.AliMediaDownloader.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(com.aliyun.downloader.AliMediaDownloader.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnPreparedListener(com.aliyun.downloader.AliMediaDownloader.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnProgressListener(com.aliyun.downloader.AliMediaDownloader.OnProgressListener onProgressListener) {
        this.mOnProgressListener = onProgressListener;
    }

    public void setSaveDir(java.lang.String str) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "setSaveDir() :" + str);
            nSetSaveDir(str);
        }
    }

    public void start() {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "start()");
            nStart();
        }
    }

    public void stop() {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "stop()");
            nStop();
        }
    }

    public void updateSource(com.aliyun.player.source.VidAuth vidAuth) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "updateSource(vidAuth) vid :" + vidAuth.getVid());
            nUpdateSource(vidAuth);
        }
    }

    public void updateSource(com.aliyun.player.source.VidSts vidSts) {
        if (com.aliyun.utils.f.b() && com.aliyun.utils.f.a()) {
            com.cicada.player.utils.Logger.v(TAG, "updateSource(vidsts) vid :" + vidSts.getVid());
            nUpdateSource(vidSts);
        }
    }
}
