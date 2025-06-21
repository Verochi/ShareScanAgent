package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ai {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("([^\\s;]+)(.*)");
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static final class a extends java.io.FilterInputStream {
        private boolean a;

        public a(java.io.InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.a = true;
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.xiaomi.push.ag a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.BufferedReader bufferedReader;
        com.xiaomi.push.ag agVar = new com.xiaomi.push.ag();
        try {
            try {
                try {
                    java.net.HttpURLConnection c2 = c(context, new java.net.URL(str));
                    c2.setConnectTimeout(10000);
                    c2.setReadTimeout(15000);
                    c2.setRequestMethod(str2);
                    int i = 0;
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        c2.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        java.io.OutputStream outputStream = c2.getOutputStream();
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (java.io.IOException e) {
                            e = e;
                            throw new java.io.IOException("err while request " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (java.lang.Throwable th) {
                            th = th;
                            throw new java.io.IOException(th.getMessage());
                        }
                    }
                    agVar.a = c2.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.a("Http POST Response Code: " + agVar.a);
                    while (true) {
                        java.lang.String headerFieldKey = c2.getHeaderFieldKey(i);
                        java.lang.String headerField = c2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (java.io.IOException unused) {
                                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new com.xiaomi.push.ai.a(c2.getErrorStream())));
                            }
                        } else {
                            agVar.b.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new com.xiaomi.push.ai.a(c2.getInputStream())));
                } catch (java.io.IOException e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            try {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                java.lang.String property = java.lang.System.getProperty("line.separator");
                for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                agVar.c = stringBuffer.toString();
                bufferedReader.close();
                com.xiaomi.push.c.a((java.io.Closeable) null);
                com.xiaomi.push.c.a((java.io.Closeable) null);
                return agVar;
            } catch (java.io.IOException e3) {
                e = e3;
                throw new java.io.IOException("err while request " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
            } catch (java.lang.Throwable th3) {
                th = th3;
                throw new java.io.IOException(th.getMessage());
            }
        } catch (java.lang.Throwable th4) {
            com.xiaomi.push.c.a((java.io.Closeable) null);
            com.xiaomi.push.c.a((java.io.Closeable) str2);
            throw th4;
        }
    }

    public static com.xiaomi.push.ag a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        return a(context, str, "POST", a(map));
    }

    public static java.lang.String a(android.content.Context context, java.net.URL url) {
        return a(context, url, "UTF-8");
    }

    private static java.lang.String a(android.content.Context context, java.net.URL url, java.lang.String str) {
        java.io.InputStream inputStream;
        try {
            inputStream = b(context, url);
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(1024);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, str));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 == read) {
                        com.xiaomi.push.c.a(inputStream);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.xiaomi.push.c.a(inputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.io.File file, java.lang.String str2) {
        if (!file.exists()) {
            return null;
        }
        java.lang.String name = file.getName();
        try {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new com.xiaomi.push.ai.a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                java.lang.String stringBuffer2 = stringBuffer.toString();
                                com.xiaomi.push.c.a(fileInputStream);
                                com.xiaomi.push.c.a(bufferedReader);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (java.io.IOException e) {
                            e = e;
                            throw new java.io.IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (java.lang.Throwable th) {
                            th = th;
                            throw new java.io.IOException(th.getMessage());
                        }
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                com.xiaomi.push.c.a((java.io.Closeable) null);
                com.xiaomi.push.c.a((java.io.Closeable) file);
                throw th3;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(java.net.URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (java.io.UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.a("Failed to convert from params map to string: ".concat(java.lang.String.valueOf(e)));
                    com.xiaomi.channel.commonutils.logger.b.a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static boolean a(android.content.Context context) {
        return j(context) >= 0;
    }

    private static java.io.InputStream b(android.content.Context context, java.net.URL url) {
        java.lang.String str;
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context");
        }
        if (url == null) {
            throw new java.lang.IllegalArgumentException("url");
        }
        java.lang.String url2 = url.toString();
        if (android.text.TextUtils.isEmpty(url2)) {
            str = null;
        } else {
            new java.lang.String();
            str = java.lang.String.format("%s&key=%s", url2, com.xiaomi.push.an.a(java.lang.String.format("%sbe988a6134bc8254465424e5a70ef037", url2)));
        }
        java.net.URL url3 = new java.net.URL(str);
        try {
            java.net.HttpURLConnection.setFollowRedirects(true);
            java.net.HttpURLConnection c2 = c(context, url3);
            c2.setConnectTimeout(10000);
            c2.setReadTimeout(15000);
            if (!android.text.TextUtils.isEmpty(null)) {
                c2.setRequestProperty("User-Agent", null);
            }
            return new com.xiaomi.push.ai.a(c2.getInputStream());
        } catch (java.io.IOException e) {
            throw new java.io.IOException("IOException:" + e.getClass().getSimpleName());
        } catch (java.lang.Throwable th) {
            throw new java.io.IOException(th.getMessage());
        }
    }

    public static boolean b(android.content.Context context) {
        boolean z;
        android.net.Network activeNetwork;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    activeNetwork = connectivityManager.getActiveNetwork();
                    android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (java.lang.Exception unused) {
                }
            } else {
                z = a(context);
            }
            return !z && c(context);
        }
        z = false;
        if (z) {
        }
    }

    private static java.net.HttpURLConnection c(android.content.Context context, java.net.URL url) {
        return (java.net.HttpURLConnection) ((com.alipay.sdk.m.l.a.q.equals(url.getProtocol()) && k(context)) ? url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    public static boolean c(android.content.Context context) {
        android.net.NetworkInfo networkInfo;
        try {
            networkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean d(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        try {
            connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.Exception unused) {
        }
        if (connectivityManager == null) {
            return false;
        }
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    public static boolean e(android.content.Context context) {
        android.net.NetworkInfo l = l(context);
        return l != null && l.getType() == 0 && 20 == l.getSubtype();
    }

    public static boolean f(android.content.Context context) {
        android.net.NetworkInfo l = l(context);
        return l != null && l.getType() == 0 && 13 == l.getSubtype();
    }

    public static boolean g(android.content.Context context) {
        android.net.NetworkInfo l = l(context);
        if (l == null || l.getType() != 0) {
            return false;
        }
        java.lang.String subtypeName = l.getSubtypeName();
        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
            switch (l.getSubtype()) {
            }
            return false;
        }
        return true;
    }

    public static boolean h(android.content.Context context) {
        android.net.NetworkInfo l = l(context);
        if (l == null || l.getType() != 0) {
            return false;
        }
        int subtype = l.getSubtype();
        return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
    }

    public static java.lang.String i(android.content.Context context) {
        if (d(context)) {
            return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static int j(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private static boolean k(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        if (!"CN".equalsIgnoreCase(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimCountryIso())) {
            return false;
        }
        try {
            connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.Exception unused) {
        }
        if (connectivityManager == null) {
            return false;
        }
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        java.lang.String extraInfo = activeNetworkInfo.getExtraInfo();
        return !android.text.TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
    }

    private static android.net.NetworkInfo l(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
