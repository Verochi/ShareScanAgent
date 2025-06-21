package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxFeedAdView extends com.alimm.tanx.core.ad.view.TanxAdView {
    private static final java.lang.String TAG = "TanxFeedAdView";
    private final com.alimm.tanx.core.ad.ad.template.rendering.feed.view.BottomView bottomView;
    protected android.widget.FrameLayout flAdContentRoot;
    protected com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd;
    com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxImageView ivAd;
    protected android.widget.ImageView ivAdLogo;
    private final android.widget.LinearLayout llRoot;
    protected com.alimm.tanx.core.ad.bean.MediaRenderingMode nowMediaRenderingMode;
    private final com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TitleTextView tvTitle;
    protected android.view.View v;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxFeedUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.iTanxFeedAd, 0);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.TAG, "loadImg:" + com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAd.getMeasuredWidth() + ":bm:" + bitmap.getWidth());
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAd.setImageBitmap(bitmap);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAd.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_do.getImageConfig()));
            com.alimm.tanx.core.ut.impl.TanxFeedUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.iTanxFeedAd, 1);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.iTanxFeedAd.onResourceLoadSuccess();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAdLogo.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAdLogo.setImageBitmap(bitmap);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAdLogo.setVisibility(0);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.ivAdLogo.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_do.getImageConfig()));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener tanxc_do;

        public AnonymousClass3(com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
            this.tanxc_do = onFeedAdListener;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface
        public void error(java.lang.String str) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = this.tanxc_do;
            if (onFeedAdListener != null) {
                onFeedAdListener.onAdClose(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.this.iTanxFeedAd);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for tanxc_do;

        public AnonymousClass4(com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for tanxc_forVar) {
            this.tanxc_do = tanxc_forVar;
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.tanxc_do.tanxc_for();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public TanxFeedAdView(android.content.Context context) {
        this(context, null);
    }

    public TanxFeedAdView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nowMediaRenderingMode = null;
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.alimm.tanx.core.R.layout.tanx_layout_ad_feed, (android.view.ViewGroup) this, true);
        this.v = inflate;
        this.tvTitle = (com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TitleTextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_title);
        this.llRoot = (android.widget.LinearLayout) this.v.findViewById(com.alimm.tanx.core.R.id.ll_root);
        this.bottomView = (com.alimm.tanx.core.ad.ad.template.rendering.feed.view.BottomView) this.v.findViewById(com.alimm.tanx.core.R.id.bottomView);
        this.ivAd = (com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxImageView) this.v.findViewById(com.alimm.tanx.core.R.id.iv_ad);
        this.ivAdLogo = (android.widget.ImageView) this.v.findViewById(com.alimm.tanx.core.R.id.iv_ad_logo);
        this.flAdContentRoot = (android.widget.FrameLayout) this.v.findViewById(com.alimm.tanx.core.R.id.fl_ad_content_root);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    public android.view.View getCloseView() {
        return this.bottomView.getCloseView();
    }

    public void loadAdContent(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, str + "\n");
        if (com.alimm.tanx.core.image.ImageManager.getLoader() != null) {
            com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.ivAd.getContext()).url(str).radius(this.nowMediaRenderingMode.getPicRadius2Int(this.ivAd.getContext())).shapeMode(com.alimm.tanx.core.image.util.ShapeMode.RECT_ROUND).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER).build();
            com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.AnonymousClass1(build));
        }
    }

    public void loadAdLogo(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "loadAdLogo:" + str);
        if (com.alimm.tanx.core.image.ImageManager.getLoader() != null) {
            com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.ivAdLogo.getContext()).url(str).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER).build();
            com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.AnonymousClass2(build));
        }
    }

    public void loadAdStyle() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, this.nowMediaRenderingMode.toString());
        if (com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().isCustomTextSizeDpSwitch()) {
            this.tvTitle.setTextSize(1, this.nowMediaRenderingMode.getTitleSize2Int());
        } else {
            this.tvTitle.setTextSize(0, com.alimm.tanx.core.utils.DimenUtil.dp2px(r0.getContext(), this.nowMediaRenderingMode.getTitleSize2Int()));
        }
        this.tvTitle.setBackgroundColor(android.graphics.Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.tvTitle.setTextColor(android.graphics.Color.parseColor(this.nowMediaRenderingMode.getTitleColor()));
        this.llRoot.setBackgroundColor(android.graphics.Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.bottomView.setViewStyle(this.nowMediaRenderingMode);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "onAttachedToWindow");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            this.ivAd.setViewSize(this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int());
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i), 1073741824), i2);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "onMeasure-> w:" + android.view.View.MeasureSpec.getSize(i) + " h:" + android.view.View.MeasureSpec.getSize(i2));
    }

    public void renderAd() {
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem;
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || (creativeItem = this.iTanxFeedAd.getBidInfo().getCreativeItem()) == null) {
            return;
        }
        loadAdContent(creativeItem.getImageUrl());
        loadAdLogo(creativeItem.getAdvLogo());
        this.tvTitle.setText(creativeItem.getTitle());
        loadAdStyle();
    }

    public void setTanxFeedAd(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.iTanxFeedAd = iTanxFeedAd;
        this.bottomView.setTanxFeedAd(iTanxFeedAd);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "setTanxFeedAd()");
        if (iTanxFeedAd.getBidInfo().getTemplateConf() != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "setTanxFeedAd()iTanxFeedAd.getBidInfo().getTemplateConf() != null");
            this.nowMediaRenderingMode = iTanxFeedAd.getBidInfo().getTemplateConf().getNowConfig(com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().isNightSwitch(), com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().isCustomTitleSizeSwitch(), com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().getCustomTitleSize());
        }
        if (this.nowMediaRenderingMode != null || onFeedAdListener == null) {
            renderAd();
        } else {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "日夜间模式对象nowConfig为空");
            onFeedAdListener.onError("日夜间模式对象nowConfig为空");
        }
    }

    public void showDislikeView(android.content.Context context, com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for tanxc_forVar = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for(context, this.nowMediaRenderingMode);
        tanxc_forVar.tanxc_do(getCloseView(), new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.AnonymousClass3(onFeedAdListener));
        this.iTanxFeedAd.bindDislikeView(tanxc_forVar.tanxc_do(), new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.AnonymousClass4(tanxc_forVar));
    }
}
