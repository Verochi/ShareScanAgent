package com.badlogic.gdx.utils.async;

/* loaded from: classes12.dex */
public class AsyncExecutor implements com.badlogic.gdx.utils.Disposable {
    public final java.util.concurrent.ExecutorService a;

    /* renamed from: com.badlogic.gdx.utils.async.AsyncExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, "AsynchExecutor-Thread");
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.badlogic.gdx.utils.async.AsyncExecutor$2, reason: invalid class name */
    public class AnonymousClass2<T> implements java.util.concurrent.Callable<T> {
        public final /* synthetic */ com.badlogic.gdx.utils.async.AsyncTask n;

        public AnonymousClass2(com.badlogic.gdx.utils.async.AsyncTask asyncTask) {
            this.n = asyncTask;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws java.lang.Exception {
            return (T) this.n.call();
        }
    }

    public AsyncExecutor(int i) {
        this.a = java.util.concurrent.Executors.newFixedThreadPool(i, new com.badlogic.gdx.utils.async.AsyncExecutor.AnonymousClass1());
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        this.a.shutdown();
        try {
            this.a.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.InterruptedException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't shutdown loading thread", e);
        }
    }

    public <T> com.badlogic.gdx.utils.async.AsyncResult<T> submit(com.badlogic.gdx.utils.async.AsyncTask<T> asyncTask) {
        if (this.a.isShutdown()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot run tasks on an executor that has been shutdown (disposed)");
        }
        return new com.badlogic.gdx.utils.async.AsyncResult<>(this.a.submit(new com.badlogic.gdx.utils.async.AsyncExecutor.AnonymousClass2(asyncTask)));
    }
}
