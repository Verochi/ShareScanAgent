package com.xiaomi.push.service;

import com.xiaomi.push.service.c.e;

/* loaded from: classes19.dex */
final class at {
    private static int f = 300000;
    com.xiaomi.push.service.c a;
    int c = 0;
    private int e = 0;
    private int d = 500;
    long b = 0;

    public at(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    private int a() {
        double d;
        if (this.c > 8) {
            return com.alipay.sdk.m.e0.a.a;
        }
        double random = (java.lang.Math.random() * 2.0d) + 1.0d;
        int i = this.c;
        if (i > 4) {
            d = 60000.0d;
        } else {
            if (i <= 1) {
                if (this.b == 0) {
                    return 0;
                }
                if (java.lang.System.currentTimeMillis() - this.b >= 310000) {
                    this.d = 1000;
                    this.e = 0;
                    return 0;
                }
                int i2 = this.d;
                int i3 = f;
                if (i2 >= i3) {
                    return i2;
                }
                int i4 = this.e + 1;
                this.e = i4;
                if (i4 >= 4) {
                    return i3;
                }
                this.d = (int) (i2 * 1.5d);
                return i2;
            }
            d = 10000.0d;
        }
        return (int) (random * d);
    }

    public final void a(boolean z) {
        if (!this.a.a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.a.e.b()) {
                this.c++;
            }
            this.a.a(1);
            com.xiaomi.push.service.c cVar = this.a;
            cVar.getClass();
            cVar.a(cVar.new e(), 0L);
            return;
        }
        if (this.a.e.b()) {
            return;
        }
        int a = a();
        this.c++;
        com.xiaomi.channel.commonutils.logger.b.a("schedule reconnect in " + a + "ms");
        com.xiaomi.push.service.c cVar2 = this.a;
        cVar2.getClass();
        cVar2.a(cVar2.new e(), (long) a);
        if (this.c == 2 && com.xiaomi.push.eh.a.a.a) {
            com.xiaomi.push.service.t.b();
        }
        if (this.c == 3) {
            com.xiaomi.push.service.t.a();
        }
    }
}
