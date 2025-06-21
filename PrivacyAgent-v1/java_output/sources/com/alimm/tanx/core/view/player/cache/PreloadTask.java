package com.alimm.tanx.core.view.player.cache;

/* loaded from: classes.dex */
public class PreloadTask implements java.lang.Runnable {
    private static final java.lang.String TAG = "PreloadTask";
    private android.os.Handler handler;
    public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer mCacheServer;
    private boolean mIsCanceled;
    private boolean mIsExecuted;
    public int mPosition;
    public int mPreloadLimit = -1;
    public com.alimm.tanx.core.view.player.cache.videocache.PreloadListener mPreloadListener;
    public java.lang.String mRawUrl;

    /* renamed from: com.alimm.tanx.core.view.player.cache.PreloadTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Exception val$e;

        public AnonymousClass1(java.lang.Exception exc) {
            this.val$e = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Exception exc = this.val$e;
            if (exc != null) {
                com.alimm.tanx.core.view.player.cache.PreloadTask preloadTask = com.alimm.tanx.core.view.player.cache.PreloadTask.this;
                preloadTask.mPreloadListener.onError(preloadTask.mRawUrl, exc);
            } else {
                com.alimm.tanx.core.view.player.cache.PreloadTask preloadTask2 = com.alimm.tanx.core.view.player.cache.PreloadTask.this;
                preloadTask2.mPreloadListener.onCached(preloadTask2.mRawUrl);
            }
        }
    }

    private void onComplete(java.lang.Exception exc) {
        if (this.mPreloadListener != null) {
            if (this.handler == null) {
                this.handler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            this.handler.post(new com.alimm.tanx.core.view.player.cache.PreloadTask.AnonymousClass1(exc));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        com.alimm.tanx.core.utils.LogUtils.i(com.alimm.tanx.core.view.player.cache.PreloadTask.TAG, "结束预加载：" + r9.mPosition);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void start() {
        java.lang.Throwable th;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.Exception e;
        int i;
        com.alimm.tanx.core.utils.LogUtils.i(TAG, "开始预加载：" + this.mPosition);
        java.net.HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                java.lang.String proxyUrl = this.mCacheServer.getProxyUrl(this.mRawUrl);
                com.alimm.tanx.core.utils.LogUtils.e("预加载的路径：", proxyUrl);
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(proxyUrl).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
                    byte[] bArr = new byte[8192];
                    int i2 = -1;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i2 += read;
                        if (this.mIsCanceled || ((i = this.mPreloadLimit) != -1 && i2 >= i)) {
                            break;
                        }
                    }
                    if (i2 == -1) {
                        com.alimm.tanx.core.utils.LogUtils.i(TAG, "预加载失败：" + this.mPosition);
                        java.io.File cacheFile = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getCacheFile(this.mRawUrl);
                        if (cacheFile.exists()) {
                            cacheFile.delete();
                        }
                        onComplete(new java.lang.Exception("预加载失败"));
                    } else {
                        onComplete(null);
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    onComplete(e);
                    com.alimm.tanx.core.utils.LogUtils.i(TAG, "异常结束预加载：" + this.mPosition + "|" + e.getMessage() + "\n" + this.mCacheServer.getProxyUrl(this.mRawUrl));
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (0 != 0) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            httpURLConnection = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    public void cancel() {
        if (this.mIsExecuted) {
            this.mIsCanceled = true;
        }
        android.os.Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void executeOn(java.util.concurrent.ExecutorService executorService) {
        if (this.mIsExecuted) {
            return;
        }
        this.mIsExecuted = true;
        executorService.submit(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alimm.tanx.core.utils.LogUtils.i(TAG, "mIsCanceled：" + this.mIsCanceled);
        if (!this.mIsCanceled) {
            start();
        }
        this.mIsExecuted = false;
        this.mIsCanceled = false;
    }
}
