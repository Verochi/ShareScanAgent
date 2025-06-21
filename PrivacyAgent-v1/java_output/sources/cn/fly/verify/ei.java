package cn.fly.verify;

/* loaded from: classes.dex */
public class ei {
    private static cn.fly.verify.ei a;
    private static volatile boolean d;
    private android.content.Context b;
    private java.util.HashMap<java.lang.String, java.lang.Object> c;
    private volatile java.io.File g;
    private long k;
    private long l;
    private long m;
    private final byte[] e = new byte[0];
    private java.util.concurrent.atomic.AtomicBoolean f = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.ConcurrentLinkedQueue<java.util.concurrent.CountDownLatch> h = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private volatile java.lang.String i = null;
    private volatile int j = -1;

    /* renamed from: cn.fly.verify.ei$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass1(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = str;
            this.b = countDownLatch;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x02bb A[Catch: all -> 0x04a7, TryCatch #3 {all -> 0x04a7, blocks: (B:7:0x001c, B:9:0x005b, B:18:0x012f, B:20:0x0142, B:38:0x0283, B:40:0x028c, B:42:0x0292, B:45:0x029b, B:47:0x02bb, B:49:0x02e1, B:50:0x02ef, B:51:0x0338, B:53:0x0366, B:55:0x0372, B:57:0x037f, B:59:0x0385, B:65:0x03c9, B:76:0x02f4, B:80:0x0328), top: B:6:0x001c, outer: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0366 A[Catch: all -> 0x04a7, TryCatch #3 {all -> 0x04a7, blocks: (B:7:0x001c, B:9:0x005b, B:18:0x012f, B:20:0x0142, B:38:0x0283, B:40:0x028c, B:42:0x0292, B:45:0x029b, B:47:0x02bb, B:49:0x02e1, B:50:0x02ef, B:51:0x0338, B:53:0x0366, B:55:0x0372, B:57:0x037f, B:59:0x0385, B:65:0x03c9, B:76:0x02f4, B:80:0x0328), top: B:6:0x001c, outer: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x03c6 A[Catch: all -> 0x03c9, TRY_LEAVE, TryCatch #4 {all -> 0x03c9, blocks: (B:61:0x03c0, B:63:0x03c6), top: B:60:0x03c0 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0436 A[Catch: all -> 0x067b, TryCatch #5 {, blocks: (B:4:0x0009, B:10:0x0061, B:12:0x00c1, B:14:0x00c9, B:15:0x012d, B:21:0x0152, B:23:0x01b2, B:25:0x01ba, B:26:0x021e, B:67:0x03d4, B:69:0x0436, B:71:0x043e, B:72:0x04a2, B:73:0x059e, B:74:0x05a5, B:90:0x04ce, B:92:0x0530, B:94:0x0538, B:97:0x05a8, B:99:0x060b, B:101:0x0613, B:102:0x067a, B:89:0x04a9, B:7:0x001c, B:9:0x005b, B:18:0x012f, B:20:0x0142, B:38:0x0283, B:40:0x028c, B:42:0x0292, B:45:0x029b, B:47:0x02bb, B:49:0x02e1, B:50:0x02ef, B:51:0x0338, B:53:0x0366, B:55:0x0372, B:57:0x037f, B:59:0x0385, B:65:0x03c9, B:76:0x02f4, B:80:0x0328), top: B:3:0x0009, inners: #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0328 A[Catch: all -> 0x04a7, TryCatch #3 {all -> 0x04a7, blocks: (B:7:0x001c, B:9:0x005b, B:18:0x012f, B:20:0x0142, B:38:0x0283, B:40:0x028c, B:42:0x0292, B:45:0x029b, B:47:0x02bb, B:49:0x02e1, B:50:0x02ef, B:51:0x0338, B:53:0x0366, B:55:0x0372, B:57:0x037f, B:59:0x0385, B:65:0x03c9, B:76:0x02f4, B:80:0x0328), top: B:6:0x001c, outer: #5 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            cn.fly.verify.dh a;
            java.lang.Throwable th;
            java.lang.String sb;
            int i;
            int i2;
            java.io.File file;
            java.lang.String str;
            boolean z;
            java.lang.String a2;
            cn.fly.verify.ei eiVar;
            java.lang.String c;
            java.util.HashMap a3;
            synchronized (cn.fly.verify.ei.this.e) {
                cn.fly.verify.er.c.set(java.lang.Boolean.TRUE);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                try {
                    cn.fly.verify.ed.a().a("dhs stch: " + cn.fly.verify.ei.this.e(this.a), new java.lang.Object[0]);
                    file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dn.a("003^baba5f"));
                } catch (java.lang.Throwable th2) {
                    try {
                        cn.fly.verify.ed.a().a("dhs oops: " + th2.getMessage(), new java.lang.Object[0]);
                        cn.fly.verify.ed.a().a(th2);
                        cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                        cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                        this.b.countDown();
                        cn.fly.verify.ei.this.h.remove(this.b);
                        cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                        if (cn.fly.verify.ei.this.m > 3500 && cn.fly.verify.ei.this.b() == 16) {
                            a = cn.fly.verify.dh.a();
                            th = new java.lang.Throwable(("-t-" + cn.fly.verify.ei.this.m) + "-d-" + cn.fly.verify.ei.this.l + "-l-" + cn.fly.verify.ei.this.k + " ");
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("");
                            sb2.append(cn.fly.verify.ei.this.i);
                            sb = sb2.toString();
                            i = 11;
                            i2 = 3;
                        }
                    } finally {
                    }
                }
                if (!cn.fly.verify.ei.this.e(this.a)) {
                    boolean unused = cn.fly.verify.ei.d = false;
                    cn.fly.verify.fq.a(file);
                    cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                    cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                    this.b.countDown();
                    cn.fly.verify.ei.this.h.remove(this.b);
                    cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                    if (cn.fly.verify.ei.this.m > 3500 && cn.fly.verify.ei.this.b() == 16) {
                        cn.fly.verify.dh a4 = cn.fly.verify.dh.a();
                        java.lang.Throwable th3 = new java.lang.Throwable(("-t-" + cn.fly.verify.ei.this.m) + "-d-" + cn.fly.verify.ei.this.l + "-l-" + cn.fly.verify.ei.this.k + " ");
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("");
                        sb3.append(cn.fly.verify.ei.this.i);
                        a4.a(3, 11, th3, sb3.toString());
                    }
                    return;
                }
                cn.fly.verify.ei.this.a(0);
                java.lang.String b = cn.fly.verify.ei.this.b(this.a);
                if (android.text.TextUtils.isEmpty(b)) {
                    boolean unused2 = cn.fly.verify.ei.d = false;
                    cn.fly.verify.dh.a().a(-1, 4, "", "");
                    cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                    cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                    this.b.countDown();
                    cn.fly.verify.ei.this.h.remove(this.b);
                    cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                    if (cn.fly.verify.ei.this.m > 3500 && cn.fly.verify.ei.this.b() == 16) {
                        cn.fly.verify.dh a5 = cn.fly.verify.dh.a();
                        java.lang.Throwable th4 = new java.lang.Throwable(("-t-" + cn.fly.verify.ei.this.m) + "-d-" + cn.fly.verify.ei.this.l + "-l-" + cn.fly.verify.ei.this.k + " ");
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                        sb4.append("");
                        sb4.append(cn.fly.verify.ei.this.i);
                        a5.a(3, 11, th4, sb4.toString());
                    }
                    return;
                }
                if (!cn.fly.verify.fh.d.b()) {
                    java.lang.String str2 = cn.fly.verify.fh.d.d() + "";
                    java.lang.String c2 = cn.fly.verify.fh.d.c();
                    if (str2.contains(c2)) {
                        str2 = str2.replace(c2, "");
                    }
                    str = b + "_" + str2.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
                    try {
                        cn.fly.verify.ed.a().a("dhs cld nm " + str, new java.lang.Object[0]);
                    } catch (java.lang.Throwable unused3) {
                    }
                    java.io.File b2 = cn.fly.verify.ei.this.b(file, str);
                    z = b2 == null && b2.exists() && b2.isFile();
                    cn.fly.verify.ed.a().a("dhs cac: " + z, new java.lang.Object[0]);
                    a2 = cn.fly.verify.fi.a(b2);
                    if (z) {
                        cn.fly.verify.ei.this.a(8);
                        eiVar = cn.fly.verify.ei.this;
                        c = eiVar.c(this.a);
                    } else {
                        cn.fly.verify.ei.this.a(5);
                        boolean equals = b.equals(a2);
                        cn.fly.verify.ed.a().a("dhs m5: " + equals, new java.lang.Object[0]);
                        if (equals) {
                            cn.fly.verify.ed.a().a("dhs tbm: " + cn.fly.verify.ei.this.f.get(), new java.lang.Object[0]);
                            if (!cn.fly.verify.ei.this.f.compareAndSet(false, true)) {
                                a2 = "";
                            }
                            cn.fly.verify.ed.a().a("dhs cl:  tm5: " + a2 + ", cm5: " + cn.fly.verify.ei.this.i, new java.lang.Object[0]);
                            if (!android.text.TextUtils.isEmpty(a2) && !a2.equals(cn.fly.verify.ei.this.i)) {
                                cn.fly.verify.ei.this.a(b2);
                                a3 = cn.fly.verify.ei.this.a(b2, a2);
                                if (a3 != null || a3.isEmpty()) {
                                    try {
                                        if (b2.exists()) {
                                            b2.delete();
                                        }
                                    } catch (java.lang.Throwable unused4) {
                                    }
                                    cn.fly.verify.ed.a().a("dhs l fail", new java.lang.Object[0]);
                                } else {
                                    cn.fly.verify.ed.a().a("dhs l succ", new java.lang.Object[0]);
                                    cn.fly.verify.ek ekVar = new cn.fly.verify.ek(a3);
                                    cn.fly.verify.ei.this.i = cn.fly.verify.fi.a(b2);
                                    boolean unused5 = cn.fly.verify.ei.d = cn.fly.verify.eh.a(cn.fly.verify.ei.this.b).a(ekVar);
                                    cn.fly.verify.ei.this.a(16);
                                    cn.fly.verify.ed.a().a("dhs fin", new java.lang.Object[0]);
                                }
                            }
                            cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                            cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                            this.b.countDown();
                            cn.fly.verify.ei.this.h.remove(this.b);
                            cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                            if (cn.fly.verify.ei.this.m > 3500 && cn.fly.verify.ei.this.b() == 16) {
                                a = cn.fly.verify.dh.a();
                                th = new java.lang.Throwable(("-t-" + cn.fly.verify.ei.this.m) + "-d-" + cn.fly.verify.ei.this.l + "-l-" + cn.fly.verify.ei.this.k + " ");
                                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                                sb5.append("");
                                sb5.append(cn.fly.verify.ei.this.i);
                                sb = sb5.toString();
                                i = 11;
                                i2 = 3;
                                a.a(i2, i, th, sb);
                            }
                            cn.fly.verify.er.c.set(java.lang.Boolean.FALSE);
                        }
                        cn.fly.verify.ei.this.a(6);
                        eiVar = cn.fly.verify.ei.this;
                        c = eiVar.c(this.a);
                    }
                    a2 = eiVar.a(c, b2, b);
                    cn.fly.verify.ed.a().a("dhs cl:  tm5: " + a2 + ", cm5: " + cn.fly.verify.ei.this.i, new java.lang.Object[0]);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        cn.fly.verify.ei.this.a(b2);
                        a3 = cn.fly.verify.ei.this.a(b2, a2);
                        if (a3 != null) {
                        }
                        if (b2.exists()) {
                        }
                        cn.fly.verify.ed.a().a("dhs l fail", new java.lang.Object[0]);
                    }
                    cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                    cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                    this.b.countDown();
                    cn.fly.verify.ei.this.h.remove(this.b);
                    cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                    if (cn.fly.verify.ei.this.m > 3500) {
                        a = cn.fly.verify.dh.a();
                        th = new java.lang.Throwable(("-t-" + cn.fly.verify.ei.this.m) + "-d-" + cn.fly.verify.ei.this.l + "-l-" + cn.fly.verify.ei.this.k + " ");
                        java.lang.StringBuilder sb52 = new java.lang.StringBuilder();
                        sb52.append("");
                        sb52.append(cn.fly.verify.ei.this.i);
                        sb = sb52.toString();
                        i = 11;
                        i2 = 3;
                        a.a(i2, i, th, sb);
                    }
                    cn.fly.verify.er.c.set(java.lang.Boolean.FALSE);
                }
                str = b;
                java.io.File b22 = cn.fly.verify.ei.this.b(file, str);
                if (b22 == null) {
                }
                cn.fly.verify.ed.a().a("dhs cac: " + z, new java.lang.Object[0]);
                a2 = cn.fly.verify.fi.a(b22);
                if (z) {
                }
                a2 = eiVar.a(c, b22, b);
                cn.fly.verify.ed.a().a("dhs cl:  tm5: " + a2 + ", cm5: " + cn.fly.verify.ei.this.i, new java.lang.Object[0]);
                if (!android.text.TextUtils.isEmpty(a2)) {
                }
                cn.fly.verify.ei.this.m = java.lang.System.currentTimeMillis() - currentTimeMillis;
                cn.fly.verify.ed.a().a("dhs ctd: " + this.b, new java.lang.Object[0]);
                this.b.countDown();
                cn.fly.verify.ei.this.h.remove(this.b);
                cn.fly.verify.ed.a().a("dhs tt " + cn.fly.verify.ei.this.m, new java.lang.Object[0]);
                if (cn.fly.verify.ei.this.m > 3500) {
                }
                cn.fly.verify.er.c.set(java.lang.Boolean.FALSE);
            }
        }
    }

    private ei(android.content.Context context) {
        this.b = context;
    }

    public static cn.fly.verify.ei a(android.content.Context context) {
        if (a == null) {
            synchronized (cn.fly.verify.ei.class) {
                if (a == null) {
                    a = new cn.fly.verify.ei(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str, java.io.File file, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        if (!android.text.TextUtils.isEmpty(str) && file != null) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String str3 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    cn.fly.verify.ed.a().a("dhs d...", new java.lang.Object[0]);
                    new cn.fly.verify.fc().a(str, fileOutputStream, (cn.fly.verify.fc.a) null);
                    java.lang.String a2 = cn.fly.verify.fi.a(file);
                    if (android.text.TextUtils.equals(str2, a2)) {
                        cn.fly.verify.dw.a(fileOutputStream);
                        if (android.text.TextUtils.isEmpty(null)) {
                            long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                            this.l = currentTimeMillis2;
                            str3 = java.lang.String.format("dhs d %d", java.lang.Long.valueOf(currentTimeMillis2));
                        }
                        cn.fly.verify.ed.a().a(str3, new java.lang.Object[0]);
                        return a2;
                    }
                    cn.fly.verify.dh.a().a(-1, 20, "", str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    cn.fly.verify.dw.a(fileOutputStream);
                    if (android.text.TextUtils.isEmpty(null)) {
                        long currentTimeMillis3 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                        this.l = currentTimeMillis3;
                        str3 = java.lang.String.format("dhs d %d", java.lang.Long.valueOf(currentTimeMillis3));
                    }
                    cn.fly.verify.ed.a().a(str3, new java.lang.Object[0]);
                    return "";
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        str3 = "dhs d e: " + th.getMessage();
                        cn.fly.verify.ed.a().a(th);
                        cn.fly.verify.dh.a().a(2, b(), th, "" + str2);
                        cn.fly.verify.dw.a(fileOutputStream);
                        if (android.text.TextUtils.isEmpty(str3)) {
                            long currentTimeMillis4 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                            this.l = currentTimeMillis4;
                            str3 = java.lang.String.format("dhs d %d", java.lang.Long.valueOf(currentTimeMillis4));
                        }
                        cn.fly.verify.ed.a().a(str3, new java.lang.Object[0]);
                        return "";
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(fileOutputStream);
                        if (android.text.TextUtils.isEmpty(str3)) {
                            long currentTimeMillis5 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                            this.l = currentTimeMillis5;
                            str3 = java.lang.String.format("dhs d %d", java.lang.Long.valueOf(currentTimeMillis5));
                        }
                        cn.fly.verify.ed.a().a(str3, new java.lang.Object[0]);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.HashMap<java.lang.String, java.lang.Object> a(java.io.File file, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String d2 = cn.fly.verify.bl.a().d();
        if (android.text.TextUtils.isEmpty(d2)) {
            d2 = cn.fly.verify.fm.a(hashMap);
        }
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>();
        if (this.c == null) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap3 = new java.util.HashMap<>();
            this.c = hashMap3;
            hashMap3.put("cacheMap", new java.util.concurrent.ConcurrentHashMap());
            this.c.put("invokeTimesMap", new java.util.concurrent.ConcurrentHashMap());
            this.c.put("expireTimeMap", new java.util.concurrent.ConcurrentHashMap());
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            cn.fly.verify.ce.a(cn.fly.verify.ax.g(), file.getAbsolutePath(), d2, hashMap2, this.c);
            this.k = java.lang.System.currentTimeMillis() - currentTimeMillis;
            cn.fly.verify.ed.a().a(android.text.TextUtils.isEmpty(null) ? java.lang.String.format("dhs l %d", java.lang.Long.valueOf(this.k)) : null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                r7 = "dhs l e: " + th.getMessage();
                hashMap2.clear();
                cn.fly.verify.dh.a().a(5, b(), th, "" + str);
                cn.fly.verify.ed.a().a(th);
            } catch (java.lang.Throwable unused) {
            }
            this.k = java.lang.System.currentTimeMillis() - currentTimeMillis;
            if (android.text.TextUtils.isEmpty(r7)) {
                r7 = java.lang.String.format("dhs l %d", java.lang.Long.valueOf(this.k));
            }
            cn.fly.verify.ed.a().a(r7, new java.lang.Object[0]);
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.io.File file) {
        if (this.g != null && this.g.exists()) {
            if (this.g.delete()) {
                cn.fly.verify.ed.a().a("dhs dof succ", new java.lang.Object[0]);
            } else {
                cn.fly.verify.ed.a().a("dhs dof fail", new java.lang.Object[0]);
            }
        }
        this.g = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File b(java.io.File file, java.lang.String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        d(str);
        return new java.io.File(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String b(java.lang.String str) {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2) {
            return null;
        }
        return split[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String c(java.lang.String str) {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2) {
            return null;
        }
        return split[1];
    }

    public static boolean c() {
        return d;
    }

    private void d(java.lang.String str) {
        java.io.File b = cn.fly.verify.fq.b(this.b, str);
        if (!b.exists() || b.length() <= 0) {
            return;
        }
        b.delete();
    }

    private java.lang.String e() {
        try {
            java.lang.String str = (java.lang.String) cn.fly.verify.bo.b(cn.fly.verify.dn.a("002Fdfdf"), (java.lang.Object) null);
            return str == null ? (java.lang.String) cn.fly.verify.bo.b(cn.fly.verify.dn.a("009XdfdcbhchddbgIgaf"), (java.lang.Object) null) : str;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(b(str)) || android.text.TextUtils.isEmpty(c(str))) ? false : true;
    }

    public final java.util.concurrent.CountDownLatch a() {
        return a(e());
    }

    public final java.util.concurrent.CountDownLatch a(java.lang.String str) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        cn.fly.verify.ed.a().a("dhs ofr: " + countDownLatch, new java.lang.Object[0]);
        this.h.offer(countDownLatch);
        cn.fly.verify.ea.f.execute(new cn.fly.verify.ei.AnonymousClass1(str, countDownLatch));
        return countDownLatch;
    }

    public void a(int i) {
        this.j = i;
    }

    public int b() {
        return this.j;
    }

    public java.util.concurrent.CountDownLatch d() {
        java.util.concurrent.ConcurrentLinkedQueue<java.util.concurrent.CountDownLatch> concurrentLinkedQueue = this.h;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        return this.h.peek();
    }
}
