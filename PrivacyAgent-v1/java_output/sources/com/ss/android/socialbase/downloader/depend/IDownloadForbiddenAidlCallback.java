package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadForbiddenAidlCallback extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public boolean hasCallback() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public void onCallback(java.util.List<java.lang.String> list) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback";
        static final int TRANSACTION_hasCallback = 2;
        static final int TRANSACTION_onCallback = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback {
            public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public boolean hasCallback() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.getDefaultImpl().hasCallback();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public void onCallback(java.util.List<java.lang.String> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.getDefaultImpl().onCallback(list);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback)) ? new com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.Proxy.sDefaultImpl != null || iDownloadForbiddenAidlCallback == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.Proxy.sDefaultImpl = iDownloadForbiddenAidlCallback;
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
                onCallback(parcel.createStringArrayList());
                parcel2.writeNoException();
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
            boolean hasCallback = hasCallback();
            parcel2.writeNoException();
            parcel2.writeInt(hasCallback ? 1 : 0);
            return true;
        }
    }

    boolean hasCallback() throws android.os.RemoteException;

    void onCallback(java.util.List<java.lang.String> list) throws android.os.RemoteException;
}
