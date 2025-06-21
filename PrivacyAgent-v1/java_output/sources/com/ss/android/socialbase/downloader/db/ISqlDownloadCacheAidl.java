package com.ss.android.socialbase.downloader.db;

/* loaded from: classes19.dex */
public interface ISqlDownloadCacheAidl extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl {
        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean cacheExist(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void clearData() throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean ensureDownloadCacheSyncSuccess() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void init() throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void removeAllDownloadChunk(int i) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadInfo(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadTaskData(int i) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
        static final int TRANSACTION_OnDownloadTaskCancel = 28;
        static final int TRANSACTION_OnDownloadTaskCompleted = 26;
        static final int TRANSACTION_OnDownloadTaskConnected = 22;
        static final int TRANSACTION_OnDownloadTaskError = 24;
        static final int TRANSACTION_OnDownloadTaskIntercept = 30;
        static final int TRANSACTION_OnDownloadTaskPause = 27;
        static final int TRANSACTION_OnDownloadTaskPrepare = 29;
        static final int TRANSACTION_OnDownloadTaskProgress = 23;
        static final int TRANSACTION_OnDownloadTaskRetry = 25;
        static final int TRANSACTION_addDownloadChunk = 11;
        static final int TRANSACTION_addSubDownloadChunk = 12;
        static final int TRANSACTION_cacheExist = 2;
        static final int TRANSACTION_clearData = 20;
        static final int TRANSACTION_ensureDownloadCacheSyncSuccess = 32;
        static final int TRANSACTION_getAllDownloadInfo = 8;
        static final int TRANSACTION_getDownloadChunk = 9;
        static final int TRANSACTION_getDownloadInfo = 3;
        static final int TRANSACTION_getDownloadInfoList = 4;
        static final int TRANSACTION_getFailedDownloadInfosWithMimeType = 5;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 6;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 7;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 31;
        static final int TRANSACTION_onDownloadTaskStart = 21;
        static final int TRANSACTION_removeAllDownloadChunk = 10;
        static final int TRANSACTION_removeDownloadInfo = 18;
        static final int TRANSACTION_removeDownloadTaskData = 19;
        static final int TRANSACTION_setInitCallback = 36;
        static final int TRANSACTION_syncDownloadChunks = 34;
        static final int TRANSACTION_syncDownloadInfo = 33;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 35;
        static final int TRANSACTION_updateChunkCount = 16;
        static final int TRANSACTION_updateDownloadChunk = 13;
        static final int TRANSACTION_updateDownloadInfo = 17;
        static final int TRANSACTION_updateSubDownloadChunk = 14;
        static final int TRANSACTION_updateSubDownloadChunkIndex = 15;

        public static class Proxy implements com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl {
            public static com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskCancel(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskCompleted(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskConnected(i, j, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskError(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskIntercept(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskPause(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskPrepare(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskProgress(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskRetry(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (downloadChunk != null) {
                        obtain.writeInt(1);
                        downloadChunk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().addDownloadChunk(downloadChunk);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (downloadChunk != null) {
                        obtain.writeInt(1);
                        downloadChunk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().addSubDownloadChunk(downloadChunk);
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean cacheExist(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().cacheExist(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void clearData() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(20, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().clearData();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean ensureDownloadCacheSyncSuccess() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().ensureDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getAllDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadChunk(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfoList(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getFailedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void init() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().init();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().isDownloadCacheSyncSuccess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().onDownloadTaskStart(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void removeAllDownloadChunk(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().removeAllDownloadChunk(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadInfo(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().removeDownloadInfo(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadTaskData(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().removeDownloadTaskData(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSqlCacheLoadCompleteCallbackAidl != null ? iSqlCacheLoadCompleteCallbackAidl.asBinder() : null);
                    if (this.mRemote.transact(36, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(34, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().syncDownloadChunks(i, list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(33, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().syncDownloadInfo(downloadInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(35, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(i, list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateChunkCount(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateDownloadChunk(i, i2, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateDownloadInfo(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateSubDownloadChunk(i, i2, i3, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateSubDownloadChunkIndex(i, i2, i3, i4);
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

        public static com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl)) ? new com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl getDefaultImpl() {
            return com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl) {
            if (com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.Proxy.sDefaultImpl != null || iSqlDownloadCacheAidl == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.Proxy.sDefaultImpl = iSqlDownloadCacheAidl;
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
                    init();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean cacheExist = cacheExist(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cacheExist ? 1 : 0);
                    return true;
                case 3:
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
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList = getDownloadInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfoList);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> failedDownloadInfosWithMimeType = getFailedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(failedDownloadInfosWithMimeType);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> successedDownloadInfosWithMimeType = getSuccessedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(successedDownloadInfosWithMimeType);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> unCompletedDownloadInfosWithMimeType = getUnCompletedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unCompletedDownloadInfosWithMimeType);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> allDownloadInfo = getAllDownloadInfo();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDownloadInfo);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = getDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadChunk);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeAllDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadChunk(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    addSubDownloadChunk(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunkIndex(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount = updateChunkCount(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (updateChunkCount != null) {
                        parcel2.writeInt(1);
                        updateChunkCount.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateDownloadInfo = updateDownloadInfo(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(updateDownloadInfo ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadInfo = removeDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadInfo ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean removeDownloadTaskData = removeDownloadTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(removeDownloadTaskData ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearData();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart = onDownloadTaskStart(parcel.readInt());
                    parcel2.writeNoException();
                    if (onDownloadTaskStart != null) {
                        parcel2.writeInt(1);
                        onDownloadTaskStart.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected = OnDownloadTaskConnected(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (OnDownloadTaskConnected != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskConnected.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress = OnDownloadTaskProgress(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskProgress != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskProgress.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError = OnDownloadTaskError(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskError != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskError.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry = OnDownloadTaskRetry(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskRetry != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskRetry.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted = OnDownloadTaskCompleted(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskCompleted != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskCompleted.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause = OnDownloadTaskPause(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskPause != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskPause.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel = OnDownloadTaskCancel(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (OnDownloadTaskCancel != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskCancel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare = OnDownloadTaskPrepare(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskPrepare != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskPrepare.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept = OnDownloadTaskIntercept(parcel.readInt());
                    parcel2.writeNoException();
                    if (OnDownloadTaskIntercept != null) {
                        parcel2.writeInt(1);
                        OnDownloadTaskIntercept.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloadCacheSyncSuccess = isDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean ensureDownloadCacheSyncSuccess = ensureDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(ensureDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfo(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadChunks(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfoFromOtherCache(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) throws android.os.RemoteException;

    void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException;

    void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException;

    boolean cacheExist(int i) throws android.os.RemoteException;

    void clearData() throws android.os.RemoteException;

    boolean ensureDownloadCacheSyncSuccess() throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException;

    void init() throws android.os.RemoteException;

    boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) throws android.os.RemoteException;

    void removeAllDownloadChunk(int i) throws android.os.RemoteException;

    boolean removeDownloadInfo(int i) throws android.os.RemoteException;

    boolean removeDownloadTaskData(int i) throws android.os.RemoteException;

    void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) throws android.os.RemoteException;

    void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException;

    void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException;

    com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) throws android.os.RemoteException;

    void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException;

    boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException;

    void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException;

    void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException;
}
