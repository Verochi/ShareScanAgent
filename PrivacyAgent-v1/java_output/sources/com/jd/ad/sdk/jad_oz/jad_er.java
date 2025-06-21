package com.jd.ad.sdk.jad_oz;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_oz.jad_an {
    public final java.io.File jad_bo;
    public final long jad_cp;
    public com.jd.ad.sdk.jad_hs.jad_an jad_er;
    public final com.jd.ad.sdk.jad_oz.jad_cp jad_dq = new com.jd.ad.sdk.jad_oz.jad_cp();
    public final com.jd.ad.sdk.jad_oz.jad_jw jad_an = new com.jd.ad.sdk.jad_oz.jad_jw();

    @java.lang.Deprecated
    public jad_er(java.io.File file, long j) {
        this.jad_bo = file;
        this.jad_cp = j;
    }

    public final synchronized com.jd.ad.sdk.jad_hs.jad_an jad_an() {
        if (this.jad_er == null) {
            java.io.File file = this.jad_bo;
            long j = this.jad_cp;
            if (j <= 0) {
                throw new java.lang.IllegalArgumentException("maxSize <= 0");
            }
            java.io.File file2 = new java.io.File(file, "journal.bkp");
            if (file2.exists()) {
                java.io.File file3 = new java.io.File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    com.jd.ad.sdk.jad_hs.jad_an.jad_an(file2, file3, false);
                }
            }
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j);
            if (jad_anVar.jad_bo.exists()) {
                try {
                    jad_anVar.jad_er();
                    jad_anVar.jad_dq();
                } catch (java.io.IOException e) {
                    java.lang.System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    jad_anVar.close();
                    com.jd.ad.sdk.jad_hs.jad_cp.jad_an(jad_anVar.jad_an);
                }
                this.jad_er = jad_anVar;
            }
            file.mkdirs();
            jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j);
            jad_anVar.jad_fs();
            this.jad_er = jad_anVar;
        }
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public java.io.File jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        java.lang.String jad_an = this.jad_an.jad_an(jad_huVar);
        if (android.util.Log.isLoggable("DiskLruCacheWrapper", 2)) {
            com.jd.ad.sdk.logger.Logger.v("DiskLruCacheWrapper", "Get: Obtained: " + jad_an + " for for Key: " + jad_huVar);
        }
        try {
            com.jd.ad.sdk.jad_hs.jad_an.jad_er jad_bo = jad_an().jad_bo(jad_an);
            if (jad_bo != null) {
                return jad_bo.jad_an(0);
            }
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable("DiskLruCacheWrapper", 5)) {
                com.jd.ad.sdk.logger.Logger.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, com.jd.ad.sdk.jad_oz.jad_an.jad_bo jad_boVar) {
        com.jd.ad.sdk.jad_oz.jad_cp.jad_an jad_anVar;
        com.jd.ad.sdk.jad_hs.jad_an jad_an;
        boolean z;
        java.lang.String jad_an2 = this.jad_an.jad_an(jad_huVar);
        com.jd.ad.sdk.jad_oz.jad_cp jad_cpVar = this.jad_dq;
        synchronized (jad_cpVar) {
            jad_anVar = jad_cpVar.jad_an.get(jad_an2);
            if (jad_anVar == null) {
                com.jd.ad.sdk.jad_oz.jad_cp.jad_bo jad_boVar2 = jad_cpVar.jad_bo;
                synchronized (jad_boVar2.jad_an) {
                    jad_anVar = jad_boVar2.jad_an.poll();
                }
                if (jad_anVar == null) {
                    jad_anVar = new com.jd.ad.sdk.jad_oz.jad_cp.jad_an();
                }
                jad_cpVar.jad_an.put(jad_an2, jad_anVar);
            }
            jad_anVar.jad_bo++;
        }
        jad_anVar.jad_an.lock();
        try {
            if (android.util.Log.isLoggable("DiskLruCacheWrapper", 2)) {
                com.jd.ad.sdk.logger.Logger.v("DiskLruCacheWrapper", "Put: Obtained: " + jad_an2 + " for for Key: " + jad_huVar);
            }
            try {
                jad_an = jad_an();
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (jad_an.jad_bo(jad_an2) != null) {
                return;
            }
            com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_an3 = jad_an.jad_an(jad_an2);
            if (jad_an3 == null) {
                throw new java.lang.IllegalStateException("Had two simultaneous puts for: " + jad_an2);
            }
            try {
                com.jd.ad.sdk.jad_mx.jad_er jad_erVar = (com.jd.ad.sdk.jad_mx.jad_er) jad_boVar;
                if (jad_erVar.jad_an.jad_an(jad_erVar.jad_bo, jad_an3.jad_an(0), jad_erVar.jad_cp)) {
                    com.jd.ad.sdk.jad_hs.jad_an.jad_an(com.jd.ad.sdk.jad_hs.jad_an.this, jad_an3, true);
                    jad_an3.jad_cp = true;
                }
                if (!z) {
                    try {
                        jad_an3.jad_an();
                    } catch (java.io.IOException unused) {
                    }
                }
            } finally {
                if (!jad_an3.jad_cp) {
                    try {
                        jad_an3.jad_an();
                    } catch (java.io.IOException unused2) {
                    }
                }
            }
        } finally {
            this.jad_dq.jad_an(jad_an2);
        }
    }
}
