package com.igexin.push;

/* loaded from: classes.dex */
public interface GtPushInterface extends android.os.IInterface {

    public static class Default implements com.igexin.push.GtPushInterface {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.igexin.push.GtPushInterface
        public java.lang.String getVersion() throws android.os.RemoteException {
            return null;
        }

        @Override // com.igexin.push.GtPushInterface
        public boolean loadSdk(android.os.Bundle bundle) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.igexin.push.GtPushInterface {
        private static final java.lang.String DESCRIPTOR = "com.igexin.push.GtPushInterface";
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_loadSdk = 2;

        public static class Proxy implements com.igexin.push.GtPushInterface {
            public static com.igexin.push.GtPushInterface sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.igexin.push.GtPushInterface.Stub.DESCRIPTOR;
            }

            @Override // com.igexin.push.GtPushInterface
            public java.lang.String getVersion() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.igexin.push.GtPushInterface.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.igexin.push.GtPushInterface.Stub.getDefaultImpl() != null) {
                        return com.igexin.push.GtPushInterface.Stub.getDefaultImpl().getVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.igexin.push.GtPushInterface
            public boolean loadSdk(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.igexin.push.GtPushInterface.Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.igexin.push.GtPushInterface.Stub.getDefaultImpl() != null) {
                        return com.igexin.push.GtPushInterface.Stub.getDefaultImpl().loadSdk(bundle);
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

        public static com.igexin.push.GtPushInterface asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.igexin.push.GtPushInterface)) ? new com.igexin.push.GtPushInterface.Stub.Proxy(iBinder) : (com.igexin.push.GtPushInterface) queryLocalInterface;
        }

        public static com.igexin.push.GtPushInterface getDefaultImpl() {
            return com.igexin.push.GtPushInterface.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.igexin.push.GtPushInterface gtPushInterface) {
            if (com.igexin.push.GtPushInterface.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (gtPushInterface == null) {
                return false;
            }
            com.igexin.push.GtPushInterface.Stub.Proxy.sDefaultImpl = gtPushInterface;
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
                java.lang.String version = getVersion();
                parcel2.writeNoException();
                parcel2.writeString(version);
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
            boolean loadSdk = loadSdk(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(loadSdk ? 1 : 0);
            return true;
        }
    }

    java.lang.String getVersion() throws android.os.RemoteException;

    boolean loadSdk(android.os.Bundle bundle) throws android.os.RemoteException;
}
