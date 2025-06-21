package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;
    private static final java.util.Map<java.lang.Class<?>, java.lang.String> t = new com.qq.e.comm.managers.plugin.PM.b();
    private final android.content.Context b;
    private java.lang.String c;
    private java.io.File d;
    private volatile int e;
    private dalvik.system.DexClassLoader f;
    private java.io.RandomAccessFile g;
    private java.nio.channels.FileLock h;
    private boolean i;
    private final com.qq.e.comm.managers.plugin.f j;
    private volatile com.qq.e.comm.pi.POFactory k;
    private int l;
    private int m;
    private java.util.concurrent.Future<java.lang.Boolean> n;
    private boolean p;
    private java.lang.String q;
    private org.json.JSONObject r;

    /* renamed from: s, reason: collision with root package name */
    private int f425s;
    final java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();
    private boolean o = false;

    public class a implements java.util.concurrent.Callable<java.lang.Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Boolean call() throws java.lang.Exception {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.qq.e.comm.managers.plugin.h.b(com.qq.e.comm.managers.plugin.PM.this.b);
            com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM.this);
            if (!com.qq.e.comm.managers.plugin.PM.this.i) {
                com.qq.e.comm.managers.plugin.PM pm = com.qq.e.comm.managers.plugin.PM.this;
                pm.i = pm.tryLockUpdate();
            }
            if (com.qq.e.comm.managers.plugin.PM.d(com.qq.e.comm.managers.plugin.PM.this)) {
                com.qq.e.comm.managers.plugin.PM.this.m = (int) (java.lang.System.currentTimeMillis() - currentTimeMillis);
                com.qq.e.comm.managers.plugin.PM.e(com.qq.e.comm.managers.plugin.PM.this);
            }
            com.qq.e.comm.managers.plugin.PM.this.l = (int) (java.lang.System.currentTimeMillis() - currentTimeMillis);
            return java.lang.Boolean.TRUE;
        }
    }

    public static class b extends java.util.HashMap<java.lang.Class<?>, java.lang.String> {
        public b() {
            put(com.qq.e.comm.pi.POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(android.content.Context context, com.qq.e.comm.managers.plugin.f fVar) {
        this.b = context.getApplicationContext();
        this.j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.q);
            }
            jSONObject.put(com.umeng.analytics.pro.f.T, pluginVersion);
            jSONObject.put("sig", this.c);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.u, com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
            jSONObject.put("ict", this.l);
            jSONObject.put("mup", this.i);
            jSONObject.put("ifg", this.f425s);
            jSONObject.put("pct", this.m);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public static void b(com.qq.e.comm.managers.plugin.PM pm) {
        android.content.SharedPreferences sharedPreferences = pm.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            pm.p = true;
            sharedPreferences.edit().remove("crash_count").commit();
            com.qq.e.comm.util.GDTLogger.e("加载本地插件");
        }
    }

    private boolean b() {
        if (!this.i) {
            return false;
        }
        try {
            this.f425s = 1;
            android.content.Context context = this.b;
            com.qq.e.comm.managers.plugin.b.a(context, com.qq.e.comm.managers.plugin.h.g(context), com.qq.e.comm.managers.plugin.h.h(this.b));
            this.c = com.qq.e.comm.constants.Sig.ASSET_PLUGIN_SIG;
            this.d = com.qq.e.comm.managers.plugin.h.g(this.b);
            this.e = com.qq.e.comm.managers.status.SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    private boolean c() {
        if (this.p) {
            return false;
        }
        if (this.i) {
            com.qq.e.comm.managers.plugin.g gVar = new com.qq.e.comm.managers.plugin.g(com.qq.e.comm.managers.plugin.h.e(this.b), com.qq.e.comm.managers.plugin.h.f(this.b));
            if (gVar.a(this.b, false)) {
                this.f425s = 3;
                com.qq.e.comm.managers.plugin.h.a(this.b);
                com.qq.e.comm.util.GDTLogger.d("NextExist,Updated=" + gVar.a(com.qq.e.comm.managers.plugin.h.g(this.b), com.qq.e.comm.managers.plugin.h.h(this.b), this.b));
            }
        }
        com.qq.e.comm.managers.plugin.g gVar2 = new com.qq.e.comm.managers.plugin.g(com.qq.e.comm.managers.plugin.h.g(this.b), com.qq.e.comm.managers.plugin.h.h(this.b));
        if (!gVar2.a(this.b, true)) {
            return false;
        }
        if (gVar2.b() < com.qq.e.comm.managers.status.SDKStatus.getBuildInPluginVersion()) {
            com.qq.e.comm.util.GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=" + com.qq.e.comm.managers.status.SDKStatus.getBuildInPluginVersion());
            return false;
        }
        if (this.f425s == 0) {
            this.f425s = 2;
        }
        this.c = gVar2.a();
        this.e = gVar2.b();
        this.d = com.qq.e.comm.managers.plugin.h.g(this.b);
        this.q = gVar2.c();
        this.o = true;
        return true;
    }

    private void d() {
        this.o = false;
        this.n = this.a.submit(new com.qq.e.comm.managers.plugin.PM.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.b() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(com.qq.e.comm.managers.plugin.PM pm) {
        java.lang.StringBuilder sb;
        pm.getClass();
        boolean z = false;
        try {
            com.qq.e.comm.util.GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + java.lang.System.currentTimeMillis());
            if (!pm.c()) {
            }
            z = true;
            sb = new java.lang.StringBuilder();
        } catch (java.lang.Throwable th) {
            try {
                com.qq.e.comm.util.GDTLogger.e("插件加载出现异常", th);
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                sb = new java.lang.StringBuilder();
            } catch (java.lang.Throwable th2) {
                com.qq.e.comm.util.GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + java.lang.System.currentTimeMillis());
                throw th2;
            }
        }
        sb.append("TimeStap_AFTER_PLUGIN_INIT:");
        sb.append(java.lang.System.currentTimeMillis());
        com.qq.e.comm.util.GDTLogger.d(sb.toString());
        return z;
    }

    public static void e(com.qq.e.comm.managers.plugin.PM pm) {
        pm.getClass();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("PluginFile:\t");
        java.io.File file = pm.d;
        sb.append(file == null ? com.igexin.push.core.b.m : file.getAbsolutePath());
        com.qq.e.comm.util.GDTLogger.d(sb.toString());
        if (pm.c == null || pm.d == null) {
            pm.f = null;
            return;
        }
        try {
            pm.f = new dalvik.system.DexClassLoader(pm.d.getAbsolutePath(), com.qq.e.comm.managers.plugin.h.c(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            com.qq.e.comm.managers.plugin.f fVar = pm.j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.e("插件ClassLoader构造发生异常", th);
            com.qq.e.comm.managers.plugin.f fVar2 = pm.j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    public <T> T getFactory(java.lang.Class<T> cls) throws com.qq.e.comm.managers.plugin.e {
        java.util.concurrent.Future<java.lang.Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException unused) {
            }
        }
        com.qq.e.comm.util.GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        java.lang.ClassLoader classLoader = com.qq.e.comm.constants.Sig.ASSET_PLUGIN_SIG == null ? com.qq.e.comm.managers.plugin.PM.class.getClassLoader() : this.f;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(com.qq.e.comm.managers.plugin.PM.class.getClassLoader() == classLoader);
        com.qq.e.comm.util.GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new com.qq.e.comm.managers.plugin.e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            java.lang.String str = t.get(cls);
            if (android.text.TextUtils.isEmpty(str)) {
                throw new com.qq.e.comm.managers.plugin.e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            java.lang.Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", android.content.Context.class, org.json.JSONObject.class).invoke(loadClass, this.b, a()));
            com.qq.e.comm.util.GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (java.lang.Throwable th) {
            throw new com.qq.e.comm.managers.plugin.e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public com.qq.e.comm.pi.POFactory getPOFactory() throws com.qq.e.comm.managers.plugin.e {
        return getPOFactory(true, false);
    }

    public com.qq.e.comm.pi.POFactory getPOFactory(boolean z, boolean z2) throws com.qq.e.comm.managers.plugin.e {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    try {
                        this.k = (com.qq.e.comm.pi.POFactory) getFactory(com.qq.e.comm.pi.POFactory.class);
                    } catch (com.qq.e.comm.managers.plugin.e e) {
                        if (!this.o) {
                            throw e;
                        }
                        com.qq.e.comm.util.GDTLogger.e("插件加载错误，回退到内置版本");
                        this.p = true;
                        this.o = false;
                        this.n = this.a.submit(new com.qq.e.comm.managers.plugin.PM.a());
                        this.k = (com.qq.e.comm.pi.POFactory) getFactory(com.qq.e.comm.pi.POFactory.class);
                    }
                }
            }
        }
        if (z && this.k != null) {
            this.k.start(z2 ? getStartCaller(0) : getStartCaller(2));
        }
        return this.k;
    }

    public int getPluginVersion() {
        java.util.concurrent.Future<java.lang.Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException unused) {
            }
        }
        return this.e;
    }

    public org.json.JSONObject getStartCaller(int i) {
        if (this.r == null) {
            this.r = new org.json.JSONObject();
        }
        try {
            this.r.put("scr", i);
        } catch (org.json.JSONException unused) {
        }
        return this.r;
    }

    public boolean tryLockUpdate() {
        try {
            java.io.File d = com.qq.e.comm.managers.plugin.h.d(this.b);
            if (!d.exists()) {
                d.createNewFile();
                com.qq.e.comm.managers.plugin.h.a(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK, d);
            }
            if (!d.exists()) {
                return false;
            }
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(d, "rw");
            this.g = randomAccessFile;
            java.nio.channels.FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.g.writeByte(37);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
