package com.liulishuo.filedownloader.event;

/* loaded from: classes23.dex */
public class DownloadEventPoolImpl implements com.liulishuo.filedownloader.event.IDownloadEventPool {
    public final java.util.concurrent.Executor a = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(10, "EventPool");
    public final java.util.HashMap<java.lang.String, java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener>> b = new java.util.HashMap<>();

    /* renamed from: com.liulishuo.filedownloader.event.DownloadEventPoolImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.liulishuo.filedownloader.event.IDownloadEvent n;

        public AnonymousClass1(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
            this.n = iDownloadEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.liulishuo.filedownloader.event.DownloadEventPoolImpl.this.publish(this.n);
        }
    }

    public final void a(java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener> linkedList, com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
        for (java.lang.Object obj : linkedList.toArray()) {
            if (obj != null && ((com.liulishuo.filedownloader.event.IDownloadListener) obj).callback(iDownloadEvent)) {
                break;
            }
        }
        java.lang.Runnable runnable = iDownloadEvent.callback;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean addListener(java.lang.String str, com.liulishuo.filedownloader.event.IDownloadListener iDownloadListener) {
        boolean add;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "setListener %s", str);
        }
        if (iDownloadListener == null) {
            throw new java.lang.IllegalArgumentException("listener must not be null!");
        }
        java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener> linkedList = this.b.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.b.get(str);
                if (linkedList == null) {
                    java.util.HashMap<java.lang.String, java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener>> hashMap = this.b;
                    java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener> linkedList2 = new java.util.LinkedList<>();
                    hashMap.put(str, linkedList2);
                    linkedList = linkedList2;
                }
            }
        }
        synchronized (str.intern()) {
            add = linkedList.add(iDownloadListener);
        }
        return add;
    }

    public void asyncPublishInNewThread(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "asyncPublishInNewThread %s", iDownloadEvent.getId());
        }
        if (iDownloadEvent == null) {
            throw new java.lang.IllegalArgumentException("event must not be null!");
        }
        this.a.execute(new com.liulishuo.filedownloader.event.DownloadEventPoolImpl.AnonymousClass1(iDownloadEvent));
    }

    public boolean publish(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "publish %s", iDownloadEvent.getId());
        }
        if (iDownloadEvent == null) {
            throw new java.lang.IllegalArgumentException("event must not be null!");
        }
        java.lang.String id = iDownloadEvent.getId();
        java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener> linkedList = this.b.get(id);
        if (linkedList == null) {
            synchronized (id.intern()) {
                linkedList = this.b.get(id);
                if (linkedList == null) {
                    if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "No listener for this event %s", id);
                    }
                    return false;
                }
            }
        }
        a(linkedList, iDownloadEvent);
        return true;
    }

    public boolean removeListener(java.lang.String str, com.liulishuo.filedownloader.event.IDownloadListener iDownloadListener) {
        boolean remove;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "removeListener %s", str);
        }
        java.util.LinkedList<com.liulishuo.filedownloader.event.IDownloadListener> linkedList = this.b.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.b.get(str);
            }
        }
        if (linkedList == null || iDownloadListener == null) {
            return false;
        }
        synchronized (str.intern()) {
            remove = linkedList.remove(iDownloadListener);
            if (linkedList.size() <= 0) {
                this.b.remove(str);
            }
        }
        return remove;
    }
}
