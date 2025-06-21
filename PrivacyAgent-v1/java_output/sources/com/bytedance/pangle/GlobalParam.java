package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class GlobalParam {
    private static com.bytedance.pangle.GlobalParam mInstance;
    private boolean mCheckPermission;
    private boolean mCloseCrashMonitor;
    private boolean mCloseFlipped;
    private boolean mCloseHookHuaweiOnInit;
    private java.lang.String mDid;
    private java.io.File mDownloadDir;
    private com.bytedance.pangle.download.IDownloaderProvider mDownloaderProvider;
    private boolean mFastDex2oat;
    private java.lang.String mHostUrl;
    private com.bytedance.pangle.log.IZeusLogger mLogger;
    private com.bytedance.pangle.log.IZeusReporter mReporter;
    private boolean hasInit = false;
    private boolean mDebug = true;
    private int mInstallThreads = 4;
    private boolean mCheckMatchHostAbi = true;
    private final java.util.Map<java.lang.String, java.lang.String> mRequestHeader = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Boolean> unInstallPluginWhenHostChange = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> mCustomTag = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.String> mSignature = new java.util.HashMap();
    private long mDexOptDelayTime = 15000;
    private boolean mPostBgDexOptByInit = true;
    private boolean mAutoFetch = true;
    private final java.util.Map<java.lang.String, java.lang.Integer> mRemoveApkEntry = new java.util.HashMap();
    private int mApmFlag = -1;
    private boolean mCloseBgDex2oat = false;

    private void ensureInit() {
        if (this.hasInit) {
            throw new java.lang.RuntimeException();
        }
    }

    public static com.bytedance.pangle.GlobalParam getInstance() {
        if (mInstance == null) {
            synchronized (com.bytedance.pangle.GlobalParam.class) {
                if (mInstance == null) {
                    mInstance = new com.bytedance.pangle.GlobalParam();
                }
            }
        }
        return mInstance;
    }

    public void addRequestHeader(java.lang.String str, java.lang.String str2) {
        ensureInit();
        this.mRequestHeader.put(str, str2);
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public void closeBgDex2oat(boolean z) {
        ensureInit();
        this.mCloseBgDex2oat = z;
    }

    public void closeCrashMonitor(boolean z) {
        ensureInit();
        this.mCloseCrashMonitor = z;
    }

    public void closeHookHuaweiOnInit(boolean z) {
        ensureInit();
        this.mCloseHookHuaweiOnInit = z;
    }

    public boolean closeHookHuaweiOnInit() {
        return this.mCloseHookHuaweiOnInit;
    }

    public int getApmFlag() {
        if (this.mApmFlag == -1) {
            this.mApmFlag = 7;
        }
        return this.mApmFlag;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCustomTag(java.lang.String str) {
        return this.mCustomTag.get(str);
    }

    public long getDexOptDelayTime() {
        return this.mDexOptDelayTime;
    }

    public java.lang.String getDid() {
        return this.mDid;
    }

    public java.io.File getDownloadDir() {
        return this.mDownloadDir;
    }

    public com.bytedance.pangle.download.IDownloaderProvider getDownloaderProvider() {
        return this.mDownloaderProvider;
    }

    public java.lang.String getHostUrl() {
        return this.mHostUrl;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public com.bytedance.pangle.log.IZeusLogger getLogger() {
        return this.mLogger;
    }

    public int getRemoveApkEntryFlag(java.lang.String str) {
        java.lang.Integer num = this.mRemoveApkEntry.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public com.bytedance.pangle.log.IZeusReporter getReporter() {
        return this.mReporter;
    }

    public java.util.Map<java.lang.String, java.lang.String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public java.lang.String getSignature(java.lang.String str) {
        return this.mSignature.get(str);
    }

    public void init() {
        this.hasInit = true;
    }

    public boolean isCloseBgDex2oat() {
        return this.mCloseBgDex2oat;
    }

    public boolean isCloseCrashMonitor() {
        return this.mCloseCrashMonitor;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public boolean isPostBgDexOptByInit() {
        return this.mPostBgDexOptByInit;
    }

    public void postBgDexOptByInit(boolean z) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeApkEntry(java.lang.String str, boolean z, boolean z2) {
        ensureInit();
        int i = z;
        if (z2) {
            i = (z ? 1 : 0) | 2;
        }
        this.mRemoveApkEntry.put(str, java.lang.Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void setApmFlag(boolean z, boolean z2, boolean z3, boolean z4) {
        ensureInit();
        ?? r1 = z;
        if (z2) {
            r1 = (z ? 1 : 0) | 2;
        }
        if (z3) {
            r1 = (r1 == true ? 1 : 0) | 4;
        }
        if (z4) {
            r1 = (r1 == true ? 1 : 0) | '\b';
        }
        this.mApmFlag = r1;
    }

    public void setAutoFetch(boolean z) {
        ensureInit();
        this.mAutoFetch = z;
    }

    public void setCheckMatchHostAbi(boolean z) {
        this.mCheckMatchHostAbi = z;
    }

    public void setCheckPermission(boolean z) {
        this.mCheckPermission = z;
    }

    public void setCloseFlipped(boolean z) {
        ensureInit();
        this.mCloseFlipped = z;
    }

    public void setCustomTag(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        this.mCustomTag.put(str, map);
    }

    public void setDebug(boolean z) {
        ensureInit();
        this.mDebug = z;
    }

    public void setDexOptDelayTime(long j) {
        ensureInit();
        this.mDexOptDelayTime = j;
    }

    public void setDid(java.lang.String str) {
        this.mDid = str;
    }

    public void setDownloadDir(java.io.File file) {
        ensureInit();
        this.mDownloadDir = file;
    }

    public void setDownloaderProvider(com.bytedance.pangle.download.IDownloaderProvider iDownloaderProvider) {
        ensureInit();
        this.mDownloaderProvider = iDownloaderProvider;
    }

    public void setFastDex2oat(boolean z) {
        this.mFastDex2oat = z;
    }

    public void setHostUrl(java.lang.String str) {
        ensureInit();
        this.mHostUrl = str;
    }

    public void setInstallThreads(int i) {
        ensureInit();
        this.mInstallThreads = i;
    }

    public void setLogger(com.bytedance.pangle.log.IZeusLogger iZeusLogger) {
        ensureInit();
        this.mLogger = iZeusLogger;
    }

    public void setReporter(com.bytedance.pangle.log.IZeusReporter iZeusReporter) {
        ensureInit();
        this.mReporter = iZeusReporter;
    }

    public void setSignature(java.lang.String str, java.lang.String str2) {
        ensureInit();
        this.mSignature.put(str, str2);
    }

    public void setUnInstallPluginWhenHostChange(java.lang.String str, boolean z) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(str, java.lang.Boolean.valueOf(z));
    }

    public boolean unInstallPluginWhenHostChange(java.lang.String str) {
        java.lang.Boolean bool = this.unInstallPluginWhenHostChange.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
