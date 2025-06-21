package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public class g extends com.anythink.expressad.foundation.g.f.i<java.lang.String> {
    private static final java.lang.String c = "g";
    private java.lang.String d;

    public g(int i, java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.f.e<java.lang.String> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final com.anythink.expressad.foundation.g.f.k<java.lang.String> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return com.anythink.expressad.foundation.g.f.k.a(new java.lang.String(cVar.b, com.anythink.expressad.foundation.g.f.g.d.a(cVar.d)), cVar);
        } catch (java.io.UnsupportedEncodingException e) {
            e.getMessage();
            return com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        try {
            java.lang.String str = this.d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }
}
