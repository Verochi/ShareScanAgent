package com.jd.ad.sdk.jad_oz;

/* loaded from: classes23.dex */
public class jad_jw {
    public final com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, java.lang.String> jad_an = new com.jd.ad.sdk.jad_ir.jad_hu<>(1000);
    public final androidx.core.util.Pools.Pool<com.jd.ad.sdk.jad_oz.jad_jw.jad_bo> jad_bo = com.jd.ad.sdk.jad_js.jad_an.jad_an(10, new com.jd.ad.sdk.jad_oz.jad_jw.jad_an(this));

    public class jad_an implements com.jd.ad.sdk.jad_js.jad_an.jad_bo<com.jd.ad.sdk.jad_oz.jad_jw.jad_bo> {
        public jad_an(com.jd.ad.sdk.jad_oz.jad_jw jad_jwVar) {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_bo
        public com.jd.ad.sdk.jad_oz.jad_jw.jad_bo jad_an() {
            try {
                return new com.jd.ad.sdk.jad_oz.jad_jw.jad_bo(java.security.MessageDigest.getInstance("SHA-256"));
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_js.jad_an.jad_dq {
        public final java.security.MessageDigest jad_an;
        public final com.jd.ad.sdk.jad_js.jad_dq jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();

        public jad_bo(java.security.MessageDigest messageDigest) {
            this.jad_an = messageDigest;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
            return this.jad_bo;
        }
    }

    public java.lang.String jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        java.lang.String jad_an2;
        synchronized (this.jad_an) {
            jad_an2 = this.jad_an.jad_an((com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, java.lang.String>) jad_huVar);
        }
        if (jad_an2 == null) {
            com.jd.ad.sdk.jad_oz.jad_jw.jad_bo jad_boVar = (com.jd.ad.sdk.jad_oz.jad_jw.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_bo.acquire());
            try {
                jad_huVar.jad_an(jad_boVar.jad_an);
                byte[] digest = jad_boVar.jad_an.digest();
                char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_bo;
                synchronized (cArr) {
                    for (int i = 0; i < digest.length; i++) {
                        int i2 = digest[i] & 255;
                        int i3 = i * 2;
                        char[] cArr2 = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
                        cArr[i3] = cArr2[i2 >>> 4];
                        cArr[i3 + 1] = cArr2[i2 & 15];
                    }
                    jad_an2 = new java.lang.String(cArr);
                }
            } finally {
                this.jad_bo.release(jad_boVar);
            }
        }
        synchronized (this.jad_an) {
            this.jad_an.jad_bo(jad_huVar, jad_an2);
        }
        return jad_an2;
    }
}
