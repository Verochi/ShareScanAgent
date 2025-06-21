package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class a0 {

    public static class a extends java.lang.Exception {
        public a(java.lang.String str) {
            super(str);
        }
    }

    public static com.huawei.hms.hatool.b0 a(java.lang.String str, byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.Closeable] */
    public static com.huawei.hms.hatool.b0 a(java.lang.String str, byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new com.huawei.hms.hatool.b0(-100, "");
        }
        java.io.BufferedOutputStream bufferedOutputStream = null;
        int i = com.anythink.basead.ui.d.a.c;
        try {
            try {
                str = a((java.lang.String) str, bArr.length, (java.util.Map<java.lang.String, java.lang.String>) map, str2);
                try {
                    if (str == 0) {
                        com.huawei.hms.hatool.b0 b0Var = new com.huawei.hms.hatool.b0(com.anythink.basead.ui.d.a.b, "");
                        com.huawei.hms.hatool.t0.a((java.io.Closeable) null);
                        com.huawei.hms.hatool.t0.a((java.io.Closeable) null);
                        if (str != 0) {
                            com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                        }
                        return b0Var;
                    }
                    map = str.getOutputStream();
                    try {
                        java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(map);
                        try {
                            try {
                                bufferedOutputStream2.write(bArr);
                                bufferedOutputStream2.flush();
                                int responseCode = str.getResponseCode();
                                try {
                                    com.huawei.hms.hatool.b0 b0Var2 = new com.huawei.hms.hatool.b0(responseCode, b(str));
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream2);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    return b0Var2;
                                } catch (java.lang.SecurityException unused) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                                    com.huawei.hms.hatool.b0 b0Var3 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var3;
                                } catch (java.net.ConnectException unused2) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "Network is unreachable or Connection refused");
                                    com.huawei.hms.hatool.b0 b0Var4 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var4;
                                } catch (java.net.UnknownHostException unused3) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "No address associated with hostname or No network");
                                    com.huawei.hms.hatool.b0 b0Var5 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var5;
                                } catch (javax.net.ssl.SSLHandshakeException unused4) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "Chain validation failed,Certificate expired");
                                    com.huawei.hms.hatool.b0 b0Var6 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var6;
                                } catch (javax.net.ssl.SSLPeerUnverifiedException unused5) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                                    com.huawei.hms.hatool.b0 b0Var7 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var7;
                                } catch (java.io.IOException unused6) {
                                    i = responseCode;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    com.huawei.hms.hatool.y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                                    com.huawei.hms.hatool.b0 b0Var8 = new com.huawei.hms.hatool.b0(i, "");
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                    com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                    if (str != 0) {
                                        com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                    }
                                    return b0Var8;
                                }
                            } catch (com.huawei.hms.hatool.a0.a unused7) {
                                bufferedOutputStream = bufferedOutputStream2;
                                com.huawei.hms.hatool.y.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                                com.huawei.hms.hatool.b0 b0Var9 = new com.huawei.hms.hatool.b0(com.anythink.basead.ui.d.a.b, "");
                                com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                if (str != 0) {
                                    com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                }
                                return b0Var9;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                com.huawei.hms.hatool.t0.a((java.io.Closeable) bufferedOutputStream);
                                com.huawei.hms.hatool.t0.a((java.io.Closeable) map);
                                if (str != 0) {
                                    com.huawei.hms.hatool.t0.a((java.net.HttpURLConnection) str);
                                }
                                throw th;
                            }
                        } catch (java.lang.SecurityException unused8) {
                        } catch (java.net.ConnectException unused9) {
                        } catch (java.net.UnknownHostException unused10) {
                        } catch (javax.net.ssl.SSLHandshakeException unused11) {
                        } catch (javax.net.ssl.SSLPeerUnverifiedException unused12) {
                        } catch (java.io.IOException unused13) {
                        }
                    } catch (com.huawei.hms.hatool.a0.a unused14) {
                    } catch (java.lang.SecurityException unused15) {
                    } catch (java.net.ConnectException unused16) {
                    } catch (java.net.UnknownHostException unused17) {
                    } catch (javax.net.ssl.SSLHandshakeException unused18) {
                    } catch (javax.net.ssl.SSLPeerUnverifiedException unused19) {
                    } catch (java.io.IOException unused20) {
                    }
                } catch (com.huawei.hms.hatool.a0.a unused21) {
                    map = 0;
                } catch (java.lang.SecurityException unused22) {
                    map = 0;
                } catch (java.net.ConnectException unused23) {
                    map = 0;
                } catch (java.net.UnknownHostException unused24) {
                    map = 0;
                } catch (javax.net.ssl.SSLHandshakeException unused25) {
                    map = 0;
                } catch (javax.net.ssl.SSLPeerUnverifiedException unused26) {
                    map = 0;
                } catch (java.io.IOException unused27) {
                    map = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    map = 0;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (com.huawei.hms.hatool.a0.a unused28) {
            str = 0;
            map = 0;
        } catch (java.lang.SecurityException unused29) {
            str = 0;
            map = 0;
        } catch (java.net.ConnectException unused30) {
            str = 0;
            map = 0;
        } catch (java.net.UnknownHostException unused31) {
            str = 0;
            map = 0;
        } catch (javax.net.ssl.SSLHandshakeException unused32) {
            str = 0;
            map = 0;
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused33) {
            str = 0;
            map = 0;
        } catch (java.io.IOException unused34) {
            str = 0;
            map = 0;
        } catch (java.lang.Throwable th4) {
            th = th4;
            str = 0;
            map = 0;
        }
    }

    public static java.net.HttpURLConnection a(java.lang.String str, int i, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.hatool.y.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(i));
        httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                java.lang.String key = entry.getKey();
                if (key != null && !android.text.TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.net.HttpURLConnection httpURLConnection) {
        java.lang.String str;
        com.huawei.secure.android.common.ssl.SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(com.huawei.hms.hatool.b.i());
            } catch (java.io.IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (java.lang.IllegalAccessException unused2) {
                str = "getSocketFactory(): Illegal Access Exception ";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (java.security.KeyStoreException unused3) {
                str = "getSocketFactory(): Key Store exception";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (java.security.NoSuchAlgorithmException unused4) {
                str = "getSocketFactory(): Algorithm Exception!";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            } catch (java.security.GeneralSecurityException unused5) {
                str = "getSocketFactory(): General Security Exception";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                secureSSLSocketFactory = null;
                if (secureSSLSocketFactory != null) {
                }
            }
            if (secureSSLSocketFactory != null) {
                throw new com.huawei.hms.hatool.a0.a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier());
        }
    }

    public static java.lang.String b(java.net.HttpURLConnection httpURLConnection) {
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return com.huawei.hms.hatool.t0.a(inputStream);
            } catch (java.io.IOException unused) {
                com.huawei.hms.hatool.y.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
                com.huawei.hms.hatool.t0.a((java.io.Closeable) inputStream);
                return "";
            }
        } finally {
            com.huawei.hms.hatool.t0.a((java.io.Closeable) inputStream);
        }
    }
}
