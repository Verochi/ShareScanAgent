package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cu extends com.xiaomi.push.ct {
    public cu(android.content.Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
    }

    @Override // com.xiaomi.push.ct
    public final java.lang.String b() {
        return "ram:" + com.xiaomi.push.ib.b() + ",rom:" + com.xiaomi.push.ib.c() + "|ramOriginal:" + com.xiaomi.push.ib.d() + ",romOriginal:" + com.xiaomi.push.ib.e();
    }

    @Override // com.xiaomi.push.ct
    public final com.xiaomi.push.gm c() {
        return com.xiaomi.push.gm.Storage;
    }
}
