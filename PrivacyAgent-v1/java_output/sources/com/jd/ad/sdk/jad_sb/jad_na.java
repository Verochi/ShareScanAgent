package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_na {
    public final java.util.List<com.jd.ad.sdk.jad_qz.jad_an> jad_an;
    public android.graphics.PointF jad_bo;
    public boolean jad_cp;

    public jad_na() {
        this.jad_an = new java.util.ArrayList();
    }

    public jad_na(android.graphics.PointF pointF, boolean z, java.util.List<com.jd.ad.sdk.jad_qz.jad_an> list) {
        this.jad_bo = pointF;
        this.jad_cp = z;
        this.jad_an = new java.util.ArrayList(list);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("ShapeData{numCurves=");
        jad_an.append(this.jad_an.size());
        jad_an.append("closed=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }
}
