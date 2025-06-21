package com.bun.miitmdid.c.c;

/* loaded from: classes.dex */
public class a {
    public static com.bun.miitmdid.c.a a() {
        return b() ? com.bun.miitmdid.c.a.FREEMEOS : c() ? com.bun.miitmdid.c.a.SSUIOS : com.bun.miitmdid.c.a.UNSUPPORT;
    }

    private static boolean b() {
        java.lang.String a = com.bun.lib.sysParamters.a("ro.build.freeme.label", "");
        if (android.text.TextUtils.isEmpty(a)) {
            return false;
        }
        return a.equalsIgnoreCase("FreemeOS");
    }

    private static boolean c() {
        return !android.text.TextUtils.isEmpty(com.bun.lib.sysParamters.a("ro.ssui.product", ""));
    }
}
