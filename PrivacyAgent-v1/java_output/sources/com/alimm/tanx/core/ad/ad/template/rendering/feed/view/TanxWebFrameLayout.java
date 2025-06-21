package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxWebFrameLayout extends android.widget.FrameLayout implements com.alimm.tanx.core.utils.NotConfused {
    private final java.lang.String TAG;
    protected android.webkit.WebView addView;
    protected android.widget.Button btnReLoadH5;
    private boolean errorCreateViewUtUpload;
    protected com.alimm.tanx.core.ad.ITanxAd iTanxFeedAd;
    private volatile boolean isH5Ut;
    private boolean isShowWebStatusUi;
    private boolean isTemplateRender;
    protected android.widget.ImageView ivLoading;
    protected android.widget.LinearLayout llWeb;
    protected android.widget.LinearLayout llWebError;
    protected android.widget.LinearLayout llWebLoading;
    protected com.alimm.tanx.core.ad.view.TanxAdView parentTanxAdView;
    float radio;
    protected android.widget.RelativeLayout rlRoot;
    protected android.view.View v;
    protected com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil webViewUtil;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.core.ad.listener.ViewClickListener {
        final /* synthetic */ boolean val$clickable;

        public AnonymousClass1(boolean z) {
            this.val$clickable = z;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(android.view.View view) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.showErrorUi(false);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.loadWeb(this.val$clickable);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.FeedWebInterface {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.showErrorUi(false);
            com.alimm.tanx.core.ut.impl.TanxFeedUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.iTanxFeedAd, 1);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.iTanxFeedAd.onResourceLoadSuccess();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z) {
            if (z) {
                com.alimm.tanx.core.utils.LogUtils.d("utLog", "utViewDraw");
            } else {
                if (!com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.isH5Ut) {
                    com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.iTanxFeedAd, com.alimm.tanx.core.ut.UtErrorCode.CRASH_H5_ERROR);
                    com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.isH5Ut = true;
                }
                com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.showErrorUi(true);
            }
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.loading(false);
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.e("TanxWebFrameLayout", "webError: cmd :" + i + " msg:" + str);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.this.showErrorUi(true);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.image.util.ImageConfig.GifCallback {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onFailure(java.lang.String str) {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onSuccess() {
        }
    }

    public TanxWebFrameLayout(android.content.Context context) {
        this(context, null);
    }

    public TanxWebFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TanxWebFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TanxWebFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "TanxWebFrameLayout";
        this.isH5Ut = false;
        this.errorCreateViewUtUpload = false;
        this.isShowWebStatusUi = true;
        this.isTemplateRender = true;
        this.radio = 0.56f;
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.alimm.tanx.core.R.layout.tanx_layout_ad_feed_item_web, (android.view.ViewGroup) this, true);
        this.v = inflate;
        this.rlRoot = (android.widget.RelativeLayout) inflate.findViewById(com.alimm.tanx.core.R.id.rl_root);
        this.llWeb = (android.widget.LinearLayout) this.v.findViewById(com.alimm.tanx.core.R.id.ll_web);
        this.llWebError = (android.widget.LinearLayout) this.v.findViewById(com.alimm.tanx.core.R.id.ll_web_error);
        this.llWebLoading = (android.widget.LinearLayout) this.v.findViewById(com.alimm.tanx.core.R.id.ll_web_loading);
        this.ivLoading = (android.widget.ImageView) this.v.findViewById(com.alimm.tanx.core.R.id.iv_loading);
        this.btnReLoadH5 = (android.widget.Button) this.v.findViewById(com.alimm.tanx.core.R.id.btn_re_load_h5);
    }

    private void errorCreateViewUt() {
        if (this.errorCreateViewUtUpload) {
            return;
        }
        this.errorCreateViewUtUpload = true;
        com.alimm.tanx.core.ut.impl.TanxFeedUt.utViewDraw(this.iTanxFeedAd, 0);
    }

    private void initClick(boolean z) {
        this.btnReLoadH5.setOnClickListener(new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.AnonymousClass1(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loading$1(boolean z) {
        if (this.isShowWebStatusUi) {
            if (!z) {
                this.llWebLoading.setVisibility(8);
                return;
            }
            com.alimm.tanx.core.TanxCoreSdk.getConfig().getImageLoader().loadGif(new com.alimm.tanx.core.image.util.GifConfig(this.ivLoading, com.alimm.tanx.core.R.drawable.tanx_loading), new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.AnonymousClass3());
            this.llWebLoading.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorUi$0(boolean z) {
        if (!z) {
            this.llWebError.setVisibility(8);
            return;
        }
        if (this.isShowWebStatusUi) {
            this.llWebError.setVisibility(0);
        } else {
            setVisibility(8);
        }
        errorCreateViewUt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWeb(boolean z) {
        loading(true);
        com.alimm.tanx.core.ut.impl.TanxCommonUt.utWebStartLoad(this.iTanxFeedAd);
        com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil feedWebViewUtil = new com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil();
        this.webViewUtil = feedWebViewUtil;
        feedWebViewUtil.tanxc_do(this.llWeb, z, this.iTanxFeedAd, this.parentTanxAdView, new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loading(boolean z) {
        this.llWebLoading.post(new defpackage.j03(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorUi(boolean z) {
        this.llWebError.post(new defpackage.i03(this, z));
    }

    public void loadAd(com.alimm.tanx.core.ad.ITanxAd iTanxAd, boolean z, com.alimm.tanx.core.ad.view.TanxAdView tanxAdView) {
        this.iTanxFeedAd = iTanxAd;
        this.parentTanxAdView = tanxAdView;
        this.errorCreateViewUtUpload = false;
        loadWeb(z);
        initClick(z);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.isTemplateRender) {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int) (android.view.View.MeasureSpec.getSize(i) * this.radio), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setShowWebStatusUi(boolean z) {
        this.isShowWebStatusUi = z;
    }

    public void setTemplateRender(boolean z) {
        this.isTemplateRender = z;
    }

    public void setViewSize(float f) {
        this.radio = f;
    }
}
