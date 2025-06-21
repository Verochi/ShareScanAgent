package com.google.firebase;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class FirebaseExceptionMapper implements com.google.android.gms.common.api.internal.StatusExceptionMapper {
    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    @androidx.annotation.RecentlyNonNull
    public java.lang.Exception getException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status) {
        return status.getStatusCode() == 8 ? new com.google.firebase.FirebaseException(status.zza()) : new com.google.firebase.FirebaseApiNotAvailableException(status.zza());
    }
}
