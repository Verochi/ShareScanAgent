package com.umeng.commonsdk.config;

/* loaded from: classes19.dex */
public class FieldManager {
    private static final java.lang.String a = "cfgfd";
    private static com.umeng.commonsdk.config.b b = com.umeng.commonsdk.config.b.b();
    private static boolean c = false;
    private static java.lang.Object d = new java.lang.Object();

    public static class a {
        private static final com.umeng.commonsdk.config.FieldManager a = new com.umeng.commonsdk.config.FieldManager(null);

        private a() {
        }
    }

    private FieldManager() {
    }

    public /* synthetic */ FieldManager(com.umeng.commonsdk.config.FieldManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private static android.util.Pair<java.lang.Long, java.lang.String> a(java.lang.String str) {
        android.util.Pair<java.lang.Long, java.lang.String> pair = new android.util.Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            java.lang.String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = java.lang.Long.parseLong(split[0]);
                return new android.util.Pair<>(java.lang.Long.valueOf(parseLong), split[1]);
            } catch (java.lang.Throwable unused) {
            }
        }
        return pair;
    }

    public static com.umeng.commonsdk.config.FieldManager a() {
        return com.umeng.commonsdk.config.FieldManager.a.a;
    }

    public static boolean allow(java.lang.String str) {
        synchronized (d) {
            if (!c) {
                return false;
            }
            return com.umeng.commonsdk.config.b.a(str);
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (d) {
            z = c;
        }
        return z;
    }

    public void a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2 = "1001@3749699455,2130669566,262139,1983";
        java.lang.String[] strArr = {com.umeng.commonsdk.config.d.a.class.getName(), com.umeng.commonsdk.config.d.b.class.getName(), com.umeng.commonsdk.config.d.c.class.getName(), com.umeng.commonsdk.config.d.EnumC0518d.class.getName()};
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (d) {
            android.util.Pair<java.lang.Long, java.lang.String> a2 = a(imprintProperty);
            if (((java.lang.Long) a2.first).longValue() > 1000 && (str = (java.lang.String) a2.second) != null && str.length() > 0) {
                str2 = str;
            }
            java.lang.String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.umeng.commonsdk.config.g gVar = new com.umeng.commonsdk.config.g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(gVar);
                    ((com.umeng.commonsdk.config.e) arrayList.get(i)).a(split[i], b, com.umeng.commonsdk.config.d.b(strArr[i]));
                }
            }
            c = true;
        }
    }

    public void a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3 = "1001@3749699455,2130669566,262139,1983";
        java.lang.String[] strArr = {com.umeng.commonsdk.config.d.a.class.getName(), com.umeng.commonsdk.config.d.b.class.getName(), com.umeng.commonsdk.config.d.c.class.getName(), com.umeng.commonsdk.config.d.EnumC0518d.class.getName()};
        synchronized (d) {
            b.a();
            if (str != null) {
                android.util.Pair<java.lang.Long, java.lang.String> a2 = a(str);
                if (((java.lang.Long) a2.first).longValue() > 1000 && (str2 = (java.lang.String) a2.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            java.lang.String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.umeng.commonsdk.config.g gVar = new com.umeng.commonsdk.config.g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(gVar);
                    ((com.umeng.commonsdk.config.e) arrayList.get(i)).a(split[i], b, com.umeng.commonsdk.config.d.b(strArr[i]));
                }
            }
            c = true;
        }
    }
}
