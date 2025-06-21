package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadMessageStation {
    public static final int DEFAULT_INTERVAL = 10;
    public static final int DEFAULT_SUB_PACKAGE_SIZE = 5;
    public static final java.util.concurrent.Executor e = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(5, "BlockCompleted");
    public static int f = 10;
    public static int g = 5;
    public final android.os.Handler a;
    public final java.util.concurrent.LinkedBlockingQueue<com.liulishuo.filedownloader.IFileDownloadMessenger> b;
    public final java.lang.Object c;
    public final java.util.ArrayList<com.liulishuo.filedownloader.IFileDownloadMessenger> d;

    /* renamed from: com.liulishuo.filedownloader.FileDownloadMessageStation$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.liulishuo.filedownloader.IFileDownloadMessenger n;

        public AnonymousClass1(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger) {
            this.n = iFileDownloadMessenger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.h();
        }
    }

    public static final class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloadMessageStation a = new com.liulishuo.filedownloader.FileDownloadMessageStation(null);
    }

    public static class UIHandlerCallback implements android.os.Handler.Callback {
        public UIHandlerCallback() {
        }

        public /* synthetic */ UIHandlerCallback(com.liulishuo.filedownloader.FileDownloadMessageStation.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a(java.util.ArrayList<com.liulishuo.filedownloader.IFileDownloadMessenger> arrayList) {
            java.util.Iterator<com.liulishuo.filedownloader.IFileDownloadMessenger> it = arrayList.iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.IFileDownloadMessenger next = it.next();
                if (!com.liulishuo.filedownloader.FileDownloadMessageStation.e(next)) {
                    next.h();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                ((com.liulishuo.filedownloader.IFileDownloadMessenger) message.obj).h();
            } else if (i == 2) {
                a((java.util.ArrayList) message.obj);
                com.liulishuo.filedownloader.FileDownloadMessageStation.getImpl().f();
            }
            return true;
        }
    }

    public FileDownloadMessageStation() {
        this.c = new java.lang.Object();
        this.d = new java.util.ArrayList<>();
        this.a = new android.os.Handler(android.os.Looper.getMainLooper(), new com.liulishuo.filedownloader.FileDownloadMessageStation.UIHandlerCallback(null));
        this.b = new java.util.concurrent.LinkedBlockingQueue<>();
    }

    public /* synthetic */ FileDownloadMessageStation(com.liulishuo.filedownloader.FileDownloadMessageStation.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static boolean e(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger) {
        if (!iFileDownloadMessenger.f()) {
            return false;
        }
        e.execute(new com.liulishuo.filedownloader.FileDownloadMessageStation.AnonymousClass1(iFileDownloadMessenger));
        return true;
    }

    public static com.liulishuo.filedownloader.FileDownloadMessageStation getImpl() {
        return com.liulishuo.filedownloader.FileDownloadMessageStation.HolderClass.a;
    }

    public static boolean isIntervalValid() {
        return f > 0;
    }

    public final void c(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger) {
        synchronized (this.c) {
            this.b.offer(iFileDownloadMessenger);
        }
        f();
    }

    public final void d(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger) {
        android.os.Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(1, iFileDownloadMessenger));
    }

    public final void f() {
        synchronized (this.c) {
            if (this.d.isEmpty()) {
                if (this.b.isEmpty()) {
                    return;
                }
                int i = 0;
                if (isIntervalValid()) {
                    int i2 = f;
                    int min = java.lang.Math.min(this.b.size(), g);
                    while (i < min) {
                        this.d.add(this.b.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.b.drainTo(this.d);
                }
                android.os.Handler handler = this.a;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.d), i);
            }
        }
    }

    public void g(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger) {
        h(iFileDownloadMessenger, false);
    }

    public void h(com.liulishuo.filedownloader.IFileDownloadMessenger iFileDownloadMessenger, boolean z) {
        if (iFileDownloadMessenger.i()) {
            iFileDownloadMessenger.h();
            return;
        }
        if (e(iFileDownloadMessenger)) {
            return;
        }
        if (!isIntervalValid() && !this.b.isEmpty()) {
            synchronized (this.c) {
                if (!this.b.isEmpty()) {
                    java.util.Iterator<com.liulishuo.filedownloader.IFileDownloadMessenger> it = this.b.iterator();
                    while (it.hasNext()) {
                        d(it.next());
                    }
                }
                this.b.clear();
            }
        }
        if (!isIntervalValid() || z) {
            d(iFileDownloadMessenger);
        } else {
            c(iFileDownloadMessenger);
        }
    }
}
