package cn.fly.verify;

/* renamed from: cn.fly.verify.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0545r {
    private static volatile cn.fly.verify.C0545r a;

    /* renamed from: cn.fly.verify.r$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ cn.fly.verify.e c;
        final /* synthetic */ cn.fly.verify.common.callback.b d;

        /* renamed from: cn.fly.verify.r$1$1, reason: invalid class name and collision with other inner class name */
        public class C00161 implements cn.fly.verify.fh.a {

            /* renamed from: cn.fly.verify.r$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C00171 extends cn.fly.verify.j.a<java.util.HashMap> {
                final /* synthetic */ java.util.HashMap a;

                public C00171(java.util.HashMap hashMap) {
                    this.a = hashMap;
                }

                @Override // cn.fly.verify.j.a
                public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
                    cn.fly.verify.common.callback.b bVar = cn.fly.verify.C0545r.AnonymousClass1.this.d;
                    if (bVar != null) {
                        bVar.a(verifyException);
                    }
                }

                @Override // cn.fly.verify.j.a
                public void a(java.util.HashMap hashMap) {
                    cn.fly.verify.a b = new cn.fly.verify.a().b(cn.fly.verify.fm.a(hashMap));
                    if (this.a.containsKey(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID)) {
                        b.f = ((java.lang.Integer) this.a.get(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID)).intValue();
                    }
                    cn.fly.verify.common.callback.b bVar = cn.fly.verify.C0545r.AnonymousClass1.this.d;
                    if (bVar != null) {
                        bVar.a((cn.fly.verify.common.callback.b) b);
                    }
                }
            }

            public C00161() {
            }

            @Override // cn.fly.verify.fh.a
            public void a(cn.fly.verify.fh.b bVar) throws java.lang.Throwable {
                try {
                    cn.fly.verify.as.a(bVar.k(0));
                    cn.fly.verify.as.b(bVar.k(1));
                    cn.fly.verify.as.c(bVar.k(2));
                    cn.fly.verify.as.d(bVar.k(3));
                    cn.fly.verify.as.e(bVar.k(4));
                    cn.fly.verify.as.f(bVar.k(5));
                    cn.fly.verify.as.g(bVar.k(6));
                    cn.fly.verify.h a = cn.fly.verify.h.a();
                    cn.fly.verify.C0545r.AnonymousClass1 anonymousClass1 = cn.fly.verify.C0545r.AnonymousClass1.this;
                    java.lang.String str = anonymousClass1.a;
                    java.lang.String str2 = anonymousClass1.b;
                    cn.fly.verify.e eVar = anonymousClass1.c;
                    java.util.HashMap<java.lang.String, java.lang.Object> a2 = a.a(str, str2, eVar != null ? eVar.b() : null);
                    cn.fly.verify.f.a().a("start requestCache with params" + new cn.fly.verify.fl().a((java.util.HashMap) a2));
                    java.lang.String str3 = cn.fly.verify.i.a(2) + "api/usedMobile";
                    cn.fly.verify.e eVar2 = cn.fly.verify.C0545r.AnonymousClass1.this.c;
                    if (eVar2 != null) {
                        eVar2.a(eVar2.b("query_cache"));
                    }
                    cn.fly.verify.j.a(false).a(a2, str3, new cn.fly.verify.C0545r.AnonymousClass1.C00161.C00171(a2));
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.f.a().a(th);
                }
            }
        }

        public AnonymousClass1(java.lang.String str, java.lang.String str2, cn.fly.verify.e eVar, cn.fly.verify.common.callback.b bVar) {
            this.a = str;
            this.b = str2;
            this.c = eVar;
            this.d = bVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).b(cn.fly.verify.as.d("S4B9kH1Lj5WPkIGJS4h9j5BJhIF9gIGOSpCUkA==")).b(cn.fly.verify.as.d("UoeEl4RSlpyWl4iQUpqEl4aLj4yWl4KWiJeXjJGKllGbkI8=")).b(cn.fly.verify.as.d("S4B9kH1Lj5WPkIGJS4iLf4ePgZCQhYqDj0qAfg==")).b(cn.fly.verify.as.d("NGlmeWY=")).b(cn.fly.verify.as.d("O3BtgG07f4V/gHF5")).b(cn.fly.verify.as.d("QXZzhnNBhYuFhnd/QYeFd4SF")).b(cn.fly.verify.as.d("XJGOoY5coKagoZKaXKKgkp+gXF1coJKhoZablKCMk5ablJKfnZ+Wm6FbpZqZ")).a(new cn.fly.verify.C0545r.AnonymousClass1.C00161());
        }
    }

    private C0545r() {
    }

    public static cn.fly.verify.C0545r a() {
        if (a == null) {
            synchronized (cn.fly.verify.C0545r.class) {
                if (a == null) {
                    a = new cn.fly.verify.C0545r();
                }
            }
        }
        return a;
    }

    public java.util.HashMap a(cn.fly.verify.e eVar) throws cn.fly.verify.common.exception.VerifyException {
        if (android.text.TextUtils.isEmpty(cn.fly.verify.ax.d())) {
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_APPKEY_NULL);
        }
        java.lang.String str = cn.fly.verify.i.a(3) + "api/initSecCdn/1/";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String c = cn.fly.verify.fh.d.c();
        java.lang.String a2 = cn.fly.verify.al.a();
        sb.append(cn.fly.verify.ax.d());
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(c);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(a2);
        return cn.fly.verify.j.a(false).a(str + sb.toString(), eVar);
    }

    public void a(java.lang.String str, java.lang.String str2, cn.fly.verify.e eVar, cn.fly.verify.common.callback.b<cn.fly.verify.a> bVar) {
        if (cn.fly.verify.ax.h()) {
            if (bVar != null) {
                bVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR));
            }
        } else {
            try {
                cn.fly.verify.d.a().execute(new cn.fly.verify.C0545r.AnonymousClass1(str, str2, eVar, bVar));
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().a(th);
            }
        }
    }

    public java.lang.String[] a(java.lang.String str, java.lang.String str2, cn.fly.verify.s sVar, java.lang.String str3) throws cn.fly.verify.common.exception.VerifyException {
        try {
            java.lang.String[] a2 = cn.fly.verify.h.a().a(sVar, str3, str, str2);
            if (a2 == null || a2.length < 1) {
                throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_TOKEN_NULL_ERR);
            }
            return new java.lang.String[]{"0:" + cn.fly.verify.an.a(a2[0]), a2[1]};
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            if (th instanceof cn.fly.verify.common.exception.VerifyException) {
                throw th;
            }
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_TOKEN_NULL_ERR.getCode(), cn.fly.verify.as.a(th));
        }
    }

    public java.util.HashMap b() throws cn.fly.verify.common.exception.VerifyException {
        java.util.HashMap<java.lang.String, java.lang.Object> b = cn.fly.verify.h.a().b();
        if (android.text.TextUtils.isEmpty((java.lang.String) b.get("appkey"))) {
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_APPKEY_NULL);
        }
        java.lang.String str = cn.fly.verify.i.a(1) + "api/initSec";
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "init start");
        return cn.fly.verify.j.a(false).b(b, str);
    }
}
