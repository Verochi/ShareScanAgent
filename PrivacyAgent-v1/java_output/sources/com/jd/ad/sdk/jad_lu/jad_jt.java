package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_jt {
    public java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_tc.jad_er>> jad_cp;
    public java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> jad_dq;
    public java.util.Map<java.lang.String, com.jd.ad.sdk.jad_qz.jad_cp> jad_er;
    public java.util.List<com.jd.ad.sdk.jad_qz.jad_hu> jad_fs;
    public androidx.collection.LongSparseArray<com.jd.ad.sdk.jad_tc.jad_er> jad_hu;
    public java.util.List<com.jd.ad.sdk.jad_tc.jad_er> jad_iv;
    public androidx.collection.SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> jad_jt;
    public android.graphics.Rect jad_jw;
    public float jad_kx;
    public float jad_ly;
    public float jad_mz;
    public boolean jad_na;
    public final com.jd.ad.sdk.jad_lu.jad_vi jad_an = new com.jd.ad.sdk.jad_lu.jad_vi();
    public final java.util.HashSet<java.lang.String> jad_bo = new java.util.HashSet<>();
    public int jad_ob = 0;

    public float jad_an() {
        return (long) ((jad_bo() / this.jad_mz) * 1000.0f);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.jd.ad.sdk.jad_tc.jad_er jad_an(long j) {
        return this.jad_hu.get(j);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an(str);
        this.jad_bo.add(str);
    }

    public float jad_bo() {
        return this.jad_ly - this.jad_kx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r4.substring(0, r4.length() - 1).equalsIgnoreCase(r8) != false) goto L13;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.jd.ad.sdk.jad_qz.jad_hu jad_bo(java.lang.String str) {
        int size = this.jad_fs.size();
        for (int i = 0; i < size; i++) {
            com.jd.ad.sdk.jad_qz.jad_hu jad_huVar = this.jad_fs.get(i);
            boolean z = true;
            if (!jad_huVar.jad_an.equalsIgnoreCase(str)) {
                if (jad_huVar.jad_an.endsWith("\r")) {
                    java.lang.String str2 = jad_huVar.jad_an;
                }
                z = false;
            }
            if (z) {
                return jad_huVar;
            }
        }
        return null;
    }

    public java.util.List<com.jd.ad.sdk.jad_tc.jad_er> jad_cp() {
        return this.jad_iv;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("LottieComposition:\n");
        java.util.Iterator<com.jd.ad.sdk.jad_tc.jad_er> it = this.jad_iv.iterator();
        while (it.hasNext()) {
            sb.append(it.next().jad_an("\t"));
        }
        return sb.toString();
    }
}
