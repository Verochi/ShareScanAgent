package com.tanx.onlyid.core.coolpad.deviceidsupport;

/* loaded from: classes19.dex */
public interface IDeviceIdManager extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getCoolOsVersion() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getIMEI(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getOAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager {
        private static final java.lang.String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getAAID = 4;
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getIMEI = 5;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_getUDID = 1;
        static final int TRANSACTION_getVAID = 3;
        static final int TRANSACTION_isCoolOs = 6;

        public static class Proxy implements com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager {
            public static com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getAAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getCoolOsVersion() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getCoolOsVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getIMEI(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getIMEI(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getOAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getOAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getUDID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().getVAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.getDefaultImpl().isCoolOs();
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

        public static com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager)) ? new com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager getDefaultImpl() {
            return com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager iDeviceIdManager) {
            if (com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceIdManager == null) {
                return false;
            }
            com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.Proxy.sDefaultImpl = iDeviceIdManager;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String udid = getUDID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String oaid = getOAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String imei = getIMEI(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isCoolOs = isCoolOs();
                    parcel2.writeNoException();
                    parcel2.writeInt(isCoolOs ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String coolOsVersion = getCoolOsVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(coolOsVersion);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getCoolOsVersion() throws android.os.RemoteException;

    java.lang.String getIMEI(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getOAID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException;

    boolean isCoolOs() throws android.os.RemoteException;
}
