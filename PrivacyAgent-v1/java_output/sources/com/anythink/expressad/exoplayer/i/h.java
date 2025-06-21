package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public abstract class h {

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.i.h.a a;

    public interface a {
        void c();
    }

    public abstract com.anythink.expressad.exoplayer.i.i a(com.anythink.expressad.exoplayer.z[] zVarArr, com.anythink.expressad.exoplayer.h.af afVar);

    public final void a(com.anythink.expressad.exoplayer.i.h.a aVar) {
        this.a = aVar;
    }

    public abstract void a(java.lang.Object obj);

    public final void b() {
        com.anythink.expressad.exoplayer.i.h.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
