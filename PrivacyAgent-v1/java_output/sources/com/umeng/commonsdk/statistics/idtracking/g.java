package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class g extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "imei";
    private android.content.Context b;

    public g(android.content.Context context) {
        super("imei");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(this.b);
    }
}
