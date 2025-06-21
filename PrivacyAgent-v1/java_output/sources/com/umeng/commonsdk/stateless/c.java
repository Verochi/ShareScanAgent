package com.umeng.commonsdk.stateless;

/* loaded from: classes19.dex */
public class c {
    private java.lang.String a = "10.0.0.172";
    private int b = 80;
    private android.content.Context c;

    public c(android.content.Context context) {
        this.c = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0119, code lost:
    
        if (r5 == null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(byte[] bArr, java.lang.String str, java.lang.String str2) {
        java.io.OutputStream outputStream;
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        boolean z = false;
        if (bArr == null || android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || url is empty ");
            return false;
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[无状态] 上报url：" + str);
        javax.net.ssl.HttpsURLConnection httpsURLConnection2 = null;
        r3 = null;
        r3 = null;
        java.io.OutputStream outputStream2 = null;
        try {
            try {
                httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(str).openConnection();
            } catch (java.lang.Throwable unused) {
            }
        } catch (javax.net.ssl.SSLHandshakeException e) {
            e = e;
            httpsURLConnection = null;
        } catch (java.lang.Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new java.security.SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setRequestProperty("X-Umeng-UTC", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
            httpsURLConnection.setRequestProperty("Content-Type", com.umeng.analytics.pro.bo.aW + str2);
            httpsURLConnection.setRequestProperty("SM-IMP", "1");
            httpsURLConnection.setRequestProperty("User-Agent", com.umeng.commonsdk.statistics.common.DeviceConfig.getCustomAgt());
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            outputStream2 = httpsURLConnection.getOutputStream();
            outputStream2.write(bArr);
            outputStream2.flush();
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + str);
                z = true;
            }
            try {
                outputStream2.close();
            } catch (java.lang.Exception unused2) {
            }
        } catch (javax.net.ssl.SSLHandshakeException e2) {
            e = e2;
            try {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "SSLHandshakeException, Failed to send message.\n" + e);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                httpsURLConnection2 = httpsURLConnection;
                if (outputStream != null) {
                }
                if (httpsURLConnection2 != null) {
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            httpsURLConnection2 = httpsURLConnection;
            try {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Exception,Failed to send message.\n" + th);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.lang.Exception unused4) {
                    }
                }
                if (httpsURLConnection2 != null) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                    httpsURLConnection2.disconnect();
                }
                return z;
            } catch (java.lang.Throwable th4) {
                th = th4;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.lang.Exception unused5) {
                    }
                }
                if (httpsURLConnection2 != null) {
                    throw th;
                }
                try {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                    httpsURLConnection2.disconnect();
                    throw th;
                } catch (java.lang.Throwable unused6) {
                    throw th;
                }
            }
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        httpsURLConnection.disconnect();
        return z;
    }

    public void a() {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (android.text.TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.h = com.umeng.commonsdk.statistics.common.DataHelper.assembleStatelessURL(imprintProperty);
    }

    public boolean a(byte[] bArr, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
        if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE != 1 && com.umeng.analytics.pro.bt.a().b()) {
            java.lang.String replace = str4.replace("ulogs", "cnlogs");
            java.lang.String c = com.umeng.analytics.pro.bx.b().c();
            if (!android.text.TextUtils.isEmpty(c)) {
                replace = com.umeng.analytics.pro.bt.a(c, str);
            }
            boolean a = a(bArr, replace, str3);
            if (!a) {
                java.lang.String a2 = com.umeng.analytics.pro.bt.a().a(str);
                if (!android.text.TextUtils.isEmpty(a2) && !replace.equalsIgnoreCase(a2)) {
                    return a(bArr, a2, str3);
                }
            }
            return a;
        }
        return a(bArr, str4, str3);
    }

    public void b() {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!android.text.TextUtils.isEmpty(imprintProperty)) {
            com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.statistics.common.DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!android.text.TextUtils.isEmpty(imprintProperty2)) {
            com.umeng.commonsdk.stateless.a.j = com.umeng.commonsdk.statistics.common.DataHelper.assembleStatelessURL(imprintProperty2);
        }
        com.umeng.commonsdk.stateless.a.h = com.umeng.commonsdk.stateless.a.j;
        if (android.text.TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            com.umeng.commonsdk.stateless.a.h = com.umeng.commonsdk.stateless.a.g;
        }
    }
}
