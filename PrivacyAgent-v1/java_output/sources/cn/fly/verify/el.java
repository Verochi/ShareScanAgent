package cn.fly.verify;

/* loaded from: classes.dex */
public class el implements cn.fly.verify.ef {
    private android.content.Context a;

    public el(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0058, code lost:
    
        if (r3 != java.lang.Boolean.TYPE) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return (T) java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005f, code lost:
    
        if (r3 != java.lang.Integer.TYPE) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return (T) (-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006a, code lost:
    
        if (r3 != java.lang.Byte.TYPE) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return (T) (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0073, code lost:
    
        if (r3 != java.lang.Character.TYPE) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return (T) (char) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007c, code lost:
    
        if (r3 != java.lang.Short.TYPE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return (T) (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0085, code lost:
    
        if (r3 != java.lang.Long.TYPE) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return (T) 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0090, code lost:
    
        if (r3 != java.lang.Float.TYPE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return (T) java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x009a, code lost:
    
        if (r3 != java.lang.Double.TYPE) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        return (T) java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(java.lang.Class<T> cls, java.lang.Object obj) {
        T cast;
        java.lang.Class cls2;
        T t = null;
        if (cls != null && obj != null && cls != java.lang.Void.class) {
            try {
                if (cls == java.lang.Boolean.TYPE) {
                    cls2 = java.lang.Boolean.class;
                } else if (cls == java.lang.Integer.TYPE) {
                    cls2 = java.lang.Integer.class;
                } else if (cls == java.lang.Byte.TYPE) {
                    cls2 = java.lang.Byte.class;
                } else if (cls == java.lang.Character.TYPE) {
                    cls2 = java.lang.Character.class;
                } else if (cls == java.lang.Short.TYPE) {
                    cls2 = java.lang.Short.class;
                } else if (cls == java.lang.Long.TYPE) {
                    cls2 = java.lang.Long.class;
                } else if (cls == java.lang.Float.TYPE) {
                    cls2 = java.lang.Float.class;
                } else if (cls == java.lang.Double.TYPE) {
                    cls2 = java.lang.Double.class;
                } else {
                    cast = cls.cast(obj);
                    t = cast;
                }
                cast = (T) cls2.cast(obj);
                t = cast;
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return t;
        return t;
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Long> A() {
        return (java.util.HashMap) a(java.util.HashMap.class, cn.fly.verify.er.a("gmrin", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String B() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("galgu", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String C() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gscsz", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String D() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gneypnw", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String E() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gnktpfs", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String F() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdtlnktpfs", null));
    }

    @Override // cn.fly.verify.ef
    public boolean G() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("cknavbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public int H() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gdntp", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String I() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gtmne", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String J() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gflv", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String K() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gbsbd", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String L() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gbfspy", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String M() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gbplfo", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String N() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("giads", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> O() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("gal", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> P() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("gsl", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String Q() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvk", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String R() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gscpt", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String S() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gsnmd", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String T() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gpgnm", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String U() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gpnmmt", null));
    }

    @Override // cn.fly.verify.ef
    public int V() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gpvsnm", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String W() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gpvsme", null));
    }

    @Override // cn.fly.verify.ef
    public boolean X() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("cinmnps", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String Y() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gcrtpcnm", null));
    }

    @Override // cn.fly.verify.ef
    public boolean Z() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ciafgd", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo a(java.lang.String str, int i) {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, cn.fly.verify.er.a("gtaifprm", new java.util.ArrayList(java.util.Arrays.asList(str, java.lang.Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo a(boolean z, java.lang.String str, int i) {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, cn.fly.verify.er.a("gtaifprmfce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z), str, java.lang.Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.PackageInfo a(boolean z, int i, java.lang.String str, int i2) {
        return (android.content.pm.PackageInfo) a(android.content.pm.PackageInfo.class, cn.fly.verify.er.a("gpgiffist", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i), str, java.lang.Integer.valueOf(i2)))));
    }

    @Override // cn.fly.verify.ef
    public android.location.Location a(int i, int i2, boolean z) {
        return (android.location.Location) a(android.location.Location.class, cn.fly.verify.er.a("glctn", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object a(int i, int i2, boolean z, boolean z2) {
        return a(java.lang.Object.class, cn.fly.verify.er.a("gtelcmefce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String a(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gstmpts", new java.util.ArrayList(java.util.Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String a(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gsimtfce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> a(boolean z, boolean z2) {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("giafce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)))));
    }

    @Override // cn.fly.verify.ef
    public java.util.List<android.content.pm.ResolveInfo> a(android.content.Intent intent, int i) {
        return (java.util.List) a(java.util.List.class, cn.fly.verify.er.a("qritsvc", new java.util.ArrayList(java.util.Arrays.asList(intent, java.lang.Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ef
    public boolean a() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("cird", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.Context aa() {
        return (android.content.Context) a(android.content.Context.class, cn.fly.verify.er.a("gaplcn", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ab() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvda", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ac() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvdtnas", null));
    }

    @Override // cn.fly.verify.ef
    public long ad() {
        return ((java.lang.Long) a(java.lang.Long.TYPE, cn.fly.verify.er.a("galtut", null))).longValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ae() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvme", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String af() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gcrup", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ag() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gcifm", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ah() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("godm", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ai() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("godhm", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> aj() {
        return (java.util.HashMap) a(java.util.HashMap.class, cn.fly.verify.er.a("galdm", null));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo ak() {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, cn.fly.verify.er.a("gtaif", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> al() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("gtaifok", null));
    }

    @Override // cn.fly.verify.ef
    public long am() {
        return ((java.lang.Long) a(java.lang.Long.TYPE, cn.fly.verify.er.a("gtbdt", null))).longValue();
    }

    @Override // cn.fly.verify.ef
    public double an() {
        return ((java.lang.Double) a(java.lang.Double.TYPE, cn.fly.verify.er.a("gtscnin", null))).doubleValue();
    }

    @Override // cn.fly.verify.ef
    public int ao() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gtscnppi", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public boolean ap() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ishmos", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String aq() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gthmosv", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ar() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gthmosdtlv", null));
    }

    @Override // cn.fly.verify.ef
    public int as() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gthmpmst", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public int at() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gthmepmst", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String au() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gtinnerlangmt", null));
    }

    @Override // cn.fly.verify.ef
    public int av() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("gtgramgendt", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public boolean aw() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ctedebbing", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ResolveInfo b(android.content.Intent intent, int i) {
        return (android.content.pm.ResolveInfo) a(android.content.pm.ResolveInfo.class, cn.fly.verify.er.a("rsaciy", new java.util.ArrayList(java.util.Arrays.asList(intent, java.lang.Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object b(boolean z, int i, java.lang.String str, int i2) {
        return a(android.content.pm.PackageInfo.class, cn.fly.verify.er.a("gmpfis", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i), str, java.lang.Integer.valueOf(i2)))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String b(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gbsifce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean b() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("cx", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean b(java.lang.String str) {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ipgist", new java.util.ArrayList(java.util.Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String c(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gsnmdfp", new java.util.ArrayList(java.util.Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String c(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gcriefce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean c() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ckpd", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String d(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gpnmfp", new java.util.ArrayList(java.util.Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String d(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gcrnmfce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean d() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("degb", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> e(boolean z) {
        return (java.util.HashMap) a(java.util.HashMap.class, cn.fly.verify.er.a("wmcwifce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean e() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("vnmt", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean e(java.lang.String str) {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ckpmsi", new java.util.ArrayList(java.util.Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public long f(java.lang.String str) {
        return ((java.lang.Long) a(java.lang.Long.TYPE, cn.fly.verify.er.a("gtlstactme", new java.util.ArrayList(java.util.Arrays.asList(str))))).longValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String f(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gneypfce", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean f() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ckua", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String g(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvkfc", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean g() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("dvenbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String h(boolean z) {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gtdm", new java.util.ArrayList(java.util.Arrays.asList(java.lang.Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ef
    public boolean h() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("ubenbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean i() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, cn.fly.verify.er.a("iwpxy", null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String j() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gavti", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String k() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gmivsn", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String l() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("bgmdl", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String m() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gmnft", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String n() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gbrd", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String o() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gdvtp", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object p() {
        return a(java.lang.Object.class, cn.fly.verify.er.a("gtecloc", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> q() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("gnbclin", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> r() {
        return e(false);
    }

    @Override // cn.fly.verify.ef
    public int s() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, cn.fly.verify.er.a("govsit", null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String t() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("govsnm", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String u() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("golgu", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String v() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gocnty", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> w() {
        return (java.util.HashMap) a(java.util.HashMap.class, cn.fly.verify.er.a("gcuin", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.ArrayList<java.lang.String>> x() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, cn.fly.verify.er.a("gtydvin", null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String y() {
        return (java.lang.String) a(java.lang.String.class, cn.fly.verify.er.a("gqmkn", null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> z() {
        return (java.util.HashMap) a(java.util.HashMap.class, cn.fly.verify.er.a("gszin", null));
    }
}
