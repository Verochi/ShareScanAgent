package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class m extends com.xiaomi.push.service.ba.a {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.service.co b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(java.lang.String str, com.xiaomi.push.service.c cVar, com.xiaomi.push.service.co coVar) {
        super(str);
        this.a = cVar;
        this.b = coVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public final void a(com.xiaomi.push.service.ba baVar) {
        java.lang.String a = baVar.a("GAID", "gaid");
        java.lang.String b = com.xiaomi.push.ib.b(this.a);
        if (android.text.TextUtils.isEmpty(b) || android.text.TextUtils.equals(a, b)) {
            return;
        }
        com.xiaomi.push.service.ba.a("GAID", "gaid", b);
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = this.b.d;
        hkVar.e = com.xiaomi.push.gu.ClientInfoUpdate.ah;
        hkVar.c = com.xiaomi.push.service.ag.a();
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        hashMap.put("gaid", b);
        byte[] a2 = com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(this.a.getPackageName(), this.b.d, hkVar, com.xiaomi.push.gk.Notification));
        com.xiaomi.push.service.c cVar = this.a;
        cVar.a(cVar.getPackageName(), a2, true);
    }
}
