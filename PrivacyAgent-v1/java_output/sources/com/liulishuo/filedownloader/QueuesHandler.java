package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
class QueuesHandler implements com.liulishuo.filedownloader.IQueuesHandler {
    public final android.util.SparseArray<android.os.Handler> a = new android.util.SparseArray<>();

    public static class SerialFinishListener implements com.liulishuo.filedownloader.BaseDownloadTask.FinishListener {
        public final java.lang.ref.WeakReference<com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback> a;
        public int b;

        public SerialFinishListener(java.lang.ref.WeakReference<com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback> weakReference) {
            this.a = weakReference;
        }

        public /* synthetic */ SerialFinishListener(java.lang.ref.WeakReference weakReference, com.liulishuo.filedownloader.QueuesHandler.AnonymousClass1 anonymousClass1) {
            this(weakReference);
        }

        public com.liulishuo.filedownloader.BaseDownloadTask.FinishListener a(int i) {
            this.b = i;
            return this;
        }

        @Override // com.liulishuo.filedownloader.BaseDownloadTask.FinishListener
        public void over(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
            java.lang.ref.WeakReference<com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a.get().c(this.b);
        }
    }

    public class SerialHandlerCallback implements android.os.Handler.Callback {
        public android.os.Handler n;
        public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> t;
        public int u = 0;
        public com.liulishuo.filedownloader.QueuesHandler.SerialFinishListener v = new com.liulishuo.filedownloader.QueuesHandler.SerialFinishListener(new java.lang.ref.WeakReference(this), null);

        public SerialHandlerCallback() {
        }

        public void b() {
            this.t.get(this.u).getOrigin().removeFinishListener(this.v);
            this.n.removeCallbacksAndMessages(null);
        }

        public final void c(int i) {
            android.os.Handler handler = this.n;
            if (handler == null || this.t == null) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "need go next %d, but params is not ready %s %s", java.lang.Integer.valueOf(i), this.n, this.t);
                return;
            }
            android.os.Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                java.lang.Object[] objArr = new java.lang.Object[2];
                java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list = this.t;
                com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener = null;
                if (list != null && list.get(0) != null) {
                    fileDownloadListener = this.t.get(0).getOrigin().getListener();
                }
                objArr[0] = fileDownloadListener;
                objArr[1] = java.lang.Integer.valueOf(obtainMessage.arg1);
                com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback.class, "start next %s %s", objArr);
            }
            this.n.sendMessage(obtainMessage);
        }

        public void d(android.os.Handler handler) {
            this.n = handler;
        }

        public void e(java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list) {
            this.t = list;
        }

        public void f() {
            c(this.u);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                if (message.arg1 < this.t.size()) {
                    int i2 = message.arg1;
                    this.u = i2;
                    com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = this.t.get(i2);
                    synchronized (iRunningTask.getPauseLock()) {
                        if (iRunningTask.getOrigin().getStatus() == 0 && !com.liulishuo.filedownloader.FileDownloadList.getImpl().k(iRunningTask)) {
                            iRunningTask.getOrigin().addFinishListener(this.v.a(this.u + 1));
                            iRunningTask.startTaskByQueue();
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback.class, "direct go next by not contains %s %d", iRunningTask, java.lang.Integer.valueOf(message.arg1));
                        }
                        c(message.arg1 + 1);
                        return true;
                    }
                }
                synchronized (com.liulishuo.filedownloader.QueuesHandler.this.a) {
                    com.liulishuo.filedownloader.QueuesHandler.this.a.remove(this.t.get(0).getAttachKey());
                }
                android.os.Handler handler = this.n;
                com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener = null;
                if (handler != null && handler.getLooper() != null) {
                    this.n.getLooper().quit();
                    this.n = null;
                    this.t = null;
                    this.v = null;
                }
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    java.lang.Object[] objArr = new java.lang.Object[2];
                    java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list = this.t;
                    if (list != null && list.get(0) != null) {
                        fileDownloadListener = this.t.get(0).getOrigin().getListener();
                    }
                    objArr[0] = fileDownloadListener;
                    objArr[1] = java.lang.Integer.valueOf(message.arg1);
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback.class, "final serial %s %d", objArr);
                }
                return true;
            }
            if (i == 2) {
                b();
            } else if (i == 3) {
                f();
            }
            return true;
        }
    }

    public final void b(android.os.Handler handler) {
        handler.sendEmptyMessage(2);
    }

    public final boolean c(int i, java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener, boolean z) {
        if (com.liulishuo.filedownloader.FileDownloadMonitor.isValid()) {
            com.liulishuo.filedownloader.FileDownloadMonitor.getMonitor().onRequestStart(list.size(), true, fileDownloadListener);
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(com.liulishuo.filedownloader.FileDownloader.class, "start list attachKey[%d] size[%d] listener[%s] isSerial[%B]", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(list.size()), fileDownloadListener, java.lang.Boolean.valueOf(z));
        }
        if (list != null && !list.isEmpty()) {
            return false;
        }
        com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.FileDownloader.class, "Tasks with the listener can't start, because can't find any task with the provided listener, maybe tasks instance has been started in the past, so they are all are inUsing, if in this case, you can use [BaseDownloadTask#reuse] to reuse theme first then start again: [%s, %B]", fileDownloadListener, java.lang.Boolean.valueOf(z));
        return true;
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public boolean contain(int i) {
        return this.a.get(i) != null;
    }

    public final void d(android.os.Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public void freezeAllSerialQueues() {
        for (int i = 0; i < this.a.size(); i++) {
            b(this.a.get(this.a.keyAt(i)));
        }
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public int serialQueueSize() {
        return this.a.size();
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public boolean startQueueParallel(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        int hashCode = fileDownloadListener.hashCode();
        java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> c = com.liulishuo.filedownloader.FileDownloadList.getImpl().c(hashCode, fileDownloadListener);
        if (c(hashCode, c, fileDownloadListener, false)) {
            return false;
        }
        java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = c.iterator();
        while (it.hasNext()) {
            it.next().startTaskByQueue();
        }
        return true;
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public boolean startQueueSerial(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback serialHandlerCallback = new com.liulishuo.filedownloader.QueuesHandler.SerialHandlerCallback();
        int hashCode = serialHandlerCallback.hashCode();
        java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> c = com.liulishuo.filedownloader.FileDownloadList.getImpl().c(hashCode, fileDownloadListener);
        if (c(hashCode, c, fileDownloadListener, true)) {
            return false;
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("filedownloader serial thread %s-%d", fileDownloadListener, java.lang.Integer.valueOf(hashCode)));
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper(), serialHandlerCallback);
        serialHandlerCallback.d(handler);
        serialHandlerCallback.e(c);
        serialHandlerCallback.c(0);
        synchronized (this.a) {
            this.a.put(hashCode, handler);
        }
        return true;
    }

    @Override // com.liulishuo.filedownloader.IQueuesHandler
    public void unFreezeSerialQueues(java.util.List<java.lang.Integer> list) {
        java.util.Iterator<java.lang.Integer> it = list.iterator();
        while (it.hasNext()) {
            d(this.a.get(it.next().intValue()));
        }
    }
}
