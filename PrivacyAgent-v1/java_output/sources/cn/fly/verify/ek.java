package cn.fly.verify;

/* loaded from: classes.dex */
public class ek implements cn.fly.verify.ef {
    private java.util.HashMap<java.lang.String, java.lang.Object> a;

    public ek(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        this.a = hashMap;
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

    private java.lang.Object a(java.lang.String str, java.lang.Object... objArr) {
        java.util.LinkedList<java.lang.Object> a;
        try {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.a;
            if (hashMap == null || !hashMap.containsKey(str) || (a = cn.fly.verify.ce.a(this.a.get(str), objArr)) == null || a.isEmpty()) {
                return null;
            }
            return a.get(0);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Long> A() {
        return (java.util.HashMap) a(java.util.HashMap.class, a("gmrin", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String B() {
        return (java.lang.String) a(java.lang.String.class, a("galgu", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String C() {
        return (java.lang.String) a(java.lang.String.class, a("gscsz", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String D() {
        return (java.lang.String) a(java.lang.String.class, a("gneypnw", new java.lang.Object[0]));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String E() {
        return (java.lang.String) a(java.lang.String.class, a("gnktpfs", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String F() {
        return (java.lang.String) a(java.lang.String.class, a("gdtlnktpfs", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public boolean G() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("cknavbl", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public int H() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gdntp", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String I() {
        return (java.lang.String) a(java.lang.String.class, a("gtmne", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String J() {
        return (java.lang.String) a(java.lang.String.class, a("gflv", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String K() {
        return (java.lang.String) a(java.lang.String.class, a("gbsbd", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String L() {
        return (java.lang.String) a(java.lang.String.class, a("gbfspy", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String M() {
        return (java.lang.String) a(java.lang.String.class, a("gbplfo", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String N() {
        return (java.lang.String) a(java.lang.String.class, a("giads", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> O() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("gal", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> P() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("gsl", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String Q() {
        return (java.lang.String) a(java.lang.String.class, a("gdvk", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String R() {
        return (java.lang.String) a(java.lang.String.class, a("gscpt", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String S() {
        return (java.lang.String) a(java.lang.String.class, a("gsnmd", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String T() {
        return (java.lang.String) a(java.lang.String.class, a("gpgnm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String U() {
        return (java.lang.String) a(java.lang.String.class, a("gpnmmt", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public int V() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gpvsnm", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String W() {
        return (java.lang.String) a(java.lang.String.class, a("gpvsme", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public boolean X() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("cinmnps", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String Y() {
        return (java.lang.String) a(java.lang.String.class, a("gcrtpcnm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public boolean Z() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ciafgd", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo a(java.lang.String str, int i) {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, a("gtaifprm", str, java.lang.Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo a(boolean z, java.lang.String str, int i) {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, a("gtaifprmfce", java.lang.Boolean.valueOf(z), str, java.lang.Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.PackageInfo a(boolean z, int i, java.lang.String str, int i2) {
        return (android.content.pm.PackageInfo) a(android.content.pm.PackageInfo.class, a("gpgiffist", java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i), str, java.lang.Integer.valueOf(i2)));
    }

    @Override // cn.fly.verify.ef
    public android.location.Location a(int i, int i2, boolean z) {
        return (android.location.Location) a(android.location.Location.class, a("glctn", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object a(int i, int i2, boolean z, boolean z2) {
        return a(java.lang.Object.class, a("gtelcmefce", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String a(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, a("gstmpts", str));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String a(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gsimtfce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> a(boolean z, boolean z2) {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("giafce", java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)));
    }

    @Override // cn.fly.verify.ef
    public java.util.List<android.content.pm.ResolveInfo> a(android.content.Intent intent, int i) {
        return (java.util.List) a(java.util.List.class, a("qritsvc", intent, java.lang.Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ef
    public boolean a() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("cird", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.Context aa() {
        return (android.content.Context) a(android.content.Context.class, a("gaplcn", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ab() {
        return (java.lang.String) a(java.lang.String.class, a("gdvda", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ac() {
        return (java.lang.String) a(java.lang.String.class, a("gdvdtnas", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public long ad() {
        return ((java.lang.Long) a(java.lang.Long.TYPE, a("galtut", (java.lang.Object[]) null))).longValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ae() {
        return (java.lang.String) a(java.lang.String.class, a("gdvme", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String af() {
        return (java.lang.String) a(java.lang.String.class, a("gcrup", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ag() {
        return (java.lang.String) a(java.lang.String.class, a("gcifm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ah() {
        return (java.lang.String) a(java.lang.String.class, a("godm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ai() {
        return (java.lang.String) a(java.lang.String.class, a("godhm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> aj() {
        return (java.util.HashMap) a(java.util.HashMap.class, a("galdm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ApplicationInfo ak() {
        return (android.content.pm.ApplicationInfo) a(android.content.pm.ApplicationInfo.class, a("gtaif", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> al() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("gtaifok", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public long am() {
        return ((java.lang.Long) a(java.lang.Long.TYPE, a("gtbdt", (java.lang.Object[]) null))).longValue();
    }

    @Override // cn.fly.verify.ef
    public double an() {
        return ((java.lang.Double) a(java.lang.Double.TYPE, a("gtscnin", (java.lang.Object[]) null))).doubleValue();
    }

    @Override // cn.fly.verify.ef
    public int ao() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gtscnppi", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public boolean ap() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ishmos", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String aq() {
        return (java.lang.String) a(java.lang.String.class, a("gthmosv", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String ar() {
        return (java.lang.String) a(java.lang.String.class, a("gthmosdtlv", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public int as() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gthmpmst", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public int at() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gthmepmst", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String au() {
        return (java.lang.String) a(java.lang.String.class, a("gtinnerlangmt", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public int av() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("gtgramgendt", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public boolean aw() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ctedebbing", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public android.content.pm.ResolveInfo b(android.content.Intent intent, int i) {
        return (android.content.pm.ResolveInfo) a(android.content.pm.ResolveInfo.class, a("rsaciy", intent, java.lang.Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object b(boolean z, int i, java.lang.String str, int i2) {
        return a(java.lang.Object.class, a("gpgiffist", java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i), str, java.lang.Integer.valueOf(i2)));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String b(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gbsifce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean b() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("cx", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean b(java.lang.String str) {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ipgist", str))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String c(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, a("gsnmdfp", str));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String c(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gcriefce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean c() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ckpd", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String d(java.lang.String str) {
        return (java.lang.String) a(java.lang.String.class, a("gpnmfp", str));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String d(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gcrnmfce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean d() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("degb", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> e(boolean z) {
        return (java.util.HashMap) a(java.util.HashMap.class, a("wmcwifce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean e() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("vnmt", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean e(java.lang.String str) {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ckpmsi", str))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public long f(java.lang.String str) {
        return ((java.lang.Long) a(java.lang.Long.TYPE, a("gtlstactme", str))).longValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String f(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gneypfce", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean f() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ckua", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String g(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gdvkfc", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean g() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("dvenbl", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String h(boolean z) {
        return (java.lang.String) a(java.lang.String.class, a("gtdm", java.lang.Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ef
    public boolean h() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("ubenbl", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public boolean i() {
        return ((java.lang.Boolean) a(java.lang.Boolean.TYPE, a("iwpxy", (java.lang.Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String j() {
        return (java.lang.String) a(java.lang.String.class, a("gavti", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String k() {
        return (java.lang.String) a(java.lang.String.class, a("gmivsn", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String l() {
        return (java.lang.String) a(java.lang.String.class, a("bgmdl", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String m() {
        return (java.lang.String) a(java.lang.String.class, a("gmnft", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String n() {
        return (java.lang.String) a(java.lang.String.class, a("gbrd", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String o() {
        return (java.lang.String) a(java.lang.String.class, a("gdvtp", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.Object p() {
        return a(java.lang.Object.class, a("gtecloc", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> q() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("gnbclin", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> r() {
        return e(false);
    }

    @Override // cn.fly.verify.ef
    public int s() {
        return ((java.lang.Integer) a(java.lang.Integer.TYPE, a("govsit", (java.lang.Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ef
    public java.lang.String t() {
        return (java.lang.String) a(java.lang.String.class, a("govsnm", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String u() {
        return (java.lang.String) a(java.lang.String.class, a("golgu", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String v() {
        return (java.lang.String) a(java.lang.String.class, a("gocnty", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.lang.Object> w() {
        return (java.util.HashMap) a(java.util.HashMap.class, a("gcuin", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.ArrayList<java.util.ArrayList<java.lang.String>> x() {
        return (java.util.ArrayList) a(java.util.ArrayList.class, a("gtydvin", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.lang.String y() {
        return (java.lang.String) a(java.lang.String.class, a("gqmkn", (java.lang.Object[]) null));
    }

    @Override // cn.fly.verify.ef
    public java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> z() {
        return (java.util.HashMap) a(java.util.HashMap.class, a("gszin", (java.lang.Object[]) null));
    }
}
