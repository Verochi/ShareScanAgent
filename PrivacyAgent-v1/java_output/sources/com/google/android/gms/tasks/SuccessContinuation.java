package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    @androidx.annotation.NonNull
    com.google.android.gms.tasks.Task<TContinuationResult> then(TResult tresult) throws java.lang.Exception;
}
