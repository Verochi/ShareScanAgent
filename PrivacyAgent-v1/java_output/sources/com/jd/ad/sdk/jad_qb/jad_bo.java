package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_bo<Data> implements com.jd.ad.sdk.jad_qb.jad_na<byte[], Data> {
    public final com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<Data> jad_an;

    public static class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<byte[], java.nio.ByteBuffer> {

        /* renamed from: com.jd.ad.sdk.jad_qb.jad_bo$jad_an$jad_an, reason: collision with other inner class name */
        public class C0404jad_an implements com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<java.nio.ByteBuffer> {
            public C0404jad_an(com.jd.ad.sdk.jad_qb.jad_bo.jad_an jad_anVar) {
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo
            public java.lang.Class<java.nio.ByteBuffer> jad_an() {
                return java.nio.ByteBuffer.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo
            public java.nio.ByteBuffer jad_an(byte[] bArr) {
                return java.nio.ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<byte[], java.nio.ByteBuffer> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_bo(new com.jd.ad.sdk.jad_qb.jad_bo.jad_an.C0404jad_an(this));
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_qb.jad_bo$jad_bo, reason: collision with other inner class name */
    public interface InterfaceC0405jad_bo<Data> {
        java.lang.Class<Data> jad_an();

        Data jad_an(byte[] bArr);
    }

    public static class jad_cp<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final byte[] jad_an;
        public final com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<Data> jad_bo;

        public jad_cp(byte[] bArr, com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<Data> interfaceC0405jad_bo) {
            this.jad_an = bArr;
            this.jad_bo = interfaceC0405jad_bo;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<Data> jad_an() {
            return this.jad_bo.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data>) this.jad_bo.jad_an(this.jad_an));
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public static class jad_dq implements com.jd.ad.sdk.jad_qb.jad_ob<byte[], java.io.InputStream> {

        public class jad_an implements com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<java.io.InputStream> {
            public jad_an(com.jd.ad.sdk.jad_qb.jad_bo.jad_dq jad_dqVar) {
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo
            public java.lang.Class<java.io.InputStream> jad_an() {
                return java.io.InputStream.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo
            public java.io.InputStream jad_an(byte[] bArr) {
                return new java.io.ByteArrayInputStream(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<byte[], java.io.InputStream> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_bo(new com.jd.ad.sdk.jad_qb.jad_bo.jad_dq.jad_an(this));
        }
    }

    public jad_bo(com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0405jad_bo<Data> interfaceC0405jad_bo) {
        this.jad_an = interfaceC0405jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        byte[] bArr2 = bArr;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(bArr2), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_bo.jad_cp(bArr2, this.jad_an));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull byte[] bArr) {
        return true;
    }
}
