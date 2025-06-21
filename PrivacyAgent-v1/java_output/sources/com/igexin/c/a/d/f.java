package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public abstract class f extends com.igexin.c.a.d.b implements com.igexin.c.a.d.a.a, com.igexin.c.a.d.a.f {
    protected static com.igexin.c.a.d.g H;
    public int A;
    public int B;
    public int C;
    public int D;
    public java.lang.Exception E;
    public java.lang.Object F;
    public com.igexin.c.a.d.a.g G;
    protected final java.util.concurrent.locks.ReentrantLock I;
    protected final java.util.concurrent.locks.Condition J;
    protected java.lang.Thread K;
    protected volatile boolean L;
    android.os.PowerManager.WakeLock M;
    int N;
    protected com.igexin.c.a.d.a.d O;
    private byte a;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;

    /* renamed from: s, reason: collision with root package name */
    protected volatile boolean f380s;
    protected volatile boolean t;
    protected volatile boolean u;
    protected volatile boolean v;
    protected volatile long w;
    volatile int x;
    public long z;

    public f(int i) {
        this(i, (byte) 0);
    }

    private f(int i, byte b) {
        this.C = i;
        this.O = null;
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.I = reentrantLock;
        this.J = reentrantLock.newCondition();
    }

    private int A() {
        return this.a & 15;
    }

    private boolean B() {
        byte b = this.a;
        return (b >> 4) > (b & 15);
    }

    private java.lang.Thread C() {
        return this.K;
    }

    private static void D() throws java.lang.Exception {
    }

    private void E() {
        this.n = true;
    }

    private java.lang.Object F() {
        return this.F;
    }

    private com.igexin.c.a.d.a.d G() {
        return this.O;
    }

    private void a(int i, java.util.concurrent.TimeUnit timeUnit) {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.a;
        this.a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
        a(i, timeUnit);
    }

    private void a(long j) {
        this.z = j;
    }

    private void a(android.os.PowerManager.WakeLock wakeLock) {
        this.M = wakeLock;
    }

    private boolean a(java.lang.Object obj) {
        if (!this.m) {
            return false;
        }
        this.q = false;
        this.n = false;
        this.m = false;
        this.F = obj;
        return true;
    }

    private void b(int i) {
        if (i != this.D) {
            this.D = i;
            H.f381s.b(this);
        }
    }

    private void b(java.lang.Object obj) {
        this.F = obj;
    }

    private java.util.concurrent.locks.ReentrantLock g() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.I;
        reentrantLock.getClass();
        return reentrantLock;
    }

    private android.os.PowerManager.WakeLock h() {
        return this.M;
    }

    private void i() {
        this.z = java.lang.System.currentTimeMillis();
    }

    private boolean q() {
        return this.v;
    }

    private int r() {
        long a = a(java.util.concurrent.TimeUnit.MILLISECONDS);
        int i = this.N;
        this.N = a > 0 ? i | 134217728 : i & 1090519038;
        return this.N;
    }

    private void s() {
        this.N = (this.N + 1) & 1090519038;
    }

    private long t() {
        return this.w - java.lang.System.currentTimeMillis();
    }

    private boolean u() {
        return this.q;
    }

    private boolean v() {
        return this.u;
    }

    private boolean w() {
        return this.m;
    }

    private boolean x() {
        return this.f380s;
    }

    private boolean y() {
        return this.t;
    }

    private void z() {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.a;
        this.a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(long j, java.util.concurrent.TimeUnit timeUnit) {
        int i;
        if (j > 0) {
            int a = H.f381s.a(this, j, timeUnit);
            i = -2;
            if (a != -2) {
                i = -1;
                if (a != -1) {
                    i = 1;
                } else {
                    this.w = java.lang.System.currentTimeMillis() + java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit);
                }
            }
            hashCode();
            java.util.concurrent.TimeUnit.SECONDS.convert(j, timeUnit);
            return i;
        }
        i = 0;
        hashCode();
        java.util.concurrent.TimeUnit.SECONDS.convert(j, timeUnit);
        return i;
    }

    public final long a(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(t(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
        this.F = null;
        this.E = null;
        this.K = null;
    }

    public final void a(int i) {
        this.a = (byte) (((i & 15) << 4) | ((byte) (this.a & 15)));
    }

    public final void a(int i, com.igexin.c.a.d.a.g gVar) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("second must > 0");
        }
        this.B = i;
        this.G = gVar;
    }

    public final void a(com.igexin.c.a.d.a.d dVar) {
        this.O = dVar;
    }

    public final void a(com.igexin.c.a.d.f fVar) {
        this.C = fVar.C;
        this.a = (byte) (fVar.a & 240);
        this.A = fVar.A;
        this.D = fVar.D;
        this.O = fVar.O;
        this.B = fVar.B;
        this.G = fVar.G;
    }

    public void b_() throws java.lang.Exception {
        this.K = java.lang.Thread.currentThread();
        this.q = true;
        hashCode();
        this.K.getName();
    }

    public void d() {
        this.t = true;
    }

    @Override // com.igexin.c.a.d.a.f
    public void d_() {
        if (this.m || this.n) {
            a();
        }
    }

    public abstract void e();

    public abstract void f();

    public final void l() {
        this.m = true;
    }

    public final boolean m() {
        return this.o;
    }

    public final boolean n() {
        return this.n;
    }

    public final void o() {
        if (!this.p && !this.r && !this.f380s) {
            this.m = true;
            this.q = false;
        } else if (this.r && !this.m) {
            this.q = false;
        } else {
            if (!this.p || this.o || this.m) {
                return;
            }
            this.q = false;
        }
    }

    public final void p() {
        if (this.O != null) {
            int i = com.igexin.c.a.d.a.d.a.a;
        }
    }
}
