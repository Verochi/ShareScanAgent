package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public final class Dispatcher {
    private java.util.concurrent.ExecutorService executorService;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final java.util.Deque<com.getui.gtc.base.http.RealCall.AsyncCall> readyAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<com.getui.gtc.base.http.RealCall.AsyncCall> runningAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<com.getui.gtc.base.http.RealCall> runningSyncCalls = new java.util.ArrayDeque();

    /* renamed from: com.getui.gtc.base.http.Dispatcher$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        java.util.concurrent.atomic.AtomicInteger index = new java.util.concurrent.atomic.AtomicInteger(0);

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("GtHttpClient dispatcher's thread" + this.index.getAndIncrement());
            return thread;
        }
    }

    private <T> void finished(java.util.Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new java.lang.AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                promoteCalls();
            }
        }
    }

    private void promoteCalls() {
        if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
            java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                com.getui.gtc.base.http.RealCall.AsyncCall next = it.next();
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningAsyncCalls.add(next);
                    executorService().execute(next);
                }
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(com.getui.gtc.base.http.RealCall.AsyncCall asyncCall) {
        java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().get().request().url().getHost().equals(asyncCall.get().request().url().getHost())) {
                i++;
            }
        }
        return i;
    }

    public final synchronized void cancelAll() {
        java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().get().cancel();
        }
        java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().get().cancel();
        }
        java.util.Iterator<com.getui.gtc.base.http.RealCall> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final synchronized void enqueue(com.getui.gtc.base.http.RealCall.AsyncCall asyncCall) {
        if (this.runningAsyncCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
            this.readyAsyncCalls.add(asyncCall);
        } else {
            this.runningAsyncCalls.add(asyncCall);
            executorService().execute(asyncCall);
        }
    }

    public final synchronized void executed(com.getui.gtc.base.http.RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public final synchronized java.util.concurrent.ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new java.util.concurrent.ThreadPoolExecutor(1, Integer.MAX_VALUE, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.getui.gtc.base.http.Dispatcher.AnonymousClass1());
        }
        return this.executorService;
    }

    public final void finished(com.getui.gtc.base.http.RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall, true);
    }

    public final void finished(com.getui.gtc.base.http.RealCall realCall) {
        finished(this.runningSyncCalls, realCall, false);
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized java.util.List<com.getui.gtc.base.http.Call> queuedCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized java.util.List<com.getui.gtc.base.http.Call> runningCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        java.util.Iterator<com.getui.gtc.base.http.RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setMaxRequests(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("max < 1: ".concat(java.lang.String.valueOf(i)));
        }
        this.maxRequests = i;
        promoteCalls();
    }

    public final synchronized void setMaxRequestsPerHost(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("max < 1: ".concat(java.lang.String.valueOf(i)));
        }
        this.maxRequestsPerHost = i;
        promoteCalls();
    }
}
