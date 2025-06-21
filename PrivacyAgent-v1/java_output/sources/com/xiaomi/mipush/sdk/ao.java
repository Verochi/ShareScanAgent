package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class ao {
    private static com.xiaomi.mipush.sdk.ao a;

    /* renamed from: a, reason: collision with other field name */
    private static final java.util.ArrayList<com.xiaomi.mipush.sdk.ao.a> f27a = new java.util.ArrayList<>();
    private static boolean b;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Context f28a;

    /* renamed from: a, reason: collision with other field name */
    private android.os.Handler f30a;

    /* renamed from: a, reason: collision with other field name */
    private android.os.Messenger f31a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f35a;

    /* renamed from: a, reason: collision with other field name */
    private java.util.List<android.os.Message> f34a = new java.util.ArrayList();
    private boolean c = false;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Intent f29a = null;

    /* renamed from: a, reason: collision with other field name */
    private java.lang.Integer f32a = null;

    /* renamed from: a, reason: collision with other field name */
    private java.lang.String f33a = null;

    public static class a<T extends com.xiaomi.push.hw<T, ?>> {
        com.xiaomi.push.gk a;

        /* renamed from: a, reason: collision with other field name */
        T f36a;

        /* renamed from: a, reason: collision with other field name */
        boolean f37a;
    }

    private ao(android.content.Context context) {
        this.f35a = false;
        this.f30a = null;
        this.f28a = context.getApplicationContext();
        this.f35a = m114c();
        b = m115d();
        this.f30a = new com.xiaomi.mipush.sdk.ap(this, android.os.Looper.getMainLooper());
        if (com.xiaomi.push.iu.a(context)) {
            com.xiaomi.push.service.ce.a = new com.xiaomi.mipush.sdk.aq(this);
        }
        android.content.Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f28a.getSharedPreferences("mipush_extra", 0).getInt(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a, reason: collision with other method in class */
    private android.content.Intent m109a() {
        return (!m119a() || "com.xiaomi.xmsf".equals(this.f28a.getPackageName())) ? e() : d();
    }

    private android.os.Message a(android.content.Intent intent) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized com.xiaomi.mipush.sdk.ao a(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao aoVar;
        synchronized (com.xiaomi.mipush.sdk.ao.class) {
            if (a == null) {
                a = new com.xiaomi.mipush.sdk.ao(context);
            }
            aoVar = a;
        }
        return aoVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private java.lang.String m112a() {
        try {
            return this.f28a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (java.lang.Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, com.xiaomi.mipush.sdk.au auVar, boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.hk hkVar;
        java.lang.String str2;
        if (com.xiaomi.mipush.sdk.b.m126a(this.f28a).m133b() && com.xiaomi.push.ai.a(this.f28a)) {
            com.xiaomi.push.hk hkVar2 = new com.xiaomi.push.hk();
            hkVar2.a(true);
            android.content.Intent m109a = m109a();
            if (android.text.TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.ag.a();
                hkVar2.c = str;
                hkVar = z ? new com.xiaomi.push.hk(str, true) : null;
                synchronized (com.xiaomi.mipush.sdk.af.class) {
                    com.xiaomi.mipush.sdk.af.a(this.f28a).m105a(str);
                }
            } else {
                hkVar2.c = str;
                hkVar = z ? new com.xiaomi.push.hk(str, true) : null;
            }
            switch (com.xiaomi.mipush.sdk.at.a[auVar.ordinal()]) {
                case 1:
                    java.lang.String str3 = com.xiaomi.push.gu.DisablePushMessage.ah;
                    hkVar2.e = str3;
                    hkVar.e = str3;
                    if (hashMap != null) {
                        hkVar2.h = hashMap;
                        hkVar.h = hashMap;
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m109a.setAction(str2);
                    break;
                case 2:
                    java.lang.String str4 = com.xiaomi.push.gu.EnablePushMessage.ah;
                    hkVar2.e = str4;
                    hkVar.e = str4;
                    if (hashMap != null) {
                        hkVar2.h = hashMap;
                        hkVar.h = hashMap;
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m109a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    hkVar2.e = com.xiaomi.push.gu.ThirdPartyRegUpdate.ah;
                    if (hashMap != null) {
                        hkVar2.h = hashMap;
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.f("type:" + auVar + ", " + str);
            hkVar2.d = com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a();
            hkVar2.i = this.f28a.getPackageName();
            com.xiaomi.push.gk gkVar = com.xiaomi.push.gk.Notification;
            a((com.xiaomi.mipush.sdk.ao) hkVar2, gkVar, false, (com.xiaomi.push.gx) null);
            if (z) {
                hkVar.d = com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a();
                hkVar.i = this.f28a.getPackageName();
                android.content.Context context = this.f28a;
                byte[] a2 = com.xiaomi.push.hv.a(com.xiaomi.mipush.sdk.ai.a(context, hkVar, gkVar, false, context.getPackageName(), com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a()));
                if (a2 != null) {
                    com.xiaomi.push.cc.a(this.f28a.getPackageName(), this.f28a, hkVar, gkVar, a2.length);
                    m109a.putExtra("mipush_payload", a2);
                    m109a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m109a.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a());
                    m109a.putExtra("mipush_app_token", com.xiaomi.mipush.sdk.b.m126a(this.f28a).b());
                    c(m109a);
                }
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f30a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private android.content.Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f28a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    private void b(android.content.Intent intent) {
        try {
            if (com.xiaomi.push.iu.a() || android.os.Build.VERSION.SDK_INT < 26) {
                this.f28a.startService(intent);
            } else {
                d(intent);
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private android.content.Intent c() {
        if (m119a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f28a.getSharedPreferences("mipush_extra", 0).edit().putInt(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(android.content.Intent intent) {
        com.xiaomi.push.service.ad a2 = com.xiaomi.push.service.ad.a(this.f28a);
        int i = com.xiaomi.push.gp.ServiceBootMode.bw;
        com.xiaomi.push.gl glVar = com.xiaomi.push.gl.START;
        int a3 = a2.a(i, glVar.c);
        int a4 = a();
        int i2 = com.xiaomi.push.gl.BIND.c;
        boolean z = a3 == i2 && b;
        if (!z) {
            i2 = glVar.c;
        }
        if (i2 != a4) {
            m120a(i2);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m114c() {
        try {
            android.content.pm.PackageInfo packageInfo = this.f28a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private android.content.Intent d() {
        android.content.Intent intent = new android.content.Intent();
        java.lang.String packageName = this.f28a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m112a());
        intent.putExtra("mipush_app_package", packageName);
        g();
        return intent;
    }

    private synchronized void d(android.content.Intent intent) {
        if (this.c) {
            android.os.Message a2 = a(intent);
            if (this.f34a.size() >= 50) {
                this.f34a.remove(0);
            }
            this.f34a.add(a2);
            return;
        }
        if (this.f31a == null) {
            this.f28a.bindService(intent, new com.xiaomi.mipush.sdk.as(this), 1);
            this.c = true;
            this.f34a.clear();
            this.f34a.add(a(intent));
            return;
        }
        try {
            this.f31a.send(a(intent));
        } catch (android.os.RemoteException unused) {
            this.f31a = null;
            this.c = false;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m115d() {
        if (m119a()) {
            try {
                return this.f28a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (java.lang.Exception unused) {
            }
        }
        return true;
    }

    private android.content.Intent e() {
        android.content.Intent intent = new android.content.Intent();
        java.lang.String packageName = this.f28a.getPackageName();
        h();
        intent.setComponent(new android.content.ComponentName(this.f28a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m116e() {
        java.lang.String packageName = this.f28a.getPackageName();
        return packageName.contains("miui") || packageName.contains(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || (this.f28a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        try {
            android.content.pm.PackageManager packageManager = this.f28a.getPackageManager();
            android.content.ComponentName componentName = new android.content.ComponentName(this.f28a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void h() {
        try {
            android.content.pm.PackageManager packageManager = this.f28a.getPackageManager();
            android.content.ComponentName componentName = new android.content.ComponentName(this.f28a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m117a() {
        b(m109a());
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m109a.putExtra(com.xiaomi.push.service.an.B, this.f28a.getPackageName());
        m109a.putExtra(com.xiaomi.push.service.an.C, i);
        m109a.putExtra(com.xiaomi.push.service.an.D, i2);
        c(m109a);
    }

    public void a(int i, java.lang.String str) {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.thirdparty");
        m109a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m109a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m109a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m118a(android.content.Intent intent) {
        intent.fillIn(m109a(), 24);
        c(intent);
    }

    public final void a(com.xiaomi.push.go goVar) {
        android.content.Intent m109a = m109a();
        byte[] a2 = com.xiaomi.push.hv.a(goVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m109a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m109a.putExtra("mipush_payload", a2);
        b(m109a);
    }

    public final void a(com.xiaomi.push.hl hlVar, boolean z) {
        com.xiaomi.push.dp.a(this.f28a.getApplicationContext()).a(this.f28a.getPackageName(), "E100003", hlVar.c, com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.WAITING_CONNECT, null);
        this.f29a = null;
        com.xiaomi.mipush.sdk.b.m126a(this.f28a).f42a = hlVar.c;
        android.content.Intent m109a = m109a();
        byte[] a2 = com.xiaomi.push.hv.a(com.xiaomi.mipush.sdk.ai.a(this.f28a, hlVar, com.xiaomi.push.gk.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
            return;
        }
        m109a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m109a.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a());
        m109a.putExtra("mipush_payload", a2);
        m109a.putExtra("mipush_session", this.f33a);
        m109a.putExtra("mipush_env_chanage", z);
        m109a.putExtra("mipush_env_type", com.xiaomi.mipush.sdk.b.m126a(this.f28a).a());
        if (com.xiaomi.push.ai.a(this.f28a) && m122b()) {
            c(m109a);
        } else {
            this.f29a = m109a;
        }
    }

    public final void a(com.xiaomi.push.hr hrVar) {
        byte[] a2 = com.xiaomi.push.hv.a(com.xiaomi.mipush.sdk.ai.a(this.f28a, hrVar, com.xiaomi.push.gk.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
            return;
        }
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m109a.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a());
        m109a.putExtra("mipush_payload", a2);
        c(m109a);
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, com.xiaomi.push.gx gxVar) {
        a((com.xiaomi.mipush.sdk.ao) t, gkVar, !gkVar.equals(com.xiaomi.push.gk.Registration), gxVar);
    }

    public <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z) {
        com.xiaomi.mipush.sdk.ao.a aVar = new com.xiaomi.mipush.sdk.ao.a();
        aVar.f36a = t;
        aVar.a = gkVar;
        aVar.f37a = z;
        java.util.ArrayList<com.xiaomi.mipush.sdk.ao.a> arrayList = f27a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, com.xiaomi.push.gx gxVar) {
        a(t, gkVar, z, true, gxVar, true);
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, com.xiaomi.push.gx gxVar, boolean z2) {
        a(t, gkVar, z, true, gxVar, z2);
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, boolean z2, com.xiaomi.push.gx gxVar, boolean z3) {
        a(t, gkVar, z, z2, gxVar, z3, this.f28a.getPackageName(), com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a());
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, boolean z2, com.xiaomi.push.gx gxVar, boolean z3, java.lang.String str, java.lang.String str2) {
        a(t, gkVar, z, z2, gxVar, z3, str, str2, true);
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, boolean z2, com.xiaomi.push.gx gxVar, boolean z3, java.lang.String str, java.lang.String str2, boolean z4) {
        a(t, gkVar, z, z2, gxVar, z3, str, str2, z4, true);
    }

    public final <T extends com.xiaomi.push.hw<T, ?>> void a(T t, com.xiaomi.push.gk gkVar, boolean z, boolean z2, com.xiaomi.push.gx gxVar, boolean z3, java.lang.String str, java.lang.String str2, boolean z4, boolean z5) {
        if (z5 && !com.xiaomi.mipush.sdk.b.m126a(this.f28a).m135c()) {
            if (z2) {
                a((com.xiaomi.mipush.sdk.ao) t, gkVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("drop the message before initialization.");
                return;
            }
        }
        com.xiaomi.push.hh a2 = z4 ? com.xiaomi.mipush.sdk.ai.a(this.f28a, t, gkVar, z, str, str2) : com.xiaomi.mipush.sdk.ai.b(this.f28a, t, gkVar, z, str, str2);
        if (gxVar != null) {
            a2.h = gxVar;
        }
        byte[] a3 = com.xiaomi.push.hv.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        com.xiaomi.push.cc.a(this.f28a.getPackageName(), this.f28a, t, gkVar, a3.length);
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m109a.putExtra("mipush_payload", a3);
        m109a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m109a);
    }

    public final void a(java.lang.String str, com.xiaomi.mipush.sdk.au auVar, com.xiaomi.mipush.sdk.e eVar) {
        com.xiaomi.mipush.sdk.af.a(this.f28a).a(auVar, "syncing");
        a(str, auVar, false, com.xiaomi.mipush.sdk.i.m145a(this.f28a, eVar));
    }

    public void a(java.lang.String str, java.lang.String str2) {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m109a.putExtra(com.xiaomi.push.service.an.B, this.f28a.getPackageName());
        m109a.putExtra(com.xiaomi.push.service.an.H, str);
        m109a.putExtra(com.xiaomi.push.service.an.I, str2);
        c(m109a);
    }

    public final void a(boolean z) {
        a(z, (java.lang.String) null);
    }

    public final void a(boolean z, java.lang.String str) {
        com.xiaomi.mipush.sdk.au auVar;
        com.xiaomi.mipush.sdk.af a2;
        com.xiaomi.mipush.sdk.au auVar2;
        if (z) {
            com.xiaomi.mipush.sdk.af a3 = com.xiaomi.mipush.sdk.af.a(this.f28a);
            auVar = com.xiaomi.mipush.sdk.au.DISABLE_PUSH;
            a3.a(auVar, "syncing");
            a2 = com.xiaomi.mipush.sdk.af.a(this.f28a);
            auVar2 = com.xiaomi.mipush.sdk.au.ENABLE_PUSH;
        } else {
            com.xiaomi.mipush.sdk.af a4 = com.xiaomi.mipush.sdk.af.a(this.f28a);
            auVar = com.xiaomi.mipush.sdk.au.ENABLE_PUSH;
            a4.a(auVar, "syncing");
            a2 = com.xiaomi.mipush.sdk.af.a(this.f28a);
            auVar2 = com.xiaomi.mipush.sdk.au.DISABLE_PUSH;
        }
        a2.a(auVar2, "");
        a(str, auVar, true, (java.util.HashMap<java.lang.String, java.lang.String>) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m119a() {
        return this.f35a && 1 == com.xiaomi.mipush.sdk.b.m126a(this.f28a).a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m120a(int i) {
        if (!com.xiaomi.mipush.sdk.b.m126a(this.f28a).m133b()) {
            return false;
        }
        c(i);
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.c = com.xiaomi.push.service.ag.a();
        hkVar.d = com.xiaomi.mipush.sdk.b.m126a(this.f28a).m127a();
        hkVar.i = this.f28a.getPackageName();
        hkVar.e = com.xiaomi.push.gu.ClientABTest.ah;
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        hashMap.put("boot_mode", java.lang.String.valueOf(i));
        a(this.f28a).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
        return true;
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m121b() {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m109a);
    }

    public void b(int i) {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m109a.putExtra(com.xiaomi.push.service.an.B, this.f28a.getPackageName());
        m109a.putExtra(com.xiaomi.push.service.an.E, i);
        m109a.putExtra(com.xiaomi.push.service.an.G, com.xiaomi.push.an.b(this.f28a.getPackageName() + i));
        c(m109a);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m122b() {
        if (!m119a() || !m116e()) {
            return true;
        }
        if (this.f32a == null) {
            java.lang.Integer valueOf = java.lang.Integer.valueOf(com.xiaomi.push.service.aq.a(this.f28a).a());
            this.f32a = valueOf;
            if (valueOf.intValue() == 0) {
                com.xiaomi.mipush.sdk.ar arVar = new com.xiaomi.mipush.sdk.ar(this, new android.os.Handler(android.os.Looper.getMainLooper()));
                android.content.ContentResolver contentResolver = this.f28a.getContentResolver();
                com.xiaomi.push.service.aq.a(this.f28a);
                contentResolver.registerContentObserver(android.provider.Settings.Global.getUriFor("device_provisioned"), false, arVar);
            }
        }
        return this.f32a.intValue() != 0;
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m123c() {
        android.content.Intent intent = this.f29a;
        if (intent != null) {
            c(intent);
            this.f29a = null;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m124d() {
        java.util.ArrayList<com.xiaomi.mipush.sdk.ao.a> arrayList = f27a;
        synchronized (arrayList) {
            boolean z = java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread();
            java.util.Iterator<com.xiaomi.mipush.sdk.ao.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.xiaomi.mipush.sdk.ao.a next = it.next();
                a(next.f36a, next.a, next.f37a, false, null, true);
                if (!z) {
                    try {
                        java.lang.Thread.sleep(100L);
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
            }
            f27a.clear();
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m125e() {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        android.app.Application application = (android.app.Application) com.xiaomi.push.aj.a("android.app.ActivityThread", "currentApplication", new java.lang.Object[0]);
        java.lang.String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        java.lang.String packageName2 = this.f28a.getPackageName();
        if (android.text.TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m109a.putExtra(com.xiaomi.push.service.an.B, packageName);
        c(m109a);
    }

    public void f() {
        android.content.Intent m109a = m109a();
        m109a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m109a.putExtra(com.xiaomi.push.service.an.B, this.f28a.getPackageName());
        m109a.putExtra(com.xiaomi.push.service.an.G, com.xiaomi.push.an.b(this.f28a.getPackageName()));
        c(m109a);
    }
}
