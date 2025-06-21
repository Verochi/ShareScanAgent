package com.anythink.expressad.advanced.c;

/* loaded from: classes12.dex */
public final class c {
    private static java.lang.String a = "ResManager";
    private static int b = 1;

    /* renamed from: com.anythink.expressad.advanced.c.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.atsignalcommon.a.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ com.anythink.expressad.advanced.view.ATNativeAdvancedView b;
        final /* synthetic */ com.anythink.expressad.advanced.c.c.a c;

        public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.advanced.c.c.a aVar) {
            this.a = cVar;
            this.b = aTNativeAdvancedView;
            this.c = aVar;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (!this.a.s()) {
                com.anythink.expressad.advanced.a.a.a(this.a.Z());
                this.b.setH5Ready(true);
            }
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.b.setH5Ready(false);
            com.anythink.expressad.advanced.c.c.a aVar = this.c;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            this.b.setH5Ready(false);
            com.anythink.expressad.advanced.c.c.a aVar = this.c;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
            if (i == 1) {
                com.anythink.expressad.advanced.a.a.a(this.a.Z());
                this.b.setH5Ready(true);
            } else {
                this.b.setH5Ready(false);
            }
            com.anythink.expressad.advanced.c.c.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.advanced.view.ATNativeAdvancedWebview a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview, java.lang.String str) {
            this.a = aTNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.a;
            java.lang.String str = this.b;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(aTNativeAdvancedWebview, str);
            aTNativeAdvancedWebview.loadUrl(str);
        }
    }

    public interface a {
        void a();

        void b();
    }

    private static com.anythink.expressad.foundation.d.c a(com.anythink.expressad.foundation.d.c cVar) {
        if (!android.text.TextUtils.isEmpty(cVar.c()) || (!android.text.TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
        } else {
            cVar.a(false);
            cVar.b(true);
        }
        return cVar;
    }

    private static java.lang.String a(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    private static void a(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, int i) {
        a(aTNativeAdvancedView, str, cVar, str2, str3, i, null);
    }

    private static void a(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, int i, com.anythink.expressad.advanced.c.c.a aVar) {
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl(aTNativeAdvancedView.getContext(), str2, str3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(i);
        aTNativeAdvancedView.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview();
        java.lang.System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new com.anythink.expressad.advanced.c.c.AnonymousClass1(cVar, aTNativeAdvancedView, aVar));
        if (advancedNativeWebview.isDestroyed()) {
            aTNativeAdvancedView.setH5Ready(false);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.anythink.expressad.advanced.c.c.AnonymousClass2(advancedNativeWebview, str));
        }
    }

    public static boolean a(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.foundation.d.c cVar) {
        if (aTNativeAdvancedView == null) {
            return false;
        }
        boolean isVideoReady = !android.text.TextUtils.isEmpty(cVar.S()) ? aTNativeAdvancedView.isVideoReady() : true;
        if (isVideoReady && !android.text.TextUtils.isEmpty(cVar.c())) {
            isVideoReady = com.anythink.expressad.advanced.a.a.b(cVar.Z());
            cVar.Z();
        }
        if (isVideoReady && android.text.TextUtils.isEmpty(cVar.c()) && !android.text.TextUtils.isEmpty(cVar.d())) {
            isVideoReady = com.anythink.expressad.advanced.a.a.b(cVar.Z());
        }
        boolean z = (android.text.TextUtils.isEmpty(cVar.c()) && android.text.TextUtils.isEmpty(cVar.d())) ? false : isVideoReady;
        return (!z || android.text.TextUtils.isEmpty(cVar.I())) ? z : aTNativeAdvancedView.isEndCardReady();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r0 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, int i, com.anythink.expressad.advanced.c.c.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (cVar != null) {
            aTNativeAdvancedView.clearResState();
            if (android.text.TextUtils.isEmpty(cVar.S())) {
                z2 = true;
            } else {
                z2 = com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aX, str2, cVar.A());
            }
            aTNativeAdvancedView.setVideoReady(true);
            boolean z4 = z2;
            if (!android.text.TextUtils.isEmpty(cVar.I()) && !aTNativeAdvancedView.isEndCardReady() && !android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(cVar.I()))) {
                aTNativeAdvancedView.setEndCardReady(true);
            }
            if (android.text.TextUtils.isEmpty(cVar.c()) || aTNativeAdvancedView.isH5Ready()) {
                z = false;
            } else {
                java.lang.String c = com.anythink.expressad.videocommon.b.i.a().c(cVar.c());
                if (android.text.TextUtils.isEmpty(c)) {
                    z = false;
                    z4 = false;
                } else if (com.anythink.expressad.advanced.a.a.b(cVar.Z())) {
                    aTNativeAdvancedView.setH5Ready(true);
                    z = false;
                    z4 = true;
                } else {
                    a(aTNativeAdvancedView, c, cVar, str, str2, i, aVar);
                    z = true;
                }
            }
            if (!android.text.TextUtils.isEmpty(cVar.c()) || android.text.TextUtils.isEmpty(cVar.d()) || aTNativeAdvancedView.isH5Ready()) {
                z3 = z4;
            } else {
                java.lang.String a2 = a(cVar.d());
                if (!android.text.TextUtils.isEmpty(a2)) {
                    if (com.anythink.expressad.advanced.a.a.b(cVar.Z())) {
                        aTNativeAdvancedView.setH5Ready(true);
                        if (cVar.H()) {
                            aTNativeAdvancedView.setVideoReady(true);
                        }
                        z3 = true;
                    } else {
                        a(aTNativeAdvancedView, a2, cVar, str, str2, i, aVar);
                        z3 = z4;
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        if (z3 && !z) {
            aVar.a();
        }
        return z3;
    }
}
