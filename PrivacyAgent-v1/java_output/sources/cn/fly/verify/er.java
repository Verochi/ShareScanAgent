package cn.fly.verify;

/* loaded from: classes.dex */
public class er {
    public static java.lang.ThreadLocal<java.lang.Boolean> a = new java.lang.ThreadLocal<>();
    public static java.lang.ThreadLocal<java.lang.Boolean> b = new java.lang.ThreadLocal<>();
    public static java.lang.ThreadLocal<java.lang.Boolean> c = new java.lang.ThreadLocal<>();
    private static volatile java.lang.String e = null;
    private static final java.util.List<java.lang.String> d = java.util.Arrays.asList("bgmdl", "gmnft", "gbrd", "govsit", "govsnm", "golgu", "gocnty", "galgu", "gtmne", "gsnmd", "gpgnm", "gpnmmt", "gpvsnm", "gpvsme", "cinmnps", "ckpmsi", "gaplcn", "gpgif", "gpgiffist", "gcrtpcnm", "gscpt", "cird", "cknavbl", "ipgist", "ckua", "ubenbl", "dvenbl", "vnmt", "iwpxy", "cx", "degb", "gdtlnktpfs", "gpgiffcin", "gpgifstrg", "gtaif", "gtaifprm", "rsaciy", "gsnmdfp", "gcrie", "gcriefce", "gdvk", "gdvkfc", "godhm", "godm", "gmpfis");

    private static cn.fly.verify.ef a() {
        return cn.fly.verify.ei.c() ? cn.fly.verify.eh.a(cn.fly.verify.ax.g()).e() : cn.fly.verify.eh.a(cn.fly.verify.ax.g()).c();
    }

    private static cn.fly.verify.ef a(java.lang.String str) {
        java.util.concurrent.CountDownLatch d2;
        java.util.concurrent.CountDownLatch d3;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            cn.fly.verify.ed.a().b("WARNING: Call in main: key = " + str);
            b();
        }
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (!(a.get() == null ? false : a.get().booleanValue())) {
            if (!d.contains(str) && !cn.fly.verify.ei.c() && (d3 = cn.fly.verify.ei.a(cn.fly.verify.ax.g()).d()) != null) {
                cn.fly.verify.ed.a().a("dhs_ivkr k: " + str + ", cdl: " + d3, new java.lang.Object[0]);
                d3.await(3500L, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            return a();
        }
        boolean booleanValue = b.get() == null ? false : b.get().booleanValue();
        boolean booleanValue2 = c.get() == null ? false : c.get().booleanValue();
        if (booleanValue) {
            cn.fly.verify.ed.a().a("isGCFThread true", new java.lang.Object[0]);
        }
        if (!booleanValue && !booleanValue2 && !cn.fly.verify.ei.c() && (d2 = cn.fly.verify.ei.a(cn.fly.verify.ax.g()).d()) != null) {
            cn.fly.verify.ed.a().a("dhs_ivkr_new k: " + str + ", cdl: " + d2, new java.lang.Object[0]);
            d2.await(3500L, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        return a();
        return a();
    }

    @cn.fly.verify.es
    public static java.lang.Object a(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList) {
        try {
            return b(str, arrayList);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    private static java.lang.Object b(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList) throws java.lang.Throwable {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        cn.fly.verify.ef a2 = a(str);
        if ("gmpfis".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return a2.b(((java.lang.Boolean) arrayList.get(0)).booleanValue(), ((java.lang.Integer) arrayList.get(1)).intValue(), (java.lang.String) arrayList.get(2), ((java.lang.Integer) arrayList.get(3)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("cird".equals(str)) {
            return java.lang.Boolean.valueOf(a2.a());
        }
        if ("cx".equals(str)) {
            return java.lang.Boolean.valueOf(a2.b());
        }
        if ("ckpd".equals(str)) {
            return java.lang.Boolean.valueOf(a2.c());
        }
        if ("degb".equals(str)) {
            return java.lang.Boolean.valueOf(a2.d());
        }
        if ("vnmt".equals(str)) {
            return java.lang.Boolean.valueOf(a2.e());
        }
        if ("ckua".equals(str)) {
            return java.lang.Boolean.valueOf(a2.f());
        }
        if ("dvenbl".equals(str)) {
            return java.lang.Boolean.valueOf(a2.g());
        }
        if ("ubenbl".equals(str)) {
            return java.lang.Boolean.valueOf(a2.h());
        }
        if ("iwpxy".equals(str)) {
            return java.lang.Boolean.valueOf(a2.i());
        }
        if ("gavti".equals(str)) {
            return a2.j();
        }
        if ("gsimt".equals(str)) {
            return a2.a(false);
        }
        if ("gsimtfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gbsi".equals(str)) {
            return a2.b(false);
        }
        if ("gbsifce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.b(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gcrie".equals(str)) {
            return a2.c(false);
        }
        if ("gcriefce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.c(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gcrnmfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.d(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gcrnm".equals(str)) {
            return a2.d(false);
        }
        if ("gmivsn".equals(str)) {
            return a2.k();
        }
        if ("bgmdl".equals(str)) {
            return a2.l();
        }
        if ("gmnft".equals(str)) {
            return a2.m();
        }
        if ("gbrd".equals(str)) {
            return a2.n();
        }
        if ("gdvtp".equals(str)) {
            return a2.o();
        }
        if ("gtecloc".equals(str)) {
            return a2.p();
        }
        if ("gnbclin".equals(str)) {
            return a2.q();
        }
        if ("wmcwi".equals(str)) {
            return a2.e(false);
        }
        if ("wmcwifce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.e(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("govsit".equals(str)) {
            return java.lang.Integer.valueOf(a2.s());
        }
        if ("govsnm".equals(str)) {
            return a2.t();
        }
        if ("golgu".equals(str)) {
            return a2.u();
        }
        if ("gocnty".equals(str)) {
            return a2.v();
        }
        if ("gcuin".equals(str)) {
            return a2.w();
        }
        if ("gtydvin".equals(str)) {
            return a2.x();
        }
        if ("gqmkn".equals(str)) {
            return a2.y();
        }
        if ("gszin".equals(str)) {
            return a2.z();
        }
        if ("gmrin".equals(str)) {
            return a2.A();
        }
        if ("galgu".equals(str)) {
            return a2.B();
        }
        if ("gscsz".equals(str)) {
            return a2.C();
        }
        if ("gneyp".equals(str)) {
            return a2.f(false);
        }
        if ("gneypnw".equals(str)) {
            return a2.D();
        }
        if ("gneypfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.f(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gnktpfs".equals(str)) {
            return a2.E();
        }
        if ("gdtlnktpfs".equals(str)) {
            return a2.F();
        }
        if ("cknavbl".equals(str)) {
            return java.lang.Boolean.valueOf(a2.G());
        }
        if ("gdntp".equals(str)) {
            return java.lang.Integer.valueOf(a2.H());
        }
        if ("gtmne".equals(str)) {
            return a2.I();
        }
        if ("gflv".equals(str)) {
            return a2.J();
        }
        if ("gbsbd".equals(str)) {
            return a2.K();
        }
        if ("gbfspy".equals(str)) {
            return a2.L();
        }
        if ("gbplfo".equals(str)) {
            return a2.M();
        }
        if ("giads".equals(str)) {
            return a2.N();
        }
        if ("gia".equals(str)) {
            if (!cn.fly.verify.bo.a(cn.fly.verify.dt.a("003dgg")) || cn.fly.verify.bl.a().h() == 42) {
                return new java.util.ArrayList();
            }
            if (arrayList != null && arrayList.size() == 1) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue(), false);
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("giafce".equals(str)) {
            if (!cn.fly.verify.bo.a(cn.fly.verify.dt.a("003dgg")) || cn.fly.verify.bl.a().h() == 42) {
                return new java.util.ArrayList();
            }
            if (arrayList != null && arrayList.size() == 2) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue(), ((java.lang.Boolean) arrayList.get(1)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gal".equals(str)) {
            return (!cn.fly.verify.bo.a(cn.fly.verify.dt.a("003dgg")) || cn.fly.verify.bl.a().h() == 42) ? new java.util.ArrayList() : a2.O();
        }
        if ("gsl".equals(str)) {
            return (!cn.fly.verify.bo.a(cn.fly.verify.dt.a("003dgg")) || cn.fly.verify.bl.a().h() == 42) ? new java.util.ArrayList() : a2.P();
        }
        if ("glctn".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return a2.a(((java.lang.Integer) arrayList.get(0)).intValue(), ((java.lang.Integer) arrayList.get(1)).intValue(), ((java.lang.Boolean) arrayList.get(2)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gstmpts".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.a((java.lang.String) arrayList.get(0));
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gdvk".equals(str)) {
            return a2.Q();
        }
        if ("gdvkfc".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.g(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("ipgist".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return java.lang.Boolean.valueOf(a2.b((java.lang.String) arrayList.get(0)));
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gscpt".equals(str)) {
            return a2.R();
        }
        if ("gsnmd".equals(str)) {
            return a2.S();
        }
        if ("gsnmdfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.c((java.lang.String) arrayList.get(0));
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpgnm".equals(str)) {
            return a2.T();
        }
        if ("gpnmmt".equals(str)) {
            return a2.U();
        }
        if ("gpnmfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.d((java.lang.String) arrayList.get(0));
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpvsnm".equals(str)) {
            return java.lang.Integer.valueOf(a2.V());
        }
        if ("gpvsme".equals(str)) {
            return a2.W();
        }
        if ("cinmnps".equals(str)) {
            return java.lang.Boolean.valueOf(a2.X());
        }
        if ("gcrtpcnm".equals(str)) {
            return a2.Y();
        }
        if ("ciafgd".equals(str)) {
            return java.lang.Boolean.valueOf(a2.Z());
        }
        if ("ckpmsi".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return java.lang.Boolean.valueOf(a2.e((java.lang.String) arrayList.get(0)));
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gaplcn".equals(str)) {
            return a2.aa();
        }
        if ("qritsvc".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return a2.a((android.content.Intent) arrayList.get(0), ((java.lang.Integer) arrayList.get(1)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("rsaciy".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return a2.b((android.content.Intent) arrayList.get(0), ((java.lang.Integer) arrayList.get(1)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpgif".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return a2.a(false, 0, (java.lang.String) arrayList.get(0), ((java.lang.Integer) arrayList.get(1)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffcin".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue(), 0, (java.lang.String) arrayList.get(1), ((java.lang.Integer) arrayList.get(2)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpgifstrg".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return a2.a(false, ((java.lang.Integer) arrayList.get(0)).intValue(), (java.lang.String) arrayList.get(1), ((java.lang.Integer) arrayList.get(2)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffist".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue(), ((java.lang.Integer) arrayList.get(1)).intValue(), (java.lang.String) arrayList.get(2), ((java.lang.Integer) arrayList.get(3)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gdvda".equals(str)) {
            return a2.ab();
        }
        if ("gdvdtnas".equals(str)) {
            return a2.ac();
        }
        if ("galtut".equals(str)) {
            return java.lang.Long.valueOf(a2.ad());
        }
        if ("gcrup".equals(str)) {
            return a2.af();
        }
        if ("gcifm".equals(str)) {
            return a2.ag();
        }
        if ("godm".equals(str)) {
            java.lang.String ah = a2.ah();
            if (android.text.TextUtils.isEmpty(e)) {
                e = cn.fly.verify.bl.a().b("key_ched_od", (java.lang.String) null);
            }
            if (android.text.TextUtils.isEmpty(ah) || cn.fly.verify.az.a().b().a()) {
                return android.text.TextUtils.isEmpty(e) ? ah : e;
            }
            if (android.text.TextUtils.equals(e, ah)) {
                return ah;
            }
            e = ah;
            cn.fly.verify.bl.a().a("key_ched_od", ah);
            return ah;
        }
        if ("godhm".equals(str)) {
            return a2.ai();
        }
        if ("galdm".equals(str)) {
            return a2.aj();
        }
        if ("gtaif".equals(str)) {
            return a2.ak();
        }
        if ("gtaifok".equals(str)) {
            return a2.al();
        }
        if ("gtaifprm".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return a2.a((java.lang.String) arrayList.get(0), ((java.lang.Integer) arrayList.get(1)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gtaifprmfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return a2.a(((java.lang.Boolean) arrayList.get(0)).booleanValue(), (java.lang.String) arrayList.get(1), ((java.lang.Integer) arrayList.get(2)).intValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gtbdt".equals(str)) {
            return java.lang.Long.valueOf(a2.am());
        }
        if ("gtscnin".equals(str)) {
            return java.lang.Double.valueOf(a2.an());
        }
        if ("gtscnppi".equals(str)) {
            return java.lang.Integer.valueOf(a2.ao());
        }
        if ("ishmos".equals(str)) {
            return java.lang.Boolean.valueOf(a2.ap());
        }
        if ("gthmosv".equals(str)) {
            return a2.aq();
        }
        if ("gthmosdtlv".equals(str)) {
            return a2.ar();
        }
        if ("gthmpmst".equals(str)) {
            return java.lang.Integer.valueOf(a2.as());
        }
        if ("gthmepmst".equals(str)) {
            return java.lang.Integer.valueOf(a2.at());
        }
        if ("gtinnerlangmt".equals(str)) {
            return a2.au();
        }
        if ("gtgramgendt".equals(str)) {
            return java.lang.Integer.valueOf(a2.av());
        }
        if ("ctedebbing".equals(str)) {
            return java.lang.Boolean.valueOf(a2.aw());
        }
        if ("gtelcmefce".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return a2.a(((java.lang.Integer) arrayList.get(0)).intValue(), ((java.lang.Integer) arrayList.get(1)).intValue(), ((java.lang.Boolean) arrayList.get(2)).booleanValue(), ((java.lang.Boolean) arrayList.get(3)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if ("gtdm".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return a2.h(((java.lang.Boolean) arrayList.get(0)).booleanValue());
            }
            throw new java.lang.Throwable("array illegal: " + arrayList);
        }
        if (!"gtlstactme".equals(str)) {
            cn.fly.verify.ed.a().a("Not found: " + str, new java.lang.Object[0]);
            return null;
        }
        if (arrayList != null && arrayList.size() == 1) {
            return java.lang.Long.valueOf(a2.f((java.lang.String) arrayList.get(0)));
        }
        throw new java.lang.Throwable("array illegal: " + arrayList);
    }

    private static void b() {
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                java.lang.String str = "";
                for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        str = str + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")\n";
                    }
                }
                cn.fly.verify.ed.a().a(str, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }
}
