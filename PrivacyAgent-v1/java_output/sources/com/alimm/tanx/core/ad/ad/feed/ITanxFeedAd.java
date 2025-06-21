package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public interface ITanxFeedAd extends com.alimm.tanx.core.ad.ITanxAd {

    public interface DislikeOnClickListener {
        void onClick(android.view.View view);
    }

    void bindDislikeView(java.util.List<android.view.View> list, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener);

    void bindFeedAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, android.view.View view, android.view.View view2, com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener);

    void bindFeedAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, android.view.View view, com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener);

    void click(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView);

    com.alimm.tanx.core.ad.ad.feed.ITanxVideoView getITanxVideoView(android.content.Context context);
}
