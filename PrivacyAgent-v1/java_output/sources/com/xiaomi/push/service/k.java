package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class k {
    static com.xiaomi.push.service.k.a a;
    private static com.xiaomi.push.service.k.b b;

    public interface a {
        boolean a();

        java.util.Map<java.lang.String, java.lang.String> b();
    }

    public interface b {
        boolean a();
    }

    public static void a(java.lang.String str) {
        if (b == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        }
    }

    public static boolean a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.service.k.a aVar = a;
        if (aVar != null && hhVar != null) {
            return aVar.a();
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa judement listener or container is null");
        return false;
    }

    public static void b(com.xiaomi.push.hh hhVar) {
        if (a == null || hhVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("handle msg wrong");
        }
    }

    public static boolean c(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.service.k.b bVar = b;
        if (bVar != null && hhVar != null) {
            return bVar.a();
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void d(com.xiaomi.push.hh hhVar) {
        if (b == null || hhVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        }
    }
}
