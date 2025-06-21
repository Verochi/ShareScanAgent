package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class p extends com.anythink.expressad.atsignalcommon.base.b {
    public static final java.lang.String a = "WindVaneWebViewClient";
    public static final int c = 0;
    public static final int d = 1;
    public static final java.lang.String e = "mmusdk_cache";
    public static final java.lang.String f = "1";
    public static boolean g = true;
    protected java.lang.String b;
    private int h;
    private com.anythink.expressad.atsignalcommon.windvane.e i;

    public p() {
        this.b = null;
        this.h = 0;
    }

    private p(int i) {
        this.b = null;
        this.h = i;
    }

    private static android.webkit.WebResourceResponse a(java.lang.String str) {
        android.graphics.Bitmap bitmap;
        android.graphics.Bitmap a2;
        try {
            if (!android.text.TextUtils.isEmpty(str) && com.anythink.expressad.atsignalcommon.windvane.n.d(str)) {
                com.anythink.expressad.foundation.g.d.b a3 = com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d());
                if (!com.anythink.expressad.foundation.h.t.a(str)) {
                    java.lang.String a4 = com.anythink.expressad.foundation.h.s.a(str);
                    java.io.File file = new java.io.File(a4);
                    if (a3.a(str) != null) {
                        bitmap = a3.a(str);
                    } else if (file.exists() && (a2 = com.anythink.expressad.foundation.g.d.a.a(a4)) != null) {
                        a3.a(str, a2);
                        bitmap = a2;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        return new android.webkit.WebResourceResponse(com.anythink.expressad.atsignalcommon.windvane.n.e(str), "utf-8", com.anythink.expressad.foundation.g.d.a.a(bitmap));
                    }
                }
                bitmap = null;
                if (bitmap != null) {
                    return new android.webkit.WebResourceResponse(com.anythink.expressad.atsignalcommon.windvane.n.e(str), "utf-8", com.anythink.expressad.foundation.g.d.a.a(bitmap));
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private static java.lang.String a(java.io.InputStream inputStream) {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            try {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    private void b(com.anythink.expressad.atsignalcommon.windvane.e eVar) {
        this.i = eVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.b = str;
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.i;
        if (eVar != null) {
            eVar.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(11)
    public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
        android.webkit.WebResourceResponse a2 = a(str);
        return a2 != null ? a2 : super.shouldInterceptRequest(webView, str);
    }
}
