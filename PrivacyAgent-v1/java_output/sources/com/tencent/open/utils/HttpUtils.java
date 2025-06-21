package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class HttpUtils {

    /* renamed from: com.tencent.open.utils.HttpUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ com.tencent.connect.auth.QQToken a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ android.os.Bundle d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ com.tencent.tauth.IRequestListener f;

        public AnonymousClass1(com.tencent.connect.auth.QQToken qQToken, android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IRequestListener iRequestListener) {
            this.a = qQToken;
            this.b = context;
            this.c = str;
            this.d = bundle;
            this.e = str2;
            this.f = iRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject request = com.tencent.open.utils.HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
                com.tencent.tauth.IRequestListener iRequestListener = this.f;
                if (iRequestListener != null) {
                    iRequestListener.onComplete(request);
                    com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                }
            } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e) {
                com.tencent.tauth.IRequestListener iRequestListener2 = this.f;
                if (iRequestListener2 != null) {
                    iRequestListener2.onHttpStatusException(e);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e.toString());
                }
            } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException e2) {
                com.tencent.tauth.IRequestListener iRequestListener3 = this.f;
                if (iRequestListener3 != null) {
                    iRequestListener3.onNetworkUnavailableException(e2);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e2.toString());
                }
            } catch (java.net.MalformedURLException e3) {
                com.tencent.tauth.IRequestListener iRequestListener4 = this.f;
                if (iRequestListener4 != null) {
                    iRequestListener4.onMalformedURLException(e3);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e3.toString());
                }
            } catch (java.net.SocketTimeoutException e4) {
                com.tencent.tauth.IRequestListener iRequestListener5 = this.f;
                if (iRequestListener5 != null) {
                    iRequestListener5.onSocketTimeoutException(e4);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e4.toString());
                }
            } catch (org.apache.http.conn.ConnectTimeoutException e5) {
                com.tencent.tauth.IRequestListener iRequestListener6 = this.f;
                if (iRequestListener6 != null) {
                    iRequestListener6.onConnectTimeoutException(e5);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException" + e5.toString());
                }
            } catch (java.io.IOException e6) {
                com.tencent.tauth.IRequestListener iRequestListener7 = this.f;
                if (iRequestListener7 != null) {
                    iRequestListener7.onIOException(e6);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                }
            } catch (org.json.JSONException e7) {
                com.tencent.tauth.IRequestListener iRequestListener8 = this.f;
                if (iRequestListener8 != null) {
                    iRequestListener8.onJSONException(e7);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                }
            } catch (java.lang.Exception e8) {
                com.tencent.tauth.IRequestListener iRequestListener9 = this.f;
                if (iRequestListener9 != null) {
                    iRequestListener9.onUnknowException(e8);
                    com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                }
            }
        }
    }

    public static class HttpStatusException extends java.lang.Exception {
        public static final java.lang.String ERROR_INFO = "http status code error:";

        public HttpStatusException(java.lang.String str) {
            super(str);
        }
    }

    public static class NetworkUnavailableException extends java.lang.Exception {
        public static final java.lang.String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(java.lang.String str) {
            super(str);
        }
    }

    public static class a {
        public final java.lang.String a;
        public final int b;

        private a(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        public /* synthetic */ a(java.lang.String str, int i, com.tencent.open.utils.HttpUtils.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }
    }

    private HttpUtils() {
    }

    private static int a(android.content.Context context) {
        java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
        if (!android.text.TextUtils.isEmpty(property)) {
            try {
                return java.lang.Integer.parseInt(property);
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return -1;
    }

    private static java.lang.String a(org.apache.http.HttpResponse httpResponse) throws java.lang.IllegalStateException, java.io.IOException {
        java.io.InputStream content = httpResponse.getEntity().getContent();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        org.apache.http.Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
            content = new java.util.zip.GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = content.read(bArr);
            if (read == -1) {
                java.lang.String str = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                content.close();
                return str;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken, java.lang.String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static java.lang.String b(android.content.Context context) {
        return java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
    }

    public static java.lang.String encodePostBody(android.os.Bundle bundle, java.lang.String str) {
        if (bundle == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (java.lang.String str2 : bundle.keySet()) {
            i++;
            java.lang.Object obj = bundle.get(str2);
            if (obj instanceof java.lang.String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((java.lang.String) obj));
                if (i < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String encodeUrl(android.os.Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : bundle.keySet()) {
            java.lang.Object obj = bundle.get(str);
            if ((obj instanceof java.lang.String) || (obj instanceof java.lang.String[])) {
                if (obj instanceof java.lang.String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(java.net.URLEncoder.encode(str) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    java.lang.String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(java.net.URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(java.net.URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(java.net.URLEncoder.encode(str) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.net.URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static int getErrorCodeFromException(java.io.IOException iOException) {
        if (iOException instanceof java.io.CharConversionException) {
            return -20;
        }
        if (iOException instanceof java.nio.charset.MalformedInputException) {
            return -21;
        }
        if (iOException instanceof java.nio.charset.UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof org.apache.http.client.HttpResponseException) {
            return -23;
        }
        if (iOException instanceof java.nio.channels.ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof org.apache.http.ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof java.io.EOFException) {
            return -26;
        }
        if (iOException instanceof java.nio.channels.FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof java.io.FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof java.net.HttpRetryException) {
            return -29;
        }
        if (iOException instanceof org.apache.http.conn.ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof java.net.SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof java.util.InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof org.apache.http.MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof java.net.MalformedURLException) {
            return -3;
        }
        if (iOException instanceof org.apache.http.NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof java.io.InvalidClassException) {
            return -33;
        }
        if (iOException instanceof java.io.InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof java.io.NotActiveException) {
            return -35;
        }
        if (iOException instanceof java.io.NotSerializableException) {
            return -36;
        }
        if (iOException instanceof java.io.OptionalDataException) {
            return -37;
        }
        if (iOException instanceof java.io.StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof java.io.WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof java.net.ProtocolException) {
            return -40;
        }
        if (iOException instanceof javax.net.ssl.SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof javax.net.ssl.SSLKeyException) {
            return -42;
        }
        if (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof javax.net.ssl.SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof java.net.BindException) {
            return -45;
        }
        if (iOException instanceof java.net.ConnectException) {
            return -46;
        }
        if (iOException instanceof java.net.NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof java.net.PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof java.io.SyncFailedException) {
            return -49;
        }
        if (iOException instanceof java.io.UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof java.net.UnknownHostException) {
            return -51;
        }
        if (iOException instanceof java.net.UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof java.io.UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof java.util.zip.ZipException ? -54 : -2;
    }

    public static org.apache.http.client.HttpClient getHttpClient(android.content.Context context, java.lang.String str, java.lang.String str2) {
        int i;
        int i2;
        org.apache.http.conn.scheme.SchemeRegistry schemeRegistry = new org.apache.http.conn.scheme.SchemeRegistry();
        schemeRegistry.register(new org.apache.http.conn.scheme.Scheme(com.alipay.sdk.m.l.a.q, org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                org.apache.http.conn.ssl.SSLSocketFactory socketFactory = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", socketFactory, 443));
            } else {
                schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", new com.tencent.open.utils.k(), 443));
            }
        } catch (java.lang.Exception unused) {
            schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
        }
        org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
        com.tencent.open.utils.g a2 = context != null ? com.tencent.open.utils.g.a(context, str) : null;
        if (a2 != null) {
            i = a2.a("Common_HttpConnectionTimeout");
            i2 = a2.a("Common_SocketConnectionTimeout");
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0) {
            i = 15000;
        }
        if (i2 == 0) {
            i2 = 30000;
        }
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        org.apache.http.params.HttpProtocolParams.setVersion(basicHttpParams, org.apache.http.HttpVersion.HTTP_1_1);
        org.apache.http.params.HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        org.apache.http.params.HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + android.os.Build.VERSION.SDK + "_" + android.os.Build.DEVICE + "_" + android.os.Build.VERSION.RELEASE);
        org.apache.http.impl.client.DefaultHttpClient defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient(new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        com.tencent.open.utils.HttpUtils.a proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new org.apache.http.HttpHost(proxy.a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static com.tencent.open.utils.HttpUtils.a getProxy(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
            java.lang.String b = b(context);
            int a2 = a(context);
            if (!android.text.TextUtils.isEmpty(b) && a2 >= 0) {
                return new com.tencent.open.utils.HttpUtils.a(b, a2, null);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.tencent.open.utils.l.a openUrl2(android.content.Context context, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) throws java.net.MalformedURLException, java.io.IOException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        org.apache.http.client.methods.HttpGet httpGet;
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            throw new com.tencent.open.utils.HttpUtils.NetworkUnavailableException(com.tencent.open.utils.HttpUtils.NetworkUnavailableException.ERROR_INFO);
        }
        android.os.Bundle bundle2 = bundle != null ? new android.os.Bundle(bundle) : new android.os.Bundle();
        java.lang.String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        org.apache.http.client.HttpClient httpClient = getHttpClient(context, string, str);
        int i = -1;
        int i2 = 0;
        if (str2.equals("GET")) {
            java.lang.String encodeUrl = encodeUrl(bundle2);
            i2 = 0 + encodeUrl.length();
            com.tencent.open.log.SLog.v("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            java.lang.String str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
            android.os.Bundle b = com.tencent.open.log.d.b(bundle2);
            if (b != bundle2) {
                com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl(b) + " -- url = " + str3);
            } else {
                com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
            }
            httpGet = new org.apache.http.client.methods.HttpGet(str3 + encodeUrl);
            httpGet.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        } else if (str2.equals("POST")) {
            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(str);
            httpPost.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            android.os.Bundle bundle3 = new android.os.Bundle();
            for (java.lang.String str4 : bundle2.keySet()) {
                java.lang.Object obj = bundle2.get(str4);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str4, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byteArrayOutputStream.write(com.tencent.open.utils.l.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(com.tencent.open.utils.l.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (java.lang.String str5 : bundle3.keySet()) {
                    i++;
                    byteArrayOutputStream.write(com.tencent.open.utils.l.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                    byteArrayOutputStream.write(com.tencent.open.utils.l.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i < size - 1) {
                        byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            i2 = 0 + byteArray2.length;
            byteArrayOutputStream.close();
            httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(byteArray2));
            httpGet = httpPost;
        } else {
            httpGet = null;
        }
        org.apache.http.HttpResponse execute = httpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =" + statusCode);
        if (statusCode == 200) {
            return new com.tencent.open.utils.l.a(a(execute), i2);
        }
        throw new com.tencent.open.utils.HttpUtils.HttpStatusException(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO + statusCode);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[LOOP:0: B:8:0x00af->B:49:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken qQToken, android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        java.lang.String str3;
        java.lang.String str4;
        int i;
        long j;
        long j2;
        int i2;
        int i3;
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q)) {
            str3 = str;
            str4 = str3;
        } else {
            str3 = com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/") + str;
            str4 = com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/") + str;
        }
        a(context, qQToken, str);
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int a2 = com.tencent.open.utils.g.a(context, qQToken.getAppId()).a("Common_HttpRetryCount");
        com.tencent.open.log.SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + a2 + "   appid:" + qQToken.getAppId() + "     url:" + str4);
        if (a2 == 0) {
            a2 = 3;
        }
        com.tencent.open.log.SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + a2 + "   appid:" + qQToken.getAppId() + "     url:" + str4);
        org.json.JSONObject jSONObject = null;
        int i4 = 0;
        while (true) {
            i4++;
            try {
                try {
                    com.tencent.open.utils.l.a openUrl2 = openUrl2(context, str3, str2, bundle);
                    jSONObject = com.tencent.open.utils.l.d(openUrl2.a);
                    try {
                        i3 = jSONObject.getInt("ret");
                    } catch (org.json.JSONException unused) {
                        i3 = -4;
                    }
                    long j3 = openUrl2.b;
                    long j4 = openUrl2.c;
                    i = i3;
                    j = j3;
                    j2 = j4;
                    break;
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                    com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, -4);
                    throw e;
                }
            } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e2) {
                e2.printStackTrace();
                try {
                    i2 = java.lang.Integer.parseInt(e2.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    i2 = -9;
                }
                com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, i2);
                throw e2;
            } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException e4) {
                e4.printStackTrace();
                throw e4;
            } catch (java.net.MalformedURLException e5) {
                e5.printStackTrace();
                com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, -3);
                throw e5;
            } catch (java.net.SocketTimeoutException e6) {
                e6.printStackTrace();
                i = -8;
                if (i4 >= a2) {
                    com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, -8);
                    throw e6;
                }
                elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                if (i4 < a2) {
                    j = 0;
                    j2 = 0;
                    com.tencent.open.a.g.a().a(str4, elapsedRealtime, j, j2, i);
                    return jSONObject;
                }
            } catch (org.apache.http.conn.ConnectTimeoutException e7) {
                e7.printStackTrace();
                i = -7;
                if (i4 >= a2) {
                    com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, -7);
                    throw e7;
                }
                elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                if (i4 < a2) {
                }
            } catch (java.io.IOException e8) {
                e8.printStackTrace();
                com.tencent.open.a.g.a().a(str4, elapsedRealtime, 0L, 0L, getErrorCodeFromException(e8));
                throw e8;
            }
        }
    }

    public static void requestAsync(com.tencent.connect.auth.QQToken qQToken, android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IRequestListener iRequestListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new com.tencent.open.utils.HttpUtils.AnonymousClass1(qQToken, context, str, bundle, str2, iRequestListener).start();
    }
}
