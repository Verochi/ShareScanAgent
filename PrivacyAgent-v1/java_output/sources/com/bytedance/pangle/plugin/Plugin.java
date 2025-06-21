package com.bytedance.pangle.plugin;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final java.lang.String TAG = "Plugin";
    private int mApiVersionCode;
    public final java.lang.String mAppKey;
    public final java.lang.String mAppSecretKey;
    public com.bytedance.pangle.ZeusApplication mApplication;
    public com.bytedance.pangle.PluginClassLoader mClassLoader;
    public com.bytedance.pangle.wrapper.PluginApplicationWrapper mHostApplication;
    public android.content.pm.ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private java.lang.String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private java.lang.String mPackageDir;
    public java.lang.String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public android.content.res.Resources mResources;
    public java.lang.String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public java.lang.String response;
    public java.util.HashMap<java.lang.String, android.content.pm.ActivityInfo> pluginActivities = new java.util.HashMap<>();
    public java.util.HashMap<java.lang.String, android.content.pm.ServiceInfo> pluginServices = new java.util.HashMap<>();
    public java.util.HashMap<java.lang.String, android.content.pm.ActivityInfo> pluginReceiver = new java.util.HashMap<>();
    public java.util.HashMap<java.lang.String, android.content.pm.ProviderInfo> pluginProvider = new java.util.HashMap<>();
    private volatile int mLifeCycle = 1;
    public final java.util.List<java.lang.String> mSharedHostSos = new java.util.ArrayList();
    final java.lang.Object installLock = new java.lang.Object();
    final java.lang.Object initializeLock = new java.lang.Object();

    /* renamed from: com.bytedance.pangle.plugin.Plugin$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.io.File file;
            try {
                if (com.bytedance.pangle.plugin.Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                    file = new java.io.File(com.bytedance.pangle.d.c.b(), com.bytedance.pangle.plugin.Plugin.this.mPkgName + ".7z.zip");
                } else {
                    file = new java.io.File(com.bytedance.pangle.d.c.b(), com.bytedance.pangle.plugin.Plugin.this.mPkgName + com.anythink.china.common.a.a.g);
                }
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + com.bytedance.pangle.plugin.Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.Zeus.getAppApplication().getAssets().open(com.bytedance.pangle.plugin.Plugin.this.mInternalPath), new java.io.FileOutputStream(file));
                if (file.exists()) {
                    com.bytedance.pangle.plugin.PluginManager.getInstance().asyncInstall(com.bytedance.pangle.plugin.Plugin.this.mPkgName, file);
                    return;
                }
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
            }
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$2, reason: invalid class name */
    public class AnonymousClass2 implements java.io.FileFilter {
        public AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file != null && file.getName().matches("^version-(\\d+)$");
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$3, reason: invalid class name */
    public class AnonymousClass3 implements java.io.FileFilter {
        public AnonymousClass3() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            if (file.getName().matches("^version-(\\d+)$")) {
                com.bytedance.pangle.util.l.a().a(com.bytedance.pangle.plugin.Plugin.this.mPkgName, java.lang.Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]), false);
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$4, reason: invalid class name */
    public class AnonymousClass4 implements java.io.FileFilter {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass4(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            if (file != null && !this.a.equals(file.getName()) && !"data".equals(file.getName())) {
                com.bytedance.pangle.util.g.a(file.getAbsolutePath());
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                if (file.getName().matches("^version-(\\d+)$")) {
                    com.bytedance.pangle.util.l.a().a(com.bytedance.pangle.plugin.Plugin.this.mPkgName, java.lang.Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]), false);
                }
            }
            return false;
        }
    }

    public Plugin(org.json.JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(com.bytedance.sdk.openadsdk.live.TTLiveConstants.LIVE_API_VERSION_KEY);
        java.lang.String signature = com.bytedance.pangle.GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (android.text.TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString(com.heytap.mcssdk.constant.b.z, "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mSharedHostSos.add((java.lang.String) optJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(java.io.File file, java.lang.String str, int i) {
        if (!android.text.TextUtils.equals(this.mPkgName, str)) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i < this.mMinVersionCode || i > this.mMaxVersionCode) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + java.lang.String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.mMinVersionCode), java.lang.Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i < this.mVersionCode && isInstalled()) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + java.lang.String.format(" pluginApk ver[%s] lower than installed plugin[%s].", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i == this.mVersionCode && com.bytedance.pangle.util.l.a().a.getString("IDENTITY_".concat(java.lang.String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i + " true");
        return true;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        int a = com.bytedance.pangle.util.l.a().a(this.mPkgName);
        boolean z2 = false;
        if (a > i2) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, TAG.concat(java.lang.String.valueOf(java.lang.String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, java.lang.Integer.valueOf(a), java.lang.Integer.valueOf(i2)))));
            return false;
        }
        boolean z3 = i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode;
        if (z3 && i2 != -1) {
            com.bytedance.pangle.util.l a2 = com.bytedance.pangle.util.l.a();
            java.lang.String str = this.mPkgName;
            int i3 = a2.a.getInt("API_MIN_" + str + "_" + i, 0);
            com.bytedance.pangle.util.l a3 = com.bytedance.pangle.util.l.a();
            java.lang.String str2 = this.mPkgName;
            int i4 = a3.a.getInt("API_MAX_" + str2 + "_" + i, Integer.MAX_VALUE);
            int i5 = i4 != 0 ? i4 : Integer.MAX_VALUE;
            if (i2 < i3 || i2 > i5) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, TAG.concat(java.lang.String.valueOf(java.lang.String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, java.lang.Integer.valueOf(this.mVersionCode), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i5)))));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.d.b.b(new java.io.File(com.bytedance.pangle.d.c.b(this.mPkgName, i)))) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, TAG.concat(java.lang.String.valueOf(java.lang.String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, java.lang.Integer.valueOf(i)))));
        } else {
            z2 = z3;
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
            if (com.bytedance.pangle.util.l.a().a.getBoolean("UNINSTALL__".concat(java.lang.String.valueOf(this.mPkgName)), false)) {
                com.bytedance.pangle.util.l a = com.bytedance.pangle.util.l.a();
                java.lang.String str = this.mPkgName;
                android.content.SharedPreferences.Editor edit = a.a.edit();
                edit.remove("UNINSTALL__".concat(java.lang.String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (android.text.TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new java.io.File(this.mPackageDir).listFiles(new com.bytedance.pangle.plugin.Plugin.AnonymousClass3());
        com.bytedance.pangle.util.g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
            if (android.text.TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            new java.io.File(this.mPackageDir).listFiles(new com.bytedance.pangle.plugin.Plugin.AnonymousClass4("version-".concat(java.lang.String.valueOf(i))));
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (android.text.TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.plugin.Plugin.AnonymousClass1());
        }
    }

    private int modifyResIfNeed(int i) {
        java.lang.String a = com.bytedance.pangle.util.b.a(com.bytedance.pangle.Zeus.getAppApplication());
        if (!android.text.TextUtils.isEmpty(a) && android.text.TextUtils.equals(com.bytedance.pangle.util.l.a().b(this.mPkgName), a)) {
            return i;
        }
        if (this.mUnInstallPluginWhenHostChange || com.bytedance.pangle.GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
            return 0;
        }
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
        int a2 = new com.bytedance.pangle.res.a.c().a(new java.io.File(com.bytedance.pangle.d.c.b(this.mPkgName, i)), true, new java.lang.StringBuilder());
        if (a2 == 100 || a2 == 200) {
            return i;
        }
        return 0;
    }

    private void setupInternalPlugin() {
        int a;
        if (com.bytedance.pangle.util.l.a().a.getInt(java.lang.String.format(java.util.Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (android.text.TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (java.lang.String str : com.bytedance.pangle.Zeus.getAppApplication().getAssets().list(com.bytedance.pangle.h.d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a = com.bytedance.pangle.util.k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = com.bytedance.pangle.h.d + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
                        this.mInternalVersionCode = a;
                        return;
                    }
                }
            } catch (java.io.IOException e) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a;
        try {
            if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a = com.bytedance.pangle.servermanager.b.a()) == null || !a.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a.b(this.mPkgName));
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("updateInstallStateFromMainProcess error. process = ");
            com.bytedance.pangle.Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (android.text.TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        java.io.File[] listFiles = new java.io.File(this.mPackageDir).listFiles(new com.bytedance.pangle.plugin.Plugin.AnonymousClass2());
        int i = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (java.io.File file : listFiles) {
                int parseInt = java.lang.Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]);
                if (parseInt > i && com.bytedance.pangle.util.l.a().a(this.mPkgName, parseInt) && new java.io.File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                    i = parseInt;
                }
            }
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    public java.lang.String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public java.lang.String getNativeLibraryDir() {
        int i = this.mVersionCode;
        return i > 0 ? com.bytedance.pangle.d.c.d(this.mPkgName, i) : com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
                int i = 0;
                if (!android.text.TextUtils.isEmpty(com.bytedance.pangle.util.l.a().a.getString("HOST_ABI_".concat(java.lang.String.valueOf(this.mPkgName)), ""))) {
                    com.bytedance.pangle.util.l a = com.bytedance.pangle.util.l.a();
                    java.lang.String str = this.mPkgName;
                    z = !android.text.TextUtils.equals(a.a.getString("HOST_ABI_".concat(java.lang.String.valueOf(str)), ""), com.bytedance.pangle.Zeus.getHostAbi());
                    com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a.a.getString("HOST_ABI_".concat(java.lang.String.valueOf(str)), "") + ", " + com.bytedance.pangle.Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    i = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i);
                }
                deleteOtherExpiredVer(i);
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(java.lang.String.valueOf(this)));
                com.bytedance.pangle.util.l a2 = com.bytedance.pangle.util.l.a();
                java.lang.String str2 = this.mPkgName;
                android.content.SharedPreferences.Editor edit = a2.a.edit();
                edit.putString("ROM_LAST_".concat(java.lang.String.valueOf(str2)), android.os.Build.VERSION.INCREMENTAL);
                edit.apply();
                com.bytedance.pangle.util.l a3 = com.bytedance.pangle.util.l.a();
                java.lang.String str3 = this.mPkgName;
                java.lang.String string = a3.a.getString("HOST_ABI_".concat(java.lang.String.valueOf(str3)), "");
                android.content.SharedPreferences.Editor edit2 = a3.a.edit();
                edit2.putString("HOST_ABI_".concat(java.lang.String.valueOf(str3)), com.bytedance.pangle.Zeus.getHostAbi());
                edit2.apply();
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + com.bytedance.pangle.Zeus.getHostAbi());
                com.bytedance.pangle.util.l a4 = com.bytedance.pangle.util.l.a();
                java.lang.String str4 = this.mPkgName;
                java.lang.String a5 = com.bytedance.pangle.util.b.a(com.bytedance.pangle.Zeus.getAppApplication());
                java.lang.String b = a4.b(str4);
                if (!android.text.TextUtils.equals(b, a5)) {
                    android.content.SharedPreferences.Editor edit3 = a4.a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(java.lang.String.valueOf(str4)), a5);
                    edit3.apply();
                }
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b + " --> " + a5);
                com.bytedance.pangle.util.l a6 = com.bytedance.pangle.util.l.a();
                java.lang.String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int a7 = a6.a(str5);
                if (a7 != i2) {
                    android.content.SharedPreferences.Editor edit4 = a6.a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(java.lang.String.valueOf(str5)), i2);
                    edit4.apply();
                }
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a7 + " --> " + i2);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(java.lang.String str) {
        this.response = str;
    }

    public boolean install(java.io.File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z = false;
        try {
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + java.lang.Thread.currentThread().getName());
            java.lang.String str = eVar.a;
            int i = eVar.b;
            synchronized (this.installLock) {
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(java.lang.String.valueOf(this)));
                boolean checkValid = checkValid(file, str, i);
                if (checkValid) {
                    java.lang.String str2 = com.bytedance.pangle.util.c.a(file)[0];
                    z = com.bytedance.pangle.plugin.b.a(file, str, i);
                    if (z) {
                        com.bytedance.pangle.util.l a = com.bytedance.pangle.util.l.a();
                        java.lang.String str3 = this.mPkgName;
                        android.content.SharedPreferences.Editor edit = a.a.edit();
                        edit.putString("IDENTITY_".concat(java.lang.String.valueOf(str3)), str2);
                        edit.apply();
                        com.bytedance.pangle.util.l.a().a(this.mPkgName, i, true);
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i + " identity=" + str2);
                        com.bytedance.pangle.util.g.a(file);
                    }
                }
                synchronized (this) {
                    if (!checkValid) {
                        com.bytedance.pangle.util.g.a(file);
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i);
                    } else if (this.mLifeCycle == 3) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i);
                    } else if (z) {
                        updateToInstalled(i);
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i);
                    } else {
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i);
                        com.bytedance.pangle.util.g.a(file);
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
        }
        return z;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i) {
        return com.bytedance.pangle.util.l.a().a(this.mPkgName, i);
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        com.bytedance.pangle.util.l a = com.bytedance.pangle.util.l.a();
        java.lang.String str = this.mPkgName;
        android.content.SharedPreferences.Editor edit = a.a.edit();
        edit.putInt("API_MIN_" + str + "_" + i, i2);
        edit.putInt("API_MAX_" + str + "_" + i, i3);
        edit.apply();
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public java.lang.String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
