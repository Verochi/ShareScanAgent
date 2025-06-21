package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class XNativeView extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    private static final java.lang.String TAG = "XNativeView";
    private com.baidu.mobads.sdk.internal.bt mAdLogger;
    private com.baidu.mobads.sdk.api.XAdNativeResponse mCurrentNativeItem;
    private com.baidu.mobads.sdk.api.INativeVideoListener mFeedVideoListener;
    private com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener mNativeViewListener;
    private int mProgressBg;
    private int mProgressColor;
    private int mProgressHeight;
    private boolean mShowProgressBar;
    private com.baidu.mobads.sdk.api.FeedPortraitVideoView mVideoView;
    private boolean videoMute;

    /* renamed from: com.baidu.mobads.sdk.api.XNativeView$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.api.IFeedPortraitListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void pauseBtnClick() {
            com.baidu.mobads.sdk.api.XNativeView.this.callNativeViewClick();
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playCompletion() {
            if (com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener.onCompletion();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playError() {
            if (com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener.onError();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playPause() {
            if (com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener.onPause();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playRenderingStart() {
            if (com.baidu.mobads.sdk.api.XNativeView.this.mVideoView != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mVideoView.hideFeedCoverPic(com.baidu.mobads.sdk.api.XNativeView.this.mCurrentNativeItem);
            }
            com.baidu.mobads.sdk.api.XNativeViewManager.getInstance().resetAllPlayer(com.baidu.mobads.sdk.api.XNativeView.this);
            if (com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener.onRenderingStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playResume() {
            if (com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.XNativeView.this.mFeedVideoListener.onResume();
            }
        }
    }

    public interface INativeViewClickListener {
        void onNativeViewClick(com.baidu.mobads.sdk.api.XNativeView xNativeView);
    }

    public XNativeView(android.content.Context context) {
        this(context, null);
    }

    public XNativeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XNativeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = com.baidu.mobads.sdk.internal.bt.a();
        setBackgroundColor(android.graphics.Color.parseColor("#000000"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNativeViewClick() {
        com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener iNativeViewClickListener = this.mNativeViewListener;
        if (iNativeViewClickListener != null) {
            iNativeViewClickListener.onNativeViewClick(this);
        }
    }

    private void initAdVideoView() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.setCanClickVideo(true);
        this.mVideoView.setAdData(this.mCurrentNativeItem);
        this.mVideoView.systemSetVideoMute(this.videoMute);
    }

    private boolean isVisible(android.view.View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        if (!view.getGlobalVisibleRect(new android.graphics.Rect())) {
            return false;
        }
        long height = view.getHeight() * view.getWidth();
        return height > 0 && (r1.height() * r1.width()) * 100 >= ((long) i) * height;
    }

    private void play() {
        if (this.mVideoView != null) {
            initAdVideoView();
            this.mVideoView.hideFeedPauseBtn(this.mCurrentNativeItem);
            this.mVideoView.play();
        }
    }

    private void renderView() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        if (xAdNativeResponse == null) {
            return;
        }
        com.baidu.mobads.sdk.api.NativeResponse.MaterialType materialType = xAdNativeResponse.getMaterialType();
        if (this.mVideoView == null) {
            com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = new com.baidu.mobads.sdk.api.FeedPortraitVideoView(getContext());
            this.mVideoView = feedPortraitVideoView;
            feedPortraitVideoView.setShowProgress(this.mShowProgressBar);
            this.mVideoView.setProgressBarColor(this.mProgressColor);
            this.mVideoView.setProgressBackgroundColor(this.mProgressBg);
            this.mVideoView.setProgressHeightInDp(this.mProgressHeight);
            addView(this.mVideoView, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            this.mVideoView.setFeedPortraitListener(new com.baidu.mobads.sdk.api.XNativeView.AnonymousClass1());
        }
        if (materialType == com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL) {
            this.mVideoView.showNormalPic(this.mCurrentNativeItem);
        } else if (materialType == com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO) {
            showView(this.mCurrentNativeItem);
        }
    }

    private boolean shouldAutoPlay() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        boolean z = xAdNativeResponse != null && xAdNativeResponse.isAutoPlay();
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse2 = this.mCurrentNativeItem;
        boolean z2 = xAdNativeResponse2 == null || xAdNativeResponse2.isNonWifiAutoPlay();
        java.lang.Boolean a = com.baidu.mobads.sdk.internal.cp.a().a(getContext().getApplicationContext());
        if (z && a.booleanValue()) {
            return true;
        }
        return z2 && !a.booleanValue();
    }

    private void showView(com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse) {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.showFeedVideoCover(xAdNativeResponse);
    }

    public void handleCover() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.handleFeedCover(this.mCurrentNativeItem);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.mobads.sdk.api.XNativeViewManager.getInstance().addItem(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.mobads.sdk.api.XNativeViewManager.getInstance().removeNativeView(this);
    }

    public void pause() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    public void render() {
        if (shouldAutoPlay()) {
            play();
        } else {
            initAdVideoView();
        }
    }

    public void resume() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    public void setNativeItem(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        this.mCurrentNativeItem = (com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse;
        renderView();
    }

    public void setNativeVideoListener(com.baidu.mobads.sdk.api.INativeVideoListener iNativeVideoListener) {
        this.mFeedVideoListener = iNativeVideoListener;
    }

    public void setNativeViewClickListener(com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener iNativeViewClickListener) {
        this.mNativeViewListener = iNativeViewClickListener;
    }

    public void setProgressBackgroundColor(int i) {
        this.mProgressBg = i;
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBackgroundColor(i);
        }
    }

    public void setProgressBarColor(int i) {
        this.mProgressColor = i;
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBarColor(i);
        }
    }

    public void setProgressHeightInDp(int i) {
        this.mProgressHeight = i;
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressHeightInDp(i);
        }
    }

    public void setShowProgress(boolean z) {
        this.mShowProgressBar = z;
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setShowProgress(z);
        }
    }

    public void setUseDownloadFrame(boolean z) {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setUseDownloadFrame(z);
        }
    }

    public void setVideoMute(boolean z) {
        this.videoMute = z;
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }

    public void stop() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }
}
