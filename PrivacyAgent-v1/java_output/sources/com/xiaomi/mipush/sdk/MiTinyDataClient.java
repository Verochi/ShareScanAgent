package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MiTinyDataClient {
    public static final java.lang.String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final java.lang.String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final java.lang.String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {
        private static volatile com.xiaomi.mipush.sdk.MiTinyDataClient.a a;

        /* renamed from: a, reason: collision with other field name */
        private android.content.Context f8a;

        /* renamed from: a, reason: collision with other field name */
        private java.lang.Boolean f10a;

        /* renamed from: a, reason: collision with other field name */
        private java.lang.String f11a;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a f9a = new com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a();

        /* renamed from: a, reason: collision with other field name */
        private final java.util.ArrayList<com.xiaomi.push.go> f12a = new java.util.ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a, reason: collision with other inner class name */
        public class C0532a {

            /* renamed from: a, reason: collision with other field name */
            private java.util.concurrent.ScheduledFuture<?> f15a;

            /* renamed from: a, reason: collision with other field name */
            private java.util.concurrent.ScheduledThreadPoolExecutor f16a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);

            /* renamed from: a, reason: collision with other field name */
            public final java.util.ArrayList<com.xiaomi.push.go> f14a = new java.util.ArrayList<>();

            /* renamed from: a, reason: collision with other field name */
            private final java.lang.Runnable f13a = new com.xiaomi.mipush.sdk.ab(this);

            public C0532a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f15a == null) {
                    this.f15a = this.f16a.scheduleAtFixedRate(this.f13a, 1000L, 1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                com.xiaomi.push.go remove = this.f14a.remove(0);
                for (com.xiaomi.push.hk hkVar : com.xiaomi.push.service.bc.a((java.util.List<com.xiaomi.push.go>) java.util.Arrays.asList(remove), com.xiaomi.mipush.sdk.MiTinyDataClient.a.this.f8a.getPackageName(), com.xiaomi.mipush.sdk.b.m126a(com.xiaomi.mipush.sdk.MiTinyDataClient.a.this.f8a).m127a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.i);
                    com.xiaomi.mipush.sdk.ao.a(com.xiaomi.mipush.sdk.MiTinyDataClient.a.this.f8a).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, true, (com.xiaomi.push.gx) null);
                }
            }

            public void a(com.xiaomi.push.go goVar) {
                this.f16a.execute(new com.xiaomi.mipush.sdk.aa(this, goVar));
            }
        }

        public static com.xiaomi.mipush.sdk.MiTinyDataClient.a a() {
            if (a == null) {
                synchronized (com.xiaomi.mipush.sdk.MiTinyDataClient.a.class) {
                    if (a == null) {
                        a = new com.xiaomi.mipush.sdk.MiTinyDataClient.a();
                    }
                }
            }
            return a;
        }

        private void a(com.xiaomi.push.go goVar) {
            synchronized (this.f12a) {
                if (!this.f12a.contains(goVar)) {
                    this.f12a.add(goVar);
                    if (this.f12a.size() > 100) {
                        this.f12a.remove(0);
                    }
                }
            }
        }

        private boolean a(android.content.Context context) {
            if (!com.xiaomi.mipush.sdk.ao.a(context).m119a()) {
                return true;
            }
            try {
                android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }

        private boolean b(android.content.Context context) {
            return com.xiaomi.mipush.sdk.b.m126a(context).m127a() == null && !a(this.f8a);
        }

        private boolean b(com.xiaomi.push.go goVar) {
            if (com.xiaomi.push.service.bc.a(goVar, false)) {
                return false;
            }
            if (!this.f10a.booleanValue()) {
                this.f9a.a(goVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + goVar.i);
            com.xiaomi.mipush.sdk.ao.a(this.f8a).a(goVar);
            return true;
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m99a(android.content.Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f8a = context;
            this.f10a = java.lang.Boolean.valueOf(a(context));
            b(com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f11a = str;
                b(com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m100a() {
            return this.f8a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
        
            r0 = "MiTinyDataClient Pending " + r6.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel";
         */
        /* renamed from: a, reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m101a(com.xiaomi.push.go goVar) {
            java.lang.String str;
            if (goVar == null) {
                return false;
            }
            if (com.xiaomi.push.service.bc.a(goVar, true)) {
                return false;
            }
            boolean z = android.text.TextUtils.isEmpty(goVar.a) && android.text.TextUtils.isEmpty(this.f11a);
            boolean z2 = !m100a();
            android.content.Context context = this.f8a;
            boolean z3 = context == null || b(context);
            if (!z2 && !z && !z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + goVar.i);
                if (android.text.TextUtils.isEmpty(goVar.i)) {
                    goVar.i = com.xiaomi.push.service.ag.a();
                }
                if (android.text.TextUtils.isEmpty(goVar.a)) {
                    goVar.a = this.f11a;
                }
                if (android.text.TextUtils.isEmpty(goVar.h)) {
                    goVar.h = this.f8a.getPackageName();
                }
                if (goVar.e <= 0) {
                    goVar.b(java.lang.System.currentTimeMillis());
                }
                return b(goVar);
            }
            if (!z2) {
                if (z3) {
                    str = "MiTinyDataClient Pending " + goVar.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId";
                }
                a(goVar);
                return true;
            }
            str = "MiTinyDataClient Pending " + goVar.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.init";
            com.xiaomi.channel.commonutils.logger.b.c(str);
            a(goVar);
            return true;
        }

        public void b(java.lang.String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            synchronized (this.f12a) {
                arrayList.addAll(this.f12a);
                this.f12a.clear();
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m101a((com.xiaomi.push.go) it.next());
            }
        }
    }

    public static void init(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().m99a(context);
        if (android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().a(str);
        }
    }

    public static boolean upload(android.content.Context context, com.xiaomi.push.go goVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + goVar.i);
        if (!com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().m100a()) {
            com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().m99a(context);
        }
        return com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().m101a(goVar);
    }

    public static boolean upload(android.content.Context context, java.lang.String str, java.lang.String str2, long j, java.lang.String str3) {
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = str;
        goVar.c = str2;
        goVar.a(j);
        goVar.b = str3;
        goVar.a(true);
        goVar.a = "push_sdk_channel";
        return upload(context, goVar);
    }

    public static boolean upload(java.lang.String str, java.lang.String str2, long j, java.lang.String str3) {
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = str;
        goVar.c = str2;
        goVar.a(j);
        goVar.b = str3;
        return com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().m101a(goVar);
    }
}
