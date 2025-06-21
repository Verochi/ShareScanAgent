package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloaderBuilder {
    private com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator chunkAdjustCalculator;
    private com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator chunkCntCalculator;
    private java.util.concurrent.ExecutorService chunkDownloadExecutor;
    private final android.content.Context context;
    private java.util.concurrent.ExecutorService cpuThreadExecutor;
    private java.util.concurrent.ExecutorService dbThreadExecutor;
    private com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private com.ss.android.socialbase.downloader.network.IDownloadDns downloadDns;
    private boolean downloadInMultiProcess;
    private com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler downloadLaunchHandler;
    private com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener downloadMonitorListener;
    private com.ss.android.socialbase.downloader.depend.IDownloadSettings downloadSetting;
    private com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService headHttpService;
    private com.ss.android.socialbase.downloader.network.IDownloadHttpService httpService;
    private com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator idGenerator;
    private java.util.concurrent.ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private java.util.concurrent.ExecutorService mixApkDownloadExecutor;
    private java.util.concurrent.ExecutorService mixDefaultDownloadExecutor;
    private java.util.concurrent.ExecutorService mixFrequentDownloadExecutor;
    private com.ss.android.socialbase.downloader.downloader.IMonitorConfig monitorConfig;
    private com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback;
    private java.util.concurrent.ExecutorService okHttpDispatcherExecutor;
    private com.ss.android.socialbase.downloader.downloader.ITTNetHandler ttNetHandler;
    private int writeBufferSize;
    private java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> downloadCompleteHandlers = new java.util.ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(android.content.Context context) {
        this.context = context;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!this.downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    this.downloadCompleteHandlers.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public com.ss.android.socialbase.downloader.downloader.Downloader build() {
        return new com.ss.android.socialbase.downloader.downloader.Downloader(this);
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder chunkAdjustCalculator(com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator iChunkAdjustCalculator) {
        this.chunkAdjustCalculator = iChunkAdjustCalculator;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder chunkCntCalculator(com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator) {
        this.chunkCntCalculator = iChunkCntCalculator;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder chunkThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder cpuThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder dbThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadCache(com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache) {
        this.downloadCache = iDownloadCache;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.IDownloadDns iDownloadDns) {
        this.downloadDns = iDownloadDns;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadLaunchHandler(com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler iDownloadLaunchHandler) {
        this.downloadLaunchHandler = iDownloadLaunchHandler;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener iDownloadMonitorListener) {
        this.downloadMonitorListener = iDownloadMonitorListener;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloadSetting(com.ss.android.socialbase.downloader.depend.IDownloadSettings iDownloadSettings) {
        this.downloadSetting = iDownloadSettings;
        return this;
    }

    public java.util.concurrent.ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public java.util.concurrent.ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public java.util.concurrent.ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public com.ss.android.socialbase.downloader.downloader.IDownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public com.ss.android.socialbase.downloader.network.IDownloadDns getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadSettings getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService getHeadHttpService() {
        return this.headHttpService;
    }

    public com.ss.android.socialbase.downloader.network.IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public java.util.concurrent.ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public java.util.concurrent.ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public java.util.concurrent.ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public java.util.concurrent.ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public com.ss.android.socialbase.downloader.downloader.IMonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public java.util.concurrent.ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public com.ss.android.socialbase.downloader.downloader.ITTNetHandler getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService iDownloadHeadHttpService) {
        this.headHttpService = iDownloadHeadHttpService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder httpService(com.ss.android.socialbase.downloader.network.IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder idGenerator(com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator iDownloadIdGenerator) {
        this.idGenerator = iDownloadIdGenerator;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder ioThreadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder mixApkDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder mixDefaultDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder mixFrequentDownloadExecutor(java.util.concurrent.ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder monitorConfig(com.ss.android.socialbase.downloader.downloader.IMonitorConfig iMonitorConfig) {
        this.monitorConfig = iMonitorConfig;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder notificationClickCallback(com.ss.android.socialbase.downloader.depend.INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder okHttpDispatcherExecutor(java.util.concurrent.ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder ttNetHandler(com.ss.android.socialbase.downloader.downloader.ITTNetHandler iTTNetHandler) {
        this.ttNetHandler = iTTNetHandler;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }
}
