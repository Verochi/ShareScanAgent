package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ej {
    private static final int a = com.xiaomi.push.dy.PING_RTT.af;
    private static long b = 0;

    public static class a {
        static java.util.Hashtable<java.lang.Integer, java.lang.Long> a = new java.util.Hashtable<>();
    }

    public static void a() {
        if (b == 0 || android.os.SystemClock.elapsedRealtime() - b > 7200000) {
            b = android.os.SystemClock.elapsedRealtime();
            a(a);
        }
    }

    public static synchronized void a(int i) {
        synchronized (com.xiaomi.push.ej.class) {
            if (i >= 16777215) {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            } else {
                com.xiaomi.push.ej.a.a.put(java.lang.Integer.valueOf(i | 0), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
    }

    public static void a(int i, int i2, java.lang.String str, int i3) {
        com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
        com.xiaomi.push.ea c = ehVar.c();
        c.a((byte) 0);
        c.a(i);
        c.b(i2);
        c.e = str;
        c.c(i3);
        ehVar.a(c);
    }

    public static synchronized void a(int i, java.lang.String str, int i2) {
        synchronized (com.xiaomi.push.ej.class) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            int i3 = i | 0;
            if (!com.xiaomi.push.ej.a.a.containsKey(java.lang.Integer.valueOf(i3))) {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
                return;
            }
            com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
            com.xiaomi.push.ea c = ehVar.c();
            c.a(i);
            c.b((int) (currentTimeMillis - com.xiaomi.push.ej.a.a.get(java.lang.Integer.valueOf(i3)).longValue()));
            c.e = str;
            if (i2 >= 0) {
                c.c(i2);
            }
            ehVar.a(c);
            com.xiaomi.push.ej.a.a.remove(java.lang.Integer.valueOf(i));
        }
    }

    public static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.service.aj.b bVar) {
        com.xiaomi.push.ec ecVar = new com.xiaomi.push.ec(cVar, bVar);
        ecVar.b.a(ecVar);
        ecVar.c = ecVar.a.c;
    }

    public static void a(java.lang.String str, int i, java.lang.Exception exc) {
        com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
        com.xiaomi.push.ea c = ehVar.c();
        if (com.xiaomi.push.eh.a() != null && com.xiaomi.push.eh.a().a != null) {
            c.c(com.xiaomi.push.ai.b(com.xiaomi.push.eh.a().a) ? 1 : 0);
        }
        if (i > 0) {
            c.a(com.xiaomi.push.dy.GSLB_REQUEST_SUCCESS.af);
            c.e = str;
            c.b(i);
            ehVar.a(c);
            return;
        }
        try {
            com.xiaomi.push.ef.a(exc);
            com.xiaomi.push.ef.a aVar = new com.xiaomi.push.ef.a();
            java.lang.String message = exc.getMessage();
            if (exc.getCause() != null) {
                message = exc.getCause().getMessage();
            }
            java.lang.String str2 = exc.getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + message;
            int a2 = com.xiaomi.push.ex.a(exc);
            if (a2 != 0) {
                aVar.a = com.xiaomi.push.dy.a(com.xiaomi.push.dy.GSLB_REQUEST_SUCCESS.af + a2);
            }
            if (aVar.a == null) {
                aVar.a = com.xiaomi.push.dy.GSLB_TCP_ERR_OTHER;
            }
            com.xiaomi.push.dy dyVar = aVar.a;
            if (dyVar == com.xiaomi.push.dy.GSLB_TCP_ERR_OTHER) {
                aVar.b = str2;
            }
            c.a(dyVar.af);
            c.g = aVar.b;
            c.e = str;
            ehVar.a(c);
        } catch (java.lang.NullPointerException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.lang.String str, java.lang.Exception exc) {
        com.xiaomi.push.dy dyVar;
        com.xiaomi.push.dy dyVar2;
        com.xiaomi.push.ea c;
        java.lang.Throwable cause;
        try {
            com.xiaomi.push.ef.a(exc);
            boolean z = exc instanceof com.xiaomi.push.fh;
            java.lang.Exception exc2 = exc;
            if (z) {
                java.lang.Throwable th = ((com.xiaomi.push.fh) exc).a;
                exc2 = exc;
                if (th != null) {
                    exc2 = ((com.xiaomi.push.fh) exc).a;
                }
            }
            com.xiaomi.push.ef.a aVar = new com.xiaomi.push.ef.a();
            java.lang.String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            int a2 = com.xiaomi.push.ex.a(exc2);
            java.lang.String str2 = exc2.getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + message;
            if (a2 != 0) {
                com.xiaomi.push.dy a3 = com.xiaomi.push.dy.a(com.xiaomi.push.dy.CONN_SUCCESS.af + a2);
                aVar.a = a3;
                if (a3 == com.xiaomi.push.dy.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof java.net.UnknownHostException)) {
                    dyVar = com.xiaomi.push.dy.CONN_BOSH_UNKNOWNHOST;
                }
                dyVar2 = aVar.a;
                if (dyVar2 != com.xiaomi.push.dy.CONN_TCP_ERR_OTHER || dyVar2 == com.xiaomi.push.dy.CONN_XMPP_ERR || dyVar2 == com.xiaomi.push.dy.CONN_BOSH_ERR) {
                    aVar.b = str2;
                }
                com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
                c = ehVar.c();
                c.a(aVar.a.af);
                c.g = aVar.b;
                c.e = str;
                if (com.xiaomi.push.eh.a() != null && com.xiaomi.push.eh.a().a != null) {
                    c.c(!com.xiaomi.push.ai.b(com.xiaomi.push.eh.a().a) ? 1 : 0);
                }
                ehVar.a(c);
            }
            dyVar = com.xiaomi.push.dy.CONN_XMPP_ERR;
            aVar.a = dyVar;
            dyVar2 = aVar.a;
            if (dyVar2 != com.xiaomi.push.dy.CONN_TCP_ERR_OTHER) {
            }
            aVar.b = str2;
            com.xiaomi.push.eh ehVar2 = com.xiaomi.push.eh.a.a;
            c = ehVar2.c();
            c.a(aVar.a.af);
            c.g = aVar.b;
            c.e = str;
            if (com.xiaomi.push.eh.a() != null) {
                c.c(!com.xiaomi.push.ai.b(com.xiaomi.push.eh.a().a) ? 1 : 0);
            }
            ehVar2.a(c);
        } catch (java.lang.NullPointerException unused) {
        }
    }

    public static void b() {
        a(a, (java.lang.String) null, -1);
    }

    public static void b(int i) {
        com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
        com.xiaomi.push.ea c = ehVar.c();
        c.a(com.xiaomi.push.dy.CHANNEL_STATS_COUNTER.af);
        c.c(i);
        ehVar.a(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(java.lang.String str, java.lang.Exception exc) {
        com.xiaomi.push.dy dyVar;
        com.xiaomi.push.dy dyVar2;
        com.xiaomi.push.ea c;
        try {
            com.xiaomi.push.ef.a(exc);
            boolean z = exc instanceof com.xiaomi.push.fh;
            java.lang.Exception exc2 = exc;
            if (z) {
                java.lang.Throwable th = ((com.xiaomi.push.fh) exc).a;
                exc2 = exc;
                if (th != null) {
                    exc2 = ((com.xiaomi.push.fh) exc).a;
                }
            }
            com.xiaomi.push.ef.a aVar = new com.xiaomi.push.ef.a();
            java.lang.String message = exc2.getMessage();
            int a2 = com.xiaomi.push.ex.a(exc2);
            java.lang.String str2 = exc2.getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + message;
            if (a2 == 105) {
                dyVar = com.xiaomi.push.dy.CHANNEL_TCP_READTIMEOUT;
            } else if (a2 == 199) {
                dyVar = com.xiaomi.push.dy.CHANNEL_TCP_ERR;
            } else {
                if (a2 == 499) {
                    aVar.a = com.xiaomi.push.dy.CHANNEL_BOSH_EXCEPTION;
                    if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                        dyVar = com.xiaomi.push.dy.CHANNEL_BOSH_ITEMNOTFIND;
                    }
                    dyVar2 = aVar.a;
                    if (dyVar2 != com.xiaomi.push.dy.CHANNEL_TCP_ERR || dyVar2 == com.xiaomi.push.dy.CHANNEL_XMPPEXCEPTION || dyVar2 == com.xiaomi.push.dy.CHANNEL_BOSH_EXCEPTION) {
                        aVar.b = str2;
                    }
                    com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
                    c = ehVar.c();
                    c.a(aVar.a.af);
                    c.g = aVar.b;
                    c.e = str;
                    if (com.xiaomi.push.eh.a() != null && com.xiaomi.push.eh.a().a != null) {
                        c.c(!com.xiaomi.push.ai.b(com.xiaomi.push.eh.a().a) ? 1 : 0);
                    }
                    ehVar.a(c);
                }
                dyVar = a2 != 109 ? a2 != 110 ? com.xiaomi.push.dy.CHANNEL_XMPPEXCEPTION : com.xiaomi.push.dy.CHANNEL_TCP_BROKEN_PIPE : com.xiaomi.push.dy.CHANNEL_TCP_CONNRESET;
            }
            aVar.a = dyVar;
            dyVar2 = aVar.a;
            if (dyVar2 != com.xiaomi.push.dy.CHANNEL_TCP_ERR) {
            }
            aVar.b = str2;
            com.xiaomi.push.eh ehVar2 = com.xiaomi.push.eh.a.a;
            c = ehVar2.c();
            c.a(aVar.a.af);
            c.g = aVar.b;
            c.e = str;
            if (com.xiaomi.push.eh.a() != null) {
                c.c(!com.xiaomi.push.ai.b(com.xiaomi.push.eh.a().a) ? 1 : 0);
            }
            ehVar2.a(c);
        } catch (java.lang.NullPointerException unused) {
        }
    }

    public static byte[] c() {
        com.xiaomi.push.eb b2 = com.xiaomi.push.eh.a.a.b();
        if (b2 != null) {
            return com.xiaomi.push.hv.a(b2);
        }
        return null;
    }
}
