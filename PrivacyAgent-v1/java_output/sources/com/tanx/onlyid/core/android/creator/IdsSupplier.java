package com.tanx.onlyid.core.android.creator;

/* loaded from: classes19.dex */
public interface IdsSupplier extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.android.creator.IdsSupplier {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
        public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
        public java.lang.String getOAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
        public java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
        public java.lang.String getVAID() throws android.os.RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
        public boolean isSupported() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.android.creator.IdsSupplier {
        private static final java.lang.String DESCRIPTOR = "com.android.creator.IdsSupplier";
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupported = 1;

        public static class Proxy implements com.tanx.onlyid.core.android.creator.IdsSupplier {
            public static com.tanx.onlyid.core.android.creator.IdsSupplier sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
            public java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl().getAAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
            public java.lang.String getOAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
            public java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl().getUDID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
            public java.lang.String getVAID() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl().getVAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.android.creator.IdsSupplier
            public boolean isSupported() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.getDefaultImpl().isSupported();
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

        public static com.tanx.onlyid.core.android.creator.IdsSupplier asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.android.creator.IdsSupplier)) ? new com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.android.creator.IdsSupplier) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.android.creator.IdsSupplier getDefaultImpl() {
            return com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.android.creator.IdsSupplier idsSupplier) {
            if (com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (idsSupplier == null) {
                return false;
            }
            com.tanx.onlyid.core.android.creator.IdsSupplier.Stub.Proxy.sDefaultImpl = idsSupplier;
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
                boolean isSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(isSupported ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String udid = getUDID(parcel.readString());
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
            java.lang.String aaid = getAAID(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    java.lang.String getAAID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getOAID() throws android.os.RemoteException;

    java.lang.String getUDID(java.lang.String str) throws android.os.RemoteException;

    java.lang.String getVAID() throws android.os.RemoteException;

    boolean isSupported() throws android.os.RemoteException;
}
