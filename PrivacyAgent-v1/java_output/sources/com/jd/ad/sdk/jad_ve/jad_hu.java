package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_hu {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(com.alipay.sdk.m.s.a.f86s, "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x070a A[LOOP:1: B:26:0x0704->B:28:0x070a, LOOP_END] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.jd.ad.sdk.jad_sb.jad_cp jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar;
        java.lang.String str;
        char c;
        com.jd.ad.sdk.jad_sb.jad_cp jad_boVar;
        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar2;
        java.lang.String str2;
        com.jd.ad.sdk.jad_sb.jad_cp jad_pcVar;
        java.lang.String str3;
        java.lang.String str4;
        char c2;
        jad_cpVar.jad_cp();
        int i = 2;
        while (true) {
            jad_dqVar = null;
            jad_boVar = null;
            str4 = null;
            str3 = null;
            str2 = null;
            jad_dqVar2 = null;
            if (!jad_cpVar.jad_jt()) {
                str = null;
                break;
            }
            int jad_an2 = jad_cpVar.jad_an(jad_an);
            if (jad_an2 == 0) {
                str = jad_cpVar.jad_ly();
                break;
            }
            if (jad_an2 != 1) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                i = jad_cpVar.jad_jw();
            }
        }
        if (str == null) {
            return null;
        }
        boolean z = false;
        int i2 = 0;
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals(com.anythink.core.common.h.c.R)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals(com.anythink.expressad.foundation.d.d.t)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar = com.jd.ad.sdk.jad_ve.jad_fs.jad_an;
                boolean z2 = i == 3;
                java.lang.String str5 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar = null;
                boolean z3 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an3 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_fs.jad_an);
                    if (jad_an3 == 0) {
                        str5 = jad_cpVar.jad_ly();
                    } else if (jad_an3 == 1) {
                        jad_mzVar = com.jd.ad.sdk.jad_ve.jad_an.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (jad_an3 == 2) {
                        jad_fsVar = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                    } else if (jad_an3 == 3) {
                        z3 = jad_cpVar.jad_hu();
                    } else if (jad_an3 != 4) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        z2 = jad_cpVar.jad_jw() == 3;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_bo(str5, jad_mzVar, jad_fsVar, z2, z3);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 1:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar2 = com.jd.ad.sdk.jad_ve.jad_hs.jad_an;
                java.lang.String str6 = null;
                com.jd.ad.sdk.jad_ra.jad_an jad_anVar3 = null;
                int i3 = 1;
                boolean z4 = false;
                boolean z5 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an4 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_hs.jad_an);
                    if (jad_an4 == 0) {
                        str6 = jad_cpVar.jad_ly();
                    } else if (jad_an4 == 1) {
                        jad_anVar3 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar);
                    } else if (jad_an4 == 2) {
                        jad_dqVar = com.jd.ad.sdk.jad_ve.jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (jad_an4 == 3) {
                        z4 = jad_cpVar.jad_hu();
                    } else if (jad_an4 == 4) {
                        i3 = jad_cpVar.jad_jw();
                    } else if (jad_an4 != 5) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        z5 = jad_cpVar.jad_hu();
                    }
                }
                if (jad_dqVar == null) {
                    jad_dqVar = new com.jd.ad.sdk.jad_ra.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100)));
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_ob(str6, z4, i3 == 1 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD, jad_anVar3, jad_dqVar, z5);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 2:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar4 = com.jd.ad.sdk.jad_ve.jad_pc.jad_an;
                android.graphics.Path.FillType fillType = android.graphics.Path.FillType.WINDING;
                java.lang.String str7 = null;
                com.jd.ad.sdk.jad_ra.jad_cp jad_cpVar2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar3 = null;
                int i4 = 0;
                boolean z6 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_pc.jad_an)) {
                        case 0:
                            str7 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_cpVar.jad_cp();
                            int i5 = -1;
                            while (jad_cpVar.jad_jt()) {
                                int jad_an5 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_pc.jad_bo);
                                if (jad_an5 == 0) {
                                    i5 = jad_cpVar.jad_jw();
                                } else if (jad_an5 != 1) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    jad_cpVar2 = new com.jd.ad.sdk.jad_ra.jad_cp(com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, new com.jd.ad.sdk.jad_ve.jad_ob(i5)));
                                }
                            }
                            jad_cpVar.jad_er();
                            break;
                        case 2:
                            jad_dqVar2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 3:
                            if (jad_cpVar.jad_jw() != 1) {
                                i4 = 2;
                                break;
                            } else {
                                i4 = 1;
                                break;
                            }
                        case 4:
                            jad_fsVar2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 5:
                            jad_fsVar3 = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 6:
                            if (jad_cpVar.jad_jw() != 1) {
                                fillType = android.graphics.Path.FillType.EVEN_ODD;
                                break;
                            } else {
                                fillType = android.graphics.Path.FillType.WINDING;
                                break;
                            }
                        case 7:
                            z6 = jad_cpVar.jad_hu();
                            break;
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_er(str7, i4, fillType, jad_cpVar2, jad_dqVar2 == null ? new com.jd.ad.sdk.jad_ra.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVar2, jad_fsVar2, jad_fsVar3, null, null, z6);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 3:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar5 = com.jd.ad.sdk.jad_ve.jad_it.jad_an;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (jad_cpVar.jad_jt()) {
                    int jad_an6 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_it.jad_an);
                    if (jad_an6 == 0) {
                        str2 = jad_cpVar.jad_ly();
                    } else if (jad_an6 == 1) {
                        z = jad_cpVar.jad_hu();
                    } else if (jad_an6 != 2) {
                        jad_cpVar.jad_ob();
                    } else {
                        jad_cpVar.jad_bo();
                        while (jad_cpVar.jad_jt()) {
                            com.jd.ad.sdk.jad_sb.jad_cp jad_an7 = jad_an(jad_cpVar, jad_jtVar);
                            if (jad_an7 != null) {
                                arrayList.add(jad_an7);
                            }
                        }
                        jad_cpVar.jad_dq();
                    }
                }
                jad_pcVar = new com.jd.ad.sdk.jad_sb.jad_pc(str2, arrayList, z);
                jad_boVar = jad_pcVar;
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 4:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar6 = com.jd.ad.sdk.jad_ve.jad_qd.jad_an;
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar3 = null;
                java.lang.String str8 = null;
                com.jd.ad.sdk.jad_ra.jad_cp jad_cpVar3 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar4 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar5 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3 = null;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                float f = 0.0f;
                boolean z7 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_qd.jad_an)) {
                        case 0:
                            str8 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_cpVar.jad_cp();
                            int i9 = -1;
                            while (jad_cpVar.jad_jt()) {
                                int jad_an8 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_qd.jad_bo);
                                if (jad_an8 == 0) {
                                    i9 = jad_cpVar.jad_jw();
                                } else if (jad_an8 != 1) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    jad_cpVar3 = new com.jd.ad.sdk.jad_ra.jad_cp(com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, new com.jd.ad.sdk.jad_ve.jad_ob(i9)));
                                }
                            }
                            jad_cpVar.jad_er();
                            break;
                        case 2:
                            jad_dqVar3 = com.jd.ad.sdk.jad_ve.jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 3:
                            if (jad_cpVar.jad_jw() != 1) {
                                i6 = 2;
                                break;
                            } else {
                                i6 = 1;
                                break;
                            }
                        case 4:
                            jad_fsVar4 = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 5:
                            jad_fsVar5 = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 6:
                            jad_boVar2 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 7:
                            i7 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 8:
                            i8 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 9:
                            f = (float) jad_cpVar.jad_iv();
                            break;
                        case 10:
                            z7 = jad_cpVar.jad_hu();
                            break;
                        case 11:
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar4 = null;
                                java.lang.String str9 = null;
                                while (jad_cpVar.jad_jt()) {
                                    int jad_an9 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_qd.jad_cp);
                                    if (jad_an9 == 0) {
                                        str9 = jad_cpVar.jad_ly();
                                    } else if (jad_an9 != 1) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_boVar4 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                    }
                                }
                                jad_cpVar.jad_er();
                                if (str9.equals("o")) {
                                    jad_boVar3 = jad_boVar4;
                                } else if (str9.equals("d") || str9.equals("g")) {
                                    jad_jtVar.jad_na = true;
                                    arrayList2.add(jad_boVar4);
                                }
                            }
                            jad_cpVar.jad_dq();
                            if (arrayList2.size() != 1) {
                                break;
                            } else {
                                arrayList2.add((com.jd.ad.sdk.jad_ra.jad_bo) arrayList2.get(0));
                                break;
                            }
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_fs(str8, i6, jad_cpVar3, jad_dqVar3 == null ? new com.jd.ad.sdk.jad_ra.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVar3, jad_fsVar4, jad_fsVar5, jad_boVar2, i7, i8, f, arrayList2, jad_boVar3, z7);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 5:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar7 = com.jd.ad.sdk.jad_ve.jad_xk.jad_an;
                boolean z8 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an10 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_xk.jad_an);
                    if (jad_an10 == 0) {
                        str3 = jad_cpVar.jad_ly();
                    } else if (jad_an10 == 1) {
                        int jad_jw = jad_cpVar.jad_jw();
                        i2 = jad_jw != 2 ? jad_jw != 3 ? jad_jw != 4 ? jad_jw != 5 ? 1 : 5 : 4 : 3 : 2;
                    } else if (jad_an10 != 2) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        z8 = jad_cpVar.jad_hu();
                    }
                }
                com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_sb.jad_iv(str3, i2, z8);
                jad_jtVar.jad_an("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                jad_boVar = jad_ivVar;
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 6:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar8 = com.jd.ad.sdk.jad_ve.jad_do.jad_an;
                java.lang.String str10 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar6 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar5 = null;
                boolean z9 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an11 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_do.jad_an);
                    if (jad_an11 == 0) {
                        str10 = jad_cpVar.jad_ly();
                    } else if (jad_an11 == 1) {
                        jad_mzVar2 = com.jd.ad.sdk.jad_ve.jad_an.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (jad_an11 == 2) {
                        jad_fsVar6 = com.jd.ad.sdk.jad_ve.jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                    } else if (jad_an11 == 3) {
                        jad_boVar5 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                    } else if (jad_an11 != 4) {
                        jad_cpVar.jad_ob();
                    } else {
                        z9 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_ly(str10, jad_mzVar2, jad_fsVar6, jad_boVar5, z9);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 7:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar9 = com.jd.ad.sdk.jad_ve.jad_ep.jad_an;
                java.lang.String str11 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar6 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar7 = null;
                com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar = null;
                boolean z10 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an12 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_ep.jad_an);
                    if (jad_an12 == 0) {
                        str11 = jad_cpVar.jad_ly();
                    } else if (jad_an12 == 1) {
                        jad_boVar6 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (jad_an12 == 2) {
                        jad_boVar7 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (jad_an12 == 3) {
                        jad_lyVar = com.jd.ad.sdk.jad_ve.jad_cp.jad_an(jad_cpVar, jad_jtVar);
                    } else if (jad_an12 != 4) {
                        jad_cpVar.jad_ob();
                    } else {
                        z10 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_mz(str11, jad_boVar6, jad_boVar7, jad_lyVar, z10);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case '\b':
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar10 = com.jd.ad.sdk.jad_ve.jad_ju.jad_an;
                com.jd.ad.sdk.jad_ra.jad_hu jad_huVar = null;
                int i10 = 0;
                boolean z11 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an13 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_ju.jad_an);
                    if (jad_an13 == 0) {
                        str4 = jad_cpVar.jad_ly();
                    } else if (jad_an13 == 1) {
                        i10 = jad_cpVar.jad_jw();
                    } else if (jad_an13 == 2) {
                        jad_huVar = new com.jd.ad.sdk.jad_ra.jad_hu(com.jd.ad.sdk.jad_ve.jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), com.jd.ad.sdk.jad_ve.jad_gr.jad_an, false));
                    } else if (jad_an13 != 3) {
                        jad_cpVar.jad_ob();
                    } else {
                        z11 = jad_cpVar.jad_hu();
                    }
                }
                jad_pcVar = new com.jd.ad.sdk.jad_sb.jad_qd(str4, i10, jad_huVar, z11);
                jad_boVar = jad_pcVar;
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case '\t':
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar11 = com.jd.ad.sdk.jad_ve.jad_cn.jad_an;
                java.lang.String str12 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar8 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar3 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar9 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar10 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar11 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar12 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar13 = null;
                int i11 = 0;
                boolean z12 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_cn.jad_an)) {
                        case 0:
                            str12 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            int jad_jw2 = jad_cpVar.jad_jw();
                            int[] jad_bo = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(2);
                            int length = jad_bo.length;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= length) {
                                    i11 = 0;
                                    break;
                                } else {
                                    i11 = jad_bo[i12];
                                    if (com.jd.ad.sdk.jad_sb.jad_jw.jad_an(i11) == jad_jw2) {
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            break;
                        case 2:
                            jad_boVar8 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 3:
                            jad_mzVar3 = com.jd.ad.sdk.jad_ve.jad_an.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 4:
                            jad_boVar9 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 5:
                            jad_boVar11 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 6:
                            jad_boVar13 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 7:
                            jad_boVar10 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 8:
                            jad_boVar12 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 9:
                            z12 = jad_cpVar.jad_hu();
                            break;
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_kx(str12, i11, jad_boVar8, jad_mzVar3, jad_boVar9, jad_boVar10, jad_boVar11, jad_boVar12, jad_boVar13, z12);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case '\n':
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar12 = com.jd.ad.sdk.jad_ve.jad_kv.jad_an;
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar4 = null;
                java.lang.String str13 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar14 = null;
                com.jd.ad.sdk.jad_ra.jad_an jad_anVar13 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar15 = null;
                int i13 = 0;
                int i14 = 0;
                float f2 = 0.0f;
                boolean z13 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_kv.jad_an)) {
                        case 0:
                            str13 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_anVar13 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar);
                            break;
                        case 2:
                            jad_boVar15 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 3:
                            jad_dqVar4 = com.jd.ad.sdk.jad_ve.jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 4:
                            i13 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 5:
                            i14 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 6:
                            f2 = (float) jad_cpVar.jad_iv();
                            break;
                        case 7:
                            z13 = jad_cpVar.jad_hu();
                            break;
                        case 8:
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar16 = null;
                                java.lang.String str14 = null;
                                while (jad_cpVar.jad_jt()) {
                                    int jad_an14 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_kv.jad_bo);
                                    if (jad_an14 == 0) {
                                        str14 = jad_cpVar.jad_ly();
                                    } else if (jad_an14 != 1) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_boVar16 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                    }
                                }
                                jad_cpVar.jad_er();
                                str14.getClass();
                                switch (str14.hashCode()) {
                                    case 100:
                                        if (str14.equals("d")) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 103:
                                        if (str14.equals("g")) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 111:
                                        if (str14.equals("o")) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                    case 1:
                                        jad_jtVar.jad_na = true;
                                        arrayList3.add(jad_boVar16);
                                        break;
                                    case 2:
                                        jad_boVar14 = jad_boVar16;
                                        break;
                                }
                            }
                            jad_cpVar.jad_dq();
                            if (arrayList3.size() != 1) {
                                break;
                            } else {
                                arrayList3.add((com.jd.ad.sdk.jad_ra.jad_bo) arrayList3.get(0));
                                break;
                            }
                        default:
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_re(str13, jad_boVar14, arrayList3, jad_anVar13, jad_dqVar4 == null ? new com.jd.ad.sdk.jad_ra.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVar4, jad_boVar15, i13, i14, f2, z13);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case 11:
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar14 = com.jd.ad.sdk.jad_ve.jad_lw.jad_an;
                java.lang.String str15 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar17 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar18 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar19 = null;
                int i15 = 0;
                boolean z14 = false;
                while (jad_cpVar.jad_jt()) {
                    int jad_an15 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_lw.jad_an);
                    if (jad_an15 == 0) {
                        jad_boVar17 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (jad_an15 == 1) {
                        jad_boVar18 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (jad_an15 == 2) {
                        jad_boVar19 = com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (jad_an15 == 3) {
                        str15 = jad_cpVar.jad_ly();
                    } else if (jad_an15 == 4) {
                        int jad_jw3 = jad_cpVar.jad_jw();
                        if (jad_jw3 == 1) {
                            i15 = 1;
                        } else {
                            if (jad_jw3 != 2) {
                                throw new java.lang.IllegalArgumentException("Unknown trim path type " + jad_jw3);
                            }
                            i15 = 2;
                        }
                    } else if (jad_an15 != 5) {
                        jad_cpVar.jad_ob();
                    } else {
                        z14 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_uh(str15, i15, jad_boVar17, jad_boVar18, jad_boVar19, z14);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case '\f':
                jad_boVar = com.jd.ad.sdk.jad_ve.jad_cp.jad_an(jad_cpVar, jad_jtVar);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            default:
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Unknown shape type " + str);
                while (jad_cpVar.jad_jt()) {
                }
                jad_cpVar.jad_er();
                return jad_boVar;
        }
    }
}
