package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bz {
    public static final java.lang.String a = "ApkLoader";
    protected static java.lang.Thread.UncaughtExceptionHandler b = null;
    public static final java.lang.String c = "__badApkVersion__9.3711";
    public static final java.lang.String d = "previousProxyVersion";
    protected static final java.lang.String e = "__xadsdk__remote__final__";
    protected static final java.lang.String f = "bdxadsdk.jar";
    protected static final java.lang.String g = "__xadsdk__remote__final__builtin__.jar";
    protected static final java.lang.String h = "__xadsdk__remote__final__builtinversion__.jar";
    protected static final java.lang.String i = "__xadsdk__remote__final__downloaded__.jar";
    protected static final java.lang.String j = "__xadsdk__remote__final__running__.jar";
    public static final java.lang.String k = "OK";
    public static final java.lang.String l = "ERROR";
    public static final java.lang.String m = "APK_INFO";
    public static final java.lang.String n = "CODE";
    public static final java.lang.String o = "success";
    protected static volatile com.baidu.mobads.sdk.internal.bo p = null;
    protected static volatile com.baidu.mobads.sdk.internal.bo q = null;
    protected static volatile java.lang.Class r = null;

    /* renamed from: s, reason: collision with root package name */
    protected static java.lang.String f297s = null;
    protected static final android.os.Handler t = new com.baidu.mobads.sdk.internal.ca(android.os.Looper.getMainLooper());
    private static final java.lang.String x = "baidu_sdk_remote";
    private boolean A;
    private java.util.concurrent.CopyOnWriteArrayList<com.baidu.mobads.sdk.internal.bz.c> B;
    private com.baidu.mobads.sdk.internal.bz.c C;
    protected android.os.Handler u;

    @android.annotation.SuppressLint({"HandlerLeak"})
    protected final android.os.Handler v;
    private com.baidu.mobads.sdk.internal.bx w;
    private final android.content.Context y;
    private com.baidu.mobads.sdk.internal.bt z;

    public static final class a extends java.lang.Exception {
        private static final long a = 2978543166232984104L;

        public a(java.lang.String str) {
            com.baidu.mobads.sdk.internal.bt.a().c(str);
        }
    }

    public static final class b extends java.lang.Exception {
        private static final long a = -7838296421993681751L;

        public b(java.lang.String str) {
            com.baidu.mobads.sdk.internal.bt.a().c(str);
        }
    }

    public interface c {
        void a(boolean z);
    }

    public bz(android.app.Activity activity) {
        this(activity.getApplicationContext());
    }

    public bz(android.content.Context context) {
        this.z = com.baidu.mobads.sdk.internal.bt.a();
        this.A = false;
        this.u = t;
        this.B = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.v = new com.baidu.mobads.sdk.internal.cb(this, android.os.Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = com.baidu.mobads.sdk.internal.cn.a(context);
            com.baidu.mobads.sdk.internal.cn.a(context).a(new com.baidu.mobads.sdk.internal.cc(this));
        }
        if (java.lang.Thread.getDefaultUncaughtExceptionHandler() instanceof com.baidu.mobads.sdk.internal.cn) {
            return;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(b);
    }

    private com.baidu.mobads.sdk.api.IXAdContainerFactory a(com.baidu.mobads.sdk.internal.bo boVar) {
        if (boVar == null) {
            return null;
        }
        try {
            return boVar.a();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(f297s)) {
            f297s = context.getDir(x, 0).getAbsolutePath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (android.text.TextUtils.isEmpty(f297s)) {
            return "";
        }
        return f297s + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.sdk.internal.bs bsVar) {
        java.lang.Class<?> b2 = bsVar.b();
        synchronized (this) {
            q = new com.baidu.mobads.sdk.internal.bo(b2, this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.sdk.internal.bx bxVar) {
        if (bxVar.a().booleanValue()) {
            com.baidu.mobads.sdk.internal.bv a2 = com.baidu.mobads.sdk.internal.bv.a(this.y, bxVar, f297s, this.v);
            if (a2.isAlive()) {
                this.z.a(a, "XApkDownloadThread already started");
                a2.a(bxVar.c());
            } else {
                this.z.a(a, "XApkDownloadThread starting ...");
                a2.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        android.os.Message obtainMessage = this.u.obtainMessage();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, java.lang.String str) {
        try {
            com.baidu.mobads.sdk.internal.cn.a(this.y).c();
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.mobads.sdk.internal.bz.c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    com.baidu.mobads.sdk.internal.bz.c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.mobads.sdk.internal.bz.c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static double b(android.content.Context context) {
        try {
            c(context);
            double b2 = b(f());
            java.lang.String d2 = d();
            if (java.lang.Double.valueOf("9.3711").doubleValue() > b(d2)) {
                com.baidu.mobads.sdk.internal.bs bsVar = new com.baidu.mobads.sdk.internal.bs(d2, context);
                if (bsVar.exists()) {
                    bsVar.delete();
                }
                com.baidu.mobads.sdk.internal.br.a(context, f, d2);
            }
            return java.lang.Math.max(b2, b(d()));
        } catch (java.lang.Exception unused) {
            return 0.0d;
        }
    }

    public static double b(java.lang.String str) {
        java.util.jar.JarFile jarFile = null;
        try {
            try {
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        if (!com.baidu.mobads.sdk.internal.cm.d.booleanValue()) {
            return java.lang.Double.valueOf("9.3711").doubleValue();
        }
        java.io.File file = new java.io.File(str);
        if (com.baidu.mobads.sdk.internal.br.a(file)) {
            java.util.jar.JarFile jarFile2 = new java.util.jar.JarFile(file);
            try {
                double parseDouble = java.lang.Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                if (parseDouble > 0.0d) {
                    try {
                        jarFile2.close();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                    return parseDouble;
                }
                jarFile = jarFile2;
            } catch (java.lang.Exception unused2) {
                jarFile = jarFile2;
                if (jarFile != null) {
                    jarFile.close();
                }
                return 0.0d;
            } catch (java.lang.Throwable th2) {
                th = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (jarFile != null) {
            jarFile.close();
        }
        return 0.0d;
    }

    private void b(com.baidu.mobads.sdk.internal.bs bsVar) {
        this.z.a(a, "len=" + bsVar.length() + ", path=" + bsVar.getAbsolutePath());
        if (p != null) {
            this.z.a(a, "mApkBuilder already initialized, version: " + p.b);
            return;
        }
        java.lang.String a2 = a(this.y);
        com.baidu.mobads.sdk.internal.bs bsVar2 = new com.baidu.mobads.sdk.internal.bs(a2, this.y);
        if (bsVar2.exists()) {
            bsVar2.delete();
        }
        try {
            com.baidu.mobads.sdk.internal.br.a(new java.io.FileInputStream(bsVar), a2);
        } catch (java.lang.Exception e2) {
            this.z.c(e2);
        }
        p = new com.baidu.mobads.sdk.internal.bo(bsVar2.b(), this.y);
        try {
            com.baidu.mobads.sdk.api.IXAdContainerFactory a3 = p.a();
            this.z.a(a, "preloaded apk.version=" + a3.getRemoteVersion());
        } catch (com.baidu.mobads.sdk.internal.bz.a e3) {
            this.z.a(a, "preload local apk " + bsVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
            a(e3.getMessage());
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.mobads.sdk.internal.bz.c cVar, android.os.Handler handler) {
        java.util.concurrent.CopyOnWriteArrayList<com.baidu.mobads.sdk.internal.bz.c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z || o()) {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        } else {
            this.A = true;
        }
        if (this.A) {
            com.baidu.mobads.sdk.internal.bd.a().a((com.baidu.mobads.sdk.internal.j) new com.baidu.mobads.sdk.internal.cd(this, z));
        } else {
            com.baidu.mobads.sdk.internal.bd.a().a(new com.baidu.mobads.sdk.internal.ce(this, z), 5L, java.util.concurrent.TimeUnit.SECONDS);
        }
    }

    public static java.lang.String c() {
        if (android.text.TextUtils.isEmpty(f297s)) {
            return "";
        }
        return f297s + g;
    }

    private static void c(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(f297s)) {
            f297s = context.getDir(x, 0).getAbsolutePath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (java.lang.Exception unused) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        com.baidu.mobads.sdk.internal.an.a(d2, new com.baidu.mobads.sdk.internal.cf(this, d2), new com.baidu.mobads.sdk.internal.cg(this));
    }

    private boolean c(com.baidu.mobads.sdk.internal.bs bsVar) {
        synchronized (this) {
            b(bsVar);
            this.z.a(a, "loaded: " + bsVar.getPath());
        }
        return true;
    }

    public static java.lang.String d() {
        if (android.text.TextUtils.isEmpty(f297s)) {
            return "";
        }
        return f297s + h;
    }

    private static synchronized void d(android.content.Context context) {
        synchronized (com.baidu.mobads.sdk.internal.bz.class) {
            try {
                java.lang.String c2 = c();
                double b2 = b(c2);
                com.baidu.mobads.sdk.internal.bt.a().a(a, "copy assets,compare version=" + java.lang.Double.valueOf("9.3711") + "remote=" + b2);
                if (java.lang.Double.valueOf("9.3711").doubleValue() != b2) {
                    com.baidu.mobads.sdk.internal.bs bsVar = new com.baidu.mobads.sdk.internal.bs(c2, context);
                    if (bsVar.exists()) {
                        bsVar.delete();
                    }
                    com.baidu.mobads.sdk.internal.br.a(context, f, c2);
                }
            } catch (java.lang.Exception e2) {
                throw new com.baidu.mobads.sdk.internal.bz.b("loadBuiltInApk failed: " + e2.toString());
            }
        }
    }

    public static java.lang.String f() {
        if (android.text.TextUtils.isEmpty(f297s)) {
            return "";
        }
        return f297s + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            java.io.File[] listFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 >= listFiles.length) {
                    return;
                }
                if (listFiles[i2].getAbsolutePath().contains(e) && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                    listFiles[i2].delete();
                }
                i2++;
            }
        } catch (java.lang.Exception e2) {
            com.baidu.mobads.sdk.internal.bt.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.SharedPreferences m() {
        return this.y.getSharedPreferences(com.baidu.mobads.sdk.internal.z.aK, 0);
    }

    private boolean n() {
        java.lang.String string = m().getString(d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!com.baidu.mobads.sdk.internal.br.a(c())) {
                if (!com.baidu.mobads.sdk.internal.br.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        com.baidu.mobads.sdk.internal.bs bsVar = new com.baidu.mobads.sdk.internal.bs(f(), this.y);
        if (!com.baidu.mobads.sdk.internal.br.a(bsVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new com.baidu.mobads.sdk.internal.bz.a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                this.z.a(a, "loadDownloadedOrBuiltInApk len=" + bsVar.length() + ", path=" + bsVar.getAbsolutePath());
                b(bsVar);
                double d2 = (double) m().getFloat(c, -1.0f);
                this.z.a(a, "downloadedApkFile.getApkVersion(): " + bsVar.c() + ", badApkVersion: " + d2);
                if (bsVar.c() == d2) {
                    throw new com.baidu.mobads.sdk.internal.bz.a("downloaded file marked bad, drop it and use built-in");
                }
                this.z.a(a, "loaded: " + bsVar.getPath());
            }
            return true;
        } catch (com.baidu.mobads.sdk.internal.bz.a e2) {
            this.z.a(a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (bsVar.exists()) {
                bsVar.delete();
            }
            k();
            return false;
        }
    }

    public final java.lang.String a() {
        return "9.3711";
    }

    public void a(com.baidu.mobads.sdk.internal.bz.c cVar) {
        a(cVar, t);
    }

    @android.annotation.TargetApi(9)
    public void a(com.baidu.mobads.sdk.internal.bz.c cVar, android.os.Handler handler) {
        com.baidu.mobads.sdk.internal.bd.a().a((com.baidu.mobads.sdk.internal.j) new com.baidu.mobads.sdk.internal.ch(this, cVar, handler));
    }

    @android.annotation.TargetApi(9)
    public void a(java.lang.String str) {
        if (p != null) {
            android.content.SharedPreferences.Editor edit = m().edit();
            edit.putFloat(c, (float) p.b);
            edit.apply();
        }
    }

    public void b() {
        new java.io.File(f()).delete();
    }

    public void e() {
        this.z.a(a, "start load assets file");
        d(this.y);
        java.lang.String c2 = c();
        com.baidu.mobads.sdk.internal.bs bsVar = new com.baidu.mobads.sdk.internal.bs(c2, this.y);
        if (!com.baidu.mobads.sdk.internal.br.a(bsVar)) {
            throw new com.baidu.mobads.sdk.internal.bz.b("loadBuiltInApk failed: " + c2);
        }
        this.z.a(a, "assets file can read ,will use it ");
        if (c(bsVar)) {
            b(true);
        }
    }

    public void g() {
        if (h() != 2 ? p() : false) {
            this.z.a(a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (com.baidu.mobads.sdk.internal.bz.b e2) {
            this.z.a(a, "loadBuiltInApk failed: " + e2.toString());
            throw new com.baidu.mobads.sdk.internal.bz.a("load built-in apk failed" + e2.toString());
        }
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public com.baidu.mobads.sdk.api.IXAdContainerFactory i() {
        return a(p);
    }

    public com.baidu.mobads.sdk.api.IXAdContainerFactory j() {
        return a(q);
    }

    public void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }
}
