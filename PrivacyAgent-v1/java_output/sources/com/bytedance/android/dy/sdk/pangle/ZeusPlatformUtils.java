package com.bytedance.android.dy.sdk.pangle;

/* loaded from: classes.dex */
public class ZeusPlatformUtils {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final java.util.HashMap<java.lang.Integer, java.lang.String> PLUGIN_LOAD_EVENT_DESC = new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass1();
    public static boolean hasInitZeus = false;
    public static final java.util.concurrent.ScheduledExecutorService sExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
    private static boolean apmEnable = true;
    private static java.util.HashMap<java.lang.String, java.lang.String> customTagMap = null;

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$1, reason: invalid class name */
    class AnonymousClass1 extends java.util.HashMap<java.lang.Integer, java.lang.String> {
        public AnonymousClass1() {
            put(0, "REQUEST_FINISH");
            put(1, "DOWNLOAD_START");
            put(2, "DOWNLOAD_PROGRESS");
            put(3, "DOWNLOAD_SUCCESS");
            put(4, "DOWNLOAD_FAILED");
            put(5, "INSTALL_START");
            put(6, "INSTALL_SUCCESS");
            put(7, "INSTALL_FAILED");
            put(8, "LOAD_START");
            put(9, "LOAD_SUCCESS");
            put(10, "LOAD_FAILED");
        }
    }

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$2, reason: invalid class name */
    class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$dependPkgName;
        final /* synthetic */ java.lang.String val$pkgName;
        final /* synthetic */ com.bytedance.android.dy.sdk.pangle.PluginInitCallback val$pluginInitCallback;

        /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$2$1, reason: invalid class name */
        class AnonymousClass1 implements java.lang.Runnable {

            /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$2$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC02631 implements java.lang.Runnable {
                public RunnableC02631() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.this.val$pluginInitCallback.onPluginInitSuccess();
                }
            }

            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.checkPluginState(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.AnonymousClass1.RunnableC02631(), com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.this.val$pkgName)) {
                    com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.this.val$pluginInitCallback.onPluginInitSuccess();
                }
            }
        }

        public AnonymousClass2(com.bytedance.android.dy.sdk.pangle.PluginInitCallback pluginInitCallback, java.lang.String str, java.lang.String str2) {
            this.val$pluginInitCallback = pluginInitCallback;
            this.val$pkgName = str;
            this.val$dependPkgName = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.AnonymousClass1 anonymousClass1 = new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2.AnonymousClass1();
            if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.checkPluginState(anonymousClass1, this.val$dependPkgName)) {
                anonymousClass1.run();
            }
        }
    }

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$3, reason: invalid class name */
    class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$pkgName;
        final /* synthetic */ com.bytedance.android.dy.sdk.pangle.PluginInitCallback val$pluginInitCallback;

        /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$3$1, reason: invalid class name */
        class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass3.this.val$pluginInitCallback.onPluginInitSuccess();
            }
        }

        public AnonymousClass3(com.bytedance.android.dy.sdk.pangle.PluginInitCallback pluginInitCallback, java.lang.String str) {
            this.val$pluginInitCallback = pluginInitCallback;
            this.val$pkgName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.checkPluginState(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass3.AnonymousClass1(), this.val$pkgName)) {
                this.val$pluginInitCallback.onPluginInitSuccess();
            }
        }
    }

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$4, reason: invalid class name */
    class AnonymousClass4 extends com.bytedance.pangle.ZeusPluginStateListener {
        final /* synthetic */ java.lang.String val$pluginName;
        final /* synthetic */ java.lang.Runnable val$task;

        /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$4$1, reason: invalid class name */
        class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.pangle.Zeus.isPluginLoaded(com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4.this.val$pluginName)) {
                    com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4.this.val$task.run();
                } else if (com.bytedance.pangle.Zeus.loadPlugin(com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4.this.val$pluginName)) {
                    com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4.this.val$task.run();
                }
            }
        }

        public AnonymousClass4(java.lang.Runnable runnable, java.lang.String str) {
            this.val$task = runnable;
            this.val$pluginName = str;
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(java.lang.String str, int i, java.lang.Object... objArr) {
            if (this.val$task != null && this.val$pluginName.equals(str) && i == 6) {
                com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.sExecutor.execute(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$5, reason: invalid class name */
    class AnonymousClass5 extends com.bytedance.pangle.ZeusPluginStateListener {
        final /* synthetic */ java.lang.String val$pluginName;

        public AnonymousClass5(java.lang.String str) {
            this.val$pluginName = str;
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(java.lang.String str, int i, java.lang.Object... objArr) {
            if (this.val$pluginName.equals(str) && i == 6 && !com.bytedance.pangle.Zeus.isPluginLoaded(this.val$pluginName)) {
                com.bytedance.pangle.Zeus.loadPlugin(this.val$pluginName);
            }
        }
    }

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$6, reason: invalid class name */
    class AnonymousClass6 extends com.bytedance.pangle.ZeusPluginStateListener {
        final /* synthetic */ java.lang.String val$pkgName;
        final /* synthetic */ com.bytedance.android.dy.sdk.pangle.PluginStateListener val$stateListener;

        public AnonymousClass6(java.lang.String str, com.bytedance.android.dy.sdk.pangle.PluginStateListener pluginStateListener) {
            this.val$pkgName = str;
            this.val$stateListener = pluginStateListener;
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(java.lang.String str, int i, java.lang.Object... objArr) {
            if (this.val$pkgName.equals(str)) {
                this.val$stateListener.onPluginStateChanged(i, (java.lang.String) com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.PLUGIN_LOAD_EVENT_DESC.get(java.lang.Integer.valueOf(i)));
            }
        }
    }

    public static void addCustomTag(java.lang.String str, java.lang.String str2) {
        if (customTagMap == null) {
            customTagMap = new java.util.HashMap<>();
        }
        customTagMap.put(str, str2);
    }

    public static void checkPluginInit(java.lang.String str, com.bytedance.android.dy.sdk.pangle.PluginInitCallback pluginInitCallback) {
        sExecutor.execute(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass3(pluginInitCallback, str));
    }

    public static void checkPluginInit(java.lang.String str, java.lang.String str2, com.bytedance.android.dy.sdk.pangle.PluginInitCallback pluginInitCallback) {
        sExecutor.execute(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass2(pluginInitCallback, str2, str));
    }

    public static boolean checkPluginState(java.lang.Runnable runnable, java.lang.String str) {
        if (com.bytedance.pangle.Zeus.isPluginInstalled(str)) {
            return !com.bytedance.pangle.Zeus.isPluginLoaded(str) ? com.bytedance.pangle.Zeus.loadPlugin(str) : com.bytedance.pangle.Zeus.isPluginLoaded(str);
        }
        com.bytedance.pangle.Zeus.registerPluginStateListener(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass4(runnable, str));
        return false;
    }

    public static boolean checkPluginState(java.lang.String str) {
        if (com.bytedance.pangle.Zeus.isPluginInstalled(str)) {
            return !com.bytedance.pangle.Zeus.isPluginLoaded(str) ? com.bytedance.pangle.Zeus.loadPlugin(str) : com.bytedance.pangle.Zeus.isPluginLoaded(str);
        }
        com.bytedance.pangle.Zeus.registerPluginStateListener(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass5(str));
        return false;
    }

    public static void fetchPlugin(java.lang.String str) {
        com.bytedance.pangle.Zeus.onPrivacyAgreed();
        com.bytedance.pangle.Zeus.fetchPlugin(str);
    }

    public static boolean getApmEnable() {
        return apmEnable;
    }

    public static com.bytedance.pangle.plugin.Plugin getPlugin(java.lang.String str, boolean z) {
        return com.bytedance.pangle.Zeus.getPlugin(str, z);
    }

    public static java.lang.ClassLoader getPluginClassloader(java.lang.String str) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).mClassLoader;
    }

    public static java.lang.String getZeusActivityString() {
        return "com.bytedance.pangle.activity";
    }

    public static java.lang.String getZeusWrapperString() {
        return "com.bytedance.pangle.wrapper";
    }

    public static void initZeus(android.app.Application application) {
        if (application == null || hasInitZeus) {
            return;
        }
        com.bytedance.pangle.GlobalParam.getInstance().init();
        com.bytedance.pangle.Zeus.init(application, false);
        com.bytedance.pangle.Zeus.installFromDownloadDir();
        hasInitZeus = true;
    }

    public static void initZeus(android.app.Application application, boolean z, java.lang.String str) {
        if (application == null || hasInitZeus) {
            return;
        }
        hasInitZeus = true;
        if (customTagMap != null) {
            com.bytedance.pangle.GlobalParam.getInstance().setCustomTag(str, customTagMap);
            customTagMap = null;
        }
        if (!apmEnable) {
            com.bytedance.pangle.GlobalParam.getInstance().setApmFlag(false, false, false, false);
            com.bytedance.pangle.GlobalParam.getInstance().closeCrashMonitor(true);
        }
        com.bytedance.pangle.GlobalParam.getInstance().init();
        com.bytedance.pangle.Zeus.init(application, true);
        com.bytedance.pangle.Zeus.installFromDownloadDir();
        if (z) {
            com.bytedance.pangle.Zeus.fetchPlugin(str);
        }
    }

    public static boolean isPluginInstalled(java.lang.String str) {
        return com.bytedance.pangle.Zeus.isPluginInstalled(str);
    }

    public static boolean isPluginLoaded(java.lang.String str) {
        return com.bytedance.pangle.Zeus.isPluginLoaded(str);
    }

    public static void registerZeusPluginLoadStateListener(java.lang.String str, com.bytedance.android.dy.sdk.pangle.PluginStateListener pluginStateListener) {
        com.bytedance.pangle.Zeus.registerPluginStateListener(new com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.AnonymousClass6(str, pluginStateListener));
    }

    public static void setApmEnable(boolean z) {
        apmEnable = z;
    }

    public static void setGlobalParams() {
        com.bytedance.pangle.GlobalParam.getInstance().setApmFlag(false, false, false, false);
        com.bytedance.pangle.GlobalParam.getInstance().closeCrashMonitor(true);
    }

    public static void setHostVersionCodeTag(long j) {
        addCustomTag("internal_host_version_code", java.lang.String.valueOf(j));
    }
}
