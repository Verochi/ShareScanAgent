package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadLineAsync {

    /* renamed from: com.liulishuo.filedownloader.FileDownloadLineAsync$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ android.app.Notification t;

        public AnonymousClass1(int i, android.app.Notification notification) {
            this.n = i;
            this.t = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.liulishuo.filedownloader.FileDownloader.getImpl().startForeground(this.n, this.t);
        }
    }

    public boolean startForeground(int i, android.app.Notification notification) {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            com.liulishuo.filedownloader.FileDownloader.getImpl().startForeground(i, notification);
            return true;
        }
        com.liulishuo.filedownloader.FileDownloader.getImpl().bindService(new com.liulishuo.filedownloader.FileDownloadLineAsync.AnonymousClass1(i, notification));
        return false;
    }
}
