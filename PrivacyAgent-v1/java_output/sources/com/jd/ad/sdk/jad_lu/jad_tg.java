package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_tg implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.jad_lu.jad_uh jad_an;

    public jad_tg(com.jd.ad.sdk.jad_lu.jad_uh jad_uhVar) {
        this.jad_an = jad_uhVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.jad_an.jad_dq == null) {
            return;
        }
        com.jd.ad.sdk.jad_lu.jad_sf<T> jad_sfVar = this.jad_an.jad_dq;
        V v = jad_sfVar.jad_an;
        if (v != 0) {
            com.jd.ad.sdk.jad_lu.jad_uh jad_uhVar = this.jad_an;
            synchronized (jad_uhVar) {
                java.util.Iterator it = new java.util.ArrayList(jad_uhVar.jad_an).iterator();
                while (it.hasNext()) {
                    ((com.jd.ad.sdk.jad_lu.jad_ob) it.next()).jad_an(v);
                }
            }
            return;
        }
        com.jd.ad.sdk.jad_lu.jad_uh jad_uhVar2 = this.jad_an;
        java.lang.Throwable th = jad_sfVar.jad_bo;
        synchronized (jad_uhVar2) {
            java.util.ArrayList arrayList = new java.util.ArrayList(jad_uhVar2.jad_bo);
            if (arrayList.isEmpty()) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Lottie encountered an error but no failure listener was added:", th);
            } else {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((com.jd.ad.sdk.jad_lu.jad_ob) it2.next()).jad_an(th);
                }
            }
        }
    }
}
