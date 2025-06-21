package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class g extends com.xiaomi.push.service.ad.a {
    final /* synthetic */ com.xiaomi.mipush.sdk.f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.xiaomi.mipush.sdk.f fVar, int i, java.lang.String str) {
        super(i, str);
        this.a = fVar;
    }

    @Override // com.xiaomi.push.service.ad.a
    public void onCallback() {
        android.content.Context context;
        boolean z;
        android.content.Context context2;
        context = this.a.f50a;
        boolean a = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.AggregatePushSwitch.bw, true);
        z = this.a.f53a;
        if (z != a) {
            this.a.f53a = a;
            context2 = this.a.f50a;
            com.xiaomi.mipush.sdk.i.b(context2);
        }
    }
}
