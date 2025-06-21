package com.anythink.expressad.video.bt.module.b;

/* loaded from: classes12.dex */
public final class d extends com.anythink.expressad.video.bt.module.b.c {
    private static final java.lang.String a = "H5ShowRewardListener";
    private com.anythink.expressad.video.bt.module.a.b b;
    private java.lang.String c;

    public d(com.anythink.expressad.video.bt.module.a.b bVar, java.lang.String str) {
        this.b = bVar;
        this.c = str;
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a() {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(java.lang.String str) {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, str);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, z, cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void b() {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.b(this.c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void c() {
        com.anythink.expressad.video.bt.module.a.b bVar = this.b;
        if (bVar != null) {
            bVar.c(this.c);
        }
    }
}
