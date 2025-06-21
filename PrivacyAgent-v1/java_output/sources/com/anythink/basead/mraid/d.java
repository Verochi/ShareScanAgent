package com.anythink.basead.mraid;

/* loaded from: classes12.dex */
public class d {
    public static java.lang.String a = "d";

    /* renamed from: com.anythink.basead.mraid.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.core.common.f.l b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.anythink.basead.mraid.d.a e;
        final /* synthetic */ com.anythink.basead.mraid.MraidWebView f;
        final /* synthetic */ java.lang.String g;

        /* renamed from: com.anythink.basead.mraid.d$1$1, reason: invalid class name and collision with other inner class name */
        public class C01421 extends com.anythink.expressad.atsignalcommon.a.b {
            boolean a = false;

            public C01421() {
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
                if (this.a) {
                    return;
                }
                this.a = true;
                if (com.anythink.core.common.res.d.a.equals(str)) {
                    com.anythink.basead.mraid.d.AnonymousClass1 anonymousClass1 = com.anythink.basead.mraid.d.AnonymousClass1.this;
                    java.lang.String str2 = anonymousClass1.d;
                    com.anythink.basead.mraid.d.a aVar = anonymousClass1.e;
                    if (aVar != null) {
                        aVar.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.o, com.anythink.basead.c.f.J));
                        return;
                    }
                    return;
                }
                com.anythink.expressad.mbbanner.a.a.a.a(webView);
                com.anythink.basead.mraid.d.AnonymousClass1 anonymousClass12 = com.anythink.basead.mraid.d.AnonymousClass1.this;
                com.anythink.basead.mraid.MraidWebView mraidWebView = anonymousClass12.f;
                if (mraidWebView != null) {
                    com.anythink.basead.a.b.c.a(anonymousClass12.g, mraidWebView);
                }
                com.anythink.basead.mraid.d.AnonymousClass1 anonymousClass13 = com.anythink.basead.mraid.d.AnonymousClass1.this;
                java.lang.String str3 = anonymousClass13.d;
                com.anythink.basead.mraid.d.a aVar2 = anonymousClass13.e;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
                if (this.a) {
                    return;
                }
                this.a = true;
                super.onReceivedError(webView, i, str, str2);
                com.anythink.basead.c.e a = com.anythink.basead.c.f.a("10000", i + "_" + str);
                java.lang.String str3 = com.anythink.basead.mraid.d.AnonymousClass1.this.d;
                a.c();
                com.anythink.basead.mraid.d.a aVar = com.anythink.basead.mraid.d.AnonymousClass1.this.e;
                if (aVar != null) {
                    aVar.a(a);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
                if (this.a) {
                    return;
                }
                this.a = true;
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                com.anythink.basead.c.e a = com.anythink.basead.c.f.a("10000", sslError != null ? sslError.toString() : "onReceivedSslError");
                java.lang.String str = com.anythink.basead.mraid.d.AnonymousClass1.this.d;
                a.c();
                com.anythink.basead.mraid.d.a aVar = com.anythink.basead.mraid.d.AnonymousClass1.this.e;
                if (aVar != null) {
                    aVar.a(a);
                }
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, int i, java.lang.String str, com.anythink.basead.mraid.d.a aVar, com.anythink.basead.mraid.MraidWebView mraidWebView, java.lang.String str2) {
            this.a = mVar;
            this.b = lVar;
            this.c = i;
            this.d = str;
            this.e = aVar;
            this.f = mraidWebView;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.n.c.b(this.a, this.b, this.c);
            java.lang.String str = com.anythink.basead.mraid.d.a;
            com.anythink.basead.mraid.a aVar = new com.anythink.basead.mraid.a();
            com.anythink.basead.mraid.e eVar = new com.anythink.basead.mraid.e(this.d);
            eVar.a(new com.anythink.basead.mraid.d.AnonymousClass1.C01421());
            this.f.setWebViewClient(eVar);
            this.f.setObject(aVar);
            com.anythink.basead.mraid.MraidWebView mraidWebView = this.f;
            java.lang.String str2 = this.d;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(mraidWebView, str2);
            mraidWebView.loadUrl(str2);
        }
    }

    public interface a {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public static java.lang.String a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        if (!android.text.TextUtils.isEmpty(lVar.l())) {
            return lVar.l();
        }
        if (android.text.TextUtils.isEmpty(lVar.k())) {
            return "";
        }
        java.io.File b = com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).b(mVar, lVar);
        if (b == null) {
            return com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(lVar.k(), mVar, lVar);
        }
        new java.lang.StringBuilder("loadMraidResource: html exists: ").append(b.toURI().toString());
        return b.toURI().toString();
    }

    public static void a(java.lang.String str, java.lang.String str2, com.anythink.basead.mraid.MraidWebView mraidWebView, com.anythink.basead.mraid.d.a aVar, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i) {
        if (mraidWebView == null) {
            return;
        }
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.mraid.d.AnonymousClass1(mVar, lVar, i, str2, aVar, mraidWebView, str));
    }
}
