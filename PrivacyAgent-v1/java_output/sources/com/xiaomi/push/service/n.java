package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class n extends com.xiaomi.push.service.ba.a {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.service.co b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(java.lang.String str, com.xiaomi.push.service.c cVar, com.xiaomi.push.service.co coVar) {
        super(str);
        this.a = cVar;
        this.b = coVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public final void a(com.xiaomi.push.service.ba baVar) {
        com.xiaomi.push.aa a = com.xiaomi.push.aa.a(this.a);
        java.lang.String a2 = baVar.a("MSAID", "msaid");
        java.lang.String str = ((java.lang.String) null) + a.b() + ((java.lang.String) null) + ((java.lang.String) null);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals(a2, str)) {
            return;
        }
        com.xiaomi.push.service.ba.a("MSAID", "msaid", str);
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = this.b.d;
        hkVar.e = com.xiaomi.push.gu.ClientInfoUpdate.ah;
        hkVar.c = com.xiaomi.push.service.ag.a();
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        a.a(hashMap);
        byte[] a3 = com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(this.a.getPackageName(), this.b.d, hkVar, com.xiaomi.push.gk.Notification));
        com.xiaomi.push.service.c cVar = this.a;
        cVar.a(cVar.getPackageName(), a3, true);
    }
}
