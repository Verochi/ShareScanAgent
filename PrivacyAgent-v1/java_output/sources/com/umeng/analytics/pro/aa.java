package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class aa {
    private static volatile com.umeng.analytics.pro.aa c;
    private com.umeng.analytics.pro.y a = new com.umeng.analytics.pro.z();
    private java.lang.String b;
    private java.util.List<com.umeng.analytics.pro.aa.a> d;
    private java.lang.String e;

    public interface a {
        void a(java.lang.String str, long j, long j2, long j3);

        void a(java.lang.String str, java.lang.String str2, long j, long j2, long j3);
    }

    private aa() {
    }

    private long a(android.content.Context context, java.lang.String str) {
        long j;
        try {
            j = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (java.lang.Exception unused) {
            j = 0;
        }
        return j <= 0 ? java.lang.System.currentTimeMillis() : j;
    }

    public static com.umeng.analytics.pro.aa a() {
        if (c == null) {
            synchronized (com.umeng.analytics.pro.aa.class) {
                if (c == null) {
                    c = new com.umeng.analytics.pro.aa();
                }
            }
        }
        return c;
    }

    private void a(long j, long j2, long j3, java.lang.String str, boolean z) {
        java.util.List<com.umeng.analytics.pro.aa.a> list = this.d;
        if (list != null) {
            for (com.umeng.analytics.pro.aa.a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.b, j, j2, j3);
                    } catch (java.lang.Exception unused) {
                    }
                } else {
                    aVar.a(this.b, j, j2, j3);
                }
            }
        }
    }

    private java.lang.String f(android.content.Context context) {
        try {
            android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).edit();
            edit.putString(com.umeng.analytics.pro.w.d, d(context));
            edit.commit();
        } catch (java.lang.Exception unused) {
        }
        long h = h(context);
        long i = i(context);
        java.lang.String str = this.b;
        long a2 = com.umeng.analytics.pro.w.a(context);
        long j = a2 * 5000;
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist()) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            com.umeng.commonsdk.framework.UMWorkDispatch.removeEvent();
        } else {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i, h, j, str, false);
        this.b = this.a.a(context);
        a(i, h, j, str, true);
        this.a.a(context, this.b);
        return this.b;
    }

    private boolean g(android.content.Context context) {
        return !android.text.TextUtils.isEmpty(this.b) && com.umeng.analytics.pro.k.a(context).a(this.b) > 0;
    }

    private long h(android.content.Context context) {
        return a(context, com.umeng.analytics.pro.w.f);
    }

    private long i(android.content.Context context) {
        return a(context, com.umeng.analytics.pro.w.a);
    }

    private boolean j(android.content.Context context) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(com.umeng.analytics.pro.w.e, 0L);
            long j2 = sharedPreferences.getLong(com.umeng.analytics.pro.w.f, 0L);
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j > 0 && j2 == 0) {
                long a2 = com.umeng.analytics.pro.w.a(appContext);
                if (a2 > 0) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (a2 * 5000);
                }
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.a.a(j, j2);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public java.lang.String a(android.content.Context context) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        java.lang.String str = "";
        try {
            synchronized (com.umeng.analytics.pro.aa.class) {
                str = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(appContext).getString(com.umeng.analytics.pro.w.d, "");
            }
        } catch (java.lang.Exception unused) {
        }
        return str;
    }

    public java.lang.String a(android.content.Context context, long j) {
        if (android.text.TextUtils.isEmpty(this.e)) {
            java.lang.String str = "SUB" + j;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(java.lang.String.format("%0" + (32 - str.length()) + "d", 0));
            this.e = sb.toString();
        }
        return this.e;
    }

    public void a(long j) {
        this.a.a(j);
    }

    public void a(com.umeng.analytics.pro.aa.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new java.util.ArrayList();
        }
        if (this.d.contains(aVar)) {
            return;
        }
        this.d.add(aVar);
    }

    public long b() {
        return this.a.a();
    }

    public synchronized java.lang.String b(android.content.Context context) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.b = d(appContext);
        if (e(appContext)) {
            try {
                this.b = f(appContext);
            } catch (java.lang.Exception unused) {
            }
        }
        return this.b;
    }

    public void b(com.umeng.analytics.pro.aa.a aVar) {
        java.util.List<com.umeng.analytics.pro.aa.a> list;
        if (aVar == null || (list = this.d) == null || list.size() == 0) {
            return;
        }
        this.d.remove(aVar);
    }

    public java.lang.String c(android.content.Context context) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (java.lang.Exception unused) {
        }
        return this.b;
    }

    public java.lang.String d(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.b)) {
            try {
                this.b = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (java.lang.Exception unused) {
            }
        }
        return this.b;
    }

    public boolean e(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return android.text.TextUtils.isEmpty(this.b) || j(context) || g(context);
    }
}
