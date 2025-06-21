package com.anythink.basead.handler;

/* loaded from: classes12.dex */
public class OfferClickHandler extends com.anythink.core.api.IOfferClickHandler {
    private static com.anythink.basead.c.d a(com.anythink.core.common.f.l lVar) {
        return com.anythink.basead.a.c.a().a(lVar.d(), lVar.s());
    }

    @Override // com.anythink.core.api.IOfferClickHandler
    public boolean startDownloadApp(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, java.lang.String str) {
        return com.anythink.basead.a.a.a(context, mVar, lVar, com.anythink.basead.a.c.a().a(lVar.d(), lVar.s()), str, new com.anythink.basead.a.h());
    }
}
