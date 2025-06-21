package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public interface DownloadAidlTask extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.model.DownloadAidlTask {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator getChunkStrategy() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend getDepend() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadListenerSize(int i) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getFileProvider() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler getForbiddenHandler() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor getInterceptor() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend getMonitorDepend() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getSingleDownloadListener(int i) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.model.DownloadAidlTask {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getChunkStrategy = 2;
        static final int TRANSACTION_getDepend = 9;
        static final int TRANSACTION_getDiskSpaceHandler = 12;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 16;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 15;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByIndex = 4;
        static final int TRANSACTION_getDownloadListenerSize = 3;
        static final int TRANSACTION_getDownloadNotificationEventListener = 6;
        static final int TRANSACTION_getFileProvider = 14;
        static final int TRANSACTION_getForbiddenHandler = 10;
        static final int TRANSACTION_getInterceptor = 8;
        static final int TRANSACTION_getMonitorDepend = 13;
        static final int TRANSACTION_getNotificationClickCallback = 7;
        static final int TRANSACTION_getRetryDelayTimeCalculator = 11;
        static final int TRANSACTION_getSingleDownloadListener = 5;

        public static class Proxy implements com.ss.android.socialbase.downloader.model.DownloadAidlTask {
            public static com.ss.android.socialbase.downloader.model.DownloadAidlTask sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator getChunkStrategy() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getChunkStrategy();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend getDepend() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDepend();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDiskSpaceHandler();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(i);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadCompleteHandlerSize();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadListenerByIndex(i, i2);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadListenerSize(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadListenerSize(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getDownloadNotificationEventListener();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getFileProvider() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getFileProvider();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler getForbiddenHandler() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getForbiddenHandler();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor getInterceptor() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getInterceptor();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend getMonitorDepend() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getMonitorDepend();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getNotificationClickCallback();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getRetryDelayTimeCalculator();
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getSingleDownloadListener(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.getDefaultImpl().getSingleDownloadListener(i);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.model.DownloadAidlTask asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.model.DownloadAidlTask)) ? new com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.model.DownloadAidlTask) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.model.DownloadAidlTask getDefaultImpl() {
            return com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) {
            if (com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.Proxy.sDefaultImpl != null || downloadAidlTask == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.Proxy.sDefaultImpl = downloadAidlTask;
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
                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo();
                    parcel2.writeNoException();
                    if (downloadInfo != null) {
                        parcel2.writeInt(1);
                        downloadInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator chunkStrategy = getChunkStrategy();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(chunkStrategy != null ? chunkStrategy.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadListenerSize = getDownloadListenerSize(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadListenerSize);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlListener downloadListenerByIndex = getDownloadListenerByIndex(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadListenerByIndex != null ? downloadListenerByIndex.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlListener singleDownloadListener = getSingleDownloadListener(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(singleDownloadListener != null ? singleDownloadListener.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor interceptor = getInterceptor();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(interceptor != null ? interceptor.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend depend = getDepend();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(depend != null ? depend.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler forbiddenHandler = getForbiddenHandler();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(forbiddenHandler != null ? forbiddenHandler.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator retryDelayTimeCalculator = getRetryDelayTimeCalculator();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(retryDelayTimeCalculator != null ? retryDelayTimeCalculator.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler diskSpaceHandler = getDiskSpaceHandler();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(diskSpaceHandler != null ? diskSpaceHandler.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend monitorDepend = getMonitorDepend();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(monitorDepend != null ? monitorDepend.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider fileProvider = getFileProvider();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fileProvider != null ? fileProvider.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadCompleteHandlerSize = getDownloadCompleteHandlerSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadCompleteHandlerSize);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = getDownloadCompleteAidlHandlerByIndex(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadCompleteAidlHandlerByIndex != null ? downloadCompleteAidlHandlerByIndex.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator getChunkStrategy() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend getDepend() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws android.os.RemoteException;

    int getDownloadCompleteHandlerSize() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws android.os.RemoteException;

    int getDownloadListenerSize(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getFileProvider() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler getForbiddenHandler() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor getInterceptor() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend getMonitorDepend() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getSingleDownloadListener(int i) throws android.os.RemoteException;
}
