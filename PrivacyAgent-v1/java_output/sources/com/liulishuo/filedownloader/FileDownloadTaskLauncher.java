package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
class FileDownloadTaskLauncher {
    public final com.liulishuo.filedownloader.FileDownloadTaskLauncher.LaunchTaskPool a = new com.liulishuo.filedownloader.FileDownloadTaskLauncher.LaunchTaskPool();

    public static class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloadTaskLauncher a = new com.liulishuo.filedownloader.FileDownloadTaskLauncher();

        static {
            com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().setReceiver(new com.liulishuo.filedownloader.MessageSnapshotGate());
        }
    }

    public static class LaunchTaskPool {
        public java.util.concurrent.ThreadPoolExecutor a;
        public java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> b;

        public LaunchTaskPool() {
            e();
        }

        public void a(com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter) {
            this.a.execute(new com.liulishuo.filedownloader.FileDownloadTaskLauncher.LaunchTaskRunnable(iStarter));
        }

        public void b(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
            if (fileDownloadListener == null) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "want to expire by listener, but the listener provided is null", new java.lang.Object[0]);
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<java.lang.Runnable> it = this.b.iterator();
            while (it.hasNext()) {
                java.lang.Runnable next = it.next();
                com.liulishuo.filedownloader.FileDownloadTaskLauncher.LaunchTaskRunnable launchTaskRunnable = (com.liulishuo.filedownloader.FileDownloadTaskLauncher.LaunchTaskRunnable) next;
                if (launchTaskRunnable.b(fileDownloadListener)) {
                    launchTaskRunnable.a();
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "expire %d tasks with listener[%s]", java.lang.Integer.valueOf(arrayList.size()), fileDownloadListener);
            }
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.a.remove((java.lang.Runnable) it2.next());
            }
        }

        public void c(com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter) {
            this.b.remove(iStarter);
        }

        public void d() {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "expire %d tasks", java.lang.Integer.valueOf(this.b.size()));
            }
            this.a.shutdownNow();
            e();
        }

        public final void e() {
            java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue<>();
            this.b = linkedBlockingQueue;
            this.a = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(3, linkedBlockingQueue, "LauncherTask");
        }
    }

    public static class LaunchTaskRunnable implements java.lang.Runnable {
        public final com.liulishuo.filedownloader.ITaskHunter.IStarter n;
        public boolean t = false;

        public LaunchTaskRunnable(com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter) {
            this.n = iStarter;
        }

        public void a() {
            this.t = true;
        }

        public boolean b(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
            com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter = this.n;
            return iStarter != null && iStarter.equalListener(fileDownloadListener);
        }

        public boolean equals(java.lang.Object obj) {
            return super.equals(obj) || obj == this.n;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.t) {
                return;
            }
            this.n.start();
        }
    }

    public static com.liulishuo.filedownloader.FileDownloadTaskLauncher d() {
        return com.liulishuo.filedownloader.FileDownloadTaskLauncher.HolderClass.a;
    }

    public synchronized void a(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        this.a.b(fileDownloadListener);
    }

    public synchronized void b(com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter) {
        this.a.c(iStarter);
    }

    public synchronized void c() {
        this.a.d();
    }

    public synchronized void e(com.liulishuo.filedownloader.ITaskHunter.IStarter iStarter) {
        this.a.a(iStarter);
    }
}
