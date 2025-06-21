package com.efs.sdk.base.core.config.remote;

/* loaded from: classes22.dex */
public final class b implements android.os.Handler.Callback {
    public static final java.util.Random a = new java.util.Random();
    public com.efs.sdk.base.IConfigRefreshAction b;
    public boolean c;
    public com.efs.sdk.base.core.config.remote.RemoteConfig d;
    public java.util.Map<com.efs.sdk.base.observer.IConfigCallback, java.lang.String[]> e;
    public java.util.Map<com.efs.sdk.base.observer.IConfigCallback, java.lang.String[]> f;
    private android.os.Handler g;
    private com.efs.sdk.base.core.config.remote.d h;
    private long i;
    private boolean j;
    private int k;

    /* renamed from: com.efs.sdk.base.core.config.remote.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public final void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            try {
                int parseInt = java.lang.Integer.parseInt(str2);
                if (com.efs.sdk.base.core.config.remote.b.this.k == parseInt) {
                    com.efs.sdk.base.core.util.Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is equals to mCverFromCommonListener");
                    return;
                }
                com.efs.sdk.base.core.config.remote.b.this.k = parseInt;
                com.efs.sdk.base.core.util.Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is " + parseInt + " and mRemoteConfig.getConfigVersion() is " + com.efs.sdk.base.core.config.remote.b.this.d.mConfigVersion);
                if (parseInt > com.efs.sdk.base.core.config.remote.b.this.d.mConfigVersion) {
                    com.efs.sdk.base.core.config.remote.b.this.g.sendEmptyMessage(4);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.efs.sdk.base.core.config.remote.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                for (com.efs.sdk.base.observer.IConfigCallback iConfigCallback : com.efs.sdk.base.core.config.remote.b.this.e.keySet()) {
                    java.lang.String[] strArr = (java.lang.String[]) com.efs.sdk.base.core.config.remote.b.this.e.get(iConfigCallback);
                    java.util.HashMap hashMap = new java.util.HashMap();
                    if (strArr != null && strArr.length != 0) {
                        for (java.lang.String str : strArr) {
                            if (com.efs.sdk.base.core.config.remote.b.this.d.mSDKConfigMap.containsKey(str)) {
                                hashMap.put(str, com.efs.sdk.base.core.config.remote.b.this.c().get(str));
                                com.efs.sdk.base.core.util.Log.i("efs.config.register", "configCallback key is " + str + " ## value is " + com.efs.sdk.base.core.config.remote.b.this.c().get(str));
                            }
                        }
                    }
                    iConfigCallback.onChange(hashMap);
                }
                com.efs.sdk.base.core.config.remote.b.this.e.clear();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.efs.sdk.base.core.config.remote.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                for (com.efs.sdk.base.observer.IConfigCallback iConfigCallback : com.efs.sdk.base.core.config.remote.b.this.f.keySet()) {
                    java.lang.String[] strArr = (java.lang.String[]) com.efs.sdk.base.core.config.remote.b.this.f.get(iConfigCallback);
                    java.util.HashMap hashMap = new java.util.HashMap();
                    if (strArr != null && strArr.length != 0) {
                        for (java.lang.String str : strArr) {
                            if (com.efs.sdk.base.core.config.remote.b.this.d.mSDKConfigMap.containsKey(str)) {
                                hashMap.put(str, com.efs.sdk.base.core.config.remote.b.this.c().get(str));
                                com.efs.sdk.base.core.util.Log.i("efs.config.register", "[from server] configCallback key is " + str + " ## value is " + com.efs.sdk.base.core.config.remote.b.this.c().get(str));
                            }
                        }
                    }
                    iConfigCallback.onChange(hashMap);
                }
                com.efs.sdk.base.core.config.remote.b.this.f.clear();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        private static final com.efs.sdk.base.core.config.remote.b a = new com.efs.sdk.base.core.config.remote.b((byte) 0);
    }

    private b() {
        this.c = true;
        this.e = new java.util.HashMap();
        this.f = new java.util.HashMap();
        this.j = false;
        this.k = -1;
        this.g = new android.os.Handler(com.efs.sdk.base.core.util.concurrent.a.a.getLooper(), this);
        this.h = new com.efs.sdk.base.core.config.remote.d();
        this.d = com.efs.sdk.base.core.config.remote.RemoteConfig.a();
        this.i = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
        this.j = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isOpenCodeLog();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.config.remote.b a() {
        return com.efs.sdk.base.core.config.remote.b.a.a;
    }

    private boolean a(com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig) {
        if (this.j) {
            return false;
        }
        if (this.d.mConfigVersion >= remoteConfig.mConfigVersion) {
            return true;
        }
        com.efs.sdk.base.core.util.Log.i("efs.config", "current config version (" + this.d.mConfigVersion + ") is older than another (" + remoteConfig.mConfigVersion + ")");
        return false;
    }

    private void e() {
        com.efs.sdk.base.core.b.h hVar;
        hVar = com.efs.sdk.base.core.b.h.a.a;
        if (!hVar.a()) {
            com.efs.sdk.base.core.util.Log.i("efs.config", "has no permission to refresh config from remote");
            return;
        }
        if (!this.c) {
            com.efs.sdk.base.core.util.Log.i("efs.config", "disable refresh config from remote");
            return;
        }
        java.lang.String refresh = g().refresh();
        com.efs.sdk.base.core.util.Log.i("efs.config", "from server. efs config is ".concat(java.lang.String.valueOf(refresh)));
        if (android.text.TextUtils.isEmpty(refresh)) {
            com.efs.sdk.base.core.util.Log.e("efs.config", "config is empty");
        } else {
            a(refresh);
        }
    }

    private void f() {
        boolean z;
        try {
            z = this.h.a(this.d);
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        if (z) {
            return;
        }
        this.g.sendEmptyMessageDelayed(3, 3000L);
    }

    @androidx.annotation.NonNull
    private com.efs.sdk.base.IConfigRefreshAction g() {
        com.efs.sdk.base.IConfigRefreshAction iConfigRefreshAction = this.b;
        return iConfigRefreshAction == null ? com.efs.sdk.base.core.config.remote.a.a() : iConfigRefreshAction;
    }

    private boolean h() {
        com.efs.sdk.base.core.config.remote.d.b();
        long j = 0;
        try {
            com.efs.sdk.base.core.config.remote.d dVar = this.h;
            dVar.c();
            if (dVar.a != null) {
                j = dVar.a.getLong("last_refresh_time", 0L);
            }
        } catch (java.lang.Throwable unused) {
        }
        boolean z = java.lang.System.currentTimeMillis() - j >= (this.d.d * 60) * 1000;
        com.efs.sdk.base.core.util.Log.i("efs.config", "isUpdate ".concat(java.lang.String.valueOf(z)));
        return z;
    }

    private void i() {
        try {
            for (android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>> valueCallback : com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                android.os.Message obtain = android.os.Message.obtain(null, 1, new org.json.JSONObject(this.d.mSDKConfigMap).toString());
                android.os.Message obtain2 = android.os.Message.obtain();
                valueCallback.onReceiveValue(new android.util.Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            java.util.Iterator<com.efs.sdk.base.observer.IEfsReporterObserver> it = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers().iterator();
            while (it.hasNext()) {
                it.next().onConfigChange();
            }
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.config", th);
        }
    }

    private void j() {
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.efs.sdk.base.core.config.remote.b.AnonymousClass3());
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.d.mSDKConfigMap.containsKey(str) ? this.d.mSDKConfigMap.get(str) : str2;
        return android.text.TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final java.lang.String a(boolean z) {
        if (z) {
            return "https://" + this.d.c;
        }
        return this.d.b + this.d.c;
    }

    public final void a(int i) {
        if (i <= this.d.mConfigVersion) {
            com.efs.sdk.base.core.util.Log.i("efs.config", "current config version is " + i + ", no need to refresh");
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.arg1 = i;
        obtain.what = 1;
        this.g.sendMessage(obtain);
    }

    public final void a(java.lang.String str) {
        com.efs.sdk.base.core.config.remote.RemoteConfig a2 = com.efs.sdk.base.core.config.remote.RemoteConfig.a();
        if (!com.efs.sdk.base.core.config.remote.c.a(str, a2)) {
            this.g.sendEmptyMessageDelayed(1, 3000L);
            return;
        }
        if (a(a2)) {
            return;
        }
        this.d = a2;
        f();
        i();
        d();
        j();
    }

    public final void b() {
        this.g.sendEmptyMessage(0);
        this.g.sendEmptyMessageDelayed(2, this.i);
    }

    public final java.util.Map<java.lang.String, java.lang.String> c() {
        return new java.util.HashMap(this.d.mSDKConfigMap);
    }

    public final void d() {
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.efs.sdk.base.core.config.remote.b.AnonymousClass2());
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig;
        com.efs.sdk.base.core.b.h hVar;
        int i = message.what;
        if (i == 0) {
            boolean a2 = com.efs.sdk.base.core.config.remote.d.a();
            com.efs.sdk.base.core.util.Log.i("efs.config", "delete old config is ".concat(java.lang.String.valueOf(a2)));
            if (a2) {
                this.g.sendEmptyMessage(1);
            } else {
                com.efs.sdk.base.core.config.remote.d dVar = this.h;
                dVar.c();
                if (dVar.a == null) {
                    remoteConfig = null;
                } else {
                    com.efs.sdk.base.core.config.remote.RemoteConfig a3 = com.efs.sdk.base.core.config.remote.RemoteConfig.a();
                    a3.mConfigVersion = dVar.a.getInt("cver", -1);
                    java.util.Set<java.lang.String> keySet = dVar.a.getAll().keySet();
                    java.util.HashMap hashMap = new java.util.HashMap();
                    for (java.lang.String str : keySet) {
                        java.lang.String string = dVar.a.getString(str, "");
                        if (!android.text.TextUtils.isEmpty(string)) {
                            hashMap.put(str, string);
                        }
                    }
                    a3.a(hashMap);
                    a3.a(dVar.a.getString("sign", ""));
                    remoteConfig = a3;
                }
                if (remoteConfig == null) {
                    com.efs.sdk.base.core.util.Log.i("efs.config", "first load local config false.");
                } else if (a(remoteConfig)) {
                    com.efs.sdk.base.core.util.Log.i("efs.config", "current config to same.");
                } else {
                    this.d = remoteConfig;
                    java.lang.String str2 = "load config from storage";
                    if (-1 != remoteConfig.mConfigVersion) {
                        i();
                        com.efs.sdk.base.core.util.Log.i("efs.config.register", "call back");
                        d();
                        j();
                        str2 = "load config from storage and notify observer";
                    }
                    com.efs.sdk.base.core.util.Log.i("efs.config", str2);
                }
            }
        } else if (i == 1) {
            int i2 = message.arg1;
            if (i2 <= this.d.mConfigVersion) {
                com.efs.sdk.base.core.util.Log.i("efs.config", "current config version is " + i2 + ", no need to refresh");
                com.efs.sdk.base.core.util.Log.i("efs.config", "current config version(" + this.d.mConfigVersion + ") is " + i2 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i == 2) {
            try {
                hVar = com.efs.sdk.base.core.b.h.a.a;
                if (hVar.a()) {
                    if (h()) {
                        com.efs.sdk.base.core.util.Log.i("efs.config", "update config");
                        e();
                    } else {
                        com.efs.sdk.base.core.util.Log.i("efs.config", "No update is required, less than 8h since the last update");
                        try {
                            int parseInt = java.lang.Integer.parseInt(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, "apm_setting_cver", "-1"));
                            com.efs.sdk.base.core.util.Log.d("efs.config", "APM_CVER_FROM_COMMON from UMEnvelopeBuild.imprintProperty is " + parseInt + " and mRemoteConfig.getConfigVersion() is " + this.d.mConfigVersion);
                            if (parseInt > this.d.mConfigVersion) {
                                this.g.sendEmptyMessage(4);
                            }
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext).registImprintCallback("apm_setting_cver", new com.efs.sdk.base.core.config.remote.b.AnonymousClass1());
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        } else if (i == 3) {
            f();
        } else if (i == 4) {
            e();
        }
        return true;
    }
}
