package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class h extends com.vivo.push.o {
    private java.lang.String a;

    public h() {
        super(2013);
    }

    public h(java.lang.String str) {
        this();
        this.a = str;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
