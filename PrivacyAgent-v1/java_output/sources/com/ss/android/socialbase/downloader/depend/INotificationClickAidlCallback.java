package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface INotificationClickAidlCallback extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback";
        static final int TRANSACTION_onClickWhenInstalled = 3;
        static final int TRANSACTION_onClickWhenSuccess = 2;
        static final int TRANSACTION_onClickWhenUnSuccess = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback {
            public static com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl().onClickWhenInstalled(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl().onClickWhenSuccess(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.getDefaultImpl().onClickWhenUnSuccess(downloadInfo);
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

        public static com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback)) ? new com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback iNotificationClickAidlCallback) {
            if (com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.Proxy.sDefaultImpl != null || iNotificationClickAidlCallback == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.Proxy.sDefaultImpl = iNotificationClickAidlCallback;
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
                boolean onClickWhenUnSuccess = onClickWhenUnSuccess(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(onClickWhenUnSuccess ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean onClickWhenSuccess = onClickWhenSuccess(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(onClickWhenSuccess ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean onClickWhenInstalled = onClickWhenInstalled(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(onClickWhenInstalled ? 1 : 0);
            return true;
        }
    }

    boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;
}
