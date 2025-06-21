package com.alimm.tanx.core.view.player.cache;

/* loaded from: classes.dex */
public class PreloadManager {
    public static final int PRELOAD_LENGTH = 1048576;
    private static final java.lang.String TAG = "PreloadManager";
    private static com.alimm.tanx.core.view.player.cache.PreloadManager sPreloadManager;
    private com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer mHttpProxyCacheServer;
    private final java.util.concurrent.ExecutorService mExecutorService = java.util.concurrent.Executors.newSingleThreadExecutor();
    private final java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask> mPreloadTasks = new java.util.LinkedHashMap<>();
    private boolean mIsStartPreload = true;

    private PreloadManager(android.content.Context context) {
        try {
            this.mHttpProxyCacheServer = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getProxy(context);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    public static com.alimm.tanx.core.view.player.cache.PreloadManager getInstance(android.content.Context context) {
        if (sPreloadManager == null) {
            synchronized (com.alimm.tanx.core.view.player.cache.PreloadManager.class) {
                if (sPreloadManager == null) {
                    sPreloadManager = new com.alimm.tanx.core.view.player.cache.PreloadManager(context.getApplicationContext());
                }
            }
        }
        return sPreloadManager;
    }

    public void addPreloadTask(java.lang.String str, int i, int i2, boolean z, com.alimm.tanx.core.view.player.cache.videocache.PreloadListener preloadListener) {
        if (this.mHttpProxyCacheServer == null) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "addPreloadTask-mHttpProxyCacheServer为空");
            return;
        }
        if (isPreloaded(str)) {
            if (preloadListener != null) {
                preloadListener.onCached(str);
                return;
            }
            return;
        }
        com.alimm.tanx.core.view.player.cache.PreloadTask preloadTask = new com.alimm.tanx.core.view.player.cache.PreloadTask();
        preloadTask.mRawUrl = str;
        preloadTask.mPosition = i;
        preloadTask.mPreloadLimit = i2;
        preloadTask.mPreloadListener = preloadListener;
        preloadTask.mCacheServer = this.mHttpProxyCacheServer;
        com.alimm.tanx.core.utils.LogUtils.i(TAG, "addPreloadTask: " + i);
        this.mPreloadTasks.put(str, preloadTask);
        if (this.mIsStartPreload) {
            if (!z) {
                preloadTask.executeOn(this.mExecutorService);
            } else if (com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getKey() == 1) {
                preloadTask.executeOn(this.mExecutorService);
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "task.executeOn");
        }
    }

    public void addPreloadTask(java.lang.String str, boolean z, com.alimm.tanx.core.view.player.cache.videocache.PreloadListener preloadListener) {
        addPreloadTask(str, 0, -1, z, preloadListener);
    }

    public void continuePreLoad(int i, boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "resumePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = true;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.view.player.cache.PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition < i && !isPreloaded(value.mRawUrl)) {
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i && !isPreloaded(value.mRawUrl)) {
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public boolean deleteCacheFile(java.lang.String str) {
        try {
            java.io.File cacheFile = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getCacheFile(str);
            if (!cacheFile.exists()) {
                return true;
            }
            cacheFile.delete();
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public java.lang.String getPlayUrl(java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
        }
        if (isPreloaded(str)) {
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer httpProxyCacheServer = this.mHttpProxyCacheServer;
            if (httpProxyCacheServer != null) {
                return httpProxyCacheServer.getProxyUrl(str);
            }
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "getPlayUrl mHttpProxyCacheServer为空");
        }
        return str;
    }

    public boolean isPreloaded(java.lang.String str) {
        java.io.File cacheFile = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getCacheFile(str);
        if (!cacheFile.exists()) {
            java.io.File tempCacheFile = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getTempCacheFile(str);
            return tempCacheFile.exists() && tempCacheFile.length() >= 1048576;
        }
        if (cacheFile.length() >= 1024) {
            return true;
        }
        cacheFile.delete();
        return false;
    }

    public void pauseAll() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "pauseAll");
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.view.player.cache.PreloadTask value = it.next().getValue();
            if (!isPreloaded(value.mRawUrl)) {
                value.cancel();
            }
        }
    }

    public void pausePreload(int i, boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "pausePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = false;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.view.player.cache.PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition >= i) {
                    value.cancel();
                }
            } else if (value.mPosition <= i) {
                value.cancel();
            }
        }
    }

    public void removeAllPreloadTask() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
            it.remove();
        }
    }

    public void removePreloadTask(java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
            this.mPreloadTasks.remove(str);
        }
    }

    public void resumeAll() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "resumeAll");
        this.mIsStartPreload = true;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.view.player.cache.PreloadTask value = it.next().getValue();
            isPreloaded(value.mRawUrl);
            value.executeOn(this.mExecutorService);
        }
    }

    public void resumePreload(int i, boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "resumePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = true;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.view.player.cache.PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition < i) {
                    isPreloaded(value.mRawUrl);
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i) {
                isPreloaded(value.mRawUrl);
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public void stopAllPreloadTask() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.view.player.cache.PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
    }
}
