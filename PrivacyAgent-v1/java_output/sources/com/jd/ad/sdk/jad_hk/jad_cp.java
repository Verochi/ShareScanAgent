package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public class jad_cp implements java.io.Serializable, java.lang.Comparable<com.jd.ad.sdk.jad_hk.jad_cp> {
    public static final char[] jad_dq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_er = new com.jd.ad.sdk.jad_hk.jad_cp((byte[]) new byte[0].clone());
    public final byte[] jad_an;
    public transient int jad_bo;
    public transient java.lang.String jad_cp;

    public jad_cp(byte[] bArr) {
        this.jad_an = bArr;
    }

    public static com.jd.ad.sdk.jad_hk.jad_cp jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hk.jad_cp(str.getBytes(com.jd.ad.sdk.jad_hk.jad_ob.jad_an));
        jad_cpVar.jad_cp = str;
        return jad_cpVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar2 = jad_cpVar;
        int jad_cp = jad_cp();
        int jad_cp2 = jad_cpVar2.jad_cp();
        int min = java.lang.Math.min(jad_cp, jad_cp2);
        for (int i = 0; i < min; i++) {
            int jad_an = jad_an(i) & 255;
            int jad_an2 = jad_cpVar2.jad_an(i) & 255;
            if (jad_an != jad_an2) {
                return jad_an < jad_an2 ? -1 : 1;
            }
        }
        if (jad_cp == jad_cp2) {
            return 0;
        }
        if (jad_cp < jad_cp2) {
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.jd.ad.sdk.jad_hk.jad_cp) {
            com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_hk.jad_cp) obj;
            int jad_cp = jad_cpVar.jad_cp();
            byte[] bArr = this.jad_an;
            if (jad_cp == bArr.length && jad_cpVar.jad_an(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.jad_bo;
        if (i != 0) {
            return i;
        }
        int hashCode = java.util.Arrays.hashCode(this.jad_an);
        this.jad_bo = hashCode;
        return hashCode;
    }

    public byte jad_an(int i) {
        return this.jad_an[i];
    }

    public com.jd.ad.sdk.jad_hk.jad_cp jad_an(int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.jad_an;
        if (i2 > bArr.length) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("endIndex > length(");
            jad_an.append(this.jad_an.length);
            jad_an.append(")");
            throw new java.lang.IllegalArgumentException(jad_an.toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i3);
        return new com.jd.ad.sdk.jad_hk.jad_cp(bArr2);
    }

    public java.lang.String jad_an() {
        byte[] bArr = this.jad_an;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = jad_dq;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public boolean jad_an(int i, com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar, int i2, int i3) {
        return jad_cpVar.jad_an(i2, this.jad_an, i, i3);
    }

    public boolean jad_an(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.jad_an;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && com.jd.ad.sdk.jad_hk.jad_ob.jad_an(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public byte[] jad_bo() {
        return this.jad_an;
    }

    public int jad_cp() {
        return this.jad_an.length;
    }

    public java.lang.String jad_dq() {
        java.lang.String str = this.jad_cp;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = new java.lang.String(this.jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
        this.jad_cp = str2;
        return str2;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb;
        java.lang.StringBuilder jad_an;
        if (this.jad_an.length == 0) {
            return "[size=0]";
        }
        java.lang.String jad_dq2 = jad_dq();
        int length = jad_dq2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = jad_dq2.length();
                break;
            }
            if (i2 == 64) {
                break;
            }
            int codePointAt = jad_dq2.codePointAt(i);
            if ((!java.lang.Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                i2++;
                i += java.lang.Character.charCount(codePointAt);
            }
        }
        i = -1;
        if (i == -1) {
            if (this.jad_an.length <= 64) {
                jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("[hex=");
                jad_an.append(jad_an());
                jad_an.append("]");
            } else {
                jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("[size=");
                jad_an.append(this.jad_an.length);
                jad_an.append(" hex=");
                jad_an.append(jad_an(0, 64).jad_an());
                jad_an.append("…]");
            }
            return jad_an.toString();
        }
        java.lang.String replace = jad_dq2.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i < jad_dq2.length()) {
            sb = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("[size=");
            sb.append(this.jad_an.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }
}
