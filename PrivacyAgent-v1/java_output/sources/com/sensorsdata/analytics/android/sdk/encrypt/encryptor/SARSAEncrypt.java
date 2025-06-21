package com.sensorsdata.analytics.android.sdk.encrypt.encryptor;

/* loaded from: classes19.dex */
public class SARSAEncrypt extends com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt {
    byte[] aesKey;
    java.lang.String mEncryptKey;

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener
    public java.lang.String asymmetricEncryptType() {
        return com.alipay.sdk.m.n.d.a;
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt
    public java.lang.String decryptEventRecord(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().decryptAES(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener
    public java.lang.String encryptEvent(byte[] bArr) {
        return com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils.symmetricEncrypt(this.aesKey, bArr, com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SymmetricEncryptMode.AES);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt
    public java.lang.String encryptEventRecord(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().encryptAES(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener
    public java.lang.String encryptSymmetricKeyWithPublicKey(java.lang.String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils.generateSymmetricKey(com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils.encryptAESKey(str, generateSymmetricKey, com.alipay.sdk.m.n.d.a);
            } catch (java.security.NoSuchAlgorithmException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }
        return this.mEncryptKey;
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener
    public java.lang.String symmetricEncryptType() {
        return "AES";
    }
}
