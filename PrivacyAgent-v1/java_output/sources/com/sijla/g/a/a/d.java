package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class d implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ com.sijla.g.a.a.c b;

    public d(com.sijla.g.a.a.c cVar, android.content.Context context) {
        this.b = cVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.sijla.g.a.a.c.a aVar;
        com.sijla.g.a.a.c.a aVar2;
        com.sijla.g.a.a.c.a aVar3;
        com.sijla.g.a.a.c.a aVar4;
        com.sijla.g.a.a.c.a aVar5;
        com.sijla.g.a.a.c.a aVar6;
        com.sijla.g.a.a.c.a aVar7;
        java.lang.String str = android.os.Build.MANUFACTURER;
        if ("ASUS".equals(str.toUpperCase().toUpperCase())) {
            com.sijla.g.a.a.a aVar8 = new com.sijla.g.a.a.a(this.a);
            aVar7 = this.b.a;
            aVar8.a(aVar7);
            return;
        }
        if ("HUAWEI".equals(str.toUpperCase().toUpperCase())) {
            com.sijla.g.a.a.e eVar = new com.sijla.g.a.a.e(this.a);
            aVar6 = this.b.a;
            eVar.a(aVar6);
            return;
        }
        if (com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT.equals(str.toUpperCase().toUpperCase())) {
            com.sijla.g.a.a.m mVar = new com.sijla.g.a.a.m(this.a);
            aVar5 = this.b.a;
            mVar.a(aVar5);
            return;
        }
        if ("ONEPLUS".equals(str.toUpperCase().toUpperCase())) {
            com.sijla.g.a.a.k kVar = new com.sijla.g.a.a.k(this.a);
            aVar4 = this.b.a;
            kVar.a(aVar4);
            return;
        }
        if ("ZTE".equals(str.toUpperCase().toUpperCase())) {
            com.sijla.g.a.a.r rVar = new com.sijla.g.a.a.r(this.a);
            aVar3 = this.b.a;
            rVar.a(aVar3);
        } else if ("FERRMEOS".equals(str.toUpperCase().toUpperCase()) || com.sijla.g.a.a.c.a()) {
            com.sijla.g.a.a.r rVar2 = new com.sijla.g.a.a.r(this.a);
            aVar = this.b.a;
            rVar2.a(aVar);
        } else if ("SSUI".equals(str.toUpperCase().toUpperCase()) || com.sijla.g.a.a.c.b()) {
            com.sijla.g.a.a.r rVar3 = new com.sijla.g.a.a.r(this.a);
            aVar2 = this.b.a;
            rVar3.a(aVar2);
        }
    }
}
