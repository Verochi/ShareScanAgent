package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class r implements com.xiaomi.push.cn {
    private android.content.Context a;

    public r(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.cn
    public java.lang.String a() {
        return com.xiaomi.mipush.sdk.b.m126a(this.a).d();
    }

    @Override // com.xiaomi.push.cn
    public void a(com.xiaomi.push.hk hkVar, com.xiaomi.push.gk gkVar, com.xiaomi.push.gx gxVar) {
        com.xiaomi.mipush.sdk.ao.a(this.a).a((com.xiaomi.mipush.sdk.ao) hkVar, gkVar, gxVar);
    }
}
