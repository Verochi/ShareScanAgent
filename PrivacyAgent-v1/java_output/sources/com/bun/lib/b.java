package com.bun.lib;

/* loaded from: classes.dex */
public class b {
    private static android.content.Context a;

    public static android.content.Context a() {
        try {
            return (android.content.Context) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.SecurityException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(android.content.Context context) {
        synchronized (com.bun.lib.b.class) {
            a = context;
        }
    }

    public static android.content.Context b() {
        android.content.Context context;
        synchronized (com.bun.lib.b.class) {
            if (a == null) {
                a = a();
            }
            context = a;
        }
        return context;
    }
}
