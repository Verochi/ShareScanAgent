package com.tanx.onlyid.core.uodis.opendevice.aidl;

/* loaded from: classes19.dex */
public interface OpenDeviceIdentifierService extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public java.lang.String getOaid() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public boolean isOaidTrackLimited() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService {
        private static final java.lang.String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        static final int TRANSACTION_getOaid = 1;
        static final int TRANSACTION_isOaidTrackLimited = 2;

        public static class Proxy implements com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService {
            public static com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }

            @Override // com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public java.lang.String getOaid() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.getDefaultImpl().getOaid();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.getDefaultImpl().isOaidTrackLimited();
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
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService)) ? new com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService getDefaultImpl() {
            return com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService openDeviceIdentifierService) {
            if (com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (openDeviceIdentifierService == null) {
                return false;
            }
            com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.Proxy.sDefaultImpl = openDeviceIdentifierService;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                java.lang.String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean isOaidTrackLimited = isOaidTrackLimited();
            parcel2.writeNoException();
            parcel2.writeInt(isOaidTrackLimited ? 1 : 0);
            return true;
        }
    }

    java.lang.String getOaid() throws android.os.RemoteException;

    boolean isOaidTrackLimited() throws android.os.RemoteException;
}
