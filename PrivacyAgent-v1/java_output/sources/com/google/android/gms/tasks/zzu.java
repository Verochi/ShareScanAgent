package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzu<TResult> extends com.google.android.gms.tasks.Task<TResult> {
    public final java.lang.Object a = new java.lang.Object();
    public final com.google.android.gms.tasks.zzq<TResult> b = new com.google.android.gms.tasks.zzq<>();

    @javax.annotation.concurrent.GuardedBy("mLock")
    public boolean c;
    public volatile boolean d;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("mLock")
    public TResult e;

    @javax.annotation.concurrent.GuardedBy("mLock")
    public java.lang.Exception f;

    public static class zza extends com.google.android.gms.common.api.internal.LifecycleCallback {
        public final java.util.List<java.lang.ref.WeakReference<com.google.android.gms.tasks.zzr<?>>> a;

        public zza(com.google.android.gms.common.api.internal.LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.a = new java.util.ArrayList();
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
        }

        public static com.google.android.gms.tasks.zzu.zza a(android.app.Activity activity) {
            com.google.android.gms.common.api.internal.LifecycleFragment fragment = com.google.android.gms.common.api.internal.LifecycleCallback.getFragment(activity);
            com.google.android.gms.tasks.zzu.zza zzaVar = (com.google.android.gms.tasks.zzu.zza) fragment.getCallbackOrNull("TaskOnStopCallback", com.google.android.gms.tasks.zzu.zza.class);
            return zzaVar == null ? new com.google.android.gms.tasks.zzu.zza(fragment) : zzaVar;
        }

        public final <T> void b(com.google.android.gms.tasks.zzr<T> zzrVar) {
            synchronized (this.a) {
                this.a.add(new java.lang.ref.WeakReference<>(zzrVar));
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @androidx.annotation.MainThread
        public void onStop() {
            synchronized (this.a) {
                java.util.Iterator<java.lang.ref.WeakReference<com.google.android.gms.tasks.zzr<?>>> it = this.a.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.tasks.zzr<?> zzrVar = it.next().get();
                    if (zzrVar != null) {
                        zzrVar.zza();
                    }
                }
                this.a.clear();
            }
        }
    }

    public final void a(@androidx.annotation.NonNull java.lang.Exception exc) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.a) {
            g();
            this.c = true;
            this.f = exc;
        }
        this.b.a(this);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        com.google.android.gms.tasks.zzh zzhVar = new com.google.android.gms.tasks.zzh(com.google.android.gms.tasks.zzv.zza(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD), onCanceledListener);
        this.b.b(zzhVar);
        com.google.android.gms.tasks.zzu.zza.a(activity).b(zzhVar);
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        this.b.b(new com.google.android.gms.tasks.zzh(com.google.android.gms.tasks.zzv.zza(executor), onCanceledListener));
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        com.google.android.gms.tasks.zzi zziVar = new com.google.android.gms.tasks.zzi(com.google.android.gms.tasks.zzv.zza(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD), onCompleteListener);
        this.b.b(zziVar);
        com.google.android.gms.tasks.zzu.zza.a(activity).b(zziVar);
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        this.b.b(new com.google.android.gms.tasks.zzi(com.google.android.gms.tasks.zzv.zza(executor), onCompleteListener));
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener) {
        com.google.android.gms.tasks.zzl zzlVar = new com.google.android.gms.tasks.zzl(com.google.android.gms.tasks.zzv.zza(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD), onFailureListener);
        this.b.b(zzlVar);
        com.google.android.gms.tasks.zzu.zza.a(activity).b(zzlVar);
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener) {
        return addOnFailureListener(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener) {
        this.b.b(new com.google.android.gms.tasks.zzl(com.google.android.gms.tasks.zzv.zza(executor), onFailureListener));
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener) {
        com.google.android.gms.tasks.zzm zzmVar = new com.google.android.gms.tasks.zzm(com.google.android.gms.tasks.zzv.zza(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD), onSuccessListener);
        this.b.b(zzmVar);
        com.google.android.gms.tasks.zzu.zza.a(activity).b(zzmVar);
        i();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener) {
        this.b.b(new com.google.android.gms.tasks.zzm(com.google.android.gms.tasks.zzv.zza(executor), onSuccessListener));
        i();
        return this;
    }

    public final void b(@androidx.annotation.Nullable TResult tresult) {
        synchronized (this.a) {
            g();
            this.c = true;
            this.e = tresult;
        }
        this.b.a(this);
    }

    public final boolean c() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWith(@androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWith(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> continuation) {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        this.b.b(new com.google.android.gms.tasks.zzc(com.google.android.gms.tasks.zzv.zza(executor), continuation, zzuVar));
        i();
        return zzuVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWithTask(@androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>> continuation) {
        return continueWithTask(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWithTask(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>> continuation) {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        this.b.b(new com.google.android.gms.tasks.zzd(com.google.android.gms.tasks.zzv.zza(executor), continuation, zzuVar));
        i();
        return zzuVar;
    }

    @javax.annotation.concurrent.GuardedBy("mLock")
    public final void d() {
        com.google.android.gms.common.internal.Preconditions.checkState(this.c, "Task is not yet complete");
    }

    public final boolean e(@androidx.annotation.NonNull java.lang.Exception exc) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean f(@androidx.annotation.Nullable TResult tresult) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = tresult;
            this.b.a(this);
            return true;
        }
    }

    @javax.annotation.concurrent.GuardedBy("mLock")
    public final void g() {
        if (this.c) {
            throw com.google.android.gms.tasks.DuplicateTaskCompletionException.of(this);
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.Nullable
    public final java.lang.Exception getException() {
        java.lang.Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            d();
            h();
            if (this.f != null) {
                throw new com.google.android.gms.tasks.RuntimeExecutionException(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends java.lang.Throwable> TResult getResult(@androidx.annotation.NonNull java.lang.Class<X> cls) throws java.lang.Throwable {
        TResult tresult;
        synchronized (this.a) {
            d();
            h();
            if (cls.isInstance(this.f)) {
                throw cls.cast(this.f);
            }
            if (this.f != null) {
                throw new com.google.android.gms.tasks.RuntimeExecutionException(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @javax.annotation.concurrent.GuardedBy("mLock")
    public final void h() {
        if (this.d) {
            throw new java.util.concurrent.CancellationException("Task is already canceled.");
        }
    }

    public final void i() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.d && this.f == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> onSuccessTask(@androidx.annotation.NonNull com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @androidx.annotation.NonNull
    public final <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> onSuccessTask(java.util.concurrent.Executor executor, com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        com.google.android.gms.tasks.zzu zzuVar = new com.google.android.gms.tasks.zzu();
        this.b.b(new com.google.android.gms.tasks.zzp(com.google.android.gms.tasks.zzv.zza(executor), successContinuation, zzuVar));
        i();
        return zzuVar;
    }
}
