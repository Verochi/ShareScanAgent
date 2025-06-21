package com.tanx.onlyid.core.zui.deviceidservice;

/* loaded from: classes19.dex */
public interface IDeviceidInterface extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public java.lang.String createAAIDForPackageName(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public java.lang.String getOAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public java.lang.String getUDID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public boolean isSupport() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface {
        private static final java.lang.String DESCRIPTOR = "com.zui.deviceidservice.IDeviceidInterface";
        static final int TRANSACTION_createAAIDForPackageName = 6;
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupport = 3;

        public static class Proxy implements com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface {
            public static com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public java.lang.String createAAIDForPackageName(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().createAAIDForPackageName(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().getAAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return "com.zui.deviceidservice.IDeviceidInterface";
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getOAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getUDID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().getUDID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().getVAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.getDefaultImpl().isSupport();
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
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface)) ? new com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface getDefaultImpl() {
            return com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface iDeviceidInterface) {
            if (com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceidInterface == null) {
                return false;
            }
            com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.Proxy.sDefaultImpl = iDeviceidInterface;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    java.lang.String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 2:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    java.lang.String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    boolean isSupport = isSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSupport ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    java.lang.String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    java.lang.String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    java.lang.String createAAIDForPackageName = createAAIDForPackageName(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(createAAIDForPackageName);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String createAAIDForPackageName(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getOAID() throws android.os.RemoteException;

    java.lang.String getUDID() throws android.os.RemoteException;

    java.lang.String getVAID(java.lang.String str) throws android.os.RemoteException;

    boolean isSupport() throws android.os.RemoteException;
}
