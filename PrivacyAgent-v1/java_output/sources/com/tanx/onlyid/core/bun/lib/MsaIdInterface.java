package com.tanx.onlyid.core.bun.lib;

/* loaded from: classes19.dex */
public interface MsaIdInterface extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.bun.lib.MsaIdInterface {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public java.lang.String getAAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public java.lang.String getOAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public java.lang.String getVAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public boolean isDataArrived() throws android.os.RemoteException {
            return false;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public boolean isSupported() throws android.os.RemoteException {
            return false;
        }

        @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
        public void shutDown() throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.bun.lib.MsaIdInterface {
        private static final java.lang.String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isDataArrived = 2;
        static final int TRANSACTION_isSupported = 1;
        static final int TRANSACTION_shutDown = 6;

        public static class Proxy implements com.tanx.onlyid.core.bun.lib.MsaIdInterface {
            public static com.tanx.onlyid.core.bun.lib.MsaIdInterface sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public java.lang.String getAAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().getAAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public java.lang.String getOAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public java.lang.String getVAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().getVAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public boolean isDataArrived() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().isDataArrived();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public boolean isSupported() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().isSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.bun.lib.MsaIdInterface
            public void shutDown() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.getDefaultImpl().shutDown();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tanx.onlyid.core.bun.lib.MsaIdInterface asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.bun.lib.MsaIdInterface)) ? new com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.bun.lib.MsaIdInterface) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.bun.lib.MsaIdInterface getDefaultImpl() {
            return com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.bun.lib.MsaIdInterface msaIdInterface) {
            if (com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (msaIdInterface == null) {
                return false;
            }
            com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.Proxy.sDefaultImpl = msaIdInterface;
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
                    boolean isSupported = isSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSupported ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDataArrived = isDataArrived();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDataArrived ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String vaid = getVAID();
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String aaid = getAAID();
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    shutDown();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String getAAID() throws android.os.RemoteException;

    java.lang.String getOAID() throws android.os.RemoteException;

    java.lang.String getVAID() throws android.os.RemoteException;

    boolean isDataArrived() throws android.os.RemoteException;

    boolean isSupported() throws android.os.RemoteException;

    void shutDown() throws android.os.RemoteException;
}
