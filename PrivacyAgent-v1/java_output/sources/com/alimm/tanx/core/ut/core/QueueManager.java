package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public class QueueManager {
    private static final int CATCH_DELAY_TIME = 10000;
    private static final int QUEUE_SIZE = 1000;
    private static final java.lang.String TAG = "QueueManager";
    private static final int defaultMaxUtCount = 5;
    private static volatile com.alimm.tanx.core.ut.core.QueueManager instance;
    private volatile java.util.concurrent.LinkedBlockingQueue<com.alimm.tanx.core.ut.bean.UtBean> realTimeLinkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue<>(1000);
    private volatile boolean realTimeQueueRunning = false;
    private volatile boolean cacheRunning = false;
    private volatile java.util.concurrent.atomic.AtomicBoolean destroy = new java.util.concurrent.atomic.AtomicBoolean(false);
    private volatile java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.io.File> catchFileConcurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>(1000);
    private volatile com.alimm.tanx.core.ut.bean.UtBean utBeanAssemble = null;

    /* renamed from: com.alimm.tanx.core.ut.core.QueueManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alimm.tanx.core.ut.core.QueueManager.this.realTimeQueueRunning = true;
                while (true) {
                    com.alimm.tanx.core.ut.bean.UtBean utBean = (com.alimm.tanx.core.ut.bean.UtBean) com.alimm.tanx.core.ut.core.QueueManager.this.realTimeLinkedBlockingQueue.take();
                    if (utBean == null) {
                        return;
                    } else {
                        com.alimm.tanx.core.ut.core.QueueManager.this.addOrRemoveUtBeanAssemble(true, utBean);
                    }
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.QueueManager.TAG, e);
                com.alimm.tanx.core.ut.core.QueueManager.this.realTimeQueueRunning = false;
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.QueueManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.QueueManager.TAG, "UserReport :启动runCatchQueue");
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(20);
                com.alimm.tanx.core.ut.bean.UtBean utBean = null;
                int i = 0;
                for (java.util.Map.Entry entry : com.alimm.tanx.core.ut.core.QueueManager.this.catchFileConcurrentHashMap.entrySet()) {
                    i++;
                    com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.QueueManager.TAG, "UserReport :取出catchFileLinkedHashMap元素，启动上报");
                    java.lang.Long l = (java.lang.Long) entry.getKey();
                    java.io.File file = (java.io.File) entry.getValue();
                    concurrentHashMap.put(l, file);
                    if (file.exists()) {
                        com.alimm.tanx.core.ut.bean.UtBean readFile2UtBean = com.alimm.tanx.core.ut.core.QueueManager.this.readFile2UtBean(file);
                        if (readFile2UtBean == null || readFile2UtBean.events.size() <= 0) {
                            com.alimm.tanx.core.ut.core.QueueManager.this.catchFileConcurrentHashMap.remove(l);
                            com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().deleteFile(file);
                        } else {
                            if (utBean != null) {
                                utBean.events.addAll(readFile2UtBean.events);
                            } else {
                                utBean = readFile2UtBean;
                            }
                            if (utBean.events.size() >= com.alimm.tanx.core.ut.core.QueueManager.this.getUploadMaxCount() || i >= com.alimm.tanx.core.ut.core.QueueManager.this.catchFileConcurrentHashMap.size()) {
                                com.alimm.tanx.core.ut.core.QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                                concurrentHashMap.clear();
                                utBean = null;
                            }
                        }
                    } else {
                        com.alimm.tanx.core.ut.core.QueueManager.this.catchFileConcurrentHashMap.remove(l);
                    }
                }
                if (utBean != null) {
                    com.alimm.tanx.core.ut.core.QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                    concurrentHashMap.clear();
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.QueueManager.TAG, e);
            }
            com.alimm.tanx.core.ut.core.QueueManager.this.cacheRunning = false;
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.QueueManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.List<java.io.File> readCacheFileList = com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().readCacheFileList();
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.QueueManager.TAG, "UserReport :添加catchFileLinkedHashMap ->目前文件有：" + readCacheFileList.size());
                for (int i = 0; i < readCacheFileList.size(); i++) {
                    if (readCacheFileList.get(i) != null) {
                        com.alimm.tanx.core.ut.core.QueueManager.this.addCatchList(readCacheFileList.get(i));
                    }
                }
                com.alimm.tanx.core.ut.core.QueueManager.this.runCatchQueue();
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.QueueManager.TAG, e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.QueueManager$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ut.core.QueueManager.this.addOrRemoveUtBeanAssemble(false, null);
        }
    }

    public class RealTimeRunnable implements java.lang.Runnable {
        private final java.lang.String TAG = "RealTimeRunnable";
        private final com.alimm.tanx.core.ut.bean.UtBean itemUtBean;

        public RealTimeRunnable(com.alimm.tanx.core.ut.bean.UtBean utBean) {
            this.itemUtBean = utBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("RealTimeRunnable", "UserReport :添加addRealTimeQueue");
                if (this.itemUtBean != null) {
                    com.alimm.tanx.core.ut.core.QueueManager.this.realTimeLinkedBlockingQueue.put(this.itemUtBean);
                } else {
                    com.alimm.tanx.core.utils.LogUtils.d("RealTimeRunnable", "UserReport :添加addRealTimeQueue失败-->itemUtBean为空");
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("RealTimeRunnable", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addOrRemoveUtBeanAssemble(boolean z, com.alimm.tanx.core.ut.bean.UtBean utBean) {
        java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> list;
        try {
            if (z) {
                if (utBean != null && (list = utBean.events) != null && list.size() > 0) {
                    if (this.utBeanAssemble == null) {
                        this.utBeanAssemble = utBean;
                    } else {
                        this.utBeanAssemble.events.addAll(utBean.events);
                    }
                    if (this.destroy.get()) {
                        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :后台逻辑，取出realTimeLinkedBlockingQueue元素，保存到文件");
                        destroyIng();
                    } else if (this.utBeanAssemble.events.size() >= getUploadMaxCount()) {
                        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :取出realTimeLinkedBlockingQueue元素，启动上报");
                        com.alimm.tanx.core.ut.core.UtRequest.getInstance().requestRealTime(this.utBeanAssemble);
                        this.utBeanAssemble = null;
                    }
                }
                return;
            }
            destroyIng();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    private void destroyIng() {
        if (this.utBeanAssemble != null) {
            com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().saveFile(this.utBeanAssemble);
            this.utBeanAssemble = null;
        }
    }

    public static com.alimm.tanx.core.ut.core.QueueManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ut.core.QueueManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ut.core.QueueManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getUploadMaxCount() {
        int utUploadMaxCount = com.alimm.tanx.core.orange.OrangeManager.getInstance().getUtUploadMaxCount();
        if (utUploadMaxCount == -1) {
            return 5;
        }
        return utUploadMaxCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alimm.tanx.core.ut.bean.UtBean readFile2UtBean(java.io.File file) {
        try {
            return (com.alimm.tanx.core.ut.bean.UtBean) com.alibaba.fastjson.JSON.parseObject(com.alimm.tanx.core.utils.FileUtils.getStrFromFile(file), com.alimm.tanx.core.ut.bean.UtBean.class);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCatchQueue() {
        com.alimm.tanx.core.ut.core.UtRequest.getInstance().atomicLong.set(0L);
        com.alimm.tanx.core.ut.core.thread.UserReportThreadPool.post(new com.alimm.tanx.core.ut.core.QueueManager.AnonymousClass2());
    }

    private void runRealTimeQueue() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :启动runRealTimeQueue--realTimeQueueRunning-->" + this.realTimeQueueRunning);
        if (this.realTimeQueueRunning) {
            return;
        }
        com.alimm.tanx.core.ut.core.thread.UserReportThreadPool.post(new com.alimm.tanx.core.ut.core.QueueManager.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadCatchUt(com.alimm.tanx.core.ut.bean.UtBean utBean, java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.io.File> concurrentHashMap) {
        if (utBean == null) {
            return;
        }
        if (!com.alimm.tanx.core.ut.core.UtRequest.getInstance().requestCache(utBean)) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap失败");
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap成功-> " + utBean.reqId);
        for (java.util.Map.Entry<java.lang.Long, java.io.File> entry : concurrentHashMap.entrySet()) {
            java.lang.Long key = entry.getKey();
            java.io.File value = entry.getValue();
            this.catchFileConcurrentHashMap.remove(key);
            com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().deleteFile(value);
        }
    }

    public void addCatchList(java.io.File file) {
        try {
            if (file != null) {
                this.catchFileConcurrentHashMap.put(java.lang.Long.valueOf(com.alimm.tanx.core.utils.FileUtil.getFileName(file)), file);
            } else {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :添加catchFileLinkedHashMap失败-->itemUtBean为空");
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    public void addRealTimeQueue(com.alimm.tanx.core.ut.bean.UtBean utBean) {
        com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.post(new com.alimm.tanx.core.ut.core.QueueManager.RealTimeRunnable(utBean));
    }

    public void destroy() {
        com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.post(new com.alimm.tanx.core.ut.core.QueueManager.AnonymousClass4());
        this.destroy.set(true);
    }

    public void readCatch2Upload() {
        if (!this.cacheRunning) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :延迟10000毫秒 启动readCatch2Upload,runCatchQueue");
            this.cacheRunning = true;
            com.alimm.tanx.core.ut.core.thread.CacheAddThreadPool.postDelayed(new com.alimm.tanx.core.ut.core.QueueManager.AnonymousClass3(), 10000);
        } else {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :readCatch2Upload已经启动，无需重复启动->cacheRunning->" + this.cacheRunning);
        }
    }

    public void run() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :run()");
        this.destroy.set(false);
        runRealTimeQueue();
        readCatch2Upload();
    }
}
