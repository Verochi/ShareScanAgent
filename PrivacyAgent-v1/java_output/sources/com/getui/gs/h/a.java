package com.getui.gs.h;

/* loaded from: classes22.dex */
public final class a {
    public static java.lang.String a = "GsIdo-DebugMode";
    public static boolean b;

    public static void a(java.lang.String str) {
        if (b) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("--- ");
            sb.append(d(str));
            sb.append(" ---");
        }
        com.getui.gs.h.b.a.a.a.d(d(str));
    }

    public static void b(java.lang.String str) {
        if (b) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("--- ");
            sb.append(d(str));
            sb.append(" ---");
        }
    }

    public static void c(java.lang.String str) {
        if (b) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("--- ");
            sb.append(d(str));
            sb.append(" ---");
        }
    }

    private static java.lang.String d(java.lang.String str) {
        return str == null ? com.igexin.push.core.b.m : str;
    }
}
