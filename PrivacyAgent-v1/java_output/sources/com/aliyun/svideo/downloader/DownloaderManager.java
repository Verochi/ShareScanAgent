package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class DownloaderManager {
    private static final java.lang.String TAG = "DownloaderManager";
    private static android.content.Context mContext;
    private static com.aliyun.svideo.downloader.FileDownloaderDBController mDbController;
    private static com.aliyun.svideo.downloader.DownloaderManager mDownloadManager;
    private android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> mAllTasks = new android.util.SparseArray<>();
    private int mAutoRetryTimes;
    private com.aliyun.svideo.downloader.DownloaderManagerConfiguration mConfiguration;
    private java.util.List<com.liulishuo.filedownloader.FileDownloadConnectListener> mConnectListenerList;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mDownloadingList;
    private java.util.Map<java.lang.String, java.lang.String> mExtFieldMap;
    private com.aliyun.svideo.downloader.FileDownloaderCallback mGlobalDownloadCallback;
    private okhttp3.Headers mHeaders;
    private com.aliyun.svideo.downloader.ListenerManager mListenerManager;
    private java.util.Queue<com.aliyun.svideo.downloader.FileDownloaderModel> mWaitQueue;

    private DownloaderManager() {
        android.content.Context context;
        if (mDbController != null || (context = mContext) == null) {
            return;
        }
        initDownloaderConfiger(context);
    }

    private com.aliyun.svideo.downloader.FileDownloaderModel addTask(java.lang.String str) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setUrl(str);
        fileDownloaderModel.setPath(createPath(str));
        return addTask(fileDownloaderModel, str);
    }

    private java.lang.String createPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return com.liulishuo.filedownloader.util.FileDownloadUtils.getDefaultSaveFilePath(str);
    }

    public static com.aliyun.svideo.downloader.DownloaderManager getInstance() {
        if (mDownloadManager == null) {
            synchronized (com.aliyun.svideo.downloader.DownloaderManager.class) {
                if (mDownloadManager == null || (mDbController == null && mContext != null)) {
                    mDownloadManager = new com.aliyun.svideo.downloader.DownloaderManager();
                }
            }
        }
        return mDownloadManager;
    }

    private void initDownloaderConfiger(android.content.Context context) {
        java.io.File filesDirectory = com.aliyun.common.utils.StorageUtils.getFilesDirectory(context);
        if (!filesDirectory.exists()) {
            filesDirectory.mkdirs();
        }
        com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder downloadStorePath = new com.aliyun.svideo.downloader.DownloaderManagerConfiguration.Builder(context).setMaxDownloadingCount(50).setDbExtField(new java.util.HashMap()).setDbVersion(2).setDbUpgradeListener(null).setDownloadStorePath(filesDirectory.getAbsolutePath());
        if (mDbController == null) {
            init(downloadStorePath.build());
        }
    }

    public void addFileDownloadListener(int i, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        this.mListenerManager.getBridgeListener(i).addDownloadListener(fileDownloaderCallback);
    }

    public void addServiceConnectListener(com.liulishuo.filedownloader.FileDownloadConnectListener fileDownloadConnectListener) {
        com.liulishuo.filedownloader.FileDownloader.getImpl().addServiceConnectListener(fileDownloadConnectListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.aliyun.svideo.downloader.FileDownloaderModel addTask(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, java.lang.String str) {
        java.lang.String path = fileDownloaderModel.getPath();
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(path)) {
            int effectType = fileDownloaderModel.getEffectType();
            java.lang.String str2 = effectType != 1 ? effectType != 2 ? effectType != 3 ? effectType != 6 ? effectType != 9 ? effectType != 10 ? "" : com.aliyun.svideo.downloader.FileDownloaderModel.TRANSITION_DIR : com.aliyun.svideo.downloader.FileDownloaderModel.ANIMATION_EFFECTS_DIR : com.aliyun.svideo.downloader.FileDownloaderModel.CAPTION_DIR : com.aliyun.svideo.downloader.FileDownloaderModel.MV_DIR : com.aliyun.svideo.downloader.FileDownloaderModel.STICKER_DIR : com.aliyun.svideo.downloader.FileDownloaderModel.FONT_DIR;
            int effectType2 = fileDownloaderModel.getEffectType();
            if (effectType2 != 1) {
                if (effectType2 != 2) {
                    if (effectType2 == 3) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(str2);
                        java.lang.String str3 = java.io.File.separator;
                        sb.append(str3);
                        sb.append(fileDownloaderModel.getId());
                        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(fileDownloaderModel.getName());
                        sb.append(str3);
                        sb.append(fileDownloaderModel.getAspect());
                        str2 = sb.toString();
                    } else if (effectType2 != 6) {
                        if (effectType2 != 9 && effectType2 != 10) {
                            path = createPath(str);
                        }
                    }
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
                        path = com.liulishuo.filedownloader.util.FileDownloadUtils.generateFilePath(com.liulishuo.filedownloader.util.FileDownloadUtils.getDefaultSaveRootPath(), str2);
                    }
                    fileDownloaderModel.setPath(path);
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(str2);
                java.lang.String str4 = java.io.File.separator;
                sb2.append(str4);
                sb2.append(fileDownloaderModel.getId());
                sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(fileDownloaderModel.getName());
                sb2.append(str4);
                sb2.append(fileDownloaderModel.getSubid());
                sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(fileDownloaderModel.getSubname());
                str2 = sb2.toString();
                if (!com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
                }
                fileDownloaderModel.setPath(path);
            }
            str2 = str2 + java.io.File.separator + fileDownloaderModel.getId() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + fileDownloaderModel.getName();
            if (!com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
            }
            fileDownloaderModel.setPath(path);
        }
        int generateId = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, path);
        fileDownloaderModel.setTaskId(generateId);
        this.mAllTasks.put(generateId, fileDownloaderModel);
        return fileDownloaderModel;
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel addTask(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setUrl(str);
        fileDownloaderModel.setPath(str2);
        return addTask(fileDownloaderModel, str);
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel addTaskAndStart(java.lang.String str) {
        com.aliyun.svideo.downloader.FileDownloaderModel addTask = addTask(str);
        startTask(addTask.getTaskId());
        return addTask;
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel addTaskAndStart(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideo.downloader.FileDownloaderModel addTask = addTask(str, str2);
        startTask(addTask.getTaskId());
        return addTask;
    }

    public int createTask(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.aliyun.svideo.downloader.BridgeListener bridgeListener) {
        return com.liulishuo.filedownloader.FileDownloader.getImpl().create(fileDownloaderModel.getUrl()).setPath(fileDownloaderModel.getPath()).setCallbackProgressTimes(100).setAutoRetryTimes(this.mAutoRetryTimes).setListener(bridgeListener).asInQueueTask().enqueue();
    }

    public com.liulishuo.filedownloader.BaseDownloadTask createTask(int i, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById = getFileDownloaderModelById(i);
        com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask = null;
        if (fileDownloaderModelById != null) {
            com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerManager.getBridgeListener(i);
            bridgeListener.addDownloadListener(fileDownloaderCallback);
            if (this.mDownloadingList.size() >= this.mConfiguration.getMaxDownloadingCount()) {
                if (!this.mWaitQueue.contains(fileDownloaderModelById)) {
                    this.mWaitQueue.offer(fileDownloaderModelById);
                }
                bridgeListener.wait(i);
            } else {
                this.mDownloadingList.add(fileDownloaderModelById);
                baseDownloadTask = com.liulishuo.filedownloader.FileDownloader.getImpl().create(fileDownloaderModelById.getUrl()).setPath(fileDownloaderModelById.getPath()).setCallbackProgressTimes(100).setCallbackProgressMinInterval(100).setAutoRetryTimes(this.mAutoRetryTimes).setListener(bridgeListener);
                for (int i2 = 0; i2 < this.mHeaders.size(); i2++) {
                    baseDownloadTask.addHeader(this.mHeaders.name(i2), this.mHeaders.value(i2));
                }
                bridgeListener.setDownloadTask(baseDownloadTask);
            }
        }
        return baseDownloadTask;
    }

    public void deleteTask(int i) {
        mDbController.deleteTaskById(i, false);
    }

    public void deleteTaskByTaskId(int i) {
        if (mDbController.deleteTask(i)) {
            pauseTask(i);
            removeDownloadingTask(i);
            removeWaitQueueTask(i);
            try {
                this.mAllTasks.remove(i);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public boolean exists(java.lang.String str) {
        return getFileDownloaderModelByUrl(str) != null;
    }

    public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getAllTask() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.mAllTasks.size(); i++) {
            arrayList.add(this.mAllTasks.valueAt(i));
        }
        return arrayList;
    }

    public com.aliyun.svideo.downloader.FileDownloaderDBController getDbController() {
        android.content.Context context;
        if (mDbController == null && (context = mContext) != null) {
            initDownloaderConfiger(context);
        }
        return mDbController;
    }

    public java.util.Map<java.lang.String, java.lang.String> getDbExtFieldMap() {
        return this.mExtFieldMap;
    }

    public com.liulishuo.filedownloader.BaseDownloadTask getDownloadTaskById(int i) {
        return this.mListenerManager.getBridgeListener(i).getDownloadTask();
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel getFileDownloaderModelById(int i) {
        android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> sparseArray = this.mAllTasks;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        return this.mAllTasks.get(i);
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel getFileDownloaderModelByPostion(int i) {
        return getFileDownloaderModelById(this.mAllTasks.keyAt(i));
    }

    public com.aliyun.svideo.downloader.FileDownloaderModel getFileDownloaderModelByUrl(java.lang.String str) {
        for (int i = 0; i < this.mAllTasks.size(); i++) {
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelByPostion = getFileDownloaderModelByPostion(i);
            if (fileDownloaderModelByPostion != null && android.text.TextUtils.equals(fileDownloaderModelByPostion.getUrl(), str)) {
                return fileDownloaderModelByPostion;
            }
        }
        return null;
    }

    public com.aliyun.svideo.downloader.FileDownloaderCallback getGlobalDownloadCallback() {
        return this.mGlobalDownloadCallback;
    }

    public int getProgress(int i) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById = getFileDownloaderModelById(i);
        if (fileDownloaderModelById != null && !new java.io.File(fileDownloaderModelById.getPath()).exists()) {
            return 0;
        }
        long total = getTotal(i);
        long soFar = getSoFar(i);
        if (total != 0) {
            return (int) ((soFar / total) * 100.0f);
        }
        return 0;
    }

    public long getSoFar(int i) {
        return com.liulishuo.filedownloader.FileDownloader.getImpl().getSoFar(i);
    }

    public long getSpeed(int i) {
        return this.mListenerManager.getBridgeListener(i).getSpeed();
    }

    public int getStatus(int i, java.lang.String str) {
        return com.liulishuo.filedownloader.FileDownloader.getImpl().getStatus(i, str);
    }

    public int getTaskCounts() {
        android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> sparseArray = this.mAllTasks;
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.size();
    }

    public long getTotal(int i) {
        return com.liulishuo.filedownloader.FileDownloader.getImpl().getTotal(i);
    }

    public synchronized void init(android.content.Context context) {
        mContext = context;
        com.liulishuo.filedownloader.FileDownloader.init(context, new com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker().connectionCreator(new com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Creator(new com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration().connectTimeout(15000).readTimeout(15000).proxy(java.net.Proxy.NO_PROXY))));
    }

    public synchronized void init(com.aliyun.svideo.downloader.DownloaderManagerConfiguration downloaderManagerConfiguration) {
        if (!com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            com.liulishuo.filedownloader.FileDownloader.getImpl().bindService();
        }
        com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG = true;
        this.mConfiguration = downloaderManagerConfiguration;
        this.mExtFieldMap = downloaderManagerConfiguration.getDbExtField();
        mDbController = new com.aliyun.svideo.downloader.FileDownloaderDBController(downloaderManagerConfiguration.getContext(), downloaderManagerConfiguration.getDbVersion(), this.mExtFieldMap, downloaderManagerConfiguration.getDbUpgradeListener(), downloaderManagerConfiguration.iCipher(), downloaderManagerConfiguration.getCk());
        this.mConnectListenerList = new java.util.ArrayList();
        this.mListenerManager = new com.aliyun.svideo.downloader.ListenerManager();
        this.mAutoRetryTimes = downloaderManagerConfiguration.getAutoRetryTimes();
        this.mHeaders = downloaderManagerConfiguration.getHeaders();
        if (!com.aliyun.common.utils.StringUtils.isEmpty(downloaderManagerConfiguration.getDownloadStorePath())) {
            com.liulishuo.filedownloader.util.FileDownloadUtils.setDefaultSaveRootPath(downloaderManagerConfiguration.getDownloadStorePath());
        }
        this.mWaitQueue = new java.util.LinkedList();
        this.mDownloadingList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        mDownloadManager = this;
    }

    public boolean isDownloading(int i, java.lang.String str) {
        int status = getStatus(i, str);
        return status == 1 || status == 2 || status == 3;
    }

    public boolean isFinish(int i, java.lang.String str) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById = getFileDownloaderModelById(i);
        return fileDownloaderModelById != null && getStatus(i, str) == -3 && new java.io.File(fileDownloaderModelById.getPath()).exists();
    }

    public boolean isReady() {
        return com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected();
    }

    public boolean isWaiting(int i) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setTaskId(i);
        return this.mWaitQueue.contains(fileDownloaderModel);
    }

    public synchronized com.aliyun.svideo.downloader.FileDownloaderModel nextTask() {
        return this.mWaitQueue.poll();
    }

    public void onDestroy() {
        try {
            this.mConnectListenerList.clear();
            pauseAllTask();
            com.liulishuo.filedownloader.FileDownloader.getImpl().unBindServiceIfIdle();
        } catch (java.lang.Exception unused) {
        }
    }

    public void pauseAllTask() {
        com.liulishuo.filedownloader.FileDownloader.getImpl().pauseAll();
    }

    public synchronized void pauseTask(int i) {
        if (isWaiting(i)) {
            com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerManager.getBridgeListener(i);
            removeWaitQueueTask(i);
            bridgeListener.stop(i, getSoFar(i), getTotal(i));
        } else {
            com.liulishuo.filedownloader.FileDownloader.getImpl().pause(i);
        }
    }

    public synchronized void removeDownloadingTask(int i) {
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = this.mDownloadingList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next != null && next.getTaskId() == i) {
                try {
                    it.remove();
                } catch (java.lang.Exception unused) {
                }
                return;
            }
        }
    }

    public void removeServiceConnectListener(com.liulishuo.filedownloader.FileDownloadConnectListener fileDownloadConnectListener) {
        com.liulishuo.filedownloader.FileDownloader.getImpl().removeServiceConnectListener(fileDownloadConnectListener);
    }

    public synchronized void removeWaitQueueTask(int i) {
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = this.mWaitQueue.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next != null && next.getTaskId() == i) {
                try {
                    it.remove();
                } catch (java.lang.Exception unused) {
                }
                return;
            }
        }
    }

    public void setGlobalDownloadCallback(com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        this.mGlobalDownloadCallback = fileDownloaderCallback;
    }

    public void startTask(int i) {
        startTask(i, (com.aliyun.svideo.downloader.FileDownloaderCallback) null);
    }

    public void startTask(int i, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById = getFileDownloaderModelById(i);
        if (fileDownloaderModelById != null) {
            com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerManager.getBridgeListener(i);
            bridgeListener.addDownloadListener(fileDownloaderCallback);
            if (this.mDownloadingList.size() >= this.mConfiguration.getMaxDownloadingCount()) {
                if (!this.mWaitQueue.contains(fileDownloaderModelById)) {
                    this.mWaitQueue.offer(fileDownloaderModelById);
                }
                bridgeListener.wait(i);
                return;
            }
            this.mDownloadingList.add(fileDownloaderModelById);
            com.liulishuo.filedownloader.BaseDownloadTask listener = com.liulishuo.filedownloader.FileDownloader.getImpl().create(fileDownloaderModelById.getUrl()).setPath(fileDownloaderModelById.getPath()).setCallbackProgressTimes(100).setAutoRetryTimes(this.mAutoRetryTimes).setListener(bridgeListener);
            for (int i2 = 0; i2 < this.mHeaders.size(); i2++) {
                listener.addHeader(this.mHeaders.name(i2), this.mHeaders.value(i2));
            }
            bridgeListener.setDownloadTask(listener);
            listener.start();
        }
    }

    public void startTask(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        com.aliyun.svideo.downloader.BridgeListener bridgeListener = new com.aliyun.svideo.downloader.BridgeListener();
        bridgeListener.addDownloadListener(fileDownloaderCallback);
        for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : list) {
            createTask(addTask(fileDownloaderModel, fileDownloaderModel.getUrl()), bridgeListener);
        }
        com.liulishuo.filedownloader.FileDownloader.getImpl().start(bridgeListener, true);
    }

    public <T extends com.liulishuo.filedownloader.FileDownloadListener> void startTaskExtend(int i, T t) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById = getFileDownloaderModelById(i);
        if (fileDownloaderModelById != null) {
            com.liulishuo.filedownloader.BaseDownloadTask listener = com.liulishuo.filedownloader.FileDownloader.getImpl().create(fileDownloaderModelById.getUrl()).setPath(fileDownloaderModelById.getPath()).setCallbackProgressTimes(100).setAutoRetryTimes(this.mAutoRetryTimes).setListener(t);
            for (int i2 = 0; i2 < this.mHeaders.size(); i2++) {
                listener.addHeader(this.mHeaders.name(i2), this.mHeaders.value(i2));
            }
        }
    }
}
