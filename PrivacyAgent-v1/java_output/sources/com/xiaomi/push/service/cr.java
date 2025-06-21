package com.xiaomi.push.service;

import com.xiaomi.push.service.c.b;

/* loaded from: classes19.dex */
public final class cr extends com.xiaomi.push.service.c.j {
    private com.xiaomi.push.service.c a;
    private byte[] b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;

    public cr(com.xiaomi.push.service.c cVar, java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        super(9);
        this.a = cVar;
        this.c = str;
        this.b = bArr;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.service.aj.b next;
        com.xiaomi.push.service.co a = com.xiaomi.push.service.cp.a(this.a);
        if (a == null) {
            try {
                a = com.xiaomi.push.service.cp.a(this.a, this.c, this.d, this.e);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. ".concat(java.lang.String.valueOf(e)));
            }
        }
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            com.xiaomi.push.service.cs.a(this.a, com.xiaomi.mipush.sdk.ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("do registration now.");
        java.util.Collection<com.xiaomi.push.service.aj.b> c = com.xiaomi.push.service.aj.a().c("5");
        if (c.isEmpty()) {
            next = a.a(this.a);
            com.xiaomi.push.service.l.a(this.a, next);
            com.xiaomi.push.service.aj.a().a(next);
        } else {
            next = c.iterator().next();
        }
        if (!this.a.b()) {
            com.xiaomi.push.service.cs.a(this.c, this.b);
            this.a.b(true);
            return;
        }
        try {
            com.xiaomi.push.service.aj.c cVar = next.m;
            if (cVar == com.xiaomi.push.service.aj.c.binded) {
                com.xiaomi.push.service.l.a(this.a, this.c, this.b);
            } else if (cVar == com.xiaomi.push.service.aj.c.unbind) {
                com.xiaomi.push.service.cs.a(this.c, this.b);
                com.xiaomi.push.service.c cVar2 = this.a;
                cVar2.getClass();
                cVar2.a(cVar2.new b(next), 0L);
            }
        } catch (com.xiaomi.push.fh e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. ".concat(java.lang.String.valueOf(e2)));
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "register app";
    }
}
