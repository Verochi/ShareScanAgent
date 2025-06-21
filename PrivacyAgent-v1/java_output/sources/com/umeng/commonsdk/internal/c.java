package com.umeng.commonsdk.internal;

/* loaded from: classes19.dex */
public class c implements com.umeng.commonsdk.framework.UMLogDataProtocol {
    public static final java.lang.String b = "preInitInvokedFlag";
    public static final java.lang.String c = "policyGrantInvokedFlag";
    public static final java.lang.String d = "policyGrantResult";
    private static int f = 1;
    private android.content.Context e;
    public static final java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.q);
    private static java.lang.Class<?> g = null;
    private static java.lang.reflect.Method h = null;
    private static java.lang.reflect.Method i = null;
    private static java.lang.reflect.Method j = null;
    private static volatile java.lang.String k = "";
    private static volatile java.lang.String l = "";
    private static boolean m = false;

    /* renamed from: com.umeng.commonsdk.internal.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                android.content.SharedPreferences sharedPreferences = this.a.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.a, 0);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                java.lang.String a = com.umeng.analytics.pro.ba.a(this.a);
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                if (!android.text.TextUtils.isEmpty(a) && sharedPreferences != null) {
                    android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(com.umeng.commonsdk.statistics.idtracking.i.c, (currentTimeMillis2 - currentTimeMillis) + "");
                    edit.commit();
                }
                if (sharedPreferences != null) {
                    android.content.SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    edit2.putString(com.umeng.commonsdk.statistics.idtracking.i.b, a);
                    edit2.commit();
                }
                if (com.umeng.commonsdk.statistics.common.DeviceConfig.isHonorDevice()) {
                    if (com.umeng.analytics.pro.bm.c()) {
                        java.lang.String c = com.umeng.analytics.pro.ba.c(this.a);
                        if (sharedPreferences != null) {
                            android.content.SharedPreferences.Editor edit3 = sharedPreferences.edit();
                            edit3.putString(com.umeng.commonsdk.statistics.idtracking.c.b, c);
                            edit3.commit();
                        }
                    } else if (com.umeng.analytics.pro.bm.b() && sharedPreferences != null) {
                        android.content.SharedPreferences.Editor edit4 = sharedPreferences.edit();
                        edit4.putString(com.umeng.commonsdk.statistics.idtracking.c.b, a);
                        edit4.commit();
                    }
                }
                if (this.b) {
                    com.umeng.commonsdk.UMConfigureImpl.removeInterruptFlag();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.umeng.commonsdk.listener.OnGetOaidListener b;

        public AnonymousClass2(android.content.Context context, com.umeng.commonsdk.listener.OnGetOaidListener onGetOaidListener) {
            this.a = context;
            this.b = onGetOaidListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String a = com.umeng.analytics.pro.ba.a(this.a);
            com.umeng.commonsdk.listener.OnGetOaidListener onGetOaidListener = this.b;
            if (onGetOaidListener != null) {
                onGetOaidListener.onGetOaid(a);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.umeng.commonsdk.listener.OnGetOaidListener {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass3(android.content.Context context) {
            this.a = context;
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                android.content.SharedPreferences sharedPreferences = this.a.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.a, 0);
                if (sharedPreferences == null || sharedPreferences.getString(com.umeng.commonsdk.statistics.idtracking.i.b, "").equalsIgnoreCase(str)) {
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(com.umeng.commonsdk.statistics.idtracking.i.b, str);
                edit.commit();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$4, reason: invalid class name */
    public class AnonymousClass4 implements com.umeng.commonsdk.listener.OnGetOaidListener {
        public AnonymousClass4() {
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(java.lang.String str) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
            if (android.text.TextUtils.isEmpty(str)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                return;
            }
            try {
                android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.internal.c.this.e.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.a, 0);
                if (sharedPreferences != null) {
                    android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(com.umeng.commonsdk.statistics.idtracking.i.b, str);
                    edit.commit();
                }
            } catch (java.lang.Throwable unused) {
            }
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.commonsdk.internal.c.this.e, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.internal.c.this.e).a(), null);
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$5, reason: invalid class name */
    public class AnonymousClass5 implements com.umeng.commonsdk.utils.onMessageSendListener {
        public AnonymousClass5() {
        }

        @Override // com.umeng.commonsdk.utils.onMessageSendListener
        public void onMessageSend() {
            if (com.umeng.commonsdk.internal.c.this.e != null) {
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.commonsdk.internal.c.this.e, com.umeng.commonsdk.internal.a.x, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.internal.c.this.e).a(), null);
            }
            com.umeng.commonsdk.UMConfigureImpl.removeMessageSendListener(this);
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$6, reason: invalid class name */
    public class AnonymousClass6 implements com.umeng.ccg.ConfigListener {
        public AnonymousClass6() {
        }

        @Override // com.umeng.ccg.ConfigListener
        public void onConfigReady(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject.toString());
            com.umeng.ccg.c.a(com.umeng.commonsdk.internal.c.this.e, 201, com.umeng.ccg.d.a(), jSONObject);
        }
    }

    static {
        c();
    }

    public c(android.content.Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    private static java.lang.Class<?> a(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    private void a(android.content.Context context) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), com.umeng.commonsdk.service.UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), com.umeng.commonsdk.service.UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            org.json.JSONObject buildZeroEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, com.umeng.commonsdk.statistics.UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(android.content.Context context, com.umeng.commonsdk.listener.OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        new java.lang.Thread(new com.umeng.commonsdk.internal.c.AnonymousClass2(context.getApplicationContext(), onGetOaidListener)).start();
    }

    public static void a(android.content.Context context, boolean z) {
        new java.lang.Thread(new com.umeng.commonsdk.internal.c.AnonymousClass1(context, z)).start();
    }

    public static java.lang.String b() {
        java.lang.reflect.Method method;
        if (!android.text.TextUtils.isEmpty(l)) {
            return l;
        }
        java.lang.Class<?> cls = g;
        if (cls == null || (method = h) == null || j == null) {
            return "";
        }
        try {
            java.lang.Object invoke = method.invoke(cls, new java.lang.Object[0]);
            if (invoke == null) {
                return "";
            }
            java.lang.String str = (java.lang.String) j.invoke(invoke, new java.lang.Object[0]);
            try {
                l = str;
            } catch (java.lang.Throwable unused) {
            }
            return str;
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    private void b(android.content.Context context) {
        try {
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, com.umeng.analytics.pro.bo.g, "");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), com.umeng.commonsdk.service.UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.bo.g), imprintProperty);
            org.json.JSONObject buildSilentEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, com.umeng.commonsdk.statistics.UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader == null || !buildSilentEnvelopeWithExtHeader.has("exception")) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            } else {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c() {
        try {
            g = com.umeng.umzid.ZIDManager.class;
            java.lang.reflect.Method declaredMethod = com.umeng.umzid.ZIDManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            if (declaredMethod != null) {
                h = declaredMethod;
            }
            java.lang.reflect.Method declaredMethod2 = g.getDeclaredMethod("getZID", android.content.Context.class);
            if (declaredMethod2 != null) {
                i = declaredMethod2;
            }
            java.lang.reflect.Method declaredMethod3 = g.getDeclaredMethod("getSDKVersion", new java.lang.Class[0]);
            if (declaredMethod3 != null) {
                j = declaredMethod3;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c(android.content.Context context) {
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new com.umeng.commonsdk.internal.c.AnonymousClass3(context));
        }
    }

    private void d() {
        com.umeng.analytics.pro.bq a2 = com.umeng.analytics.pro.bq.a(this.e);
        com.umeng.analytics.pro.br a3 = a2.a(com.umeng.analytics.pro.bs.c);
        if (a3 != null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                java.lang.String str = a3.a;
                java.lang.String str2 = a3.b;
                org.json.JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.e.getApplicationContext(), new org.json.JSONObject(a3.c), new org.json.JSONObject(a3.d), a3.e, str2, a3.f);
                if (a4 == null || !a4.has("exception")) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a2.a(com.umeng.analytics.pro.bs.c, str);
                a2.b();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(android.content.Context context) {
        long longValue;
        long longValue2;
        if (context == null) {
            return;
        }
        java.lang.String str = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE;
        java.lang.String a2 = com.umeng.common.b.a(context, str, "debugkey");
        if (android.text.TextUtils.isEmpty(a2)) {
            return;
        }
        java.lang.String a3 = com.umeng.common.b.a(context, str, com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
        java.lang.String a4 = com.umeng.common.b.a(context, str, com.umeng.analytics.AnalyticsConfig.RTD_PERIOD);
        if (!android.text.TextUtils.isEmpty(a3)) {
            try {
                longValue = java.lang.Long.valueOf(a3).longValue();
            } catch (java.lang.Throwable unused) {
            }
            if (!android.text.TextUtils.isEmpty(a4)) {
                try {
                    longValue2 = java.lang.Long.valueOf(a4).longValue();
                } catch (java.lang.Throwable unused2) {
                }
                if (longValue != 0 || longValue2 == 0) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
                    com.umeng.common.b.a(context, com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE);
                }
                if (java.lang.System.currentTimeMillis() - longValue > longValue2 * 60 * 1000) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
                    com.umeng.common.b.a(context, com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE);
                    if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                        com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug();
                        return;
                    }
                    return;
                }
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("debugkey", a2);
                if (com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
                com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                return;
            }
            longValue2 = 0;
            if (longValue != 0) {
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
            com.umeng.common.b.a(context, com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE);
        }
        longValue = 0;
        if (!android.text.TextUtils.isEmpty(a4)) {
        }
        longValue2 = 0;
        if (longValue != 0) {
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
        com.umeng.common.b.a(context, com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE);
    }

    private void e() {
        if (m) {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            m = false;
        } else if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            a(this.e, new com.umeng.commonsdk.internal.c.AnonymousClass4());
        }
    }

    private void e(android.content.Context context) {
        java.lang.Object invoke;
        java.lang.reflect.Method declaredMethod;
        android.content.Context applicationContext = context.getApplicationContext();
        java.lang.String appkey = com.umeng.commonsdk.utils.UMUtils.getAppkey(context);
        try {
            java.lang.Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            java.lang.reflect.Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new java.lang.Object[0])) == null || (declaredMethod = a2.getDeclaredMethod("init", android.content.Context.class, java.lang.String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void f() {
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            com.umeng.commonsdk.UMConfigureImpl.registerInterruptFlag();
            com.umeng.commonsdk.UMConfigureImpl.init(this.e);
            f++;
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            com.umeng.commonsdk.UMConfigureImpl.registerMessageSendListener(new com.umeng.commonsdk.internal.c.AnonymousClass5());
            a(this.e, true);
        }
    }

    private static void f(android.content.Context context) {
        java.io.File file = new java.io.File(context.getFilesDir().getAbsolutePath() + java.io.File.separator + com.umeng.analytics.pro.bs.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (java.lang.Throwable unused) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            e(this.e);
        }
    }

    private void h() {
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(this.e)) {
            f(this.e);
            com.umeng.commonsdk.UMInnerManager.sendInnerPackage(this.e);
            if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.at) && com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0 && com.umeng.commonsdk.utils.UMUtils.isMainProgress(this.e)) {
                android.content.Context context = this.e;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.G, com.umeng.commonsdk.internal.b.a(context).a(), null, 5000L);
            }
            android.content.Context context2 = this.e;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.analytics.pro.q.a.z, com.umeng.analytics.CoreProtocol.getInstance(context2), null);
            android.content.Context context3 = this.e;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context3, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context3).a(), null);
        }
    }

    public java.lang.String a() {
        java.lang.reflect.Method method;
        if (!android.text.TextUtils.isEmpty(k)) {
            return k;
        }
        java.lang.Class<?> cls = g;
        if (cls == null || (method = h) == null || i == null) {
            return "";
        }
        try {
            java.lang.Object invoke = method.invoke(cls, new java.lang.Object[0]);
            if (invoke == null) {
                return "";
            }
            java.lang.String str = (java.lang.String) i.invoke(invoke, this.e);
            try {
                k = str;
            } catch (java.lang.Throwable unused) {
            }
            return str;
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(java.lang.Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public org.json.JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02be A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d7 A[Catch: all -> 0x0432, TRY_LEAVE, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void workEvent(java.lang.Object obj, int i2) {
        android.content.SharedPreferences.Editor edit;
        boolean z = true;
        boolean z2 = false;
        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent");
        if (com.umeng.commonsdk.utils.c.a()) {
            if (32802 == i2) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 静默模式：进入心跳处理逻辑!");
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long b2 = com.umeng.commonsdk.utils.c.b(this.e);
                boolean e = com.umeng.commonsdk.utils.c.e(this.e);
                if (com.umeng.commonsdk.utils.c.a(b2, currentTimeMillis, com.umeng.commonsdk.utils.c.a(this.e))) {
                    if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(this.e, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_Silent)) {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 静默心跳信封文件已存在，尝试发送之!");
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建静默心跳信封.");
                        b(this.e);
                    }
                    com.umeng.commonsdk.framework.UMEnvelopeBuild.registerNetReceiver(this.e);
                }
                if (e) {
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> send REBUILD_DB msg in silent mode.");
                android.content.Context context = this.e;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.pro.q.a.p, com.umeng.analytics.CoreProtocol.getInstance(context), null, 2000L);
            }
            return;
        }
        try {
            switch (i2) {
                case 32769:
                    com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent send envelope");
                    com.umeng.commonsdk.internal.UMInternalManagerAgent.class.getMethod("sendInternalEnvelopeByStateful2", android.content.Context.class).invoke(com.umeng.commonsdk.internal.UMInternalManagerAgent.class, this.e);
                    break;
                case 32771:
                    if (obj != null && (obj instanceof com.umeng.commonsdk.internal.utils.b)) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        com.umeng.commonsdk.internal.utils.b bVar = (com.umeng.commonsdk.internal.utils.b) obj;
                        try {
                            jSONObject.put("le", bVar.a);
                            jSONObject.put("vol", bVar.b);
                            jSONObject.put("temp", bVar.c);
                            jSONObject.put("st", bVar.d);
                            jSONObject.put(com.anythink.expressad.d.a.b.dx, bVar.e);
                            jSONObject.put("ts", bVar.f);
                        } catch (java.lang.Throwable unused) {
                        }
                        java.lang.String jSONObject2 = jSONObject.toString();
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "battery info: " + jSONObject2);
                        com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent.class.getMethod("saveBattery", android.content.Context.class, java.lang.String.class).invoke(com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent.class, this.e, jSONObject2);
                        break;
                    }
                    break;
                case 32775:
                    com.umeng.commonsdk.internal.utils.InfoPreferenceAgent.class.getMethod("saveUA", android.content.Context.class, java.lang.String.class).invoke(com.umeng.commonsdk.internal.utils.InfoPreferenceAgent.class, this.e, (java.lang.String) obj);
                    break;
                case 32777:
                    com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent send envelope");
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    jSONObject3.put(com.umeng.analytics.pro.bo.aT, com.umeng.commonsdk.internal.a.e);
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    jSONObject4.put(com.umeng.analytics.pro.bo.aA, new org.json.JSONObject());
                    org.json.JSONObject buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.e, jSONObject3, jSONObject4);
                    if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has("exception")) {
                        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                        break;
                    }
                    break;
                case 32779:
                    com.umeng.commonsdk.vchannel.Sender.handleEvent(this.e, (com.umeng.commonsdk.vchannel.b) obj);
                    break;
                case com.umeng.commonsdk.internal.a.p /* 32781 */:
                    if (!com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(this.e, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                        a(this.e);
                        break;
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                        break;
                    }
                case com.umeng.commonsdk.internal.a.f457s /* 32784 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    f();
                    f--;
                    g();
                    com.umeng.commonsdk.utils.UMUtils.saveSDKComponent();
                    break;
                case com.umeng.commonsdk.internal.a.t /* 32785 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (!com.umeng.analytics.pro.bq.a(this.e).c()) {
                        d();
                        if (!com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.t)) {
                            android.content.Context context2 = this.e;
                            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context2).a(), null);
                            break;
                        }
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                        break;
                    }
                    break;
                case com.umeng.commonsdk.internal.a.u /* 32786 */:
                    com.umeng.commonsdk.internal.crash.UMCrashManager.buildEnvelope(this.e, obj);
                    break;
                case com.umeng.commonsdk.internal.a.v /* 32787 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    java.lang.String a2 = com.umeng.commonsdk.stateless.d.a(this.e, false);
                    java.lang.String a3 = com.umeng.commonsdk.stateless.d.a(this.e, true);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        java.io.File file = new java.io.File(a2);
                        if (file.exists() && file.isDirectory()) {
                            z2 = true;
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(a3)) {
                        java.io.File file2 = new java.io.File(a3);
                        if (file2.exists() && file2.isDirectory()) {
                            if (!z) {
                                if (!com.umeng.commonsdk.stateless.b.a()) {
                                    new com.umeng.commonsdk.stateless.b(this.e);
                                    com.umeng.commonsdk.stateless.b.b();
                                    break;
                                } else {
                                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                                    break;
                                }
                            } else {
                                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                                break;
                            }
                        }
                    }
                    z = z2;
                    if (!z) {
                    }
                    break;
                case com.umeng.commonsdk.internal.a.w /* 32788 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E) && !com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist()) {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        android.content.Context context3 = this.e;
                        com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(context3, com.umeng.analytics.pro.q.a.E, com.umeng.analytics.CoreProtocol.getInstance(context3), null, 5000L);
                    }
                    if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                        com.umeng.analytics.pro.n.a(this.e).b(this.e);
                        break;
                    }
                    break;
                case com.umeng.commonsdk.internal.a.x /* 32790 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    f--;
                    g();
                    break;
                case com.umeng.commonsdk.internal.a.y /* 32791 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    com.umeng.commonsdk.UMInnerManager.sendInnerPackage(this.e);
                    if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.at) && com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 0 && com.umeng.commonsdk.utils.UMUtils.isMainProgress(this.e)) {
                        android.content.Context context4 = this.e;
                        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context4, com.umeng.commonsdk.internal.a.G, com.umeng.commonsdk.internal.b.a(context4).a(), null, 5000L);
                    }
                    e(this.e);
                    com.umeng.commonsdk.utils.UMUtils.saveSDKComponent();
                    break;
                case com.umeng.commonsdk.internal.a.z /* 32792 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (obj instanceof java.lang.Integer) {
                        int intValue = ((java.lang.Integer) obj).intValue();
                        android.content.SharedPreferences sharedPreferences = this.e.getApplicationContext().getSharedPreferences(a, 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putInt("policyGrantResult", intValue).commit();
                            break;
                        }
                    }
                    break;
                case com.umeng.commonsdk.internal.a.A /* 32793 */:
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (obj instanceof org.json.JSONObject) {
                        org.json.JSONObject jSONObject5 = (org.json.JSONObject) obj;
                        if (jSONObject5.has(com.umeng.commonsdk.internal.a.J)) {
                            int i3 = jSONObject5.getInt(com.umeng.commonsdk.internal.a.J);
                            int i4 = jSONObject5.getInt(com.umeng.commonsdk.internal.a.K);
                            int i5 = jSONObject5.getInt("policyGrantResult");
                            android.content.SharedPreferences sharedPreferences2 = this.e.getApplicationContext().getSharedPreferences(a, 0);
                            if (sharedPreferences2 != null && (edit = sharedPreferences2.edit()) != null) {
                                edit.putInt(b, i3);
                                edit.putInt(c, i4);
                                edit.putInt("policyGrantResult", i5);
                                edit.commit();
                            }
                            java.io.File file3 = new java.io.File(this.e.getFilesDir().getAbsolutePath() + java.io.File.separator + com.umeng.analytics.pro.bs.m);
                            if (!file3.exists()) {
                                file3.createNewFile();
                                break;
                            }
                        }
                    }
                    break;
                case com.umeng.commonsdk.internal.a.B /* 32800 */:
                    java.io.File file4 = new java.io.File(this.e.getFilesDir().getAbsolutePath() + java.io.File.separator + com.umeng.analytics.pro.bs.m);
                    if (file4.exists()) {
                        file4.delete();
                        break;
                    }
                    break;
                case com.umeng.commonsdk.internal.a.C /* 32801 */:
                    com.umeng.commonsdk.debug.SelfChecker.doCheck(this.e);
                    break;
                case com.umeng.commonsdk.internal.a.E /* 32803 */:
                    android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.e.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> ConnectivityManager is null!");
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                        break;
                    } else {
                        try {
                            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo == null) {
                                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> NetworkInfo is null!");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            } else if (activeNetworkInfo.isAvailable()) {
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> network state changed: Available");
                                com.umeng.commonsdk.framework.a.a(true);
                                com.umeng.commonsdk.stateless.b.a(true);
                            } else {
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> network state changed: unAvailable");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            }
                            break;
                        } catch (java.lang.Throwable unused2) {
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                            return;
                        }
                    }
                case com.umeng.commonsdk.internal.a.F /* 32804 */:
                    d(this.e);
                    break;
                case com.umeng.commonsdk.internal.a.G /* 32805 */:
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv CLOUD_CONFIG_TRIGGER msg.");
                    com.umeng.ccg.CcgAgent.registerConfigListener(new com.umeng.commonsdk.internal.c.AnonymousClass6());
                    android.content.SharedPreferences a4 = com.umeng.analytics.pro.au.a(this.e);
                    if (a4 != null) {
                        long j2 = a4.getLong(com.umeng.analytics.pro.au.a, 0L);
                        if (j2 < Long.MAX_VALUE) {
                            j2++;
                        }
                        a4.edit().putLong(com.umeng.analytics.pro.au.a, j2).commit();
                    }
                    com.umeng.ccg.CcgAgent.init(this.e);
                    break;
            }
        } catch (java.lang.Throwable unused3) {
        }
    }
}
