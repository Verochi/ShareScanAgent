package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fb {
    private volatile com.amap.api.mapcore.util.fb.b a = new com.amap.api.mapcore.util.fb.b((byte) 0);
    private com.amap.api.mapcore.util.gq b = new com.amap.api.mapcore.util.gq("HttpsDecisionUtil");

    public static class a {
        static com.amap.api.mapcore.util.fb a = new com.amap.api.mapcore.util.fb();
    }

    public static class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final void a(android.content.Context context) {
            if (context != null && this.b <= 0) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a() {
            boolean z;
            if (!this.d) {
                boolean z2 = android.os.Build.VERSION.SDK_INT >= 28;
                if (this.a) {
                    int i = this.b;
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
    }

    public static com.amap.api.mapcore.util.fb a() {
        return com.amap.api.mapcore.util.fb.a.a;
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
        b(context, true);
    }

    private static void b(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor a2 = com.amap.api.mapcore.util.gq.a(context, "open_common");
        com.amap.api.mapcore.util.gq.a(a2, "a3", z);
        com.amap.api.mapcore.util.gq.a(a2);
    }

    private static boolean c() {
        return false;
    }

    public final void a(android.content.Context context) {
        if (this.a == null) {
            this.a = new com.amap.api.mapcore.util.fb.b((byte) 0);
        }
        this.a.a(com.amap.api.mapcore.util.gq.a(context, "open_common", "a3", true));
        this.a.a(context);
        com.amap.api.mapcore.util.fk.a(context).a();
    }

    public final void a(android.content.Context context, boolean z) {
        if (this.a == null) {
            this.a = new com.amap.api.mapcore.util.fb.b((byte) 0);
        }
        b(context, z);
        this.a.a(z);
    }

    public final boolean a(boolean z) {
        if (c()) {
            return false;
        }
        return z || b();
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new com.amap.api.mapcore.util.fb.b((byte) 0);
        }
        return this.a.a();
    }
}
