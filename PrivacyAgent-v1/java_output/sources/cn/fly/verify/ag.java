package cn.fly.verify;

/* loaded from: classes.dex */
public class ag {
    public static java.lang.String a() {
        java.lang.StringBuilder sb;
        int i;
        java.lang.String str = "";
        for (int i2 = 0; i2 < 32; i2++) {
            int nextInt = new java.util.Random(100L).nextInt() % 62;
            if (nextInt < 26) {
                str = str + (nextInt + 97);
            } else {
                if (nextInt < 52) {
                    sb = new java.lang.StringBuilder();
                    sb.append(str);
                    i = nextInt + 65;
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(str);
                    i = (nextInt + 48) - 26;
                }
                sb.append(i - 26);
                str = sb.toString();
            }
        }
        return str;
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            java.lang.String a = cn.fly.verify.al.a();
            if (android.text.TextUtils.isEmpty(a)) {
                return null;
            }
            int length = a.length() / 2;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                sb.append(a.substring(i * 2, i2 * 2));
                if (i < length - 1) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                }
                i = i2;
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String b = b(jSONObject.optString("aesKey"), str2);
            return b(jSONObject.optString("data"), b.substring(0, 16), b.substring(16));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str != null) {
            try {
                if (str.length() == 0 || str.trim().length() == 0 || str2 == null || str2.length() != 16 || str3.length() != 16) {
                    return null;
                }
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new javax.crypto.spec.SecretKeySpec(str2.getBytes("utf-8"), "AES"), new javax.crypto.spec.IvParameterSpec(str3.getBytes("utf-8")));
                return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0).replace("\n", "");
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.lang.StringBuilder sb;
        if (hashMap != null) {
            try {
                sb = new java.lang.StringBuilder();
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : hashMap.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.Object value = entry.getValue();
                    if (value != null && !android.text.TextUtils.isEmpty(key)) {
                        java.lang.String encode = java.net.URLEncoder.encode(value.toString(), "UTF-8");
                        sb.append(key);
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (java.lang.Exception unused) {
            }
            if (sb != null) {
                return null;
            }
            return sb.toString();
        }
        sb = null;
        if (sb != null) {
        }
    }

    public static java.security.PublicKey a(java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str.getBytes(), 0)));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static byte[] a(java.security.interfaces.RSAPublicKey rSAPublicKey, byte[] bArr) throws java.lang.Exception {
        if (rSAPublicKey == null) {
            throw new java.lang.Exception("public key is null");
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidKeyException unused) {
            throw new java.security.InvalidKeyException("InvalidKey");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.security.NoSuchAlgorithmException("NoSuchAlgorithm");
        } catch (javax.crypto.BadPaddingException unused3) {
            throw new javax.crypto.BadPaddingException("BadPadding");
        } catch (javax.crypto.IllegalBlockSizeException unused4) {
            throw new javax.crypto.IllegalBlockSizeException("IllegalBlockSize");
        } catch (javax.crypto.NoSuchPaddingException unused5) {
            throw new javax.crypto.NoSuchPaddingException("NoSuchPadding or not support this padding");
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(java.nio.charset.Charset.defaultCharset()));
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) a(str2);
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.Exception("rsaAes key is null");
        }
        return new java.lang.String(a(rSAPublicKey, android.util.Base64.decode(str, 0)), java.nio.charset.Charset.defaultCharset()).trim();
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() == 0 || str.trim().length() == 0) {
                return null;
            }
            if (str2 == null) {
                throw new java.lang.Exception("decrypt key is null");
            }
            if (str2.length() != 16) {
                throw new java.lang.Exception("decrypt key length error");
            }
            if (str3.length() != 16) {
                throw new java.lang.Exception(" iv decrypt key length error");
            }
            byte[] decode = android.util.Base64.decode(str, 0);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new javax.crypto.spec.SecretKeySpec(str2.getBytes("utf-8"), "AES"), new javax.crypto.spec.IvParameterSpec(str3.getBytes("utf-8")));
            return new java.lang.String(cipher.doFinal(decode), "utf-8");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) {
        try {
            java.security.PublicKey a = a(str);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, a);
            return android.util.Base64.encodeToString(cipher.doFinal(str2.getBytes(java.nio.charset.Charset.defaultCharset())), 0).replace("\n", "");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> d(java.lang.String str, java.lang.String str2) {
        java.lang.String a = a();
        java.lang.String substring = a.substring(0, 16);
        java.lang.String substring2 = a.substring(16, 32);
        java.lang.String a2 = a("{app:{\"c\":" + cn.fly.verify.fh.d.m() + ",\"md5\":\"" + a(cn.fly.verify.ax.g()) + "\", \"n\":\"" + cn.fly.verify.al.i() + "\",\"pk\":\"" + cn.fly.verify.fh.d.c() + "\",\"v\":\"" + cn.fly.verify.fh.d.f() + "\"},sdk: {\"c\":47,\"cm\":\"CUCC\",\"n\":\"SDKFactory\",\"v\":\"安卓4.0.3开放版Z21041415\"},device:{\"imei\":[],\"os\":\"Android\"},sim:[],data:{\"r\":" + java.lang.System.currentTimeMillis() + ",\"serviceType\":0,\"privateIp\":\"\",\"compatible\":\"2\",\"newVersion\":\"10\"}}", substring.trim(), substring2.trim());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(substring);
        sb.append(substring2);
        java.lang.String c = c(str2, sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append("/dro/netm/v1.0/qc?apiKey=");
        sb2.append(str);
        sb2.append("&params=");
        sb2.append(a2);
        sb2.append("&paramsKey=");
        sb2.append(c);
        java.lang.String b = b(sb2.toString());
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("apiKey", str);
        hashMap.put("params", a2);
        hashMap.put("paramsKey", c);
        java.util.HashMap hashMap2 = new java.util.HashMap(16);
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("sign", b);
            hashMap.put("sign_Type", "B");
            hashMap2.put("sign", b);
            hashMap2.put("api-protocol", "1.1");
        }
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap3 = new java.util.HashMap<>();
        hashMap3.put("params", hashMap);
        hashMap3.put("sign", hashMap2);
        return hashMap3;
    }
}
