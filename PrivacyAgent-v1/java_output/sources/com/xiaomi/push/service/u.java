package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class u implements java.lang.Runnable {
    final /* synthetic */ java.util.List a;
    final /* synthetic */ boolean b = true;

    public u(java.util.List list) {
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean b;
        boolean b2;
        b = com.xiaomi.push.service.t.b("www.baidu.com:80");
        java.util.Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            java.lang.String str = (java.lang.String) it.next();
            if (!b) {
                b2 = com.xiaomi.push.service.t.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.b) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        com.xiaomi.push.ej.b(b ? 1 : 2);
    }
}
