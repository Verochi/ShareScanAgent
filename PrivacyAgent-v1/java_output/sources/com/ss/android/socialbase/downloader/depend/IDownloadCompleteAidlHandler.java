package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadCompleteAidlHandler extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler";
        static final int TRANSACTION_handle = 1;
        static final int TRANSACTION_needHandle = 2;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler {
            public static com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
            public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.getDefaultImpl().handle(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
            public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.getDefaultImpl().needHandle(downloadInfo);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler)) ? new com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler iDownloadCompleteAidlHandler) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.Proxy.sDefaultImpl != null || iDownloadCompleteAidlHandler == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.Proxy.sDefaultImpl = iDownloadCompleteAidlHandler;
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
                handle(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
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
            boolean needHandle = needHandle(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(needHandle ? 1 : 0);
            return true;
        }
    }

    void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;
}
