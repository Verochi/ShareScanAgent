package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_iv implements com.jd.ad.sdk.jad_ve.jad_mx<com.jd.ad.sdk.jad_qz.jad_bo> {
    public static final com.jd.ad.sdk.jad_ve.jad_iv jad_an = new com.jd.ad.sdk.jad_ve.jad_iv();
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_qz.jad_bo jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        jad_cpVar.jad_cp();
        java.lang.String str = null;
        java.lang.String str2 = null;
        float f2 = 0.0f;
        int i = 3;
        int i2 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_bo)) {
                case 0:
                    str = jad_cpVar.jad_ly();
                    break;
                case 1:
                    str2 = jad_cpVar.jad_ly();
                    break;
                case 2:
                    f2 = (float) jad_cpVar.jad_iv();
                    break;
                case 3:
                    int jad_jw = jad_cpVar.jad_jw();
                    if (jad_jw <= 2 && jad_jw >= 0) {
                        i = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_jw];
                        break;
                    } else {
                        i = 3;
                        break;
                    }
                case 4:
                    i2 = jad_cpVar.jad_jw();
                    break;
                case 5:
                    f3 = (float) jad_cpVar.jad_iv();
                    break;
                case 6:
                    f4 = (float) jad_cpVar.jad_iv();
                    break;
                case 7:
                    i3 = com.jd.ad.sdk.jad_ve.jad_sf.jad_an(jad_cpVar);
                    break;
                case 8:
                    i4 = com.jd.ad.sdk.jad_ve.jad_sf.jad_an(jad_cpVar);
                    break;
                case 9:
                    f5 = (float) jad_cpVar.jad_iv();
                    break;
                case 10:
                    z = jad_cpVar.jad_hu();
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    break;
            }
        }
        jad_cpVar.jad_er();
        return new com.jd.ad.sdk.jad_qz.jad_bo(str, str2, f2, i, i2, f3, f4, i3, i4, f5, z);
    }
}
