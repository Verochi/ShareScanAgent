package com.sensorsdata.analytics.android.sdk.encrypt.encryptor;

/* loaded from: classes19.dex */
public enum SymmetricEncryptMode {
    AES("AES", "AES/CBC/PKCS5Padding"),
    SM4("SM4", "SM4/CBC/PKCS5Padding");

    public java.lang.String algorithm;
    public java.lang.String transformation;

    SymmetricEncryptMode(java.lang.String str, java.lang.String str2) {
        this.algorithm = str;
        this.transformation = str2;
    }
}
