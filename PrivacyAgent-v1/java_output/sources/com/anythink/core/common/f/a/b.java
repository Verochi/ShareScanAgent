package com.anythink.core.common.f.a;

/* loaded from: classes12.dex */
public class b extends com.anythink.core.common.f.l {
    final java.lang.String a = com.anythink.core.common.f.a.b.class.getSimpleName();

    public b(com.anythink.core.common.f.a.e eVar) {
        o(eVar.getIconImageUrl());
        h(eVar.getStarRating().intValue());
        q(eVar.getMainImageUrl());
        m(eVar.getTitle());
        s(eVar.getCallToActionText());
        n(eVar.getDescriptionText());
        r(eVar.getAdChoiceIconUrl());
        a(eVar.getAdLogo());
        com.anythink.core.api.ATAdAppInfo adAppInfo = eVar.getAdAppInfo();
        if (adAppInfo != null) {
            if (com.anythink.core.common.b.o.a().A()) {
                new java.lang.StringBuilder("AdAppInfo:").append(eVar.getAdAppInfo().toString());
            }
            z(adAppInfo.getPublisher());
            A(adAppInfo.getAppVersion());
            B(adAppInfo.getAppPrivacyUrl());
            C(adAppInfo.getAppPermissonUrl());
            c(adAppInfo.getFunctionUrl());
        }
    }

    @Override // com.anythink.core.common.f.l
    public final boolean O() {
        return true;
    }

    @Override // com.anythink.core.common.f.l
    public final java.util.List<java.lang.String> b(com.anythink.core.common.f.n nVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(x());
        return arrayList;
    }

    @Override // com.anythink.core.common.f.l
    public final int d() {
        return 10;
    }

    @Override // com.anythink.core.common.f.l
    public final java.lang.String p() {
        return "";
    }
}
