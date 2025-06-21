package com.anythink.expressad.splash.c;

/* loaded from: classes12.dex */
public final class e {
    private static final java.lang.String a = "WebViewRenderManager";
    private boolean b;
    private boolean c;

    /* renamed from: com.anythink.expressad.splash.c.e$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.atsignalcommon.a.b {
        final /* synthetic */ com.anythink.expressad.splash.c.e.b a;
        final /* synthetic */ com.anythink.expressad.splash.view.ATSplashView b;
        final /* synthetic */ com.anythink.expressad.foundation.d.c c;

        public AnonymousClass1(com.anythink.expressad.splash.c.e.b bVar, com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar) {
            this.a = bVar;
            this.b = aTSplashView;
            this.c = cVar;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.anythink.expressad.splash.c.e.b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            }
            com.anythink.expressad.splash.c.e.a(com.anythink.expressad.splash.c.e.this);
            if (!this.c.s()) {
                this.b.setH5Ready(true);
            }
            com.anythink.expressad.splash.js.SplashJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.splash.c.e.b bVar = this.a;
            if (bVar != null) {
                bVar.a(str);
            }
            com.anythink.expressad.splash.c.e.this.a();
            this.b.setH5Ready(false);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            com.anythink.expressad.splash.c.e.b bVar = this.a;
            if (bVar != null) {
                bVar.a(sslError.toString());
            }
            com.anythink.expressad.splash.c.e.this.a();
            this.b.setH5Ready(false);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
            com.anythink.expressad.splash.c.e.b bVar = this.a;
            if (bVar != null) {
                bVar.a(i);
            }
            if (i == 1) {
                com.anythink.expressad.splash.c.e.this.b = true;
                this.b.setH5Ready(true);
            } else {
                com.anythink.expressad.splash.c.e.this.b = false;
                this.b.setH5Ready(false);
            }
        }
    }

    public static class a {
        private static final com.anythink.expressad.splash.c.e a = new com.anythink.expressad.splash.c.e((byte) 0);
    }

    public interface b {
        void a();

        void a(int i);

        void a(java.lang.String str);
    }

    public static class c {
        private java.lang.String a;
        private java.lang.String b;
        private com.anythink.expressad.foundation.d.c c;
        private java.lang.String d;
        private boolean e;
        private int f;
        private boolean g;

        private boolean g() {
            return this.g;
        }

        public final java.lang.String a() {
            return this.d;
        }

        public final void a(int i) {
            this.f = i;
        }

        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            this.c = cVar;
        }

        public final void a(java.lang.String str) {
            this.d = str;
        }

        public final void a(boolean z) {
            this.g = z;
        }

        public final java.lang.String b() {
            return this.a;
        }

        public final void b(java.lang.String str) {
            this.a = str;
        }

        public final void b(boolean z) {
            this.e = z;
        }

        public final java.lang.String c() {
            return this.b;
        }

        public final void c(java.lang.String str) {
            this.b = str;
        }

        public final com.anythink.expressad.foundation.d.c d() {
            return this.c;
        }

        public final boolean e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }
    }

    private e() {
        this.b = false;
        this.c = false;
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.splash.c.e eVar) {
        eVar.c = true;
        return true;
    }

    private static com.anythink.expressad.splash.c.e b() {
        return com.anythink.expressad.splash.c.e.a.a;
    }

    public final void a() {
        this.b = false;
        this.c = false;
    }

    public final void a(com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.splash.c.e.c cVar, com.anythink.expressad.splash.c.e.b bVar) {
        if (aTSplashView != null) {
            java.lang.String c2 = cVar.c();
            java.lang.String b2 = cVar.b();
            com.anythink.expressad.foundation.d.c d = cVar.d();
            java.lang.String a2 = cVar.a();
            boolean e = cVar.e();
            int f = cVar.f();
            com.anythink.expressad.splash.view.ATSplashWebview splashWebview = aTSplashView.getSplashWebview();
            if (splashWebview == null) {
                return;
            }
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = new com.anythink.expressad.splash.js.SplashJSBridgeImpl(aTSplashView.getContext(), b2, c2);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(d);
            splashJSBridgeImpl.setCampaignList(arrayList);
            splashJSBridgeImpl.setAllowSkip(e ? 1 : 0);
            splashJSBridgeImpl.setCountdownS(f);
            aTSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
            java.lang.String aa = android.text.TextUtils.isEmpty(d.Z()) ? d.aa() : d.Z();
            java.lang.String requestId = splashWebview.getRequestId();
            if (!android.text.TextUtils.isEmpty(requestId) && requestId.equals(aa) && (this.b || this.c)) {
                aTSplashView.setH5Ready(true);
                if (bVar != null) {
                    bVar.a(1);
                    return;
                }
                return;
            }
            a();
            splashWebview.setRequestId(aa);
            java.lang.System.currentTimeMillis();
            splashWebview.setWebViewListener(new com.anythink.expressad.splash.c.e.AnonymousClass1(bVar, aTSplashView, d));
            if (splashWebview.isDestroyed()) {
                aTSplashView.setH5Ready(false);
            } else {
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(splashWebview, a2);
                splashWebview.loadUrl(a2);
            }
        }
    }
}
