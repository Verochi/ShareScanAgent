package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public class Tasks {
    public static com.huawei.hmf.tasks.a.j a = new com.huawei.hmf.tasks.a.j();

    public static com.huawei.hmf.tasks.Task<java.util.List<com.huawei.hmf.tasks.Task<?>>> allOf(java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>> collection) {
        return com.huawei.hmf.tasks.a.j.a(collection);
    }

    public static com.huawei.hmf.tasks.Task<java.util.List<com.huawei.hmf.tasks.Task<?>>> allOf(com.huawei.hmf.tasks.Task<?>... taskArr) {
        return com.huawei.hmf.tasks.a.j.a((java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>>) java.util.Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(com.huawei.hmf.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        com.huawei.hmf.tasks.a.j.a("await must not be called on the UI thread");
        if (task.isComplete()) {
            return (TResult) com.huawei.hmf.tasks.a.j.a((com.huawei.hmf.tasks.Task) task);
        }
        com.huawei.hmf.tasks.a.j.a aVar = new com.huawei.hmf.tasks.a.j.a();
        task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
        aVar.a.await();
        return (TResult) com.huawei.hmf.tasks.a.j.a((com.huawei.hmf.tasks.Task) task);
    }

    public static <TResult> TResult await(com.huawei.hmf.tasks.Task<TResult> task, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        com.huawei.hmf.tasks.a.j.a("await must not be called on the UI thread");
        if (!task.isComplete()) {
            com.huawei.hmf.tasks.a.j.a aVar = new com.huawei.hmf.tasks.a.j.a();
            task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
            if (!aVar.a.await(j, timeUnit)) {
                throw new java.util.concurrent.TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) com.huawei.hmf.tasks.a.j.a((com.huawei.hmf.tasks.Task) task);
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> call(java.util.concurrent.Callable<TResult> callable) {
        return a.a(com.huawei.hmf.tasks.TaskExecutors.immediate(), callable);
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> callInBackground(java.util.concurrent.Callable<TResult> callable) {
        return a.a(com.huawei.hmf.tasks.TaskExecutors.a(), callable);
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> callInBackground(java.util.concurrent.Executor executor, java.util.concurrent.Callable<TResult> callable) {
        return a.a(executor, callable);
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> fromCanceled() {
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        iVar.a();
        return iVar;
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> fromException(java.lang.Exception exc) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> fromResult(TResult tresult) {
        return com.huawei.hmf.tasks.a.j.a(tresult);
    }

    public static com.huawei.hmf.tasks.Task<java.lang.Void> join(java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>> collection) {
        return com.huawei.hmf.tasks.a.j.c(collection);
    }

    public static com.huawei.hmf.tasks.Task<java.lang.Void> join(com.huawei.hmf.tasks.Task<?>... taskArr) {
        return com.huawei.hmf.tasks.a.j.c(java.util.Arrays.asList(taskArr));
    }

    public static <TResult> com.huawei.hmf.tasks.Task<java.util.List<TResult>> successOf(java.util.Collection<? extends com.huawei.hmf.tasks.Task<TResult>> collection) {
        return com.huawei.hmf.tasks.a.j.b(collection);
    }

    public static <TResult> com.huawei.hmf.tasks.Task<java.util.List<TResult>> successOf(com.huawei.hmf.tasks.Task<?>... taskArr) {
        return com.huawei.hmf.tasks.a.j.b(java.util.Arrays.asList(taskArr));
    }
}
