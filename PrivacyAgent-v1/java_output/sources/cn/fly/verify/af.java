package cn.fly.verify;

/* loaded from: classes.dex */
public class af {
    private java.util.HashMap<java.lang.String, java.lang.Object> a;
    private java.util.HashMap<java.lang.String, java.lang.Object> b;

    public af(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2) {
        this.a = hashMap;
        this.b = hashMap2;
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> a(android.net.Network network, java.lang.String str, java.net.HttpURLConnection httpURLConnection) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        if (httpURLConnection != null) {
            try {
                httpURLConnection.setRequestProperty("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                if ("POST".equals(str) && this.a != null) {
                    httpURLConnection.setRequestMethod(str);
                    httpURLConnection.connect();
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    byteArrayOutputStream.write(cn.fly.verify.ag.a(this.a).getBytes("utf-8"));
                    httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
                }
            } catch (java.lang.Throwable th) {
                hashMap.put("code", 1);
                hashMap.put("res", th.getMessage());
                return hashMap;
            }
        }
        return b(network, str, httpURLConnection);
    }

    private java.lang.String b(android.content.Context context) {
        java.lang.String str;
        try {
            str = android.webkit.WebSettings.getDefaultUserAgent(context);
        } catch (java.lang.Exception unused) {
            str = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(java.lang.String.format("\\u%04x", java.lang.Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> b(android.net.Network network, java.lang.String str, java.net.HttpURLConnection httpURLConnection) {
        int responseCode;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        if (httpURLConnection != null) {
            try {
                responseCode = httpURLConnection.getResponseCode();
            } catch (java.lang.Throwable unused) {
                java.lang.Throwable th = new java.lang.Throwable("CU_HTTP_REQUEST_FAILED");
                hashMap.put("code", 1);
                hashMap.put("res", th.getMessage());
                return hashMap;
            }
        } else {
            responseCode = -1;
        }
        if (responseCode == 200) {
            java.lang.String a = a(httpURLConnection, "UTF-8");
            hashMap.put("code", 0);
            hashMap.put("res", a);
            return hashMap;
        }
        if (responseCode != 301 && responseCode != 302) {
            java.lang.Throwable th2 = new java.lang.Throwable("CU_SERVER_RESPONSE_CODE");
            hashMap.put("code", 1);
            hashMap.put("res", th2.getMessage());
            return hashMap;
        }
        java.lang.String headerField = httpURLConnection.getHeaderField("Location");
        java.lang.String headerField2 = httpURLConnection.getHeaderField(com.google.common.net.HttpHeaders.SET_COOKIE);
        java.lang.String path = httpURLConnection.getURL().getPath();
        if (android.text.TextUtils.isEmpty(headerField)) {
            java.lang.Throwable th3 = new java.lang.Throwable("CU_NO_REDIRECT_ADDRESS_CODE");
            hashMap.put("code", 1);
            hashMap.put("res", th3.getMessage());
            return hashMap;
        }
        java.net.HttpURLConnection a2 = a(network, headerField);
        if (android.text.TextUtils.isEmpty(headerField2)) {
            a2.setRequestProperty(com.google.common.net.HttpHeaders.COOKIE, "");
        } else {
            "/ctcnet/gctcmc.do".equals(path);
            a2.setRequestProperty(com.google.common.net.HttpHeaders.COOKIE, headerField2);
        }
        return a(network, "GET", a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(android.content.Context context) {
        java.lang.String b;
        if (context != null) {
            try {
                b = b(context);
            } catch (java.lang.Throwable unused) {
            }
            return !android.text.TextUtils.isEmpty(b) ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : b;
        }
        b = null;
        if (!android.text.TextUtils.isEmpty(b)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(java.net.HttpURLConnection httpURLConnection, java.lang.String str) {
        java.lang.StringBuilder sb;
        if (httpURLConnection != null) {
            try {
                sb = new java.lang.StringBuilder();
                try {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream(), str));
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    }
                } catch (java.io.UnsupportedEncodingException | java.io.IOException unused) {
                }
            } catch (java.io.UnsupportedEncodingException | java.io.IOException unused2) {
            }
            if (sb != null) {
                return null;
            }
            return sb.toString().trim();
        }
        sb = null;
        if (sb != null) {
        }
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    public java.net.HttpURLConnection a(android.net.Network network, java.lang.String str) throws java.lang.Throwable {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.Throwable("CU_HTTP_URL_EMPTY");
        }
        java.net.URL url = new java.net.URL(str);
        java.lang.String j = cn.fly.verify.al.j();
        java.net.URLConnection uRLConnection = network != null ? (java.net.HttpURLConnection) network.openConnection(url) : null;
        if (uRLConnection == null) {
            uRLConnection = url.openConnection();
        } else if (j.equalsIgnoreCase("WIFI")) {
            j = "2";
        }
        if (uRLConnection == null) {
            throw new java.lang.Throwable("CU_HTTP_CHANNEL_OPEN_FAILED");
        }
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) uRLConnection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("user-agent", a(cn.fly.verify.ax.g()));
        httpURLConnection.setRequestProperty("netType", java.lang.String.valueOf(j));
        httpURLConnection.setRequestProperty("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.b;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.b.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), (java.lang.String) entry.getValue());
            }
        }
        return httpURLConnection;
    }

    public void a(android.net.Network network, java.lang.String str, cn.fly.verify.common.callback.b bVar, java.lang.String str2) {
        cn.fly.verify.common.exception.VerifyException verifyException;
        try {
            java.util.HashMap<java.lang.String, java.lang.Object> a = a(network, "POST", a(network, str));
            int intValue = (a == null || !a.containsKey("code")) ? -1 : ((java.lang.Integer) a.get("code")).intValue();
            java.lang.String str3 = (a == null || !a.containsKey("res")) ? null : (java.lang.String) a.get("res");
            if (intValue != 0 || str3 == null) {
                verifyException = new cn.fly.verify.common.exception.VerifyException(302002, str3);
            } else {
                try {
                    int optInt = new org.json.JSONObject(str3).optInt("code");
                    if (optInt != 0) {
                        bVar.a(new cn.fly.verify.common.exception.VerifyException(optInt, str3));
                        return;
                    }
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(cn.fly.verify.ag.a(new org.json.JSONObject(str3).optString("obj"), str2));
                        java.lang.String optString = jSONObject.optString("accessCode");
                        java.lang.String optString2 = jSONObject.optString("fakeMobile");
                        long optLong = jSONObject.optLong(com.umeng.analytics.pro.ay.b);
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put("optoken", optString);
                        hashMap.put("expired", java.lang.Long.valueOf(optLong));
                        hashMap.put(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE, optString2);
                        bVar.a((cn.fly.verify.common.callback.b) hashMap);
                        return;
                    } catch (java.lang.Throwable th) {
                        bVar.a(new cn.fly.verify.common.exception.VerifyException(302001, cn.fly.verify.as.a(th)));
                        return;
                    }
                } catch (java.lang.Throwable th2) {
                    verifyException = new cn.fly.verify.common.exception.VerifyException(302003, cn.fly.verify.as.a(th2));
                }
            }
            bVar.a(verifyException);
        } catch (java.lang.Throwable th3) {
            bVar.a(new cn.fly.verify.common.exception.VerifyException(302002, cn.fly.verify.as.a(th3)));
        }
    }
}
