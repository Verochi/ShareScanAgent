package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_jt implements com.jd.ad.sdk.jad_hk.jad_mz {
    public final com.jd.ad.sdk.jad_hk.jad_bo jad_an;
    public final com.jd.ad.sdk.jad_hk.jad_an jad_bo;
    public com.jd.ad.sdk.jad_hk.jad_jw jad_cp;
    public int jad_dq;
    public boolean jad_er;
    public long jad_fs;

    public jad_jt(com.jd.ad.sdk.jad_hk.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
        com.jd.ad.sdk.jad_hk.jad_an jad_an = jad_boVar.jad_an();
        this.jad_bo = jad_an;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = jad_an.jad_an;
        this.jad_cp = jad_jwVar;
        this.jad_dq = jad_jwVar != null ? jad_jwVar.jad_bo : -1;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.jad_er = true;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, long j) {
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_er) {
            throw new java.lang.IllegalStateException("closed");
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar3 = this.jad_cp;
        if (jad_jwVar3 != null && (jad_jwVar3 != (jad_jwVar2 = this.jad_bo.jad_an) || this.jad_dq != jad_jwVar2.jad_bo)) {
            throw new java.lang.IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.jad_an.jad_an(this.jad_fs + 1)) {
            return -1L;
        }
        if (this.jad_cp == null && (jad_jwVar = this.jad_bo.jad_an) != null) {
            this.jad_cp = jad_jwVar;
            this.jad_dq = jad_jwVar.jad_bo;
        }
        long min = java.lang.Math.min(j, this.jad_bo.jad_bo - this.jad_fs);
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_bo;
        long j2 = this.jad_fs;
        jad_anVar2.getClass();
        if (jad_anVar == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(jad_anVar2.jad_bo, j2, min);
        if (min != 0) {
            jad_anVar.jad_bo += min;
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar4 = jad_anVar2.jad_an;
            while (true) {
                long j3 = jad_jwVar4.jad_cp - jad_jwVar4.jad_bo;
                if (j2 < j3) {
                    break;
                }
                j2 -= j3;
                jad_jwVar4 = jad_jwVar4.jad_fs;
            }
            long j4 = min;
            while (j4 > 0) {
                com.jd.ad.sdk.jad_hk.jad_jw jad_bo = jad_jwVar4.jad_bo();
                int i = (int) (jad_bo.jad_bo + j2);
                jad_bo.jad_bo = i;
                jad_bo.jad_cp = java.lang.Math.min(i + ((int) j4), jad_bo.jad_cp);
                com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar5 = jad_anVar.jad_an;
                if (jad_jwVar5 == null) {
                    jad_bo.jad_jt = jad_bo;
                    jad_bo.jad_fs = jad_bo;
                    jad_anVar.jad_an = jad_bo;
                } else {
                    jad_jwVar5.jad_jt.jad_an(jad_bo);
                }
                j4 -= jad_bo.jad_cp - jad_bo.jad_bo;
                jad_jwVar4 = jad_jwVar4.jad_fs;
                j2 = 0;
            }
        }
        this.jad_fs += min;
        return min;
    }
}
