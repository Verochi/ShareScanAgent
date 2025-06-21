package com.getui.gtc.extension.distribution.gbd.e;

import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass1;
import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass2;
import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass3;
import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass4;
import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass5;
import com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass8;

/* loaded from: classes22.dex */
public final class c extends java.lang.Thread {
    private static final java.lang.String a = "GBDThread";

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        android.content.pm.ApplicationInfo applicationInfo;
        long j;
        android.os.Bundle bundle;
        java.lang.Thread.currentThread().setName("GBD-Thread");
        if (android.os.Looper.myLooper() == null) {
            android.os.Looper.prepare();
        }
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.h.b == null) {
                com.getui.gtc.extension.distribution.gbd.d.h.b = new com.getui.gtc.extension.distribution.gbd.e.a();
            }
            com.getui.gtc.extension.distribution.gbd.e.b a2 = com.getui.gtc.extension.distribution.gbd.e.b.a();
            com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_Logic", "gbd logic init ,GBD-2.10.5.2");
            com.getui.gtc.extension.distribution.gbd.d.h.ap = com.getui.gtc.extension.distribution.gbd.n.a.a();
            com.getui.gtc.extension.distribution.gbd.d.h.a = new com.getui.gtc.extension.distribution.gbd.f.a(a2.a);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.b();
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b();
            com.getui.gtc.extension.distribution.gbd.f.h.a();
            a2.b();
            android.content.Context context = a2.a;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                applicationInfo = null;
            }
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                java.lang.String string = bundle.getString(com.getui.gtc.extension.distribution.gbd.d.g.M);
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.getui.gtc.extension.distribution.gbd.d.d.d = string;
                }
                java.lang.String string2 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.N);
                if (!android.text.TextUtils.isEmpty(string2)) {
                    com.getui.gtc.extension.distribution.gbd.d.d.e = string2;
                }
                java.lang.String string3 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.O);
                if (!android.text.TextUtils.isEmpty(string3)) {
                    com.getui.gtc.extension.distribution.gbd.d.i.a = string3;
                }
                java.lang.String string4 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.P);
                if (!android.text.TextUtils.isEmpty(string4)) {
                    com.getui.gtc.extension.distribution.gbd.d.i.b = string4;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", "gbd config task init");
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(a2.new AnonymousClass1());
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(a2.new AnonymousClass2(), 5000L);
            try {
                boolean B = com.getui.gtc.extension.distribution.gbd.n.l.B();
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", "CAE  ".concat(java.lang.String.valueOf(B)));
                if (B) {
                    if (com.getui.gtc.extension.distribution.gbd.d.h.ai.split(",").length >= 200) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", " CAD length > 200, clean. ");
                        com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                    }
                    long C = com.getui.gtc.extension.distribution.gbd.n.l.C();
                    long j2 = C - (com.getui.gtc.extension.distribution.gbd.d.h.aj + com.getui.gtc.extension.distribution.gbd.d.h.ak);
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_Logic", "initCAA: sdkLastStartTime  " + com.getui.gtc.extension.distribution.gbd.d.h.aj);
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_Logic", "initCAA: sdkAliveTime  " + com.getui.gtc.extension.distribution.gbd.d.h.ak);
                    if (com.getui.gtc.extension.distribution.gbd.d.h.aj == 0) {
                        com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                        com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                    } else if (j2 <= com.getui.gtc.extension.distribution.gbd.d.d.bK * 1000) {
                        long j3 = C - com.getui.gtc.extension.distribution.gbd.d.h.aj;
                        com.getui.gtc.extension.distribution.gbd.d.h.ak = j3;
                        if (j3 < 0) {
                            com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                            com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                        }
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                    } else {
                        if (com.getui.gtc.extension.distribution.gbd.d.h.ak >= 10000) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                            sb.append((com.getui.gtc.extension.distribution.gbd.d.h.aj / 1000) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + (com.getui.gtc.extension.distribution.gbd.d.h.ak / 1000) + ",");
                            com.getui.gtc.extension.distribution.gbd.d.h.ai = sb.toString();
                            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                            com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", "CAD update =  " + com.getui.gtc.extension.distribution.gbd.d.h.ai);
                        }
                        com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                        com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a.b.f(j);
                } else {
                    com.getui.gtc.extension.distribution.gbd.d.h.aj = 0L;
                    com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                    com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", "clean CAD. ");
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            if (com.getui.gtc.extension.distribution.gbd.n.l.B()) {
                com.getui.gtc.extension.distribution.gbd.k.a.c.a(0L);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_Logic", "GBD E " + com.getui.gtc.extension.distribution.gbd.d.d.x);
            if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                a2.f = new com.getui.gtc.extension.distribution.gbd.k.a();
                try {
                    com.getui.gtc.extension.distribution.gbd.d.h.c = (android.net.wifi.WifiManager) a2.a.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                    if (a2.a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", a2.a.getPackageName()) == 0) {
                        com.getui.gtc.extension.distribution.gbd.d.h.i = true;
                    }
                } catch (java.lang.Throwable th2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                }
                try {
                    if (!a2.e.getAndSet(true)) {
                        if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_WIFI_STATE") && com.getui.gtc.extension.distribution.gbd.d.d.q) {
                            a2.c = new com.getui.gtc.extension.distribution.gbd.i.b();
                            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                            a2.a.registerReceiver(a2.c, intentFilter);
                        }
                        a2.b = new com.getui.gtc.extension.distribution.gbd.i.c();
                        android.content.IntentFilter intentFilter2 = new android.content.IntentFilter();
                        intentFilter2.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
                        intentFilter2.addAction("android.intent.action.SCREEN_OFF");
                        a2.a.registerReceiver(a2.b, intentFilter2);
                        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(a2.new AnonymousClass8(), 500L);
                        a2.d = new com.getui.gtc.extension.distribution.gbd.i.d();
                        android.content.IntentFilter intentFilter3 = new android.content.IntentFilter();
                        intentFilter3.addAction("android.intent.action.ACTION_SHUTDOWN");
                        a2.a.registerReceiver(a2.d, intentFilter3);
                    }
                } catch (java.lang.Throwable th3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                }
                com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
                if (aVar != null && a2.f != null) {
                    aVar.postDelayed(a2.new AnonymousClass3(), com.getui.gtc.extension.distribution.gbd.d.d.g * 1000);
                }
                com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(a2.new AnonymousClass4(), 2000L);
                long nextInt = (com.getui.gtc.extension.distribution.gbd.d.d.ci + new java.util.Random().nextInt(5)) * 1000;
                long j4 = nextInt * 7;
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_Logic", "gbd dc task delay= " + nextInt + "ms start");
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(a2.new AnonymousClass5(j4), nextInt, j4);
                a2.b();
            }
        } catch (java.lang.Throwable th4) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th4.toString());
        }
        android.os.Looper.loop();
    }
}
