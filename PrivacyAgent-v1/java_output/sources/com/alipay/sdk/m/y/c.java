package com.alipay.sdk.m.y;

/* loaded from: classes.dex */
public final class c {
    public static java.lang.String a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    public static java.lang.String a() {
        java.lang.String str = new java.lang.String();
        for (int i = 0; i < a.length() - 1; i += 4) {
            str = str + a.charAt(i);
        }
        return str;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            javax.crypto.spec.PBEKeySpec a2 = a(str);
            byte[] bytes = str2.getBytes();
            byte[] b = b();
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(b));
            byte[] salt = a2.getSalt();
            java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
            allocate.put(salt);
            cipher.doFinal(java.nio.ByteBuffer.wrap(bytes), allocate);
            return a(allocate.array());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }

    public static javax.crypto.spec.PBEKeySpec a(java.lang.String str) {
        java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(com.alipay.sdk.m.y.a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        java.lang.Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        java.lang.reflect.Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new javax.crypto.spec.PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        byte[] doFinal;
        try {
            javax.crypto.spec.PBEKeySpec a2 = a(str);
            int length = str2.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = java.lang.Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
            }
            byte[] b = b();
            if (length <= 16) {
                doFinal = null;
            } else {
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new javax.crypto.spec.PBEKeySpec(a2.getPassword(), java.util.Arrays.copyOf(bArr, 16), 10, 128)).getEncoded(), "AES");
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(b));
                doFinal = cipher.doFinal(bArr, 16, length - 16);
            }
        } catch (java.lang.Exception unused) {
        }
        if (doFinal == null) {
            throw new java.lang.Exception();
        }
        java.lang.String str3 = new java.lang.String(doFinal);
        if (com.alipay.sdk.m.z.a.c(str3)) {
            return str3;
        }
        return null;
    }

    public static byte[] b() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < 48; i += 2) {
                sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i));
            }
            return com.alipay.sdk.m.y.a.a(sb.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
