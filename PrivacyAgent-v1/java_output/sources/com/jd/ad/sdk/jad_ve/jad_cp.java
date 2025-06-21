package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_cp {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("k");

    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b9, code lost:
    
        if ((r0.jad_an == 1.0f && r0.jad_bo == 1.0f) != false) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.jd.ad.sdk.jad_ra.jad_ly jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        boolean z;
        com.jd.ad.sdk.jad_ra.jad_jt jad_jtVar2;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar;
        boolean z2;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3;
        com.jd.ad.sdk.jad_ra.jad_bo jad_an2;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar4;
        boolean z3 = false;
        boolean z4 = jad_cpVar.jad_mz() == 3;
        if (z4) {
            jad_cpVar.jad_cp();
        }
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar5 = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar6 = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar7 = null;
        com.jd.ad.sdk.jad_ra.jad_er jad_erVar = null;
        com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar = null;
        com.jd.ad.sdk.jad_ra.jad_jt jad_jtVar3 = null;
        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar8 = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar9 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    jad_boVar2 = jad_boVar6;
                    jad_boVar3 = jad_boVar7;
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        if (jad_cpVar.jad_an(jad_bo) != 0) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_erVar = com.jd.ad.sdk.jad_ve.jad_an.jad_an(jad_cpVar, jad_jtVar);
                        }
                    }
                    jad_cpVar.jad_er();
                    jad_boVar6 = jad_boVar2;
                    jad_boVar7 = jad_boVar3;
                    z3 = false;
                    break;
                case 1:
                    jad_mzVar = com.jd.ad.sdk.jad_ve.jad_an.jad_bo(jad_cpVar, jad_jtVar);
                    z3 = false;
                    break;
                case 2:
                    jad_jtVar3 = new com.jd.ad.sdk.jad_ra.jad_jt(com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_ve.jad_fq.jad_an));
                    z3 = false;
                    break;
                case 3:
                    jad_jtVar.jad_an("Lottie doesn't support 3D layers.");
                    jad_an2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    if (jad_an2.jad_an.isEmpty()) {
                        jad_boVar4 = jad_an2;
                        jad_boVar2 = jad_boVar6;
                        jad_boVar3 = jad_boVar7;
                        if (((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar4.jad_an.get(0)).jad_bo == 0) {
                            jad_boVar4.jad_an.set(0, new com.jd.ad.sdk.jad_yh.jad_an(jad_jtVar, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(jad_jtVar.jad_ly)));
                        }
                    } else {
                        jad_boVar4 = jad_an2;
                        jad_boVar2 = jad_boVar6;
                        jad_boVar3 = jad_boVar7;
                        jad_an2.jad_an.add(new com.jd.ad.sdk.jad_yh.jad_an(jad_jtVar, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(jad_jtVar.jad_ly)));
                    }
                    jad_boVar5 = jad_boVar4;
                    jad_boVar6 = jad_boVar2;
                    jad_boVar7 = jad_boVar3;
                    z3 = false;
                    break;
                case 4:
                    jad_an2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    if (jad_an2.jad_an.isEmpty()) {
                    }
                    jad_boVar5 = jad_boVar4;
                    jad_boVar6 = jad_boVar2;
                    jad_boVar7 = jad_boVar3;
                    z3 = false;
                    break;
                case 5:
                    jad_dqVar = com.jd.ad.sdk.jad_ve.jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                    break;
                case 6:
                    jad_boVar8 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    break;
                case 7:
                    jad_boVar9 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    break;
                case 8:
                    jad_boVar7 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    break;
                case 9:
                    jad_boVar6 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, z3);
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    z3 = false;
                    break;
            }
        }
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar10 = jad_boVar6;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar11 = jad_boVar7;
        if (z4) {
            jad_cpVar.jad_er();
        }
        if (jad_erVar == null || (jad_erVar.jad_cp() && jad_erVar.jad_an.get(0).jad_bo.equals(0.0f, 0.0f))) {
            jad_erVar = null;
        }
        com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar2 = jad_mzVar == null || (!(jad_mzVar instanceof com.jd.ad.sdk.jad_ra.jad_iv) && jad_mzVar.jad_cp() && jad_mzVar.jad_bo().get(0).jad_bo.equals(0.0f, 0.0f)) ? null : jad_mzVar;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar12 = jad_boVar5 == null || (jad_boVar5.jad_cp() && (((java.lang.Float) ((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar5.jad_an.get(0)).jad_bo).floatValue() > 0.0f ? 1 : (((java.lang.Float) ((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar5.jad_an.get(0)).jad_bo).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : jad_boVar5;
        if (jad_jtVar3 != null) {
            if (jad_jtVar3.jad_cp()) {
                com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar2 = (com.jd.ad.sdk.jad_yh.jad_dq) ((com.jd.ad.sdk.jad_yh.jad_an) jad_jtVar3.jad_an.get(0)).jad_bo;
            }
            z = false;
            if (z) {
                jad_jtVar2 = jad_jtVar3;
                jad_boVar = jad_boVar11;
            } else {
                jad_boVar = jad_boVar11;
                jad_jtVar2 = null;
            }
            if (jad_boVar != null || (jad_boVar.jad_cp() && ((java.lang.Float) ((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar.jad_an.get(0)).jad_bo).floatValue() == 0.0f)) {
                jad_boVar = null;
            }
            if (jad_boVar10 != null || (jad_boVar10.jad_cp() && ((java.lang.Float) ((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar10.jad_an.get(0)).jad_bo).floatValue() == 0.0f)) {
                z2 = true;
                return new com.jd.ad.sdk.jad_ra.jad_ly(jad_erVar, jad_mzVar2, jad_jtVar2, jad_boVar12, jad_dqVar, jad_boVar8, jad_boVar9, jad_boVar, z2 ? null : jad_boVar10);
            }
            z2 = false;
            return new com.jd.ad.sdk.jad_ra.jad_ly(jad_erVar, jad_mzVar2, jad_jtVar2, jad_boVar12, jad_dqVar, jad_boVar8, jad_boVar9, jad_boVar, z2 ? null : jad_boVar10);
        }
        z = true;
        if (z) {
        }
        if (jad_boVar != null || (jad_boVar.jad_cp() && ((java.lang.Float) ((com.jd.ad.sdk.jad_yh.jad_an) jad_boVar.jad_an.get(0)).jad_bo).floatValue() == 0.0f)) {
        }
        if (jad_boVar10 != null) {
        }
        z2 = true;
        return new com.jd.ad.sdk.jad_ra.jad_ly(jad_erVar, jad_mzVar2, jad_jtVar2, jad_boVar12, jad_dqVar, jad_boVar8, jad_boVar9, jad_boVar, z2 ? null : jad_boVar10);
    }
}
