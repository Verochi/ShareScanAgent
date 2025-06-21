package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public class e<E extends com.igexin.c.a.d.f> {
    static final /* synthetic */ boolean h = true;
    private static final java.lang.String i = "ScheduleQueue";
    final transient java.util.concurrent.locks.ReentrantLock a;
    final transient java.util.concurrent.locks.Condition b;
    final java.util.TreeSet<E> c;
    final java.util.concurrent.atomic.AtomicInteger d;
    int e;
    com.igexin.c.a.d.g f;
    public final java.util.concurrent.atomic.AtomicLong g;
    private long j;

    public e(java.util.Comparator<? super E> comparator, com.igexin.c.a.d.g gVar) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.d = new java.util.concurrent.atomic.AtomicInteger(0);
        this.g = new java.util.concurrent.atomic.AtomicLong(-1L);
        this.c = new java.util.TreeSet<>(comparator);
        this.f = gVar;
    }

    private E b() {
        try {
            return this.c.first();
        } catch (java.util.NoSuchElementException unused) {
            return null;
        }
    }

    private E c() {
        E b = b();
        if (b == null) {
            return null;
        }
        if (this.c.remove(b)) {
            return b;
        }
        com.igexin.c.a.c.a.a(i, "Queue Poll Error@");
        return null;
    }

    private E d() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            E b = b();
            if (b != null) {
                if (b.a(java.util.concurrent.TimeUnit.MILLISECONDS) > 0) {
                    b.N |= 134217728;
                } else {
                    b.N &= 1090519038;
                }
                if (b.N >= 0) {
                    E c = c();
                    if (!h && c == null) {
                        throw new java.lang.AssertionError();
                    }
                    if (!e()) {
                        this.b.signalAll();
                    }
                    return c;
                }
            }
            reentrantLock.unlock();
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean e() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            return this.c.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void f() {
        this.c.clear();
    }

    public final int a(E e, long j, java.util.concurrent.TimeUnit timeUnit) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            if (!this.c.contains(e)) {
                reentrantLock.unlock();
                return -1;
            }
            this.c.remove(e);
            e.w = java.lang.System.currentTimeMillis() + java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit);
            e.hashCode();
            e.a(java.util.concurrent.TimeUnit.SECONDS);
            return a((com.igexin.c.a.d.e<E>) e) ? 1 : -2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E a() throws java.lang.InterruptedException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E b = b();
                boolean z = true;
                if (b != null) {
                    java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS;
                    long a = b.a(timeUnit);
                    if (!b.m && !b.n) {
                        z = false;
                    }
                    if (a <= 0 || z) {
                        break;
                    }
                    b.hashCode();
                    java.util.concurrent.TimeUnit.SECONDS.convert(a, timeUnit);
                    this.g.set(b.w);
                    com.igexin.c.a.c.a.a("schedule take|needAlarm = " + this.f.D + "|" + b.getClass().getName() + "@" + b.hashCode(), new java.lang.Object[0]);
                    if (this.f.D) {
                        this.f.a(b.w);
                    }
                    this.b.awaitNanos(a);
                } else {
                    this.d.set(1);
                    this.e = 0;
                    this.b.await();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E c = c();
        if (!h && c == null) {
            throw new java.lang.AssertionError();
        }
        if (!e()) {
            this.b.signalAll();
        }
        if (this.j > 0) {
            java.lang.System.currentTimeMillis();
        }
        this.g.set(-1L);
        return c;
    }

    public final boolean a(E e) {
        if (e == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            E b = b();
            int i2 = this.e + 1;
            this.e = i2;
            e.x = i2;
            if (!this.c.add(e)) {
                e.x--;
                return false;
            }
            e.N = (e.N + 1) & 1090519038;
            if (b == null || this.c.comparator().compare(e, b) < 0) {
                this.b.signalAll();
            }
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("ScheduleQueue|offer|error", new java.lang.Object[0]);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean a(java.lang.Class cls) {
        if (cls == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<E> it = this.c.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.getClass() == cls) {
                    arrayList.add(next);
                }
            }
            arrayList.size();
            this.c.removeAll(arrayList);
            reentrantLock.unlock();
            return true;
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b(E e) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            if (this.c.contains(e) && this.c.remove(e)) {
                return a((com.igexin.c.a.d.e<E>) e);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c(E e) {
        if (e == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            if (!this.c.contains(e) || !this.c.remove(e)) {
                return false;
            }
            e.hashCode();
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
