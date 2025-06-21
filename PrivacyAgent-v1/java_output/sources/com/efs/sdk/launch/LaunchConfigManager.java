package com.efs.sdk.launch;

/* loaded from: classes22.dex */
public class LaunchConfigManager {
    private final java.lang.String a = "LaunchConfigManager";
    private final int b = 0;
    private com.efs.sdk.base.EfsReporter c;
    private int d;
    private int e;
    private boolean f;
    private android.content.Context g;

    /* renamed from: com.efs.sdk.launch.LaunchConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            android.content.SharedPreferences sharedPreferences;
            android.content.SharedPreferences.Editor edit;
            try {
                java.lang.Object obj = map.get("apm_startperf_sampling_rate");
                if (obj == null || (sharedPreferences = com.efs.sdk.launch.LaunchConfigManager.this.g.getSharedPreferences("efs_launch", 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt("apm_startperf_sampling_rate", java.lang.Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public LaunchConfigManager(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        boolean z;
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences.Editor edit2;
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit3;
        android.content.SharedPreferences.Editor edit4;
        android.content.SharedPreferences.Editor edit5;
        this.d = 100;
        this.f = false;
        android.content.Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.c = efsReporter;
        android.content.SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        android.content.SharedPreferences sharedPreferences3 = this.g.getSharedPreferences("efs_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.c.getAllSdkConfig(new java.lang.String[]{"apm_startperf_sampling_rate"}, new com.efs.sdk.launch.LaunchConfigManager.AnonymousClass1());
        if (i != -1) {
            this.d = i;
        }
        android.content.SharedPreferences sharedPreferences4 = this.g.getSharedPreferences("efs_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z2 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        if (this.d != 0) {
            z = true;
            if (!com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                boolean z3 = this.d != this.e;
                java.lang.Long valueOf = java.lang.Long.valueOf(j);
                int i2 = this.d;
                java.lang.Long valueOf2 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                java.lang.Long valueOf3 = java.lang.Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z2 && valueOf3.longValue() < 86400000 && !z3) {
                    boolean z4 = com.efs.sdk.launch.LaunchManager.isDebug;
                } else if (valueOf3.longValue() >= 86400000 || z3) {
                    if (i2 != 0 && (i2 == 100 || new java.util.Random().nextInt(100) <= i2)) {
                        boolean z5 = com.efs.sdk.launch.LaunchManager.isDebug;
                    } else {
                        boolean z6 = com.efs.sdk.launch.LaunchManager.isDebug;
                        z = false;
                    }
                    android.content.SharedPreferences sharedPreferences5 = this.g.getSharedPreferences("efs_launch", 0);
                    if (sharedPreferences5 != null && (edit2 = sharedPreferences5.edit()) != null) {
                        edit2.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, z);
                        edit2.commit();
                    }
                    if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                        edit.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                        edit.commit();
                    }
                } else {
                    boolean z7 = com.efs.sdk.launch.LaunchManager.isDebug;
                }
            }
            this.f = z;
            sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (edit3 = sharedPreferences.edit()) == null) {
            }
            edit3.putInt("apm_startperf_sampling_rate_last", this.d);
            edit3.commit();
            return;
        }
        if (z2 && sharedPreferences4 != null && (edit5 = sharedPreferences4.edit()) != null) {
            edit5.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            edit5.commit();
        }
        if (j != 0 && sharedPreferences4 != null && (edit4 = sharedPreferences4.edit()) != null) {
            edit4.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            edit4.commit();
        }
        z = false;
        this.f = z;
        sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f;
    }
}
