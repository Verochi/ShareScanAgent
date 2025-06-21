package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ht extends com.amap.api.mapcore.util.hz {
    java.io.ByteArrayOutputStream a;

    public ht() {
        this.a = new java.io.ByteArrayOutputStream();
    }

    public ht(com.amap.api.mapcore.util.hz hzVar) {
        super(hzVar);
        this.a = new java.io.ByteArrayOutputStream();
    }

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        this.a = new java.io.ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.mapcore.util.hz
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
