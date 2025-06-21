package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class d {

    public enum a {
        GET("GET"),
        POST("POST");

        public java.lang.String d;

        a(java.lang.String str) {
            this.d = str;
        }

        public java.lang.String a() {
            return this.d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.InputStream] */
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        ?? r8;
        ?? r9;
        ?? r10;
        java.net.HttpURLConnection httpURLConnection;
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        java.io.InputStream inputStream3;
        java.io.InputStream inputStream4;
        ?? r82;
        java.io.InputStream inputStream5;
        java.io.InputStream inputStream6;
        java.io.OutputStream outputStream;
        ?? r2 = 0;
        if (str2 == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        int i = -1;
        try {
            try {
                httpURLConnection = a(context, str, map, com.huawei.hms.opendevice.d.a.POST.a());
                if (httpURLConnection == null) {
                    com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) null);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) null);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) null);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                }
                try {
                    r82 = new java.io.BufferedOutputStream(httpURLConnection.getOutputStream());
                } catch (java.io.IOException unused) {
                    inputStream3 = null;
                    inputStream4 = inputStream3;
                    r82 = inputStream3;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("http execute encounter IOException - http code:");
                    sb.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.RuntimeException unused2) {
                    inputStream2 = null;
                    inputStream4 = inputStream2;
                    r82 = inputStream2;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("http execute encounter RuntimeException - http code:");
                    sb2.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb2.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.Exception unused3) {
                    inputStream = null;
                    inputStream4 = inputStream;
                    r82 = inputStream;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("http execute encounter unknown exception - http code:");
                    sb3.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb3.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.Throwable th) {
                    r9 = 0;
                    r10 = 0;
                    r2 = httpURLConnection;
                    th = th;
                    r8 = 0;
                }
                try {
                    r82.write(str2.getBytes("UTF-8"));
                    r82.flush();
                    i = httpURLConnection.getResponseCode();
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("http post response code: ");
                    sb4.append(i);
                    com.huawei.hms.support.log.HMSLog.d("PushHttpClient", sb4.toString());
                    inputStream4 = i >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                    try {
                        inputStream5 = new java.io.BufferedInputStream(inputStream4);
                        try {
                            java.lang.String a2 = com.huawei.hms.opendevice.s.a(inputStream5);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r82);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream4);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                            com.huawei.hms.opendevice.s.a(httpURLConnection);
                            com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                            return a2;
                        } catch (java.io.IOException unused4) {
                            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                            sb5.append("http execute encounter IOException - http code:");
                            sb5.append(i);
                            com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb5.toString());
                            outputStream = r82;
                            inputStream6 = inputStream4;
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                            com.huawei.hms.opendevice.s.a(httpURLConnection);
                            com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                            return null;
                        } catch (java.lang.RuntimeException unused5) {
                            java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                            sb22.append("http execute encounter RuntimeException - http code:");
                            sb22.append(i);
                            com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb22.toString());
                            outputStream = r82;
                            inputStream6 = inputStream4;
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                            com.huawei.hms.opendevice.s.a(httpURLConnection);
                            com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                            return null;
                        } catch (java.lang.Exception unused6) {
                            java.lang.StringBuilder sb32 = new java.lang.StringBuilder();
                            sb32.append("http execute encounter unknown exception - http code:");
                            sb32.append(i);
                            com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb32.toString());
                            outputStream = r82;
                            inputStream6 = inputStream4;
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                            com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                            com.huawei.hms.opendevice.s.a(httpURLConnection);
                            com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                            return null;
                        }
                    } catch (java.io.IOException unused7) {
                        inputStream5 = null;
                    } catch (java.lang.RuntimeException unused8) {
                        inputStream5 = null;
                    } catch (java.lang.Exception unused9) {
                        inputStream5 = null;
                    } catch (java.lang.Throwable th2) {
                        r2 = httpURLConnection;
                        th = th2;
                        r10 = 0;
                        r8 = r82;
                        r9 = inputStream4;
                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8);
                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9);
                        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10);
                        com.huawei.hms.opendevice.s.a((java.net.HttpURLConnection) r2);
                        com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                        throw th;
                    }
                } catch (java.io.IOException unused10) {
                    inputStream4 = null;
                    r82 = r82;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb52 = new java.lang.StringBuilder();
                    sb52.append("http execute encounter IOException - http code:");
                    sb52.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb52.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.RuntimeException unused11) {
                    inputStream4 = null;
                    r82 = r82;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb222 = new java.lang.StringBuilder();
                    sb222.append("http execute encounter RuntimeException - http code:");
                    sb222.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb222.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.Exception unused12) {
                    inputStream4 = null;
                    r82 = r82;
                    inputStream5 = inputStream4;
                    java.lang.StringBuilder sb322 = new java.lang.StringBuilder();
                    sb322.append("http execute encounter unknown exception - http code:");
                    sb322.append(i);
                    com.huawei.hms.support.log.HMSLog.w("PushHttpClient", sb322.toString());
                    outputStream = r82;
                    inputStream6 = inputStream4;
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(outputStream);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream6);
                    com.huawei.secure.android.common.util.IOUtil.closeSecure(inputStream5);
                    com.huawei.hms.opendevice.s.a(httpURLConnection);
                    com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (java.lang.Throwable th3) {
                    r10 = 0;
                    r2 = httpURLConnection;
                    th = th3;
                    r9 = 0;
                    r8 = r82;
                }
            } catch (java.lang.Throwable th4) {
                r2 = context;
                th = th4;
                r8 = str;
                r9 = str2;
                r10 = map;
            }
        } catch (java.io.IOException unused13) {
            httpURLConnection = null;
            inputStream3 = null;
        } catch (java.lang.RuntimeException unused14) {
            httpURLConnection = null;
            inputStream2 = null;
        } catch (java.lang.Exception unused15) {
            httpURLConnection = null;
            inputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            r8 = 0;
            r9 = 0;
            r10 = 0;
        }
    }

    public static java.net.HttpURLConnection a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                java.lang.String key = entry.getKey();
                if (key != null && !android.text.TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, java.net.URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(android.content.Context context, java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        com.huawei.secure.android.common.ssl.SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(context);
            } catch (java.io.IOException unused) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            } catch (java.lang.IllegalAccessException unused2) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            } catch (java.lang.IllegalArgumentException unused3) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            } catch (java.security.KeyStoreException unused4) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            } catch (java.security.NoSuchAlgorithmException unused5) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            } catch (java.security.GeneralSecurityException unused6) {
                com.huawei.hms.support.log.HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory == null) {
                }
            }
            if (secureSSLSocketFactory == null) {
                throw new java.lang.Exception("No ssl socket factory set.");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
    }
}
