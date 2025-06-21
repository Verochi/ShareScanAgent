package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cm {
    public static final java.lang.String a = "9.3711";
    public static final java.lang.String b = "";
    public static final java.lang.Boolean c;
    public static final java.lang.Boolean d;
    public static final java.lang.String e = "9.3711";
    public static final int f = 5000;
    public static final java.lang.Boolean g;
    public static final boolean h = false;
    public static java.lang.String i;

    static {
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        c = bool;
        d = java.lang.Boolean.TRUE;
        g = bool;
        i = "adserv_0";
    }

    public static java.lang.String a() {
        return i;
    }

    public static double b() {
        try {
            return java.lang.Double.parseDouble("9.3711");
        } catch (java.lang.Exception unused) {
            return 0.0d;
        }
    }

    public static double c() {
        try {
            return java.lang.Double.parseDouble("9.3711");
        } catch (java.lang.Exception unused) {
            return 0.0d;
        }
    }

    public static int d() {
        try {
            return java.lang.Integer.valueOf("9.3711".split("\\.")[0]).intValue();
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }
}
