package com.ss.android.socialbase.downloader.db;

/* loaded from: classes19.dex */
public class SqlDownloadCache extends com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl.Stub implements com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache {
    private static volatile android.database.sqlite.SQLiteDatabase database;
    private volatile boolean cacheSynced;
    com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl callback;
    private com.ss.android.socialbase.downloader.db.TableStatements chunkTableStatements;
    private com.ss.android.socialbase.downloader.db.TableStatements downloadTableStatements;
    private com.ss.android.socialbase.downloader.db.TableStatements segmentTableStatements;

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ android.util.SparseArray val$copyChunkListMap;
        final /* synthetic */ android.util.SparseArray val$copyDownloadInfoMap;

        public AnonymousClass1(android.util.SparseArray sparseArray, android.util.SparseArray sparseArray2, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            this.val$copyDownloadInfoMap = sparseArray;
            this.val$copyChunkListMap = sparseArray2;
            this.val$callback = sqlCacheLoadCompleteCallback;
        }

        /* JADX WARN: Code restructure failed: missing block: B:139:0x027a, code lost:
        
            if (r0 == null) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x0284, code lost:
        
            if (r0 == null) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x033e, code lost:
        
            if (r0 == null) goto L171;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x0351, code lost:
        
            r18.this$0.onInitFinish(r18.val$copyDownloadInfoMap, r18.val$copyChunkListMap);
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x035a, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x0349, code lost:
        
            r0.callback();
            r18.this$0.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:191:0x0347, code lost:
        
            if (r0 == null) goto L171;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x01a5, code lost:
        
            if (r0 != null) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01a7, code lost:
        
            r0.callback();
            r18.this$0.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x01af, code lost:
        
            r18.this$0.onInitFinish(r18.val$copyDownloadInfoMap, r18.val$copyChunkListMap);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x01b8, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01bf, code lost:
        
            if (r0 == null) goto L83;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00da A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ca A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback;
            com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
            boolean z;
            int i;
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.ensureDataBaseInit();
            if (com.ss.android.socialbase.downloader.db.SqlDownloadCache.database == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator idGenerator = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIdGenerator();
            android.util.SparseArray sparseArray = new android.util.SparseArray();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            android.database.Cursor cursor = null;
            int i2 = 0;
            try {
                cursor = com.ss.android.socialbase.downloader.db.SqlDownloadCache.database.rawQuery("SELECT * FROM downloader", null);
                while (cursor.moveToNext()) {
                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = new com.ss.android.socialbase.downloader.model.DownloadInfo(cursor);
                    downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                    if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                        downloadInfo.setStatus(-5);
                        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.STATUS_NOT_UPDATE_TO_DB, true)) {
                            sparseArray.put(downloadInfo.getId(), downloadInfo);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) && !android.text.TextUtils.isEmpty(downloadInfo.getName())) {
                        if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                downloadInfo.reset();
                            }
                            z = false;
                        } else {
                            z = true;
                        }
                        if (downloadInfo.getStatus() == 11) {
                            downloadInfo.setStatus(-5);
                        }
                        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                            if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA)) {
                                downloadInfo.erase();
                            }
                        }
                        if (z) {
                            int id = downloadInfo.getId();
                            if (idGenerator != null) {
                                java.lang.String taskKey = downloadInfo.getTaskKey();
                                if (android.text.TextUtils.isEmpty(taskKey)) {
                                    taskKey = downloadInfo.getUrl();
                                }
                                i = idGenerator.generate(taskKey, downloadInfo.getSavePath());
                            } else {
                                i = 0;
                            }
                            if (i != id) {
                                downloadInfo.setId(i);
                                sparseArray.put(id, downloadInfo);
                            }
                            this.val$copyDownloadInfoMap.put(downloadInfo.getId(), downloadInfo);
                        } else {
                            arrayList.add(java.lang.Integer.valueOf(downloadInfo.getId()));
                            arrayList2.add(downloadInfo);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList2);
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.loadCacheFromDB(arrayList2, arrayList, sparseArray, this.val$copyDownloadInfoMap, this.val$copyChunkListMap);
                try {
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    if (this.val$copyDownloadInfoMap != null) {
                        while (i2 < this.val$copyDownloadInfoMap.size()) {
                            int keyAt = this.val$copyDownloadInfoMap.keyAt(i2);
                            if (keyAt != 0) {
                                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = (com.ss.android.socialbase.downloader.model.DownloadInfo) this.val$copyDownloadInfoMap.get(keyAt);
                                if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8192)) {
                                    if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                        arrayList3.add(java.lang.Integer.valueOf(downloadInfo2.getId()));
                                        this.val$copyChunkListMap.remove(downloadInfo2.getId());
                                    }
                                } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                    arrayList3.add(java.lang.Integer.valueOf(downloadInfo2.getId()));
                                    this.val$copyChunkListMap.remove(downloadInfo2.getId());
                                }
                            }
                            java.util.Iterator it = arrayList3.iterator();
                            while (it.hasNext()) {
                                this.val$copyDownloadInfoMap.remove(((java.lang.Integer) it.next()).intValue());
                            }
                            i2++;
                        }
                    }
                    sqlCacheLoadCompleteCallback2 = this.val$callback;
                } catch (java.lang.Throwable th) {
                    try {
                        th.printStackTrace();
                        sqlCacheLoadCompleteCallback2 = this.val$callback;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                try {
                    th2.printStackTrace();
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                    com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList2);
                    com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.loadCacheFromDB(arrayList2, arrayList, sparseArray, this.val$copyDownloadInfoMap, this.val$copyChunkListMap);
                    try {
                        java.util.ArrayList arrayList4 = new java.util.ArrayList();
                        if (this.val$copyDownloadInfoMap != null) {
                            while (i2 < this.val$copyDownloadInfoMap.size()) {
                                int keyAt2 = this.val$copyDownloadInfoMap.keyAt(i2);
                                if (keyAt2 != 0) {
                                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo3 = (com.ss.android.socialbase.downloader.model.DownloadInfo) this.val$copyDownloadInfoMap.get(keyAt2);
                                    if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8192)) {
                                        if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                            arrayList4.add(java.lang.Integer.valueOf(downloadInfo3.getId()));
                                            this.val$copyChunkListMap.remove(downloadInfo3.getId());
                                        }
                                    } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                        arrayList4.add(java.lang.Integer.valueOf(downloadInfo3.getId()));
                                        this.val$copyChunkListMap.remove(downloadInfo3.getId());
                                    }
                                }
                                java.util.Iterator it2 = arrayList4.iterator();
                                while (it2.hasNext()) {
                                    this.val$copyDownloadInfoMap.remove(((java.lang.Integer) it2.next()).intValue());
                                }
                                i2++;
                            }
                        }
                        sqlCacheLoadCompleteCallback2 = this.val$callback;
                    } catch (java.lang.Throwable th3) {
                        try {
                            th3.printStackTrace();
                            sqlCacheLoadCompleteCallback2 = this.val$callback;
                        } finally {
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                    com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList2);
                    com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.loadCacheFromDB(arrayList2, arrayList, sparseArray, this.val$copyDownloadInfoMap, this.val$copyChunkListMap);
                    try {
                        java.util.ArrayList arrayList5 = new java.util.ArrayList();
                        if (this.val$copyDownloadInfoMap != null) {
                            while (i2 < this.val$copyDownloadInfoMap.size()) {
                                int keyAt3 = this.val$copyDownloadInfoMap.keyAt(i2);
                                if (keyAt3 != 0) {
                                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo4 = (com.ss.android.socialbase.downloader.model.DownloadInfo) this.val$copyDownloadInfoMap.get(keyAt3);
                                    if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8192)) {
                                        if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                            arrayList5.add(java.lang.Integer.valueOf(downloadInfo4.getId()));
                                            this.val$copyChunkListMap.remove(downloadInfo4.getId());
                                        }
                                    } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                        arrayList5.add(java.lang.Integer.valueOf(downloadInfo4.getId()));
                                        this.val$copyChunkListMap.remove(downloadInfo4.getId());
                                    }
                                }
                                java.util.Iterator it3 = arrayList5.iterator();
                                while (it3.hasNext()) {
                                    this.val$copyDownloadInfoMap.remove(((java.lang.Integer) it3.next()).intValue());
                                }
                                i2++;
                            }
                        }
                        sqlCacheLoadCompleteCallback = this.val$callback;
                    } catch (java.lang.Throwable th5) {
                        try {
                            th5.printStackTrace();
                            sqlCacheLoadCompleteCallback = this.val$callback;
                        } finally {
                            if (this.val$callback != null) {
                                this.val$callback.callback();
                                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.cacheSynced = true;
                            }
                            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.onInitFinish(this.val$copyDownloadInfoMap, this.val$copyChunkListMap);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.clearDataInSubThread();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ android.content.ContentValues val$cv;
        final /* synthetic */ int val$id;

        public AnonymousClass11(int i, android.content.ContentValues contentValues) {
            this.val$id = i;
            this.val$cv = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.updateInner(this.val$id, this.val$cv);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass2(int i) {
            this.val$id = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.deleteInner(this.val$id, com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadChunk val$chunk;

        public AnonymousClass3(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
            this.val$chunk = downloadChunk;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.insertDownloadChunkInner(this.val$chunk, com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$id;

        public AnonymousClass4(int i, int i2, long j) {
            this.val$id = i;
            this.val$chunkIndex = i2;
            this.val$currentOffset = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.updateDownloadChunkInner(this.val$id, this.val$chunkIndex, this.val$currentOffset, com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;

        public AnonymousClass5(int i, int i2, int i3, long j) {
            this.val$id = i;
            this.val$chunkIndex = i2;
            this.val$hostChunkIndex = i3;
            this.val$currentOffset = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.updateSubDownloadChunkInner(this.val$id, this.val$chunkIndex, this.val$hostChunkIndex, this.val$currentOffset, com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;
        final /* synthetic */ int val$newChunkIndex;

        public AnonymousClass6(int i, int i2, int i3, int i4) {
            this.val$id = i;
            this.val$chunkIndex = i2;
            this.val$hostChunkIndex = i3;
            this.val$newChunkIndex = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.updateSubDownloadChunkIndexInner(this.val$id, this.val$chunkIndex, this.val$hostChunkIndex, this.val$newChunkIndex, com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$downloadInfo;

        public AnonymousClass7(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.val$downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.db.SqlDownloadCache sqlDownloadCache = com.ss.android.socialbase.downloader.db.SqlDownloadCache.this;
                sqlDownloadCache.insertDownloadInfoInner(this.val$downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$downloadInfo;

        public AnonymousClass8(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.val$downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.updateDownloadInfoForCurrentThread(this.val$downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass9(int i) {
            this.val$id = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.removeDownloadInfo(this.val$id);
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.removeAllDownloadChunk(this.val$id);
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.removeSegments(this.val$id);
        }
    }

    public SqlDownloadCache() {
        this(false);
    }

    public SqlDownloadCache(boolean z) {
        this.callback = null;
        if (z) {
            this.cacheSynced = false;
            init();
        }
    }

    private void addDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (database == null || this.downloadTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass7(downloadInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiHijackDirIfNeeded(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.clearAntiHijackDir(downloadInfo);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearDataInSubThread() {
        try {
            safeBeginTransaction();
            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, null, null);
            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, null, null);
            database.setTransactionSuccessful();
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                safeEndTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteInner(int i, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (com.ss.android.socialbase.downloader.db.SqlDownloadCache.class) {
                if (database == null) {
                    try {
                        database = com.ss.android.socialbase.downloader.db.DownloadDBHelper.getInstance().getWritableDatabase();
                        this.downloadTableStatements = new com.ss.android.socialbase.downloader.db.TableStatements(database, com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_ALL_COLUMNS, com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.chunkTableStatements = new com.ss.android.socialbase.downloader.db.TableStatements(database, com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_ALL_COLUMNS, com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_PK_COLUMNS);
                        this.segmentTableStatements = new com.ss.android.socialbase.downloader.db.TableStatements(database, com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME, com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_ALL_COLUMNS, com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_PK_COLUMNS);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (downloadChunk == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadChunk.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadInfoInner(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCacheFromDB(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, java.util.List<java.lang.Integer> list2, android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray, android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray2, android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            try {
                try {
                    safeBeginTransaction();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_CLEAR_INVALID_TASK_ERROR)) {
                            java.lang.String[] strArr = new java.lang.String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = java.lang.String.valueOf(list.get(i));
                            }
                            java.lang.String str = "CAST(_id AS TEXT) IN (" + new java.lang.String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, str, strArr);
                            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, str, strArr);
                        } else {
                            java.lang.String join = android.text.TextUtils.join(", ", list2);
                            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, "_id IN (?)", new java.lang.String[]{join});
                            database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, "_id IN (?)", new java.lang.String[]{join});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray.keyAt(i2);
                        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = sparseArray.get(keyAt);
                        database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(keyAt)});
                        database.insert(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = getDownloadChunk(keyAt);
                            if (downloadChunk.size() > 0) {
                                database.delete(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(keyAt)});
                                for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 : downloadChunk) {
                                    downloadChunk2.setId(downloadInfo.getId());
                                    database.insert(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, null, downloadChunk2.toContentValues());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            int id = sparseArray2.valueAt(i3).getId();
                            java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> parseHostChunkList = com.ss.android.socialbase.downloader.utils.DownloadUtils.parseHostChunkList(getDownloadChunk(id));
                            if (parseHostChunkList != null && parseHostChunkList.size() > 0) {
                                sparseArray3.put(id, parseHostChunkList);
                            }
                        }
                    }
                    database.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void safeEndTransaction() {
        try {
            if (database == null || !database.inTransaction()) {
                return;
            }
            database.endTransaction();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void update(int i, android.content.ContentValues contentValues) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass11(i, contentValues));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadChunkInner(int i, int i2, long j, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_OFFSET, java.lang.Long.valueOf(j));
                database.update(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ?", new java.lang.String[]{java.lang.Integer.toString(i), java.lang.Integer.toString(i2)});
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateDownloadInfoForCurrentThread(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!cacheExist(downloadInfo.getId())) {
                addDownloadInfo(downloadInfo);
                return;
            }
            com.ss.android.socialbase.downloader.db.TableStatements tableStatements = this.downloadTableStatements;
            if (tableStatements == null) {
                return;
            }
            try {
                updateDownloadInfoInner(downloadInfo, tableStatements.getUpdateStatement());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void updateDownloadInfoInner(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInner(int i, android.content.ContentValues contentValues) {
        int i2 = 10;
        while (database.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    java.lang.Thread.sleep(5L);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            database.update(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new java.lang.String[]{java.lang.String.valueOf(i)});
        } catch (java.lang.Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkIndexInner(int i, int i2, int i3, int i4, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_INDEX, java.lang.Integer.valueOf(i4));
                database.update(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new java.lang.String[]{java.lang.Integer.toString(i), java.lang.Integer.toString(i2), java.lang.Integer.toString(i3)});
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkInner(int i, int i2, int i3, long j, android.database.sqlite.SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_OFFSET, java.lang.Long.valueOf(j));
                database.update(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new java.lang.String[]{java.lang.Integer.toString(i), java.lang.Integer.toString(i2), java.lang.Integer.toString(i3)});
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) (-4));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) (-3));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(j));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_DOWNLOAD, (java.lang.Integer) 0);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_SUCCESS, (java.lang.Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) 3);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.TOTAL_BYTES, java.lang.Long.valueOf(j));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.ETAG, str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) (-1));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(j));
        if (j > 0) {
            contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_DOWNLOAD, (java.lang.Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) (-2));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) 4);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Integer) 5);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_DOWNLOAD, (java.lang.Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass3(downloadChunk));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i) {
        try {
            return getDownloadInfo(i) != null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void clearData() {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass10());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        ensureDataBaseInit();
        if (database != null) {
            android.database.Cursor cursor = null;
            try {
                cursor = database.rawQuery(java.lang.String.format("SELECT * FROM %s WHERE %s = ?", com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_TABLE_NAME, "_id"), new java.lang.String[]{java.lang.Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.DownloadChunk(cursor));
                }
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
            } catch (java.lang.Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                } catch (java.lang.Throwable th2) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        android.database.Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(java.lang.String.format("SELECT * FROM %s WHERE %s = ?", com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new java.lang.String[]{java.lang.Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = new com.ss.android.socialbase.downloader.model.DownloadInfo(cursor);
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        return downloadInfo;
                    }
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        return null;
                    } catch (java.lang.Throwable th2) {
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        ensureDataBaseInit();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (database != null) {
            android.database.Cursor cursor = null;
            try {
                cursor = database.rawQuery(java.lang.String.format("SELECT * FROM %s WHERE %s = ?", com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, "url"), new java.lang.String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
            } catch (java.lang.Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                } catch (java.lang.Throwable th2) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> getSegmentMap(int i) {
        android.database.Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(java.lang.String.format("SELECT * FROM %s WHERE %s = ?", com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME, "_id"), new java.lang.String[]{java.lang.Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("info");
                        java.lang.String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                        java.util.HashMap hashMap = new java.util.HashMap();
                        org.json.JSONArray jSONArray = new org.json.JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            com.ss.android.socialbase.downloader.segment.Segment segment = new com.ss.android.socialbase.downloader.segment.Segment(jSONArray.getJSONObject(i2));
                            hashMap.put(java.lang.Long.valueOf(segment.getStartOffset()), segment);
                        }
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        return hashMap;
                    }
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        return null;
                    } catch (java.lang.Throwable th2) {
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(cursor);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.ArrayList<com.ss.android.socialbase.downloader.segment.Segment> getSegments(int i) {
        java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> segmentMap = getSegmentMap(i);
        if (segmentMap == null || segmentMap.isEmpty()) {
            return null;
        }
        return new java.util.ArrayList<>(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void init() {
        init(new android.util.SparseArray<>(), new android.util.SparseArray<>(), null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray, android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray2, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        try {
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1 anonymousClass1 = new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1(sparseArray, sparseArray2, sqlCacheLoadCompleteCallback);
            java.util.concurrent.ExecutorService dBThreadExecutorService = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(anonymousClass1);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) {
        return null;
    }

    public void onInitFinish(android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray, android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray2) {
        try {
            java.util.HashMap sparseArrayToHashMap = com.ss.android.socialbase.downloader.utils.DownloadUtils.sparseArrayToHashMap(sparseArray);
            java.util.HashMap sparseArrayToHashMap2 = com.ss.android.socialbase.downloader.utils.DownloadUtils.sparseArrayToHashMap(sparseArray2);
            com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl = this.callback;
            if (iSqlCacheLoadCompleteCallbackAidl != null) {
                iSqlCacheLoadCompleteCallbackAidl.callback(sparseArrayToHashMap, sparseArrayToHashMap2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void removeAllDownloadChunk(int i) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass2(i));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(int i) {
        com.ss.android.socialbase.downloader.db.TableStatements tableStatements;
        ensureDataBaseInit();
        if (database != null && (tableStatements = this.downloadTableStatements) != null) {
            try {
                deleteInner(i, tableStatements.getDeleteStatement());
                return true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass9(i));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            deleteInner(i, this.segmentTableStatements.getDeleteStatement());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        try {
            removeAllDownloadChunk(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk : list) {
                    if (downloadChunk != null) {
                        addDownloadChunk(downloadChunk);
                        if (downloadChunk.hasChunkDivided()) {
                            java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = downloadChunk.getSubChunkList().iterator();
                            while (it.hasNext()) {
                                addDownloadChunk(it.next());
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) {
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        int i3 = 10;
        while (database.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    java.lang.Thread.sleep(5L);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_COUNT, java.lang.Integer.valueOf(i2));
        database.update(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new java.lang.String[]{java.lang.Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateDownloadChunk(int i, int i2, long j) {
        ensureDataBaseInit();
        if (i == 0 || i2 < 0 || j < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass4(i, i2, j));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (downloadInfo == null || database == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass8(downloadInfo));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            java.util.Iterator<java.lang.Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(java.lang.Long.valueOf(it.next().longValue())).toJson());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        android.database.sqlite.SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        com.ss.android.socialbase.downloader.logger.Logger.d("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.utils.DownloadUtils.cost(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        ensureDataBaseInit();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass5(i, i2, i3, j));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
        ensureDataBaseInit();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitDBTask(new com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass6(i, i2, i3, i4));
    }
}
