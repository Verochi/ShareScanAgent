package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class w extends com.vivo.push.o {
    private int a;

    public w() {
        super(2011);
        this.a = 0;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.o
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }

    @Override // com.vivo.push.o
    public final java.lang.String toString() {
        return "PushModeCommand";
    }
}
