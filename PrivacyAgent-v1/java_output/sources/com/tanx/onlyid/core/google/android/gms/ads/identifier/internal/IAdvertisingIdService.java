package com.tanx.onlyid.core.google.android.gms.ads.identifier.internal;

/* loaded from: classes19.dex */
public interface IAdvertisingIdService extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public java.lang.String getId() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService {
        private static final java.lang.String DESCRIPTOR = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        static final int TRANSACTION_getId = 1;
        static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        public static class Proxy implements com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService {
            public static com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public java.lang.String getId() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.getDefaultImpl().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.getDefaultImpl().isLimitAdTrackingEnabled(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService)) ? new com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService getDefaultImpl() {
            return com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService iAdvertisingIdService) {
            if (com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAdvertisingIdService == null) {
                return false;
            }
            com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.Proxy.sDefaultImpl = iAdvertisingIdService;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }
    }

    java.lang.String getId() throws android.os.RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z) throws android.os.RemoteException;
}
