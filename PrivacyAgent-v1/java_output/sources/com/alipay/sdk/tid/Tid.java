package com.alipay.sdk.tid;

/* loaded from: classes.dex */
public class Tid {
    public final java.lang.String key;
    public final java.lang.String tid;
    public final long time;

    public Tid(java.lang.String str, java.lang.String str2, long j) {
        this.tid = str;
        this.key = str2;
        this.time = j;
    }

    public static boolean isEmpty(com.alipay.sdk.tid.Tid tid) {
        return tid == null || android.text.TextUtils.isEmpty(tid.tid);
    }

    public java.lang.String getTid() {
        return this.tid;
    }

    public java.lang.String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }
}
