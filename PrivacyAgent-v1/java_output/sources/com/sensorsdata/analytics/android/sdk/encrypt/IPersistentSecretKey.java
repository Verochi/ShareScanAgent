package com.sensorsdata.analytics.android.sdk.encrypt;

/* loaded from: classes19.dex */
public interface IPersistentSecretKey {
    com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey();

    void saveSecretKey(com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey);
}
