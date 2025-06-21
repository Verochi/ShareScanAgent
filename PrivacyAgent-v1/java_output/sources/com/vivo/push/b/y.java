package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class y extends com.vivo.push.o {
    private java.lang.String a;

    public y() {
        super(2008);
    }

    public y(java.lang.String str) {
        super(2008);
        this.a = str;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
    }

    @Override // com.vivo.push.o
    public final java.lang.String toString() {
        return "StopServiceCommand";
    }
}
