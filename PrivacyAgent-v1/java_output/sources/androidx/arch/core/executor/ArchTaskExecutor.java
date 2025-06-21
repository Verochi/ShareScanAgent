package androidx.arch.core.executor;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ArchTaskExecutor extends androidx.arch.core.executor.TaskExecutor {
    private static volatile androidx.arch.core.executor.ArchTaskExecutor sInstance;

    @androidx.annotation.NonNull
    private androidx.arch.core.executor.TaskExecutor mDefaultTaskExecutor;

    @androidx.annotation.NonNull
    private androidx.arch.core.executor.TaskExecutor mDelegate;

    @androidx.annotation.NonNull
    private static final java.util.concurrent.Executor sMainThreadExecutor = new androidx.arch.core.executor.ArchTaskExecutor.AnonymousClass1();

    @androidx.annotation.NonNull
    private static final java.util.concurrent.Executor sIOThreadExecutor = new androidx.arch.core.executor.ArchTaskExecutor.AnonymousClass2();

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            androidx.arch.core.executor.ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    }

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    }

    private ArchTaskExecutor() {
        androidx.arch.core.executor.DefaultTaskExecutor defaultTaskExecutor = new androidx.arch.core.executor.DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    @androidx.annotation.NonNull
    public static java.util.concurrent.Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    @androidx.annotation.NonNull
    public static androidx.arch.core.executor.ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (androidx.arch.core.executor.ArchTaskExecutor.class) {
            if (sInstance == null) {
                sInstance = new androidx.arch.core.executor.ArchTaskExecutor();
            }
        }
        return sInstance;
    }

    @androidx.annotation.NonNull
    public static java.util.concurrent.Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(java.lang.Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(java.lang.Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    public void setDelegate(@androidx.annotation.Nullable androidx.arch.core.executor.TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor;
    }
}
