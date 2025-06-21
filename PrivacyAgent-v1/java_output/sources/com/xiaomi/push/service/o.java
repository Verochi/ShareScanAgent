package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class o implements com.xiaomi.push.service.aj.b.a {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public o(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public final void a(com.xiaomi.push.service.aj.c cVar, com.xiaomi.push.service.aj.c cVar2, int i) {
        if (cVar2 == com.xiaomi.push.service.aj.c.binded) {
            com.xiaomi.push.service.cs.a(this.a);
            com.xiaomi.push.service.cs.b(this.a);
        } else if (cVar2 == com.xiaomi.push.service.aj.c.unbind) {
            com.xiaomi.channel.commonutils.logger.b.a("onChange unbind");
            com.xiaomi.push.service.cs.a(this.a, com.xiaomi.mipush.sdk.ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
