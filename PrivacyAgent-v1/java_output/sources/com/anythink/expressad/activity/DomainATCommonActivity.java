package com.anythink.expressad.activity;

/* loaded from: classes12.dex */
public class DomainATCommonActivity extends android.app.Activity {
    private static final java.lang.String b = "ATCommonActivity";
    private com.anythink.expressad.foundation.d.c c;
    private com.anythink.expressad.foundation.webview.BrowserView d;
    java.lang.String a = "";
    private com.anythink.expressad.foundation.webview.BrowserView.a e = new com.anythink.expressad.activity.DomainATCommonActivity.AnonymousClass1();

    /* renamed from: com.anythink.expressad.activity.DomainATCommonActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.webview.BrowserView.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void a() {
            com.anythink.expressad.activity.DomainATCommonActivity.this.finish();
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final boolean a(android.webkit.WebView webView, java.lang.String str) {
            if (com.anythink.expressad.foundation.h.s.a.a(str) && com.anythink.expressad.foundation.h.s.a.a(com.anythink.expressad.activity.DomainATCommonActivity.this, str, null)) {
                com.anythink.expressad.activity.DomainATCommonActivity.this.finish();
            }
            return com.anythink.expressad.activity.DomainATCommonActivity.this.a(webView, str);
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void b() {
        }
    }

    private void a() {
        java.lang.String stringExtra = getIntent().getStringExtra("url");
        this.a = stringExtra;
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            android.widget.Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.c = (com.anythink.expressad.foundation.d.c) getIntent().getSerializableExtra("mvcommon");
        com.anythink.expressad.foundation.webview.BrowserView browserView = new com.anythink.expressad.foundation.webview.BrowserView(this, this.c);
        this.d = browserView;
        browserView.setListener(this.e);
        this.d.loadUrl(this.a);
        com.anythink.expressad.foundation.webview.BrowserView browserView2 = this.d;
        if (browserView2 != null) {
            setContentView(browserView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(r8, r2);
        r8.loadUrl(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078 A[Catch: all -> 0x009b, TryCatch #2 {all -> 0x009b, blocks: (B:28:0x006c, B:30:0x0078, B:32:0x0086, B:37:0x0094), top: B:27:0x006c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(android.webkit.WebView webView, java.lang.String str) {
        boolean z;
        android.content.Intent parseUri;
        java.lang.String stringExtra;
        java.lang.String str2;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            android.net.Uri parse = android.net.Uri.parse(str);
            boolean z2 = true;
            if (!parse.getScheme().equals(com.alipay.sdk.m.l.a.q) && !parse.getScheme().equals("https")) {
                z = false;
                if (z && parse.getScheme().equals(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                    parseUri = android.content.Intent.parseUri(str, 1);
                    try {
                        str2 = parseUri.getPackage();
                        if (!android.text.TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.addCategory("android.intent.category.BROWSABLE");
                            parseUri.setComponent(null);
                            parseUri.setSelector(null);
                            parseUri.setFlags(268435456);
                            startActivityForResult(parseUri, 0);
                            finish();
                            return true;
                        }
                    } catch (java.lang.Throwable th) {
                        th.getMessage();
                    }
                    try {
                        stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!android.text.TextUtils.isEmpty(stringExtra)) {
                            android.net.Uri parse2 = android.net.Uri.parse(str);
                            if (!parse2.getScheme().equals(com.alipay.sdk.m.l.a.q) && !parse2.getScheme().equals("https")) {
                                z2 = false;
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th2.getMessage();
                    }
                }
                return false;
            }
            z = true;
            if (z) {
                return false;
            }
            parseUri = android.content.Intent.parseUri(str, 1);
            str2 = parseUri.getPackage();
            if (!android.text.TextUtils.isEmpty(str2)) {
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.setFlags(268435456);
                startActivityForResult(parseUri, 0);
                finish();
                return true;
            }
            stringExtra = parseUri.getStringExtra("browser_fallback_url");
            if (!android.text.TextUtils.isEmpty(stringExtra)) {
            }
            return false;
        } catch (java.lang.Throwable th3) {
            th3.getMessage();
            return false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        if (com.anythink.expressad.foundation.b.a.b().d() == null) {
            com.anythink.expressad.foundation.b.a.b().a(getApplicationContext());
        }
        java.lang.String stringExtra = getIntent().getStringExtra("url");
        this.a = stringExtra;
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            android.widget.Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.c = (com.anythink.expressad.foundation.d.c) getIntent().getSerializableExtra("mvcommon");
        com.anythink.expressad.foundation.webview.BrowserView browserView = new com.anythink.expressad.foundation.webview.BrowserView(this, this.c);
        this.d = browserView;
        browserView.setListener(this.e);
        this.d.loadUrl(this.a);
        com.anythink.expressad.foundation.webview.BrowserView browserView2 = this.d;
        if (browserView2 != null) {
            setContentView(browserView2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.anythink.expressad.foundation.webview.BrowserView browserView = this.d;
        if (browserView != null) {
            browserView.destroy();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
