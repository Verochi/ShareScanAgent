package com.bytedance.pangle.provider;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ContentProviderManager {
    public static final java.lang.String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final java.lang.String PLUGIN_PROCESS_NAME = "process_name";
    public static final java.lang.String PROVIDER_PARAM_FEILD = "provider_params";
    public static final java.lang.String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final java.lang.String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final java.lang.String PROVIDER_URI = "uri";
    private static com.bytedance.pangle.provider.ContentProviderManager sInstance;
    private final java.util.Map<com.bytedance.pangle.provider.ContentProviderManager.b, com.bytedance.pangle.provider.ContentProviderManager.a> mContentProviderMap = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.String> mAuthorityProcessNameMap = new java.util.HashMap();
    private final java.util.Map<java.lang.String, com.bytedance.pangle.provider.ContentProviderManager.c> mSystemProviderInfoMap = new java.util.HashMap();

    public static final class a {
        public final com.bytedance.pangle.provider.ContentProviderManager.b a;
        public final android.content.pm.ProviderInfo b;
        public final com.bytedance.pangle.provider.PluginContentProvider c;

        public a(com.bytedance.pangle.provider.ContentProviderManager.b bVar, android.content.pm.ProviderInfo providerInfo, com.bytedance.pangle.provider.PluginContentProvider pluginContentProvider) {
            this.b = providerInfo;
            this.a = bVar;
            this.c = pluginContentProvider;
        }
    }

    public static class b {
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.lang.String c;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str2;
            this.b = str3;
            this.c = str;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.bytedance.pangle.provider.ContentProviderManager.b) {
                com.bytedance.pangle.provider.ContentProviderManager.b bVar = (com.bytedance.pangle.provider.ContentProviderManager.b) obj;
                if (android.text.TextUtils.equals(this.c, bVar.c) && android.text.TextUtils.equals(this.b, bVar.b) && android.text.TextUtils.equals(this.a, bVar.a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return java.util.Objects.hash(this.a, this.b, this.c);
        }
    }

    public static final class c extends com.bytedance.pangle.provider.ContentProviderManager.b {
        public final android.content.pm.ProviderInfo d;

        public c(java.lang.String str, java.lang.String str2, android.content.pm.ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.d = providerInfo;
        }
    }

    private ContentProviderManager() {
    }

    public static com.bytedance.pangle.provider.ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (com.bytedance.pangle.provider.ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new com.bytedance.pangle.provider.ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    private void installProvider(java.lang.String str, android.content.pm.ProviderInfo providerInfo, com.bytedance.pangle.plugin.Plugin plugin) {
        if (providerInfo == null) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (android.text.TextUtils.equals(str, providerInfo.processName)) {
            com.bytedance.pangle.log.ZeusLogger.v(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                com.bytedance.pangle.provider.PluginContentProvider instantiateProvider = instantiateProvider(plugin, providerInfo);
                if (instantiateProvider == null) {
                    return;
                }
                instantiateProvider.attachInfo(com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                com.bytedance.pangle.log.ZeusLogger.v(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                com.bytedance.pangle.provider.ContentProviderManager.b bVar = new com.bytedance.pangle.provider.ContentProviderManager.b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(bVar, new com.bytedance.pangle.provider.ContentProviderManager.a(bVar, providerInfo, instantiateProvider));
            } catch (java.lang.Exception e) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private com.bytedance.pangle.provider.PluginContentProvider instantiateProvider(com.bytedance.pangle.plugin.Plugin plugin, android.content.pm.ProviderInfo providerInfo) {
        java.lang.Object newInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (!(newInstance instanceof androidx.core.content.FileProvider)) {
            return (com.bytedance.pangle.provider.PluginContentProvider) newInstance;
        }
        android.os.Bundle bundle = providerInfo.metaData;
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(java.lang.String.valueOf(newInstance)));
        }
        com.bytedance.pangle.FileProvider.a(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
        return null;
    }

    public android.os.Bundle call(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str, java.lang.String str2, android.os.Bundle bundle, java.lang.String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public final android.os.Bundle call(android.content.ContentResolver contentResolver, java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Bundle bundle, java.lang.String str4) {
        return com.bytedance.pangle.provider.a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(android.content.ContentResolver contentResolver, android.net.Uri uri, android.os.Bundle bundle, java.lang.String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, bundle, str);
    }

    public int delete(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, strArr, str2);
    }

    public java.lang.String getPluginProcessNameByAuthority(java.lang.String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public com.bytedance.pangle.provider.PluginContentProvider getPluginProvider(com.bytedance.pangle.provider.ContentProviderManager.b bVar) {
        com.bytedance.pangle.provider.ContentProviderManager.a aVar = this.mContentProviderMap.get(bVar);
        if (aVar == null) {
            return null;
        }
        return aVar.c;
    }

    public java.util.Map<java.lang.String, com.bytedance.pangle.provider.ContentProviderManager.c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public java.lang.String getType(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str);
    }

    public void initSystemContentProviderInfo() {
        java.lang.String str;
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_CONTENT_PROVIDER, com.anythink.expressad.foundation.d.c.bT);
        try {
            android.content.pm.ProviderInfo[] providerInfoArr = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageInfo(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (android.content.pm.ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null && str.contains(".pangle.provider.proxy.")) {
                    try {
                        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(com.bytedance.pangle.Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            java.lang.String a2 = com.bytedance.pangle.d.d.a(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(a2, new com.bytedance.pangle.provider.ContentProviderManager.c(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), a2, providerInfo));
                            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (java.lang.Exception e) {
                        com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public android.net.Uri insert(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public android.net.Uri insert(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str);
    }

    public void installContentProviders(java.util.Collection<android.content.pm.ProviderInfo> collection, com.bytedance.pangle.plugin.Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        com.bytedance.pangle.Zeus.getAppApplication();
        java.lang.String a2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
        for (android.content.pm.ProviderInfo providerInfo : collection) {
            if (com.bytedance.pangle.log.ZeusLogger.isDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                com.bytedance.pangle.log.ZeusLogger.v(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(a2, providerInfo, plugin);
        }
    }

    public boolean isPluginProvider(android.net.Uri uri) {
        if (uri == null) {
            return true;
        }
        java.lang.String authority = uri.getAuthority();
        java.util.Set<java.lang.String> keySet = this.mAuthorityProcessNameMap.keySet();
        return keySet != null && keySet.contains(authority);
    }

    @androidx.annotation.RequiresApi(api = 26)
    public android.database.Cursor query(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.lang.String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }

    @androidx.annotation.RequiresApi(api = 16)
    public android.database.Cursor query(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal, java.lang.String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public android.database.Cursor query(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, java.lang.String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        return com.bytedance.pangle.provider.a.b(contentResolver, uri, contentValues, bundle, str);
    }

    public int update(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }
}
