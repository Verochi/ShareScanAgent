package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_gr implements com.jd.ad.sdk.jad_ve.jad_mx<com.jd.ad.sdk.jad_sb.jad_na> {
    public static final com.jd.ad.sdk.jad_ve.jad_gr jad_an = new com.jd.ad.sdk.jad_ve.jad_gr();
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("c", "v", "i", "o");

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_sb.jad_na jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
        }
        jad_cpVar.jad_cp();
        java.util.List<android.graphics.PointF> list = null;
        java.util.List<android.graphics.PointF> list2 = null;
        java.util.List<android.graphics.PointF> list3 = null;
        boolean z = false;
        while (jad_cpVar.jad_jt()) {
            int jad_an2 = jad_cpVar.jad_an(jad_bo);
            if (jad_an2 == 0) {
                z = jad_cpVar.jad_hu();
            } else if (jad_an2 == 1) {
                list = com.jd.ad.sdk.jad_ve.jad_sf.jad_bo(jad_cpVar, f);
            } else if (jad_an2 == 2) {
                list2 = com.jd.ad.sdk.jad_ve.jad_sf.jad_bo(jad_cpVar, f);
            } else if (jad_an2 != 3) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                list3 = com.jd.ad.sdk.jad_ve.jad_sf.jad_bo(jad_cpVar, f);
            }
        }
        jad_cpVar.jad_er();
        if (jad_cpVar.jad_mz() == 2) {
            jad_cpVar.jad_dq();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new java.lang.IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new com.jd.ad.sdk.jad_sb.jad_na(new android.graphics.PointF(), false, java.util.Collections.emptyList());
        }
        int size = list.size();
        android.graphics.PointF pointF = list.get(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 1; i < size; i++) {
            android.graphics.PointF pointF2 = list.get(i);
            int i2 = i - 1;
            arrayList.add(new com.jd.ad.sdk.jad_qz.jad_an(com.jd.ad.sdk.jad_xg.jad_jt.jad_an(list.get(i2), list3.get(i2)), com.jd.ad.sdk.jad_xg.jad_jt.jad_an(pointF2, list2.get(i)), pointF2));
        }
        if (z) {
            android.graphics.PointF pointF3 = list.get(0);
            int i3 = size - 1;
            arrayList.add(new com.jd.ad.sdk.jad_qz.jad_an(com.jd.ad.sdk.jad_xg.jad_jt.jad_an(list.get(i3), list3.get(i3)), com.jd.ad.sdk.jad_xg.jad_jt.jad_an(pointF3, list2.get(0)), pointF3));
        }
        return new com.jd.ad.sdk.jad_sb.jad_na(pointF, z, arrayList);
    }
}
