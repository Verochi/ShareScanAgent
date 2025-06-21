package com.anythink.china.b;

/* loaded from: classes12.dex */
public final class a {
    private static java.lang.String a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static java.lang.String e = "";
    private static java.lang.String f = "";
    private static java.lang.String g = "";
    private static java.lang.String h = "";
    private static java.lang.String i = "";
    private static java.lang.String j;
    private static boolean k;
    private static java.util.List<com.anythink.core.common.f.s> l;

    /* renamed from: com.anythink.china.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.china.a.a {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.anythink.china.a.a
        public final void a() {
        }

        @Override // com.anythink.china.a.a
        public final void a(java.lang.String str, boolean z) {
            if (com.anythink.china.b.a.a(str)) {
                return;
            }
            java.lang.String unused = com.anythink.china.b.a.c = str;
            com.anythink.core.common.o.r.a(this.a, com.anythink.core.common.b.h.p, "oaid", str);
        }
    }

    /* renamed from: com.anythink.china.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.china.a.a {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.Object b;
        final /* synthetic */ boolean[] c;

        public AnonymousClass2(android.content.Context context, java.lang.Object obj, boolean[] zArr) {
            this.a = context;
            this.b = obj;
            this.c = zArr;
        }

        @Override // com.anythink.china.a.a
        public final void a() {
            this.c[0] = true;
            try {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.china.a.a
        public final void a(java.lang.String str, boolean z) {
            if (!com.anythink.china.b.a.a(str)) {
                java.lang.String unused = com.anythink.china.b.a.c = str;
                com.anythink.core.common.o.r.a(this.a, com.anythink.core.common.b.h.p, "oaid", str);
            }
            try {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            } catch (java.lang.Throwable unused2) {
            }
            this.c[0] = true;
        }
    }

    public static java.lang.String a() {
        return com.anythink.core.common.b.o.a().c("mac") ? "" : a;
    }

    public static void a(android.content.Context context) {
        java.lang.String str = "";
        java.lang.String b2 = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, "oaid", "");
        c = b2;
        if (android.text.TextUtils.isEmpty(b2) && !com.anythink.core.common.b.o.a().c("oaid") && android.text.TextUtils.isEmpty(c)) {
            com.anythink.china.a.b.a(context, new com.anythink.china.b.a.AnonymousClass1(context));
        }
        if (!com.anythink.core.common.b.o.a().c("mac")) {
            str = android.os.Build.VERSION.SDK_INT < 23 ? com.anythink.china.b.d.a(context) : com.anythink.china.b.d.a();
        }
        a = str;
        b = d(context);
        d = com.anythink.china.b.b.a();
        java.lang.String[] c2 = com.anythink.china.b.b.c(context);
        if (c2 != null && c2.length == 2) {
            e = c2[0];
            f = c2[1];
        }
        g = com.anythink.china.b.b.b();
        h = com.anythink.china.b.b.c();
        i = com.anythink.china.b.b.d();
        if (l == null) {
            long longValue = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_time", (java.lang.Long) 0L).longValue();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            l = arrayList;
            arrayList.add(new com.anythink.core.common.f.s(context, longValue, "vivo_ver", "com.bbk.appstore"));
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                l.add(new com.anythink.core.common.f.s(context, longValue, "oppo_ver", "com.heytap.market"));
            } else {
                l.add(new com.anythink.core.common.f.s(context, longValue, "oppo_ver", "com.oppo.market"));
            }
            l.add(new com.anythink.core.common.f.s(context, longValue, "xiaomi_ver", "com.xiaomi.market"));
            com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_time", java.lang.System.currentTimeMillis());
        }
    }

    public static /* synthetic */ boolean a(java.lang.String str) {
        return java.util.regex.Pattern.matches("^[0-]+$", str);
    }

    public static java.lang.String b() {
        return com.anythink.core.common.b.o.a().c("oaid") ? "" : c;
    }

    public static java.lang.String b(android.content.Context context) {
        d(context);
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        java.lang.String c2 = c(context);
        return !android.text.TextUtils.isEmpty(c2) ? c2 : "";
    }

    public static java.lang.String c() {
        return com.anythink.core.common.b.o.a().c("wifi_name") ? "" : com.anythink.china.b.b.b(com.anythink.core.common.b.o.a().f());
    }

    public static java.lang.String c(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("oaid")) {
            return "";
        }
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        java.lang.String b2 = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, "oaid", "");
        c = b2;
        if (!android.text.TextUtils.isEmpty(b2)) {
            return c;
        }
        java.lang.Object obj = new java.lang.Object();
        boolean[] zArr = {false};
        com.anythink.china.a.b.a(context, new com.anythink.china.b.a.AnonymousClass2(context, obj, zArr));
        if (!zArr[0]) {
            try {
                synchronized (obj) {
                    obj.wait(1500L);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        java.lang.String str = c;
        return str != null ? str : "";
    }

    private static boolean c(java.lang.String str) {
        return java.util.regex.Pattern.matches("^[0-]+$", str);
    }

    public static java.lang.String d() {
        return d;
    }

    public static synchronized java.lang.String d(android.content.Context context) {
        synchronized (com.anythink.china.b.a.class) {
            if (com.anythink.core.common.b.o.a().c("imei")) {
                return "";
            }
            if (!k && android.text.TextUtils.isEmpty(b) && com.anythink.china.common.d.a(context, com.anythink.china.common.d.a)) {
                b = com.anythink.china.b.c.a(context);
                k = true;
            }
            return b;
        }
    }

    public static java.lang.String e() {
        return com.anythink.china.b.b.a(com.anythink.core.common.b.o.a().f());
    }

    public static synchronized java.lang.String e(android.content.Context context) {
        synchronized (com.anythink.china.b.a.class) {
            java.lang.String str = j;
            if (str != null) {
                return str;
            }
            try {
                j = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (java.lang.Exception unused) {
            }
            if (j == null) {
                j = "";
            }
            return j;
        }
    }

    public static java.lang.String f() {
        return e;
    }

    public static java.lang.String g() {
        return f;
    }

    public static java.lang.String h() {
        return g;
    }

    public static java.lang.String i() {
        return h;
    }

    public static java.lang.String j() {
        return i;
    }

    public static java.util.List<com.anythink.core.common.f.s> k() {
        return l;
    }
}
