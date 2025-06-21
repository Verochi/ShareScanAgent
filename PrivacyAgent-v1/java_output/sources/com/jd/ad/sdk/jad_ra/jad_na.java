package com.jd.ad.sdk.jad_ra;

/* loaded from: classes23.dex */
public abstract class jad_na<V, O> implements com.jd.ad.sdk.jad_ra.jad_mz<V, O> {
    public final java.util.List<com.jd.ad.sdk.jad_yh.jad_an<V>> jad_an;

    public jad_na(java.util.List<com.jd.ad.sdk.jad_yh.jad_an<V>> list) {
        this.jad_an = list;
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public java.util.List<com.jd.ad.sdk.jad_yh.jad_an<V>> jad_bo() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public boolean jad_cp() {
        if (this.jad_an.isEmpty()) {
            return true;
        }
        return this.jad_an.size() == 1 && this.jad_an.get(0).jad_cp();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!this.jad_an.isEmpty()) {
            sb.append("values=");
            sb.append(java.util.Arrays.toString(this.jad_an.toArray()));
        }
        return sb.toString();
    }
}
