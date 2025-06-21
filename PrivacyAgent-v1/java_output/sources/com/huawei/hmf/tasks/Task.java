package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public abstract class Task<TResult> {
    public com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(android.app.Activity activity, com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public com.huawei.hmf.tasks.Task<TResult> addOnCanceledListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(android.app.Activity activity, com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public com.huawei.hmf.tasks.Task<TResult> addOnCompleteListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(android.app.Activity activity, com.huawei.hmf.tasks.OnFailureListener onFailureListener);

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(com.huawei.hmf.tasks.OnFailureListener onFailureListener);

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnFailureListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnFailureListener onFailureListener);

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(android.app.Activity activity, com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener);

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener);

    public abstract com.huawei.hmf.tasks.Task<TResult> addOnSuccessListener(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.OnSuccessListener<TResult> onSuccessListener);

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWith(com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWith(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWithTask(com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> continueWithTask(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract java.lang.Exception getException();

    public abstract TResult getResult();

    public abstract <E extends java.lang.Throwable> TResult getResultThrowException(java.lang.Class<E> cls) throws java.lang.Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> onSuccessTask(com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> com.huawei.hmf.tasks.Task<TContinuationResult> onSuccessTask(java.util.concurrent.Executor executor, com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
