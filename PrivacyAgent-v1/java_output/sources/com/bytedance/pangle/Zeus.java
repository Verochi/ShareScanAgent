package com.bytedance.pangle;

import com.bytedance.pangle.download.b.AnonymousClass1;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class Zeus {
    private static android.app.Application sApplication;
    private static final java.util.HashMap<java.lang.String, android.content.pm.ProviderInfo> serverManagerHashMap = new java.util.HashMap<>();
    static final java.lang.Object wait = new java.lang.Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(java.lang.String str, java.lang.String str2) {
        com.bytedance.pangle.plugin.Plugin plugin;
        android.content.res.Resources resources;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(com.bytedance.pangle.ZeusPluginEventCallback zeusPluginEventCallback) {
        com.bytedance.pangle.i a = com.bytedance.pangle.i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a.c) {
                a.c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(java.lang.String str) {
        com.bytedance.pangle.download.a a = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (!com.bytedance.pangle.GlobalParam.getInstance().autoFetch()) {
                com.bytedance.pangle.download.b.a();
                return;
            }
            com.bytedance.pangle.download.b a2 = com.bytedance.pangle.download.b.a();
            java.lang.Runnable runnable = a2.c.get(str);
            if (runnable != null) {
                a2.b.removeCallbacks(runnable);
            }
            com.bytedance.pangle.download.b.AnonymousClass1 anonymousClass1 = a2.new AnonymousClass1(str);
            a2.c.put(str, anonymousClass1);
            a2.b.postDelayed(anonymousClass1, 1800000L);
            com.bytedance.pangle.download.b.a();
            if (a.a.contains(str)) {
                return;
            }
            a.a.add(str);
        }
    }

    public static android.app.Application getAppApplication() {
        if (sApplication == null) {
            com.bytedance.pangle.b.a();
            try {
                sApplication = (android.app.Application) com.bytedance.pangle.util.MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new java.lang.Object[0]);
            } catch (java.lang.Throwable unused) {
            }
        }
        return sApplication;
    }

    public static java.lang.String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
    }

    public static int getInstalledPluginVersion(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(java.lang.String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static com.bytedance.pangle.plugin.Plugin getPlugin(java.lang.String str) {
        return getPlugin(str, true);
    }

    public static com.bytedance.pangle.plugin.Plugin getPlugin(java.lang.String str, boolean z) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str, z);
    }

    public static java.util.HashMap<java.lang.String, android.content.pm.ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static java.lang.String getZeusDid() {
        java.lang.String did = com.bytedance.pangle.GlobalParam.getInstance().getDid();
        return !android.text.TextUtils.isEmpty(did) ? did : com.bytedance.pangle.apm.ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return com.bytedance.pangle.i.a().a;
    }

    public static void hookHuaWeiVerifier(android.app.Application application) {
        com.bytedance.pangle.receiver.b.a(application);
    }

    public static void init(android.app.Application application, boolean z) {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_COMMON, "start init");
        com.bytedance.pangle.i.a().a(application, z);
        java.lang.Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
        for (java.lang.Runnable runnable : b.b) {
            if (runnable != null) {
                b.a.post(runnable);
            }
        }
        b.b.clear();
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            com.bytedance.pangle.plugin.PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(java.lang.String str) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(java.lang.String str) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        synchronized (com.bytedance.pangle.Zeus.class) {
            if (onPrivacyAgreed) {
                return;
            }
            com.bytedance.pangle.apm.ApmUtils.getApmInstance().init();
            onPrivacyAgreed = true;
        }
    }

    public static void registerPluginInstallListener(com.bytedance.pangle.ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            com.bytedance.pangle.c a = com.bytedance.pangle.servermanager.b.a();
            if (a != null) {
                a.a(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.f.b(zeusPluginInstallListener));
            }
        } catch (android.os.RemoteException e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public static void registerPluginStateListener(com.bytedance.pangle.ZeusPluginStateListener zeusPluginStateListener) {
        com.bytedance.pangle.i.a().b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(com.bytedance.pangle.ZeusPluginEventCallback zeusPluginEventCallback) {
        com.bytedance.pangle.i a = com.bytedance.pangle.i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a.c) {
                a.c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(java.lang.String str, int i, boolean z) {
        com.bytedance.pangle.plugin.PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
    }

    public static void setAppContext(android.app.Application application) {
        if (application != null && android.text.TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (android.app.Application) com.bytedance.pangle.util.FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (java.lang.Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(java.lang.String str, java.lang.String str2) {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, com.anythink.expressad.foundation.d.c.bT);
        com.bytedance.pangle.c a = com.bytedance.pangle.servermanager.b.a();
        if (a == null) {
            return false;
        }
        try {
            return a.a(str, str2);
        } catch (android.os.RemoteException e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
            return false;
        }
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(java.lang.String str) {
        com.bytedance.pangle.plugin.PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(com.bytedance.pangle.ZeusPluginStateListener zeusPluginStateListener) {
        java.util.List<com.bytedance.pangle.ZeusPluginStateListener> list = com.bytedance.pangle.i.a().b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i) {
        if (com.bytedance.pangle.i.a().a) {
            return true;
        }
        java.lang.Object obj = wait;
        synchronized (obj) {
            if (!com.bytedance.pangle.i.a().a) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (java.lang.InterruptedException unused) {
                }
            }
        }
        return com.bytedance.pangle.i.a().a;
    }

    public void unregisterPluginInstallListener(com.bytedance.pangle.ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            com.bytedance.pangle.c a = com.bytedance.pangle.servermanager.b.a();
            if (a != null) {
                a.a(zeusPluginInstallListener.hashCode());
            }
        } catch (android.os.RemoteException e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }
}
