package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public class TaskCompletionSource<TResult> {
    public final com.huawei.hmf.tasks.a.i<TResult> a = new com.huawei.hmf.tasks.a.i<>();

    /* renamed from: com.huawei.hmf.tasks.TaskCompletionSource$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hmf.tasks.TaskCompletionSource.this.a.a();
        }
    }

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(com.huawei.hmf.tasks.CancellationToken cancellationToken) {
        cancellationToken.register(new com.huawei.hmf.tasks.TaskCompletionSource.AnonymousClass1());
    }

    public com.huawei.hmf.tasks.Task<TResult> getTask() {
        return this.a;
    }

    public void setException(java.lang.Exception exc) {
        this.a.a(exc);
    }

    public void setResult(TResult tresult) {
        this.a.a((com.huawei.hmf.tasks.a.i<TResult>) tresult);
    }
}
