package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class BottomView extends android.widget.FrameLayout implements com.alimm.tanx.core.utils.NotConfused {
    private com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd;
    private android.widget.ImageView ivClose;
    private android.widget.LinearLayout llClose;
    private android.widget.RelativeLayout rlRoot;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for tipsPopUp;
    private android.widget.TextView tvAd;
    private android.widget.TextView tvAdName;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.BottomView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public BottomView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    public BottomView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.alimm.tanx.core.R.layout.layout_ad_bottom, (android.view.ViewGroup) this, true);
        if (this.iTanxFeedAd != null) {
            return;
        }
        this.rlRoot = (android.widget.RelativeLayout) inflate.findViewById(com.alimm.tanx.core.R.id.rl_root);
        this.tvAd = (android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_ad);
        this.tvAdName = (android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_ad_name);
        this.llClose = (android.widget.LinearLayout) inflate.findViewById(com.alimm.tanx.core.R.id.ll_close);
        this.ivClose = (android.widget.ImageView) inflate.findViewById(com.alimm.tanx.core.R.id.iv_close);
        initClick();
    }

    private void initClick() {
        this.llClose.setOnClickListener(new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.BottomView.AnonymousClass1());
    }

    private void initView() {
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo;
        com.alimm.tanx.core.ad.bean.CreativeItem creativeItem;
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd == null || (bidInfo = iTanxFeedAd.getBidInfo()) == null || (creativeItem = bidInfo.getCreativeItem()) == null || creativeItem.getAdvName() == null) {
            return;
        }
        this.tvAdName.setText(creativeItem.getAdvName());
    }

    public android.view.View getCloseView() {
        return this.llClose;
    }

    public com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd getiTanxFeedAd() {
        return this.iTanxFeedAd;
    }

    public void setTanxFeedAd(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
        this.iTanxFeedAd = iTanxFeedAd;
        initView();
    }

    public void setViewStyle(com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode) {
        this.rlRoot.setBackgroundColor(android.graphics.Color.parseColor(mediaRenderingMode.getBgColor()));
        this.tvAdName.setTextColor(android.graphics.Color.parseColor(mediaRenderingMode.getAdvColor()));
        this.tvAd.setTextColor(android.graphics.Color.parseColor(mediaRenderingMode.getAdColor()));
        if (com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().isCustomTextSizeDpSwitch()) {
            this.tvAdName.setTextSize(1, mediaRenderingMode.getAdvSize2Int());
            this.tvAd.setTextSize(1, mediaRenderingMode.getAdSize2Int());
        } else {
            this.tvAdName.setTextSize(0, com.alimm.tanx.core.utils.DimenUtil.dp2px(r0.getContext(), mediaRenderingMode.getAdvSize2Int()));
            this.tvAd.setTextSize(0, com.alimm.tanx.core.utils.DimenUtil.dp2px(r0.getContext(), mediaRenderingMode.getAdSize2Int()));
        }
    }
}
