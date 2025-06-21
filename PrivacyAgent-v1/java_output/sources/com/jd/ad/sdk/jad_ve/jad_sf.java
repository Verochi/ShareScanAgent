package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_sf {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("x", "y");

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(10).length];
            jad_an = iArr;
            try {
                iArr[6] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[0] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    @androidx.annotation.ColorInt
    public static int jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        jad_cpVar.jad_bo();
        int jad_iv = (int) (jad_cpVar.jad_iv() * 255.0d);
        int jad_iv2 = (int) (jad_cpVar.jad_iv() * 255.0d);
        int jad_iv3 = (int) (jad_cpVar.jad_iv() * 255.0d);
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return android.graphics.Color.argb(255, jad_iv, jad_iv2, jad_iv3);
    }

    public static android.graphics.PointF jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        int i = com.jd.ad.sdk.jad_ve.jad_sf.jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_cpVar.jad_mz())];
        if (i == 1) {
            float jad_iv = (float) jad_cpVar.jad_iv();
            float jad_iv2 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_jt()) {
                jad_cpVar.jad_ob();
            }
            return new android.graphics.PointF(jad_iv * f, jad_iv2 * f);
        }
        if (i == 2) {
            jad_cpVar.jad_bo();
            float jad_iv3 = (float) jad_cpVar.jad_iv();
            float jad_iv4 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_mz() != 2) {
                jad_cpVar.jad_ob();
            }
            jad_cpVar.jad_dq();
            return new android.graphics.PointF(jad_iv3 * f, jad_iv4 * f);
        }
        if (i != 3) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Unknown point starts with ");
            jad_an2.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_cpVar.jad_mz()));
            throw new java.lang.IllegalArgumentException(jad_an2.toString());
        }
        jad_cpVar.jad_cp();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jad_cpVar.jad_jt()) {
            int jad_an3 = jad_cpVar.jad_an(jad_an);
            if (jad_an3 == 0) {
                f3 = jad_bo(jad_cpVar);
            } else if (jad_an3 != 1) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                f2 = jad_bo(jad_cpVar);
            }
        }
        jad_cpVar.jad_er();
        return new android.graphics.PointF(f3 * f, f2 * f);
    }

    public static float jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        int jad_mz = jad_cpVar.jad_mz();
        int i = com.jd.ad.sdk.jad_ve.jad_sf.jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_mz)];
        if (i == 1) {
            return (float) jad_cpVar.jad_iv();
        }
        if (i != 2) {
            throw new java.lang.IllegalArgumentException("Unknown value for token of type " + com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz));
        }
        jad_cpVar.jad_bo();
        float jad_iv = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return jad_iv;
    }

    public static java.util.List<android.graphics.PointF> jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jad_cpVar.jad_bo();
        while (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            arrayList.add(jad_an(jad_cpVar, f));
            jad_cpVar.jad_dq();
        }
        jad_cpVar.jad_dq();
        return arrayList;
    }
}
