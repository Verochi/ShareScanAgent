package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_re implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final java.lang.String jad_an;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_bo;
    public final java.util.List<com.jd.ad.sdk.jad_ra.jad_bo> jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_an jad_dq;
    public final com.jd.ad.sdk.jad_ra.jad_dq jad_er;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_fs;
    public final int jad_hu;
    public final float jad_iv;
    public final int jad_jt;
    public final boolean jad_jw;

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;
        public static final /* synthetic */ int[] jad_bo;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_bo = iArr;
            try {
                iArr[2] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_bo[0] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_bo[1] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr2;
            try {
                iArr2[0] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                jad_an[1] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                jad_an[2] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lcom/jd/ad/sdk/jad_ra/jad_bo;Ljava/util/List<Lcom/jd/ad/sdk/jad_ra/jad_bo;>;Lcom/jd/ad/sdk/jad_ra/jad_an;Lcom/jd/ad/sdk/jad_ra/jad_dq;Lcom/jd/ad/sdk/jad_ra/jad_bo;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public jad_re(java.lang.String str, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, java.util.List list, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2, int i, int i2, float f, boolean z) {
        this.jad_an = str;
        this.jad_bo = jad_boVar;
        this.jad_cp = list;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_dqVar;
        this.jad_fs = jad_boVar2;
        this.jad_jt = i;
        this.jad_hu = i2;
        this.jad_iv = f;
        this.jad_jw = z;
    }

    public int jad_an() {
        return this.jad_jt;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_re(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_ra.jad_an jad_bo() {
        return this.jad_dq;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_cp() {
        return this.jad_bo;
    }

    public int jad_dq() {
        return this.jad_hu;
    }

    public java.util.List<com.jd.ad.sdk.jad_ra.jad_bo> jad_er() {
        return this.jad_cp;
    }

    public float jad_fs() {
        return this.jad_iv;
    }

    public com.jd.ad.sdk.jad_ra.jad_dq jad_hu() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_iv() {
        return this.jad_fs;
    }

    public java.lang.String jad_jt() {
        return this.jad_an;
    }

    public boolean jad_jw() {
        return this.jad_jw;
    }
}
