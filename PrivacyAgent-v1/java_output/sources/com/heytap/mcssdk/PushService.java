package com.heytap.mcssdk;

/* loaded from: classes22.dex */
public class PushService implements com.heytap.mcssdk.a {
    private static final java.lang.String APP_PACKAGE = "appPackage";
    private static final java.lang.String APP_VERSION_CODE = "versionCode";
    private static final java.lang.String APP_VERSION_NAME = "versionName";
    private static final int DEFAULT_API_MAX_COUNT = 2;
    private static final java.lang.String EVENT_ID = "eventID";
    private static final java.lang.String EXTRA = "extra";
    private static final java.lang.String GLOBAL_ID = "globalID";
    private static final int MAX_HOUR_IN_DAY = 23;
    private static final int MAX_MIN_IN_HOUR = 59;
    private static final int MCS_SUPPORT_VERSION = 1019;
    private static final java.lang.String MESSAGE_ID = "messageID";
    private static final java.lang.String MESSAGE_TYPE = "messageType";
    private static final java.lang.String NEW_MCS_RECEIVE_SDK_ACTION_Base64 = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final java.lang.String PUSH_SDK_VERSION = "pushSdkVersion";
    private static final int SDK_INT_24 = 24;
    private static final java.lang.String SUPPORT_OPEN_PUSH = "supportOpenPush";
    private static final int SYSTEM_UID = 1000;
    private static final java.lang.String TASK_ID = "taskID";
    private static final java.lang.String TYPE = "type";
    private static boolean sIsNewMcsPkg;
    private static java.lang.String sMcsPkgName;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.mcssdk.c.a> mAppLimitMap;
    private java.lang.String mAuthCode;
    private android.content.Context mContext;
    private com.heytap.msp.push.callback.ICallBackResultService mICallBackResultService;
    private com.heytap.msp.push.callback.IGetAppNotificationCallBackService mIGetAppNotificationCallBackService;
    private com.heytap.msp.push.callback.ISetAppNotificationCallBackService mISetAppNotificationCallBackService;
    private java.util.List<com.heytap.mcssdk.d.d> mParsers;
    private java.util.List<com.heytap.mcssdk.e.c> mProcessors;
    private java.lang.String mRegisterID;
    private java.lang.String mVerifyCode;
    private static final int[] OLD_MCS_PACKAGE = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] OLD_MCS_RECEIVE_SDK_ACTION = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static java.lang.String NEW_MCS_RECEIVE_SDK_ACTION = "";
    private static int sCount = 0;

    /* renamed from: com.heytap.mcssdk.PushService$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        final /* synthetic */ android.content.Intent a;

        public AnonymousClass1(android.content.Intent intent) {
            this.a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putAll(this.a.getExtras());
            try {
                com.mcs.aidl.IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
            } catch (java.lang.Exception e) {
                com.heytap.mcssdk.utils.d.b("bindMcsService exception:" + e);
            }
            com.heytap.mcssdk.PushService.this.mContext.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static class a {
        private static final com.heytap.mcssdk.PushService a = new com.heytap.mcssdk.PushService(null);

        private a() {
        }
    }

    private PushService() {
        this.mProcessors = new java.util.ArrayList();
        this.mParsers = new java.util.ArrayList();
        this.mRegisterID = null;
        synchronized (com.heytap.mcssdk.PushService.class) {
            int i = sCount;
            if (i > 0) {
                throw new java.lang.RuntimeException("PushService can't create again!");
            }
            sCount = i + 1;
        }
        addParser(new com.heytap.mcssdk.d.b());
        addParser(new com.heytap.mcssdk.d.a());
        addProcessor(new com.heytap.mcssdk.e.b());
        addProcessor(new com.heytap.mcssdk.e.a());
        this.mAppLimitMap = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public /* synthetic */ PushService(com.heytap.mcssdk.PushService.AnonymousClass1 anonymousClass1) {
        this();
    }

    private com.heytap.mcssdk.c.a addCommandToMap(int i) {
        java.lang.String str;
        if (!this.mAppLimitMap.containsKey(java.lang.Integer.valueOf(i))) {
            com.heytap.mcssdk.c.a aVar = new com.heytap.mcssdk.c.a(java.lang.System.currentTimeMillis(), 1);
            this.mAppLimitMap.put(java.lang.Integer.valueOf(i), aVar);
            com.heytap.mcssdk.utils.d.b("addCommandToMap :appBean is null");
            return aVar;
        }
        com.heytap.mcssdk.c.a aVar2 = this.mAppLimitMap.get(java.lang.Integer.valueOf(i));
        if (checkTimeNeedUpdate(aVar2)) {
            aVar2.a(1);
            aVar2.a(java.lang.System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            aVar2.a(aVar2.b() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        com.heytap.mcssdk.utils.d.b(str);
        return aVar2;
    }

    private synchronized void addParser(com.heytap.mcssdk.d.d dVar) {
        if (dVar != null) {
            this.mParsers.add(dVar);
        }
    }

    private synchronized void addProcessor(com.heytap.mcssdk.e.c cVar) {
        if (cVar != null) {
            this.mProcessors.add(cVar);
        }
    }

    private boolean checkAll() {
        return checkContext() && checkRegisterID();
    }

    private boolean checkContext() {
        return this.mContext != null;
    }

    private boolean checkRegisterID() {
        return this.mRegisterID != null;
    }

    private boolean checkTimeNeedUpdate(com.heytap.mcssdk.c.a aVar) {
        long a2 = aVar.a();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.heytap.mcssdk.utils.d.b("checkTimeNeedUpdate : lastedTime " + a2 + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - a2 > 1000;
    }

    public static com.heytap.mcssdk.PushService getInstance() {
        return com.heytap.mcssdk.PushService.a.a;
    }

    private android.content.Intent getIntent(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(getReceiveSdkAction(this.mContext));
        intent.setPackage(getMcsPackageName(this.mContext));
        intent.putExtra("type", i);
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            android.content.Context context = this.mContext;
            jSONObject2.putOpt("versionName", com.heytap.mcssdk.utils.Utils.getVersionName(context, context.getPackageName()));
            android.content.Context context2 = this.mContext;
            jSONObject2.putOpt("versionCode", java.lang.Integer.valueOf(com.heytap.mcssdk.utils.Utils.getVersionCode(context2, context2.getPackageName())));
            if (jSONObject != null) {
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra(com.heytap.mcssdk.constant.b.z, this.mAuthCode);
        intent.putExtra(com.heytap.mcssdk.constant.b.A, this.mVerifyCode);
        intent.putExtra(com.heytap.mcssdk.constant.b.B, this.mRegisterID);
        intent.putExtra(com.heytap.mcssdk.constant.b.C, getSDKVersionName());
        return intent;
    }

    private java.lang.String getNewMcsPackageName(android.content.Context context) {
        boolean z;
        int packageUid;
        int packageUid2;
        boolean z2;
        if (android.text.TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
            NEW_MCS_RECEIVE_SDK_ACTION = new java.lang.String(com.heytap.mcssdk.a.a.b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
        }
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new android.content.Intent(NEW_MCS_RECEIVE_SDK_ACTION), 8192);
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            java.lang.String str = it.next().serviceInfo.packageName;
            try {
                z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                packageUid = context.getPackageManager().getPackageUid(str, 0);
                packageUid2 = context.getPackageManager().getPackageUid(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, 0);
                z2 = packageUid == packageUid2;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
            if (z || z2) {
                return str;
            }
        }
        return null;
    }

    public static int getSDKVersionCode() {
        return 3000;
    }

    public static java.lang.String getSDKVersionName() {
        return com.pushsdk.a.f;
    }

    private boolean isSupportPushInner(android.content.Context context) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        java.lang.String mcsPackageName = getMcsPackageName(this.mContext);
        return com.heytap.mcssdk.utils.Utils.isExistPackage(this.mContext, mcsPackageName) && com.heytap.mcssdk.utils.Utils.getVersionCode(this.mContext, mcsPackageName) >= 1019 && com.heytap.mcssdk.utils.Utils.isSupportPush(this.mContext, mcsPackageName, SUPPORT_OPEN_PUSH);
    }

    @java.lang.Deprecated
    private static void onAppStart(android.content.Context context) {
        com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, new com.heytap.msp.push.mode.MessageStat(context.getPackageName(), "app_start", null));
    }

    private void startMcsService(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        if (checkCommandLimit(i)) {
            com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService = this.mICallBackResultService;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
                return;
            }
            return;
        }
        try {
            this.mContext.startService(getIntent(i, str, jSONObject));
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e("startMcsService--Exception" + e.getMessage());
        }
    }

    private void startMcsService(int i, org.json.JSONObject jSONObject) {
        startMcsService(i, "", jSONObject);
    }

    public void bindMcsService(int i) {
        if (!checkCommandLimit(i)) {
            android.content.Intent intent = getIntent(i, "", null);
            this.mContext.bindService(intent, new com.heytap.mcssdk.PushService.AnonymousClass1(intent), 1);
        } else {
            com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService = this.mICallBackResultService;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
            }
        }
    }

    public boolean checkCommandLimit(int i) {
        return (i == 12291 || i == 12312 || addCommandToMap(i).b() <= 2) ? false : true;
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType(org.json.JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications(org.json.JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void disableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (getPushCallback() != null) {
            this.mISetAppNotificationCallBackService.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void enableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        } else {
            com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.mISetAppNotificationCallBackService;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    public java.util.Map<java.lang.Integer, com.heytap.mcssdk.c.a> getAppLimitMap() {
        return this.mAppLimitMap;
    }

    @Override // com.heytap.mcssdk.a
    public void getAppNotificationSwitch(com.heytap.msp.push.callback.IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mIGetAppNotificationCallBackService = iGetAppNotificationCallBackService;
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        } else {
            com.heytap.msp.push.callback.IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.mIGetAppNotificationCallBackService;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public int getErrorCode(int i) {
        switch (i) {
            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_REGISTER /* 12289 */:
                return -1;
            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i) {
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i) {
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i) {
                                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public java.lang.String getMcsPackageName(android.content.Context context) {
        boolean z;
        if (sMcsPkgName == null) {
            java.lang.String newMcsPackageName = getNewMcsPackageName(context);
            if (newMcsPackageName == null) {
                sMcsPkgName = com.heytap.mcssdk.utils.Utils.getString(OLD_MCS_PACKAGE);
                z = false;
            } else {
                sMcsPkgName = newMcsPackageName;
                z = true;
            }
            sIsNewMcsPkg = z;
        }
        return sMcsPkgName;
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus(org.json.JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetNotificationStatus(-2, 0);
        }
    }

    public java.util.List<com.heytap.mcssdk.d.d> getParsers() {
        return this.mParsers;
    }

    public java.util.List<com.heytap.mcssdk.e.c> getProcessors() {
        return this.mProcessors;
    }

    public com.heytap.msp.push.callback.ICallBackResultService getPushCallback() {
        return this.mICallBackResultService;
    }

    public com.heytap.msp.push.callback.IGetAppNotificationCallBackService getPushGetAppNotificationCallBack() {
        return this.mIGetAppNotificationCallBackService;
    }

    public com.heytap.msp.push.callback.ISetAppNotificationCallBackService getPushSetAppNotificationCallBack() {
        return this.mISetAppNotificationCallBackService;
    }

    public void getPushStatus() {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetPushStatus(-2, 0);
        }
    }

    public int getPushVersionCode() {
        if (!checkContext()) {
            return 0;
        }
        android.content.Context context = this.mContext;
        return com.heytap.mcssdk.utils.Utils.getVersionCode(context, getMcsPackageName(context));
    }

    public java.lang.String getPushVersionName() {
        if (!checkContext()) {
            return "";
        }
        android.content.Context context = this.mContext;
        return com.heytap.mcssdk.utils.Utils.getVersionName(context, getMcsPackageName(context));
    }

    public java.lang.String getReceiveSdkAction(android.content.Context context) {
        if (sMcsPkgName == null) {
            getNewMcsPackageName(context);
        }
        if (!sIsNewMcsPkg) {
            return com.heytap.mcssdk.utils.Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
        }
        if (android.text.TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
            NEW_MCS_RECEIVE_SDK_ACTION = new java.lang.String(com.heytap.mcssdk.a.a.b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
        }
        return NEW_MCS_RECEIVE_SDK_ACTION;
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister(org.json.JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onRegister(-2, null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public java.lang.String getRegisterID() {
        return this.mRegisterID;
    }

    public com.heytap.mcssdk.PushService init(android.content.Context context, boolean z) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context can't be null");
        }
        innerInit(context);
        new com.heytap.mcssdk.b.a().a(this.mContext);
        com.heytap.mcssdk.utils.d.f(z);
        return this;
    }

    public void innerInit(android.content.Context context) {
        boolean z;
        android.content.Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (sMcsPkgName == null) {
            java.lang.String newMcsPackageName = getNewMcsPackageName(applicationContext);
            if (newMcsPackageName == null) {
                sMcsPkgName = com.heytap.mcssdk.utils.Utils.getString(OLD_MCS_PACKAGE);
                z = false;
            } else {
                sMcsPkgName = newMcsPackageName;
                z = true;
            }
            sIsNewMcsPkg = z;
        }
    }

    public boolean isSupportPushByClient(android.content.Context context) {
        return isSupportPushInner(context);
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings(org.json.JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush(org.json.JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void register(android.content.Context context, java.lang.String str, java.lang.String str2, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.a
    public void register(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        if (!com.heytap.mcssdk.utils.Utils.isSupportPushByClient(this.mContext)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mICallBackResultService = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.DBDefinition.APP_VERSION_CODE, java.lang.Integer.valueOf(com.heytap.mcssdk.utils.Utils.getVersionCode(context)));
            jSONObject.putOpt("appVersionName", com.heytap.mcssdk.utils.Utils.getVersionName(context));
        } catch (org.json.JSONException e) {
            com.heytap.mcssdk.utils.d.e("register-Exception:" + e.getMessage());
        }
        startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
    }

    @Override // com.heytap.mcssdk.a
    public void requestNotificationPermission() {
        if (checkContext()) {
            bindMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush(org.json.JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
        }
    }

    public void setAppKeySecret(java.lang.String str, java.lang.String str2) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i, org.json.JSONObject jSONObject) {
        if (!checkAll()) {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            return;
        }
        startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i + "", jSONObject);
    }

    public void setPushCallback(com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        this.mICallBackResultService = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4, org.json.JSONObject jSONObject) {
        if (!checkAll()) {
            if (getPushCallback() != null) {
                getPushCallback().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i < 0 || i2 < 0 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
            throw new java.lang.IllegalArgumentException("params are not all right,please check params");
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("weekDays", com.heytap.mcssdk.c.b.a(list));
            jSONObject2.put("startHour", i);
            jSONObject2.put("startMin", i2);
            jSONObject2.put("endHour", i3);
            jSONObject2.put("endMin", i4);
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
        } catch (org.json.JSONException e) {
            com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, e.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setRegisterID(java.lang.String str) {
        this.mRegisterID = str;
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister() {
        unRegister(null);
    }

    public void unRegister(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mContext = context.getApplicationContext();
        this.mICallBackResultService = iCallBackResultService;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister(org.json.JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onUnRegister(-2);
        }
    }
}
