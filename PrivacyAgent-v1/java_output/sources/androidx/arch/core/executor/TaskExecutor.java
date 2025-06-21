package androidx.arch.core.executor;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class TaskExecutor {
    public abstract void executeOnDiskIO(@androidx.annotation.NonNull java.lang.Runnable runnable);

    public void executeOnMainThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            postToMainThread(runnable);
        }
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(@androidx.annotation.NonNull java.lang.Runnable runnable);
}
