package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class q<TResult> implements com.hihonor.push.sdk.tasks.ExecuteResult<TResult> {
    public com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> a;
    public java.util.concurrent.Executor b;
    public final java.lang.Object c = new java.lang.Object();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ com.hihonor.push.sdk.tasks.Task a;

        public a(com.hihonor.push.sdk.tasks.Task task) {
            this.a = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.hihonor.push.sdk.q.this.c) {
                com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener = com.hihonor.push.sdk.q.this.a;
                if (onCompleteListener != null) {
                    onCompleteListener.onComplete(this.a);
                }
            }
        }
    }

    public q(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener) {
        this.a = onCompleteListener;
        this.b = executor;
    }

    @Override // com.hihonor.push.sdk.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.hihonor.push.sdk.tasks.ExecuteResult
    public final void onComplete(com.hihonor.push.sdk.tasks.Task<TResult> task) {
        this.b.execute(new com.hihonor.push.sdk.q.a(task));
    }
}
