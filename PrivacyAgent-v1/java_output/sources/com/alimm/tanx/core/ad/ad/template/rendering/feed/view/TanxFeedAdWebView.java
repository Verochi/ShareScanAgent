package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxFeedAdWebView extends com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView {
    private static final java.lang.String TAG = "TanxFeedAdNativeView";
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout tanxWebFrameLayout;

    public TanxFeedAdWebView(android.content.Context context) {
        this(context, null);
        this.tanxWebFrameLayout = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout(getContext());
    }

    public TanxFeedAdWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void loadAdContent(java.lang.String str) {
        this.flAdContentRoot.removeAllViews();
        this.flAdContentRoot.addView(this.tanxWebFrameLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
        this.tanxWebFrameLayout.loadAd(this.iTanxFeedAd, true, this);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null && this.iTanxFeedAd.getBidInfo().getTemplateConf() != null) {
            this.tanxWebFrameLayout.setViewSize(this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebWidth2Int());
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i), 1073741824), i2);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "onMeasure-> w:" + android.view.View.MeasureSpec.getSize(i) + " h:" + android.view.View.MeasureSpec.getSize(i2));
    }
}
