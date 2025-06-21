package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class q extends com.xiaomi.push.service.ad.a {
    final /* synthetic */ android.content.Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, java.lang.String str, android.content.Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ad.a
    public final void onCallback() {
        com.xiaomi.push.de.a(this.a).d = com.xiaomi.push.service.ad.a(this.a).a(com.xiaomi.push.gp.AwakeInfoUploadWaySwitch.bw, 0);
    }
}
