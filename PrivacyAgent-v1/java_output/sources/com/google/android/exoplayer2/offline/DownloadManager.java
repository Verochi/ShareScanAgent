package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final com.google.android.exoplayer2.scheduler.Requirements DEFAULT_REQUIREMENTS = new com.google.android.exoplayer2.scheduler.Requirements(1);
    public final android.content.Context a;
    public final com.google.android.exoplayer2.offline.WritableDownloadIndex b;
    public final android.os.Handler c;
    public final com.google.android.exoplayer2.offline.DownloadManager.InternalHandler d;
    public final com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener e;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.offline.DownloadManager.Listener> f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public java.util.List<com.google.android.exoplayer2.offline.Download> o;
    public com.google.android.exoplayer2.scheduler.RequirementsWatcher p;

    public static final class DownloadUpdate {
        public final com.google.android.exoplayer2.offline.Download a;
        public final boolean b;
        public final java.util.List<com.google.android.exoplayer2.offline.Download> c;

        @androidx.annotation.Nullable
        public final java.lang.Exception d;

        public DownloadUpdate(com.google.android.exoplayer2.offline.Download download, boolean z, java.util.List<com.google.android.exoplayer2.offline.Download> list, @androidx.annotation.Nullable java.lang.Exception exc) {
            this.a = download;
            this.b = z;
            this.c = list;
            this.d = exc;
        }
    }

    public static final class InternalHandler extends android.os.Handler {
        public boolean a;
        public final android.os.HandlerThread b;
        public final com.google.android.exoplayer2.offline.WritableDownloadIndex c;
        public final com.google.android.exoplayer2.offline.DownloaderFactory d;
        public final android.os.Handler e;
        public final java.util.ArrayList<com.google.android.exoplayer2.offline.Download> f;
        public final java.util.HashMap<java.lang.String, com.google.android.exoplayer2.offline.DownloadManager.Task> g;
        public int h;
        public boolean i;
        public int j;
        public int k;
        public int l;

        public InternalHandler(android.os.HandlerThread handlerThread, com.google.android.exoplayer2.offline.WritableDownloadIndex writableDownloadIndex, com.google.android.exoplayer2.offline.DownloaderFactory downloaderFactory, android.os.Handler handler, int i, int i2, boolean z) {
            super(handlerThread.getLooper());
            this.b = handlerThread;
            this.c = writableDownloadIndex;
            this.d = downloaderFactory;
            this.e = handler;
            this.j = i;
            this.k = i2;
            this.i = z;
            this.f = new java.util.ArrayList<>();
            this.g = new java.util.HashMap<>();
        }

        public static int d(com.google.android.exoplayer2.offline.Download download, com.google.android.exoplayer2.offline.Download download2) {
            return com.google.android.exoplayer2.util.Util.compareLong(download.startTimeMs, download2.startTimeMs);
        }

        public static com.google.android.exoplayer2.offline.Download e(com.google.android.exoplayer2.offline.Download download, int i) {
            return new com.google.android.exoplayer2.offline.Download(download.request, i, download.startTimeMs, java.lang.System.currentTimeMillis(), download.contentLength, 0, 0, download.a);
        }

        public final void A(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.DownloadManager.Task task) {
            if (task != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(!task.v);
                task.e(false);
            }
        }

        public final void B() {
            int i = 0;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                com.google.android.exoplayer2.offline.Download download = this.f.get(i2);
                com.google.android.exoplayer2.offline.DownloadManager.Task task = this.g.get(download.request.id);
                int i3 = download.state;
                if (i3 == 0) {
                    task = y(task, download);
                } else if (i3 == 1) {
                    A(task);
                } else if (i3 == 2) {
                    com.google.android.exoplayer2.util.Assertions.checkNotNull(task);
                    x(task, download, i);
                } else {
                    if (i3 != 5 && i3 != 7) {
                        throw new java.lang.IllegalStateException();
                    }
                    z(task, download);
                }
                if (task != null && !task.v) {
                    i++;
                }
            }
        }

        public final void C() {
            for (int i = 0; i < this.f.size(); i++) {
                com.google.android.exoplayer2.offline.Download download = this.f.get(i);
                if (download.state == 2) {
                    try {
                        this.c.putDownload(download);
                    } catch (java.io.IOException e) {
                        com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to update index.", e);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000L);
        }

        public final void b(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i) {
            com.google.android.exoplayer2.offline.Download f = f(downloadRequest.id, true);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (f != null) {
                m(com.google.android.exoplayer2.offline.DownloadManager.d(f, downloadRequest, i, currentTimeMillis));
            } else {
                m(new com.google.android.exoplayer2.offline.Download(downloadRequest, i != 0 ? 1 : 0, currentTimeMillis, currentTimeMillis, -1L, i, 0));
            }
            B();
        }

        public final boolean c() {
            return !this.i && this.h == 0;
        }

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.offline.Download f(java.lang.String str, boolean z) {
            int g = g(str);
            if (g != -1) {
                return this.f.get(g);
            }
            if (!z) {
                return null;
            }
            try {
                return this.c.getDownload(str);
            } catch (java.io.IOException e) {
                java.lang.String valueOf = java.lang.String.valueOf(str);
                com.google.android.exoplayer2.util.Log.e("DownloadManager", valueOf.length() != 0 ? "Failed to load download: ".concat(valueOf) : new java.lang.String("Failed to load download: "), e);
                return null;
            }
        }

        public final int g(java.lang.String str) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).request.id.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public final void h(int i) {
            this.h = i;
            com.google.android.exoplayer2.offline.DownloadCursor downloadCursor = null;
            try {
                try {
                    this.c.setDownloadingStatesToQueued();
                    downloadCursor = this.c.getDownloads(0, 1, 2, 5, 7);
                    while (downloadCursor.moveToNext()) {
                        this.f.add(downloadCursor.getDownload());
                    }
                } catch (java.io.IOException e) {
                    com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to load index.", e);
                    this.f.clear();
                }
                com.google.android.exoplayer2.util.Util.closeQuietly(downloadCursor);
                this.e.obtainMessage(0, new java.util.ArrayList(this.f)).sendToTarget();
                B();
            } catch (java.lang.Throwable th) {
                com.google.android.exoplayer2.util.Util.closeQuietly(downloadCursor);
                throw th;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = 0;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 1:
                    r(message.arg1 != 0);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 2:
                    u(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 3:
                    w((java.lang.String) message.obj, message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 4:
                    s(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 5:
                    t(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 6:
                    b((com.google.android.exoplayer2.offline.DownloadRequest) message.obj, message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 7:
                    q((java.lang.String) message.obj);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 8:
                    p();
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 9:
                    l((com.google.android.exoplayer2.offline.DownloadManager.Task) message.obj);
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 10:
                    i((com.google.android.exoplayer2.offline.DownloadManager.Task) message.obj, com.google.android.exoplayer2.util.Util.toLong(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new java.lang.IllegalStateException();
            }
        }

        public final void i(com.google.android.exoplayer2.offline.DownloadManager.Task task, long j) {
            com.google.android.exoplayer2.offline.Download download = (com.google.android.exoplayer2.offline.Download) com.google.android.exoplayer2.util.Assertions.checkNotNull(f(task.n.id, false));
            if (j == download.contentLength || j == -1) {
                return;
            }
            m(new com.google.android.exoplayer2.offline.Download(download.request, download.state, download.startTimeMs, java.lang.System.currentTimeMillis(), j, download.stopReason, download.failureReason, download.a));
        }

        public final void j(com.google.android.exoplayer2.offline.Download download, @androidx.annotation.Nullable java.lang.Exception exc) {
            com.google.android.exoplayer2.offline.Download download2 = new com.google.android.exoplayer2.offline.Download(download.request, exc == null ? 3 : 4, download.startTimeMs, java.lang.System.currentTimeMillis(), download.contentLength, download.stopReason, exc == null ? 0 : 1, download.a);
            this.f.remove(g(download2.request.id));
            try {
                this.c.putDownload(download2);
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to update index.", e);
            }
            this.e.obtainMessage(2, new com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate(download2, false, new java.util.ArrayList(this.f), exc)).sendToTarget();
        }

        public final void k(com.google.android.exoplayer2.offline.Download download) {
            if (download.state == 7) {
                n(download, download.stopReason == 0 ? 0 : 1);
                B();
            } else {
                this.f.remove(g(download.request.id));
                try {
                    this.c.removeDownload(download.request.id);
                } catch (java.io.IOException unused) {
                    com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to remove from database");
                }
                this.e.obtainMessage(2, new com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate(download, true, new java.util.ArrayList(this.f), null)).sendToTarget();
            }
        }

        public final void l(com.google.android.exoplayer2.offline.DownloadManager.Task task) {
            java.lang.String str = task.n.id;
            this.g.remove(str);
            boolean z = task.v;
            if (!z) {
                int i = this.l - 1;
                this.l = i;
                if (i == 0) {
                    removeMessages(11);
                }
            }
            if (task.y) {
                B();
                return;
            }
            java.lang.Exception exc = task.z;
            if (exc != null) {
                java.lang.String valueOf = java.lang.String.valueOf(task.n);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 20);
                sb.append("Task failed: ");
                sb.append(valueOf);
                sb.append(", ");
                sb.append(z);
                com.google.android.exoplayer2.util.Log.e("DownloadManager", sb.toString(), exc);
            }
            com.google.android.exoplayer2.offline.Download download = (com.google.android.exoplayer2.offline.Download) com.google.android.exoplayer2.util.Assertions.checkNotNull(f(str, false));
            int i2 = download.state;
            if (i2 == 2) {
                com.google.android.exoplayer2.util.Assertions.checkState(!z);
                j(download, exc);
            } else {
                if (i2 != 5 && i2 != 7) {
                    throw new java.lang.IllegalStateException();
                }
                com.google.android.exoplayer2.util.Assertions.checkState(z);
                k(download);
            }
            B();
        }

        public final com.google.android.exoplayer2.offline.Download m(com.google.android.exoplayer2.offline.Download download) {
            int i = download.state;
            com.google.android.exoplayer2.util.Assertions.checkState((i == 3 || i == 4) ? false : true);
            int g = g(download.request.id);
            if (g == -1) {
                this.f.add(download);
                java.util.Collections.sort(this.f, new com.google.android.exoplayer2.offline.b());
            } else {
                boolean z = download.startTimeMs != this.f.get(g).startTimeMs;
                this.f.set(g, download);
                if (z) {
                    java.util.Collections.sort(this.f, new com.google.android.exoplayer2.offline.b());
                }
            }
            try {
                this.c.putDownload(download);
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to update index.", e);
            }
            this.e.obtainMessage(2, new com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate(download, false, new java.util.ArrayList(this.f), null)).sendToTarget();
            return download;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0007, code lost:
        
            if (r3 != 1) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final com.google.android.exoplayer2.offline.Download n(com.google.android.exoplayer2.offline.Download download, int i) {
            boolean z = (i == 3 || i == 4) ? false : true;
            com.google.android.exoplayer2.util.Assertions.checkState(z);
            return m(e(download, i));
        }

        public final void o() {
            java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Task> it = this.g.values().iterator();
            while (it.hasNext()) {
                it.next().e(true);
            }
            try {
                this.c.setDownloadingStatesToQueued();
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to update index.", e);
            }
            this.f.clear();
            this.b.quit();
            synchronized (this) {
                this.a = true;
                notifyAll();
            }
        }

        public final void p() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                com.google.android.exoplayer2.offline.DownloadCursor downloads = this.c.getDownloads(3, 4);
                while (downloads.moveToNext()) {
                    try {
                        arrayList.add(downloads.getDownload());
                    } finally {
                    }
                }
                downloads.close();
            } catch (java.io.IOException unused) {
                com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to load downloads.");
            }
            for (int i = 0; i < this.f.size(); i++) {
                java.util.ArrayList<com.google.android.exoplayer2.offline.Download> arrayList2 = this.f;
                arrayList2.set(i, e(arrayList2.get(i), 5));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.f.add(e((com.google.android.exoplayer2.offline.Download) arrayList.get(i2), 5));
            }
            java.util.Collections.sort(this.f, new com.google.android.exoplayer2.offline.b());
            try {
                this.c.setStatesToRemoving();
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to update index.", e);
            }
            java.util.ArrayList arrayList3 = new java.util.ArrayList(this.f);
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.e.obtainMessage(2, new com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate(this.f.get(i3), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        public final void q(java.lang.String str) {
            com.google.android.exoplayer2.offline.Download f = f(str, true);
            if (f == null) {
                java.lang.String valueOf = java.lang.String.valueOf(str);
                com.google.android.exoplayer2.util.Log.e("DownloadManager", valueOf.length() != 0 ? "Failed to remove nonexistent download: ".concat(valueOf) : new java.lang.String("Failed to remove nonexistent download: "));
            } else {
                n(f, 5);
                B();
            }
        }

        public final void r(boolean z) {
            this.i = z;
            B();
        }

        public final void s(int i) {
            this.j = i;
            B();
        }

        public final void t(int i) {
            this.k = i;
        }

        public final void u(int i) {
            this.h = i;
            B();
        }

        public final void v(com.google.android.exoplayer2.offline.Download download, int i) {
            if (i == 0) {
                if (download.state == 1) {
                    n(download, 0);
                }
            } else if (i != download.stopReason) {
                int i2 = download.state;
                if (i2 == 0 || i2 == 2) {
                    i2 = 1;
                }
                m(new com.google.android.exoplayer2.offline.Download(download.request, i2, download.startTimeMs, java.lang.System.currentTimeMillis(), download.contentLength, i, 0, download.a));
            }
        }

        public final void w(@androidx.annotation.Nullable java.lang.String str, int i) {
            if (str == null) {
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    v(this.f.get(i2), i);
                }
                try {
                    this.c.setStopReason(i);
                } catch (java.io.IOException e) {
                    com.google.android.exoplayer2.util.Log.e("DownloadManager", "Failed to set manual stop reason", e);
                }
            } else {
                com.google.android.exoplayer2.offline.Download f = f(str, false);
                if (f != null) {
                    v(f, i);
                } else {
                    try {
                        this.c.setStopReason(str, i);
                    } catch (java.io.IOException e2) {
                        com.google.android.exoplayer2.util.Log.e("DownloadManager", str.length() != 0 ? "Failed to set manual stop reason: ".concat(str) : new java.lang.String("Failed to set manual stop reason: "), e2);
                    }
                }
            }
            B();
        }

        public final void x(com.google.android.exoplayer2.offline.DownloadManager.Task task, com.google.android.exoplayer2.offline.Download download, int i) {
            com.google.android.exoplayer2.util.Assertions.checkState(!task.v);
            if (!c() || i >= this.j) {
                n(download, 0);
                task.e(false);
            }
        }

        @androidx.annotation.Nullable
        @androidx.annotation.CheckResult
        public final com.google.android.exoplayer2.offline.DownloadManager.Task y(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.DownloadManager.Task task, com.google.android.exoplayer2.offline.Download download) {
            if (task != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(!task.v);
                task.e(false);
                return task;
            }
            if (!c() || this.l >= this.j) {
                return null;
            }
            com.google.android.exoplayer2.offline.Download n = n(download, 2);
            com.google.android.exoplayer2.offline.DownloadManager.Task task2 = new com.google.android.exoplayer2.offline.DownloadManager.Task(n.request, this.d.createDownloader(n.request), n.a, false, this.k, this, null);
            this.g.put(n.request.id, task2);
            int i = this.l;
            this.l = i + 1;
            if (i == 0) {
                sendEmptyMessageDelayed(11, 5000L);
            }
            task2.start();
            return task2;
        }

        public final void z(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.DownloadManager.Task task, com.google.android.exoplayer2.offline.Download download) {
            if (task != null) {
                if (task.v) {
                    return;
                }
                task.e(false);
            } else {
                com.google.android.exoplayer2.offline.DownloadManager.Task task2 = new com.google.android.exoplayer2.offline.DownloadManager.Task(download.request, this.d.createDownloader(download.request), download.a, true, this.k, this, null);
                this.g.put(download.request.id, task2);
                task2.start();
            }
        }
    }

    public interface Listener {
        void onDownloadChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.Download download, @androidx.annotation.Nullable java.lang.Exception exc);

        void onDownloadRemoved(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.Download download);

        void onDownloadsPausedChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z);

        void onIdle(com.google.android.exoplayer2.offline.DownloadManager downloadManager);

        void onInitialized(com.google.android.exoplayer2.offline.DownloadManager downloadManager);

        void onRequirementsStateChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.scheduler.Requirements requirements, int i);

        void onWaitingForRequirementsChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z);
    }

    public static class Task extends java.lang.Thread implements com.google.android.exoplayer2.offline.Downloader.ProgressListener {
        public long A;
        public final com.google.android.exoplayer2.offline.DownloadRequest n;
        public final com.google.android.exoplayer2.offline.Downloader t;
        public final com.google.android.exoplayer2.offline.DownloadProgress u;
        public final boolean v;
        public final int w;

        @androidx.annotation.Nullable
        public volatile com.google.android.exoplayer2.offline.DownloadManager.InternalHandler x;
        public volatile boolean y;

        @androidx.annotation.Nullable
        public java.lang.Exception z;

        public Task(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, com.google.android.exoplayer2.offline.Downloader downloader, com.google.android.exoplayer2.offline.DownloadProgress downloadProgress, boolean z, int i, com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler) {
            this.n = downloadRequest;
            this.t = downloader;
            this.u = downloadProgress;
            this.v = z;
            this.w = i;
            this.x = internalHandler;
            this.A = -1L;
        }

        public /* synthetic */ Task(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, com.google.android.exoplayer2.offline.Downloader downloader, com.google.android.exoplayer2.offline.DownloadProgress downloadProgress, boolean z, int i, com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler, com.google.android.exoplayer2.offline.DownloadManager.AnonymousClass1 anonymousClass1) {
            this(downloadRequest, downloader, downloadProgress, z, i, internalHandler);
        }

        public static int f(int i) {
            return java.lang.Math.min((i - 1) * 1000, 5000);
        }

        public void e(boolean z) {
            if (z) {
                this.x = null;
            }
            if (this.y) {
                return;
            }
            this.y = true;
            this.t.cancel();
            interrupt();
        }

        @Override // com.google.android.exoplayer2.offline.Downloader.ProgressListener
        public void onProgress(long j, long j2, float f) {
            this.u.bytesDownloaded = j2;
            this.u.percentDownloaded = f;
            if (j != this.A) {
                this.A = j;
                com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler = this.x;
                if (internalHandler != null) {
                    internalHandler.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.v) {
                    this.t.remove();
                } else {
                    long j = -1;
                    int i = 0;
                    while (!this.y) {
                        try {
                            this.t.download(this);
                            break;
                        } catch (java.io.IOException e) {
                            if (!this.y) {
                                long j2 = this.u.bytesDownloaded;
                                if (j2 != j) {
                                    j = j2;
                                    i = 0;
                                }
                                i++;
                                if (i > this.w) {
                                    throw e;
                                }
                                java.lang.Thread.sleep(f(i));
                            }
                        }
                    }
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            } catch (java.lang.Exception e2) {
                this.z = e2;
            }
            com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler = this.x;
            if (internalHandler != null) {
                internalHandler.obtainMessage(9, this).sendToTarget();
            }
        }
    }

    @java.lang.Deprecated
    public DownloadManager(android.content.Context context, com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(context, databaseProvider, cache, factory, new defpackage.jz());
    }

    public DownloadManager(android.content.Context context, com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(context, new com.google.android.exoplayer2.offline.DefaultDownloadIndex(databaseProvider), new com.google.android.exoplayer2.offline.DefaultDownloaderFactory(new com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory), executor));
    }

    public DownloadManager(android.content.Context context, com.google.android.exoplayer2.offline.WritableDownloadIndex writableDownloadIndex, com.google.android.exoplayer2.offline.DownloaderFactory downloaderFactory) {
        this.a = context.getApplicationContext();
        this.b = writableDownloadIndex;
        this.k = 3;
        this.l = 5;
        this.j = true;
        this.o = java.util.Collections.emptyList();
        this.f = new java.util.concurrent.CopyOnWriteArraySet<>();
        android.os.Handler createHandlerForCurrentOrMainLooper = com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper(new defpackage.f50(this));
        this.c = createHandlerForCurrentOrMainLooper;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler = new com.google.android.exoplayer2.offline.DownloadManager.InternalHandler(handlerThread, writableDownloadIndex, downloaderFactory, createHandlerForCurrentOrMainLooper, this.k, this.l, this.j);
        this.d = internalHandler;
        defpackage.g50 g50Var = new defpackage.g50(this);
        this.e = g50Var;
        com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher = new com.google.android.exoplayer2.scheduler.RequirementsWatcher(context, g50Var, DEFAULT_REQUIREMENTS);
        this.p = requirementsWatcher;
        int start = requirementsWatcher.start();
        this.m = start;
        this.g = 1;
        internalHandler.obtainMessage(0, start, 0).sendToTarget();
    }

    public static com.google.android.exoplayer2.offline.Download d(com.google.android.exoplayer2.offline.Download download, com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i, long j) {
        int i2 = download.state;
        return new com.google.android.exoplayer2.offline.Download(download.request.copyWithMergedRequest(downloadRequest), (i2 == 5 || i2 == 7) ? 7 : i != 0 ? 1 : 0, (i2 == 5 || download.isTerminalState()) ? j : download.startTimeMs, j, -1L, i, 0);
    }

    public void addDownload(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest) {
        addDownload(downloadRequest, 0);
    }

    public void addDownload(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i) {
        this.g++;
        this.d.obtainMessage(6, i, 0, downloadRequest).sendToTarget();
    }

    public void addListener(com.google.android.exoplayer2.offline.DownloadManager.Listener listener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        this.f.add(listener);
    }

    public final boolean c(android.os.Message message) {
        int i = message.what;
        if (i == 0) {
            g((java.util.List) message.obj);
        } else if (i == 1) {
            h(message.arg1, message.arg2);
        } else {
            if (i != 2) {
                throw new java.lang.IllegalStateException();
            }
            f((com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate) message.obj);
        }
        return true;
    }

    public final void e() {
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onWaitingForRequirementsChanged(this, this.n);
        }
    }

    public final void f(com.google.android.exoplayer2.offline.DownloadManager.DownloadUpdate downloadUpdate) {
        this.o = java.util.Collections.unmodifiableList(downloadUpdate.c);
        com.google.android.exoplayer2.offline.Download download = downloadUpdate.a;
        boolean k = k();
        if (downloadUpdate.b) {
            java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().onDownloadRemoved(this, download);
            }
        } else {
            java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadChanged(this, download, downloadUpdate.d);
            }
        }
        if (k) {
            e();
        }
    }

    public final void g(java.util.List<com.google.android.exoplayer2.offline.Download> list) {
        this.i = true;
        this.o = java.util.Collections.unmodifiableList(list);
        boolean k = k();
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onInitialized(this);
        }
        if (k) {
            e();
        }
    }

    public android.os.Looper getApplicationLooper() {
        return this.c.getLooper();
    }

    public java.util.List<com.google.android.exoplayer2.offline.Download> getCurrentDownloads() {
        return this.o;
    }

    public com.google.android.exoplayer2.offline.DownloadIndex getDownloadIndex() {
        return this.b;
    }

    public boolean getDownloadsPaused() {
        return this.j;
    }

    public int getMaxParallelDownloads() {
        return this.k;
    }

    public int getMinRetryCount() {
        return this.l;
    }

    public int getNotMetRequirements() {
        return this.m;
    }

    public com.google.android.exoplayer2.scheduler.Requirements getRequirements() {
        return this.p.getRequirements();
    }

    public final void h(int i, int i2) {
        this.g -= i;
        this.h = i2;
        if (isIdle()) {
            java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().onIdle(this);
            }
        }
    }

    public final void i(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher, int i) {
        com.google.android.exoplayer2.scheduler.Requirements requirements = requirementsWatcher.getRequirements();
        if (this.m != i) {
            this.m = i;
            this.g++;
            this.d.obtainMessage(2, i, 0).sendToTarget();
        }
        boolean k = k();
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onRequirementsStateChanged(this, requirements, i);
        }
        if (k) {
            e();
        }
    }

    public boolean isIdle() {
        return this.h == 0 && this.g == 0;
    }

    public boolean isInitialized() {
        return this.i;
    }

    public boolean isWaitingForRequirements() {
        return this.n;
    }

    public final void j(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        this.g++;
        this.d.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        boolean k = k();
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onDownloadsPausedChanged(this, z);
        }
        if (k) {
            e();
        }
    }

    public final boolean k() {
        boolean z;
        if (!this.j && this.m != 0) {
            for (int i = 0; i < this.o.size(); i++) {
                if (this.o.get(i).state == 0) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = this.n != z;
        this.n = z;
        return z2;
    }

    public void pauseDownloads() {
        j(true);
    }

    public void release() {
        synchronized (this.d) {
            com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler = this.d;
            if (internalHandler.a) {
                return;
            }
            internalHandler.sendEmptyMessage(12);
            boolean z = false;
            while (true) {
                com.google.android.exoplayer2.offline.DownloadManager.InternalHandler internalHandler2 = this.d;
                if (internalHandler2.a) {
                    break;
                }
                try {
                    internalHandler2.wait();
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
            this.c.removeCallbacksAndMessages(null);
            this.o = java.util.Collections.emptyList();
            this.g = 0;
            this.h = 0;
            this.i = false;
            this.m = 0;
            this.n = false;
        }
    }

    public void removeAllDownloads() {
        this.g++;
        this.d.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(java.lang.String str) {
        this.g++;
        this.d.obtainMessage(7, str).sendToTarget();
    }

    public void removeListener(com.google.android.exoplayer2.offline.DownloadManager.Listener listener) {
        this.f.remove(listener);
    }

    public void resumeDownloads() {
        j(false);
    }

    public void setMaxParallelDownloads(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        if (this.k == i) {
            return;
        }
        this.k = i;
        this.g++;
        this.d.obtainMessage(4, i, 0).sendToTarget();
    }

    public void setMinRetryCount(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0);
        if (this.l == i) {
            return;
        }
        this.l = i;
        this.g++;
        this.d.obtainMessage(5, i, 0).sendToTarget();
    }

    public void setRequirements(com.google.android.exoplayer2.scheduler.Requirements requirements) {
        if (requirements.equals(this.p.getRequirements())) {
            return;
        }
        this.p.stop();
        com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher = new com.google.android.exoplayer2.scheduler.RequirementsWatcher(this.a, this.e, requirements);
        this.p = requirementsWatcher;
        i(this.p, requirementsWatcher.start());
    }

    public void setStopReason(@androidx.annotation.Nullable java.lang.String str, int i) {
        this.g++;
        this.d.obtainMessage(3, i, 0, str).sendToTarget();
    }
}
