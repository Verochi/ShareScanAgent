package com.umeng.analytics.filter;

/* loaded from: classes19.dex */
public class EventList extends com.umeng.analytics.filter.c implements com.umeng.commonsdk.utils.FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private android.content.Context mAppContext;
    protected java.lang.String mEventList;
    protected java.lang.String mEventListKey;
    protected java.lang.String mEventListName;
    protected java.lang.String mEventListVersionKey;
    private com.umeng.commonsdk.utils.FileLockUtil mFileLock = new com.umeng.commonsdk.utils.FileLockUtil();

    public EventList(java.lang.String str, java.lang.String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(java.io.File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private boolean loadEventListFromFile(android.content.Context context, java.io.File file) {
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.lang.String sb;
        if (file.exists() && android.text.TextUtils.isEmpty(this.mEventList)) {
            try {
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
                } catch (java.lang.Throwable th2) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th2);
                }
                try {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    sb = sb2.toString();
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    try {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (java.lang.Throwable th4) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Throwable th5) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th5);
                            }
                        }
                        throw th4;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            if (!android.text.TextUtils.isEmpty(sb)) {
                java.lang.String md5 = com.umeng.commonsdk.statistics.common.HelperUtils.getMD5(sb);
                java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, this.mEventListVersionKey, "");
                this.mEventList = sb;
                eventListChange();
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> loadEventListFromFile: mEventList = " + this.mEventList);
                if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                    if (!md5.equalsIgnoreCase(imprintProperty)) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Throwable th7) {
                            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th7);
                        }
                        return false;
                    }
                    this.mEventList = sb;
                    eventListChange();
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable th8) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th8);
                    }
                    return true;
                }
                if (!md5.equalsIgnoreCase(imprintProperty)) {
                    setMD5ClearFlag(true);
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable th9) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th9);
                    }
                    return false;
                }
                this.mEventList = sb;
                setMD5ClearFlag(false);
                try {
                    bufferedReader.close();
                } catch (java.lang.Throwable th10) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th10);
                }
                return true;
            }
            bufferedReader.close();
        }
        return false;
    }

    private void saveEventListToFile(android.content.Context context, java.io.File file) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            return this.mEventList != null;
        }
    }

    public void eventListChange() {
    }

    public boolean matchHit(java.lang.String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.io.File file, int i) {
        if (i == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i == 1) {
            synchronized (this) {
                if (loadEventListFromFile(this.mAppContext, file)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> find event list data file, load it.");
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> can't find event list file.");
                }
            }
        } else if (i == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.lang.String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
        return false;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
        if (com.umeng.analytics.pro.f.at.equals(str) && str2 == null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new java.io.File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if (com.umeng.analytics.pro.f.au.equals(str) && str2 == null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new java.io.File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return true;
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + str2.length());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("--->>> onPreProcessImprintKey: value = ");
        sb.append(str2);
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, sb.toString());
        this.mEventList = str2;
        eventListChange();
        java.io.File file = new java.io.File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (java.io.IOException e) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.mAppContext, e);
                }
            } catch (java.io.IOException unused) {
                file.createNewFile();
            }
        }
        this.mFileLock.doFileOperateion(file, this, 0);
        setMD5ClearFlag(false);
        return true;
    }

    public void register(android.content.Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
        java.io.File file = new java.io.File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(this.mAppContext)) {
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z) {
    }

    public java.lang.String toString() {
        if (android.text.TextUtils.isEmpty(this.mEventListName) || android.text.TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
        sb.append("EventListName:" + this.mEventListName + ",");
        sb.append("listKey:" + this.mEventListKey + ",");
        if (android.text.TextUtils.isEmpty(this.mEventList)) {
            sb.append("listKeyValue:empty,");
        } else {
            sb.append("listKeyValue:" + this.mEventList + "]");
        }
        if (android.text.TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb.append("listKeyVer:empty]");
        } else {
            sb.append("listKeyVer:" + this.mEventListVersionKey + "]");
        }
        return sb.toString();
    }
}
