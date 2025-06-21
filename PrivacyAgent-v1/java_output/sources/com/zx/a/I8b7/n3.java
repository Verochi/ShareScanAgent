package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class n3 {
    public final java.lang.String[] a = f();
    public final java.lang.String[] b = d();
    public final java.lang.String[] c = c();

    @android.annotation.SuppressLint({"NewApi"})
    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public com.zx.module.base.Callback b;
        public java.util.TimerTask d;
        public org.json.JSONObject e;
        public int f;
        public final java.util.concurrent.atomic.AtomicBoolean g = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer c = new java.util.Timer();

        /* renamed from: com.zx.a.I8b7.n3$a$a, reason: collision with other inner class name */
        public class C0539a extends java.util.TimerTask {
            public C0539a(com.zx.a.I8b7.n3 n3Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.n3.a aVar = com.zx.a.I8b7.n3.a.this;
                    com.zx.module.base.Callback callback = aVar.b;
                    if (callback != null) {
                        callback.callback(com.zx.a.I8b7.n3.this.a("wifi 情况下切换数据网络超时, 检查是否打开数据网络!", 1));
                    }
                } catch (org.json.JSONException e) {
                    com.zx.a.I8b7.r2.a(e);
                }
            }
        }

        public a(org.json.JSONObject jSONObject, android.net.ConnectivityManager connectivityManager, com.zx.module.base.Callback callback, int i) {
            this.e = jSONObject;
            this.f = i;
            this.a = connectivityManager;
            this.b = callback;
            com.zx.a.I8b7.n3.a.C0539a c0539a = new com.zx.a.I8b7.n3.a.C0539a(com.zx.a.I8b7.n3.this);
            this.d = c0539a;
            this.c.schedule(c0539a, 7000L);
        }

        @com.zx.module.annotation.Java2C.Method2C
        private native void a(android.net.Network network, java.lang.String str);

        public final void a(android.net.Network network) throws java.lang.Throwable {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(com.zx.a.I8b7.n3.this.b[0]));
            httpURLConnection.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            org.json.JSONObject a = com.zx.a.I8b7.n3.this.a();
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(a.toString());
            bufferedWriter.close();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b()).getJSONObject("body");
            java.lang.String string = jSONObject.getString("resultCode");
            java.lang.String string2 = jSONObject.getString("resultDesc");
            httpURLConnection.disconnect();
            if ("103000".equals(string) && "成功".equals(string2)) {
                com.zx.a.I8b7.n3.this.a(this.e, this.b, this.f, "cmcc", jSONObject.getString("token"), null);
            } else {
                this.b.callback(com.zx.a.I8b7.n3.this.b(jSONObject.toString()));
            }
        }

        public final void b(android.net.Network network) throws java.lang.Throwable {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(com.zx.a.I8b7.n3.this.c[0]));
            httpURLConnection.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            java.lang.String substring = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").substring(0, 16);
            java.lang.String a = com.zx.a.I8b7.n3.this.a(substring);
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(a);
            bufferedWriter.close();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b(""), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            httpURLConnection.disconnect();
            java.lang.String string = jSONObject.getString("msg");
            int i = jSONObject.getInt("result");
            java.lang.String optString = jSONObject.optString("data");
            if (i == 0 && "success".equals(string) && !android.text.TextUtils.isEmpty(optString)) {
                com.zx.a.I8b7.n3.this.a(this.e, this.b, this.f, com.anythink.expressad.d.a.b.dx, com.zx.a.I8b7.n3.this.a(substring, optString), null);
            } else {
                this.b.callback(com.zx.a.I8b7.n3.this.b(jSONObject.toString()));
            }
        }

        public final void c(android.net.Network network) throws java.lang.Throwable {
            com.zx.a.I8b7.n3 n3Var = com.zx.a.I8b7.n3.this;
            java.lang.String c = n3Var.c(n3Var.a[0]);
            com.zx.a.I8b7.r2.a("unicomUAIDNisportalUrl: ".concat(java.lang.String.valueOf(c)));
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(c));
            httpURLConnection.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.connect();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            java.lang.String optString = jSONObject.optString("authurl");
            if (android.text.TextUtils.isEmpty(optString)) {
                this.b.callback(com.zx.a.I8b7.n3.this.b(jSONObject.toString()));
                return;
            }
            java.lang.String c2 = com.zx.a.I8b7.n3.this.c(optString);
            com.zx.a.I8b7.r2.a("unicomUAIDAuthUrl: ".concat(java.lang.String.valueOf(c2)));
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(c2));
            httpURLConnection2.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection2.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection2.connect();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b("text/json; charset=utf-8"), httpURLConnection2.getContentLength(), httpURLConnection2.getResponseCode() == 200 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream()).b());
            java.lang.String optString2 = jSONObject2.optString("code");
            if (android.text.TextUtils.isEmpty(optString2)) {
                this.b.callback(com.zx.a.I8b7.n3.this.b(jSONObject2.toString()));
                return;
            }
            com.zx.a.I8b7.r2.a("unicomUAID code: ".concat(java.lang.String.valueOf(optString2)));
            a(network, optString2);
            httpURLConnection.disconnect();
            httpURLConnection2.disconnect();
            com.zx.a.I8b7.n3.this.a(this.e, this.b, this.f, "unicom", optString2, jSONObject2.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, null));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.g.getAndSet(true)) {
                    return;
                }
                com.zx.a.I8b7.r2.a("zx 网络切换: 使用移动网络访问");
                this.d.cancel();
                this.c.cancel();
                java.lang.String b = com.zx.a.I8b7.w3.b(com.zx.a.I8b7.m3.a);
                if ("中国联通".equals(b)) {
                    c(network);
                } else if ("中国移动".equals(b)) {
                    a(network);
                } else if ("中国电信".equals(b)) {
                    b(network);
                } else {
                    this.b.callback(com.zx.a.I8b7.n3.this.a("暂不支持该运营商", 1));
                }
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
                com.zx.module.base.Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(com.zx.a.I8b7.n3.this.a(th.getMessage(), 1));
                        this.a.unregisterNetworkCallback(this);
                    } catch (org.json.JSONException e) {
                        com.zx.a.I8b7.r2.a(e);
                    }
                }
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.n3 a = new com.zx.a.I8b7.n3();
    }

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String a(com.zx.module.base.Callback callback) throws java.lang.Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str) throws java.lang.Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, org.json.JSONException;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native org.json.JSONObject a() throws org.json.JSONException;

    @com.zx.module.annotation.Java2C.Method2C
    private native void a(org.json.JSONObject jSONObject, com.zx.module.base.Callback callback, int i) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String b(com.zx.module.base.Callback callback) throws java.lang.Exception;

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] b();

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String c(java.lang.String str);

    @com.zx.module.annotation.Java2C.Method2C
    private native org.json.JSONObject c(com.zx.module.base.Callback callback) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] c();

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] d();

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String e();

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] f();

    public final java.lang.String a(java.lang.String str, int i) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }

    public final void a(org.json.JSONObject jSONObject, com.zx.module.base.Callback callback, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        org.json.JSONObject jSONObject2;
        java.lang.String str4;
        if (i == 0) {
            try {
                callback.callback(a(com.zx.a.I8b7.w1.b(jSONObject, str, str2, str3), 0));
                return;
            } catch (java.lang.Throwable th) {
                java.lang.String message = th.getMessage();
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("msg", message);
                jSONObject3.put("code", 10011);
                callback.callback(jSONObject3.toString());
                return;
            }
        }
        if (i == 1) {
            java.lang.String string = jSONObject.getString("callerId");
            jSONObject2 = new org.json.JSONObject();
            java.lang.String str5 = string + "|" + com.zx.a.I8b7.m3.g + "|" + com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h) + "|" + str + "|" + str2;
            java.lang.String str6 = b()[0];
            java.security.SecureRandom secureRandom = com.zx.a.I8b7.p.a;
            try {
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str6, 0))));
                byte[] bytes = str5.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                int length = bytes.length;
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = length - i2;
                    if (i4 <= 0) {
                        break;
                    }
                    byte[] doFinal = i4 > 117 ? cipher.doFinal(bytes, i2, 117) : cipher.doFinal(bytes, i2, i4);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i3++;
                    i2 = i3 * 117;
                }
                str4 = new java.lang.String(android.util.Base64.encode(byteArrayOutputStream.toByteArray(), 2), java.nio.charset.StandardCharsets.UTF_8);
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable unused) {
                }
            } catch (java.lang.Throwable unused2) {
                str4 = "";
            }
            jSONObject2.put("data", str4);
        } else {
            if (i != 2) {
                return;
            }
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            jSONObject4.put("code", str2);
            jSONObject4.put("type", str);
            jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("data", jSONObject4);
        }
        jSONObject2.put("code", 0);
        callback.callback(jSONObject2.toString());
    }

    public final java.lang.String b(java.lang.String str) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("msg", str);
        jSONObject.put("code", 10010);
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if ((r1.isWifiEnabled() && (r3 == null ? 0 : r3.getIpAddress()) != 0) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(org.json.JSONObject jSONObject, com.zx.module.base.Callback callback, int i) throws java.lang.Throwable {
        boolean booleanValue;
        boolean a2 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.ACCESS_WIFI_STATE", false);
        boolean a3 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.CHANGE_NETWORK_STATE", false);
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (!a2 || !a3) {
            com.zx.a.I8b7.r2.a("开始执行getUAID333");
            a(jSONObject, callback, i);
            return;
        }
        android.content.Context context = com.zx.a.I8b7.m3.a;
        com.zx.a.I8b7.r2.a("getUAID:forceSendRequestByMobileData with cb");
        boolean z = true;
        if (i2 >= 24) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                booleanValue = ((java.lang.Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new java.lang.Class[0]).invoke(telephonyManager, new java.lang.Object[0])).booleanValue();
            } catch (java.lang.Exception unused) {
            }
            if (booleanValue) {
                com.zx.a.I8b7.r2.a("zx 网络切换: 移动网络不可用，提示请打开移动网络");
                callback.callback(a("zx 网络切换: 移动网络不可用，提示请打开移动网络", 1));
                return;
            }
            if (((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).isWifiEnabled()) {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            }
            z = false;
            if (!z) {
                com.zx.a.I8b7.r2.a("zx 网络切换: 直接可以使用移动网络访问");
                a(jSONObject, callback, i);
                return;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManager.requestNetwork(builder.build(), new com.zx.a.I8b7.n3.a(jSONObject, connectivityManager, callback, i));
            return;
        }
        booleanValue = true;
        if (booleanValue) {
        }
    }
}
