package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class d extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "idfa";
    private android.content.Context b;

    public d(android.content.Context context) {
        super("idfa");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(this.b);
    }
}
