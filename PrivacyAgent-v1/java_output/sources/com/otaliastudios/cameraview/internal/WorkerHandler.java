package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class WorkerHandler {
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.internal.WorkerHandler.class.getSimpleName());
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<com.otaliastudios.cameraview.internal.WorkerHandler>> f = new java.util.concurrent.ConcurrentHashMap<>(4);
    public static com.otaliastudios.cameraview.internal.WorkerHandler g;
    public java.lang.String a;
    public android.os.HandlerThread b;
    public android.os.Handler c;
    public java.util.concurrent.Executor d;

    /* renamed from: com.otaliastudios.cameraview.internal.WorkerHandler$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.HandlerThread {
        public AnonymousClass1(java.lang.String str) {
            super(str);
        }

        @Override // java.lang.Thread
        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return super.toString() + "[" + getThreadId() + "]";
        }
    }

    /* renamed from: com.otaliastudios.cameraview.internal.WorkerHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Executor {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            com.otaliastudios.cameraview.internal.WorkerHandler.this.run(runnable);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.internal.WorkerHandler$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.CountDownLatch n;

        public AnonymousClass3(java.util.concurrent.CountDownLatch countDownLatch) {
            this.n = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.countDown();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.internal.WorkerHandler$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource n;
        public final /* synthetic */ java.util.concurrent.Callable t;

        public AnonymousClass4(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource, java.util.concurrent.Callable callable) {
            this.n = taskCompletionSource;
            this.t = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.n.trySetResult(this.t.call());
            } catch (java.lang.Exception e) {
                this.n.trySetException(e);
            }
        }
    }

    public WorkerHandler(@androidx.annotation.NonNull java.lang.String str) {
        this.a = str;
        com.otaliastudios.cameraview.internal.WorkerHandler.AnonymousClass1 anonymousClass1 = new com.otaliastudios.cameraview.internal.WorkerHandler.AnonymousClass1(str);
        this.b = anonymousClass1;
        anonymousClass1.setDaemon(true);
        this.b.start();
        this.c = new android.os.Handler(this.b.getLooper());
        this.d = new com.otaliastudios.cameraview.internal.WorkerHandler.AnonymousClass2();
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        post(new com.otaliastudios.cameraview.internal.WorkerHandler.AnonymousClass3(countDownLatch));
        try {
            countDownLatch.await();
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public static void destroyAll() {
        java.util.Iterator<java.lang.String> it = f.keySet().iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<com.otaliastudios.cameraview.internal.WorkerHandler> weakReference = f.get(it.next());
            com.otaliastudios.cameraview.internal.WorkerHandler workerHandler = weakReference.get();
            if (workerHandler != null) {
                workerHandler.destroy();
            }
            weakReference.clear();
        }
        f.clear();
    }

    public static void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        get().post(runnable);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.internal.WorkerHandler get() {
        com.otaliastudios.cameraview.internal.WorkerHandler workerHandler = get("FallbackCameraThread");
        g = workerHandler;
        return workerHandler;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.internal.WorkerHandler get(@androidx.annotation.NonNull java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<com.otaliastudios.cameraview.internal.WorkerHandler>> concurrentHashMap = f;
        if (concurrentHashMap.containsKey(str)) {
            com.otaliastudios.cameraview.internal.WorkerHandler workerHandler = concurrentHashMap.get(str).get();
            if (workerHandler == null) {
                e.w("get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                if (workerHandler.getThread().isAlive() && !workerHandler.getThread().isInterrupted()) {
                    e.w("get:", "Reusing cached worker handler.", str);
                    return workerHandler;
                }
                workerHandler.destroy();
                e.w("get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        e.i("get:", "Creating new handler.", str);
        com.otaliastudios.cameraview.internal.WorkerHandler workerHandler2 = new com.otaliastudios.cameraview.internal.WorkerHandler(str);
        concurrentHashMap.put(str, new java.lang.ref.WeakReference<>(workerHandler2));
        return workerHandler2;
    }

    public void destroy() {
        android.os.HandlerThread thread = getThread();
        if (thread.isAlive()) {
            thread.interrupt();
            thread.quit();
        }
        f.remove(this.a);
    }

    @androidx.annotation.NonNull
    public java.util.concurrent.Executor getExecutor() {
        return this.d;
    }

    @androidx.annotation.NonNull
    public android.os.Handler getHandler() {
        return this.c;
    }

    @androidx.annotation.NonNull
    public android.os.Looper getLooper() {
        return this.b.getLooper();
    }

    @androidx.annotation.NonNull
    public android.os.HandlerThread getThread() {
        return this.b;
    }

    public <T> com.google.android.gms.tasks.Task<T> post(@androidx.annotation.NonNull java.util.concurrent.Callable<T> callable) {
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        post(new com.otaliastudios.cameraview.internal.WorkerHandler.AnonymousClass4(taskCompletionSource, callable));
        return taskCompletionSource.getTask();
    }

    public void post(long j, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.c.postDelayed(runnable, j);
    }

    public void post(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.c.post(runnable);
    }

    public void remove(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.c.removeCallbacks(runnable);
    }

    public <T> com.google.android.gms.tasks.Task<T> run(@androidx.annotation.NonNull java.util.concurrent.Callable<T> callable) {
        if (java.lang.Thread.currentThread() != getThread()) {
            return post(callable);
        }
        try {
            return com.google.android.gms.tasks.Tasks.forResult(callable.call());
        } catch (java.lang.Exception e2) {
            return com.google.android.gms.tasks.Tasks.forException(e2);
        }
    }

    public void run(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        if (java.lang.Thread.currentThread() == getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
