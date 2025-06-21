package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_vi<Data, ResourceType, Transcode> {
    public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_an;
    public final java.util.List<? extends com.jd.ad.sdk.jad_mx.jad_kx<Data, ResourceType, Transcode>> jad_bo;
    public final java.lang.String jad_cp;

    public jad_vi(java.lang.Class<Data> cls, java.lang.Class<ResourceType> cls2, java.lang.Class<Transcode> cls3, java.util.List<com.jd.ad.sdk.jad_mx.jad_kx<Data, ResourceType, Transcode>> list, androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.jad_an = pool;
        this.jad_bo = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed LoadPath{");
        jad_an.append(cls.getSimpleName());
        jad_an.append("->");
        jad_an.append(cls2.getSimpleName());
        jad_an.append("->");
        jad_an.append(cls3.getSimpleName());
        jad_an.append(com.alipay.sdk.m.u.i.d);
        this.jad_cp = jad_an.toString();
    }

    public com.jd.ad.sdk.jad_mx.jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_kv.jad_er<Data> jad_erVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, int i, int i2, com.jd.ad.sdk.jad_mx.jad_kx.jad_an<ResourceType> jad_anVar) {
        java.util.List<java.lang.Throwable> list = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_an.acquire());
        try {
            int size = this.jad_bo.size();
            com.jd.ad.sdk.jad_mx.jad_xk<Transcode> jad_xkVar = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    jad_xkVar = this.jad_bo.get(i3).jad_an(jad_erVar, i, i2, jad_jwVar, jad_anVar);
                } catch (com.jd.ad.sdk.jad_mx.jad_sf e) {
                    list.add(e);
                }
                if (jad_xkVar != null) {
                    break;
                }
            }
            if (jad_xkVar != null) {
                return jad_xkVar;
            }
            throw new com.jd.ad.sdk.jad_mx.jad_sf(this.jad_cp, new java.util.ArrayList(list));
        } finally {
            this.jad_an.release(list);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("LoadPath{decodePaths=");
        jad_an.append(java.util.Arrays.toString(this.jad_bo.toArray()));
        jad_an.append('}');
        return jad_an.toString();
    }
}
