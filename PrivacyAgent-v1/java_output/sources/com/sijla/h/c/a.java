package com.sijla.h.c;

/* loaded from: classes19.dex */
public class a {
    private static boolean a = true;
    private static volatile com.sijla.h.c.a b;
    private static android.content.Context c;
    private static final java.util.HashMap<java.lang.String, java.lang.Boolean> d;

    static {
        java.util.HashMap<java.lang.String, java.lang.Boolean> hashMap = new java.util.HashMap<>();
        d = hashMap;
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        hashMap.put("fd.qchannel03.cn", bool);
        hashMap.put("fd2.qchannel03.cn", bool);
        hashMap.put("a.qchannel03.cn", bool);
        hashMap.put("d.qchannel03.cn", bool);
        hashMap.put("log.qchannel03.cn", bool);
        hashMap.put("truth.qchannel03.cn", bool);
    }

    private a() {
    }

    public static com.sijla.h.c.a a() {
        if (b == null) {
            synchronized (com.sijla.h.c.a.class) {
                if (b == null) {
                    b = new com.sijla.h.c.a();
                    c = com.sijla.h.c.i();
                }
            }
        }
        try {
            a = !new java.io.File(com.sijla.h.a.d.c(com.sijla.b.g.b())).exists();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    private static com.sijla.h.j a(int i, java.net.HttpURLConnection httpURLConnection, com.sijla.h.c.a.a aVar) {
        com.sijla.h.j a2;
        com.sijla.h.j jVar = new com.sijla.h.j();
        java.io.InputStream inputStream = null;
        try {
            try {
                if (204 != i) {
                    if (i == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        a2 = aVar.a(inputStream);
                    } else {
                        inputStream = httpURLConnection.getErrorStream();
                        a2 = new com.sijla.h.c.a.a.a().a(inputStream);
                    }
                    jVar = a2;
                }
                jVar.a(i);
                com.sijla.h.c.a(inputStream);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                jVar.a(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE);
                com.sijla.h.c.a(inputStream);
            }
            return jVar;
        } catch (java.lang.Throwable th) {
            com.sijla.h.c.a(inputStream);
            throw th;
        }
    }

    public static com.sijla.h.j a(java.lang.String str, com.sijla.h.c.a.a aVar) {
        java.net.HttpURLConnection a2;
        com.sijla.h.j jVar = new com.sijla.h.j();
        if (!a) {
            return jVar;
        }
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                a2 = a(str);
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            a(a2, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, (byte[]) null);
            jVar = a(a2.getResponseCode(), a2, aVar);
            com.sijla.h.c.a(a2);
        } catch (java.lang.Exception e2) {
            e = e2;
            httpURLConnection = a2;
            jVar.a(400);
            jVar.a(e.getMessage());
            com.sijla.h.c.a(httpURLConnection);
            return jVar;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = a2;
            com.sijla.h.c.a(httpURLConnection);
            throw th;
        }
        return jVar;
    }

    public static com.sijla.h.j a(java.lang.String str, org.json.JSONObject jSONObject) {
        return a(str, a(jSONObject).toString().getBytes(), new com.sijla.h.c.a.a.a());
    }

    public static com.sijla.h.j a(java.lang.String str, org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.io.File> map, com.sijla.h.c.a.a aVar) {
        int i;
        java.net.HttpURLConnection httpURLConnection;
        java.io.DataOutputStream dataOutputStream;
        com.sijla.h.j jVar = new com.sijla.h.j();
        if (!a) {
            return jVar;
        }
        java.lang.String uuid = java.util.UUID.randomUUID().toString();
        try {
            try {
                httpURLConnection = a(str);
            } catch (java.lang.Throwable th) {
                th = th;
                i = 2;
                java.io.Closeable[] closeableArr = new java.io.Closeable[i];
                closeableArr[0] = null;
                closeableArr[1] = null;
                com.sijla.h.c.a(closeableArr);
                com.sijla.h.c.a(httpURLConnection);
                throw th;
            }
            try {
                httpURLConnection.setReadTimeout(com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR);
                httpURLConnection.setConnectTimeout(com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat(java.lang.String.valueOf(uuid)));
                dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
                if (jSONObject != null) {
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            java.lang.String next = keys.next();
                            java.lang.String optString = jSONObject.optString(next);
                            sb.append("--");
                            sb.append(uuid);
                            sb.append("\r\n");
                            sb.append("Content-Disposition: form-data; name=\"" + next + "\"\r\n");
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Content-Type: text/plain; charset=");
                            sb2.append("UTF-8");
                            sb2.append("\r\n");
                            sb.append(sb2.toString());
                            sb.append("Content-Transfer-Encoding: 8bit".concat("\r\n"));
                            sb.append("\r\n");
                            sb.append(optString);
                            sb.append("\r\n");
                        }
                        dataOutputStream.write(sb.toString().getBytes());
                    } catch (java.lang.Exception e) {
                        e = e;
                        jVar.a(400);
                        jVar.a(e.getMessage());
                        com.sijla.h.c.a(dataOutputStream, null);
                        com.sijla.h.c.a(httpURLConnection);
                        return jVar;
                    }
                }
                if (map != null) {
                    for (java.util.Map.Entry<java.lang.String, java.io.File> entry : map.entrySet()) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("--");
                        sb3.append(uuid);
                        sb3.append("\r\n");
                        sb3.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + entry.getKey() + "\"\r\n");
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder("Content-Type: application/octet-stream; charset=");
                        sb4.append("UTF-8");
                        sb4.append("\r\n");
                        sb3.append(sb4.toString());
                        sb3.append("\r\n");
                        dataOutputStream.write(sb3.toString().getBytes());
                        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(entry.getValue());
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                dataOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream.close();
                        dataOutputStream.write("\r\n".getBytes());
                    }
                }
                dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                dataOutputStream.flush();
                jVar = a(httpURLConnection.getResponseCode(), httpURLConnection, aVar);
                com.sijla.h.c.a(dataOutputStream, null);
                com.sijla.h.c.a(httpURLConnection);
            } catch (java.lang.Exception e2) {
                e = e2;
                dataOutputStream = null;
                jVar.a(400);
                jVar.a(e.getMessage());
                com.sijla.h.c.a(dataOutputStream, null);
                com.sijla.h.c.a(httpURLConnection);
                return jVar;
            } catch (java.lang.Throwable th2) {
                th = th2;
                i = 2;
                java.io.Closeable[] closeableArr2 = new java.io.Closeable[i];
                closeableArr2[0] = null;
                closeableArr2[1] = null;
                com.sijla.h.c.a(closeableArr2);
                com.sijla.h.c.a(httpURLConnection);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            httpURLConnection = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            i = 2;
            httpURLConnection = null;
        }
        return jVar;
    }

    public static com.sijla.h.j a(java.lang.String str, byte[] bArr, com.sijla.h.c.a.a aVar) {
        java.net.HttpURLConnection httpURLConnection;
        com.sijla.h.j jVar = new com.sijla.h.j();
        if (!a) {
            return jVar;
        }
        try {
            httpURLConnection = a(str);
            try {
                try {
                    a(httpURLConnection, "post", bArr);
                    jVar = a(httpURLConnection.getResponseCode(), httpURLConnection, aVar);
                    com.sijla.h.c.a(null);
                    com.sijla.h.c.a(httpURLConnection);
                } catch (java.lang.Exception e) {
                    e = e;
                    jVar.a(400);
                    jVar.a(e.getMessage());
                    com.sijla.h.c.a(null);
                    com.sijla.h.c.a(httpURLConnection);
                    return jVar;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.sijla.h.c.a(null);
                com.sijla.h.c.a(httpURLConnection);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = null;
            com.sijla.h.c.a(null);
            com.sijla.h.c.a(httpURLConnection);
            throw th;
        }
        return jVar;
    }

    public static java.lang.StringBuffer a(org.json.JSONObject jSONObject) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            boolean z = true;
            while (keys.hasNext()) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append("&");
                }
                java.lang.String next = keys.next();
                stringBuffer.append(next);
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(java.net.URLEncoder.encode(jSONObject.optString(next), "UTF-8"));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static java.net.HttpURLConnection a(java.lang.String str) {
        java.net.HttpURLConnection httpURLConnection;
        java.lang.Boolean bool;
        try {
            if (str.startsWith("http:") && !a(c)) {
                str = str.replace("http:", "https:");
            }
            java.net.URL url = new java.net.URL(str);
            java.lang.String host = url.getHost();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                java.util.HashMap<java.lang.String, java.lang.Boolean> hashMap = d;
                if ((!hashMap.containsKey(host) || (bool = hashMap.get(host)) == null) ? true : bool.booleanValue()) {
                    httpURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection();
                } else {
                    javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                    sSLContext.init(null, new javax.net.ssl.TrustManager[]{new com.sijla.h.c.b.a(host)}, null);
                    javax.net.ssl.SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                    javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setSSLSocketFactory(socketFactory);
                    httpsURLConnection.setHostnameVerifier(new com.sijla.h.c.b.b());
                    httpURLConnection = httpsURLConnection;
                }
            } else {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            }
            a(httpURLConnection);
            return httpURLConnection;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(java.net.HttpURLConnection httpURLConnection) {
        java.lang.String str;
        java.lang.String str2;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.sijla.h.a.a.r());
            httpURLConnection.setRequestProperty("sts", sb.toString());
            httpURLConnection.setRequestProperty("osv", com.sijla.h.a.a.j());
            httpURLConnection.setRequestProperty("osn", com.sijla.h.c.a());
            httpURLConnection.setRequestProperty("osm", com.sijla.h.a.a.f());
            httpURLConnection.setRequestProperty("osb", com.sijla.h.a.a.g());
            httpURLConnection.setRequestProperty("hw", com.sijla.h.a.a.i());
            httpURLConnection.setRequestProperty("osc", com.sijla.h.a.a.n(com.sijla.b.g.b()));
            java.lang.String c2 = com.sijla.b.g.c();
            com.sijla.c.a aVar = com.sijla.b.g.a;
            if (aVar != null) {
                str2 = aVar.b();
                str = aVar.c();
            } else {
                str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                str2 = str;
            }
            java.lang.String[] strArr = {com.sijla.h.i.a, android.os.Build.MODEL, c2, "20230823", str2, str, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER};
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            for (int i = 0; i < 7; i++) {
                sb2.append(strArr[i]);
                if (i != 6) {
                    sb2.append("\t");
                }
            }
            httpURLConnection.setRequestProperty("quae", "1");
            httpURLConnection.setRequestProperty("User-Agent", com.sijla.h.c.b(sb2.toString()));
            httpURLConnection.setRequestProperty("ssslv", com.getui.gtc.extension.distribution.gbd.f.h.n);
        } catch (java.lang.Throwable unused) {
            httpURLConnection.setRequestProperty("ssslv", com.getui.gtc.extension.distribution.gbd.f.h.n);
        }
    }

    public static void a(java.net.HttpURLConnection httpURLConnection, java.lang.String str, byte[] bArr) {
        httpURLConnection.setReadTimeout(com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR);
        httpURLConnection.setConnectTimeout(com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR);
        if (str.toUpperCase().equals("POST")) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bArr.length));
            java.io.OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    com.sijla.h.c.a(outputStream);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                    com.sijla.h.c.a(outputStream);
                }
            } catch (java.lang.Throwable th) {
                com.sijla.h.c.a(outputStream);
                throw th;
            }
        }
    }

    private static boolean a(android.content.Context context) {
        android.security.NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        if (context == null) {
            return false;
        }
        try {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (context.getApplicationInfo().targetSdkVersion < 27) {
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            networkSecurityPolicy = android.security.NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted();
            return isCleartextTrafficPermitted;
        }
        return false;
    }

    public static boolean b() {
        return a;
    }
}
