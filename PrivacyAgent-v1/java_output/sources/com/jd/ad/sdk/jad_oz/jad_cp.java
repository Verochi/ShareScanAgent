package com.jd.ad.sdk.jad_oz;

/* loaded from: classes23.dex */
public final class jad_cp {
    public final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_oz.jad_cp.jad_an> jad_an = new java.util.HashMap();
    public final com.jd.ad.sdk.jad_oz.jad_cp.jad_bo jad_bo = new com.jd.ad.sdk.jad_oz.jad_cp.jad_bo();

    public static class jad_an {
        public final java.util.concurrent.locks.Lock jad_an = new java.util.concurrent.locks.ReentrantLock();
        public int jad_bo;
    }

    public static class jad_bo {
        public final java.util.Queue<com.jd.ad.sdk.jad_oz.jad_cp.jad_an> jad_an = new java.util.ArrayDeque();
    }

    public void jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_oz.jad_cp.jad_an jad_anVar;
        synchronized (this) {
            jad_anVar = (com.jd.ad.sdk.jad_oz.jad_cp.jad_an) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_an.get(str));
            int i = jad_anVar.jad_bo;
            if (i < 1) {
                throw new java.lang.IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + jad_anVar.jad_bo);
            }
            int i2 = i - 1;
            jad_anVar.jad_bo = i2;
            if (i2 == 0) {
                com.jd.ad.sdk.jad_oz.jad_cp.jad_an remove = this.jad_an.remove(str);
                if (!remove.equals(jad_anVar)) {
                    throw new java.lang.IllegalStateException("Removed the wrong lock, expected to remove: " + jad_anVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                com.jd.ad.sdk.jad_oz.jad_cp.jad_bo jad_boVar = this.jad_bo;
                synchronized (jad_boVar.jad_an) {
                    if (jad_boVar.jad_an.size() < 10) {
                        jad_boVar.jad_an.offer(remove);
                    }
                }
            }
        }
        jad_anVar.jad_an.unlock();
    }
}
