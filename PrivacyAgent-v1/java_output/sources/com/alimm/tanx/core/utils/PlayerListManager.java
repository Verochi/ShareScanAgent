package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class PlayerListManager implements com.alimm.tanx.core.utils.NotConfused {
    private static final int PLAYER_MAX_NUM = 20;
    static final java.lang.String TAG = "PlayerListManager";
    private static com.alimm.tanx.core.utils.PlayerListManager instance;
    public static java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> mPlayerMap = new com.alimm.tanx.core.utils.PlayerListManager.AnonymousClass1(20);

    /* renamed from: com.alimm.tanx.core.utils.PlayerListManager$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> entry) {
            boolean z = com.alimm.tanx.core.utils.PlayerListManager.mPlayerMap.size() > 20;
            if (z) {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.PlayerListManager.TAG, "FeedVideoManager 缓存超出20个，回收:" + entry.getKey());
                com.alimm.tanx.core.utils.PlayerListManager.destroy(entry);
            }
            return z;
        }
    }

    private void clearThis(java.lang.String str) {
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> next = it.next();
                if (next.getKey().equals(str)) {
                    destroy(next);
                    it.remove();
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroy(java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> entry) {
        if (entry == null || entry.getValue() == null) {
            return;
        }
        entry.getValue().destroy();
    }

    public static com.alimm.tanx.core.utils.PlayerListManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.utils.PlayerListManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.utils.PlayerListManager();
                }
            }
        }
        return instance;
    }

    private boolean isITanxAdNull(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        return iTanxAd == null || iTanxAd.getBidInfo() == null || android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getSessionId());
    }

    private static void pause(java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> entry) {
        if (entry == null || entry.getValue() == null) {
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "暂停sessionId：" + entry.getValue().getSessionId());
        entry.getValue().pause();
    }

    public void clearAll() {
        try {
            java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> linkedHashMap = mPlayerMap;
            if (linkedHashMap == null || linkedHashMap.size() <= 0) {
                return;
            }
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            if (it.hasNext()) {
                destroy(it.next());
                it.remove();
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public void clearOtherPlayer(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        try {
            if (isITanxAdNull(iTanxAd)) {
                return;
            }
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> next = it.next();
                if (!next.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                    destroy(next);
                    it.remove();
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public void clearThis(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        if (isITanxAdNull(iTanxAd)) {
            com.alimm.tanx.core.utils.LogUtils.d("clearThis error  iTanxAd  == null", new java.lang.String[0]);
        } else {
            clearThis(iTanxAd.getBidInfo().getSessionId());
        }
    }

    public com.alimm.tanx.core.ad.ad.feed.FeedVideoManager getFeedVideoManager4SessionId(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> linkedHashMap;
        if (isITanxAdNull(iTanxAd) || (linkedHashMap = mPlayerMap) == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return mPlayerMap.get(iTanxAd.getBidInfo().getSessionId());
    }

    public void putFeedVideoManager(com.alimm.tanx.core.ad.ITanxAd iTanxAd, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager feedVideoManager) {
        if (isITanxAdNull(iTanxAd)) {
            com.alimm.tanx.core.utils.LogUtils.d("putFeedVideoManager error iTanxAd == null", new java.lang.String[0]);
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d("putFeedVideoManager push sessionId:" + iTanxAd.getBidInfo().getSessionId(), new java.lang.String[0]);
        mPlayerMap.put(iTanxAd.getBidInfo().getSessionId(), feedVideoManager);
    }

    public void stopOtherPlayer(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        try {
            if (isITanxAdNull(iTanxAd)) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.feed.FeedVideoManager> entry : mPlayerMap.entrySet()) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "stopOtherPlayer: 循环：" + entry.getKey() + " 当前广告id：" + iTanxAd.getBidInfo().getSessionId());
                if (!entry.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                    pause(entry);
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }
}
