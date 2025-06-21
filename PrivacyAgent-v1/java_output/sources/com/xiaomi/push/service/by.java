package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class by extends com.xiaomi.push.service.c.j {
    final /* synthetic */ int a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ com.xiaomi.push.service.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(com.xiaomi.push.service.c cVar, int i, java.lang.String str, byte[] bArr) {
        super(14);
        this.d = cVar;
        this.a = i;
        this.b = str;
        this.c = bArr;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.ew ewVar;
        this.d.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        com.xiaomi.push.service.cp.a = null;
        com.xiaomi.push.service.cp.a();
        com.xiaomi.push.service.aj.a().a("5");
        com.xiaomi.push.f.a(this.a);
        ewVar = this.d.i;
        ewVar.d = com.xiaomi.push.ew.a();
        com.xiaomi.channel.commonutils.logger.b.a("clear account and start registration. " + this.b);
        this.d.a(this.c, this.b);
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "clear account cache.";
    }
}
