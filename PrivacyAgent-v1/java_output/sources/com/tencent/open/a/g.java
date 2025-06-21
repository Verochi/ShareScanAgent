package com.tencent.open.a;

/* loaded from: classes19.dex */
public class g {
    protected static com.tencent.open.a.g a;
    protected android.os.HandlerThread e;
    protected android.os.Handler f;
    protected java.util.Random b = new java.util.Random();
    protected java.util.List<java.io.Serializable> d = java.util.Collections.synchronizedList(new java.util.ArrayList());
    protected java.util.List<java.io.Serializable> c = java.util.Collections.synchronizedList(new java.util.ArrayList());
    protected java.util.concurrent.Executor g = com.tencent.open.utils.j.b();
    protected java.util.concurrent.Executor h = com.tencent.open.utils.j.b();

    /* renamed from: com.tencent.open.a.g$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1000) {
                com.tencent.open.a.g.this.b();
            } else if (i == 1001) {
                com.tencent.open.a.g.this.e();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.tencent.open.a.g$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.os.Bundle a;
        final /* synthetic */ boolean b;

        public AnonymousClass2(android.os.Bundle bundle, boolean z) {
            this.a = bundle;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String k = com.tencent.open.utils.l.k(com.tencent.open.a.c.b(com.tencent.open.utils.f.a()));
                java.lang.String k2 = com.tencent.open.utils.l.k(com.tencent.open.a.c.c(com.tencent.open.utils.f.a()));
                java.lang.String k3 = com.tencent.open.utils.l.k(com.tencent.open.a.c.a());
                java.lang.String k4 = com.tencent.open.utils.l.k(com.tencent.open.a.c.d(com.tencent.open.utils.f.a()));
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("uin", com.tencent.connect.common.Constants.DEFAULT_UIN);
                bundle.putString("imei", k);
                bundle.putString("imsi", k2);
                bundle.putString("android_id", k4);
                bundle.putString("mac", k3);
                bundle.putString("platform", "1");
                bundle.putString("os_ver", android.os.Build.VERSION.RELEASE);
                bundle.putString(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "");
                bundle.putString("network", com.tencent.open.a.a.a(com.tencent.open.utils.f.a()));
                bundle.putString("language", com.tencent.open.a.c.b());
                bundle.putString("resolution", com.tencent.open.a.c.a(com.tencent.open.utils.f.a()));
                bundle.putString("apn", com.tencent.open.a.a.b(com.tencent.open.utils.f.a()));
                bundle.putString("model_name", android.os.Build.MODEL);
                bundle.putString("timezone", java.util.TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
                bundle.putString("qz_ver", com.tencent.open.utils.l.d(com.tencent.open.utils.f.a(), com.tencent.connect.common.Constants.PACKAGE_QZONE));
                bundle.putString("qq_ver", com.tencent.open.utils.l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                bundle.putString("qua", com.tencent.open.utils.l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                bundle.putString(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, com.tencent.open.utils.f.b());
                bundle.putString("app_ver", com.tencent.open.utils.l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                android.os.Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                com.tencent.open.a.g.this.d.add(new com.tencent.open.a.b(bundle));
                int size = com.tencent.open.a.g.this.d.size();
                int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportTimeInterval");
                if (a == 0) {
                    a = 10000;
                }
                if (!com.tencent.open.a.g.this.a("report_via", size) && !this.b) {
                    if (com.tencent.open.a.g.this.f.hasMessages(1001)) {
                        return;
                    }
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = 1001;
                    com.tencent.open.a.g.this.f.sendMessageDelayed(obtain, a);
                    return;
                }
                com.tencent.open.a.g.this.e();
                com.tencent.open.a.g.this.f.removeMessages(1001);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
            }
        }
    }

    /* renamed from: com.tencent.open.a.g$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ int d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ boolean g;

        public AnonymousClass3(long j, java.lang.String str, java.lang.String str2, int i, long j2, long j3, boolean z) {
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = j2;
            this.f = j3;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.a;
                android.os.Bundle bundle = new android.os.Bundle();
                java.lang.String a = com.tencent.open.a.a.a(com.tencent.open.utils.f.a());
                bundle.putString("apn", a);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", this.b);
                bundle.putString("detail", this.c);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("network=");
                sb.append(a);
                sb.append(kotlin.text.Typography.amp);
                sb.append("sdcard=");
                int i = 1;
                sb.append(android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(kotlin.text.Typography.amp);
                sb.append("wifi=");
                sb.append(com.tencent.open.a.a.e(com.tencent.open.utils.f.a()));
                bundle.putString("deviceInfo", sb.toString());
                int a2 = 100 / com.tencent.open.a.g.this.a(this.d);
                if (a2 > 0) {
                    i = a2 > 100 ? 100 : a2;
                }
                bundle.putString("frequency", i + "");
                bundle.putString("reqSize", this.e + "");
                bundle.putString("resultCode", this.d + "");
                bundle.putString("rspSize", this.f + "");
                bundle.putString("timeCost", elapsedRealtime + "");
                bundle.putString("uin", com.tencent.connect.common.Constants.DEFAULT_UIN);
                com.tencent.open.a.g.this.c.add(new com.tencent.open.a.b(bundle));
                int size = com.tencent.open.a.g.this.c.size();
                int a3 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportTimeInterval");
                if (a3 == 0) {
                    a3 = 10000;
                }
                if (!com.tencent.open.a.g.this.a("report_cgi", size) && !this.g) {
                    if (!com.tencent.open.a.g.this.f.hasMessages(1000)) {
                        android.os.Message obtain = android.os.Message.obtain();
                        obtain.what = 1000;
                        com.tencent.open.a.g.this.f.sendMessageDelayed(obtain, a3);
                    }
                }
                com.tencent.open.a.g.this.b();
                com.tencent.open.a.g.this.f.removeMessages(1000);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
            }
        }
    }

    /* renamed from: com.tencent.open.a.g$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00a5 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x0008, B:7:0x0011, B:10:0x0023, B:21:0x00a5, B:22:0x00b0, B:28:0x0094, B:30:0x0099, B:36:0x009e, B:14:0x003b, B:16:0x008a), top: B:2:0x0008, inners: #1, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[EDGE_INSN: B:33:0x00a3->B:20:0x00a3 BREAK  A[LOOP:0: B:12:0x0039->B:34:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[LOOP:0: B:12:0x0039->B:34:?, LOOP_END, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                android.os.Bundle c = com.tencent.open.a.g.this.c();
                if (c == null) {
                    return;
                }
                int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_HttpRetryCount");
                if (a == 0) {
                    a = 3;
                }
                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + a);
                boolean z = false;
                int i = 0;
                while (true) {
                    i++;
                    try {
                        try {
                            try {
                                org.apache.http.client.HttpClient httpClient = com.tencent.open.utils.HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, "https://wspeed.qq.com/w.cgi");
                                org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost("https://wspeed.qq.com/w.cgi");
                                httpPost.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
                                httpPost.setHeader("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                                httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(com.tencent.open.utils.l.i(com.tencent.open.utils.HttpUtils.encodeUrl(c))));
                                int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                                if (statusCode != 200) {
                                    break;
                                }
                                com.tencent.open.a.f.a().b("report_cgi");
                                z = true;
                                break;
                            } catch (java.lang.Exception e) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                            }
                        } catch (java.net.SocketTimeoutException e2) {
                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                            if (i < a) {
                                if (!z) {
                                }
                                com.tencent.open.a.g.this.c.clear();
                            }
                        }
                    } catch (org.apache.http.conn.ConnectTimeoutException e3) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                        if (i < a) {
                        }
                    }
                }
                if (!z) {
                    com.tencent.open.a.f.a().a("report_cgi", com.tencent.open.a.g.this.c);
                }
                com.tencent.open.a.g.this.c.clear();
            } catch (java.lang.Exception e4) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e4);
            }
        }
    }

    /* renamed from: com.tencent.open.a.g$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            try {
                android.os.Bundle d = com.tencent.open.a.g.this.d();
                if (d == null) {
                    return;
                }
                com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d.toString());
                int a = com.tencent.open.a.e.a();
                int i2 = 0;
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                boolean z = false;
                int i3 = 0;
                long j = 0;
                long j2 = 0;
                do {
                    int i4 = i2 + 1;
                    try {
                        try {
                            try {
                                try {
                                    com.tencent.open.utils.l.a openUrl2 = com.tencent.open.utils.HttpUtils.openUrl2(com.tencent.open.utils.f.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d);
                                    try {
                                        i = com.tencent.open.utils.l.d(openUrl2.a).getInt("ret");
                                    } catch (org.json.JSONException unused) {
                                        i = -4;
                                    }
                                    if (i == 0 || !android.text.TextUtils.isEmpty(openUrl2.a)) {
                                        i4 = a;
                                        z = true;
                                    }
                                    j = openUrl2.b;
                                    j2 = openUrl2.c;
                                    i2 = i4;
                                } catch (org.json.JSONException unused2) {
                                    i2 = i4;
                                    i3 = -4;
                                    j = 0;
                                    j2 = 0;
                                }
                            } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e) {
                                try {
                                    i3 = java.lang.Integer.parseInt(e.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                } catch (java.lang.Exception unused3) {
                                }
                            } catch (java.net.SocketTimeoutException unused4) {
                                elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                                i2 = i4;
                                i3 = -8;
                                j = 0;
                                j2 = 0;
                            }
                        } catch (org.apache.http.conn.ConnectTimeoutException unused5) {
                            elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                            i2 = i4;
                            i3 = -7;
                            j = 0;
                            j2 = 0;
                        } catch (java.lang.Exception unused6) {
                            i2 = a;
                            i3 = -6;
                            j = 0;
                            j2 = 0;
                        }
                    } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException unused7) {
                        com.tencent.open.a.g.this.d.clear();
                        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                        return;
                    } catch (java.io.IOException e2) {
                        i3 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(e2);
                        i2 = i4;
                        j = 0;
                        j2 = 0;
                    }
                } while (i2 < a);
                com.tencent.open.a.g.this.a("mapp_apptrace_sdk", elapsedRealtime, j, j2, i3, null, false);
                if (z) {
                    com.tencent.open.a.f.a().b("report_via");
                } else {
                    com.tencent.open.a.f.a().a("report_via", com.tencent.open.a.g.this.d);
                }
                com.tencent.open.a.g.this.d.clear();
                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
            } catch (java.lang.Exception e3) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
            }
        }
    }

    /* renamed from: com.tencent.open.a.g$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ android.os.Bundle a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass6(android.os.Bundle bundle, java.lang.String str, boolean z, java.lang.String str2) {
            this.a = bundle;
            this.b = str;
            this.c = z;
            this.d = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0135 A[Catch: Exception -> 0x0158, TRY_ENTER, TryCatch #5 {Exception -> 0x0158, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000e, B:11:0x0015, B:13:0x003e, B:14:0x0042, B:16:0x0050, B:17:0x0086, B:33:0x0135, B:35:0x013b, B:39:0x00d4, B:62:0x0118, B:68:0x0151, B:75:0x014e, B:110:0x0064, B:112:0x0072, B:113:0x0152, B:70:0x0143, B:72:0x0149), top: B:2:0x0004, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013b A[Catch: Exception -> 0x0158, TRY_LEAVE, TryCatch #5 {Exception -> 0x0158, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000e, B:11:0x0015, B:13:0x003e, B:14:0x0042, B:16:0x0050, B:17:0x0086, B:33:0x0135, B:35:0x013b, B:39:0x00d4, B:62:0x0118, B:68:0x0151, B:75:0x014e, B:110:0x0064, B:112:0x0072, B:113:0x0152, B:70:0x0143, B:72:0x0149), top: B:2:0x0004, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            org.apache.http.client.methods.HttpUriRequest httpUriRequest;
            org.apache.http.HttpResponse httpResponse;
            try {
                if (this.a == null) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                    return;
                }
                int a = com.tencent.open.a.e.a();
                if (a == 0) {
                    a = 3;
                }
                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a);
                org.apache.http.HttpResponse httpResponse2 = null;
                org.apache.http.client.HttpClient httpClient = com.tencent.open.utils.HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, this.b);
                java.lang.String encodeUrl = com.tencent.open.utils.HttpUtils.encodeUrl(this.a);
                if (this.c) {
                    encodeUrl = java.net.URLEncoder.encode(encodeUrl);
                }
                if (this.d.toUpperCase().equals("GET")) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(this.b);
                    stringBuffer.append(encodeUrl);
                    httpUriRequest = new org.apache.http.client.methods.HttpGet(stringBuffer.toString());
                } else if (!this.d.toUpperCase().equals("POST")) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                    return;
                } else {
                    org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(this.b);
                    httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(com.tencent.open.utils.l.i(encodeUrl)));
                    httpUriRequest = httpPost;
                }
                httpUriRequest.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
                httpUriRequest.addHeader("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                int i = 0;
                boolean z = false;
                do {
                    i++;
                    try {
                        try {
                            httpResponse = httpClient.execute(httpUriRequest);
                            try {
                                int statusCode = httpResponse.getStatusLine().getStatusCode();
                                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                                if (statusCode != 200) {
                                    com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                } else {
                                    try {
                                        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                                        z = true;
                                    } catch (java.net.SocketTimeoutException e) {
                                        e = e;
                                        z = true;
                                        try {
                                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                            if (httpResponse != null) {
                                                try {
                                                    org.apache.http.HttpEntity entity = httpResponse.getEntity();
                                                    if (entity != null) {
                                                        entity.consumeContent();
                                                    }
                                                } catch (java.lang.Exception e2) {
                                                    e = e2;
                                                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                }
                                            }
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            httpResponse2 = httpResponse;
                                            if (httpResponse2 != null) {
                                                try {
                                                    org.apache.http.HttpEntity entity2 = httpResponse2.getEntity();
                                                    if (entity2 != null) {
                                                        entity2.consumeContent();
                                                    }
                                                } catch (java.lang.Exception e3) {
                                                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e3);
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (org.apache.http.conn.ConnectTimeoutException e4) {
                                        e = e4;
                                        z = true;
                                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException:", e);
                                        if (httpResponse != null) {
                                            try {
                                                org.apache.http.HttpEntity entity3 = httpResponse.getEntity();
                                                if (entity3 != null) {
                                                    entity3.consumeContent();
                                                }
                                            } catch (java.lang.Exception e5) {
                                                e = e5;
                                                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                            }
                                        }
                                    } catch (java.lang.Exception e6) {
                                        e = e6;
                                        httpResponse2 = httpResponse;
                                        z = true;
                                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e);
                                        if (httpResponse2 != null) {
                                            try {
                                                org.apache.http.HttpEntity entity4 = httpResponse2.getEntity();
                                                if (entity4 != null) {
                                                    entity4.consumeContent();
                                                }
                                            } catch (java.lang.Exception e7) {
                                                e = e7;
                                                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                if (z) {
                                                }
                                            }
                                        }
                                        if (z) {
                                        }
                                    }
                                }
                                try {
                                    org.apache.http.HttpEntity entity5 = httpResponse.getEntity();
                                    if (entity5 != null) {
                                        entity5.consumeContent();
                                    }
                                } catch (java.lang.Exception e8) {
                                    e = e8;
                                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                    if (z) {
                                    }
                                }
                            } catch (java.net.SocketTimeoutException e9) {
                                e = e9;
                            } catch (org.apache.http.conn.ConnectTimeoutException e10) {
                                e = e10;
                            } catch (java.lang.Exception e11) {
                                e = e11;
                                httpResponse2 = httpResponse;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (httpResponse2 != null) {
                            }
                            throw th;
                        }
                    } catch (java.net.SocketTimeoutException e12) {
                        e = e12;
                        httpResponse = null;
                    } catch (org.apache.http.conn.ConnectTimeoutException e13) {
                        e = e13;
                        httpResponse = null;
                    } catch (java.lang.Exception e14) {
                        e = e14;
                    }
                    if (z) {
                        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                        return;
                    } else {
                        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                        return;
                    }
                } while (i < a);
                if (z) {
                }
            } catch (java.lang.Exception e15) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e15);
            }
        }
    }

    private g() {
        this.e = null;
        if (this.e == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new com.tencent.open.a.g.AnonymousClass1(this.e.getLooper());
    }

    public static synchronized com.tencent.open.a.g a() {
        com.tencent.open.a.g gVar;
        synchronized (com.tencent.open.a.g.class) {
            if (a == null) {
                a = new com.tencent.open.a.g();
            }
            gVar = a;
        }
        return gVar;
    }

    public int a(int i) {
        if (i == 0) {
            int a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    public void a(android.os.Bundle bundle, java.lang.String str, boolean z) {
        if (bundle == null) {
            return;
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new com.tencent.open.a.g.AnonymousClass2(bundle, z));
        }
    }

    public void a(java.lang.String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(java.lang.String str, long j, long j2, long j3, int i, java.lang.String str2, boolean z) {
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new com.tencent.open.a.g.AnonymousClass3(j, str, str2, i, j2, j3, z));
        }
    }

    public void a(java.lang.String str, java.lang.String str2, android.os.Bundle bundle, boolean z) {
        com.tencent.open.utils.j.a(new com.tencent.open.a.g.AnonymousClass6(bundle, str, z, str2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(java.lang.String str, int i) {
        int a2;
        int i2 = 5;
        if (str.equals("report_cgi")) {
            a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportMaxcount");
        } else if (str.equals("report_via")) {
            a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportBatchCount");
        } else {
            i2 = 0;
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        int a2;
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (!str.equals("report_cgi")) {
            if (str.equals("report_via")) {
                a2 = com.tencent.open.a.e.a(str2);
                if (this.b.nextInt(100) < a2) {
                    i = a2;
                    z = true;
                }
            }
            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        try {
            a2 = a(java.lang.Integer.parseInt(str2));
            if (this.b.nextInt(100) < a2) {
                z = true;
            }
        } catch (java.lang.Exception unused) {
            return false;
        }
        i = a2;
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    public void b() {
        this.h.execute(new com.tencent.open.a.g.AnonymousClass4());
    }

    public android.os.Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.c.get(0);
        if (bVar == null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        java.lang.String str = bVar.a.get("appid");
        java.util.List<java.io.Serializable> a2 = com.tencent.open.a.f.a().a("report_cgi");
        if (a2 != null) {
            this.c.addAll(a2);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", com.tencent.connect.common.Constants.SDK_VERSION_REPORT);
            bundle.putString(com.alipay.sdk.m.p.e.p, android.os.Build.DEVICE);
            bundle.putString("qua", com.tencent.connect.common.Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                com.tencent.open.a.b bVar2 = (com.tencent.open.a.b) this.c.get(i);
                bundle.putString(i + "_1", bVar2.a.get("apn"));
                bundle.putString(i + "_2", bVar2.a.get("frequency"));
                bundle.putString(i + "_3", bVar2.a.get("commandid"));
                bundle.putString(i + "_4", bVar2.a.get("resultCode"));
                bundle.putString(i + "_5", bVar2.a.get("timeCost"));
                bundle.putString(i + "_6", bVar2.a.get("reqSize"));
                bundle.putString(i + "_7", bVar2.a.get("rspSize"));
                bundle.putString(i + "_8", bVar2.a.get("detail"));
                bundle.putString(i + "_9", bVar2.a.get("uin"));
                bundle.putString(i + "_10", com.tencent.open.a.c.e(com.tencent.open.utils.f.a()) + "&" + bVar2.a.get("deviceInfo"));
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    public android.os.Bundle d() {
        java.util.List<java.io.Serializable> a2 = com.tencent.open.a.f.a().a("report_via");
        if (a2 != null) {
            this.d.addAll(a2);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (java.io.Serializable serializable : this.d) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.tencent.open.a.b bVar = (com.tencent.open.a.b) serializable;
            for (java.lang.String str : bVar.a.keySet()) {
                try {
                    java.lang.String str2 = bVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (org.json.JSONException e) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        android.os.Bundle bundle = new android.os.Bundle();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (org.json.JSONException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    public void e() {
        this.g.execute(new com.tencent.open.a.g.AnonymousClass5());
    }
}
