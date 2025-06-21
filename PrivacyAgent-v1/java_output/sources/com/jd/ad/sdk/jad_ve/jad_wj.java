package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_wj {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", com.anythink.expressad.video.dynview.a.a.U, "v", "layers", "assets", "fonts", "chars", "markers");
    public static com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("id", "layers", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "p", com.umeng.analytics.pro.bo.aN);
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_cp = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_dq = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_MODE, "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0046. Please report as an issue. */
    public static com.jd.ad.sdk.jad_lu.jad_jt jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        java.util.ArrayList arrayList;
        androidx.collection.SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> sparseArrayCompat;
        java.util.ArrayList arrayList2;
        float f;
        float f2;
        java.util.ArrayList arrayList3;
        float jad_an2 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an();
        androidx.collection.LongSparseArray<com.jd.ad.sdk.jad_tc.jad_er> longSparseArray = new androidx.collection.LongSparseArray<>();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashMap hashMap2 = new java.util.HashMap();
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.ArrayList arrayList5 = new java.util.ArrayList();
        androidx.collection.SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> sparseArrayCompat2 = new androidx.collection.SparseArrayCompat<>();
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = new com.jd.ad.sdk.jad_lu.jad_jt();
        jad_cpVar.jad_cp();
        int i = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i2 = 0;
        while (jad_cpVar.jad_jt()) {
            float f6 = f3;
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    i = jad_cpVar.jad_jw();
                    f3 = f6;
                    break;
                case 1:
                    i2 = jad_cpVar.jad_jw();
                    f3 = f6;
                    break;
                case 2:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f5 = (float) jad_cpVar.jad_iv();
                    f3 = f6;
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 3:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f4 = ((float) jad_cpVar.jad_iv()) - 0.01f;
                    f3 = f6;
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 4:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f3 = (float) jad_cpVar.jad_iv();
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 5:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = f4;
                    f2 = f5;
                    java.lang.String[] split = jad_cpVar.jad_ly().split("\\.");
                    int parseInt = java.lang.Integer.parseInt(split[0]);
                    int parseInt2 = java.lang.Integer.parseInt(split[1]);
                    if (!(parseInt >= 4 && (parseInt > 4 || (parseInt2 >= 4 && (parseInt2 > 4 || java.lang.Integer.parseInt(split[2]) >= 0))))) {
                        jad_jtVar.jad_an("Lottie only supports bodymovin >= 4.4.0");
                    }
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 6:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_bo();
                    int i3 = 0;
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_tc.jad_er jad_an3 = com.jd.ad.sdk.jad_ve.jad_vi.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_an3.jad_er == 3) {
                            i3++;
                        }
                        arrayList4.add(jad_an3);
                        longSparseArray.put(jad_an3.jad_dq, jad_an3);
                        if (i3 > 4) {
                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("You have " + i3 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jad_cpVar.jad_dq();
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 7:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        java.util.ArrayList arrayList6 = new java.util.ArrayList();
                        androidx.collection.LongSparseArray longSparseArray2 = new androidx.collection.LongSparseArray();
                        jad_cpVar.jad_cp();
                        java.lang.String str = null;
                        java.lang.String str2 = null;
                        java.lang.String str3 = null;
                        int i4 = 0;
                        int i5 = 0;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an4 = jad_cpVar.jad_an(jad_bo);
                            if (jad_an4 == 0) {
                                str = jad_cpVar.jad_ly();
                            } else if (jad_an4 == 1) {
                                jad_cpVar.jad_bo();
                                while (jad_cpVar.jad_jt()) {
                                    com.jd.ad.sdk.jad_tc.jad_er jad_an5 = com.jd.ad.sdk.jad_ve.jad_vi.jad_an(jad_cpVar, jad_jtVar);
                                    longSparseArray2.put(jad_an5.jad_dq, jad_an5);
                                    arrayList6.add(jad_an5);
                                }
                                jad_cpVar.jad_dq();
                            } else if (jad_an4 == 2) {
                                i4 = jad_cpVar.jad_jw();
                            } else if (jad_an4 == 3) {
                                i5 = jad_cpVar.jad_jw();
                            } else if (jad_an4 == 4) {
                                str2 = jad_cpVar.jad_ly();
                            } else if (jad_an4 != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                str3 = jad_cpVar.jad_ly();
                            }
                        }
                        jad_cpVar.jad_er();
                        if (str2 != null) {
                            hashMap2.put(str, new com.jd.ad.sdk.jad_lu.jad_na(i4, i5, str, str2, str3));
                        } else {
                            hashMap.put(str, arrayList6);
                        }
                    }
                    jad_cpVar.jad_dq();
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 8:
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        if (jad_cpVar.jad_an(jad_cp) != 0) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar = com.jd.ad.sdk.jad_ve.jad_na.jad_an;
                                jad_cpVar.jad_cp();
                                java.lang.String str4 = null;
                                java.lang.String str5 = null;
                                java.lang.String str6 = null;
                                float f7 = 0.0f;
                                while (true) {
                                    arrayList3 = arrayList5;
                                    if (jad_cpVar.jad_jt()) {
                                        int jad_an6 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_na.jad_an);
                                        androidx.collection.SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> sparseArrayCompat3 = sparseArrayCompat2;
                                        if (jad_an6 != 0) {
                                            if (jad_an6 == 1) {
                                                str5 = jad_cpVar.jad_ly();
                                            } else if (jad_an6 == 2) {
                                                str6 = jad_cpVar.jad_ly();
                                            } else if (jad_an6 != 3) {
                                                jad_cpVar.jad_na();
                                                jad_cpVar.jad_ob();
                                            } else {
                                                f7 = (float) jad_cpVar.jad_iv();
                                            }
                                            arrayList5 = arrayList3;
                                            sparseArrayCompat2 = sparseArrayCompat3;
                                        } else {
                                            str4 = jad_cpVar.jad_ly();
                                            arrayList5 = arrayList3;
                                        }
                                    }
                                }
                                jad_cpVar.jad_er();
                                hashMap3.put(str5, new com.jd.ad.sdk.jad_qz.jad_cp(str4, str5, str6, f7));
                                arrayList5 = arrayList3;
                            }
                            jad_cpVar.jad_dq();
                        }
                    }
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    jad_cpVar.jad_er();
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 9:
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar2 = com.jd.ad.sdk.jad_ve.jad_mz.jad_an;
                        java.util.ArrayList arrayList7 = new java.util.ArrayList();
                        jad_cpVar.jad_cp();
                        double d = 0.0d;
                        double d2 = 0.0d;
                        java.lang.String str7 = null;
                        java.lang.String str8 = null;
                        char c = 0;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an7 = jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_mz.jad_an);
                            if (jad_an7 == 0) {
                                c = jad_cpVar.jad_ly().charAt(0);
                            } else if (jad_an7 == 1) {
                                d = jad_cpVar.jad_iv();
                            } else if (jad_an7 == 2) {
                                d2 = jad_cpVar.jad_iv();
                            } else if (jad_an7 == 3) {
                                str7 = jad_cpVar.jad_ly();
                            } else if (jad_an7 == 4) {
                                str8 = jad_cpVar.jad_ly();
                            } else if (jad_an7 != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                jad_cpVar.jad_cp();
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(com.jd.ad.sdk.jad_ve.jad_mz.jad_bo) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_bo();
                                        while (jad_cpVar.jad_jt()) {
                                            arrayList7.add((com.jd.ad.sdk.jad_sb.jad_pc) com.jd.ad.sdk.jad_ve.jad_hu.jad_an(jad_cpVar, jad_jtVar));
                                        }
                                        jad_cpVar.jad_dq();
                                    }
                                }
                                jad_cpVar.jad_er();
                            }
                        }
                        jad_cpVar.jad_er();
                        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_qz.jad_dq(arrayList7, c, d, d2, str7, str8);
                        sparseArrayCompat2.put(jad_dqVar.hashCode(), jad_dqVar);
                    }
                    jad_cpVar.jad_dq();
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 10:
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        java.lang.String str9 = null;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an8 = jad_cpVar.jad_an(jad_dq);
                            float f10 = f4;
                            if (jad_an8 != 0) {
                                if (jad_an8 == 1) {
                                    f8 = (float) jad_cpVar.jad_iv();
                                } else if (jad_an8 != 2) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    f9 = (float) jad_cpVar.jad_iv();
                                }
                                f4 = f10;
                            } else {
                                str9 = jad_cpVar.jad_ly();
                            }
                        }
                        jad_cpVar.jad_er();
                        arrayList5.add(new com.jd.ad.sdk.jad_qz.jad_hu(str9, f8, f9));
                        f5 = f5;
                        f4 = f4;
                    }
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_dq();
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                default:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = f4;
                    f2 = f5;
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    f3 = f6;
                    f5 = f2;
                    arrayList5 = arrayList2;
                    f4 = f;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
            }
        }
        jad_jtVar.jad_jw = new android.graphics.Rect(0, 0, (int) (i * jad_an2), (int) (i2 * jad_an2));
        jad_jtVar.jad_kx = f5;
        jad_jtVar.jad_ly = f4;
        jad_jtVar.jad_mz = f3;
        jad_jtVar.jad_iv = arrayList4;
        jad_jtVar.jad_hu = longSparseArray;
        jad_jtVar.jad_cp = hashMap;
        jad_jtVar.jad_dq = hashMap2;
        jad_jtVar.jad_jt = sparseArrayCompat2;
        jad_jtVar.jad_er = hashMap3;
        jad_jtVar.jad_fs = arrayList5;
        return jad_jtVar;
    }
}
