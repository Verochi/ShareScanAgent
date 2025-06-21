package okhttp3;

/* loaded from: classes23.dex */
public final class Dispatcher {

    @javax.annotation.Nullable
    public java.lang.Runnable c;

    @javax.annotation.Nullable
    public java.util.concurrent.ExecutorService d;
    public int a = 64;
    public int b = 5;
    public final java.util.Deque<okhttp3.RealCall.AsyncCall> e = new java.util.ArrayDeque();
    public final java.util.Deque<okhttp3.RealCall.AsyncCall> f = new java.util.ArrayDeque();
    public final java.util.Deque<okhttp3.RealCall> g = new java.util.ArrayDeque();

    public Dispatcher() {
    }

    public Dispatcher(java.util.concurrent.ExecutorService executorService) {
        this.d = executorService;
    }

    public void a(okhttp3.RealCall.AsyncCall asyncCall) {
        okhttp3.RealCall.AsyncCall c;
        synchronized (this) {
            this.e.add(asyncCall);
            if (!asyncCall.m().v && (c = c(asyncCall.n())) != null) {
                asyncCall.o(c);
            }
        }
        g();
    }

    public synchronized void b(okhttp3.RealCall realCall) {
        this.g.add(realCall);
    }

    @javax.annotation.Nullable
    public final okhttp3.RealCall.AsyncCall c(java.lang.String str) {
        for (okhttp3.RealCall.AsyncCall asyncCall : this.f) {
            if (asyncCall.n().equals(str)) {
                return asyncCall;
            }
        }
        for (okhttp3.RealCall.AsyncCall asyncCall2 : this.e) {
            if (asyncCall2.n().equals(str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    public synchronized void cancelAll() {
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().m().cancel();
        }
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it2 = this.f.iterator();
        while (it2.hasNext()) {
            it2.next().m().cancel();
        }
        java.util.Iterator<okhttp3.RealCall> it3 = this.g.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final <T> void d(java.util.Deque<T> deque, T t) {
        java.lang.Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new java.lang.AssertionError("Call wasn't in-flight!");
            }
            runnable = this.c;
        }
        if (g() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void e(okhttp3.RealCall.AsyncCall asyncCall) {
        asyncCall.k().decrementAndGet();
        d(this.f, asyncCall);
    }

    public synchronized java.util.concurrent.ExecutorService executorService() {
        if (this.d == null) {
            this.d = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    public void f(okhttp3.RealCall realCall) {
        d(this.g, realCall);
    }

    public final boolean g() {
        int i;
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.e.iterator();
            while (it.hasNext()) {
                okhttp3.RealCall.AsyncCall next = it.next();
                if (this.f.size() >= this.a) {
                    break;
                }
                if (next.k().get() < this.b) {
                    it.remove();
                    next.k().incrementAndGet();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((okhttp3.RealCall.AsyncCall) arrayList.get(i)).l(executorService());
        }
        return z;
    }

    public synchronized int getMaxRequests() {
        return this.a;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.b;
    }

    public synchronized java.util.List<okhttp3.Call> queuedCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.e.size();
    }

    public synchronized java.util.List<okhttp3.Call> runningCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.g);
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.f.size() + this.g.size();
    }

    public synchronized void setIdleCallback(@javax.annotation.Nullable java.lang.Runnable runnable) {
        this.c = runnable;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.a = i;
            }
            g();
        } else {
            throw new java.lang.IllegalArgumentException("max < 1: " + i);
        }
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.b = i;
            }
            g();
        } else {
            throw new java.lang.IllegalArgumentException("max < 1: " + i);
        }
    }
}
