package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public class jad_er {
    public final java.util.List<com.jd.ad.sdk.jad_sb.jad_cp> jad_an;
    public final com.jd.ad.sdk.jad_lu.jad_jt jad_bo;
    public final java.lang.String jad_cp;
    public final long jad_dq;
    public final int jad_er;
    public final long jad_fs;
    public final java.util.List<com.jd.ad.sdk.jad_sb.jad_jt> jad_hu;
    public final com.jd.ad.sdk.jad_ra.jad_ly jad_iv;

    @androidx.annotation.Nullable
    public final java.lang.String jad_jt;
    public final int jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final float jad_mz;
    public final float jad_na;
    public final int jad_ob;
    public final int jad_pc;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_jw jad_qd;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_kx jad_re;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_sf;
    public final java.util.List<com.jd.ad.sdk.jad_yh.jad_an<java.lang.Float>> jad_tg;
    public final int jad_uh;
    public final boolean jad_vi;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_sb.jad_an jad_wj;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ve.jad_jw jad_xk;

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lcom/jd/ad/sdk/jad_sb/jad_cp;>;Lcom/jd/ad/sdk/jad_lu/jad_jt;Ljava/lang/String;JLjava/lang/Object;JLjava/lang/String;Ljava/util/List<Lcom/jd/ad/sdk/jad_sb/jad_jt;>;Lcom/jd/ad/sdk/jad_ra/jad_ly;IIIFFIILcom/jd/ad/sdk/jad_ra/jad_jw;Lcom/jd/ad/sdk/jad_ra/jad_kx;Ljava/util/List<Lcom/jd/ad/sdk/jad_yh/jad_an<Ljava/lang/Float;>;>;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_ra/jad_bo;ZLcom/jd/ad/sdk/jad_sb/jad_an;Lcom/jd/ad/sdk/jad_ve/jad_jw;)V */
    public jad_er(java.util.List list, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, java.lang.String str, long j, int i, long j2, @androidx.annotation.Nullable java.lang.String str2, java.util.List list2, com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar, int i2, int i3, int i4, float f, float f2, int i5, int i6, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_jw jad_jwVar, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_kx jad_kxVar, java.util.List list3, int i7, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, boolean z, @androidx.annotation.Nullable com.jd.ad.sdk.jad_sb.jad_an jad_anVar, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ve.jad_jw jad_jwVar2) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = str;
        this.jad_dq = j;
        this.jad_er = i;
        this.jad_fs = j2;
        this.jad_jt = str2;
        this.jad_hu = list2;
        this.jad_iv = jad_lyVar;
        this.jad_jw = i2;
        this.jad_kx = i3;
        this.jad_ly = i4;
        this.jad_mz = f;
        this.jad_na = f2;
        this.jad_ob = i5;
        this.jad_pc = i6;
        this.jad_qd = jad_jwVar;
        this.jad_re = jad_kxVar;
        this.jad_tg = list3;
        this.jad_uh = i7;
        this.jad_sf = jad_boVar;
        this.jad_vi = z;
        this.jad_wj = jad_anVar;
        this.jad_xk = jad_jwVar2;
    }

    public com.jd.ad.sdk.jad_lu.jad_jt jad_an() {
        return this.jad_bo;
    }

    public java.lang.String jad_an(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(this.jad_cp);
        sb.append("\n");
        com.jd.ad.sdk.jad_tc.jad_er jad_an = this.jad_bo.jad_an(this.jad_fs);
        if (jad_an != null) {
            sb.append("\t\tParents: ");
            sb.append(jad_an.jad_cp);
            com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
            while (true) {
                jad_an = jad_jtVar.jad_an(jad_an.jad_fs);
                if (jad_an == null) {
                    break;
                }
                sb.append("->");
                sb.append(jad_an.jad_cp);
                jad_jtVar = this.jad_bo;
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!this.jad_hu.isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(this.jad_hu.size());
            sb.append("\n");
        }
        if (this.jad_jw != 0 && this.jad_kx != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(java.lang.String.format(java.util.Locale.US, "%dx%d %X\n", java.lang.Integer.valueOf(this.jad_jw), java.lang.Integer.valueOf(this.jad_kx), java.lang.Integer.valueOf(this.jad_ly)));
        }
        if (!this.jad_an.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.jd.ad.sdk.jad_sb.jad_cp jad_cpVar : this.jad_an) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(jad_cpVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public long jad_bo() {
        return this.jad_dq;
    }

    public java.util.List<com.jd.ad.sdk.jad_sb.jad_jt> jad_cp() {
        return this.jad_hu;
    }

    public int jad_dq() {
        return this.jad_uh;
    }

    public java.lang.String jad_er() {
        return this.jad_cp;
    }

    public long jad_fs() {
        return this.jad_fs;
    }

    public int jad_hu() {
        return this.jad_ly;
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ra.jad_jw jad_iv() {
        return this.jad_qd;
    }

    public java.util.List<com.jd.ad.sdk.jad_sb.jad_cp> jad_jt() {
        return this.jad_an;
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ra.jad_kx jad_jw() {
        return this.jad_re;
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ra.jad_bo jad_kx() {
        return this.jad_sf;
    }

    public com.jd.ad.sdk.jad_ra.jad_ly jad_ly() {
        return this.jad_iv;
    }

    public java.lang.String toString() {
        return jad_an("");
    }
}
