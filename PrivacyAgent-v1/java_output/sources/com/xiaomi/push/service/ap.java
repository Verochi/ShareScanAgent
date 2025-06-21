package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ap implements com.xiaomi.push.di {
    @Override // com.xiaomi.push.di
    public final void a(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = com.xiaomi.push.de.a(context).b;
        hkVar.i = com.xiaomi.push.de.a(context).c;
        hkVar.e = com.xiaomi.push.gu.AwakeAppResponse.ah;
        hkVar.c = com.xiaomi.push.service.ag.a();
        hkVar.h = hashMap;
        byte[] a = com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(hkVar.i, hkVar.d, hkVar, com.xiaomi.push.gk.Notification));
        if (!(context instanceof com.xiaomi.push.service.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("MoleInfo : context is not correct in pushLayer " + hkVar.c);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("MoleInfo : send data directly in pushLayer " + hkVar.c);
            ((com.xiaomi.push.service.c) context).a(context.getPackageName(), a, true);
        }
    }

    @Override // com.xiaomi.push.di
    public final void b(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.gh a = com.xiaomi.push.gh.a(context);
        if (a != null) {
            java.lang.String a2 = com.xiaomi.push.cy.a(hashMap);
            java.lang.String packageName = a.a.getPackageName();
            java.lang.String packageName2 = a.a.getPackageName();
            com.xiaomi.push.go goVar = new com.xiaomi.push.go();
            goVar.g = "category_awake_app";
            goVar.c = "wake_up_app";
            goVar.a(1L);
            goVar.b = a2;
            goVar.a(true);
            goVar.a = "push_sdk_channel";
            goVar.h = packageName2;
            a.a(goVar, packageName);
        }
    }

    @Override // com.xiaomi.push.di
    public final void c(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000" + com.xiaomi.push.cy.b(hashMap));
    }
}
