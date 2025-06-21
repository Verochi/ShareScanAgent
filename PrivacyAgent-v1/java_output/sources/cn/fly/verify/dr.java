package cn.fly.verify;

/* loaded from: classes.dex */
public class dr {
    public static volatile boolean a;
    private static cn.fly.verify.dr b;
    private java.io.File c;
    private java.math.BigInteger d = new java.math.BigInteger("f53c224aefb38daa0825c1b8ea691b16d2e16db10880548afddd780c6670a091a11dafa954ea4a9483797fda1045d2693a08daa48cf9cedce1e8733b857304cb", 16);
    private java.math.BigInteger e = new java.math.BigInteger("27749621e6ca022469645faed16e8261acf6af822467382d55c24bb9bc02356ab16e76ddc799dc8ba6b4f110411996eeb63505c9dcf969d3fc085d712f0f1a9713b67aa1128d7cc41bda363afb0ec7ade60e542a4e22869395331cc0096de412034551e98bb2629ae1b7168b8bc82006d064ab335d8567283e70beb6a49e9423", 16);

    /* renamed from: cn.fly.verify.dr$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.dp {
        final /* synthetic */ java.lang.Runnable a;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.a = runnable;
        }

        @Override // cn.fly.verify.dp
        public boolean a(cn.fly.verify.fj fjVar) {
            this.a.run();
            return false;
        }
    }

    public static class a implements java.lang.Runnable {
        private int a;
        private int b;
        private java.lang.String c;
        private java.lang.String d;

        /* renamed from: cn.fly.verify.dr$a$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.fy {
            final /* synthetic */ int a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ int c;
            final /* synthetic */ java.lang.String d;

            public AnonymousClass1(int i, java.lang.String str, int i2, java.lang.String str2) {
                this.a = i;
                this.b = str;
                this.c = i2;
                this.d = str2;
            }

            @Override // cn.fly.verify.fy
            public void a() throws java.lang.Throwable {
                cn.fly.verify.ed.a().a("[LGSM] SLR: Ins", new java.lang.Object[0]);
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put(cn.fly.verify.bj.a("010%giedemhk%g-ekgiejfe$f"), java.lang.Integer.valueOf(this.a));
                hashMap.put(cn.fly.verify.bj.a("0068giedemfl7eJff"), this.b);
                hashMap.put(cn.fly.verify.bj.a("004jYelIkg"), java.lang.Integer.valueOf(this.c));
                hashMap.put(cn.fly.verify.bj.a("005g9ekekUej"), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                java.lang.String encode = java.net.URLEncoder.encode(this.d);
                if (android.text.TextUtils.isEmpty(encode)) {
                    encode = this.d;
                }
                hashMap.put(cn.fly.verify.bj.a("003'eggiff"), android.util.Base64.encodeToString(encode.getBytes("utf-8"), 2));
                hashMap.put(cn.fly.verify.bj.a("005j^ejeg!gTgi"), 1);
                cn.fly.verify.ed.a().a("[LGSM] W l " + hashMap, new java.lang.Object[0]);
                cn.fly.verify.dr.b(this.c).a(cn.fly.verify.fm.a(hashMap));
            }
        }

        private a() {
        }

        public /* synthetic */ a(cn.fly.verify.dr.AnonymousClass1 anonymousClass1) {
            this();
        }

        private void b(int i, int i2, java.lang.String str, java.lang.String str2) {
            cn.fly.verify.ed.a().a("[LGSM] SLR: onL", new java.lang.Object[0]);
            if (cn.fly.verify.dr.a().a(new cn.fly.verify.dr.a.AnonymousClass1(i, str, i2, str2)) && cn.fly.verify.dy.b()) {
                cn.fly.verify.ed.a().a("[LGSM] SLR: U", new java.lang.Object[0]);
                cn.fly.verify.ea.c.execute(new cn.fly.verify.dr.c(null));
            }
        }

        public cn.fly.verify.dr.a a(int i, int i2, java.lang.String str, java.lang.String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b(this.a, this.b, this.c, this.d);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().b(th);
            }
        }
    }

    public static class b implements cn.fly.verify.ee.a {
        java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> a;
        int b;
        java.lang.String c;

        private b() {
            this.a = new java.util.ArrayList<>();
            this.b = -1;
        }

        public /* synthetic */ b(cn.fly.verify.dr.AnonymousClass1 anonymousClass1) {
            this();
        }

        private java.util.HashMap<java.lang.String, java.lang.Object> a(cn.fly.verify.fh.b bVar, int i, java.lang.String str) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            hashMap.put(cn.fly.verify.bj.a("0035em?g4el"), cn.fly.verify.dv.a());
            hashMap.put(cn.fly.verify.bj.a("0047edehejed"), cn.fly.verify.df.a((cn.fly.verify.bd) null));
            hashMap.put(cn.fly.verify.bj.a("004khej"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.e()));
            hashMap.put(cn.fly.verify.bj.a("003[giedem"), str);
            hashMap.put(cn.fly.verify.bj.a("006;giedemeeXg<ek"), java.lang.Integer.valueOf(i));
            hashMap.put(cn.fly.verify.bj.a("007ekkfeReg'g"), bVar.i());
            hashMap.put(cn.fly.verify.bj.a("006ekkkQemff"), cn.fly.verify.fh.d.c());
            hashMap.put(cn.fly.verify.bj.a("006ekk<ee<gNek"), java.lang.String.valueOf(cn.fly.verify.fh.d.m()));
            hashMap.put(cn.fly.verify.bj.a("005WegfeedGgh"), cn.fly.verify.fh.d.j());
            if (cn.fly.verify.bo.b()) {
                hashMap.put(cn.fly.verify.bj.a("008^edAg9eeej:dgRejed"), bVar.h());
            }
            hashMap.put(cn.fly.verify.bj.a("0063gielgiee,g%ek"), java.lang.String.valueOf(cn.fly.verify.fh.d.g()));
            hashMap.put(cn.fly.verify.bj.a("011fgj(ggfeekemPj5elGkg"), bVar.g());
            return hashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private java.lang.String b(java.lang.String str) throws java.lang.Throwable {
            java.io.ByteArrayInputStream byteArrayInputStream;
            java.lang.Throwable th;
            byte[] bArr;
            java.util.zip.GZIPOutputStream gZIPOutputStream;
            java.lang.Throwable th2;
            try {
                bArr = str.getBytes();
                byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
                try {
                    try {
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = byteArrayInputStream.read(bArr2, 0, 1024);
                                    if (read == -1) {
                                        gZIPOutputStream.flush();
                                        cn.fly.verify.dw.a(gZIPOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.flush();
                                        java.lang.String encodeToString = android.util.Base64.encodeToString(byteArray, 2);
                                        cn.fly.verify.dw.a(byteArrayOutputStream, byteArrayInputStream);
                                        return encodeToString;
                                    }
                                    gZIPOutputStream.write(bArr2, 0, read);
                                }
                            } catch (java.lang.Throwable th3) {
                                th2 = th3;
                                cn.fly.verify.dw.a(gZIPOutputStream);
                                throw th2;
                            }
                        } catch (java.lang.Throwable th4) {
                            gZIPOutputStream = null;
                            th2 = th4;
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        cn.fly.verify.dw.a(bArr, byteArrayInputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    bArr = null;
                    cn.fly.verify.dw.a(bArr, byteArrayInputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th7) {
                byteArrayInputStream = null;
                th = th7;
                bArr = null;
            }
        }

        @Override // cn.fly.verify.ee.a
        public void a(java.lang.String str) {
            cn.fly.verify.ed.a().a("[LGSM] ULL onRd " + str, new java.lang.Object[0]);
            java.util.HashMap<java.lang.String, java.lang.Object> a = cn.fly.verify.fm.a(str);
            try {
                this.b = java.lang.Integer.parseInt(java.lang.String.valueOf(a.get(cn.fly.verify.bj.a("010Xgiedemhk+gTekgiejfeKf"))));
            } catch (java.lang.Throwable unused) {
            }
            this.c = (java.lang.String) a.get(cn.fly.verify.bj.a("006CgiedemflTe^ff"));
            this.a.add(a);
        }

        @Override // cn.fly.verify.ee.a
        public boolean a(cn.fly.verify.fh.b bVar) {
            java.lang.String b;
            cn.fly.verify.ed.a().a("[LGSM] ULL onUd", new java.lang.Object[0]);
            java.util.HashMap<java.lang.String, java.lang.Object> a = a(bVar, this.b, this.c);
            a.put(cn.fly.verify.bj.a("006gFekekeggiff"), this.a);
            try {
                java.lang.String a2 = cn.fly.verify.fm.a((java.util.HashMap) a);
                this.a.clear();
                b = b(a2);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a("[LGSM] ULL onUd: E", new java.lang.Object[0]);
                cn.fly.verify.ed.a().a(th);
            }
            if (cn.fly.verify.bj.a("004f^fe>fg").equals(bVar.g())) {
                throw new java.lang.IllegalStateException("network is disconnected!");
            }
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            hashMap.put(com.anythink.expressad.d.a.b.dH, b);
            cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
            aVar.a = 10000;
            aVar.b = 10000;
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put(cn.fly.verify.bj.a("0138fhgi:g,ekilfjedDgfj<ejPjOel"), cn.fly.verify.bk.c());
            hashMap2.put(cn.fly.verify.bj.a("004Kegfeejed"), bVar.A());
            java.lang.String str = cn.fly.verify.dj.a().a("el") + "/errlog";
            cn.fly.verify.ed.a().a("[LGSM] ULL onUd: Req", new java.lang.Object[0]);
            java.lang.String b2 = new cn.fly.verify.fc().b(str, hashMap, hashMap2, aVar);
            cn.fly.verify.ed.a().a("[LGSM] ULL onUd: " + java.lang.String.format("Resp(%s): %s", str, b2), new java.lang.Object[0]);
            java.lang.Object obj = cn.fly.verify.fm.a(b2).get(cn.fly.verify.bj.a("006Cgi1jej$ehgi"));
            return (obj != null ? ((java.lang.Integer) obj).intValue() : 0) == 200;
        }
    }

    public static class c implements java.lang.Runnable {
        private java.lang.Runnable a;

        /* renamed from: cn.fly.verify.dr$c$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.fy {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.fy
            public void a() {
                cn.fly.verify.ed.a().a("[LGSM] UCLR", new java.lang.Object[0]);
                cn.fly.verify.dr.b(1).a(new cn.fly.verify.dr.b(null));
            }
        }

        /* renamed from: cn.fly.verify.dr$c$2, reason: invalid class name */
        public class AnonymousClass2 implements cn.fly.verify.fh.a {
            public AnonymousClass2() {
            }

            @Override // cn.fly.verify.fh.a
            public void a(cn.fly.verify.fh.b bVar) {
                if (cn.fly.verify.bj.a("004fHfeHfg").equals(bVar.g())) {
                    return;
                }
                int intValue = ((java.lang.Integer) cn.fly.verify.bo.a(cn.fly.verify.bj.a("004dg<ekek"), 1)).intValue();
                cn.fly.verify.ed.a().a("[LGSM] ULR Ck cerr: " + intValue, new java.lang.Object[0]);
                if (intValue == 1) {
                    cn.fly.verify.dr.a().a(cn.fly.verify.dr.c.this.a);
                } else {
                    cn.fly.verify.dr.b(1).a(((java.lang.Long) cn.fly.verify.bo.a("cerr_max", 104857600L)).longValue());
                }
            }
        }

        private c() {
            this.a = new cn.fly.verify.dr.c.AnonymousClass1();
        }

        public /* synthetic */ c(cn.fly.verify.dr.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (cn.fly.verify.bo.c()) {
                    cn.fly.verify.fh.a(cn.fly.verify.ax.g()).g().a(new cn.fly.verify.dr.c.AnonymousClass2());
                } else {
                    cn.fly.verify.ed.a().a("[LGSM] ULR Ck nt: FBDN", new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
    }

    private dr() {
    }

    public static synchronized cn.fly.verify.dr a() {
        cn.fly.verify.dr drVar;
        synchronized (cn.fly.verify.dr.class) {
            if (b == null) {
                b = new cn.fly.verify.dr();
            }
            drVar = b;
        }
        return drVar;
    }

    private java.lang.String a(java.lang.String str) {
        java.io.DataOutputStream dataOutputStream;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] c2 = cn.fly.verify.dw.c();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] a2 = new cn.fly.verify.fn(1024).a(c2, this.d, this.e);
                    dataOutputStream.writeInt(a2.length);
                    dataOutputStream.write(a2);
                    byte[] a3 = cn.fly.verify.fi.a(c2, str.getBytes("utf-8"));
                    dataOutputStream.writeInt(a3.length);
                    dataOutputStream.write(a3);
                    dataOutputStream.flush();
                    cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                    return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            cn.fly.verify.ed.a().a(th3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.lang.Runnable runnable) {
        if (this.c == null) {
            java.io.File file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.bj.a("005Wge_hFfeSd0em"));
            this.c = file;
            if (!file.exists()) {
                try {
                    this.c.createNewFile();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        return cn.fly.verify.dq.a(this.c, new cn.fly.verify.dr.AnonymousClass1(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.fly.verify.ee b(int i) {
        return new cn.fly.verify.ee(cn.fly.verify.bj.a("0058geegOdhIff"), cn.fly.verify.bj.a("0058geegOdhIff") + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i, 50);
    }

    public int a(int i, java.lang.String str) {
        if (cn.fly.verify.ax.f() != null && a) {
            android.content.Intent intent = new android.content.Intent();
            intent.setPackage(cn.fly.verify.bj.a("015df%gegiJieBek@gSgiedemgeHh-feff"));
            intent.putExtra(cn.fly.verify.bj.a("007kedJemBe^ffTg"), cn.fly.verify.ax.g().getPackageName());
            intent.putExtra(cn.fly.verify.bj.a("008k0ekejfeekejVj_el"), i);
            intent.putExtra("ver", cn.fly.verify.ax.a);
            intent.putExtra(cn.fly.verify.bj.a("003Jeggiff"), a(str));
            cn.fly.verify.fp.a(cn.fly.verify.ax.f(), cn.fly.verify.bj.a("013'giWgfNedgjekfeGeHed,de^giDj"), new java.lang.Object[]{intent}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Intent.class}, 0);
        }
        return 0;
    }

    public void a(int i, java.lang.String str, int i2, java.lang.String str2) {
        cn.fly.verify.ed.a().a("[LGSM] Sd curr", new java.lang.Object[0]);
        if (i == 1) {
            new cn.fly.verify.dr.a(null).a(i2, i, str, str2).run();
        }
    }

    public void b() {
        cn.fly.verify.ed.a().a("[LGSM] Sd last", new java.lang.Object[0]);
        cn.fly.verify.ea.c.execute(new cn.fly.verify.dr.c(null));
    }
}
