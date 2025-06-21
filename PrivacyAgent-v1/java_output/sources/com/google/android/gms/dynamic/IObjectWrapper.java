package com.google.android.gms.dynamic;

/* loaded from: classes22.dex */
public interface IObjectWrapper extends android.os.IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements com.google.android.gms.dynamic.IObjectWrapper {

        public static class zza extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.dynamic.IObjectWrapper {
            public zza(android.os.IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @androidx.annotation.RecentlyNonNull
        public static com.google.android.gms.dynamic.IObjectWrapper asInterface(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof com.google.android.gms.dynamic.IObjectWrapper ? (com.google.android.gms.dynamic.IObjectWrapper) queryLocalInterface : new com.google.android.gms.dynamic.IObjectWrapper.Stub.zza(iBinder);
        }
    }
}
