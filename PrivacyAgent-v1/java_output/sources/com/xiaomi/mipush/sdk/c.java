package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class c implements com.xiaomi.push.di {
    @Override // com.xiaomi.push.di
    public void a(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = com.xiaomi.push.de.a(context).b;
        hkVar.i = com.xiaomi.push.de.a(context).c;
        hkVar.e = com.xiaomi.push.gu.AwakeAppResponse.ah;
        hkVar.c = com.xiaomi.push.service.ag.a();
        hkVar.h = hashMap;
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, true, (com.xiaomi.push.gx) null, true);
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.di
    public void b(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.mipush.sdk.MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, com.xiaomi.push.cy.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.di
    public void c(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000" + com.xiaomi.push.cy.b(hashMap));
        java.lang.String str = hashMap.get(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE);
        java.lang.String str2 = hashMap.get("awake_info");
        if ("1007".equals(str)) {
            com.xiaomi.mipush.sdk.o.a(context, str2);
        }
    }
}
