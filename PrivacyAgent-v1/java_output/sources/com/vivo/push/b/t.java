package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class t extends com.vivo.push.b.s {
    private java.util.ArrayList<java.lang.String> a;
    private java.util.ArrayList<java.lang.String> b;

    public t(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("error_msg", this.b);
    }

    public final java.util.ArrayList<java.lang.String> d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c("content");
        this.b = aVar.c("error_msg");
    }

    public final java.util.List<java.lang.String> e() {
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnSetTagsCommand";
    }
}
