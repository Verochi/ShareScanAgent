package com.vivo.vms;

/* loaded from: classes19.dex */
public interface IPCCallback extends android.os.IInterface {

    public static class Default implements com.vivo.vms.IPCCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCCallback
        public void call(android.os.Bundle bundle) {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.vivo.vms.IPCCallback {
        private static final java.lang.String DESCRIPTOR = "com.vivo.vms.IPCCallback";
        static final int TRANSACTION_call = 1;

        public static class Proxy implements com.vivo.vms.IPCCallback {
            public static com.vivo.vms.IPCCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCCallback
            public void call(android.os.Bundle bundle) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.vivo.vms.IPCCallback.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.vivo.vms.IPCCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle.readFromParcel(obtain2);
                        }
                    } else {
                        com.vivo.vms.IPCCallback.Stub.getDefaultImpl().call(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.vivo.vms.IPCCallback.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.vivo.vms.IPCCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.vivo.vms.IPCCallback)) ? new com.vivo.vms.IPCCallback.Stub.Proxy(iBinder) : (com.vivo.vms.IPCCallback) queryLocalInterface;
        }

        public static com.vivo.vms.IPCCallback getDefaultImpl() {
            return com.vivo.vms.IPCCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.vivo.vms.IPCCallback iPCCallback) {
            if (com.vivo.vms.IPCCallback.Stub.Proxy.sDefaultImpl != null || iPCCallback == null) {
                return false;
            }
            com.vivo.vms.IPCCallback.Stub.Proxy.sDefaultImpl = iPCCallback;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            android.os.Bundle bundle = new android.os.Bundle();
            call(bundle);
            parcel2.writeNoException();
            parcel2.writeInt(1);
            bundle.writeToParcel(parcel2, 1);
            return true;
        }
    }

    void call(android.os.Bundle bundle);
}
