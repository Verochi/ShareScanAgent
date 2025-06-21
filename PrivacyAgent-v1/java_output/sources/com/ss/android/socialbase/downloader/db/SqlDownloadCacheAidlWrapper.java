package com.ss.android.socialbase.downloader.db;

/* loaded from: classes19.dex */
public class SqlDownloadCacheAidlWrapper implements android.content.ServiceConnection, com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final java.lang.String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;

    @androidx.annotation.Nullable
    private com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl mISqlDownloadCache;
    private com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener mRebindErrorListener;
    private java.util.concurrent.Future<?> mSetInitCallbackFuture;
    private android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl mPengingCallback = null;
    private java.lang.Runnable mCheckAliveRunnable = new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass1();
    private java.util.concurrent.CountDownLatch mInitLock = new java.util.concurrent.CountDownLatch(1);

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.sIsMainProcessAlive || com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                return;
            }
            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.os.IBinder val$service;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.IBinder.DeathRecipient {
            public AnonymousClass1() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                boolean unused = com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                if (com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                    return;
                }
                com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
            }
        }

        public AnonymousClass2(android.os.IBinder iBinder) {
            this.val$service = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.os.IBinder iBinder;
            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass2.AnonymousClass1 anonymousClass1;
            synchronized (this) {
                try {
                    try {
                        if (com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mPengingCallback != null && com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache != null) {
                            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache.setInitCallback(com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mPengingCallback);
                        }
                        iBinder = this.val$service;
                        anonymousClass1 = new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass2.AnonymousClass1();
                    } catch (java.lang.Throwable unused) {
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th);
                        if (com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                        }
                        com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                        iBinder = this.val$service;
                        anonymousClass1 = new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass2.AnonymousClass1();
                    } finally {
                        com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                        try {
                            this.val$service.linkToDeath(new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass2.AnonymousClass1(), 0);
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                }
                iBinder.linkToDeath(anonymousClass1, 0);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService.startServiceAndBind(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ android.util.SparseArray val$chunkListSparseArray;
        final /* synthetic */ android.util.SparseArray val$downloadInfoSparseArray;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl.Stub {
            public AnonymousClass1() {
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public void callback(java.util.Map map, java.util.Map map2) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.sparseArrayPutAll(com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass4.this.val$downloadInfoSparseArray, map);
                com.ss.android.socialbase.downloader.utils.DownloadUtils.sparseArrayPutAll(com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass4.this.val$chunkListSparseArray, map2);
                com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass4.this.val$callback.callback();
                com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
            }
        }

        public AnonymousClass4(android.util.SparseArray sparseArray, android.util.SparseArray sparseArray2, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            this.val$downloadInfoSparseArray = sparseArray;
            this.val$chunkListSparseArray = sparseArray2;
            this.val$callback = sqlCacheLoadCompleteCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback;
            java.util.concurrent.Future future;
            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.setInitCallback(new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass4.AnonymousClass1());
            try {
                z = !com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                z = false;
            }
            if (z && (future = com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                future.cancel(true);
            }
            com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.this.init();
            if (!z || (sqlCacheLoadCompleteCallback = this.val$callback) == null) {
                return;
            }
            sqlCacheLoadCompleteCallback.callback();
        }
    }

    public interface OnMainProcessRebindErrorListener {
        void onRebindError();
    }

    public SqlDownloadCacheAidlWrapper() {
        com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService.startServiceAndBind(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindMainProcessDelayed() {
        if (android.os.Build.VERSION.SDK_INT >= 26 || sIsMainProcessAlive) {
            return false;
        }
        if (sBindMainProcessTimes > 5) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - sLastBindMainProcessTimeMills < 15000) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = currentTimeMillis;
        this.mHandler.postDelayed(new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass3(), 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCancel(i, j);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCompleted(i, j);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskConnected(i, j, str, str2);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskError(i, j);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskIntercept(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPause(i, j);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPrepare(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskProgress(i, j);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskRetry(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.addDownloadChunk(downloadChunk);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.addSubDownloadChunk(downloadChunk);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.cacheExist(i);
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.clearData();
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.ensureDownloadCacheSyncSuccess();
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getAllDownloadInfo();
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadChunk(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfo(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfoList(str);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getFailedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> getSegmentMap(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.ArrayList<com.ss.android.socialbase.downloader.segment.Segment> getSegments(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getSuccessedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getUnCompletedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.init();
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray, android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray2, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().submit(new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass4(sparseArray, sparseArray2, sqlCacheLoadCompleteCallback));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.isDownloadCacheSyncSuccess();
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.onDownloadTaskStart(i);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        try {
            this.mISqlDownloadCache = com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub.asInterface(iBinder);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.mSetInitCallbackFuture = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().submit(new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.AnonymousClass2(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.removeAllDownloadChunk(i);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadInfo(i);
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadTaskData(i);
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                try {
                    iSqlDownloadCacheAidl.setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.mPengingCallback = iSqlCacheLoadCompleteCallbackAidl;
            }
        }
    }

    public void setOnMainProcessRebindErrorCallback(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        this.mRebindErrorListener = onMainProcessRebindErrorListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadChunks(i, list);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfo(downloadInfo);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfoFromOtherCache(i, list);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateChunkCount(i, i2);
            }
            return null;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i, int i2, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateDownloadChunk(i, i2, j);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateDownloadInfo(downloadInfo);
            }
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunk(i, i2, i3, j);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
        try {
            com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunkIndex(i, i2, i3, i4);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }
}
