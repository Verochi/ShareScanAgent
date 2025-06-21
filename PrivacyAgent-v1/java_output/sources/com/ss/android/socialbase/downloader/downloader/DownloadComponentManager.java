package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    private static volatile android.content.Context appContext;
    private static volatile com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator chunkAdjustCalculator;
    private static volatile com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator chunkCntCalculator;
    private static volatile java.util.concurrent.ExecutorService chunkDownloadExecutor;
    private static volatile java.util.concurrent.ExecutorService cpuThreadExecutor;
    private static volatile java.util.concurrent.ExecutorService dbThreadExecutor;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadDns defaultDownloadDns;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService defaultHeadHttpService;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadHttpService defaultHttpService;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private static final java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadDns downloadDns;
    private static volatile com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine;
    private static com.ss.android.socialbase.downloader.monitor.InnerEventListener downloadEventListener;
    private static int downloadExpSwitchCode;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener downloadMonitorListener;
    private static volatile com.ss.android.socialbase.downloader.downloader.DownloadReceiver downloadReceiver;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler downloadServiceHandler;
    private static volatile com.ss.android.socialbase.downloader.depend.IDownloadSettings downloadSettings;
    private static final java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener> downloadTaskExecuteListeners;
    private static final int fixedCPUPoolSize;
    private static final int fixedDBPoolSize;
    private static final int fixedIOPoolSize;
    private static final int fixedMIXPoolSize;
    private static volatile boolean hasInit;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService headHttpService;
    private static volatile com.ss.android.socialbase.downloader.network.IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile com.ss.android.socialbase.downloader.downloader.ITTNetHandler iTTNetHandler;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator idGenerator;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator independentHolderCreator;
    private static volatile java.util.concurrent.ExecutorService ioThreadExecutor;
    private static int maxDownloadPoolSize;
    private static volatile java.util.concurrent.ExecutorService mixApkDownloadExecutor;
    private static volatile java.util.concurrent.ExecutorService mixDefaultDownloadExecutor;
    private static volatile java.util.concurrent.ExecutorService mixFrequentDownloadExecutor;
    private static volatile com.ss.android.socialbase.downloader.downloader.IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static boolean notAutoRebootService;
    private static volatile com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback;
    private static volatile java.util.concurrent.ExecutorService okHttpDispatcherExecutor;
    private static com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private static volatile java.util.concurrent.ScheduledExecutorService scheduledExecutor;
    private static int writeBufferSize;
    private static volatile java.util.List<com.ss.android.socialbase.downloader.depend.ProcessCallback> processCallbacks = new java.util.ArrayList();
    private static volatile boolean downloadInMultiProcess = false;
    private static volatile okhttp3.OkHttpClient sOkHttpClient = null;
    private static final java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> downloadCompleteHandlers = new java.util.ArrayList();
    private static boolean isReceiverRegistered = false;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
            if (appContext != null) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.getCurProcessName(appContext);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.ss.android.socialbase.downloader.network.IDownloadDns {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadDns
        public java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException {
            return okhttp3.Dns.SYSTEM.lookup(str);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.ss.android.socialbase.downloader.monitor.InnerEventListener {
        @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
        public void onEvent(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        }

        @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
        public void onUnityEvent(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        }
    }

    public interface IndependentHolderCreator {

        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache createCache(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener);

        com.ss.android.socialbase.downloader.downloader.IDownloadProxy createProxy();

        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler createServiceHandler();
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = availableProcessors;
        fixedIOPoolSize = (java.lang.Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = availableProcessors;
        fixedDBPoolSize = availableProcessors;
        writeBufferSize = 8192;
        downloadCacheSyncStatusListeners = new java.util.ArrayList();
        downloadTaskExecuteListeners = new java.util.ArrayList();
        needAutoRefreshUnSuccessTask = true;
        notAutoRebootService = false;
        hasInit = false;
    }

    private DownloadComponentManager() {
    }

    public static void addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                if (!list.contains(iDownloadCompleteHandler)) {
                    list.add(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback) {
        if (processCallback == null) {
            return;
        }
        synchronized (processCallbacks) {
            processCallbacks.add(processCallback);
        }
    }

    public static synchronized void coverComponent(com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloaderBuilder) {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            setDownloadBuilder(downloaderBuilder);
        }
    }

    public static okhttp3.OkHttpClient.Builder createDownloadClientBuilder() {
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(java.util.Collections.singletonList(okhttp3.Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor != null) {
            builder.dispatcher(new okhttp3.Dispatcher(okHttpDispatcherExecutor));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection(boolean z, int i, java.lang.String str, java.lang.String str2, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, int i2, boolean z2, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws java.lang.Exception {
        java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list2;
        int i3;
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection2;
        if (!android.text.TextUtils.isEmpty(str2)) {
            java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> arrayList = list == null ? new java.util.ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_REQUEST_HOST_IP, str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] downloadNetLibs = getDownloadNetLibs(i3);
        java.lang.Exception exc = null;
        for (int i4 : downloadNetLibs) {
            try {
                downloadWithConnection2 = downloadWithConnection2(i, str, str2, list2, i4, z2, downloadInfo);
            } catch (java.lang.Exception e) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCode304Error(e) && com.ss.android.socialbase.downloader.utils.DownloadUtils.hasDownloadCacheHeader(list2)) {
                    com.ss.android.socialbase.downloader.logger.Logger.d("dcach::http exception 304, throw excepiton, not retry " + e);
                    throw e;
                }
                exc = e;
            }
            if (downloadWithConnection2 != null) {
                return downloadWithConnection2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection(boolean z, int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.lang.Exception {
        return downloadWithConnection(z, i, str, null, list, 0, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection2(int i, java.lang.String str, java.lang.String str2, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, int i2, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        com.ss.android.socialbase.downloader.network.IDownloadHttpService httpService2 = i2 == 1 ? getHttpService() : getDefaultHttpService();
        if (httpService2 == null) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1022, new java.io.IOException("httpService not exist, netLib = " + i2));
        }
        java.io.IOException iOException = null;
        long j = 0;
        if (z) {
            try {
                j = java.lang.System.currentTimeMillis();
            } catch (java.io.IOException e) {
                e = e;
                iOException = e;
                throw iOException;
            } catch (java.lang.Throwable th) {
                th = th;
                java.io.IOException iOException2 = iOException;
                if (z) {
                }
                throw th;
            }
        }
        try {
            try {
                com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection = httpService2.downloadWithConnection(i, str, list);
                if (z) {
                    com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(downloadWithConnection, str, str2, java.lang.System.currentTimeMillis() - j, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, i2, null, downloadInfo);
                }
                return downloadWithConnection;
            } catch (java.io.IOException e2) {
                e = e2;
                iOException = e;
                throw iOException;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            java.io.IOException iOException22 = iOException;
            if (z) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(null, str, str2, java.lang.System.currentTimeMillis() - j, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, i2, iOException22, downloadInfo);
            }
            throw th;
        }
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.lang.Exception {
        return downloadWithHeadConnection(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, int i, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws java.lang.Exception {
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection2;
        java.lang.Exception e = null;
        for (int i2 : getDownloadNetLibs(i)) {
            try {
                downloadWithHeadConnection2 = downloadWithHeadConnection2(str, list, i2, z, downloadInfo);
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            if (downloadWithHeadConnection2 != null) {
                return downloadWithHeadConnection2;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection2(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, int i, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService headHttpService2 = i == 1 ? getHeadHttpService() : getDefaultHeadHttpService();
        if (headHttpService2 == null) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1022, new java.io.IOException("httpService not exist, netLib = " + i));
        }
        java.io.IOException iOException = null;
        long j = 0;
        if (z) {
            try {
                j = java.lang.System.currentTimeMillis();
            } catch (java.io.IOException e) {
                e = e;
                iOException = e;
                throw iOException;
            } catch (java.lang.Throwable th) {
                th = th;
                java.io.IOException iOException2 = iOException;
                if (z) {
                }
                throw th;
            }
        }
        try {
            try {
                com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithConnection = headHttpService2.downloadWithConnection(str, list);
                if (z) {
                    com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(downloadWithConnection, str, null, java.lang.System.currentTimeMillis() - j, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, i, null, downloadInfo);
                }
                return downloadWithConnection;
            } catch (java.io.IOException e2) {
                e = e2;
                iOException = e;
                throw iOException;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            java.io.IOException iOException22 = iOException;
            if (z) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(null, str, null, java.lang.System.currentTimeMillis() - j, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, i, iOException22, downloadInfo);
            }
            throw th;
        }
    }

    public static void ensureOPPO() {
        if (android.text.TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO)) {
            com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO = com.igexin.assist.util.AssistUtils.BRAND_OPPO;
            com.ss.android.socialbase.downloader.constants.DownloadConstants.UPPER_OPPO = com.igexin.assist.util.AssistUtils.BRAND_OPPO.toUpperCase();
        }
    }

    public static android.app.AlarmManager getAlarmManager() {
        return null;
    }

    public static synchronized android.content.Context getAppContext() {
        android.content.Context context;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            context = appContext;
        }
        return context;
    }

    public static java.util.concurrent.ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (cpuThreadExecutor == null) {
                    int i = fixedCPUPoolSize;
                    java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    cpuThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return cpuThreadExecutor;
    }

    public static com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator getChunkAdjustCalculator() {
        if (chunkAdjustCalculator == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (chunkAdjustCalculator == null) {
                    chunkAdjustCalculator = new com.ss.android.socialbase.downloader.impls.DefaultChunkAdjustCalculator();
                }
            }
        }
        return chunkAdjustCalculator;
    }

    public static com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator getChunkCntCalculator() {
        if (chunkCntCalculator == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (chunkCntCalculator == null) {
                    chunkCntCalculator = new com.ss.android.socialbase.downloader.impls.DefaultChunkCntCalculator();
                }
            }
        }
        return chunkCntCalculator;
    }

    public static java.util.concurrent.ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (chunkDownloadExecutor == null) {
                    int i = fixedIOPoolSize;
                    java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    chunkDownloadExecutor = threadPoolExecutor;
                }
            }
        }
        return chunkDownloadExecutor;
    }

    public static java.util.concurrent.ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (dbThreadExecutor == null) {
                    int i = fixedDBPoolSize;
                    java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    dbThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return dbThreadExecutor;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (defaultDownloadDns == null) {
                    defaultDownloadDns = new com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.AnonymousClass2();
                }
            }
        }
        return defaultDownloadDns;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService getDefaultHeadHttpService() {
        if (defaultHeadHttpService == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (defaultHeadHttpService == null) {
                    defaultHeadHttpService = new com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService();
                }
            }
        }
        return defaultHeadHttpService;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (defaultHttpService == null) {
                    defaultHttpService = new com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService();
                }
            }
        }
        return defaultHttpService;
    }

    public static com.ss.android.socialbase.downloader.downloader.IDownloadCache getDownloadCache() {
        if (downloadCache == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (downloadCache == null) {
                    downloadCache = new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache();
                }
            }
        }
        return downloadCache;
    }

    public static okhttp3.OkHttpClient getDownloadClient() {
        if (sOkHttpClient == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (sOkHttpClient == null) {
                    sOkHttpClient = createDownloadClientBuilder().build();
                }
            }
        }
        return sOkHttpClient;
    }

    public static java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static com.ss.android.socialbase.downloader.impls.AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (downloadEngine == null) {
                    downloadEngine = new com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine();
                }
            }
        }
        return downloadEngine;
    }

    public static int getDownloadExpSwitchCode() {
        return downloadExpSwitchCode;
    }

    public static int getDownloadId(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        java.lang.String taskKey = downloadInfo.getTaskKey();
        if (android.text.TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return getDownloadId(taskKey, downloadInfo.getSavePath());
    }

    public static int getDownloadId(java.lang.String str, java.lang.String str2) {
        com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator idGenerator2 = getIdGenerator();
        if (idGenerator2 == null) {
            return 0;
        }
        return idGenerator2.generate(str, str2);
    }

    public static synchronized com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler getDownloadLaunchHandler() {
        com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler iDownloadLaunchHandler;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            iDownloadLaunchHandler = downloadLaunchHandler;
        }
        return iDownloadLaunchHandler;
    }

    public static com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    private static int[] getDownloadNetLibs(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (downloadServiceHandler == null) {
                    downloadServiceHandler = new com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler();
                }
            }
        }
        return downloadServiceHandler;
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject getDownloadSetting() {
        return (downloadSettings == null || downloadSettings.get() == null) ? com.ss.android.socialbase.downloader.constants.DownloadConstants.EMPTY_JSON : downloadSettings.get();
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.monitor.InnerEventListener getEventListener() {
        if (downloadEventListener == null) {
            downloadEventListener = new com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.AnonymousClass3();
        }
        return downloadEventListener;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService getHeadHttpService() {
        return headHttpService;
    }

    public static com.ss.android.socialbase.downloader.network.IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static java.util.concurrent.ExecutorService getIOThreadExecutor() {
        return ioThreadExecutor != null ? ioThreadExecutor : getCPUThreadExecutor();
    }

    public static com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator getIdGenerator() {
        if (idGenerator == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (idGenerator == null) {
                    idGenerator = new com.ss.android.socialbase.downloader.impls.DefaultIdGenerator();
                }
            }
        }
        return idGenerator;
    }

    public static com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (independentDownloadServiceHandler == null) {
                    independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
                }
            }
        }
        return independentDownloadServiceHandler;
    }

    public static com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    private static int getMaxDownloadPoolSize() {
        int i = maxDownloadPoolSize;
        if (i <= 0 || i > fixedCPUPoolSize) {
            maxDownloadPoolSize = fixedCPUPoolSize;
        }
        return maxDownloadPoolSize;
    }

    public static java.util.concurrent.ExecutorService getMixApkThreadExecutor() {
        return mixApkDownloadExecutor != null ? mixApkDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static java.util.concurrent.ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (mixDefaultDownloadExecutor == null) {
                    int i = fixedMIXPoolSize;
                    java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    mixDefaultDownloadExecutor = threadPoolExecutor;
                }
            }
        }
        return mixDefaultDownloadExecutor;
    }

    public static java.util.concurrent.ExecutorService getMixFrequentThreadExecutor() {
        return mixFrequentDownloadExecutor != null ? mixFrequentDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static synchronized com.ss.android.socialbase.downloader.downloader.IMonitorConfig getMonitorConfig() {
        com.ss.android.socialbase.downloader.downloader.IMonitorConfig iMonitorConfig;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            iMonitorConfig = monitorConfig;
        }
        return iMonitorConfig;
    }

    public static com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static java.util.List<com.ss.android.socialbase.downloader.depend.ProcessCallback> getProcessCallbacks() {
        java.util.List<com.ss.android.socialbase.downloader.depend.ProcessCallback> list;
        synchronized (processCallbacks) {
            list = processCallbacks;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator getRetryDelayTimeCalculator() {
        if (retryDelayTimeCalculator == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (retryDelayTimeCalculator == null) {
                    retryDelayTimeCalculator = new com.ss.android.socialbase.downloader.impls.DefaultRetryDelayTimeCalculator();
                }
            }
        }
        return retryDelayTimeCalculator;
    }

    public static java.util.concurrent.ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (scheduledExecutor == null) {
                    scheduledExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return scheduledExecutor;
    }

    public static com.ss.android.socialbase.downloader.downloader.ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
                if (iTTNetHandler == null) {
                    iTTNetHandler = new com.ss.android.socialbase.downloader.downloader.ITTNetHandler.DefaultTTNetHandler();
                }
            }
        }
        return iTTNetHandler;
    }

    public static synchronized int getWriteBufferSize() {
        int i;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            i = writeBufferSize;
        }
        return i;
    }

    public static synchronized void initComponent(com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloaderBuilder) {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            if (hasInit) {
                com.ss.android.socialbase.downloader.logger.Logger.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z = downloadInMultiProcess;
            setDownloadBuilder(downloaderBuilder);
            if (downloadCache == null) {
                downloadCache = new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache();
            }
            if (downloadServiceHandler == null) {
                downloadServiceHandler = new com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler();
            }
            if (independentDownloadServiceHandler == null && independentHolderCreator != null) {
                independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
            }
            if (idGenerator == null) {
                idGenerator = new com.ss.android.socialbase.downloader.impls.DefaultIdGenerator();
            }
            if (downloadEngine == null) {
                downloadEngine = new com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine();
            }
            if (chunkCntCalculator == null) {
                chunkCntCalculator = new com.ss.android.socialbase.downloader.impls.DefaultChunkCntCalculator();
            }
            if (chunkAdjustCalculator == null) {
                chunkAdjustCalculator = new com.ss.android.socialbase.downloader.impls.DefaultChunkAdjustCalculator();
            }
            if (retryDelayTimeCalculator == null) {
                retryDelayTimeCalculator = new com.ss.android.socialbase.downloader.impls.DefaultRetryDelayTimeCalculator();
            }
            int i = maxDownloadPoolSize;
            if (i <= 0 || i > fixedCPUPoolSize) {
                maxDownloadPoolSize = fixedCPUPoolSize;
            }
            registerDownloadReceiver();
            if (downloadInMultiProcess && !z && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()) {
                com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).startService();
            } else if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainThread()) {
                java.util.concurrent.ExecutorService iOThreadExecutor = getIOThreadExecutor();
                if (iOThreadExecutor != null) {
                    iOThreadExecutor.execute(new com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.AnonymousClass1());
                }
            } else {
                android.content.Context appContext2 = getAppContext();
                if (appContext2 != null) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.getCurProcessName(appContext2);
                }
            }
            ensureOPPO();
            hasInit = true;
        }
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        boolean z;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            z = downloadInMultiProcess;
        }
        return z;
    }

    public static synchronized boolean isHttpServiceInit() {
        boolean z;
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            z = httpServiceInit;
        }
        return z;
    }

    public static boolean isInit() {
        return hasInit;
    }

    private static void needAutoRefreshUnSuccessTask(boolean z) {
        needAutoRefreshUnSuccessTask = z;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static boolean notAutoRebootService() {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.NOT_AUTO_BOOT_SERVICE, notAutoRebootService ? 1 : 0) > 0;
    }

    public static void onDownloadCacheSyncCallback(com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus downloadCacheSyncStatus) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener : list) {
                if (iDownloadCacheSyncStatusListener != null) {
                    if (downloadCacheSyncStatus == com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus.SYNC_START) {
                        iDownloadCacheSyncStatusListener.onStart();
                    } else if (downloadCacheSyncStatus == com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus.SYNC_SUCCESS) {
                        iDownloadCacheSyncStatusListener.onSuccess();
                    }
                }
            }
            if (downloadCacheSyncStatus == com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus.SYNC_SUCCESS) {
                downloadCacheSyncStatusListeners.clear();
            }
        }
    }

    public static void onDownloadTaskFinish(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, @com.ss.android.socialbase.downloader.constants.BoundType int i) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onFinish(downloadTask, i);
                }
            }
        }
    }

    public static void onDownloadTaskStart(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, @com.ss.android.socialbase.downloader.constants.BoundType int i) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onStart(downloadTask, i);
                }
            }
        }
    }

    public static void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (!list.contains(iDownloadCacheSyncStatusListener)) {
                    list.add(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    private static void registerDownloadReceiver() {
        if (downloadReceiver == null) {
            downloadReceiver = new com.ss.android.socialbase.downloader.downloader.DownloadReceiver();
        }
        if (isReceiverRegistered) {
            return;
        }
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            appContext.registerReceiver(downloadReceiver, intentFilter);
            isReceiverRegistered = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void registerDownloadTaskExecuteListener(com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                if (!list.contains(iDownloadTaskExecuteListener)) {
                    list.add(iDownloadTaskExecuteListener);
                }
            }
        }
    }

    public static void removeDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                if (list.contains(iDownloadCompleteHandler)) {
                    list.remove(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static synchronized void setAppContext(android.content.Context context) {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            if (context != null) {
                if (appContext == null) {
                    appContext = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().init(appContext);
                }
            }
        }
    }

    private static void setCPUThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            cpuThreadExecutor = executorService;
        }
    }

    private static void setChunkAdjustCalculator(com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator iChunkAdjustCalculator) {
        if (iChunkAdjustCalculator != null) {
            chunkAdjustCalculator = iChunkAdjustCalculator;
        }
    }

    private static void setChunkCntCalculator(com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator) {
        if (iChunkCntCalculator != null) {
            chunkCntCalculator = iChunkCntCalculator;
        }
    }

    public static void setChunkDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            chunkDownloadExecutor = executorService;
        }
    }

    private static void setDBThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            dbThreadExecutor = executorService;
        }
    }

    private static void setDownloadBuilder(com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                setAppContext(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                setDownloadCache(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                setIdGenerator(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                setChunkCntCalculator(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                setNotificationClickCallback(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                setMaxDownloadPoolSize(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                setHttpService(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                setHeadHttpService(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                setDownloadLaunchHandler(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                setCPUThreadExecutor(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                setIOThreadExecutor(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                setMixDefaultDownloadExecutor(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                setMixFrequentDownloadExecutor(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                setMixApkDownloadExecutor(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                setDBThreadExecutor(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                setChunkDownloadExecutor(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                setOkHttpDispatcherExecutor(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                setDownloadCompleteHandlers(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                monitorConfig = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                writeBufferSize = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                setChunkAdjustCalculator(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                downloadInMultiProcess = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                downloadExpSwitchCode = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                setDownloadSetting(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                downloadDns = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                com.ss.android.socialbase.downloader.downloader.ITTNetHandler tTNetHandler = downloaderBuilder.getTTNetHandler();
                iTTNetHandler = tTNetHandler;
                if (tTNetHandler.isTTNetEnable()) {
                    setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
                    setHeadHttpService(iTTNetHandler.getTTNetDownloadHeadHttpService());
                } else {
                    setHttpService(getDefaultHttpService());
                    setHeadHttpService(getDefaultHeadHttpService());
                }
            }
            needAutoRefreshUnSuccessTask(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                setDownloadMonitorListener(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void setDownloadCache(com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache) {
        if (iDownloadCache != null) {
            downloadCache = iDownloadCache;
        }
    }

    private static void setDownloadCompleteHandlers(java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> list) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> list2 = downloadCompleteHandlers;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void setDownloadEventListener(com.ss.android.socialbase.downloader.monitor.InnerEventListener innerEventListener) {
        downloadEventListener = innerEventListener;
    }

    public static synchronized void setDownloadInMultiProcess() {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            if (downloadInMultiProcess) {
                return;
            }
            downloadInMultiProcess = true;
            try {
                android.content.Intent intent = new android.content.Intent(getAppContext(), (java.lang.Class<?>) com.ss.android.socialbase.downloader.impls.DownloadHandleService.class);
                intent.setAction(com.ss.android.socialbase.downloader.constants.DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);
                getAppContext().startService(intent);
                if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()) {
                    com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).startService();
                }
            } catch (java.lang.Throwable th) {
                downloadInMultiProcess = false;
                th.printStackTrace();
            }
        }
    }

    public static synchronized void setDownloadLaunchHandler(com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler iDownloadLaunchHandler) {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            if (iDownloadLaunchHandler != null) {
                downloadLaunchHandler = iDownloadLaunchHandler;
                if (downloadCache instanceof com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) {
                    ((com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();
                }
            }
        }
    }

    private static void setDownloadMonitorListener(com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener iDownloadMonitorListener) {
        if (iDownloadMonitorListener != null) {
            downloadMonitorListener = iDownloadMonitorListener;
        }
    }

    public static void setDownloadSetting(com.ss.android.socialbase.downloader.depend.IDownloadSettings iDownloadSettings) {
        downloadSettings = iDownloadSettings;
        com.ss.android.socialbase.downloader.setting.DownloadSetting.init();
    }

    public static void setHeadHttpService(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService iDownloadHeadHttpService) {
        if (iDownloadHeadHttpService != null) {
            headHttpService = iDownloadHeadHttpService;
        }
    }

    public static void setHttpService(com.ss.android.socialbase.downloader.network.IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            httpService = iDownloadHttpService;
        }
        httpServiceInit = httpService != null;
    }

    private static void setIOThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            ioThreadExecutor = executorService;
        }
    }

    private static void setIdGenerator(com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator iDownloadIdGenerator) {
        if (iDownloadIdGenerator != null) {
            idGenerator = iDownloadIdGenerator;
        }
    }

    public static void setIndependentServiceCreator(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator independentHolderCreator2) {
        com.ss.android.socialbase.downloader.logger.Logger.v("wjd", "setIndependentServiceCreator::creator=".concat(java.lang.String.valueOf(independentHolderCreator2)));
        independentHolderCreator = independentHolderCreator2;
    }

    private static void setMaxDownloadPoolSize(int i) {
        if (i > 0) {
            maxDownloadPoolSize = i;
        }
    }

    private static void setMixApkDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            mixApkDownloadExecutor = executorService;
        }
    }

    private static void setMixDefaultDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            mixDefaultDownloadExecutor = executorService;
        }
    }

    private static void setMixFrequentDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            mixFrequentDownloadExecutor = executorService;
        }
    }

    public static void setNotAutoRebootService(boolean z) {
        notAutoRebootService = z;
    }

    public static void setNotificationClickCallback(com.ss.android.socialbase.downloader.depend.INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback != null) {
            notificationClickCallback = iNotificationClickCallback;
        }
    }

    public static void setOkHttpDispatcherExecutor(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            okHttpDispatcherExecutor = executorService;
        }
    }

    public static void setReserveWifiStatusListener(com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener iReserveWifiStatusListener) {
    }

    public static void submitCPUTask(java.lang.Runnable runnable) {
        submitCPUTask(runnable, false);
    }

    public static void submitCPUTask(java.lang.Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainThread()) {
            getCPUThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitDBTask(java.lang.Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainThread()) {
            getDBThreadExecutorService().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitIOTask(java.lang.Runnable runnable) {
        submitIOTask(runnable, false);
    }

    public static void submitIOTask(java.lang.Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainThread()) {
            getIOThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static java.util.concurrent.Future submitScheduleTask(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return getScheduledExecutorService().schedule(runnable, j, timeUnit);
    }

    public static boolean supportMultiProc() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("supportMultiProc::=");
        sb.append(independentHolderCreator != null);
        com.ss.android.socialbase.downloader.logger.Logger.v("wjd", sb.toString());
        return independentHolderCreator != null;
    }

    public static void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (list.contains(iDownloadCacheSyncStatusListener)) {
                    list.remove(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    public static synchronized void unRegisterDownloadReceiver() {
        synchronized (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class) {
            try {
                if (isReceiverRegistered && downloadReceiver != null && appContext != null) {
                    appContext.unregisterReceiver(downloadReceiver);
                    isReceiverRegistered = false;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void unRegisterDownloadTaskExecuteListener(com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                if (list.contains(iDownloadTaskExecuteListener)) {
                    list.remove(iDownloadTaskExecuteListener);
                }
            }
        }
    }
}
