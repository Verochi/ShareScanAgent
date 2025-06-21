package cn.fly.verify;

/* loaded from: classes.dex */
public class bl {
    public static final java.lang.String a = cn.fly.verify.dt.a("009!dlCf7dkdhdcdieeDdj");
    public static final java.lang.String b = cn.fly.verify.dt.a("010>dl-f%dkdh;eYdgFj!djQc-dc");
    public static final java.lang.String c = cn.fly.verify.dt.a("009-dlQf<dkdhHe!dg@gdg");
    public static final java.lang.String d = cn.fly.verify.dt.a("010Idl;f*dkdhfhVeMdg$gdg");
    public static final java.lang.String e = cn.fly.verify.dt.a("0114dl:f=dkdh3jj4dheedj-i7dc");
    public static final java.lang.String f = cn.fly.verify.dt.a("031]dl[f1dkdh4efRec<i)dhdg2jg(edRdFdcdhGdjj*dhPdci,diddJfYdhEiRdidf;f");
    public static final java.lang.String g = cn.fly.verify.dt.a("025:dl@fEdkdhfedgefef;fMdjRf>dcdh7gHed'cdiPdied>e0dhdfdchi");
    public static final java.lang.String h = cn.fly.verify.dt.a("038%dl^fYdkdhDefRec]iUdhdg4jg4ed]d@dcdhfedgefefFf!djLf=dcdh)g(ed$cdi>died-e[dh,i-didf3f");
    public static final java.lang.String i = cn.fly.verify.dt.a("014BffdiefdidhGgdTfh%i*dhdiJeBefed");
    public static final java.lang.String j = cn.fly.verify.dt.a("018JdlQfAdkdhffdiefdidh=g?difhKi!dhKhd?fh7h");
    public static final java.lang.String k = cn.fly.verify.dt.a("0301dlWfQdkdhEef>ec=iMdhdg,jgWedQd@dcdhffdiefdidhJg.difh(iSdh7i=didfGf");
    public static final java.lang.String l = cn.fly.verify.dt.a("012%dl5fCdkdhfhffdi$ichfBfh");
    public static final java.lang.String m = cn.fly.verify.dt.a("022,dl5fIdkdhfhffdi2ichf+fhdhDi8didfNf4fh[idMdfCj");
    private static final java.lang.String n = cn.fly.verify.dt.a("0193dl$fSdkdhVdjj)dh;dci5didd<fLdhCiAdidf3f");
    private static final java.lang.String o = cn.fly.verify.dt.a("0120dl,f$dkdhKchdeefgSfh");
    private static java.util.concurrent.atomic.AtomicBoolean p = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean q = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static cn.fly.verify.bl r;

    /* renamed from: s, reason: collision with root package name */
    private cn.fly.verify.fs f67s;

    /* renamed from: cn.fly.verify.bl$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.fz {
        public AnonymousClass1(java.lang.String str) {
            super(str);
        }

        @Override // cn.fly.verify.fz
        public void a() {
            java.lang.Object obj = cn.fly.verify.dq.i;
            synchronized (obj) {
                try {
                    obj.wait(600000L);
                    cn.fly.verify.di.a().a(11);
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> e = cn.fly.verify.bo.e();
                    if (e != null && e.size() > 0) {
                        cn.fly.verify.di.a().a(12);
                        java.lang.Object obj2 = e.get("h");
                        java.lang.Object obj3 = e.get("k");
                        java.lang.Object obj4 = e.get(cn.fly.verify.dt.a("001=fe"));
                        java.lang.Object obj5 = e.get("s");
                        java.lang.Object obj6 = e.get(cn.fly.verify.dt.a("002ce"));
                        java.lang.Object obj7 = e.get(cn.fly.verify.dt.a("002.efVe"));
                        e.clear();
                        cn.fly.verify.cd.a(obj2, obj3, obj4, obj5, obj6, obj7);
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: cn.fly.verify.bl$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.fz {

        /* renamed from: cn.fly.verify.bl$2$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.fv<java.lang.Void> {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.fv
            public void a(java.lang.Void r1) {
            }
        }

        public AnonymousClass2(java.lang.String str) {
            super(str);
        }

        @Override // cn.fly.verify.fz
        public void a() {
            java.lang.Object obj = cn.fly.verify.dq.j;
            synchronized (obj) {
                try {
                    obj.wait();
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> f = cn.fly.verify.bo.f();
                    java.util.ArrayList arrayList = (java.util.ArrayList) f.get(cn.fly.verify.dt.a("002gi"));
                    f.clear();
                    cn.fly.verify.cd.a((java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>>) arrayList, new cn.fly.verify.bl.AnonymousClass2.AnonymousClass1());
                } finally {
                }
            }
        }
    }

    public static class a {
        public static final java.lang.String a = cn.fly.verify.dt.a("003[hcedfe");
        public static final java.lang.String b = cn.fly.verify.dt.a("011GdfedfedhSc>eddfdfed$e(fh");
        private static cn.fly.verify.bl.a c;
        private cn.fly.verify.fs d;

        private a() {
            if (this.d == null) {
                cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
                this.d = fsVar;
                fsVar.a(a, b, 1);
            }
        }

        public static synchronized cn.fly.verify.bl.a a() {
            cn.fly.verify.bl.a aVar;
            synchronized (cn.fly.verify.bl.a.class) {
                if (c == null) {
                    c = new cn.fly.verify.bl.a();
                }
                aVar = c;
            }
            return aVar;
        }

        public static boolean b() {
            try {
                java.io.File c2 = c();
                if (c2 == null || !c2.exists()) {
                    return false;
                }
                return c2.length() > 0;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        public static java.io.File c() {
            if (cn.fly.verify.ax.g() == null) {
                return null;
            }
            try {
                return new java.io.File(new java.io.File(cn.fly.verify.ax.g().getFilesDir(), a), b + "_1");
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().c(th);
                return null;
            }
        }

        public int a(java.lang.String str, int i) {
            return this.d.b(str, i);
        }

        public java.util.HashMap<java.lang.String, java.lang.Object> d() {
            return this.d.a();
        }
    }

    private bl() {
        if (this.f67s == null) {
            cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
            this.f67s = fsVar;
            fsVar.a("fvv_cms", 1);
        }
    }

    public static synchronized cn.fly.verify.bl a() {
        cn.fly.verify.bl blVar;
        synchronized (cn.fly.verify.bl.class) {
            if (r == null) {
                r = new cn.fly.verify.bl();
            }
            blVar = r;
        }
        return blVar;
    }

    public static boolean b() {
        try {
            java.io.File c2 = c();
            if (c2 == null || !c2.exists()) {
                return false;
            }
            return c2.length() > 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.io.File c() {
        if (cn.fly.verify.ax.g() == null) {
            return null;
        }
        try {
            return new java.io.File(new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.fs.a), "fvv_cms_1");
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().c(th);
            return null;
        }
    }

    public static void u() {
        if (p.compareAndSet(false, true)) {
            new cn.fly.verify.bl.AnonymousClass1(cn.fly.verify.dt.a("004 fkikhkge")).start();
        }
        w();
    }

    private static java.lang.String v() {
        return cn.fly.verify.fi.b(cn.fly.verify.fh.d.j());
    }

    private static void w() {
        if (q.compareAndSet(false, true)) {
            new cn.fly.verify.bl.AnonymousClass2("DS-W").start();
        }
    }

    public java.lang.Object a(java.lang.String str) {
        return this.f67s.d(str);
    }

    public void a(int i2) {
        a("key_lch_tms", i2);
    }

    public void a(long j2) {
        a("key_a_rmt_tm", j2);
    }

    public void a(cn.fly.verify.ay.b bVar) {
        java.lang.String a2;
        if (bVar != null) {
            try {
                a2 = bVar.a();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
                return;
            }
        } else {
            a2 = null;
        }
        a("key_duid_entity", android.util.Base64.encodeToString(cn.fly.verify.fi.a(cn.fly.verify.fh.d.j(), a2), 0));
    }

    public void a(cn.fly.verify.ay.d dVar) {
        a("key_duid_param_blacklist", dVar != null ? dVar.a() : null);
    }

    public void a(java.lang.String str, int i2) {
        this.f67s.a(str, java.lang.Integer.valueOf(i2));
    }

    public void a(java.lang.String str, long j2) {
        this.f67s.a(str, java.lang.Long.valueOf(j2));
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        this.f67s.a(str, obj);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            this.f67s.e(str);
        } else {
            this.f67s.a(str, str2);
        }
    }

    public void a(java.lang.String str, boolean z) {
        this.f67s.a(str, java.lang.Boolean.valueOf(z));
    }

    public void a(java.util.ArrayList<java.lang.String> arrayList) {
        a("key_chd_prx_dm", (arrayList == null || arrayList.isEmpty()) ? null : cn.fly.verify.fm.a((java.lang.Object) arrayList));
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (hashMap != null) {
            this.f67s.a(hashMap);
        }
    }

    public void a(boolean z) {
        a("keyR_drt_lch", z);
    }

    public int b(int i2) {
        return b("key_wt_dys", i2);
    }

    public int b(java.lang.String str, int i2) {
        return this.f67s.b(str, i2);
    }

    public long b(java.lang.String str, long j2) {
        return this.f67s.a(str, j2);
    }

    public java.lang.String b(java.lang.String str, java.lang.String str2) {
        return this.f67s.b(str, str2);
    }

    public void b(long j2) {
        a("key_fst_lnch_tm", j2);
    }

    public void b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                str = android.util.Base64.encodeToString(cn.fly.verify.fi.a(v(), str), 0);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        a(l, str);
    }

    public void b(java.lang.String str, java.lang.Object obj) {
        this.f67s.a(str, obj);
    }

    public void b(java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>>> hashMap) {
        a("key_chd_busi_dm", cn.fly.verify.fm.a((java.util.HashMap) hashMap));
    }

    public boolean b(java.lang.String str, boolean z) {
        return this.f67s.a(str, z);
    }

    public java.lang.Object c(java.lang.String str, java.lang.Object obj) {
        java.lang.Object d2 = this.f67s.d(str);
        return d2 == null ? obj : d2;
    }

    public void c(int i2) {
        a("key_wt_dys", i2);
    }

    public void c(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                str = android.util.Base64.encodeToString(cn.fly.verify.fi.a(v(), str), 0);
                a(m, java.lang.System.currentTimeMillis());
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        a("key_gfrt", str);
    }

    public void c(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        a("key_ckd_busi_dm", cn.fly.verify.fm.a((java.util.HashMap) hashMap));
    }

    public int d(int i2) {
        return b("key_wt_tms", i2);
    }

    public java.lang.String d() {
        java.lang.String b2 = b(l, (java.lang.String) null);
        if (android.text.TextUtils.isEmpty(b2)) {
            return b2;
        }
        try {
            java.lang.String v = v();
            return cn.fly.verify.fi.c(v.getBytes("UTF-8"), android.util.Base64.decode(b2, 0));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return b2;
        }
    }

    public void d(java.lang.String str) {
        a("key_chd_ak", str);
    }

    public void d(java.util.HashMap<java.lang.String, java.lang.Long> hashMap) {
        a("key_dm_ck_tm", cn.fly.verify.fm.a((java.util.HashMap) hashMap));
    }

    public java.lang.String e() {
        java.lang.String b2 = b("key_gfrt", (java.lang.String) null);
        if (android.text.TextUtils.isEmpty(b2)) {
            return b2;
        }
        try {
            java.lang.String v = v();
            return cn.fly.verify.fi.c(v.getBytes("UTF-8"), android.util.Base64.decode(b2, 0));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return b2;
        }
    }

    public void e(int i2) {
        a("key_wt_tms", i2);
    }

    public void e(java.lang.String str) {
        a("key_chd_as", str);
    }

    public void f() {
        b((java.lang.String) null);
        c((java.lang.String) null);
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> g() {
        java.lang.String b2 = b(o, (java.lang.String) null);
        if (android.text.TextUtils.isEmpty(b2)) {
            return null;
        }
        return cn.fly.verify.fm.a(b2);
    }

    public int h() {
        return b("key_mstrgy", 0);
    }

    public cn.fly.verify.ay.d i() {
        return cn.fly.verify.ay.d.a(b("key_duid_param_blacklist", (java.lang.String) null));
    }

    public cn.fly.verify.ay.b j() {
        try {
            java.lang.String b2 = b("key_duid_entity", (java.lang.String) null);
            if (!android.text.TextUtils.isEmpty(b2)) {
                return cn.fly.verify.ay.b.a(cn.fly.verify.fi.a(cn.fly.verify.fh.d.j(), android.util.Base64.decode(b2, 0)));
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        return null;
    }

    public long k() {
        return b("key_a_rmt_tm", 0L);
    }

    public int l() {
        return b("key_lch_tms", 0);
    }

    public boolean m() {
        return b("keyR_drt_lch", false);
    }

    public java.lang.String n() {
        return b("key_chd_ak", (java.lang.String) null);
    }

    public java.lang.String o() {
        return b("key_chd_as", (java.lang.String) null);
    }

    public java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>>> p() {
        return cn.fly.verify.fm.a(b("key_chd_busi_dm", (java.lang.String) null));
    }

    public java.util.HashMap<java.lang.String, java.lang.String> q() {
        return cn.fly.verify.fm.a(b("key_ckd_busi_dm", (java.lang.String) null));
    }

    public java.util.ArrayList<java.lang.String> r() {
        java.util.HashMap a2 = cn.fly.verify.fm.a(b("key_chd_prx_dm", (java.lang.String) null));
        return (a2 == null || a2.isEmpty()) ? new java.util.ArrayList<>() : (java.util.ArrayList) a2.get(cn.fly.verify.dt.a("008Gef7d$dlVfg8difh]i"));
    }

    public java.util.HashMap<java.lang.String, java.lang.Long> s() {
        return cn.fly.verify.fm.a(b("key_dm_ck_tm", (java.lang.String) null));
    }

    public long t() {
        return b("key_fst_lnch_tm", 0L);
    }
}
