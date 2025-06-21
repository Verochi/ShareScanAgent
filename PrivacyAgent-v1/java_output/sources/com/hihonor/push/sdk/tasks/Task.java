package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public abstract class Task<TResult> {
    public com.hihonor.push.sdk.tasks.Task<TResult> addOnCanceledListener(com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public com.hihonor.push.sdk.tasks.Task<TResult> addOnCanceledListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public com.hihonor.push.sdk.tasks.Task<TResult> addOnCompleteListener(com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public com.hihonor.push.sdk.tasks.Task<TResult> addOnCompleteListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract com.hihonor.push.sdk.tasks.Task<TResult> addOnFailureListener(com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener);

    public abstract com.hihonor.push.sdk.tasks.Task<TResult> addOnFailureListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnFailureListener onFailureListener);

    public abstract com.hihonor.push.sdk.tasks.Task<TResult> addOnSuccessListener(com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener);

    public abstract com.hihonor.push.sdk.tasks.Task<TResult> addOnSuccessListener(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.OnSuccessListener<TResult> onSuccessListener);

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> continueWith(com.hihonor.push.sdk.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> continueWith(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> continueWithTask(com.hihonor.push.sdk.tasks.Continuation<TResult, com.hihonor.push.sdk.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> continueWithTask(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.Continuation<TResult, com.hihonor.push.sdk.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract java.lang.Exception getException();

    public abstract TResult getResult();

    public abstract <E extends java.lang.Throwable> TResult getResultThrowException(java.lang.Class<E> cls) throws java.lang.Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> onSuccessTask(com.hihonor.push.sdk.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> com.hihonor.push.sdk.tasks.Task<TContinuationResult> onSuccessTask(java.util.concurrent.Executor executor, com.hihonor.push.sdk.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
