package com.jd.ad.sdk.jad_uf;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.jad_kv.jad_er<java.nio.ByteBuffer> {
    public final java.nio.ByteBuffer jad_an;

    /* renamed from: com.jd.ad.sdk.jad_uf.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0411jad_an implements com.jd.ad.sdk.jad_kv.jad_er.jad_an<java.nio.ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kv.jad_er<java.nio.ByteBuffer> jad_an(java.nio.ByteBuffer byteBuffer) {
            return new com.jd.ad.sdk.jad_uf.jad_an(byteBuffer);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public java.lang.Class<java.nio.ByteBuffer> jad_an() {
            return java.nio.ByteBuffer.class;
        }
    }

    public jad_an(java.nio.ByteBuffer byteBuffer) {
        this.jad_an = byteBuffer;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    @androidx.annotation.NonNull
    public java.nio.ByteBuffer jad_an() {
        this.jad_an.position(0);
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
    }
}
