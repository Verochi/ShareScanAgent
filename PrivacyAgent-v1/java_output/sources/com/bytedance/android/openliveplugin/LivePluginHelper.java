package com.bytedance.android.openliveplugin;

/* loaded from: classes.dex */
public class LivePluginHelper {
    public static final java.lang.String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final java.lang.String PLAYER_PLUGIN_PACKAGE_NAME = "com.byted.ttm.player";
    private static com.bytedance.android.live.base.api.IOuterLiveService liveRoomService;
    private static java.util.ArrayList<com.bytedance.android.live.base.api.ILiveInitCallback> mLiveInitListeners;
    private static com.bytedance.android.live.base.api.callback.EmptyCallback sInstallCallback;
    public static final java.util.concurrent.ScheduledExecutorService sExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(new com.bytedance.android.openliveplugin.LivePluginHelper.DefaultThreadFactory());
    private static volatile boolean hasLiveInitFinish = false;
    private static boolean runInLiveProcess = false;
    private static boolean stopAppLogOnEnterBackground = false;
    private static java.lang.ref.WeakReference<android.app.Activity> hostActivity = null;
    private static final com.bytedance.android.live.base.api.ILiveInitCallback loadingLiveInitCallback = new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass6();

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$1, reason: invalid class name */
    class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$appId;
        final /* synthetic */ com.bytedance.android.live.base.api.ILiveHostContextParam.Builder val$builder;
        final /* synthetic */ android.app.Application val$context;
        final /* synthetic */ com.bytedance.android.live.base.api.ILiveInitCallback val$liveInitCallback;
        final /* synthetic */ boolean val$runInLiveProcess;

        public AnonymousClass1(com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, android.app.Application application, java.lang.String str, boolean z) {
            this.val$liveInitCallback = iLiveInitCallback;
            this.val$builder = builder;
            this.val$context = application;
            this.val$appId = str;
            this.val$runInLiveProcess = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.android.openliveplugin.LivePluginHelper.addInitListener(this.val$liveInitCallback);
            if (com.bytedance.android.openliveplugin.LivePluginHelper.getStopAppLogOnEnterBackground()) {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("stop_applog_on_background", "1");
                this.val$builder.addHostInitExtra(hashMap);
            }
            com.bytedance.android.openliveplugin.LiveReflectFacade.initLiveInPlugin(this.val$context, this.val$appId, this.val$builder, this.val$runInLiveProcess, com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback.INSTANCE);
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$2, reason: invalid class name */
    class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$appId;
        final /* synthetic */ com.bytedance.android.live.base.api.ILiveHostContextParam.Builder val$builder;
        final /* synthetic */ android.app.Application val$context;
        final /* synthetic */ com.bytedance.android.live.base.api.ILiveInitCallback val$liveInitCallback;
        final /* synthetic */ boolean val$runInLiveProcess;

        /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$2$1, reason: invalid class name */
        class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("live init : runnable real init live ---- ");
                com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass2 anonymousClass2 = com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass2.this;
                com.bytedance.android.openliveplugin.LivePluginHelper.realInitLivePlugin(anonymousClass2.val$context, anonymousClass2.val$appId, anonymousClass2.val$builder, anonymousClass2.val$liveInitCallback, anonymousClass2.val$runInLiveProcess);
            }
        }

        public AnonymousClass2(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z) {
            this.val$context = application;
            this.val$appId = str;
            this.val$builder = builder;
            this.val$liveInitCallback = iLiveInitCallback;
            this.val$runInLiveProcess = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("live init : async start init live ~~~");
            if (com.bytedance.android.openliveplugin.LivePluginHelper.prepare(new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass2.AnonymousClass1())) {
                com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("live init : prepared-start real init live ---- ");
                com.bytedance.android.openliveplugin.LivePluginHelper.realInitLivePlugin(this.val$context, this.val$appId, this.val$builder, this.val$liveInitCallback, this.val$runInLiveProcess);
            }
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$3, reason: invalid class name */
    class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable val$task;

        public AnonymousClass3(java.lang.Runnable runnable) {
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.android.openliveplugin.LivePluginHelper.prepare(this.val$task)) {
                this.val$task.run();
            }
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$4, reason: invalid class name */
    class AnonymousClass4 implements com.bytedance.android.dy.sdk.pangle.PluginStateListener {
        @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
        public void onPluginStateChanged(int i, java.lang.String str) {
            if (i != 6 || com.bytedance.android.openliveplugin.LivePluginHelper.sInstallCallback == null) {
                return;
            }
            com.bytedance.android.openliveplugin.LivePluginHelper.sInstallCallback.invoke();
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$5, reason: invalid class name */
    class AnonymousClass5 implements com.bytedance.android.dy.sdk.pangle.PluginStateListener {
        @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
        public void onPluginStateChanged(int i, java.lang.String str) {
            if ((i == 4 || i == 7 || i == 10) && com.bytedance.android.openliveplugin.LiveLoadingDialog.dismiss() && com.bytedance.android.openliveplugin.LivePluginHelper.hostActivity.get() != null) {
                android.widget.Toast.makeText((android.content.Context) com.bytedance.android.openliveplugin.LivePluginHelper.hostActivity.get(), com.bytedance.sdk.openadsdk.R.string.live_in_loading_failed, 1).show();
            }
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.android.live.base.api.ILiveInitCallback {
        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(java.lang.String str) {
            if (!com.bytedance.android.openliveplugin.LiveLoadingDialog.dismiss() || com.bytedance.android.openliveplugin.LivePluginHelper.hostActivity.get() == null) {
                return;
            }
            android.widget.Toast.makeText((android.content.Context) com.bytedance.android.openliveplugin.LivePluginHelper.hostActivity.get(), com.bytedance.sdk.openadsdk.R.string.live_in_loading_failed, 1).show();
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            if (com.bytedance.android.openliveplugin.LiveLoadingDialog.dismiss()) {
                com.bytedance.android.openliveplugin.LivePluginHelper.trulyEnterCommerceOrderList();
            }
        }
    }

    /* renamed from: com.bytedance.android.openliveplugin.LivePluginHelper$7, reason: invalid class name */
    class AnonymousClass7 implements com.bytedance.android.live.base.api.callback.CommonCallback<java.lang.String, java.lang.String> {
        @Override // com.bytedance.android.live.base.api.callback.CommonCallback
        public void onFail(java.lang.String str) {
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("get enterCommercePage fail, error msg = ".concat(java.lang.String.valueOf(str)));
        }

        @Override // com.bytedance.android.live.base.api.callback.CommonCallback
        public void onSuccess(java.lang.String str) {
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("get enterCommercePage success, result = ".concat(java.lang.String.valueOf(str)));
            com.bytedance.android.openliveplugin.LivePluginHelper.liveRoomService.handleSchema((android.content.Context) com.bytedance.android.openliveplugin.LivePluginHelper.hostActivity.get(), android.net.Uri.parse(str));
        }
    }

    public static class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
        private final java.lang.ThreadGroup group;
        private final java.lang.String namePrefix;
        private final java.util.concurrent.atomic.AtomicInteger threadNumber;

        public DefaultThreadFactory() {
            this.threadNumber = new java.util.concurrent.atomic.AtomicInteger(1);
            this.group = new java.lang.ThreadGroup("tob_douyin_live_group");
            this.namePrefix = "tob_douyin_live_thread_init";
        }

        public DefaultThreadFactory(java.lang.String str) {
            this.threadNumber = new java.util.concurrent.atomic.AtomicInteger(1);
            this.group = new java.lang.ThreadGroup("tob_douyin_live_group");
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }
    }

    public static class LiveInitCallback implements com.bytedance.android.live.base.api.ILiveInitCallback {
        public static com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback INSTANCE = new com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback();

        private LiveInitCallback() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(java.lang.String str) {
            java.util.Iterator it = com.bytedance.android.openliveplugin.LivePluginHelper.mLiveInitListeners.iterator();
            while (it.hasNext()) {
                com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback = (com.bytedance.android.live.base.api.ILiveInitCallback) it.next();
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFailed(str);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            com.bytedance.android.openliveplugin.LivePluginHelper.logVersionInfo();
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("live init : LiveInitCallbackWrapper onLiveInitFinish called.");
            com.bytedance.android.openliveplugin.LivePluginHelper.initLiveCommerce();
            boolean unused = com.bytedance.android.openliveplugin.LivePluginHelper.hasLiveInitFinish = true;
            java.util.Iterator it = com.bytedance.android.openliveplugin.LivePluginHelper.mLiveInitListeners.iterator();
            while (it.hasNext()) {
                com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback = (com.bytedance.android.live.base.api.ILiveInitCallback) it.next();
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFinish();
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static void adaptEventBus() {
        com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "tryAdaptEventBus", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getZeusActivityString(), com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getZeusWrapperString());
    }

    public static void addCustomTag(java.lang.String str, java.lang.String str2) {
        com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.addCustomTag(str, str2);
    }

    public static void addInitListener(com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback) {
        if (mLiveInitListeners == null) {
            mLiveInitListeners = new java.util.ArrayList<>();
        }
        if (iLiveInitCallback == com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback.INSTANCE || mLiveInitListeners.contains(iLiveInitCallback) || iLiveInitCallback == null) {
            return;
        }
        mLiveInitListeners.add(iLiveInitCallback);
    }

    public static void enterCommerceOrderList(android.app.Activity activity) {
        hostActivity = new java.lang.ref.WeakReference<>(activity);
        if (isLiveInited()) {
            trulyEnterCommerceOrderList();
            return;
        }
        com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass5());
        addInitListener(loadingLiveInitCallback);
        com.bytedance.android.openliveplugin.LiveLoadingDialog.show(hostActivity.get());
    }

    public static boolean getApmEnable() {
        return com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getApmEnable();
    }

    public static java.lang.String getLiveArgsJsonStr() {
        return (java.lang.String) com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "getLiveArgsJsonStr", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new java.lang.Object[0]);
    }

    public static com.bytedance.android.live.base.api.IOuterLiveService getLiveRoomService() {
        if (liveRoomService == null) {
            liveRoomService = com.bytedance.android.openliveplugin.LiveReflectFacade.getOuterLiveService();
        }
        return liveRoomService;
    }

    public static boolean getStopAppLogOnEnterBackground() {
        return stopAppLogOnEnterBackground;
    }

    public static void init(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback) {
        init(application, str, builder, iLiveInitCallback, true);
    }

    public static void init(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z) {
        init(application, str, builder, iLiveInitCallback, z, false);
    }

    public static void init(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z, boolean z2) {
        if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.hasInitZeus) {
            com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.fetchPlugin("com.byted.live.lite");
        } else {
            com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.initZeus(application, z, "com.byted.live.lite");
        }
        initLive(application, str, builder, iLiveInitCallback, z2);
    }

    public static void initLive(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z) {
        runInLiveProcess = z;
        sExecutor.execute(new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass2(application, str, builder, iLiveInitCallback, z));
    }

    public static void initLiveCommerce() {
        try {
            adaptEventBus();
            com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", "init", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLiveInited() {
        return hasLiveInitFinish;
    }

    public static boolean isRunInLiveProcess() {
        return runInLiveProcess;
    }

    public static void logEventV3(java.lang.String str, org.json.JSONObject jSONObject) {
        com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "onEventV3", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logVersionInfo() {
        java.lang.Object callStaticMethodWithClassLoader = com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginApplication", "getPluginVersion", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new java.lang.Object[0]);
        if (callStaticMethodWithClassLoader == null) {
            return;
        }
        try {
            android.util.Pair pair = (android.util.Pair) callStaticMethodWithClassLoader;
            long longValue = ((java.lang.Long) pair.first).longValue();
            java.lang.String str = (java.lang.String) pair.second;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("version_info: lib_version_name=");
            sb.append("2.1.1.4-tob-tob-283069386");
            sb.append("; sdkApiVersionName=");
            sb.append("2.1.1.4-tob-tob-283069386");
            sb.append("; pluginVersionCode=");
            sb.append(longValue);
            sb.append("; pluginVersionName=");
            sb.append(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean prepare(java.lang.Runnable runnable) {
        com.bytedance.android.live.base.api.callback.EmptyCallback emptyCallback;
        com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("live init : prepare ---- ");
        com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass4());
        if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.isPluginInstalled("com.byted.live.lite") && (emptyCallback = sInstallCallback) != null) {
            emptyCallback.invoke();
        }
        return com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.checkPluginState(runnable, "com.byted.live.lite");
    }

    private static void preparePlayer(java.lang.Runnable runnable) {
        com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass3 anonymousClass3 = new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass3(runnable);
        if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.checkPluginState(anonymousClass3, PLAYER_PLUGIN_PACKAGE_NAME)) {
            anonymousClass3.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realInitLivePlugin(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z) {
        sExecutor.execute(new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass1(iLiveInitCallback, builder, application, str, z));
    }

    public static void setApmEnable(boolean z) {
        com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.setApmEnable(z);
    }

    public static void setBoeValue(java.lang.String str) {
        com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setBoeValue", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setHostVersionCodeTag(long j) {
        com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.setHostVersionCodeTag(j);
    }

    public static void setInstallCallback(com.bytedance.android.live.base.api.callback.EmptyCallback emptyCallback) {
        sInstallCallback = emptyCallback;
    }

    public static void setPpeValue(java.lang.String str) {
        com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setPpeValue", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setStopAppLogOnEnterBackground(boolean z) {
        stopAppLogOnEnterBackground = z;
    }

    public static void trulyEnterCommerceOrderList() {
        com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("trulyEnterCommerceOrderList start");
        if (liveRoomService == null) {
            getLiveRoomService();
        }
        if (liveRoomService == null) {
            return;
        }
        try {
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("callExpandMethod enterCommercePage");
            liveRoomService.callExpandMethod("enterCommercePage", new org.json.JSONObject().put("request_page", "order_list"), new com.bytedance.android.openliveplugin.LivePluginHelper.AnonymousClass7(), 2000L);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
