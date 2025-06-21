package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

/* loaded from: classes19.dex */
public interface StorePlugin {
    java.lang.Boolean getBool(java.lang.String str);

    java.lang.Float getFloat(java.lang.String str);

    java.lang.Integer getInteger(java.lang.String str);

    java.lang.Long getLong(java.lang.String str);

    java.lang.String getString(java.lang.String str);

    boolean isExists(java.lang.String str);

    void remove(java.lang.String str);

    void setBool(java.lang.String str, boolean z);

    void setFloat(java.lang.String str, float f);

    void setInteger(java.lang.String str, int i);

    void setLong(java.lang.String str, long j);

    void setString(java.lang.String str, java.lang.String str2);

    java.lang.String type();

    void upgrade(com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin);
}
