package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class FeedPortraitVideoView extends android.widget.RelativeLayout {
    private static final java.lang.String FEED_CLICK = "pauseBtnClick";
    private static final java.lang.String PLAY_END = "playCompletion";
    private static final java.lang.String PLAY_ERROR = "playError";
    private static final java.lang.String PLAY_PAUSE = "playPause";
    private static final java.lang.String PLAY_RESUME = "playResume";
    private static final java.lang.String PLAY_START = "playRenderingStart";
    private static final java.lang.String TAG = "FeedPortraitVideoView";
    private android.view.View mAdView;
    private com.baidu.mobads.sdk.api.IFeedPortraitListener mFeedVideoListener;
    private java.lang.ClassLoader mLoader;
    private java.lang.String mRemoteClassName;
    private android.content.Context mViewContext;
    private boolean useDownloadFrame;

    public class InvocationHandlerImp implements java.lang.reflect.InvocationHandler {
        public InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            java.lang.String name = method.getName();
            if (android.text.TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.PLAY_END)) {
                if (com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.playCompletion();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.PLAY_ERROR)) {
                if (com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.playError();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.PLAY_START)) {
                if (com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.playRenderingStart();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.PLAY_PAUSE)) {
                if (com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.playPause();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.PLAY_RESUME)) {
                if (com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.playResume();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.FeedPortraitVideoView.FEED_CLICK) && com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener != null) {
                com.baidu.mobads.sdk.api.FeedPortraitVideoView.this.mFeedVideoListener.pauseBtnClick();
            }
            return null;
        }
    }

    public FeedPortraitVideoView(android.content.Context context) {
        this(context, null);
    }

    public FeedPortraitVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedPortraitVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRemoteClassName = com.baidu.mobads.sdk.internal.z.d;
        this.useDownloadFrame = false;
        init(context);
    }

    private void init(android.content.Context context) {
        this.mViewContext = context;
        java.lang.Object[] objArr = {context};
        java.lang.ClassLoader a = com.baidu.mobads.sdk.internal.bs.a(context);
        this.mLoader = a;
        android.view.View view = (android.view.View) com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, a, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        android.view.View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new java.lang.Class[0], new java.lang.Object[0]);
        if (a instanceof java.lang.Long) {
            return ((java.lang.Long) a).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        android.view.View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new java.lang.Class[0], new java.lang.Object[0]);
        if (a instanceof java.lang.Long) {
            return ((java.lang.Long) a).longValue();
        }
        return 0L;
    }

    public void handleFeedCover(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "handleCover", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        }
    }

    public void hideFeedCoverPic(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "hideFeedCoverPic", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        }
    }

    public void hideFeedPauseBtn(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "hidePauseBtn", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        }
    }

    public boolean isPlaying() {
        android.view.View view = this.mAdView;
        if (view != null) {
            java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "isPlaying", new java.lang.Class[0], new java.lang.Object[0]);
            if (a instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) a).booleanValue();
            }
        }
        return false;
    }

    public boolean isShowEndFrame() {
        android.view.View view = this.mAdView;
        if (view != null) {
            java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "isShowEndFrame", new java.lang.Class[0], new java.lang.Object[0]);
            if (a instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) a).booleanValue();
            }
        }
        return false;
    }

    public void pause() {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, com.anythink.expressad.foundation.d.c.cb, new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void play() {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, com.aliyun.vod.log.core.AliyunLogCommon.SubModule.play, new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void resume() {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, com.anythink.expressad.foundation.d.c.cc, new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void seekTo(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "seekTo", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setAdData(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        if (abstractData instanceof com.baidu.mobads.sdk.api.NativeCPUAdData) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setCpuAdData", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        } else {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        }
    }

    public void setCanClickVideo(boolean z) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setCanClickVideo", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setFeedPortraitListener(com.baidu.mobads.sdk.api.IFeedPortraitListener iFeedPortraitListener) {
        this.mFeedVideoListener = iFeedPortraitListener;
        try {
            java.lang.Class<?> a = com.baidu.mobads.sdk.internal.au.a("com.component.feed.IFeedPortraitListener", this.mLoader);
            if (a != null) {
                java.lang.Object newProxyInstance = java.lang.reflect.Proxy.newProxyInstance(a.getClassLoader(), new java.lang.Class[]{a}, new com.baidu.mobads.sdk.api.FeedPortraitVideoView.InvocationHandlerImp());
                android.view.View view = this.mAdView;
                if (view != null) {
                    com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setFeedPortraitListener", new java.lang.Class[]{a}, newProxyInstance);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setPlayBackSpeed(float f) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setPlayBackSpeed", new java.lang.Class[]{java.lang.Float.TYPE}, java.lang.Float.valueOf(f));
        }
    }

    public void setProgressBackgroundColor(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setProgressBackgroundColor", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setProgressBarColor(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setProgressBarColor", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setProgressHeightInDp(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setProgressHeightDp", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setShowProgress(boolean z) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setShowProgressBar", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setUseDownloadFrame(boolean z) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setUseDownloadFrame", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setVideoMute(boolean z) {
        try {
            android.view.View view = this.mAdView;
            if (view != null) {
                com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "userSetVideoMute", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void showFeedVideoCover(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "showFeedVideoCover", new java.lang.Class[]{java.lang.Object.class}, abstractData);
        }
    }

    public void showNormalPic(com.baidu.mobads.sdk.api.AbstractData abstractData) {
        android.view.View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "showNormalPic", new java.lang.Class[]{java.lang.Object.class}, abstractData);
    }

    public void stop() {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "stop", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void systemSetVideoMute(boolean z) {
        try {
            android.view.View view = this.mAdView;
            if (view != null) {
                com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setVideoMute", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
