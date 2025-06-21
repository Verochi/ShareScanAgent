package com.vivo.push.d;

/* loaded from: classes19.dex */
final class p extends com.vivo.push.d.z {
    public p(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.o oVar2 = (com.vivo.push.b.o) oVar;
        com.vivo.push.e.a().a(new com.vivo.push.b.h(java.lang.String.valueOf(oVar2.f())));
        if (!com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1020L);
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(oVar2.f()));
            android.content.Context context = this.a;
            java.lang.String b = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!android.text.TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return;
        }
        if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.a), oVar2.d(), oVar2.i())) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(oVar2.f()));
            android.content.Context context2 = this.a;
            java.lang.String b2 = com.vivo.push.util.z.b(context2, context2.getPackageName());
            if (!android.text.TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            com.vivo.push.e.a().a(xVar2);
            return;
        }
        com.vivo.push.model.UnvarnishedMessage e = oVar2.e();
        if (e == null) {
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
            return;
        }
        com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + e.getTargetType() + " ; target is " + e.getTragetContent());
        com.vivo.push.m.b(new com.vivo.push.d.q(this, e));
    }
}
