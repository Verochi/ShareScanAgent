package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class j extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "serial";

    public j() {
        super(a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    @android.annotation.TargetApi(9)
    public java.lang.String f() {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getSerial();
    }
}
