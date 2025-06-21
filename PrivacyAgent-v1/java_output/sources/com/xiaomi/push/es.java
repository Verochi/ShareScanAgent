package com.xiaomi.push;

/* loaded from: classes19.dex */
final class es extends java.lang.Thread {
    final /* synthetic */ com.xiaomi.push.er a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(com.xiaomi.push.er erVar, java.lang.String str) {
        super(str);
        this.a = erVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        com.xiaomi.push.em emVar;
        com.xiaomi.push.er erVar;
        java.lang.String str;
        com.xiaomi.push.cx.a aVar;
        int i;
        try {
            emVar = this.a.z;
            boolean z = false;
            try {
                emVar.c = false;
                com.xiaomi.push.ek a = emVar.a();
                if ("CONN".equals(a.a.f)) {
                    com.xiaomi.push.cx.f fVar = (com.xiaomi.push.cx.f) new com.xiaomi.push.cx.f().b(a.c());
                    if (fVar.a) {
                        emVar.b.a(fVar.b);
                        z = true;
                    }
                    if (fVar.d) {
                        com.xiaomi.push.cx.b bVar = fVar.e;
                        com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
                        ekVar.a("SYNC", "CONF");
                        ekVar.a(bVar.c(), (java.lang.String) null);
                        emVar.b.a(ekVar);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a("[Slim] CONN: host = " + fVar.c);
                }
                if (!z) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Slim] Invalid CONN");
                    throw new java.io.IOException("Invalid Connection");
                }
                emVar.d = emVar.b.a();
                while (!emVar.c) {
                    com.xiaomi.push.ek a2 = emVar.a();
                    emVar.b.l();
                    short s2 = a2.b;
                    if (s2 == 1) {
                        erVar = emVar.b;
                    } else if (s2 != 2) {
                        if (s2 != 3) {
                            str = "[Slim] unknow blob type " + ((int) a2.b);
                        } else {
                            try {
                                emVar.b.b(emVar.a.a(a2.c(), emVar.b));
                            } catch (java.lang.Exception e) {
                                str = "[Slim] Parse packet from Blob chid=" + a2.a.a + "; Id=" + a2.a() + " failure:" + e.getMessage();
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.a(str);
                    } else if ("SECMSG".equals(a2.a.f) && (((i = (aVar = a2.a).a) == 2 || i == 3) && android.text.TextUtils.isEmpty(aVar.h))) {
                        try {
                            emVar.b.b(emVar.a.a(a2.c(com.xiaomi.push.service.aj.a().b(java.lang.Integer.valueOf(a2.a.a).toString(), a2.b()).i), emVar.b));
                        } catch (java.lang.Exception e2) {
                            str = "[Slim] Parse packet from Blob chid=" + a2.a.a + "; Id=" + a2.a() + " failure:" + e2.getMessage();
                        }
                    } else {
                        if (a2.a.a == 10) {
                            a2.b(10);
                            a2.e.c = com.xiaomi.push.jd.a(emVar.e);
                            a2.e.d = com.xiaomi.push.ai.d(emVar.e);
                            a2.e.e = java.lang.System.currentTimeMillis();
                            com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                        }
                        erVar = emVar.b;
                    }
                    erVar.a(a2);
                }
            } catch (java.io.IOException e3) {
                if (!emVar.c) {
                    throw e3;
                }
            }
        } catch (java.lang.Exception e4) {
            this.a.c(9, e4);
        }
    }
}
