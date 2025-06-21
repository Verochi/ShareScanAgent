package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_hu {
    public final java.util.List<com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_na, android.graphics.Path>> jad_an;
    public final java.util.List<com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer>> jad_bo;
    public final java.util.List<com.jd.ad.sdk.jad_sb.jad_jt> jad_cp;

    public jad_hu(java.util.List<com.jd.ad.sdk.jad_sb.jad_jt> list) {
        this.jad_cp = list;
        this.jad_an = new java.util.ArrayList(list.size());
        this.jad_bo = new java.util.ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.jad_an.add(list.get(i).jad_an().jad_an());
            this.jad_bo.add(list.get(i).jad_bo().jad_an());
        }
    }

    public java.util.List<com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_na, android.graphics.Path>> jad_an() {
        return this.jad_an;
    }

    public java.util.List<com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer>> jad_bo() {
        return this.jad_bo;
    }
}
