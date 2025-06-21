package com.alipay.sdk.m.x;

/* loaded from: classes.dex */
public abstract class c extends android.widget.FrameLayout {
    public static final java.lang.String c = "v1";
    public static final java.lang.String d = "v2";
    public android.app.Activity a;
    public final java.lang.String b;

    public c(android.app.Activity activity, java.lang.String str) {
        super(activity);
        this.a = activity;
        this.b = str;
    }

    public static void a(android.webkit.WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public abstract void a(java.lang.String str);

    public void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        android.webkit.CookieSyncManager.createInstance(this.a.getApplicationContext()).sync();
        android.webkit.CookieManager.getInstance().setCookie(str, str2);
        android.webkit.CookieSyncManager.getInstance().sync();
    }

    public boolean a() {
        return c.equals(this.b);
    }

    public abstract boolean b();

    public abstract void c();
}
