package com.efs.sdk.net;

/* loaded from: classes22.dex */
public class NetConfigManager {
    private com.efs.sdk.base.EfsReporter c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean k;
    private android.content.Context l;
    private int m;
    private final java.lang.String a = "NetConfigManager";
    private final int b = 0;
    private int h = 100;
    private int i = 10;
    private int j = 0;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;

    /* renamed from: com.efs.sdk.net.NetConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {

        /* renamed from: com.efs.sdk.net.NetConfigManager$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02861 implements java.lang.Runnable {
            final /* synthetic */ android.content.SharedPreferences.Editor a;
            final /* synthetic */ java.lang.Object b;

            public RunnableC02861(android.content.SharedPreferences.Editor editor, java.lang.Object obj) {
                this.a = editor;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.putInt("apm_netperf_sampling_rate", java.lang.Integer.parseInt(this.b.toString()));
                this.a.commit();
            }
        }

        /* renamed from: com.efs.sdk.net.NetConfigManager$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ android.content.SharedPreferences.Editor a;
            final /* synthetic */ java.lang.Object b;

            public AnonymousClass2(android.content.SharedPreferences.Editor editor, java.lang.Object obj) {
                this.a = editor;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.putInt("apm_netperf_extra", java.lang.Integer.parseInt(this.b.toString()));
                this.a.commit();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            android.content.SharedPreferences sharedPreferences;
            android.content.SharedPreferences.Editor edit;
            android.content.SharedPreferences sharedPreferences2;
            android.content.SharedPreferences.Editor edit2;
            try {
                java.lang.Object obj = map.get("apm_netperf_sampling_rate");
                if (obj != null && (sharedPreferences2 = com.efs.sdk.net.NetConfigManager.this.l.getSharedPreferences("net_launch", 0)) != null && (edit2 = sharedPreferences2.edit()) != null) {
                    new java.lang.Thread(new com.efs.sdk.net.NetConfigManager.AnonymousClass1.RunnableC02861(edit2, obj)).start();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            try {
                java.lang.Object obj2 = map.get("apm_netperf_extra");
                if (obj2 != null && (sharedPreferences = com.efs.sdk.net.NetConfigManager.this.l.getSharedPreferences("net_launch", 0)) != null && (edit = sharedPreferences.edit()) != null) {
                    new java.lang.Thread(new com.efs.sdk.net.NetConfigManager.AnonymousClass1.AnonymousClass2(edit, obj2)).start();
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                com.efs.sdk.net.NetConfigManager.this.h = java.lang.Integer.parseInt(map.get("apm_netperf_day_limit").toString());
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
            try {
                java.lang.Object obj3 = map.get("apm_netperf_data_rate");
                if (obj3 != null) {
                    com.efs.sdk.net.NetConfigManager.this.i = java.lang.Integer.parseInt(obj3.toString());
                }
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            try {
                java.lang.Object obj4 = map.get("apm_netperf_dtet");
                if (obj4 != null) {
                    com.efs.sdk.net.NetConfigManager.this.j = java.lang.Integer.parseInt(obj4.toString());
                }
            } catch (java.lang.Throwable th5) {
                th5.printStackTrace();
            }
            try {
                java.lang.Object obj5 = map.get("apm_netperf_bd_state");
                if (obj5 != null) {
                    com.efs.sdk.net.NetConfigManager.this.n = java.lang.Integer.parseInt(obj5.toString()) == 100;
                }
            } catch (java.lang.Throwable th6) {
                th6.printStackTrace();
            }
            try {
                java.lang.Object obj6 = map.get("apm_netperf_res_bd_state");
                if (obj6 != null) {
                    com.efs.sdk.net.NetConfigManager.this.o = java.lang.Integer.parseInt(obj6.toString()) == 100;
                }
            } catch (java.lang.Throwable th7) {
                th7.printStackTrace();
            }
            try {
                java.lang.Object obj7 = map.get("apm_netperf_req_hd_state");
                if (obj7 != null) {
                    com.efs.sdk.net.NetConfigManager.this.p = java.lang.Integer.parseInt(obj7.toString()) == 100;
                }
            } catch (java.lang.Throwable th8) {
                th8.printStackTrace();
            }
            try {
                java.lang.Object obj8 = map.get("apm_netperf_res_hd_state");
                if (obj8 != null) {
                    com.efs.sdk.net.NetConfigManager.this.q = java.lang.Integer.parseInt(obj8.toString()) == 100;
                }
            } catch (java.lang.Throwable th9) {
                th9.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetConfigManager(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        int i;
        boolean z;
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences.Editor edit2;
        android.content.SharedPreferences.Editor edit3;
        android.content.SharedPreferences.Editor edit4;
        android.content.SharedPreferences sharedPreferences;
        int i2;
        int i3;
        android.content.SharedPreferences.Editor edit5;
        this.d = 0;
        this.e = 0;
        this.k = false;
        this.m = -1;
        android.content.Context applicationContext = context.getApplicationContext();
        this.l = applicationContext;
        this.c = efsReporter;
        android.content.SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            this.f = sharedPreferences2.getInt("apm_netperf_sampling_rate_last", 0);
            this.g = sharedPreferences2.getInt("apm_netperf_extra_last", 0);
        }
        android.content.SharedPreferences sharedPreferences3 = this.l.getSharedPreferences("net_launch", 0);
        if (sharedPreferences3 != null) {
            i = sharedPreferences3.getInt("apm_netperf_sampling_rate", -1);
            this.e = sharedPreferences3.getInt("apm_netperf_extra", -1);
        } else {
            i = -1;
        }
        this.c.getAllSdkConfig(new java.lang.String[]{"apm_netperf_sampling_rate", "apm_netperf_day_limit", "apm_netperf_data_rate", "apm_netperf_dtet", "apm_netperf_extra", "apm_netperf_bd_state", "apm_netperf_res_bd_state", "apm_netperf_req_hd_state", "apm_netperf_res_hd_state"}, new com.efs.sdk.net.NetConfigManager.AnonymousClass1());
        if (i != -1) {
            this.d = i;
        }
        if (!com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
            android.content.SharedPreferences sharedPreferences4 = this.l.getSharedPreferences("net_launch", 0);
            long j = sharedPreferences4 != null ? sharedPreferences4.getLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
            boolean z2 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i4 = this.d;
            if (i4 == 0) {
                if (z2 && sharedPreferences4 != null && (edit4 = sharedPreferences4.edit()) != null) {
                    edit4.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    edit4.commit();
                }
                if (j != 0 && sharedPreferences4 != null && (edit3 = sharedPreferences4.edit()) != null) {
                    edit3.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                    edit3.commit();
                }
            } else {
                boolean z3 = java.lang.Math.max(i4, this.e) != java.lang.Math.max(this.f, this.g);
                java.lang.Long valueOf = java.lang.Long.valueOf(j);
                int max = java.lang.Math.max(this.d, this.e);
                java.lang.Long valueOf2 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                java.lang.Long valueOf3 = java.lang.Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z2 && valueOf3.longValue() < 86400000 && !z3) {
                    com.efs.sdk.base.core.util.Log.d("NetConfigManager", " check in allready");
                } else {
                    if (valueOf3.longValue() >= 86400000 || z3) {
                        if (a(max)) {
                            com.efs.sdk.base.core.util.Log.d("NetConfigManager", "random check in");
                            z = true;
                        } else {
                            com.efs.sdk.base.core.util.Log.d("NetConfigManager", "random not check in!");
                            z = false;
                        }
                        android.content.SharedPreferences sharedPreferences5 = this.l.getSharedPreferences("net_launch", 0);
                        if (sharedPreferences5 != null && (edit2 = sharedPreferences5.edit()) != null) {
                            edit2.putBoolean(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_CHECK_IN_STATE, z);
                            edit2.commit();
                        }
                        if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                            edit.putLong(com.efs.sdk.pa.config.ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                            edit.commit();
                        }
                        this.k = z;
                        sharedPreferences = this.l.getSharedPreferences("net_launch", 0);
                        if (sharedPreferences != null && (edit5 = sharedPreferences.edit()) != null) {
                            edit5.putInt("apm_netperf_sampling_rate_last", this.d);
                            edit5.putInt("apm_netperf_extra_last", this.e);
                            edit5.commit();
                        }
                        i2 = this.d;
                        i3 = this.e;
                        if (i2 >= i3) {
                            this.m = 0;
                            return;
                        }
                        if (i3 == 0) {
                            this.m = 0;
                            return;
                        } else if (a((i2 * 100) / i3)) {
                            this.m = 0;
                            return;
                        } else {
                            this.m = 1;
                            return;
                        }
                    }
                    com.efs.sdk.base.core.util.Log.d("NetConfigManager", "un repeat check in 24 hour!");
                }
            }
            z = false;
            this.k = z;
            sharedPreferences = this.l.getSharedPreferences("net_launch", 0);
            if (sharedPreferences != null) {
                edit5.putInt("apm_netperf_sampling_rate_last", this.d);
                edit5.putInt("apm_netperf_extra_last", this.e);
                edit5.commit();
            }
            i2 = this.d;
            i3 = this.e;
            if (i2 >= i3) {
            }
        }
        z = true;
        this.k = z;
        sharedPreferences = this.l.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
        }
        i2 = this.d;
        i3 = this.e;
        if (i2 >= i3) {
        }
    }

    private static boolean a(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new java.util.Random().nextInt(100) <= i;
    }

    public boolean enableTracer() {
        return this.k;
    }

    public int getDataRate() {
        return this.i;
    }

    public int getDayLimit() {
        return this.h;
    }

    public int getExtraDataRate() {
        return this.j;
    }

    public int getExtraRateFlag() {
        return this.m;
    }

    public boolean getNetRequestBodyCollectState() {
        return this.n;
    }

    public boolean getNetRequestHeaderCollectState() {
        return this.p;
    }

    public boolean getNetResponseBodyCollectState() {
        return this.o;
    }

    public boolean getNetResponseHeaderCollectState() {
        return this.q;
    }

    public boolean isStrategyHitCurrentProcess() {
        return this.r;
    }

    public void setStrategyHitCurrentProcess(boolean z) {
        this.r = z;
    }
}
