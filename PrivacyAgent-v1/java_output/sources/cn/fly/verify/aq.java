package cn.fly.verify;

/* loaded from: classes.dex */
public class aq {
    private static cn.fly.verify.fs a;
    private static cn.fly.verify.fs b;

    static {
        try {
            cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
            a = fsVar;
            fsVar.a("FlyVerify_SPDB_V2", 1);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String a() {
        return a.a("udd");
    }

    public static void a(int i) {
        a.a("logSwitch", java.lang.Integer.valueOf(i));
    }

    public static void a(long j) {
        a.a("key_config_expire_time", java.lang.Long.valueOf(j));
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            a.e("udd");
        } else {
            a.a("udd", str);
        }
    }

    public static void a(java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null) {
            a.e("key_noup");
        } else {
            a.a("key_noup", arrayList);
        }
    }

    public static void a(java.util.HashMap hashMap) {
        if (hashMap == null) {
            a.e("key_config");
        } else {
            a.a("key_config", hashMap);
        }
    }

    public static void a(boolean z) {
        a.a("unknown_try", java.lang.Boolean.valueOf(z));
    }

    public static java.util.HashMap b() {
        java.lang.Object d = a.d("key_config");
        if (d != null) {
            return (java.util.HashMap) d;
        }
        return null;
    }

    public static void b(int i) {
        a.a("key_oppo_net", java.lang.Integer.valueOf(i));
    }

    public static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            u().e("cache_log");
        } else {
            u().a("cache_log", str);
        }
    }

    public static void b(boolean z) {
        a.a("key_use_wo", java.lang.Boolean.valueOf(z));
    }

    public static void c(int i) {
        a.a("key_cache_type", java.lang.Integer.valueOf(i));
    }

    public static void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a.a("key_dnc", str);
    }

    public static void c(boolean z) {
        a.a("key_auto_pre", java.lang.Boolean.valueOf(z));
    }

    public static boolean c() {
        return a.a("unknown_try", false);
    }

    public static int d() {
        return a.b("logSwitch", 1);
    }

    public static void d(int i) {
        a.a("auto_refresh", java.lang.Integer.valueOf(i));
    }

    public static void d(java.lang.String str) {
        a.a("factoryBlst", str);
    }

    public static java.lang.String e() {
        java.lang.String a2 = u().a("cache_log");
        return android.text.TextUtils.isEmpty(a2) ? "" : a2;
    }

    public static void e(int i) {
        a.a("cmSwitchData", java.lang.Integer.valueOf(i));
    }

    public static void f(int i) {
        a.a("cuSwitchData", java.lang.Integer.valueOf(i));
    }

    public static boolean f() {
        try {
            java.io.File file = new java.io.File(cn.fly.verify.ax.g().getFilesDir() + "/Pers/FlyVerify_LOG_1");
            if (!file.exists() || file.length() <= 209715200) {
                return false;
            }
            return file.delete();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String g() {
        java.lang.String a2 = a.a("key_dnc");
        return android.text.TextUtils.isEmpty(a2) ? "" : a2;
    }

    public static void g(int i) {
        a.a("subIdEnable", java.lang.Integer.valueOf(i));
    }

    public static long h() {
        return a.a("key_config_expire_time", 0L);
    }

    public static void h(int i) {
        a.a("subIdsEnable", java.lang.Integer.valueOf(i));
    }

    public static void i(int i) {
        a.a("slotsEnable", java.lang.Integer.valueOf(i));
    }

    public static boolean i() {
        return a.a("key_preverify_success", false);
    }

    public static void j(int i) {
        a.a("operatorCode", java.lang.Integer.valueOf(i));
    }

    public static boolean j() {
        return a.b("key_use_wo");
    }

    public static int k() {
        return a.c("key_cache_type");
    }

    public static void k(int i) {
        a.a("switchTimeout", java.lang.Integer.valueOf(i));
    }

    public static int l() {
        return a.b("auto_refresh", 1);
    }

    public static void l(int i) {
        a.a("ignoreSwitchError", java.lang.Integer.valueOf(i));
    }

    public static int m() {
        return a.b("cmSwitchData", 1);
    }

    public static int n() {
        return a.b("cuSwitchData", 1);
    }

    public static int o() {
        return a.b("subIdEnable", 1);
    }

    public static int p() {
        return a.b("subIdsEnable", 1);
    }

    public static int q() {
        return a.b("slotsEnable", 1);
    }

    public static java.lang.String r() {
        return a.b("factoryBlst", (java.lang.String) null);
    }

    public static int s() {
        return a.b("operatorCode", 0);
    }

    public static int t() {
        return a.b("ignoreSwitchError", 1);
    }

    private static cn.fly.verify.fs u() {
        if (b == null) {
            cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
            b = fsVar;
            fsVar.a("FlyVerify_LOG", 1);
        }
        return b;
    }
}
