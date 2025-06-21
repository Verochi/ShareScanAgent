package com.google.firebase;

/* loaded from: classes22.dex */
public class FirebaseException extends java.lang.Exception {
    @java.lang.Deprecated
    public FirebaseException() {
    }

    public FirebaseException(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        super(com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str, "Detail message must not be empty"));
    }

    public FirebaseException(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        super(com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str, "Detail message must not be empty"), th);
    }
}
