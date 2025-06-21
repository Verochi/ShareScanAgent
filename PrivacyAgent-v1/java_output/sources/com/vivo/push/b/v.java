package com.vivo.push.b;

/* loaded from: classes19.dex */
public abstract class v extends com.vivo.push.b.s {
    private java.lang.String a;
    private long b;

    public v(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        aVar.a("notify_id", this.b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.b;
    }

    public final java.lang.String i() {
        return this.a;
    }
}
