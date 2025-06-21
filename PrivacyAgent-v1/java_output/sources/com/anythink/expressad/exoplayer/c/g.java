package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public abstract class g<I extends com.anythink.expressad.exoplayer.c.e, O extends com.anythink.expressad.exoplayer.c.f, E extends java.lang.Exception> implements com.anythink.expressad.exoplayer.c.c<I, O, E> {
    private final java.lang.Thread a;
    private final java.lang.Object b = new java.lang.Object();
    private final java.util.ArrayDeque<I> c = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<O> d = new java.util.ArrayDeque<>();
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    /* renamed from: com.anythink.expressad.exoplayer.c.g$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            com.anythink.expressad.exoplayer.c.g.a(com.anythink.expressad.exoplayer.c.g.this);
        }
    }

    private g(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = h();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = i();
        }
        com.anythink.expressad.exoplayer.c.g.AnonymousClass1 anonymousClass1 = new com.anythink.expressad.exoplayer.c.g.AnonymousClass1();
        this.a = anonymousClass1;
        anonymousClass1.start();
    }

    private void a(int i) {
        com.anythink.expressad.exoplayer.k.a.b(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.d(i);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.exoplayer.c.g gVar) {
        do {
            try {
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.IllegalStateException(e);
            }
        } while (gVar.o());
    }

    private void b(I i) {
        i.a();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.a();
        O[] oArr = this.f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    private void l() {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    private void m() {
        if (p()) {
            this.b.notify();
        }
    }

    private void n() {
        do {
            try {
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.IllegalStateException(e);
            }
        } while (o());
    }

    private boolean o() {
        synchronized (this.b) {
            while (!this.l && !p()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            this.k = false;
            if (removeFirst.c()) {
                o.b(4);
            } else {
                if (removeFirst.b()) {
                    o.b(Integer.MIN_VALUE);
                }
                try {
                    this.j = k();
                } catch (java.lang.OutOfMemoryError unused) {
                    this.j = j();
                } catch (java.lang.RuntimeException unused2) {
                    this.j = j();
                }
                if (this.j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    b((com.anythink.expressad.exoplayer.c.g<I, O, E>) o);
                } else if (o.b()) {
                    this.m++;
                    b((com.anythink.expressad.exoplayer.c.g<I, O, E>) o);
                } else {
                    o.b = this.m;
                    this.m = 0;
                    this.d.addLast(o);
                }
                b((com.anythink.expressad.exoplayer.c.g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean p() {
        return !this.c.isEmpty() && this.h > 0;
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void a(I i) {
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.a(i == this.i);
            this.c.addLast(i);
            m();
            this.i = null;
        }
    }

    public final void a(O o) {
        synchronized (this.b) {
            b((com.anythink.expressad.exoplayer.c.g<I, O, E>) o);
            m();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void d() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                b((com.anythink.expressad.exoplayer.c.g<I, O, E>) i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                b((com.anythink.expressad.exoplayer.c.g<I, O, E>) this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                b((com.anythink.expressad.exoplayer.c.g<I, O, E>) this.d.removeFirst());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void e() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final I b() {
        I i;
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.b(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final O c() {
        synchronized (this.b) {
            l();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    public abstract I h();

    public abstract O i();

    public abstract E j();

    public abstract E k();
}
