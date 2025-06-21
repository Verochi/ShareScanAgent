package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public class DownloadMgrInitialParams {
    public final com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker a;

    public static class InitCustomMaker {
        public com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker a;
        public java.lang.Integer b;
        public com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator c;
        public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator d;
        public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter e;
        public com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator f;
        public com.liulishuo.filedownloader.services.ForegroundServiceConfig g;

        public void commit() {
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker connectionCountAdapter(com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter) {
            this.e = connectionCountAdapter;
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker connectionCreator(com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator connectionCreator) {
            this.d = connectionCreator;
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker database(com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker databaseCustomMaker) {
            this.a = databaseCustomMaker;
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker foregroundServiceConfig(com.liulishuo.filedownloader.services.ForegroundServiceConfig foregroundServiceConfig) {
            this.g = foregroundServiceConfig;
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker idGenerator(com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator idGenerator) {
            this.f = idGenerator;
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker maxNetworkThreadCount(int i) {
            if (i > 0) {
                this.b = java.lang.Integer.valueOf(i);
            }
            return this;
        }

        public com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker outputStreamCreator(com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator outputStreamCreator) {
            this.c = outputStreamCreator;
            if (outputStreamCreator == null || outputStreamCreator.supportSeek() || com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().fileNonPreAllocation) {
                return this;
            }
            throw new java.lang.IllegalArgumentException("Since the provided FileDownloadOutputStream does not support the seek function, if FileDownloader pre-allocates file size at the beginning of the download, it will can not be resumed from the breakpoint. If you need to ensure that the resumption is available, please add and set the value of 'file.non-pre-allocation' field to 'true' in the 'filedownloader.properties' file which is in your application assets folder manually for resolving this problem.");
        }

        public java.lang.String toString() {
            return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.a, this.b, this.c, this.d, this.e);
        }
    }

    public DownloadMgrInitialParams() {
        this.a = null;
    }

    public DownloadMgrInitialParams(com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker) {
        this.a = initCustomMaker;
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter a() {
        return new com.liulishuo.filedownloader.connection.DefaultConnectionCountAdapter();
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator b() {
        return new com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Creator();
    }

    public final com.liulishuo.filedownloader.database.FileDownloadDatabase c() {
        return new com.liulishuo.filedownloader.database.RemitDatabase();
    }

    public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter createConnectionCountAdapter() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (connectionCountAdapter = initCustomMaker.e) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize connection count adapter: %s", connectionCountAdapter);
            }
            return connectionCountAdapter;
        }
        return a();
    }

    public com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator createConnectionCreator() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator connectionCreator;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (connectionCreator = initCustomMaker.d) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize connection creator: %s", connectionCreator);
            }
            return connectionCreator;
        }
        return b();
    }

    public com.liulishuo.filedownloader.database.FileDownloadDatabase createDatabase() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker databaseCustomMaker;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker == null || (databaseCustomMaker = initCustomMaker.a) == null) {
            return c();
        }
        com.liulishuo.filedownloader.database.FileDownloadDatabase customMake = databaseCustomMaker.customMake();
        if (customMake == null) {
            return c();
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize database: %s", customMake);
        }
        return customMake;
    }

    public com.liulishuo.filedownloader.services.ForegroundServiceConfig createForegroundServiceConfig() {
        com.liulishuo.filedownloader.services.ForegroundServiceConfig foregroundServiceConfig;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (foregroundServiceConfig = initCustomMaker.g) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize foreground service config: %s", foregroundServiceConfig);
            }
            return foregroundServiceConfig;
        }
        return d();
    }

    public com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator createIdGenerator() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator idGenerator;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (idGenerator = initCustomMaker.f) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize id generator: %s", idGenerator);
            }
            return idGenerator;
        }
        return e();
    }

    public com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator createOutputStreamCreator() {
        com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator outputStreamCreator;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (outputStreamCreator = initCustomMaker.c) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize output stream: %s", outputStreamCreator);
            }
            return outputStreamCreator;
        }
        return f();
    }

    public final com.liulishuo.filedownloader.services.ForegroundServiceConfig d() {
        return new com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder().needRecreateChannelId(true).build();
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator e() {
        return new com.liulishuo.filedownloader.services.DefaultIdGenerator();
    }

    public final com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator f() {
        return new com.liulishuo.filedownloader.stream.FileDownloadRandomAccessFile.Creator();
    }

    public final int g() {
        return com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().downloadMaxNetworkThreadCount;
    }

    public int getMaxNetworkThreadCount() {
        java.lang.Integer num;
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = this.a;
        if (initCustomMaker != null && (num = initCustomMaker.b) != null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.liulishuo.filedownloader.util.FileDownloadProperties.getValidNetworkThreadCount(num.intValue());
        }
        return g();
    }
}
