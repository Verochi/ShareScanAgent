package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class aw implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f39a;

    public aw(android.content.Context context, boolean z) {
        this.a = context;
        this.f39a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String d;
        java.lang.String d2;
        java.util.Map<java.lang.String, java.lang.String> map;
        java.lang.String d3;
        java.lang.String str;
        java.lang.String c;
        java.lang.String c2;
        com.xiaomi.channel.commonutils.logger.b.a("do sync info");
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk(com.xiaomi.push.service.ag.a(), false);
        com.xiaomi.mipush.sdk.b m126a = com.xiaomi.mipush.sdk.b.m126a(this.a);
        hkVar.e = com.xiaomi.push.gu.SyncInfo.ah;
        hkVar.d = m126a.m127a();
        hkVar.i = this.a.getPackageName();
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        android.content.Context context = this.a;
        com.xiaomi.push.iv.a(hashMap, "app_version", com.xiaomi.push.ga.a(context, context.getPackageName()));
        java.util.Map<java.lang.String, java.lang.String> map2 = hkVar.h;
        android.content.Context context2 = this.a;
        com.xiaomi.push.iv.a(map2, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, java.lang.Integer.toString(com.xiaomi.push.ga.b(context2, context2.getPackageName())));
        com.xiaomi.push.iv.a(hkVar.h, "push_sdk_vn", "4_9_0");
        com.xiaomi.push.iv.a(hkVar.h, "push_sdk_vc", java.lang.Integer.toString(40090));
        com.xiaomi.push.iv.a(hkVar.h, "token", m126a.b());
        if (!com.xiaomi.push.iu.f()) {
            java.lang.String a = com.xiaomi.push.ao.a(com.xiaomi.push.ib.c(this.a));
            java.lang.String e = com.xiaomi.push.ib.e(this.a);
            if (!android.text.TextUtils.isEmpty(e)) {
                a = a + "," + e;
            }
            if (!android.text.TextUtils.isEmpty(a)) {
                com.xiaomi.push.iv.a(hkVar.h, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.aa.a(this.a).a(hkVar.h);
        com.xiaomi.push.iv.a(hkVar.h, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_REG_ID, m126a.m134c());
        com.xiaomi.push.iv.a(hkVar.h, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_REG_SECRET, m126a.d());
        com.xiaomi.push.iv.a(hkVar.h, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME, com.xiaomi.mipush.sdk.MiPushClient.getAcceptTime(this.a).replace(",", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f39a) {
            java.util.Map<java.lang.String, java.lang.String> map3 = hkVar.h;
            c = com.xiaomi.mipush.sdk.av.c(com.xiaomi.mipush.sdk.MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.iv.a(map3, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ALIASES_MD5, c);
            java.util.Map<java.lang.String, java.lang.String> map4 = hkVar.h;
            c2 = com.xiaomi.mipush.sdk.av.c(com.xiaomi.mipush.sdk.MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.iv.a(map4, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOPICS_MD5, c2);
            map = hkVar.h;
            d3 = com.xiaomi.mipush.sdk.av.c(com.xiaomi.mipush.sdk.MiPushClient.getAllUserAccount(this.a));
            str = com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            java.util.Map<java.lang.String, java.lang.String> map5 = hkVar.h;
            d = com.xiaomi.mipush.sdk.av.d(com.xiaomi.mipush.sdk.MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.iv.a(map5, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ALIASES, d);
            java.util.Map<java.lang.String, java.lang.String> map6 = hkVar.h;
            d2 = com.xiaomi.mipush.sdk.av.d(com.xiaomi.mipush.sdk.MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.iv.a(map6, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOPICS, d2);
            map = hkVar.h;
            d3 = com.xiaomi.mipush.sdk.av.d(com.xiaomi.mipush.sdk.MiPushClient.getAllUserAccount(this.a));
            str = com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.iv.a(map, str, d3);
        com.xiaomi.mipush.sdk.ao.a(this.a).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
    }
}
