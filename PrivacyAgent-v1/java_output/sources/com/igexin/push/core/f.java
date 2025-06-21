package com.igexin.push.core;

import com.igexin.push.core.d.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass27;
import com.igexin.push.core.e.f.AnonymousClass28;

/* loaded from: classes23.dex */
public final class f extends android.os.HandlerThread {
    public f() {
        super("CoreThread");
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        android.os.Handler handler;
        com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
        try {
            com.igexin.push.core.e.a(dVar.a);
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
                dVar.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null, 4);
            } else {
                dVar.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null);
            }
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            dVar.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
            if (android.text.TextUtils.isEmpty(com.igexin.push.h.g.c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass27(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass28(), true, false);
            }
            com.igexin.push.core.d.b.d().a();
            com.igexin.push.g.g.b();
            com.igexin.c.a.b.e eVar = dVar.f;
            android.content.Context context = dVar.a;
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
            com.igexin.c.a.b.e eVar2 = dVar.f;
            byte[] a2 = com.igexin.c.b.a.a(com.igexin.push.core.e.L.getBytes());
            eVar2.e = a2;
            byte[] a3 = com.igexin.c.b.a.a(a2);
            eVar2.f = a3;
            if (a3 != null) {
                new java.lang.String(a3);
            }
            com.igexin.push.core.e.ae = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.g.b.b.g(), false, true);
            com.igexin.push.core.e.af = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.g.b.e.g(), true, true);
            com.igexin.push.c.c.a();
            com.igexin.push.c.c.b();
            dVar.b();
            dVar.d = com.igexin.push.core.a.b.d();
            dVar.h.a();
            com.igexin.push.core.e.m.set(true);
            com.igexin.push.g.f.a().d();
            while (!dVar.c.isEmpty()) {
                android.os.Message poll = dVar.c.poll();
                if (poll != null && (handler = dVar.b) != null) {
                    handler.sendMessage(poll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) dVar.new AnonymousClass1(), true);
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
            com.igexin.c.a.c.a.b("CoreLogic", sb2);
            com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + sb2 + " ------");
        }
    }
}
