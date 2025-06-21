package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class o implements com.anythink.expressad.exoplayer.j.h.a {
    private final android.content.Context a;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> b;
    private final com.anythink.expressad.exoplayer.j.h.a c;

    private o(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar, com.anythink.expressad.exoplayer.j.h.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aaVar;
        this.c = aVar;
    }

    public o(android.content.Context context, java.lang.String str) {
        this(context, str, (com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h>) null);
    }

    private o(android.content.Context context, java.lang.String str, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar) {
        this(context, aaVar, new com.anythink.expressad.exoplayer.j.q(str, aaVar));
    }

    private com.anythink.expressad.exoplayer.j.n b() {
        return new com.anythink.expressad.exoplayer.j.n(this.a, this.b, this.c.a());
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ com.anythink.expressad.exoplayer.j.h a() {
        return new com.anythink.expressad.exoplayer.j.n(this.a, this.b, this.c.a());
    }
}
