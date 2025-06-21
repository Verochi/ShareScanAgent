package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DownloadHandleService extends android.app.Service {
    private static final java.lang.String TAG = "DownloadHandleService";

    /* renamed from: com.ss.android.socialbase.downloader.impls.DownloadHandleService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass1(int i) {
            this.val$id = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().retryDelayStart(this.val$id);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleIntent(android.content.Intent intent) {
        int intExtra;
        if (intent == null) {
            return;
        }
        java.lang.String action = intent.getAction();
        if (android.text.TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_DOWNLOAD_ID, 0)) == 0) {
            return;
        }
        if (action.equals(com.ss.android.socialbase.downloader.constants.DownloadConstants.ACTION_RETRY)) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.downloader.impls.DownloadHandleService.AnonymousClass1(intExtra));
        } else if (action.equals(com.ss.android.socialbase.downloader.constants.DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY)) {
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(intExtra);
        } else if (action.equals(com.ss.android.socialbase.downloader.constants.DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY)) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadInMultiProcess();
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        super.onStartCommand(intent, i, i2);
        handleIntent(intent);
        return 2;
    }
}
