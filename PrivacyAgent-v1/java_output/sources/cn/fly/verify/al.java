package cn.fly.verify;

/* loaded from: classes31.dex */
public class al {
    private static java.lang.String a;
    private static java.lang.String b;
    private static java.lang.String c;
    private static java.lang.String d;
    private static java.lang.String e;
    private static java.lang.String f;
    private static java.lang.String g;
    private static java.lang.String h;
    private static java.lang.String i;
    private static java.lang.String j;
    private static int k;
    private static java.lang.String l;
    private static android.content.pm.PackageInfo m;
    private static java.lang.String n;
    private static java.lang.String o;

    /* renamed from: cn.fly.verify.al$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ boolean a;
        final /* synthetic */ cn.fly.verify.e b;
        final /* synthetic */ long c;
        final /* synthetic */ cn.fly.verify.ar d;

        public AnonymousClass1(boolean z, cn.fly.verify.e eVar, long j, cn.fly.verify.ar arVar) {
            this.a = z;
            this.b = eVar;
            this.c = j;
            this.d = arVar;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            try {
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "DH response");
                if (android.text.TextUtils.isEmpty(cn.fly.verify.al.a)) {
                    java.lang.String unused = cn.fly.verify.al.a = bVar.f();
                }
                java.lang.String unused2 = cn.fly.verify.al.j = bVar.b(new int[0]);
                if (this.a) {
                    java.lang.String unused3 = cn.fly.verify.al.b = bVar.a(new int[0]);
                }
                cn.fly.verify.e eVar = this.b;
                if (eVar != null) {
                    eVar.a((java.lang.String) null, (java.lang.String) null, "dh", java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - this.c));
                }
                cn.fly.verify.ar arVar = this.d;
                if (arVar != null) {
                    arVar.run();
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", th.getMessage());
                cn.fly.verify.ar arVar2 = this.d;
                if (arVar2 != null) {
                    arVar2.a(th);
                }
            }
        }
    }

    /* renamed from: cn.fly.verify.al$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 implements cn.fly.verify.fh.a {
        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            try {
                if (android.text.TextUtils.isEmpty(cn.fly.verify.al.o)) {
                    java.lang.String unused = cn.fly.verify.al.o = bVar.F();
                }
                int unused2 = cn.fly.verify.al.k = bVar.w();
                java.lang.String unused3 = cn.fly.verify.al.c = bVar.l();
                java.lang.String unused4 = cn.fly.verify.al.d = bVar.h();
                java.lang.String unused5 = cn.fly.verify.al.e = bVar.p();
                java.lang.String unused6 = cn.fly.verify.al.f = bVar.e();
                java.lang.String unused7 = cn.fly.verify.al.g = bVar.i();
                java.lang.String unused8 = cn.fly.verify.al.h = bVar.y();
                java.lang.String unused9 = cn.fly.verify.al.i = bVar.b();
                java.lang.String unused10 = cn.fly.verify.al.l = bVar.x();
                android.content.pm.PackageInfo unused11 = cn.fly.verify.al.m = bVar.g(new int[0]);
                java.lang.String unused12 = cn.fly.verify.al.n = bVar.z();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", th.getMessage());
            }
        }
    }

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(a)) {
            a = cn.fly.verify.as.e();
        }
        return a;
    }

    public static void a(cn.fly.verify.ar arVar, boolean z, cn.fly.verify.e eVar) {
        cn.fly.verify.fh.c f2;
        try {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "DH request");
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            if (android.text.TextUtils.isEmpty(a)) {
                f2 = (z ? cn.fly.verify.fh.a(cn.fly.verify.ax.g()).b(true).a(true) : cn.fly.verify.fh.a(cn.fly.verify.ax.g()).b(true)).f();
            } else {
                f2 = z ? cn.fly.verify.fh.a(cn.fly.verify.ax.g()).b(true).a(true) : cn.fly.verify.fh.a(cn.fly.verify.ax.g()).b(true);
            }
            if (f2 != null) {
                f2.a(new cn.fly.verify.al.AnonymousClass1(z, eVar, uptimeMillis, arVar));
            }
        } catch (java.lang.Throwable th) {
            if (!(th instanceof java.lang.ClassNotFoundException) && !(th instanceof java.lang.NoClassDefFoundError) && !(th instanceof java.lang.NoSuchMethodException)) {
                boolean z2 = th instanceof java.lang.NoSuchMethodError;
            }
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", th.getMessage());
            if (arVar != null) {
                arVar.a(th);
            }
        }
        cn.fly.verify.as.b(true);
        cn.fly.verify.as.c(true);
        cn.fly.verify.as.d(true);
        try {
            cn.fly.verify.fh.c A = cn.fly.verify.fh.a(cn.fly.verify.ax.g()).w().l().h().p().e().i().z().b().x().a(cn.fly.verify.fh.d.c(), 128).A();
            if (android.text.TextUtils.isEmpty(o)) {
                A = A.d(false);
            }
            A.a(new cn.fly.verify.al.AnonymousClass2());
        } catch (java.lang.Throwable th2) {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", th2.getMessage());
        }
    }

    public static java.lang.String b() {
        return o;
    }

    public static int c() {
        return k;
    }

    public static java.lang.String d() {
        return b;
    }

    public static java.lang.String e() {
        return c;
    }

    public static java.lang.String f() {
        return d;
    }

    public static java.lang.String g() {
        return e;
    }

    public static java.lang.String h() {
        return f;
    }

    public static java.lang.String i() {
        return g;
    }

    public static java.lang.String j() {
        return j;
    }

    public static java.lang.String k() {
        return n;
    }

    public static java.lang.String l() {
        java.lang.String str = null;
        try {
            str = ((android.telephony.TelephonyManager) cn.fly.verify.ax.g().getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
            cn.fly.verify.f.a().a("==== getCarrierImpl");
        } catch (java.lang.Throwable unused) {
        }
        return android.text.TextUtils.isEmpty(str) ? "-1" : str;
    }

    public static java.lang.String m() {
        java.lang.Object a2;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            if (!cn.fly.verify.fh.d.b("android.permission.ACCESS_NETWORK_STATE") || (a2 = cn.fly.verify.fh.d.a("connectivity")) == null || (activeNetworkInfo = ((android.net.ConnectivityManager) a2).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return "none";
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? java.lang.String.valueOf(type) : com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI : "cell";
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().c(th);
            return "none";
        }
    }
}
