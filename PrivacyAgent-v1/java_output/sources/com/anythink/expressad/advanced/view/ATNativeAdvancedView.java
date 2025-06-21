package com.anythink.expressad.advanced.view;

/* loaded from: classes12.dex */
public class ATNativeAdvancedView extends android.widget.RelativeLayout {
    protected static final java.lang.String a = "webviewshow";
    private static java.lang.String b = "ATNativeAdvancedView";
    private com.anythink.expressad.advanced.view.ATNativeAdvancedWebview c;
    private android.view.View d;
    private boolean e;
    private boolean f;
    private boolean g;
    private com.anythink.expressad.advanced.d.c h;
    private com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl i;
    private android.content.Context j;

    /* renamed from: com.anythink.expressad.advanced.view.ATNativeAdvancedView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.String unused = com.anythink.expressad.advanced.view.ATNativeAdvancedView.b;
                java.lang.String str = "";
                try {
                    com.anythink.expressad.advanced.view.ATNativeAdvancedView.this.c.getLocationOnScreen(new int[2]);
                    java.lang.String unused2 = com.anythink.expressad.advanced.view.ATNativeAdvancedView.b;
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("startX", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r2[0]));
                    jSONObject.put("startY", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r2[1]));
                    str = jSONObject.toString();
                } catch (java.lang.Throwable th) {
                    java.lang.String unused3 = com.anythink.expressad.advanced.view.ATNativeAdvancedView.b;
                    th.getMessage();
                }
                java.lang.String encodeToString = android.util.Base64.encodeToString(str.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.advanced.view.ATNativeAdvancedView.this.c, com.anythink.expressad.advanced.view.ATNativeAdvancedView.a, encodeToString);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ATNativeAdvancedView(android.content.Context context) {
        this(context, null);
    }

    public ATNativeAdvancedView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATNativeAdvancedView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = context;
    }

    private void b() {
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.c, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.c.getLocationInWindow(iArr);
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.c.getHeight());
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.i);
            this.c.post(new com.anythink.expressad.advanced.view.ATNativeAdvancedView.AnonymousClass1());
        }
        android.view.View view = this.d;
        if (view != null) {
            if (view.getParent() != null) {
                bringChildToFront(this.d);
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 28.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 2.0f);
            layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 2.0f);
            addView(this.d, layoutParams);
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.c.getLocationInWindow(iArr);
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.c;
        transInfoForMraid(aTNativeAdvancedWebview, iArr[0], iArr[1], aTNativeAdvancedWebview.getWidth(), this.c.getHeight());
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.c;
        if (aTNativeAdvancedWebview2 != null) {
            aTNativeAdvancedWebview2.setObject(this.i);
            this.c.post(new com.anythink.expressad.advanced.view.ATNativeAdvancedView.AnonymousClass1());
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
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.k);
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
        android.view.View view = this.d;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.g = false;
        this.f = false;
        this.e = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        android.view.View view = this.d;
        if (view == null || view.getParent() == null) {
            return;
        }
        removeView(this.d);
    }

    public void destroy() {
        removeAllViews();
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.c;
        if (aTNativeAdvancedWebview != null && !aTNativeAdvancedWebview.isDestroyed()) {
            this.c.release();
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendEventToH5(this.c, "onSystemDestory", "");
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl getAdvancedNativeJSBridgeImpl() {
        return this.i;
    }

    public com.anythink.expressad.advanced.view.ATNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.c;
    }

    public android.view.View getCloseView() {
        return this.d;
    }

    public boolean isEndCardReady() {
        return this.g;
    }

    public boolean isH5Ready() {
        return this.e;
    }

    public boolean isVideoReady() {
        return this.f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.g = false;
        this.f = false;
        this.e = false;
    }

    public void setAdvancedNativeJSBridgeImpl(com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl) {
        this.i = nativeAdvancedJSBridgeImpl;
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.c;
        if (aTNativeAdvancedWebview != null) {
            aTNativeAdvancedWebview.setObject(nativeAdvancedJSBridgeImpl);
        }
    }

    public void setAdvancedNativeWebview(com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview) {
        this.c = aTNativeAdvancedWebview;
        com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = this.i;
        if (nativeAdvancedJSBridgeImpl != null) {
            aTNativeAdvancedWebview.setObject(nativeAdvancedJSBridgeImpl);
        }
    }

    public void setCloseView(android.view.View view) {
        this.d = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z) {
        this.g = z;
    }

    public void setH5Ready(boolean z) {
        this.e = z;
    }

    public void setVideoReady(boolean z) {
        this.f = z;
    }

    public void show() {
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.c, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.c.getLocationInWindow(iArr);
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.c.getHeight());
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.i);
            this.c.post(new com.anythink.expressad.advanced.view.ATNativeAdvancedView.AnonymousClass1());
        }
        android.view.View view = this.d;
        if (view != null) {
            if (view.getParent() == null) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 28.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 2.0f);
                layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 2.0f);
                addView(this.d, layoutParams);
            } else {
                bringChildToFront(this.d);
            }
        }
        clearResState();
    }
}
