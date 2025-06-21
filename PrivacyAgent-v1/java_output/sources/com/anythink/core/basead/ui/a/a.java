package com.anythink.core.basead.ui.a;

/* loaded from: classes12.dex */
public final class a {

    /* renamed from: com.anythink.core.basead.ui.a.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.webkit.WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsBeforeUnload(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
            jsPromptResult.confirm();
            return true;
        }
    }

    /* renamed from: com.anythink.core.basead.ui.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.webkit.GeolocationPermissions.Callback a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(android.webkit.GeolocationPermissions.Callback callback, java.lang.String str) {
            this.a = callback;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            android.webkit.GeolocationPermissions.Callback callback = this.a;
            if (callback != null) {
                callback.invoke(this.b, false, false);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.anythink.core.basead.ui.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.webkit.GeolocationPermissions.Callback a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(android.webkit.GeolocationPermissions.Callback callback, java.lang.String str) {
            this.a = callback;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            android.webkit.GeolocationPermissions.Callback callback = this.a;
            if (callback != null) {
                callback.invoke(this.b, true, false);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    private static void a() {
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        if (com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
            cookieManager.setAcceptCookie(true);
            android.webkit.CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        android.webkit.CookieManager.setAcceptFileSchemeCookies(false);
        cookieManager.removeSessionCookies(null);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    public static void a(android.content.Context context) {
        android.webkit.CookieSyncManager.createInstance(context);
        android.webkit.CookieSyncManager.getInstance().startSync();
    }

    public static void a(android.content.Context context, java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
        try {
            com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
            if (b != null) {
                if (b.onGeolocationPermissionsShowPrompt(str, callback)) {
                    return;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", android.os.Process.myPid(), android.os.Process.myUid()) == 0) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context, com.anythink.core.common.o.i.a(context, "system_dialog", com.anythink.expressad.foundation.h.i.e));
                builder.setMessage(context.getString(com.anythink.core.common.o.i.a(context, "location_ask_title", com.anythink.expressad.foundation.h.i.g))).setCancelable(true).setPositiveButton(context.getString(com.anythink.core.common.o.i.a(context, "location_allow", com.anythink.expressad.foundation.h.i.g)), new com.anythink.core.basead.ui.a.a.AnonymousClass3(callback, str)).setNegativeButton(context.getString(com.anythink.core.common.o.i.a(context, "location_deny", com.anythink.expressad.foundation.h.i.g)), new com.anythink.core.basead.ui.a.a.AnonymousClass2(callback, str));
                builder.create().show();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(android.webkit.WebView webView) {
        webView.setWebChromeClient(new com.anythink.core.basead.ui.a.a.AnonymousClass1());
    }

    public static void a(android.webkit.WebView webView, android.content.Context context, com.anythink.core.basead.ui.web.b bVar) {
        android.webkit.WebSettings settings = webView.getSettings();
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setMixedContentMode(1);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            java.lang.reflect.Method declaredMethod = android.webkit.WebSettings.class.getDeclaredMethod(com.anythink.core.common.o.d.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.reflect.Method declaredMethod2 = android.webkit.WebSettings.class.getDeclaredMethod("setDisplayZoomControls", java.lang.Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, java.lang.Boolean.FALSE);
        } catch (java.lang.Exception unused2) {
        }
        settings.setDatabaseEnabled(true);
        java.lang.String path = context.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        webView.setWebViewClient(new com.anythink.core.basead.ui.web.a(bVar));
    }

    public static void a(android.webkit.WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "");
            webView.loadUrl("");
        }
        webView.onPause();
    }

    private static void b(android.webkit.WebView webView) {
        android.webkit.CookieManager.getInstance().setAcceptThirdPartyCookies(webView, com.anythink.core.common.b.r.a(webView.getContext()).b());
    }
}
