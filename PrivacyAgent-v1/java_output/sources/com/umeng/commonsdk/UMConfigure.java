package com.umeng.commonsdk;

/* loaded from: classes19.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final java.lang.String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final java.lang.String KEY_FILE_NAME_LOG = "LOG";
    private static final java.lang.String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final java.lang.String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final java.lang.String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final java.lang.String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final java.lang.String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final java.lang.String TAG = "UMConfigure";
    private static final java.lang.String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final java.lang.String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final java.lang.String WRAPER_TYPE_FLUTTER = "flutter";
    private static final java.lang.String WRAPER_TYPE_HYBRID = "hybrid";
    private static final java.lang.String WRAPER_TYPE_NATIVE = "native";
    private static final java.lang.String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final java.lang.String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final java.lang.String WRAPER_TYPE_UNITY = "Unity";
    private static final java.lang.String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static com.umeng.commonsdk.listener.OnGetOaidListener mOnGetOaidListener;
    public static com.umeng.commonsdk.debug.UMLog umDebugLog = new com.umeng.commonsdk.debug.UMLog();
    private static boolean preInitComplete = false;
    private static java.lang.Object PreInitLock = new java.lang.Object();
    public static java.lang.String sAppkey = "";
    public static java.lang.String sChannel = "";
    public static boolean isInit = false;
    private static java.lang.Object lock = new java.lang.Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static volatile boolean shouldCollectAid = true;
    private static volatile boolean shouldCollectOaid = true;
    private static volatile boolean shouldCollectImei = true;
    private static volatile boolean shouldCollectImsi = true;
    private static volatile boolean shouldCollectIccid = true;
    private static volatile boolean shouldCollectWiFiMac = true;
    private static volatile boolean shouldOutputRT = false;
    public static com.umeng.analytics.MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = com.umeng.analytics.MobclickAgent.PageMode.AUTO;
    private static final java.lang.String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", com.umeng.analytics.pro.bo.al};
    private static boolean isFinish = false;
    private static java.lang.Object lockObject = new java.lang.Object();

    /* renamed from: com.umeng.commonsdk.UMConfigure$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                android.os.Looper.prepare();
                android.widget.Toast.makeText(this.a, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                android.os.Looper.loop();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.lang.Thread {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                android.os.Looper.prepare();
                android.widget.Toast.makeText(this.a, com.umeng.commonsdk.debug.UMLogCommon.SC_10015, 1).show();
                android.os.Looper.loop();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.lang.Thread {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass3(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                android.os.Looper.prepare();
                android.widget.Toast.makeText(this.a, com.umeng.commonsdk.debug.UMLogCommon.SC_10015, 1).show();
                android.os.Looper.loop();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass4(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String b = com.umeng.analytics.pro.ba.b(this.a);
            if (com.umeng.commonsdk.UMConfigure.mOnGetOaidListener != null) {
                com.umeng.commonsdk.UMConfigure.mOnGetOaidListener.onGetOaid(b);
            }
        }
    }

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(java.lang.Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(com.umeng.commonsdk.UMConfigure.BS_TYPE bs_type, java.lang.String str) {
        if (bs_type == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                return;
            }
            int ordinal = bs_type.ordinal();
            java.lang.String[] strArr = BUSINESS_TYPE;
            java.lang.String str2 = ordinal < strArr.length ? strArr[ordinal] : "";
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            com.umeng.commonsdk.statistics.TagHelper.deleteModuleTag(str2 + "_" + str);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void disableAidCollect() {
        try {
            java.lang.Class<?> cls = getClass("com.umeng.socialize.UMShareAPI");
            java.lang.Class<?> cls2 = getClass("com.uyumao.nns.zmd.ZmdManager");
            if (cls == null && cls2 == null) {
                return;
            }
            shouldCollectAid = false;
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void disableOaidCollect() {
        try {
            if (getClass("com.uyumao.nns.zmd.ZmdManager") != null) {
                shouldCollectOaid = false;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void enableAzxSwitch(boolean z) {
        com.umeng.ccg.b.a(z);
    }

    public static void enableIccidCollection(boolean z) {
        shouldCollectIccid = z;
    }

    public static void enableImeiCollection(boolean z) {
        shouldCollectImei = z;
    }

    public static void enableImsiCollection(boolean z) {
        shouldCollectImsi = z;
    }

    public static void enableUmcCfgSwitch(boolean z) {
        com.umeng.ccg.b.b(z);
    }

    public static void enableWiFiMacCollection(boolean z) {
        shouldCollectWiFiMac = z;
    }

    private static java.lang.Class<?> getClass(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    private static java.lang.String getCurrentActivityName() {
        return com.umeng.analytics.vshelper.PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static java.lang.Object getDecInstanceObject(java.lang.Class<?> cls) {
        java.lang.reflect.Constructor<?> constructor;
        if (cls == null) {
            return null;
        }
        try {
            constructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
        } catch (java.lang.NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused2) {
            return null;
        }
    }

    private static java.lang.reflect.Method getDecMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>[] clsArr) {
        java.lang.reflect.Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static java.util.Map<java.lang.String, java.lang.String> getModuleTags() {
        try {
            return com.umeng.commonsdk.statistics.TagHelper.getModuleTags();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static void getOaid(android.content.Context context, com.umeng.commonsdk.listener.OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        mOnGetOaidListener = onGetOaidListener;
        if (shouldCollectOaid) {
            new java.lang.Thread(new com.umeng.commonsdk.UMConfigure.AnonymousClass4(applicationContext)).start();
            return;
        }
        com.umeng.commonsdk.listener.OnGetOaidListener onGetOaidListener2 = mOnGetOaidListener;
        if (onGetOaidListener2 != null) {
            onGetOaidListener2.onGetOaid(null);
        }
    }

    public static java.lang.String[] getTestDeviceInfo(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        if (context != null) {
            try {
                strArr[0] = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(context);
            } catch (java.lang.Exception unused) {
            }
        }
        return strArr;
    }

    public static java.lang.String getUMIDString(android.content.Context context) {
        if (context != null) {
            return com.umeng.commonsdk.utils.UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static java.lang.String getUmengZID(android.content.Context context) {
        if (context != null) {
            return com.umeng.commonsdk.utils.UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    private static void ignoreSdkCheck(android.content.Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(android.content.Context context, int i, java.lang.String str) {
        init(context, null, null, i, str);
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        java.lang.Object invoke;
        java.lang.reflect.Method declaredMethod;
        java.lang.Class<?> cls;
        java.lang.reflect.Method declaredMethod2;
        java.lang.reflect.Method declaredMethod3;
        java.lang.Object invoke2;
        java.lang.reflect.Method declaredMethod4;
        try {
            try {
                if (debugLog) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("common type is ");
                    sb.append(com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE);
                }
            } catch (java.lang.Throwable th) {
                if (debugLog) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("init e is ");
                    sb2.append(th);
                }
            }
        } catch (java.lang.Exception e) {
            if (debugLog) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("init e is ");
                sb3.append(e);
            }
        }
        if (context == null || isInit) {
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        com.umeng.commonsdk.service.UMGlobalContext.getInstance(applicationContext);
        if (com.umeng.commonsdk.utils.c.a()) {
            if (!isPreInit()) {
                preInitInternal(applicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.D, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            return;
        }
        try {
            if (getClass("com.umeng.umzid.ZIDManager") == null) {
                new com.umeng.commonsdk.UMConfigure.AnonymousClass1(applicationContext).start();
                return;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Class<?> cls2 = getClass("com.umeng.message.PushAgent");
            if (cls2 != null && !checkShareSdk(cls2) && shouldCheckShareSdk) {
                new com.umeng.commonsdk.UMConfigure.AnonymousClass2(applicationContext).start();
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            java.lang.Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
            if (cls3 != null && !checkShareSdk(cls3) && shouldCheckShareSdk) {
                new com.umeng.commonsdk.UMConfigure.AnonymousClass3(applicationContext).start();
            }
        } catch (java.lang.Throwable unused3) {
        }
        if (!isPreInit()) {
            preInitInternal(applicationContext, str, str2);
            if (!isPreInit()) {
                return;
            }
        }
        com.umeng.commonsdk.framework.UMEnvelopeBuild.registerNetReceiver(applicationContext);
        com.umeng.commonsdk.utils.UMUtils.setAppkey(applicationContext, sAppkey);
        java.lang.String lastAppkey = com.umeng.commonsdk.utils.UMUtils.getLastAppkey(applicationContext);
        if (!android.text.TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
            if (!android.text.TextUtils.isEmpty(lastAppkey) && debugLog) {
                com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10008, 2, "");
            }
            com.umeng.commonsdk.utils.UMUtils.setLastAppkey(applicationContext, sAppkey);
        }
        if (debugLog) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append("current appkey is ");
            sb4.append(sAppkey);
            sb4.append(", last appkey is ");
            sb4.append(lastAppkey);
        }
        if (debugLog) {
            java.lang.String appkeyByXML = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(applicationContext);
            if (!android.text.TextUtils.isEmpty(sAppkey) && !android.text.TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10011, 3, "", new java.lang.String[]{"@", "#"}, new java.lang.String[]{sAppkey, appkeyByXML});
            }
        }
        com.umeng.commonsdk.utils.UMUtils.setChannel(applicationContext, sChannel);
        if (debugLog) {
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append("channel is ");
            sb5.append(sChannel);
        }
        try {
            java.lang.reflect.Method declaredMethod5 = com.umeng.analytics.MobclickAgent.class.getDeclaredMethod("init", android.content.Context.class);
            if (declaredMethod5 != null) {
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(com.umeng.analytics.MobclickAgent.class, applicationContext);
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                    com.umeng.analytics.pro.n.a(applicationContext).b(applicationContext);
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                }
                if (debugLog) {
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10003, 2, "");
                }
            }
            java.lang.Class.forName("com.umeng.analytics.game.UMGameAgent");
            java.lang.reflect.Method declaredMethod6 = com.umeng.analytics.MobclickAgent.class.getDeclaredMethod("setGameScenarioType", android.content.Context.class);
            if (declaredMethod6 != null) {
                declaredMethod6.setAccessible(true);
                declaredMethod6.invoke(com.umeng.analytics.MobclickAgent.class, applicationContext);
            }
            if (com.umeng.commonsdk.statistics.b.a.indexOf("e") >= 0 && (declaredMethod4 = com.umeng.analytics.MobclickAgent.class.getDeclaredMethod("disableExceptionCatch", new java.lang.Class[0])) != null) {
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(com.umeng.analytics.MobclickAgent.class, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            java.lang.Class<?> cls4 = java.lang.Class.forName("com.umeng.message.PushAgent");
            java.lang.reflect.Method declaredMethod7 = cls4.getDeclaredMethod("init", android.content.Context.class);
            if (declaredMethod7 != null) {
                declaredMethod7.setAccessible(true);
                declaredMethod7.invoke(cls4, applicationContext);
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            java.lang.Class<?> cls5 = java.lang.Class.forName("com.umeng.message.MessageSharedPrefs");
            java.lang.reflect.Method declaredMethod8 = cls5.getDeclaredMethod("getInstance", android.content.Context.class);
            if (declaredMethod8 != null && (invoke2 = declaredMethod8.invoke(cls5, applicationContext)) != null) {
                java.lang.reflect.Method declaredMethod9 = cls5.getDeclaredMethod("setMessageAppKey", java.lang.String.class);
                if (declaredMethod9 != null) {
                    declaredMethod9.setAccessible(true);
                    declaredMethod9.invoke(invoke2, sAppkey);
                    if (debugLog) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10004, 2, "");
                    }
                }
                java.lang.reflect.Method declaredMethod10 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, java.lang.String.class);
                if (declaredMethod10 != null) {
                    declaredMethod10.setAccessible(true);
                    declaredMethod10.invoke(invoke2, sChannel);
                    if (debugLog) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10005, 2, "");
                    }
                }
                if (!android.text.TextUtils.isEmpty(str3)) {
                    if (debugLog) {
                        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                        sb6.append("push secret is ");
                        sb6.append(str3);
                    }
                    java.lang.reflect.Method declaredMethod11 = cls5.getDeclaredMethod("setMessageAppSecret", java.lang.String.class);
                    if (declaredMethod11 != null) {
                        declaredMethod11.setAccessible(true);
                        declaredMethod11.invoke(invoke2, str3);
                        if (debugLog) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10009, 2, "");
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused6) {
        }
        try {
            java.lang.Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
            setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
            if (cls6 != null && (declaredMethod3 = cls6.getDeclaredMethod("init", android.content.Context.class, java.lang.String.class)) != null) {
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(cls6, applicationContext, sAppkey);
                if (debugLog) {
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10006, 2, "");
                }
            }
        } catch (java.lang.Throwable unused7) {
        }
        com.umeng.commonsdk.statistics.AnalyticsConstants.setDeviceType(i);
        try {
            java.lang.Class<?> cls7 = java.lang.Class.forName("com.umeng.error.UMError");
            java.lang.reflect.Method declaredMethod12 = cls7.getDeclaredMethod("init", android.content.Context.class);
            if (declaredMethod12 != null) {
                declaredMethod12.setAccessible(true);
                declaredMethod12.invoke(cls7, applicationContext);
                if (debugLog) {
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10010, 2, "");
                }
            }
        } catch (java.lang.Throwable unused8) {
        }
        try {
            if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 1 && (declaredMethod2 = cls.getDeclaredMethod("useIntlServices", java.lang.Boolean.TYPE)) != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls, java.lang.Boolean.TRUE);
                }
                java.lang.reflect.Method declaredMethod13 = cls.getDeclaredMethod("init", android.content.Context.class, java.lang.String.class, java.lang.String.class);
                if (declaredMethod13 != null) {
                    declaredMethod13.setAccessible(true);
                    declaredMethod13.invoke(cls, applicationContext, sAppkey, sChannel);
                    if (debugLog) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10014, 2, "");
                    }
                }
            }
        } catch (java.lang.Throwable unused9) {
        }
        try {
            java.lang.reflect.Method declaredMethod14 = java.lang.Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", android.app.Application.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE, java.lang.String.class);
            if (declaredMethod14 != null) {
                declaredMethod14.invoke(null, applicationContext, sAppkey, sChannel, java.lang.Integer.valueOf(i), str3);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
            }
        } catch (java.lang.Throwable unused10) {
        }
        try {
            java.lang.reflect.Method declaredMethod15 = java.lang.Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", android.app.Application.class, java.lang.String.class);
            if (declaredMethod15 != null) {
                declaredMethod15.invoke(null, applicationContext, sAppkey);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
            }
        } catch (java.lang.Throwable unused11) {
        }
        synchronized (lockObject) {
            isFinish = true;
        }
        if (needCheckPolicyResult(applicationContext)) {
            synchronized (lock) {
                int i2 = preInitInvokedFlag;
                int i3 = policyGrantResult;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.umeng.commonsdk.internal.a.J, preInitInvokedFlag);
                    jSONObject.put(com.umeng.commonsdk.internal.a.K, policyGrantInvokedFlag);
                    jSONObject.put("policyGrantResult", policyGrantResult);
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.A, com.umeng.commonsdk.internal.b.a(applicationContext).a(), jSONObject);
                } catch (java.lang.Throwable unused12) {
                }
            }
        }
        if (needSendZcfgEnv(applicationContext)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.p, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
        } else if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(applicationContext)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
            if (com.umeng.commonsdk.config.FieldManager.b()) {
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.y, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            }
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                com.umeng.commonsdk.internal.c.a(applicationContext, false);
            }
        }
        if (isDebugLog()) {
            com.umeng.commonsdk.UMConfigureInternation.doSelfCheck(applicationContext);
        }
        try {
            android.content.Context applicationContext2 = context.getApplicationContext();
            java.lang.Class<?> cls8 = java.lang.Class.forName("com.umeng.cconfig.UMRemoteConfig");
            java.lang.reflect.Method declaredMethod16 = cls8.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            if (declaredMethod16 != null && (invoke = declaredMethod16.invoke(cls8, new java.lang.Object[0])) != null && (declaredMethod = cls8.getDeclaredMethod("init", android.content.Context.class)) != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(invoke, applicationContext2);
            }
        } catch (java.lang.Exception unused13) {
        }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.F, com.umeng.commonsdk.internal.b.a(context).a(), null);
        if (!isInit) {
            isInit = true;
        }
        if (debugLog) {
            com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.commonsdk.debug.UMLogCommon.SC_10029, 2, "");
        }
    }

    private static void invoke(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused) {
        }
    }

    private static void invoke(java.lang.reflect.Method method, java.lang.Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static java.lang.Boolean isInForeground() {
        return java.lang.Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    private static boolean isSilentMode() {
        boolean a = com.umeng.commonsdk.utils.c.a();
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + a);
        return a;
    }

    private static boolean needCheckPolicyResult(android.content.Context context) {
        java.io.File filesDir = context.getFilesDir();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(java.io.File.separator);
        sb.append(com.umeng.analytics.pro.bs.m);
        return !new java.io.File(sb.toString()).exists();
    }

    public static boolean needSendZcfgEnv(android.content.Context context) {
        java.io.File filesDir = context.getFilesDir();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(java.io.File.separator);
        sb.append(com.umeng.analytics.pro.bs.l);
        return !new java.io.File(sb.toString()).exists();
    }

    public static void onActEvent(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        com.umeng.ccg.CcgAgent.onActUpEvent(str, str2, bundle);
    }

    public static void preInit(android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if ("1".equals(com.umeng.commonsdk.utils.UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(applicationContext);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = com.umeng.commonsdk.utils.UMUtils.getChannelByXML(applicationContext);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        com.umeng.commonsdk.service.UMGlobalContext.getInstance(applicationContext);
        com.umeng.analytics.pro.n.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            com.umeng.commonsdk.config.FieldManager.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean a = com.umeng.commonsdk.utils.c.a();
        if (debugLog && a) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    public static void registerActionInfo(com.umeng.ccg.ActionInfo actionInfo) {
        com.umeng.ccg.CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(java.lang.String str) {
        com.umeng.analytics.pro.ay.b().a(str);
    }

    private static void setCheckDevice(boolean z) {
        com.umeng.commonsdk.statistics.AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setDomain(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL = str;
        com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z) {
        com.umeng.commonsdk.statistics.b.a(z);
    }

    private static void setFile(java.lang.Class<?> cls, java.lang.String str, java.lang.String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void setFile(java.lang.Class<?> cls, java.lang.String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, java.lang.Boolean.valueOf(z));
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j) {
        com.umeng.commonsdk.statistics.a.c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            com.umeng.commonsdk.statistics.common.MLog.DEBUG = z;
            java.lang.Class<?> cls = getClass("com.umeng.message.PushAgent");
            java.lang.Object decInstanceObject = getDecInstanceObject(cls);
            java.lang.Class cls2 = java.lang.Boolean.TYPE;
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new java.lang.Class[]{cls2}), decInstanceObject, new java.lang.Object[]{java.lang.Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new java.lang.Class[]{cls2}), new java.lang.Object[]{java.lang.Boolean.valueOf(z)});
        } catch (java.lang.Exception e) {
            if (debugLog) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("set log enabled e is ");
                sb.append(e);
            }
        } catch (java.lang.Throwable th) {
            if (debugLog) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("set log enabled e is ");
                sb2.append(th);
            }
        }
    }

    private static void setModuleTag(com.umeng.commonsdk.UMConfigure.BS_TYPE bs_type, java.lang.String str, java.lang.String str2) {
        if (bs_type == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str.trim().getBytes().length > 64 || str2.trim().getBytes().length > 128) {
                return;
            }
            int ordinal = bs_type.ordinal();
            java.lang.String[] strArr = BUSINESS_TYPE;
            java.lang.String str3 = ordinal < strArr.length ? strArr[ordinal] : "";
            if (android.text.TextUtils.isEmpty(str3)) {
                return;
            }
            com.umeng.commonsdk.statistics.TagHelper.setModuleTag(str3 + "_" + str, str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z) {
        com.umeng.commonsdk.statistics.AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setWraperType(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.a = "native";
                com.umeng.commonsdk.statistics.a.a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_UNITY;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.a = "hybrid";
                com.umeng.commonsdk.statistics.a.a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.b = str2;
        com.umeng.commonsdk.statistics.a.b = str2;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldCollectIccid() {
        return shouldCollectIccid;
    }

    public static boolean shouldCollectImei() {
        return shouldCollectImei;
    }

    public static boolean shouldCollectImsi() {
        return shouldCollectImsi;
    }

    public static boolean shouldCollectOaid() {
        return shouldCollectOaid;
    }

    public static boolean shouldCollectWifiMac() {
        return shouldCollectWiFiMac;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(android.content.Context context, boolean z) {
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, com.umeng.commonsdk.internal.b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.z, com.umeng.commonsdk.internal.b.a(context).a(), java.lang.Integer.valueOf(policyGrantResult));
    }
}
