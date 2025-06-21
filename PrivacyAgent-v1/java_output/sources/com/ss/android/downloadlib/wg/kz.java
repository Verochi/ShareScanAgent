package com.ss.android.downloadlib.wg;

/* loaded from: classes19.dex */
public class kz {
    private static android.os.Handler vw = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.wg.kz$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
        final /* synthetic */ com.ss.android.downloadlib.wg.o t;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ long wg;

        /* renamed from: com.ss.android.downloadlib.wg.kz$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04781 implements java.lang.Runnable {
            public RunnableC04781() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean t = com.ss.android.downloadlib.bt.vl.t(com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw.yl());
                long yl = com.ss.android.downloadlib.wg.kz.yl(com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw);
                if (!t || yl >= java.lang.System.currentTimeMillis() - com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.wg) {
                    long o = com.ss.android.downloadlib.wg.kz.o(com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw);
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    com.ss.android.downloadlib.wg.kz.AnonymousClass1 anonymousClass1 = com.ss.android.downloadlib.wg.kz.AnonymousClass1.this;
                    if (currentTimeMillis - anonymousClass1.wg > o) {
                        com.ss.android.downloadlib.v.vw.vw().vw("deeplink_delay_timeout", com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw);
                        return;
                    }
                    anonymousClass1.vw.vl(true);
                    com.ss.android.downloadlib.v.vw.vw().vw("deeplink_delay_invoke", com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw);
                    com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.t.vw(true);
                    com.ss.android.downloadad.api.vw.wg wgVar = com.ss.android.downloadlib.wg.kz.AnonymousClass1.this.vw;
                    com.ss.android.downloadlib.wg.kz.wg(wgVar, com.ss.android.downloadlib.wg.kz.es(wgVar));
                }
            }
        }

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, long j, com.ss.android.downloadlib.wg.o oVar) {
            this.vw = wgVar;
            this.wg = j;
            this.t = oVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.wg.kz.AnonymousClass1.RunnableC04781());
        }
    }

    /* renamed from: com.ss.android.downloadlib.wg.kz$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ int wg;

        public AnonymousClass2(com.ss.android.downloadad.api.vw.wg wgVar, int i) {
            this.vw = wgVar;
            this.wg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 1;
            if (!com.ss.android.downloadlib.bt.vl.t(this.vw.yl())) {
                com.ss.android.downloadlib.wg.kz.wg(this.vw, this.wg - 1);
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                if (!this.vw.fu()) {
                    i = 2;
                }
                jSONObject.putOpt("deeplink_source", java.lang.Integer.valueOf(i));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.v.vw.vw().vw("deeplink_success_2", jSONObject, this.vw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int es(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_check_count", 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optLong("app_link_check_timeout", 300000L);
    }

    public static boolean t(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    public static boolean v(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    public static void vw(com.ss.android.downloadad.api.vw.wg wgVar, @androidx.annotation.NonNull com.ss.android.downloadlib.wg.o oVar) {
        boolean isAppForeground = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && android.os.Build.VERSION.SDK_INT >= 29) {
            com.ss.android.downloadlib.bt.vl.t();
        }
        boolean isAppForeground2 = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground();
        boolean z = !isAppForeground && isAppForeground2;
        if (wgVar != null) {
            wgVar.vl(z);
        }
        oVar.vw(z);
        if (wgVar == null) {
            return;
        }
        wg(wgVar, es(wgVar));
        if (isAppForeground2) {
            return;
        }
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(new com.ss.android.downloadlib.wg.kz.AnonymousClass1(wgVar, java.lang.System.currentTimeMillis(), oVar));
    }

    public static boolean vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_opt_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.wg.kz.AnonymousClass2(wgVar, i), x(wgVar) * 1000);
    }

    public static boolean wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_opt_install_switch") == 1;
    }

    private static int x(com.ss.android.downloadad.api.vw.wg wgVar) {
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_check_delay", 1);
    }

    public static long yl(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.bt.yl.vw(wgVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }
}
