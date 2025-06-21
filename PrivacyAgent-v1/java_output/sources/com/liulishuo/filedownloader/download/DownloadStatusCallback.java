package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class DownloadStatusCallback implements android.os.Handler.Callback {
    public android.os.HandlerThread A;
    public volatile java.lang.Thread C;
    public final com.liulishuo.filedownloader.model.FileDownloadModel n;
    public final com.liulishuo.filedownloader.download.DownloadStatusCallback.ProcessParams u;
    public final int v;
    public final int w;
    public final int x;
    public long y;
    public android.os.Handler z;
    public volatile boolean B = false;
    public volatile long D = 0;
    public final java.util.concurrent.atomic.AtomicLong E = new java.util.concurrent.atomic.AtomicLong();
    public final java.util.concurrent.atomic.AtomicBoolean F = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.atomic.AtomicBoolean G = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.atomic.AtomicBoolean H = new java.util.concurrent.atomic.AtomicBoolean(true);
    public final com.liulishuo.filedownloader.database.FileDownloadDatabase t = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getDatabaseInstance();

    public static class ProcessParams {
        public boolean a;
        public java.lang.Exception b;
        public int c;

        public void a(java.lang.Exception exc) {
            this.b = exc;
        }

        public void b(boolean z) {
            this.a = z;
        }

        public void c(int i) {
            this.c = i;
        }

        public java.lang.Exception getException() {
            return this.b;
        }

        public int getRetryingTimes() {
            return this.c;
        }

        public boolean isResuming() {
            return this.a;
        }
    }

    public DownloadStatusCallback(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, int i, int i2, int i3) {
        this.n = fileDownloadModel;
        this.w = i2 < 5 ? 5 : i2;
        this.x = i3;
        this.u = new com.liulishuo.filedownloader.download.DownloadStatusCallback.ProcessParams();
        this.v = i;
    }

    public static long a(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / j2;
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    public void b() {
        android.os.Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.A.quit();
            this.C = java.lang.Thread.currentThread();
            while (this.B) {
                java.util.concurrent.locks.LockSupport.parkNanos(java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.C = null;
        }
    }

    public final java.lang.Exception c(java.lang.Exception exc) {
        long length;
        java.lang.String tempFilePath = this.n.getTempFilePath();
        if ((!this.n.isChunked() && !com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().fileNonPreAllocation) || !(exc instanceof java.io.IOException) || !new java.io.File(tempFilePath).exists()) {
            return exc;
        }
        long freeSpaceBytes = com.liulishuo.filedownloader.util.FileDownloadUtils.getFreeSpaceBytes(tempFilePath);
        if (freeSpaceBytes > 4096) {
            return exc;
        }
        java.io.File file = new java.io.File(tempFilePath);
        if (file.exists()) {
            length = file.length();
        } else {
            com.liulishuo.filedownloader.util.FileDownloadLog.e(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new java.lang.Object[0]);
            length = 0;
        }
        return new com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException(freeSpaceBytes, 4096L, length, exc);
    }

    public final void d() throws java.io.IOException {
        u();
        this.n.setStatus((byte) -3);
        this.t.updateCompleted(this.n.getId(), this.n.getTotal());
        this.t.removeConnections(this.n.getId());
        t((byte) -3);
        if (com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().broadcastCompleted) {
            com.liulishuo.filedownloader.services.FileDownloadBroadcastHandler.sendCompletedBroadcast(this.n);
        }
    }

    public final void e(java.lang.Exception exc) {
        java.lang.Exception exc2;
        java.lang.Exception c = c(exc);
        if (c instanceof android.database.sqlite.SQLiteFullException) {
            i((android.database.sqlite.SQLiteFullException) c);
            exc2 = c;
        } else {
            try {
                this.n.setStatus((byte) -1);
                this.n.setErrMsg(exc.toString());
                this.t.updateError(this.n.getId(), c, this.n.getSoFar());
                exc2 = c;
            } catch (android.database.sqlite.SQLiteFullException e) {
                android.database.sqlite.SQLiteFullException sQLiteFullException = e;
                i(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.u.a(exc2);
        t((byte) -1);
    }

    public final void f() {
        this.n.setStatus((byte) -2);
        this.t.updatePause(this.n.getId(), this.n.getSoFar());
        t((byte) -2);
    }

    public final void g() {
        if (this.n.getSoFar() == this.n.getTotal()) {
            this.t.updateProgress(this.n.getId(), this.n.getSoFar());
            return;
        }
        if (this.G.compareAndSet(true, false)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.i(this, "handleProgress update model's status with progress", new java.lang.Object[0]);
            }
            this.n.setStatus((byte) 3);
        }
        if (this.F.compareAndSet(true, false)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.i(this, "handleProgress notify user progress status", new java.lang.Object[0]);
            }
            t((byte) 3);
        }
    }

    public final void h(java.lang.Exception exc, int i) {
        java.lang.Exception c = c(exc);
        this.u.a(c);
        this.u.c(this.v - i);
        this.n.setStatus((byte) 5);
        this.n.setErrMsg(c.toString());
        this.t.updateRetry(this.n.getId(), c);
        t((byte) 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(android.os.Message message) {
        this.B = true;
        int i = message.what;
        try {
            if (i != 3) {
                if (i == 5) {
                    h((java.lang.Exception) message.obj, message.arg1);
                }
                return true;
            }
            g();
            return true;
        } finally {
            this.B = false;
            if (this.C != null) {
                java.util.concurrent.locks.LockSupport.unpark(this.C);
            }
        }
    }

    public final void i(android.database.sqlite.SQLiteFullException sQLiteFullException) {
        int id = this.n.getId();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", java.lang.Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.n.setErrMsg(sQLiteFullException.toString());
        this.n.setStatus((byte) -1);
        this.t.remove(id);
        this.t.removeConnections(id);
    }

    public boolean isAlive() {
        android.os.HandlerThread handlerThread = this.A;
        return handlerThread != null && handlerThread.isAlive();
    }

    public final void j(long j) {
        boolean z;
        if (!this.H.compareAndSet(true, false)) {
            long j2 = j - this.D;
            if (this.y == -1 || this.E.get() < this.y || j2 < this.w) {
                z = false;
                if (z || !this.F.compareAndSet(false, true)) {
                }
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.i(this, "inspectNeedCallbackToUser need callback to user", new java.lang.Object[0]);
                }
                this.D = j;
                this.E.set(0L);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    public final boolean k() {
        if (this.n.isChunked()) {
            com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel = this.n;
            fileDownloadModel.setTotal(fileDownloadModel.getSoFar());
        } else if (this.n.getSoFar() != this.n.getTotal()) {
            n(new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("sofar[%d] not equal total[%d]", java.lang.Long.valueOf(this.n.getSoFar()), java.lang.Long.valueOf(this.n.getTotal()))));
            return true;
        }
        return false;
    }

    public void l() throws java.io.IOException {
        if (k()) {
            return;
        }
        d();
    }

    public void m(boolean z, long j, java.lang.String str, java.lang.String str2) throws java.lang.IllegalArgumentException {
        java.lang.String eTag = this.n.getETag();
        if (eTag != null && !eTag.equals(str)) {
            throw new java.lang.IllegalArgumentException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, eTag));
        }
        this.u.b(z);
        this.n.setStatus((byte) 2);
        this.n.setTotal(j);
        this.n.setETag(str);
        this.n.setFilename(str2);
        this.t.updateConnected(this.n.getId(), j, str, str2);
        t((byte) 2);
        this.y = a(j, this.x);
        this.G.compareAndSet(false, true);
    }

    public void n(java.lang.Exception exc) {
        e(exc);
    }

    public void o() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("source-status-callback");
        this.A = handlerThread;
        handlerThread.start();
        this.z = new android.os.Handler(this.A.getLooper(), this);
    }

    public void onPending() {
        this.n.setStatus((byte) 1);
        this.t.updatePending(this.n.getId());
        t((byte) 1);
    }

    public void p() {
        f();
    }

    public void q(long j) {
        this.E.addAndGet(j);
        this.n.increaseSoFar(j);
        j(android.os.SystemClock.elapsedRealtime());
        if (this.z == null) {
            g();
        } else if (this.F.get()) {
            v(this.z.obtainMessage(3));
        }
    }

    public void r(java.lang.Exception exc, int i) {
        this.E.set(0L);
        android.os.Handler handler = this.z;
        if (handler == null) {
            h(exc, i);
        } else {
            v(handler.obtainMessage(5, i, 0, exc));
        }
    }

    public void s() {
        this.n.setStatus((byte) 6);
        t((byte) 6);
        this.t.onTaskStart(this.n.getId());
    }

    public final void t(byte b) {
        if (b != -2) {
            com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().inflow(com.liulishuo.filedownloader.message.MessageSnapshotTaker.take(b, this.n, this.u));
        } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", java.lang.Integer.valueOf(this.n.getId()));
        }
    }

    public final void u() throws java.io.IOException {
        boolean z;
        java.lang.String tempFilePath = this.n.getTempFilePath();
        java.lang.String targetFilePath = this.n.getTargetFilePath();
        java.io.File file = new java.io.File(tempFilePath);
        try {
            java.io.File file2 = new java.io.File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new java.io.IOException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, java.lang.Long.valueOf(length)));
                }
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, java.lang.Long.valueOf(length), java.lang.Long.valueOf(file.length()));
            }
            z = !file.renameTo(file2);
            if (!z) {
                if (z && file.exists() && !file.delete()) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "delete the temp file(%s) failed, on completed downloading.", tempFilePath);
                    return;
                }
                return;
            }
            try {
                throw new java.io.IOException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Can't rename the  temp downloaded file(%s) to the target file(%s)", tempFilePath, targetFilePath));
            } catch (java.lang.Throwable th) {
                th = th;
                if (z && file.exists() && !file.delete()) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "delete the temp file(%s) failed, on completed downloading.", tempFilePath);
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = true;
        }
    }

    public final synchronized void v(android.os.Message message) {
        if (!this.A.isAlive()) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", java.lang.Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.z.sendMessage(message);
        } catch (java.lang.IllegalStateException e) {
            if (this.A.isAlive()) {
                throw e;
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", java.lang.Integer.valueOf(message.what));
            }
        }
    }
}
