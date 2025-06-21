package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_mz<A, B> {
    public final com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<A>, B> jad_an;

    public class jad_an extends com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<A>, B> {
        public jad_an(com.jd.ad.sdk.jad_qb.jad_mz jad_mzVar, long j) {
            super(j);
        }

        @Override // com.jd.ad.sdk.jad_ir.jad_hu
        public void jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
            com.jd.ad.sdk.jad_qb.jad_mz.jad_bo jad_boVar = (com.jd.ad.sdk.jad_qb.jad_mz.jad_bo) obj;
            jad_boVar.getClass();
            java.util.Queue<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<?>> queue = com.jd.ad.sdk.jad_qb.jad_mz.jad_bo.jad_dq;
            synchronized (queue) {
                ((java.util.ArrayDeque) queue).offer(jad_boVar);
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class jad_bo<A> {
        public static final java.util.Queue<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<?>> jad_dq;
        public int jad_an;
        public int jad_bo;
        public A jad_cp;

        static {
            char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
            jad_dq = new java.util.ArrayDeque(0);
        }

        public static <A> com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<A> jad_an(A a, int i, int i2) {
            com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<A> jad_boVar;
            java.util.Queue<com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<?>> queue = jad_dq;
            synchronized (queue) {
                jad_boVar = (com.jd.ad.sdk.jad_qb.jad_mz.jad_bo) ((java.util.ArrayDeque) queue).poll();
            }
            if (jad_boVar == null) {
                jad_boVar = new com.jd.ad.sdk.jad_qb.jad_mz.jad_bo<>();
            }
            jad_boVar.jad_cp = a;
            jad_boVar.jad_bo = i;
            jad_boVar.jad_an = i2;
            return jad_boVar;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.jd.ad.sdk.jad_qb.jad_mz.jad_bo)) {
                return false;
            }
            com.jd.ad.sdk.jad_qb.jad_mz.jad_bo jad_boVar = (com.jd.ad.sdk.jad_qb.jad_mz.jad_bo) obj;
            return this.jad_bo == jad_boVar.jad_bo && this.jad_an == jad_boVar.jad_an && this.jad_cp.equals(jad_boVar.jad_cp);
        }

        public int hashCode() {
            return this.jad_cp.hashCode() + (((this.jad_an * 31) + this.jad_bo) * 31);
        }
    }

    public jad_mz(long j) {
        this.jad_an = new com.jd.ad.sdk.jad_qb.jad_mz.jad_an(this, j);
    }
}
