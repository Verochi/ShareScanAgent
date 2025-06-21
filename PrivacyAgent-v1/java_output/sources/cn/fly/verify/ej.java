package cn.fly.verify;

/* loaded from: classes.dex */
public class ej {
    private static cn.fly.verify.ej b;
    private android.content.Context a;
    private java.lang.Object c;
    private android.content.pm.PackageManager d;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> e = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> f = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> g = new java.util.concurrent.ConcurrentHashMap<>();
    private java.lang.String h;

    /* renamed from: cn.fly.verify.ej$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ej.a<java.lang.Object> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, int i) {
            super(null);
            this.a = str;
            this.b = i;
        }

        @Override // cn.fly.verify.ej.a
        public java.lang.Object a() throws java.lang.Throwable {
            return cn.fly.verify.ej.this.c(this.a, this.b);
        }
    }

    /* renamed from: cn.fly.verify.ej$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.ej.a<java.lang.Object> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, int i) {
            super(null);
            this.a = str;
            this.b = i;
        }

        @Override // cn.fly.verify.ej.a
        public java.lang.Object a() throws java.lang.Throwable {
            return cn.fly.verify.ej.this.c(this.a, this.b);
        }
    }

    public static abstract class a<T> {
        private a() {
        }

        public /* synthetic */ a(cn.fly.verify.ej.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract T a() throws java.lang.Throwable;
    }

    private ej(android.content.Context context) {
        this.a = context;
        java.lang.String packageName = context.getPackageName();
        this.h = packageName;
        try {
            a(packageName, 193);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    public static cn.fly.verify.ej a(android.content.Context context) {
        if (b == null) {
            synchronized (cn.fly.verify.ej.class) {
                if (b == null) {
                    b = new cn.fly.verify.ej(context);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(java.lang.String str, cn.fly.verify.ej.a<T> aVar, long j, T t, boolean z) {
        T t2;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> concurrentHashMap;
        int valueOf;
        T t3 = (T) null;
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (str == null) {
            t2 = aVar.a();
            return t2 != null ? t : t2;
        }
        java.lang.Integer num = this.f.get(str);
        if (num != null && (t3 = (T) this.e.get(str)) == null && !z) {
            return t;
        }
        java.lang.Long l = this.g.get(str);
        boolean z2 = false;
        if (l != null && java.lang.System.currentTimeMillis() >= l.longValue()) {
            z2 = true;
        }
        if (t3 == null || z2 || z) {
            t3 = aVar.a();
            if (t3 != null) {
                this.e.put(str, t3);
                if (j > 0) {
                    this.g.put(str, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() + j));
                }
            }
            if (num == null) {
                concurrentHashMap = this.f;
                valueOf = 1;
            } else {
                concurrentHashMap = this.f;
                valueOf = java.lang.Integer.valueOf(num.intValue() + 1);
            }
            concurrentHashMap.put(str, valueOf);
        }
        t2 = t3;
        if (t2 != null) {
        }
    }

    private <T> T a(java.lang.String str, cn.fly.verify.ej.a<T> aVar, T t) {
        return (T) a(str, aVar, 0L, t, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.Object c(java.lang.String str, int i) throws java.lang.Throwable {
        return android.os.Build.VERSION.SDK_INT <= 25 ? cn.fly.verify.fh.d.a(this.d, cn.fly.verify.bj.a("014GffJgj@hmIed3em1e.ff7g]fj<fWfgfe"), new java.lang.Object[]{str, java.lang.Integer.valueOf(i)}, new java.lang.Class[]{java.lang.String.class, java.lang.Integer.TYPE}) : cn.fly.verify.ep.a(this.a, str, i);
    }

    public java.lang.Object a(java.lang.String str, int i) throws java.lang.Throwable {
        if (this.d == null) {
            this.d = this.a.getPackageManager();
        }
        boolean equals = str.equals(this.h);
        if (!equals && !cn.fly.verify.de.b()) {
            return null;
        }
        if (!equals) {
            return c(str, i);
        }
        int i2 = (i == 0 || i == 1 || i == 128 || i == 64) ? 193 : i;
        java.lang.Object a2 = a("gpisys-" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2, new cn.fly.verify.ej.AnonymousClass1(str, i2), (cn.fly.verify.ej.AnonymousClass1) null);
        if (a2 != null || i2 != 193) {
            return a2;
        }
        return a("gpisys-" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i, new cn.fly.verify.ej.AnonymousClass2(str, i), (cn.fly.verify.ej.AnonymousClass2) null);
    }

    public java.lang.String a(java.lang.String str) {
        return a(str, "");
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.Object a2 = cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.bj.a("027ef<edekfeejedgefegigefkelgiQjgReghmekfeBkg9ek'jYejPg^gi"), (java.lang.String) null), cn.fly.verify.bj.a("003HffNgj"), str2, str);
        return a2 != null ? java.lang.String.valueOf(a2) : str2;
    }

    public java.util.Enumeration<java.net.NetworkInterface> a() {
        try {
            return java.net.NetworkInterface.getNetworkInterfaces();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public java.util.Enumeration<java.net.InetAddress> a(java.net.NetworkInterface networkInterface) {
        return (java.util.Enumeration) cn.fly.verify.fp.a(networkInterface, cn.fly.verify.bj.a("0169ffRgj_fjWfgj<fmededek'g)gigi5g>gi"), (java.lang.Object) null, new java.lang.Object[0]);
    }

    public java.util.List<android.content.pm.ResolveInfo> a(android.content.Intent intent, int i) {
        if (cn.fly.verify.de.b()) {
            return (java.util.List) cn.fly.verify.fp.a(this.a.getPackageManager(), cn.fly.verify.bj.a("019*efeh@g;ekelfjPfjgfj;fk4g6ekeeej0dg+gi"), new java.lang.Object[]{intent, java.lang.Integer.valueOf(i)}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Intent.class, java.lang.Integer.TYPE}, (java.lang.Object) null);
        }
        return null;
    }

    public int b() {
        if (!cn.fly.verify.eh.a(this.a).d().e(cn.fly.verify.bj.a("035efYedekfeejedge4kg=ekegejgigiejfe2fRgehjhifmgleihmgkhhfihieifkflfmflhi"))) {
            return -1;
        }
        if (!cn.fly.verify.az.a().f()) {
            return cn.fly.verify.az.a().m();
        }
        if (this.c == null) {
            this.c = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("005kiVfe;fg"));
        }
        return ((java.lang.Integer) cn.fly.verify.fp.a(this.c, cn.fly.verify.bj.a("014Vff1gj?fi!gjAggfeekemflel kg"), -1, new java.lang.Object[0])).intValue();
    }

    public android.content.pm.ApplicationInfo b(java.lang.String str, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        if (this.d == null) {
            this.d = this.a.getPackageManager();
        }
        if (android.text.TextUtils.equals(str, this.a.getPackageName()) || cn.fly.verify.de.b()) {
            return this.d.getApplicationInfo(str, i);
        }
        return null;
    }

    public android.content.pm.ResolveInfo b(android.content.Intent intent, int i) {
        if (cn.fly.verify.de.b()) {
            return (android.content.pm.ResolveInfo) cn.fly.verify.fp.a(this.a.getPackageManager(), cn.fly.verify.bj.a("015@ek-g-gife4h+ee?gLfm%djNejeeej,jZel"), new java.lang.Object[]{intent, java.lang.Integer.valueOf(i)}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Intent.class, java.lang.Integer.TYPE}, (java.lang.Object) null);
        }
        return null;
    }

    public int c() {
        if (android.os.Build.VERSION.SDK_INT < 24 || !cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("035efHedekfeejedgeVkgWekegejgigiejfeAf,gehjhifmgleihmgkhhfihieifkflfmflhi"))) {
            return -1;
        }
        if (!cn.fly.verify.az.a().f()) {
            return cn.fly.verify.az.a().m();
        }
        if (this.c == null) {
            this.c = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("005ki'fe?fg"));
        }
        return ((java.lang.Integer) cn.fly.verify.fp.a(this.c, cn.fly.verify.bj.a("0187ff:gj<gl?ejeAfi7gj2ggfeekemflel;kg"), -1, new java.lang.Object[0])).intValue();
    }

    public android.content.pm.ApplicationInfo d() {
        return this.a.getApplicationInfo();
    }
}
