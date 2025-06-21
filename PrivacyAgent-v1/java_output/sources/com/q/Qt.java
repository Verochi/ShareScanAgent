package com.q;

/* loaded from: classes19.dex */
public class Qt {
    private static java.lang.String bts = "2023-08-23 12:47:44";

    public static boolean _s() {
        return false;
    }

    @java.lang.Deprecated
    public static void appHidden(android.content.Context context) {
    }

    @java.lang.Deprecated
    public static void appStart(android.content.Context context) {
    }

    public static void init(android.app.Application application, java.lang.String str, java.lang.String str2) {
        init(application, str, str2, null);
    }

    public static void init(android.app.Application application, java.lang.String str, java.lang.String str2, com.sijla.callback.QtCallBack qtCallBack) {
        init(application, str, str2, application.getPackageName(), true, qtCallBack);
    }

    public static void init(android.app.Application application, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sijla.callback.QtCallBack qtCallBack) {
        init(application, str, str2, str3, true, qtCallBack);
    }

    public static void init(android.app.Application application, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, com.sijla.callback.QtCallBack qtCallBack) {
        com.sijla.a.a.a(new com.q.c(application, z, str, str2, str3, qtCallBack));
    }

    public static void init(android.app.Application application, java.lang.String str, java.lang.String str2, boolean z, com.sijla.callback.QtCallBack qtCallBack) {
        init(application, str, str2, application.getPackageName(), z, qtCallBack);
    }

    public static void isAllowNetworkConnections(android.content.Context context, boolean z) {
    }

    public static void onEvent(android.content.Context context, java.lang.String str) {
        com.sijla.h.f.a(context, str, "");
    }

    public static void onEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.sijla.h.f.a(context, str, str2);
    }

    public static void saveAndroidId(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.sijla.a.a.a(new com.q.a(context, str));
    }

    public static void saveOAID(android.content.Context context, java.lang.String str) {
        com.sijla.a.a.a(new com.q.b(context, str));
    }

    public static void setAppkey(android.content.Context context, java.lang.String str) {
        com.sijla.b.g.a(str);
    }

    public static void setImei(android.content.Context context, java.lang.String str) {
        com.sijla.h.a.a.a(context, str);
    }

    public static void showLog(boolean z) {
        com.sijla.b.g.a(z);
    }
}
