package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_fs {
    public static final com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_bo = new com.jd.ad.sdk.jad_kv.jad_fs.jad_an();
    public final java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>> jad_an = new java.util.HashMap();

    public class jad_an implements com.jd.ad.sdk.jad_kv.jad_er.jad_an<java.lang.Object> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kv.jad_er<java.lang.Object> jad_an(@androidx.annotation.NonNull java.lang.Object obj) {
            return new com.jd.ad.sdk.jad_kv.jad_fs.jad_bo(obj);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public java.lang.Class<java.lang.Object> jad_an() {
            throw new java.lang.UnsupportedOperationException("Not implemented");
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_kv.jad_er<java.lang.Object> {
        public final java.lang.Object jad_an;

        public jad_bo(@androidx.annotation.NonNull java.lang.Object obj) {
            this.jad_an = obj;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er
        @androidx.annotation.NonNull
        public java.lang.Object jad_an() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er
        public void jad_bo() {
        }
    }
}
