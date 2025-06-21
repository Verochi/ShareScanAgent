package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bt extends com.xiaomi.push.ew {
    final /* synthetic */ com.xiaomi.push.service.c h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(com.xiaomi.push.service.c cVar, java.lang.String str) {
        super(str);
        this.h = cVar;
    }

    @Override // com.xiaomi.push.ew
    public final byte[] b() {
        try {
            com.xiaomi.push.cx.b bVar = new com.xiaomi.push.cx.b();
            bVar.a(com.xiaomi.push.service.ay.a().d());
            return bVar.c();
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
