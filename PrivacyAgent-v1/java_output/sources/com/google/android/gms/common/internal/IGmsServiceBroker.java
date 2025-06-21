package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public interface IGmsServiceBroker extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.google.android.gms.common.internal.IGmsServiceBroker {

        public static class zza implements com.google.android.gms.common.internal.IGmsServiceBroker {
            private final android.os.IBinder zza;

            public zza(android.os.IBinder iBinder) {
                this.zza = iBinder;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.zza;
            }

            @Override // com.google.android.gms.common.internal.IGmsServiceBroker
            public final void getService(com.google.android.gms.common.internal.IGmsCallbacks iGmsCallbacks, @androidx.annotation.Nullable com.google.android.gms.common.internal.GetServiceRequest getServiceRequest) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        @androidx.annotation.RecentlyNonNull
        public boolean onTransact(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.Nullable android.os.Parcel parcel2, @androidx.annotation.RecentlyNonNull int i2) throws android.os.RemoteException {
            com.google.android.gms.common.internal.IGmsCallbacks zzpVar;
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            android.os.IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzpVar = null;
            } else {
                android.os.IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                zzpVar = queryLocalInterface instanceof com.google.android.gms.common.internal.IGmsCallbacks ? (com.google.android.gms.common.internal.IGmsCallbacks) queryLocalInterface : new com.google.android.gms.common.internal.zzp(readStrongBinder);
            }
            if (i == 46) {
                getService(zzpVar, parcel.readInt() != 0 ? com.google.android.gms.common.internal.GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
                ((android.os.Parcel) com.google.android.gms.common.internal.Preconditions.checkNotNull(parcel2)).writeNoException();
                return true;
            }
            if (i == 47) {
                if (parcel.readInt() != 0) {
                    com.google.android.gms.common.internal.zzx.CREATOR.createFromParcel(parcel);
                }
                throw new java.lang.UnsupportedOperationException();
            }
            parcel.readInt();
            if (i != 4) {
                parcel.readString();
            }
            if (i != 1) {
                if (i != 2 && i != 23 && i != 25 && i != 27) {
                    if (i != 30) {
                        if (i == 34) {
                            parcel.readString();
                        } else if (i != 41 && i != 43 && i != 37 && i != 38) {
                            switch (i) {
                                case 9:
                                    parcel.readString();
                                    parcel.createStringArray();
                                    parcel.readString();
                                    parcel.readStrongBinder();
                                    parcel.readString();
                                    if (parcel.readInt() != 0) {
                                        break;
                                    }
                                    break;
                                case 10:
                                    parcel.readString();
                                    parcel.createStringArray();
                                    break;
                                case 19:
                                    parcel.readStrongBinder();
                                    if (parcel.readInt() != 0) {
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                    }
                }
                if (parcel.readInt() != 0) {
                }
            } else {
                parcel.readString();
                parcel.createStringArray();
                parcel.readString();
                if (parcel.readInt() != 0) {
                }
            }
            throw new java.lang.UnsupportedOperationException();
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    void getService(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.IGmsCallbacks iGmsCallbacks, @androidx.annotation.Nullable com.google.android.gms.common.internal.GetServiceRequest getServiceRequest) throws android.os.RemoteException;
}
