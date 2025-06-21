package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class z extends com.vivo.push.b.c {
    private java.util.ArrayList<java.lang.String> a;

    public z(boolean z, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(com.baidu.mobads.sdk.internal.bm.l, (java.io.Serializable) this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(com.baidu.mobads.sdk.internal.bm.l);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final java.lang.String toString() {
        return "TagCommand";
    }
}
