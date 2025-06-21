package com.vivo.vms;

/* loaded from: classes19.dex */
public interface IPCInvoke extends android.os.IInterface {

    public static class Default implements com.vivo.vms.IPCInvoke {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCInvoke
        public android.os.Bundle asyncCall(android.os.Bundle bundle, com.vivo.vms.IPCCallback iPCCallback) {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.vivo.vms.IPCInvoke {
        private static final java.lang.String DESCRIPTOR = "com.vivo.vms.IPCInvoke";
        static final int TRANSACTION_asyncCall = 1;

        public static class Proxy implements com.vivo.vms.IPCInvoke {
            public static com.vivo.vms.IPCInvoke sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCInvoke
            public android.os.Bundle asyncCall(android.os.Bundle bundle, com.vivo.vms.IPCCallback iPCCallback) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.vivo.vms.IPCInvoke.Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPCCallback != null ? iPCCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.vivo.vms.IPCInvoke.Stub.getDefaultImpl() != null) {
                        return com.vivo.vms.IPCInvoke.Stub.getDefaultImpl().asyncCall(bundle, iPCCallback);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.vivo.vms.IPCInvoke.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.vivo.vms.IPCInvoke asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.vivo.vms.IPCInvoke)) ? new com.vivo.vms.IPCInvoke.Stub.Proxy(iBinder) : (com.vivo.vms.IPCInvoke) queryLocalInterface;
        }

        public static com.vivo.vms.IPCInvoke getDefaultImpl() {
            return com.vivo.vms.IPCInvoke.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.vivo.vms.IPCInvoke iPCInvoke) {
            if (com.vivo.vms.IPCInvoke.Stub.Proxy.sDefaultImpl != null || iPCInvoke == null) {
                return false;
            }
            com.vivo.vms.IPCInvoke.Stub.Proxy.sDefaultImpl = iPCInvoke;
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
            android.os.Bundle asyncCall = asyncCall(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null, com.vivo.vms.IPCCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            if (asyncCall != null) {
                parcel2.writeInt(1);
                asyncCall.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    android.os.Bundle asyncCall(android.os.Bundle bundle, com.vivo.vms.IPCCallback iPCCallback);
}
