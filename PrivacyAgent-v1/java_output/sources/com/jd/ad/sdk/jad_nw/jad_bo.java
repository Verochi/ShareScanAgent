package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_bo {
    public final java.util.List<com.jd.ad.sdk.jad_nw.jad_sf> jad_an = new java.util.ArrayList();

    public void jad_an(android.graphics.Path path) {
        for (int size = this.jad_an.size() - 1; size >= 0; size--) {
            com.jd.ad.sdk.jad_nw.jad_sf jad_sfVar = this.jad_an.get(size);
            java.lang.ThreadLocal<android.graphics.PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
            if (jad_sfVar != null && !jad_sfVar.jad_bo) {
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(path, ((com.jd.ad.sdk.jad_ox.jad_dq) jad_sfVar.jad_er).jad_hu() / 100.0f, ((com.jd.ad.sdk.jad_ox.jad_dq) jad_sfVar.jad_fs).jad_hu() / 100.0f, ((com.jd.ad.sdk.jad_ox.jad_dq) jad_sfVar.jad_jt).jad_hu() / 360.0f);
            }
        }
    }
}
