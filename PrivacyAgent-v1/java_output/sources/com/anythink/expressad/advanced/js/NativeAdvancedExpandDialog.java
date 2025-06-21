package com.anythink.expressad.advanced.js;

/* loaded from: classes12.dex */
public class NativeAdvancedExpandDialog extends android.app.Dialog {
    private final java.lang.String a;
    private java.lang.String b;
    private boolean c;
    private android.widget.FrameLayout d;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView e;
    private android.widget.TextView f;
    private java.lang.String g;
    private java.util.List<com.anythink.expressad.foundation.d.c> h;
    private com.anythink.expressad.advanced.d.a i;
    private com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge j;

    /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$2$1, reason: invalid class name */
        public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
            public AnonymousClass1() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(java.lang.String str) {
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass2.AnonymousClass1());
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.a(com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(android.content.DialogInterface dialogInterface) {
            if (com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.i != null) {
                com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.i.a(false);
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView, null, "", "text/html", "utf-8", null);
            windVaneWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.d.removeView(com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e);
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e.release();
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e = null;
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.i = null;
        }
    }

    /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public void close() {
            com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.dismiss();
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public void expand(java.lang.String str, boolean z) {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public com.anythink.expressad.foundation.d.c getMraidCampaign() {
            return null;
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public void open(java.lang.String str) {
            try {
                if (com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e != null && java.lang.System.currentTimeMillis() - com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e.lastTouchTime > com.anythink.expressad.a.b.a.c) {
                    com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.h.get(0);
                    com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.e.getUrl();
                    if (com.anythink.expressad.a.b.a.a(cVar)) {
                        return;
                    }
                }
                if (com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.h.size() > 1) {
                    com.anythink.core.common.b.o.a().f().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                    str = null;
                }
                if (com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.i != null) {
                    com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.i.a(str);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public void unload() {
            close();
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public void useCustomClose(boolean z) {
            try {
                com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.this.f.setVisibility(z ? 4 : 0);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public NativeAdvancedExpandDialog(android.content.Context context, android.os.Bundle bundle, com.anythink.expressad.advanced.d.a aVar) {
        super(context);
        this.a = "NativeAdvancedExpandDialog";
        this.j = new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass4();
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.i = aVar;
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
        this.f.setOnClickListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass1());
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
        this.e.setWebViewListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass2());
        this.e.setObject(this.j);
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.e;
        java.lang.String str = this.b;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str);
        windVaneWebView2.loadUrl(str);
        setOnDismissListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass3());
    }

    public static /* synthetic */ void a(com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog nativeAdvancedExpandDialog) {
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
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.k);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.g);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
            nativeAdvancedExpandDialog.e.getLocationInWindow(new int[2]);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(nativeAdvancedExpandDialog.e, r1[0], r1[1], r11.getWidth(), nativeAdvancedExpandDialog.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(nativeAdvancedExpandDialog.e, r1[0], r1[1], r5.getWidth(), nativeAdvancedExpandDialog.e.getHeight());
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(nativeAdvancedExpandDialog.e, e, f);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(nativeAdvancedExpandDialog.e, intValue, intValue2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(nativeAdvancedExpandDialog.e, hashMap);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(nativeAdvancedExpandDialog.e);
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
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.k);
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

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
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
        this.f.setOnClickListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass1());
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
        this.e.setWebViewListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass2());
        this.e.setObject(this.j);
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.e;
        java.lang.String str = this.b;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str);
        windVaneWebView2.loadUrl(str);
        setOnDismissListener(new com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.AnonymousClass3());
    }

    public void setCampaignList(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.g = str;
        this.h = list;
    }
}
