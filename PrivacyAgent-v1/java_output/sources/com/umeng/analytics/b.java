package com.umeng.analytics;

/* loaded from: classes19.dex */
public class b implements com.umeng.analytics.pro.p, com.umeng.analytics.pro.v {
    private static final java.lang.String A = "umsp_2";
    private static final java.lang.String B = "umsp_3";
    private static final java.lang.String C = "umsp_4";
    private static final java.lang.String D = "umsp_5";
    private static android.content.Context a = null;
    private static final java.lang.String h = "sp_uapp";
    private static final java.lang.String i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static java.lang.String q = "";
    private static java.lang.String r = "";
    private static final java.lang.String t = "ekv_bl_ver";
    private static final java.lang.String w = "ekv_wl_ver";
    private static final java.lang.String z = "umsp_1";
    private com.umeng.common.ISysListener b;
    private com.umeng.analytics.pro.r c;
    private com.umeng.analytics.pro.x d;
    private com.umeng.analytics.pro.m e;
    private com.umeng.analytics.pro.w f;
    private com.umeng.analytics.pro.n g;
    private boolean j;
    private volatile org.json.JSONObject k;
    private volatile org.json.JSONObject l;
    private volatile org.json.JSONObject m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;
    private com.umeng.analytics.pro.o y;

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f442s = com.umeng.analytics.pro.f.ar;
    private static final java.lang.String v = com.umeng.analytics.pro.f.as;

    public static class a {
        private static final com.umeng.analytics.b a = new com.umeng.analytics.b(null);

        private a() {
        }
    }

    static {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext != null) {
            a = appContext.getApplicationContext();
        }
    }

    private b() {
        this.c = new com.umeng.analytics.pro.r();
        this.d = new com.umeng.analytics.pro.x();
        this.e = new com.umeng.analytics.pro.m();
        this.f = com.umeng.analytics.pro.w.a();
        this.g = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.y = null;
        this.c.a(this);
    }

    public /* synthetic */ b(com.umeng.analytics.b.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.b a() {
        return com.umeng.analytics.b.a.a;
    }

    private void a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, long j, boolean z2) {
        try {
            if (context == null) {
                com.umeng.commonsdk.statistics.common.MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (e(str)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            java.lang.String str2 = "";
            if (this.k == null) {
                this.k = new org.json.JSONObject();
            } else {
                str2 = this.k.toString();
            }
            com.umeng.analytics.pro.u.a(a).a(str, map, j, str2, z2);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
    }

    private void b(java.lang.String str, java.lang.Object obj) {
        try {
            if (this.k == null) {
                this.k = new org.json.JSONObject();
            }
            int i2 = 0;
            if (!obj.getClass().isArray()) {
                if (!(obj instanceof java.util.List)) {
                    if ((obj instanceof java.lang.String) || (obj instanceof java.lang.Long) || (obj instanceof java.lang.Integer) || (obj instanceof java.lang.Float) || (obj instanceof java.lang.Double) || (obj instanceof java.lang.Short)) {
                        this.k.put(str, obj);
                        return;
                    }
                    return;
                }
                java.util.List list = (java.util.List) obj;
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                while (i2 < list.size()) {
                    java.lang.Object obj2 = list.get(i2);
                    if ((obj2 instanceof java.lang.String) || (obj2 instanceof java.lang.Long) || (obj2 instanceof java.lang.Integer) || (obj2 instanceof java.lang.Float) || (obj2 instanceof java.lang.Double) || (obj2 instanceof java.lang.Short)) {
                        jSONArray.put(list.get(i2));
                    }
                    i2++;
                }
                this.k.put(str, jSONArray);
                return;
            }
            if (obj instanceof java.lang.String[]) {
                java.lang.String[] strArr = (java.lang.String[]) obj;
                if (strArr.length > 10) {
                    return;
                }
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                while (i2 < strArr.length) {
                    java.lang.String str2 = strArr[i2];
                    if (str2 != null && !com.umeng.commonsdk.statistics.common.HelperUtils.checkStrLen(str2, 256)) {
                        jSONArray2.put(strArr[i2]);
                    }
                    i2++;
                }
                this.k.put(str, jSONArray2);
                return;
            }
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                while (i2 < jArr.length) {
                    jSONArray3.put(jArr[i2]);
                    i2++;
                }
                this.k.put(str, jSONArray3);
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                while (i2 < iArr.length) {
                    jSONArray4.put(iArr[i2]);
                    i2++;
                }
                this.k.put(str, jSONArray4);
                return;
            }
            if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                while (i2 < fArr.length) {
                    jSONArray5.put(fArr[i2]);
                    i2++;
                }
                this.k.put(str, jSONArray5);
                return;
            }
            if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                org.json.JSONArray jSONArray6 = new org.json.JSONArray();
                while (i2 < dArr.length) {
                    jSONArray6.put(dArr[i2]);
                    i2++;
                }
                this.k.put(str, jSONArray6);
                return;
            }
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                org.json.JSONArray jSONArray7 = new org.json.JSONArray();
                while (i2 < sArr.length) {
                    jSONArray7.put((int) sArr[i2]);
                    i2++;
                }
                this.k.put(str, jSONArray7);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean c(java.lang.String str, java.lang.Object obj) {
        int i2;
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.statistics.common.MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i2 = str.getBytes("UTF-8").length;
        } catch (java.io.UnsupportedEncodingException unused) {
            i2 = 0;
        }
        if (i2 > 128) {
            com.umeng.commonsdk.statistics.common.MLog.e("key length is " + i2 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof java.lang.String) {
            if (((java.lang.String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            com.umeng.commonsdk.statistics.common.MLog.e("value length is " + ((java.lang.String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof java.lang.Integer) || (obj instanceof java.lang.Long) || (obj instanceof java.lang.Double) || (obj instanceof java.lang.Float)) {
            return true;
        }
        com.umeng.commonsdk.statistics.common.MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    private boolean e(java.lang.String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (!this.x.enabled()) {
            return false;
        }
        if (!this.x.matchHit(str)) {
            return true;
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    private boolean f(java.lang.String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        com.umeng.commonsdk.statistics.common.MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    private boolean g(java.lang.String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        com.umeng.commonsdk.statistics.common.MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    private void i(android.content.Context context) {
        try {
            if (context == null) {
                com.umeng.commonsdk.statistics.common.MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            if (this.k == null) {
                this.k = new org.json.JSONObject();
            }
            if (this.l == null) {
                this.l = new org.json.JSONObject();
            }
            java.lang.String string = sharedPreferences.getString(i, null);
            if (!android.text.TextUtils.isEmpty(string)) {
                try {
                    this.m = new org.json.JSONObject(string);
                } catch (org.json.JSONException unused) {
                }
            }
            if (this.m == null) {
                this.m = new org.json.JSONObject();
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(double d, double d2) {
        android.content.Context context = a;
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setLocation can not be called in child process");
            return;
        }
        if (com.umeng.analytics.AnalyticsConfig.a == null) {
            com.umeng.analytics.AnalyticsConfig.a = new double[2];
        }
        double[] dArr = com.umeng.analytics.AnalyticsConfig.a;
        dArr[0] = d;
        dArr[1] = d2;
    }

    public void a(long j) {
        android.content.Context context = a;
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            com.umeng.analytics.AnalyticsConfig.kContinueSessionMillis = j;
            com.umeng.analytics.pro.aa.a().a(com.umeng.analytics.AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (this.u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f442s, "ekv_bl_ver");
                this.u = aVar;
                aVar.register(a);
            }
            if (this.x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(v, "ekv_wl_ver");
                this.x = bVar;
                bVar.register(a);
            }
            if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                if (!this.j) {
                    this.j = true;
                    i(a);
                }
                synchronized (this) {
                    if (!this.n) {
                        com.umeng.analytics.pro.n a2 = com.umeng.analytics.pro.n.a(context);
                        this.g = a2;
                        if (a2.a()) {
                            this.n = true;
                        }
                        this.y = com.umeng.analytics.pro.o.a();
                        try {
                            com.umeng.analytics.pro.o.a(context);
                            this.y.a(this);
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
                if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(com.umeng.analytics.pro.l.B, 3, "", null, null);
                }
                com.umeng.commonsdk.framework.UMWorkDispatch.registerConnStateObserver(com.umeng.analytics.CoreProtocol.getInstance(a));
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(android.content.Context context, int i2) {
        if (context == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        com.umeng.analytics.AnalyticsConfig.a(a, i2);
    }

    public void a(android.content.Context context, com.umeng.analytics.MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(a, eScenarioType.toValue());
        }
        if (this.j && this.n) {
            return;
        }
        a(a);
    }

    public void a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.w, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("reportError can not be called in child process");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(a);
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("ts", java.lang.System.currentTimeMillis());
            jSONObject.put(com.umeng.analytics.pro.f.W, 2);
            jSONObject.put("context", str);
            jSONObject.put("__ii", this.f.c());
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4106, com.umeng.analytics.CoreProtocol.getInstance(context2), jSONObject);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
    }

    public synchronized void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        int i2 = 0;
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.af, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (!android.text.TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                com.umeng.commonsdk.statistics.common.MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof java.lang.String) && !com.umeng.commonsdk.statistics.common.HelperUtils.checkStrLen(obj.toString(), 256)) {
                com.umeng.commonsdk.statistics.common.MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.k == null) {
                    this.k = new org.json.JSONObject();
                }
                if (!obj.getClass().isArray()) {
                    if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Long) && !(obj instanceof java.lang.Integer) && !(obj instanceof java.lang.Float) && !(obj instanceof java.lang.Double) && !(obj instanceof java.lang.Short)) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.k.put(str, obj);
                } else if (obj instanceof java.lang.String[]) {
                    java.lang.String[] strArr = (java.lang.String[]) obj;
                    if (strArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    while (i2 < strArr.length) {
                        java.lang.String str2 = strArr[i2];
                        if (str2 != null && com.umeng.commonsdk.statistics.common.HelperUtils.checkStrLen(str2, 256)) {
                            jSONArray.put(strArr[i2]);
                            i2++;
                        }
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                        return;
                    }
                    this.k.put(str, jSONArray);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray2);
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray3);
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray4);
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray5);
                } else {
                    if (!(obj instanceof short[])) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, illegal type!");
                        return;
                    }
                    short[] sArr = (short[]) obj;
                    if (sArr.length > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                        return;
                    }
                    org.json.JSONArray jSONArray6 = new org.json.JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray6);
                }
            } catch (java.lang.Throwable unused) {
            }
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.t, com.umeng.analytics.CoreProtocol.getInstance(context2), this.k.toString());
            return;
        }
        com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ag, 0, "\\|");
    }

    public void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (e(str)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            java.lang.String str3 = "";
            if (this.k == null) {
                this.k = new org.json.JSONObject();
            } else {
                str3 = this.k.toString();
            }
            com.umeng.analytics.pro.u.a(a).a(str, str2, j, i2, str3);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
    }

    public void a(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(a);
            }
            java.lang.String str2 = "";
            if (this.k == null) {
                this.k = new org.json.JSONObject();
            } else {
                str2 = this.k.toString();
            }
            com.umeng.analytics.pro.u.a(a).a(str, hashMap, str2);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
    }

    public void a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        a(context, str, map, -1L, true);
    }

    public void a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, long j) {
        try {
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.c, 0, "\\|");
            return;
        }
        if (java.util.Arrays.asList(com.umeng.analytics.pro.f.aL).contains(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.b, 0, "\\|");
            return;
        }
        if (map.isEmpty()) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.d, 0, "\\|");
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (java.util.Arrays.asList(com.umeng.analytics.pro.f.aL).contains(it.next().getKey())) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.e, 0, "\\|");
                return;
            }
        }
        a(context, str, map, j, false);
    }

    public void a(android.content.Context context, java.lang.Throwable th) {
        if (context == null || th == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.y, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("reportError can not be called in child process");
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(a);
            }
            a(a, com.umeng.commonsdk.statistics.common.DataHelper.convertExceptionToString(th));
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(e);
            }
        }
    }

    public synchronized void a(android.content.Context context, java.util.List<java.lang.String> list) {
        try {
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e(th);
        }
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.aj, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        com.umeng.analytics.pro.u.a(a).a(list);
    }

    public synchronized void a(android.content.Context context, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        java.lang.String obj;
        java.lang.Object obj2;
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.al, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new org.json.JSONObject();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.am, 0, "\\|");
            return;
        }
        try {
            jSONObject2 = new org.json.JSONObject(this.m.toString());
        } catch (java.lang.Exception unused) {
            jSONObject2 = null;
        }
        if (jSONObject2 == null) {
            jSONObject2 = new org.json.JSONObject();
        }
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    obj = keys.next().toString();
                    obj2 = jSONObject.get(obj);
                } catch (java.lang.Exception unused2) {
                }
                if (c(obj, obj2)) {
                    jSONObject2.put(obj, obj2);
                    if (jSONObject2.length() > 10) {
                        com.umeng.commonsdk.statistics.common.MLog.e("please check propertics, size overlength!");
                        return;
                    }
                    continue;
                } else {
                    return;
                }
            }
        }
        this.m = jSONObject2;
        if (this.m.length() > 0) {
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.w, com.umeng.analytics.CoreProtocol.getInstance(context2), this.m.toString());
        }
    }

    public void a(com.umeng.common.ISysListener iSysListener) {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            this.b = iSysListener;
        } else {
            com.umeng.commonsdk.statistics.common.MLog.e("setSysListener can not be called in child process");
        }
    }

    public synchronized void a(java.lang.Object obj) {
        android.content.Context context;
        try {
            context = a;
        } catch (java.lang.Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            java.lang.String str = (java.lang.String) obj;
            android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit();
            if (edit != null && !android.text.TextUtils.isEmpty(str)) {
                edit.putString(h, this.k.toString()).commit();
            }
        }
    }

    public void a(java.lang.String str) {
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.a(str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        if (f(str)) {
            if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Integer) && !(obj instanceof java.lang.Long) && !(obj instanceof java.lang.Short) && !(obj instanceof java.lang.Float) && !(obj instanceof java.lang.Double)) {
                com.umeng.commonsdk.statistics.common.MLog.e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("pk", str);
                if (obj instanceof java.lang.String) {
                    java.lang.String str2 = (java.lang.String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!g(str2)) {
                        return;
                    } else {
                        jSONObject.put(com.umeng.analytics.pro.f.T, str2);
                    }
                } else {
                    jSONObject.put(com.umeng.analytics.pro.f.T, obj);
                }
                android.content.Context context = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.pro.q.a.q, com.umeng.analytics.CoreProtocol.getInstance(context), jSONObject);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void a(java.lang.String str, java.lang.String str2) {
        try {
            android.content.Context context = a;
            if (context == null) {
                return;
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.umeng.analytics.pro.f.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4101, com.umeng.analytics.CoreProtocol.getInstance(context2), jSONObject);
            android.content.Context context3 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context3, com.umeng.analytics.pro.q.a.o, com.umeng.analytics.CoreProtocol.getInstance(context3), jSONObject);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.v
    public void a(java.lang.Throwable th) {
        try {
            android.content.Context context = a;
            if (context == null) {
                return;
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (com.umeng.analytics.AnalyticsConfig.enable) {
                com.umeng.analytics.pro.x xVar = this.d;
                if (xVar != null) {
                    xVar.b();
                }
                com.umeng.analytics.pro.n.a(a, "onAppCrash");
                com.umeng.analytics.pro.m mVar = this.e;
                if (mVar != null) {
                    mVar.b();
                }
                com.umeng.analytics.pro.n nVar = this.g;
                if (nVar != null) {
                    nVar.c();
                }
                com.umeng.analytics.pro.w wVar = this.f;
                if (wVar != null) {
                    wVar.c(a, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                }
                if (th != null) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("ts", java.lang.System.currentTimeMillis());
                    jSONObject.put(com.umeng.analytics.pro.f.W, 1);
                    jSONObject.put("context", com.umeng.commonsdk.statistics.common.DataHelper.convertExceptionToString(th));
                    com.umeng.analytics.pro.k.a(a).a(this.f.c(), jSONObject.toString(), 1);
                }
                com.umeng.analytics.pro.q.a(a).d();
                com.umeng.analytics.pro.x.a(a);
                if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
                    com.umeng.analytics.pro.n.c(a);
                }
                com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e("Exception in onAppCrash", e);
            }
        }
    }

    public void a(javax.microedition.khronos.opengles.GL10 gl10) {
        java.lang.String[] gpu = com.umeng.commonsdk.utils.UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            com.umeng.analytics.AnalyticsConfig.GPU_VENDER = gpu[0];
            com.umeng.analytics.AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    public void a(boolean z2) {
        android.content.Context context = a;
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (com.umeng.analytics.AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            com.umeng.analytics.AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    public org.json.JSONObject b() {
        return this.k;
    }

    public void b(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("unexpected null context in onResume");
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("onResume can not be called in child process");
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog() && !(context instanceof android.app.Activity)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.o, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.e.a(context.getClass().getName());
            }
            h();
            if (com.umeng.commonsdk.UMConfigure.isDebugLog() && (context instanceof android.app.Activity)) {
                q = context.getClass().getName();
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public void b(android.content.Context context, java.lang.String str) {
        try {
            if (context == null) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.N, 0, "\\|");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.O, 0, "\\|");
                return;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.umeng.analytics.pro.f.aK, str);
            a(a, com.umeng.analytics.pro.f.aJ, (java.util.Map<java.lang.String, java.lang.Object>) hashMap, -1L, false);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(th);
            }
        }
    }

    public synchronized void b(java.lang.Object obj) {
        android.content.Context context;
        try {
            context = a;
        } catch (java.lang.Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit();
        if (obj != null) {
            java.lang.String str = (java.lang.String) obj;
            if (edit != null && !android.text.TextUtils.isEmpty(str)) {
                edit.putString(i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(i).commit();
        }
    }

    public void b(java.lang.String str) {
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.b(str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public org.json.JSONObject c() {
        return this.m;
    }

    public void c(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.p, 0, "\\|");
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("onPause can not be called in child process");
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog() && !(context instanceof android.app.Activity)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.q, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.e.b(context.getClass().getName());
            }
            i();
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog() && (context instanceof android.app.Activity)) {
            r = context.getClass().getName();
        }
    }

    public void c(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.z, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        com.umeng.analytics.AnalyticsConfig.a(a, str);
    }

    public void c(java.lang.String str) {
        if (g(str)) {
            a(com.umeng.analytics.pro.f.O, (java.lang.Object) str);
        }
    }

    public org.json.JSONObject d() {
        return this.l;
    }

    public void d(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onKillProcess can not be called in child process");
                return;
            }
            com.umeng.analytics.pro.n nVar = this.g;
            if (nVar != null) {
                nVar.c();
            }
            com.umeng.analytics.pro.n.a(context, "onKillProcess");
            com.umeng.analytics.pro.m mVar = this.e;
            if (mVar != null) {
                mVar.b();
            }
            com.umeng.analytics.pro.x xVar = this.d;
            if (xVar != null) {
                xVar.b();
            }
            android.content.Context context2 = a;
            if (context2 != null) {
                com.umeng.analytics.pro.w wVar = this.f;
                if (wVar != null) {
                    wVar.c(context2, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                }
                com.umeng.analytics.pro.q.a(a).d();
                com.umeng.analytics.pro.x.a(a);
                if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
                    com.umeng.analytics.pro.n.c(a);
                }
                com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public synchronized void d(android.content.Context context, java.lang.String str) {
        try {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ag, 0, "\\|");
            return;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.k == null) {
            this.k = new org.json.JSONObject();
        }
        if (this.k.has(str)) {
            this.k.remove(str);
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.v, com.umeng.analytics.CoreProtocol.getInstance(context2), str);
        }
    }

    public void d(java.lang.String str) {
        if (g(str)) {
            a(com.umeng.analytics.pro.f.P, (java.lang.Object) str);
        }
    }

    public synchronized java.lang.Object e(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.k == null) {
            this.k = new org.json.JSONObject();
        } else if (this.k.has(str)) {
            return this.k.opt(str);
        }
        return null;
    }

    public synchronized java.lang.String e(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.k != null) {
            return this.k.toString();
        }
        this.k = new org.json.JSONObject();
        return null;
    }

    public void e() {
        this.l = null;
    }

    public java.lang.String f() {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            return q;
        }
        com.umeng.commonsdk.statistics.common.MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public synchronized void f(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        this.k = new org.json.JSONObject();
        android.content.Context context2 = a;
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.u, com.umeng.analytics.CoreProtocol.getInstance(context2), null);
    }

    public synchronized void f(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.an, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new org.json.JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.m.has(str)) {
                this.m.remove(str);
                android.content.Context context2 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 8200, com.umeng.analytics.CoreProtocol.getInstance(context2), this.m.toString());
            } else if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ao, 0, "\\|");
            }
            return;
        }
        com.umeng.commonsdk.statistics.common.MLog.e("please check propertics, property is null!");
    }

    public java.lang.String g() {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            return r;
        }
        com.umeng.commonsdk.statistics.common.MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public synchronized void g(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ap, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m.length() > 0) {
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.y, com.umeng.analytics.CoreProtocol.getInstance(context2), null);
        }
        this.m = new org.json.JSONObject();
    }

    public synchronized org.json.JSONObject h(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.aq, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(a)) {
            com.umeng.commonsdk.statistics.common.MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new org.json.JSONObject();
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (this.m.length() > 0) {
            try {
                jSONObject = new org.json.JSONObject(this.m.toString());
            } catch (org.json.JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void h() {
        try {
            android.content.Context context = a;
            if (context != null) {
                if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                    com.umeng.commonsdk.statistics.common.MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                android.content.Context context2 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4352, com.umeng.analytics.CoreProtocol.getInstance(context2), java.lang.Long.valueOf(currentTimeMillis));
                android.content.Context context3 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context3, 4103, com.umeng.analytics.CoreProtocol.getInstance(context3), java.lang.Long.valueOf(currentTimeMillis));
            }
            com.umeng.common.ISysListener iSysListener = this.b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void i() {
        try {
            android.content.Context context = a;
            if (context != null) {
                if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                    com.umeng.commonsdk.statistics.common.MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                android.content.Context context2 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.h, com.umeng.analytics.CoreProtocol.getInstance(context2), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                android.content.Context context3 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context3, 4100, com.umeng.analytics.CoreProtocol.getInstance(context3), null);
                android.content.Context context4 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context4, 4099, com.umeng.analytics.CoreProtocol.getInstance(context4), null);
                android.content.Context context5 = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context5, 4105, com.umeng.analytics.CoreProtocol.getInstance(context5), null);
            }
        } catch (java.lang.Throwable unused) {
        }
        com.umeng.common.ISysListener iSysListener = this.b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public void j() {
        try {
            android.content.Context context = a;
            if (context == null) {
                return;
            }
            if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                com.umeng.commonsdk.statistics.common.MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            android.content.Context context2 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4102, com.umeng.analytics.CoreProtocol.getInstance(context2), jSONObject);
            android.content.Context context3 = a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context3, com.umeng.analytics.pro.q.a.o, com.umeng.analytics.CoreProtocol.getInstance(context3), jSONObject);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.common.MLog.DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        android.content.Context context;
        try {
            context = a;
        } catch (java.lang.Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.k != null) {
            android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit();
            edit.putString(h, this.k.toString());
            edit.commit();
        } else {
            this.k = new org.json.JSONObject();
        }
    }

    public synchronized org.json.JSONObject l() {
        android.content.Context context;
        try {
            context = a;
        } catch (java.lang.Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            com.umeng.commonsdk.statistics.common.MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.k == null) {
            this.k = new org.json.JSONObject();
        }
        return this.k;
    }

    public synchronized void m() {
        try {
            android.content.Context context = a;
            if (context != null) {
                if (!com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                    com.umeng.commonsdk.statistics.common.MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(a).edit();
                    edit.remove(h);
                    edit.commit();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.p
    public void n() {
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (com.umeng.analytics.AnalyticsConfig.enable && com.umeng.commonsdk.config.FieldManager.b()) {
            if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.D)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist(com.umeng.analytics.pro.q.a.B)) {
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                android.content.Context context = a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.pro.q.a.B, com.umeng.analytics.CoreProtocol.getInstance(context), null);
            }
        }
    }
}
