package com.bytedance.pangle.plugin;

/* loaded from: classes12.dex */
public final class c {
    private static final com.bytedance.pangle.i a = com.bytedance.pangle.i.a();

    /* renamed from: com.bytedance.pangle.plugin.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.pangle.a.a.InterfaceC0264a {
        final /* synthetic */ com.bytedance.pangle.plugin.Plugin a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.io.File c;
        final /* synthetic */ java.io.File d;
        final /* synthetic */ java.lang.StringBuilder e;

        public AnonymousClass1(com.bytedance.pangle.plugin.Plugin plugin, java.lang.String str, java.io.File file, java.io.File file2, java.lang.StringBuilder sb) {
            this.a = plugin;
            this.b = str;
            this.c = file;
            this.d = file2;
            this.e = sb;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0264a
        public final void a() {
            com.bytedance.pangle.plugin.c.this.a(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.pangle.a.a.InterfaceC0264a {
        final /* synthetic */ android.content.pm.PackageInfo[] a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.bytedance.pangle.plugin.Plugin c;
        final /* synthetic */ java.lang.StringBuilder d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.io.File f;

        public AnonymousClass2(android.content.pm.PackageInfo[] packageInfoArr, java.lang.String str, com.bytedance.pangle.plugin.Plugin plugin, java.lang.StringBuilder sb, java.lang.String str2, java.io.File file) {
            this.a = packageInfoArr;
            this.b = str;
            this.c = plugin;
            this.d = sb;
            this.e = str2;
            this.f = file;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0264a
        public final void a() {
            this.a[0] = com.bytedance.pangle.plugin.c.this.a(this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.ComponentCallbacks {
        final /* synthetic */ com.bytedance.pangle.plugin.Plugin a;

        public AnonymousClass3(com.bytedance.pangle.plugin.Plugin plugin) {
            this.a = plugin;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(android.content.res.Configuration configuration) {
            this.a.mResources.updateConfiguration(configuration, com.bytedance.pangle.Zeus.getAppApplication().getResources().getDisplayMetrics());
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.pangle.plugin.Plugin a;

        public AnonymousClass4(com.bytedance.pangle.plugin.Plugin plugin) {
            this.a = plugin;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.bytedance.pangle.PluginClassLoader pluginClassLoader = this.a.mClassLoader;
                pluginClassLoader.setAllPluginClasses((java.util.HashSet) com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new java.lang.Object[0]));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.pm.PackageInfo a(java.lang.String str, com.bytedance.pangle.plugin.Plugin plugin, java.lang.StringBuilder sb, java.lang.String str2, java.io.File file) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        android.content.pm.PackageInfo packageArchiveInfo = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        plugin.mHostApplication = (com.bytedance.pangle.wrapper.PluginApplicationWrapper) com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext2Application(com.bytedance.pangle.Zeus.getAppApplication(), plugin.mPkgName);
        android.content.pm.ApplicationInfo applicationInfo = new android.content.pm.ApplicationInfo(com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (android.text.TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (android.text.TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new com.bytedance.pangle.res.PluginResources(com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        com.bytedance.pangle.Zeus.getAppApplication().registerComponentCallbacks(new com.bytedance.pangle.plugin.c.AnonymousClass3(plugin));
        sb.append("makeResources cost:");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        sb.append(com.alipay.sdk.m.u.i.b);
        return packageArchiveInfo;
    }

    private static void a(com.bytedance.pangle.plugin.Plugin plugin, java.lang.String str) {
        org.json.JSONObject optJSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("mapping");
        java.util.HashMap hashMap = new java.util.HashMap();
        if (optJSONObject2 != null) {
            java.util.Iterator<java.lang.String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, optJSONObject2.getString(next));
            }
        }
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("forceMappings");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("minApi", 0);
                int optInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= optInt2 && apiVersionCode >= optInt && (optJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    java.util.Iterator<java.lang.String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        java.lang.String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                }
            }
        }
        for (java.lang.String str2 : hashMap.keySet()) {
            java.lang.String str3 = (java.lang.String) hashMap.get(str2);
            java.lang.String str4 = plugin.mPkgName;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "");
            sb.append((java.lang.String) hashMap.get(str2));
            com.bytedance.pangle.ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    private static void a(com.bytedance.pangle.plugin.Plugin plugin, java.lang.String str, java.io.File file, java.io.File file2) {
        if (com.bytedance.pangle.util.i.k()) {
            com.bytedance.pangle.PluginClassLoader pluginClassLoader = new com.bytedance.pangle.PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            a(pluginClassLoader, str);
            return;
        }
        if (!com.bytedance.pangle.util.i.b()) {
            plugin.mClassLoader = new com.bytedance.pangle.PluginClassLoader(str, file2, file.getAbsolutePath(), null);
            return;
        }
        java.lang.String a2 = com.bytedance.pangle.e.g.a(plugin.mPkgName, plugin.getVersion());
        java.lang.String[] split = a2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = !com.bytedance.pangle.e.b.a(file2.getAbsolutePath(), split);
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "useDirect:" + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " " + z);
        com.bytedance.pangle.PluginClassLoader pluginClassLoader2 = new com.bytedance.pangle.PluginClassLoader(z ? "" : a2, file2, file.getAbsolutePath(), null);
        plugin.mClassLoader = pluginClassLoader2;
        if (z) {
            com.bytedance.pangle.dex.a.a(pluginClassLoader2, plugin.mPkgName, plugin.getVersion());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.pangle.plugin.Plugin plugin, java.lang.String str, java.io.File file, java.io.File file2, java.lang.StringBuilder sb) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.plugin.c.AnonymousClass4(plugin));
        }
        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
        try {
            java.lang.String str2 = (java.lang.String) com.bytedance.pangle.util.FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                a(plugin, str2);
            }
        } catch (java.lang.ClassNotFoundException unused) {
        } catch (java.lang.Throwable th) {
            sb.append("actStubV1 cost:");
            sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis2);
            sb.append(com.alipay.sdk.m.u.i.b);
            throw th;
        }
        sb.append("actStubV1 cost:");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis2);
        sb.append(com.alipay.sdk.m.u.i.b);
    }

    private static void a(com.bytedance.pangle.plugin.Plugin plugin, java.lang.StringBuilder sb, android.content.pm.PackageInfo packageInfo) {
        android.content.pm.ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                if (android.text.TextUtils.isEmpty(activityInfo.processName) || !activityInfo.processName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    activityInfo.processName = "main";
                } else {
                    activityInfo.processName = activityInfo.processName.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        android.content.pm.ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                if (android.text.TextUtils.isEmpty(serviceInfo.processName) || !serviceInfo.processName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    serviceInfo.processName = "main";
                } else {
                    serviceInfo.processName = serviceInfo.processName.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        android.content.pm.ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (android.content.pm.ActivityInfo activityInfo2 : activityInfoArr2) {
                if (android.text.TextUtils.isEmpty(activityInfo2.processName) || !activityInfo2.processName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    activityInfo2.processName = "main";
                } else {
                    activityInfo2.processName = activityInfo2.processName.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        android.content.pm.ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (android.content.pm.ProviderInfo providerInfo : providerInfoArr) {
                if (android.text.TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    providerInfo.processName = "main";
                } else {
                    providerInfo.processName = providerInfo.processName.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.HashMap<java.lang.String, android.content.pm.ProviderInfo> hashMap = plugin.pluginProvider;
        if (hashMap != null && hashMap.size() > 0) {
            com.bytedance.pangle.provider.ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        sb.append(com.alipay.sdk.m.u.i.b);
        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
        if (!android.text.TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            com.bytedance.pangle.ZeusApplication zeusApplication = (com.bytedance.pangle.ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, com.bytedance.pangle.Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis2);
        sb.append(com.alipay.sdk.m.u.i.b);
    }

    private static void a(java.lang.Object obj, java.lang.String str) {
        if (str != null) {
            try {
                for (java.lang.String str2 : str.split(java.io.File.pathSeparator)) {
                    new java.io.File(str2).setReadOnly();
                }
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(java.lang.String.valueOf(str)), th);
                return;
            }
        }
        com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(dalvik.system.BaseDexClassLoader.class, "addDexPath", java.lang.String.class).invoke(obj, str);
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(java.lang.String.valueOf(str)));
    }

    private static void a(java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2, int i2, long j, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", java.lang.Integer.valueOf(com.bytedance.pangle.log.b.b(java.lang.Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01a9 A[Catch: all -> 0x024b, TryCatch #0 {all -> 0x024b, blocks: (B:29:0x0185, B:31:0x01a9, B:37:0x01d1, B:39:0x01d7, B:40:0x01da, B:42:0x01e2, B:43:0x0245, B:46:0x0218), top: B:28:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d1 A[Catch: all -> 0x024b, TryCatch #0 {all -> 0x024b, blocks: (B:29:0x0185, B:31:0x01a9, B:37:0x01d1, B:39:0x01d7, B:40:0x01da, B:42:0x01e2, B:43:0x0245, B:46:0x0218), top: B:28:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e2 A[Catch: all -> 0x024b, TryCatch #0 {all -> 0x024b, blocks: (B:29:0x0185, B:31:0x01a9, B:37:0x01d1, B:39:0x01d7, B:40:0x01da, B:42:0x01e2, B:43:0x0245, B:46:0x0218), top: B:28:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0218 A[Catch: all -> 0x024b, TryCatch #0 {all -> 0x024b, blocks: (B:29:0x0185, B:31:0x01a9, B:37:0x01d1, B:39:0x01d7, B:40:0x01da, B:42:0x01e2, B:43:0x0245, B:46:0x0218), top: B:28:0x0185 }] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(java.lang.String str, com.bytedance.pangle.plugin.Plugin plugin, java.lang.StringBuilder sb) {
        boolean z;
        boolean z2;
        int i;
        java.io.File file;
        android.content.pm.PackageInfo[] packageInfoArr;
        char c;
        boolean z3;
        boolean z4;
        boolean z5;
        try {
            if (plugin == null) {
                sb.append("loadPluginInternal, plugin == null;");
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!");
                return false;
            }
            java.lang.String b = com.bytedance.pangle.d.c.b(plugin.mPkgName, plugin.getVersion());
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + b + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new java.io.File(b).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            try {
                if (!com.bytedance.pangle.util.i.b() && !com.bytedance.pangle.util.i.f() && !com.bytedance.pangle.util.i.k()) {
                    if (!((com.bytedance.pangle.util.l.a().b(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
                        sb.append("removeEntry skip 2;");
                        z2 = true;
                        z = false;
                        i = z2;
                        java.io.File file2 = new java.io.File(com.bytedance.pangle.d.c.d(plugin.mPkgName, plugin.getVersion()));
                        java.io.File file3 = new java.io.File(com.bytedance.pangle.d.c.c(plugin.mPkgName, plugin.getVersion()));
                        if (com.bytedance.pangle.util.i.e()) {
                            java.lang.String[] strArr = new java.lang.String[i];
                            strArr[0] = file3 + java.io.File.separator + com.bytedance.pangle.e.b.a(b);
                            if (!com.bytedance.pangle.e.b.a(strArr)) {
                                file3 = null;
                            }
                        }
                        file = file3;
                        if (file != null && !file.exists()) {
                            file.mkdirs();
                        }
                        android.content.pm.PackageInfo[] packageInfoArr2 = new android.content.pm.PackageInfo[i];
                        if (com.bytedance.pangle.util.i.k()) {
                            packageInfoArr = packageInfoArr2;
                            a(plugin, b, file2, file, sb);
                            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                            c = 0;
                            packageInfoArr[0] = a(str, plugin, sb, b, file2);
                            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                        } else {
                            com.bytedance.pangle.a.a.InterfaceC0264a[] interfaceC0264aArr = new com.bytedance.pangle.a.a.InterfaceC0264a[2];
                            interfaceC0264aArr[0] = new com.bytedance.pangle.plugin.c.AnonymousClass1(plugin, b, file2, file, sb);
                            packageInfoArr = packageInfoArr2;
                            interfaceC0264aArr[i] = new com.bytedance.pangle.plugin.c.AnonymousClass2(packageInfoArr2, str, plugin, sb, b, file2);
                            com.bytedance.pangle.a.a.a(interfaceC0264aArr);
                            c = 0;
                        }
                        a(plugin, sb, packageInfoArr[c]);
                        return i;
                    }
                    boolean a2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication());
                    boolean z6 = com.bytedance.pangle.util.l.a().a.getBoolean("dex_opt_state_" + plugin.mPkgName + "_" + plugin.getVersion(), false);
                    if (a2 && z6) {
                        if (!com.bytedance.pangle.util.l.a().a.getBoolean("dex_remove_state_" + plugin.mPkgName + "_" + plugin.getVersion(), false)) {
                            long currentTimeMillis = java.lang.System.currentTimeMillis();
                            z5 = true;
                            z4 = com.bytedance.pangle.util.b.b.a(b, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                            sb.append("removeEntry cost:");
                            sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
                            sb.append(com.alipay.sdk.m.u.i.b);
                            com.bytedance.pangle.util.l.a().c(plugin.mPkgName, plugin.getVersion(), true);
                            z = z4;
                            i = z5;
                            java.io.File file22 = new java.io.File(com.bytedance.pangle.d.c.d(plugin.mPkgName, plugin.getVersion()));
                            java.io.File file32 = new java.io.File(com.bytedance.pangle.d.c.c(plugin.mPkgName, plugin.getVersion()));
                            if (com.bytedance.pangle.util.i.e()) {
                            }
                            file = file32;
                            if (file != null) {
                                file.mkdirs();
                            }
                            android.content.pm.PackageInfo[] packageInfoArr22 = new android.content.pm.PackageInfo[i];
                            if (com.bytedance.pangle.util.i.k()) {
                            }
                            a(plugin, sb, packageInfoArr[c]);
                            return i;
                        }
                        z3 = true;
                        sb.append("removeEntry skip 3;");
                    } else {
                        z3 = true;
                        sb.append("removeEntry skip 4 ");
                        sb.append(a2);
                        sb.append(" ");
                        sb.append(z6);
                        sb.append(com.alipay.sdk.m.u.i.b);
                    }
                    z4 = false;
                    z5 = z3;
                    z = z4;
                    i = z5;
                    java.io.File file222 = new java.io.File(com.bytedance.pangle.d.c.d(plugin.mPkgName, plugin.getVersion()));
                    java.io.File file322 = new java.io.File(com.bytedance.pangle.d.c.c(plugin.mPkgName, plugin.getVersion()));
                    if (com.bytedance.pangle.util.i.e()) {
                    }
                    file = file322;
                    if (file != null) {
                    }
                    android.content.pm.PackageInfo[] packageInfoArr222 = new android.content.pm.PackageInfo[i];
                    if (com.bytedance.pangle.util.i.k()) {
                    }
                    a(plugin, sb, packageInfoArr[c]);
                    return i;
                }
                java.io.File file2222 = new java.io.File(com.bytedance.pangle.d.c.d(plugin.mPkgName, plugin.getVersion()));
                java.io.File file3222 = new java.io.File(com.bytedance.pangle.d.c.c(plugin.mPkgName, plugin.getVersion()));
                if (com.bytedance.pangle.util.i.e()) {
                }
                file = file3222;
                if (file != null) {
                }
                android.content.pm.PackageInfo[] packageInfoArr2222 = new android.content.pm.PackageInfo[i];
                if (com.bytedance.pangle.util.i.k()) {
                }
                a(plugin, sb, packageInfoArr[c]);
                return i;
            } catch (java.lang.Throwable th) {
                th = th;
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_ERROR, "loadPluginInternal stack:" + java.util.Arrays.toString(th.getStackTrace()));
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_ERROR, "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ");
                sb.append(th.getMessage());
                sb.append(com.alipay.sdk.m.u.i.b);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (!z) {
                    return false;
                }
                com.bytedance.pangle.util.l.a().a(str, plugin.getVersion(), "load");
                if (com.bytedance.pangle.util.l.a().b(str, plugin.getVersion(), "load") <= 3) {
                    return false;
                }
                com.bytedance.pangle.Zeus.unInstallPlugin(str);
                return false;
            }
            z2 = true;
            sb.append("removeEntry skip 1;");
            z = false;
            i = z2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public final boolean a(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(java.lang.String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            if (!plugin.isInstalled()) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(java.lang.String.valueOf(str)));
                return false;
            }
            if (plugin.isLoaded()) {
                return true;
            }
            com.bytedance.pangle.i iVar = a;
            iVar.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(java.lang.String.valueOf(str)));
            a(com.bytedance.pangle.c.b.i, com.bytedance.pangle.c.b.a.D, plugin.mPkgName, plugin.getVersion(), -1L, (java.lang.String) null);
            com.bytedance.pangle.ZeusPluginStateListener.postStateChange(str, 8, new java.lang.Object[0]);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            boolean a3 = a(str, plugin, sb);
            a2.a("loadPluginInternal:".concat(java.lang.String.valueOf(a3)));
            if (a3) {
                plugin.setLifeCycle(3);
                a(com.bytedance.pangle.c.b.j, com.bytedance.pangle.c.b.a.E, plugin.mPkgName, plugin.getVersion(), a2.a(), sb.toString());
                com.bytedance.pangle.ZeusPluginStateListener.postStateChange(str, 9, new java.lang.Object[0]);
                iVar.a(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                sb.append("plugin:");
                sb.append(plugin.mPkgName);
                sb.append(" versionCode:");
                sb.append(plugin.getVersion());
                sb.append("load failed;");
                a(com.bytedance.pangle.c.b.j, com.bytedance.pangle.c.b.a.F, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                com.bytedance.pangle.ZeusPluginStateListener.postStateChange(str, 10, new java.lang.Object[0]);
                iVar.a(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(java.lang.String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }
}
