package com.hihonor.push.framework.aidl;

/* loaded from: classes22.dex */
public interface IPushCallback extends android.os.IInterface {

    public static class Default implements com.hihonor.push.framework.aidl.IPushCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.push.framework.aidl.IPushCallback
        public void onResult(com.hihonor.push.framework.aidl.DataBuffer dataBuffer) {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.hihonor.push.framework.aidl.IPushCallback {
        private static final java.lang.String DESCRIPTOR = "com.hihonor.push.framework.aidl.IPushCallback";
        public static final int TRANSACTION_onResult = 1;

        public static class Proxy implements com.hihonor.push.framework.aidl.IPushCallback {
            public static com.hihonor.push.framework.aidl.IPushCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.hihonor.push.framework.aidl.IPushCallback.Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.push.framework.aidl.IPushCallback
            public void onResult(com.hihonor.push.framework.aidl.DataBuffer dataBuffer) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.push.framework.aidl.IPushCallback.Stub.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.hihonor.push.framework.aidl.IPushCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.hihonor.push.framework.aidl.IPushCallback.Stub.getDefaultImpl().onResult(dataBuffer);
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

        public static com.hihonor.push.framework.aidl.IPushCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.hihonor.push.framework.aidl.IPushCallback)) ? new com.hihonor.push.framework.aidl.IPushCallback.Stub.Proxy(iBinder) : (com.hihonor.push.framework.aidl.IPushCallback) queryLocalInterface;
        }

        public static com.hihonor.push.framework.aidl.IPushCallback getDefaultImpl() {
            return com.hihonor.push.framework.aidl.IPushCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.hihonor.push.framework.aidl.IPushCallback iPushCallback) {
            if (com.hihonor.push.framework.aidl.IPushCallback.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPushCallback == null) {
                return false;
            }
            com.hihonor.push.framework.aidl.IPushCallback.Stub.Proxy.sDefaultImpl = iPushCallback;
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
            onResult(parcel.readInt() != 0 ? com.hihonor.push.framework.aidl.DataBuffer.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(com.hihonor.push.framework.aidl.DataBuffer dataBuffer);
}
