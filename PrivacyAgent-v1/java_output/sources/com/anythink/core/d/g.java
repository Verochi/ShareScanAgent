package com.anythink.core.d;

/* loaded from: classes12.dex */
public final class g {
    private final com.anythink.core.d.f a;

    /* renamed from: com.anythink.core.d.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.d.e a;
        final /* synthetic */ com.anythink.core.common.f.al b;

        public AnonymousClass1(com.anythink.core.d.e eVar, com.anythink.core.common.f.al alVar) {
            this.a = eVar;
            this.b = alVar;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            if (obj instanceof org.json.JSONObject) {
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                try {
                    jSONObject.put(com.anythink.core.d.e.a.ad, java.lang.System.currentTimeMillis());
                    com.anythink.core.d.e eVar = this.a;
                    if (eVar != null) {
                        eVar.a(jSONObject, this.b.c());
                    }
                } catch (java.lang.Throwable th) {
                    new java.lang.StringBuilder("parse place strategy error:").append(th.getMessage());
                }
                com.anythink.core.d.e a = com.anythink.core.d.e.a(jSONObject);
                if (com.anythink.core.d.g.this.a == null || a == null) {
                    return;
                }
                a.a(2);
                com.anythink.core.d.f fVar = com.anythink.core.d.g.this.a;
                java.lang.String c = this.b.c();
                if (a.ai() != 1) {
                    jSONObject = null;
                }
                fVar.a(c, a, jSONObject, 2);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    public g(com.anythink.core.d.f fVar) {
        this.a = fVar;
    }

    public static void a(android.content.Context context, com.anythink.core.common.f.al alVar, com.anythink.core.common.h.k kVar) {
        new com.anythink.core.common.h.l(context, alVar).a(0, kVar);
    }

    public final void a(android.content.Context context, com.anythink.core.common.f.al alVar) {
        if (alVar == null) {
            return;
        }
        com.anythink.core.d.e d = this.a.d(alVar.c());
        if (d != null) {
            alVar.a(d.az());
        } else {
            alVar.a((java.util.Map<java.lang.String, java.lang.String>) null);
        }
        new com.anythink.core.common.h.l(context, alVar).a(0, (com.anythink.core.common.h.k) new com.anythink.core.d.g.AnonymousClass1(d, alVar));
    }
}
