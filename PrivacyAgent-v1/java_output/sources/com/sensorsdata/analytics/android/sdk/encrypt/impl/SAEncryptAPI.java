package com.sensorsdata.analytics.android.sdk.encrypt.impl;

/* loaded from: classes19.dex */
public interface SAEncryptAPI {
    java.lang.String decryptAES(java.lang.String str);

    java.lang.String encryptAES(java.lang.String str);

    <T> T encryptEventData(T t);

    <T> T encryptEventData(T t, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey);

    java.lang.String loadSecretKey();

    void storeSecretKey(java.lang.String str);

    java.lang.String verifySecretKey(android.net.Uri uri);
}
