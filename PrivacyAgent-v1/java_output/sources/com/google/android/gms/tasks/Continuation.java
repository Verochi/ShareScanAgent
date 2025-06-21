package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) throws java.lang.Exception;
}
