package com.xiaomi.push.service;

import com.xiaomi.push.service.c.d;
import com.xiaomi.push.service.c.m;

/* loaded from: classes19.dex */
final class bm implements com.xiaomi.push.fb {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public bm(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // com.xiaomi.push.fb
    public final void a(com.xiaomi.push.ek ekVar) {
        com.xiaomi.push.service.c cVar = this.a;
        cVar.a(cVar.new d(ekVar), 0L);
    }

    @Override // com.xiaomi.push.fb
    public final void a(com.xiaomi.push.fn fnVar) {
        com.xiaomi.push.service.c cVar = this.a;
        cVar.a(cVar.new m(fnVar), 0L);
    }
}
