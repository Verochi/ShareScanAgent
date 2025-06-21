package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_uh {
    public static com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("k");

    public static <T> java.util.List<com.jd.ad.sdk.jad_yh.jad_an<T>> jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, float f, com.jd.ad.sdk.jad_ve.jad_mx<T> jad_mxVar, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jad_cpVar.jad_mz() == 6) {
            jad_jtVar.jad_an("Lottie doesn't support expressions.");
            return arrayList;
        }
        jad_cpVar.jad_cp();
        while (jad_cpVar.jad_jt()) {
            if (jad_cpVar.jad_an(jad_an) != 0) {
                jad_cpVar.jad_ob();
            } else if (jad_cpVar.jad_mz() == 1) {
                jad_cpVar.jad_bo();
                if (jad_cpVar.jad_mz() == 7) {
                    arrayList.add(com.jd.ad.sdk.jad_ve.jad_tg.jad_an(jad_cpVar, jad_jtVar, f, jad_mxVar, false, z));
                } else {
                    while (jad_cpVar.jad_jt()) {
                        arrayList.add(com.jd.ad.sdk.jad_ve.jad_tg.jad_an(jad_cpVar, jad_jtVar, f, jad_mxVar, true, z));
                    }
                }
                jad_cpVar.jad_dq();
            } else {
                arrayList.add(com.jd.ad.sdk.jad_ve.jad_tg.jad_an(jad_cpVar, jad_jtVar, f, jad_mxVar, false, z));
            }
        }
        jad_cpVar.jad_er();
        jad_an(arrayList);
        return arrayList;
    }

    public static <T> void jad_an(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = list.get(i2);
            i2++;
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = list.get(i2);
            jad_anVar.jad_hu = java.lang.Float.valueOf(jad_anVar2.jad_jt);
            if (jad_anVar.jad_cp == null && (t = jad_anVar2.jad_bo) != null) {
                jad_anVar.jad_cp = t;
                if (jad_anVar instanceof com.jd.ad.sdk.jad_ox.jad_iv) {
                    ((com.jd.ad.sdk.jad_ox.jad_iv) jad_anVar).jad_dq();
                }
            }
        }
        com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar3 = list.get(i);
        if ((jad_anVar3.jad_bo == null || jad_anVar3.jad_cp == null) && list.size() > 1) {
            list.remove(jad_anVar3);
        }
    }
}
