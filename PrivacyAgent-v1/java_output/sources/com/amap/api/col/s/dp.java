package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dp extends com.amap.api.col.s.ds {
    public java.lang.StringBuilder e;
    public boolean f;

    public dp() {
        this.e = new java.lang.StringBuilder();
        this.f = true;
    }

    public dp(com.amap.api.col.s.ds dsVar) {
        super(dsVar);
        this.e = new java.lang.StringBuilder();
        this.f = true;
    }

    @Override // com.amap.api.col.s.ds
    public final byte[] a(byte[] bArr) {
        byte[] a = com.amap.api.col.s.bu.a(this.e.toString());
        this.d = a;
        this.f = true;
        java.lang.StringBuilder sb = this.e;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.amap.api.col.s.ds
    public final void b(byte[] bArr) {
        java.lang.String a = com.amap.api.col.s.bu.a(bArr);
        if (this.f) {
            this.f = false;
        } else {
            this.e.append(",");
        }
        java.lang.StringBuilder sb = this.e;
        sb.append("{\"log\":\"");
        sb.append(a);
        sb.append("\"}");
    }
}
