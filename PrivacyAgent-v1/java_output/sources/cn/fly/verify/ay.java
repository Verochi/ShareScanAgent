package cn.fly.verify;

/* loaded from: classes.dex */
public final class ay {
    private boolean a = false;
    private final byte[] b = new byte[0];

    /* renamed from: cn.fly.verify.ay$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ cn.fly.verify.bd a;
        final /* synthetic */ cn.fly.verify.fv b;

        public AnonymousClass1(cn.fly.verify.bd bdVar, cn.fly.verify.fv fvVar) {
            this.a = bdVar;
            this.b = fvVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008c A[Catch: all -> 0x00a9, Merged into TryCatch #1 {all -> 0x00ac, blocks: (B:3:0x0001, B:4:0x0007, B:28:0x00ab, B:6:0x0008, B:11:0x002e, B:13:0x008c, B:15:0x0092, B:16:0x0094, B:19:0x00a2, B:24:0x009d), top: B:2:0x0001 }] */
        @Override // cn.fly.verify.fh.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(cn.fly.verify.fh.b bVar) {
            boolean z;
            try {
                synchronized (cn.fly.verify.ay.this.b) {
                    java.lang.String a = cn.fly.verify.ay.this.a(cn.fly.verify.df.a, bVar);
                    java.util.HashMap e = cn.fly.verify.ay.this.e();
                    boolean a2 = cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e, bVar);
                    boolean f = cn.fly.verify.ay.this.f();
                    cn.fly.verify.ay ayVar = cn.fly.verify.ay.this;
                    if (!a2 && !f) {
                        z = false;
                        ayVar.a = z;
                        boolean a3 = cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e, this.a, bVar);
                        cn.fly.verify.ed.a().a("map: " + e + "\nisCh: " + a2 + ", isG: " + f + ", isReg: " + a3, ", udif:" + cn.fly.verify.ay.this.a);
                        if (cn.fly.verify.ay.this.a) {
                            if (android.text.TextUtils.isEmpty(a)) {
                                a = cn.fly.verify.df.a;
                            }
                            cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e, a, bVar);
                        }
                        if (!a2 || a3) {
                            cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e);
                        }
                    }
                    z = true;
                    ayVar.a = z;
                    boolean a32 = cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e, this.a, bVar);
                    cn.fly.verify.ed.a().a("map: " + e + "\nisCh: " + a2 + ", isG: " + f + ", isReg: " + a32, ", udif:" + cn.fly.verify.ay.this.a);
                    if (cn.fly.verify.ay.this.a) {
                    }
                    if (!a2) {
                    }
                    cn.fly.verify.ay.this.a((java.util.HashMap<java.lang.String, java.lang.Object>) e);
                }
            } finally {
                this.b.a(null);
            }
        }
    }

    /* renamed from: cn.fly.verify.ay$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.dp {
        final /* synthetic */ java.util.HashMap a;

        public AnonymousClass2(java.util.HashMap hashMap) {
            this.a = hashMap;
        }

        @Override // cn.fly.verify.dp
        public boolean a(cn.fly.verify.fj fjVar) {
            cn.fly.verify.fq.a(cn.fly.verify.ay.this.d(), cn.fly.verify.ay.b(cn.fly.verify.fh.d.j(), this.a));
            return false;
        }
    }

    public class a implements cn.fly.verify.bd {
        public a() {
        }

        @Override // cn.fly.verify.bd
        public java.lang.String a() {
            return cn.fly.verify.dn.a("006Heieefafaeecf");
        }

        @Override // cn.fly.verify.bd
        public int b() {
            return cn.fly.verify.ax.a;
        }
    }

    public static class b {
        private java.lang.String a;
        private long b;
        private java.lang.String c;
        private long d;
        private java.lang.String e;

        public b(java.lang.String str, long j, java.lang.String str2, long j2, java.lang.String str3) {
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = j2;
            this.e = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x00a6, TryCatch #0 {all -> 0x00a6, blocks: (B:6:0x0007, B:9:0x001f, B:12:0x0027, B:14:0x0035, B:17:0x003e, B:19:0x0050, B:22:0x0059, B:24:0x0063, B:26:0x0067, B:27:0x007b, B:29:0x0083, B:31:0x0087, B:33:0x009c, B:36:0x008f, B:38:0x0093, B:40:0x006e, B:42:0x0072), top: B:5:0x0007 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static cn.fly.verify.ay.b a(java.lang.String str) {
            long j;
            java.lang.Object obj;
            long j2;
            long intValue;
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.util.HashMap a = cn.fly.verify.fm.a(str);
                    java.lang.String str2 = (java.lang.String) a.get(cn.fly.verify.dn.a("004Hbabebgba"));
                    if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.equals(com.igexin.push.core.b.m, str2)) {
                        str2 = null;
                    }
                    java.lang.String str3 = (java.lang.String) a.get("genType");
                    java.lang.String str4 = (android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.equals(com.igexin.push.core.b.m, str3)) ? null : str3;
                    java.lang.String str5 = (java.lang.String) a.get(cn.fly.verify.dn.a("002Tcc(h"));
                    java.lang.String str6 = (android.text.TextUtils.isEmpty(str5) || android.text.TextUtils.equals(com.igexin.push.core.b.m, str5)) ? null : str5;
                    java.lang.Object obj2 = a.get("gt");
                    if (obj2 != null) {
                        if (obj2 instanceof java.lang.Long) {
                            j = ((java.lang.Long) obj2).longValue();
                        } else if (obj2 instanceof java.lang.Integer) {
                            j = ((java.lang.Integer) obj2).intValue();
                        }
                        obj = a.get("expTime");
                        if (obj != null) {
                            if (obj instanceof java.lang.Long) {
                                intValue = ((java.lang.Long) obj).longValue();
                            } else if (obj instanceof java.lang.Integer) {
                                intValue = ((java.lang.Integer) obj).intValue();
                            }
                            j2 = intValue;
                            return new cn.fly.verify.ay.b(str2, j, str4, j2, str6);
                        }
                        j2 = 0;
                        return new cn.fly.verify.ay.b(str2, j, str4, j2, str6);
                    }
                    j = 0;
                    obj = a.get("expTime");
                    if (obj != null) {
                    }
                    j2 = 0;
                    return new cn.fly.verify.ay.b(str2, j, str4, j2, str6);
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
            return null;
        }

        public java.lang.String a() {
            return cn.fly.verify.fm.a((java.util.HashMap) b());
        }

        public boolean a(long j) {
            long j2 = this.d;
            return j2 == 0 || j + (j2 * 1000) <= java.lang.System.currentTimeMillis();
        }

        public java.util.HashMap<java.lang.String, java.lang.Object> b() {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            hashMap.put(cn.fly.verify.dn.a("0047babebgba"), this.a);
            hashMap.put("gt", java.lang.Long.valueOf(this.b));
            hashMap.put("genType", this.c);
            hashMap.put("expTime", java.lang.Long.valueOf(this.d));
            hashMap.put(cn.fly.verify.dn.a("002Wcc<h"), this.e);
            return hashMap;
        }

        public java.lang.String c() {
            return this.a;
        }

        public long d() {
            return this.b;
        }

        public java.lang.String e() {
            return this.c;
        }

        public long f() {
            return this.d;
        }

        public java.lang.String g() {
            return this.e;
        }
    }

    public static class c {
        private static final java.util.List<java.lang.String> a = java.util.Arrays.asList("4c5f81a0-4728-476f-a57f-b46fa44f07d3", "f6af99e2-2b64-4eb6-aba6-4d44fb935939", "00000000-0000-0000-0000-000000000000");
        private java.util.List<java.lang.String> b;

        /* renamed from: cn.fly.verify.ay$c$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.fh.a {
            final /* synthetic */ java.lang.String[] a;
            final /* synthetic */ java.util.concurrent.CountDownLatch b;

            public AnonymousClass1(java.lang.String[] strArr, java.util.concurrent.CountDownLatch countDownLatch) {
                this.a = strArr;
                this.b = countDownLatch;
            }

            @Override // cn.fly.verify.fh.a
            public void a(cn.fly.verify.fh.b bVar) throws java.lang.Throwable {
                try {
                    this.a[0] = bVar.k();
                } finally {
                    this.b.countDown();
                }
            }
        }

        private c() {
        }

        public /* synthetic */ c(cn.fly.verify.ay.AnonymousClass1 anonymousClass1) {
            this();
        }

        private java.lang.String a(long j) {
            java.lang.String uuid = java.util.UUID.randomUUID().toString();
            return android.text.TextUtils.isEmpty(uuid) ? b(j) : uuid;
        }

        private java.lang.String b(long j) {
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.io.DataOutputStream dataOutputStream;
            java.lang.String str = null;
            try {
                long nextLong = new java.security.SecureRandom().nextLong();
                long currentTimeMillis = j + java.lang.System.currentTimeMillis();
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                    try {
                        dataOutputStream.writeLong(nextLong);
                        dataOutputStream.writeLong(currentTimeMillis);
                        str = cn.fly.verify.fi.b(byteArrayOutputStream.toByteArray());
                        cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                            return str;
                        } catch (java.lang.Throwable th2) {
                            cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            }
            return str;
        }

        private void c() {
            cn.fly.verify.ay.d i = cn.fly.verify.ax.a + 30 >= d() ? cn.fly.verify.bl.a().i() : e();
            if (i != null && i.c() != null) {
                this.b = i.c();
            }
            if (this.b == null) {
                this.b = a;
            }
        }

        private int d() {
            return java.lang.Integer.parseInt(new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date()));
        }

        private cn.fly.verify.ay.d e() {
            try {
                cn.fly.verify.fc fcVar = new cn.fly.verify.fc();
                cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
                aVar.b = 2000;
                aVar.a = 5000;
                java.lang.String b = fcVar.b(cn.fly.verify.dj.a().a("dg") + "/getDuidBlacklist", null, null, aVar);
                java.util.HashMap a2 = cn.fly.verify.fm.a(b);
                if (a2 != null && !a2.isEmpty()) {
                    if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a2.get(cn.fly.verify.dn.a("006:dfTgbg4bedf"))))) {
                        throw new java.lang.Throwable("RS is illegal: " + b);
                    }
                    java.lang.String valueOf = java.lang.String.valueOf(a2.get(cn.fly.verify.dn.a("0041baKbgb")));
                    if (!android.text.TextUtils.isEmpty(valueOf)) {
                        cn.fly.verify.ay.d a3 = cn.fly.verify.ay.d.a(cn.fly.verify.fi.a(f(), android.util.Base64.decode(valueOf, 0)));
                        cn.fly.verify.bl.a().a(a3);
                        return a3;
                    }
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
            return null;
        }

        private java.lang.String f() {
            java.lang.String[] strArr = {"QvxJJ", "FYsAX", "cvWe", "MqlWJL"};
            return strArr[1] + strArr[3] + new java.lang.String[]{"akuRE", "wbMqR", "uBs", "CDpnc"}[3];
        }

        public cn.fly.verify.ay.b a() {
            c();
            return b();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[Catch: all -> 0x00d8, TryCatch #1 {all -> 0x00d8, blocks: (B:6:0x0026, B:9:0x0032, B:12:0x0060, B:14:0x0066, B:15:0x0070, B:21:0x00a8, B:22:0x00b9, B:29:0x009e, B:31:0x004a, B:33:0x0052, B:35:0x005c, B:37:0x002e, B:17:0x008e, B:19:0x0094), top: B:5:0x0026, inners: #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public cn.fly.verify.ay.b b() {
            java.lang.String str;
            boolean z = true;
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            java.lang.String[] strArr = new java.lang.String[1];
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).k().a(new cn.fly.verify.ay.c.AnonymousClass1(strArr, countDownLatch));
            try {
                countDownLatch.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Throwable unused) {
            }
            try {
                java.lang.String j = cn.fly.verify.fh.d.j();
                java.lang.String trim = j == null ? null : j.trim();
                java.lang.String ah = cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ah();
                if (android.text.TextUtils.isEmpty(ah)) {
                    ah = (android.text.TextUtils.isEmpty(strArr[0]) || this.b.contains(strArr[0])) ? null : strArr[0];
                }
                if (android.text.TextUtils.isEmpty(ah)) {
                    ah = a(android.os.SystemClock.elapsedRealtime());
                } else {
                    z = false;
                }
                java.lang.String str2 = trim + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ah + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ((java.lang.Object) null) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ((java.lang.Object) null);
                try {
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
                if (!android.text.TextUtils.isEmpty(str2)) {
                    str = cn.fly.verify.fi.b(cn.fly.verify.fi.a(str2));
                    if (z) {
                        str = "s_" + str;
                    }
                    cn.fly.verify.ay.b bVar = new cn.fly.verify.ay.b(str, java.lang.System.currentTimeMillis(), "client", 0L, android.util.Base64.encodeToString(str2.getBytes(), 2));
                    cn.fly.verify.bl.a().a(bVar);
                    return bVar;
                }
                str = null;
                if (z) {
                }
                cn.fly.verify.ay.b bVar2 = new cn.fly.verify.ay.b(str, java.lang.System.currentTimeMillis(), "client", 0L, android.util.Base64.encodeToString(str2.getBytes(), 2));
                cn.fly.verify.bl.a().a(bVar2);
                return bVar2;
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().a(th2);
                return null;
            }
        }
    }

    public static class d {
        private java.util.List<java.lang.String> a;
        private java.util.List<java.lang.String> b;

        public d(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
            this.a = list;
            this.b = list2;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:6:0x0007, B:8:0x0013, B:10:0x0017, B:11:0x0026, B:13:0x002e, B:15:0x0032, B:16:0x0041, B:19:0x0039, B:21:0x003d, B:23:0x001e, B:25:0x0022), top: B:5:0x0007 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static cn.fly.verify.ay.d a(java.lang.String str) {
            java.util.List<java.lang.String> list;
            java.lang.Object obj;
            java.util.List<java.lang.String> list2;
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.util.HashMap a = cn.fly.verify.fm.a(str);
                    java.lang.Object obj2 = a.get("idfas");
                    if (obj2 != null) {
                        if (obj2 instanceof java.lang.String) {
                            list = b((java.lang.String) obj2);
                        } else if (obj2 instanceof java.util.List) {
                            list = (java.util.List) obj2;
                        }
                        obj = a.get("oiid");
                        if (obj != null) {
                            if (obj instanceof java.lang.String) {
                                list2 = b((java.lang.String) obj);
                            } else if (obj instanceof java.util.List) {
                                list2 = (java.util.List) obj;
                            }
                            return new cn.fly.verify.ay.d(list, list2);
                        }
                        list2 = null;
                        return new cn.fly.verify.ay.d(list, list2);
                    }
                    list = null;
                    obj = a.get("oiid");
                    if (obj != null) {
                    }
                    list2 = null;
                    return new cn.fly.verify.ay.d(list, list2);
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
            return null;
        }

        private static java.util.List<java.lang.String> b(java.lang.String str) {
            java.lang.String[] split;
            return (android.text.TextUtils.isEmpty(str) || (split = str.split(",")) == null || split.length <= 0) ? new java.util.ArrayList() : new java.util.ArrayList(java.util.Arrays.asList(split));
        }

        public java.lang.String a() {
            return cn.fly.verify.fm.a((java.util.HashMap) b());
        }

        public java.util.HashMap<java.lang.String, java.lang.Object> b() {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            hashMap.put("idfas", this.a);
            hashMap.put("oiid", this.b);
            return hashMap;
        }

        public java.util.List<java.lang.String> c() {
            return this.a;
        }

        public java.util.List<java.lang.String> d() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str, cn.fly.verify.fh.b bVar) {
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
        if (!cn.fly.verify.bo.c()) {
            return null;
        }
        cn.fly.verify.ay.b j = cn.fly.verify.bl.a().j();
        if (j != null && !j.a(cn.fly.verify.bl.a().b("key_request_duid_time", 0L)) && !cn.fly.verify.dz.a().d()) {
            return null;
        }
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put(cn.fly.verify.dn.a("004hebg"), 1);
        hashMap.put(cn.fly.verify.dn.a("005'bdcbbaXde"), cn.fly.verify.fh.d.j());
        hashMap.put(cn.fly.verify.dn.a("0077cd3bag9cbbhbi"), cn.fly.verify.fh.d.k());
        hashMap.put("admt", bVar.k());
        hashMap.put("oamt", cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ah());
        hashMap.put("btt", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
        hashMap.put(cn.fly.verify.dn.a("004[bhbabgba"), cn.fly.verify.dz.a().e());
        hashMap.put("v", cn.fly.verify.dz.a().b());
        hashMap.put(cn.fly.verify.dn.a("004h]bebgba"), cn.fly.verify.dz.a().g());
        hashMap.put(cn.fly.verify.dn.a("0055babhbdbgba"), cn.fly.verify.dz.a().h());
        hashMap.put(cn.fly.verify.dn.a("008gOcb]hBbfbabhbddf"), cn.fly.verify.dz.a().i());
        if (j == null) {
            hashMap.put(cn.fly.verify.dn.a("004@babebgba"), str);
            hashMap.put("genType", "common");
        } else {
            hashMap.put(cn.fly.verify.dn.a("004Ubabebgba"), j.c());
            hashMap.put("gt", java.lang.Long.valueOf(j.d()));
            hashMap.put("genType", j.e());
            hashMap.put("expTime", java.lang.Long.valueOf(j.f()));
            hashMap.put(cn.fly.verify.dn.a("002$cc,h"), j.g());
        }
        java.util.HashMap hashMap2 = (java.util.HashMap) new cn.fly.verify.fb(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd").b(true, null, hashMap, cn.fly.verify.dj.a().a("dg") + "/v4/dgen", true);
        if (hashMap2 != null) {
            cn.fly.verify.bl.a().a("key_request_duid_time", java.lang.System.currentTimeMillis());
            java.lang.String str2 = (java.lang.String) hashMap2.get(cn.fly.verify.dn.a("004Xbhbabgba"));
            if (!android.text.TextUtils.isEmpty(str2)) {
                cn.fly.verify.dz.a().a(str2);
            }
            cn.fly.verify.ay.b a2 = cn.fly.verify.ay.b.a(cn.fly.verify.fm.a(hashMap2));
            if (a2 != null) {
                cn.fly.verify.bl.a().a(a2);
                return a2.c();
            }
        }
        return null;
    }

    private static java.util.HashMap<java.lang.String, java.lang.Object> a(java.lang.String str, byte[] bArr) throws java.lang.Throwable {
        return cn.fly.verify.fm.a(cn.fly.verify.fi.a(str, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.c), new cn.fly.verify.ay.AnonymousClass2(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str, cn.fly.verify.fh.b bVar) {
        try {
            if (cn.fly.verify.bo.c()) {
                java.util.HashMap hashMap2 = (java.util.HashMap) hashMap.get(cn.fly.verify.dn.a("0105baCd=bbbg3ad!cgFcJcdcb"));
                java.util.HashMap hashMap3 = new java.util.HashMap();
                hashMap3.put(cn.fly.verify.dn.a("005g,cbbj;dc"), cn.fly.verify.bm.a().b());
                for (java.util.Map.Entry entry : hashMap2.entrySet()) {
                    hashMap3.put(entry.getKey(), entry.getValue());
                }
                try {
                    hashMap3.put(cn.fly.verify.dn.a("007ab.bhbhbgHd$bh"), java.lang.Integer.valueOf(java.lang.Integer.parseInt(java.lang.String.valueOf(hashMap3.get(cn.fly.verify.dn.a("007ab!bhbhbgNd2bh"))))));
                } catch (java.lang.Throwable unused) {
                }
                hashMap3.put(cn.fly.verify.dn.a("0040babebgba"), str);
                java.util.HashMap<java.lang.String, java.lang.Long> o = bVar.o();
                java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> n = bVar.n();
                if (o != null) {
                    hashMap3.put(cn.fly.verify.dn.a("003?bh_b'bd"), o.get(cn.fly.verify.dn.a("005g8cb@gbe")));
                }
                if (n != null) {
                    java.util.HashMap<java.lang.String, java.lang.Long> hashMap4 = n.get(cn.fly.verify.dn.a("006]dfba abWbhba"));
                    if (hashMap4 != null) {
                        hashMap3.put(cn.fly.verify.dn.a("013;dfbaWabMbhbachPg7cbbh4b5cc;d"), hashMap4.get(cn.fly.verify.dn.a("005gWcb)gbe")));
                    }
                    java.util.HashMap<java.lang.String, java.lang.Long> hashMap5 = n.get(cn.fly.verify.dn.a("004Zba>bgb"));
                    if (hashMap5 != null) {
                        hashMap3.put(cn.fly.verify.dn.a("011$baTbgb,chRgNcbbh6bOcc'd"), hashMap5.get(cn.fly.verify.dn.a("005gUcbWgbe")));
                    }
                }
                hashMap3.put(cn.fly.verify.dn.a("006Gbhcbbdcgbdcc"), bVar.p());
                java.lang.String encodeToString = android.util.Base64.encodeToString(cn.fly.verify.fi.a(c(), cn.fly.verify.fm.a(hashMap3)), 2);
                java.util.HashMap<java.lang.String, java.lang.Object> hashMap6 = new java.util.HashMap<>();
                hashMap6.put(com.anythink.expressad.d.a.b.dH, encodeToString);
                cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
                aVar.a = 30000;
                aVar.b = 30000;
                cn.fly.verify.fc fcVar = new cn.fly.verify.fc();
                java.lang.String str2 = cn.fly.verify.dj.a().a("dg") + cn.fly.verify.dn.a("006jFbabgVcCcdcb");
                java.util.HashMap<java.lang.String, java.lang.String> hashMap7 = new java.util.HashMap<>();
                hashMap7.put(cn.fly.verify.dn.a("013!cedf2dIbhficgba<dcgCbg=gHbi"), cn.fly.verify.bk.c());
                hashMap7.put(cn.fly.verify.dn.a("004[bdcbbgba"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ai());
                if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(cn.fly.verify.fm.a(fcVar.b(str2, hashMap6, hashMap7, aVar)).get(cn.fly.verify.dn.a("006(df;gbgSbedf"))))) {
                    cn.fly.verify.bl.a().a(cn.fly.verify.bl.a, java.lang.System.currentTimeMillis());
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private boolean a(cn.fly.verify.bd bdVar, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, cn.fly.verify.fh.b bVar) throws java.lang.Throwable {
        if (!cn.fly.verify.bo.c()) {
            return false;
        }
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>();
        hashMap2.put(cn.fly.verify.dn.a("007hUbhcbbabeZag"), bdVar.a());
        cn.fly.verify.ay.b j = cn.fly.verify.bl.a().j();
        java.lang.String c2 = j != null ? j.c() : null;
        java.lang.String valueOf = java.lang.String.valueOf(cn.fly.verify.fh.d.c());
        hashMap2.put(cn.fly.verify.dn.a("006bhhVbj8dWbi"), cn.fly.verify.dv.a());
        hashMap2.put(cn.fly.verify.dn.a("004Qbabebgba"), c2);
        hashMap2.put(cn.fly.verify.dn.a("006bhhh>bjcc"), valueOf);
        hashMap2.put(cn.fly.verify.dn.a("006bhh8bbMd$bh"), java.lang.String.valueOf(cn.fly.verify.fh.d.m()));
        hashMap2.put(cn.fly.verify.dn.a("006OdfbabjbbEd(bh"), java.lang.String.valueOf(bdVar.b()));
        hashMap2.put(cn.fly.verify.dn.a("007cdg.ddcbbhbj"), java.lang.String.valueOf(bVar.g()));
        java.lang.String str = cn.fly.verify.dj.a().a("dg") + cn.fly.verify.dn.a("006j%badfbgccYc");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap3 = new java.util.HashMap<>();
        hashMap3.put(cn.fly.verify.dn.a("013Icedf8d6bhficgba5dcgBbgNg$bi"), cn.fly.verify.bk.c());
        hashMap3.put(cn.fly.verify.dn.a("004*bdcbbgba"), bVar.A());
        cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
        aVar.a = 10000;
        aVar.b = 10000;
        java.util.HashMap a2 = cn.fly.verify.fm.a(new cn.fly.verify.fc().b(str, hashMap2, hashMap3, aVar));
        if (cn.fly.verify.dn.a("004gFbhbeOd").equals(java.lang.String.valueOf(a2.get(cn.fly.verify.dn.a("004XbhLdBbeOh"))))) {
            this.a = true;
        }
        if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a2.get(cn.fly.verify.dn.a("006EdfJgbgEbedf"))))) {
            return false;
        }
        java.util.HashMap hashMap4 = (java.util.HashMap) hashMap.get(cn.fly.verify.dn.a("007bhhPcg^cWcdcb"));
        java.util.HashMap hashMap5 = (java.util.HashMap) hashMap4.get(valueOf);
        if (hashMap5 == null) {
            hashMap5 = new java.util.HashMap();
        }
        hashMap5.put(bdVar.a(), cn.fly.verify.dv.a());
        hashMap4.put(valueOf, hashMap5);
        hashMap.put(cn.fly.verify.dn.a("007bhh7cgVc;cdcb"), hashMap4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, cn.fly.verify.bd bdVar, cn.fly.verify.fh.b bVar) {
        if (bdVar == null) {
            bdVar = new cn.fly.verify.ay.a();
        }
        boolean z = false;
        try {
            java.util.HashMap hashMap2 = (java.util.HashMap) hashMap.get(cn.fly.verify.dn.a("007bhh^cg^cPcdcb"));
            if (hashMap2 == null) {
                hashMap2 = new java.util.HashMap();
                hashMap.put(cn.fly.verify.dn.a("007bhh[cgYc1cdcb"), hashMap2);
                z = true;
            }
            java.util.HashMap hashMap3 = (java.util.HashMap) hashMap2.get(cn.fly.verify.fh.d.c());
            java.lang.String str = hashMap3 != null ? (java.lang.String) hashMap3.get(bdVar.a()) : null;
            java.lang.String a2 = cn.fly.verify.dv.a();
            if (str == null || !str.equals(a2)) {
                if (a(bdVar, hashMap, bVar)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, cn.fly.verify.fh.b bVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int i = 0;
        if (hashMap == null) {
            hashMap = new java.util.HashMap<>();
            z = true;
        } else {
            z = false;
        }
        java.util.HashMap hashMap2 = (java.util.HashMap) hashMap.get(cn.fly.verify.dn.a("010]baKdKbbbgYad>cgYcLcdcb"));
        if (hashMap2 == null) {
            hashMap2 = new java.util.HashMap();
            hashMap.put(cn.fly.verify.dn.a("010Pba,dDbbbgSadWcgAcQcdcb"), hashMap2);
            z = true;
        }
        java.lang.Object obj = hashMap2.get("admt");
        java.lang.String k = bVar.k();
        if (k == null || k.equals(obj)) {
            z2 = false;
        } else {
            hashMap2.put("admt", k);
            z2 = true;
        }
        java.lang.Object obj2 = hashMap2.get(cn.fly.verify.dn.a("004XcbMb;bgba"));
        java.lang.String ah = cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ah();
        if ((obj2 == null && !android.text.TextUtils.isEmpty(ah)) || (obj2 != null && !java.lang.String.valueOf(obj2).equals(ah))) {
            hashMap2.put(cn.fly.verify.dn.a("004Gcb3bXbgba"), ah);
            z2 = true;
            i = 1;
        }
        java.lang.Object obj3 = hashMap2.get(cn.fly.verify.dn.a("004Qbhbabgba"));
        java.lang.String c2 = cn.fly.verify.dz.a().c();
        if ((obj3 == null && !android.text.TextUtils.isEmpty(c2)) || (obj3 != null && !java.lang.String.valueOf(obj3).equals(c2))) {
            hashMap2.put(cn.fly.verify.dn.a("0041bhbabgba"), c2);
            i |= 2;
            z2 = true;
        }
        java.lang.Object obj4 = hashMap2.get(cn.fly.verify.dn.a("005 babhbdbgba"));
        java.lang.String h = cn.fly.verify.dz.a().h();
        if ((obj4 == null && !android.text.TextUtils.isEmpty(h)) || (obj4 != null && !java.lang.String.valueOf(obj4).equals(h))) {
            hashMap2.put(cn.fly.verify.dn.a("005.babhbdbgba"), h);
            i |= 4;
            z2 = true;
        }
        java.lang.Object obj5 = hashMap2.get(cn.fly.verify.dn.a("004h@bebgba"));
        java.lang.String g = cn.fly.verify.dz.a().g();
        if ((obj5 == null && !android.text.TextUtils.isEmpty(g)) || (obj5 != null && !java.lang.String.valueOf(obj5).equals(g))) {
            hashMap2.put(cn.fly.verify.dn.a("004hQbebgba"), g);
            i |= 8;
            z2 = true;
        }
        java.lang.Object obj6 = hashMap2.get("v");
        java.lang.String b2 = cn.fly.verify.dz.a().b();
        if ((obj6 == null && !android.text.TextUtils.isEmpty(b2)) || (obj6 != null && !java.lang.String.valueOf(obj6).equals(b2))) {
            hashMap2.put("v", b2);
            z2 = true;
        }
        hashMap2.put("cid_modify", java.lang.Integer.valueOf(i));
        if (z2) {
            z = true;
        }
        java.lang.Object obj7 = hashMap2.get(cn.fly.verify.dn.a("0054bdcbbaFde"));
        java.lang.String j = cn.fly.verify.fh.d.j();
        if (j != null && !j.equals(obj7)) {
            hashMap2.put(cn.fly.verify.dn.a("0055bdcbba6de"), j);
            z = true;
        }
        java.lang.Object obj8 = hashMap2.get(cn.fly.verify.dn.a("007EcdXbag.cbbhbi"));
        java.lang.String k2 = cn.fly.verify.fh.d.k();
        if (k2 != null && !k2.equals(obj8)) {
            hashMap2.put(cn.fly.verify.dn.a("0075cd!bag_cbbhbi"), k2);
            z = true;
        }
        java.lang.Object obj9 = hashMap2.get(cn.fly.verify.dn.a("007abNbhbhbg1dUbh"));
        java.lang.String d2 = bVar.d();
        if (d2 != null && !d2.equals(obj9)) {
            hashMap2.put(cn.fly.verify.dn.a("007abAbhbhbg>d)bh"), d2);
            z = true;
        }
        java.lang.Object obj10 = hashMap2.get(cn.fly.verify.dn.a("006'dfbidfbbQd0bh"));
        java.lang.String h2 = cn.fly.verify.fh.d.h();
        if (h2 != null && !h2.equals(obj10)) {
            hashMap2.put(cn.fly.verify.dn.a("006?dfbidfbb[d1bh"), h2);
            z = true;
        }
        java.lang.Object obj11 = hashMap2.get(cn.fly.verify.dn.a("002BcaXh"));
        boolean q = bVar.q();
        if (obj11 == null || !java.lang.String.valueOf(q ? 1 : 0).equals(java.lang.String.valueOf(obj11))) {
            hashMap2.put(cn.fly.verify.dn.a("002)ca:h"), java.lang.Integer.valueOf(q ? 1 : 0));
            z = true;
        }
        java.lang.Object obj12 = hashMap2.get(cn.fly.verify.dn.a("007%dcbhFdb?bjUdEba"));
        boolean a2 = bVar.a();
        hashMap2.put(cn.fly.verify.dn.a("007Zdcbh'db-bj?d_ba"), java.lang.Boolean.valueOf(a2));
        if ((obj12 == null && a2) || (obj12 != null && !java.lang.String.valueOf(obj12).equals(java.lang.String.valueOf(a2)))) {
            z = true;
        }
        java.lang.String valueOf = java.lang.String.valueOf(hashMap2.get("prelangmt"));
        java.lang.String valueOf2 = java.lang.String.valueOf(bVar.B());
        if (!android.text.TextUtils.equals(valueOf, valueOf2)) {
            hashMap2.put("prelangmt", valueOf2);
            z = true;
        }
        java.lang.Object obj13 = hashMap2.get("gramgendt");
        int C = bVar.C();
        if (obj13 == null || !android.text.TextUtils.equals(java.lang.String.valueOf(obj13), java.lang.String.valueOf(C))) {
            hashMap2.put("gramgendt", java.lang.Integer.valueOf(C));
        } else {
            z3 = z;
        }
        hashMap2.put(cn.fly.verify.dn.a("004hebg"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.e()));
        hashMap2.put(cn.fly.verify.dn.a("010<baMdKbbbg?ad!cibiBhd"), bVar.m());
        hashMap2.put(cn.fly.verify.dn.a("003hbYba"), java.lang.Integer.valueOf(bVar.r() ? 1 : 0));
        hashMap2.put(cn.fly.verify.dn.a("0108df-a,bh3ddcWdfbgeaDd"), bVar.c());
        java.util.HashMap<java.lang.String, java.lang.Object> a3 = cn.fly.verify.bq.a(cn.fly.verify.ax.g());
        if (a3 != null && a3.size() > 0) {
            hashMap2.putAll(a3);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.lang.String a2 = cn.fly.verify.fm.a((java.util.HashMap) hashMap);
        try {
            return cn.fly.verify.fi.a(str, a2);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return a2.getBytes();
        }
    }

    private java.lang.String c() {
        return cn.fly.verify.dn.a("016Sdfbabjdb a;cbbdbdcb,cbhSdbdfbabj");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File d() {
        return cn.fly.verify.fq.a(cn.fly.verify.ax.g(), cn.fly.verify.dn.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.HashMap<java.lang.String, java.lang.Object> e() {
        try {
            return a(cn.fly.verify.fh.d.j(), cn.fly.verify.fq.b(d()));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return new java.util.HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        cn.fly.verify.bl a2 = cn.fly.verify.bl.a();
        java.lang.String str = cn.fly.verify.bl.a;
        long b2 = a2.b(str, -1L);
        if (b2 != -1) {
            return java.lang.System.currentTimeMillis() >= b2 + (((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.dn.a("005WbabgccAbh"), 2592000L)).longValue() * 1000);
        }
        cn.fly.verify.bl.a().a(str, java.lang.System.currentTimeMillis());
        return false;
    }

    public synchronized java.lang.String a() {
        cn.fly.verify.ay.b j = cn.fly.verify.bl.a().j();
        if (j == null || android.text.TextUtils.isEmpty(j.c())) {
            return null;
        }
        return j.c();
    }

    public void a(cn.fly.verify.bd bdVar, cn.fly.verify.fv<java.lang.Void> fvVar) {
        cn.fly.verify.ed.a().a("di init", new java.lang.Object[0]);
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).k().d().o().n().q().a().m().r().c().g().B().A().y().p().C().D().a(new cn.fly.verify.ay.AnonymousClass1(bdVar, fvVar));
    }

    public synchronized java.lang.String b() {
        java.lang.String str;
        java.lang.Throwable th;
        try {
            str = a();
            try {
            } catch (java.lang.Throwable th2) {
                th = th2;
                cn.fly.verify.ed.a().a(th);
                return str;
            }
        } catch (java.lang.Throwable th3) {
            str = null;
            th = th3;
        }
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.equals(com.igexin.push.core.b.m, str)) {
            return str;
        }
        cn.fly.verify.ay.b a2 = new cn.fly.verify.ay.c(null).a();
        if (a2 != null) {
            str = a2.c();
        }
        return str;
    }
}
