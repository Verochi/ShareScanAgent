package com.efs.sdk.base.core.config;

/* loaded from: classes22.dex */
public class GlobalInfoManager {
    private com.efs.sdk.base.core.config.GlobalInfo a;
    private android.content.Context b;

    public static class a {
        private static final com.efs.sdk.base.core.config.GlobalInfoManager a = new com.efs.sdk.base.core.config.GlobalInfoManager((byte) 0);
    }

    private GlobalInfoManager() {
        this.b = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    public /* synthetic */ GlobalInfoManager(byte b) {
        this();
    }

    private static java.lang.String a(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.statistics.common.DeviceConfig> cls;
        java.lang.reflect.Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = com.umeng.commonsdk.statistics.common.DeviceConfig.class;
            java.lang.String str = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", android.content.Context.class);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return null;
        }
    }

    public static com.efs.sdk.base.core.config.GlobalInfoManager getInstance() {
        return com.efs.sdk.base.core.config.GlobalInfoManager.a.a;
    }

    public com.efs.sdk.base.core.config.GlobalInfo getGlobalInfo() {
        try {
            java.lang.String a2 = a(this.b);
            if (!android.text.TextUtils.isEmpty(a2)) {
                this.a.a(com.umeng.umcrash.UMCrash.KEY_CALLBACK_SESSION_ID, a2);
            }
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.d("efs.info.manager", "refreshSessionId caused error: " + th.getMessage());
        }
        return this.a;
    }

    public java.lang.String getNetStatus() {
        return this.a.b(com.alipay.sdk.m.k.b.k, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    public void initGlobalInfo() {
        com.efs.sdk.base.core.util.Log.e("ballack", "initGlobalInfo called once.");
        com.efs.sdk.base.core.config.GlobalInfo globalInfo = new com.efs.sdk.base.core.config.GlobalInfo();
        this.a = globalInfo;
        globalInfo.a("appid", com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        int myPid = com.efs.sdk.base.core.util.ProcessUtil.myPid();
        this.a.a("pid", java.lang.Integer.valueOf(myPid));
        this.a.a(com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE, com.efs.sdk.base.core.util.ProcessUtil.getProcessName(myPid));
        java.lang.String a2 = com.efs.sdk.base.core.util.c.a(this.b);
        this.a.a("wid", a2);
        if (android.text.TextUtils.isEmpty(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getUid())) {
            this.a.a("uid", a2);
        } else {
            this.a.a("uid", com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getUid());
        }
        com.efs.sdk.base.core.config.GlobalInfo globalInfo2 = this.a;
        com.efs.sdk.base.core.a.a.a();
        globalInfo2.a("stime", java.lang.Long.valueOf(com.efs.sdk.base.core.a.a.b() - android.os.Process.getElapsedCpuTime()));
        this.a.a("pkg", com.efs.sdk.base.core.util.PackageUtil.getPackageName(this.b));
        this.a.a("ver", com.efs.sdk.base.core.util.PackageUtil.getAppVersionName(this.b));
        this.a.a("vcode", com.efs.sdk.base.core.util.PackageUtil.getAppVersionCode(this.b));
        this.a.a("sdk_ver", com.efs.sdk.base.BuildConfig.VERSION_NAME);
        this.a.a("brand", android.os.Build.BRAND.toLowerCase());
        com.efs.sdk.base.core.config.GlobalInfo globalInfo3 = this.a;
        java.lang.String str = android.os.Build.MODEL;
        globalInfo3.a("model", str == null ? "unknown" : str.replace(" ", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace("_", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase());
        this.a.a("build_model", str);
        android.util.DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        this.a.a("dsp_w", java.lang.Integer.valueOf(displayMetrics.widthPixels));
        this.a.a("dsp_h", java.lang.Integer.valueOf(displayMetrics.heightPixels));
        this.a.a(com.anythink.expressad.video.dynview.a.a.U, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        this.a.a("rom", android.os.Build.VERSION.RELEASE);
        this.a.a("sdk", java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        this.a.a("lang", java.util.Locale.getDefault().getLanguage());
        this.a.a("tzone", java.util.TimeZone.getDefault().getID());
        this.a.a(com.alipay.sdk.m.k.b.k, com.efs.sdk.base.core.util.NetworkUtil.getNetworkType(this.b));
        try {
            java.lang.String[] networkAccessMode = com.efs.sdk.base.core.util.NetworkUtil.getNetworkAccessMode(this.b);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                this.a.a(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                this.a.a(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, "2G/3G");
            } else {
                this.a.a(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                this.a.a(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
            }
            this.a.a(com.umeng.umcrash.UMCrash.KEY_HEADER_NETWORK_TYPE, java.lang.Integer.valueOf(com.efs.sdk.base.core.util.NetworkUtil.getNetworkTypeUmeng(this.b)));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            this.a.a("log_uid", com.efs.sdk.base.core.util.secure.EncodeUtil.base64DecodeToStr(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogUid().getBytes()));
            this.a.a("log_did", com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogDid());
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void refreshNetStatus() {
        java.lang.String networkType = com.efs.sdk.base.core.util.NetworkUtil.getNetworkType(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext);
        com.efs.sdk.base.core.util.Log.w("efs.info.manager", "network change: ".concat(java.lang.String.valueOf(networkType)));
        this.a.a(com.alipay.sdk.m.k.b.k, networkType);
    }
}
