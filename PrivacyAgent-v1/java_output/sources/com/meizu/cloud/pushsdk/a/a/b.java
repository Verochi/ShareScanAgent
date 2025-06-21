package com.meizu.cloud.pushsdk.a.a;

/* loaded from: classes23.dex */
public class b {
    private static final java.lang.String a = "b";
    private static final java.lang.Object b = new java.lang.Object();
    private static com.meizu.cloud.pushsdk.a.a.b c;

    private b(android.content.Context context) {
        try {
            java.lang.System.setProperty("sun.net.http.allowRestrictedHeaders", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.meizu.cloud.pushsdk.a.a.a.a(context);
    }

    public static com.meizu.cloud.pushsdk.a.a.b a(android.content.Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new com.meizu.cloud.pushsdk.a.a.b(context);
                }
            }
        }
        return c;
    }

    private java.util.Map<java.lang.String, java.lang.String> a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>(2);
        }
        byte[] c2 = com.meizu.cloud.pushsdk.a.a.a.a().c();
        if (c2 == null || c2.length <= 0) {
            byte[] b2 = com.meizu.cloud.pushsdk.a.a.a.a().b();
            if (b2 != null && b2.length > 0) {
                java.lang.String str = new java.lang.String(com.meizu.cloud.pushsdk.a.a.a.a().b());
                com.meizu.cloud.pushinternal.DebugLogger.d(a, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            java.lang.String str2 = new java.lang.String(c2);
            com.meizu.cloud.pushinternal.DebugLogger.d(a, "attach x_s_key: " + str2);
            map.put("X-S-Key", str2);
        }
        return map;
    }

    private void a(java.net.HttpURLConnection httpURLConnection, byte[] bArr) throws java.io.IOException {
        java.util.zip.GZIPOutputStream gZIPOutputStream = null;
        try {
            java.util.zip.GZIPOutputStream gZIPOutputStream2 = new java.util.zip.GZIPOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (java.lang.Exception unused) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void a(java.net.URLConnection uRLConnection) {
        try {
            java.lang.String headerField = uRLConnection.getHeaderField("X-S-Key");
            com.meizu.cloud.pushinternal.DebugLogger.d(a, "get x_s_key = " + headerField);
            if (android.text.TextUtils.isEmpty(headerField)) {
                return;
            }
            com.meizu.cloud.pushsdk.a.a.a.a().a(headerField);
        } catch (java.lang.NullPointerException unused) {
        }
    }

    private byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00fc, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00fe, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.meizu.cloud.pushsdk.a.a.c b(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection;
        java.io.InputStream inputStream;
        byte[] a2;
        com.meizu.cloud.pushsdk.a.a.c cVar = null;
        cVar = null;
        cVar = null;
        ?? r0 = 0;
        cVar = null;
        if (str2 != null) {
            byte[] a3 = com.meizu.cloud.pushsdk.a.a.a.a().a(str2.getBytes());
            java.lang.String str3 = a3 != null ? new java.lang.String(android.util.Base64.encode(a3, 2)) : null;
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(com.meizu.cloud.pushsdk.constants.PushConstants.URL_UPLOAD_DATA).openConnection();
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                if (map != null && map.size() > 0) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                try {
                    if (str3 != null) {
                        try {
                            a(httpURLConnection, str3.getBytes());
                        } catch (java.lang.Exception e) {
                            e = e;
                            inputStream = null;
                            com.meizu.cloud.pushinternal.DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                } catch (java.io.IOException unused) {
                                }
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    java.lang.String str4 = a;
                    com.meizu.cloud.pushinternal.DebugLogger.d(str4, "code = " + responseCode);
                    a(httpURLConnection);
                    b(httpURLConnection);
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        try {
                            a2 = a(inputStream);
                            if (a2 != null) {
                                java.lang.String str5 = new java.lang.String(a2);
                                com.meizu.cloud.pushinternal.DebugLogger.d(str4, "body = " + str5);
                                try {
                                    new org.json.JSONObject(str5).getInt("code");
                                } catch (org.json.JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            com.meizu.cloud.pushinternal.DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                        }
                    } else {
                        a2 = null;
                    }
                    cVar = a2 != null ? new com.meizu.cloud.pushsdk.a.a.c(responseCode, new java.lang.String(a2)) : new com.meizu.cloud.pushsdk.a.a.c(responseCode, null);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r0 = str3;
                }
            } catch (java.net.MalformedURLException e4) {
                e4.printStackTrace();
            }
        }
        return cVar;
        httpURLConnection.disconnect();
        return cVar;
    }

    private void b(java.net.URLConnection uRLConnection) {
        try {
            java.lang.String headerField = uRLConnection.getHeaderField("Key-Timeout");
            com.meizu.cloud.pushinternal.DebugLogger.d(a, "get keyTimeout = " + headerField);
        } catch (java.lang.NullPointerException unused) {
        }
    }

    public com.meizu.cloud.pushsdk.a.a.c a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        try {
            return b(str, a(map), str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
