package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public final class jad_sf<V> {

    @androidx.annotation.Nullable
    public final V jad_an;

    @androidx.annotation.Nullable
    public final java.lang.Throwable jad_bo;

    public jad_sf(V v) {
        this.jad_an = v;
        this.jad_bo = null;
    }

    public jad_sf(java.lang.Throwable th) {
        this.jad_bo = th;
        this.jad_an = null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.jd.ad.sdk.jad_lu.jad_sf)) {
            return false;
        }
        com.jd.ad.sdk.jad_lu.jad_sf jad_sfVar = (com.jd.ad.sdk.jad_lu.jad_sf) obj;
        V v = this.jad_an;
        if (v != null && v.equals(jad_sfVar.jad_an)) {
            return true;
        }
        java.lang.Throwable th = this.jad_bo;
        if (th == null || jad_sfVar.jad_bo == null) {
            return false;
        }
        return th.toString().equals(this.jad_bo.toString());
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{this.jad_an, this.jad_bo});
    }
}
