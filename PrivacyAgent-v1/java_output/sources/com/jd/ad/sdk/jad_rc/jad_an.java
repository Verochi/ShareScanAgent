package com.jd.ad.sdk.jad_rc;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, java.io.InputStream> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Integer> jad_bo = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_qb.jad_mz<com.jd.ad.sdk.jad_qb.jad_jt, com.jd.ad.sdk.jad_qb.jad_jt> jad_an;

    /* renamed from: com.jd.ad.sdk.jad_rc.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0407jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<com.jd.ad.sdk.jad_qb.jad_jt, java.io.InputStream> {
        public final com.jd.ad.sdk.jad_qb.jad_mz<com.jd.ad.sdk.jad_qb.jad_jt, com.jd.ad.sdk.jad_qb.jad_jt> jad_an = new com.jd.ad.sdk.jad_qb.jad_mz<>(500);

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_rc.jad_an(this.jad_an);
        }
    }

    public jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_qb.jad_mz<com.jd.ad.sdk.jad_qb.jad_jt, com.jd.ad.sdk.jad_qb.jad_jt> jad_mzVar) {
        this.jad_an = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.io.InputStream> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar2 = jad_jtVar;
        com.jd.ad.sdk.jad_qb.jad_mz<com.jd.ad.sdk.jad_qb.jad_jt, com.jd.ad.sdk.jad_qb.jad_jt> jad_mzVar = this.jad_an;
        if (jad_mzVar != null) {
            com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<com.jd.ad.sdk.jad_qb.jad_jt> jad_an = com.jd.ad.sdk.jad_qb.jad_mz.jad_bo.jad_an(jad_jtVar2, 0, 0);
            com.jd.ad.sdk.jad_qb.jad_jt jad_an2 = jad_mzVar.jad_an.jad_an((com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<com.jd.ad.sdk.jad_qb.jad_jt>, com.jd.ad.sdk.jad_qb.jad_jt>) jad_an);
            java.util.Queue<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<?>> queue = com.jd.ad.sdk.jad_qb.jad_mz.jad_bo.jad_dq;
            synchronized (queue) {
                ((java.util.ArrayDeque) queue).offer(jad_an);
            }
            com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar3 = jad_an2;
            if (jad_jtVar3 == null) {
                com.jd.ad.sdk.jad_qb.jad_mz<com.jd.ad.sdk.jad_qb.jad_jt, com.jd.ad.sdk.jad_qb.jad_jt> jad_mzVar2 = this.jad_an;
                jad_mzVar2.getClass();
                jad_mzVar2.jad_an.jad_bo(com.jd.ad.sdk.jad_qb.jad_mz.jad_bo.jad_an(jad_jtVar2, 0, 0), jad_jtVar2);
            } else {
                jad_jtVar2 = jad_jtVar3;
            }
        }
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(jad_jtVar2, java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_kv.jad_jw(jad_jtVar2, ((java.lang.Integer) jad_jwVar.jad_an(jad_bo)).intValue(), com.jd.ad.sdk.jad_kv.jad_jw.jad_fs));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar) {
        return true;
    }
}
