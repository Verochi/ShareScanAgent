package okhttp3.internal.connection;

/* loaded from: classes23.dex */
public final class RealConnectionPool {
    public static final java.util.concurrent.Executor g = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp ConnectionPool", true));
    public final int a;
    public final long b;
    public final java.lang.Runnable c = new defpackage.ha2(this);
    public final java.util.Deque<okhttp3.internal.connection.RealConnection> d = new java.util.ArrayDeque();
    public final okhttp3.internal.connection.RouteDatabase e = new okhttp3.internal.connection.RouteDatabase();
    public boolean f;

    public RealConnectionPool(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.a = i;
        this.b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        while (true) {
            long b = b(java.lang.System.nanoTime());
            if (b == -1) {
                return;
            }
            if (b > 0) {
                long j = b / 1000000;
                long j2 = b - (1000000 * j);
                synchronized (this) {
                    try {
                        wait(j, (int) j2);
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
            }
        }
    }

    public long b(long j) {
        synchronized (this) {
            okhttp3.internal.connection.RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.RealConnection realConnection2 : this.d) {
                if (e(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.o;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.b;
            if (j2 < j4 && i <= this.a) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.f = false;
                return -1L;
            }
            this.d.remove(realConnection);
            okhttp3.internal.Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    public boolean c(okhttp3.internal.connection.RealConnection realConnection) {
        if (realConnection.i || this.a == 0) {
            this.d.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public void connectFailed(okhttp3.Route route, java.io.IOException iOException) {
        if (route.proxy().type() != java.net.Proxy.Type.DIRECT) {
            okhttp3.Address address = route.address();
            address.proxySelector().connectFailed(address.url().uri(), route.proxy().address(), iOException);
        }
        this.e.b(route);
    }

    public synchronized int connectionCount() {
        return this.d.size();
    }

    public final int e(okhttp3.internal.connection.RealConnection realConnection, long j) {
        java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.Transmitter>> list = realConnection.n;
        int i = 0;
        while (i < list.size()) {
            java.lang.ref.Reference<okhttp3.internal.connection.Transmitter> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.internal.platform.Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((okhttp3.internal.connection.Transmitter.TransmitterReference) reference).a);
                list.remove(i);
                realConnection.i = true;
                if (list.isEmpty()) {
                    realConnection.o = j - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public void evictAll() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<okhttp3.internal.connection.RealConnection> it = this.d.iterator();
            while (it.hasNext()) {
                okhttp3.internal.connection.RealConnection next = it.next();
                if (next.n.isEmpty()) {
                    next.i = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            okhttp3.internal.Util.closeQuietly(((okhttp3.internal.connection.RealConnection) it2.next()).socket());
        }
    }

    public void f(okhttp3.internal.connection.RealConnection realConnection) {
        if (!this.f) {
            this.f = true;
            g.execute(this.c);
        }
        this.d.add(realConnection);
    }

    public boolean g(okhttp3.Address address, okhttp3.internal.connection.Transmitter transmitter, @javax.annotation.Nullable java.util.List<okhttp3.Route> list, boolean z) {
        for (okhttp3.internal.connection.RealConnection realConnection : this.d) {
            if (!z || realConnection.isMultiplexed()) {
                if (realConnection.g(address, list)) {
                    transmitter.a(realConnection);
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized int idleConnectionCount() {
        int i;
        java.util.Iterator<okhttp3.internal.connection.RealConnection> it = this.d.iterator();
        i = 0;
        while (it.hasNext()) {
            if (it.next().n.isEmpty()) {
                i++;
            }
        }
        return i;
    }
}
