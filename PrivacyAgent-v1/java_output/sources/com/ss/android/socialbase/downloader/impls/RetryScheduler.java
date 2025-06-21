package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class RetryScheduler implements android.os.Handler.Callback, com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final java.lang.String TAG = "RetryScheduler";
    private static volatile com.ss.android.socialbase.downloader.impls.RetryScheduler sInstance;
    private static com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler sRetryScheduleHandler;
    private android.net.ConnectivityManager mConnectivityManager;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper(), this);
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo> mRetryInfoList = new android.util.SparseArray<>();
    private int mWaitingRetryTasksCount = 0;
    private final android.content.Context mContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$1$1, reason: invalid class name and collision with other inner class name */
        public class C04861 extends android.net.ConnectivityManager.NetworkCallback {
            public C04861() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(android.net.Network network) {
                com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.downloader.impls.RetryScheduler.TAG, "network onAvailable: ");
                com.ss.android.socialbase.downloader.impls.RetryScheduler.this.scheduleAllTaskRetry(1, true);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mContext != null) {
                    com.ss.android.socialbase.downloader.impls.RetryScheduler retryScheduler = com.ss.android.socialbase.downloader.impls.RetryScheduler.this;
                    retryScheduler.mConnectivityManager = (android.net.ConnectivityManager) retryScheduler.mContext.getApplicationContext().getSystemService("connectivity");
                    com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mConnectivityManager.registerNetworkCallback(new android.net.NetworkRequest.Builder().build(), new com.ss.android.socialbase.downloader.impls.RetryScheduler.AnonymousClass1.C04861());
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ boolean val$force;
        final /* synthetic */ int val$level;

        public AnonymousClass2(int i, boolean z) {
            this.val$level = i;
            this.val$force = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int netWorkType;
            try {
                if (com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mWaitingRetryTasksCount > 0 && (netWorkType = com.ss.android.socialbase.downloader.impls.RetryScheduler.this.getNetWorkType()) != 0) {
                    com.ss.android.socialbase.downloader.logger.Logger.i(com.ss.android.socialbase.downloader.impls.RetryScheduler.TAG, "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mWaitingRetryTasksCount);
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    synchronized (com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mRetryInfoList) {
                        for (int i = 0; i < com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mRetryInfoList.size(); i++) {
                            com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo retryInfo = (com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo) com.ss.android.socialbase.downloader.impls.RetryScheduler.this.mRetryInfoList.valueAt(i);
                            if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, this.val$level, netWorkType, this.val$force)) {
                                if (this.val$force) {
                                    retryInfo.resetRetryInterval();
                                }
                                arrayList.add(retryInfo);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        java.util.Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            com.ss.android.socialbase.downloader.impls.RetryScheduler.this.doSchedulerRetryInSubThread(((com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo) it.next()).id, netWorkType, false);
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int val$downloadId;

        public AnonymousClass3(int i) {
            this.val$downloadId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.impls.RetryScheduler retryScheduler = com.ss.android.socialbase.downloader.impls.RetryScheduler.this;
                retryScheduler.doSchedulerRetryInSubThread(this.val$downloadId, retryScheduler.getNetWorkType(), true);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class RetryInfo {
        final int[] allowErrorCode;
        final int id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private int mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private long mLastRetryTime;
        private boolean mNeedWifi;
        private int mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        public RetryInfo(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.id = i;
            this.level = i2;
            this.maxCount = i3;
            this.intervalMs = i4;
            this.intervalMsAcceleration = i5;
            this.useJobScheduler = z;
            this.allowErrorCode = iArr;
            this.mCurrentIntervalMs = i4;
        }

        public boolean canRetry(long j, int i, int i2, boolean z) {
            if (!this.mIsWaitingRetry) {
                com.ss.android.socialbase.downloader.logger.Logger.i(com.ss.android.socialbase.downloader.impls.RetryScheduler.TAG, "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.level < i || this.mRetryCount >= this.maxCount) {
                return false;
            }
            if (!this.mNeedWifi || i2 == 2) {
                return z || j - this.mLastRetryTime >= ((long) this.intervalMs);
            }
            return false;
        }

        public int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs;
        }

        public synchronized void increaseRetryCount() {
            this.mRetryCount++;
        }

        public synchronized void increaseRetryInterval() {
            this.mCurrentIntervalMs += this.intervalMsAcceleration;
        }

        public void resetRetryInterval() {
            this.mCurrentIntervalMs = this.intervalMs;
        }

        public synchronized void updateRetryTimeStamp(long j) {
            this.mLastRetryTime = j;
        }
    }

    public interface RetryScheduleHandler {
        void cancelRetry(int i);

        void scheduleRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private RetryScheduler() {
        registerNetworkCallback();
        this.mIsDownloaderProcess = com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess();
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private boolean canRetryForAllowErrorCode(com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo retryInfo, int i) {
        int[] iArr = retryInfo.allowErrorCode;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canRetryWhenInsufficientSpace(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        long j;
        try {
            j = com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(downloadInfo.getTempPath());
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (j < (baseException instanceof com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException ? ((com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException) baseException).getRequiredSpaceBytes() : downloadInfo.getTotalBytes() - downloadInfo.getCurBytes())) {
            com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                if (j > 0) {
                    int optInt = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                    if (optInt > 0) {
                        long j2 = j - (optInt * 1048576);
                        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "retry schedule: available = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j) + "MB, minKeep = " + optInt + "MB, canDownload = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j2) + "MB");
                        if (j2 <= 0) {
                            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo createRetryInfo(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i);
        boolean z2 = false;
        int optInt = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RETRY_SCHEDULE, 0);
        org.json.JSONObject optJSONObject = obtain.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int i4 = 60;
        if (optJSONObject != null) {
            int optInt2 = optJSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
            int optInt3 = optJSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
            int optInt4 = optJSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
            if (sRetryScheduleHandler != null && optJSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) == 1) {
                z2 = true;
            }
            iArr = parserAllowErrorCode(optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
            i2 = optInt4;
            z = z2;
            i3 = optInt2;
            i4 = optInt3;
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo(i, optInt, i3, i4 * 1000, i2 * 1000, z, iArr);
    }

    private void doScheduleAllTaskRetry(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.downloader.impls.RetryScheduler.AnonymousClass2(i, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSchedulerRetryInSubThread(int i, int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener reserveWifiStatusListener;
        boolean z2;
        android.content.Context context = this.mContext;
        if (context == null) {
            return;
        }
        synchronized (this.mRetryInfoList) {
            com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            boolean z3 = true;
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i3 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i3;
                if (i3 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + retryInfo.mRetryCount + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                removeRetryInfo(i);
                return;
            }
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "doSchedulerRetryInSubThread，id:".concat(java.lang.String.valueOf(i)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                removeRetryInfo(i);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 4, 3);
                }
                com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler downloadLaunchHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    downloadLaunchHandler.onLaunchResume(java.util.Collections.singletonList(downloadInfo), 3);
                }
                removeRetryInfo(i);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i2 != 0) {
                z2 = true;
            } else if (!retryInfo.useJobScheduler) {
                return;
            } else {
                z2 = false;
            }
            com.ss.android.socialbase.downloader.exception.BaseException failedException = downloadInfo.getFailedException();
            if (z2 && com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(failedException)) {
                z2 = canRetryWhenInsufficientSpace(downloadInfo, failedException);
            }
            retryInfo.increaseRetryCount();
            if (!z2) {
                if (z) {
                    retryInfo.increaseRetryInterval();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z3 = false;
                }
                tryStartScheduleRetry(downloadInfo, z3, i2);
                return;
            }
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doSchedulerRetry: restart task, ****** id = " + retryInfo.id);
            retryInfo.updateRetryTimeStamp(java.lang.System.currentTimeMillis());
            if (z) {
                retryInfo.increaseRetryInterval();
            }
            downloadInfo.setRetryScheduleCount(retryInfo.mRetryCount);
            if (downloadInfo.getStatus() == -1) {
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).restart(downloadInfo.getId());
            }
        }
    }

    public static com.ss.android.socialbase.downloader.impls.RetryScheduler getInstance() {
        if (sInstance == null) {
            synchronized (com.ss.android.socialbase.downloader.impls.RetryScheduler.class) {
                if (sInstance == null) {
                    sInstance = new com.ss.android.socialbase.downloader.impls.RetryScheduler();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetWorkType() {
        try {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (android.net.ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity");
            }
            android.net.NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (java.lang.Exception unused) {
        }
        return 0;
    }

    private com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo obtainRetryInfo(int i) {
        com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo retryInfo = this.mRetryInfoList.get(i);
        if (retryInfo == null) {
            synchronized (this.mRetryInfoList) {
                retryInfo = this.mRetryInfoList.get(i);
                if (retryInfo == null) {
                    retryInfo = createRetryInfo(i);
                }
                this.mRetryInfoList.put(i, retryInfo);
            }
        }
        return retryInfo;
    }

    private int[] parserAllowErrorCode(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.lang.String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = java.lang.Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private void registerNetworkCallback() {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.downloader.impls.RetryScheduler.AnonymousClass1());
    }

    private void removeRetryInfo(int i) {
        synchronized (this.mRetryInfoList) {
            this.mRetryInfoList.remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAllTaskRetry(int i, boolean z) {
        if (this.mWaitingRetryTasksCount <= 0) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.mLastHandleAllTaskTime < 10000) {
                    return;
                }
            }
            this.mLastHandleAllTaskTime = currentTimeMillis;
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.mHandler.removeMessages(0);
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i;
            obtain.arg2 = z ? 1 : 0;
            this.mHandler.sendMessageDelayed(obtain, 2000L);
        }
    }

    public static void setRetryScheduleHandler(com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler retryScheduleHandler) {
        sRetryScheduleHandler = retryScheduleHandler;
    }

    private void tryStartScheduleRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, int i) {
        com.ss.android.socialbase.downloader.exception.BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo obtainRetryInfo = obtainRetryInfo(downloadInfo.getId());
        if (obtainRetryInfo.mRetryCount > obtainRetryInfo.maxCount) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "tryStartScheduleRetry, id = " + obtainRetryInfo.id + ", mRetryCount = " + obtainRetryInfo.mRetryCount + ", maxCount = " + obtainRetryInfo.maxCount);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(failedException) && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!canRetryForAllowErrorCode(obtainRetryInfo, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "allow error code, id = " + obtainRetryInfo.id + ", error code = " + errorCode);
        }
        obtainRetryInfo.mNeedWifi = z;
        synchronized (this.mRetryInfoList) {
            if (!obtainRetryInfo.mIsWaitingRetry) {
                obtainRetryInfo.mIsWaitingRetry = true;
                this.mWaitingRetryTasksCount++;
            }
        }
        int currentRetryIntervalMs = obtainRetryInfo.getCurrentRetryIntervalMs();
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "tryStartScheduleRetry: id = " + obtainRetryInfo.id + ", delayTimeMills = " + currentRetryIntervalMs + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
        if (!obtainRetryInfo.useJobScheduler) {
            if (z) {
                return;
            }
            this.mHandler.removeMessages(downloadInfo.getId());
            this.mHandler.sendEmptyMessageDelayed(downloadInfo.getId(), currentRetryIntervalMs);
            return;
        }
        if (i == 0) {
            obtainRetryInfo.resetRetryInterval();
        }
        com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
        if (retryScheduleHandler != null) {
            retryScheduleHandler.scheduleRetry(downloadInfo, currentRetryIntervalMs, z, i);
        }
        if (this.mIsDownloaderProcess) {
            obtainRetryInfo.updateRetryTimeStamp(java.lang.System.currentTimeMillis());
            obtainRetryInfo.increaseRetryCount();
            obtainRetryInfo.increaseRetryInterval();
        }
    }

    public void doSchedulerRetry(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.downloader.impls.RetryScheduler.AnonymousClass3(i));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what == 0) {
            doScheduleAllTaskRetry(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "handleMessage, doSchedulerRetry, id = " + message.what);
            doSchedulerRetry(message.what);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void tryCancelScheduleRetry(int i) {
        synchronized (this.mRetryInfoList) {
            com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i2 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i2;
                if (i2 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (!retryInfo.useJobScheduler) {
                this.mHandler.removeMessages(i);
                return;
            }
            com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
            if (retryScheduleHandler != null) {
                retryScheduleHandler.cancelRetry(i);
            }
        }
    }

    public void tryStartScheduleRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || android.text.TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_APK) || !com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            return;
        }
        tryStartScheduleRetry(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), getNetWorkType());
    }
}
