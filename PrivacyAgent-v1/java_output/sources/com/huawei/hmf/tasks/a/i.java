package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class i<TResult> extends com.huawei.hmf.tasks.Task<TResult> {
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public java.lang.Exception e;
    public final java.lang.Object a = new java.lang.Object();
    public java.util.List<com.huawei.hmf.tasks.ExecuteResult<TResult>> f = new java.util.ArrayList();

    /* renamed from: com.huawei.hmf.tasks.a.i$1, reason: invalid class name */
    public class AnonymousClass1 implements com.huawei.hmf.tasks.OnSuccessListener<TResult> {
        public final /* synthetic */ com.huawei.hmf.tasks.SuccessContinuation a;
        public final /* synthetic */ com.huawei.hmf.tasks.a.i b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* renamed from: com.huawei.hmf.tasks.a.i$1$1, reason: invalid class name and collision with other inner class name */
        public class C03611<TContinuationResult> implements com.huawei.hmf.tasks.OnCompleteListener<TContinuationResult> {
            public C03611() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public final void onComplete(com.huawei.hmf.tasks.Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    com.huawei.hmf.tasks.a.i.AnonymousClass1.this.b.a((com.huawei.hmf.tasks.a.i) task.getResult());
                } else if (task.isCanceled()) {
                    com.huawei.hmf.tasks.a.i.AnonymousClass1.this.b.a();
                } else {
                    com.huawei.hmf.tasks.a.i.AnonymousClass1.this.b.a(task.getException());
                }
            }
        }

        public AnonymousClass1(com.huawei.hmf.tasks.SuccessContinuation successContinuation, com.huawei.hmf.tasks.a.i iVar) {
            this.a = successContinuation;
            this.b = iVar;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            try {
                com.huawei.hmf.tasks.Task then = this.a.then(tresult);
                if (then == null) {
                    this.b.a((java.lang.Exception) new java.lang.NullPointerException("SuccessContinuation returned null"));
                } else {
                    then.addOnCompleteListener(new com.huawei.hmf.tasks.a.i.AnonymousClass1.C03611());
                }
            } catch (java.lang.Exception e) {
                this.b.a(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$2, reason: invalid class name */
    public class AnonymousClass2 implements com.huawei.hmf.tasks.OnFailureListener {
        public final /* synthetic */ com.huawei.hmf.tasks.a.i a;

        public AnonymousClass2(com.huawei.hmf.tasks.a.i iVar) {
            this.a = iVar;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(java.lang.Exception exc) {
            this.a.a(exc);
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$3, reason: invalid class name */
    public class AnonymousClass3 implements com.huawei.hmf.tasks.OnCanceledListener {
        public final /* synthetic */ com.huawei.hmf.tasks.a.i a;

        public AnonymousClass3(com.huawei.hmf.tasks.a.i iVar) {
            this.a = iVar;
        }

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void onCanceled() {
            this.a.a();
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$4, reason: invalid class name */
    public class AnonymousClass4 implements com.huawei.hmf.tasks.OnCompleteListener<TResult> {
        public final /* synthetic */ com.huawei.hmf.tasks.Continuation a;
        public final /* synthetic */ com.huawei.hmf.tasks.a.i b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* renamed from: com.huawei.hmf.tasks.a.i$4$1, reason: invalid class name */
        public class AnonymousClass1<TContinuationResult> implements com.huawei.hmf.tasks.OnCompleteListener<TContinuationResult> {
            public AnonymousClass1() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public final void onComplete(com.huawei.hmf.tasks.Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    com.huawei.hmf.tasks.a.i.AnonymousClass4.this.b.a((com.huawei.hmf.tasks.a.i) task.getResult());
                } else if (task.isCanceled()) {
                    com.huawei.hmf.tasks.a.i.AnonymousClass4.this.b.a();
                } else {
                    com.huawei.hmf.tasks.a.i.AnonymousClass4.this.b.a(task.getException());
                }
            }
        }

        public AnonymousClass4(com.huawei.hmf.tasks.Continuation continuation, com.huawei.hmf.tasks.a.i iVar) {
            this.a = continuation;
            this.b = iVar;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void onComplete(com.huawei.hmf.tasks.Task<TResult> task) {
            try {
                com.huawei.hmf.tasks.Task task2 = (com.huawei.hmf.tasks.Task) this.a.then(task);
                if (task2 == null) {
                    this.b.a((java.lang.Exception) new java.lang.NullPointerException("Continuation returned null"));
                } else {
                    task2.addOnCompleteListener(new com.huawei.hmf.tasks.a.i.AnonymousClass4.AnonymousClass1());
                }
            } catch (java.lang.Exception e) {
                this.b.a(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$5, reason: invalid class name */
    public class AnonymousClass5 implements com.huawei.hmf.tasks.OnCompleteListener<TResult> {
        public final /* synthetic */ com.huawei.hmf.tasks.a.i a;
        public final /* synthetic */ com.huawei.hmf.tasks.Continuation b;

        public AnonymousClass5(com.huawei.hmf.tasks.a.i iVar, com.huawei.hmf.tasks.Continuation continuation) {
            this.a = iVar;
            this.b = continuation;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void onComplete(com.huawei.hmf.tasks.Task<TResult> task) {
            if (task.isCanceled()) {
                this.a.a();
                return;
            }
            try {
                this.a.a((com.huawei.hmf.tasks.a.i) this.b.then(task));
            } catch (java.lang.Exception e) {
                this.a.a(e);
            }
        }
    }

    public final com.huawei.hmf.tasks.Task<TResult> a(com.huawei.hmf.tasks.ExecuteResult<TResult> executeResult) {
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

    public final void a(java.lang.Exception exc) {
        synchronized (this.a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.e = exc;
            this.a.notifyAll();
            b();
        }
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.d = tresult;
            this.a.notifyAll();
            b();
        }
    }

    public final boolean a() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.c = true;
            this.a.notifyAll();
            b();
            return true;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(android.app.Activity activity, com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        com.huawei.hmf.tasks.a.b bVar = new com.huawei.hmf.tasks.a.b(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onCanceledListener);
        com.huawei.hmf.tasks.a.g.a(activity, bVar);
        return a((com.huawei.hmf.tasks.ExecuteResult) bVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onCanceledListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        return a((com.huawei.hmf.tasks.ExecuteResult) new com.huawei.hmf.tasks.a.b(executor, onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(android.app.Activity activity, com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        com.huawei.hmf.tasks.a.d dVar = new com.huawei.hmf.tasks.a.d(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onCompleteListener);
        com.huawei.hmf.tasks.a.g.a(activity, dVar);
        return a((com.huawei.hmf.tasks.ExecuteResult) dVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onCompleteListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        return a((com.huawei.hmf.tasks.ExecuteResult) new com.huawei.hmf.tasks.a.d(executor, onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(android.app.Activity activity, com.huawei.hmf.tasks.OnFailureListener onFailureListener) {
        com.huawei.hmf.tasks.a.f fVar = new com.huawei.hmf.tasks.a.f(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onFailureListener);
        com.huawei.hmf.tasks.a.g.a(activity, fVar);
        return a((com.huawei.hmf.tasks.ExecuteResult) fVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(com.huawei.hmf.tasks.OnFailureListener onFailureListener) {
        return addOnFailureListener(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onFailureListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnFailureListener onFailureListener) {
        return a((com.huawei.hmf.tasks.ExecuteResult) new com.huawei.hmf.tasks.a.f(executor, onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(android.app.Activity activity, com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener) {
        com.huawei.hmf.tasks.a.h hVar = new com.huawei.hmf.tasks.a.h(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onSuccessListener);
        com.huawei.hmf.tasks.a.g.a(activity, hVar);
        return a((com.huawei.hmf.tasks.ExecuteResult) hVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(com.huawei.hmf.tasks.TaskExecutors.uiThread(), onSuccessListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener) {
        return a((com.huawei.hmf.tasks.ExecuteResult) new com.huawei.hmf.tasks.a.h(executor, onSuccessListener));
    }

    public final void b() {
        synchronized (this.a) {
            java.util.Iterator<com.huawei.hmf.tasks.ExecuteResult<TResult>> it = this.f.iterator();
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

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWith(com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(com.huawei.hmf.tasks.TaskExecutors.uiThread(), continuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWith(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult> continuation) {
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        addOnCompleteListener(executor, new com.huawei.hmf.tasks.a.i.AnonymousClass5(iVar, continuation));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWithTask(com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>> continuation) {
        return continueWithTask(com.huawei.hmf.tasks.TaskExecutors.uiThread(), continuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWithTask(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>> continuation) {
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        addOnCompleteListener(executor, new com.huawei.hmf.tasks.a.i.AnonymousClass4(continuation, iVar));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final java.lang.Exception getException() {
        java.lang.Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
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

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends java.lang.Throwable> TResult getResultThrowException(java.lang.Class<E> cls) throws java.lang.Throwable {
        TResult tresult;
        synchronized (this.a) {
            if (cls != null) {
                if (cls.isInstance(this.e)) {
                    throw cls.cast(this.e);
                }
            }
            if (this.e != null) {
                throw new java.lang.RuntimeException(this.e);
            }
            tresult = this.d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isCanceled() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.b && !isCanceled() && this.e == null;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> onSuccessTask(com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(com.huawei.hmf.tasks.TaskExecutors.uiThread(), successContinuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> onSuccessTask(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        addOnSuccessListener(executor, new com.huawei.hmf.tasks.a.i.AnonymousClass1(successContinuation, iVar));
        addOnFailureListener(new com.huawei.hmf.tasks.a.i.AnonymousClass2(iVar));
        addOnCanceledListener(new com.huawei.hmf.tasks.a.i.AnonymousClass3(iVar));
        return iVar;
    }
}
