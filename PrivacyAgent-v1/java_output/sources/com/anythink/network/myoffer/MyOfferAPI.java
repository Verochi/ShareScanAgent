package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferAPI {
    public static boolean checkOffersOutOfCap(android.content.Context context, java.lang.String str) {
        return com.anythink.basead.f.a.b.a(context).a(str);
    }

    public static java.lang.String getDefaultOfferId(android.content.Context context, java.lang.String str) {
        return com.anythink.basead.f.a.a.a(context).b(str);
    }

    public static java.lang.String getOutOfCapOfferIds(android.content.Context context) {
        return com.anythink.basead.f.a.b.a(context).a();
    }

    public static void preloadATOffer(android.content.Context context, com.anythink.core.common.f.aa aaVar) {
        com.anythink.basead.f.a.a.a(context).a(aaVar.a);
    }
}
