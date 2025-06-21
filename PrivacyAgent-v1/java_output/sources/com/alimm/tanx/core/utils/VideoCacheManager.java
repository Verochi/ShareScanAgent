package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class VideoCacheManager implements com.alimm.tanx.core.utils.NotConfused {
    private static final int CACHED_WEB_VIEW_MAX_NUM = 10;
    static final java.lang.String TAG = "VideoCacheManager";
    private static com.alimm.tanx.core.utils.VideoCacheManager instance;
    private static boolean isOnlyWifiCache;
    public static java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ITanxAd> mCachedVideoMap = new com.alimm.tanx.core.utils.VideoCacheManager.AnonymousClass1(10);

    /* renamed from: com.alimm.tanx.core.utils.VideoCacheManager$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ITanxAd> {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ITanxAd> entry) {
            return com.alimm.tanx.core.utils.VideoCacheManager.mCachedVideoMap.size() > 10;
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.VideoCacheManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener {
        @Override // com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener
        public void onDisconnect() {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.VideoCacheManager.TAG, "onDisconnect");
        }

        @Override // com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener
        public void onMobileConnect() {
            if (com.alimm.tanx.core.utils.VideoCacheManager.isOnlyWifiCache) {
                com.alimm.tanx.core.view.player.cache.PreloadManager.getInstance(com.alimm.tanx.core.TanxCoreSdk.getApplication()).pauseAll();
            }
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.VideoCacheManager.TAG, "onMobileConnect");
        }

        @Override // com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener
        public void onWifiConnect() {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.VideoCacheManager.TAG, "onWifiConnect");
            com.alimm.tanx.core.view.player.cache.PreloadManager.getInstance(com.alimm.tanx.core.TanxCoreSdk.getApplication()).resumeAll();
        }
    }

    public static com.alimm.tanx.core.utils.VideoCacheManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.utils.VideoCacheManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.utils.VideoCacheManager();
                    com.alimm.tanx.core.utils.NetWorkUtil.registerReceiver(new com.alimm.tanx.core.utils.VideoCacheManager.AnonymousClass2());
                }
            }
        }
        return instance;
    }

    private void pushCache(java.lang.String str, com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        com.alimm.tanx.core.utils.LogUtils.d("video pushCache", new java.lang.String[0]);
        mCachedVideoMap.put(str, iTanxAd);
    }

    public void clearThis(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        if (iTanxAd == null || iTanxAd.getBidInfo() == null || iTanxAd.getBidInfo().getCreativeItem() == null || android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getCreativeItem().getVideo())) {
            return;
        }
        clearThis(iTanxAd.getBidInfo().getCreativeItem().getVideo());
    }

    public void clearThis(java.lang.String str) {
        try {
            java.util.Iterator<java.lang.String> it = mCachedVideoMap.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    it.remove();
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public com.alimm.tanx.core.ad.ITanxAd getVideoCacheSuccAd(java.lang.String str) {
        java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ITanxAd> linkedHashMap = mCachedVideoMap;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return mCachedVideoMap.get(str);
    }

    public void preload(com.alimm.tanx.core.ad.ITanxAd iTanxAd, boolean z, com.alimm.tanx.core.view.player.cache.videocache.PreloadListener preloadListener) {
        isOnlyWifiCache = z;
        if (iTanxAd == null || iTanxAd.getBidInfo() == null || iTanxAd.getBidInfo().getCreativeItem() == null || android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getCreativeItem().getVideo())) {
            return;
        }
        if (preloadListener != null) {
            preloadListener.onStartCached(iTanxAd);
        }
        pushCache(iTanxAd.getBidInfo().getCreativeItem().getVideo(), iTanxAd);
        com.alimm.tanx.core.view.player.cache.PreloadManager.getInstance(com.alimm.tanx.core.TanxCoreSdk.getApplication()).addPreloadTask(iTanxAd.getBidInfo().getCreativeItem().getVideo(), z, preloadListener);
        com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.getInstance(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getVideoSize(iTanxAd);
    }

    public void preload(java.util.List<com.alimm.tanx.core.ad.ITanxAd> list, boolean z, com.alimm.tanx.core.view.player.cache.videocache.PreloadListener preloadListener) {
        isOnlyWifiCache = z;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            preload(list.get(i), z, preloadListener);
        }
    }
}
