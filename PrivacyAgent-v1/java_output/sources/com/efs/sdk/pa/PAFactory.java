package com.efs.sdk.pa;

/* loaded from: classes22.dex */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final java.lang.String TAG = "pafactory";
    static final java.lang.ThreadLocal<com.efs.sdk.pa.PA> sThreadLocal = new java.lang.ThreadLocal<>();
    private com.efs.sdk.pa.config.ConfigManager mConfigManager;
    private android.content.Context mContext;
    private java.util.HashMap<java.lang.String, java.lang.String> mExtend;
    private com.efs.sdk.pa.IPaClient mPaClient;
    private com.efs.sdk.base.EfsReporter mReporter;
    private com.efs.sdk.pa.config.IEfsReporter mReporterFactory;
    private java.lang.String mSerial;
    private java.lang.String mSver;
    private long mTimeOutTime;
    private com.efs.sdk.pa.PATraceListener mTraceListener;

    public static class Builder {
        private com.efs.sdk.pa.config.PackageLevel a;
        private com.efs.sdk.pa.config.IEfsReporter b;
        private boolean c;
        private android.content.Context d;
        private java.lang.String e;
        private java.util.HashMap<java.lang.String, java.lang.String> f;
        private java.lang.String g;
        private long h = 2000;
        private com.efs.sdk.pa.PATraceListener i;
        private com.efs.sdk.pa.IPaClient j;

        public Builder(android.content.Context context, com.efs.sdk.pa.config.IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new java.lang.RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new java.lang.RuntimeException("reporter Should Not Empty");
            }
            this.b = iEfsReporter;
            this.d = context;
        }

        public com.efs.sdk.pa.PAFactory build() {
            if (this.a != null) {
                return new com.efs.sdk.pa.PAFactory(this.d, this.a, this.b, this.c, this.e, this.f, this.g, this.h, this.i, this.j, null);
            }
            throw new java.lang.RuntimeException(java.lang.String.format("%s Should Not Null", ""));
        }

        public com.efs.sdk.pa.PAFactory.Builder extendLogInfo(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
            this.f = hashMap;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder isNewInstall(boolean z) {
            this.c = z;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder packageLevel(com.efs.sdk.pa.config.PackageLevel packageLevel) {
            this.a = packageLevel;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder serial(java.lang.String str) {
            this.e = str;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder setPaClient(com.efs.sdk.pa.IPaClient iPaClient) {
            this.j = iPaClient;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder sver(java.lang.String str) {
            this.g = str;
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder timeoutTime(long j) {
            if (j <= 0) {
                this.h = 2000L;
            } else {
                if (j > 4000) {
                    this.h = 2000L;
                    return this;
                }
                this.h = j;
            }
            return this;
        }

        public com.efs.sdk.pa.PAFactory.Builder traceListener(com.efs.sdk.pa.PATraceListener pATraceListener) {
            this.i = pATraceListener;
            return this;
        }
    }

    private PAFactory(android.content.Context context, com.efs.sdk.pa.config.PackageLevel packageLevel, com.efs.sdk.pa.config.IEfsReporter iEfsReporter, boolean z, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.lang.String str2, long j, com.efs.sdk.pa.PATraceListener pATraceListener, com.efs.sdk.pa.IPaClient iPaClient) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = hashMap;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mPaClient = iPaClient;
        this.mTimeOutTime = j;
        this.mConfigManager = new com.efs.sdk.pa.config.ConfigManager(context, packageLevel, iEfsReporter, z);
    }

    public /* synthetic */ PAFactory(android.content.Context context, com.efs.sdk.pa.config.PackageLevel packageLevel, com.efs.sdk.pa.config.IEfsReporter iEfsReporter, boolean z, java.lang.String str, java.util.HashMap hashMap, java.lang.String str2, long j, com.efs.sdk.pa.PATraceListener pATraceListener, com.efs.sdk.pa.IPaClient iPaClient, com.efs.sdk.pa.PAFactory.AnonymousClass1 anonymousClass1) {
        this(context, packageLevel, iEfsReporter, z, str, hashMap, str2, j, pATraceListener, iPaClient);
    }

    public com.efs.sdk.pa.config.ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getExtend() {
        return this.mExtend;
    }

    public com.efs.sdk.pa.IPaClient getPaClient() {
        return this.mPaClient;
    }

    public synchronized com.efs.sdk.pa.PA getPaInstance() {
        com.efs.sdk.pa.PA pa;
        java.lang.ThreadLocal<com.efs.sdk.pa.PA> threadLocal = sThreadLocal;
        pa = threadLocal.get();
        if (pa == null) {
            pa = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
            pa.registerPAANRListener(this.mContext, new com.efs.sdk.pa.a(this), this.mTimeOutTime);
            threadLocal.set(pa);
        }
        return pa;
    }

    public com.efs.sdk.base.EfsReporter getReporter() {
        if (this.mReporter == null) {
            com.efs.sdk.pa.config.IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public java.lang.String getSerial() {
        return this.mSerial;
    }

    public java.lang.String getSver() {
        return this.mSver;
    }

    public com.efs.sdk.pa.PATraceListener getTraceListener() {
        return this.mTraceListener;
    }
}
