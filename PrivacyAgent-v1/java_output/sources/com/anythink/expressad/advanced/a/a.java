package com.anythink.expressad.advanced.a;

/* loaded from: classes12.dex */
public final class a {
    private static java.util.Map<java.lang.String, java.lang.Boolean> a = new java.util.HashMap();

    private static void a() {
        a.clear();
    }

    public static void a(java.lang.String str) {
        a.put(str, java.lang.Boolean.TRUE);
    }

    public static boolean b(java.lang.String str) {
        if (a.containsKey(str)) {
            return a.get(str).booleanValue();
        }
        return false;
    }

    public static void c(java.lang.String str) {
        a.remove(str);
    }
}
