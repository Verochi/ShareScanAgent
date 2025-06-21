package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dm extends com.amap.api.col.s.ds {
    public java.io.ByteArrayOutputStream e;

    public dm() {
        this.e = new java.io.ByteArrayOutputStream();
    }

    public dm(com.amap.api.col.s.ds dsVar) {
        super(dsVar);
        this.e = new java.io.ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.ds
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.e.toByteArray();
        try {
            this.e.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        this.e = new java.io.ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.ds
    public final void b(byte[] bArr) {
        try {
            this.e.write(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
