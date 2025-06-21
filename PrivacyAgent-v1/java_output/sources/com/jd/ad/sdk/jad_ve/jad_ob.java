package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_ob implements com.jd.ad.sdk.jad_ve.jad_mx<com.jd.ad.sdk.jad_sb.jad_dq> {
    public int jad_an;

    public jad_ob(int i) {
        this.jad_an = i;
    }

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_sb.jad_dq jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        int i;
        double d;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        boolean z = jad_cpVar.jad_mz() == 1;
        if (z) {
            jad_cpVar.jad_bo();
        }
        while (jad_cpVar.jad_jt()) {
            arrayList.add(java.lang.Float.valueOf((float) jad_cpVar.jad_iv()));
        }
        if (z) {
            jad_cpVar.jad_dq();
        }
        if (this.jad_an == -1) {
            this.jad_an = arrayList.size() / 4;
        }
        int i3 = this.jad_an;
        float[] fArr = new float[i3];
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = this.jad_an * 4;
            if (i4 >= i) {
                break;
            }
            int i7 = i4 / 4;
            double floatValue = ((java.lang.Float) arrayList.get(i4)).floatValue();
            int i8 = i4 % 4;
            if (i8 == 0) {
                if (i7 > 0) {
                    float f2 = (float) floatValue;
                    if (fArr[i7 - 1] >= f2) {
                        fArr[i7] = f2 + 0.01f;
                    }
                }
                fArr[i7] = (float) floatValue;
            } else if (i8 == 1) {
                i5 = (int) (floatValue * 255.0d);
            } else if (i8 == 2) {
                i6 = (int) (floatValue * 255.0d);
            } else if (i8 == 3) {
                iArr[i7] = android.graphics.Color.argb(255, i5, i6, (int) (floatValue * 255.0d));
            }
            i4++;
        }
        com.jd.ad.sdk.jad_sb.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_sb.jad_dq(fArr, iArr);
        if (arrayList.size() > i) {
            int size = (arrayList.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i9 = 0;
            while (i < arrayList.size()) {
                if (i % 2 == 0) {
                    dArr[i9] = ((java.lang.Float) arrayList.get(i)).floatValue();
                } else {
                    dArr2[i9] = ((java.lang.Float) arrayList.get(i)).floatValue();
                    i9++;
                }
                i++;
            }
            while (true) {
                int[] iArr2 = jad_dqVar.jad_bo;
                if (i2 >= iArr2.length) {
                    break;
                }
                int i10 = iArr2[i2];
                double d2 = jad_dqVar.jad_an[i2];
                int i11 = 1;
                while (true) {
                    if (i11 >= size) {
                        d = dArr2[size - 1] * 255.0d;
                        break;
                    }
                    int i12 = i11 - 1;
                    double d3 = dArr[i12];
                    double d4 = dArr[i11];
                    if (d4 >= d2) {
                        double d5 = (d2 - d3) / (d4 - d3);
                        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
                        double max = java.lang.Math.max(0.0d, java.lang.Math.min(1.0d, d5));
                        double d6 = dArr2[i12];
                        d = (((dArr2[i11] - d6) * max) + d6) * 255.0d;
                        break;
                    }
                    i11++;
                }
                jad_dqVar.jad_bo[i2] = android.graphics.Color.argb((int) d, android.graphics.Color.red(i10), android.graphics.Color.green(i10), android.graphics.Color.blue(i10));
                i2++;
            }
        }
        return jad_dqVar;
    }
}
