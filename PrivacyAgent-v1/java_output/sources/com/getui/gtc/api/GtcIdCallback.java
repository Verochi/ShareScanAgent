package com.getui.gtc.api;

/* loaded from: classes22.dex */
public interface GtcIdCallback extends android.os.IInterface {

    public static class Default implements com.getui.gtc.api.GtcIdCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public void onFailure(java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public void onSuccess(java.lang.String str) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.getui.gtc.api.GtcIdCallback {
        private static final java.lang.String DESCRIPTOR = "com.getui.gtc.api.GtcIdCallback";
        static final int TRANSACTION_onFailure = 1;
        static final int TRANSACTION_onSuccess = 2;

        public static class Proxy implements com.getui.gtc.api.GtcIdCallback {
            public static com.getui.gtc.api.GtcIdCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.getui.gtc.api.GtcIdCallback.Stub.DESCRIPTOR;
            }

            @Override // com.getui.gtc.api.GtcIdCallback
            public void onFailure(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.getui.gtc.api.GtcIdCallback.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.getui.gtc.api.GtcIdCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.getui.gtc.api.GtcIdCallback.Stub.getDefaultImpl().onFailure(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.getui.gtc.api.GtcIdCallback
            public void onSuccess(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.getui.gtc.api.GtcIdCallback.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.getui.gtc.api.GtcIdCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.getui.gtc.api.GtcIdCallback.Stub.getDefaultImpl().onSuccess(str);
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

        public static com.getui.gtc.api.GtcIdCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.getui.gtc.api.GtcIdCallback)) ? new com.getui.gtc.api.GtcIdCallback.Stub.Proxy(iBinder) : (com.getui.gtc.api.GtcIdCallback) queryLocalInterface;
        }

        public static com.getui.gtc.api.GtcIdCallback getDefaultImpl() {
            return com.getui.gtc.api.GtcIdCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.getui.gtc.api.GtcIdCallback gtcIdCallback) {
            if (com.getui.gtc.api.GtcIdCallback.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (gtcIdCallback == null) {
                return false;
            }
            com.getui.gtc.api.GtcIdCallback.Stub.Proxy.sDefaultImpl = gtcIdCallback;
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
                onFailure(parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailure(java.lang.String str) throws android.os.RemoteException;

    void onSuccess(java.lang.String str) throws android.os.RemoteException;
}
