package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public class AccountAccessor extends com.google.android.gms.common.internal.IAccountAccessor.Stub {
    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.accounts.Account getAccountBinderSafe(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.IAccountAccessor iAccountAccessor) {
        if (iAccountAccessor != null) {
            long clearCallingIdentity = android.os.Binder.clearCallingIdentity();
            try {
                return iAccountAccessor.zza();
            } catch (android.os.RemoteException unused) {
            } finally {
                android.os.Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        throw new java.lang.NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    @androidx.annotation.RecentlyNonNull
    public final android.accounts.Account zza() {
        throw new java.lang.NoSuchMethodError();
    }
}
