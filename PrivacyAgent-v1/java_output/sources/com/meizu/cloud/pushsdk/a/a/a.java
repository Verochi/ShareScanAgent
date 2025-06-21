package com.meizu.cloud.pushsdk.a.a;

/* loaded from: classes23.dex */
public class a {
    private static com.meizu.cloud.pushsdk.a.a.a a;
    private static final java.lang.Object b = new java.lang.Object();
    private byte[] c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private java.security.PublicKey h;
    private final android.content.SharedPreferences i;
    private final android.content.SharedPreferences j;
    private long k = 0;

    private a(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("com.x.y.1", 0);
        this.i = sharedPreferences;
        this.j = context.getSharedPreferences("com.x.y.2", 0);
        java.lang.Integer.parseInt(sharedPreferences.getString("keyTimeout", "0"));
        sharedPreferences.getLong("createDate", 0L);
        e();
        byte[] bArr = this.c;
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = this.d;
            if (bArr2 == null || bArr2.length == 0) {
                java.security.PublicKey b2 = b(context);
                this.h = b2;
                if (b2 != null) {
                    h();
                    return;
                }
                return;
            }
            return;
        }
        java.security.PublicKey b3 = b(context);
        this.h = b3;
        if (b3 != null) {
            f();
            return;
        }
        sharedPreferences.edit().clear().apply();
        try {
            d();
            java.security.PublicKey b4 = b(context);
            this.h = b4;
            if (b4 != null) {
                f();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static com.meizu.cloud.pushsdk.a.a.a a() {
        com.meizu.cloud.pushsdk.a.a.a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        throw new java.lang.IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private java.lang.String a(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        try {
                            byteArrayOutputStream.close();
                            return byteArrayOutputStream2;
                        } catch (java.io.IOException unused) {
                            return byteArrayOutputStream2;
                        }
                    }
                    byteArrayOutputStream.write(read);
                } catch (java.io.IOException unused2) {
                    return null;
                }
            } catch (java.io.IOException unused3) {
                byteArrayOutputStream.close();
                return null;
            } catch (java.lang.Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException unused4) {
                }
                throw th;
            }
        }
    }

    public static void a(android.content.Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new com.meizu.cloud.pushsdk.a.a.a(context);
                }
            }
        }
    }

    private java.security.PublicKey b(android.content.Context context) {
        b("load publicKey from preference");
        java.lang.String string = this.j.getString("publicKey", "");
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(string, 2)));
        } catch (java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void b(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.d("HttpKeyMgr", str);
    }

    private void c(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.e("HttpKeyMgr", str);
    }

    private void d() throws java.io.IOException {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(com.meizu.cloud.pushsdk.constants.PushConstants.URL_DOWNLOAD_PUBLIC_KEY).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (java.net.ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            java.io.InputStream inputStream = null;
            try {
                b("code = " + httpURLConnection.getResponseCode());
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    java.lang.String a2 = a(inputStream);
                    b("body = " + a2);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(a2);
                            if (jSONObject.getInt("code") == 200) {
                                java.lang.String string = jSONObject.getString("value");
                                android.content.SharedPreferences.Editor edit = this.j.edit();
                                edit.putString("publicKey", string);
                                edit.apply();
                            }
                        } catch (java.lang.Exception e2) {
                            c("downloadPublicKey message error " + e2.getMessage());
                        }
                    }
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                httpURLConnection.disconnect();
            }
        } catch (java.net.MalformedURLException unused2) {
        }
    }

    private void e() {
        b("loadKeys");
        java.lang.String string = this.i.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!android.text.TextUtils.isEmpty(string)) {
            this.g = string.getBytes();
        }
        java.lang.String string2 = this.i.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!android.text.TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.f = bytes;
            this.d = android.util.Base64.decode(bytes, 2);
        }
        java.lang.String string3 = this.i.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (android.text.TextUtils.isEmpty(string3)) {
            return;
        }
        byte[] bytes2 = string3.getBytes();
        this.e = bytes2;
        this.c = android.util.Base64.decode(bytes2, 2);
        b("saved rKey: " + new java.lang.String(this.c));
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            this.c = encoded;
            this.e = android.util.Base64.encode(encoded, 2);
            b("***** rKey64: " + new java.lang.String(this.e));
            android.content.SharedPreferences.Editor edit = this.i.edit();
            edit.putString("rKey64", new java.lang.String(this.e));
            edit.apply();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void h() {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.h);
            byte[] doFinal = cipher.doFinal(this.c);
            this.d = doFinal;
            this.f = android.util.Base64.encode(doFinal, 2);
            b("***** aKey64: " + new java.lang.String(this.f));
            android.content.SharedPreferences.Editor edit = this.i.edit();
            edit.putString("aKey64", new java.lang.String(this.f));
            edit.apply();
        } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.BadPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public void a(java.lang.String str) {
        this.g = str.getBytes();
        android.content.SharedPreferences.Editor edit = this.i.edit();
        edit.putString("sKey64", new java.lang.String(this.g));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        java.lang.String str;
        byte[] bArr2 = this.c;
        if (bArr2 == null || bArr2.length == 0) {
            str = "rKey null!";
        } else {
            if (bArr != null && bArr.length != 0) {
                b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new java.lang.String(android.util.Base64.encode(bArr, 2)));
                b("<<<<<<<<<< encrypt input <<<<<<<<<<");
                try {
                    javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, new javax.crypto.spec.SecretKeySpec(this.c, "AES"), new javax.crypto.spec.IvParameterSpec(this.c));
                    byte[] doFinal = cipher.doFinal(bArr);
                    b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new java.lang.String(android.util.Base64.encode(doFinal, 2)));
                    b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                    return doFinal;
                } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.BadPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.NoSuchPaddingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            str = "input null!";
        }
        c(str);
        return null;
    }

    public byte[] b() {
        return this.f;
    }

    public byte[] c() {
        return this.g;
    }
}
