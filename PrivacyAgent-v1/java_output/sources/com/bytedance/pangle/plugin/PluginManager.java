package com.bytedance.pangle.plugin;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class PluginManager {
    private static final java.lang.String TAG = "PluginManager";
    private static volatile com.bytedance.pangle.plugin.PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private java.util.concurrent.ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private volatile java.util.Map<java.lang.String, com.bytedance.pangle.plugin.Plugin> mPlugins = new java.util.concurrent.ConcurrentHashMap();
    private final com.bytedance.pangle.plugin.c pluginLoader = new com.bytedance.pangle.plugin.c();

    private PluginManager() {
    }

    private void ensurePluginFileExist(com.bytedance.pangle.plugin.Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new java.io.File(com.bytedance.pangle.d.c.b(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static com.bytedance.pangle.plugin.PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (com.bytedance.pangle.plugin.PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new com.bytedance.pangle.plugin.PluginManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        com.bytedance.pangle.log.ZeusLogger.v(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        try {
            android.os.Bundle bundle = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageInfo(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            try {
                for (java.lang.String str : bundle.keySet()) {
                    java.lang.String str2 = com.bytedance.pangle.h.e;
                    if (str2.startsWith("PANGLE_")) {
                        if (str.startsWith(str2) || str.startsWith("ZEUS_PLUGIN_")) {
                            arrayList.add(bundle.getString(str));
                        }
                    } else if (str.startsWith(str2)) {
                        arrayList.add(bundle.getString(str));
                    }
                }
                try {
                    java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
                    for (java.lang.String str3 : arrayList) {
                        try {
                            com.bytedance.pangle.plugin.Plugin plugin = new com.bytedance.pangle.plugin.Plugin(new org.json.JSONObject(str3));
                            concurrentHashMap.put(plugin.mPkgName, plugin);
                            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                        } catch (org.json.JSONException e) {
                            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str3.trim(), e);
                        }
                    }
                    this.mPlugins = concurrentHashMap;
                    com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                } catch (java.lang.Exception e2) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e2);
                }
                this.mIsParsePluginConfig = true;
            } catch (java.lang.Exception e3) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager iterator metaData failed.", e3);
            }
        } catch (java.lang.Exception e4) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e4);
        }
    }

    public void asyncInstall(java.lang.String str, java.io.File file) {
        if (file != null) {
            getInstallThreadPool().execute(new com.bytedance.pangle.plugin.a(str, file));
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(java.lang.String.valueOf(file)));
        } else {
            com.bytedance.pangle.ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public boolean checkPluginInstalled(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public java.util.concurrent.ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool == null) {
            this.mInstallThreadPool = com.bytedance.pangle.d.e.a(com.bytedance.pangle.GlobalParam.getInstance().getInstallThreads());
        }
        return this.mInstallThreadPool;
    }

    public com.bytedance.pangle.plugin.Plugin getPlugin(java.lang.String str) {
        return getPlugin(str, true);
    }

    public com.bytedance.pangle.plugin.Plugin getPlugin(java.lang.String str, boolean z) {
        if (!com.bytedance.pangle.Zeus.hasInit() && com.bytedance.pangle.util.b.a()) {
            throw new java.lang.RuntimeException("Please init Zeus first!");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        com.bytedance.pangle.plugin.Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.plugin.d());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(java.lang.String str) {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_COMMON, "start load plugin:".concat(java.lang.String.valueOf(str)));
        return this.pluginLoader.a(str);
    }

    public void setAllowDownloadPlugin(java.lang.String str, int i, boolean z) {
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            boolean z2 = !z;
            android.content.SharedPreferences.Editor edit = com.bytedance.pangle.util.l.a().a.edit();
            java.lang.String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
            if (z2) {
                edit.putInt(str2, 0);
            } else {
                edit.remove(str2);
            }
            edit.apply();
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z2);
        }
    }

    public boolean syncInstall(java.lang.String str, java.io.File file) {
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(java.lang.String.valueOf(file)));
        return new com.bytedance.pangle.plugin.a(str, file).a();
    }

    public void tryOfflineInternalPlugin(java.lang.String str, int i) {
        com.bytedance.pangle.plugin.Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i) {
            return;
        }
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
        com.bytedance.pangle.util.l a = com.bytedance.pangle.util.l.a();
        int apiVersionCode = plugin.getApiVersionCode();
        android.content.SharedPreferences.Editor edit = a.a.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(java.lang.String.valueOf(str)), apiVersionCode);
        edit.apply();
    }

    public void unInstallPackage(java.lang.String str) {
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(java.lang.String.valueOf(str)));
        if (getPlugin(str) != null) {
            android.content.SharedPreferences.Editor edit = com.bytedance.pangle.util.l.a().a.edit();
            edit.putBoolean("UNINSTALL__".concat(java.lang.String.valueOf(str)), true);
            edit.apply();
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(java.lang.String.valueOf(str)));
        }
    }
}
