package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface PreloadListener {
    void onCached(java.lang.String str);

    void onError(java.lang.String str, java.lang.Exception exc);

    void onStartCached(com.alimm.tanx.core.ad.ITanxAd iTanxAd);
}
