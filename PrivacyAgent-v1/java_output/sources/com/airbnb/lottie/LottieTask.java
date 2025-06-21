package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieTask<T> {
    public static java.util.concurrent.Executor EXECUTOR = java.util.concurrent.Executors.newCachedThreadPool();
    public final java.util.Set<com.airbnb.lottie.LottieListener<T>> a;
    public final java.util.Set<com.airbnb.lottie.LottieListener<java.lang.Throwable>> b;
    public final android.os.Handler c;

    @androidx.annotation.Nullable
    public volatile com.airbnb.lottie.LottieResult<T> d;

    /* renamed from: com.airbnb.lottie.LottieTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.airbnb.lottie.LottieTask.this.d == null) {
                return;
            }
            com.airbnb.lottie.LottieResult lottieResult = com.airbnb.lottie.LottieTask.this.d;
            if (lottieResult.getValue() != null) {
                com.airbnb.lottie.LottieTask.this.g(lottieResult.getValue());
            } else {
                com.airbnb.lottie.LottieTask.this.e(lottieResult.getException());
            }
        }
    }

    public class LottieFutureTask extends java.util.concurrent.FutureTask<com.airbnb.lottie.LottieResult<T>> {
        public LottieFutureTask(java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                com.airbnb.lottie.LottieTask.this.setResult(get());
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e) {
                com.airbnb.lottie.LottieTask.this.setResult(new com.airbnb.lottie.LottieResult(e));
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public LottieTask(java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<T>> callable) {
        this(callable, false);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public LottieTask(java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<T>> callable, boolean z) {
        this.a = new java.util.LinkedHashSet(1);
        this.b = new java.util.LinkedHashSet(1);
        this.c = new android.os.Handler(android.os.Looper.getMainLooper());
        this.d = null;
        if (!z) {
            EXECUTOR.execute(new com.airbnb.lottie.LottieTask.LottieFutureTask(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (java.lang.Throwable th) {
            setResult(new com.airbnb.lottie.LottieResult<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(@androidx.annotation.Nullable com.airbnb.lottie.LottieResult<T> lottieResult) {
        if (this.d != null) {
            throw new java.lang.IllegalStateException("A task may only be set once.");
        }
        this.d = lottieResult;
        f();
    }

    public synchronized com.airbnb.lottie.LottieTask<T> addFailureListener(com.airbnb.lottie.LottieListener<java.lang.Throwable> lottieListener) {
        if (this.d != null && this.d.getException() != null) {
            lottieListener.onResult(this.d.getException());
        }
        this.b.add(lottieListener);
        return this;
    }

    public synchronized com.airbnb.lottie.LottieTask<T> addListener(com.airbnb.lottie.LottieListener<T> lottieListener) {
        if (this.d != null && this.d.getValue() != null) {
            lottieListener.onResult(this.d.getValue());
        }
        this.a.add(lottieListener);
        return this;
    }

    public final synchronized void e(java.lang.Throwable th) {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.utils.Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.airbnb.lottie.LottieListener) it.next()).onResult(th);
        }
    }

    public final void f() {
        this.c.post(new com.airbnb.lottie.LottieTask.AnonymousClass1());
    }

    public final synchronized void g(T t) {
        java.util.Iterator it = new java.util.ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((com.airbnb.lottie.LottieListener) it.next()).onResult(t);
        }
    }

    public synchronized com.airbnb.lottie.LottieTask<T> removeFailureListener(com.airbnb.lottie.LottieListener<java.lang.Throwable> lottieListener) {
        this.b.remove(lottieListener);
        return this;
    }

    public synchronized com.airbnb.lottie.LottieTask<T> removeListener(com.airbnb.lottie.LottieListener<T> lottieListener) {
        this.a.remove(lottieListener);
        return this;
    }
}
