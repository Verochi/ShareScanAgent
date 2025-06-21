package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class an {
    private static final java.lang.String a = "PluginLoader";
    private static java.lang.ClassLoader b;

    public interface a {
        void a();
    }

    public static android.view.View a(android.content.Context context) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            return vVar.a(context);
        }
        return null;
    }

    public static java.lang.ClassLoader a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader) {
        com.baidu.mobads.sdk.internal.u uVar;
        if (!a()) {
            return classLoader;
        }
        if (b == null && (uVar = (com.baidu.mobads.sdk.internal.u) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.a).a()) != null) {
            b = uVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return b;
    }

    public static void a(double d, com.baidu.mobads.sdk.internal.am.b bVar, com.baidu.mobads.sdk.internal.an.a aVar) {
        com.baidu.mobads.sdk.internal.u uVar = (com.baidu.mobads.sdk.internal.u) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.a).a();
        if (uVar != null) {
            uVar.startLoadRemotePhp(d, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void a(int i) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(i);
        }
    }

    public static void a(int i, int i2) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.b(i, i2);
        }
    }

    public static void a(int i, boolean z) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(i, z);
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(context, str);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(context, str, str2);
        }
    }

    public static void a(com.baidu.mobads.sdk.internal.w wVar) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(wVar);
        }
    }

    public static void a(boolean z) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(z);
        }
    }

    public static void a(boolean z, int i, int i2, int i3) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(z, i, i2, i3);
        }
    }

    public static boolean a() {
        return com.baidu.mobads.sdk.internal.cm.d.booleanValue();
    }

    public static void b() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.b();
        }
    }

    public static void b(int i) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.b(i);
        }
    }

    public static void b(int i, int i2) {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a(i, i2);
        }
    }

    public static android.app.Activity c() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            return vVar.c();
        }
        return null;
    }

    public static boolean d() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            return vVar.d();
        }
        return false;
    }

    public static boolean e() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            return vVar.e();
        }
        return false;
    }

    public static boolean f() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            return vVar.f();
        }
        com.baidu.mobads.sdk.internal.ay.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.g();
        }
    }

    public static void h() {
        com.baidu.mobads.sdk.internal.v vVar = (com.baidu.mobads.sdk.internal.v) com.baidu.mobads.sdk.internal.c.a().a(com.baidu.mobads.sdk.internal.c.a.b).a();
        if (vVar != null) {
            vVar.a();
        }
    }
}
