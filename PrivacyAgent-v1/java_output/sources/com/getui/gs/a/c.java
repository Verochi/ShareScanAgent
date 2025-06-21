package com.getui.gs.a;

import com.getui.gs.g.g.AnonymousClass1;

/* loaded from: classes22.dex */
public final class c {
    private static com.getui.gs.sdk.IGtcIdCallback c;
    private static final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);
    private static final java.util.List<java.lang.Runnable> b = new java.util.ArrayList();
    private static final java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static volatile boolean e = true;
    private static volatile long f = 0;
    private static boolean g = false;
    private static long h = 0;

    /* renamed from: com.getui.gs.a.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        /* renamed from: com.getui.gs.a.c$1$1, reason: invalid class name and collision with other inner class name */
        public class BinderC02871 extends com.getui.gtc.api.GtcIdCallback.Stub {
            public BinderC02871() {
            }

            @Override // com.getui.gtc.api.GtcIdCallback
            public final void onFailure(java.lang.String str) throws android.os.RemoteException {
                com.getui.gs.h.a.c("gs init failed: cause gtc init onFailure: ".concat(java.lang.String.valueOf(str)));
                com.getui.gs.h.b.a.a.a.e("gs init failed: cause gtc init onFailure: ".concat(java.lang.String.valueOf(str)));
                com.getui.gs.a.c.a.set(0);
                com.getui.gs.a.c.b.clear();
            }

            @Override // com.getui.gtc.api.GtcIdCallback
            public final void onSuccess(java.lang.String str) throws android.os.RemoteException {
                com.getui.gs.a.d.a(str);
                if (com.getui.gs.a.c.c != null) {
                    com.getui.gs.a.c.c.onGetGtcId(com.getui.gs.a.d.e());
                }
            }
        }

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gs.a.d.a(com.getui.gtc.api.GtcManager.getInstance().initialize(this.a, com.getui.gtc.dim.Caller.IDO, new com.getui.gs.a.c.AnonymousClass1.BinderC02871()));
                com.getui.gs.a.d.a(this.a);
                com.getui.gs.c.a.a(com.getui.gs.a.d.a());
                com.getui.gs.a.c.i();
                com.getui.gs.a.c.a.set(2);
                com.getui.gs.ias.core.GsConfig.idoEnable(this.a, true);
                if (com.getui.gs.a.c.c != null) {
                    com.getui.gs.a.c.c.onGetGtcId(com.getui.gs.a.d.e());
                }
                com.getui.gs.h.a.a("gs init success: appid = " + com.getui.gs.a.d.d() + ", gtcId = " + com.getui.gs.a.d.e());
                if (android.text.TextUtils.isEmpty(com.getui.gs.a.d.e())) {
                    com.getui.gs.h.b.a.a.a.e(com.getui.gs.a.d.d() + " , gtcId is empty!!!!!");
                }
                com.getui.gs.a.c.j();
                com.getui.gs.a.c.b();
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("gs init failed, cause: " + th.getMessage());
                com.getui.gs.h.b.a("gs init failed", th);
                com.getui.gs.a.c.a.set(0);
                com.getui.gs.a.c.b.clear();
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$10, reason: invalid class name */
    public static class AnonymousClass10 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.g.f fVar;
            com.getui.gs.g.g gVar;
            java.lang.String str;
            fVar = com.getui.gs.g.f.a.a;
            fVar.b();
            gVar = com.getui.gs.g.g.a.a;
            android.content.Context a = com.getui.gs.a.d.a();
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 28) {
                str = "ue-queryAndUpload :  sdk version < 28";
            } else if (com.getui.gs.c.a.a("sdk.ido.type20.enable", false)) {
                android.app.usage.UsageStatsManager usageStatsManager = (android.app.usage.UsageStatsManager) a.getSystemService("usagestats");
                gVar.a = usageStatsManager;
                if (usageStatsManager != null && i >= 28) {
                    com.getui.gs.h.c.b().execute(gVar.new AnonymousClass1());
                    com.getui.gs.g.d.a();
                    com.getui.gs.a.c.l();
                }
                str = "ue-queryAndUpload : usageStatsManager is null or sdk version < 28";
            } else {
                str = "ue-queryAndUpload : type20 is disabled";
            }
            com.getui.gs.h.a.a(str);
            com.getui.gs.g.d.a();
            com.getui.gs.a.c.l();
        }
    }

    /* renamed from: com.getui.gs.a.c$11, reason: invalid class name */
    public static class AnonymousClass11 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.g.f fVar;
            com.getui.gs.g.f fVar2;
            com.getui.gs.g.f fVar3;
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (com.getui.gs.a.c.h == 0) {
                    fVar3 = com.getui.gs.g.f.a.a;
                    fVar3.a(currentTimeMillis);
                    com.getui.gs.a.c.o();
                } else if (currentTimeMillis - com.getui.gs.a.c.h <= com.getui.gs.ias.core.a.a()) {
                    com.getui.gs.h.a.a("onActivityResumed: session update");
                    fVar = com.getui.gs.g.f.a.a;
                    fVar.a(currentTimeMillis, false);
                } else {
                    com.getui.gs.h.a.a("onActivityResumed: more than " + com.getui.gs.ias.core.a.a() + " from last end time, create a new session");
                    fVar2 = com.getui.gs.g.f.a.a;
                    fVar2.b(currentTimeMillis);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.b.a.a.a.e("onActivityResumed error: " + th.getMessage());
                com.getui.gs.h.a.c("onActivityResumed error: " + th.getMessage());
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.g.f fVar;
            com.getui.gs.g.f fVar2;
            try {
                long unused = com.getui.gs.a.c.h = java.lang.System.currentTimeMillis();
                com.getui.gs.h.a.a("onActivityPaused: session update，" + com.getui.gs.a.c.h);
                fVar = com.getui.gs.g.f.a.a;
                fVar.a(com.getui.gs.a.c.h, true);
                fVar2 = com.getui.gs.g.f.a.a;
                fVar2.c(com.getui.gs.a.c.h);
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.b.a.a.a.e("onActivityPaused error: " + th.getMessage());
                com.getui.gs.h.a.c("onActivityPaused error: " + th.getMessage());
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.g.f fVar;
            try {
                fVar = com.getui.gs.g.f.a.a;
                fVar.a();
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.b.a.a.a.e("onActivityDestroyed error: " + th.getMessage());
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ long a;

        public AnonymousClass4(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.b.e eVar;
            com.getui.gs.b.e eVar2;
            try {
                boolean z = this.a == 0;
                org.json.JSONObject a = com.getui.gs.e.d.a();
                a.put("action", "bind");
                a.put(com.vivo.push.PushClientConstants.TAG_PKG_NAME, com.getui.gs.a.d.g());
                a.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME, com.getui.gs.a.d.f());
                a.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE, com.getui.gs.a.d.j());
                a.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, com.getui.gs.a.d.h());
                a.put("isFirst", z ? 1 : 0);
                java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.b).useExpiredCacheForReserve(true).build());
                java.lang.String str2 = "";
                if (str == null) {
                    str = "";
                }
                a.put("imei", str);
                java.lang.String str3 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.h).useExpiredCacheForReserve(true).build());
                if (str3 == null) {
                    str3 = "";
                }
                a.put("mac", str3);
                a.put("extended", com.getui.gs.h.d.a(com.getui.gs.a.d.a()) ? "1" : "0");
                java.lang.String str4 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.r).useExpiredCacheForReserve(true).build());
                if (str4 == null) {
                    str4 = "";
                }
                a.put("phoneBrand", str4);
                java.lang.String str5 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.e).useExpiredCacheForReserve(true).build());
                if (str5 == null) {
                    str5 = "";
                }
                a.put("imsi", str5);
                a.put("phoneModel", com.getui.gs.h.a.a.a());
                java.lang.String str6 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.p).storageCacheValidTime(0L).useExpiredCacheForReserve(true).build());
                if (str6 == null) {
                    str6 = "";
                }
                a.put("androidId", str6);
                a.put("systemVersion", com.getui.gs.h.a.a.b());
                a.put(com.heytap.mcssdk.constant.b.C, com.getui.gs.a.d.i());
                java.lang.String str7 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(com.getui.gs.h.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.b.q).storageCacheValidTime(0L).useExpiredCacheForReserve(true).build());
                if (str7 == null) {
                    str7 = "";
                }
                a.put("aid", str7);
                a.put(com.anythink.expressad.foundation.g.a.bj, "");
                a.put("oaid", com.getui.gs.h.a.a.c());
                eVar = com.getui.gs.b.e.a.a;
                java.lang.String str8 = eVar.a.c;
                if (!android.text.TextUtils.isEmpty(str8)) {
                    str2 = str8;
                }
                a.put("cid", str2);
                a.put("isForeground", com.getui.gs.h.d.a());
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.c());
                jSONObject.put("s11", com.getui.gs.h.e.a());
                a.put(com.umeng.analytics.pro.bo.aA, jSONObject);
                com.getui.gs.e.b.a(a.toString());
                eVar2 = com.getui.gs.b.e.a.a;
                eVar2.a.a(2, java.lang.System.currentTimeMillis());
                boolean unused = com.getui.gs.a.c.e = true;
                com.getui.gs.h.b.a.a.a.d("checkBind: bind success");
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$5, reason: invalid class name */
    public static class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ org.json.JSONObject b;
        final /* synthetic */ java.lang.String c = null;

        public AnonymousClass5(java.lang.String str, org.json.JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.d.b bVar;
            try {
                bVar = com.getui.gs.d.b.a.a;
                java.lang.String str = this.a;
                org.json.JSONObject jSONObject = this.b;
                java.lang.String str2 = this.c;
                com.getui.gs.d.b.a(str);
                bVar.a.put(str, com.getui.gs.d.b.a(str, com.getui.gs.d.a.EnumC0289a.TYPE_DURATION, jSONObject, str2));
                com.getui.gs.h.a.a("onBeginEvent: eventId=".concat(java.lang.String.valueOf(str)));
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("onBeginEvent failed, eventId=" + this.a + ", cause: " + th.getMessage());
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onBeginEvent failed, eventId=");
                sb.append(this.a);
                com.getui.gs.h.b.a(sb.toString(), th);
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$6, reason: invalid class name */
    public static class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ org.json.JSONObject b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass6(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.d.b bVar;
            try {
                bVar = com.getui.gs.d.b.a.a;
                java.lang.String str = this.a;
                org.json.JSONObject jSONObject = this.b;
                java.lang.String str2 = this.c;
                com.getui.gs.d.b.a(str);
                if (!bVar.a.containsKey(str)) {
                    throw new java.lang.IllegalStateException("eventId=" + str + " not begin or end already");
                }
                com.getui.gs.d.a a = com.getui.gs.d.b.a(str, com.getui.gs.d.a.EnumC0289a.TYPE_DURATION, jSONObject, str2);
                com.getui.gs.d.b.a(a);
                com.getui.gs.d.a remove = bVar.a.remove(str);
                long j = a.c;
                long j2 = remove.c;
                a.c = j2;
                a.e.put("$duration", j - j2);
                com.getui.gs.h.a.a("onEndEvent: ".concat(java.lang.String.valueOf(a)));
                bVar.a(a, true);
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("onEndEvent failed, eventId=" + this.a + ", cause: " + th.getMessage());
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onEndEvent failed, eventId=");
                sb.append(this.a);
                com.getui.gs.h.b.a(sb.toString(), th);
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$7, reason: invalid class name */
    public static class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ org.json.JSONObject b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass7(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.d.b bVar;
            try {
                bVar = com.getui.gs.d.b.a.a;
                bVar.a(this.a, this.b, this.c);
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("onEvent failed, eventId=" + this.a + ", cause: " + th.getMessage());
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onEvent failed, eventId=");
                sb.append(this.a);
                com.getui.gs.h.b.a(sb.toString(), th);
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$8, reason: invalid class name */
    public static class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass8(org.json.JSONObject jSONObject, java.lang.String str) {
            this.a = jSONObject;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.d.b bVar;
            try {
                bVar = com.getui.gs.d.b.a.a;
                bVar.a(this.a, this.b, true);
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("setProfile failed, cause: " + th.getMessage());
                com.getui.gs.h.b.a("setProfile failed", th);
            }
        }
    }

    /* renamed from: com.getui.gs.a.c$9, reason: invalid class name */
    public static class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ org.json.JSONObject b;

        public AnonymousClass9(java.lang.String str, org.json.JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.d.b bVar;
            try {
                bVar = com.getui.gs.d.b.a.a;
                java.lang.String str = this.a;
                org.json.JSONObject jSONObject = this.b;
                java.lang.String[] strArr = com.getui.gs.a.b.a.a;
                com.getui.gs.d.b.a(str);
                com.getui.gs.d.a a = com.getui.gs.d.b.a(str, com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL, jSONObject, "");
                org.json.JSONObject jSONObject2 = a.e;
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (android.text.TextUtils.isEmpty(next)) {
                        throw new java.lang.IllegalArgumentException("the property key can't be empty");
                    }
                    if (!com.getui.gs.d.b.a(next, strArr)) {
                        if (a.d != com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE && next.startsWith("$")) {
                            throw new java.lang.IllegalArgumentException("the property key can't start with $");
                        }
                        int length = next.length();
                        if (length <= 0 || length > 128) {
                            throw new java.lang.IllegalArgumentException("The length of key must be > 0 && <= 128: ".concat(next));
                        }
                        java.lang.Object obj = jSONObject2.get(next);
                        if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Number) && !(obj instanceof java.lang.Boolean) && !(obj instanceof java.util.Date)) {
                            throw new java.lang.IllegalArgumentException("the property value must be instance of String/Number/Boolean/Date");
                        }
                        if (obj instanceof java.util.Date) {
                            jSONObject2.put(next, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format((java.util.Date) obj));
                        }
                    }
                }
                a.i = new org.json.JSONObject();
                com.getui.gs.d.b.b(a);
                com.getui.gs.h.a.a("onPopupEvent: ".concat(java.lang.String.valueOf(a)));
                bVar.a(a, true);
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.a.c("onPopupEvent failed, cause: " + th.getMessage());
                com.getui.gs.h.b.a("onPopupEvent failed", th);
            }
        }
    }

    public static java.lang.String a() {
        return com.getui.gs.a.d.e();
    }

    public static void a(android.content.Context context) {
        com.getui.gs.h.a.a("gs preInit start ");
        if (com.getui.gtc.base.util.CommonUtil.isMainProcess()) {
            com.getui.gs.g.b.a(context);
        }
    }

    public static void a(com.getui.gs.sdk.IGtcIdCallback iGtcIdCallback) {
        c = iGtcIdCallback;
    }

    private static void a(java.lang.Runnable runnable) {
        int i = a.get();
        if (i == -1) {
            com.getui.gs.h.a.a("task can't be exec, sdk is closed");
        } else if (i == 1) {
            b.add(runnable);
        } else {
            if (i != 2) {
                throw new java.lang.IllegalStateException("please init gs firstly : ".concat(java.lang.String.valueOf(i)));
            }
            com.getui.gs.h.c.a().execute(runnable);
        }
    }

    public static void a(java.lang.String str, org.json.JSONObject jSONObject) {
        a(new com.getui.gs.a.c.AnonymousClass5(str, jSONObject));
    }

    public static void a(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        a(new com.getui.gs.a.c.AnonymousClass6(str, jSONObject, str2));
    }

    public static void a(org.json.JSONObject jSONObject, java.lang.String str) {
        a(new com.getui.gs.a.c.AnonymousClass8(jSONObject, str));
    }

    private static java.util.Date b(long j) {
        java.util.Date date = new java.util.Date(j);
        return new java.util.Date(date.getYear(), date.getMonth(), date.getDate());
    }

    public static void b() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        long j;
        java.lang.String concat;
        com.getui.gtc.base.log.Logger logger;
        com.getui.gs.b.e eVar5;
        com.getui.gs.b.e eVar6;
        com.getui.gs.b.e eVar7;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = d;
        boolean z = true;
        if (atomicBoolean.getAndSet(true)) {
            return;
        }
        if (!com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gs.a.d.a())) {
            com.getui.gs.h.b.a.a.a.d("bindAction upload task is waiting for network");
            atomicBoolean.set(false);
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (!e && currentTimeMillis - f < com.getui.gs.c.a.a("sdk.ido.bind.min", 60000L)) {
            atomicBoolean.set(false);
            return;
        }
        try {
            eVar = com.getui.gs.b.e.a.a;
            long longValue = eVar.a.d.get(2).longValue();
            eVar2 = com.getui.gs.b.e.a.a;
            java.lang.String str = eVar2.a.c;
            java.lang.String b2 = com.getui.gs.h.d.b(com.getui.gs.a.d.a());
            com.getui.gs.h.b.a.a.a.d("checkPushCid: cacheId(" + str + "), newId(" + b2 + ")");
            boolean z2 = (android.text.TextUtils.isEmpty(b2) || b2.equalsIgnoreCase(str)) ? false : true;
            if (z2) {
                com.getui.gs.h.b.a.a.a.d("need b: cid changed");
                eVar7 = com.getui.gs.b.e.a.a;
                com.getui.gs.b.b bVar = eVar7.a;
                if (bVar.a(1, b2.getBytes())) {
                    bVar.c = b2;
                }
            }
            eVar3 = com.getui.gs.b.e.a.a;
            java.lang.String str2 = eVar3.a.a;
            java.lang.String e2 = com.getui.gs.a.d.e();
            com.getui.gs.h.b.a.a.a.d("checkGtcId: cacheId(" + str2 + "), newId(" + e2 + ")");
            boolean z3 = (android.text.TextUtils.isEmpty(e2) || e2.equalsIgnoreCase(str2)) ? false : true;
            if (z3) {
                com.getui.gs.h.b.a.a.a.d("need b: gtc id changed");
                eVar6 = com.getui.gs.b.e.a.a;
                com.getui.gs.b.b bVar2 = eVar6.a;
                if (bVar2.a(50, e2.getBytes())) {
                    bVar2.a = e2;
                }
            }
            boolean z4 = z2 | z3;
            eVar4 = com.getui.gs.b.e.a.a;
            java.lang.String str3 = eVar4.a.b;
            java.lang.String c2 = com.getui.gs.h.a.a.c();
            com.getui.gs.h.b.a.a.a.d("checkOAId: cacheId(" + str3 + "), newId(" + c2 + ")");
            boolean z5 = (android.text.TextUtils.isEmpty(c2) || c2.equalsIgnoreCase(str3)) ? false : true;
            if (z5) {
                com.getui.gs.h.b.a.a.a.d("need b: oa id changed");
                eVar5 = com.getui.gs.b.e.a.a;
                com.getui.gs.b.b bVar3 = eVar5.a;
                if (bVar3.a(51, c2.getBytes())) {
                    bVar3.b = c2;
                }
            }
            if (z5 || z4) {
                j = currentTimeMillis;
            } else {
                long[] c3 = com.getui.gs.ias.core.a.c();
                long b3 = com.getui.gs.ias.core.a.b();
                long j2 = c3[0];
                long j3 = c3[1];
                if (longValue == 0) {
                    concat = "need b: never b";
                    logger = com.getui.gs.h.b.a.a.a;
                } else if (currentTimeMillis - longValue > b3) {
                    concat = "need b: last b has ben greater than interval, ".concat(java.lang.String.valueOf(b3));
                    logger = com.getui.gs.h.b.a.a.a;
                } else {
                    java.util.Date b4 = b(currentTimeMillis);
                    java.util.Date b5 = b(longValue);
                    long time = b4.getTime();
                    if (time != b5.getTime()) {
                        long random = ((long) ((j3 - j2) * java.lang.Math.random())) + j2;
                        long j4 = time + random;
                        if (currentTimeMillis >= j4) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("need b: trigger next day , (");
                            sb.append(j2);
                            sb.append("|");
                            sb.append(j3);
                            sb.append("|");
                            sb.append(random);
                            sb.append("|");
                            j = currentTimeMillis;
                            sb.append(j);
                            sb.append("|");
                            sb.append(j4);
                            sb.append(")");
                            com.getui.gs.h.b.a.a.a.d(sb.toString());
                            z = true;
                        }
                    }
                    j = currentTimeMillis;
                    z = false;
                }
                logger.d(concat);
                j = currentTimeMillis;
            }
            if (!z) {
                atomicBoolean.set(false);
                return;
            }
            f = j;
            com.getui.gs.h.b.a.a.a.d("checkBind: bind start");
            com.getui.gs.h.c.b().execute(new com.getui.gs.a.c.AnonymousClass4(longValue));
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a("bind failed: ", th);
            d.set(false);
        }
    }

    public static void b(android.content.Context context) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = a;
        if (atomicInteger.get() == 1 || atomicInteger.get() == 2) {
            throw new java.lang.IllegalStateException("gs init method has already been invoked");
        }
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context cannot be null");
        }
        if (!com.getui.gtc.base.util.CommonUtil.isMainProcess()) {
            throw new java.lang.IllegalStateException("gs must init at the main process");
        }
        atomicInteger.set(1);
        com.getui.gs.h.a.a("gs init start : GSIDO-1.4.6.2");
        com.getui.gs.h.c.a().execute(new com.getui.gs.a.c.AnonymousClass1(context));
    }

    public static void b(java.lang.String str, org.json.JSONObject jSONObject) {
        a(new com.getui.gs.a.c.AnonymousClass9(str, jSONObject));
    }

    public static void b(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        a(new com.getui.gs.a.c.AnonymousClass7(str, jSONObject, str2));
    }

    public static java.lang.String c(android.content.Context context) throws java.security.NoSuchAlgorithmException {
        if (android.text.TextUtils.isEmpty(com.getui.gs.a.d.e())) {
            com.getui.gs.a.d.a(com.getui.gtc.api.GtcManager.getInstance().initialize(context, null));
        }
        return com.getui.gs.a.d.e();
    }

    public static void c() {
        a(new com.getui.gs.a.c.AnonymousClass11());
    }

    public static void d() {
        a(new com.getui.gs.a.c.AnonymousClass2());
    }

    public static boolean d(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.a("close error: " + th.getMessage());
            com.getui.gs.h.b.a.a.a.e(th);
        }
        if (a.getAndSet(-1) != 2) {
            com.getui.gs.h.a.a("close failed, sdk not init.");
            return false;
        }
        com.getui.gs.g.d.b();
        com.getui.gs.ias.core.GsConfig.idoEnable(context, false);
        com.getui.gs.h.a.a("close success");
        return true;
    }

    public static void e() {
        a(new com.getui.gs.a.c.AnonymousClass3());
    }

    public static /* synthetic */ void i() {
        com.getui.gs.g.f fVar;
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        com.getui.gs.b.e eVar5;
        com.getui.gs.b.e eVar6;
        com.getui.gs.b.e eVar7;
        com.getui.gs.b.e eVar8;
        try {
            com.getui.gs.h.a.a("onSdkInit: this is a new session");
            fVar = com.getui.gs.g.f.a.a;
            com.getui.gs.g.c.a();
            eVar = com.getui.gs.b.e.a.a;
            long a2 = eVar.a.a(6);
            eVar2 = com.getui.gs.b.e.a.a;
            long a3 = eVar2.a.a(7);
            if (a2 > 0 && a3 > a2) {
                com.getui.gs.h.b.a.a.a.d("Type11 history: last session found，(" + a2 + ", " + a3 + ")");
                fVar.a(11, a2, a3);
            }
            eVar3 = com.getui.gs.b.e.a.a;
            long c2 = eVar3.a.c();
            eVar4 = com.getui.gs.b.e.a.a;
            long a4 = eVar4.a.a(5);
            if (c2 > 0 && a4 > c2) {
                long j = a4 - c2;
                com.getui.gs.h.b.a.a.a.d("Type8 history: last session found，(" + c2 + ", " + a4 + ")");
                if (j >= com.getui.gs.ias.core.GsConfig.getMinAppActiveDuration() && j <= com.getui.gs.ias.core.GsConfig.getMaxAppActiveDuration()) {
                    fVar.a(8, c2, a4);
                }
                com.getui.gs.h.b.a.a.a.d("Type8 history: the last session duration " + j + " is invalid, must be the area of " + com.getui.gs.ias.core.GsConfig.getMinAppActiveDuration() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + com.getui.gs.ias.core.GsConfig.getMaxAppActiveDuration());
            }
            com.getui.gs.g.c.b();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.getui.gs.h.b.a.a.a.d("type init : ".concat(java.lang.String.valueOf(currentTimeMillis)));
            eVar5 = com.getui.gs.b.e.a.a;
            eVar5.a.a(4, currentTimeMillis);
            eVar6 = com.getui.gs.b.e.a.a;
            eVar6.a.a(5, currentTimeMillis);
            eVar7 = com.getui.gs.b.e.a.a;
            eVar7.a.a(6, currentTimeMillis);
            eVar8 = com.getui.gs.b.e.a.a;
            eVar8.a.a(7, currentTimeMillis);
            com.getui.gs.h.b.a.a.a.d("Type11 onNewSession: new session created");
            fVar.a(11, currentTimeMillis, currentTimeMillis);
            fVar.a(currentTimeMillis);
            a(new com.getui.gs.a.c.AnonymousClass10());
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a("onSdkInit error: ", th);
            com.getui.gs.h.a.c("onSdkInit error: " + th.getMessage());
        }
    }

    public static /* synthetic */ void j() {
        java.util.List<java.lang.Runnable> list = b;
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        list.clear();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((java.lang.Runnable) it.next());
        }
    }

    public static /* synthetic */ void l() {
        com.getui.gs.d.b bVar;
        com.getui.gs.d.b bVar2;
        try {
            if (!com.getui.gs.ias.core.a.a(com.google.android.gms.common.Scopes.PROFILE)) {
                bVar2 = com.getui.gs.d.b.a.a;
                bVar2.a((org.json.JSONObject) null, (java.lang.String) null, false);
            }
            if (!com.getui.gs.ias.core.a.a("$app_start")) {
                bVar = com.getui.gs.d.b.a.a;
                bVar.a("$app_start", (org.json.JSONObject) null, (java.lang.String) null);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e("presetEvent error: " + th.getMessage());
            com.getui.gs.h.a.c("presetEvent error: " + th.getMessage());
        }
        if (com.getui.gtc.base.util.CommonUtil.isAppForeground()) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        com.getui.gs.d.b bVar;
        if (g) {
            return;
        }
        try {
            com.getui.gs.h.a.a("onForegroundEvent");
            if (!com.getui.gs.ias.core.a.a("$foreground_start")) {
                bVar = com.getui.gs.d.b.a.a;
                bVar.a("$foreground_start", (org.json.JSONObject) null, (java.lang.String) null);
            }
            g = true;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e("onForegroundEvent error: " + th.getMessage());
            com.getui.gs.h.a.c("onForegroundEvent error: " + th.getMessage());
        }
    }
}
