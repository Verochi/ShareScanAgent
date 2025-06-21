package com.alimm.tanx.core.view.player.cache;

/* loaded from: classes.dex */
public class VideoGetSizeManager {
    private static final int CACHED_VIDEO_SIZE_MAX_NUM = 50;
    private static final java.lang.String TAG = "VideoGetSizeManager";
    public static java.util.LinkedHashMap<java.lang.String, java.lang.Long> mCachedVideoSizeMap = new com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.AnonymousClass1(50);
    private static com.alimm.tanx.core.view.player.cache.VideoGetSizeManager sPreloadManager;
    long tempSize = 50;

    /* renamed from: com.alimm.tanx.core.view.player.cache.VideoGetSizeManager$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.LinkedHashMap<java.lang.String, java.lang.Long> {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, java.lang.Long> entry) {
            return com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.mCachedVideoSizeMap.size() > 50;
        }
    }

    private VideoGetSizeManager(android.content.Context context) {
    }

    public static com.alimm.tanx.core.view.player.cache.VideoGetSizeManager getInstance(android.content.Context context) {
        if (sPreloadManager == null) {
            synchronized (com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.class) {
                if (sPreloadManager == null) {
                    sPreloadManager = new com.alimm.tanx.core.view.player.cache.VideoGetSizeManager(context.getApplicationContext());
                }
            }
        }
        return sPreloadManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideoSize$14(java.lang.String str, com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity");
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength > 0) {
                mCachedVideoSizeMap.put(str, java.lang.Long.valueOf(contentLength));
                if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getThreshold(com.alimm.tanx.core.orange.OrangeManager.FEED_VIDEO_MAX_SIZE) > -1) {
                    this.tempSize = com.alimm.tanx.core.orange.OrangeManager.getInstance().getThreshold(com.alimm.tanx.core.orange.OrangeManager.FEED_VIDEO_MAX_SIZE) * 1024 * 1024;
                }
                com.alimm.tanx.core.ut.impl.TanxCommonUt.fileSizeCheck(iTanxAd, contentLength, contentLength > this.tempSize ? 1 : 0, java.lang.System.currentTimeMillis() - currentTimeMillis);
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "视频:" + str + " 长度：" + httpURLConnection.getContentLength() + " 时间：" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    public void getVideoSize(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "getVideoSize");
        java.lang.String video = iTanxAd.getBidInfo().getCreativeItem().getVideo();
        if (isPreloaded(video)) {
            return;
        }
        com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool.post(new defpackage.r93(this, video, iTanxAd));
    }

    public boolean isPreloaded(java.lang.String str) {
        return mCachedVideoSizeMap.get(str) != null;
    }
}
