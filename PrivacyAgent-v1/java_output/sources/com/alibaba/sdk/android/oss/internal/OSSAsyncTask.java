package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class OSSAsyncTask<T extends com.alibaba.sdk.android.oss.model.OSSResult> {
    private volatile boolean canceled;
    private com.alibaba.sdk.android.oss.network.ExecutionContext context;
    private java.util.concurrent.Future<T> future;

    public static com.alibaba.sdk.android.oss.internal.OSSAsyncTask wrapRequestTask(java.util.concurrent.Future future, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        com.alibaba.sdk.android.oss.internal.OSSAsyncTask oSSAsyncTask = new com.alibaba.sdk.android.oss.internal.OSSAsyncTask();
        oSSAsyncTask.future = future;
        oSSAsyncTask.context = executionContext;
        return oSSAsyncTask;
    }

    public void cancel() {
        this.canceled = true;
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = this.context;
        if (executionContext != null) {
            executionContext.getCancellationHandler().cancel();
        }
    }

    public T getResult() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        try {
            return this.future.get();
        } catch (java.lang.InterruptedException e) {
            throw new com.alibaba.sdk.android.oss.ClientException(" InterruptedException and message : " + e.getMessage(), e);
        } catch (java.util.concurrent.ExecutionException e2) {
            java.lang.Throwable cause = e2.getCause();
            if (cause instanceof com.alibaba.sdk.android.oss.ClientException) {
                throw ((com.alibaba.sdk.android.oss.ClientException) cause);
            }
            if (cause instanceof com.alibaba.sdk.android.oss.ServiceException) {
                throw ((com.alibaba.sdk.android.oss.ServiceException) cause);
            }
            cause.printStackTrace();
            throw new com.alibaba.sdk.android.oss.ClientException("Unexpected exception!" + cause.getMessage());
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isCompleted() {
        return this.future.isDone();
    }

    public void waitUntilFinished() {
        try {
            this.future.get();
        } catch (java.lang.Exception unused) {
        }
    }
}
