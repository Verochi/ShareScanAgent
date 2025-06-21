package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class a extends com.vivo.push.b.c {
    private java.util.ArrayList<java.lang.String> a;

    public a(boolean z, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        super(z ? 2002 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(com.baidu.mobads.sdk.internal.bm.l, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(com.baidu.mobads.sdk.internal.bm.l);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final java.lang.String toString() {
        return "AliasCommand:" + b();
    }
}
