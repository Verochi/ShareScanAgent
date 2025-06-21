package com.xiaomi.push.service;

import com.xiaomi.push.service.c.g;

/* loaded from: classes19.dex */
final class bu implements com.xiaomi.push.service.aj.a {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public bu(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.aj.a
    public final void a() {
        this.a.k();
        if (com.xiaomi.push.service.aj.a().c() <= 0) {
            com.xiaomi.push.service.c cVar = this.a;
            cVar.a(cVar.new g(12), 0L);
        }
    }
}
