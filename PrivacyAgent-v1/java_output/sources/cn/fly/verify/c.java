package cn.fly.verify;

/* loaded from: classes31.dex */
public class c {
    private java.lang.String a;
    private java.lang.String b;
    private int c;
    private java.lang.String d;
    private int e;
    private java.lang.String f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private java.lang.String l;
    private boolean m;
    private java.lang.String o;
    private java.lang.String p;
    private boolean q;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.Integer f69s;
    private java.lang.String t;
    private java.lang.Integer u;
    private boolean r = false;
    private final long n = java.lang.System.currentTimeMillis();

    /* renamed from: cn.fly.verify.c$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.fly.verify.g.values().length];
            a = iArr;
            try {
                iArr[cn.fly.verify.g.INIT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[cn.fly.verify.g.PREVERIFY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[cn.fly.verify.g.AUTHPAGE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[cn.fly.verify.g.VERIFY.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[cn.fly.verify.g.LOG.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public c(cn.fly.verify.g gVar, java.lang.String str) {
        java.lang.String str2;
        int i = cn.fly.verify.c.AnonymousClass1.a[gVar.ordinal()];
        if (i == 1) {
            str2 = "init";
        } else if (i == 2) {
            str2 = "preVerify";
        } else if (i == 3) {
            str2 = "authPageOpend";
        } else {
            if (i != 4) {
                if (i == 5) {
                    str2 = "log";
                }
                this.b = str;
            }
            str2 = "verify";
        }
        this.a = str2;
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(java.lang.Integer num) {
        this.f69s = num;
    }

    public void a(java.lang.String str) {
        this.p = str;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean a() {
        return this.r;
    }

    public java.lang.String b() {
        return this.p;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.h = j;
    }

    public void b(java.lang.Integer num) {
        this.u = num;
    }

    public void b(java.lang.String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public java.lang.String c() {
        return this.a;
    }

    public void c(long j) {
        this.i = j;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public void c(boolean z) {
        this.q = z;
    }

    public java.lang.String d() {
        return this.b;
    }

    public void d(java.lang.String str) {
        this.f = str;
    }

    public int e() {
        return this.c;
    }

    public void e(java.lang.String str) {
        this.l = str;
    }

    public java.lang.String f() {
        return this.d;
    }

    public void f(java.lang.String str) {
        this.o = str;
    }

    public int g() {
        return this.e;
    }

    public void g(java.lang.String str) {
        this.t = str;
    }

    public java.lang.String h() {
        return this.f;
    }

    public long i() {
        return this.g;
    }

    public long j() {
        return this.h;
    }

    public long k() {
        return this.i;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.k;
    }

    public java.lang.String n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return this.q;
    }

    public java.lang.String q() {
        return this.o;
    }

    public java.lang.Integer r() {
        return this.f69s;
    }

    public java.lang.String s() {
        return this.t;
    }

    public java.lang.Integer t() {
        return this.u;
    }
}
