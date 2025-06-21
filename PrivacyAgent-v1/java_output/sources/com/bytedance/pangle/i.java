package com.bytedance.pangle;

/* loaded from: classes12.dex */
public class i {
    private static volatile com.bytedance.pangle.i d;
    boolean a;
    public final java.util.List<com.bytedance.pangle.ZeusPluginStateListener> b = new java.util.concurrent.CopyOnWriteArrayList();
    final java.util.List<com.bytedance.pangle.ZeusPluginEventCallback> c = new java.util.ArrayList();
    private final android.os.Handler e = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.i$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.util.j.b();
        }
    }

    /* renamed from: com.bytedance.pangle.i$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.pangle.c.a {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.c.a
        public final void a(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3) {
            java.lang.String str2;
            if (jSONObject == null) {
                jSONObject = new org.json.JSONObject();
            }
            if (jSONObject2 == null) {
                jSONObject2 = new org.json.JSONObject();
            }
            if (jSONObject3 == null) {
                jSONObject3 = new org.json.JSONObject();
            }
            if (com.bytedance.pangle.Zeus.getAppApplication() != null) {
                com.bytedance.pangle.Zeus.getAppApplication();
                str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
            } else {
                str2 = null;
            }
            java.lang.String packageName = com.bytedance.pangle.Zeus.getAppApplication() != null ? com.bytedance.pangle.Zeus.getAppApplication().getPackageName() : "";
            if (str2 == null) {
                str2 = "unknown";
            }
            try {
                jSONObject.putOpt(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                jSONObject.putOpt("host_package_name", packageName);
                com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.22-pangle"));
                com.bytedance.pangle.log.ZeusLogger.v(com.bytedance.pangle.log.ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                com.bytedance.pangle.log.IZeusReporter reporter = com.bytedance.pangle.GlobalParam.getInstance().getReporter();
                if (reporter != null) {
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        jSONObject4.putOpt(next, jSONObject.opt(next));
                    }
                    java.util.Iterator<java.lang.String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        java.lang.String next2 = keys2.next();
                        jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                    }
                    java.util.Iterator<java.lang.String> keys3 = jSONObject3.keys();
                    while (keys3.hasNext()) {
                        java.lang.String next3 = keys3.next();
                        jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                    }
                    reporter.report(str, jSONObject4);
                }
                com.bytedance.pangle.apm.ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            } catch (org.json.JSONException e) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_REPORTER, e.getMessage(), e);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.i$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(java.lang.Class.forName("com.android.server.SystemConfig"), "getInstance", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(java.lang.String.valueOf(th)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.i$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ int e;
        final /* synthetic */ java.lang.Throwable f;

        public AnonymousClass4(java.lang.Object obj, int i, int i2, java.lang.String str, int i3, java.lang.Throwable th) {
            this.a = obj;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = i3;
            this.f = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ((com.bytedance.pangle.ZeusPluginEventCallback) this.a).onPluginEvent(this.b, this.c, this.d, this.e, this.f);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static com.bytedance.pangle.i a() {
        if (d == null) {
            synchronized (com.bytedance.pangle.i.class) {
                if (d == null) {
                    d = new com.bytedance.pangle.i();
                }
            }
        }
        return d;
    }

    private static void b() {
        android.content.pm.ProviderInfo[] providerInfoArr;
        java.lang.String str;
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, com.anythink.expressad.foundation.d.c.bT);
        try {
            android.content.pm.PackageInfo packageInfo = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageInfo(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (android.content.pm.ProviderInfo providerInfo : providerInfoArr) {
                    if (!android.text.TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(com.bytedance.pangle.Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!android.text.TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                str = providerInfo.processName.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
                                if (com.bytedance.pangle.Zeus.getServerManagerHashMap().get(str) != null || !android.text.TextUtils.equals(str, "main") || !android.text.TextUtils.equals(providerInfo.name, com.bytedance.pangle.servermanager.MainServerManager.class.getName())) {
                                    com.bytedance.pangle.Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (com.bytedance.pangle.Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            com.bytedance.pangle.Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(java.lang.String.valueOf(packageInfo)));
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(java.lang.String.valueOf(e)));
            throw new java.lang.RuntimeException(e);
        }
    }

    private java.lang.Object[] c() {
        java.lang.Object[] array;
        synchronized (this.c) {
            array = !this.c.isEmpty() ? this.c.toArray() : null;
        }
        return array == null ? new java.lang.Object[0] : array;
    }

    public final void a(int i, int i2, @androidx.annotation.Nullable java.lang.String str, int i3, @androidx.annotation.Nullable java.lang.Throwable th) {
        for (java.lang.Object obj : c()) {
            this.e.post(new com.bytedance.pangle.i.AnonymousClass4(obj, i, i2, str, i3, th));
        }
    }

    public final synchronized void a(android.app.Application application, boolean z) {
        if (this.a) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        com.bytedance.pangle.Zeus.setAppContext(application);
        com.bytedance.pangle.GlobalParam globalParam = com.bytedance.pangle.GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_ERROR, com.anythink.expressad.foundation.g.b.b.a);
            throw new java.lang.IllegalArgumentException("context must be not null !!!");
        }
        com.bytedance.pangle.log.ZeusLogger.setDebug(globalParam.isDebug());
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.bytedance.pangle.d.e.a(new com.bytedance.pangle.i.AnonymousClass1());
        if (com.bytedance.pangle.GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.bytedance.pangle.e.f.a();
        }
        if (z) {
            com.bytedance.pangle.Zeus.onPrivacyAgreed();
        }
        com.bytedance.pangle.c.b a = com.bytedance.pangle.c.b.a();
        com.bytedance.pangle.i.AnonymousClass2 anonymousClass2 = new com.bytedance.pangle.i.AnonymousClass2();
        synchronized (a.a) {
            a.a.add(anonymousClass2);
        }
        if (!globalParam.isCloseFlipped()) {
            com.bytedance.pangle.b.a();
        }
        if (android.os.Build.VERSION.SDK_INT == 29) {
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.i.AnonymousClass3());
        }
        if (com.bytedance.pangle.util.i.j()) {
            try {
                com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
                com.bytedance.pangle.util.FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", java.lang.Boolean.TRUE);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
            } catch (java.lang.Exception e) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
            }
        }
        b();
        com.bytedance.pangle.provider.ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            com.bytedance.pangle.Zeus.hookHuaWeiVerifier(application);
        }
        this.a = true;
        a(com.bytedance.pangle.ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
    }
}
