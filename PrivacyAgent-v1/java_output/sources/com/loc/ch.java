package com.loc;

/* loaded from: classes23.dex */
public final class ch extends com.loc.ck {
    private java.lang.StringBuilder a;
    private boolean b;

    public ch() {
        this.a = new java.lang.StringBuilder();
        this.b = true;
    }

    public ch(com.loc.ck ckVar) {
        super(ckVar);
        this.a = new java.lang.StringBuilder();
        this.b = true;
    }

    @Override // com.loc.ck
    public final byte[] a(byte[] bArr) {
        byte[] a = com.loc.y.a(this.a.toString());
        this.d = a;
        this.b = true;
        java.lang.StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.loc.ck
    public final void b(byte[] bArr) {
        java.lang.String a = com.loc.y.a(bArr);
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
