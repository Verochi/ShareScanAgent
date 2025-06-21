package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadLine {

    /* renamed from: com.liulishuo.filedownloader.FileDownloadLine$1, reason: invalid class name */
    public class AnonymousClass1 implements com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber {
        public final /* synthetic */ int a;
        public final /* synthetic */ android.app.Notification b;

        public AnonymousClass1(int i, android.app.Notification notification) {
            this.a = i;
            this.b = notification;
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public void a() {
            com.liulishuo.filedownloader.FileDownloader.getImpl().startForeground(this.a, this.b);
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public java.lang.Object getValue() {
            return null;
        }
    }

    /* renamed from: com.liulishuo.filedownloader.FileDownloadLine$2, reason: invalid class name */
    public class AnonymousClass2 implements com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber {
        public long a;
        public final /* synthetic */ int b;

        public AnonymousClass2(int i) {
            this.b = i;
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public void a() {
            this.a = com.liulishuo.filedownloader.FileDownloader.getImpl().getSoFar(this.b);
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public java.lang.Object getValue() {
            return java.lang.Long.valueOf(this.a);
        }
    }

    /* renamed from: com.liulishuo.filedownloader.FileDownloadLine$3, reason: invalid class name */
    public class AnonymousClass3 implements com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber {
        public long a;
        public final /* synthetic */ int b;

        public AnonymousClass3(int i) {
            this.b = i;
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public void a() {
            this.a = com.liulishuo.filedownloader.FileDownloader.getImpl().getTotal(this.b);
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public java.lang.Object getValue() {
            return java.lang.Long.valueOf(this.a);
        }
    }

    /* renamed from: com.liulishuo.filedownloader.FileDownloadLine$4, reason: invalid class name */
    public class AnonymousClass4 implements com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber {
        public byte a;
        public final /* synthetic */ int b;
        public final /* synthetic */ java.lang.String c;

        public AnonymousClass4(int i, java.lang.String str) {
            this.b = i;
            this.c = str;
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public void a() {
            this.a = com.liulishuo.filedownloader.FileDownloader.getImpl().getStatus(this.b, this.c);
        }

        @Override // com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber
        public java.lang.Object getValue() {
            return java.lang.Byte.valueOf(this.a);
        }
    }

    public static class ConnectListener implements java.lang.Runnable {
        public boolean n = false;
        public final com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber t;

        public ConnectListener(com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber connectSubscriber) {
            this.t = connectSubscriber;
        }

        public boolean a() {
            return this.n;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                this.t.a();
                this.n = true;
                notifyAll();
            }
        }
    }

    public interface ConnectSubscriber {
        void a();

        java.lang.Object getValue();
    }

    public final void a(com.liulishuo.filedownloader.FileDownloadLine.ConnectSubscriber connectSubscriber) {
        com.liulishuo.filedownloader.FileDownloadLine.ConnectListener connectListener = new com.liulishuo.filedownloader.FileDownloadLine.ConnectListener(connectSubscriber);
        synchronized (connectListener) {
            com.liulishuo.filedownloader.FileDownloader.getImpl().bindService(connectListener);
            if (!connectListener.a()) {
                if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                    throw new java.lang.IllegalThreadStateException("Sorry, FileDownloader can not block the main thread, because the system is also  callbacks ServiceConnection#onServiceConnected method in the main thread.");
                }
                try {
                    connectListener.wait(200000L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public long getSoFar(int i) {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            return com.liulishuo.filedownloader.FileDownloader.getImpl().getSoFar(i);
        }
        com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass2 anonymousClass2 = new com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass2(i);
        a(anonymousClass2);
        return ((java.lang.Long) anonymousClass2.getValue()).longValue();
    }

    public byte getStatus(int i, java.lang.String str) {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            return com.liulishuo.filedownloader.FileDownloader.getImpl().getStatus(i, str);
        }
        if (str != null && new java.io.File(str).exists()) {
            return (byte) -3;
        }
        com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass4 anonymousClass4 = new com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass4(i, str);
        a(anonymousClass4);
        return ((java.lang.Byte) anonymousClass4.getValue()).byteValue();
    }

    public long getTotal(int i) {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            return com.liulishuo.filedownloader.FileDownloader.getImpl().getTotal(i);
        }
        com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass3 anonymousClass3 = new com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass3(i);
        a(anonymousClass3);
        return ((java.lang.Long) anonymousClass3.getValue()).longValue();
    }

    public void startForeground(int i, android.app.Notification notification) {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            com.liulishuo.filedownloader.FileDownloader.getImpl().startForeground(i, notification);
        } else {
            a(new com.liulishuo.filedownloader.FileDownloadLine.AnonymousClass1(i, notification));
        }
    }
}
