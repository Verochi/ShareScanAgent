package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
public class OpenIdHelper {
    public static java.lang.reflect.Method a;

    public static java.lang.String a(android.content.Context context) {
        org.repackage.com.meizu.flyme.openidsdk.b d = org.repackage.com.meizu.flyme.openidsdk.b.d();
        return d.a(context.getApplicationContext(), d.a);
    }

    public static void a(boolean z) {
        org.repackage.com.meizu.flyme.openidsdk.b.d();
        org.repackage.com.meizu.flyme.openidsdk.b.f(z);
    }

    public static final boolean a() {
        android.content.Context context = null;
        try {
            if (a == null) {
                java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityThread").getMethod("currentApplication", new java.lang.Class[0]);
                a = method;
                method.setAccessible(true);
            }
            context = (android.content.Context) a.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            new java.lang.StringBuilder("ActivityThread:currentApplication --> ").append(e.toString());
        }
        if (context == null) {
            return false;
        }
        return org.repackage.com.meizu.flyme.openidsdk.b.d().h(context, false);
    }

    public static java.lang.String b(android.content.Context context) {
        org.repackage.com.meizu.flyme.openidsdk.b d = org.repackage.com.meizu.flyme.openidsdk.b.d();
        return d.a(context.getApplicationContext(), d.b);
    }

    public static java.lang.String c(android.content.Context context) {
        org.repackage.com.meizu.flyme.openidsdk.b d = org.repackage.com.meizu.flyme.openidsdk.b.d();
        return d.a(context.getApplicationContext(), d.d);
    }

    public static java.lang.String d(android.content.Context context) {
        org.repackage.com.meizu.flyme.openidsdk.b d = org.repackage.com.meizu.flyme.openidsdk.b.d();
        return d.a(context.getApplicationContext(), d.c);
    }
}
