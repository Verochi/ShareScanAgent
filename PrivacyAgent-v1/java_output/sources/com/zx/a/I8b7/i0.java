package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class i0 {
    public static com.zx.a.I8b7.o2 a;
    public static final java.lang.String[] b;

    static {
        g();
        b = h();
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        a(stringBuffer);
        stringBuffer.append("BE");
        stringBuffer.append("GIN ");
        stringBuffer.append("CE");
        stringBuffer.append("RT");
        stringBuffer.append("IFIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(str.getBytes(java.nio.charset.StandardCharsets.UTF_8)), java.nio.charset.StandardCharsets.UTF_8));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.trim().equals("")) {
                    sb.append(readLine.substring(0, readLine.length() - 5));
                }
            }
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
        }
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        a(stringBuffer);
        stringBuffer.append("EN");
        stringBuffer.append("D ");
        stringBuffer.append("CE");
        stringBuffer.append("RTI");
        stringBuffer.append("FIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static org.json.JSONObject a() throws org.json.JSONException {
        java.lang.String str;
        java.lang.Exception e;
        android.content.pm.Signature[] a2;
        java.security.MessageDigest messageDigest;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("appPkg", com.zx.a.I8b7.m3.g);
        java.lang.String str2 = "error!";
        try {
            a2 = com.zx.a.I8b7.d.a(com.zx.a.I8b7.m3.g);
        } catch (java.lang.Exception e2) {
            str = "error!";
            e = e2;
        }
        if (a2 != null) {
            str = "error!";
            for (android.content.pm.Signature signature : a2) {
                try {
                    byte[] byteArray = signature.toByteArray();
                    try {
                        messageDigest = java.security.MessageDigest.getInstance("MD5");
                    } catch (java.security.NoSuchAlgorithmException e3) {
                        com.zx.a.I8b7.r2.a(e3);
                    }
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str = sb.toString();
                    }
                    str = "error!";
                } catch (java.lang.Exception e4) {
                    e = e4;
                    com.zx.a.I8b7.r2.a(e);
                    str2 = str;
                    jSONObject.put("appSign", str2);
                    jSONObject.put(com.anythink.expressad.videocommon.e.b.u, com.zx.a.I8b7.m3.f);
                    return jSONObject;
                }
            }
            str2 = str;
        }
        jSONObject.put("appSign", str2);
        jSONObject.put(com.anythink.expressad.videocommon.e.b.u, com.zx.a.I8b7.m3.f);
        return jSONObject;
    }

    public static void a(java.lang.StringBuffer stringBuffer) {
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
    }

    public static void a(java.net.HttpURLConnection httpURLConnection) throws java.security.cert.CertificateException, java.io.IOException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
        httpURLConnection.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
        if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(c());
            httpsURLConnection.setHostnameVerifier(com.zx.a.I8b7.n2.a);
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> b(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("UDID-LID", com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
        java.lang.String str2 = com.zx.a.I8b7.m3.i;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("UDID-ZID", str2);
        try {
            java.lang.String str3 = new java.lang.String(android.util.Base64.encode(a().toString().getBytes(java.nio.charset.StandardCharsets.UTF_8), 2), java.nio.charset.StandardCharsets.UTF_8);
            com.zx.a.I8b7.r2.a("ZXID 请求 header 中的 appInfo: ".concat(str3));
            hashMap.put("UDID-APP-INFO", str3);
            java.lang.String str4 = new java.lang.String(android.util.Base64.encode(e().toString().getBytes(java.nio.charset.StandardCharsets.UTF_8), 2), java.nio.charset.StandardCharsets.UTF_8);
            com.zx.a.I8b7.r2.a("ZXID 请求 header 中的 sdkInfoBase: ".concat(str4));
            hashMap.put("UDID-SDK-INFO-BASE", str4);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXID 请求 header 创建异常: ");
            a2.append(e.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
        }
        hashMap.put("UDID-PROTOCOL", "v3.0.0");
        hashMap.put("UDID-KEY", str);
        return hashMap;
    }

    public static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("applicationId", com.zx.a.I8b7.m3.g);
            android.content.pm.PackageManager packageManager = com.zx.a.I8b7.w3.a;
            jSONObject.put("country", java.util.Locale.getDefault().getCountry());
            jSONObject.put("language", java.util.Locale.getDefault().getLanguage());
            jSONObject.put("model", android.os.Build.MODEL);
            jSONObject.put("arch", com.zx.a.I8b7.w3.c());
            jSONObject.put("androidVersion", com.zx.a.I8b7.w3.a("59"));
        } catch (org.json.JSONException e) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXID 构建deviceInfo异常:");
            a2.append(e.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
        }
        return jSONObject;
    }

    public static javax.net.ssl.SSLSocketFactory c() throws java.security.cert.CertificateException, java.io.IOException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        java.security.cert.X509Certificate f = f();
        if (f == null) {
            throw new java.security.cert.CertificateException("getCurEnvCA is null");
        }
        java.security.KeyStore keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", f);
        javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 24 || i > 26) {
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        } else {
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{new com.zx.a.I8b7.h0()}, null);
        }
        return sSLContext.getSocketFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static org.json.JSONObject d() {
        int i;
        org.json.JSONObject e = e();
        try {
            com.zx.a.I8b7.u3 u3Var = com.zx.a.I8b7.l2.a.a.a;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("debug", com.zx.a.I8b7.w3.i() ? 1 : 0);
            jSONObject.put("permission", u3Var.h());
            jSONObject.put("enable", u3Var.f());
            jSONObject.put("showPermissionDialog", u3Var.e());
            e.put("userSettings", jSONObject);
            com.zx.a.I8b7.e1 e1Var = com.zx.a.I8b7.e1.a.a;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("pts", e1Var.a);
                jSONObject2.put("pid", e1Var.b);
                jSONObject2.put(com.anythink.core.common.h.c.R, e1Var.c);
            } catch (java.lang.Exception e2) {
                com.zx.a.I8b7.r2.a(e2);
            }
            e.put("processInfo", jSONObject2);
            try {
                i = com.zx.a.I8b7.x1.b(com.zx.a.I8b7.m3.a).getBoolean("ZX_IS_PRIVACY");
            } catch (android.content.pm.PackageManager.NameNotFoundException e3) {
                com.zx.a.I8b7.r2.a(e3);
                i = 0;
            }
            e.put("privacy", i);
            e.put("appIds", com.zx.a.I8b7.x1.a());
        } catch (org.json.JSONException e4) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXID 构建SDKInfo异常:");
            a2.append(e4.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
        }
        return e;
    }

    public static org.json.JSONObject e() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", com.zx.a.I8b7.m3.b);
            jSONObject.put("configVersion", com.zx.a.I8b7.m3.o);
            if (android.text.TextUtils.equals("core-d", com.zx.a.I8b7.m3.c)) {
                jSONObject.put("versiond", com.zx.a.I8b7.m3.d);
            }
            jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, com.zx.a.I8b7.m3.e);
            jSONObject.put("arch", android.os.Build.CPU_ABI);
        } catch (org.json.JSONException e) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXID 构建SDKInfoBase异常:");
            a2.append(e.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
        }
        return jSONObject;
    }

    public static java.security.cert.X509Certificate f() throws java.security.cert.CertificateException {
        return (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(a(b[0]).getBytes()));
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String[] g();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String[] h();
}
