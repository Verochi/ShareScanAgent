package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class AnythinkBTWebView extends com.anythink.expressad.video.bt.module.BTBaseView implements com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge {

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f266s = "portrait";
    private static final java.lang.String t = "landscape";
    private com.anythink.expressad.video.signal.a.j A;
    private android.webkit.WebView B;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r;
    private boolean u;
    private android.widget.ImageView v;
    private boolean w;
    private com.anythink.expressad.videocommon.e.d x;
    private java.util.List<com.anythink.expressad.foundation.d.c> y;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView z;

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTWebView$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.atsignalcommon.a.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(java.lang.Object obj) {
            super.a(obj);
            try {
                java.lang.String i = com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.A != null ? com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.A.i() : "";
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.text.TextUtils.isEmpty(i) ? "" : android.util.Base64.encodeToString(i.getBytes(), 2));
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject2.put("result", 1);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, "onWebviewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, e.getMessage());
                    e.getMessage();
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.z);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, "onWebviewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, e.getMessage());
                    e.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", sslError.toString());
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, "onWebviewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, e.getMessage());
                    e.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTWebView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("x", java.lang.String.valueOf(view.getX()));
                    jSONObject2.put("y", java.lang.String.valueOf(view.getY()));
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, "onClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } catch (java.lang.Exception unused) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B, "onClicked", com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.d);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTWebView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.close();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTWebView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.z != null) {
                    com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.z.clearWebView();
                    com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.z.release();
                }
                com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.p = null;
                com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.q = null;
                com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.r = null;
                if (com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B != null) {
                    com.anythink.expressad.video.bt.module.AnythinkBTWebView.this.B = null;
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public AnythinkBTWebView(android.content.Context context) {
        super(context);
        this.u = false;
        this.w = false;
    }

    public AnythinkBTWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = false;
        this.w = false;
    }

    private void a(com.anythink.expressad.atsignalcommon.base.c cVar) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setFilter(cVar);
        }
    }

    private void b() {
        try {
            getMraidCampaign();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void broadcast(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.z != null) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                jSONObject2.put("id", this.d);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.z, "broadcast", android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (java.lang.Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((android.webkit.WebView) this.z, "broadcast", this.d);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        android.webkit.WebView webView = this.B;
        if (webView != null) {
            com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerCloseBtnClicked", this.d);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(java.lang.String str, boolean z) {
    }

    public java.util.List<com.anythink.expressad.foundation.d.c> getCampaigns() {
        return this.y;
    }

    public java.lang.String getFilePath() {
        return this.q;
    }

    public java.lang.String getFileURL() {
        return this.p;
    }

    public java.lang.String getHtml() {
        return this.r;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return this.b;
    }

    public com.anythink.expressad.videocommon.e.d getRewardUnitSetting() {
        return this.x;
    }

    public com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView getWebView() {
        return this.z;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(android.content.Context context) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(context);
        this.z = windVaneWebView;
        windVaneWebView.setBackgroundColor(0);
        this.z.setVisibility(0);
        com.anythink.expressad.video.signal.a.j jVar = new com.anythink.expressad.video.signal.a.j(null, this.b, this.y);
        this.A = jVar;
        jVar.a(this.c);
        this.z.setObject(this.A);
        this.z.setMraidObject(this);
        this.z.setWebViewListener(new com.anythink.expressad.video.bt.module.AnythinkBTWebView.AnonymousClass1());
        addView(this.z, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTWebView.AnonymousClass2());
        try {
            android.widget.ImageView imageView = new android.widget.ImageView(getContext());
            this.v = imageView;
            imageView.setImageResource(findDrawable("anythink_reward_close"));
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.TOP_END;
            layoutParams.setMargins(30, 30, 30, 30);
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(this.u ? 4 : 8);
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.H()) {
                this.v.setVisibility(4);
            }
            this.v.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTWebView.AnonymousClass3());
            addView(this.v);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void notifyEvent(java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            com.anythink.expressad.video.bt.module.BTBaseView.a(windVaneWebView, str, this.d);
        }
    }

    public void onBackPressed() {
        if (this.z != null) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a((android.webkit.WebView) this.z, "onSystemBackPressed", this.d);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (this.z != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", t);
                } else {
                    jSONObject.put("orientation", f266s);
                }
                jSONObject.put("instanceId", this.d);
                java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.z, "orientation", encodeToString);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        if (this.w) {
            return;
        }
        this.w = true;
        try {
            if (this.z != null) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((android.webkit.WebView) this.z, "onSystemDestory", this.d);
            }
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.anythink.expressad.video.bt.module.AnythinkBTWebView.AnonymousClass4(), 500L);
            setOnClickListener(null);
            removeAllViews();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(java.lang.String str) {
        try {
            java.lang.String ad = this.b.ad();
            if (!android.text.TextUtils.isEmpty(str)) {
                this.b.p(str);
                try {
                    getMraidCampaign();
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            }
            new com.anythink.expressad.a.a(getContext(), this.c);
            this.b.p(ad);
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    public void preload() {
        if (!android.text.TextUtils.isEmpty(this.p)) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
            java.lang.String str = this.p;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str);
            windVaneWebView.loadUrl(str);
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.q)) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.z;
            java.lang.String str2 = this.q;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str2);
            windVaneWebView2.loadUrl(str2);
            return;
        }
        if (android.text.TextUtils.isEmpty(this.r)) {
            return;
        }
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView3 = this.z;
        java.lang.String str3 = this.r;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView3, "", str3, "text/html", "UTF-8", null);
        windVaneWebView3.loadDataWithBaseURL("", str3, "text/html", "UTF-8", null);
    }

    public void setCampaigns(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.y = list;
    }

    public void setCreateWebView(android.webkit.WebView webView) {
        this.B = webView;
    }

    public void setFilePath(java.lang.String str) {
        this.q = str;
    }

    public void setFileURL(java.lang.String str) {
        this.p = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        boolean contains = str.contains("play.google.com");
        setWebviewClickable(!contains);
        if (contains) {
            com.anythink.expressad.atsignalcommon.base.c cVar = new com.anythink.expressad.atsignalcommon.base.c();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
            if (windVaneWebView != null) {
                windVaneWebView.setFilter(cVar);
            }
        }
    }

    public void setHtml(java.lang.String str) {
        this.r = str;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setRewardUnitSetting(com.anythink.expressad.videocommon.e.d dVar) {
        this.x = dVar;
    }

    public void setWebViewRid(java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        try {
            this.v.setVisibility(z ? 4 : 0);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public boolean webviewGoBack() {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.z.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.z.goForward();
        return true;
    }

    public void webviewLoad(int i) {
        if (this.A == null) {
            this.A = new com.anythink.expressad.video.signal.a.j(null, this.b, this.y);
        }
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            this.A.a(cVar);
        } else {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.y;
            if (list != null && list.size() > 0) {
                this.A.a(this.y);
                if (this.y.size() == 1) {
                    this.A.a(this.y.get(0));
                }
            }
        }
        com.anythink.expressad.videocommon.e.d dVar = this.x;
        if (dVar != null) {
            this.A.a(dVar);
        }
        this.A.a(this.c);
        this.A.c(this.d);
        if (i == 1) {
            this.A.q();
        }
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.A);
        }
        com.anythink.expressad.foundation.d.c cVar2 = this.b;
        if (cVar2 != null && cVar2.H()) {
            this.v.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }
}
