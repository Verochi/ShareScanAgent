package com.xiaomi.push;

/* loaded from: classes19.dex */
final class o extends com.xiaomi.push.m.b {
    final /* synthetic */ com.xiaomi.push.m b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(com.xiaomi.push.m mVar, com.xiaomi.push.m.a aVar) {
        super(aVar);
        this.b = mVar;
    }

    @Override // com.xiaomi.push.m.b
    public final void a() {
        java.lang.Object obj;
        java.util.Map map;
        obj = this.b.d;
        synchronized (obj) {
            map = this.b.c;
            map.remove(this.a.a());
        }
    }
}
