package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class h<TResult> implements com.huawei.hmf.tasks.ExecuteResult<TResult> {
    public com.huawei.hmf.tasks.OnSuccessListener<TResult> a;
    public java.util.concurrent.Executor b;
    public final java.lang.Object c = new java.lang.Object();

    /* renamed from: com.huawei.hmf.tasks.a.h$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.huawei.hmf.tasks.Task n;

        public AnonymousClass1(com.huawei.hmf.tasks.Task task) {
            this.n = task;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.huawei.hmf.tasks.a.h.this.c) {
                if (com.huawei.hmf.tasks.a.h.this.a != null) {
                    com.huawei.hmf.tasks.a.h.this.a.onSuccess(this.n.getResult());
                }
            }
        }
    }

    public h(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(com.huawei.hmf.tasks.Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.b.execute(new com.huawei.hmf.tasks.a.h.AnonymousClass1(task));
    }
}
