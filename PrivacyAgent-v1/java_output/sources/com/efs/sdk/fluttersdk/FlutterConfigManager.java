package com.efs.sdk.fluttersdk;

/* loaded from: classes22.dex */
public class FlutterConfigManager {
    private com.efs.sdk.base.EfsReporter c;
    private android.content.Context i;
    private final java.lang.String a = "FlutterConfigManager";
    private final int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = false;
    private boolean j = false;

    /* renamed from: com.efs.sdk.fluttersdk.FlutterConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            try {
                java.lang.Object obj = map.get("flutter_pv_sampling_rate");
                if (obj != null) {
                    com.efs.sdk.fluttersdk.FlutterConfigManager.this.d = java.lang.Integer.parseInt(obj.toString());
                    com.efs.sdk.fluttersdk.FlutterConfigManager flutterConfigManager = com.efs.sdk.fluttersdk.FlutterConfigManager.this;
                    flutterConfigManager.h = com.efs.sdk.fluttersdk.FlutterConfigManager.a(flutterConfigManager.d);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            try {
                java.lang.Object obj2 = map.get("flutter_pv_max_count");
                if (obj2 != null) {
                    com.efs.sdk.fluttersdk.FlutterConfigManager.this.e = java.lang.Integer.parseInt(obj2.toString());
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                java.lang.Object obj3 = map.get("flutter_dart_exception_state");
                if (obj3 != null) {
                    com.efs.sdk.fluttersdk.FlutterConfigManager.this.f = java.lang.Integer.parseInt(obj3.toString());
                }
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
            try {
                java.lang.Object obj4 = map.get("flutter_dart_exception_max_count");
                if (obj4 != null) {
                    com.efs.sdk.fluttersdk.FlutterConfigManager.this.g = java.lang.Integer.parseInt(obj4.toString());
                }
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            com.efs.sdk.fluttersdk.FlutterConfigManager.b(com.efs.sdk.fluttersdk.FlutterConfigManager.this);
        }
    }

    public FlutterConfigManager(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        this.i = context;
        this.c = efsReporter;
        efsReporter.getAllSdkConfig(new java.lang.String[]{"flutter_pv_sampling_rate", "flutter_pv_max_count", "flutter_dart_exception_state", "flutter_dart_exception_max_count"}, new com.efs.sdk.fluttersdk.FlutterConfigManager.AnonymousClass1());
    }

    public static /* synthetic */ boolean a(int i) {
        if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i != 0) {
            return i == 100 || new java.util.Random().nextInt(100) <= i;
        }
        return false;
    }

    public static /* synthetic */ boolean b(com.efs.sdk.fluttersdk.FlutterConfigManager flutterConfigManager) {
        flutterConfigManager.j = true;
        return true;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getCloudConfig() {
        if (!this.j) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("flutter_pv_max_count", java.lang.Integer.valueOf(this.e));
        hashMap.put("flutter_dart_exception_state", java.lang.Integer.valueOf(this.f));
        hashMap.put("flutter_dart_exception_max_count", java.lang.Integer.valueOf(this.g));
        hashMap.put("flutter_pv_sampling_hit", java.lang.Boolean.valueOf(this.h));
        return hashMap;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNativeParams() {
        java.util.HashMap hashMap = null;
        if (!this.j) {
            return null;
        }
        try {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            try {
                android.content.Intent registerReceiver = this.i.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
                hashMap2.put(com.umeng.analytics.pro.bo.Z, java.lang.Integer.valueOf(registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0)));
                hashMap2.put("temperature", java.lang.Integer.valueOf(registerReceiver.getIntExtra("temperature", 0)));
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                hashMap2.put("disk_ratio", java.lang.String.format(java.util.Locale.getDefault(), "%.2f", java.lang.Double.valueOf(((statFs.getAvailableBlocksLong() * r3) / (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) * 100.0d)));
                hashMap2.putAll(com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap());
                hashMap2.putAll(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
                return hashMap2;
            } catch (java.lang.Throwable unused) {
                hashMap = hashMap2;
                return hashMap;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public boolean isFlutterEnable() {
        return this.h;
    }
}
