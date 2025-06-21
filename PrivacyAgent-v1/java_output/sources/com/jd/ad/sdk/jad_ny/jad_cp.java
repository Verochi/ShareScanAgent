package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ny.jad_ly {
    public final com.jd.ad.sdk.jad_ny.jad_cp.jad_bo jad_an = new com.jd.ad.sdk.jad_ny.jad_cp.jad_bo();
    public final com.jd.ad.sdk.jad_ny.jad_hu<com.jd.ad.sdk.jad_ny.jad_cp.jad_an, android.graphics.Bitmap> jad_bo = new com.jd.ad.sdk.jad_ny.jad_hu<>();

    @androidx.annotation.VisibleForTesting
    public static class jad_an implements com.jd.ad.sdk.jad_ny.jad_mz {
        public final com.jd.ad.sdk.jad_ny.jad_cp.jad_bo jad_an;
        public int jad_bo;
        public int jad_cp;
        public android.graphics.Bitmap.Config jad_dq;

        public jad_an(com.jd.ad.sdk.jad_ny.jad_cp.jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.jd.ad.sdk.jad_ny.jad_cp.jad_an)) {
                return false;
            }
            com.jd.ad.sdk.jad_ny.jad_cp.jad_an jad_anVar = (com.jd.ad.sdk.jad_ny.jad_cp.jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp && this.jad_dq == jad_anVar.jad_dq;
        }

        public int hashCode() {
            int i = ((this.jad_bo * 31) + this.jad_cp) * 31;
            android.graphics.Bitmap.Config config = this.jad_dq;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            com.jd.ad.sdk.jad_ny.jad_cp.jad_bo jad_boVar = this.jad_an;
            if (jad_boVar.jad_an.size() < 20) {
                jad_boVar.jad_an.offer(this);
            }
        }

        public java.lang.String toString() {
            return com.jd.ad.sdk.jad_ny.jad_cp.jad_cp(this.jad_bo, this.jad_cp, this.jad_dq);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class jad_bo extends com.jd.ad.sdk.jad_ny.jad_dq<com.jd.ad.sdk.jad_ny.jad_cp.jad_an> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public com.jd.ad.sdk.jad_ny.jad_cp.jad_an jad_an() {
            return new com.jd.ad.sdk.jad_ny.jad_cp.jad_an(this);
        }
    }

    public static java.lang.String jad_cp(int i, int i2, android.graphics.Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public android.graphics.Bitmap jad_an() {
        return this.jad_bo.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public android.graphics.Bitmap jad_an(int i, int i2, android.graphics.Bitmap.Config config) {
        com.jd.ad.sdk.jad_ny.jad_cp.jad_an jad_bo2 = this.jad_an.jad_bo();
        jad_bo2.jad_bo = i;
        jad_bo2.jad_cp = i2;
        jad_bo2.jad_dq = config;
        return this.jad_bo.jad_an(jad_bo2);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public void jad_an(android.graphics.Bitmap bitmap) {
        com.jd.ad.sdk.jad_ny.jad_cp.jad_bo jad_boVar = this.jad_an;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap.Config config = bitmap.getConfig();
        com.jd.ad.sdk.jad_ny.jad_cp.jad_an jad_bo2 = jad_boVar.jad_bo();
        jad_bo2.jad_bo = width;
        jad_bo2.jad_cp = height;
        jad_bo2.jad_dq = config;
        this.jad_bo.jad_an(jad_bo2, bitmap);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public java.lang.String jad_bo(int i, int i2, android.graphics.Bitmap.Config config) {
        return jad_cp(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public java.lang.String jad_bo(android.graphics.Bitmap bitmap) {
        return jad_cp(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public int jad_cp(android.graphics.Bitmap bitmap) {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("AttributeStrategy:\n  ");
        jad_an2.append(this.jad_bo);
        return jad_an2.toString();
    }
}
