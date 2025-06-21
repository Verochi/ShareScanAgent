package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public class jad_hu extends java.io.InputStream {
    public final /* synthetic */ com.jd.ad.sdk.jad_hk.jad_iv jad_an;

    public jad_hu(com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar) {
        this.jad_an = jad_ivVar;
    }

    @Override // java.io.InputStream
    public int available() {
        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = this.jad_an;
        if (jad_ivVar.jad_cp) {
            throw new java.io.IOException("closed");
        }
        return (int) java.lang.Math.min(jad_ivVar.jad_an.jad_bo, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.close();
    }

    @Override // java.io.InputStream
    public int read() {
        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = this.jad_an;
        if (jad_ivVar.jad_cp) {
            throw new java.io.IOException("closed");
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = jad_ivVar.jad_an;
        if (jad_anVar.jad_bo == 0 && jad_ivVar.jad_bo.jad_an(jad_anVar, 8192L) == -1) {
            return -1;
        }
        return this.jad_an.jad_an.jad_bo() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.jad_an.jad_cp) {
            throw new java.io.IOException("closed");
        }
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(bArr.length, i, i2);
        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = this.jad_an;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = jad_ivVar.jad_an;
        if (jad_anVar.jad_bo == 0 && jad_ivVar.jad_bo.jad_an(jad_anVar, 8192L) == -1) {
            return -1;
        }
        return this.jad_an.jad_an.jad_an(bArr, i, i2);
    }

    public java.lang.String toString() {
        return this.jad_an + ".inputStream()";
    }
}
