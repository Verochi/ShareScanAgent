package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public final class d implements com.anythink.core.common.j.c {
    @Override // com.anythink.core.common.j.c
    public final void a(java.lang.String str, com.anythink.core.common.b.b bVar) {
        if (bVar == null || !(bVar instanceof com.anythink.splashad.a.b)) {
            return;
        }
        ((com.anythink.splashad.a.b) bVar).setRequestId(str);
    }
}
