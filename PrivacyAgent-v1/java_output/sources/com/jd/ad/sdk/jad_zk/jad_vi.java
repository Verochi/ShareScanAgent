package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public final class jad_vi implements com.jd.ad.sdk.jad_zk.jad_mz {
    public final java.util.Set<com.jd.ad.sdk.jad_fo.jad_er<?>> jad_an = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_an() {
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_fo.jad_er) it.next()).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_cp() {
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_fo.jad_er) it.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_dq() {
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_fo.jad_er) it.next()).jad_dq();
        }
    }
}
