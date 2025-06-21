package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hw extends com.amap.api.mapcore.util.hz {
    private java.lang.StringBuilder a;
    private boolean b;

    public hw() {
        this.a = new java.lang.StringBuilder();
        this.b = true;
    }

    public hw(com.amap.api.mapcore.util.hz hzVar) {
        super(hzVar);
        this.a = new java.lang.StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) {
        byte[] a = com.amap.api.mapcore.util.fi.a(this.a.toString());
        this.d = a;
        this.b = true;
        java.lang.StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.amap.api.mapcore.util.hz
    public final void b(byte[] bArr) {
        java.lang.String a = com.amap.api.mapcore.util.fi.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        java.lang.StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a);
        sb.append("\"}");
    }
}
