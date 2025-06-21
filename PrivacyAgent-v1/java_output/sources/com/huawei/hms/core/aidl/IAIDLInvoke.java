package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public interface IAIDLInvoke extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.huawei.hms.core.aidl.IAIDLInvoke {

        public static class a implements com.huawei.hms.core.aidl.IAIDLInvoke {
            public static com.huawei.hms.core.aidl.IAIDLInvoke b;
            private android.os.IBinder a;

            public a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void asyncCall(com.huawei.hms.core.aidl.DataBuffer dataBuffer, com.huawei.hms.core.aidl.IAIDLCallback iAIDLCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iAIDLCallback != null ? iAIDLCallback.asBinder() : null);
                    if (this.a.transact(2, obtain, null, 1) || com.huawei.hms.core.aidl.IAIDLInvoke.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    com.huawei.hms.core.aidl.IAIDLInvoke.Stub.getDefaultImpl().asyncCall(dataBuffer, iAIDLCallback);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void syncCall(com.huawei.hms.core.aidl.DataBuffer dataBuffer) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.a.transact(1, obtain, obtain2, 0) || com.huawei.hms.core.aidl.IAIDLInvoke.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.huawei.hms.core.aidl.IAIDLInvoke.Stub.getDefaultImpl().syncCall(dataBuffer);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLInvoke");
        }

        public static com.huawei.hms.core.aidl.IAIDLInvoke asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.huawei.hms.core.aidl.IAIDLInvoke)) ? new com.huawei.hms.core.aidl.IAIDLInvoke.Stub.a(iBinder) : (com.huawei.hms.core.aidl.IAIDLInvoke) queryLocalInterface;
        }

        public static com.huawei.hms.core.aidl.IAIDLInvoke getDefaultImpl() {
            return com.huawei.hms.core.aidl.IAIDLInvoke.Stub.a.b;
        }

        public static boolean setDefaultImpl(com.huawei.hms.core.aidl.IAIDLInvoke iAIDLInvoke) {
            if (com.huawei.hms.core.aidl.IAIDLInvoke.Stub.a.b != null || iAIDLInvoke == null) {
                return false;
            }
            com.huawei.hms.core.aidl.IAIDLInvoke.Stub.a.b = iAIDLInvoke;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                syncCall(parcel.readInt() != 0 ? com.huawei.hms.core.aidl.DataBuffer.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                asyncCall(parcel.readInt() != 0 ? com.huawei.hms.core.aidl.DataBuffer.CREATOR.createFromParcel(parcel) : null, com.huawei.hms.core.aidl.IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
            return true;
        }
    }

    void asyncCall(com.huawei.hms.core.aidl.DataBuffer dataBuffer, com.huawei.hms.core.aidl.IAIDLCallback iAIDLCallback) throws android.os.RemoteException;

    void syncCall(com.huawei.hms.core.aidl.DataBuffer dataBuffer) throws android.os.RemoteException;
}
