package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CpuVideoView extends android.widget.RelativeLayout {
    public static final java.lang.String TAG = "CpuVideoView";
    private com.baidu.mobads.sdk.api.CpuVideoView.CpuVideoStatusListener mCpuVideoStatusListener;
    private com.baidu.mobads.sdk.api.FeedPortraitVideoView mVideoView;

    /* renamed from: com.baidu.mobads.sdk.api.CpuVideoView$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.api.IFeedPortraitListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void pauseBtnClick() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("pauseBtnClick: ");
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playCompletion() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("playCompletion: ");
            if (com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener != null) {
                com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener.playCompletion();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playError() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("playError: ");
            if (com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener != null) {
                com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener.playError();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playPause() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("playPause: ");
            if (com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener != null) {
                com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener.playPause();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playRenderingStart() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("playRenderingStart: ");
            if (com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener != null) {
                com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener.playRenderingStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playResume() {
            com.baidu.mobads.sdk.internal.ay.h(com.baidu.mobads.sdk.api.CpuVideoView.TAG).d("playResume: ");
            if (com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener != null) {
                com.baidu.mobads.sdk.api.CpuVideoView.this.mCpuVideoStatusListener.playResume();
            }
        }
    }

    public interface CpuVideoStatusListener {
        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    public CpuVideoView(android.content.Context context) {
        this(context, null);
    }

    public CpuVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CpuVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initVideoView();
    }

    private void initVideoView() {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = new com.baidu.mobads.sdk.api.FeedPortraitVideoView(getContext());
        this.mVideoView = feedPortraitVideoView;
        feedPortraitVideoView.systemSetVideoMute(true);
        this.mVideoView.setProgressBarColor(-1);
        this.mVideoView.setProgressHeightInDp(1);
        this.mVideoView.setProgressBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.mVideoView.setFeedPortraitListener(new com.baidu.mobads.sdk.api.CpuVideoView.AnonymousClass1());
        addView(this.mVideoView, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCpuVideoStatusListener(com.baidu.mobads.sdk.api.CpuVideoView.CpuVideoStatusListener cpuVideoStatusListener) {
        this.mCpuVideoStatusListener = cpuVideoStatusListener;
    }

    public void setVideoConfig(com.baidu.mobads.sdk.api.IBasicCPUData iBasicCPUData) {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setAdData(iBasicCPUData);
        }
    }
}
