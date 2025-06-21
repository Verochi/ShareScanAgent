package com.anythink.basead;

/* loaded from: classes12.dex */
public final class b {

    /* renamed from: com.anythink.basead.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.f.q.a {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass1(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // com.anythink.core.common.f.q.a
        public final void a() {
            com.anythink.core.common.f.l lVar = this.a;
            com.anythink.basead.a.a.a(10, lVar, new com.anythink.basead.c.i(lVar.m(), ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(com.anythink.core.common.b.o.a().f(), ((com.anythink.core.common.f.j) this.a).b());
        }
    }

    public static java.util.Map<java.lang.String, java.lang.Object> a(com.anythink.basead.d.b bVar) {
        if (bVar != null) {
            return a(bVar.f());
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> a(com.anythink.basead.f.c cVar) {
        if (cVar != null) {
            return a(cVar.e());
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> a(com.anythink.core.common.f.l lVar) {
        if (lVar == null) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("offer_id", lVar.s());
        hashMap.put("creative_id", lVar.t());
        hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.IS_DEEPLINK_OFFER, java.lang.Integer.valueOf((android.text.TextUtils.isEmpty(lVar.r()) && android.text.TextUtils.isEmpty(lVar.C())) ? 0 : 1));
        if (lVar instanceof com.anythink.core.common.f.ai) {
            com.anythink.core.common.f.ai aiVar = (com.anythink.core.common.f.ai) lVar;
            hashMap.put("dsp_id", aiVar.Z());
            if (aiVar.n() instanceof com.anythink.core.common.f.aj) {
                hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.WS_IMP_SWITCH, java.lang.Integer.valueOf(((com.anythink.core.common.f.aj) aiVar.n()).au()));
            }
            if (lVar instanceof com.anythink.core.common.f.j) {
                hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.WS_ACTION, new com.anythink.basead.b.AnonymousClass1(lVar));
                if (!lVar.H()) {
                    if (aiVar.n().aj() == 1) {
                        hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE, "6");
                    } else if (aiVar.n().ak() > 0) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(aiVar.n().ak());
                        hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE, sb.toString());
                    }
                }
            }
        }
        return hashMap;
    }
}
