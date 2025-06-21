package com.alipay.sdk.tid;

/* loaded from: classes.dex */
public class TidHelper {
    public static com.alipay.sdk.tid.Tid a(android.content.Context context, com.alipay.sdk.m.t.a aVar) {
        if (aVar == null || aVar.i()) {
            return null;
        }
        return new com.alipay.sdk.tid.Tid(aVar.d(), aVar.c(), aVar.e().longValue());
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        com.alipay.sdk.m.s.b.d().a(context);
    }

    public static com.alipay.sdk.tid.Tid b(android.content.Context context) throws java.lang.Exception {
        try {
            com.alipay.sdk.m.p.b a = new com.alipay.sdk.m.q.c().a(com.alipay.sdk.m.s.a.h(), context);
            if (a != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(a.a());
                com.alipay.sdk.m.t.a a2 = com.alipay.sdk.m.t.a.a(context);
                java.lang.String optString = jSONObject.optString("tid");
                java.lang.String string = jSONObject.getString(com.alipay.sdk.m.t.a.j);
                if (!android.text.TextUtils.isEmpty(optString) && !android.text.TextUtils.isEmpty(string)) {
                    a2.a(optString, string);
                }
                return a(context, a2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public static void clearTID(android.content.Context context) {
        com.alipay.sdk.m.t.a.a(context).a();
    }

    public static java.lang.String getIMEI(android.content.Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).b();
    }

    public static java.lang.String getIMSI(android.content.Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).c();
    }

    public static synchronized java.lang.String getTIDValue(android.content.Context context) {
        java.lang.String tid;
        synchronized (com.alipay.sdk.tid.TidHelper.class) {
            com.alipay.sdk.tid.Tid loadOrCreateTID = loadOrCreateTID(context);
            tid = com.alipay.sdk.tid.Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
        }
        return tid;
    }

    public static java.lang.String getVirtualImei(android.content.Context context) {
        a(context);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.f();
    }

    public static java.lang.String getVirtualImsi(android.content.Context context) {
        a(context);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.g();
    }

    public static com.alipay.sdk.tid.Tid loadLocalTid(android.content.Context context) {
        com.alipay.sdk.m.t.a a = com.alipay.sdk.m.t.a.a(context);
        if (a.h()) {
            return null;
        }
        return new com.alipay.sdk.tid.Tid(a.d(), a.c(), a.e().longValue());
    }

    public static synchronized com.alipay.sdk.tid.Tid loadOrCreateTID(android.content.Context context) {
        synchronized (com.alipay.sdk.tid.TidHelper.class) {
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "load_create_tid");
            a(context);
            com.alipay.sdk.tid.Tid loadTID = loadTID(context);
            if (com.alipay.sdk.tid.Tid.isEmpty(loadTID)) {
                if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                    return null;
                }
                try {
                    loadTID = b(context);
                } catch (java.lang.Throwable unused) {
                }
            }
            return loadTID;
        }
    }

    public static com.alipay.sdk.tid.Tid loadTID(android.content.Context context) {
        a(context);
        com.alipay.sdk.tid.Tid a = a(context, com.alipay.sdk.m.t.a.a(context));
        if (a == null) {
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "load_tid null");
        }
        return a;
    }

    public static boolean resetTID(android.content.Context context) throws java.lang.Exception {
        com.alipay.sdk.tid.Tid tid;
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "reset_tid");
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.Exception("Must be called on worker thread");
        }
        a(context);
        clearTID(context);
        try {
            tid = b(context);
        } catch (java.lang.Throwable unused) {
            tid = null;
        }
        return !com.alipay.sdk.tid.Tid.isEmpty(tid);
    }
}
