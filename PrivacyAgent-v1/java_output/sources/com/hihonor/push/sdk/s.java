package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class s<TResult> implements com.hihonor.push.sdk.tasks.ExecuteResult<TResult> {
    public com.hihonor.push.sdk.tasks.OnFailureListener a;
    public java.util.concurrent.Executor b;
    public final java.lang.Object c = new java.lang.Object();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ com.hihonor.push.sdk.tasks.Task a;

        public a(com.hihonor.push.sdk.tasks.Task task) {
            this.a = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.hihonor.push.sdk.s.this.c) {
                com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener = com.hihonor.push.sdk.s.this.a;
                if (onFailureListener != null) {
                    onFailureListener.onFailure(this.a.getException());
                }
            }
        }
    }

    public s(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener) {
        this.a = onFailureListener;
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
        if (task.isSuccessful() || ((com.hihonor.push.sdk.v) task).c) {
            return;
        }
        this.b.execute(new com.hihonor.push.sdk.s.a(task));
    }
}
