package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_qb.jad_na<java.io.File, java.nio.ByteBuffer> {

    public static final class jad_an implements com.jd.ad.sdk.jad_kv.jad_dq<java.nio.ByteBuffer> {
        public final java.io.File jad_an;

        public jad_an(java.io.File file) {
            this.jad_an = file;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<java.nio.ByteBuffer> jad_an() {
            return java.nio.ByteBuffer.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.nio.ByteBuffer> jad_anVar) {
            try {
                jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.nio.ByteBuffer>) com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an));
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable("ByteBufferFileLoader", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                jad_anVar.jad_an((java.lang.Exception) e);
            }
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

    public static class jad_bo implements com.jd.ad.sdk.jad_qb.jad_ob<java.io.File, java.nio.ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.io.File, java.nio.ByteBuffer> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_dq();
        }
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.nio.ByteBuffer> jad_an(@androidx.annotation.NonNull java.io.File file, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        java.io.File file2 = file;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(file2), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_dq.jad_an(file2));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.io.File file) {
        return true;
    }
}
