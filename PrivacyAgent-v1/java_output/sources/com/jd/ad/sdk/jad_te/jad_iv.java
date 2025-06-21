package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public abstract class jad_iv {
    public static final com.jd.ad.sdk.jad_te.jad_iv jad_an = new com.jd.ad.sdk.jad_te.jad_iv.jad_bo();
    public static final com.jd.ad.sdk.jad_te.jad_iv jad_bo;
    public static final com.jd.ad.sdk.jad_te.jad_iv jad_cp;
    public static final com.jd.ad.sdk.jad_ju.jad_iv<com.jd.ad.sdk.jad_te.jad_iv> jad_dq;
    public static final boolean jad_er;

    public static class jad_an extends com.jd.ad.sdk.jad_te.jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return java.lang.Math.max(i3 / i, i4 / i2);
        }
    }

    public static class jad_bo extends com.jd.ad.sdk.jad_te.jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return com.jd.ad.sdk.jad_te.jad_iv.jad_er ? 2 : 1;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            if (com.jd.ad.sdk.jad_te.jad_iv.jad_er) {
                return java.lang.Math.min(i3 / i, i4 / i2);
            }
            if (java.lang.Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / java.lang.Integer.highestOneBit(r2);
        }
    }

    public static class jad_cp extends com.jd.ad.sdk.jad_te.jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        com.jd.ad.sdk.jad_te.jad_iv.jad_an jad_anVar = new com.jd.ad.sdk.jad_te.jad_iv.jad_an();
        jad_bo = new com.jd.ad.sdk.jad_te.jad_iv.jad_cp();
        jad_cp = jad_anVar;
        jad_dq = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jad_anVar);
        jad_er = true;
    }

    public abstract int jad_an(int i, int i2, int i3, int i4);

    public abstract float jad_bo(int i, int i2, int i3, int i4);
}
