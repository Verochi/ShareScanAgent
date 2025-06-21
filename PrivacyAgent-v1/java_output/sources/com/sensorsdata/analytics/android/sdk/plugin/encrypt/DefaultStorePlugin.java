package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

/* loaded from: classes19.dex */
public abstract class DefaultStorePlugin implements com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin {
    private final java.lang.String mFileName;
    private final android.content.SharedPreferences mStoreSp;

    public DefaultStorePlugin(android.content.Context context, java.lang.String str) {
        this.mStoreSp = com.sensorsdata.analytics.android.sdk.util.SASpUtils.getSharedPreferences(context, str, 0);
        this.mFileName = str;
    }

    private java.lang.String getKey(java.lang.String str) {
        return str.replaceFirst(type(), "");
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Boolean getBool(java.lang.String str) {
        if (isExists(str)) {
            return java.lang.Boolean.valueOf(this.mStoreSp.getBoolean(getKey(str), false));
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Float getFloat(java.lang.String str) {
        if (isExists(str)) {
            return java.lang.Float.valueOf(this.mStoreSp.getFloat(getKey(str), 0.0f));
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Integer getInteger(java.lang.String str) {
        if (isExists(str)) {
            return java.lang.Integer.valueOf(this.mStoreSp.getInt(getKey(str), 0));
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.Long getLong(java.lang.String str) {
        if (isExists(str)) {
            return java.lang.Long.valueOf(this.mStoreSp.getLong(getKey(str), 0L));
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.String getString(java.lang.String str) {
        if (isExists(str)) {
            return this.mStoreSp.getString(getKey(str), null);
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public boolean isExists(java.lang.String str) {
        return this.mStoreSp.contains(getKey(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void remove(java.lang.String str) {
        this.mStoreSp.edit().remove(getKey(str)).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setBool(java.lang.String str, boolean z) {
        this.mStoreSp.edit().putBoolean(getKey(str), z).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setFloat(java.lang.String str, float f) {
        this.mStoreSp.edit().putFloat(getKey(str), f).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setInteger(java.lang.String str, int i) {
        this.mStoreSp.edit().putInt(getKey(str), i).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setLong(java.lang.String str, long j) {
        this.mStoreSp.edit().putLong(getKey(str), j).apply();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void setString(java.lang.String str, java.lang.String str2) {
        this.mStoreSp.edit().putString(getKey(str), str2).apply();
    }

    public abstract java.util.List<java.lang.String> storeKeys();

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public java.lang.String type() {
        return this.mFileName;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin
    public void upgrade(com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin) {
    }
}
