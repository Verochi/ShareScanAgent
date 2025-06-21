package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_an {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("k", "x", "y");

    public static com.jd.ad.sdk.jad_ra.jad_er jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            while (jad_cpVar.jad_jt()) {
                arrayList.add(new com.jd.ad.sdk.jad_ox.jad_iv(jad_jtVar, com.jd.ad.sdk.jad_ve.jad_tg.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), com.jd.ad.sdk.jad_ve.jad_yl.jad_an, jad_cpVar.jad_mz() == 3, false)));
            }
            jad_cpVar.jad_dq();
            com.jd.ad.sdk.jad_ve.jad_uh.jad_an(arrayList);
        } else {
            arrayList.add(new com.jd.ad.sdk.jad_yh.jad_an(com.jd.ad.sdk.jad_ve.jad_sf.jad_an(jad_cpVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an())));
        }
        return new com.jd.ad.sdk.jad_ra.jad_er(arrayList);
    }

    public static com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        jad_cpVar.jad_cp();
        com.jd.ad.sdk.jad_ra.jad_er jad_erVar = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2 = null;
        boolean z = false;
        while (jad_cpVar.jad_mz() != 4) {
            int jad_an2 = jad_cpVar.jad_an(jad_an);
            if (jad_an2 == 0) {
                jad_erVar = jad_an(jad_cpVar, jad_jtVar);
            } else if (jad_an2 != 1) {
                if (jad_an2 != 2) {
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                } else if (jad_cpVar.jad_mz() == 6) {
                    jad_cpVar.jad_ob();
                    z = true;
                } else {
                    jad_boVar2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                }
            } else if (jad_cpVar.jad_mz() == 6) {
                jad_cpVar.jad_ob();
                z = true;
            } else {
                jad_boVar = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
            }
        }
        jad_cpVar.jad_er();
        if (z) {
            jad_jtVar.jad_an("Lottie doesn't support expressions.");
        }
        return jad_erVar != null ? jad_erVar : new com.jd.ad.sdk.jad_ra.jad_iv(jad_boVar, jad_boVar2);
    }
}
