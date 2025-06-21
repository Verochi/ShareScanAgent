package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class ATSplashView extends android.widget.RelativeLayout {
    protected static final java.lang.String a = "webviewshow";
    protected static final java.lang.String b = "updateCountdown";
    private static java.lang.String c = "ATSplashView";
    private int d;
    private com.anythink.expressad.splash.view.ATSplashWebview e;
    private android.view.ViewGroup f;
    private android.view.View g;
    private android.view.View h;
    private int i;
    private boolean j;
    private boolean k;
    private android.view.ViewGroup l;
    private boolean m;
    private android.view.View n;
    private boolean o;
    private boolean p;
    private android.widget.RelativeLayout.LayoutParams q;
    private com.anythink.expressad.splash.js.SplashJSBridgeImpl r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f263s;

    /* renamed from: com.anythink.expressad.splash.view.ATSplashView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.String unused = com.anythink.expressad.splash.view.ATSplashView.c;
                java.lang.String str = "";
                try {
                    com.anythink.expressad.splash.view.ATSplashView.this.e.getLocationOnScreen(new int[2]);
                    java.lang.String unused2 = com.anythink.expressad.splash.view.ATSplashView.c;
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("startX", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r4[0]));
                    jSONObject.put("startY", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r4[1]));
                    str = jSONObject.toString();
                } catch (java.lang.Throwable th) {
                    java.lang.String unused3 = com.anythink.expressad.splash.view.ATSplashView.c;
                    th.getMessage();
                }
                int[] iArr = new int[2];
                com.anythink.expressad.splash.view.ATSplashView.this.e.getLocationInWindow(iArr);
                com.anythink.expressad.splash.view.ATSplashView.transInfoForMraid(com.anythink.expressad.splash.view.ATSplashView.this.e, iArr[0], iArr[1], com.anythink.expressad.splash.view.ATSplashView.this.e.getWidth(), com.anythink.expressad.splash.view.ATSplashView.this.e.getHeight());
                java.lang.String encodeToString = android.util.Base64.encodeToString(str.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.splash.view.ATSplashView.this.e, com.anythink.expressad.splash.view.ATSplashView.a, encodeToString);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ATSplashView(android.content.Context context) {
        this(context, null);
    }

    public ATSplashView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f263s = false;
        b();
    }

    private void b() {
        setBackgroundColor(0);
        this.d = getResources().getConfiguration().orientation;
        this.f263s = false;
    }

    private void c() {
        android.view.View view;
        android.view.View view2;
        android.view.View view3;
        if (this.h != null) {
            if (this.f == null) {
                android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
                this.f = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.d == 2) {
                this.i = com.anythink.expressad.foundation.h.t.f(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f.getId());
                if (!this.o || (view2 = this.n) == null) {
                    com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        com.anythink.core.common.o.w.a(this.n);
                    }
                    addView(this.n, layoutParams);
                }
                android.view.ViewGroup viewGroup = this.f;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i = this.q.width;
                    int i2 = this.i;
                    if (i > i2 / 4) {
                        i = i2 / 4;
                    }
                    this.f.addView(this.h, i, -1);
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(i, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f, layoutParams2);
                }
            } else {
                this.i = com.anythink.expressad.foundation.h.t.e(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f.getId());
                if (!this.o || (view = this.n) == null) {
                    com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview2 = this.e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        com.anythink.core.common.o.w.a(this.n);
                    }
                    addView(this.n, layoutParams3);
                }
                android.view.ViewGroup viewGroup2 = this.f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i3 = this.q.height;
                    int i4 = this.i;
                    if (i3 > i4 / 4) {
                        i3 = i4 / 4;
                    }
                    this.f.addView(this.h, -1, i3);
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, i3);
                    layoutParams4.addRule(12);
                    addView(this.f, layoutParams4);
                }
            }
        } else if (!this.o || (view3 = this.n) == null) {
            com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview3 = this.e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.e, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                com.anythink.core.common.o.w.a(this.n);
            }
            addView(this.n, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        android.view.View view4 = this.g;
        if (view4 != null) {
            if (view4.getParent() != null) {
                bringChildToFront(this.g);
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 100.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f));
            layoutParams5.addRule(10);
            layoutParams5.addRule(11);
            layoutParams5.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
            layoutParams5.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
            addView(this.g, layoutParams5);
        }
    }

    private void d() {
        com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(this.r);
            this.e.post(new com.anythink.expressad.splash.view.ATSplashView.AnonymousClass1());
        }
    }

    public static void transInfoForMraid(android.webkit.WebView webView, int i, int i2, int i3, int i4) {
        try {
            int i5 = com.anythink.core.common.b.o.a().f().getResources().getConfiguration().orientation;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("orientation", i5 == 2 ? "landscape" : i5 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            float e = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
            float f = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
            java.util.HashMap g = com.anythink.expressad.foundation.h.k.g(com.anythink.core.common.b.o.a().f());
            int intValue = ((java.lang.Integer) g.get("width")).intValue();
            int intValue2 = ((java.lang.Integer) g.get("height")).intValue();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "Interstitial");
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "default");
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
            float f2 = i;
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(webView, f2, f3, f4, f5);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(webView, f2, f3, f4, f5);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(webView, e, f);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(webView, intValue, intValue2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(webView, hashMap);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(webView);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void changeCloseBtnState(int i) {
        android.view.View view = this.g;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void checkSkipViewLocation() {
        if (this.f263s) {
            return;
        }
        try {
            android.view.View view = this.g;
            if (view != null) {
                android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                    int i = ((android.widget.RelativeLayout.LayoutParams) layoutParams).topMargin;
                    int b2 = com.anythink.core.common.o.i.b(getContext()) + i;
                    if (i > 0) {
                        this.f263s = true;
                    }
                    int[] iArr = new int[2];
                    this.g.getLocationOnScreen(iArr);
                    int i2 = iArr[1];
                    if (i2 < b2) {
                        ((android.widget.RelativeLayout.LayoutParams) layoutParams).topMargin = i + (b2 - i2);
                        this.g.setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearResState() {
        this.m = false;
        this.k = false;
        this.j = false;
    }

    public void destroy() {
        com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview == null || aTSplashWebview.isDestroyed()) {
            return;
        }
        this.e.release();
        com.anythink.expressad.splash.js.SplashJsUtils.sendEventToH5(this.e, "onSystemDestory", "");
    }

    public android.view.View getCloseView() {
        return this.g;
    }

    public android.view.ViewGroup getDevContainer() {
        return this.l;
    }

    public android.view.View getIconVg() {
        return this.h;
    }

    public com.anythink.expressad.splash.js.SplashJSBridgeImpl getSplashJSBridgeImpl() {
        return this.r;
    }

    public com.anythink.expressad.splash.view.ATSplashWebview getSplashWebview() {
        return this.e;
    }

    public boolean isAttach() {
        return this.p;
    }

    public boolean isDynamicView() {
        return this.o;
    }

    public boolean isH5Ready() {
        return this.j;
    }

    public boolean isImageReady() {
        return this.m;
    }

    public boolean isVideoReady() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSkipViewLocation();
    }

    public void onPause() {
        android.view.View view = this.n;
        if (view == null || !(view instanceof com.anythink.expressad.splash.view.ATSplashNativeView)) {
            return;
        }
        ((com.anythink.expressad.splash.view.ATSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        android.view.View view = this.n;
        if (view == null || !(view instanceof com.anythink.expressad.splash.view.ATSplashNativeView)) {
            return;
        }
        ((com.anythink.expressad.splash.view.ATSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.k = false;
        this.j = false;
    }

    public void setCloseView(android.view.View view) {
        this.g = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(android.view.ViewGroup viewGroup) {
        this.l = viewGroup;
    }

    public void setDynamicView(boolean z) {
        this.o = z;
    }

    public void setH5Ready(boolean z) {
        this.j = z;
    }

    public void setIconVg(android.view.View view, android.widget.RelativeLayout.LayoutParams layoutParams) {
        this.h = view;
        this.q = layoutParams;
    }

    public void setImageReady(boolean z) {
        this.m = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        android.view.View view = this.n;
        if (view == null || !(view instanceof com.anythink.expressad.splash.view.ATSplashNativeView)) {
            return;
        }
        ((com.anythink.expressad.splash.view.ATSplashNativeView) view).setNotchPadding(i, i2, i3, i4);
    }

    public void setSplashJSBridgeImpl(com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl) {
        this.r = splashJSBridgeImpl;
        com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setSplashNativeView(android.view.View view) {
        if (view != null) {
            this.n = view;
        }
    }

    public void setSplashWebview(com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview) {
        this.e = aTSplashWebview;
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.r;
        if (splashJSBridgeImpl != null) {
            aTSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setVideoReady(boolean z) {
        this.k = z;
    }

    public void show() {
        android.view.View view;
        android.view.View view2;
        android.view.View view3;
        android.view.ViewGroup viewGroup;
        if (this.r != null && (viewGroup = this.l) != null && (viewGroup.getContext() instanceof android.app.Activity)) {
            this.r.updateContext(this.l.getContext());
        }
        if (this.h != null) {
            if (this.f == null) {
                android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
                this.f = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.d == 2) {
                this.i = com.anythink.expressad.foundation.h.t.f(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f.getId());
                if (!this.o || (view2 = this.n) == null) {
                    com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        com.anythink.core.common.o.w.a(this.n);
                    }
                    addView(this.n, layoutParams);
                }
                android.view.ViewGroup viewGroup2 = this.f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i = this.q.width;
                    int i2 = this.i;
                    if (i > i2 / 4) {
                        i = i2 / 4;
                    }
                    this.f.addView(this.h, i, -1);
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(i, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f, layoutParams2);
                }
            } else {
                this.i = com.anythink.expressad.foundation.h.t.e(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f.getId());
                if (!this.o || (view = this.n) == null) {
                    com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview2 = this.e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        com.anythink.core.common.o.w.a(this.n);
                    }
                    addView(this.n, layoutParams3);
                }
                android.view.ViewGroup viewGroup3 = this.f;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i3 = this.q.height;
                    int i4 = this.i;
                    if (i3 > i4 / 4) {
                        i3 = i4 / 4;
                    }
                    this.f.addView(this.h, -1, i3);
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, i3);
                    layoutParams4.addRule(12);
                    addView(this.f, layoutParams4);
                }
            }
        } else if (!this.o || (view3 = this.n) == null) {
            com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview3 = this.e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.e, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                com.anythink.core.common.o.w.a(this.n);
            }
            addView(this.n, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        android.view.View view4 = this.g;
        if (view4 != null) {
            if (view4.getParent() == null) {
                android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 100.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
                layoutParams5.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
                addView(this.g, layoutParams5);
            } else {
                bringChildToFront(this.g);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i) {
        android.view.View view;
        if (this.e != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.d.a.b.dk, i);
                java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.e, b, encodeToString);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (this.o && (view = this.n) != null && (view instanceof com.anythink.expressad.splash.view.ATSplashNativeView)) {
                ((com.anythink.expressad.splash.view.ATSplashNativeView) view).updateCountDown(i);
            }
        }
    }
}
