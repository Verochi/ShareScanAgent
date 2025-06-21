package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public interface ICancelToken extends android.os.IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements com.google.android.gms.common.internal.ICancelToken {

        public static class zza extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.common.internal.ICancelToken {
            public zza(android.os.IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
            }

            @Override // com.google.android.gms.common.internal.ICancelToken
            public final void cancel() throws android.os.RemoteException {
                zzc(2, a_());
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        @androidx.annotation.RecentlyNonNull
        public static com.google.android.gms.common.internal.ICancelToken asInterface(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return queryLocalInterface instanceof com.google.android.gms.common.internal.ICancelToken ? (com.google.android.gms.common.internal.ICancelToken) queryLocalInterface : new com.google.android.gms.common.internal.ICancelToken.Stub.zza(iBinder);
        }
    }

    void cancel() throws android.os.RemoteException;
}
