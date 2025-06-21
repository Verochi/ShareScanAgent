package com.tanx.onlyid.core.heytap.openid;

/* loaded from: classes19.dex */
public interface IOpenID extends android.os.IInterface {

    public static class Default implements com.tanx.onlyid.core.heytap.openid.IOpenID {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.heytap.openid.IOpenID
        public java.lang.String getSerID(java.lang.String str, java.lang.String str2, java.lang.String str3) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tanx.onlyid.core.heytap.openid.IOpenID {
        private static final java.lang.String DESCRIPTOR = "com.heytap.openid.IOpenID";
        static final int TRANSACTION_getSerID = 1;

        public static class Proxy implements com.tanx.onlyid.core.heytap.openid.IOpenID {
            public static com.tanx.onlyid.core.heytap.openid.IOpenID sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.DESCRIPTOR;
            }

            @Override // com.tanx.onlyid.core.heytap.openid.IOpenID
            public java.lang.String getSerID(java.lang.String str, java.lang.String str2, java.lang.String str3) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.getDefaultImpl() != null) {
                        return com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.getDefaultImpl().getSerID(str, str2, str3);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tanx.onlyid.core.heytap.openid.IOpenID asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.tanx.onlyid.core.heytap.openid.IOpenID)) ? new com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.Proxy(iBinder) : (com.tanx.onlyid.core.heytap.openid.IOpenID) queryLocalInterface;
        }

        public static com.tanx.onlyid.core.heytap.openid.IOpenID getDefaultImpl() {
            return com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tanx.onlyid.core.heytap.openid.IOpenID iOpenID) {
            if (com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.Proxy.sDefaultImpl != null || iOpenID == null) {
                return false;
            }
            com.tanx.onlyid.core.heytap.openid.IOpenID.Stub.Proxy.sDefaultImpl = iOpenID;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            java.lang.String serID = getSerID(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(serID);
            return true;
        }
    }

    java.lang.String getSerID(java.lang.String str, java.lang.String str2, java.lang.String str3) throws android.os.RemoteException;
}
