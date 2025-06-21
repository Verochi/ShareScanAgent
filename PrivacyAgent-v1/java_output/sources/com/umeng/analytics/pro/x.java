package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class x {
    private static final int c = 5;
    private static org.json.JSONArray d = new org.json.JSONArray();
    private static java.lang.Object e = new java.lang.Object();
    private final java.util.Map<java.lang.String, java.lang.Long> f = new java.util.HashMap();
    java.util.Stack<java.lang.String> a = new java.util.Stack<>();
    com.umeng.analytics.vshelper.a b = com.umeng.analytics.vshelper.PageNameMonitor.getInstance();

    public static void a(android.content.Context context) {
        java.lang.String jSONArray;
        if (context != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                synchronized (e) {
                    jSONArray = d.toString();
                    d = new org.json.JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new org.json.JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        com.umeng.analytics.pro.k.a(context).a(com.umeng.analytics.pro.w.a().c(), jSONObject, com.umeng.analytics.pro.k.a.PAGE);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public int a() {
        return 2;
    }

    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog() && this.a.size() != 0) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.F, 0, "\\|", new java.lang.String[]{"@"}, new java.lang.String[]{this.a.peek()}, null, null);
        }
        this.b.customPageBegin(str);
        synchronized (this.f) {
            this.f.put(str, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                this.a.push(str);
            }
        }
    }

    public void b() {
        java.lang.String str;
        synchronized (this.f) {
            str = null;
            long j = 0;
            for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }

    public void b(java.lang.String str) {
        java.lang.Long l;
        android.content.Context appContext;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f.containsKey(str)) {
            if (com.umeng.commonsdk.UMConfigure.isDebugLog() && this.a.size() == 0) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.G, 0, "\\|", new java.lang.String[]{"@"}, new java.lang.String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f) {
            l = this.f.get(str);
            this.f.remove(str);
        }
        if (l == null) {
            return;
        }
        if (com.umeng.commonsdk.UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
            this.a.pop();
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis() - l.longValue();
        synchronized (e) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.umeng.analytics.pro.f.v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(com.umeng.analytics.pro.f.x, l);
                jSONObject.put("type", a());
                d.put(jSONObject);
                if (d.length() >= 5 && (appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(null)) != null) {
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(appContext, 4099, com.umeng.analytics.CoreProtocol.getInstance(appContext), null);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        if (!com.umeng.commonsdk.UMConfigure.isDebugLog() || this.a.size() == 0) {
            return;
        }
        com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.E, 0, "\\|", new java.lang.String[]{"@"}, new java.lang.String[]{str}, null, null);
    }
}
