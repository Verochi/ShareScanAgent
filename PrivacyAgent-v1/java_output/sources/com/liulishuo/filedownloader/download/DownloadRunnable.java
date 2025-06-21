package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class DownloadRunnable implements java.lang.Runnable {
    public final com.liulishuo.filedownloader.download.ConnectTask n;
    public final com.liulishuo.filedownloader.download.ProcessCallback t;
    public final java.lang.String u;
    public final boolean v;
    public com.liulishuo.filedownloader.download.FetchDataTask w;
    public volatile boolean x;
    public final int y;
    public final int z;

    public static class Builder {
        public final com.liulishuo.filedownloader.download.ConnectTask.Builder a = new com.liulishuo.filedownloader.download.ConnectTask.Builder();
        public com.liulishuo.filedownloader.download.ProcessCallback b;
        public java.lang.String c;
        public java.lang.Boolean d;
        public java.lang.Integer e;

        public com.liulishuo.filedownloader.download.DownloadRunnable build() {
            if (this.b == null || this.c == null || this.d == null || this.e == null) {
                throw new java.lang.IllegalArgumentException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("%s %s %B", this.b, this.c, this.d));
            }
            com.liulishuo.filedownloader.download.ConnectTask a = this.a.a();
            return new com.liulishuo.filedownloader.download.DownloadRunnable(a.a, this.e.intValue(), a, this.b, this.d.booleanValue(), this.c, null);
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setCallback(com.liulishuo.filedownloader.download.ProcessCallback processCallback) {
            this.b = processCallback;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setConnectionIndex(java.lang.Integer num) {
            this.e = num;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setConnectionModel(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile) {
            this.a.b(connectionProfile);
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setEtag(java.lang.String str) {
            this.a.d(str);
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setHeader(com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader) {
            this.a.e(fileDownloadHeader);
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setId(int i) {
            this.a.c(i);
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setPath(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setUrl(java.lang.String str) {
            this.a.f(str);
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadRunnable.Builder setWifiRequired(boolean z) {
            this.d = java.lang.Boolean.valueOf(z);
            return this;
        }
    }

    public DownloadRunnable(int i, int i2, com.liulishuo.filedownloader.download.ConnectTask connectTask, com.liulishuo.filedownloader.download.ProcessCallback processCallback, boolean z, java.lang.String str) {
        this.y = i;
        this.z = i2;
        this.x = false;
        this.t = processCallback;
        this.u = str;
        this.n = connectTask;
        this.v = z;
    }

    public /* synthetic */ DownloadRunnable(int i, int i2, com.liulishuo.filedownloader.download.ConnectTask connectTask, com.liulishuo.filedownloader.download.ProcessCallback processCallback, boolean z, java.lang.String str, com.liulishuo.filedownloader.download.DownloadRunnable.AnonymousClass1 anonymousClass1) {
        this(i, i2, connectTask, processCallback, z, str);
    }

    public final long a() {
        com.liulishuo.filedownloader.database.FileDownloadDatabase databaseInstance = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getDatabaseInstance();
        if (this.z < 0) {
            com.liulishuo.filedownloader.model.FileDownloadModel find = databaseInstance.find(this.y);
            if (find != null) {
                return find.getSoFar();
            }
            return 0L;
        }
        for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : databaseInstance.findConnectionModel(this.y)) {
            if (connectionModel.getIndex() == this.z) {
                return connectionModel.getCurrentOffset();
            }
        }
        return 0L;
    }

    public void discard() {
        pause();
    }

    public void pause() {
        this.x = true;
        com.liulishuo.filedownloader.download.FetchDataTask fetchDataTask = this.w;
        if (fetchDataTask != null) {
            fetchDataTask.pause();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        java.lang.Exception e;
        com.liulishuo.filedownloader.download.FetchDataTask.Builder builder;
        android.os.Process.setThreadPriority(10);
        long j = this.n.getProfile().b;
        com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection = null;
        boolean z2 = false;
        while (!this.x) {
            try {
                try {
                    fileDownloadConnection = this.n.c();
                    int responseCode = fileDownloadConnection.getResponseCode();
                    if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the connection[%d] for %d, is connected %s with code[%d]", java.lang.Integer.valueOf(this.z), java.lang.Integer.valueOf(this.y), this.n.getProfile(), java.lang.Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new java.net.SocketException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.n.getRequestHeader(), fileDownloadConnection.getResponseHeaderFields(), java.lang.Integer.valueOf(responseCode), java.lang.Integer.valueOf(this.y), java.lang.Integer.valueOf(this.z)));
                    }
                    try {
                        builder = new com.liulishuo.filedownloader.download.FetchDataTask.Builder();
                    } catch (com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException | java.io.IOException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException e2) {
                        e = e2;
                        z = true;
                        try {
                            if (!this.t.isRetry(e)) {
                                this.t.onError(e);
                                if (fileDownloadConnection == null) {
                                    return;
                                }
                            } else if (z && this.w == null) {
                                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                this.t.onError(e);
                                if (fileDownloadConnection == null) {
                                    return;
                                }
                            } else {
                                if (this.w != null) {
                                    long a = a();
                                    if (a > 0) {
                                        this.n.g(a);
                                    }
                                }
                                this.t.onRetry(e);
                                if (fileDownloadConnection != null) {
                                    fileDownloadConnection.ending();
                                }
                                z2 = z;
                            }
                            return;
                        } finally {
                            if (fileDownloadConnection != null) {
                                fileDownloadConnection.ending();
                            }
                        }
                    }
                } catch (com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException | java.io.IOException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException e3) {
                    e = e3;
                    z = false;
                }
            } catch (com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException | java.io.IOException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException e4) {
                z = z2;
                e = e4;
            }
            if (this.x) {
                fileDownloadConnection.ending();
                return;
            }
            com.liulishuo.filedownloader.download.FetchDataTask build = builder.setDownloadId(this.y).setConnectionIndex(this.z).setCallback(this.t).setHost(this).setWifiRequired(this.v).setConnection(fileDownloadConnection).setConnectionProfile(this.n.getProfile()).setPath(this.u).build();
            this.w = build;
            build.run();
            if (this.x) {
                this.w.pause();
            }
            return;
        }
        if (fileDownloadConnection != null) {
            fileDownloadConnection.ending();
        }
    }
}
