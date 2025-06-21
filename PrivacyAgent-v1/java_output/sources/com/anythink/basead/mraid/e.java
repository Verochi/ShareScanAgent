package com.anythink.basead.mraid;

/* loaded from: classes12.dex */
public final class e extends com.anythink.expressad.atsignalcommon.base.b {
    final java.lang.String a = com.anythink.basead.mraid.e.class.getSimpleName();
    java.lang.String b;
    com.anythink.basead.mraid.b c;

    /* renamed from: com.anythink.basead.mraid.e$1, reason: invalid class name */
    public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
        public AnonymousClass1() {
        }

        private static void a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
        }
    }

    public e(java.lang.String str) {
        this.b = str;
    }

    private void a(com.anythink.basead.mraid.b bVar) {
        this.c = bVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.basead.mraid.e.AnonymousClass1());
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        com.anythink.basead.mraid.b bVar;
        try {
            if (!android.text.TextUtils.equals(str, this.b) && (bVar = this.c) != null) {
                bVar.open(str);
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
