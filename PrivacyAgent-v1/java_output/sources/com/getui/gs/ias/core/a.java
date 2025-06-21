package com.getui.gs.ias.core;

/* loaded from: classes22.dex */
public final class a {
    private static long[] a;
    private static java.util.List<java.lang.String> b;

    /* renamed from: com.getui.gs.ias.core.a$a, reason: collision with other inner class name */
    public static class C0291a {
        private static com.getui.gs.ias.core.a.C0291a.C0292a a;
        private static com.getui.gs.ias.core.a.C0291a.C0292a b;

        /* renamed from: com.getui.gs.ias.core.a$a$a, reason: collision with other inner class name */
        public static class C0292a {
            public long a;
            public long b;
            public long c;
            public double d;

            private C0292a() {
            }

            public /* synthetic */ C0292a(byte b) {
                this();
            }

            public final java.lang.String toString() {
                return "Info{windowTime=" + this.a + ", boundaryMin=" + this.b + ", boundaryMax=" + this.c + ", ratio=" + this.d + '}';
            }
        }

        public static long a(int i) {
            com.getui.gs.ias.core.a.C0291a.C0292a e = e(i);
            if (e == null) {
                return 259200000L;
            }
            long j = e.a;
            if (j > 0) {
                return j;
            }
            return 259200000L;
        }

        public static long b(int i) {
            com.getui.gs.ias.core.a.C0291a.C0292a e = e(i);
            if (e == null) {
                return 10000L;
            }
            long j = e.b;
            if (j > 0) {
                return j;
            }
            return 10000L;
        }

        public static long c(int i) {
            com.getui.gs.ias.core.a.C0291a.C0292a e = e(i);
            if (e == null) {
                return com.heytap.mcssdk.constant.a.h;
            }
            long j = e.c;
            return j > 0 ? j : com.heytap.mcssdk.constant.a.h;
        }

        public static double d(int i) {
            com.getui.gs.ias.core.a.C0291a.C0292a e = e(i);
            if (e == null) {
                return 0.3d;
            }
            double d = e.d;
            if (d > 0.0d) {
                return d;
            }
            return 0.3d;
        }

        private static com.getui.gs.ias.core.a.C0291a.C0292a e(int i) {
            if (i == 8) {
                com.getui.gs.ias.core.a.C0291a.C0292a c0292a = a;
                if (c0292a != null) {
                    return c0292a;
                }
                com.getui.gs.ias.core.a.C0291a.C0292a f = f(i);
                a = f;
                return f;
            }
            if (i != 11) {
                return null;
            }
            com.getui.gs.ias.core.a.C0291a.C0292a c0292a2 = b;
            if (c0292a2 != null) {
                return c0292a2;
            }
            com.getui.gs.ias.core.a.C0291a.C0292a f2 = f(i);
            b = f2;
            return f2;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static com.getui.gs.ias.core.a.C0291a.C0292a f(int i) {
            java.lang.String str;
            java.lang.String str2;
            if (i == 8) {
                str2 = "sdk.ido.type8.s1.info";
            } else {
                if (i != 11) {
                    str = null;
                    if (!android.text.TextUtils.isEmpty(str)) {
                        try {
                            java.lang.String[] split = str.split("\\|");
                            com.getui.gs.ias.core.a.C0291a.C0292a c0292a = new com.getui.gs.ias.core.a.C0291a.C0292a((byte) 0);
                            c0292a.a = ((java.lang.Long) com.getui.gs.c.a.a(split[0], 259200L)).longValue() * 1000;
                            c0292a.b = ((java.lang.Long) com.getui.gs.c.a.a(split[1], 10L)).longValue() * 1000;
                            c0292a.c = ((java.lang.Long) com.getui.gs.c.a.a(split[2], 900L)).longValue() * 1000;
                            c0292a.d = ((java.lang.Double) com.getui.gs.c.a.a(split[3], java.lang.Double.valueOf(0.3d))).doubleValue();
                            return c0292a;
                        } catch (java.lang.Throwable th) {
                            com.getui.gs.h.b.a.a.a.e(th);
                        }
                    }
                    return null;
                }
                str2 = "sdk.ido.type11.s1.info";
            }
            str = com.getui.gs.c.a.a(str2, "");
            if (!android.text.TextUtils.isEmpty(str)) {
            }
            return null;
        }
    }

    public static long a() {
        long sessionTimeoutMillis = com.getui.gs.ias.core.GsConfig.getSessionTimeoutMillis();
        return sessionTimeoutMillis > 0 ? sessionTimeoutMillis : com.getui.gs.c.a.a("sdk.ido.type8.timeout", 30000L);
    }

    public static boolean a(java.lang.String str) {
        if (b == null) {
            b = new java.util.ArrayList();
            for (java.lang.String str2 : com.getui.gs.c.a.a("sdk.ido.b.events_inner", "").split("\\|")) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    b.add(str2);
                }
            }
        }
        return b.contains(str);
    }

    public static long b() {
        return com.getui.gs.c.a.a("sdk.ido.bind.interval", 86400000L);
    }

    public static long[] c() {
        if (a == null) {
            java.lang.String a2 = com.getui.gs.c.a.a("sdk.ido.bind.day.boundary", "");
            if (!android.text.TextUtils.isEmpty(a2)) {
                try {
                    java.lang.String[] split = a2.split(",");
                    a = new long[2];
                    long parseLong = java.lang.Long.parseLong(split[0]) * 1000;
                    long parseLong2 = java.lang.Long.parseLong(split[1]) * 1000;
                    if (parseLong > 0 && parseLong2 > parseLong) {
                        long[] jArr = a;
                        jArr[0] = parseLong;
                        jArr[1] = parseLong2;
                        return jArr;
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gs.h.b.a.a.a.e(th);
                }
            }
            a = com.getui.gs.a.b.a;
        }
        return a;
    }

    public static long d() {
        com.getui.gs.b.e eVar;
        if (com.getui.gs.c.a.a("sdk.ido.type8.interval.strategy", 0) == 1) {
            long a2 = com.getui.gs.g.c.a(8);
            eVar = com.getui.gs.b.e.a.a;
            if (a2 >= eVar.a.b()) {
                return com.getui.gs.g.c.b(8);
            }
        }
        return com.getui.gs.c.a.a("sdk.ido.type8.upload.interval", 10000L);
    }

    public static long e() {
        com.getui.gs.b.e eVar;
        if (com.getui.gs.c.a.a("sdk.ido.type11.interval.strategy", 0) == 1) {
            long a2 = com.getui.gs.g.c.a(11);
            eVar = com.getui.gs.b.e.a.a;
            if (a2 >= eVar.a.b()) {
                return com.getui.gs.g.c.b(11);
            }
        }
        return com.getui.gs.c.a.a("sdk.ido.type11.upload.interval", 10000L);
    }

    public static long f() {
        return java.lang.Math.max(com.getui.gs.ias.core.GsConfig.getEventUploadInterval(), com.getui.gs.c.a.a("sdk.ido.type13.upload.interval", 10000L));
    }

    public static long g() {
        return java.lang.Math.max(com.getui.gs.ias.core.GsConfig.getProfileUploadInterval(), com.getui.gs.c.a.a("sdk.ido.type14.upload.interval", 5000L));
    }

    public static int h() {
        return com.getui.gs.c.a.a("sdk.ido.event.db.size", 2000);
    }
}
