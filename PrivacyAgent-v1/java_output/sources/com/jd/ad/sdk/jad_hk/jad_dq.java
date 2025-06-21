package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_hk.jad_mz {
    public final /* synthetic */ com.jd.ad.sdk.jad_hk.jad_na jad_an;
    public final /* synthetic */ java.io.InputStream jad_bo;

    public jad_dq(com.jd.ad.sdk.jad_hk.jad_na jad_naVar, java.io.InputStream inputStream) {
        this.jad_an = jad_naVar;
        this.jad_bo = inputStream;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.jad_bo.close();
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        try {
            this.jad_an.jad_an();
            com.jd.ad.sdk.jad_hk.jad_jw jad_an = jad_anVar.jad_an(1);
            int read = this.jad_bo.read(jad_an.jad_an, jad_an.jad_cp, (int) java.lang.Math.min(j, 8192 - jad_an.jad_cp));
            if (read == -1) {
                return -1L;
            }
            jad_an.jad_cp += read;
            long j2 = read;
            jad_anVar.jad_bo += j2;
            return j2;
        } catch (java.lang.AssertionError e) {
            if ((e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) ? false : true) {
                throw new java.io.IOException(e);
            }
            throw e;
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("source(");
        jad_an.append(this.jad_bo);
        jad_an.append(")");
        return jad_an.toString();
    }
}
