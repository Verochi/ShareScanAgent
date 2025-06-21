package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bv {
    private static final java.lang.String a = "HttpClient";
    private static javax.net.ssl.HostnameVerifier f;
    private java.lang.String b;
    private com.umeng.analytics.pro.bv.a c;
    private java.util.Map<java.lang.String, java.lang.String> d;
    private com.umeng.analytics.pro.bw e;

    /* renamed from: com.umeng.analytics.pro.bv$1, reason: invalid class name */
    public static class AnonymousClass1 implements javax.net.ssl.HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return !android.text.TextUtils.isEmpty(str) && com.umeng.analytics.pro.bt.a.equalsIgnoreCase(str);
        }
    }

    public enum a {
        POST,
        GET
    }

    public bv(java.lang.String str, com.umeng.analytics.pro.bv.a aVar, java.util.Map<java.lang.String, java.lang.String> map, com.umeng.analytics.pro.bw bwVar) {
        this.b = str;
        this.c = aVar;
        this.d = map;
        this.e = bwVar;
    }

    private static javax.net.ssl.HostnameVerifier a() {
        if (f == null) {
            f = new com.umeng.analytics.pro.bv.AnonymousClass1();
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ef, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e5, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        if (r1 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i, java.lang.String str) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(this.b).openConnection();
            try {
                javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new java.security.SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(a());
                java.util.Map<java.lang.String, java.lang.String> map = this.d;
                if (map != null && !map.isEmpty()) {
                    for (java.lang.String str2 : this.d.keySet()) {
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            httpsURLConnection.setRequestProperty(str2, this.d.get(str2));
                        }
                    }
                }
                httpsURLConnection.setConnectTimeout(i);
                httpsURLConnection.setReadTimeout(i);
                if (this.c == com.umeng.analytics.pro.bv.a.POST) {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDefaultUseCaches(false);
                    if (!android.text.TextUtils.isEmpty(str)) {
                        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(httpsURLConnection.getOutputStream());
                        outputStreamWriter.write(str);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                    }
                    httpsURLConnection.connect();
                } else {
                    httpsURLConnection.setRequestMethod("GET");
                }
                if (httpsURLConnection.getResponseCode() == 200) {
                    java.io.InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] readStreamToByteArray = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(inputStream);
                    java.lang.String str3 = "";
                    if (readStreamToByteArray != null) {
                        try {
                            if (readStreamToByteArray.length > 1) {
                                str3 = new java.lang.String(readStreamToByteArray);
                            }
                        } finally {
                            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(inputStream);
                        }
                    }
                    com.umeng.analytics.pro.bw bwVar = this.e;
                    if (bwVar != null) {
                        bwVar.a(str3);
                    }
                    httpsURLConnection.disconnect();
                    return str3;
                }
            } catch (java.net.MalformedURLException unused) {
            } catch (java.net.SocketTimeoutException unused2) {
            } catch (java.net.UnknownHostException unused3) {
            } catch (javax.net.ssl.SSLHandshakeException unused4) {
            } catch (java.io.IOException unused5) {
            } catch (java.lang.Throwable unused6) {
            }
        } catch (java.net.MalformedURLException unused7) {
            httpsURLConnection = null;
        } catch (java.net.SocketTimeoutException unused8) {
            httpsURLConnection = null;
        } catch (java.net.UnknownHostException unused9) {
            httpsURLConnection = null;
        } catch (javax.net.ssl.SSLHandshakeException unused10) {
            httpsURLConnection = null;
        } catch (java.io.IOException unused11) {
            httpsURLConnection = null;
        } catch (java.lang.Throwable unused12) {
            httpsURLConnection = null;
        }
        httpsURLConnection.disconnect();
        return null;
    }
}
