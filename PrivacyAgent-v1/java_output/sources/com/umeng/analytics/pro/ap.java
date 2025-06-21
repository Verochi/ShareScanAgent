package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ap {
    private static javax.net.ssl.HostnameVerifier a;

    /* renamed from: com.umeng.analytics.pro.ap$1, reason: invalid class name */
    public static class AnonymousClass1 implements javax.net.ssl.HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str);
        }
    }

    private static javax.net.ssl.HostnameVerifier a() {
        if (a == null) {
            a = new com.umeng.analytics.pro.ap.AnonymousClass1();
        }
        return a;
    }

    private static javax.net.ssl.HttpsURLConnection a(java.lang.String str, java.lang.String str2, byte[] bArr) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        javax.net.ssl.HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(str).openConnection();
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new java.security.SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a());
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(15000);
            httpsURLConnection.addRequestProperty("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
            httpsURLConnection.addRequestProperty(str2, com.umeng.commonsdk.UMConfigure.sAppkey);
            httpsURLConnection.setRequestProperty("User-Agent", com.umeng.commonsdk.statistics.common.DeviceConfig.getCustomAgt());
            httpsURLConnection.connect();
            java.io.OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            return httpsURLConnection;
        } catch (java.lang.Exception e2) {
            e = e2;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            return httpsURLConnection2;
        }
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = null;
        try {
            javax.net.ssl.HttpsURLConnection a2 = a(str, "ak", com.umeng.analytics.pro.ax.a(bArr, com.umeng.commonsdk.UMConfigure.sAppkey.getBytes()));
            if (a2 != null && a2.getResponseCode() == 200) {
                java.io.InputStream inputStream = a2.getInputStream();
                try {
                    byte[] readStreamToByteArray = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(inputStream);
                    try {
                        java.lang.String headerField = a2.getHeaderField("ak");
                        if (android.text.TextUtils.isEmpty(headerField)) {
                            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                        } else {
                            bArr2 = com.umeng.analytics.pro.ax.a(readStreamToByteArray, headerField.getBytes());
                        }
                        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(inputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(inputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return bArr2;
    }

    public static void b(java.lang.String str, byte[] bArr) {
        byte[] bArr2;
        javax.net.ssl.HttpsURLConnection httpsURLConnection = null;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                com.umeng.analytics.pro.ax.a(bArr, byteArrayOutputStream);
                bArr2 = com.umeng.analytics.pro.ax.a(byteArrayOutputStream.toByteArray(), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes());
            } catch (java.lang.Throwable unused) {
                bArr2 = null;
            }
            httpsURLConnection = a(str, "appkey", bArr2);
            if (httpsURLConnection != null) {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("SC event report error, http error code: ");
                    sb.append(responseCode);
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "SC event report successful.");
                }
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                if (0 == 0) {
                    return;
                }
            } catch (java.lang.Throwable th2) {
                if (0 != 0) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (java.lang.Throwable unused3) {
        }
    }
}
