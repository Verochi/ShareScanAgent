package cn.fly.verify;

/* loaded from: classes31.dex */
public class ai {
    private static cn.fly.verify.ai a;
    private java.util.List<java.lang.String> b;
    private int c;
    private java.lang.Integer d;
    private boolean f;
    private volatile long j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.Boolean m;
    private java.lang.Integer n;
    private java.lang.Integer o;
    private java.lang.Integer p;
    private java.lang.Integer q;
    private java.lang.Integer r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.Integer f66s;
    private java.lang.String t;
    private java.lang.Integer u;
    private java.lang.Integer v;
    private java.lang.Integer w;
    private java.lang.String e = "LphSZLqaUeFdyaQq";
    private final java.util.concurrent.atomic.AtomicInteger g = new java.util.concurrent.atomic.AtomicInteger(0);
    private volatile int h = -1;
    private volatile int i = -1;

    private ai() {
    }

    public static cn.fly.verify.ai a() {
        if (a == null) {
            synchronized (cn.fly.verify.ai.class) {
                if (a == null) {
                    a = new cn.fly.verify.ai();
                }
            }
        }
        return a;
    }

    private boolean v() {
        java.lang.String[] s2 = s();
        if (s2 != null) {
            for (java.lang.String str : s2) {
                if (cn.fly.verify.fh.d.k().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(java.lang.Boolean bool) {
        this.m = bool;
    }

    public void a(java.lang.String str) {
        this.l = str;
    }

    public void a(java.util.List<java.lang.String> list) {
        this.b = list;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public java.lang.String b() {
        return this.l;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(java.lang.String str) {
        this.k = str;
    }

    public java.lang.String c() {
        return this.k;
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(java.lang.String str) {
        this.e = str;
    }

    public int d() {
        return this.h;
    }

    public void d(int i) {
        this.d = java.lang.Integer.valueOf(i);
    }

    public void d(java.lang.String str) {
        this.t = str;
    }

    public int e() {
        int i = this.i;
        this.i = -1;
        return i;
    }

    public void e(int i) {
        this.n = java.lang.Integer.valueOf(i);
    }

    public long f() {
        long j = this.j;
        this.j = 0L;
        return j;
    }

    public void f(int i) {
        this.o = java.lang.Integer.valueOf(i);
    }

    public java.util.List<java.lang.String> g() {
        if (this.b == null) {
            this.b = new java.util.ArrayList();
        }
        return this.b;
    }

    public void g(int i) {
        this.p = java.lang.Integer.valueOf(i);
    }

    public int h() {
        return this.c;
    }

    public void h(int i) {
        this.q = java.lang.Integer.valueOf(i);
    }

    public java.lang.String i() {
        return this.e;
    }

    public void i(int i) {
        this.r = java.lang.Integer.valueOf(i);
    }

    public void j(int i) {
        this.f66s = java.lang.Integer.valueOf(i);
    }

    public boolean j() {
        return this.f;
    }

    public java.lang.Boolean k() {
        if (this.m == null) {
            this.m = java.lang.Boolean.valueOf(cn.fly.verify.aq.c());
        }
        return this.m;
    }

    public void k(int i) {
        this.u = java.lang.Integer.valueOf(i);
    }

    public int l() {
        if (this.d == null) {
            this.d = java.lang.Integer.valueOf(cn.fly.verify.aq.l());
        }
        return this.d.intValue();
    }

    public void l(int i) {
        this.v = java.lang.Integer.valueOf(i);
    }

    public int m() {
        if (this.n == null) {
            this.n = java.lang.Integer.valueOf(cn.fly.verify.aq.d());
        }
        if (this.n == null) {
            this.n = 1;
        }
        return this.n.intValue();
    }

    public void m(int i) {
        this.w = java.lang.Integer.valueOf(i);
    }

    public int n() {
        if (this.o == null) {
            this.o = java.lang.Integer.valueOf(cn.fly.verify.aq.m());
        }
        if (this.o == null) {
            this.o = 1;
        }
        return this.o.intValue();
    }

    public int o() {
        if (this.p == null) {
            this.p = java.lang.Integer.valueOf(cn.fly.verify.aq.n());
        }
        if (this.p == null) {
            this.p = 1;
        }
        return this.p.intValue();
    }

    public int p() {
        if (v()) {
            return 0;
        }
        if (this.q == null) {
            this.q = java.lang.Integer.valueOf(cn.fly.verify.aq.o());
        }
        if (this.q == null) {
            this.q = 1;
        }
        return this.q.intValue();
    }

    public int q() {
        if (v()) {
            return 0;
        }
        if (this.r == null) {
            this.r = java.lang.Integer.valueOf(cn.fly.verify.aq.p());
        }
        if (this.r == null) {
            this.r = 1;
        }
        return this.r.intValue();
    }

    public int r() {
        if (v()) {
            return 0;
        }
        if (this.f66s == null) {
            this.f66s = java.lang.Integer.valueOf(cn.fly.verify.aq.q());
        }
        if (this.f66s == null) {
            this.f66s = 1;
        }
        return this.f66s.intValue();
    }

    public java.lang.String[] s() {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(this.t)) {
            this.t = cn.fly.verify.aq.r();
        }
        java.lang.String str = this.t;
        if (str == null || (split = str.split(",")) == null || split.length <= 0) {
            return null;
        }
        return split;
    }

    public int t() {
        if (this.u == null) {
            this.u = java.lang.Integer.valueOf(cn.fly.verify.aq.s());
        }
        if (this.u == null) {
            this.u = 0;
        }
        return this.u.intValue();
    }

    public int u() {
        if (this.w == null) {
            this.w = java.lang.Integer.valueOf(cn.fly.verify.aq.t());
        }
        return this.w.intValue();
    }
}
