package com.vivo.push.c;

/* loaded from: classes19.dex */
public final class e implements com.vivo.push.c.b {
    private static java.security.PrivateKey a;
    private static java.security.PublicKey b;
    private static java.security.KeyStore c;
    private static javax.security.auth.x500.X500Principal d;
    private android.content.Context e;

    public e(android.content.Context context) {
        this.e = context;
        try {
            b();
            a(context);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    private static void a(android.content.Context context) {
        try {
            if (context == null) {
                com.vivo.push.util.p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            if (b("PushRsaKeyAlias")) {
                com.vivo.push.util.p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
                return;
            }
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.add(1, 999);
            android.security.KeyPairGeneratorSpec build = new android.security.KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(d).setSerialNumber(java.math.BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    private static java.security.PrivateKey b(android.content.Context context) {
        java.security.PrivateKey privateKey;
        try {
            privateKey = a;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            com.vivo.push.util.p.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        if (!b("PushRsaKeyAlias")) {
            a(context);
        }
        java.security.KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof java.security.KeyStore.PrivateKeyEntry) {
            java.security.PrivateKey privateKey2 = ((java.security.KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private static void b() {
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            c = keyStore;
            keyStore.load(null);
            d = new javax.security.auth.x500.X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    private static boolean b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (c == null) {
                b();
            }
            return c.containsAlias(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.b
    public final java.lang.String a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || b(this.e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            java.security.PrivateKey b2 = b(this.e);
            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
            signature.initSign(b2);
            signature.update(bytes);
            java.lang.String encodeToString = android.util.Base64.encodeToString(signature.sign(), 2);
            com.vivo.push.util.p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.c.b
    public final java.security.PublicKey a() {
        java.security.PublicKey publicKey;
        try {
            publicKey = b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
        }
        if (publicKey != null) {
            return publicKey;
        }
        if (!b("PushRsaKeyAlias")) {
            a(this.e);
        }
        java.security.KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof java.security.KeyStore.PrivateKeyEntry) {
            java.security.PublicKey publicKey2 = ((java.security.KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            b = publicKey2;
            return publicKey2;
        }
        return null;
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, java.security.PublicKey publicKey, byte[] bArr2) {
        try {
            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }
}
