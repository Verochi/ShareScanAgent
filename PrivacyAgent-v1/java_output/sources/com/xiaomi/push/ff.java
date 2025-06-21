package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ff extends com.xiaomi.push.service.c.j {
    final /* synthetic */ int a;
    final /* synthetic */ java.lang.Exception b;
    final /* synthetic */ com.xiaomi.push.fd c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff(com.xiaomi.push.fd fdVar, int i, java.lang.Exception exc) {
        super(2);
        this.c = fdVar;
        this.a = i;
        this.b = exc;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        this.c.u.a(this.a, this.b);
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "shutdown the connection. " + this.a + ", " + this.b;
    }
}
