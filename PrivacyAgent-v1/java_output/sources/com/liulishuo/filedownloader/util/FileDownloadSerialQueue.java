package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadSerialQueue {
    public static final int ID_INVALID = 0;
    public final android.os.HandlerThread d;
    public final android.os.Handler e;
    public volatile com.liulishuo.filedownloader.BaseDownloadTask f;
    public final com.liulishuo.filedownloader.util.FileDownloadSerialQueue.SerialFinishCallback g;
    public final java.lang.Object a = new java.lang.Object();
    public final java.util.concurrent.BlockingQueue<com.liulishuo.filedownloader.BaseDownloadTask> b = new java.util.concurrent.LinkedBlockingQueue();
    public final java.util.List<com.liulishuo.filedownloader.BaseDownloadTask> c = new java.util.ArrayList();
    public volatile boolean h = false;

    public static class SerialFinishCallback implements com.liulishuo.filedownloader.BaseDownloadTask.FinishListener {
        public final java.lang.ref.WeakReference<com.liulishuo.filedownloader.util.FileDownloadSerialQueue> a;

        public SerialFinishCallback(java.lang.ref.WeakReference<com.liulishuo.filedownloader.util.FileDownloadSerialQueue> weakReference) {
            this.a = weakReference;
        }

        @Override // com.liulishuo.filedownloader.BaseDownloadTask.FinishListener
        public synchronized void over(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
            baseDownloadTask.removeFinishListener(this);
            java.lang.ref.WeakReference<com.liulishuo.filedownloader.util.FileDownloadSerialQueue> weakReference = this.a;
            if (weakReference == null) {
                return;
            }
            com.liulishuo.filedownloader.util.FileDownloadSerialQueue fileDownloadSerialQueue = weakReference.get();
            if (fileDownloadSerialQueue == null) {
                return;
            }
            fileDownloadSerialQueue.f = null;
            if (fileDownloadSerialQueue.h) {
                return;
            }
            fileDownloadSerialQueue.c();
        }
    }

    public class SerialLoop implements android.os.Handler.Callback {
        public SerialLoop() {
        }

        public /* synthetic */ SerialLoop(com.liulishuo.filedownloader.util.FileDownloadSerialQueue fileDownloadSerialQueue, com.liulishuo.filedownloader.util.FileDownloadSerialQueue.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            try {
                if (com.liulishuo.filedownloader.util.FileDownloadSerialQueue.this.h) {
                    return false;
                }
                com.liulishuo.filedownloader.util.FileDownloadSerialQueue fileDownloadSerialQueue = com.liulishuo.filedownloader.util.FileDownloadSerialQueue.this;
                fileDownloadSerialQueue.f = (com.liulishuo.filedownloader.BaseDownloadTask) fileDownloadSerialQueue.b.take();
                com.liulishuo.filedownloader.util.FileDownloadSerialQueue.this.f.addFinishListener(com.liulishuo.filedownloader.util.FileDownloadSerialQueue.this.g).start();
                return false;
            } catch (java.lang.InterruptedException unused) {
                return false;
            }
        }
    }

    public FileDownloadSerialQueue() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(com.liulishuo.filedownloader.util.FileDownloadUtils.getThreadPoolName("SerialDownloadManager"));
        this.d = handlerThread;
        handlerThread.start();
        this.e = new android.os.Handler(handlerThread.getLooper(), new com.liulishuo.filedownloader.util.FileDownloadSerialQueue.SerialLoop(this, null));
        this.g = new com.liulishuo.filedownloader.util.FileDownloadSerialQueue.SerialFinishCallback(new java.lang.ref.WeakReference(this));
        c();
    }

    public final void c() {
        this.e.sendEmptyMessage(1);
    }

    public void enqueue(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        synchronized (this.g) {
            if (this.h) {
                this.c.add(baseDownloadTask);
                return;
            }
            try {
                this.b.put(baseDownloadTask);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWaitingTaskCount() {
        return this.b.size() + this.c.size();
    }

    public int getWorkingTaskId() {
        if (this.f != null) {
            return this.f.getId();
        }
        return 0;
    }

    public void pause() {
        synchronized (this.g) {
            if (this.h) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "require pause this queue(remain %d), but it has already been paused", java.lang.Integer.valueOf(this.b.size()));
                return;
            }
            this.h = true;
            this.b.drainTo(this.c);
            if (this.f != null) {
                this.f.removeFinishListener(this.g);
                this.f.pause();
            }
        }
    }

    public void resume() {
        synchronized (this.g) {
            if (!this.h) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "require resume this queue(remain %d), but it is still running", java.lang.Integer.valueOf(this.b.size()));
                return;
            }
            this.h = false;
            this.b.addAll(this.c);
            this.c.clear();
            if (this.f == null) {
                c();
            } else {
                this.f.addFinishListener(this.g);
                this.f.start();
            }
        }
    }

    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask> shutdown() {
        java.util.ArrayList arrayList;
        synchronized (this.g) {
            if (this.f != null) {
                pause();
            }
            arrayList = new java.util.ArrayList(this.c);
            this.c.clear();
            this.e.removeMessages(1);
            this.d.interrupt();
            this.d.quit();
        }
        return arrayList;
    }
}
