package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class e extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "idmd5";
    private android.content.Context b;

    public e(android.content.Context context) {
        super("idmd5");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(this.b);
    }
}
