package com.sensorsdata.analytics.android.sdk.encrypt;

/* loaded from: classes19.dex */
public class SecreteKey {
    public java.lang.String asymmetricEncryptType;
    public java.lang.String key;
    public java.lang.String symmetricEncryptType;
    public int version;

    public SecreteKey(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        this.key = str;
        this.version = i;
        this.symmetricEncryptType = str2;
        this.asymmetricEncryptType = str3;
    }

    public java.lang.String toString() {
        return "{\"key\":\"" + this.key + "\",\"version\":\"" + this.version + "\",\"symmetricEncryptType\":\"" + this.symmetricEncryptType + "\",\"asymmetricEncryptType\":\"" + this.asymmetricEncryptType + "\"}";
    }
}
