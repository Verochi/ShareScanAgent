package com.umeng.commonsdk.statistics.internal;

/* loaded from: classes19.dex */
public class c {
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private java.lang.String a = "10.0.0.172";
    private int b = 80;
    private android.content.Context c;
    private com.umeng.commonsdk.statistics.internal.b d;

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            if (com.umeng.commonsdk.config.FieldManager.b()) {
                com.umeng.commonsdk.config.FieldManager.a().a(com.umeng.commonsdk.statistics.internal.c.this.c, str2);
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.commonsdk.statistics.internal.c.this.c, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.statistics.internal.c.this.c).a(), null);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback {
        public AnonymousClass2() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
        public boolean onPreProcessImprintKey(java.lang.String str, java.lang.String str2) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
            com.umeng.commonsdk.config.FieldManager.a().a(com.umeng.commonsdk.statistics.internal.c.this.c);
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.commonsdk.statistics.internal.c.this.c, com.umeng.commonsdk.internal.a.f457s, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.statistics.internal.c.this.c).a(), null);
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(com.umeng.commonsdk.statistics.internal.c.this.c).a(com.umeng.commonsdk.statistics.AnalyticsConstants.ZERO_RESPONSE_FLAG);
            return true;
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$3, reason: invalid class name */
    public class AnonymousClass3 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        public AnonymousClass3() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
            com.umeng.commonsdk.config.FieldManager.a().a(com.umeng.commonsdk.statistics.internal.c.this.c, str2);
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.commonsdk.statistics.internal.c.this.c, com.umeng.commonsdk.internal.a.f457s, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.statistics.internal.c.this.c).a(), null);
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                if (!com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist()) {
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(com.umeng.commonsdk.statistics.internal.c.this.c, com.umeng.analytics.pro.q.a.E, com.umeng.analytics.CoreProtocol.getInstance(com.umeng.commonsdk.statistics.internal.c.this.c), null, 0L);
                }
            }
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                com.umeng.analytics.pro.n.a(com.umeng.commonsdk.statistics.internal.c.this.c).b(com.umeng.commonsdk.statistics.internal.c.this.c);
            }
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(com.umeng.commonsdk.statistics.internal.c.this.c).unregistImprintCallback(com.umeng.commonsdk.statistics.AnalyticsConstants.CFG_FIELD_KEY, this);
        }
    }

    public c(android.content.Context context) {
        this.c = context;
    }

    private void a() {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!android.text.TextUtils.isEmpty(imprintProperty)) {
            com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty);
        }
        if (!android.text.TextUtils.isEmpty(imprintProperty2)) {
            com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty2);
        }
        com.umeng.commonsdk.statistics.AnalyticsConstants.APPLOG_URL_LIST = new java.lang.String[]{com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL, com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL};
    }

    private void b() {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!android.text.TextUtils.isEmpty(imprintProperty)) {
            com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty);
        }
        if (!android.text.TextUtils.isEmpty(imprintProperty2)) {
            com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty2);
        }
        java.lang.String imprintProperty3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_p", "");
        java.lang.String imprintProperty4 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_s", "");
        if (!android.text.TextUtils.isEmpty(imprintProperty3)) {
            com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_DEFAULT_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty3);
        }
        if (!android.text.TextUtils.isEmpty(imprintProperty4)) {
            com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_SECONDARY_URL = com.umeng.commonsdk.statistics.common.DataHelper.assembleURL(imprintProperty4);
        }
        com.umeng.commonsdk.statistics.AnalyticsConstants.APPLOG_URL_LIST = new java.lang.String[]{com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_DEFAULT_URL, com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_SECONDARY_URL};
        if (android.text.TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            com.umeng.commonsdk.statistics.AnalyticsConstants.APPLOG_URL_LIST = new java.lang.String[]{com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL, com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL};
        }
    }

    private byte[] b(byte[] bArr, java.lang.String str) {
        if (!com.umeng.analytics.pro.bt.a().b()) {
            return a(bArr, str);
        }
        if (!str.contains("preulogs")) {
            str = str.replace("ulogs", "cnlogs");
        }
        java.lang.String b = com.umeng.analytics.pro.bt.b(str);
        java.lang.String c = com.umeng.analytics.pro.bx.b().c();
        if (!android.text.TextUtils.isEmpty(c)) {
            str = com.umeng.analytics.pro.bt.a(c, b);
        }
        byte[] a = a(bArr, str);
        if (a != null) {
            return a;
        }
        java.lang.String a2 = com.umeng.analytics.pro.bt.a().a(b);
        return (android.text.TextUtils.isEmpty(a2) || str.equalsIgnoreCase(a2)) ? a : a(bArr, a2);
    }

    private void c() {
        if (g) {
            return;
        }
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.c).registImprintCallback(com.umeng.commonsdk.statistics.AnalyticsConstants.CFG_FIELD_KEY, new com.umeng.commonsdk.statistics.internal.c.AnonymousClass1());
        g = true;
    }

    private byte[] c(byte[] bArr, java.lang.String str) {
        return com.umeng.analytics.pro.bt.a().b() ? a(bArr, str.replace("ulogs", "cnlogs")) : a(bArr, str);
    }

    private void d() {
        if (f) {
            return;
        }
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.c).registPreProcessCallback(com.umeng.commonsdk.statistics.AnalyticsConstants.ZERO_RESPONSE_FLAG, new com.umeng.commonsdk.statistics.internal.c.AnonymousClass2());
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.c).registImprintCallback(com.umeng.commonsdk.statistics.AnalyticsConstants.CFG_FIELD_KEY, new com.umeng.commonsdk.statistics.internal.c.AnonymousClass3());
        f = true;
    }

    public void a(com.umeng.commonsdk.statistics.internal.b bVar) {
        this.d = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0181: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:107:0x018d, block:B:106:0x0181 */
    public byte[] a(byte[] bArr, java.lang.String str) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        java.io.OutputStream outputStream;
        java.io.OutputStream outputStream2;
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[有状态] 上报url: " + str);
        try {
            try {
                com.umeng.commonsdk.statistics.internal.b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(str).openConnection();
                try {
                    boolean z = true;
                    if (!e) {
                        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new java.security.SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", com.umeng.commonsdk.statistics.internal.a.a(this.c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", com.umeng.commonsdk.statistics.internal.a.a(this.c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setRequestProperty("User-Agent", com.umeng.commonsdk.statistics.common.DeviceConfig.getCustomAgt());
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        httpsURLConnection.connect();
                        com.umeng.commonsdk.statistics.internal.b bVar2 = this.d;
                        if (bVar2 != null) {
                            bVar2.onRequestEnd();
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        java.lang.String headerField = httpsURLConnection.getHeaderField("Content-Type");
                        if (android.text.TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                            z = false;
                        }
                        java.lang.String str2 = com.umeng.commonsdk.statistics.AnalyticsConstants.OS;
                        if (responseCode != 200 || !z) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e2) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e2);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (java.io.IOException unused) {
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        java.io.InputStream inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] readStreamToByteArray = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(inputStream);
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e3) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e3);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (java.io.IOException unused2) {
                            }
                            httpsURLConnection.disconnect();
                            return readStreamToByteArray;
                        } finally {
                            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(inputStream);
                        }
                    } catch (java.net.UnknownHostException unused3) {
                        com.umeng.commonsdk.debug.UMLog.aq("A_10200", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e4) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e4);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (java.io.IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (javax.net.ssl.SSLHandshakeException unused5) {
                        com.umeng.commonsdk.debug.UMLog.aq("A_10201", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e5) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e5);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (java.io.IOException unused6) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (java.lang.Throwable unused7) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e6) {
                                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e6);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (java.io.IOException unused8) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (java.net.UnknownHostException unused9) {
                    outputStream = null;
                } catch (javax.net.ssl.SSLHandshakeException unused10) {
                    outputStream = null;
                } catch (java.lang.Throwable unused11) {
                    outputStream = null;
                }
            } catch (java.lang.Throwable th) {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (java.lang.Exception e7) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.c, e7);
                    }
                }
                if (str == 0) {
                    throw th;
                }
                try {
                    str.getInputStream().close();
                } catch (java.io.IOException unused12) {
                }
                str.disconnect();
                throw th;
            }
        } catch (java.net.UnknownHostException unused13) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (javax.net.ssl.SSLHandshakeException unused14) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (java.lang.Throwable unused15) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, java.lang.String str) {
        if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            com.umeng.commonsdk.statistics.UMServerURL.DEFAULT_URL = com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_DEFAULT_URL;
            com.umeng.commonsdk.statistics.UMServerURL.SECONDARY_URL = com.umeng.commonsdk.statistics.UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArr2 = null;
        int i = 0;
        while (true) {
            java.lang.String[] strArr = com.umeng.commonsdk.statistics.AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            java.lang.String str2 = strArr[i];
            if (z2) {
                d();
            } else {
                c();
            }
            java.lang.String str3 = str2 + java.io.File.separator + str;
            bArr2 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0 ? i == 0 ? b(bArr, str3) : c(bArr, str3) : a(bArr, str3);
            if (bArr2 != null) {
                com.umeng.commonsdk.statistics.internal.b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                }
            } else {
                com.umeng.commonsdk.statistics.internal.b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }
}
