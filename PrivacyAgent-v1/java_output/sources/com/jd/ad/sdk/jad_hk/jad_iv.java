package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_iv implements com.jd.ad.sdk.jad_hk.jad_bo {
    public final com.jd.ad.sdk.jad_hk.jad_an jad_an = new com.jd.ad.sdk.jad_hk.jad_an();
    public final com.jd.ad.sdk.jad_hk.jad_mz jad_bo;
    public boolean jad_cp;

    public jad_iv(com.jd.ad.sdk.jad_hk.jad_mz jad_mzVar) {
        if (jad_mzVar == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.jad_bo = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.jad_cp) {
            return;
        }
        this.jad_cp = true;
        this.jad_bo.close();
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_an;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public int jad_an(com.jd.ad.sdk.jad_hk.jad_fs jad_fsVar) {
        if (this.jad_cp) {
            throw new java.lang.IllegalStateException("closed");
        }
        do {
            int jad_an = this.jad_an.jad_an(jad_fsVar, true);
            if (jad_an == -1) {
                return -1;
            }
            if (jad_an != -2) {
                this.jad_an.jad_dq(jad_fsVar.jad_an[jad_an].jad_cp());
                return jad_an;
            }
        } while (this.jad_bo.jad_an(this.jad_an, 8192L) != -1);
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, long j) {
        if (jad_anVar == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_cp) {
            throw new java.lang.IllegalStateException("closed");
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_an;
        if (jad_anVar2.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar2, 8192L) == -1) {
            return -1L;
        }
        return this.jad_an.jad_an(jad_anVar, java.lang.Math.min(j, this.jad_an.jad_bo));
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        if (this.jad_cp) {
            throw new java.lang.IllegalStateException("closed");
        }
        long j = 0;
        while (true) {
            long jad_an = this.jad_an.jad_an(jad_cpVar, j);
            if (jad_an != -1) {
                return jad_an;
            }
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_an;
            long j2 = jad_anVar.jad_bo;
            if (this.jad_bo.jad_an(jad_anVar, 8192L) == -1) {
                return -1L;
            }
            j = java.lang.Math.max(j, j2);
        }
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public com.jd.ad.sdk.jad_hk.jad_an jad_an() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public boolean jad_an(long j) {
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_cp) {
            throw new java.lang.IllegalStateException("closed");
        }
        do {
            jad_anVar = this.jad_an;
            if (jad_anVar.jad_bo >= j) {
                return true;
            }
        } while (this.jad_bo.jad_an(jad_anVar, 8192L) != -1);
        return false;
    }

    public com.jd.ad.sdk.jad_hk.jad_bo jad_bo() {
        return new com.jd.ad.sdk.jad_hk.jad_iv(new com.jd.ad.sdk.jad_hk.jad_jt(this));
    }

    public byte jad_cp() {
        if (jad_an(1L)) {
            return this.jad_an.jad_bo();
        }
        throw new java.io.EOFException();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) {
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_an;
        if (jad_anVar.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar, 8192L) == -1) {
            return -1;
        }
        return this.jad_an.read(byteBuffer);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("buffer(");
        jad_an.append(this.jad_bo);
        jad_an.append(")");
        return jad_an.toString();
    }
}
