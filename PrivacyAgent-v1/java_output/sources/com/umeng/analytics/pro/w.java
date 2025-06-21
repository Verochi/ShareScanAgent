package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class w implements com.umeng.analytics.pro.aa.a {
    public static final java.lang.String a = "session_start_time";
    public static final java.lang.String b = "session_end_time";
    public static final java.lang.String c = "session_id";
    public static final java.lang.String d = "pre_session_id";
    public static final java.lang.String e = "a_start_time";
    public static final java.lang.String f = "a_end_time";
    public static final java.lang.String g = "fg_count";
    private static java.lang.String h = null;
    private static android.content.Context i = null;
    private static boolean j = false;
    private static long k = 0;
    private static boolean l = true;
    private static long m;

    public static class a {
        private static final com.umeng.analytics.pro.w a = new com.umeng.analytics.pro.w(null);

        private a() {
        }
    }

    private w() {
        com.umeng.analytics.pro.aa.a().a(this);
    }

    public /* synthetic */ w(com.umeng.analytics.pro.w.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static long a(android.content.Context context) {
        try {
            return com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getLong(g, 0L);
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    public static com.umeng.analytics.pro.w a() {
        return com.umeng.analytics.pro.w.a.a;
    }

    private void a(android.content.Context context, java.lang.String str, long j2, long j3, long j4) {
        if (android.text.TextUtils.isEmpty(h)) {
            h = com.umeng.analytics.pro.aa.a().a(i);
        }
        if (android.text.TextUtils.isEmpty(str) || str.equals(h)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.umeng.analytics.pro.g.d.a.g, j3);
            jSONObject.put(com.umeng.analytics.pro.g.d.a.h, j4);
            org.json.JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            org.json.JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            com.umeng.analytics.pro.k.a(context).a(h, jSONObject, com.umeng.analytics.pro.k.a.END);
        } catch (java.lang.Exception unused) {
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("__e", j2);
            com.umeng.analytics.pro.k.a(context).a(str, jSONObject2, com.umeng.analytics.pro.k.a.BEGIN);
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                m = j4;
                d(context);
                android.content.Context context2 = i;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(context2, com.umeng.analytics.pro.q.a.E, com.umeng.analytics.CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (java.lang.Exception unused2) {
        }
        h = str;
    }

    private void a(java.lang.String str, long j2) {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(b, 0L);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(com.umeng.analytics.pro.g.d.a.g, j3);
            double[] location = com.umeng.analytics.AnalyticsConfig.getLocation();
            if (location != null) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", java.lang.System.currentTimeMillis());
                jSONObject.put(com.umeng.analytics.pro.g.d.a.e, jSONObject2);
            }
            java.lang.Class<?> cls = java.lang.Class.forName("android.net.TrafficStats");
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            java.lang.reflect.Method method = cls.getMethod("getUidRxBytes", cls2);
            java.lang.reflect.Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i2 = i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((java.lang.Long) method.invoke(null, java.lang.Integer.valueOf(i2))).longValue();
            long longValue2 = ((java.lang.Long) method2.invoke(null, java.lang.Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put(com.umeng.analytics.pro.f.H, longValue);
                jSONObject3.put(com.umeng.analytics.pro.f.G, longValue2);
                jSONObject.put(com.umeng.analytics.pro.g.d.a.d, jSONObject3);
            }
            com.umeng.analytics.pro.k.a(i).a(str, jSONObject, com.umeng.analytics.pro.k.a.NEWSESSION);
            com.umeng.analytics.pro.x.a(i);
            com.umeng.analytics.pro.n.c(i);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(g, 0L);
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(g, j2 + 1);
                edit.commit();
            }
        }
    }

    private void d(android.content.Context context) {
        try {
            android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).edit();
            edit.putLong(g, 0L);
            edit.commit();
        } catch (java.lang.Throwable unused) {
        }
    }

    private java.lang.String e(android.content.Context context) {
        if (i == null && context != null) {
            i = context.getApplicationContext();
        }
        java.lang.String d2 = com.umeng.analytics.pro.aa.a().d(i);
        try {
            f(context);
            com.umeng.analytics.pro.q.a(i).d((java.lang.Object) null);
        } catch (java.lang.Throwable unused) {
        }
        return d2;
    }

    private void f(android.content.Context context) {
        com.umeng.analytics.pro.q.a(context).b(context);
        com.umeng.analytics.pro.q.a(context).d();
    }

    public java.lang.String a(android.content.Context context, long j2, boolean z) {
        java.lang.String b2 = com.umeng.analytics.pro.aa.a().b(context);
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        if (android.text.TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("__e", j2);
            org.json.JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            org.json.JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            com.umeng.analytics.pro.k.a(context).a(b2, jSONObject, com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN);
            com.umeng.analytics.pro.q.a(context).a(jSONObject, z);
        } catch (java.lang.Throwable unused) {
        }
        return b2;
    }

    public void a(android.content.Context context, long j2) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(a, j2);
        edit.commit();
    }

    public void a(android.content.Context context, java.lang.Object obj) {
        android.content.SharedPreferences.Editor edit;
        try {
            if (i == null && context != null) {
                i = context.getApplicationContext();
            }
            long longValue = ((java.lang.Long) obj).longValue();
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            java.lang.String string = sharedPreferences.getString(com.umeng.analytics.pro.f.aF, "");
            java.lang.String appVersionName = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(i);
            if (android.text.TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", java.lang.Integer.parseInt(com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(context)));
                edit.putString(com.umeng.analytics.pro.f.aF, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                java.lang.String string2 = sharedPreferences.getString("pre_date", "");
                java.lang.String string3 = sharedPreferences.getString("pre_version", "");
                java.lang.String string4 = sharedPreferences.getString(com.umeng.analytics.pro.f.aF, "");
                edit.putInt("versioncode", java.lang.Integer.parseInt(com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(context)));
                edit.putString(com.umeng.analytics.pro.f.aF, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (l) {
                    l = false;
                }
                if (j) {
                    j = false;
                    b(i, longValue, true);
                    b(i, longValue);
                    return;
                }
                return;
            }
            if (j) {
                j = false;
                if (l) {
                    l = false;
                }
                h = e(context);
                com.umeng.commonsdk.statistics.common.MLog.d("创建新会话: " + h);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + h);
                return;
            }
            h = sharedPreferences.getString("session_id", null);
            edit.putLong(e, longValue);
            edit.putLong(f, 0L);
            edit.commit();
            com.umeng.commonsdk.statistics.common.MLog.d("延续上一个会话: " + h);
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Extend current session: " + h);
            if (l) {
                l = false;
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    android.content.Context context2 = i;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(context2, com.umeng.analytics.pro.q.a.E, com.umeng.analytics.CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            com.umeng.analytics.pro.q.a(i).a(false);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(java.lang.String str, long j2, long j3, long j4) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(java.lang.String str, java.lang.String str2, long j2, long j3, long j4) {
        a(i, str2, j2, j3, j4);
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.SUB_PROCESS_EVENT) {
            android.content.Context context = i;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.process.UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, com.umeng.analytics.process.UMProcessDBDatasSender.getInstance(context), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        }
    }

    @java.lang.Deprecated
    public java.lang.String b() {
        return h;
    }

    public void b(android.content.Context context, long j2) {
        if (com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            com.umeng.analytics.pro.q.a(i).c((java.lang.Object) null);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void b(android.content.Context context, java.lang.Object obj) {
        try {
            if (i == null) {
                i = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
            }
            long currentTimeMillis = obj == null ? java.lang.System.currentTimeMillis() : ((java.lang.Long) obj).longValue();
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(i);
            if (sharedPreferences == null) {
                return;
            }
            k = sharedPreferences.getLong(f, 0L);
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + k);
            java.lang.String string = sharedPreferences.getString(com.umeng.analytics.pro.f.aF, "");
            java.lang.String appVersionName = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(i);
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (android.text.TextUtils.isEmpty(string) || string.equals(appVersionName)) {
                if (!com.umeng.analytics.pro.aa.a().e(i)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                    j = false;
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                j = true;
                edit.putLong(a, currentTimeMillis);
                edit.commit();
                a(i, currentTimeMillis, false);
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
            edit.putLong(a, currentTimeMillis);
            edit.commit();
            com.umeng.analytics.pro.q.a(i).a((java.lang.Object) null, true);
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + com.umeng.analytics.pro.aa.a().c(i));
            j = true;
            a(i, currentTimeMillis, true);
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean b(android.content.Context context, long j2, boolean z) {
        java.lang.String a2;
        long j3;
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (a2 = com.umeng.analytics.pro.aa.a().a(i)) == null) {
                return false;
            }
            long j4 = sharedPreferences.getLong(e, 0L);
            long j5 = sharedPreferences.getLong(f, 0L);
            if (j4 <= 0 || j5 != 0) {
                return false;
            }
            try {
                if (z) {
                    j3 = k;
                    if (j3 == 0) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                        j3 = j2;
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + k);
                    }
                    c(i, java.lang.Long.valueOf(j3));
                } else {
                    c(i, java.lang.Long.valueOf(j2));
                    j3 = j2;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (z) {
                    jSONObject.put(com.umeng.analytics.pro.g.d.a.g, j3);
                } else {
                    jSONObject.put(com.umeng.analytics.pro.g.d.a.g, j2);
                }
                org.json.JSONObject b2 = com.umeng.analytics.b.a().b();
                if (b2 != null && b2.length() > 0) {
                    jSONObject.put("__sp", b2);
                }
                org.json.JSONObject c2 = com.umeng.analytics.b.a().c();
                if (c2 != null && c2.length() > 0) {
                    jSONObject.put("__pp", c2);
                }
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + m);
                    jSONObject.put(com.umeng.analytics.pro.g.d.a.h, m);
                    m = 0L;
                } else {
                    jSONObject.put(com.umeng.analytics.pro.g.d.a.h, 0L);
                }
                com.umeng.analytics.pro.k.a(context).a(a2, jSONObject, com.umeng.analytics.pro.k.a.END);
                com.umeng.analytics.pro.q.a(i).e();
            } catch (java.lang.Throwable unused) {
            }
            return true;
        } catch (java.lang.Throwable unused2) {
            return false;
        }
    }

    @java.lang.Deprecated
    public java.lang.String c() {
        return c(i);
    }

    @java.lang.Deprecated
    public java.lang.String c(android.content.Context context) {
        try {
            if (h == null) {
                return com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (java.lang.Throwable unused) {
        }
        return h;
    }

    public void c(android.content.Context context, java.lang.Object obj) {
        try {
            if (i == null && context != null) {
                i = context.getApplicationContext();
            }
            long longValue = ((java.lang.Long) obj).longValue();
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(e, 0L) == 0) {
                com.umeng.commonsdk.statistics.common.MLog.e("onPause called before onResume");
                return;
            }
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f, longValue);
            edit.putLong(b, longValue);
            edit.commit();
        } catch (java.lang.Throwable unused) {
        }
    }
}
