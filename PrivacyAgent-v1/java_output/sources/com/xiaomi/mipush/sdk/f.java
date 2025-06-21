package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class f implements com.xiaomi.mipush.sdk.AbstractPushManager {
    private static volatile com.xiaomi.mipush.sdk.f a;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Context f50a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.mipush.sdk.PushConfiguration f51a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f53a = false;

    /* renamed from: a, reason: collision with other field name */
    private java.util.Map<com.xiaomi.mipush.sdk.e, com.xiaomi.mipush.sdk.AbstractPushManager> f52a = new java.util.HashMap();

    private f(android.content.Context context) {
        this.f50a = context.getApplicationContext();
    }

    public static com.xiaomi.mipush.sdk.f a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.mipush.sdk.f.class) {
                if (a == null) {
                    a = new com.xiaomi.mipush.sdk.f(context);
                }
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        com.xiaomi.mipush.sdk.AbstractPushManager a2;
        com.xiaomi.mipush.sdk.e eVar;
        com.xiaomi.mipush.sdk.AbstractPushManager a3;
        com.xiaomi.mipush.sdk.e eVar2;
        com.xiaomi.mipush.sdk.AbstractPushManager a4;
        com.xiaomi.mipush.sdk.e eVar3;
        com.xiaomi.mipush.sdk.AbstractPushManager a5;
        com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration = this.f51a;
        if (pushConfiguration == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f51a.getOpenHmsPush() + " HW online switch : " + com.xiaomi.mipush.sdk.i.m150a(this.f50a, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + com.xiaomi.mipush.sdk.ag.HUAWEI.equals(com.xiaomi.mipush.sdk.n.a(this.f50a)));
            com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        }
        if (this.f51a.getOpenHmsPush()) {
            android.content.Context context = this.f50a;
            com.xiaomi.mipush.sdk.e eVar4 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI;
            if (com.xiaomi.mipush.sdk.i.m150a(context, eVar4) && com.xiaomi.mipush.sdk.ag.HUAWEI.equals(com.xiaomi.mipush.sdk.n.a(this.f50a))) {
                if (!m144a(eVar4)) {
                    a(eVar4, com.xiaomi.mipush.sdk.ak.a(this.f50a, eVar4));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
                if (this.f51a.getOpenFCMPush()) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("ASSEMBLE_PUSH : ");
                    sb2.append(" FCM user switch : " + this.f51a.getOpenFCMPush() + " FCM online switch : " + com.xiaomi.mipush.sdk.i.m150a(this.f50a, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + com.xiaomi.mipush.sdk.n.m154a(this.f50a));
                    com.xiaomi.channel.commonutils.logger.b.a(sb2.toString());
                }
                if (this.f51a.getOpenFCMPush()) {
                    android.content.Context context2 = this.f50a;
                    com.xiaomi.mipush.sdk.e eVar5 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM;
                    if (com.xiaomi.mipush.sdk.i.m150a(context2, eVar5) && com.xiaomi.mipush.sdk.n.m154a(this.f50a)) {
                        if (!m144a(eVar5)) {
                            a(eVar5, com.xiaomi.mipush.sdk.ak.a(this.f50a, eVar5));
                        }
                        com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
                        if (this.f51a.getOpenCOSPush()) {
                            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("ASSEMBLE_PUSH : ");
                            sb3.append(" COS user switch : " + this.f51a.getOpenCOSPush() + " COS online switch : " + com.xiaomi.mipush.sdk.i.m150a(this.f50a, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + com.xiaomi.mipush.sdk.n.b(this.f50a));
                            com.xiaomi.channel.commonutils.logger.b.a(sb3.toString());
                        }
                        if (this.f51a.getOpenCOSPush()) {
                            android.content.Context context3 = this.f50a;
                            com.xiaomi.mipush.sdk.e eVar6 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS;
                            if (com.xiaomi.mipush.sdk.i.m150a(context3, eVar6) && com.xiaomi.mipush.sdk.n.b(this.f50a)) {
                                a(eVar6, com.xiaomi.mipush.sdk.ak.a(this.f50a, eVar6));
                                if (this.f51a.getOpenFTOSPush()) {
                                    android.content.Context context4 = this.f50a;
                                    com.xiaomi.mipush.sdk.e eVar7 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
                                    if (com.xiaomi.mipush.sdk.i.m150a(context4, eVar7) && com.xiaomi.mipush.sdk.n.c(this.f50a)) {
                                        a(eVar7, com.xiaomi.mipush.sdk.ak.a(this.f50a, eVar7));
                                        return;
                                    }
                                }
                                eVar3 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
                                if (m144a(eVar3) || (a5 = a(eVar3)) == null) {
                                    return;
                                }
                                m143a(eVar3);
                                a5.unregister();
                                return;
                            }
                        }
                        eVar2 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS;
                        if (m144a(eVar2) && (a4 = a(eVar2)) != null) {
                            m143a(eVar2);
                            a4.unregister();
                        }
                        if (this.f51a.getOpenFTOSPush()) {
                        }
                        eVar3 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
                        if (m144a(eVar3)) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                eVar = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM;
                if (m144a(eVar) && (a3 = a(eVar)) != null) {
                    m143a(eVar);
                    a3.unregister();
                }
                if (this.f51a.getOpenCOSPush()) {
                }
                if (this.f51a.getOpenCOSPush()) {
                }
                eVar2 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS;
                if (m144a(eVar2)) {
                    m143a(eVar2);
                    a4.unregister();
                }
                if (this.f51a.getOpenFTOSPush()) {
                }
                eVar3 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
                if (m144a(eVar3)) {
                }
            }
        }
        com.xiaomi.mipush.sdk.e eVar8 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI;
        if (m144a(eVar8) && (a2 = a(eVar8)) != null) {
            m143a(eVar8);
            a2.unregister();
        }
        if (this.f51a.getOpenFCMPush()) {
        }
        if (this.f51a.getOpenFCMPush()) {
        }
        eVar = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM;
        if (m144a(eVar)) {
            m143a(eVar);
            a3.unregister();
        }
        if (this.f51a.getOpenCOSPush()) {
        }
        if (this.f51a.getOpenCOSPush()) {
        }
        eVar2 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS;
        if (m144a(eVar2)) {
        }
        if (this.f51a.getOpenFTOSPush()) {
        }
        eVar3 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
        if (m144a(eVar3)) {
        }
    }

    public com.xiaomi.mipush.sdk.AbstractPushManager a(com.xiaomi.mipush.sdk.e eVar) {
        return this.f52a.get(eVar);
    }

    public void a(com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration) {
        this.f51a = pushConfiguration;
        this.f53a = com.xiaomi.push.service.ad.a(this.f50a).a(com.xiaomi.push.gp.AggregatePushSwitch.bw, true);
        if (this.f51a.getOpenHmsPush() || this.f51a.getOpenFCMPush() || this.f51a.getOpenCOSPush() || this.f51a.getOpenFTOSPush()) {
            com.xiaomi.push.service.ad.a(this.f50a).a(new com.xiaomi.mipush.sdk.g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m143a(com.xiaomi.mipush.sdk.e eVar) {
        this.f52a.remove(eVar);
    }

    public void a(com.xiaomi.mipush.sdk.e eVar, com.xiaomi.mipush.sdk.AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f52a.containsKey(eVar)) {
                this.f52a.remove(eVar);
            }
            this.f52a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m144a(com.xiaomi.mipush.sdk.e eVar) {
        return this.f52a.containsKey(eVar);
    }

    public boolean b(com.xiaomi.mipush.sdk.e eVar) {
        int i = com.xiaomi.mipush.sdk.h.a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration = this.f51a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i == 2) {
            com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration2 = this.f51a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i == 3) {
            com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration3 = this.f51a;
            if (pushConfiguration3 != null) {
                z = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i != 4) {
            return false;
        }
        com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration4 = this.f51a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : assemble push register");
        if (this.f52a.size() <= 0) {
            a();
        }
        if (this.f52a.size() > 0) {
            for (com.xiaomi.mipush.sdk.AbstractPushManager abstractPushManager : this.f52a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            com.xiaomi.mipush.sdk.i.m146a(this.f50a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : assemble push unregister");
        for (com.xiaomi.mipush.sdk.AbstractPushManager abstractPushManager : this.f52a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f52a.clear();
    }
}
