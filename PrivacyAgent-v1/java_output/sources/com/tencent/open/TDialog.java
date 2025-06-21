package com.tencent.open;

/* loaded from: classes19.dex */
public class TDialog extends com.tencent.open.b {
    static final android.widget.FrameLayout.LayoutParams c = new android.widget.FrameLayout.LayoutParams(-1, -1);
    static android.widget.Toast d = null;
    private static java.lang.ref.WeakReference<android.app.ProgressDialog> f;
    private java.lang.ref.WeakReference<android.content.Context> e;
    private java.lang.String g;
    private com.tencent.open.TDialog.OnTimeListener h;
    private com.tencent.tauth.IUiListener i;
    private android.widget.FrameLayout j;
    private com.tencent.open.b.b k;
    private android.os.Handler l;
    private boolean m;
    private com.tencent.connect.auth.QQToken n;

    /* renamed from: com.tencent.open.TDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.View decorView;
            android.view.View childAt;
            android.view.Window window = com.tencent.open.TDialog.this.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((android.view.ViewGroup) decorView).getChildAt(0)) == null) {
                return;
            }
            childAt.setPadding(0, 0, 0, 0);
        }
    }

    public class FbWebViewClient extends android.webkit.WebViewClient {
        private FbWebViewClient() {
        }

        public /* synthetic */ FbWebViewClient(com.tencent.open.TDialog tDialog, com.tencent.open.TDialog.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.TDialog.this.k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.tencent.open.log.SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.tencent.open.TDialog.this.h.onError(new com.tencent.tauth.UiError(i, str, str2));
            if (com.tencent.open.TDialog.this.e != null && com.tencent.open.TDialog.this.e.get() != null) {
                android.widget.Toast.makeText((android.content.Context) com.tencent.open.TDialog.this.e.get(), "网络连接异常或系统错误", 0).show();
            }
            com.tencent.open.TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.tencent.open.log.SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.h.a().a((android.content.Context) com.tencent.open.TDialog.this.e.get(), "auth://tauth.qq.com/"))) {
                com.tencent.open.TDialog.this.h.onComplete(com.tencent.open.utils.l.c(str));
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                com.tencent.open.TDialog.this.h.onCancel();
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) && !str.endsWith(com.anythink.china.common.a.a.g)) {
                return str.startsWith("auth://progress");
            }
            try {
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) ? android.net.Uri.parse(android.net.Uri.decode(str.substring(11))) : android.net.Uri.parse(android.net.Uri.decode(str)));
                intent.addFlags(268435456);
                if (com.tencent.open.TDialog.this.e != null && com.tencent.open.TDialog.this.e.get() != null) {
                    ((android.content.Context) com.tencent.open.TDialog.this.e.get()).startActivity(intent);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public class JsListener extends com.tencent.open.a.b {
        private JsListener() {
        }

        public /* synthetic */ JsListener(com.tencent.open.TDialog tDialog, com.tencent.open.TDialog.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onAddShare(java.lang.String str) {
            com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(java.lang.String str) {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            com.tencent.open.TDialog.this.l.obtainMessage(2, str).sendToTarget();
            com.tencent.open.TDialog.this.dismiss();
        }

        public void onCancelAddShare(java.lang.String str) {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(com.anythink.expressad.d.a.b.dO);
        }

        public void onCancelInvite() {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(1, str).sendToTarget();
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            com.tencent.open.TDialog.this.dismiss();
        }

        public void onInvite(java.lang.String str) {
            onComplete(str);
        }

        public void onLoad(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(3, str).sendToTarget();
        }
    }

    public static class OnTimeListener extends com.tencent.tauth.DefaultUiListener {
        java.lang.String a;
        java.lang.String b;
        private java.lang.ref.WeakReference<android.content.Context> c;
        private java.lang.String d;
        private com.tencent.tauth.IUiListener e;

        public OnTimeListener(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tauth.IUiListener iUiListener) {
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

    public class THandler extends android.os.Handler {
        private com.tencent.open.TDialog.OnTimeListener b;

        public THandler(com.tencent.open.TDialog.OnTimeListener onTimeListener, android.os.Looper looper) {
            super(looper);
            this.b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
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
                if (com.tencent.open.TDialog.this.e == null || com.tencent.open.TDialog.this.e.get() == null) {
                    return;
                }
                com.tencent.open.TDialog.c((android.content.Context) com.tencent.open.TDialog.this.e.get(), (java.lang.String) message.obj);
                return;
            }
            if (i != 5 || com.tencent.open.TDialog.this.e == null || com.tencent.open.TDialog.this.e.get() == null) {
                return;
            }
            com.tencent.open.TDialog.d((android.content.Context) com.tencent.open.TDialog.this.e.get(), (java.lang.String) message.obj);
        }
    }

    public TDialog(android.content.Context context, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, com.tencent.connect.auth.QQToken qQToken) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar);
        this.m = false;
        this.n = null;
        this.e = new java.lang.ref.WeakReference<>(context);
        this.g = str2;
        this.h = new com.tencent.open.TDialog.OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new com.tencent.open.TDialog.THandler(this.h, context.getMainLooper());
        this.i = iUiListener;
        this.n = qQToken;
    }

    private void a() {
        new android.widget.TextView(this.e.get()).setText("test");
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.e.get());
        this.j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.j.addView(this.k);
        setContentView(this.j);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new com.tencent.open.TDialog.FbWebViewClient(this, null));
        this.k.setWebChromeClient(this.b);
        this.k.clearFormData();
        android.webkit.WebSettings settings = this.k.getSettings();
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
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new com.tencent.open.TDialog.JsListener(this, null), "sdk_js_if");
        com.tencent.open.b.b bVar = this.k;
        java.lang.String str = this.g;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(bVar, str);
        bVar.loadUrl(str);
        this.k.setLayoutParams(c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject d2 = com.tencent.open.utils.l.d(str);
            int i = d2.getInt("type");
            java.lang.String string = d2.getString("msg");
            if (i == 0) {
                android.widget.Toast toast = d;
                if (toast == null) {
                    d = android.widget.Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    d.setText(string);
                    d.setDuration(0);
                }
                d.show();
                return;
            }
            if (i == 1) {
                android.widget.Toast toast2 = d;
                if (toast2 == null) {
                    d = android.widget.Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    d.setText(string);
                    d.setDuration(1);
                }
                d.show();
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
            int i = d2.getInt("action");
            java.lang.String string = d2.getString("msg");
            if (i == 1) {
                java.lang.ref.WeakReference<android.app.ProgressDialog> weakReference = f;
                if (weakReference != null && weakReference.get() != null) {
                    f.get().setMessage(string);
                    if (!f.get().isShowing()) {
                        f.get().show();
                    }
                }
                android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(context);
                progressDialog.setMessage(string);
                f = new java.lang.ref.WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i == 0) {
                java.lang.ref.WeakReference<android.app.ProgressDialog> weakReference2 = f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f.get().isShowing()) {
                    f.get().dismiss();
                    f = null;
                }
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.open.b
    public void a(java.lang.String str) {
        com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.k, str);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.tencent.open.TDialog.OnTimeListener onTimeListener = this.h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.open.TDialog.AnonymousClass1());
        b();
    }
}
