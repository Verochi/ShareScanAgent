package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface ProcessAidlCallback extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.ProcessAidlCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
        public void callback(int i, int i2) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.ProcessAidlCallback {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback";
        static final int TRANSACTION_callback = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.ProcessAidlCallback {
            public static com.ss.android.socialbase.downloader.depend.ProcessAidlCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
            public void callback(int i, int i2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.getDefaultImpl().callback(i, i2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.ProcessAidlCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.ProcessAidlCallback)) ? new com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.ProcessAidlCallback) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.ProcessAidlCallback getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) {
            if (com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.Proxy.sDefaultImpl != null || processAidlCallback == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.Proxy.sDefaultImpl = processAidlCallback;
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
            callback(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void callback(int i, int i2) throws android.os.RemoteException;
}
