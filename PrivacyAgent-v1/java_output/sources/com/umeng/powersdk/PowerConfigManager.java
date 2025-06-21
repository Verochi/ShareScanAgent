package com.umeng.powersdk;

/* loaded from: classes19.dex */
public class PowerConfigManager {
    private android.content.Context b;
    private com.efs.sdk.base.EfsReporter c;
    private int d;
    private int f;
    private boolean g;
    private final java.lang.String a = "PageConfigManager";
    private final int e = 0;

    /* renamed from: com.umeng.powersdk.PowerConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            android.content.SharedPreferences.Editor edit;
            try {
                android.content.SharedPreferences sharedPreferences = com.umeng.powersdk.PowerConfigManager.this.b.getSharedPreferences("efs_power", 0);
                if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || map == null) {
                    return;
                }
                java.lang.Object obj = map.get("apm_powerperf_sampling_rate");
                if (obj != null) {
                    edit.putInt("apm_powerperf_sampling_rate", java.lang.Integer.parseInt(obj.toString()));
                }
                java.lang.Object obj2 = map.get("apm_powerperf_collect_interval");
                if (obj2 != null) {
                    edit.putInt("apm_powerperf_collect_interval", java.lang.Integer.parseInt(obj2.toString()));
                }
                java.lang.Object obj3 = map.get("apm_powerperf_collect_max_period_sec");
                if (obj3 != null) {
                    edit.putInt("apm_powerperf_collect_max_period_sec", java.lang.Integer.parseInt(obj3.toString()));
                }
                edit.apply();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public PowerConfigManager(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences.Editor edit2;
        android.content.SharedPreferences.Editor edit3;
        android.content.SharedPreferences.Editor edit4;
        android.content.SharedPreferences.Editor edit5;
        this.d = 100;
        this.g = false;
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = efsReporter;
        android.content.SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("efs_power", 0);
        if (sharedPreferences != null) {
            this.f = sharedPreferences.getInt("apm_powerperf_sampling_rate_last", 0);
        }
        android.content.SharedPreferences sharedPreferences2 = this.b.getSharedPreferences("efs_power", 0);
        int i = sharedPreferences2 != null ? sharedPreferences2.getInt("apm_powerperf_sampling_rate", -1) : -1;
        this.c.getAllSdkConfig(new java.lang.String[]{"apm_powerperf_sampling_rate", "apm_powerperf_collect_interval", "apm_powerperf_collect_max_period_sec"}, new com.umeng.powersdk.PowerConfigManager.AnonymousClass1());
        if (i != -1) {
            this.d = i;
        }
        boolean z = true;
        if (!com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
            android.content.SharedPreferences sharedPreferences3 = this.b.getSharedPreferences("efs_power", 0);
            long j = sharedPreferences3 != null ? sharedPreferences3.getLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
            boolean z2 = sharedPreferences3 != null ? sharedPreferences3.getBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i2 = this.d;
            if (i2 == 0) {
                if (z2 && sharedPreferences3 != null && (edit5 = sharedPreferences3.edit()) != null) {
                    edit5.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    edit5.commit();
                }
                if (j != 0 && sharedPreferences3 != null && (edit4 = sharedPreferences3.edit()) != null) {
                    edit4.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                    edit4.commit();
                }
            } else {
                boolean z3 = i2 != this.f;
                java.lang.Long valueOf = java.lang.Long.valueOf(j);
                int i3 = this.d;
                java.lang.Long valueOf2 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                java.lang.Long valueOf3 = java.lang.Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z2 && valueOf3.longValue() < 86400000 && !z3) {
                    java.lang.String str = com.umeng.powersdk.PowerManager.TAG;
                } else if (valueOf3.longValue() >= 86400000 || z3) {
                    if (i3 != 0 && (i3 == 100 || new java.util.Random().nextInt(100) <= i3)) {
                        java.lang.String str2 = com.umeng.powersdk.PowerManager.TAG;
                    } else {
                        java.lang.String str3 = com.umeng.powersdk.PowerManager.TAG;
                        z = false;
                    }
                    android.content.SharedPreferences sharedPreferences4 = this.b.getSharedPreferences("efs_power", 0);
                    if (sharedPreferences4 != null && (edit3 = sharedPreferences4.edit()) != null) {
                        edit3.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, z);
                        edit3.apply();
                    }
                    if (sharedPreferences4 != null && (edit2 = sharedPreferences4.edit()) != null) {
                        edit2.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                        edit2.apply();
                    }
                } else {
                    java.lang.String str4 = com.umeng.powersdk.PowerManager.TAG;
                }
            }
            z = false;
        }
        this.g = z;
        android.content.SharedPreferences sharedPreferences5 = this.b.getSharedPreferences("efs_power", 0);
        if (sharedPreferences5 == null || (edit = sharedPreferences5.edit()) == null) {
            return;
        }
        edit.putInt("apm_powerperf_sampling_rate_last", this.d);
        edit.apply();
    }

    public boolean enableTracer() {
        return this.g;
    }
}
