package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public class Tasks {
    private static final com.hihonor.push.sdk.u HELPER = new com.hihonor.push.sdk.u();

    public static <TResult> TResult await(com.hihonor.push.sdk.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("await must not be called on the UI thread");
        }
        if (task.isComplete()) {
            return (TResult) com.hihonor.push.sdk.u.a(task);
        }
        com.hihonor.push.sdk.x xVar = new com.hihonor.push.sdk.x();
        task.addOnSuccessListener(xVar).addOnFailureListener(xVar);
        xVar.a.await();
        return (TResult) com.hihonor.push.sdk.u.a(task);
    }

    public static <TResult> TResult await(com.hihonor.push.sdk.tasks.Task<TResult> task, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("await must not be called on the UI thread");
        }
        if (!task.isComplete()) {
            com.hihonor.push.sdk.x xVar = new com.hihonor.push.sdk.x();
            task.addOnSuccessListener(xVar).addOnFailureListener(xVar);
            if (!xVar.a.await(j, timeUnit)) {
                throw new java.util.concurrent.TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) com.hihonor.push.sdk.u.a(task);
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> call(java.util.concurrent.Callable<TResult> callable) {
        return HELPER.a(com.hihonor.push.sdk.tasks.TaskExecutors.immediate(), callable);
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> callInBackground(java.util.concurrent.Callable<TResult> callable) {
        return HELPER.a(com.hihonor.push.sdk.tasks.TaskExecutors.background(), callable);
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> callInBackground(java.util.concurrent.Executor executor, java.util.concurrent.Callable<TResult> callable) {
        return HELPER.a(executor, callable);
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> fromCanceled() {
        com.hihonor.push.sdk.v vVar = new com.hihonor.push.sdk.v();
        synchronized (vVar.a) {
            if (!vVar.b) {
                vVar.b = true;
                vVar.c = true;
                vVar.a.notifyAll();
                vVar.a();
            }
        }
        return vVar;
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> fromException(java.lang.Exception exc) {
        com.hihonor.push.sdk.tasks.TaskCompletionSource taskCompletionSource = new com.hihonor.push.sdk.tasks.TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> com.hihonor.push.sdk.tasks.Task<TResult> fromResult(TResult tresult) {
        com.hihonor.push.sdk.tasks.TaskCompletionSource taskCompletionSource = new com.hihonor.push.sdk.tasks.TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }
}
