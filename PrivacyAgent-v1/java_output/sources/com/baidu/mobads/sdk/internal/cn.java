package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cn implements java.lang.Thread.UncaughtExceptionHandler {
    public static java.lang.String a = "";
    private static final java.lang.String b = "remote";
    private static final java.lang.String c = "proxy";
    private static final java.lang.String d = "third-mtj";
    private static final java.lang.String e = "third-cpu";
    private static final java.lang.String f = "third-cpu-cyber";
    private static final java.lang.String g = "third-novel";
    private static final java.lang.String h = "third-aigc";
    private static final java.lang.String i = "third-aigc-virtual";
    private static final java.lang.String j = "third-aigc-speech";
    private static java.lang.Thread.UncaughtExceptionHandler k = null;
    private static volatile com.baidu.mobads.sdk.internal.cn l = null;
    private static final java.lang.String o = "key_crash_source";
    private static final java.lang.String p = "key_crash_trace";
    private static final java.lang.String q = "key_crash_ad";
    private android.content.Context m;
    private com.baidu.mobads.sdk.internal.cn.a n;

    public interface a {
        void a(java.lang.String str);
    }

    private cn(android.content.Context context) {
        this.m = context.getApplicationContext();
        k = java.lang.Thread.getDefaultUncaughtExceptionHandler();
    }

    public static com.baidu.mobads.sdk.internal.cn a(android.content.Context context) {
        if (l == null) {
            synchronized (com.baidu.mobads.sdk.internal.cn.class) {
                if (l == null) {
                    l = new com.baidu.mobads.sdk.internal.cn(context);
                }
            }
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        return e().getString(str, "");
    }

    private java.lang.String a(java.lang.Throwable th) {
        java.lang.Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        java.util.List<java.lang.String> d2 = d();
        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
            java.lang.String className = stackTraceElement.getClassName();
            if (className.startsWith("junit.framework")) {
                return null;
            }
            if (!className.startsWith(com.baidu.mobads.sdk.internal.z.as) && !className.startsWith(com.baidu.mobads.sdk.internal.z.at) && !className.startsWith(com.baidu.mobads.sdk.internal.z.au)) {
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.av) || className.startsWith(com.baidu.mobads.sdk.internal.z.aw) || className.startsWith(com.baidu.mobads.sdk.internal.z.ax)) {
                    return c;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.ay)) {
                    return d;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.az)) {
                    return e;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.aA) || className.startsWith(com.baidu.mobads.sdk.internal.z.aB)) {
                    return f;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.aJ)) {
                    return j;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.aF) || className.startsWith(com.baidu.mobads.sdk.internal.z.aG) || className.startsWith(com.baidu.mobads.sdk.internal.z.aH) || className.startsWith(com.baidu.mobads.sdk.internal.z.aI)) {
                    return i;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.aE)) {
                    return h;
                }
                if (className.startsWith(com.baidu.mobads.sdk.internal.z.aC) || className.startsWith(com.baidu.mobads.sdk.internal.z.aD)) {
                    if (com.baidu.mobads.sdk.internal.cm.g.booleanValue()) {
                        return g;
                    }
                } else if (a(className, d2)) {
                }
            }
            return b;
        }
        return null;
    }

    private boolean a(java.lang.String str, java.util.List<java.lang.String> list) {
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private java.util.List<java.lang.String> d() {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            com.baidu.mobads.sdk.internal.aa a2 = com.baidu.mobads.sdk.internal.aa.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                java.lang.Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof java.util.List) {
                    arrayList.addAll((java.util.List) remoteParam);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return arrayList;
    }

    private android.content.SharedPreferences e() {
        return this.m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private android.content.SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        android.content.SharedPreferences.Editor f2 = f();
        f2.clear();
        f2.apply();
    }

    public void a() {
        com.baidu.mobads.sdk.internal.bd.a().a((com.baidu.mobads.sdk.internal.j) new com.baidu.mobads.sdk.internal.co(this));
    }

    public void a(com.baidu.mobads.sdk.internal.cn.a aVar) {
        this.n = aVar;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor f2 = f();
        java.lang.String str3 = "crashtime:" + java.lang.System.currentTimeMillis() + " ";
        f2.putString(o, str);
        f2.putString(p, str3 + str2);
        f2.putString(q, a);
        f2.commit();
    }

    public void b() {
        if (java.lang.Thread.getDefaultUncaughtExceptionHandler() instanceof com.baidu.mobads.sdk.internal.cn) {
            return;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void c() {
        this.n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            java.lang.String a2 = a(th);
            if (a2 != null) {
                a(a2, android.util.Log.getStackTraceString(th));
                com.baidu.mobads.sdk.internal.cn.a aVar = this.n;
                if (aVar != null) {
                    aVar.a(a2);
                }
            }
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (java.lang.Exception e2) {
            com.baidu.mobads.sdk.internal.bt.a().c(e2);
        }
    }
}
