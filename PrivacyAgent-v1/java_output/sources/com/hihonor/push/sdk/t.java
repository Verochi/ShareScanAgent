package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class t<TResult> implements com.hihonor.push.sdk.tasks.ExecuteResult<TResult> {
    public com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> a;
    public java.util.concurrent.Executor b;
    public final java.lang.Object c = new java.lang.Object();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ com.hihonor.push.sdk.tasks.Task a;

        public a(com.hihonor.push.sdk.tasks.Task task) {
            this.a = task;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.hihonor.push.sdk.t.this.c) {
                com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener = com.hihonor.push.sdk.t.this.a;
                if (onSuccessListener != 0) {
                    onSuccessListener.onSuccess(this.a.getResult());
                }
            }
        }
    }

    public t(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
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
        if (!task.isSuccessful() || ((com.hihonor.push.sdk.v) task).c) {
            return;
        }
        this.b.execute(new com.hihonor.push.sdk.t.a(task));
    }
}
