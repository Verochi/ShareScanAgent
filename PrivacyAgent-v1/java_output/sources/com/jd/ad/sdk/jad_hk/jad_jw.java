package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_jw {
    public final byte[] jad_an;
    public int jad_bo;
    public int jad_cp;
    public boolean jad_dq;
    public boolean jad_er;
    public com.jd.ad.sdk.jad_hk.jad_jw jad_fs;
    public com.jd.ad.sdk.jad_hk.jad_jw jad_jt;

    public jad_jw() {
        this.jad_an = new byte[8192];
        this.jad_er = true;
        this.jad_dq = false;
    }

    public jad_jw(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.jad_an = bArr;
        this.jad_bo = i;
        this.jad_cp = i2;
        this.jad_dq = z;
        this.jad_er = z2;
    }

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_hk.jad_jw jad_an() {
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_fs;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = jad_jwVar != this ? jad_jwVar : null;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar3 = this.jad_jt;
        jad_jwVar3.jad_fs = jad_jwVar;
        this.jad_fs.jad_jt = jad_jwVar3;
        this.jad_fs = null;
        this.jad_jt = null;
        return jad_jwVar2;
    }

    public final com.jd.ad.sdk.jad_hk.jad_jw jad_an(com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar) {
        jad_jwVar.jad_jt = this;
        jad_jwVar.jad_fs = this.jad_fs;
        this.jad_fs.jad_jt = jad_jwVar;
        this.jad_fs = jad_jwVar;
        return jad_jwVar;
    }

    public final void jad_an(com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar, int i) {
        if (!jad_jwVar.jad_er) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = jad_jwVar.jad_cp;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (jad_jwVar.jad_dq) {
                throw new java.lang.IllegalArgumentException();
            }
            int i4 = jad_jwVar.jad_bo;
            if (i3 - i4 > 8192) {
                throw new java.lang.IllegalArgumentException();
            }
            byte[] bArr = jad_jwVar.jad_an;
            java.lang.System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            jad_jwVar.jad_cp -= jad_jwVar.jad_bo;
            jad_jwVar.jad_bo = 0;
        }
        java.lang.System.arraycopy(this.jad_an, this.jad_bo, jad_jwVar.jad_an, jad_jwVar.jad_cp, i);
        jad_jwVar.jad_cp += i;
        this.jad_bo += i;
    }

    public final com.jd.ad.sdk.jad_hk.jad_jw jad_bo() {
        this.jad_dq = true;
        return new com.jd.ad.sdk.jad_hk.jad_jw(this.jad_an, this.jad_bo, this.jad_cp, true, false);
    }
}
