package com.google.android.gms.common;

/* loaded from: classes22.dex */
public class UserRecoverableException extends java.lang.Exception {
    private final android.content.Intent zza;

    public UserRecoverableException(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.content.Intent intent) {
        super(str);
        this.zza = intent;
    }

    @androidx.annotation.RecentlyNonNull
    public android.content.Intent getIntent() {
        return new android.content.Intent(this.zza);
    }
}
