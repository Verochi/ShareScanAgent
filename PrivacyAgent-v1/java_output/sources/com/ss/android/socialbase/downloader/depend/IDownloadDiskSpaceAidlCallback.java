package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadDiskSpaceAidlCallback extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
        public void onDiskCleaned() throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback";
        static final int TRANSACTION_onDiskCleaned = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback {
            public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
            public void onDiskCleaned() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.getDefaultImpl().onDiskCleaned();
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback)) ? new com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.Proxy.sDefaultImpl != null || iDownloadDiskSpaceAidlCallback == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.Proxy.sDefaultImpl = iDownloadDiskSpaceAidlCallback;
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
            onDiskCleaned();
            parcel2.writeNoException();
            return true;
        }
    }

    void onDiskCleaned() throws android.os.RemoteException;
}
