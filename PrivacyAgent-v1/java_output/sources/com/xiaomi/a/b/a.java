package com.xiaomi.a.b;

/* loaded from: classes19.dex */
public final class a {
    public static void a(android.content.Context context, com.xiaomi.a.a.a aVar, com.xiaomi.a.c.a aVar2, com.xiaomi.a.c.b bVar) {
        com.xiaomi.channel.commonutils.logger.b.c("init in  pid :" + android.os.Process.myPid() + " threadId: " + java.lang.Thread.currentThread().getId());
        com.xiaomi.a.b.b a = com.xiaomi.a.b.b.a(context);
        a.e = aVar;
        a.g = aVar2;
        a.h = bVar;
        aVar2.a(a.c);
        a.h.a(a.b);
        boolean z = false;
        java.lang.String str = (java.lang.String) com.xiaomi.push.aj.a("android.app.ActivityThread", "currentProcessName", new java.lang.Object[0]);
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            z = str.equals(context.getPackageName());
        }
        if (z) {
            com.xiaomi.channel.commonutils.logger.b.c("init in process\u3000start scheduleJob");
            com.xiaomi.a.b.b a2 = com.xiaomi.a.b.b.a(context);
            com.xiaomi.a.b.b.a(a2.d).b();
            com.xiaomi.a.b.b.a(a2.d).c();
        }
    }

    public static void a(android.content.Context context, com.xiaomi.a.a.b bVar) {
        if (bVar != null) {
            com.xiaomi.a.b.b a = com.xiaomi.a.b.b.a(context);
            if (a.a().b) {
                a.a.execute(new com.xiaomi.a.b.c(a, bVar));
            }
        }
    }

    public static void a(android.content.Context context, com.xiaomi.a.a.c cVar) {
        if (cVar != null) {
            com.xiaomi.a.b.b a = com.xiaomi.a.b.b.a(context);
            if (a.a().c) {
                a.a.execute(new com.xiaomi.a.b.d(a, cVar));
            }
        }
    }
}
