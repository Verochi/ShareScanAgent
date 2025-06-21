package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class n extends com.vivo.push.b.s {
    private java.lang.String a;
    private int b;
    private boolean c;

    public n() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void b(java.lang.String str) {
        this.a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("log_level", this.b);
        aVar.a("is_server_log", this.c);
    }

    public final java.lang.String d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("content");
        this.b = aVar.b("log_level", 0);
        this.c = aVar.e("is_server_log");
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnLogCommand";
    }
}
