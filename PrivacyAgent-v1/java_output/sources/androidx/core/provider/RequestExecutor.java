package androidx.core.provider;

/* loaded from: classes.dex */
class RequestExecutor {

    public static class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
        private int mPriority;
        private java.lang.String mThreadName;

        public static class ProcessPriorityThread extends java.lang.Thread {
            private final int mPriority;

            public ProcessPriorityThread(java.lang.Runnable runnable, java.lang.String str, int i) {
                super(runnable, str);
                this.mPriority = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                android.os.Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        public DefaultThreadFactory(@androidx.annotation.NonNull java.lang.String str, int i) {
            this.mThreadName = str;
            this.mPriority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new androidx.core.provider.RequestExecutor.DefaultThreadFactory.ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }
    }

    public static class HandlerExecutor implements java.util.concurrent.Executor {
        private final android.os.Handler mHandler;

        public HandlerExecutor(@androidx.annotation.NonNull android.os.Handler handler) {
            this.mHandler = (android.os.Handler) androidx.core.util.Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            if (this.mHandler.post((java.lang.Runnable) androidx.core.util.Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new java.util.concurrent.RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static class ReplyRunnable<T> implements java.lang.Runnable {

        @androidx.annotation.NonNull
        private java.util.concurrent.Callable<T> mCallable;

        @androidx.annotation.NonNull
        private androidx.core.util.Consumer<T> mConsumer;

        @androidx.annotation.NonNull
        private android.os.Handler mHandler;

        /* renamed from: androidx.core.provider.RequestExecutor$ReplyRunnable$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ androidx.core.util.Consumer val$consumer;
            final /* synthetic */ java.lang.Object val$result;

            public AnonymousClass1(androidx.core.util.Consumer consumer, java.lang.Object obj) {
                this.val$consumer = consumer;
                this.val$result = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.val$consumer.accept(this.val$result);
            }
        }

        public ReplyRunnable(@androidx.annotation.NonNull android.os.Handler handler, @androidx.annotation.NonNull java.util.concurrent.Callable<T> callable, @androidx.annotation.NonNull androidx.core.util.Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.mCallable.call();
            } catch (java.lang.Exception unused) {
                t = null;
            }
            this.mHandler.post(new androidx.core.provider.RequestExecutor.ReplyRunnable.AnonymousClass1(this.mConsumer, t));
        }
    }

    private RequestExecutor() {
    }

    public static java.util.concurrent.ThreadPoolExecutor createDefaultExecutor(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.IntRange(from = 0) int i2) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, i2, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingDeque(), new androidx.core.provider.RequestExecutor.DefaultThreadFactory(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static java.util.concurrent.Executor createHandlerExecutor(@androidx.annotation.NonNull android.os.Handler handler) {
        return new androidx.core.provider.RequestExecutor.HandlerExecutor(handler);
    }

    public static <T> void execute(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Callable<T> callable, @androidx.annotation.NonNull androidx.core.util.Consumer<T> consumer) {
        executor.execute(new androidx.core.provider.RequestExecutor.ReplyRunnable(androidx.core.provider.CalleeHandler.create(), callable, consumer));
    }

    public static <T> T submit(@androidx.annotation.NonNull java.util.concurrent.ExecutorService executorService, @androidx.annotation.NonNull java.util.concurrent.Callable<T> callable, @androidx.annotation.IntRange(from = 0) int i) throws java.lang.InterruptedException {
        try {
            return executorService.submit(callable).get(i, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException e) {
            throw e;
        } catch (java.util.concurrent.ExecutionException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.util.concurrent.TimeoutException unused) {
            throw new java.lang.InterruptedException("timeout");
        }
    }
}
