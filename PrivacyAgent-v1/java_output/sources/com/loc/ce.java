package com.loc;

/* loaded from: classes23.dex */
public final class ce extends com.loc.ck {
    java.io.ByteArrayOutputStream a;

    public ce() {
        this.a = new java.io.ByteArrayOutputStream();
    }

    public ce(com.loc.ck ckVar) {
        super(ckVar);
        this.a = new java.io.ByteArrayOutputStream();
    }

    @Override // com.loc.ck
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

    @Override // com.loc.ck
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
