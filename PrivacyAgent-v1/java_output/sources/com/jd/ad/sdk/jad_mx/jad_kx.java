package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_kx<DataType, ResourceType, Transcode> {
    public final java.lang.Class<DataType> jad_an;
    public final java.util.List<? extends com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType>> jad_bo;
    public final com.jd.ad.sdk.jad_yj.jad_er<ResourceType, Transcode> jad_cp;
    public final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> jad_dq;
    public final java.lang.String jad_er;

    public interface jad_an<ResourceType> {
    }

    public jad_kx(java.lang.Class<DataType> cls, java.lang.Class<ResourceType> cls2, java.lang.Class<Transcode> cls3, java.util.List<? extends com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType>> list, com.jd.ad.sdk.jad_yj.jad_er<ResourceType, Transcode> jad_erVar, androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.jad_an = cls;
        this.jad_bo = list;
        this.jad_cp = jad_erVar;
        this.jad_dq = pool;
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed DecodePath{");
        jad_an2.append(cls.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls2.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls3.getSimpleName());
        jad_an2.append(com.alipay.sdk.m.u.i.d);
        this.jad_er = jad_an2.toString();
    }

    public com.jd.ad.sdk.jad_mx.jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_kv.jad_er<DataType> jad_erVar, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, com.jd.ad.sdk.jad_mx.jad_kx.jad_an<ResourceType> jad_anVar) {
        com.jd.ad.sdk.jad_mx.jad_xk<ResourceType> jad_xkVar;
        com.jd.ad.sdk.jad_ju.jad_na jad_naVar;
        com.jd.ad.sdk.jad_ju.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_ju.jad_hu jad_dqVar;
        java.util.List<java.lang.Throwable> list = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_dq.acquire());
        try {
            com.jd.ad.sdk.jad_mx.jad_xk<ResourceType> jad_an2 = jad_an(jad_erVar, i, i2, jad_jwVar, list);
            this.jad_dq.release(list);
            com.jd.ad.sdk.jad_mx.jad_hu.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_mx.jad_hu.jad_cp) jad_anVar;
            com.jd.ad.sdk.jad_mx.jad_hu jad_huVar = com.jd.ad.sdk.jad_mx.jad_hu.this;
            com.jd.ad.sdk.jad_ju.jad_an jad_anVar2 = jad_cpVar2.jad_an;
            jad_huVar.getClass();
            java.lang.Class<?> cls = jad_an2.get().getClass();
            com.jd.ad.sdk.jad_ju.jad_mz jad_mzVar = null;
            if (jad_anVar2 != com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE) {
                com.jd.ad.sdk.jad_ju.jad_na jad_bo = jad_huVar.jad_an.jad_bo(cls);
                jad_naVar = jad_bo;
                jad_xkVar = jad_bo.jad_an(jad_huVar.jad_hu, jad_an2, jad_huVar.jad_ly, jad_huVar.jad_mz);
            } else {
                jad_xkVar = jad_an2;
                jad_naVar = null;
            }
            if (!jad_an2.equals(jad_xkVar)) {
                jad_an2.jad_dq();
            }
            if (jad_huVar.jad_an.jad_an((com.jd.ad.sdk.jad_mx.jad_xk<?>) jad_xkVar)) {
                jad_mzVar = jad_huVar.jad_an.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp());
                if (jad_mzVar == null) {
                    throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_dq(jad_xkVar.jad_cp());
                }
                jad_cpVar = jad_mzVar.jad_an(jad_huVar.jad_ob);
            } else {
                jad_cpVar = com.jd.ad.sdk.jad_ju.jad_cp.NONE;
            }
            com.jd.ad.sdk.jad_ju.jad_mz jad_mzVar2 = jad_mzVar;
            com.jd.ad.sdk.jad_mx.jad_jt<R> jad_jtVar = jad_huVar.jad_an;
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2 = jad_huVar.jad_xk;
            java.util.List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_cp = jad_jtVar.jad_cp();
            int size = jad_cp.size();
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (jad_cp.get(i3).jad_an.equals(jad_huVar2)) {
                    z = true;
                    break;
                }
                i3++;
            }
            com.jd.ad.sdk.jad_mx.jad_xk<ResourceType> jad_xkVar2 = jad_xkVar;
            if (jad_huVar.jad_na.jad_an(!z, jad_anVar2, jad_cpVar)) {
                if (jad_mzVar2 == null) {
                    throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_dq(jad_xkVar.get().getClass());
                }
                int i4 = com.jd.ad.sdk.jad_mx.jad_hu.jad_an.jad_cp[jad_cpVar.ordinal()];
                if (i4 == 1) {
                    jad_dqVar = new com.jd.ad.sdk.jad_mx.jad_dq(jad_huVar.jad_xk, jad_huVar.jad_iv);
                } else {
                    if (i4 != 2) {
                        throw new java.lang.IllegalArgumentException("Unknown strategy: " + jad_cpVar);
                    }
                    jad_dqVar = new com.jd.ad.sdk.jad_mx.jad_zm(jad_huVar.jad_an.jad_cp.jad_an, jad_huVar.jad_xk, jad_huVar.jad_iv, jad_huVar.jad_ly, jad_huVar.jad_mz, jad_naVar, cls, jad_huVar.jad_ob);
                }
                com.jd.ad.sdk.jad_mx.jad_wj<Z> jad_an3 = com.jd.ad.sdk.jad_mx.jad_wj.jad_an(jad_xkVar);
                com.jd.ad.sdk.jad_mx.jad_hu.jad_dq<?> jad_dqVar2 = jad_huVar.jad_fs;
                jad_dqVar2.jad_an = jad_dqVar;
                jad_dqVar2.jad_bo = jad_mzVar2;
                jad_dqVar2.jad_cp = jad_an3;
                jad_xkVar2 = jad_an3;
            }
            return this.jad_cp.jad_an(jad_xkVar2, jad_jwVar);
        } catch (java.lang.Throwable th) {
            this.jad_dq.release(list);
            throw th;
        }
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_mx.jad_xk<ResourceType> jad_an(com.jd.ad.sdk.jad_kv.jad_er<DataType> jad_erVar, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, java.util.List<java.lang.Throwable> list) {
        int size = this.jad_bo.size();
        com.jd.ad.sdk.jad_mx.jad_xk<ResourceType> jad_xkVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType> jad_lyVar = this.jad_bo.get(i3);
            try {
                if (jad_lyVar.jad_an(jad_erVar.jad_an(), jad_jwVar)) {
                    jad_xkVar = jad_lyVar.jad_an(jad_erVar.jad_an(), i, i2, jad_jwVar);
                }
            } catch (java.io.IOException | java.lang.OutOfMemoryError | java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable("DecodePath", 2)) {
                    com.jd.ad.sdk.logger.Logger.v("DecodePath", "Failed to decode data for " + jad_lyVar, e);
                }
                list.add(e);
            }
            if (jad_xkVar != null) {
                break;
            }
        }
        if (jad_xkVar != null) {
            return jad_xkVar;
        }
        throw new com.jd.ad.sdk.jad_mx.jad_sf(this.jad_er, new java.util.ArrayList(list));
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("DecodePath{ dataClass=");
        jad_an2.append(this.jad_an);
        jad_an2.append(", decoders=");
        jad_an2.append(this.jad_bo);
        jad_an2.append(", transcoder=");
        jad_an2.append(this.jad_cp);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
