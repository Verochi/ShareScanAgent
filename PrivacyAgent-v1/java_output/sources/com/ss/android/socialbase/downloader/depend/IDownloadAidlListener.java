package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadAidlListener extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadAidlListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public int getOriginHashCode() throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadAidlListener {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener";
        static final int TRANSACTION_getOriginHashCode = 1;
        static final int TRANSACTION_onCanceled = 8;
        static final int TRANSACTION_onFailed = 7;
        static final int TRANSACTION_onFirstStart = 9;
        static final int TRANSACTION_onFirstSuccess = 10;
        static final int TRANSACTION_onPause = 5;
        static final int TRANSACTION_onPrepare = 2;
        static final int TRANSACTION_onProgress = 4;
        static final int TRANSACTION_onRetry = 11;
        static final int TRANSACTION_onRetryDelay = 12;
        static final int TRANSACTION_onStart = 3;
        static final int TRANSACTION_onSuccessed = 6;
        static final int TRANSACTION_onWaitingDownloadCompleteHandler = 13;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadAidlListener {
            public static com.ss.android.socialbase.downloader.depend.IDownloadAidlListener sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public int getOriginHashCode() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().getOriginHashCode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onCanceled(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onFailed(downloadInfo, baseException);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onFirstStart(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onFirstSuccess(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onPause(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onPrepare(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onProgress(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onRetry(downloadInfo, baseException);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onRetryDelay(downloadInfo, baseException);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onStart(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onSuccessed(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.getDefaultImpl().onWaitingDownloadCompleteHandler(downloadInfo);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadAidlListener)) ? new com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadAidlListener) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.Proxy.sDefaultImpl != null || iDownloadAidlListener == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.Proxy.sDefaultImpl = iDownloadAidlListener;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int originHashCode = getOriginHashCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(originHashCode);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrepare(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onStart(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onProgress(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPause(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSuccessed(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFailed(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.exception.BaseException.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCanceled(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFirstStart(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFirstSuccess(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRetry(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.exception.BaseException.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRetryDelay(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.exception.BaseException.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    onWaitingDownloadCompleteHandler(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int getOriginHashCode() throws android.os.RemoteException;

    void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException;

    void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException;

    void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException;

    void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;
}
