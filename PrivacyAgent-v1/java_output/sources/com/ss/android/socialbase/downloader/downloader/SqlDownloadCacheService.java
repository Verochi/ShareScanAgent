package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class SqlDownloadCacheService extends android.app.Service {
    private static final java.lang.String TAG = "SqlDownloadCacheService";

    public static void startServiceAndBind(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache sqlDownloadCache = downloadCache instanceof com.ss.android.socialbase.downloader.impls.DefaultDownloadCache ? ((com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) downloadCache).getSqlDownloadCache() : downloadCache instanceof com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache ? (com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache) downloadCache : null;
        return sqlDownloadCache instanceof android.os.IBinder ? (android.os.IBinder) sqlDownloadCache : new android.os.Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.notAutoRebootService()) {
            return 2;
        }
        return onStartCommand;
    }
}
