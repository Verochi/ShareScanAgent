package com.tencent.open;

/* loaded from: classes19.dex */
public class c extends com.tencent.open.b implements com.tencent.open.b.a.InterfaceC0501a {
    static android.widget.Toast c;
    private java.lang.String d;
    private com.tencent.tauth.IUiListener e;
    private com.tencent.open.c.C0502c f;
    private android.os.Handler g;
    private com.tencent.open.b.a h;
    private com.tencent.open.b.b i;
    private java.lang.ref.WeakReference<android.content.Context> j;
    private int k;

    public class a extends android.webkit.WebViewClient {
        private a() {
        }

        public /* synthetic */ a(com.tencent.open.c cVar, com.tencent.open.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.c.this.i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.tencent.open.log.SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.tencent.open.c.this.f.onError(new com.tencent.tauth.UiError(i, str, str2));
            if (com.tencent.open.c.this.j != null && com.tencent.open.c.this.j.get() != null) {
                android.widget.Toast.makeText((android.content.Context) com.tencent.open.c.this.j.get(), "网络连接异常或系统错误", 0).show();
            }
            com.tencent.open.c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.tencent.open.log.SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.h.a().a((android.content.Context) com.tencent.open.c.this.j.get(), "auth://tauth.qq.com/"))) {
                com.tencent.open.c.this.f.onComplete(com.tencent.open.utils.l.c(str));
                com.tencent.open.c.this.dismiss();
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                com.tencent.open.c.this.f.onCancel();
                com.tencent.open.c.this.dismiss();
                return true;
            }
            if (!str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                return false;
            }
            com.tencent.open.c.this.dismiss();
            return true;
        }
    }

    public class b extends com.tencent.open.a.b {
        private b() {
        }

        public /* synthetic */ b(com.tencent.open.c cVar, com.tencent.open.c.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: com.tencent.open.c$c, reason: collision with other inner class name */
    public static class C0502c extends com.tencent.tauth.DefaultUiListener {
        java.lang.String a;
        java.lang.String b;
        private java.lang.ref.WeakReference<android.content.Context> c;
        private java.lang.String d;
        private com.tencent.tauth.IUiListener e;

        public C0502c(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tauth.IUiListener iUiListener) {
            this.c = new java.lang.ref.WeakReference<>(context);
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(java.lang.String str) {
            try {
                onComplete(com.tencent.open.utils.l.d(str));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                onError(new com.tencent.tauth.UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            com.tencent.open.a.g.a().a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            java.lang.String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            com.tencent.open.a.g a = com.tencent.open.a.g.a();
            a.a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }
    }

    public class d extends android.os.Handler {
        private com.tencent.open.c.C0502c b;

        public d(com.tencent.open.c.C0502c c0502c, android.os.Looper looper) {
            super(looper);
            this.b = c0502c;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.open.log.SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.b.a((java.lang.String) message.obj);
                return;
            }
            if (i == 2) {
                this.b.onCancel();
                return;
            }
            if (i == 3) {
                if (com.tencent.open.c.this.j == null || com.tencent.open.c.this.j.get() == null) {
                    return;
                }
                com.tencent.open.c.c((android.content.Context) com.tencent.open.c.this.j.get(), (java.lang.String) message.obj);
                return;
            }
            if (i != 5 || com.tencent.open.c.this.j == null || com.tencent.open.c.this.j.get() == null) {
                return;
            }
            com.tencent.open.c.d((android.content.Context) com.tencent.open.c.this.j.get(), (java.lang.String) message.obj);
        }
    }

    public c(android.content.Context context, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, com.tencent.connect.auth.QQToken qQToken) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar);
        this.j = new java.lang.ref.WeakReference<>(context);
        this.d = str2;
        this.f = new com.tencent.open.c.C0502c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.g = new com.tencent.open.c.d(this.f, context.getMainLooper());
        this.e = iUiListener;
        this.k = java.lang.Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        com.tencent.open.log.SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    private void b() {
        com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.j.get());
        this.h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.h.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.j.get());
        this.i = bVar;
        bVar.setBackgroundColor(0);
        this.i.setBackgroundDrawable(null);
        try {
            android.view.View.class.getMethod("setLayerType", java.lang.Integer.TYPE, android.graphics.Paint.class).invoke(this.i, 1, new android.graphics.Paint());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.i.setLayoutParams(layoutParams);
        this.h.addView(this.i);
        this.h.a(this);
        setContentView(this.h);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.i.setVerticalScrollBarEnabled(false);
        this.i.setHorizontalScrollBarEnabled(false);
        this.i.setWebViewClient(new com.tencent.open.c.a(this, null));
        this.i.setWebChromeClient(this.b);
        this.i.clearFormData();
        android.webkit.WebSettings settings = this.i.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new com.tencent.open.c.b(this, null), "sdk_js_if");
        this.i.clearView();
        com.tencent.open.b.b bVar = this.i;
        java.lang.String str = this.d;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(bVar, str);
        bVar.loadUrl(str);
        this.i.getSettings().setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject d2 = com.tencent.open.utils.l.d(str);
            int i = d2.getInt("type");
            java.lang.String string = d2.getString("msg");
            if (i == 0) {
                android.widget.Toast toast = c;
                if (toast == null) {
                    c = android.widget.Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    c.setText(string);
                    c.setDuration(0);
                }
                c.show();
                return;
            }
            if (i == 1) {
                android.widget.Toast toast2 = c;
                if (toast2 == null) {
                    c = android.widget.Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    c.setText(string);
                    c.setDuration(1);
                }
                c.show();
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            org.json.JSONObject d2 = com.tencent.open.utils.l.d(str);
            d2.getInt("action");
            d2.getString("msg");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.open.b.a.InterfaceC0501a
    public void a() {
        this.i.getLayoutParams().height = this.k;
        com.tencent.open.log.SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b.a.InterfaceC0501a
    public void a(int i) {
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            if (i >= this.k || 2 != this.j.get().getResources().getConfiguration().orientation) {
                this.i.getLayoutParams().height = this.k;
            } else {
                this.i.getLayoutParams().height = i;
            }
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.b
    public void a(java.lang.String str) {
        com.tencent.open.log.SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.i, str);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }
}
