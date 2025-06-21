package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bo {
    public volatile com.amap.api.col.s.bo.b a = new com.amap.api.col.s.bo.b((byte) 0);
    public com.amap.api.col.s.cm b = new com.amap.api.col.s.cm("HttpsDecisionUtil");

    public static class a {
        public static com.amap.api.col.s.bo a = new com.amap.api.col.s.bo();
    }

    public static class b {
        public int a;
        public boolean b;
        public final boolean c;
        public boolean d;

        public b() {
            this.a = 0;
            this.b = true;
            this.c = true;
            this.d = false;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final void a(android.content.Context context) {
            if (context != null && this.a <= 0) {
                this.a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.b = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean c() {
            boolean z;
            if (!this.d) {
                boolean z2 = android.os.Build.VERSION.SDK_INT >= 28;
                if (this.b) {
                    int i = this.a;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                        if (!z2 && z) {
                            return false;
                        }
                    }
                }
                z = true;
                if (!z2 && z) {
                }
            }
            return true;
        }

        public final void d(boolean z) {
            this.d = z;
        }
    }

    public static com.amap.api.col.s.bo a() {
        return com.amap.api.col.s.bo.a.a;
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            android.net.Uri.Builder buildUpon = android.net.Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }

    public static void b(android.content.Context context) {
        c(context, true);
    }

    public static void c(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor a2 = com.amap.api.col.s.cm.a(context, "open_common");
        com.amap.api.col.s.cm.a(a2, "a3", z);
        com.amap.api.col.s.cm.a(a2);
    }

    public static boolean d() {
        return false;
    }

    public final void a(android.content.Context context) {
        if (this.a == null) {
            this.a = new com.amap.api.col.s.bo.b((byte) 0);
        }
        this.a.b(com.amap.api.col.s.cm.a(context, "open_common", "a3", true));
        this.a.a(context);
        com.amap.api.col.s.bv.a(context).a();
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new com.amap.api.col.s.bo.b((byte) 0);
        }
        this.a.d(z);
    }

    public final void b(android.content.Context context, boolean z) {
        if (this.a == null) {
            this.a = new com.amap.api.col.s.bo.b((byte) 0);
        }
        c(context, z);
        this.a.b(z);
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new com.amap.api.col.s.bo.b((byte) 0);
        }
        return this.a.c();
    }

    public final boolean b(boolean z) {
        if (d()) {
            return false;
        }
        return z || b();
    }
}
