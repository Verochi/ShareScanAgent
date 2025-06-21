package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bn extends com.xiaomi.push.service.c.j {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ com.xiaomi.push.service.c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(com.xiaomi.push.service.c cVar, java.lang.String str, byte[] bArr) {
        super(4);
        this.c = cVar;
        this.a = str;
        this.b = bArr;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.service.l.a(this.c, this.a, this.b);
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.c.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send mi push message";
    }
}
