package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
public final class a {
    private final java.lang.Object a = new java.lang.Object();
    private final java.lang.Object b = new java.lang.Object();

    @android.annotation.TargetApi(18)
    private java.security.KeyPair a(android.content.Context context, java.lang.String str) throws java.security.NoSuchProviderException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException {
        java.security.spec.AlgorithmParameterSpec build;
        java.security.KeyPair generateKeyPair;
        android.security.keystore.KeyGenParameterSpec.Builder blockModes;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        synchronized (this.b) {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                blockModes = new android.security.keystore.KeyGenParameterSpec.Builder(str, 3).setBlockModes("ECB");
                encryptionPaddings = blockModes.setEncryptionPaddings("PKCS1Padding");
                keySize = encryptionPaddings.setKeySize(1024);
                build = keySize.build();
            } else {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                java.util.Calendar calendar2 = java.util.Calendar.getInstance();
                calendar2.add(1, 30);
                build = new android.security.KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new javax.security.auth.x500.X500Principal("CN=".concat(java.lang.String.valueOf(str)))).setSerialNumber(java.math.BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            }
            keyPairGenerator.initialize(build);
            generateKeyPair = keyPairGenerator.generateKeyPair();
        }
        return generateKeyPair;
    }

    @android.annotation.TargetApi(18)
    public final java.security.KeyPair a(android.content.Context context, java.lang.String str, boolean z) throws java.security.KeyStoreException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.UnrecoverableKeyException, java.security.NoSuchProviderException, java.security.InvalidAlgorithmParameterException {
        synchronized (this.b) {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias(str) || !z) {
                return new java.security.KeyPair(keyStore.getCertificate(str).getPublicKey(), (java.security.PrivateKey) keyStore.getKey(str, null));
            }
            return a(context, str);
        }
    }

    @android.annotation.TargetApi(23)
    public final javax.crypto.SecretKey a(java.lang.String str) throws java.security.KeyStoreException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.UnrecoverableKeyException, java.security.NoSuchProviderException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.SecretKey secretKey;
        synchronized (this.a) {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.containsAlias(str);
            secretKey = (javax.crypto.SecretKey) keyStore.getKey(str, null);
        }
        return secretKey;
    }
}
