package androidx.core.os;

/* loaded from: classes.dex */
public final class ExecutorCompat {

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

    private ExecutorCompat() {
    }

    @androidx.annotation.NonNull
    public static java.util.concurrent.Executor create(@androidx.annotation.NonNull android.os.Handler handler) {
        return new androidx.core.os.ExecutorCompat.HandlerExecutor(handler);
    }
}
