package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ed extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.ec a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed(com.xiaomi.push.ec ecVar) {
        super(4);
        this.a = ecVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Throwable] */
    @Override // com.xiaomi.push.service.c.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        com.xiaomi.push.ef.a aVar;
        java.lang.String message;
        int a;
        java.lang.String str;
        com.xiaomi.push.dy dyVar;
        com.xiaomi.push.dy dyVar2;
        com.xiaomi.push.dy dyVar3;
        com.xiaomi.push.ec ecVar = this.a;
        com.xiaomi.push.service.aj.b bVar = ecVar.b;
        synchronized (bVar.o) {
            bVar.o.remove(ecVar);
        }
        if (!ecVar.f || ecVar.e == 11) {
            return;
        }
        com.xiaomi.push.ea c = com.xiaomi.push.eh.a.a.c();
        int i = com.xiaomi.push.ee.a[ecVar.d.ordinal()];
        if (i != 1) {
            if (i == 3) {
                dyVar3 = com.xiaomi.push.dy.BIND_SUCCESS;
            }
            if (c == null) {
                c.e = ecVar.c.e();
                com.xiaomi.push.service.aj.b bVar2 = ecVar.b;
                c.h = bVar2.b;
                c.c = 1;
                try {
                    c.a((byte) java.lang.Integer.parseInt(bVar2.h));
                } catch (java.lang.NumberFormatException unused) {
                }
                com.xiaomi.push.eh.a.a.a(c);
                return;
            }
            return;
        }
        int i2 = ecVar.e;
        if (i2 == 17) {
            dyVar3 = com.xiaomi.push.dy.BIND_TCP_READ_TIMEOUT;
        } else if (i2 == 21) {
            dyVar3 = com.xiaomi.push.dy.BIND_TIMEOUT;
        } else {
            try {
                java.lang.Exception exc = com.xiaomi.push.eh.a().c;
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
                aVar = new com.xiaomi.push.ef.a();
                message = exc2.getMessage();
                if (exc2.getCause() != null) {
                    message = exc2.getCause().getMessage();
                }
                a = com.xiaomi.push.ex.a(exc2);
                str = exc2.getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + message;
            } catch (java.lang.NullPointerException unused2) {
                c = null;
            }
            if (a == 105) {
                dyVar = com.xiaomi.push.dy.BIND_TCP_READ_TIMEOUT;
            } else if (a == 199) {
                dyVar = com.xiaomi.push.dy.BIND_TCP_ERR;
            } else if (a != 499) {
                dyVar = a != 109 ? a != 110 ? com.xiaomi.push.dy.BIND_XMPP_ERR : com.xiaomi.push.dy.BIND_TCP_BROKEN_PIPE : com.xiaomi.push.dy.BIND_TCP_CONNRESET;
            } else {
                aVar.a = com.xiaomi.push.dy.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    dyVar = com.xiaomi.push.dy.BIND_BOSH_ITEM_NOT_FOUND;
                }
                dyVar2 = aVar.a;
                if (dyVar2 != com.xiaomi.push.dy.BIND_TCP_ERR || dyVar2 == com.xiaomi.push.dy.BIND_XMPP_ERR || dyVar2 == com.xiaomi.push.dy.BIND_BOSH_ERR) {
                    aVar.b = str;
                }
                c.b = dyVar2.af;
                c.g = aVar.b;
                if (c == null) {
                }
            }
            aVar.a = dyVar;
            dyVar2 = aVar.a;
            if (dyVar2 != com.xiaomi.push.dy.BIND_TCP_ERR) {
            }
            aVar.b = str;
            c.b = dyVar2.af;
            c.g = aVar.b;
            if (c == null) {
            }
        }
        c.b = dyVar3.af;
        if (c == null) {
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "Handling bind stats";
    }
}
