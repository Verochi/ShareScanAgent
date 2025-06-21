package com.alimm.tanx.core.ad.ad.template.rendering.feed;

/* loaded from: classes.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd> implements com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd, com.alimm.tanx.core.view.feed.ITanxFeedCacheContext {
    com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener tanxc_do;
    com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_for tanxc_if;
    private final android.content.Context tanxc_int;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxc_new;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener {
        final /* synthetic */ android.app.Activity tanxc_do;

        public AnonymousClass1(android.app.Activity activity) {
            this.tanxc_do = activity;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
            tanxc_do(iTanxFeedAd);
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
        public void onAdClose() {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if tanxc_ifVar = com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.this;
            com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_ifVar.tanxc_do;
            if (onFeedAdListener != null) {
                onFeedAdListener.onAdClose(((com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if) tanxc_ifVar).tanxc_for);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
        public void onAdDislike() {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.this.tanxc_new.showDislikeView(this.tanxc_do, com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.this.tanxc_do);
        }

        public void tanxc_do(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.this.tanxc_do;
            if (onFeedAdListener != null) {
                onFeedAdListener.onClick(iTanxFeedAd);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
        public void onAdShow(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.this.tanxc_do;
            if (onFeedAdListener != null) {
                onFeedAdListener.onAdShow(iTanxFeedAd);
            }
        }
    }

    public tanxc_if(android.content.Context context, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_for tanxc_forVar) {
        super(iTanxFeedAd);
        this.tanxc_int = context;
        this.tanxc_if = tanxc_forVar;
    }

    private boolean tanxc_for() {
        T t = this.tanxc_for;
        if (t == 0 || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) t).getBidInfo() == null || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || android.text.TextUtils.isEmpty(((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId())) {
            return false;
        }
        return com.alimm.tanx.core.constant.AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID.equals(((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId());
    }

    private boolean tanxc_if() {
        T t = this.tanxc_for;
        if (t == 0 || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) t).getBidInfo() == null) {
            return false;
        }
        return ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getInteractType2FeedSlide();
    }

    private boolean tanxc_int() {
        T t = this.tanxc_for;
        return (t == 0 || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) t).getBidInfo() == null || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getWebType2Int() != 2) ? false : true;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        com.alimm.tanx.core.utils.LogUtils.d("TanxFeedExpressAd", "媒体调用destroy（）");
        super.destroy();
        this.tanxc_do = null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return com.alimm.tanx.core.constant.TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        if (tanxFeedAdView != null) {
            tanxFeedAdView.loadAdStyle();
        }
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public android.view.View remove() {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        this.tanxc_new = null;
        return tanxFeedAdView;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd
    public void setOnFeedAdListener(com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.tanxc_do = onFeedAdListener;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView() {
        return getAdView((android.app.Activity) this.tanxc_int);
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.core.ad.view.TanxAdView getAdView(android.app.Activity activity) {
        if (tanxc_for() && tanxc_int()) {
            this.tanxc_new = this.tanxc_if.tanxc_for(this, activity);
        } else if (tanxc_if()) {
            this.tanxc_new = this.tanxc_if.tanxc_if(this, activity);
        } else {
            this.tanxc_new = this.tanxc_if.tanxc_do(this, activity);
        }
        this.tanxc_new.setTanxFeedAd((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for, this.tanxc_do);
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = (com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) this.tanxc_for;
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        iTanxFeedAd.bindFeedAdView(tanxFeedAdView, tanxFeedAdView, tanxFeedAdView.getCloseView(), new com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.AnonymousClass1(activity));
        return this.tanxc_new;
    }
}
