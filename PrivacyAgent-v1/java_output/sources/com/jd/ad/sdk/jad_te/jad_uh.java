package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_uh implements com.jd.ad.sdk.jad_ju.jad_ly<java.io.InputStream, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_te.jad_jw jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;

    public static class jad_an implements com.jd.ad.sdk.jad_te.jad_jw.jad_bo {
        public final com.jd.ad.sdk.jad_te.jad_sf jad_an;
        public final com.jd.ad.sdk.jad_ir.jad_dq jad_bo;

        public jad_an(com.jd.ad.sdk.jad_te.jad_sf jad_sfVar, com.jd.ad.sdk.jad_ir.jad_dq jad_dqVar) {
            this.jad_an = jad_sfVar;
            this.jad_bo = jad_dqVar;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an() {
            com.jd.ad.sdk.jad_te.jad_sf jad_sfVar = this.jad_an;
            synchronized (jad_sfVar) {
                jad_sfVar.jad_cp = jad_sfVar.jad_an.length;
            }
        }

        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, android.graphics.Bitmap bitmap) {
            java.io.IOException iOException = this.jad_bo.jad_bo;
            if (iOException != null) {
                if (bitmap == null) {
                    throw iOException;
                }
                jad_erVar.jad_an(bitmap);
                throw iOException;
            }
        }
    }

    public jad_uh(com.jd.ad.sdk.jad_te.jad_jw jad_jwVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_jwVar;
        this.jad_bo = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_te.jad_sf jad_sfVar;
        boolean z;
        com.jd.ad.sdk.jad_ir.jad_dq jad_dqVar;
        java.io.InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof com.jd.ad.sdk.jad_te.jad_sf) {
            jad_sfVar = (com.jd.ad.sdk.jad_te.jad_sf) inputStream2;
            z = false;
        } else {
            jad_sfVar = new com.jd.ad.sdk.jad_te.jad_sf(inputStream2, this.jad_bo, 65536);
            z = true;
        }
        java.util.Queue<com.jd.ad.sdk.jad_ir.jad_dq> queue = com.jd.ad.sdk.jad_ir.jad_dq.jad_cp;
        synchronized (queue) {
            jad_dqVar = (com.jd.ad.sdk.jad_ir.jad_dq) ((java.util.ArrayDeque) queue).poll();
        }
        if (jad_dqVar == null) {
            jad_dqVar = new com.jd.ad.sdk.jad_ir.jad_dq();
        }
        jad_dqVar.jad_an = jad_sfVar;
        com.jd.ad.sdk.jad_ir.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_ir.jad_iv(jad_dqVar);
        com.jd.ad.sdk.jad_te.jad_uh.jad_an jad_anVar = new com.jd.ad.sdk.jad_te.jad_uh.jad_an(jad_sfVar, jad_dqVar);
        try {
            com.jd.ad.sdk.jad_te.jad_jw jad_jwVar2 = this.jad_an;
            return jad_jwVar2.jad_an(new com.jd.ad.sdk.jad_te.jad_ob.jad_bo(jad_ivVar, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, jad_anVar);
        } finally {
            jad_dqVar.jad_bo();
            if (z) {
                jad_sfVar.jad_bo();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_an.getClass();
        return true;
    }
}
