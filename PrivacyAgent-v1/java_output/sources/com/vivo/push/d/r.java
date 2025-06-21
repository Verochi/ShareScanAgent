package com.vivo.push.d;

/* loaded from: classes19.dex */
public final class r extends com.vivo.push.d.z {

    public interface a {
        void a();

        void b();
    }

    public r(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        if (oVar == null) {
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) oVar;
        android.content.Context context = this.a;
        if (!com.vivo.push.util.t.d(context, context.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(qVar.f()));
            android.content.Context context2 = this.a;
            java.lang.String b = com.vivo.push.util.z.b(context2, context2.getPackageName());
            if (!android.text.TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return;
        }
        com.vivo.push.e.a().a(new com.vivo.push.b.h(java.lang.String.valueOf(qVar.f())));
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(qVar.f()));
            android.content.Context context3 = this.a;
            java.lang.String b2 = com.vivo.push.util.z.b(context3, context3.getPackageName());
            if (!android.text.TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            com.vivo.push.e.a().a(xVar2);
            return;
        }
        if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.a), qVar.e(), qVar.i())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            java.util.HashMap<java.lang.String, java.lang.String> hashMap3 = new java.util.HashMap<>();
            hashMap3.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(qVar.f()));
            android.content.Context context4 = this.a;
            java.lang.String b3 = com.vivo.push.util.z.b(context4, context4.getPackageName());
            if (!android.text.TextUtils.isEmpty(b3)) {
                hashMap3.put("remoteAppId", b3);
            }
            xVar3.a(hashMap3);
            com.vivo.push.e.a().a(xVar3);
            return;
        }
        com.vivo.push.model.InsideNotificationItem d = qVar.d();
        if (d == null) {
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.p.c(this.a, "通知内容为空，" + qVar.f());
            com.vivo.push.util.e.a(this.a, qVar.f(), 1027L);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + d.getTargetType() + " ; target is " + d.getTragetContent());
        com.vivo.push.m.c(new com.vivo.push.d.s(this, d, qVar));
    }
}
