package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public class OSSLogToFileUtils {
    private static final java.lang.String LOG_DIR_NAME = "OSSLog";
    private static com.alibaba.sdk.android.oss.common.OSSLogToFileUtils instance;
    private static android.content.Context sContext;
    private static java.io.File sLogFile;
    private static android.net.Uri sLogUri;
    private boolean useSdCard = true;
    private static com.alibaba.sdk.android.oss.common.LogThreadPoolManager logService = com.alibaba.sdk.android.oss.common.LogThreadPoolManager.newInstance();
    private static java.text.SimpleDateFormat sLogSDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static long LOG_MAX_SIZE = com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE;

    /* renamed from: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            java.io.File unused = com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile = com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.instance.getLogFile();
            if (com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logInfo("LogFilePath is: " + com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile.getPath(), false);
                if (com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.LOG_MAX_SIZE < com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getLogFileSize(com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile)) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logInfo("init reset log file", false);
                    com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.instance.resetLogFile();
                }
            }
        }
    }

    public static class WriteCall implements java.lang.Runnable {
        private java.lang.Object mStr;

        public WriteCall(java.lang.Object obj) {
            this.mStr = obj;
        }

        private java.io.PrintWriter printEx(java.io.PrintWriter printWriter) {
            printWriter.println("crash_time：" + com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogSDF.format(new java.util.Date()));
            ((java.lang.Throwable) this.mStr).printStackTrace(printWriter);
            return printWriter;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile != null) {
                com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getInstance();
                if (com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getLogFileSize(com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile) > com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.LOG_MAX_SIZE) {
                    com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getInstance().resetLogFile();
                }
                try {
                    java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) new java.io.FileWriter(com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.sLogFile, true), true);
                    if (this.mStr instanceof java.lang.Throwable) {
                        printEx(printWriter);
                    } else {
                        printWriter.println(com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getInstance().getFunctionInfo(null) + " - " + this.mStr.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private OSSLogToFileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getFunctionInfo(java.lang.StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        return "[" + sLogSDF.format(new java.util.Date()) + "]";
    }

    public static com.alibaba.sdk.android.oss.common.OSSLogToFileUtils getInstance() {
        if (instance == null) {
            synchronized (com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.class) {
                if (instance == null) {
                    instance = new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils();
                }
            }
        }
        return instance;
    }

    public static long getLocalLogFileSize() {
        return getLogFileSize(sLogFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File getLogFile() {
        java.io.File file;
        boolean z = false;
        java.io.File file2 = null;
        try {
            boolean z2 = true;
            if (this.useSdCard && android.os.Environment.getExternalStorageState().equals("mounted") && android.os.Build.VERSION.SDK_INT < 29) {
                if (readSDCardSpace() <= LOG_MAX_SIZE / 1024) {
                    z2 = false;
                }
                file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + LOG_DIR_NAME);
            } else {
                if (readSystemSpace() <= LOG_MAX_SIZE / 1024) {
                    z2 = false;
                }
                file = new java.io.File(sContext.getFilesDir().getPath() + java.io.File.separator + LOG_DIR_NAME);
            }
            z = z2;
        } catch (java.lang.Exception unused) {
            file = null;
        }
        if (z) {
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new java.io.File(file.getPath() + "/logs.csv");
            if (!file2.exists()) {
                createNewFile(file2);
            }
        }
        return file2;
    }

    public static long getLogFileSize(java.io.File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return file.length();
    }

    private android.net.Uri getLogUri() {
        android.content.ContentResolver contentResolver = sContext.getContentResolver();
        android.net.Uri queryLogUri = queryLogUri();
        if (queryLogUri == null) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("_display_name", "logs.csv");
            contentValues.put("mime_type", "file/csv");
            contentValues.put("title", "logs.csv");
            contentValues.put("relative_path", "Documents/OSSLog");
            queryLogUri = contentResolver.insert(android.provider.MediaStore.Files.getContentUri("external"), contentValues);
            try {
                contentResolver.openFileDescriptor(queryLogUri, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        return queryLogUri;
    }

    public static void init(android.content.Context context, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        java.io.File file;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("init ...", false);
        if (clientConfiguration != null) {
            LOG_MAX_SIZE = clientConfiguration.getMaxLogSize();
        }
        if (sContext != null && instance != null && (file = sLogFile) != null && file.exists()) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("LogToFileUtils has been init ...", false);
            return;
        }
        sContext = context.getApplicationContext();
        instance = getInstance();
        logService.addExecuteTask(new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.AnonymousClass1());
    }

    private android.net.Uri queryLogUri() {
        android.content.ContentResolver contentResolver = sContext.getContentResolver();
        android.net.Uri contentUri = android.provider.MediaStore.Files.getContentUri("external");
        android.database.Cursor query = contentResolver.query(contentUri, new java.lang.String[]{"_id"}, "relative_path like ? AND _display_name=?", new java.lang.String[]{"Documents/OSSLog%", "logs.csv"}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        android.net.Uri withAppendedId = android.content.ContentUris.withAppendedId(contentUri, query.getLong(0));
        query.close();
        return withAppendedId;
    }

    private long readSDCardSpace() {
        long j = 0;
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            try {
                j = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath()).getAvailableBlocksLong() * r3.getBlockSize();
            } catch (java.lang.Exception unused) {
            }
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("sd卡存储空间:" + java.lang.String.valueOf(j) + "kb", false);
        return j;
    }

    private long readSystemSpace() {
        long j;
        try {
            j = (new android.os.StatFs(android.os.Environment.getDataDirectory().getPath()).getAvailableBlocksLong() * r1.getBlockSize()) / 1024;
        } catch (java.lang.Exception unused) {
            j = 0;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("内部存储空间:" + java.lang.String.valueOf(j) + "kb", false);
        return j;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public void createNewFile(java.io.File file) {
        try {
            file.createNewFile();
        } catch (java.lang.Exception e) {
            com.alibaba.sdk.android.oss.common.OSSLog.logError("Create log file failure !!! " + e.toString(), false);
        }
    }

    public void deleteLogFile() {
        java.io.File file = new java.io.File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("delete Log File ... ", false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        deleteLogFile();
        java.io.File file = new java.io.File(sLogFile.getParent());
        if (file.exists()) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("delete Log FileDir ... ", false);
            file.delete();
        }
    }

    public void resetLogFile() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("Reset Log File ... ", false);
        if (!sLogFile.getParentFile().exists()) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("Reset Log make File dir ... ", false);
            sLogFile.getParentFile().mkdir();
        }
        java.io.File file = new java.io.File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            file.delete();
        }
        createNewFile(file);
    }

    public void setUseSdCard(boolean z) {
        this.useSdCard = z;
    }

    public synchronized void write(java.lang.Object obj) {
        java.io.File file;
        if (com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()) {
            if (sContext != null && instance != null && (file = sLogFile) != null) {
                if (!file.exists()) {
                    resetLogFile();
                }
                logService.addExecuteTask(new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.WriteCall(obj));
            }
        }
    }
}
