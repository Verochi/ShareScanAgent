package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public class TaskCompletionSource<TResult> {
    public final com.google.android.gms.tasks.zzu<TResult> a = new com.google.android.gms.tasks.zzu<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(@androidx.annotation.NonNull com.google.android.gms.tasks.CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new com.google.android.gms.tasks.zzs(this));
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<TResult> getTask() {
        return this.a;
    }

    public void setException(@androidx.annotation.NonNull java.lang.Exception exc) {
        this.a.a(exc);
    }

    public void setResult(@androidx.annotation.Nullable TResult tresult) {
        this.a.b(tresult);
    }

    public boolean trySetException(@androidx.annotation.NonNull java.lang.Exception exc) {
        return this.a.e(exc);
    }

    public boolean trySetResult(@androidx.annotation.Nullable TResult tresult) {
        return this.a.f(tresult);
    }
}
