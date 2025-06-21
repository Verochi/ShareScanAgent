package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class s {
    private static volatile com.xiaomi.mipush.sdk.s a;

    /* renamed from: a, reason: collision with other field name */
    private final android.content.Context f57a;

    private s(android.content.Context context) {
        this.f57a = context.getApplicationContext();
    }

    private static com.xiaomi.mipush.sdk.s a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.mipush.sdk.s.class) {
                if (a == null) {
                    a = new com.xiaomi.mipush.sdk.s(context);
                }
            }
        }
        return a;
    }

    public static void a(android.content.Context context, com.xiaomi.push.hh hhVar) {
        a(context).a(hhVar, 0, true);
    }

    public static void a(android.content.Context context, com.xiaomi.push.hh hhVar, boolean z) {
        a(context).a(hhVar, 1, z);
    }

    private void a(com.xiaomi.push.hh hhVar, int i, boolean z) {
        if (com.xiaomi.push.iu.a(this.f57a) || !com.xiaomi.push.iu.a() || hhVar == null || hhVar.a != com.xiaomi.push.gk.SendMessage || hhVar.h == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("click to start activity result:" + java.lang.String.valueOf(i));
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk(hhVar.h.a, false);
        hkVar.e = com.xiaomi.push.gu.SDK_START_ACTIVITY.ah;
        hkVar.d = hhVar.e;
        hkVar.i = hhVar.f;
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        hashMap.put("result", java.lang.String.valueOf(i));
        com.xiaomi.mipush.sdk.ao.a(this.f57a).a(hkVar, com.xiaomi.push.gk.Notification, false, false, null, true, hhVar.f, hhVar.e, true, false);
    }

    public static void b(android.content.Context context, com.xiaomi.push.hh hhVar, boolean z) {
        a(context).a(hhVar, 2, z);
    }

    public static void c(android.content.Context context, com.xiaomi.push.hh hhVar, boolean z) {
        a(context).a(hhVar, 3, z);
    }

    public static void d(android.content.Context context, com.xiaomi.push.hh hhVar, boolean z) {
        a(context).a(hhVar, 4, z);
    }

    public static void e(android.content.Context context, com.xiaomi.push.hh hhVar, boolean z) {
        com.xiaomi.mipush.sdk.s a2;
        int i;
        com.xiaomi.mipush.sdk.b m126a = com.xiaomi.mipush.sdk.b.m126a(context);
        if (android.text.TextUtils.isEmpty(m126a.m134c()) || android.text.TextUtils.isEmpty(m126a.d())) {
            a2 = a(context);
            i = 6;
        } else {
            boolean m138f = m126a.m138f();
            a2 = a(context);
            i = m138f ? 7 : 5;
        }
        a2.a(hhVar, i, z);
    }
}
