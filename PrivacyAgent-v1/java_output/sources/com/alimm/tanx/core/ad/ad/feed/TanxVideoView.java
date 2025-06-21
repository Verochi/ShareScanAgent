package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public class TanxVideoView extends com.alimm.tanx.core.view.player.ui.TanxPlayerView {
    private static final java.lang.String TAG = "TanxVideoView";
    private com.alimm.tanx.core.ad.ITanxAd iTanxAd;
    private com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    private volatile boolean isLoadWeb;
    private android.widget.ImageView ivDefaultPlayer;
    private android.view.View ivPlayer;
    private android.view.View.OnClickListener onClickListener;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout tanxWebFrameLayout;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.TanxVideoView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivDefaultPlayer.setImageResource(com.alimm.tanx.core.R.mipmap.pause);
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
            tanxVideoView.removeView(tanxVideoView.ivPlayer);
            if (com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.iTanxFeedVideoAdListener != null) {
                android.view.View onCustomPlayIcon = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.iTanxFeedVideoAdListener.onCustomPlayIcon();
                if (onCustomPlayIcon != null) {
                    com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer = onCustomPlayIcon;
                } else {
                    com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView2 = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
                    tanxVideoView2.ivPlayer = tanxVideoView2.ivDefaultPlayer;
                }
            }
            if (com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.onClickListener != null) {
                com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer.setOnClickListener(com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.onClickListener);
            }
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView3 = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
            tanxVideoView3.addView(tanxVideoView3.ivPlayer);
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer.setVisibility(0);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.TanxVideoView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivDefaultPlayer.setImageResource(com.alimm.tanx.core.R.mipmap.londing);
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
            tanxVideoView.removeView(tanxVideoView.ivPlayer);
            if (com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.iTanxFeedVideoAdListener != null) {
                android.view.View onCustomLoadingIcon = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.iTanxFeedVideoAdListener.onCustomLoadingIcon();
                if (onCustomLoadingIcon != null) {
                    com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer = onCustomLoadingIcon;
                } else {
                    com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView2 = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
                    tanxVideoView2.ivPlayer = tanxVideoView2.ivDefaultPlayer;
                }
            }
            if (com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.onClickListener != null) {
                com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer.setOnClickListener(com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.onClickListener);
            }
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView3 = com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this;
            tanxVideoView3.addView(tanxVideoView3.ivPlayer);
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer.setVisibility(0);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.TanxVideoView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView.this.ivPlayer.setVisibility(8);
        }
    }

    public TanxVideoView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.isLoadWeb = false;
        initView();
    }

    public TanxVideoView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLoadWeb = false;
    }

    public TanxVideoView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLoadWeb = false;
    }

    private void initView() {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout tanxWebFrameLayout = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout(getContext());
        this.tanxWebFrameLayout = tanxWebFrameLayout;
        tanxWebFrameLayout.setShowWebStatusUi(false);
        this.tanxWebFrameLayout.setTemplateRender(false);
        addView(this.tanxWebFrameLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
        this.ivDefaultPlayer = new android.widget.ImageView(getContext());
        int dp2px = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), 30.0f);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 17;
        this.ivDefaultPlayer.setLayoutParams(layoutParams);
        android.widget.ImageView imageView = this.ivDefaultPlayer;
        this.ivPlayer = imageView;
        android.view.View.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        addView(this.ivPlayer, layoutParams);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    @Override // com.alimm.tanx.core.view.player.ui.TanxPlayerView
    public void loadWeb() {
        if (this.isLoadWeb) {
            return;
        }
        super.loadWeb();
        this.tanxWebFrameLayout.loadAd(this.iTanxAd, false, this);
        this.isLoadWeb = true;
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setLoadingType() {
        post(new com.alimm.tanx.core.ad.ad.feed.TanxVideoView.AnonymousClass2());
    }

    public void setPauseType() {
        post(new com.alimm.tanx.core.ad.ad.feed.TanxVideoView.AnonymousClass1());
    }

    public void setPlayClickListener(android.view.View.OnClickListener onClickListener) {
        android.view.View view = this.ivPlayer;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        this.onClickListener = onClickListener;
    }

    public void setPlayType() {
        post(new com.alimm.tanx.core.ad.ad.feed.TanxVideoView.AnonymousClass3());
    }

    public void setTanxAd(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        this.iTanxAd = iTanxAd;
    }

    public void setiTanxFeedVideoAdListener(com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
    }
}
