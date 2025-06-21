package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.a.d {
    private static final boolean i = true;
    private int l;
    private com.anythink.expressad.foundation.g.g.c o;
    private com.anythink.expressad.a.h p;
    private int j = 0;
    private java.lang.String k = null;
    com.anythink.expressad.a.c.b a = null;
    private com.anythink.expressad.a.e m = null;
    private boolean n = true;
    private android.os.Handler q = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.g.a.b {

        /* renamed from: com.anythink.expressad.a.c$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01771 implements java.lang.Runnable {
            public RunnableC01771() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.a.c.this.m != null) {
                    if (com.anythink.expressad.a.c.this.a.g()) {
                        com.anythink.expressad.a.e unused = com.anythink.expressad.a.c.this.m;
                    } else {
                        com.anythink.expressad.a.e unused2 = com.anythink.expressad.a.c.this.m;
                        com.anythink.expressad.a.c.this.a.h();
                    }
                }
            }
        }

        private AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a.b
        public final void a(com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a) {
            if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.FINISH && com.anythink.expressad.a.c.this.n) {
                com.anythink.expressad.a.c.this.q.post(new com.anythink.expressad.a.c.AnonymousClass1.RunnableC01771());
            }
        }
    }

    public class a extends com.anythink.expressad.foundation.g.g.a {
        private a() {
        }

        private /* synthetic */ a(com.anythink.expressad.a.c cVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00be A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014f A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0172 A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x018c A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00ec A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0102 A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00fa A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0091 A[EDGE_INSN: B:79:0x0091->B:80:0x0091 BREAK  A[LOOP:0: B:5:0x000b->B:65:0x0131], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0139 A[Catch: Exception -> 0x01d9, TryCatch #4 {Exception -> 0x01d9, blocks: (B:3:0x0001, B:7:0x0015, B:9:0x001e, B:20:0x0078, B:30:0x00be, B:32:0x00c4, B:34:0x00cc, B:37:0x00d5, B:38:0x00e4, B:57:0x00dd, B:58:0x00ec, B:59:0x00f4, B:71:0x00fa, B:61:0x0102, B:69:0x010e, B:63:0x011b, B:65:0x0131, B:82:0x00a5, B:77:0x00ab, B:92:0x0139, B:93:0x013c, B:39:0x013d, B:41:0x014f, B:44:0x0162, B:46:0x0172, B:47:0x01ca, B:50:0x018c, B:52:0x0194, B:54:0x01a5, B:55:0x019e, B:56:0x01b1), top: B:2:0x0001 }] */
        @Override // com.anythink.expressad.foundation.g.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            java.net.HttpURLConnection httpURLConnection;
            java.lang.String str;
            int i;
            java.lang.String str2;
            try {
                com.anythink.expressad.a.c.this.a = new com.anythink.expressad.a.c.b();
                int i2 = 0;
                while (true) {
                    java.net.HttpURLConnection httpURLConnection2 = null;
                    if (i2 >= 10) {
                        break;
                    }
                    if (!com.anythink.expressad.a.c.this.n) {
                        return;
                    }
                    com.anythink.expressad.a.c.d(com.anythink.expressad.a.c.this);
                    try {
                        com.anythink.expressad.a.c cVar = com.anythink.expressad.a.c.this;
                        cVar.k = cVar.k.replace(" ", "%20");
                        java.lang.String unused = com.anythink.expressad.a.c.this.k;
                        httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(com.anythink.expressad.a.c.this.k).openConnection();
                        try {
                            try {
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.o.e.i());
                                httpURLConnection.setConnectTimeout(15000);
                                httpURLConnection.setReadTimeout(15000);
                                httpURLConnection.setInstanceFollowRedirects(false);
                                httpURLConnection.connect();
                                i = httpURLConnection.getResponseCode();
                                try {
                                    str = httpURLConnection.getHeaderField("Location");
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    str = null;
                                }
                                try {
                                    str2 = httpURLConnection.getHeaderField("Content-type");
                                    httpURLConnection.disconnect();
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (i2 != 0) {
                                        com.anythink.expressad.a.c.this.a.a(false);
                                        com.anythink.expressad.a.c.this.a.d(e.getLocalizedMessage());
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    str2 = null;
                                    if (i != 301) {
                                        if (i != 200) {
                                        }
                                        if (!com.anythink.expressad.a.c.this.k.toLowerCase().startsWith("market:/")) {
                                            if (com.anythink.expressad.a.c.this.k.toLowerCase().endsWith(com.anythink.china.common.a.a.g)) {
                                            }
                                            com.anythink.expressad.a.c.this.a.d(null);
                                            com.anythink.expressad.a.c.this.a.a(true);
                                        }
                                        com.anythink.expressad.a.c.this.a.c(1);
                                        com.anythink.expressad.a.c cVar2 = com.anythink.expressad.a.c.this;
                                        cVar2.a.e(cVar2.k);
                                        com.anythink.expressad.a.c.this.a.b(true);
                                        com.anythink.expressad.a.c.this.a.d(null);
                                        com.anythink.expressad.a.c.this.a.a(true);
                                    }
                                    if (!android.text.TextUtils.isEmpty(str)) {
                                    }
                                    if (!com.anythink.expressad.a.c.this.k.toLowerCase().startsWith("market:/")) {
                                    }
                                    com.anythink.expressad.a.c.this.a.c(1);
                                    com.anythink.expressad.a.c cVar22 = com.anythink.expressad.a.c.this;
                                    cVar22.a.e(cVar22.k);
                                    com.anythink.expressad.a.c.this.a.b(true);
                                    com.anythink.expressad.a.c.this.a.d(null);
                                    com.anythink.expressad.a.c.this.a.a(true);
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                httpURLConnection2 = httpURLConnection;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            str = null;
                            i = 200;
                            e.printStackTrace();
                            if (i2 != 0) {
                            }
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        httpURLConnection = null;
                        str = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (httpURLConnection2 != null) {
                        }
                        throw th;
                    }
                    if (i != 301 && i != 302 && i != 307) {
                        if (i != 200) {
                            if (!android.text.TextUtils.isEmpty(str2) && str2.indexOf(com.baidu.mobads.sdk.internal.a.f) < 0 && str2.indexOf("text") < 0) {
                                com.anythink.expressad.a.c.this.a.c(3);
                                com.anythink.expressad.a.c.this.a.b(true);
                            }
                            com.anythink.expressad.a.c.this.a.c(2);
                            com.anythink.expressad.a.c.this.a.b(true);
                        } else {
                            com.anythink.expressad.a.c.this.a.b(false);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(str)) {
                        com.anythink.expressad.a.c.this.a.b(true);
                        break;
                    }
                    if (!str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q)) {
                        com.anythink.expressad.a.c.this.k = str;
                        com.anythink.expressad.a.c.this.a.b(true);
                        break;
                    } else {
                        com.anythink.expressad.a.c.this.k = str;
                        if (com.anythink.expressad.a.c.this.k.toLowerCase().endsWith(com.anythink.china.common.a.a.g)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!com.anythink.expressad.a.c.this.k.toLowerCase().startsWith("market:/") && com.anythink.expressad.a.c.this.k.toLowerCase().indexOf("play.google.com") <= 0) {
                    if (com.anythink.expressad.a.c.this.k.toLowerCase().endsWith(com.anythink.china.common.a.a.g)) {
                        if (com.anythink.expressad.a.c.this.j >= 10 || !com.anythink.expressad.a.c.this.a.k()) {
                            com.anythink.expressad.a.c.this.a.c(2);
                        }
                        com.anythink.expressad.a.c cVar3 = com.anythink.expressad.a.c.this;
                        cVar3.a.e(cVar3.k);
                    } else {
                        com.anythink.expressad.a.c.this.a.c(3);
                        com.anythink.expressad.a.c cVar4 = com.anythink.expressad.a.c.this;
                        cVar4.a.e(cVar4.k);
                        com.anythink.expressad.a.c.this.a.b(true);
                    }
                    com.anythink.expressad.a.c.this.a.d(null);
                    com.anythink.expressad.a.c.this.a.a(true);
                }
                com.anythink.expressad.a.c.this.a.c(1);
                com.anythink.expressad.a.c cVar222 = com.anythink.expressad.a.c.this;
                cVar222.a.e(cVar222.k);
                com.anythink.expressad.a.c.this.a.b(true);
                com.anythink.expressad.a.c.this.a.d(null);
                com.anythink.expressad.a.c.this.a.a(true);
            } catch (java.lang.Exception e5) {
                com.anythink.expressad.a.c cVar5 = com.anythink.expressad.a.c.this;
                cVar5.a.e(cVar5.k);
                com.anythink.expressad.a.c.this.a.a(false);
                com.anythink.expressad.a.c.this.a.d(e5.getLocalizedMessage());
                e5.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public static class b implements com.anythink.expressad.e.b, java.io.Serializable {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final long e = 1;
        private boolean f;
        private java.lang.String g;
        private int h;
        private java.lang.String i;
        private java.lang.String j;
        private boolean k;
        private java.lang.String l;
        private java.lang.String m;
        private java.lang.String n;
        private int o;
        private boolean p;
        private int q;

        private void f(java.lang.String str) {
            this.j = str;
        }

        private boolean l() {
            return this.p;
        }

        private java.lang.String m() {
            return this.j;
        }

        public final int a() {
            return this.q;
        }

        public final void a(int i) {
            this.q = i;
        }

        public final void a(java.lang.String str) {
            this.n = str;
        }

        public final void a(boolean z) {
            this.f = z;
        }

        public final void b() {
            this.p = true;
        }

        public final void b(int i) {
            this.o = i;
        }

        public final void b(java.lang.String str) {
            this.m = str;
        }

        public final void b(boolean z) {
            this.k = z;
        }

        public final int c() {
            return this.o;
        }

        public final void c(int i) {
            this.h = i;
        }

        public final void c(java.lang.String str) {
            this.l = str;
        }

        public final java.lang.String d() {
            return this.n;
        }

        public final void d(java.lang.String str) {
            this.g = str;
        }

        public final java.lang.String e() {
            return this.m;
        }

        public final void e(java.lang.String str) {
            this.i = str;
        }

        public final java.lang.String f() {
            return this.l;
        }

        public final boolean g() {
            return this.f;
        }

        public final java.lang.String h() {
            return this.g;
        }

        public final int i() {
            return this.h;
        }

        public final java.lang.String j() {
            return this.i;
        }

        public final boolean k() {
            return this.k;
        }
    }

    public c(android.content.Context context) {
        this.o = new com.anythink.expressad.foundation.g.g.c(context, 2);
        this.p = new com.anythink.expressad.a.h(context);
    }

    private void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.e eVar) {
        this.k = new java.lang.String(cVar.ad());
        this.m = eVar;
        this.a = null;
        this.p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, null, cVar, true, false, com.anythink.expressad.a.a.a.l);
    }

    private void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.e eVar, com.anythink.expressad.c.b bVar) {
        this.k = new java.lang.String(cVar.ad());
        this.m = eVar;
        this.a = null;
        this.p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, bVar, cVar, true, false, com.anythink.expressad.a.a.a.l);
    }

    public static /* synthetic */ int d(com.anythink.expressad.a.c cVar) {
        int i2 = cVar.j;
        cVar.j = i2 + 1;
        return i2;
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.a.e eVar, java.lang.String str3, boolean z, boolean z2, int i2) {
        java.lang.String str4;
        boolean z3;
        this.k = str3;
        this.m = eVar;
        this.a = null;
        this.l = i2;
        if (cVar != null) {
            boolean z4 = "5".equals(cVar.ab()) || "6".equals(cVar.ab());
            str4 = cVar.aZ();
            z3 = z4;
        } else {
            str4 = "";
            z3 = false;
        }
        this.p.a(str3, eVar, z3, str, str4, str2, null, cVar, z, z2, i2);
    }

    public final boolean a() {
        return this.n;
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.n = false;
    }
}
