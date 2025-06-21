package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class r {
    public static boolean a = true;

    public static void a(java.lang.String str) {
        if (a) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("--- ");
            a2.append(str == null ? com.igexin.push.core.b.m : str);
            a2.append(" ---");
        }
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        com.zx.a.I8b7.r2.a(str);
    }

    public static void b(java.lang.String str) {
        if (a) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("--- ");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            a2.append(str);
            a2.append(" ---");
        }
    }
}
