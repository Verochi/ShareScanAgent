package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_ly extends com.jd.ad.sdk.jad_hk.jad_cp {
    public final transient byte[][] jad_fs;
    public final transient int[] jad_jt;

    public jad_ly(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, int i) {
        super(null);
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(jad_anVar.jad_bo, 0L, i);
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = jad_anVar.jad_an;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = jad_jwVar.jad_cp;
            int i6 = jad_jwVar.jad_bo;
            if (i5 == i6) {
                throw new java.lang.AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            jad_jwVar = jad_jwVar.jad_fs;
        }
        this.jad_fs = new byte[i4][];
        this.jad_jt = new int[i4 * 2];
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = jad_anVar.jad_an;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.jad_fs;
            bArr[i7] = jad_jwVar2.jad_an;
            int i8 = jad_jwVar2.jad_cp;
            int i9 = jad_jwVar2.jad_bo;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.jad_jt;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            jad_jwVar2.jad_dq = true;
            i7++;
            jad_jwVar2 = jad_jwVar2.jad_fs;
        }
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.jd.ad.sdk.jad_hk.jad_cp) {
            com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_hk.jad_cp) obj;
            if (jad_cpVar.jad_cp() == jad_cp() && jad_an(0, jad_cpVar, 0, jad_cp())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public int hashCode() {
        int i = this.jad_bo;
        if (i != 0) {
            return i;
        }
        int length = this.jad_fs.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.jad_fs[i2];
            int[] iArr = this.jad_jt;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.jad_bo = i4;
        return i4;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public byte jad_an(int i) {
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(this.jad_jt[this.jad_fs.length - 1], i, 1L);
        int jad_bo = jad_bo(i);
        int i2 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
        int[] iArr = this.jad_jt;
        byte[][] bArr = this.jad_fs;
        return bArr[jad_bo][(i - i2) + iArr[bArr.length + jad_bo]];
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public com.jd.ad.sdk.jad_hk.jad_cp jad_an(int i, int i2) {
        return jad_fs().jad_an(i, i2);
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public java.lang.String jad_an() {
        return jad_fs().jad_an();
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public boolean jad_an(int i, com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar, int i2, int i3) {
        if (i < 0 || i > jad_cp() - i3) {
            return false;
        }
        int jad_bo = jad_bo(i);
        while (i3 > 0) {
            int i4 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
            int min = java.lang.Math.min(i3, ((this.jad_jt[jad_bo] - i4) + i4) - i);
            int[] iArr = this.jad_jt;
            byte[][] bArr = this.jad_fs;
            if (!jad_cpVar.jad_an(i2, bArr[jad_bo], (i - i4) + iArr[bArr.length + jad_bo], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            jad_bo++;
        }
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public boolean jad_an(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > jad_cp() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int jad_bo = jad_bo(i);
        while (i3 > 0) {
            int i4 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
            int min = java.lang.Math.min(i3, ((this.jad_jt[jad_bo] - i4) + i4) - i);
            int[] iArr = this.jad_jt;
            byte[][] bArr2 = this.jad_fs;
            if (!com.jd.ad.sdk.jad_hk.jad_ob.jad_an(bArr2[jad_bo], (i - i4) + iArr[bArr2.length + jad_bo], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            jad_bo++;
        }
        return true;
    }

    public final int jad_bo(int i) {
        int binarySearch = java.util.Arrays.binarySearch(this.jad_jt, 0, this.jad_fs.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public byte[] jad_bo() {
        return jad_er();
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public int jad_cp() {
        return this.jad_jt[this.jad_fs.length - 1];
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public java.lang.String jad_dq() {
        com.jd.ad.sdk.jad_hk.jad_cp jad_fs = jad_fs();
        java.lang.String str = jad_fs.jad_cp;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = new java.lang.String(jad_fs.jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
        jad_fs.jad_cp = str2;
        return str2;
    }

    public byte[] jad_er() {
        int[] iArr = this.jad_jt;
        byte[][] bArr = this.jad_fs;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.jad_jt;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            java.lang.System.arraycopy(this.jad_fs[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public final com.jd.ad.sdk.jad_hk.jad_cp jad_fs() {
        return new com.jd.ad.sdk.jad_hk.jad_cp(jad_er());
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_cp
    public java.lang.String toString() {
        return jad_fs().toString();
    }
}
