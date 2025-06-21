package com.qq.e.comm;

/* loaded from: classes19.dex */
public class DownloadService extends android.app.Service {
    private com.qq.e.comm.pi.SVSD a;
    private boolean b = false;
    private java.util.LinkedList<com.qq.e.comm.DownloadService.b> c = new java.util.LinkedList<>();

    public class a implements java.lang.Runnable {
        final /* synthetic */ com.qq.e.comm.managers.a a;

        /* renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        public class RunnableC0434a implements java.lang.Runnable {
            final /* synthetic */ com.qq.e.comm.pi.SVSD a;

            public RunnableC0434a(com.qq.e.comm.pi.SVSD svsd) {
                this.a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.onCreate();
                while (true) {
                    com.qq.e.comm.DownloadService.b bVar = (com.qq.e.comm.DownloadService.b) com.qq.e.comm.DownloadService.this.c.poll();
                    if (bVar == null) {
                        com.qq.e.comm.DownloadService.this.a = this.a;
                        return;
                    }
                    this.a.onStartCommand(bVar.a, bVar.b, bVar.c);
                }
            }
        }

        public a(com.qq.e.comm.managers.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.qq.e.comm.pi.SVSD aPKDownloadServiceDelegate = this.a.c().getPOFactory().getAPKDownloadServiceDelegate(com.qq.e.comm.DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    com.qq.e.comm.util.GDTLogger.w("DownloadService初始化异常");
                } else {
                    new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.qq.e.comm.DownloadService.a.RunnableC0434a(aPKDownloadServiceDelegate));
                }
            } catch (java.lang.Throwable th) {
                com.qq.e.comm.util.GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    public static class b {
        private final android.content.Intent a;
        private final int b;
        private final int c;

        private b(android.content.Intent intent, int i, int i2) {
            this.a = intent;
            this.b = i;
            this.c = i2;
        }

        public /* synthetic */ b(android.content.Intent intent, int i, int i2, com.qq.e.comm.DownloadService.a aVar) {
            this(intent, i, i2);
        }
    }

    private boolean a(boolean z) {
        if (this.a != null) {
            return true;
        }
        com.qq.e.comm.managers.a b2 = com.qq.e.comm.managers.a.b();
        if (!b2.d()) {
            return false;
        }
        if (!z) {
            if (this.b) {
                return false;
            }
            this.b = true;
            com.qq.e.comm.managers.a.g.submit(new com.qq.e.comm.DownloadService.a(b2));
            return false;
        }
        try {
            com.qq.e.comm.pi.SVSD aPKDownloadServiceDelegate = b2.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.w("DownloadService初始化异常", th);
            return false;
        }
    }

    public static void enterAPPDownloadListPage(android.content.Context context) {
        if (context == null) {
            com.qq.e.comm.util.GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.qq.e.comm.DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.qq.e.comm.util.GDTLogger.d("DownloadService.onBind");
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        java.lang.String stringExtra = intent.getStringExtra("GDT_APPID");
        com.qq.e.comm.util.GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (android.text.TextUtils.isEmpty(stringExtra) || !a(true)) {
            return null;
        }
        return this.a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(android.content.Intent intent) {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        if (android.text.TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            com.qq.e.comm.util.GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (a(false)) {
            return this.a.onStartCommand(intent, i, i2);
        }
        this.c.add(new com.qq.e.comm.DownloadService.b(intent, i, i2, null));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(android.content.Intent intent) {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        com.qq.e.comm.pi.SVSD svsd = this.a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
