package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class m extends com.vivo.push.b.s {
    private java.util.ArrayList<java.lang.String> a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.a);
    }

    public final java.util.ArrayList<java.lang.String> d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c("tags_list");
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnListTagCommand";
    }
}
