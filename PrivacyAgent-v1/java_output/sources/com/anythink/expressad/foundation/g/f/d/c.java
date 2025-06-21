package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public class c extends com.anythink.expressad.foundation.g.f.d.e<org.json.JSONArray> {
    private static final java.lang.String c = "c";

    public c(int i, java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.f.e<org.json.JSONArray> eVar) {
        super(i, str, str2, eVar);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final com.anythink.expressad.foundation.g.f.k<org.json.JSONArray> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return com.anythink.expressad.foundation.g.f.k.a(new org.json.JSONArray(new java.lang.String(cVar.b, com.anythink.expressad.foundation.g.f.g.d.a(cVar.d))), cVar);
        } catch (java.io.UnsupportedEncodingException e) {
            e.getMessage();
            return com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        } catch (org.json.JSONException e2) {
            e2.getMessage();
            return com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
