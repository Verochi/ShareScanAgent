package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd {
    private com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener tanxc_do;
    private com.alimm.tanx.core.ad.ad.feed.FeedVideoManager tanxc_for;
    private com.alimm.tanx.core.view.feed.tanxc_do tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener) {
            this.tanxc_do = iTanxFeedInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (this.tanxc_do != null) {
                if (com.alimm.tanx.core.ad.ad.feed.tanxc_do.this.getAdSlot() == null || com.alimm.tanx.core.ad.ad.feed.tanxc_do.this.getAdSlot().isFeedBackDialog()) {
                    this.tanxc_do.onAdDislike();
                } else {
                    this.tanxc_do.onAdClose();
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack = com.alimm.tanx.core.ad.ad.feed.tanxc_do.this.getBidInfo().getEventTrack();
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    interactionUpload.uploadInteraction(eventTrack, 3);
                    com.alimm.tanx.core.ut.impl.TanxFeedUt.utClose(com.alimm.tanx.core.ad.ad.feed.tanxc_do.this, 2);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.monitor.ITanxExposureCallback {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
            ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).isReadyExposure = true;
            com.alimm.tanx.core.ad.ad.feed.tanxc_do.this.doImpExposure();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(java.util.Map<java.lang.String, java.lang.Object> map) {
            com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendFeedMonitor(((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).adSlot, ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).reqId, ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).bidInfo.getTemplateId(), ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).bidInfo.getCreativeId(), map, ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.feed.tanxc_do.this).bidInfo.getSessionId());
        }
    }

    public tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
    }

    private void tanxc_do(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, android.view.View view, com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("adView:");
        java.lang.String str = com.igexin.push.core.b.m;
        sb.append(tanxAdView == null ? com.igexin.push.core.b.m : "不为空");
        sb.append("iTanxFeedInteractionListener:");
        if (iTanxFeedInteractionListener != null) {
            str = "不为空";
        }
        sb.append(str);
        com.alimm.tanx.core.utils.LogUtils.d("bindView", sb.toString());
        super.bindAdView(tanxAdView, list, iTanxFeedInteractionListener);
        this.tanxc_do = iTanxFeedInteractionListener;
        if (view != null) {
            view.setOnClickListener(new com.alimm.tanx.core.ad.ad.feed.tanxc_do.AnonymousClass1(iTanxFeedInteractionListener));
        }
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new com.alimm.tanx.core.ad.monitor.tanxc_if(tanxAdView, new com.alimm.tanx.core.ad.ad.feed.tanxc_do.AnonymousClass2()));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindDislikeView(java.util.List<android.view.View> list, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        if (list == null) {
            return;
        }
        java.util.Iterator<android.view.View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(new com.alimm.tanx.core.ad.ad.feed.TanxFeedAd$3(this, list, dislikeOnClickListener));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindFeedAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, android.view.View view, android.view.View view2, com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (view != null) {
            arrayList.add(view);
        }
        bindFeedAdView(tanxAdView, arrayList, view2, iTanxFeedInteractionListener);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindFeedAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, android.view.View view, com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, getAdSlot().isExpressRender() ? "bindTemplateFeedAdView" : "bindFeedAdView", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD, null);
        tanxc_do(tanxAdView, list, view, iTanxFeedInteractionListener);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void click(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView) {
        super.doClickExposure(tanxAdView);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        com.alimm.tanx.core.utils.LogUtils.d("TanxFeedAd", "媒体调用destroy（）");
        com.alimm.tanx.core.utils.PlayerListManager.getInstance().clearThis(this);
        super.destroy();
        com.alimm.tanx.core.ad.ad.feed.FeedVideoManager feedVideoManager = this.tanxc_for;
        if (feedVideoManager != null) {
            feedVideoManager.destroy();
        }
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public com.alimm.tanx.core.ut.AdUtConstants getAdClickUtKey() {
        return getBidInfo().getInteractType2FeedSlide() ? com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_INTERACTION_CLICK : com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_CLICK;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return super.getAdType();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public com.alimm.tanx.core.ad.ad.feed.ITanxVideoView getITanxVideoView(android.content.Context context) {
        if (this.tanxc_if == null) {
            this.tanxc_if = new com.alimm.tanx.core.view.feed.tanxc_do();
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager(this, this.tanxc_if, context);
            com.alimm.tanx.core.utils.PlayerListManager.getInstance().putFeedVideoManager(this, this.tanxc_for);
        }
        return this.tanxc_for;
    }
}
