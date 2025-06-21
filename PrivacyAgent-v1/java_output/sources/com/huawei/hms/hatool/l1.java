package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class l1 {
    public static com.huawei.hms.hatool.j1 a;

    public static synchronized com.huawei.hms.hatool.j1 a() {
        com.huawei.hms.hatool.j1 j1Var;
        synchronized (com.huawei.hms.hatool.l1.class) {
            if (a == null) {
                a = com.huawei.hms.hatool.o1.c().b();
            }
            j1Var = a;
        }
        return j1Var;
    }

    public static void a(int i, java.lang.String str, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        if (a() == null || !com.huawei.hms.hatool.w0.b().a()) {
            return;
        }
        if (i == 1 || i == 0) {
            a.a(i, str, linkedHashMap);
            return;
        }
        com.huawei.hms.hatool.y.d("hmsSdk", "Data type no longer collects range.type: " + i);
    }

    @java.lang.Deprecated
    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (a() != null) {
            a.a(context, str, str2);
        }
    }

    public static boolean b() {
        return com.huawei.hms.hatool.o1.c().a();
    }

    public static void c() {
        if (a() == null || !com.huawei.hms.hatool.w0.b().a()) {
            return;
        }
        a.a(-1);
    }
}
