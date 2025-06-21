package com.alipay.android.app.helper;

/* loaded from: classes.dex */
public class Tid extends com.alipay.sdk.tid.Tid {
    public Tid(java.lang.String str, java.lang.String str2, long j) {
        super(str, str2, j);
    }

    public static com.alipay.android.app.helper.Tid fromRealTidModel(com.alipay.sdk.tid.Tid tid) {
        if (tid == null) {
            return null;
        }
        return new com.alipay.android.app.helper.Tid(tid.getTid(), tid.getTidSeed(), tid.getTimestamp());
    }
}
