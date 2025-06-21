package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public abstract class zzq extends com.google.android.gms.internal.common.zza implements com.google.android.gms.common.internal.zzr {
    public static com.google.android.gms.common.internal.zzr zza(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof com.google.android.gms.common.internal.zzr ? (com.google.android.gms.common.internal.zzr) queryLocalInterface : new com.google.android.gms.common.internal.zzs(iBinder);
    }
}
