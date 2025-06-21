package com.ss.android.vw;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.vw.wg {
    private final java.io.RandomAccessFile vw;

    public vw(java.io.File file) throws java.io.FileNotFoundException {
        this.vw = new java.io.RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.vw.wg
    public int vw(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.vw.read(bArr, i, i2);
    }

    @Override // com.ss.android.vw.wg
    public long vw() throws java.io.IOException {
        return this.vw.length();
    }

    @Override // com.ss.android.vw.wg
    public void vw(long j, long j2) throws java.io.IOException {
        this.vw.seek(j);
    }

    @Override // com.ss.android.vw.wg
    public void wg() throws java.io.IOException {
        this.vw.close();
    }
}
