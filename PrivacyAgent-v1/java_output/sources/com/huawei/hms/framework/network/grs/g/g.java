package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class g extends com.huawei.hms.framework.network.grs.g.a implements java.util.concurrent.Callable<com.huawei.hms.framework.network.grs.g.d> {
    private static final java.lang.String i = "g";

    public g(java.lang.String str, int i2, com.huawei.hms.framework.network.grs.g.c cVar, android.content.Context context, java.lang.String str2, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        super(str, i2, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x012e: MOVE (r6 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:79:0x012e */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.huawei.hms.framework.network.grs.g.d call() {
        java.net.HttpURLConnection httpURLConnection;
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        long j;
        long currentTimeMillis;
        long elapsedRealtime;
        java.lang.String str = i;
        com.huawei.hms.framework.common.Logger.i(str, "Post call execute");
        long j2 = 0;
        java.net.HttpURLConnection httpURLConnection2 = null;
        java.io.InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                    try {
                        j2 = java.lang.System.currentTimeMillis();
                        httpsURLConnection = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                    } catch (java.io.IOException e) {
                        e = e;
                        httpsURLConnection = null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (java.lang.RuntimeException unused) {
                            com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (java.lang.Throwable unused2) {
                            com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e2) {
                e = e2;
                httpsURLConnection = null;
                j = 0;
            }
            try {
            } catch (java.io.IOException e3) {
                e = e3;
                long j3 = j2;
                j2 = elapsedRealtime;
                j = j3;
                long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                currentTimeMillis = java.lang.System.currentTimeMillis();
                com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 run task catch IOException", e);
                this.a = new com.huawei.hms.framework.network.grs.g.d(e, elapsedRealtime2 - j2);
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (java.lang.RuntimeException unused3) {
                        j2 = j;
                        com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(j2);
                        this.a.a(currentTimeMillis);
                        if (b() != null) {
                        }
                        return this.a;
                    } catch (java.lang.Throwable unused4) {
                        j2 = j;
                        com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(j2);
                        this.a.a(currentTimeMillis);
                        if (b() != null) {
                        }
                        return this.a;
                    }
                }
                j2 = j;
                this.a.b(c());
                this.a.a(d());
                this.a.b(j2);
                this.a.a(currentTimeMillis);
                if (b() != null) {
                }
                return this.a;
            }
            if (httpsURLConnection == null) {
                com.huawei.hms.framework.common.Logger.w(str, "create HttpsURLConnection instance by url return null.");
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (java.lang.RuntimeException unused5) {
                        com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (java.lang.Throwable unused6) {
                        com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                return null;
            }
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            java.lang.String a = b() != null ? b().a() : "";
            if (android.text.TextUtils.isEmpty(a)) {
                a = "&";
            }
            httpsURLConnection.setRequestProperty("If-None-Match", a);
            httpsURLConnection.connect();
            com.huawei.hms.framework.network.grs.h.f.a.a(httpsURLConnection, f().a("services", ""));
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                try {
                    inputStream = httpsURLConnection.getInputStream();
                    byte[] byteArray = com.huawei.hms.framework.common.IoUtils.toByteArray(inputStream);
                    com.huawei.hms.framework.common.IoUtils.closeSecure(inputStream);
                    bArr = byteArray;
                } catch (java.lang.Throwable th2) {
                    com.huawei.hms.framework.common.IoUtils.closeSecure(inputStream);
                    throw th2;
                }
            }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpsURLConnection.getHeaderFields();
            httpsURLConnection.disconnect();
            long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime();
            currentTimeMillis = java.lang.System.currentTimeMillis();
            this.a = new com.huawei.hms.framework.network.grs.g.d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
            try {
                httpsURLConnection.disconnect();
            } catch (java.lang.RuntimeException unused7) {
                com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                this.a.b(c());
                this.a.a(d());
                this.a.b(j2);
                this.a.a(currentTimeMillis);
                if (b() != null) {
                }
                return this.a;
            } catch (java.lang.Throwable unused8) {
                com.huawei.hms.framework.common.Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                this.a.b(c());
                this.a.a(d());
                this.a.b(j2);
                this.a.a(currentTimeMillis);
                if (b() != null) {
                }
                return this.a;
            }
            this.a.b(c());
            this.a.a(d());
            this.a.b(j2);
            this.a.a(currentTimeMillis);
            if (b() != null) {
                b().a(this.a);
            }
            return this.a;
        } catch (java.lang.Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
        }
    }
}
