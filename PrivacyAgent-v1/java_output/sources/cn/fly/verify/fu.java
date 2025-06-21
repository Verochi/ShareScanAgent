package cn.fly.verify;

/* loaded from: classes.dex */
public class fu {
    private final android.content.Context a;

    public fu(android.content.Context context) {
        this.a = context;
    }

    private boolean b() {
        try {
            java.lang.Object a = cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.dn.a("027bc@babhcbbgbadbcbdfdbchbidf'gd'bdejbhcb]hd!bhBgEbg%dRdf"), (java.lang.String) null), cn.fly.verify.dn.a("003*cc^dg"), "", "ro.build.tags");
            java.lang.String valueOf = a != null ? java.lang.String.valueOf(a) : null;
            if (!(valueOf != null && valueOf.contains(cn.fly.verify.dn.a("009gd]df3gRfibjMd7bidf")))) {
                if (!g()) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private boolean c() {
        return "0".equals(cn.fly.verify.eg.a(this.a).a(cn.fly.verify.dn.a("020 bhcbdbdccbcbAgZdbcd6eb*dfQf9db.e:cbGaCbj>dGba")));
    }

    private boolean d() {
        java.lang.String a = cn.fly.verify.eg.a(this.a).a(cn.fly.verify.dn.a("025Qbhcbdbdccbcb@gWdbbbCd*bhbgcdbgHdVbadccbcbGgAdf-gbgd"));
        if (a != null) {
            return android.text.TextUtils.equals(a.toLowerCase(), "orange") || android.text.TextUtils.equals(a.toLowerCase(), "red");
        }
        return false;
    }

    private boolean e() {
        java.lang.String a = cn.fly.verify.eg.a(this.a).a(cn.fly.verify.dn.a("027IbhcbdbdccbcbRgNdbbbdcbdQdgb$dbbaRd+bbbg>adXbfdf5gbgd"));
        return a != null && android.text.TextUtils.equals(cn.fly.verify.dn.a("008DbeXce0cb4aHbjNdZba"), a.toLowerCase());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f() {
        java.lang.Object obj;
        java.io.InputStream inputStream;
        ?? r8;
        int myPid = android.os.Process.myPid();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            obj = cn.fly.verify.dw.c(cn.fly.verify.dn.a("010abg!gd<jh4bhcbMaj") + (myPid + cn.fly.verify.dn.a("007jQbdcbbeQcgIdf")));
            try {
                inputStream = (java.io.InputStream) cn.fly.verify.fp.a(obj, cn.fly.verify.dn.a("014Jcc6dg!cg5ch3beDg<chUgSbh3db[bd"), (java.lang.Object) null, new java.lang.Object[0]);
                if (inputStream != null) {
                    try {
                        r8 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "utf-8"));
                        while (true) {
                            try {
                                java.lang.String readLine = r8.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("\n");
                            } catch (java.lang.Throwable th) {
                                th = th;
                                try {
                                    cn.fly.verify.ed.a().a(th);
                                    cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                                    if (obj != null) {
                                    }
                                    return sb.toString().contains(cn.fly.verify.dn.a("0060bdXbMccbgdfbj"));
                                } catch (java.lang.Throwable th2) {
                                    cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                                    if (obj != null) {
                                        cn.fly.verify.fp.a(obj, cn.fly.verify.dn.a("007'baUd(df.g!bhcbbi"), (java.lang.Object) null, new java.lang.Object[0]);
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        r8 = 0;
                    }
                } else {
                    r8 = 0;
                }
                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                if (obj != null) {
                    cn.fly.verify.fp.a(obj, cn.fly.verify.dn.a("007'baUd(df.g!bhcbbi"), (java.lang.Object) null, new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                r8 = inputStream;
                cn.fly.verify.ed.a().a(th);
                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                if (obj != null) {
                    cn.fly.verify.fp.a(obj, cn.fly.verify.dn.a("007'baUd(df.g!bhcbbi"), (java.lang.Object) null, new java.lang.Object[0]);
                }
                return sb.toString().contains(cn.fly.verify.dn.a("0060bdXbMccbgdfbj"));
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            obj = null;
            inputStream = null;
        }
        return sb.toString().contains(cn.fly.verify.dn.a("0060bdXbMccbgdfbj"));
    }

    private boolean g() {
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
        if (new java.io.File(cn.fly.verify.dn.a("025jDdfbidfBgd=bd(jbhhj*chbe=hd*bhbedfSd$bhdb!bh?bj")).exists()) {
            return true;
        }
        java.lang.String[] strArr = {cn.fly.verify.dn.a("012j6baRbgbjeWcb;abej"), cn.fly.verify.dn.a("016j=ba<bgbje-cb8abej+dcbg%cj"), cn.fly.verify.dn.a("017j0baFbgbjeMcb:abej0cadcbg cj"), cn.fly.verify.dn.a("006jTdfdcbg9cj"), cn.fly.verify.dn.a("008j%dfbeEjZdcbg-cj"), cn.fly.verify.dn.a("012j5dfbidfRgd>bd8j:dcbgZcj"), cn.fly.verify.dn.a("017jEdfbidfAgdCbd5jSdcbg9cj2dbMd;ca4gj"), cn.fly.verify.dn.a("021j)dfbidf0gd=bd1j dcbg5cjXcdVb'bg!eTdf(bScd@dj"), cn.fly.verify.dn.a("016j*dfbidf9gd=bdXjFdfba]j4cadcbgRcj"), cn.fly.verify.dn.a("025j<dfbidfZgdXbdJj$bedfbh@jIddYd.fi^cddJbafibhcbcb<gj"), cn.fly.verify.dn.a("013j!dfbidf_gd5bdOj[cadcbgEcj"), cn.fly.verify.dn.a("013j9dfbidf:gdFbdHj?dfdcbgEcj"), cn.fly.verify.dn.a("012j,bbSdcWbacbbh:jBdcbg cj"), cn.fly.verify.dn.a("006jabafd"), cn.fly.verify.dn.a("005j8ba2bgb"), cn.fly.verify.dn.a("004jSbaEdIbb")};
        for (int i = 0; i < 16; i++) {
            if (new java.io.File(strArr[i], cn.fly.verify.dn.a("002_dfbe")).exists()) {
                return true;
            }
        }
        for (int i2 = 0; i2 < 16; i2++) {
            if (new java.io.File(strArr[i2], cn.fly.verify.dn.a("007>dcbedfbidccbca")).exists()) {
                return true;
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (new java.io.File(strArr[i3], cn.fly.verify.dn.a("006>bd)bUccbgdfbj")).exists()) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        try {
            if (d()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (e()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (c()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (b()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (f()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        } catch (java.lang.Throwable unused) {
        }
        return sb.toString();
    }
}
