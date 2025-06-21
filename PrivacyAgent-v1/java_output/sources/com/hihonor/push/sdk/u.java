package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class u {

    public class a implements java.lang.Runnable {
        public final /* synthetic */ com.hihonor.push.sdk.tasks.TaskCompletionSource a;
        public final /* synthetic */ java.util.concurrent.Callable b;

        public a(com.hihonor.push.sdk.u uVar, com.hihonor.push.sdk.tasks.TaskCompletionSource taskCompletionSource, java.util.concurrent.Callable callable) {
            this.a = taskCompletionSource;
            this.b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.setResult(this.b.call());
            } catch (java.lang.Exception e) {
                this.a.setException(e);
            }
        }
    }

    public static <TResult> TResult a(com.hihonor.push.sdk.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new java.util.concurrent.ExecutionException(task.getException());
    }

    public final <TResult> com.hihonor.push.sdk.tasks.Task<TResult> a(java.util.concurrent.Executor executor, java.util.concurrent.Callable<TResult> callable) {
        com.hihonor.push.sdk.tasks.TaskCompletionSource taskCompletionSource = new com.hihonor.push.sdk.tasks.TaskCompletionSource();
        try {
            executor.execute(new com.hihonor.push.sdk.u.a(this, taskCompletionSource, callable));
        } catch (java.lang.Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }
}
