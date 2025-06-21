package com.ss.android.downloadlib.wg;

/* loaded from: classes19.dex */
public class t {

    /* renamed from: com.ss.android.downloadlib.wg.t$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ com.ss.android.downloadlib.guide.install.vw wg;

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.guide.install.vw vwVar) {
            this.vw = wgVar;
            this.wg = vwVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            com.ss.android.socialbase.downloader.logger.Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
            com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            if (com.ss.android.downloadlib.bt.vl.wg(this.vw)) {
                return;
            }
            this.vw.u(true);
            com.ss.android.downloadlib.v.vw.vw().vw("install_delay_invoke", this.vw);
            this.wg.vw();
        }
    }

    public static void vw(com.ss.android.downloadad.api.vw.wg wgVar, @androidx.annotation.NonNull com.ss.android.downloadlib.guide.install.vw vwVar) {
        boolean isAppForeground = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && android.os.Build.VERSION.SDK_INT >= 29) {
            com.ss.android.downloadlib.bt.vl.t();
        }
        boolean isAppForeground2 = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && isAppForeground2 && wgVar != null) {
            wgVar.vl(true);
        }
        vwVar.vw();
        com.ss.android.socialbase.downloader.logger.Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(java.lang.String.valueOf(isAppForeground2)));
        if (isAppForeground2) {
            return;
        }
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(new com.ss.android.downloadlib.wg.t.AnonymousClass1(wgVar, vwVar));
    }
}
