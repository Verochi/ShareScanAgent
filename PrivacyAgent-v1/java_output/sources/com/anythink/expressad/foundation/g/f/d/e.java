package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public abstract class e<T> extends com.anythink.expressad.foundation.g.f.i<T> {
    private static final java.lang.String c = "e";
    private final java.lang.String d;

    public e(int i, java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.f.e<T> eVar) {
        super(i, str, eVar);
        this.d = str2;
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
