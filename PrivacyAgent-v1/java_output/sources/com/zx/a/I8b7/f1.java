package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class f1 {
    public static final byte[] b = {-95, -8, -49, 34, 91, -116, -29, -2, -106, 39, -56, 39, -121, 112, -22, com.google.common.base.Ascii.NAK};
    public static final byte[] c = {-84, -2, -56, -72, -90, 65, -76, -48, -92, com.google.common.base.Ascii.RS, -27, -64, -102, 101, 95, com.google.common.base.Ascii.CAN};
    public final java.lang.String[] a = b();

    @android.annotation.SuppressLint({"NewApi"})
    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public java.util.TimerTask c;
        public final java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer b = new java.util.Timer();

        /* renamed from: com.zx.a.I8b7.f1$a$a, reason: collision with other inner class name */
        public class C0536a extends java.util.TimerTask {
            public C0536a(com.zx.a.I8b7.f1.a aVar, com.zx.a.I8b7.f1 f1Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
            }
        }

        public a(android.net.ConnectivityManager connectivityManager) {
            this.a = connectivityManager;
            com.zx.a.I8b7.f1.a.C0536a c0536a = new com.zx.a.I8b7.f1.a.C0536a(this, com.zx.a.I8b7.f1.this);
            this.c = c0536a;
            this.b.schedule(c0536a, 7000L);
        }

        public final void a(android.net.Network network) throws java.lang.Exception {
            java.lang.StringBuilder a = com.zx.a.I8b7.f3.a(com.zx.a.I8b7.f1.this.d());
            a.append(java.net.URLEncoder.encode(com.zx.a.I8b7.m3.i, "UTF-8"));
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(a.toString()));
            httpURLConnection.setConnectTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.setReadTimeout(com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
            httpURLConnection.connect();
            com.zx.a.I8b7.u1 a2 = com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("cmd 8 suc!");
            a3.append(a2.b());
            com.zx.a.I8b7.r2.a(a3.toString());
            httpURLConnection.disconnect();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.d.getAndSet(true)) {
                    return;
                }
                this.c.cancel();
                this.b.cancel();
                java.lang.String b = com.zx.a.I8b7.w3.b(com.zx.a.I8b7.m3.a);
                if ("中国联通".equals(b)) {
                    a(network);
                } else if (!"中国移动".equals(b)) {
                    "中国电信".equals(b);
                }
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.f1 a = new com.zx.a.I8b7.f1();
    }

    public final java.lang.String a(java.lang.String str) {
        java.lang.String str2 = com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((java.lang.System.currentTimeMillis() / 1000) / com.anythink.expressad.d.a.b.aT);
        java.security.SecureRandom secureRandom = com.zx.a.I8b7.p.a;
        try {
            return str + "/api?appid=" + this.a[1] + "&request_id=" + com.zx.a.I8b7.p.a("SHA256", str2.getBytes(java.nio.charset.StandardCharsets.UTF_8)).substring(0, 16);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException("sha256String fail", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
    
        if ((r0.isWifiEnabled() && (r1 == null ? 0 : r1.getIpAddress()) != 0) != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() throws java.lang.Throwable {
        boolean booleanValue;
        if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.i) || !com.zx.a.I8b7.m3.i.startsWith("Z01-") || !"中国联通".equals(com.zx.a.I8b7.w3.b(com.zx.a.I8b7.m3.a))) {
            return;
        }
        boolean a2 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.ACCESS_WIFI_STATE", false);
        boolean a3 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.CHANGE_NETWORK_STATE", false);
        int i = android.os.Build.VERSION.SDK_INT;
        if (!a2 || !a3) {
            e();
            return;
        }
        android.content.Context context = com.zx.a.I8b7.m3.a;
        boolean z = true;
        if (i >= 24) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                booleanValue = ((java.lang.Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new java.lang.Class[0]).invoke(telephonyManager, new java.lang.Object[0])).booleanValue();
            } catch (java.lang.Exception unused) {
            }
            if (booleanValue) {
                return;
            }
            android.content.Context context2 = com.zx.a.I8b7.m3.a;
            if (((android.net.wifi.WifiManager) context2.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).isWifiEnabled()) {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context2.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            }
            z = false;
            if (!z) {
                e();
                return;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.zx.a.I8b7.m3.a.getSystemService("connectivity");
            android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManager.requestNetwork(builder.build(), new com.zx.a.I8b7.f1.a(connectivityManager));
            return;
        }
        booleanValue = true;
        if (booleanValue) {
        }
    }

    public final java.lang.String[] b() {
        return new java.lang.String[]{"https://nisportal.10010.com:9001", "1073741824000"};
    }

    public final java.lang.String c() throws java.lang.Exception {
        com.zx.a.I8b7.o2 o2Var = new com.zx.a.I8b7.o2(new com.zx.a.I8b7.o2.a());
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        com.zx.a.I8b7.q1.a a2 = aVar.a(a(this.a[0]));
        a2.b = "GET";
        a2.e = "unicom uaid nisportal api";
        org.json.JSONObject jSONObject = new org.json.JSONObject(new com.zx.a.I8b7.i1(o2Var, new com.zx.a.I8b7.q1(aVar)).a().e.b());
        java.lang.String optString = jSONObject.optString("authurl");
        if (android.text.TextUtils.isEmpty(optString)) {
            throw new java.lang.RuntimeException(jSONObject.toString());
        }
        com.zx.a.I8b7.q1.a aVar2 = new com.zx.a.I8b7.q1.a();
        com.zx.a.I8b7.q1.a a3 = aVar2.a(a(optString));
        a3.b = "GET";
        a3.e = "unicom uaid auth api";
        return new org.json.JSONObject(new com.zx.a.I8b7.i1(o2Var, new com.zx.a.I8b7.q1(aVar2)).a().e.b()).getString("code");
    }

    public final java.lang.String d() throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new javax.crypto.spec.SecretKeySpec(b, "AES"), new javax.crypto.spec.IvParameterSpec(c));
        return new java.lang.String(cipher.doFinal(android.util.Base64.decode("xxXbFehPQ+Zs/VtAtd6DL3ogem3eY/0zoVy6qWtcMuI5NPlB0yUsMmvUu+oK7CzNKOAIJmt5N8/SdP04E4O7Tw==", 2)), "UTF-8");
    }

    public final void e() {
        try {
            c();
            com.zx.a.I8b7.o2 o2Var = new com.zx.a.I8b7.o2(new com.zx.a.I8b7.o2.a());
            com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
            com.zx.a.I8b7.q1.a a2 = aVar.a(d() + java.net.URLEncoder.encode(com.zx.a.I8b7.m3.i, "UTF-8"));
            a2.b = "GET";
            a2.e = "unicom uaid nisportal api";
            new com.zx.a.I8b7.i1(o2Var, new com.zx.a.I8b7.q1(aVar)).a();
            com.zx.a.I8b7.r2.a("l t s u c!");
        } catch (java.lang.Throwable unused) {
        }
    }
}
