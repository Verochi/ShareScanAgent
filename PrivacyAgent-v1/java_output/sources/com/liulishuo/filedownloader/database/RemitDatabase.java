package com.liulishuo.filedownloader.database;

/* loaded from: classes23.dex */
public class RemitDatabase implements com.liulishuo.filedownloader.database.FileDownloadDatabase {
    public android.os.Handler c;
    public volatile java.lang.Thread g;
    public final java.util.List<java.lang.Integer> e = new java.util.ArrayList();
    public java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger();
    public final com.liulishuo.filedownloader.database.NoDatabaseImpl a = new com.liulishuo.filedownloader.database.NoDatabaseImpl();
    public final com.liulishuo.filedownloader.database.SqliteDatabaseImpl b = new com.liulishuo.filedownloader.database.SqliteDatabaseImpl();
    public final long d = com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().downloadMinProgressTime;

    /* renamed from: com.liulishuo.filedownloader.database.RemitDatabase$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                if (com.liulishuo.filedownloader.database.RemitDatabase.this.g != null) {
                    java.util.concurrent.locks.LockSupport.unpark(com.liulishuo.filedownloader.database.RemitDatabase.this.g);
                    com.liulishuo.filedownloader.database.RemitDatabase.this.g = null;
                }
                return false;
            }
            try {
                com.liulishuo.filedownloader.database.RemitDatabase.this.f.set(i);
                com.liulishuo.filedownloader.database.RemitDatabase.this.h(i);
                com.liulishuo.filedownloader.database.RemitDatabase.this.e.add(java.lang.Integer.valueOf(i));
                return false;
            } finally {
                com.liulishuo.filedownloader.database.RemitDatabase.this.f.set(0);
                if (com.liulishuo.filedownloader.database.RemitDatabase.this.g != null) {
                    java.util.concurrent.locks.LockSupport.unpark(com.liulishuo.filedownloader.database.RemitDatabase.this.g);
                    com.liulishuo.filedownloader.database.RemitDatabase.this.g = null;
                }
            }
        }
    }

    public static class Maker implements com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker {
        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker
        public com.liulishuo.filedownloader.database.FileDownloadDatabase customMake() {
            return new com.liulishuo.filedownloader.database.RemitDatabase();
        }
    }

    public RemitDatabase() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(com.liulishuo.filedownloader.util.FileDownloadUtils.getThreadPoolName("RemitHandoverToDB"));
        handlerThread.start();
        this.c = new android.os.Handler(handlerThread.getLooper(), new com.liulishuo.filedownloader.database.RemitDatabase.AnonymousClass1());
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void clear() {
        this.a.clear();
        this.b.clear();
    }

    public final void f(int i) {
        this.c.removeMessages(i);
        if (this.f.get() != i) {
            h(i);
            return;
        }
        this.g = java.lang.Thread.currentThread();
        this.c.sendEmptyMessage(0);
        java.util.concurrent.locks.LockSupport.park();
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.model.FileDownloadModel find(int i) {
        return this.a.find(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel(int i) {
        return this.a.findConnectionModel(i);
    }

    public final boolean g(int i) {
        return !this.e.contains(java.lang.Integer.valueOf(i));
    }

    public final void h(int i) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "sync cache to db %d", java.lang.Integer.valueOf(i));
        }
        this.b.update(this.a.find(i));
        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel = this.a.findConnectionModel(i);
        this.b.removeConnections(i);
        java.util.Iterator<com.liulishuo.filedownloader.model.ConnectionModel> it = findConnectionModel.iterator();
        while (it.hasNext()) {
            this.b.insertConnectionModel(it.next());
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insert(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        this.a.insert(fileDownloadModel);
        if (g(fileDownloadModel.getId())) {
            return;
        }
        this.b.insert(fileDownloadModel);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insertConnectionModel(com.liulishuo.filedownloader.model.ConnectionModel connectionModel) {
        this.a.insertConnectionModel(connectionModel);
        if (g(connectionModel.getId())) {
            return;
        }
        this.b.insertConnectionModel(connectionModel);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer() {
        com.liulishuo.filedownloader.database.SqliteDatabaseImpl sqliteDatabaseImpl = this.b;
        com.liulishuo.filedownloader.database.NoDatabaseImpl noDatabaseImpl = this.a;
        return sqliteDatabaseImpl.maintainer(noDatabaseImpl.a, noDatabaseImpl.b);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void onTaskStart(int i) {
        this.c.sendEmptyMessageDelayed(i, this.d);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public boolean remove(int i) {
        this.b.remove(i);
        return this.a.remove(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void removeConnections(int i) {
        this.a.removeConnections(i);
        if (g(i)) {
            return;
        }
        this.b.removeConnections(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void update(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        this.a.update(fileDownloadModel);
        if (g(fileDownloadModel.getId())) {
            return;
        }
        this.b.update(fileDownloadModel);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateCompleted(int i, long j) {
        this.a.updateCompleted(i, j);
        if (g(i)) {
            this.c.removeMessages(i);
            if (this.f.get() == i) {
                this.g = java.lang.Thread.currentThread();
                this.c.sendEmptyMessage(0);
                java.util.concurrent.locks.LockSupport.park();
                this.b.updateCompleted(i, j);
            }
        } else {
            this.b.updateCompleted(i, j);
        }
        this.e.remove(java.lang.Integer.valueOf(i));
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        this.a.updateConnected(i, j, str, str2);
        if (g(i)) {
            return;
        }
        this.b.updateConnected(i, j, str, str2);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionCount(int i, int i2) {
        this.a.updateConnectionCount(i, i2);
        if (g(i)) {
            return;
        }
        this.b.updateConnectionCount(i, i2);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionModel(int i, int i2, long j) {
        this.a.updateConnectionModel(i, i2, j);
        if (g(i)) {
            return;
        }
        this.b.updateConnectionModel(i, i2, j);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateError(int i, java.lang.Throwable th, long j) {
        this.a.updateError(i, th, j);
        if (g(i)) {
            f(i);
        }
        this.b.updateError(i, th, j);
        this.e.remove(java.lang.Integer.valueOf(i));
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateOldEtagOverdue(int i, java.lang.String str, long j, long j2, int i2) {
        this.a.updateOldEtagOverdue(i, str, j, j2, i2);
        if (g(i)) {
            return;
        }
        this.b.updateOldEtagOverdue(i, str, j, j2, i2);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePause(int i, long j) {
        this.a.updatePause(i, j);
        if (g(i)) {
            f(i);
        }
        this.b.updatePause(i, j);
        this.e.remove(java.lang.Integer.valueOf(i));
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePending(int i) {
        this.a.updatePending(i);
        if (g(i)) {
            return;
        }
        this.b.updatePending(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateProgress(int i, long j) {
        this.a.updateProgress(i, j);
        if (g(i)) {
            return;
        }
        this.b.updateProgress(i, j);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateRetry(int i, java.lang.Throwable th) {
        this.a.updateRetry(i, th);
        if (g(i)) {
            return;
        }
        this.b.updateRetry(i, th);
    }
}
