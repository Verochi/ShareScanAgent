package com.google.android.gms.common;

/* loaded from: classes22.dex */
public class GooglePlayServicesRepairableException extends com.google.android.gms.common.UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.content.Intent intent) {
        super(str, intent);
        this.zza = i;
    }

    @androidx.annotation.RecentlyNonNull
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
