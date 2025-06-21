package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class b extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "android_id";
    private android.content.Context b;

    public b(android.content.Context context) {
        super("android_id");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(this.b);
    }
}
