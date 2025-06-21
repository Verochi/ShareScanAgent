package com.ss.android.socialbase.appdownloader;

@android.annotation.TargetApi(21)
/* loaded from: classes19.dex */
public class RetryJobSchedulerService extends android.app.job.JobService {
    public static void vw(int i) {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        try {
            android.app.job.JobScheduler jobScheduler = (android.app.job.JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:14:0x002a, B:23:0x0048, B:24:0x0050, B:27:0x0070, B:29:0x0081, B:30:0x0084, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:38:0x00a7, B:46:0x003e, B:18:0x0035), top: B:13:0x002a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #0 {all -> 0x00b7, blocks: (B:14:0x002a, B:23:0x0048, B:24:0x0050, B:27:0x0070, B:29:0x0081, B:30:0x0084, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:38:0x00a7, B:46:0x003e, B:18:0x0035), top: B:13:0x002a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j, boolean z, int i) {
        android.content.Context appContext;
        long j2;
        int schedule;
        com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener reserveWifiStatusListener;
        com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.onStatusChanged(downloadInfo, 2, 3);
        }
        try {
            android.app.job.JobScheduler jobScheduler = (android.app.job.JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (i != 0 && (!z || i == 2)) {
                j2 = 60000 + j;
                android.app.job.JobInfo.Builder minimumLatency = new android.app.job.JobInfo.Builder(downloadInfo.getId(), new android.content.ComponentName(appContext.getPackageName(), com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
                if (z) {
                    i2 = 1;
                }
                android.app.job.JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
                if (j2 > 0) {
                    requiresDeviceIdle.setOverrideDeadline(j2);
                }
                schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
                }
                if (schedule > 0) {
                    com.ss.android.socialbase.downloader.logger.Logger.w("RetrySchedulerService", "schedule err errCode = ".concat(java.lang.String.valueOf(schedule)));
                    return;
                }
                return;
            }
            j = 1000;
            j2 = 0;
            android.app.job.JobInfo.Builder minimumLatency2 = new android.app.job.JobInfo.Builder(downloadInfo.getId(), new android.content.ComponentName(appContext.getPackageName(), com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (z) {
            }
            android.app.job.JobInfo.Builder requiresDeviceIdle2 = minimumLatency2.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
            }
            schedule = jobScheduler.schedule(requiresDeviceIdle2.build());
            if (schedule > 0) {
                reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
            }
            if (schedule > 0) {
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.notAutoRebootService()) {
            return 2;
        }
        return onStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(android.app.job.JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.logger.Logger.i("RetrySchedulerService", "onStartJob, id = ".concat(java.lang.String.valueOf(jobId)));
        com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().doSchedulerRetry(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(android.app.job.JobParameters jobParameters) {
        return false;
    }
}
