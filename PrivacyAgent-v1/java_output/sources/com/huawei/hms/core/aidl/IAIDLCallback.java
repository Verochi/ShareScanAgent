package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public interface IAIDLCallback extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.huawei.hms.core.aidl.IAIDLCallback {
        private static final java.lang.String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";
        static final int TRANSACTION_call = 1;

        public static class a implements com.huawei.hms.core.aidl.IAIDLCallback {
            public static com.huawei.hms.core.aidl.IAIDLCallback b;
            private android.os.IBinder a;

            public a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.huawei.hms.core.aidl.IAIDLCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.huawei.hms.core.aidl.IAIDLCallback)) ? new com.huawei.hms.core.aidl.IAIDLCallback.Stub.a(iBinder) : (com.huawei.hms.core.aidl.IAIDLCallback) queryLocalInterface;
        }

        public static com.huawei.hms.core.aidl.IAIDLCallback getDefaultImpl() {
            return com.huawei.hms.core.aidl.IAIDLCallback.Stub.a.b;
        }

        public static boolean setDefaultImpl(com.huawei.hms.core.aidl.IAIDLCallback iAIDLCallback) {
            if (com.huawei.hms.core.aidl.IAIDLCallback.Stub.a.b != null || iAIDLCallback == null) {
                return false;
            }
            com.huawei.hms.core.aidl.IAIDLCallback.Stub.a.b = iAIDLCallback;
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
                call(parcel.readInt() != 0 ? com.huawei.hms.core.aidl.DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void call(com.huawei.hms.core.aidl.DataBuffer dataBuffer) throws android.os.RemoteException;
}
