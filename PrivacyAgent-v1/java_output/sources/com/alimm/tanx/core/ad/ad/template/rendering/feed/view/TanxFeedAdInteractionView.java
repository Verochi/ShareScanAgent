package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxFeedAdInteractionView extends com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView {
    private static final java.lang.String TAG = "TanxFeedAdInteractionView";
    private final java.lang.String ALL_SLIDE_DISTANCE_KEY;
    private final java.lang.String DIRECTION_SLIDE_DISTANCE_KEY;
    private final java.lang.String FEED_INTERACTION_GIF_URL;
    private final java.lang.String SLIDE_DIRECTION_KEY;
    private final int defaultAllSlideDistance;
    private final int defaultDirectionSlideDistance;
    private final int defaultSlideDirection;
    private final com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFrameLayout flGif;
    private final android.widget.ImageView ivGif;
    private float radio;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack
        public void onInteractionEnd(int i, int i2, int i3) {
            int i4;
            int i5;
            int i6;
            com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.iTanxFeedAd;
            if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf() == null) {
                i4 = 1;
                i5 = 55;
                i6 = 120;
            } else {
                i4 = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideType2Int();
                i5 = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideDistance2Int();
                i6 = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getAllSlideDistance2Int();
            }
            if (i4 == 2) {
                if (java.lang.Math.abs(i2) >= com.alimm.tanx.core.utils.DimenUtil.dp2px(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.getContext(), i5) || i3 >= com.alimm.tanx.core.utils.DimenUtil.dp2px(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.getContext(), i6)) {
                    com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView tanxFeedAdInteractionView = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this;
                    tanxFeedAdInteractionView.iTanxFeedAd.click(tanxFeedAdInteractionView);
                    return;
                }
                return;
            }
            if (java.lang.Math.abs(i) >= com.alimm.tanx.core.utils.DimenUtil.dp2px(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.getContext(), i5) || i3 >= com.alimm.tanx.core.utils.DimenUtil.dp2px(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this.getContext(), i6)) {
                com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView tanxFeedAdInteractionView2 = com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.this;
                tanxFeedAdInteractionView2.iTanxFeedAd.click(tanxFeedAdInteractionView2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack
        public void onInteractionStart() {
            com.alimm.tanx.core.utils.LogUtils.d("", "");
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.image.util.ImageConfig.GifCallback {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.TAG, str, "main");
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.TAG, str);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onSuccess() {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.TAG, "加载gif成功");
        }
    }

    public TanxFeedAdInteractionView(android.content.Context context) {
        this(context, null);
    }

    public TanxFeedAdInteractionView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DIRECTION_SLIDE_DISTANCE_KEY = "directionSlideDistance";
        this.ALL_SLIDE_DISTANCE_KEY = "allSlideDistance";
        this.SLIDE_DIRECTION_KEY = "slideDirection";
        this.FEED_INTERACTION_GIF_URL = "feedInteractionGifUrl";
        this.defaultDirectionSlideDistance = 55;
        this.defaultAllSlideDistance = 120;
        this.defaultSlideDirection = 1;
        this.radio = 0.56f;
        this.ivGif = (android.widget.ImageView) this.v.findViewById(com.alimm.tanx.core.R.id.iv_gif);
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFrameLayout tanxFrameLayout = (com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFrameLayout) this.v.findViewById(com.alimm.tanx.core.R.id.fl_gif);
        this.flGif = tanxFrameLayout;
        tanxFrameLayout.setVisibility(0);
    }

    private boolean isInterAction() {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "交互type不为3");
            return false;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "交互type为3,为信息流滑动");
        return this.iTanxFeedAd.getBidInfo().getInteractType2FeedSlide();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void loadAdContent(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, str);
        super.loadAdContent(str);
        if (!isInterAction() || com.alimm.tanx.core.image.ImageManager.getLoader() == null) {
            return;
        }
        com.alimm.tanx.core.image.ImageManager.getLoader().loadGif(new com.alimm.tanx.core.image.util.GifConfig(this.ivGif, com.alimm.tanx.core.orange.OrangeManager.getInstance().getFeedInteractionGifUrlParam("feedInteractionGifUrl")), new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.AnonymousClass2());
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            float templateHeight2Int = this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int();
            this.radio = templateHeight2Int;
            this.flGif.setViewSize(templateHeight2Int);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void renderAd() {
        super.renderAd();
        if (!isInterAction()) {
            this.flGif.setVisibility(8);
            return;
        }
        this.ivGif.setVisibility(0);
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView touchTraceView = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView(getContext(), null, new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.AnonymousClass1());
        touchTraceView.tanxc_do(this.radio);
        this.flAdContentRoot.addView(touchTraceView);
    }
}
