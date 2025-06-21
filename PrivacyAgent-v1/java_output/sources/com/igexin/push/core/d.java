package com.igexin.push.core;

import com.igexin.push.config.a.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass27;
import com.igexin.push.core.e.f.AnonymousClass28;

/* loaded from: classes31.dex */
public final class d implements com.igexin.c.a.d.a.c {
    private static final java.lang.String j = "CoreLogic";
    android.content.Context a;
    android.os.Handler b;
    final java.util.concurrent.ConcurrentLinkedQueue<android.os.Message> c;
    com.igexin.push.core.a.b d;
    public android.os.Handler e;
    final com.igexin.c.a.b.e f;
    public com.igexin.c.a.b.d g;
    public final com.igexin.push.e.a h;
    public final com.igexin.push.b.b i;
    private final com.igexin.push.core.f k;
    private final java.util.concurrent.atomic.AtomicBoolean l;

    /* renamed from: com.igexin.push.core.d$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 extends com.igexin.c.a.b.a.a.a {
        public AnonymousClass1() {
            super(com.igexin.c.a.b.c.f, null);
        }

        @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
        public final void b_() throws java.lang.Exception {
            super.b_();
            int myPid = android.os.Process.myPid();
            com.igexin.push.core.l a = com.igexin.push.core.l.a();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10008);
            bundle.putInt("pid", myPid);
            a.a(bundle);
            com.igexin.push.core.l a2 = com.igexin.push.core.l.a();
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putInt("action", com.igexin.sdk.PushConsts.ACTION_NOTIFICATION_ENABLE);
            a2.a(bundle2);
            java.lang.String str = com.igexin.push.core.e.a;
            com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
            try {
                com.igexin.assist.sdk.AssistPushManager.getInstance().initialize(com.igexin.push.core.e.l);
                com.igexin.assist.sdk.AssistPushManager.getInstance().register(com.igexin.push.core.e.l);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(com.igexin.push.core.d.j, "|init|failed|");
            }
        }

        @Override // com.igexin.c.a.d.a.e
        public final int c() {
            return 0;
        }

        @Override // com.igexin.c.a.b.a.a.a
        public final void c_() {
        }
    }

    /* loaded from: classes23.dex */
    public static class a {
        private static final com.igexin.push.core.d a = new com.igexin.push.core.d((byte) 0);

        private a() {
        }
    }

    private d() {
        this.c = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.l = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.k = new com.igexin.push.core.f();
        com.igexin.c.a.b.e a2 = com.igexin.c.a.b.e.a();
        this.f = a2;
        a2.g = new com.igexin.push.d.a(this.a);
        a2.a((com.igexin.c.a.d.a.c) this);
        this.h = new com.igexin.push.e.a();
        this.i = new com.igexin.push.b.b(com.igexin.push.core.ServiceManager.b);
        this.g = com.igexin.push.d.a.c.a();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static boolean a(com.igexin.push.g.b.f fVar) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVar, false, true);
    }

    public static boolean a(boolean z) {
        com.igexin.c.a.c.a.a("CoreLogic|start sdkSwitch isSlave = ".concat(java.lang.String.valueOf(z)), new java.lang.Object[0]);
        if (com.igexin.push.core.e.l == null) {
            return false;
        }
        if (!com.igexin.push.core.d.d.a().b("i")) {
            com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
            java.lang.Boolean bool = java.lang.Boolean.TRUE;
            a2.a("i", bool);
            com.igexin.push.core.d.d.a().a("p", bool);
            com.igexin.push.core.e.f388s = true;
        }
        if (z) {
            com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.TRUE);
            com.igexin.push.core.e.f388s = true;
        }
        com.igexin.push.core.d.a.a.h.a();
        return true;
    }

    public static boolean c() {
        com.igexin.c.a.c.a.a("CoreLogic|ext init ###", new java.lang.Object[0]);
        android.os.Process.myPid();
        android.util.DisplayMetrics displayMetrics = com.igexin.push.core.e.l.getResources().getDisplayMetrics();
        com.igexin.push.core.e.j = java.lang.Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        com.igexin.push.core.e.k = java.lang.Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
        try {
            if (android.os.Build.VERSION.SDK_INT < 30) {
                com.igexin.push.h.j.j();
            }
        } catch (java.lang.Throwable unused) {
        }
        if (com.igexin.push.core.e.aC == null) {
            com.igexin.push.core.e.aC = com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName() + java.lang.System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass1(com.igexin.push.core.e.aC), false, true);
        }
        return true;
    }

    public static java.lang.String h() {
        android.net.NetworkInfo activeNetworkInfo;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return null;
    }

    private android.os.Handler i() {
        return this.e;
    }

    private static com.igexin.push.core.d j() {
        return com.igexin.push.core.d.a.a;
    }

    private com.igexin.c.a.b.d k() {
        return this.g;
    }

    private com.igexin.push.e.a l() {
        return this.h;
    }

    private com.igexin.push.b.b m() {
        return this.i;
    }

    private void n() {
        android.os.Handler handler;
        try {
            com.igexin.push.core.e.a(this.a);
            com.igexin.push.config.b.a();
            com.igexin.push.config.b.b();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction(com.igexin.push.core.b.K);
            intentFilter.addAction(com.igexin.push.core.b.M);
            intentFilter.addAction("com.igexin.action.notification.click");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            int i = android.os.Build.VERSION.SDK_INT;
            if (i > 33) {
                this.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null, 4);
            } else {
                this.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null);
            }
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            this.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            if (android.text.TextUtils.isEmpty(com.igexin.push.h.g.c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass27(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass28(), true, false);
            }
            com.igexin.push.core.d.b.d().a();
            com.igexin.push.g.g.b();
            com.igexin.c.a.b.e eVar = this.f;
            android.content.Context context = this.a;
            if (!eVar.I) {
                if (!com.igexin.push.h.n.l()) {
                    eVar.v = (android.os.PowerManager) context.getSystemService("power");
                    eVar.D = true;
                    eVar.w = (android.app.AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
                    try {
                        if (i >= 31) {
                            eVar.t = ((java.lang.Boolean) android.app.AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", new java.lang.Class[0]).invoke(eVar.w, new java.lang.Object[0])).booleanValue();
                        } else {
                            eVar.t = true;
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                    com.igexin.c.a.d.g.AnonymousClass1 anonymousClass1 = new com.igexin.c.a.d.g.AnonymousClass1(context);
                    int i2 = android.os.Build.VERSION.SDK_INT;
                    if (i2 > 33) {
                        context.registerReceiver(eVar, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, anonymousClass1, com.igexin.push.core.e.ac, null);
                    }
                    eVar.B = "AlarmNioTaskSchedule." + context.getPackageName();
                    if (i2 > 33) {
                        context.registerReceiver(eVar, new android.content.IntentFilter(eVar.B), com.igexin.push.core.e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, new android.content.IntentFilter(eVar.B), com.igexin.push.core.e.ac, null);
                    }
                    int i3 = (com.igexin.push.h.n.a(context) < 31 || i2 < 30) ? 134217728 : 201326592;
                    eVar.x = new android.content.Intent("AlarmTaskSchedule." + context.getPackageName());
                    eVar.y = android.app.PendingIntent.getBroadcast(context, eVar.hashCode(), eVar.x, i3);
                    eVar.hashCode();
                    eVar.z = new android.content.Intent(eVar.B);
                    eVar.A = android.app.PendingIntent.getBroadcast(context, eVar.hashCode() + 2, eVar.z, i3);
                    eVar.hashCode();
                }
                eVar.p.start();
                try {
                    java.lang.Thread.yield();
                } catch (java.lang.Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
                eVar.I = true;
            }
            com.igexin.c.a.b.e eVar2 = this.f;
            byte[] a3 = com.igexin.c.b.a.a(com.igexin.push.core.e.L.getBytes());
            eVar2.e = a3;
            byte[] a4 = com.igexin.c.b.a.a(a3);
            eVar2.f = a4;
            if (a4 != null) {
                new java.lang.String(a4);
            }
            com.igexin.push.core.e.ae = this.f.a((com.igexin.c.a.d.f) com.igexin.push.g.b.b.g(), false, true);
            com.igexin.push.core.e.af = this.f.a((com.igexin.c.a.d.f) com.igexin.push.g.b.e.g(), true, true);
            com.igexin.push.c.c.a();
            com.igexin.push.c.c.b();
            b();
            this.d = com.igexin.push.core.a.b.d();
            this.h.a();
            com.igexin.push.core.e.m.set(true);
            com.igexin.push.g.f.a().d();
            while (!this.c.isEmpty()) {
                android.os.Message poll = this.c.poll();
                if (poll != null && (handler = this.b) != null) {
                    handler.sendMessage(poll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.d.AnonymousClass1(), true);
        } catch (java.lang.Throwable th3) {
            th = th3;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            while (th.getCause() != null) {
                th = th.getCause();
            }
            sb.append(th.toString());
            sb.append("\n");
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            java.lang.String sb2 = sb.toString();
            com.igexin.c.a.c.a.b(j, sb2);
            com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + sb2 + " ------");
        }
    }

    private void o() {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction(com.igexin.push.core.b.K);
        intentFilter.addAction(com.igexin.push.core.b.M);
        intentFilter.addAction("com.igexin.action.notification.click");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (android.os.Build.VERSION.SDK_INT > 33) {
            this.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null, 4);
        } else {
            this.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null);
        }
    }

    private boolean p() {
        if (com.igexin.push.core.e.l == null) {
            return true;
        }
        com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.FALSE);
        com.igexin.push.core.e.f388s = false;
        com.igexin.push.core.e.v = false;
        this.h.b();
        return true;
    }

    private static void q() {
        java.lang.String str = com.igexin.push.core.e.a;
        com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
    }

    private void r() {
        try {
            this.a.unregisterReceiver(com.igexin.push.core.i.a());
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static /* synthetic */ void s() {
        java.lang.String str = com.igexin.push.core.e.a;
        com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
    }

    public final long a() {
        android.os.Handler handler = this.b;
        if (handler == null) {
            return -2L;
        }
        return handler.getLooper().getThread().getId();
    }

    @Override // com.igexin.c.a.d.a.c
    public final void a(long j2) {
    }

    public final boolean a(android.content.Context context) {
        this.a = context.getApplicationContext();
        com.igexin.push.core.f fVar = this.k;
        if (fVar != null && fVar.isAlive()) {
            com.igexin.c.a.c.a.a("CoreLogic|coreThread is alive +++++", new java.lang.Object[0]);
            return true;
        }
        if (!this.l.getAndSet(true)) {
            com.igexin.c.a.c.a.a("CoreLogic|start coreThread +++++", new java.lang.Object[0]);
            this.k.start();
            this.b = new com.igexin.push.core.c(this.k.getLooper());
            this.e = new com.igexin.c.a.b.a.a.c(this.k.getLooper());
        }
        return true;
    }

    public final boolean a(android.os.Message message) {
        if (com.igexin.push.core.e.m.get()) {
            this.b.sendMessage(message);
            return true;
        }
        this.c.add(message);
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean a(com.igexin.c.a.d.a.e eVar) {
        com.igexin.push.core.a.b bVar = this.d;
        return bVar != null && bVar.a(eVar);
    }

    public final void b() {
        com.igexin.push.g.b.a g = com.igexin.push.g.b.a.g();
        com.igexin.push.g.c cVar = new com.igexin.push.g.c();
        g.a((com.igexin.push.g.b.c) cVar);
        g.a((com.igexin.push.g.b.c) com.igexin.push.g.a.a());
        g.a((com.igexin.push.g.b.c) com.igexin.push.g.e.a());
        g.a((com.igexin.push.g.b.c) com.igexin.push.g.f.a());
        try {
            com.igexin.push.g.a.a().a(false);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        try {
            cVar.b();
            cVar.b = java.lang.System.currentTimeMillis();
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        com.igexin.push.core.e.ag = this.f.a((com.igexin.c.a.d.f) g, false, true);
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean d() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean e() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean f() {
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final long g() {
        return 94808L;
    }
}
