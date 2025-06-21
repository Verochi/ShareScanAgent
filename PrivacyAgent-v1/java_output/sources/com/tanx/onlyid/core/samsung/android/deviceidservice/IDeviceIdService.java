package com.tanx.onlyid.core.samsung.android.deviceidservice;

/* loaded from: classes19.dex */
public interface IDeviceIdService extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
        public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
        public java.lang.String getOAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
        public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService {
        private static final java.lang.String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";
        static final int TRANSACTION_getAAID = 3;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getVAID = 2;

        public static class Proxy implements com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService {
            public static com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl().getAAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }

            @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getOAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.getDefaultImpl().getVAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService)) ? new com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService getDefaultImpl() {
            return com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService iDeviceIdService) {
            if (com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceIdService == null) {
                return false;
            }
            com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService.Stub.Proxy.sDefaultImpl = iDeviceIdService;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                java.lang.String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                java.lang.String vaid = getVAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            java.lang.String aaid = getAAID(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getOAID() throws android.os.RemoteException;

    java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException;
}
