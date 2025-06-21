package com.igexin.push.d;

/* loaded from: classes23.dex */
public final class d implements com.igexin.push.d.b {
    public static final java.lang.String a = "NormalModel";

    @Override // com.igexin.push.d.b
    public final long a() {
        long j;
        boolean a2 = com.igexin.push.h.c.a();
        com.igexin.push.core.e.n = com.igexin.push.h.c.e();
        com.igexin.c.a.c.a.a("NormalModel|isSdkOn = " + com.igexin.push.core.e.p + " isPushOn = " + com.igexin.push.core.e.f388s + " isBlockEndTime = " + a2 + " isNetworkAvailable = " + com.igexin.push.core.e.n, new java.lang.Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.f388s || !a2) {
            com.igexin.c.a.c.a.a(a, "reconnect stop, interval= 20min ++++++");
            com.igexin.c.a.c.a.a("NormalModel|reconnect stop, interval= 20min ++++", new java.lang.Object[0]);
            return com.igexin.push.config.c.g;
        }
        long j2 = com.igexin.push.core.e.O;
        if (j2 <= 0) {
            j = 1;
        } else {
            j = j2 + (j2 <= 300 ? 150L : j2 <= 10000 ? 500L : j2 <= 30000 ? 1500L : com.igexin.push.config.c.l);
        }
        com.igexin.push.core.e.O = j;
        if (com.igexin.push.core.e.O > com.igexin.push.config.c.g) {
            com.igexin.push.core.e.O = com.igexin.push.config.c.g;
        }
        long j3 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("NormalModel|after add auto reconnect delay time = ".concat(java.lang.String.valueOf(j3)), new java.lang.Object[0]);
        return j3;
    }
}
