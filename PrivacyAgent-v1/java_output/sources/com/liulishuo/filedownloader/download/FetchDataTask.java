package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class FetchDataTask {
    public final com.liulishuo.filedownloader.download.ProcessCallback a;
    public final int b;
    public final int c;
    public final com.liulishuo.filedownloader.download.DownloadRunnable d;
    public final com.liulishuo.filedownloader.connection.FileDownloadConnection e;
    public final boolean f;
    public final long g;
    public final long h;
    public final long i;
    public final java.lang.String j;
    public long k;
    public com.liulishuo.filedownloader.stream.FileDownloadOutputStream l;
    public volatile boolean m;
    public final com.liulishuo.filedownloader.database.FileDownloadDatabase n;
    public volatile long o;
    public volatile long p;

    public static class Builder {
        public com.liulishuo.filedownloader.download.DownloadRunnable a;
        public com.liulishuo.filedownloader.connection.FileDownloadConnection b;
        public com.liulishuo.filedownloader.download.ConnectionProfile c;
        public com.liulishuo.filedownloader.download.ProcessCallback d;
        public java.lang.String e;
        public java.lang.Boolean f;
        public java.lang.Integer g;
        public java.lang.Integer h;

        public com.liulishuo.filedownloader.download.FetchDataTask build() throws java.lang.IllegalArgumentException {
            com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection;
            com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile;
            java.lang.Integer num;
            if (this.f == null || (fileDownloadConnection = this.b) == null || (connectionProfile = this.c) == null || this.d == null || this.e == null || (num = this.h) == null || this.g == null) {
                throw new java.lang.IllegalArgumentException();
            }
            return new com.liulishuo.filedownloader.download.FetchDataTask(fileDownloadConnection, connectionProfile, this.a, num.intValue(), this.g.intValue(), this.f.booleanValue(), this.d, this.e, null);
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setCallback(com.liulishuo.filedownloader.download.ProcessCallback processCallback) {
            this.d = processCallback;
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setConnection(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
            this.b = fileDownloadConnection;
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setConnectionIndex(int i) {
            this.g = java.lang.Integer.valueOf(i);
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setConnectionProfile(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile) {
            this.c = connectionProfile;
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setDownloadId(int i) {
            this.h = java.lang.Integer.valueOf(i);
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setHost(com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable) {
            this.a = downloadRunnable;
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setPath(java.lang.String str) {
            this.e = str;
            return this;
        }

        public com.liulishuo.filedownloader.download.FetchDataTask.Builder setWifiRequired(boolean z) {
            this.f = java.lang.Boolean.valueOf(z);
            return this;
        }
    }

    public FetchDataTask(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection, com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile, com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable, int i, int i2, boolean z, com.liulishuo.filedownloader.download.ProcessCallback processCallback, java.lang.String str) {
        this.o = 0L;
        this.p = 0L;
        this.a = processCallback;
        this.j = str;
        this.e = fileDownloadConnection;
        this.f = z;
        this.d = downloadRunnable;
        this.c = i2;
        this.b = i;
        this.n = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getDatabaseInstance();
        this.g = connectionProfile.a;
        this.h = connectionProfile.c;
        this.k = connectionProfile.b;
        this.i = connectionProfile.d;
    }

    public /* synthetic */ FetchDataTask(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection, com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile, com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable, int i, int i2, boolean z, com.liulishuo.filedownloader.download.ProcessCallback processCallback, java.lang.String str, com.liulishuo.filedownloader.download.FetchDataTask.AnonymousClass1 anonymousClass1) {
        this(fileDownloadConnection, connectionProfile, downloadRunnable, i, i2, z, processCallback, str);
    }

    public final void a() {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (com.liulishuo.filedownloader.util.FileDownloadUtils.isNeedSync(this.k - this.o, elapsedRealtime - this.p)) {
            b();
            this.o = this.k;
            this.p = elapsedRealtime;
        }
    }

    public final void b() {
        boolean z;
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        try {
            this.l.flushAndSync();
            z = true;
        } catch (java.io.IOException e) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            int i = this.c;
            if (i >= 0) {
                this.n.updateConnectionModel(this.b, i, this.k);
            } else {
                this.a.syncProgressFromCache();
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.c), java.lang.Long.valueOf(this.k), java.lang.Long.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void pause() {
        this.m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ea, code lost:
    
        throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws java.io.IOException, java.lang.IllegalAccessException, java.lang.IllegalArgumentException, com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException {
        java.lang.Throwable th;
        com.liulishuo.filedownloader.stream.FileDownloadOutputStream fileDownloadOutputStream;
        if (this.m) {
            return;
        }
        long findContentLength = com.liulishuo.filedownloader.util.FileDownloadUtils.findContentLength(this.c, this.e);
        if (findContentLength == -1) {
            findContentLength = com.liulishuo.filedownloader.util.FileDownloadUtils.findContentLengthFromContentRange(this.e);
        }
        if (findContentLength == 0) {
            throw new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("there isn't any content need to download on %d-%d with the content-length is 0", java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.c)));
        }
        long j = this.i;
        if (j > 0 && findContentLength != j) {
            throw new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.h == -1 ? com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("range[%d-)", java.lang.Long.valueOf(this.k)) : com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("range[%d-%d)", java.lang.Long.valueOf(this.k), java.lang.Long.valueOf(this.h)), java.lang.Long.valueOf(this.i), java.lang.Long.valueOf(findContentLength), java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.c)));
        }
        long j2 = this.k;
        java.io.InputStream inputStream = null;
        try {
            boolean isSupportSeek = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().isSupportSeek();
            if (this.d != null && !isSupportSeek) {
                throw new java.lang.IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            fileDownloadOutputStream = com.liulishuo.filedownloader.util.FileDownloadUtils.createOutputStream(this.j);
            try {
                this.l = fileDownloadOutputStream;
                if (isSupportSeek) {
                    fileDownloadOutputStream.seek(this.k);
                }
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "start fetch(%d): range [%d, %d), seek to[%d]", java.lang.Integer.valueOf(this.c), java.lang.Long.valueOf(this.g), java.lang.Long.valueOf(this.h), java.lang.Long.valueOf(this.k));
                }
                inputStream = this.e.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.m) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileDownloadOutputStream != null) {
                        try {
                            b();
                        } finally {
                        }
                    }
                    if (fileDownloadOutputStream != null) {
                        try {
                            fileDownloadOutputStream.close();
                            return;
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                        if (fileDownloadOutputStream != null) {
                            try {
                                b();
                            } finally {
                                try {
                                    fileDownloadOutputStream.close();
                                    throw th;
                                } catch (java.io.IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        if (fileDownloadOutputStream != null) {
                            try {
                                fileDownloadOutputStream.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        long j3 = this.k - j2;
                        if (findContentLength != -1 && findContentLength != j3) {
                            throw new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(findContentLength), java.lang.Long.valueOf(this.g), java.lang.Long.valueOf(this.h), java.lang.Long.valueOf(this.k), java.lang.Long.valueOf(j2)));
                        }
                        this.a.onCompleted(this.d, this.g, this.h);
                        return;
                    }
                    fileDownloadOutputStream.write(bArr, 0, read);
                    long j4 = j2;
                    long j5 = read;
                    this.k += j5;
                    this.a.onProgress(j5);
                    a();
                    if (this.m) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                        try {
                            b();
                            try {
                                fileDownloadOutputStream.close();
                                return;
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                                return;
                            }
                        } finally {
                        }
                    } else {
                        if (this.f && com.liulishuo.filedownloader.util.FileDownloadUtils.isNetworkNotOnWifiType()) {
                            break;
                        }
                        j2 = j4;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (fileDownloadOutputStream != null) {
                    try {
                        b();
                    } finally {
                        try {
                            fileDownloadOutputStream.close();
                            throw th;
                        } catch (java.io.IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                }
                if (fileDownloadOutputStream == null) {
                    throw th;
                }
                try {
                    fileDownloadOutputStream.close();
                    throw th;
                } catch (java.io.IOException e10) {
                    e10.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileDownloadOutputStream = null;
        }
    }
}
