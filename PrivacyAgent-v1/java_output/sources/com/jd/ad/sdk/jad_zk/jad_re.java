package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public class jad_re {
    public final java.util.Set<com.jd.ad.sdk.jad_en.jad_dq> jad_an = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());
    public final java.util.Set<com.jd.ad.sdk.jad_en.jad_dq> jad_bo = new java.util.HashSet();
    public boolean jad_cp;

    public boolean jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z = true;
        if (jad_dqVar == null) {
            return true;
        }
        boolean remove = this.jad_an.remove(jad_dqVar);
        if (!this.jad_bo.remove(jad_dqVar) && !remove) {
            z = false;
        }
        if (z) {
            jad_dqVar.clear();
        }
        return z;
    }

    public java.lang.String toString() {
        return super.toString() + "{numRequests=" + this.jad_an.size() + ", isPaused=" + this.jad_cp + com.alipay.sdk.m.u.i.d;
    }
}
