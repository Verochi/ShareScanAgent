package com.google.android.gms.common;

/* loaded from: classes22.dex */
public final class GooglePlayServicesNotAvailableException extends java.lang.Exception {

    @androidx.annotation.RecentlyNonNull
    public final int errorCode;

    public GooglePlayServicesNotAvailableException(@androidx.annotation.RecentlyNonNull int i) {
        this.errorCode = i;
    }
}
