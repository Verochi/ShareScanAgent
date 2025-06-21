package com.sina.weibo.sdk;

/* loaded from: classes19.dex */
public final class a {
    private static boolean a;
    private static com.sina.weibo.sdk.auth.AuthInfo b;

    public static com.sina.weibo.sdk.auth.AuthInfo a() {
        if (a) {
            return b;
        }
        throw new java.lang.RuntimeException("please init sdk before use it. Wb.install()");
    }

    public static void a(android.content.Context context, com.sina.weibo.sdk.auth.AuthInfo authInfo) {
        if (a) {
            return;
        }
        if (authInfo == null) {
            throw new java.lang.RuntimeException("authInfo must not be null.");
        }
        b = authInfo;
        com.sina.weibo.sdk.a.a.b().b(context, authInfo.getAppKey());
        a = true;
    }

    public static boolean a(android.content.Context context) {
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices;
        android.content.Intent intent = new android.content.Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        return (context == null || (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) == null || queryIntentServices.isEmpty()) ? false : true;
    }

    public static boolean b(android.content.Context context) {
        com.sina.weibo.sdk.c.a.C0466a c;
        return a(context) && (c = com.sina.weibo.sdk.c.a.c(context)) != null && c.am >= 10772;
    }
}
