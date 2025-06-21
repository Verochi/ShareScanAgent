package com.ss.android.downloadlib.wg;

/* loaded from: classes19.dex */
public class yl implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
    private long vw;

    /* renamed from: com.ss.android.downloadlib.wg.yl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ long vw;
        final /* synthetic */ com.ss.android.downloadlib.wg.v wg;

        public AnonymousClass1(long j, com.ss.android.downloadlib.wg.v vVar) {
            this.vw = j;
            this.wg = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppFocus() || java.lang.System.currentTimeMillis() - com.ss.android.downloadlib.wg.yl.this.vw <= this.vw) {
                this.wg.vw(true);
            } else {
                this.wg.vw(false);
            }
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.wg.yl vw = new com.ss.android.downloadlib.wg.yl(null);
    }

    private yl() {
        this.vw = 0L;
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public /* synthetic */ yl(com.ss.android.downloadlib.wg.yl.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.wg.yl vw() {
        return com.ss.android.downloadlib.wg.yl.vw.vw;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.vw = java.lang.System.currentTimeMillis();
    }

    public void vw(com.ss.android.downloadlib.wg.v vVar) {
        vw(vVar, 5000L);
    }

    public void vw(com.ss.android.downloadlib.wg.v vVar, long j) {
        if (vVar == null) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.wg.yl.AnonymousClass1(j, vVar), j);
    }

    public void wg(com.ss.android.downloadlib.wg.v vVar) {
        if (vVar == null) {
            return;
        }
        org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
        int i = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
        int optInt = x.optInt("check_an_result_delay", com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        if (optInt > 0) {
            i = optInt;
        }
        vw(vVar, i);
    }
}
