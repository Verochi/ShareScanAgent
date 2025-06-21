package com.efs.sdk.base.core.b;

/* loaded from: classes22.dex */
public class c extends android.os.Handler {
    private static final java.util.Map<java.lang.String, java.lang.Long> a = new com.efs.sdk.base.core.b.c.AnonymousClass1();
    private static final java.util.Map<java.lang.String, java.lang.Long> b = new com.efs.sdk.base.core.b.c.AnonymousClass2();
    private java.util.Map<java.lang.String, java.util.concurrent.atomic.AtomicInteger> c;
    private volatile android.content.SharedPreferences d;
    private volatile android.content.SharedPreferences.Editor e;
    private android.content.Context f;
    private java.lang.String g;

    /* renamed from: com.efs.sdk.base.core.b.c$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.Long> {
        public AnonymousClass1() {
            super(3);
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    }

    /* renamed from: com.efs.sdk.base.core.b.c$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.HashMap<java.lang.String, java.lang.Long> {
        public AnonymousClass2() {
            super(3);
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", 2097152L);
        }
    }

    public static class a {
        private static final com.efs.sdk.base.core.b.c a = new com.efs.sdk.base.core.b.c((byte) 0);
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.c = new java.util.concurrent.ConcurrentHashMap(5);
        this.f = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.g = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        java.io.File c = com.efs.sdk.base.core.util.a.c(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (c.exists()) {
            com.efs.sdk.base.core.util.FileUtil.delete(c);
        }
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private static long a(java.util.Map<java.lang.String, java.lang.String> map, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        long longValue = b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || android.text.TextUtils.isEmpty(map.get(str2))) {
            return longValue;
        }
        try {
            return java.lang.Long.parseLong(map.get(str2));
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.flow", "get max flow error", th);
            return longValue;
        }
    }

    public static com.efs.sdk.base.core.b.c a() {
        return com.efs.sdk.base.core.b.c.a.a;
    }

    private static java.util.List<java.lang.String> a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!android.text.TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }

    private void a(java.lang.String str) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        if (!this.c.containsKey(str) || this.c.get(str) == null || this.c.get(str).get() <= 10) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            fVar.a(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion, str);
            if (str.equals("flow_day")) {
                fVar2 = com.efs.sdk.base.core.d.f.a.a;
                fVar2.a(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion);
            }
            if (!this.c.containsKey(str)) {
                this.c.put(str, new java.util.concurrent.atomic.AtomicInteger());
            }
            this.c.get(str).incrementAndGet();
        }
    }

    private boolean a(@androidx.annotation.NonNull java.lang.String str, long j, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, long j2) {
        b();
        if (this.d == null) {
            com.efs.sdk.base.core.util.Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        java.util.List<java.lang.String> a2 = a(str, str2, str3);
        java.util.Map<java.lang.String, java.lang.String> c = com.efs.sdk.base.core.config.remote.b.a().c();
        for (java.lang.String str4 : a2) {
            if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.d.getLong("curr_time_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis())) > j) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                obtain.arg1 = java.lang.Long.valueOf(j).intValue();
                sendMessage(obtain);
            }
            long a3 = a(c, str, str4);
            long j3 = this.d.getLong(str4, 0L);
            if (j3 + j2 > a3) {
                com.efs.sdk.base.core.util.Log.i("efs.flow", "flow limit, key: " + str4 + ", max: " + a3 + ", now: " + j3 + ", size: " + j2);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void b() {
        try {
            c();
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.d == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.d == null) {
                    this.d = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.getSharedPreferences(this.f, this.g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.e == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.e == null) {
                    this.e = this.d.edit();
                }
            }
        }
    }

    public final boolean a(@androidx.annotation.NonNull java.lang.String str, long j) {
        java.lang.String netStatus = com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getNetStatus();
        boolean z = true;
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : a.entrySet()) {
            z = a(entry.getKey(), entry.getValue().longValue(), str, netStatus, j);
            if (!z) {
                break;
            }
        }
        return z;
    }

    @Override // android.os.Handler
    public void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 0) {
            b();
            if (this.d == null) {
                com.efs.sdk.base.core.util.Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
                return;
            }
            if (this.e == null) {
                com.efs.sdk.base.core.util.Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
                return;
            }
            java.lang.String valueOf = java.lang.String.valueOf(message.obj);
            long j = message.arg1;
            java.lang.String netStatus = com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getNetStatus();
            for (java.lang.String str : a.keySet()) {
                java.lang.String concat = "curr_time_".concat(java.lang.String.valueOf(str));
                if (!this.d.contains(concat)) {
                    this.e.putLong(concat, java.lang.System.currentTimeMillis());
                }
                for (java.lang.String str2 : a(str, valueOf, netStatus)) {
                    this.e.putLong(str2, this.d.getLong(str2, 0L) + j);
                }
            }
            this.e.apply();
            return;
        }
        if (i != 1) {
            com.efs.sdk.base.core.util.Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
            return;
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(message.obj);
        long j2 = message.arg1;
        b();
        if (this.d == null) {
            com.efs.sdk.base.core.util.Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            return;
        }
        if (this.e == null) {
            com.efs.sdk.base.core.util.Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            return;
        }
        java.lang.String concat2 = "curr_time_".concat(valueOf2);
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.d.getLong(concat2, java.lang.System.currentTimeMillis())) >= j2) {
            for (java.lang.String str3 : this.d.getAll().keySet()) {
                if (str3.startsWith(valueOf2)) {
                    this.e.putLong(str3, 0L);
                }
            }
            this.e.putLong(concat2, java.lang.System.currentTimeMillis());
            this.e.apply();
            this.c.clear();
        }
    }
}
