package cn.fly.verify;

/* loaded from: classes31.dex */
public abstract class bf implements java.lang.Runnable {
    private static final java.util.WeakHashMap<java.lang.String, java.lang.Object> k = new java.util.WeakHashMap<>();
    protected int a;
    protected java.lang.Object b;
    private final java.lang.String c;
    private final java.lang.String d;
    private final long e;
    private final long f;
    private volatile long g;
    private final int h;
    private int i;
    private boolean j;
    private long l;

    /* renamed from: cn.fly.verify.bf$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ cn.fly.verify.fv a;

        public AnonymousClass1(cn.fly.verify.fv fvVar) {
            this.a = fvVar;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            this.a.a(cn.fly.verify.bf.this.b(bVar.i(new int[0])));
        }
    }

    /* renamed from: cn.fly.verify.bf$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends cn.fly.verify.fv<java.util.HashMap<java.lang.String, java.lang.Object>> {
        final /* synthetic */ java.util.HashMap a;
        final /* synthetic */ long b;

        public AnonymousClass2(java.util.HashMap hashMap, long j) {
            this.a = hashMap;
            this.b = j;
        }

        @Override // cn.fly.verify.fv
        public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            this.a.put(cn.fly.verify.bj.a("002dh"), hashMap);
            cn.fly.verify.bf.this.a(hashMap, this.a);
            cn.fly.verify.cd.a().a(this.b, this.a);
        }
    }

    /* renamed from: cn.fly.verify.bf$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements android.os.Handler.Callback {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            try {
                cn.fly.verify.di.a().a(16);
                cn.fly.verify.fp.a(this.a, cn.fly.verify.bj.a("006GejGfBeefeem!g"), null, new java.lang.Object[]{this.b});
                cn.fly.verify.di.a().a(17);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.di.a().a(7, th);
            }
            return false;
        }
    }

    public bf(java.lang.String str, long j, java.lang.String str2, long j2, long j3) {
        this.a = 0;
        this.i = 0;
        this.j = false;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = j2;
        this.h = getClass().hashCode();
        this.l = j3;
        this.g = java.lang.System.currentTimeMillis();
    }

    public bf(java.lang.String str, java.lang.String str2, long j) {
        this(str, 0L, str2, 0L, j);
    }

    public static long a(java.lang.String str, java.lang.Long l) {
        java.util.Map map = (java.util.Map) cn.fly.verify.bo.a(cn.fly.verify.bj.a("005!gi$hVej.j1gi"), (java.lang.Object) null);
        if (map == null) {
            return 0L;
        }
        return ((java.lang.Long) cn.fly.verify.fq.a(map.get(str), l)).longValue();
    }

    public static void a(java.lang.String str, java.io.File file, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.lang.Object obj;
        java.lang.Object a = cn.fly.verify.fp.a((java.lang.Object) cn.fly.verify.ax.g(), cn.fly.verify.bj.a("014FffCgj hl'he^gigigdfe5e;ed1g]ek"), new java.lang.Object[0]);
        cn.fly.verify.fp.b(cn.fly.verify.bj.a("028]edSehPeeejemgegielgiGjgDeggegl>gUfdhl7he%gigigdfeZe?edBg[ek"), cn.fly.verify.bj.a("028]edSehPeeejemgegielgiGjgDeggegl>gUfdhl7he%gigigdfeZe?edBg[ek"));
        file.setReadOnly();
        java.io.File parentFile = file.getParentFile();
        java.util.WeakHashMap<java.lang.String, java.lang.Object> weakHashMap = k;
        synchronized (weakHashMap) {
            obj = weakHashMap.get(str);
            if (obj == null) {
                obj = cn.fly.verify.fp.a(cn.fly.verify.bj.a("028Fed*ehLeeejemgegielgiUjgHeggegl]g'fdhlHhe*gigigdfeEe9edDg@ek"), file.getAbsolutePath(), parentFile.getAbsolutePath(), parentFile.getAbsolutePath(), a);
                weakHashMap.put(str, obj);
            }
        }
        cn.fly.verify.fq.a(parentFile);
        java.lang.String a2 = cn.fly.verify.df.a((cn.fly.verify.bd) null);
        java.lang.Object a3 = cn.fly.verify.fp.a(cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("009h9fe0eJedhl^he:gigi"), str2), cn.fly.verify.bj.a("009MffUgjDidSgji9feed"), str3, java.lang.String.class);
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(cn.fly.verify.bj.a("004Vedehejed"), a2);
        hashMap.put(cn.fly.verify.bj.a("004Segfeejed"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ah());
        hashMap.put(cn.fly.verify.bj.a("010>giedemhkPgAekgiejfeUf"), java.lang.Integer.valueOf(cn.fly.verify.ax.a));
        hashMap.put(cn.fly.verify.bj.a("006ekk*jdMgQel"), cn.fly.verify.dv.a());
        hashMap.put(cn.fly.verify.bj.a("009ekkKfk=gd3ekFgj"), cn.fly.verify.ax.e());
        hashMap.put(cn.fly.verify.bj.a("006RedfeegOeGej6f"), cn.fly.verify.ax.a().a());
        hashMap.put(cn.fly.verify.bj.a("010TfgfeekFdg[gk!jjk=gi"), java.lang.Boolean.valueOf(cn.fly.verify.ax.b()));
        hashMap.put(cn.fly.verify.bj.a("009UfgfeekNdgXfjSk*eeii"), java.lang.Boolean.valueOf(cn.fly.verify.ax.c()));
        hashMap.put(cn.fly.verify.bj.a("004gdg7fd"), java.lang.Long.valueOf(((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.bj.a("004gdgDfd"), 5L)).longValue()));
        hashMap.put(cn.fly.verify.bj.a("002d6ed"), (java.lang.String) cn.fly.verify.bo.a(cn.fly.verify.bj.a("002dOed"), cn.fly.verify.bj.a("006]ififigigigig")));
        hashMap.put("usridt", cn.fly.verify.bk.d());
        hashMap.put("mdp", cn.fly.verify.eb.class.getName());
        java.lang.String a4 = cn.fly.verify.fm.a(hashMap);
        cn.fly.verify.fp.a(a3, cn.fly.verify.bj.a("013(gi$gjFfm9ddgVgigiejgfLhg"), java.lang.Boolean.TRUE);
        cn.fly.verify.di.a().a(15);
        cn.fly.verify.ft.a(0, new cn.fly.verify.bf.AnonymousClass3(a3, a4));
    }

    private void m() {
        int i;
        if (this.j || (i = this.a) < 0) {
            return;
        }
        this.a = i + 1;
    }

    public cn.fly.verify.bf a(long j) {
        if (j > 0) {
            this.g = java.lang.System.currentTimeMillis() + (j * 1000);
        } else {
            this.g = -1L;
        }
        return this;
    }

    public cn.fly.verify.bf a(java.lang.Object obj) {
        this.b = obj;
        return this;
    }

    public cn.fly.verify.bf a(boolean z) {
        this.j = z;
        if (z) {
            this.l = 0L;
        }
        return this;
    }

    public <T> T a(java.lang.String str, T t) {
        return (T) cn.fly.verify.bo.a(str, t);
    }

    public void a() {
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j, java.lang.String str, java.lang.Object obj) {
        a(j, str, obj, false);
    }

    public void a(long j, java.lang.String str, java.lang.Object obj, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, boolean z) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j2 = j > 0 ? (j * 1000) + currentTimeMillis : currentTimeMillis;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>();
        hashMap2.put(cn.fly.verify.bj.a("004j6elPkg"), str);
        hashMap2.put(cn.fly.verify.bj.a("004h$ejgiSj"), obj);
        hashMap2.put(cn.fly.verify.bj.a("008^edJejgjCejeg3g"), java.lang.Long.valueOf(currentTimeMillis));
        if (hashMap != null && !hashMap.isEmpty()) {
            hashMap2.putAll(hashMap);
        }
        if (z) {
            a((cn.fly.verify.fv<java.util.HashMap<java.lang.String, java.lang.Object>>) new cn.fly.verify.bf.AnonymousClass2(hashMap2, j2));
        } else {
            cn.fly.verify.cd.a().a(j2, hashMap2);
        }
    }

    public void a(long j, java.lang.String str, java.lang.Object obj, boolean z) {
        a(j, str, obj, null, z);
    }

    public void a(cn.fly.verify.fv<java.util.HashMap<java.lang.String, java.lang.Object>> fvVar) {
        if (((java.lang.Integer) a(cn.fly.verify.bj.a("002QfeYh"), (java.lang.String) 0)).intValue() == 1) {
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).a(0, 0, true, false).a(new cn.fly.verify.bf.AnonymousClass1(fvVar));
        } else {
            fvVar.a(null);
        }
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2) {
    }

    public cn.fly.verify.bf b(boolean z) {
        this.a = z ? 0 : -1;
        return this;
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> b(java.lang.Object obj) {
        java.lang.Object th;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
        if (obj == null) {
            return null;
        }
        cn.fly.verify.en.a aVar = new cn.fly.verify.en.a(obj);
        try {
            hashMap = new java.util.HashMap<>();
            try {
                hashMap.put("accmt", java.lang.Float.valueOf(aVar.a()));
                if (aVar.i()) {
                    hashMap.put("vacmt", java.lang.Float.valueOf(aVar.j()));
                }
                hashMap.put("ltdmt", java.lang.Double.valueOf(aVar.b()));
                hashMap.put("lndmt", java.lang.Double.valueOf(aVar.c()));
                hashMap.put(cn.fly.verify.dg.a, java.lang.Long.valueOf(aVar.d()));
                hashMap.put("prvmt", aVar.e());
                hashMap.put("atdmt", java.lang.Double.valueOf(aVar.f()));
                hashMap.put("brmt", java.lang.Float.valueOf(aVar.g()));
                hashMap.put("spmt", java.lang.Float.valueOf(aVar.h()));
            } catch (java.lang.Throwable th2) {
                th = th2;
                cn.fly.verify.ed.a().a("[cl] glfe " + th, new java.lang.Object[0]);
                return hashMap;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            hashMap = null;
        }
        return hashMap;
    }

    public void b() {
        long l = l();
        if (l > 0) {
            a(l);
        } else {
            this.j = true;
        }
    }

    public java.lang.String c() {
        return this.c;
    }

    public boolean d() {
        return ((java.lang.Long) cn.fly.verify.bo.a(this.c, java.lang.Long.valueOf(this.e))).longValue() != 0 && e();
    }

    public final boolean e() {
        if ("bs,l,ol,wi,wl,ext,aa,".contains(this.c + ",")) {
            return cn.fly.verify.dk.a().b();
        }
        return true;
    }

    public boolean f() {
        return this.a == 0;
    }

    public boolean g() {
        if (!d()) {
            return false;
        }
        cn.fly.verify.ea.c.execute(this);
        return true;
    }

    public boolean h() {
        boolean a = cn.fly.verify.bo.a();
        boolean b = cn.fly.verify.bo.b();
        if (!a || !b) {
            cn.fly.verify.ed.a().a("slt: " + c() + ", to: " + a + ", conn: " + b, new java.lang.Object[0]);
            return false;
        }
        boolean d = d();
        cn.fly.verify.ed.a().a("slt : " + getClass().getSimpleName() + ", to: " + a + ", conn: " + b + ", " + this.c + ": " + d + ", key: " + a(this.c, (java.lang.String) 0) + ", gp: " + l() + " , oce " + this.j + " , tt " + this.a, new java.lang.Object[0]);
        return d;
    }

    public long i() {
        return this.g;
    }

    public int j() {
        return this.h;
    }

    public abstract void k() throws java.lang.Throwable;

    public long l() {
        try {
            java.lang.String str = this.d;
            if (str != null) {
                return java.lang.Long.parseLong(java.lang.String.valueOf(cn.fly.verify.bo.a(str, java.lang.Long.valueOf(this.f))));
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0L;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l > 0) {
            cn.fly.verify.bj.a().a(this.l, (long) this, this.i);
            this.l = 0L;
            return;
        }
        try {
            if (f()) {
                a();
            }
            if (h()) {
                k();
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
