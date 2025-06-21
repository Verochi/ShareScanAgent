package com.tanx.onlyid.core.asus.msa.SupplementaryDID;

/* loaded from: classes19.dex */
public interface IDidAidlInterface extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
        public java.lang.String getAAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
        public java.lang.String getOAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
        public java.lang.String getUDID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
        public java.lang.String getVAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface {
        private static final java.lang.String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupport = 1;

        public static class Proxy implements com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface {
            public static com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
            public java.lang.String getAAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl().getAAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
            public java.lang.String getOAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
            public java.lang.String getUDID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl().getUDID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
            public java.lang.String getVAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl().getVAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.getDefaultImpl().isSupport();
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

        public static com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface)) ? new com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface getDefaultImpl() {
            return com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface) {
            if (com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDidAidlInterface == null) {
                return false;
            }
            com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.Proxy.sDefaultImpl = iDidAidlInterface;
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
                boolean isSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(isSupport ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String udid = getUDID();
                parcel2.writeNoException();
                parcel2.writeString(udid);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String vaid = getVAID();
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            java.lang.String aaid = getAAID();
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    java.lang.String getAAID() throws android.os.RemoteException;

    java.lang.String getOAID() throws android.os.RemoteException;

    java.lang.String getUDID() throws android.os.RemoteException;

    java.lang.String getVAID() throws android.os.RemoteException;

    boolean isSupport() throws android.os.RemoteException;
}
