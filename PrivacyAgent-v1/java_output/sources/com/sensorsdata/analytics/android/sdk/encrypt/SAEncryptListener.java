package com.sensorsdata.analytics.android.sdk.encrypt;

/* loaded from: classes19.dex */
public interface SAEncryptListener {
    java.lang.String asymmetricEncryptType();

    java.lang.String encryptEvent(byte[] bArr);

    java.lang.String encryptSymmetricKeyWithPublicKey(java.lang.String str);

    java.lang.String symmetricEncryptType();
}
