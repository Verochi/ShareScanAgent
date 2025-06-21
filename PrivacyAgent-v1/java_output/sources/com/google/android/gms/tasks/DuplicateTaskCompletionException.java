package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public final class DuplicateTaskCompletionException extends java.lang.IllegalStateException {
    private DuplicateTaskCompletionException(java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th) {
        super(str, th);
    }

    public static java.lang.IllegalStateException of(com.google.android.gms.tasks.Task<?> task) {
        java.lang.String str;
        if (!task.isComplete()) {
            return new java.lang.IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        java.lang.Exception exception = task.getException();
        if (exception != null) {
            str = "failure";
        } else if (task.isSuccessful()) {
            java.lang.String valueOf = java.lang.String.valueOf(task.getResult());
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 7);
            sb.append("result ");
            sb.append(valueOf);
            str = sb.toString();
        } else {
            str = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(str);
        return new com.google.android.gms.tasks.DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new java.lang.String("Complete with: "), exception);
    }
}
