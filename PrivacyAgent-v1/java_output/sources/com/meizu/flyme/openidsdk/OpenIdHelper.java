package com.meizu.flyme.openidsdk;

/* loaded from: classes23.dex */
public class OpenIdHelper {
    public static java.lang.String a(android.content.Context context) {
        com.meizu.flyme.openidsdk.b a = com.meizu.flyme.openidsdk.b.a();
        return a.a(context.getApplicationContext(), a.c);
    }

    public static final boolean a() {
        android.content.Context context = null;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityThread").getMethod("currentApplication", new java.lang.Class[0]);
            method.setAccessible(true);
            context = (android.content.Context) method.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ActivityThread:currentApplication --> ");
            sb.append(e.toString());
        }
        if (context == null) {
            return false;
        }
        return com.meizu.flyme.openidsdk.b.a().a(context, false);
    }

    public static java.lang.String b(android.content.Context context) {
        com.meizu.flyme.openidsdk.b a = com.meizu.flyme.openidsdk.b.a();
        return a.a(context.getApplicationContext(), a.b);
    }

    public static java.lang.String c(android.content.Context context) {
        com.meizu.flyme.openidsdk.b a = com.meizu.flyme.openidsdk.b.a();
        return a.a(context.getApplicationContext(), a.a);
    }

    public static java.lang.String d(android.content.Context context) {
        com.meizu.flyme.openidsdk.b a = com.meizu.flyme.openidsdk.b.a();
        return a.a(context.getApplicationContext(), a.d);
    }
}
