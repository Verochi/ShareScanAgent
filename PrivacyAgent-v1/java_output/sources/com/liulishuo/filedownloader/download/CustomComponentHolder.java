package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class CustomComponentHolder {
    public com.liulishuo.filedownloader.services.DownloadMgrInitialParams a;
    public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter b;
    public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator c;
    public com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator d;
    public com.liulishuo.filedownloader.database.FileDownloadDatabase e;
    public com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator f;
    public com.liulishuo.filedownloader.services.ForegroundServiceConfig g;

    public static final class LazyLoader {
        public static final com.liulishuo.filedownloader.download.CustomComponentHolder a = new com.liulishuo.filedownloader.download.CustomComponentHolder();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d4, code lost:
    
        if (r8.getSoFar() > 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0051, code lost:
    
        if (r8.getSoFar() <= 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fb A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:26:0x00f1, B:15:0x00fb, B:17:0x0111, B:19:0x0115, B:20:0x012d, B:21:0x0134, B:51:0x00a3, B:52:0x00c5, B:54:0x00cc, B:57:0x00da, B:60:0x00e5), top: B:25:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:72:0x0034, B:74:0x003b, B:76:0x0042, B:78:0x0049, B:10:0x0056, B:36:0x0065, B:38:0x0070, B:9:0x0053), top: B:71:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:26:0x00f1, B:15:0x00fb, B:17:0x0111, B:19:0x0115, B:20:0x012d, B:21:0x0134, B:51:0x00a3, B:52:0x00c5, B:54:0x00cc, B:57:0x00da, B:60:0x00e5), top: B:25:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer) {
        long j;
        long j2;
        java.lang.String targetFilePath;
        boolean z;
        java.lang.String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        java.util.Iterator<com.liulishuo.filedownloader.model.FileDownloadModel> it = maintainer.iterator();
        com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator idGeneratorInstance = getImpl().getIdGeneratorInstance();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (it.hasNext()) {
            try {
                com.liulishuo.filedownloader.model.FileDownloadModel next = it.next();
                java.lang.String str2 = str;
                if (next.getStatus() != 3) {
                    try {
                        if (next.getStatus() != 2) {
                            if (next.getStatus() != -1) {
                                if (next.getStatus() == 1) {
                                }
                                targetFilePath = next.getTargetFilePath();
                                if (targetFilePath != null) {
                                    j = currentTimeMillis;
                                    j2 = j3;
                                    z = true;
                                } else {
                                    java.io.File file = new java.io.File(targetFilePath);
                                    if (next.getStatus() == -2) {
                                        j = currentTimeMillis;
                                        try {
                                            if (com.liulishuo.filedownloader.util.FileDownloadUtils.isBreakpointAvailable(next.getId(), next, next.getPath(), null)) {
                                                java.io.File file2 = new java.io.File(next.getTempFilePath());
                                                if (!file2.exists() && file.exists()) {
                                                    boolean renameTo = file.renameTo(file2);
                                                    if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                                                        j2 = j3;
                                                        com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.database.FileDownloadDatabase.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", java.lang.Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                        if (next.getStatus() != 1) {
                                                        }
                                                        if (com.liulishuo.filedownloader.util.FileDownloadUtils.isBreakpointAvailable(next.getId(), next) && !file.exists()) {
                                                            z = false;
                                                        }
                                                        z = true;
                                                    }
                                                }
                                            }
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            j2 = j3;
                                            str = str2;
                                            com.liulishuo.filedownloader.util.FileDownloadUtils.markConverted(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
                                            maintainer.onFinishMaintain();
                                            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        j = currentTimeMillis;
                                    }
                                    j2 = j3;
                                    if (next.getStatus() != 1) {
                                    }
                                    if (com.liulishuo.filedownloader.util.FileDownloadUtils.isBreakpointAvailable(next.getId(), next)) {
                                        z = false;
                                    }
                                    z = true;
                                }
                                if (z) {
                                    int id = next.getId();
                                    int transOldId = idGeneratorInstance.transOldId(id, next.getUrl(), next.getPath(), next.isPathAsDirectory());
                                    if (transOldId != id) {
                                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.database.FileDownloadDatabase.class, "the id is changed on restoring from db: old[%d] -> new[%d]", java.lang.Integer.valueOf(id), java.lang.Integer.valueOf(transOldId));
                                        }
                                        next.setId(transOldId);
                                        maintainer.changeFileDownloadModelId(id, next);
                                        j5++;
                                    }
                                    maintainer.onRefreshedValidData(next);
                                    j3 = j2 + 1;
                                } else {
                                    try {
                                        it.remove();
                                        maintainer.onRemovedInvalidData(next);
                                        j4++;
                                        j3 = j2;
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        str = str2;
                                        com.liulishuo.filedownloader.util.FileDownloadUtils.markConverted(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
                                        maintainer.onFinishMaintain();
                                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                                        }
                                        throw th;
                                    }
                                }
                                str = str2;
                                currentTimeMillis = j;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        j = currentTimeMillis;
                        j2 = j3;
                        str = str2;
                        com.liulishuo.filedownloader.util.FileDownloadUtils.markConverted(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
                        maintainer.onFinishMaintain();
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.database.FileDownloadDatabase.class, str, java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j5), java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - j));
                        }
                        throw th;
                    }
                }
                next.setStatus((byte) -2);
                targetFilePath = next.getTargetFilePath();
                if (targetFilePath != null) {
                }
                if (z) {
                }
                str = str2;
                currentTimeMillis = j;
            } catch (java.lang.Throwable th4) {
                th = th4;
                j = currentTimeMillis;
                j2 = j3;
            }
        }
        java.lang.String str3 = str;
        long j6 = currentTimeMillis;
        long j7 = j3;
        com.liulishuo.filedownloader.util.FileDownloadUtils.markConverted(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
        maintainer.onFinishMaintain();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.database.FileDownloadDatabase.class, str3, java.lang.Long.valueOf(j7), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j5), java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - j6));
        }
    }

    public static com.liulishuo.filedownloader.download.CustomComponentHolder getImpl() {
        return com.liulishuo.filedownloader.download.CustomComponentHolder.LazyLoader.a;
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter a() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter = this.b;
        if (connectionCountAdapter != null) {
            return connectionCountAdapter;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = c().createConnectionCountAdapter();
            }
        }
        return this.b;
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator b() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator connectionCreator = this.c;
        if (connectionCreator != null) {
            return connectionCreator;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = c().createConnectionCreator();
            }
        }
        return this.c;
    }

    public final com.liulishuo.filedownloader.services.DownloadMgrInitialParams c() {
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams downloadMgrInitialParams = this.a;
        if (downloadMgrInitialParams != null) {
            return downloadMgrInitialParams;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new com.liulishuo.filedownloader.services.DownloadMgrInitialParams();
            }
        }
        return this.a;
    }

    public com.liulishuo.filedownloader.connection.FileDownloadConnection createConnection(java.lang.String str) throws java.io.IOException {
        return b().create(str);
    }

    public com.liulishuo.filedownloader.stream.FileDownloadOutputStream createOutputStream(java.io.File file) throws java.io.IOException {
        return d().create(file);
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator d() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator outputStreamCreator = this.d;
        if (outputStreamCreator != null) {
            return outputStreamCreator;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = c().createOutputStreamCreator();
            }
        }
        return this.d;
    }

    public int determineConnectionCount(int i, java.lang.String str, java.lang.String str2, long j) {
        return a().determineConnectionCount(i, str, str2, j);
    }

    public com.liulishuo.filedownloader.database.FileDownloadDatabase getDatabaseInstance() {
        com.liulishuo.filedownloader.database.FileDownloadDatabase fileDownloadDatabase = this.e;
        if (fileDownloadDatabase != null) {
            return fileDownloadDatabase;
        }
        synchronized (this) {
            if (this.e == null) {
                com.liulishuo.filedownloader.database.FileDownloadDatabase createDatabase = c().createDatabase();
                this.e = createDatabase;
                e(createDatabase.maintainer());
            }
        }
        return this.e;
    }

    public com.liulishuo.filedownloader.services.ForegroundServiceConfig getForegroundConfigInstance() {
        com.liulishuo.filedownloader.services.ForegroundServiceConfig foregroundServiceConfig = this.g;
        if (foregroundServiceConfig != null) {
            return foregroundServiceConfig;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = c().createForegroundServiceConfig();
            }
        }
        return this.g;
    }

    public com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator getIdGeneratorInstance() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator idGenerator = this.f;
        if (idGenerator != null) {
            return idGenerator;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = c().createIdGenerator();
            }
        }
        return this.f;
    }

    public int getMaxNetworkThreadCount() {
        return c().getMaxNetworkThreadCount();
    }

    public boolean isSupportSeek() {
        return d().supportSeek();
    }

    public void setInitCustomMaker(com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker) {
        synchronized (this) {
            this.a = new com.liulishuo.filedownloader.services.DownloadMgrInitialParams(initCustomMaker);
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }
}
