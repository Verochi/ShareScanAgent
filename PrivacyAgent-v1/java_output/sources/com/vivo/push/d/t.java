package com.vivo.push.d;

/* loaded from: classes19.dex */
final class t implements com.vivo.push.d.r.a {
    final /* synthetic */ com.vivo.push.d.s a;

    public t(com.vivo.push.d.s sVar) {
        this.a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        android.content.Context context;
        android.content.Context context2;
        long l = com.vivo.push.e.a().l();
        if (l < 1400 && l != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(java.lang.String.valueOf(l)));
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", java.lang.String.valueOf(this.a.b.f()));
        context = ((com.vivo.push.l) this.a.c).a;
        context2 = ((com.vivo.push.l) this.a.c).a;
        java.lang.String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("app_id", b);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        android.content.Context context;
        android.content.Context context2;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(this.a.b.f()));
        context = ((com.vivo.push.l) this.a.c).a;
        context2 = ((com.vivo.push.l) this.a.c).a;
        java.lang.String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}
