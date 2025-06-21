package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class PatchAdView extends android.widget.RelativeLayout {
    private static final java.lang.String AD_CLICKED = "onAdClicked";
    private static final java.lang.String PLAY_END = "playCompletion";
    private static final java.lang.String PLAY_ERROR = "playFailure";
    private static final java.lang.String PLAY_START = "onAdShow";
    private static final java.lang.String TAG = "PacthAdView";
    private android.view.View mAdView;
    private com.baidu.mobads.sdk.api.IPatchAdListener mListener;
    private java.lang.ClassLoader mLoader;
    private final java.lang.String mRemoteClassName;
    private android.content.Context mViewContext;

    public class InvocationHandlerImp implements java.lang.reflect.InvocationHandler {
        public InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            java.lang.String name = method.getName();
            if (android.text.TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(com.baidu.mobads.sdk.api.PatchAdView.PLAY_END)) {
                if (com.baidu.mobads.sdk.api.PatchAdView.this.mListener != null) {
                    com.baidu.mobads.sdk.api.PatchAdView.this.mListener.playCompletion();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.PatchAdView.PLAY_ERROR)) {
                if (com.baidu.mobads.sdk.api.PatchAdView.this.mListener != null) {
                    com.baidu.mobads.sdk.api.PatchAdView.this.mListener.playError();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.PatchAdView.PLAY_START)) {
                if (com.baidu.mobads.sdk.api.PatchAdView.this.mListener != null) {
                    com.baidu.mobads.sdk.api.PatchAdView.this.mListener.onAdShow();
                }
            } else if (name.equals(com.baidu.mobads.sdk.api.PatchAdView.AD_CLICKED) && com.baidu.mobads.sdk.api.PatchAdView.this.mListener != null) {
                com.baidu.mobads.sdk.api.PatchAdView.this.mListener.onAdClicked();
            }
            return null;
        }
    }

    public PatchAdView(android.content.Context context) {
        super(context);
        this.mRemoteClassName = com.baidu.mobads.sdk.internal.z.i;
        init(context);
        setBackgroundColor(android.graphics.Color.parseColor("#000000"));
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
        if (a instanceof java.lang.Number) {
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
        if (a instanceof java.lang.Number) {
            return ((java.lang.Long) a).longValue();
        }
        return 0L;
    }

    public void setAdData(com.baidu.mobads.sdk.api.XAdVideoResponse xAdVideoResponse) {
        android.view.View view;
        if (xAdVideoResponse == null || (view = this.mAdView) == null) {
            return;
        }
        com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new java.lang.Class[]{java.lang.Object.class}, xAdVideoResponse);
    }

    public void setPatchAdListener(com.baidu.mobads.sdk.api.IPatchAdListener iPatchAdListener) {
        this.mListener = iPatchAdListener;
        try {
            java.lang.Class<?> a = com.baidu.mobads.sdk.internal.au.a("com.component.patchad.IPatchAdListener", this.mLoader);
            if (a != null) {
                java.lang.Object newProxyInstance = java.lang.reflect.Proxy.newProxyInstance(a.getClassLoader(), new java.lang.Class[]{a}, new com.baidu.mobads.sdk.api.PatchAdView.InvocationHandlerImp());
                android.view.View view = this.mAdView;
                if (view != null) {
                    com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setPatchAdListener", new java.lang.Class[]{a}, newProxyInstance);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setVideoVolume(boolean z) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(this.mRemoteClassName, view, this.mLoader, "setVideoVolume", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }
}
