package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class q {
    private static android.content.Context a = null;
    private static final java.lang.String l = "first_activate_time";
    private static final java.lang.String m = "ana_is_f";
    private static final java.lang.String n = "thtstart";
    private static final java.lang.String o = "dstk_last_time";
    private static final java.lang.String p = "dstk_cnt";
    private static final java.lang.String q = "gkvc";
    private static final java.lang.String r = "ekvc";
    private static final java.lang.String t = "-1";
    private static final java.lang.String x = "com.umeng.umcrash.UMCrashUtils";
    private static java.lang.Class<?> y;
    private static java.lang.reflect.Method z;
    private com.umeng.analytics.pro.q.c b;
    private android.content.SharedPreferences c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private org.json.JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;

    /* renamed from: s, reason: collision with root package name */
    private final long f449s;
    private boolean u;
    private boolean v;
    private java.lang.Object w;

    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;
        public static final int a = 4097;
        public static final int b = 4098;
        public static final int c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 4357;
        public static final int q = 4358;
        public static final int r = 8193;

        /* renamed from: s, reason: collision with root package name */
        public static final int f450s = 8194;
        public static final int t = 8195;
        public static final int u = 8196;
        public static final int v = 8197;
        public static final int w = 8199;
        public static final int x = 8200;
        public static final int y = 8201;
        public static final int z = 8208;
    }

    public static class b {
        private static final com.umeng.analytics.pro.q a = new com.umeng.analytics.pro.q(null);

        private b() {
        }
    }

    public static class c {
        private com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy a = null;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private com.umeng.commonsdk.statistics.noise.ABTest f;

        public c() {
            this.f = null;
            this.f = com.umeng.commonsdk.statistics.noise.ABTest.getService(com.umeng.analytics.pro.q.a);
        }

        private com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy = this.a;
                return reportStrategy instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportRealtime ? reportStrategy : new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportRealtime();
            }
            if (i == 1) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                return reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch ? reportStrategy2 : new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch();
            }
            if (i == 4) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy3 = this.a;
                return reportStrategy3 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportDaily ? reportStrategy3 : new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportDaily(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(com.umeng.analytics.pro.q.a));
            }
            if (i == 5) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy4 = this.a;
                return reportStrategy4 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportWifiOnly ? reportStrategy4 : new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportWifiOnly(com.umeng.analytics.pro.q.a);
            }
            if (i == 6) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy5 = this.a;
                if (!(reportStrategy5 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval)) {
                    return new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(com.umeng.analytics.pro.q.a), i2);
                }
                ((com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                return reportStrategy5;
            }
            if (i == 8) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy6 = this.a;
                return reportStrategy6 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.SmartPolicy ? reportStrategy6 : new com.umeng.commonsdk.statistics.common.ReportPolicy.SmartPolicy(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(com.umeng.analytics.pro.q.a));
            }
            if (i != 11) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy7 = this.a;
                return reportStrategy7 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch ? reportStrategy7 : new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch();
            }
            com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy8 = this.a;
            if (reportStrategy8 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime) {
                ((com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                return reportStrategy8;
            }
            com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i2);
            return reportQuasiRealtime;
        }

        public int a(int i) {
            int intValue = java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.analytics.pro.q.a, "test_report_interval", com.umeng.analytics.pro.q.t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        public void a() {
            try {
                int[] a = a(-1, -1);
                this.b = a[0];
                this.c = a[1];
            } catch (java.lang.Throwable unused) {
            }
        }

        public int[] a(int i, int i2) {
            int intValue = java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.analytics.pro.q.a, "report_policy", com.umeng.analytics.pro.q.t)).intValue();
            int intValue2 = java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.analytics.pro.q.a, "report_interval", com.umeng.analytics.pro.q.t)).intValue();
            if (intValue == -1 || !com.umeng.commonsdk.statistics.common.ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            if (11 != intValue) {
                return new int[]{i, i2};
            }
            if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                intValue2 = 15;
            }
            return new int[]{intValue, intValue2 * 1000};
        }

        public void b() {
            int i;
            com.umeng.commonsdk.statistics.noise.Defcon service = com.umeng.commonsdk.statistics.noise.Defcon.getService(com.umeng.analytics.pro.q.a);
            if (service.isOpen()) {
                com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy = this.a;
                this.a = (reportStrategy instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.a : new com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(com.umeng.analytics.pro.q.a), service);
            } else {
                boolean z = java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.analytics.pro.q.a, "integrated_test", com.umeng.analytics.pro.q.t)).intValue() == 1;
                if (com.umeng.commonsdk.UMConfigure.isDebugLog() && z && !com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.K, 3, "\\|", null, null);
                }
                if (com.umeng.commonsdk.statistics.common.MLog.DEBUG && z) {
                    this.a = new com.umeng.commonsdk.statistics.common.ReportPolicy.DebugPolicy(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(com.umeng.analytics.pro.q.a));
                } else if (this.f.isInTest() && "RPT".equals(this.f.getTestName())) {
                    if (this.f.getTestPolicy() == 6) {
                        if (java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.analytics.pro.q.a, "test_report_interval", com.umeng.analytics.pro.q.t)).intValue() != -1) {
                            i = a(com.anythink.expressad.foundation.g.a.bM);
                        } else {
                            i = this.c;
                            if (i <= 0) {
                                i = this.e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.a = b(this.f.getTestPolicy(), i);
                } else {
                    int i2 = this.d;
                    int i3 = this.e;
                    int i4 = this.b;
                    if (i4 != -1) {
                        i3 = this.c;
                        i2 = i4;
                    }
                    this.a = b(i2, i3);
                }
            }
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                try {
                    com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                    if (reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.J, 3, "", new java.lang.String[]{"@"}, new java.lang.String[]{java.lang.String.valueOf(((com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DebugPolicy) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.M, 3, "", new java.lang.String[]{"@"}, new java.lang.String[]{java.lang.String.valueOf(((com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)});
                    } else {
                        boolean z2 = reportStrategy2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        public com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }
    }

    public static class d {
        private java.util.Map<java.lang.String, java.lang.Object> a;
        private java.lang.String b;
        private java.lang.String c;
        private long d;

        private d() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0L;
        }

        public d(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, long j) {
            this.a = map;
            this.b = str;
            this.d = j;
            this.c = str2;
        }

        public java.util.Map<java.lang.String, java.lang.Object> a() {
            return this.a;
        }

        public java.lang.String b() {
            return this.c;
        }

        public java.lang.String c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }
    }

    static {
        h();
    }

    private q() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 10;
        this.g = new org.json.JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.f449s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new java.lang.Object();
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.b = new com.umeng.analytics.pro.q.c();
        } catch (java.lang.Throwable unused) {
        }
    }

    public /* synthetic */ q(com.umeng.analytics.pro.q.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.q a(android.content.Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return com.umeng.analytics.pro.q.b.a;
    }

    private org.json.JSONObject a(org.json.JSONObject jSONObject, long j) {
        try {
            if (com.umeng.analytics.pro.s.a(jSONObject) <= j) {
                return jSONObject;
            }
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.f.aH, com.umeng.analytics.pro.s.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return com.umeng.analytics.pro.s.a(a, j, jSONObject);
        } catch (java.lang.Throwable unused) {
            return jSONObject;
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        java.lang.reflect.Method method;
        java.lang.Class<?> cls = y;
        if (cls == null || (method = z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (java.lang.Throwable unused) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private boolean a(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (java.lang.System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        }
        o();
        return true;
    }

    private boolean a(org.json.JSONArray jSONArray) {
        int length = jSONArray.length();
        java.util.List asList = java.util.Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i++;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return i >= length;
    }

    private boolean a(org.json.JSONObject jSONObject) {
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                java.util.Iterator<java.lang.String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i++;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return i >= length;
    }

    private org.json.JSONObject b(org.json.JSONObject jSONObject, long j) {
        try {
            if (com.umeng.analytics.pro.s.a(jSONObject) <= j) {
                return jSONObject;
            }
            jSONObject = null;
            com.umeng.analytics.pro.k.a(a).a(true, false);
            com.umeng.analytics.pro.k.a(a).b();
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (java.lang.Throwable unused) {
            return jSONObject;
        }
    }

    private void b(org.json.JSONObject jSONObject) {
        org.json.JSONObject f;
        if (com.umeng.analytics.pro.k.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(a)).c() || (f = com.umeng.analytics.pro.k.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(a)).f()) == null) {
            return;
        }
        java.lang.String optString = f.optString("__av");
        java.lang.String optString2 = f.optString("__vc");
        try {
            if (android.text.TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), com.umeng.commonsdk.utils.UMUtils.getAppVersionName(a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (android.text.TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void c(org.json.JSONObject jSONObject) {
        try {
            if (com.umeng.analytics.pro.k.a(a).e()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), com.umeng.commonsdk.utils.UMUtils.getAppVersionName(a));
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(a));
                return;
            }
            org.json.JSONObject g = com.umeng.analytics.pro.k.a(a).g();
            if (g != null) {
                java.lang.String optString = g.optString("__av");
                java.lang.String optString2 = g.optString("__vc");
                if (android.text.TextUtils.isEmpty(optString)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), com.umeng.commonsdk.utils.UMUtils.getAppVersionName(a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                }
                if (android.text.TextUtils.isEmpty(optString2)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean c(boolean z2) {
        if (s() || com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.b == null) {
            this.b = new com.umeng.analytics.pro.q.c();
        }
        this.b.a();
        com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy c2 = this.b.c();
        boolean shouldSendMessage = c2.shouldSendMessage(z2);
        if (shouldSendMessage) {
            if (((c2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval) || (c2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DebugPolicy) || (c2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                com.umeng.commonsdk.statistics.common.MLog.d("数据发送策略 : " + c2.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void d(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                org.json.JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                            com.umeng.commonsdk.statistics.common.MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            com.umeng.commonsdk.statistics.common.MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.Z)) {
                    jSONObject3.put(com.umeng.analytics.pro.f.Z, jSONObject4.getJSONArray(com.umeng.analytics.pro.f.Z));
                    if (jSONObject3.length() > 0) {
                        if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                            com.umeng.commonsdk.statistics.common.MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            com.umeng.commonsdk.statistics.common.MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                            com.umeng.commonsdk.statistics.common.MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            com.umeng.commonsdk.statistics.common.MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.n)) {
                    org.json.JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.f.n);
                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(com.umeng.analytics.pro.f.u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.f.u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.f.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                            com.umeng.commonsdk.statistics.common.MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            com.umeng.commonsdk.statistics.common.MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.f.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.f.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.f.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.f.L));
                    if (jSONObject3.length() > 0) {
                        if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                            com.umeng.commonsdk.statistics.common.MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            com.umeng.commonsdk.statistics.common.MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    com.umeng.commonsdk.statistics.common.MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new org.json.JSONObject();
                }
            }
            jSONObject3.length();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e(th);
        }
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new com.umeng.analytics.pro.q.c();
        }
        com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy c2 = this.b.c();
        if (c2 instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy) {
            return z2 ? ((com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy) c2).shouldSendMessageByInstant() : c2.shouldSendMessage(false);
        }
        return true;
    }

    private void e(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                } else {
                    this.i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                } else {
                    this.j++;
                }
            }
            if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.g == null) {
                    this.g = new org.json.JSONArray();
                }
                this.g.put(jSONObject);
                com.umeng.analytics.pro.k.a(a).a(this.g);
                this.g = new org.json.JSONArray();
                return;
            }
            if (this.g.length() >= this.f) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                com.umeng.analytics.pro.k.a(a).a(this.g);
                this.g = new org.json.JSONArray();
            }
            if (this.k == 0) {
                this.k = java.lang.System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e(th);
        }
    }

    private void e(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                org.json.JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.f.n)) {
                    org.json.JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.f.n);
                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.f.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        com.umeng.commonsdk.statistics.common.MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.f.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.f.L));
                    if (jSONObject3.length() > 0) {
                        com.umeng.commonsdk.statistics.common.MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new org.json.JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    com.umeng.commonsdk.statistics.common.MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new org.json.JSONObject();
                }
            }
            jSONObject3.length();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e(th);
        }
    }

    private void f(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                b(a);
                d();
                java.lang.String[] a2 = com.umeng.analytics.c.a(a);
                if (a2 == null || android.text.TextUtils.isEmpty(a2[0]) || android.text.TextUtils.isEmpty(a2[1])) {
                    return;
                }
                com.umeng.analytics.pro.w.a().a(a, j);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + com.umeng.analytics.pro.aa.a().c(a));
                boolean b2 = com.umeng.analytics.pro.w.a().b(a, j, false);
                com.umeng.analytics.c.b(a);
                com.umeng.analytics.pro.w.a().a(a, j, true);
                if (b2) {
                    com.umeng.analytics.pro.w.a().b(a, j);
                }
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void f(org.json.JSONObject jSONObject) {
        org.json.JSONObject optJSONObject;
        org.json.JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(com.umeng.analytics.pro.f.n)) {
                    com.umeng.analytics.pro.k.a(a).a(true, false);
                }
                com.umeng.analytics.pro.k.a(a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(com.umeng.analytics.pro.f.n) && (optJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.f.n).optJSONObject(0)) != null) {
                    java.lang.String optString = optJSONObject2.optString("id");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        com.umeng.analytics.pro.k.a(a).b(optString);
                    }
                }
            }
            com.umeng.analytics.pro.k.a(a).b();
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            android.content.Context context = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 4353, com.umeng.analytics.CoreProtocol.getInstance(context), null);
        } catch (java.lang.Exception unused) {
        }
    }

    private void g(java.lang.Object obj) {
        try {
            b(a);
            d();
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                java.lang.String string = jSONObject.getString(com.umeng.analytics.pro.f.M);
                java.lang.String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                java.lang.String[] a2 = com.umeng.analytics.c.a(a);
                if (a2 != null && string.equals(a2[0]) && string2.equals(a2[1])) {
                    return;
                }
                com.umeng.analytics.pro.w.a().a(a, j);
                java.lang.String c2 = com.umeng.analytics.pro.aa.a().c(a);
                boolean b2 = com.umeng.analytics.pro.w.a().b(a, j, false);
                com.umeng.analytics.c.a(a, string, string2);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c2);
                com.umeng.analytics.pro.w.a().a(a, j, true);
                if (b2) {
                    com.umeng.analytics.pro.w.a().b(a, j);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void g(org.json.JSONObject jSONObject) {
        org.json.JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.f.n)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    com.umeng.analytics.pro.k.a(a).i();
                    com.umeng.analytics.pro.k.a(a).h();
                    com.umeng.analytics.pro.k.a(a).b(true, false);
                    com.umeng.analytics.pro.k.a(a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(com.umeng.analytics.pro.f.n)) {
                    com.umeng.analytics.pro.k.a(a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(com.umeng.analytics.pro.f.Z)) {
                    com.umeng.analytics.pro.k.a(a).h();
                }
                if (optJSONObject.has("error")) {
                    com.umeng.analytics.pro.k.a(a).i();
                }
            }
            com.umeng.analytics.pro.k.a(a).a();
        } catch (java.lang.Exception unused) {
        }
    }

    private static void h() {
        try {
            y = com.umeng.umcrash.UMCrashUtils.class;
            java.lang.reflect.Method declaredMethod = com.umeng.umcrash.UMCrashUtils.class.getDeclaredMethod("setPuidAndProvider", java.lang.String.class, java.lang.String.class);
            if (declaredMethod != null) {
                z = declaredMethod;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void h(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            java.lang.String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (android.text.TextUtils.isEmpty(optString)) {
                return;
            }
            com.umeng.analytics.pro.k.a(a).a(optString, obj.toString(), 2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void i() {
        org.json.JSONObject b2 = b(com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(a));
        if (b2 == null || b2.length() < 1) {
            return;
        }
        org.json.JSONObject jSONObject = (org.json.JSONObject) b2.opt("header");
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) b2.opt("content");
        if (a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        org.json.JSONObject buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (java.lang.Throwable unused) {
            }
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((java.lang.Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        org.json.JSONObject buildEnvelopeWithExtHeader;
        org.json.JSONObject a2 = a(com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(a));
        if (a2 == null || a2.length() < 1) {
            return;
        }
        org.json.JSONObject jSONObject = (org.json.JSONObject) a2.opt("header");
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) a2.opt("content");
        android.content.Context context = a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (java.lang.Throwable unused) {
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((java.lang.Object) buildEnvelopeWithExtHeader);
    }

    private org.json.JSONObject k() {
        org.json.JSONObject l2 = l();
        if (l2 != null) {
            try {
                l2.put("st", "1");
            } catch (java.lang.Throwable unused) {
            }
        }
        return l2;
    }

    private org.json.JSONObject l() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (com.umeng.analytics.AnalyticsConfig.mWrapperType != null && com.umeng.analytics.AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), com.umeng.analytics.AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), com.umeng.analytics.AnalyticsConfig.mWrapperType);
            }
            int verticalType = com.umeng.analytics.AnalyticsConfig.getVerticalType(a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.i), verticalType);
            java.lang.String str = "9.7.5";
            if (verticalType == 1) {
                java.lang.String gameSdkVersion = com.umeng.analytics.AnalyticsConfig.getGameSdkVersion(a);
                if (!android.text.TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.7.5");
            }
            java.lang.String MD5 = com.umeng.commonsdk.statistics.common.HelperUtils.MD5(com.umeng.analytics.AnalyticsConfig.getSecretKey(a));
            if (!android.text.TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a);
            java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.f.at, "");
            if (!android.text.TextUtils.isEmpty(imprintProperty2)) {
                if (com.umeng.analytics.AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.av), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.av), imprintProperty2);
                }
            }
            java.lang.String imprintProperty3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.f.au, "");
            if (!android.text.TextUtils.isEmpty(imprintProperty3)) {
                if (com.umeng.analytics.AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.aw), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.aw), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.an), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.m), n());
            if (sharedPreferences != null) {
                java.lang.String string = sharedPreferences.getString("vers_name", "");
                if (!android.text.TextUtils.isEmpty(string)) {
                    java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(java.lang.System.currentTimeMillis()));
                    if (android.text.TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.f.m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private java.lang.String m() {
        java.lang.String str = "0";
        java.lang.String str2 = null;
        try {
            str2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
        } catch (java.lang.Throwable unused) {
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            if (!android.text.TextUtils.isEmpty(this.d)) {
                return this.d;
            }
            if (this.c == null) {
                this.c = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a);
            }
            java.lang.String string = this.c.getString("pre_version", "");
            java.lang.String appVersionName = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(a);
            if (android.text.TextUtils.isEmpty(string)) {
                this.c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
            } else {
                str = this.c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.d = str;
            return str;
        }
        str = str2;
        this.d = str;
        return str;
    }

    private java.lang.String n() {
        java.lang.String str = null;
        try {
            str = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
            if (android.text.TextUtils.isEmpty(str)) {
                if (!android.text.TextUtils.isEmpty(this.e)) {
                    return this.e;
                }
                if (this.c == null) {
                    this.c = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a);
                }
                java.lang.String string = this.c.getString("pre_date", "");
                if (android.text.TextUtils.isEmpty(string)) {
                    string = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(java.lang.System.currentTimeMillis()));
                    this.c.edit().putString("pre_date", string).commit();
                } else {
                    java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(java.lang.System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (java.lang.Throwable unused) {
        }
        this.e = str;
        return str;
    }

    private void o() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = java.lang.System.currentTimeMillis();
            com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit().putLong(o, java.lang.System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!android.text.TextUtils.isEmpty(com.umeng.analytics.pro.w.a().b())) {
                b(a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.g.length(); i++) {
                org.json.JSONObject optJSONObject = this.g.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    java.lang.String optString = optJSONObject.optString("__i");
                    if (android.text.TextUtils.isEmpty(optString) || t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.g.length() > 0) {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; i < this.g.length(); i++) {
                try {
                    org.json.JSONObject jSONObject = this.g.getJSONObject(i);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        java.lang.String optString = jSONObject.optString("__i");
                        boolean isEmpty = android.text.TextUtils.isEmpty(optString);
                        java.lang.String str = t;
                        if (isEmpty || t.equals(optString)) {
                            java.lang.String b2 = com.umeng.analytics.pro.w.a().b();
                            if (!android.text.TextUtils.isEmpty(b2)) {
                                str = b2;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            this.g = jSONArray;
        }
    }

    private void r() {
        android.content.Context context;
        android.content.SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = a) == null || (sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(l, java.lang.System.currentTimeMillis()).commit();
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean s() {
        android.content.SharedPreferences sharedPreferences;
        try {
            android.content.Context context = a;
            if (context == null || (sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(m, -1L) != 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public org.json.JSONObject a(long j) {
        if (android.text.TextUtils.isEmpty(com.umeng.analytics.pro.aa.a().d(a))) {
            return null;
        }
        org.json.JSONObject b2 = b(false);
        int a2 = com.umeng.analytics.pro.t.a().a(a);
        if (b2.length() > 0) {
            if (b2.length() == 1) {
                if (b2.optJSONObject(com.umeng.analytics.pro.f.L) != null && a2 != 3) {
                    return null;
                }
                if (!android.text.TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                    return null;
                }
            } else if (b2.length() == 2 && b2.optJSONObject(com.umeng.analytics.pro.f.L) != null && !android.text.TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
            java.lang.String optString = b2.optString(com.umeng.analytics.pro.f.n);
            java.lang.String optString2 = b2.optString(com.umeng.analytics.pro.f.Z);
            java.lang.String optString3 = b2.optString("ekv");
            if (android.text.TextUtils.isEmpty(optString) && android.text.TextUtils.isEmpty(optString2) && !android.text.TextUtils.isEmpty(optString3) && a(b2)) {
                return null;
            }
        } else if (a2 != 3) {
            return null;
        }
        org.json.JSONObject l2 = l();
        if (l2 != null) {
            c(l2);
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new org.json.JSONObject());
            } else if (b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (l2 != null && l2.length() > 0) {
                jSONObject.put("header", l2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (java.lang.Throwable unused) {
            return jSONObject;
        }
    }

    public void a() {
        if (a != null) {
            synchronized (this.w) {
                if (this.u) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    android.content.Context context = a;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 4353, com.umeng.analytics.CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    android.content.Context context2 = a;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4354, com.umeng.analytics.CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    public void a(java.lang.Object obj) {
        if (obj != null) {
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (!jSONObject.has("exception")) {
                        g(jSONObject);
                    } else if (101 != jSONObject.getInt("exception")) {
                        g(jSONObject);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void a(java.lang.Object obj, int i) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i != 4357) {
                return;
            }
            try {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                com.umeng.analytics.pro.j.a(a);
                com.umeng.commonsdk.utils.c.c(a);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (com.umeng.analytics.AnalyticsConfig.enable) {
            try {
                if (i == 4358) {
                    if (obj != null && (obj instanceof org.json.JSONObject)) {
                        java.lang.String optString = ((org.json.JSONObject) obj).optString("pk");
                        java.lang.Object opt = ((org.json.JSONObject) obj).opt(com.umeng.analytics.pro.f.T);
                        if (android.text.TextUtils.isEmpty(optString)) {
                            return;
                        }
                        java.lang.String[] a2 = com.umeng.analytics.c.a(a);
                        if (a2 == null || android.text.TextUtils.isEmpty(a2[0]) || android.text.TextUtils.isEmpty(a2[1])) {
                            com.umeng.commonsdk.statistics.common.MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                            return;
                        }
                        if (com.umeng.analytics.pro.f.O.equals(optString)) {
                            com.umeng.analytics.c.a((java.lang.String) opt);
                            return;
                        } else if (com.umeng.analytics.pro.f.P.equals(optString)) {
                            com.umeng.analytics.c.b((java.lang.String) opt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(optString, opt);
                            return;
                        }
                    }
                    return;
                }
                switch (i) {
                    case 4097:
                        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                            com.umeng.analytics.process.UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(a), new org.json.JSONArray().put(obj));
                            return;
                        }
                        if (obj != null) {
                            e(obj);
                        }
                        if (t.equals(((org.json.JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if (t.equals(((org.json.JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4099:
                        com.umeng.analytics.pro.x.a(a);
                        return;
                    case 4100:
                        com.umeng.analytics.pro.n.c(a);
                        return;
                    case 4101:
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((java.lang.Object) null, true);
                        g(obj);
                        return;
                    case 4102:
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((java.lang.Object) null, true);
                        f(obj);
                        return;
                    case 4103:
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        com.umeng.analytics.pro.w.a().a(a, obj);
                        synchronized (this.w) {
                            this.v = true;
                        }
                        return;
                    case com.umeng.analytics.pro.q.a.h /* 4104 */:
                        com.umeng.analytics.pro.w.a().c(a, obj);
                        return;
                    case 4105:
                        d();
                        return;
                    case 4106:
                        h(obj);
                        return;
                    default:
                        switch (i) {
                            case 4352:
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                com.umeng.analytics.pro.w.a().b(a, obj);
                                synchronized (this.w) {
                                    this.u = true;
                                }
                                return;
                            case 4353:
                                a(obj, true);
                                return;
                            case 4354:
                                c();
                                return;
                            case com.umeng.analytics.pro.q.a.n /* 4355 */:
                                if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                                    com.umeng.analytics.process.UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(a), new org.json.JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    }
                                    return;
                                }
                            case com.umeng.analytics.pro.q.a.o /* 4356 */:
                                if (obj == null || y == null || z == null) {
                                    return;
                                }
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                java.lang.String str = "";
                                java.lang.String str2 = "";
                                if (obj instanceof org.json.JSONObject) {
                                    org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                                    if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.f.M)) {
                                        str = jSONObject.getString(com.umeng.analytics.pro.f.M);
                                        str2 = jSONObject.getString("uid");
                                    }
                                    a(str2, str);
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case com.umeng.analytics.pro.q.a.t /* 8195 */:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case com.umeng.analytics.pro.q.a.u /* 8196 */:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case com.umeng.analytics.pro.q.a.v /* 8197 */:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i) {
                                            case com.umeng.analytics.pro.q.a.w /* 8199 */:
                                            case 8200:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case com.umeng.analytics.pro.q.a.y /* 8201 */:
                                                com.umeng.analytics.b.a().b((java.lang.Object) null);
                                                return;
                                            default:
                                                switch (i) {
                                                    case com.umeng.analytics.pro.q.a.z /* 8208 */:
                                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        android.content.Context context = a;
                                                        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.pro.q.a.A, com.umeng.analytics.CoreProtocol.getInstance(context), null);
                                                        android.content.Context context2 = a;
                                                        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4354, com.umeng.analytics.CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case com.umeng.analytics.pro.q.a.A /* 8209 */:
                                                        a(obj, false);
                                                        return;
                                                    case com.umeng.analytics.pro.q.a.B /* 8210 */:
                                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a) || (this.b.c() instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case com.umeng.analytics.pro.q.a.E /* 8213 */:
                                                                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (com.umeng.commonsdk.statistics.common.DeviceConfig.getGlobleActivity(a) != null) {
                                                                        com.umeng.analytics.pro.w.b(a);
                                                                    }
                                                                    android.content.Context context3 = a;
                                                                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(context3, com.umeng.analytics.pro.q.a.E, com.umeng.analytics.CoreProtocol.getInstance(context3), null, 5000L);
                                                                    return;
                                                                }
                                                                return;
                                                            case com.umeng.analytics.pro.q.a.F /* 8214 */:
                                                                if (obj != null && (obj instanceof org.json.JSONObject)) {
                                                                    java.lang.String optString2 = ((org.json.JSONObject) obj).optString(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
                                                                    java.lang.String optString3 = ((org.json.JSONObject) obj).optString(com.umeng.analytics.AnalyticsConfig.RTD_PERIOD);
                                                                    java.lang.String optString4 = ((org.json.JSONObject) obj).optString("debugkey");
                                                                    if (android.text.TextUtils.isEmpty(optString2) || android.text.TextUtils.isEmpty(optString3) || android.text.TextUtils.isEmpty(optString4)) {
                                                                        return;
                                                                    }
                                                                    android.content.Context context4 = a;
                                                                    java.lang.String str3 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE;
                                                                    com.umeng.common.b.a(context4, str3, com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, optString2);
                                                                    com.umeng.common.b.a(a, str3, com.umeng.analytics.AnalyticsConfig.RTD_PERIOD, optString3);
                                                                    com.umeng.common.b.a(a, str3, "debugkey", optString4);
                                                                    return;
                                                                }
                                                                return;
                                                            case com.umeng.analytics.pro.q.a.G /* 8215 */:
                                                                com.umeng.common.b.a(a, com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public void a(java.lang.Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (com.umeng.commonsdk.framework.UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.b.c() instanceof com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime)) {
                if (com.umeng.commonsdk.framework.UMEnvelopeBuild.isReadyBuild(a, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_APP)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z2) {
                if (com.umeng.commonsdk.framework.UMEnvelopeBuild.isOnline(a)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (com.umeng.commonsdk.framework.UMEnvelopeBuild.isReadyBuild(a, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_APP)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    public org.json.JSONObject b(long j) {
        if (android.text.TextUtils.isEmpty(com.umeng.analytics.pro.aa.a().d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        org.json.JSONObject b2 = com.umeng.analytics.pro.k.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(a)).b(false);
        java.lang.String[] a2 = com.umeng.analytics.c.a(a);
        if (a2 != null && !android.text.TextUtils.isEmpty(a2[0]) && !android.text.TextUtils.isEmpty(a2[1])) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.f.M, a2[0]);
                jSONObject.put(com.umeng.analytics.pro.f.N, a2[1]);
                if (jSONObject.length() > 0) {
                    b2.put(com.umeng.analytics.pro.f.L, jSONObject);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        int a3 = com.umeng.analytics.pro.t.a().a(a);
        if (b2.length() == 1 && b2.optJSONObject(com.umeng.analytics.pro.f.L) != null && a3 != 3) {
            return null;
        }
        com.umeng.analytics.pro.t.a().b(b2, a);
        if (b2.length() <= 0 && a3 != 3) {
            return null;
        }
        org.json.JSONObject k = k();
        if (k != null) {
            b(k);
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            if (a3 == 3) {
                jSONObject3.put("analytics", new org.json.JSONObject());
            } else if (b2.length() > 0) {
                jSONObject3.put("analytics", b2);
            }
            if (k != null && k.length() > 0) {
                jSONObject2.put("header", k);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j);
        } catch (java.lang.Throwable unused2) {
            return jSONObject2;
        }
    }

    public org.json.JSONObject b(boolean z2) {
        org.json.JSONArray jSONArray;
        org.json.JSONArray jSONArray2;
        org.json.JSONObject jSONObject = null;
        try {
            jSONObject = com.umeng.analytics.pro.k.a(a).a(z2);
            if (jSONObject == null) {
                jSONObject = new org.json.JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(com.umeng.analytics.pro.f.n);
                    jSONObject = jSONObject;
                    if (has) {
                        org.json.JSONArray jSONArray3 = jSONObject.getJSONArray(com.umeng.analytics.pro.f.n);
                        org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                        int i = 0;
                        while (i < jSONArray3.length()) {
                            org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray3.get(i);
                            org.json.JSONArray optJSONArray = jSONObject2.optJSONArray(com.umeng.analytics.pro.f.t);
                            org.json.JSONArray optJSONArray2 = jSONObject2.optJSONArray(com.umeng.analytics.pro.f.u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(com.umeng.analytics.pro.f.t, optJSONArray2);
                                jSONObject2.remove(com.umeng.analytics.pro.f.u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                java.util.ArrayList arrayList = new java.util.ArrayList();
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList.add((org.json.JSONObject) optJSONArray.get(i2));
                                }
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    arrayList.add((org.json.JSONObject) optJSONArray2.get(i3));
                                }
                                com.umeng.commonsdk.utils.JSONArraySortUtil jSONArraySortUtil = new com.umeng.commonsdk.utils.JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.f.x);
                                java.util.Collections.sort(arrayList, jSONArraySortUtil);
                                org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                                java.util.Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((org.json.JSONObject) it.next());
                                }
                                jSONObject2.put(com.umeng.analytics.pro.f.t, jSONArray5);
                                jSONObject2.remove(com.umeng.analytics.pro.f.u);
                            }
                            if (jSONObject2.has(com.umeng.analytics.pro.f.t)) {
                                org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.analytics.pro.f.t);
                                int i4 = 0;
                                while (i4 < optJSONArray3.length()) {
                                    org.json.JSONObject jSONObject3 = optJSONArray3.getJSONObject(i4);
                                    if (jSONObject3.has(com.umeng.analytics.pro.f.x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(com.umeng.analytics.pro.f.x));
                                        jSONObject3.remove(com.umeng.analytics.pro.f.x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.f.t, optJSONArray3);
                                jSONObject2.put(com.umeng.analytics.pro.f.z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.f.z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(com.umeng.analytics.pro.f.n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (java.lang.Exception e) {
                    com.umeng.commonsdk.statistics.common.MLog.e("merge pages error");
                    e.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a);
            if (sharedPreferences != null) {
                java.lang.String string = sharedPreferences.getString("userlevel", "");
                if (!android.text.TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            java.lang.String[] a2 = com.umeng.analytics.c.a(a);
            if (a2 != null && !android.text.TextUtils.isEmpty(a2[0]) && !android.text.TextUtils.isEmpty(a2[1])) {
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                jSONObject4.put(com.umeng.analytics.pro.f.M, a2[0]);
                jSONObject4.put(com.umeng.analytics.pro.f.N, a2[1]);
                if (jSONObject4.length() > 0) {
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    java.lang.String a3 = com.umeng.analytics.c.a();
                    if (a3 != null) {
                        jSONObject5.put(com.umeng.analytics.pro.f.O, a3);
                    }
                    java.lang.String b2 = com.umeng.analytics.c.b();
                    if (b2 != null) {
                        jSONObject5.put(com.umeng.analytics.pro.f.P, b2);
                    }
                    java.util.Map<java.lang.String, java.lang.Object> c2 = com.umeng.analytics.c.c(a);
                    if (c2 != null && c2.size() > 0) {
                        for (java.lang.String str : c2.keySet()) {
                            jSONObject5.put(str, c2.get(str));
                        }
                    }
                    if (jSONObject5.length() > 0) {
                        jSONObject4.put(com.umeng.analytics.pro.f.R, jSONObject5);
                    }
                    jSONObject.put(com.umeng.analytics.pro.f.L, jSONObject4);
                }
            }
            if (com.umeng.commonsdk.statistics.noise.ABTest.getService(a).isInTest()) {
                org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                jSONObject6.put(com.umeng.commonsdk.statistics.noise.ABTest.getService(a).getTestName(), com.umeng.commonsdk.statistics.noise.ABTest.getService(a).getGroupInfo());
                jSONObject.put(com.umeng.analytics.pro.f.K, jSONObject6);
            }
            com.umeng.analytics.pro.t.a().a(jSONObject, a);
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    public void b() {
    }

    public void b(android.content.Context context) {
        try {
            com.umeng.analytics.pro.k.a(context).d();
            q();
        } catch (java.lang.Throwable unused) {
        }
    }

    public void b(java.lang.Object obj) {
        if (obj != null) {
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (!jSONObject.has("exception")) {
                        f(jSONObject);
                    } else if (101 != jSONObject.getInt("exception")) {
                        f(jSONObject);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void c() {
        b(a);
        d();
        a(true);
    }

    public void c(java.lang.Object obj) {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                com.umeng.analytics.pro.k.a(a).a(this.g);
                this.g = new org.json.JSONArray();
            }
            com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (java.lang.Throwable unused) {
        }
    }

    public void d(java.lang.Object obj) {
        r();
        m();
        n();
        a(true);
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public long f() {
        android.content.SharedPreferences sharedPreferences;
        long j = 0;
        try {
            android.content.Context context = a;
            if (context == null || (sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j2 = sharedPreferences.getLong(l, 0L);
            if (j2 == 0) {
                try {
                    j = java.lang.System.currentTimeMillis();
                    sharedPreferences.edit().putLong(l, j).commit();
                    return j;
                } catch (java.lang.Throwable unused) {
                }
            }
            return j2;
        } catch (java.lang.Throwable unused2) {
            return j;
        }
    }
}
