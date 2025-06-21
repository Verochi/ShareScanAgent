package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public class CacheUserReportManager {
    private static final java.lang.String TAG = "CacheUserReportManager";
    private static volatile com.alimm.tanx.core.ut.core.CacheUserReportManager instance;
    public static volatile int tempFileName;
    private final int FILE_MAX_SIZE = 1000;

    @java.lang.Deprecated
    private final int FILE_MERGE_SIZE = 5;
    private final java.io.File cacheDir = com.alimm.tanx.core.utils.FileUtils.mkdir(com.alimm.tanx.core.utils.FileUtils.getExternalDir(com.alimm.tanx.core.TanxCoreSdk.getApplication(), 0).getPath() + "/ut/");

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$utStr;

        public AnonymousClass1(java.lang.String str) {
            this.val$utStr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ut.core.CacheUserReportManager.this.judgeFileDelete();
            com.alimm.tanx.core.utils.FileUtils.saveStr2File(com.alimm.tanx.core.utils.FileUtil.getAndCreateFile(com.alimm.tanx.core.ut.core.CacheUserReportManager.this.cacheDir.getPath(), com.alimm.tanx.core.ut.core.CacheUserReportManager.this.createFileName()), this.val$utStr);
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<java.io.File> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(java.io.File file, java.io.File file2) {
            return (int) (com.alimm.tanx.core.utils.FileUtil.getFileName(file2) - com.alimm.tanx.core.utils.FileUtil.getFileName(file));
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.CacheUserReportManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.io.File val$file;

        public AnonymousClass3(java.io.File file) {
            this.val$file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.utils.FileUtils.deleteFile(this.val$file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String createFileName() {
        return java.lang.System.currentTimeMillis() + ".txt";
    }

    public static com.alimm.tanx.core.ut.core.CacheUserReportManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ut.core.CacheUserReportManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ut.core.CacheUserReportManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeFileDelete() {
        try {
            java.io.File file = this.cacheDir;
            if (file != null) {
                java.io.File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :judgeFileDelete()listFiles为空，或length为0");
                    return;
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :judgeFileDelete()文件个数->" + listFiles.length);
                if (listFiles.length >= 1000) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(listFiles));
                    java.util.Collections.sort(arrayList, new com.alimm.tanx.core.ut.core.CacheUserReportManager.AnonymousClass2());
                    while (arrayList.size() - 1000 >= 0) {
                        com.alimm.tanx.core.utils.FileUtils.deleteFile((java.io.File) arrayList.get(arrayList.size() - 1));
                        arrayList.remove(arrayList.size() - 1);
                        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :judgeFileDelete(),超过文件阈值开始删除->当前文件个数" + listFiles.length);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.IUserReport.TAG, e);
        }
    }

    public void deleteFile(java.io.File file) {
        com.alimm.tanx.core.ut.core.thread.FileThreadPool.post(new com.alimm.tanx.core.ut.core.CacheUserReportManager.AnonymousClass3(file));
    }

    public java.util.List<java.io.File> readCacheFileList() {
        java.io.File[] listFiles = this.cacheDir.listFiles();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        return (listFiles == null || listFiles.length <= 0) ? arrayList : new java.util.ArrayList(java.util.Arrays.asList(listFiles));
    }

    public void saveFile(com.alimm.tanx.core.ut.bean.UtBean utBean) {
        saveFile(com.alibaba.fastjson.JSON.toJSONString(utBean));
    }

    public void saveFile(java.lang.String str) {
        com.alimm.tanx.core.ut.core.thread.FileThreadPool.post(new com.alimm.tanx.core.ut.core.CacheUserReportManager.AnonymousClass1(str));
    }
}
