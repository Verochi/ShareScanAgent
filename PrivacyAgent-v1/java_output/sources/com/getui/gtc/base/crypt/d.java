package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
public final class d {
    com.getui.gtc.base.crypt.a a;
    com.getui.gtc.base.crypt.c b;
    java.util.Map<java.lang.String, javax.crypto.SecretKey> c = new java.util.HashMap();
    java.util.Map<java.lang.String, javax.crypto.SecretKey> d = new java.util.HashMap();
    java.util.Map<java.lang.String, java.security.KeyPair> e = new java.util.HashMap();
    java.util.Map<java.lang.String, javax.crypto.spec.IvParameterSpec> f = new java.util.HashMap();
    java.lang.String g;

    private java.security.KeyPair d(java.lang.String str) {
        try {
            java.lang.String digestToHexString = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + "-rsa1024alias").getBytes());
            if (this.e.containsKey(digestToHexString)) {
                return this.e.get(digestToHexString);
            }
            java.security.KeyPair a = this.a.a(null, digestToHexString, false);
            if (a == null) {
                return null;
            }
            this.e.put(digestToHexString, a);
            return a;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final java.util.List<com.getui.gtc.base.crypt.CryptException> a(android.content.Context context) throws com.getui.gtc.base.crypt.CryptException {
        javax.crypto.SecretKey secretKey;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.g = java.lang.String.valueOf(android.os.Process.myPid());
        java.lang.String str = this.g + "-rsa1024alias";
        java.lang.String str2 = this.g + "-aes128alias";
        java.lang.String str3 = this.g + "-ivalias";
        java.lang.String digestToHexString = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", str.getBytes());
        java.lang.String digestToHexString2 = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", str2.getBytes());
        java.lang.String digestToHexString3 = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", str3.getBytes());
        com.getui.gtc.base.crypt.a aVar = new com.getui.gtc.base.crypt.a();
        this.a = aVar;
        try {
            java.security.KeyPair a = aVar.a(context, digestToHexString, true);
            this.e.put(digestToHexString, a);
            com.getui.gtc.base.crypt.c cVar = new com.getui.gtc.base.crypt.c(context, a);
            this.b = cVar;
            secretKey = cVar.a(digestToHexString2);
        } catch (java.lang.Throwable th) {
            arrayList.add(new com.getui.gtc.base.crypt.CryptException("above api 18, but second secret key create failed with android key store!", th));
            secretKey = null;
        }
        if (secretKey == null) {
            try {
                com.getui.gtc.base.crypt.c cVar2 = new com.getui.gtc.base.crypt.c(context, null);
                this.b = cVar2;
                secretKey = cVar2.a(digestToHexString2);
            } catch (java.lang.Throwable th2) {
                throw new com.getui.gtc.base.crypt.CryptException("second secret key create failed!", th2);
            }
        }
        this.d.put(digestToHexString2, secretKey);
        try {
            com.getui.gtc.base.crypt.c cVar3 = this.b;
            javax.crypto.spec.IvParameterSpec b = cVar3.b(digestToHexString3, true, cVar3.a);
            if (b == null) {
                throw new com.getui.gtc.base.crypt.CryptException("iv parameter spec create failed!");
            }
            this.f.put(digestToHexString3, b);
            return arrayList;
        } catch (java.lang.Throwable th3) {
            throw new com.getui.gtc.base.crypt.CryptException("iv parameter spec create failed!", th3);
        }
    }

    public final javax.crypto.SecretKey a() {
        return b(this.g);
    }

    public final javax.crypto.SecretKey a(java.lang.String str) {
        try {
            java.lang.String digestToHexString = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + "-aes128alias").getBytes());
            if (this.c.containsKey(digestToHexString)) {
                return this.c.get(digestToHexString);
            }
            javax.crypto.SecretKey a = this.a.a(digestToHexString);
            if (a == null) {
                return null;
            }
            this.c.put(digestToHexString, a);
            return a;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final javax.crypto.SecretKey b(java.lang.String str) {
        try {
            java.lang.String digestToHexString = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + "-aes128alias").getBytes());
            if (this.d.containsKey(digestToHexString)) {
                return this.d.get(digestToHexString);
            }
            javax.crypto.SecretKey a = this.b.a(digestToHexString, false, d(str));
            if (a == null) {
                return null;
            }
            this.d.put(digestToHexString, a);
            return a;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final javax.crypto.spec.IvParameterSpec b() {
        return c(this.g);
    }

    public final javax.crypto.spec.IvParameterSpec c(java.lang.String str) {
        try {
            java.lang.String digestToHexString = com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + "-ivalias").getBytes());
            if (this.f.containsKey(digestToHexString)) {
                return this.f.get(digestToHexString);
            }
            javax.crypto.spec.IvParameterSpec b = this.b.b(digestToHexString, false, d(str));
            if (b == null) {
                return null;
            }
            this.f.put(digestToHexString, b);
            return b;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
