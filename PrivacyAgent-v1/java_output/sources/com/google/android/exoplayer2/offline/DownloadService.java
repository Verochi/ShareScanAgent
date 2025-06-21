package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public abstract class DownloadService extends android.app.Service {
    public static final java.lang.String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final java.lang.String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final java.lang.String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final java.lang.String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final java.lang.String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    public static final java.lang.String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final java.lang.String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final java.lang.String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final java.util.HashMap<java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService>, com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper> C = new java.util.HashMap<>();
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final java.lang.String KEY_CONTENT_ID = "content_id";
    public static final java.lang.String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final java.lang.String KEY_FOREGROUND = "foreground";
    public static final java.lang.String KEY_REQUIREMENTS = "requirements";
    public static final java.lang.String KEY_STOP_REASON = "stop_reason";
    public boolean A;
    public boolean B;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater n;

    @androidx.annotation.Nullable
    public final java.lang.String t;

    @androidx.annotation.StringRes
    public final int u;

    @androidx.annotation.StringRes
    public final int v;
    public com.google.android.exoplayer2.offline.DownloadManager w;
    public int x;
    public boolean y;
    public boolean z;

    public static final class DownloadManagerHelper implements com.google.android.exoplayer2.offline.DownloadManager.Listener {
        public final android.content.Context a;
        public final com.google.android.exoplayer2.offline.DownloadManager b;
        public final boolean c;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.scheduler.Scheduler d;
        public final java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> e;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.offline.DownloadService f;

        public DownloadManagerHelper(android.content.Context context, com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.scheduler.Scheduler scheduler, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
            this.a = context;
            this.b = downloadManager;
            this.c = z;
            this.d = scheduler;
            this.e = cls;
            downloadManager.addListener(this);
            h();
        }

        public /* synthetic */ DownloadManagerHelper(android.content.Context context, com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z, com.google.android.exoplayer2.scheduler.Scheduler scheduler, java.lang.Class cls, com.google.android.exoplayer2.offline.DownloadService.AnonymousClass1 anonymousClass1) {
            this(context, downloadManager, z, scheduler, cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(com.google.android.exoplayer2.offline.DownloadService downloadService) {
            downloadService.o(this.b.getCurrentDownloads());
        }

        public void c(com.google.android.exoplayer2.offline.DownloadService downloadService) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.f == null);
            this.f = downloadService;
            if (this.b.isInitialized()) {
                com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper().postAtFrontOfQueue(new com.google.android.exoplayer2.offline.c(this, downloadService));
            }
        }

        public void d(com.google.android.exoplayer2.offline.DownloadService downloadService) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.f == downloadService);
            this.f = null;
            if (this.d == null || this.b.isWaitingForRequirements()) {
                return;
            }
            this.d.cancel();
        }

        public final void f() {
            if (this.c) {
                com.google.android.exoplayer2.util.Util.startForegroundService(this.a, com.google.android.exoplayer2.offline.DownloadService.i(this.a, this.e, "com.google.android.exoplayer.downloadService.action.RESTART"));
            } else {
                try {
                    this.a.startService(com.google.android.exoplayer2.offline.DownloadService.i(this.a, this.e, com.google.android.exoplayer2.offline.DownloadService.ACTION_INIT));
                } catch (java.lang.IllegalStateException unused) {
                    com.google.android.exoplayer2.util.Log.w("DownloadService", "Failed to restart DownloadService (process is idle).");
                }
            }
        }

        public final boolean g() {
            com.google.android.exoplayer2.offline.DownloadService downloadService = this.f;
            return downloadService == null || downloadService.k();
        }

        public final void h() {
            if (this.d == null) {
                return;
            }
            if (!this.b.isWaitingForRequirements()) {
                this.d.cancel();
                return;
            }
            java.lang.String packageName = this.a.getPackageName();
            if (this.d.schedule(this.b.getRequirements(), packageName, "com.google.android.exoplayer.downloadService.action.RESTART")) {
                return;
            }
            com.google.android.exoplayer2.util.Log.e("DownloadService", "Scheduling downloads failed.");
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onDownloadChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.Download download, @androidx.annotation.Nullable java.lang.Exception exc) {
            com.google.android.exoplayer2.offline.DownloadService downloadService = this.f;
            if (downloadService != null) {
                downloadService.m(download);
            }
            if (g() && com.google.android.exoplayer2.offline.DownloadService.l(download.state)) {
                com.google.android.exoplayer2.util.Log.w("DownloadService", "DownloadService wasn't running. Restarting.");
                f();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onDownloadRemoved(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.Download download) {
            com.google.android.exoplayer2.offline.DownloadService downloadService = this.f;
            if (downloadService != null) {
                downloadService.n(download);
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public /* synthetic */ void onDownloadsPausedChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z) {
            defpackage.h50.c(this, downloadManager, z);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public final void onIdle(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
            com.google.android.exoplayer2.offline.DownloadService downloadService = this.f;
            if (downloadService != null) {
                downloadService.p();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onInitialized(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
            com.google.android.exoplayer2.offline.DownloadService downloadService = this.f;
            if (downloadService != null) {
                downloadService.o(downloadManager.getCurrentDownloads());
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public /* synthetic */ void onRequirementsStateChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.scheduler.Requirements requirements, int i) {
            defpackage.h50.f(this, downloadManager, requirements, i);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onWaitingForRequirementsChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, boolean z) {
            if (!z && !downloadManager.getDownloadsPaused() && g()) {
                java.util.List<com.google.android.exoplayer2.offline.Download> currentDownloads = downloadManager.getCurrentDownloads();
                int i = 0;
                while (true) {
                    if (i >= currentDownloads.size()) {
                        break;
                    }
                    if (currentDownloads.get(i).state == 0) {
                        f();
                        break;
                    }
                    i++;
                }
            }
            h();
        }
    }

    public final class ForegroundNotificationUpdater {
        public final int a;
        public final long b;
        public final android.os.Handler c = new android.os.Handler(android.os.Looper.getMainLooper());
        public boolean d;
        public boolean e;

        public ForegroundNotificationUpdater(int i, long j) {
            this.a = i;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update() {
            java.util.List<com.google.android.exoplayer2.offline.Download> currentDownloads = ((com.google.android.exoplayer2.offline.DownloadManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.offline.DownloadService.this.w)).getCurrentDownloads();
            com.google.android.exoplayer2.offline.DownloadService downloadService = com.google.android.exoplayer2.offline.DownloadService.this;
            downloadService.startForeground(this.a, downloadService.getForegroundNotification(currentDownloads));
            this.e = true;
            if (this.d) {
                this.c.removeCallbacksAndMessages(null);
                this.c.postDelayed(new com.google.android.exoplayer2.offline.d(this), this.b);
            }
        }

        public void b() {
            if (this.e) {
                update();
            }
        }

        public void c() {
            if (this.e) {
                return;
            }
            update();
        }

        public void d() {
            this.d = true;
            update();
        }

        public void e() {
            this.d = false;
            this.c.removeCallbacksAndMessages(null);
        }
    }

    public DownloadService(int i) {
        this(i, 1000L);
    }

    public DownloadService(int i, long j) {
        this(i, j, null, 0, 0);
    }

    @java.lang.Deprecated
    public DownloadService(int i, long j, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.StringRes int i2) {
        this(i, j, str, i2, 0);
    }

    public DownloadService(int i, long j, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.StringRes int i2, @androidx.annotation.StringRes int i3) {
        if (i == 0) {
            this.n = null;
            this.t = null;
            this.u = 0;
            this.v = 0;
            return;
        }
        this.n = new com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater(i, j);
        this.t = str;
        this.u = i2;
        this.v = i3;
    }

    public static android.content.Intent buildAddDownloadIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i, boolean z) {
        return j(context, cls, ACTION_ADD_DOWNLOAD, z).putExtra(KEY_DOWNLOAD_REQUEST, downloadRequest).putExtra(KEY_STOP_REASON, i);
    }

    public static android.content.Intent buildAddDownloadIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static android.content.Intent buildPauseDownloadsIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        return j(context, cls, ACTION_PAUSE_DOWNLOADS, z);
    }

    public static android.content.Intent buildRemoveAllDownloadsIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        return j(context, cls, ACTION_REMOVE_ALL_DOWNLOADS, z);
    }

    public static android.content.Intent buildRemoveDownloadIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, java.lang.String str, boolean z) {
        return j(context, cls, ACTION_REMOVE_DOWNLOAD, z).putExtra(KEY_CONTENT_ID, str);
    }

    public static android.content.Intent buildResumeDownloadsIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        return j(context, cls, ACTION_RESUME_DOWNLOADS, z);
    }

    public static android.content.Intent buildSetRequirementsIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.scheduler.Requirements requirements, boolean z) {
        return j(context, cls, ACTION_SET_REQUIREMENTS, z).putExtra(KEY_REQUIREMENTS, requirements);
    }

    public static android.content.Intent buildSetStopReasonIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, @androidx.annotation.Nullable java.lang.String str, int i, boolean z) {
        return j(context, cls, ACTION_SET_STOP_REASON, z).putExtra(KEY_CONTENT_ID, str).putExtra(KEY_STOP_REASON, i);
    }

    public static android.content.Intent i(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, java.lang.String str) {
        return new android.content.Intent(context, cls).setAction(str);
    }

    public static android.content.Intent j(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, java.lang.String str, boolean z) {
        return i(context, cls, str).putExtra(KEY_FOREGROUND, z);
    }

    public static boolean l(int i) {
        return i == 2 || i == 5 || i == 7;
    }

    public static void sendAddDownload(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, i, z), z);
    }

    public static void sendAddDownload(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendPauseDownloads(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        startService(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveAllDownloads(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        startService(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveDownload(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, java.lang.String str, boolean z) {
        startService(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendResumeDownloads(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, boolean z) {
        startService(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetRequirements(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.scheduler.Requirements requirements, boolean z) {
        startService(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void sendSetStopReason(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, @androidx.annotation.Nullable java.lang.String str, int i, boolean z) {
        startService(context, buildSetStopReasonIntent(context, cls, str, i, z), z);
    }

    public static void start(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
        context.startService(i(context, cls, ACTION_INIT));
    }

    public static void startForeground(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
        com.google.android.exoplayer2.util.Util.startForegroundService(context, j(context, cls, ACTION_INIT, true));
    }

    private static void startService(android.content.Context context, android.content.Intent intent, boolean z) {
        if (z) {
            com.google.android.exoplayer2.util.Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public abstract com.google.android.exoplayer2.offline.DownloadManager getDownloadManager();

    public abstract android.app.Notification getForegroundNotification(java.util.List<com.google.android.exoplayer2.offline.Download> list);

    @androidx.annotation.Nullable
    public abstract com.google.android.exoplayer2.scheduler.Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.n;
        if (foregroundNotificationUpdater == null || this.B) {
            return;
        }
        foregroundNotificationUpdater.b();
    }

    public final boolean k() {
        return this.A;
    }

    public final void m(com.google.android.exoplayer2.offline.Download download) {
        onDownloadChanged(download);
        if (this.n != null) {
            if (l(download.state)) {
                this.n.d();
            } else {
                this.n.b();
            }
        }
    }

    public final void n(com.google.android.exoplayer2.offline.Download download) {
        onDownloadRemoved(download);
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.n;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.b();
        }
    }

    public final void o(java.util.List<com.google.android.exoplayer2.offline.Download> list) {
        if (this.n != null) {
            for (int i = 0; i < list.size(); i++) {
                if (l(list.get(i).state)) {
                    this.n.d();
                    return;
                }
            }
        }
    }

    @Override // android.app.Service
    @androidx.annotation.Nullable
    public final android.os.IBinder onBind(android.content.Intent intent) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public void onCreate() {
        java.lang.String str = this.t;
        if (str != null) {
            com.google.android.exoplayer2.util.NotificationUtil.createNotificationChannel(this, str, this.u, this.v, 2);
        }
        java.lang.Class<?> cls = getClass();
        java.util.HashMap<java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService>, com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper> hashMap = C;
        com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper downloadManagerHelper = (com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper) hashMap.get(cls);
        if (downloadManagerHelper == null) {
            boolean z = this.n != null;
            com.google.android.exoplayer2.scheduler.Scheduler scheduler = z ? getScheduler() : null;
            com.google.android.exoplayer2.offline.DownloadManager downloadManager = getDownloadManager();
            this.w = downloadManager;
            downloadManager.resumeDownloads();
            downloadManagerHelper = new com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper(getApplicationContext(), this.w, z, scheduler, cls, null);
            hashMap.put(cls, downloadManagerHelper);
        } else {
            this.w = downloadManagerHelper.b;
        }
        downloadManagerHelper.c(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.B = true;
        ((com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper) com.google.android.exoplayer2.util.Assertions.checkNotNull(C.get(getClass()))).d(this);
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.n;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.e();
        }
    }

    @java.lang.Deprecated
    public void onDownloadChanged(com.google.android.exoplayer2.offline.Download download) {
    }

    @java.lang.Deprecated
    public void onDownloadRemoved(com.google.android.exoplayer2.offline.Download download) {
    }

    @Override // android.app.Service
    public int onStartCommand(@androidx.annotation.Nullable android.content.Intent intent, int i, int i2) {
        java.lang.String str;
        java.lang.String str2;
        com.google.android.exoplayer2.offline.DownloadManager downloadManager;
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater;
        this.x = i2;
        this.z = false;
        if (intent != null) {
            str = intent.getAction();
            str2 = intent.getStringExtra(KEY_CONTENT_ID);
            this.y |= intent.getBooleanExtra(KEY_FOREGROUND, false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str);
        } else {
            str = null;
            str2 = null;
        }
        if (str == null) {
            str = ACTION_INIT;
        }
        downloadManager = (com.google.android.exoplayer2.offline.DownloadManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w);
        switch (str) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                com.google.android.exoplayer2.offline.DownloadRequest downloadRequest = (com.google.android.exoplayer2.offline.DownloadRequest) ((android.content.Intent) com.google.android.exoplayer2.util.Assertions.checkNotNull(intent)).getParcelableExtra(KEY_DOWNLOAD_REQUEST);
                if (downloadRequest != null) {
                    downloadManager.addDownload(downloadRequest, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                } else {
                    com.google.android.exoplayer2.util.Log.e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.resumeDownloads();
                break;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.removeAllDownloads();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                com.google.android.exoplayer2.scheduler.Requirements requirements = (com.google.android.exoplayer2.scheduler.Requirements) ((android.content.Intent) com.google.android.exoplayer2.util.Assertions.checkNotNull(intent)).getParcelableExtra(KEY_REQUIREMENTS);
                if (requirements != null) {
                    com.google.android.exoplayer2.scheduler.Scheduler scheduler = getScheduler();
                    if (scheduler != null) {
                        com.google.android.exoplayer2.scheduler.Requirements supportedRequirements = scheduler.getSupportedRequirements(requirements);
                        if (!supportedRequirements.equals(requirements)) {
                            int requirements2 = requirements.getRequirements() ^ supportedRequirements.getRequirements();
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(65);
                            sb.append("Ignoring requirements not supported by the Scheduler: ");
                            sb.append(requirements2);
                            com.google.android.exoplayer2.util.Log.w("DownloadService", sb.toString());
                            requirements = supportedRequirements;
                        }
                    }
                    downloadManager.setRequirements(requirements);
                    break;
                } else {
                    com.google.android.exoplayer2.util.Log.e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.pauseDownloads();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((android.content.Intent) com.google.android.exoplayer2.util.Assertions.checkNotNull(intent)).hasExtra(KEY_STOP_REASON)) {
                    com.google.android.exoplayer2.util.Log.e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.setStopReason(str2, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (str2 != null) {
                    downloadManager.removeDownload(str2);
                    break;
                } else {
                    com.google.android.exoplayer2.util.Log.e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
            default:
                com.google.android.exoplayer2.util.Log.e("DownloadService", str.length() != 0 ? "Ignored unrecognized action: ".concat(str) : new java.lang.String("Ignored unrecognized action: "));
                break;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26 && this.y && (foregroundNotificationUpdater = this.n) != null) {
            foregroundNotificationUpdater.c();
        }
        this.A = false;
        if (downloadManager.isIdle()) {
            p();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(android.content.Intent intent) {
        this.z = true;
    }

    public final void p() {
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.n;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.e();
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 28 || !this.z) {
            this.A |= stopSelfResult(this.x);
        } else {
            stopSelf();
            this.A = true;
        }
    }
}
