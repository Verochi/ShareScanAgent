package com.anythink.basead.mraid;

/* loaded from: classes12.dex */
public final class c extends android.app.Dialog {
    private final java.lang.String a;
    private java.lang.String b;
    private boolean c;
    private android.widget.FrameLayout d;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView e;
    private android.widget.TextView f;
    private com.anythink.basead.mraid.b g;
    private com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge h;

    /* renamed from: com.anythink.basead.mraid.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.mraid.c.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.mraid.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: com.anythink.basead.mraid.c$2$1, reason: invalid class name */
        public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
            public AnonymousClass1() {
            }

            private static void a() {
            }

            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.basead.mraid.c.AnonymousClass2.AnonymousClass1());
            com.anythink.basead.mraid.c.a(com.anythink.basead.mraid.c.this);
        }
    }

    /* renamed from: com.anythink.basead.mraid.c$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(android.content.DialogInterface dialogInterface) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = com.anythink.basead.mraid.c.this.e;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView, null, "", "text/html", "utf-8", null);
            windVaneWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            com.anythink.basead.mraid.c.this.d.removeView(com.anythink.basead.mraid.c.this.e);
            com.anythink.basead.mraid.c.this.e.release();
            com.anythink.basead.mraid.c.this.e = null;
            com.anythink.basead.mraid.c.this.g = null;
        }
    }

    /* renamed from: com.anythink.basead.mraid.c$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void close() {
            com.anythink.basead.mraid.c.this.dismiss();
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void expand(java.lang.String str, boolean z) {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
            return null;
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void open(java.lang.String str) {
            try {
                if (com.anythink.basead.mraid.c.this.g != null) {
                    com.anythink.basead.mraid.c.this.g.open(str);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void unload() {
            close();
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void useCustomClose(boolean z) {
            try {
                com.anythink.basead.mraid.c.this.f.setVisibility(z ? 4 : 0);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public c(android.content.Context context, android.os.Bundle bundle, com.anythink.basead.mraid.b bVar) {
        super(context);
        this.a = "BannerExpandDialog";
        this.h = new com.anythink.basead.mraid.c.AnonymousClass4();
        this.b = bundle.getString("url");
        this.c = bundle.getBoolean("shouldUseCustomClose");
        this.g = bVar;
    }

    private void a() {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new com.anythink.basead.mraid.c.AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
        this.e.setWebViewListener(new com.anythink.basead.mraid.c.AnonymousClass2());
        this.e.setObject(this.h);
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.e;
        java.lang.String str = this.b;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str);
        windVaneWebView2.loadUrl(str);
        setOnDismissListener(new com.anythink.basead.mraid.c.AnonymousClass3());
    }

    public static /* synthetic */ void a(com.anythink.basead.mraid.c cVar) {
        try {
            int i = com.anythink.core.common.b.o.a().f().getResources().getConfiguration().orientation;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("orientation", i == 2 ? "landscape" : i == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            float e = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
            float f = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
            java.util.HashMap g = com.anythink.expressad.foundation.h.k.g(com.anythink.core.common.b.o.a().f());
            int intValue = ((java.lang.Integer) g.get("width")).intValue();
            int intValue2 = ((java.lang.Integer) g.get("height")).intValue();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "Interstitial");
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.g);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
            cVar.e.getLocationInWindow(new int[2]);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(cVar.e, r1[0], r1[1], r11.getWidth(), cVar.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(cVar.e, r1[0], r1[1], r5.getWidth(), cVar.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(cVar.e, e, f);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(cVar.e, intValue, intValue2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(cVar.e, hashMap);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(cVar.e);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void b() {
        try {
            int i = com.anythink.core.common.b.o.a().f().getResources().getConfiguration().orientation;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("orientation", i == 2 ? "landscape" : i == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            float e = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
            float f = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
            java.util.HashMap g = com.anythink.expressad.foundation.h.k.g(com.anythink.core.common.b.o.a().f());
            int intValue = ((java.lang.Integer) g.get("width")).intValue();
            int intValue2 = ((java.lang.Integer) g.get("height")).intValue();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "Interstitial");
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.g);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
            this.e.getLocationInWindow(new int[2]);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(this.e, r1[0], r1[1], r11.getWidth(), this.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(this.e, r1[0], r1[1], r5.getWidth(), this.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(this.e, e, f);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(this.e, intValue, intValue2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(this.e, hashMap);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(this.e);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new com.anythink.basead.mraid.c.AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
        this.e.setWebViewListener(new com.anythink.basead.mraid.c.AnonymousClass2());
        this.e.setObject(this.h);
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.e;
        java.lang.String str = this.b;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str);
        windVaneWebView2.loadUrl(str);
        setOnDismissListener(new com.anythink.basead.mraid.c.AnonymousClass3());
    }
}
