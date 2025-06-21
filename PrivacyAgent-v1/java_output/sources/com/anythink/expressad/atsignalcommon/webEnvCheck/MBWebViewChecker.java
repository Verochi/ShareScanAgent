package com.anythink.expressad.atsignalcommon.webEnvCheck;

/* loaded from: classes12.dex */
public final class MBWebViewChecker {
    private static volatile java.lang.Boolean a;
    private static volatile android.os.Handler b;
    private static java.lang.Boolean c;

    /* renamed from: com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.a == null) {
                try {
                    java.lang.Boolean unused = com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.a = java.lang.Boolean.valueOf(com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.b(this.a));
                } catch (java.lang.Exception unused2) {
                    java.lang.Boolean unused3 = com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.a = java.lang.Boolean.FALSE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(android.content.Context context) {
        android.webkit.WebView webView;
        try {
            webView = new android.webkit.WebView(context);
        } catch (java.lang.Exception unused) {
            webView = null;
        }
        return webView != null;
    }

    public static boolean isWebViewAvailable(android.content.Context context) {
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        c = bool;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            if (a == null) {
                try {
                    a = java.lang.Boolean.valueOf(b(context));
                } catch (java.lang.Exception unused) {
                    a = java.lang.Boolean.FALSE;
                }
            }
            if (a == null) {
                a = java.lang.Boolean.FALSE;
            }
            return a.booleanValue();
        }
        if (a == null && b == null) {
            android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
            b = handler;
            handler.post(new com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.AnonymousClass1(context));
        }
        if (a == null) {
            return true;
        }
        return a.booleanValue();
    }
}
