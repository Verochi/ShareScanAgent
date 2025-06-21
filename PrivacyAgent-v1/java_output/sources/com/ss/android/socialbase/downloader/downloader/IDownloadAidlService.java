package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface IDownloadAidlService extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.downloader.IDownloadAidlService {
        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener1(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean canResume(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void cancel(int i, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearData() throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearDownloadData(int i, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void dispatchProcessCallback(int i, int i2) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void forceDownloadIngoreRecommendSize(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public long getCurBytes(int i) throws android.os.RemoteException {
            return 0L;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadId(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfoByUrlAndPath(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadWithIndependentProcessStatus(int i) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getStatus(int i) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloading(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isHttpServiceInit() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isServiceForeground() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pause(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pauseAll() throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeAllDownloadChunk(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadInfo(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadTaskData(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resetDownloadData(int i, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restart(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resume(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean retryDelayStart(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setLogLevel(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setThrottleNetSpeed(int i, long j) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void stopForeground(boolean z) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.downloader.IDownloadAidlService {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadChunk = 38;
        static final int TRANSACTION_addDownloadListener = 26;
        static final int TRANSACTION_addDownloadListener1 = 27;
        static final int TRANSACTION_addProcessCallback = 49;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 46;
        static final int TRANSACTION_clearDownloadData = 22;
        static final int TRANSACTION_dispatchProcessCallback = 50;
        static final int TRANSACTION_forceDownloadIngoreRecommendSize = 24;
        static final int TRANSACTION_getAllDownloadInfo = 19;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadChunk = 13;
        static final int TRANSACTION_getDownloadFileUriProvider = 54;
        static final int TRANSACTION_getDownloadId = 14;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 15;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadNotificationEventListener = 51;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 37;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 18;
        static final int TRANSACTION_getFailedDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 52;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 17;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 32;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 35;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 28;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 31;
        static final int TRANSACTION_isServiceForeground = 55;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeAllDownloadChunk = 41;
        static final int TRANSACTION_removeDownloadInfo = 40;
        static final int TRANSACTION_removeDownloadListener = 25;
        static final int TRANSACTION_removeDownloadTaskData = 45;
        static final int TRANSACTION_resetDownloadData = 23;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 20;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 21;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_retryDelayStart = 33;
        static final int TRANSACTION_setDownloadNotificationEventListener = 53;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 36;
        static final int TRANSACTION_setLogLevel = 34;
        static final int TRANSACTION_setThrottleNetSpeed = 56;
        static final int TRANSACTION_startForeground = 29;
        static final int TRANSACTION_stopForeground = 30;
        static final int TRANSACTION_syncDownloadChunks = 48;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 47;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadChunk = 42;
        static final int TRANSACTION_updateDownloadInfo = 39;
        static final int TRANSACTION_updateSubDownloadChunk = 43;
        static final int TRANSACTION_updateSubDownloadChunkIndex = 44;

        public static class Proxy implements com.ss.android.socialbase.downloader.downloader.IDownloadAidlService {
            public static com.ss.android.socialbase.downloader.downloader.IDownloadAidlService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (downloadChunk != null) {
                        obtain.writeInt(1);
                        downloadChunk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(38, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().addDownloadChunk(downloadChunk);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(26, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().addDownloadListener(i, i2, iDownloadAidlListener, i3, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    try {
                        if (this.mRemote.transact(27, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                        } else {
                            com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().addDownloadListener1(i, i2, iDownloadAidlListener, i3, z, z2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(processAidlCallback != null ? processAidlCallback.asBinder() : null);
                    if (this.mRemote.transact(49, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().addProcessCallback(processAidlCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().canResume(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int i, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().cancel(i, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(46, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().clearData();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int i, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(22, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().clearDownloadData(i, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int i, int i2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(50, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().dispatchProcessCallback(i, i2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void forceDownloadIngoreRecommendSize(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(24, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().forceDownloadIngoreRecommendSize(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getAllDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getCurBytes(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadChunk(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(54, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadFileUriProvider(i);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadId(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfoByUrlAndPath(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadInfoList(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(51, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadNotificationEventListener(i);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getFailedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(52, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getNotificationClickCallback(i);
                    }
                    obtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getStatus(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().isDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().isDownloading(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().isHttpServiceInit();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isServiceForeground() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(55, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().isServiceForeground();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().pause(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().pauseAll();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeAllDownloadChunk(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(41, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().removeAllDownloadChunk(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().removeDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(25, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().removeDownloadListener(i, i2, iDownloadAidlListener, i3, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().removeDownloadTaskData(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int i, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(23, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().resetDownloadData(i, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().restart(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(20, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().restartAllFailedDownloadTasks(list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(21, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().resume(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean retryDelayStart(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().retryDelayStart(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iDownloadNotificationEventAidlListener != null ? iDownloadNotificationEventAidlListener.asBinder() : null);
                    if (this.mRemote.transact(53, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().setDownloadNotificationEventListener(i, iDownloadNotificationEventAidlListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(36, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(i, z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(34, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().setLogLevel(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(56, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().setThrottleNetSpeed(i, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(29, obtain, null, 1) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().startForeground(i, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void stopForeground(boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(30, obtain, null, 1) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().stopForeground(z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(48, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().syncDownloadChunks(i, list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(47, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(i, list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(downloadAidlTask != null ? downloadAidlTask.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().tryDownload(downloadAidlTask);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(42, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().updateDownloadChunk(i, i2, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().updateDownloadInfo(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(43, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().updateSubDownloadChunk(i, i2, i3, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(44, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.getDefaultImpl().updateSubDownloadChunkIndex(i, i2, i3, i4);
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

        public static com.ss.android.socialbase.downloader.downloader.IDownloadAidlService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.downloader.IDownloadAidlService)) ? new com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.downloader.IDownloadAidlService) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.downloader.IDownloadAidlService getDefaultImpl() {
            return com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.downloader.IDownloadAidlService iDownloadAidlService) {
            if (com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.Proxy.sDefaultImpl != null || iDownloadAidlService == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.Proxy.sDefaultImpl = iDownloadAidlService;
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
                    tryDownload(com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean canResume = canResume(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(canResume ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    resume(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    restart(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseAll();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    long curBytes = getCurBytes(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(curBytes);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int status = getStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(status);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloading = isDownloading(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloading ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfo != null) {
                        parcel2.writeInt(1);
                        downloadInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList = getDownloadInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfoList);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = getDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadChunk);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadId = getDownloadId(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadId);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfoByUrlAndPath = getDownloadInfoByUrlAndPath(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoByUrlAndPath != null) {
                        parcel2.writeInt(1);
                        downloadInfoByUrlAndPath.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> failedDownloadInfosWithMimeType = getFailedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(failedDownloadInfosWithMimeType);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> successedDownloadInfosWithMimeType = getSuccessedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(successedDownloadInfosWithMimeType);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadingDownloadInfosWithMimeType = getDownloadingDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadingDownloadInfosWithMimeType);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> allDownloadInfo = getAllDownloadInfo();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDownloadInfo);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllFailedDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllPauseReserveOnWifiDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearDownloadData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetDownloadData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    forceDownloadIngoreRecommendSize(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeDownloadListener(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener1(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadSuccessAndFileNotExist = isDownloadSuccessAndFileNotExist(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadSuccessAndFileNotExist ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (android.app.Notification) android.app.Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isHttpServiceInit = isHttpServiceInit();
                    parcel2.writeNoException();
                    parcel2.writeInt(isHttpServiceInit ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> unCompletedDownloadInfosWithMimeType = getUnCompletedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unCompletedDownloadInfosWithMimeType);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean retryDelayStart = retryDelayStart(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(retryDelayStart ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLogLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadCacheSyncSuccess = isDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadWithIndependentProcessStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadWithIndependentProcessStatus = getDownloadWithIndependentProcessStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadWithIndependentProcessStatus);
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadChunk(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateDownloadInfo = updateDownloadInfo(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(updateDownloadInfo ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadInfo = removeDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadInfo ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeAllDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunkIndex(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadTaskData = removeDownloadTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadTaskData ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearData();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfoFromOtherCache(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadChunks(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    dispatchProcessCallback(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                    return true;
                case 53:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadNotificationEventListener(parcel.readInt(), com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider downloadFileUriProvider = getDownloadFileUriProvider(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadFileUriProvider != null ? downloadFileUriProvider.asBinder() : null);
                    return true;
                case 55:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isServiceForeground = isServiceForeground();
                    parcel2.writeNoException();
                    parcel2.writeInt(isServiceForeground ? 1 : 0);
                    return true;
                case 56:
                    parcel.enforceInterface(DESCRIPTOR);
                    setThrottleNetSpeed(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException;

    void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException;

    void addDownloadListener1(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws android.os.RemoteException;

    void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) throws android.os.RemoteException;

    boolean canResume(int i) throws android.os.RemoteException;

    void cancel(int i, boolean z) throws android.os.RemoteException;

    void clearData() throws android.os.RemoteException;

    void clearDownloadData(int i, boolean z) throws android.os.RemoteException;

    void dispatchProcessCallback(int i, int i2) throws android.os.RemoteException;

    void forceDownloadIngoreRecommendSize(int i) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException;

    long getCurBytes(int i) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws android.os.RemoteException;

    int getDownloadId(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfoByUrlAndPath(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws android.os.RemoteException;

    int getDownloadWithIndependentProcessStatus(int i) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback(int i) throws android.os.RemoteException;

    int getStatus(int i) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException;

    boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    boolean isDownloading(int i) throws android.os.RemoteException;

    boolean isHttpServiceInit() throws android.os.RemoteException;

    boolean isServiceForeground() throws android.os.RemoteException;

    void pause(int i) throws android.os.RemoteException;

    void pauseAll() throws android.os.RemoteException;

    void removeAllDownloadChunk(int i) throws android.os.RemoteException;

    boolean removeDownloadInfo(int i) throws android.os.RemoteException;

    void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException;

    boolean removeDownloadTaskData(int i) throws android.os.RemoteException;

    void resetDownloadData(int i, boolean z) throws android.os.RemoteException;

    void restart(int i) throws android.os.RemoteException;

    void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException;

    void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException;

    void resume(int i) throws android.os.RemoteException;

    boolean retryDelayStart(int i) throws android.os.RemoteException;

    void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws android.os.RemoteException;

    void setDownloadWithIndependentProcessStatus(int i, boolean z) throws android.os.RemoteException;

    void setLogLevel(int i) throws android.os.RemoteException;

    void setThrottleNetSpeed(int i, long j) throws android.os.RemoteException;

    void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException;

    void stopForeground(boolean z) throws android.os.RemoteException;

    void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException;

    void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException;

    void tryDownload(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) throws android.os.RemoteException;

    void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException;

    boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException;

    void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException;
}
