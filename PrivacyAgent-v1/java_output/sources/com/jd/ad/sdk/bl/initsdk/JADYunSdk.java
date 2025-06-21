package com.jd.ad.sdk.bl.initsdk;

/* loaded from: classes23.dex */
public class JADYunSdk {
    public static final int REQUEST_CODE_MEDIA_DIALOG = 9991;
    private static boolean isEnableLog = false;
    private static boolean isInitSuccess = false;
    private static com.jd.ad.sdk.bl.initsdk.JADInitCallback mInitCallback = null;
    public static com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_er mInnerInitCallBack = null;
    private static boolean mSupportMultiProcess = false;
    private static java.lang.String sAppId = "";
    public static volatile com.jd.ad.sdk.fdt.logger.JADLogAdapter sLogAdapter;
    public static volatile com.jd.ad.sdk.bl.initsdk.JADPrivateController sPrivateController;

    public class jad_an implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_jw.jad_an.jad_an)) {
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                    com.jd.ad.sdk.jad_jw.jad_an.jad_an = jad_anVar.jad_an("refo");
                    java.lang.Object jad_an = jad_anVar.jad_an("refot", (java.lang.Class<java.lang.Object>) java.lang.Long.TYPE);
                    if (java.lang.System.currentTimeMillis() - ((jad_an == null || !(jad_an instanceof java.lang.Long)) ? 0L : ((java.lang.Long) jad_an).longValue()) > 86400000) {
                        com.jd.ad.sdk.jad_jw.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    }
                }
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid error: ");
                jad_an2.append(android.util.Log.getStackTraceString(e));
                com.jd.ad.sdk.logger.Logger.d(jad_an2.toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()));
            }
        }
    }

    public class jad_bo extends com.jd.ad.sdk.fdt.logger.JADLogAdapter {
        @Override // com.jd.ad.sdk.fdt.logger.JADLogAdapter, com.jd.ad.sdk.jad_kt.jad_bo
        public boolean isLoggable(int i, @androidx.annotation.Nullable java.lang.String str) {
            if (com.jd.ad.sdk.bl.initsdk.JADYunSdk.isEnableLog) {
                return super.isLoggable(i, str);
            }
            return false;
        }
    }

    public class jad_cp implements com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_er {
    }

    public class jad_dq implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context jad_an;
        public final /* synthetic */ com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jad_bo;

        public jad_dq(android.content.Context context, com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig) {
            this.jad_an = context;
            this.jad_bo = jADYunSdkConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.bl.initsdk.JADYunSdk.init(this.jad_an, this.jad_bo);
        }
    }

    public interface jad_er {
    }

    public static void asyncInit(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig, com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_dq(context, jADYunSdkConfig));
    }

    private static void crashInit() {
        if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(10, (java.lang.String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_xk.jad_bo jad_boVar = com.jd.ad.sdk.jad_xk.jad_bo.C0415jad_bo.jad_an;
        try {
            java.lang.String str = "jadcrash";
            if (!com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                str = "jadcrash_" + com.jd.ad.sdk.jad_qd.jad_jw.jad_cp(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
            }
            jad_boVar.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(str, 0);
            if (!(java.lang.Thread.getDefaultUncaughtExceptionHandler() instanceof com.jd.ad.sdk.jad_xk.jad_bo) && jad_boVar.jad_bo == null) {
                jad_boVar.jad_bo = java.lang.Thread.getDefaultUncaughtExceptionHandler();
            }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(jad_boVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_xk.jad_an(com.jd.ad.sdk.jad_xk.jad_bo.C0415jad_bo.jad_an));
    }

    public static java.lang.String getAppId() {
        return !android.text.TextUtils.isEmpty(sAppId) ? sAppId : com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("AppId");
    }

    public static com.jd.ad.sdk.bl.initsdk.JADPrivateController getPrivateController() {
        return sPrivateController;
    }

    public static java.lang.String getSDKVersion() {
        return "2.6.20";
    }

    public static void init(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        initJADLog(jADYunSdkConfig);
        android.app.Application application = (android.app.Application) context.getApplicationContext();
        com.jd.ad.sdk.jad_fq.jad_cp.jad_an = application;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new com.jd.ad.sdk.fdt.utils.ActLifecycle());
        }
        sAppId = jADYunSdkConfig.getAppId();
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_re.jad_bo(jADYunSdkConfig));
        mSupportMultiProcess = jADYunSdkConfig.isSupportMultiProcess();
        android.content.Context jad_an2 = context instanceof android.app.Application ? context : com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        initAntiSDK(jad_an2);
        if (jADYunSdkConfig.getPrivateController() != null) {
            sPrivateController = jADYunSdkConfig.getPrivateController();
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            com.jd.ad.sdk.bl.initsdk.JADPrivateController jADPrivateController = sPrivateController;
            jad_fsVar.jad_jw = jADPrivateController;
            java.lang.String oaid = jADPrivateController.getOaid();
            if (!android.text.TextUtils.isEmpty(oaid)) {
                jad_fsVar.jad_an = oaid;
                com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("oidCustom", oaid);
            }
            jad_fsVar.jad_fs = jADPrivateController.isCanUseLocation();
            com.jd.ad.sdk.dl.baseinfo.JADLocation location = jADPrivateController.getLocation();
            if (location != null && location.isValid()) {
                jad_fsVar.jad_dq = location;
            }
            jad_fsVar.jad_jt = jADPrivateController.isCanUseIP();
            java.lang.String ip = jADPrivateController.getIP();
            if (!android.text.TextUtils.isEmpty(ip) && !"0.0.0.0".equals(ip)) {
                jad_fsVar.jad_cp = ip;
            }
            if (jad_an2 != null) {
                jad_fsVar.jad_hu.clear();
                java.util.Iterator<java.lang.String> it = com.jd.ad.sdk.jad_qd.jad_dq.jad_cp.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_hu.add(com.jd.ad.sdk.jad_fq.jad_fs.jad_an(it.next()));
                }
            }
            try {
                jad_fsVar.jad_iv.clear();
                com.jd.ad.sdk.jad_pc.jad_an jad_an3 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                if (jad_an3 != null) {
                    java.lang.String str = jad_an3.jad_qd;
                    if (!android.text.TextUtils.isEmpty(str)) {
                        jad_fsVar.jad_iv.addAll(java.util.Arrays.asList(str.split(",")));
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        crashInit();
        com.jd.ad.sdk.jad_xk.jad_iv jad_ivVar = com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an;
        jad_ivVar.getClass();
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_xk.jad_hu(jad_ivVar, context));
        initInternalInitCallBack();
        java.lang.String appId = jADYunSdkConfig.getAppId();
        android.os.Handler handler = com.jd.ad.sdk.jad_ob.jad_er.jad_an;
        com.jd.ad.sdk.jad_ob.jad_bo.jad_bo = true;
        com.jd.ad.sdk.jad_ob.jad_er.jad_an(appId);
        com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an(new com.jd.ad.sdk.jad_ob.jad_er.jad_bo());
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        java.lang.String jad_dq2 = jad_anVar.jad_dq("isRegisterNetworkReceiver");
        if (android.text.TextUtils.isEmpty(jad_dq2) || !jad_dq2.equals("1")) {
            if (com.jd.ad.sdk.jad_ob.jad_er.jad_bo == null) {
                com.jd.ad.sdk.jad_ob.jad_er.jad_bo = new com.jd.ad.sdk.jad_ob.jad_hu();
            }
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            jad_an2.registerReceiver(com.jd.ad.sdk.jad_ob.jad_er.jad_bo, intentFilter, null, null);
            jad_anVar.jad_bo("isRegisterNetworkReceiver", "1");
        }
        initSOaid();
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_hu.jad_dq(context));
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_dq(com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an, context));
        long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
        int i = com.jd.ad.sdk.jad_vi.jad_an.jad_an;
        if (i < 1) {
            com.jd.ad.sdk.jad_vi.jad_an.jad_an = i + 1;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 6);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "iid", com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "init", 1);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "idu", java.lang.Long.valueOf(currentTimeMillis2));
            jad_ivVar.jad_bo(jSONObject);
        }
        com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.init(context);
    }

    private static void initAntiSDK(android.content.Context context) {
        android.content.Context context2;
        if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(11, (java.lang.String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_il.jad_bo jad_boVar = new com.jd.ad.sdk.jad_il.jad_bo();
        jad_boVar.jad_an = context;
        jad_boVar.jad_bo = false;
        synchronized (com.jd.ad.sdk.jad_il.jad_an.class) {
            if (!com.jd.ad.sdk.jad_il.jad_an.jad_bo && (context2 = jad_boVar.jad_an) != null) {
                boolean z = jad_boVar.jad_bo;
                com.jd.android.sdk.coreinfo.util.Logger.enableLogger(z);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("init AntiSDK :context=");
                sb.append(jad_boVar.jad_an);
                sb.append(", debugFlag=");
                sb.append(z);
                com.jd.ad.sdk.jad_il.jad_an.jad_an = context2;
                com.jd.ad.sdk.jad_il.jad_an.jad_bo = true;
            }
        }
    }

    private static void initInternalInitCallBack() {
        mInnerInitCallBack = new com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_cp();
    }

    private static void initJADLog(com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig) {
        isEnableLog = jADYunSdkConfig.isEnableLog();
        if (sLogAdapter == null) {
            sLogAdapter = new com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_bo();
            com.jd.ad.sdk.logger.Logger.addLogAdapter(sLogAdapter);
        }
    }

    private static void initSOaid() {
        try {
            if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(12, (java.lang.String) null)) {
                return;
            }
            if (com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getOpenReflectOaid() == 1) {
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_an());
            } else {
                com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
            }
        } catch (java.lang.Exception unused) {
            com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
        }
    }

    public static boolean isEnableLog() {
        return isEnableLog;
    }

    public static boolean isInitSuccess() {
        return isInitSuccess;
    }

    public static boolean isSupportMultiProcess() {
        return mSupportMultiProcess;
    }

    public static void syncInit(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig, com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        init(context, jADYunSdkConfig);
    }
}
