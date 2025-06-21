package com.loc;

/* loaded from: classes23.dex */
public final class cz extends com.loc.gf {
    public cz(java.nio.ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.loc.gf
    public final int a(java.lang.CharSequence charSequence) {
        try {
            return super.a(charSequence);
        } catch (java.lang.Throwable th) {
            com.loc.el.a(th);
            return super.a("");
        }
    }
}
