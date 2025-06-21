package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class f {
    public static final java.lang.String a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static boolean f;
    public static final boolean g;
    public static final boolean h;
    private static int i;

    static {
        int i2;
        java.lang.String str = com.xiaomi.push.i.a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        a = str;
        boolean contains = str.contains("2A2FE0D7");
        b = contains;
        c = contains || "DEBUG".equalsIgnoreCase(str);
        d = "LOGABLE".equalsIgnoreCase(str);
        e = str.contains("YY");
        f = str.equalsIgnoreCase("TEST");
        g = "BETA".equalsIgnoreCase(str);
        h = str.startsWith("RC");
        i = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else {
            if (!str.equalsIgnoreCase("ONEBOX")) {
                i = 1;
                return;
            }
            i2 = 3;
        }
        i = i2;
    }

    public static void a(int i2) {
        i = i2;
    }

    public static boolean a() {
        return i == 2;
    }

    public static boolean b() {
        return i == 3;
    }

    public static int c() {
        return i;
    }
}
