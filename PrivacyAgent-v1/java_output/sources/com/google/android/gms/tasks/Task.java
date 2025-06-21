package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public abstract class Task<TResult> {
    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCanceledListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCanceledListener onCanceledListener) {
        throw new java.lang.UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> addOnCompleteListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        throw new java.lang.UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener);

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener);

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnFailureListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener);

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener);

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener);

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.Task<TResult> addOnSuccessListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener);

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWith(@androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWith(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWith is not implemented");
    }

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWithTask(@androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> continueWithTask(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>> continuation) {
        throw new java.lang.UnsupportedOperationException("continueWithTask is not implemented");
    }

    @androidx.annotation.Nullable
    public abstract java.lang.Exception getException();

    public abstract TResult getResult();

    public abstract <X extends java.lang.Throwable> TResult getResult(@androidx.annotation.NonNull java.lang.Class<X> cls) throws java.lang.Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> onSuccessTask(@androidx.annotation.NonNull com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @androidx.annotation.NonNull
    public <TContinuationResult> com.google.android.gms.tasks.Task<TContinuationResult> onSuccessTask(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new java.lang.UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
