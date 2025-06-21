package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public abstract class jad_ly {
    public static final com.jd.ad.sdk.jad_mx.jad_ly jad_an = new com.jd.ad.sdk.jad_mx.jad_ly.jad_an();
    public static final com.jd.ad.sdk.jad_mx.jad_ly jad_bo = new com.jd.ad.sdk.jad_mx.jad_ly.jad_bo();
    public static final com.jd.ad.sdk.jad_mx.jad_ly jad_cp = new com.jd.ad.sdk.jad_mx.jad_ly.jad_cp();

    public class jad_an extends com.jd.ad.sdk.jad_mx.jad_ly {
        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_ju.jad_an jad_anVar) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_cp jad_cpVar) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_bo() {
            return false;
        }
    }

    public class jad_bo extends com.jd.ad.sdk.jad_mx.jad_ly {
        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_ju.jad_an jad_anVar) {
            return (jad_anVar == com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE || jad_anVar == com.jd.ad.sdk.jad_ju.jad_an.MEMORY_CACHE) ? false : true;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_cp jad_cpVar) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_bo() {
            return false;
        }
    }

    public class jad_cp extends com.jd.ad.sdk.jad_mx.jad_ly {
        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_ju.jad_an jad_anVar) {
            return jad_anVar == com.jd.ad.sdk.jad_ju.jad_an.REMOTE;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_cp jad_cpVar) {
            return ((z && jad_anVar == com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE) || jad_anVar == com.jd.ad.sdk.jad_ju.jad_an.LOCAL) && jad_cpVar == com.jd.ad.sdk.jad_ju.jad_cp.TRANSFORMED;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_ly
        public boolean jad_bo() {
            return true;
        }
    }

    public abstract boolean jad_an();

    public abstract boolean jad_an(com.jd.ad.sdk.jad_ju.jad_an jad_anVar);

    public abstract boolean jad_an(boolean z, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_cp jad_cpVar);

    public abstract boolean jad_bo();
}
