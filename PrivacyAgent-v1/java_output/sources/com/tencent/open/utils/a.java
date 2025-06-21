package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class a {
    private java.security.KeyStore a;
    private android.content.SharedPreferences b;

    public a(android.content.Context context) {
        try {
            this.b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            this.a = keyStore;
            keyStore.load(null);
            if (this.a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            c("");
            a(context);
            a();
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.d("KEYSTORE", "Exception", e);
        }
    }

    private void a() throws java.lang.Exception {
        byte[] bArr = new byte[16];
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        secureRandom.nextBytes(bArr);
        c(android.util.Base64.encodeToString(secureRandom.generateSeed(12), 0));
        java.security.PublicKey publicKey = this.a.getCertificate("KEYSTORE_AES").getPublicKey();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        d(android.util.Base64.encodeToString(cipher.doFinal(bArr), 0));
    }

    private void a(android.content.Context context) throws java.lang.Exception {
        android.security.keystore.KeyGenParameterSpec.Builder digests;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec build;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i = android.os.Build.VERSION.SDK_INT;
        sb.append(i);
        com.tencent.open.log.SLog.d("KEYSTORE", sb.toString());
        if (i >= 23) {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
            digests = new android.security.keystore.KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512");
            encryptionPaddings = digests.setEncryptionPaddings("PKCS1Padding");
            build = encryptionPaddings.build();
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
            return;
        }
        java.security.KeyPairGenerator keyPairGenerator2 = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.add(1, 30);
        keyPairGenerator2.initialize(new android.security.KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new javax.security.auth.x500.X500Principal("CN=KEYSTORE_AES")).setSerialNumber(java.math.BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
        keyPairGenerator2.generateKeyPair();
    }

    private byte[] b() {
        return android.util.Base64.decode(this.b.getString("PREF_KEY_IV", ""), 0);
    }

    private javax.crypto.spec.SecretKeySpec c() throws java.lang.Exception {
        java.lang.String string = this.b.getString("PREF_KEY_AES", "");
        java.security.PrivateKey privateKey = (java.security.PrivateKey) this.a.getKey("KEYSTORE_AES", null);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        return new javax.crypto.spec.SecretKeySpec(cipher.doFinal(android.util.Base64.decode(string, 0)), "AES/GCM/NoPadding");
    }

    private void c(java.lang.String str) {
        this.b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(java.lang.String str) {
        this.b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public java.lang.String a(java.lang.String str) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, c(), new javax.crypto.spec.IvParameterSpec(b()));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    public java.lang.String b(java.lang.String str) {
        try {
            byte[] decode = android.util.Base64.decode(str.getBytes(), 0);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, c(), new javax.crypto.spec.IvParameterSpec(b()));
            return new java.lang.String(cipher.doFinal(decode));
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }
}
