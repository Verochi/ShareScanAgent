package com.aliyun.common.network;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AlivcHttp {

    public class a implements javax.net.ssl.X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    }

    public class b implements javax.net.ssl.HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return true;
        }
    }

    public static boolean isHttps(com.aliyun.common.network.AlivcHttpRequest alivcHttpRequest) {
        return alivcHttpRequest.getUrl().startsWith("https://");
    }

    public static boolean needOutput(com.aliyun.common.network.AlivcHttpRequest alivcHttpRequest) {
        return ((alivcHttpRequest != null) && ("POST".equalsIgnoreCase(alivcHttpRequest.getMethod()) || "PUT".equalsIgnoreCase(alivcHttpRequest.getMethod()))) && alivcHttpRequest.getBody() != null && alivcHttpRequest.getBody().length > 0;
    }

    private static java.lang.String readStream(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return "";
        }
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
        byte[] bArr = new byte[4096];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0275, code lost:
    
        if (r9 == null) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0181: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:132:0x017f */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x018c: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:128:0x018a */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0197: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:126:0x0195 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01a2: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:124:0x01a0 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01ad: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:130:0x01ab */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x02a3: IF  (r9 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:169:0x02a8, block:B:167:0x02a3 */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.aliyun.common.network.AlivcHttpResponse request(com.aliyun.common.network.AlivcHttpRequest alivcHttpRequest) {
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2;
        long j;
        long j2;
        long j3;
        long j4;
        com.aliyun.common.network.AlivcHttpResponse alivcHttpResponse;
        long j5;
        long j6;
        java.net.HttpURLConnection httpURLConnection3;
        com.aliyun.common.network.AlivcHttpResponse alivcHttpResponse2;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        java.io.OutputStream outputStream;
        int responseCode;
        java.io.InputStream inputStream;
        java.lang.String responseMessage;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields;
        long elapsedRealtime;
        long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
        java.io.InputStream inputStream2 = null;
        try {
            try {
                httpURLConnection3 = (java.net.HttpURLConnection) new java.net.URL(alivcHttpRequest.getUrl()).openConnection();
            } catch (java.lang.Throwable th) {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (java.net.MalformedURLException e) {
            e = e;
            httpURLConnection = null;
        } catch (java.net.SocketTimeoutException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (java.net.UnknownHostException e3) {
            e = e3;
            httpURLConnection = null;
        } catch (javax.net.ssl.SSLException e4) {
            e = e4;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            if (trustAllSSLCert(alivcHttpRequest) && isHttps(alivcHttpRequest)) {
                skipSSLVerification((javax.net.ssl.HttpsURLConnection) httpURLConnection3);
            }
            httpURLConnection3.setReadTimeout(alivcHttpRequest.getReadTimeout());
            httpURLConnection3.setConnectTimeout(alivcHttpRequest.getConnectTimeout());
            httpURLConnection3.setInstanceFollowRedirects(alivcHttpRequest.isFollowRedirects());
            httpURLConnection3.setRequestMethod(alivcHttpRequest.getMethod());
            httpURLConnection3.setDoInput(true);
            httpURLConnection3.setUseCaches(false);
            boolean needOutput = needOutput(alivcHttpRequest);
            if (needOutput) {
                httpURLConnection3.setDoOutput(true);
            }
            java.util.Map<java.lang.String, java.lang.String> headers = alivcHttpRequest.getHeaders();
            for (java.lang.String str : headers.keySet()) {
                httpURLConnection3.addRequestProperty(str, headers.get(str));
            }
            long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime();
            try {
                httpURLConnection3.connect();
                j7 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime3;
                try {
                    if (needOutput) {
                        try {
                            long elapsedRealtime4 = android.os.SystemClock.elapsedRealtime();
                            try {
                                outputStream = httpURLConnection3.getOutputStream();
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                            try {
                                outputStream.write(alivcHttpRequest.getBody());
                                outputStream.flush();
                                safeClose(outputStream);
                                j5 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime4;
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                inputStream2 = outputStream;
                                safeClose(inputStream2);
                                long elapsedRealtime5 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime4;
                                throw th;
                            }
                        } catch (java.net.MalformedURLException e5) {
                            e = e5;
                            httpURLConnection = httpURLConnection3;
                            j = j7;
                            j2 = -1;
                            j3 = -1;
                            j4 = -1;
                            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-3, e.getMessage());
                            if (httpURLConnection != null) {
                            }
                            j5 = j4;
                            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics = alivcHttpResponse.metrics;
                            alivcHttpMetrics.connectTimeMs = j;
                            alivcHttpMetrics.sendTimeMs = j5;
                            alivcHttpMetrics.responseTimeMs = j3;
                            alivcHttpMetrics.readTimeMs = j2;
                            return alivcHttpResponse;
                        } catch (java.net.SocketTimeoutException e6) {
                            e = e6;
                            httpURLConnection = httpURLConnection3;
                            j = j7;
                            j2 = -1;
                            j3 = -1;
                            j4 = -1;
                            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-4, e.getMessage());
                            if (httpURLConnection != null) {
                            }
                            j5 = j4;
                            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2 = alivcHttpResponse.metrics;
                            alivcHttpMetrics2.connectTimeMs = j;
                            alivcHttpMetrics2.sendTimeMs = j5;
                            alivcHttpMetrics2.responseTimeMs = j3;
                            alivcHttpMetrics2.readTimeMs = j2;
                            return alivcHttpResponse;
                        } catch (java.net.UnknownHostException e7) {
                            e = e7;
                            httpURLConnection = httpURLConnection3;
                            j = j7;
                            j2 = -1;
                            j3 = -1;
                            j4 = -1;
                            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-5, e.getMessage());
                            if (httpURLConnection != null) {
                            }
                            j5 = j4;
                            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22 = alivcHttpResponse.metrics;
                            alivcHttpMetrics22.connectTimeMs = j;
                            alivcHttpMetrics22.sendTimeMs = j5;
                            alivcHttpMetrics22.responseTimeMs = j3;
                            alivcHttpMetrics22.readTimeMs = j2;
                            return alivcHttpResponse;
                        } catch (javax.net.ssl.SSLException e8) {
                            e = e8;
                            httpURLConnection = httpURLConnection3;
                            j = j7;
                            j2 = -1;
                            j3 = -1;
                            j4 = -1;
                            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-2, e.getMessage());
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            httpURLConnection = httpURLConnection3;
                            j = j7;
                            j2 = -1;
                            j3 = -1;
                            j4 = -1;
                            th.printStackTrace();
                            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-1, th.getClass().getSimpleName() + ": " + th.getMessage());
                            if (httpURLConnection != null) {
                            }
                            j5 = j4;
                            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222 = alivcHttpResponse.metrics;
                            alivcHttpMetrics222.connectTimeMs = j;
                            alivcHttpMetrics222.sendTimeMs = j5;
                            alivcHttpMetrics222.responseTimeMs = j3;
                            alivcHttpMetrics222.readTimeMs = j2;
                            return alivcHttpResponse;
                        }
                    } else {
                        j5 = 0;
                    }
                    responseCode = httpURLConnection3.getResponseCode();
                    j3 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                } catch (java.net.MalformedURLException e9) {
                    e = e9;
                    httpURLConnection = httpURLConnection3;
                    j = j7;
                    j4 = j12;
                    j2 = -1;
                    j3 = -1;
                } catch (java.net.SocketTimeoutException e10) {
                    e = e10;
                    httpURLConnection = httpURLConnection3;
                    j = j7;
                    j4 = j11;
                    j2 = -1;
                    j3 = -1;
                } catch (java.net.UnknownHostException e11) {
                    e = e11;
                    httpURLConnection = httpURLConnection3;
                    j = j7;
                    j4 = j10;
                    j2 = -1;
                    j3 = -1;
                } catch (javax.net.ssl.SSLException e12) {
                    e = e12;
                    httpURLConnection = httpURLConnection3;
                    j = j7;
                    j4 = j9;
                    j2 = -1;
                    j3 = -1;
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection3;
                    j = j7;
                    j4 = j8;
                    j2 = -1;
                    j3 = -1;
                }
            } catch (java.lang.Throwable th7) {
                long elapsedRealtime6 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime3;
                try {
                    throw th7;
                } catch (java.net.MalformedURLException e13) {
                    e = e13;
                    j = elapsedRealtime6;
                    httpURLConnection = httpURLConnection3;
                    j2 = -1;
                    j3 = -1;
                    j4 = -1;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-3, e.getMessage());
                    if (httpURLConnection != null) {
                        j5 = j4;
                        j6 = j2;
                        httpURLConnection3 = httpURLConnection;
                        alivcHttpResponse2 = alivcHttpResponse;
                        j7 = j;
                        httpURLConnection3.disconnect();
                        j2 = j6;
                        long j13 = j7;
                        alivcHttpResponse = alivcHttpResponse2;
                        j = j13;
                        alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                        com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222 = alivcHttpResponse.metrics;
                        alivcHttpMetrics2222.connectTimeMs = j;
                        alivcHttpMetrics2222.sendTimeMs = j5;
                        alivcHttpMetrics2222.responseTimeMs = j3;
                        alivcHttpMetrics2222.readTimeMs = j2;
                        return alivcHttpResponse;
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics22222.connectTimeMs = j;
                    alivcHttpMetrics22222.sendTimeMs = j5;
                    alivcHttpMetrics22222.responseTimeMs = j3;
                    alivcHttpMetrics22222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (java.net.SocketTimeoutException e14) {
                    e = e14;
                    j = elapsedRealtime6;
                    httpURLConnection = httpURLConnection3;
                    j2 = -1;
                    j3 = -1;
                    j4 = -1;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-4, e.getMessage());
                    if (httpURLConnection != null) {
                        j5 = j4;
                        j6 = j2;
                        httpURLConnection3 = httpURLConnection;
                        alivcHttpResponse2 = alivcHttpResponse;
                        j7 = j;
                        httpURLConnection3.disconnect();
                        j2 = j6;
                        long j132 = j7;
                        alivcHttpResponse = alivcHttpResponse2;
                        j = j132;
                        alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                        com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222 = alivcHttpResponse.metrics;
                        alivcHttpMetrics222222.connectTimeMs = j;
                        alivcHttpMetrics222222.sendTimeMs = j5;
                        alivcHttpMetrics222222.responseTimeMs = j3;
                        alivcHttpMetrics222222.readTimeMs = j2;
                        return alivcHttpResponse;
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics2222222.connectTimeMs = j;
                    alivcHttpMetrics2222222.sendTimeMs = j5;
                    alivcHttpMetrics2222222.responseTimeMs = j3;
                    alivcHttpMetrics2222222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (java.net.UnknownHostException e15) {
                    e = e15;
                    j = elapsedRealtime6;
                    httpURLConnection = httpURLConnection3;
                    j2 = -1;
                    j3 = -1;
                    j4 = -1;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-5, e.getMessage());
                    if (httpURLConnection != null) {
                        j5 = j4;
                        j6 = j2;
                        httpURLConnection3 = httpURLConnection;
                        alivcHttpResponse2 = alivcHttpResponse;
                        j7 = j;
                        httpURLConnection3.disconnect();
                        j2 = j6;
                        long j1322 = j7;
                        alivcHttpResponse = alivcHttpResponse2;
                        j = j1322;
                        alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                        com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222 = alivcHttpResponse.metrics;
                        alivcHttpMetrics22222222.connectTimeMs = j;
                        alivcHttpMetrics22222222.sendTimeMs = j5;
                        alivcHttpMetrics22222222.responseTimeMs = j3;
                        alivcHttpMetrics22222222.readTimeMs = j2;
                        return alivcHttpResponse;
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics222222222.connectTimeMs = j;
                    alivcHttpMetrics222222222.sendTimeMs = j5;
                    alivcHttpMetrics222222222.responseTimeMs = j3;
                    alivcHttpMetrics222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (javax.net.ssl.SSLException e16) {
                    e = e16;
                    j = elapsedRealtime6;
                    httpURLConnection = httpURLConnection3;
                    j2 = -1;
                    j3 = -1;
                    j4 = -1;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-2, e.getMessage());
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    j = elapsedRealtime6;
                    httpURLConnection = httpURLConnection3;
                    j2 = -1;
                    j3 = -1;
                    j4 = -1;
                    th.printStackTrace();
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-1, th.getClass().getSimpleName() + ": " + th.getMessage());
                    if (httpURLConnection != null) {
                        j5 = j4;
                        j6 = j2;
                        httpURLConnection3 = httpURLConnection;
                        alivcHttpResponse2 = alivcHttpResponse;
                        j7 = j;
                        httpURLConnection3.disconnect();
                        j2 = j6;
                        long j13222 = j7;
                        alivcHttpResponse = alivcHttpResponse2;
                        j = j13222;
                        alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                        com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222 = alivcHttpResponse.metrics;
                        alivcHttpMetrics2222222222.connectTimeMs = j;
                        alivcHttpMetrics2222222222.sendTimeMs = j5;
                        alivcHttpMetrics2222222222.responseTimeMs = j3;
                        alivcHttpMetrics2222222222.readTimeMs = j2;
                        return alivcHttpResponse;
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics22222222222.connectTimeMs = j;
                    alivcHttpMetrics22222222222.sendTimeMs = j5;
                    alivcHttpMetrics22222222222.responseTimeMs = j3;
                    alivcHttpMetrics22222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                }
            }
        } catch (java.net.MalformedURLException e17) {
            e = e17;
            httpURLConnection = httpURLConnection3;
            j = -1;
            j2 = -1;
            j3 = -1;
            j4 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-3, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics222222222222.connectTimeMs = j;
            alivcHttpMetrics222222222222.sendTimeMs = j5;
            alivcHttpMetrics222222222222.responseTimeMs = j3;
            alivcHttpMetrics222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (java.net.SocketTimeoutException e18) {
            e = e18;
            httpURLConnection = httpURLConnection3;
            j = -1;
            j2 = -1;
            j3 = -1;
            j4 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-4, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics2222222222222.connectTimeMs = j;
            alivcHttpMetrics2222222222222.sendTimeMs = j5;
            alivcHttpMetrics2222222222222.responseTimeMs = j3;
            alivcHttpMetrics2222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (java.net.UnknownHostException e19) {
            e = e19;
            httpURLConnection = httpURLConnection3;
            j = -1;
            j2 = -1;
            j3 = -1;
            j4 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-5, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics22222222222222.connectTimeMs = j;
            alivcHttpMetrics22222222222222.sendTimeMs = j5;
            alivcHttpMetrics22222222222222.responseTimeMs = j3;
            alivcHttpMetrics22222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (javax.net.ssl.SSLException e20) {
            e = e20;
            httpURLConnection = httpURLConnection3;
            j = -1;
            j2 = -1;
            j3 = -1;
            j4 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-2, e.getMessage());
        } catch (java.lang.Throwable th9) {
            th = th9;
            httpURLConnection = httpURLConnection3;
            j = -1;
            j2 = -1;
            j3 = -1;
            j4 = -1;
            th.printStackTrace();
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-1, th.getClass().getSimpleName() + ": " + th.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics222222222222222.connectTimeMs = j;
            alivcHttpMetrics222222222222222.sendTimeMs = j5;
            alivcHttpMetrics222222222222222.responseTimeMs = j3;
            alivcHttpMetrics222222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        }
        try {
            try {
                responseMessage = httpURLConnection3.getResponseMessage();
                headerFields = httpURLConnection3.getHeaderFields();
                elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            } catch (java.lang.Throwable th10) {
                th = th10;
            }
            try {
                inputStream = httpURLConnection3.getInputStream();
                try {
                    java.lang.String readStream = readStream(inputStream);
                    alivcHttpResponse2 = new com.aliyun.common.network.AlivcHttpResponse(responseCode, responseMessage);
                    alivcHttpResponse2.setBody(readStream);
                    alivcHttpResponse2.setResponseHeaders(headerFields);
                    safeClose(inputStream);
                } catch (java.io.IOException unused) {
                    inputStream2 = httpURLConnection3.getErrorStream();
                    java.lang.String readStream2 = readStream(inputStream2);
                    alivcHttpResponse2 = new com.aliyun.common.network.AlivcHttpResponse(responseCode, responseMessage);
                    alivcHttpResponse2.setBody(readStream2);
                    alivcHttpResponse2.setResponseHeaders(headerFields);
                    safeClose(inputStream);
                    safeClose(inputStream2);
                    j6 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
                    httpURLConnection3.disconnect();
                    j2 = j6;
                    long j132222 = j7;
                    alivcHttpResponse = alivcHttpResponse2;
                    j = j132222;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics2222222222222222.connectTimeMs = j;
                    alivcHttpMetrics2222222222222222.sendTimeMs = j5;
                    alivcHttpMetrics2222222222222222.responseTimeMs = j3;
                    alivcHttpMetrics2222222222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                }
            } catch (java.io.IOException unused2) {
                inputStream = null;
            } catch (java.lang.Throwable th11) {
                th = th11;
                inputStream = null;
                safeClose(inputStream);
                safeClose(inputStream2);
                long elapsedRealtime7 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
                try {
                    throw th;
                } catch (java.net.MalformedURLException e21) {
                    e = e21;
                    httpURLConnection = httpURLConnection3;
                    j4 = j5;
                    j2 = elapsedRealtime7;
                    j = j7;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-3, e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics22222222222222222.connectTimeMs = j;
                    alivcHttpMetrics22222222222222222.sendTimeMs = j5;
                    alivcHttpMetrics22222222222222222.responseTimeMs = j3;
                    alivcHttpMetrics22222222222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (java.net.SocketTimeoutException e22) {
                    e = e22;
                    httpURLConnection = httpURLConnection3;
                    j4 = j5;
                    j2 = elapsedRealtime7;
                    j = j7;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-4, e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics222222222222222222.connectTimeMs = j;
                    alivcHttpMetrics222222222222222222.sendTimeMs = j5;
                    alivcHttpMetrics222222222222222222.responseTimeMs = j3;
                    alivcHttpMetrics222222222222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (java.net.UnknownHostException e23) {
                    e = e23;
                    httpURLConnection = httpURLConnection3;
                    j4 = j5;
                    j2 = elapsedRealtime7;
                    j = j7;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-5, e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics2222222222222222222.connectTimeMs = j;
                    alivcHttpMetrics2222222222222222222.sendTimeMs = j5;
                    alivcHttpMetrics2222222222222222222.responseTimeMs = j3;
                    alivcHttpMetrics2222222222222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                } catch (javax.net.ssl.SSLException e24) {
                    e = e24;
                    httpURLConnection = httpURLConnection3;
                    j4 = j5;
                    j2 = elapsedRealtime7;
                    j = j7;
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-2, e.getMessage());
                } catch (java.lang.Throwable th12) {
                    th = th12;
                    httpURLConnection = httpURLConnection3;
                    j4 = j5;
                    j2 = elapsedRealtime7;
                    j = j7;
                    th.printStackTrace();
                    alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-1, th.getClass().getSimpleName() + ": " + th.getMessage());
                    if (httpURLConnection != null) {
                    }
                    j5 = j4;
                    alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222222222222222 = alivcHttpResponse.metrics;
                    alivcHttpMetrics22222222222222222222.connectTimeMs = j;
                    alivcHttpMetrics22222222222222222222.sendTimeMs = j5;
                    alivcHttpMetrics22222222222222222222.responseTimeMs = j3;
                    alivcHttpMetrics22222222222222222222.readTimeMs = j2;
                    return alivcHttpResponse;
                }
            }
            safeClose(inputStream2);
            j6 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
        } catch (java.net.MalformedURLException e25) {
            e = e25;
            httpURLConnection = httpURLConnection3;
            j = j7;
            j4 = j5;
            j2 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-3, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics222222222222222222222.connectTimeMs = j;
            alivcHttpMetrics222222222222222222222.sendTimeMs = j5;
            alivcHttpMetrics222222222222222222222.responseTimeMs = j3;
            alivcHttpMetrics222222222222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (java.net.SocketTimeoutException e26) {
            e = e26;
            httpURLConnection = httpURLConnection3;
            j = j7;
            j4 = j5;
            j2 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-4, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics2222222222222222222222.connectTimeMs = j;
            alivcHttpMetrics2222222222222222222222.sendTimeMs = j5;
            alivcHttpMetrics2222222222222222222222.responseTimeMs = j3;
            alivcHttpMetrics2222222222222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (java.net.UnknownHostException e27) {
            e = e27;
            httpURLConnection = httpURLConnection3;
            j = j7;
            j4 = j5;
            j2 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-5, e.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics22222222222222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics22222222222222222222222.connectTimeMs = j;
            alivcHttpMetrics22222222222222222222222.sendTimeMs = j5;
            alivcHttpMetrics22222222222222222222222.responseTimeMs = j3;
            alivcHttpMetrics22222222222222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        } catch (javax.net.ssl.SSLException e28) {
            e = e28;
            httpURLConnection = httpURLConnection3;
            j = j7;
            j4 = j5;
            j2 = -1;
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-2, e.getMessage());
        } catch (java.lang.Throwable th13) {
            th = th13;
            httpURLConnection = httpURLConnection3;
            j = j7;
            j4 = j5;
            j2 = -1;
            th.printStackTrace();
            alivcHttpResponse = new com.aliyun.common.network.AlivcHttpResponse(-1, th.getClass().getSimpleName() + ": " + th.getMessage());
            if (httpURLConnection != null) {
            }
            j5 = j4;
            alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
            com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics222222222222222222222222 = alivcHttpResponse.metrics;
            alivcHttpMetrics222222222222222222222222.connectTimeMs = j;
            alivcHttpMetrics222222222222222222222222.sendTimeMs = j5;
            alivcHttpMetrics222222222222222222222222.responseTimeMs = j3;
            alivcHttpMetrics222222222222222222222222.readTimeMs = j2;
            return alivcHttpResponse;
        }
        httpURLConnection3.disconnect();
        j2 = j6;
        long j1322222 = j7;
        alivcHttpResponse = alivcHttpResponse2;
        j = j1322222;
        alivcHttpResponse.metrics.totalTimeMs = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
        com.aliyun.common.network.AlivcHttpMetrics alivcHttpMetrics2222222222222222222222222 = alivcHttpResponse.metrics;
        alivcHttpMetrics2222222222222222222222222.connectTimeMs = j;
        alivcHttpMetrics2222222222222222222222222.sendTimeMs = j5;
        alivcHttpMetrics2222222222222222222222222.responseTimeMs = j3;
        alivcHttpMetrics2222222222222222222222222.readTimeMs = j2;
        return alivcHttpResponse;
    }

    private static void safeClose(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void skipSSLVerification(javax.net.ssl.HttpsURLConnection httpsURLConnection) throws java.security.KeyManagementException, java.security.NoSuchAlgorithmException {
        javax.net.ssl.TrustManager[] trustManagerArr = {new com.aliyun.common.network.AlivcHttp.a()};
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new java.security.SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new com.aliyun.common.network.AlivcHttp.b());
    }

    public static boolean trustAllSSLCert(com.aliyun.common.network.AlivcHttpRequest alivcHttpRequest) {
        return alivcHttpRequest.isTrustAllSSLCert();
    }
}
