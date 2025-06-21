package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

/* loaded from: classes19.dex */
public class SAEncryptStorePlugin implements com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin {
    private final java.lang.String mFileName;
    private final android.content.SharedPreferences mStoreSp;

    public SAEncryptStorePlugin(android.content.Context context) {
        this(context, com.sensorsdata.analytics.android.sdk.BuildConfig.LIBRARY_PACKAGE_NAME);
    }

    public SAEncryptStorePlugin(android.content.Context context, java.lang.String str) {
        this.mStoreSp = com.sensorsdata.analytics.android.sdk.util.SASpUtils.getSharedPreferences(context, str, 0);
        this.mFileName = str;
    }

    private java.lang.String decryptValue(java.lang.String str) {
        java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_DECRYPT_AES, str);
        return android.text.TextUtils.isEmpty(str2) ? str : str2;
    }

    private java.lang.String encryptValue(java.lang.String str) {
        java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_AES, str);
        return android.text.TextUtils.isEmpty(str2) ? str : str2;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Boolean getBool(java.lang.String str) {
        java.lang.String string = getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        return java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(string));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Float getFloat(java.lang.String str) {
        java.lang.String string = getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        return java.lang.Float.valueOf(java.lang.Float.parseFloat(string));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Integer getInteger(java.lang.String str) {
        java.lang.String string = getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        return java.lang.Integer.valueOf(java.lang.Integer.parseInt(string));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Long getLong(java.lang.String str) {
        java.lang.String string = getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        return java.lang.Long.valueOf(java.lang.Long.parseLong(string));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.String getString(java.lang.String str) {
        java.lang.String string = this.mStoreSp.getString(encryptValue(str), null);
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        return decryptValue(string);
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public boolean isExists(java.lang.String str) {
        return this.mStoreSp.contains(encryptValue(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void remove(java.lang.String str) {
        this.mStoreSp.edit().remove(encryptValue(str)).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setBool(java.lang.String str, boolean z) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(java.lang.String.valueOf(z))).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setFloat(java.lang.String str, float f) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(java.lang.String.valueOf(f))).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setInteger(java.lang.String str, int i) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(java.lang.String.valueOf(i))).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setLong(java.lang.String str, long j) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(java.lang.String.valueOf(j))).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setString(java.lang.String str, java.lang.String str2) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(str2)).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.String type() {
        return this.mFileName;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void upgrade(com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin) {
    }
}
