package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class o {
    private java.lang.Runnable bt;
    private android.os.Handler kz;
    private long t;
    private long v;
    private final java.util.Queue<java.lang.Integer> vw;
    private boolean wg;
    private java.lang.ref.SoftReference<com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity> yl;

    /* renamed from: com.ss.android.socialbase.appdownloader.o$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.o.this.t();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.o$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            boolean hasCallbacks;
            if (com.ss.android.socialbase.appdownloader.o.this.vw.isEmpty()) {
                return;
            }
            long optLong = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", com.igexin.push.config.c.l);
            long currentTimeMillis = java.lang.System.currentTimeMillis() - com.ss.android.socialbase.appdownloader.o.this.v;
            if (currentTimeMillis >= optLong) {
                com.ss.android.socialbase.appdownloader.o.this.v = java.lang.System.currentTimeMillis();
                com.ss.android.socialbase.appdownloader.o.this.t();
            } else {
                hasCallbacks = com.ss.android.socialbase.appdownloader.o.this.kz.hasCallbacks(com.ss.android.socialbase.appdownloader.o.this.bt);
                if (hasCallbacks) {
                    return;
                }
                com.ss.android.socialbase.appdownloader.o.this.kz.postDelayed(com.ss.android.socialbase.appdownloader.o.this.bt, optLong - currentTimeMillis);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.o$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ java.lang.Integer wg;

        public AnonymousClass3(android.content.Context context, java.lang.Integer num) {
            this.vw = context;
            this.wg = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.o.this.wg(this.vw, this.wg.intValue(), false);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.o$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ boolean t;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ int wg;

        public AnonymousClass4(android.content.Context context, int i, boolean z) {
            this.vw = context;
            this.wg = i;
            this.t = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.o.this.vw(this.vw, this.wg, this.t);
        }
    }

    public static class vw {
        private static final com.ss.android.socialbase.appdownloader.o vw = new com.ss.android.socialbase.appdownloader.o(null);
    }

    private o() {
        this.vw = new java.util.ArrayDeque();
        this.wg = false;
        this.kz = new android.os.Handler(android.os.Looper.getMainLooper());
        this.bt = new com.ss.android.socialbase.appdownloader.o.AnonymousClass1();
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(new com.ss.android.socialbase.appdownloader.o.AnonymousClass2());
    }

    public /* synthetic */ o(com.ss.android.socialbase.appdownloader.o.AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        java.lang.Integer poll;
        if (android.os.Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.vw) {
                poll = this.vw.poll();
            }
            this.kz.removeCallbacks(this.bt);
            if (poll == null) {
                this.wg = false;
                return;
            }
            android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                this.kz.post(new com.ss.android.socialbase.appdownloader.o.AnonymousClass3(appContext, poll));
            } else {
                wg(appContext, poll.intValue(), false);
            }
            this.kz.postDelayed(this.bt, com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }
    }

    private boolean v() {
        return java.lang.System.currentTimeMillis() - this.t < 1000;
    }

    public static com.ss.android.socialbase.appdownloader.o vw() {
        return com.ss.android.socialbase.appdownloader.o.vw.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wg(android.content.Context context, int i, boolean z) {
        int wg = com.ss.android.socialbase.appdownloader.t.wg(context, i, z);
        if (wg == 1) {
            this.wg = true;
        }
        this.t = java.lang.System.currentTimeMillis();
        return wg;
    }

    public int vw(android.content.Context context, int i, boolean z) {
        if (z) {
            return wg(context, i, z);
        }
        if (v()) {
            this.kz.postDelayed(new com.ss.android.socialbase.appdownloader.o.AnonymousClass4(context, i, z), 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground()) {
            com.ss.android.socialbase.downloader.logger.Logger.i("leaves", "on Foreground");
            return wg(context, i, z);
        }
        if (com.ss.android.socialbase.appdownloader.wg.vw()) {
            return 1;
        }
        boolean z2 = android.os.Build.VERSION.SDK_INT < 29;
        if (this.vw.isEmpty() && !this.wg && z2) {
            return wg(context, i, z);
        }
        int optInt = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
        synchronized (this.vw) {
            while (this.vw.size() > optInt) {
                this.vw.poll();
            }
        }
        if (z2) {
            this.kz.removeCallbacks(this.bt);
            this.kz.postDelayed(this.bt, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("install_queue_timeout", com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US));
        }
        synchronized (this.vw) {
            if (!this.vw.contains(java.lang.Integer.valueOf(i))) {
                this.vw.offer(java.lang.Integer.valueOf(i));
            }
        }
        return 1;
    }

    public void vw(com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.yl = new java.lang.ref.SoftReference<>(jumpUnknownSourceActivity);
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
        if (downloadInfo == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        t();
    }

    public com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity wg() {
        java.lang.ref.SoftReference<com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity> softReference = this.yl;
        com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.yl = null;
        return jumpUnknownSourceActivity;
    }
}
