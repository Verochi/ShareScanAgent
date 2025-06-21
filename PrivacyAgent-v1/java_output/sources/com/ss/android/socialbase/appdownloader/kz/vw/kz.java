package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
public class kz {
    private int[] vw;
    private int[] wg;

    private kz() {
    }

    private static final int vw(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }

    public static com.ss.android.socialbase.appdownloader.kz.vw.kz vw(com.ss.android.socialbase.appdownloader.kz.vw.v vVar) throws java.io.IOException {
        com.ss.android.socialbase.appdownloader.kz.vw.wg.vw(vVar, 1835009);
        int wg = vVar.wg();
        int wg2 = vVar.wg();
        int wg3 = vVar.wg();
        vVar.wg();
        int wg4 = vVar.wg();
        int wg5 = vVar.wg();
        com.ss.android.socialbase.appdownloader.kz.vw.kz kzVar = new com.ss.android.socialbase.appdownloader.kz.vw.kz();
        kzVar.vw = vVar.wg(wg2);
        if (wg3 != 0) {
            vVar.wg(wg3);
        }
        int i = (wg5 == 0 ? wg : wg5) - wg4;
        if (i % 4 != 0) {
            throw new java.io.IOException("String data size is not multiple of 4 (" + i + ").");
        }
        kzVar.wg = vVar.wg(i / 4);
        if (wg5 != 0) {
            int i2 = wg - wg5;
            if (i2 % 4 != 0) {
                throw new java.io.IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            vVar.wg(i2 / 4);
        }
        return kzVar;
    }

    public java.lang.String vw(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.vw) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int vw = vw(this.wg, i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(vw);
        while (vw != 0) {
            i2 += 2;
            sb.append((char) vw(this.wg, i2));
            vw--;
        }
        return sb.toString();
    }
}
