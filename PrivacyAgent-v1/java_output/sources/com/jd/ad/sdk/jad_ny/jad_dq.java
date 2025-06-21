package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public abstract class jad_dq<T extends com.jd.ad.sdk.jad_ny.jad_mz> {
    public final java.util.Queue<T> jad_an = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(20);

    public abstract T jad_an();

    public T jad_bo() {
        T poll = this.jad_an.poll();
        return poll == null ? jad_an() : poll;
    }
}
