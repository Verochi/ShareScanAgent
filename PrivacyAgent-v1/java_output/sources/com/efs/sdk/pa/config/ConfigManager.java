package com.efs.sdk.pa.config;

/* loaded from: classes22.dex */
public class ConfigManager {
    private static final int A_DAY = 86400000;
    public static final java.lang.String FLAG_PA_CHECK_IN_STATE = "8f2f54c08600aa25915617fa1371441b";
    public static final java.lang.String FLAG_PA_FORE_CHECK_TIME = "03f870871950c148387b251894ed3e88";
    private static final int MAX_ANR_STATS_COUNT = 50;
    private static final int MAX_ANR_TRACE_RATE = 100;
    private static final java.lang.String MODEL_SP = "paconfig";
    public static final java.lang.String PA_LEVEL = "pa_level";
    private static final java.lang.String STATS_ANR_LOG_COUNT = "apm_anr_count";
    private boolean mCheckIn;
    private int mCurrentRate;
    private com.efs.sdk.pa.config.IEfsReporter mEfsReporter;
    private int mLastRate;
    private com.efs.sdk.pa.config.PackageLevel mPackageLevel;
    private android.content.SharedPreferences mSharedPreferences;
    private final java.lang.String TAG = "WpkPaConfig";
    private final java.lang.String APM_PATRACE_SWITCH_RATE_LAST = "apm_patrace_switch_rate_last";
    private final java.lang.String APM_PATRACE_SWITCH_RATE_CURRENT = "apm_patrace_switch_rate";
    private final int DEF_CLOSE_RATE = 0;

    /* renamed from: com.efs.sdk.pa.config.ConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            java.lang.Object obj = map.get("apm_patrace_switch_rate");
            if (obj != null) {
                try {
                    com.efs.sdk.pa.config.ConfigManager.this.putIntValue("apm_patrace_switch_rate", java.lang.Integer.parseInt(obj.toString()));
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public ConfigManager(android.content.Context context, com.efs.sdk.pa.config.PackageLevel packageLevel, com.efs.sdk.pa.config.IEfsReporter iEfsReporter, boolean z) {
        boolean z2 = false;
        this.mCheckIn = false;
        this.mPackageLevel = packageLevel;
        this.mEfsReporter = iEfsReporter;
        this.mSharedPreferences = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.getSharedPreferences(context, MODEL_SP);
        initRate();
        if (z) {
            resetUploadSmoothLogCnt();
            z2 = enableAnrTracer();
        } else if (isCountEnable() && enableAnrTracer()) {
            z2 = true;
        }
        this.mCheckIn = z2;
        resetRate();
    }

    private boolean checkIn(boolean z, java.lang.Long l, boolean z2, int i) {
        java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        java.lang.Long valueOf2 = java.lang.Long.valueOf(valueOf.longValue() - l.longValue());
        if (z2 && valueOf2.longValue() < 86400000 && !z) {
            return true;
        }
        if (valueOf2.longValue() < 86400000 && !z) {
            return false;
        }
        boolean random = random(i);
        putBooleanValue(FLAG_PA_CHECK_IN_STATE, random);
        putLongValue(FLAG_PA_FORE_CHECK_TIME, valueOf.longValue());
        return random;
    }

    private boolean enableAnrTracer() {
        long j = this.mSharedPreferences.getLong(FLAG_PA_FORE_CHECK_TIME, 0L);
        boolean z = this.mSharedPreferences.getBoolean(FLAG_PA_CHECK_IN_STATE, false);
        if (this.mCurrentRate != 0) {
            if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                return true;
            }
            return checkIn(this.mCurrentRate != this.mLastRate, java.lang.Long.valueOf(j), z, this.mCurrentRate);
        }
        if (z) {
            putBooleanValue(FLAG_PA_CHECK_IN_STATE, false);
        }
        if (j != 0) {
            putLongValue(FLAG_PA_FORE_CHECK_TIME, 0L);
        }
        return false;
    }

    private int getCurrentConfigRate() {
        int i = this.mSharedPreferences.getInt("apm_patrace_switch_rate", -1);
        this.mEfsReporter.getReporter().getAllSdkConfig(new java.lang.String[]{"apm_patrace_switch_rate"}, new com.efs.sdk.pa.config.ConfigManager.AnonymousClass1());
        return i;
    }

    private void initRate() {
        this.mLastRate = this.mSharedPreferences.getInt("apm_patrace_switch_rate_last", 0);
        int currentConfigRate = getCurrentConfigRate();
        if (currentConfigRate != -1) {
            this.mCurrentRate = currentConfigRate;
        } else if (this.mPackageLevel == com.efs.sdk.pa.config.PackageLevel.TRIAL) {
            this.mCurrentRate = 100;
        } else {
            this.mCurrentRate = 0;
        }
    }

    private boolean isCountEnable() {
        return this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) <= 50;
    }

    private void putBooleanValue(java.lang.String str, boolean z) {
        android.content.SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putIntValue(java.lang.String str, int i) {
        android.content.SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    private void putLongValue(java.lang.String str, long j) {
        android.content.SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    private boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new java.util.Random().nextInt(100) <= i;
    }

    private void resetRate() {
        putIntValue("apm_patrace_switch_rate_last", this.mCurrentRate);
    }

    private void resetUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, 0L);
    }

    public boolean enableTracer() {
        return this.mCheckIn;
    }

    public void increaseUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) + 1);
    }
}
