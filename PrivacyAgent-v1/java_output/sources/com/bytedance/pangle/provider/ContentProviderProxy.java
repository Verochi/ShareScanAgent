package com.bytedance.pangle.provider;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ContentProviderProxy extends android.content.ContentProvider {
    public com.bytedance.pangle.provider.ContentProviderManager mPluginProviderManager;

    private com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider(android.net.Uri uri, java.lang.String str) {
        return obtainPluginProvider(uri, str, null);
    }

    private com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider(android.net.Uri uri, java.lang.String str, java.lang.String str2) {
        java.lang.String queryParameter = uri.getQueryParameter("provider_params");
        android.net.Uri uri2 = null;
        if (queryParameter == null) {
            return null;
        }
        if (!android.text.TextUtils.isEmpty(queryParameter)) {
            queryParameter = android.text.TextUtils.isEmpty(queryParameter) ? "" : new java.lang.String(android.util.Base64.decode(queryParameter, 10));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(queryParameter);
        java.lang.String optString = jSONObject.optString(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME);
        java.lang.String optString2 = jSONObject.optString("plugin_pkg_name");
        java.lang.String optString3 = jSONObject.optString("uri");
        com.bytedance.pangle.Zeus.loadPlugin(optString2);
        if (!android.text.TextUtils.isEmpty(optString3)) {
            uri2 = android.net.Uri.parse(optString3);
            str2 = uri2.getAuthority();
        }
        if (str2 == null) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] plugin Authority is null !!! plugin provider can not find !!");
        }
        com.bytedance.pangle.provider.PluginContentProvider pluginProvider = this.mPluginProviderManager.getPluginProvider(new com.bytedance.pangle.provider.ContentProviderManager.b(optString2, optString, str2));
        pluginProvider.pluginUri = uri2;
        return pluginProvider;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable android.os.Bundle bundle) {
        waitInit();
        try {
            java.lang.String string = bundle.getString("provider_params", "");
            android.net.Uri parse = android.net.Uri.parse(bundle.getString(com.bytedance.pangle.provider.ContentProviderManager.PROVIDER_PROXY_URI, ""));
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(parse, parse.getAuthority(), string);
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.call(str, str2, bundle);
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#call(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable android.os.Bundle bundle) {
        try {
            java.lang.String string = bundle.getString("provider_params", "");
            android.net.Uri parse = android.net.Uri.parse(bundle.getString(com.bytedance.pangle.provider.ContentProviderManager.PROVIDER_PROXY_URI, ""));
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(parse, parse.getAuthority(), string);
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.call(string, str2, str3, bundle);
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#call(4 params-Added in API level 29) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.os.Bundle bundle) {
        waitInit();
        if (uri == null) {
            return -1;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.delete(obtainPluginProvider.pluginUri, bundle);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#delete(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        waitInit();
        if (uri == null) {
            return -1;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.delete(obtainPluginProvider.pluginUri, str, strArr);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#delete(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.getType(obtainPluginProvider.pluginUri);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#getType className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.insert(obtainPluginProvider.pluginUri, contentValues);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#insert(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable android.os.Bundle bundle) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.insert(obtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#insert(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mPluginProviderManager = com.bytedance.pangle.provider.ContentProviderManager.getInstance();
        return true;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(api = 26)
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, bundle, cancellationSignal);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#query(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, str, strArr2, str2);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#query(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, str, strArr2, str2, cancellationSignal);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#query(6 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable android.os.Bundle bundle) {
        waitInit();
        if (uri == null) {
            return 0;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.update(obtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#update(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        waitInit();
        if (uri == null) {
            return 0;
        }
        try {
            com.bytedance.pangle.provider.PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.update(obtainPluginProvider.pluginUri, contentValues, str, strArr);
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "proxy provider#update(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    public void waitInit() {
        com.bytedance.pangle.Zeus.waitInit(-1);
    }
}
