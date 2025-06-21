package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
final class e<TResult> implements com.huawei.hmf.tasks.OnCanceledListener, com.huawei.hmf.tasks.OnFailureListener, com.huawei.hmf.tasks.OnSuccessListener<TResult> {
    public final java.lang.Object a = new java.lang.Object();
    public final int b;
    public final com.huawei.hmf.tasks.a.i<java.lang.Void> c;
    public int d;
    public java.lang.Exception e;
    public boolean f;

    public e(int i, com.huawei.hmf.tasks.a.i<java.lang.Void> iVar) {
        this.b = i;
        this.c = iVar;
    }

    public final void a() {
        if (this.d >= this.b) {
            if (this.e != null) {
                this.c.a(new java.util.concurrent.ExecutionException("a task failed", this.e));
            } else if (this.f) {
                this.c.a();
            } else {
                this.c.a((com.huawei.hmf.tasks.a.i<java.lang.Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.a) {
            this.d++;
            this.f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(java.lang.Exception exc) {
        synchronized (this.a) {
            this.d++;
            this.e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.d++;
            a();
        }
    }
}
