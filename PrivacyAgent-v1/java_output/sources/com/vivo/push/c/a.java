package com.vivo.push.c;

/* loaded from: classes19.dex */
public final class a implements com.vivo.push.c.c {
    private java.security.KeyStore a;
    private javax.crypto.SecretKey b;

    public a() {
        a();
        b();
    }

    private void a() {
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            this.a = keyStore;
            keyStore.load(null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("AesSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    private javax.crypto.SecretKey b() {
        javax.crypto.SecretKey d;
        android.security.keystore.KeyGenParameterSpec.Builder blockModes;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        android.security.keystore.KeyGenParameterSpec build;
        try {
            javax.crypto.SecretKey secretKey = this.b;
            if (secretKey != null) {
                return secretKey;
            }
            if (c()) {
                d = d();
            } else {
                javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES", "AndroidKeyStore");
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    blockModes = new android.security.keystore.KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM");
                    encryptionPaddings = blockModes.setEncryptionPaddings("NoPadding");
                    keySize = encryptionPaddings.setKeySize(256);
                    build = keySize.build();
                    keyGenerator.init(build);
                }
                d = keyGenerator.generateKey();
            }
            this.b = d;
            return this.b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("AesSecurity", "getSecretKey error" + e.getMessage());
            return null;
        }
    }

    private boolean c() {
        try {
            if (this.a == null) {
                a();
            }
            return this.a.containsAlias("AesKeyAlias");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("AesSecurity", "hasAESKey error" + e.getMessage());
            return false;
        }
    }

    private javax.crypto.SecretKey d() {
        try {
            return ((java.security.KeyStore.SecretKeyEntry) this.a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("AesSecurity", "getAESSecretKey error" + e.getMessage());
            return null;
        }
    }
}
