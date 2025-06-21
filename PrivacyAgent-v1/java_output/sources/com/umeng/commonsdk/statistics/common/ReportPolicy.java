package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    static final int BATCH_AT_TERMINATE = 2;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int DAILY = 4;
    static final int IMMEDIATE = 3;
    public static final int QUASI_REALTIME_POLICY = 11;
    public static final int REALTIME = 0;
    public static final int SMART_POLICY = 8;
    public static final int WIFIONLY = 5;

    public static class DebugPolicy extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private final long ReportInterval = 15000;
        private com.umeng.commonsdk.statistics.internal.StatTracer mTracer;

        public DebugPolicy(com.umeng.commonsdk.statistics.internal.StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastSuccessfulBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= 15000;
        }
    }

    public static class DefconPolicy extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private com.umeng.commonsdk.statistics.noise.Defcon defcon;
        private com.umeng.commonsdk.statistics.internal.StatTracer tracer;

        public DefconPolicy(com.umeng.commonsdk.statistics.internal.StatTracer statTracer, com.umeng.commonsdk.statistics.noise.Defcon defcon) {
            this.tracer = statTracer;
            this.defcon = defcon;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return this.defcon.isOpen();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastSuccessfulBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval();
        }

        public boolean shouldSendMessageByInstant() {
            return java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastInstantBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval();
        }
    }

    public static class LatentPolicy extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private long latency;
        private long start;

        public LatentPolicy(int i) {
            this.start = 0L;
            this.latency = i;
            this.start = java.lang.System.currentTimeMillis();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return java.lang.System.currentTimeMillis() - this.start < this.latency;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return java.lang.System.currentTimeMillis() - this.start >= this.latency;
        }
    }

    public static class ReportAtLaunch extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return z;
        }
    }

    public static class ReportByInterval extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private static long MAX_REPORT_INTERVAL = 86400000;
        private static long MIN_REPORT_INTERVAL = 90000;
        private long mReportInterval;
        private com.umeng.commonsdk.statistics.internal.StatTracer mTracer;

        public ReportByInterval(com.umeng.commonsdk.statistics.internal.StatTracer statTracer, long j) {
            this.mTracer = statTracer;
            setReportInterval(j);
        }

        public static boolean isValidValue(int i) {
            return ((long) i) >= MIN_REPORT_INTERVAL;
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j) {
            long j2 = MIN_REPORT_INTERVAL;
            if (j < j2 || j > MAX_REPORT_INTERVAL) {
                this.mReportInterval = j2;
            } else {
                this.mReportInterval = j;
            }
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return z || java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastSuccessfulBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= this.mReportInterval;
        }
    }

    public static class ReportDaily extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private long HOURS_DAY = 86400000;
        private com.umeng.commonsdk.statistics.internal.StatTracer mTracer;

        public ReportDaily(com.umeng.commonsdk.statistics.internal.StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastSuccessfulBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= this.HOURS_DAY;
        }
    }

    public static class ReportQuasiRealtime extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private static long DEFAULT_REPORT_INTERVAL = 15000;
        private static long MAX_REPORT_INTERVAL = 90000;
        private static long MIN_REPORT_INTERVAL = 3000;
        private long mReportInterval;

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j) {
            if (j < MIN_REPORT_INTERVAL || j > MAX_REPORT_INTERVAL) {
                this.mReportInterval = DEFAULT_REPORT_INTERVAL;
            } else {
                this.mReportInterval = j;
            }
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    public static class ReportRealtime extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    public static class ReportStrategy {
        public boolean isValid() {
            return true;
        }

        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    public static class ReportWifiOnly extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private android.content.Context mContext;

        public ReportWifiOnly(android.content.Context context) {
            this.mContext = context;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return com.umeng.commonsdk.statistics.common.DeviceConfig.isWiFiAvailable(this.mContext);
        }
    }

    public static class SmartPolicy extends com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy {
        private final long ReportInterval = 10800000;
        private com.umeng.commonsdk.statistics.internal.StatTracer mTracer;

        public SmartPolicy(com.umeng.commonsdk.statistics.internal.StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return java.lang.System.currentTimeMillis() - com.umeng.commonsdk.framework.UMEnvelopeBuild.getLastSuccessfulBuildTime(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext()) >= 10800000;
        }
    }

    public static boolean isValid(int i) {
        if (i != 8 && i != 11) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
