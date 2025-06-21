package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class cn extends com.xiaomi.push.service.c.j {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ java.util.List b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.xiaomi.push.service.cm d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(com.xiaomi.push.service.cm cmVar, java.lang.String str, java.util.List list, java.lang.String str2) {
        super(4);
        this.d = cmVar;
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.service.cm cmVar = this.d;
        java.lang.String str = this.a;
        java.lang.String string = "com.xiaomi.xmsf".equals(str) ? "1000271" : cmVar.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
        java.util.ArrayList<com.xiaomi.push.hk> a = com.xiaomi.push.service.bc.a((java.util.List<com.xiaomi.push.go>) this.b, this.a, string, 32768);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        java.util.Iterator<com.xiaomi.push.hk> it = a.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.hk next = it.next();
            next.a("uploadWay", "longXMPushService");
            com.xiaomi.push.hh a2 = com.xiaomi.push.service.l.a(this.a, string, next, com.xiaomi.push.gk.Notification);
            if (!android.text.TextUtils.isEmpty(this.c) && !android.text.TextUtils.equals(this.a, this.c)) {
                if (a2.h == null) {
                    com.xiaomi.push.gx gxVar = new com.xiaomi.push.gx();
                    gxVar.a = "-1";
                    a2.h = gxVar;
                }
                com.xiaomi.push.gx gxVar2 = a2.h;
                java.lang.String str2 = this.c;
                if (gxVar2.k == null) {
                    gxVar2.k = new java.util.HashMap();
                }
                gxVar2.k.put("ext_traffic_source_pkg", str2);
            }
            this.d.a.a(this.a, com.xiaomi.push.hv.a(a2), true);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "Send tiny data.";
    }
}
