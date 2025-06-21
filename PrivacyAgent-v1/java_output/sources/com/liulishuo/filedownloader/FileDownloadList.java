package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadList {
    public final java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> a;

    public static final class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloadList a = new com.liulishuo.filedownloader.FileDownloadList(null);
    }

    public FileDownloadList() {
        this.a = new java.util.ArrayList<>();
    }

    public /* synthetic */ FileDownloadList(com.liulishuo.filedownloader.FileDownloadList.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.liulishuo.filedownloader.FileDownloadList getImpl() {
        return com.liulishuo.filedownloader.FileDownloadList.HolderClass.a;
    }

    public void a(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        if (!iRunningTask.getOrigin().isAttached()) {
            iRunningTask.setAttachKeyDefault();
        }
        if (iRunningTask.getMessageHandler().getMessenger().m()) {
            b(iRunningTask);
        }
    }

    public void b(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        if (iRunningTask.isMarkedAdded2List()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(iRunningTask)) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "already has %s", iRunningTask);
            } else {
                iRunningTask.markAdded2List();
                this.a.add(iRunningTask);
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "add list in all %s %d %d", iRunningTask, java.lang.Byte.valueOf(iRunningTask.getOrigin().getStatus()), java.lang.Integer.valueOf(this.a.size()));
                }
            }
        }
    }

    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> c(int i, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (next.getOrigin().getListener() == fileDownloadListener && !next.getOrigin().isAttached()) {
                    next.setAttachKeyByQueue(i);
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> d(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (next.is(fileDownloadListener)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask[] e() {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask[] iRunningTaskArr;
        synchronized (this.a) {
            iRunningTaskArr = (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask[]) this.a.toArray(new com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask[this.a.size()]);
        }
        return iRunningTaskArr;
    }

    public int f(int i) {
        int i2;
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().is(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void g(java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list) {
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.a.clear();
        }
    }

    public com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask get(int i) {
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (next.is(i)) {
                    return next;
                }
            }
            return null;
        }
    }

    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> h(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (next.is(i) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> i(int i) {
        byte status;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.a) {
            java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.a.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask next = it.next();
                if (next.is(i) && !next.isOver() && (status = next.getOrigin().getStatus()) != 0 && status != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean j() {
        return this.a.isEmpty();
    }

    public boolean k(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        return this.a.isEmpty() || !this.a.contains(iRunningTask);
    }

    public int l() {
        return this.a.size();
    }

    public boolean remove(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask, com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        boolean remove;
        byte status = messageSnapshot.getStatus();
        synchronized (this.a) {
            remove = this.a.remove(iRunningTask);
            if (remove && this.a.size() == 0 && com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().isRunServiceForeground()) {
                com.liulishuo.filedownloader.FileDownloader.getImpl().stopForeground(true);
            }
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG && this.a.size() == 0) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "remove %s left %d %d", iRunningTask, java.lang.Byte.valueOf(status), java.lang.Integer.valueOf(this.a.size()));
        }
        if (remove) {
            com.liulishuo.filedownloader.IFileDownloadMessenger messenger = iRunningTask.getMessageHandler().getMessenger();
            if (status == -4) {
                messenger.n(messageSnapshot);
            } else if (status == -3) {
                messenger.o(com.liulishuo.filedownloader.message.MessageSnapshotTaker.takeBlockCompleted(messageSnapshot));
            } else if (status == -2) {
                messenger.c(messageSnapshot);
            } else if (status == -1) {
                messenger.j(messageSnapshot);
            }
        } else {
            com.liulishuo.filedownloader.util.FileDownloadLog.e(this, "remove error, not exist: %s %d", iRunningTask, java.lang.Byte.valueOf(status));
        }
        return remove;
    }
}
