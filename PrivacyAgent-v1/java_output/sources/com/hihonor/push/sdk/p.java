package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class p<TResult> implements com.hihonor.push.sdk.tasks.ExecuteResult<TResult> {
    public com.hihonor.push.sdk.tasks.OnCanceledListener a;
    public java.util.concurrent.Executor b;
    public final java.lang.Object c = new java.lang.Object();

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.hihonor.push.sdk.p.this.c) {
                com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener = com.hihonor.push.sdk.p.this.a;
                if (onCanceledListener != null) {
                    onCanceledListener.onCanceled();
                }
            }
        }
    }

    public p(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener) {
        this.a = onCanceledListener;
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
        if (((com.hihonor.push.sdk.v) task).c) {
            this.b.execute(new com.hihonor.push.sdk.p.a());
        }
    }
}
