package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class v<TResult> extends com.hihonor.push.sdk.tasks.Task<TResult> {
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public java.lang.Exception e;
    public final java.lang.Object a = new java.lang.Object();
    public java.util.List<com.hihonor.push.sdk.tasks.ExecuteResult<TResult>> f = new java.util.ArrayList();

    public final com.hihonor.push.sdk.tasks.Task<TResult> a(com.hihonor.push.sdk.tasks.ExecuteResult<TResult> executeResult) {
        boolean isComplete;
        synchronized (this.a) {
            isComplete = isComplete();
            if (!isComplete) {
                this.f.add(executeResult);
            }
        }
        if (isComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    public final void a() {
        synchronized (this.a) {
            java.util.Iterator<com.hihonor.push.sdk.tasks.ExecuteResult<TResult>> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (java.lang.RuntimeException e) {
                    throw e;
                } catch (java.lang.Exception e2) {
                    throw new java.lang.RuntimeException(e2);
                }
            }
            this.f = null;
        }
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnCanceledListener(com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener) {
        return a(new com.hihonor.push.sdk.p(com.hihonor.push.sdk.tasks.TaskExecutors.uiThread(), onCanceledListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnCanceledListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener) {
        return a(new com.hihonor.push.sdk.p(executor, onCanceledListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnCompleteListener(com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener) {
        return a(new com.hihonor.push.sdk.q(com.hihonor.push.sdk.tasks.TaskExecutors.uiThread(), onCompleteListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnCompleteListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener) {
        return a(new com.hihonor.push.sdk.q(executor, onCompleteListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnFailureListener(com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener) {
        return a(new com.hihonor.push.sdk.s(com.hihonor.push.sdk.tasks.TaskExecutors.uiThread(), onFailureListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnFailureListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener) {
        return a(new com.hihonor.push.sdk.s(executor, onFailureListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnSuccessListener(com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener) {
        return a(new com.hihonor.push.sdk.t(com.hihonor.push.sdk.tasks.TaskExecutors.uiThread(), onSuccessListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final com.hihonor.push.sdk.tasks.Task<TResult> addOnSuccessListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener) {
        return a(new com.hihonor.push.sdk.t(executor, onSuccessListener));
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final java.lang.Exception getException() {
        java.lang.Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            if (this.e != null) {
                throw new java.lang.RuntimeException(this.e);
            }
            tresult = this.d;
        }
        return tresult;
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final <E extends java.lang.Throwable> TResult getResultThrowException(java.lang.Class<E> cls) throws java.lang.Throwable {
        TResult tresult;
        synchronized (this.a) {
            if (cls != null) {
                if (cls.isInstance(this.e)) {
                    E cast = cls.cast(this.e);
                    java.util.Objects.requireNonNull(cast);
                    throw cast;
                }
            }
            if (this.e != null) {
                throw new java.lang.RuntimeException(this.e);
            }
            tresult = this.d;
        }
        return tresult;
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final boolean isCanceled() {
        return this.c;
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    @Override // com.hihonor.push.sdk.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.b && !this.c && this.e == null;
        }
        return z;
    }
}
