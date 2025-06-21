package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public final class Tasks {

    public interface zza<T> extends com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnFailureListener, com.google.android.gms.tasks.OnSuccessListener<T> {
    }

    public static final class zzb implements com.google.android.gms.tasks.Tasks.zza {
        public final java.util.concurrent.CountDownLatch a;

        public zzb() {
            this.a = new java.util.concurrent.CountDownLatch(1);
        }

        public /* synthetic */ zzb(com.google.android.gms.tasks.zzy zzyVar) {
            this();
        }

        public final void a() throws java.lang.InterruptedException {
            this.a.await();
        }

        public final boolean b(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return this.a.await(j, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@androidx.annotation.NonNull java.lang.Exception exc) {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(java.lang.Object obj) {
            this.a.countDown();
        }
    }

    public static final class zzc implements com.google.android.gms.tasks.Tasks.zza {
        public final java.lang.Object a = new java.lang.Object();
        public final int b;
        public final com.google.android.gms.tasks.zzu<java.lang.Void> c;

        @javax.annotation.concurrent.GuardedBy("mLock")
        public int d;

        @javax.annotation.concurrent.GuardedBy("mLock")
        public int e;

        @javax.annotation.concurrent.GuardedBy("mLock")
        public int f;

        @javax.annotation.concurrent.GuardedBy("mLock")
        public java.lang.Exception g;

        @javax.annotation.concurrent.GuardedBy("mLock")
        public boolean h;

        public zzc(int i, com.google.android.gms.tasks.zzu<java.lang.Void> zzuVar) {
            this.b = i;
            this.c = zzuVar;
        }

        @javax.annotation.concurrent.GuardedBy("mLock")
        public final void a() {
            if (this.d + this.e + this.f == this.b) {
                if (this.g == null) {
                    if (this.h) {
                        this.c.c();
                        return;
                    } else {
                        this.c.b(null);
                        return;
                    }
                }
                com.google.android.gms.tasks.zzu<java.lang.Void> zzuVar = this.c;
                int i = this.e;
                int i2 = this.b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(54);
                sb.append(i);
                sb.append(" out of ");
                sb.append(i2);
                sb.append(" underlying tasks failed");
                zzuVar.a(new java.util.concurrent.ExecutionException(sb.toString(), this.g));
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            synchronized (this.a) {
                this.f++;
                this.h = true;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@androidx.annotation.NonNull java.lang.Exception exc) {
            synchronized (this.a) {
                this.e++;
                this.g = exc;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(java.lang.Object obj) {
            synchronized (this.a) {
                this.d++;
                a();
            }
        }
    }

    public static <TResult> TResult a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new java.util.concurrent.CancellationException("Task is already canceled");
        }
        throw new java.util.concurrent.ExecutionException(task.getException());
    }

    public static <TResult> TResult await(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        com.google.android.gms.common.internal.Preconditions.checkNotMainThread();
        com.google.android.gms.common.internal.Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        com.google.android.gms.tasks.Tasks.zzb zzbVar = new com.google.android.gms.tasks.Tasks.zzb(null);
        b(task, zzbVar);
        zzbVar.a();
        return (TResult) a(task);
    }

    public static <TResult> TResult await(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task, long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        com.google.android.gms.common.internal.Preconditions.checkNotMainThread();
        com.google.android.gms.common.internal.Preconditions.checkNotNull(task, "Task must not be null");
        com.google.android.gms.common.internal.Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        com.google.android.gms.tasks.Tasks.zzb zzbVar = new com.google.android.gms.tasks.Tasks.zzb(null);
        b(task, zzbVar);
        if (zzbVar.b(j, timeUnit)) {
            return (TResult) a(task);
        }
        throw new java.util.concurrent.TimeoutException("Timed out waiting for Task");
    }

    public static <T> void b(com.google.android.gms.tasks.Task<T> task, com.google.android.gms.tasks.Tasks.zza<? super T> zzaVar) {
        java.util.concurrent.Executor executor = com.google.android.gms.tasks.TaskExecutors.a;
        task.addOnSuccessListener(executor, zzaVar);
        task.addOnFailureListener(executor, zzaVar);
        task.addOnCanceledListener(executor, zzaVar);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static <TResult> com.google.android.gms.tasks.Task<TResult> call(@androidx.annotation.NonNull java.util.concurrent.Callable<TResult> callable) {
        return call(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, callable);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static <TResult> com.google.android.gms.tasks.Task<TResult> call(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Callable<TResult> callable) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(executor, "Executor must not be null");
        com.google.android.gms.common.internal.Preconditions.checkNotNull(callable, "Callback must not be null");
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        executor.execute(new com.google.android.gms.tasks.zzy(zzuVar, callable));
        return zzuVar;
    }

    @androidx.annotation.NonNull
    public static <TResult> com.google.android.gms.tasks.Task<TResult> forCanceled() {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        zzuVar.c();
        return zzuVar;
    }

    @androidx.annotation.NonNull
    public static <TResult> com.google.android.gms.tasks.Task<TResult> forException(@androidx.annotation.NonNull java.lang.Exception exc) {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        zzuVar.a(exc);
        return zzuVar;
    }

    @androidx.annotation.NonNull
    public static <TResult> com.google.android.gms.tasks.Task<TResult> forResult(TResult tresult) {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        zzuVar.b(tresult);
        return zzuVar;
    }

    @androidx.annotation.NonNull
    public static com.google.android.gms.tasks.Task<java.lang.Void> whenAll(@androidx.annotation.Nullable java.util.Collection<? extends com.google.android.gms.tasks.Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(null);
        }
        java.util.Iterator<? extends com.google.android.gms.tasks.Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new java.lang.NullPointerException("null tasks are not accepted");
            }
        }
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        com.google.android.gms.tasks.Tasks.zzc zzcVar = new com.google.android.gms.tasks.Tasks.zzc(collection.size(), zzuVar);
        java.util.Iterator<? extends com.google.android.gms.tasks.Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            b(it2.next(), zzcVar);
        }
        return zzuVar;
    }

    @androidx.annotation.NonNull
    public static com.google.android.gms.tasks.Task<java.lang.Void> whenAll(@androidx.annotation.Nullable com.google.android.gms.tasks.Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(null) : whenAll(java.util.Arrays.asList(taskArr));
    }

    @androidx.annotation.NonNull
    public static com.google.android.gms.tasks.Task<java.util.List<com.google.android.gms.tasks.Task<?>>> whenAllComplete(@androidx.annotation.Nullable java.util.Collection<? extends com.google.android.gms.tasks.Task<?>> collection) {
        return (collection == null || collection.isEmpty()) ? forResult(java.util.Collections.emptyList()) : whenAll(collection).continueWithTask(new com.google.android.gms.tasks.zzz(collection));
    }

    @androidx.annotation.NonNull
    public static com.google.android.gms.tasks.Task<java.util.List<com.google.android.gms.tasks.Task<?>>> whenAllComplete(@androidx.annotation.Nullable com.google.android.gms.tasks.Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(java.util.Collections.emptyList()) : whenAllComplete(java.util.Arrays.asList(taskArr));
    }

    @androidx.annotation.NonNull
    public static <TResult> com.google.android.gms.tasks.Task<java.util.List<TResult>> whenAllSuccess(@androidx.annotation.Nullable java.util.Collection<? extends com.google.android.gms.tasks.Task<?>> collection) {
        return (collection == null || collection.isEmpty()) ? forResult(java.util.Collections.emptyList()) : (com.google.android.gms.tasks.Task<java.util.List<TResult>>) whenAll(collection).continueWith(new com.google.android.gms.tasks.zzaa(collection));
    }

    @androidx.annotation.NonNull
    public static <TResult> com.google.android.gms.tasks.Task<java.util.List<TResult>> whenAllSuccess(@androidx.annotation.Nullable com.google.android.gms.tasks.Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(java.util.Collections.emptyList()) : whenAllSuccess(java.util.Arrays.asList(taskArr));
    }
}
