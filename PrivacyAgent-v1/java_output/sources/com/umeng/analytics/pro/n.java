package com.umeng.analytics.pro;

@android.annotation.TargetApi(14)
/* loaded from: classes19.dex */
public class n {
    public static java.lang.String a;
    boolean b;
    boolean c;
    com.umeng.analytics.vshelper.a f;
    android.app.Application.ActivityLifecycleCallbacks g;
    private final java.util.Map<java.lang.String, java.lang.Long> h;
    private boolean l;
    private int m;
    private int n;
    private static org.json.JSONArray i = new org.json.JSONArray();
    private static java.lang.Object j = new java.lang.Object();
    private static android.app.Application k = null;
    static java.lang.String d = null;
    static int e = -1;
    private static boolean o = true;
    private static java.lang.Object p = new java.lang.Object();
    private static com.umeng.analytics.pro.by q = new com.umeng.analytics.vshelper.b();

    /* renamed from: com.umeng.analytics.pro.n$1, reason: invalid class name */
    public class AnonymousClass1 implements android.app.Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            com.umeng.analytics.pro.n.q.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                synchronized (com.umeng.analytics.pro.n.p) {
                    if (com.umeng.analytics.pro.n.o) {
                        return;
                    }
                }
            } else {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
            }
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
                if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            } else {
                com.umeng.analytics.pro.n.this.c(activity);
                com.umeng.analytics.b.a().i();
                com.umeng.analytics.pro.n.this.b = false;
                com.umeng.analytics.pro.n.q.d(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                synchronized (com.umeng.analytics.pro.n.p) {
                    if (com.umeng.analytics.pro.n.o) {
                        boolean unused = com.umeng.analytics.pro.n.o = false;
                    }
                }
                com.umeng.analytics.pro.n.this.a(activity);
            } else {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                com.umeng.analytics.pro.n.this.a(activity);
            }
            com.umeng.analytics.pro.n.q.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            if (activity != null) {
                if (com.umeng.analytics.pro.n.this.m <= 0) {
                    if (com.umeng.analytics.pro.n.d == null) {
                        com.umeng.analytics.pro.n.d = java.util.UUID.randomUUID().toString();
                    }
                    if (com.umeng.analytics.pro.n.e == -1) {
                        com.umeng.analytics.pro.n.e = activity.isTaskRoot() ? 1 : 0;
                    }
                    if (com.umeng.analytics.pro.n.e == 0 && com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity)) {
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put("activityName", activity.toString());
                        hashMap.put("pid", java.lang.Integer.valueOf(android.os.Process.myPid()));
                        hashMap.put("isMainProcess", java.lang.Integer.valueOf(com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity) ? 1 : 0));
                        com.umeng.analytics.b a = com.umeng.analytics.b.a();
                        if (a != null) {
                            a.a((android.content.Context) activity, "$$_onUMengEnterForegroundInitError", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
                        }
                        com.umeng.analytics.pro.n.e = -2;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, com.umeng.analytics.pro.l.ar);
                        }
                    } else if (com.umeng.analytics.pro.n.e == 1 || !com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity)) {
                        java.util.HashMap hashMap2 = new java.util.HashMap();
                        hashMap2.put("pairUUID", com.umeng.analytics.pro.n.d);
                        hashMap2.put("pid", java.lang.Integer.valueOf(android.os.Process.myPid()));
                        hashMap2.put("isMainProcess", java.lang.Integer.valueOf(com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap2.put("activityName", activity.toString());
                        if (com.umeng.analytics.b.a() != null) {
                            com.umeng.analytics.b.a().a((android.content.Context) activity, "$$_onUMengEnterForeground", (java.util.Map<java.lang.String, java.lang.Object>) hashMap2);
                        }
                    }
                }
                if (com.umeng.analytics.pro.n.this.n < 0) {
                    com.umeng.analytics.pro.n.e(com.umeng.analytics.pro.n.this);
                } else {
                    com.umeng.analytics.pro.n.f(com.umeng.analytics.pro.n.this);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            com.umeng.commonsdk.debug.UMLog uMLog = com.umeng.commonsdk.UMConfigure.umDebugLog;
            com.umeng.analytics.MobclickAgent.PageMode pageMode = com.umeng.analytics.MobclickAgent.PageMode.AUTO;
            if (activity != null) {
                if (activity.isChangingConfigurations()) {
                    com.umeng.analytics.pro.n.a(com.umeng.analytics.pro.n.this);
                    return;
                }
                com.umeng.analytics.pro.n.b(com.umeng.analytics.pro.n.this);
                if (com.umeng.analytics.pro.n.this.m <= 0) {
                    if (com.umeng.analytics.pro.n.e == 0 && com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity)) {
                        return;
                    }
                    int i = com.umeng.analytics.pro.n.e;
                    if (i == 1 || (i == 0 && !com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity))) {
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put("pairUUID", com.umeng.analytics.pro.n.d);
                        hashMap.put("reason", "Normal");
                        hashMap.put("pid", java.lang.Integer.valueOf(android.os.Process.myPid()));
                        hashMap.put("isMainProcess", java.lang.Integer.valueOf(com.umeng.commonsdk.utils.UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap.put("activityName", activity.toString());
                        com.umeng.analytics.b a = com.umeng.analytics.b.a();
                        if (a != null) {
                            a.a((android.content.Context) activity, "$$_onUMengEnterBackground", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
                        }
                        if (com.umeng.analytics.pro.n.d != null) {
                            com.umeng.analytics.pro.n.d = null;
                        }
                    }
                }
            }
        }
    }

    public static class a {
        private static final com.umeng.analytics.pro.n a = new com.umeng.analytics.pro.n(null);

        private a() {
        }
    }

    private n() {
        this.h = new java.util.HashMap();
        this.l = false;
        this.b = false;
        this.c = false;
        this.m = 0;
        this.n = 0;
        this.f = com.umeng.analytics.vshelper.PageNameMonitor.getInstance();
        this.g = new com.umeng.analytics.pro.n.AnonymousClass1();
        synchronized (this) {
            if (k != null) {
                g();
            }
        }
    }

    public /* synthetic */ n(com.umeng.analytics.pro.n.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static /* synthetic */ int a(com.umeng.analytics.pro.n nVar) {
        int i2 = nVar.n;
        nVar.n = i2 - 1;
        return i2;
    }

    public static synchronized com.umeng.analytics.pro.n a(android.content.Context context) {
        com.umeng.analytics.pro.n nVar;
        synchronized (com.umeng.analytics.pro.n.class) {
            if (k == null && context != null) {
                if (context instanceof android.app.Activity) {
                    k = ((android.app.Activity) context).getApplication();
                } else if (context instanceof android.app.Application) {
                    k = (android.app.Application) context;
                }
            }
            nVar = com.umeng.analytics.pro.n.a.a;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.app.Activity activity) {
        if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != com.umeng.analytics.MobclickAgent.PageMode.AUTO) {
            if (com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            java.lang.String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f.activityResume(str);
            if (!this.b) {
                b(activity);
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            this.b = false;
            if (android.text.TextUtils.isEmpty(a)) {
                a = str;
            } else {
                if (a.equals(str)) {
                    return;
                }
                b(activity);
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (e == 1 && com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("pairUUID", d);
            hashMap.put("reason", str);
            if (d != null) {
                d = null;
            }
            if (context != null) {
                hashMap.put("pid", java.lang.Integer.valueOf(android.os.Process.myPid()));
                hashMap.put("isMainProcess", java.lang.Integer.valueOf(com.umeng.commonsdk.utils.UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
            }
        }
    }

    public static /* synthetic */ int b(com.umeng.analytics.pro.n nVar) {
        int i2 = nVar.m;
        nVar.m = i2 - 1;
        return i2;
    }

    private void b(android.app.Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.h) {
            this.h.put(a, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(android.app.Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.h) {
                if (a == null && activity != null) {
                    a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                if (android.text.TextUtils.isEmpty(a) || !this.h.containsKey(a)) {
                    j2 = 0;
                    j3 = 0;
                } else {
                    j2 = this.h.get(a).longValue();
                    j3 = java.lang.System.currentTimeMillis() - j2;
                    this.h.remove(a);
                }
            }
            synchronized (j) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.umeng.analytics.pro.f.v, a);
                    jSONObject.put("duration", j3);
                    jSONObject.put(com.umeng.analytics.pro.f.x, j2);
                    jSONObject.put("type", 0);
                    i.put(jSONObject);
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static void c(android.content.Context context) {
        java.lang.String jSONArray;
        if (context != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                synchronized (j) {
                    jSONArray = i.toString();
                    i = new org.json.JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(com.umeng.analytics.pro.g.d.a.c, new org.json.JSONArray(jSONArray));
                    com.umeng.analytics.pro.k.a(context).a(com.umeng.analytics.pro.w.a().c(), jSONObject, com.umeng.analytics.pro.k.a.AUTOPAGE);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static /* synthetic */ int e(com.umeng.analytics.pro.n nVar) {
        int i2 = nVar.n;
        nVar.n = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int f(com.umeng.analytics.pro.n nVar) {
        int i2 = nVar.m;
        nVar.m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.l) {
            return;
        }
        this.l = true;
        if (k != null) {
            k.registerActivityLifecycleCallbacks(this.g);
        }
    }

    public boolean a() {
        return this.l;
    }

    public void b() {
        this.l = false;
        if (k != null) {
            k.unregisterActivityLifecycleCallbacks(this.g);
            k = null;
        }
    }

    public void b(android.content.Context context) {
        synchronized (p) {
            if (!o) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
                return;
            }
            o = false;
            android.app.Activity globleActivity = com.umeng.commonsdk.statistics.common.DeviceConfig.getGlobleActivity(context);
            if (globleActivity == null) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
            a(globleActivity);
        }
    }

    public void c() {
        c((android.app.Activity) null);
        b();
    }
}
