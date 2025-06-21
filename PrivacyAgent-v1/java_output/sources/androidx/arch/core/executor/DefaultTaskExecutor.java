package androidx.arch.core.executor;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends androidx.arch.core.executor.TaskExecutor {

    @androidx.annotation.Nullable
    private volatile android.os.Handler mMainHandler;
    private final java.lang.Object mLock = new java.lang.Object();
    private final java.util.concurrent.ExecutorService mDiskIO = java.util.concurrent.Executors.newFixedThreadPool(4, new androidx.arch.core.executor.DefaultTaskExecutor.AnonymousClass1());

    /* renamed from: androidx.arch.core.executor.DefaultTaskExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private static final java.lang.String THREAD_NAME_STEM = "arch_disk_io_%d";
        private final java.util.concurrent.atomic.AtomicInteger mThreadId = new java.util.concurrent.atomic.AtomicInteger(0);

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName(java.lang.String.format(THREAD_NAME_STEM, java.lang.Integer.valueOf(this.mThreadId.getAndIncrement())));
            return thread;
        }
    }

    private static android.os.Handler createAsync(@androidx.annotation.NonNull android.os.Looper looper) {
        android.os.Handler createAsync;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            createAsync = android.os.Handler.createAsync(looper);
            return createAsync;
        }
        try {
            return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, null, java.lang.Boolean.TRUE);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException unused) {
            return new android.os.Handler(looper);
        } catch (java.lang.reflect.InvocationTargetException unused2) {
            return new android.os.Handler(looper);
        }
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(java.lang.Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(java.lang.Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = createAsync(android.os.Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }
}
