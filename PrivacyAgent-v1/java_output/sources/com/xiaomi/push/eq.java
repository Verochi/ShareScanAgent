package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class eq extends com.xiaomi.push.ek {
    public eq() {
        a("PING", (java.lang.String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.ek
    public final java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer) {
        return c().length == 0 ? byteBuffer : super.a(byteBuffer);
    }

    @Override // com.xiaomi.push.ek
    public final int d() {
        if (c().length == 0) {
            return 0;
        }
        return super.d();
    }
}
