package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_er extends android.content.ContextWrapper {

    @androidx.annotation.VisibleForTesting
    public static final com.jd.ad.sdk.jad_gr.jad_kx<?, ?> jad_jw = new com.jd.ad.sdk.jad_gr.jad_bo();
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;
    public final com.jd.ad.sdk.jad_gr.jad_hu jad_bo;
    public final com.jd.ad.sdk.jad_gr.jad_cp.jad_an jad_cp;
    public final java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> jad_dq;
    public final java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_gr.jad_kx<?, ?>> jad_er;
    public final com.jd.ad.sdk.jad_mx.jad_mz jad_fs;
    public final int jad_hu;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    public com.jd.ad.sdk.jad_en.jad_hu jad_iv;
    public final com.jd.ad.sdk.jad_gr.jad_fs jad_jt;

    public jad_er(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_hu jad_huVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_fo.jad_bo jad_boVar2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_cp.jad_an jad_anVar, @androidx.annotation.NonNull java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_gr.jad_kx<?, ?>> map, @androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> list, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar, int i) {
        super(context.getApplicationContext());
        this.jad_an = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_anVar;
        this.jad_dq = list;
        this.jad_er = map;
        this.jad_fs = jad_mzVar;
        this.jad_jt = jad_fsVar;
        this.jad_hu = i;
    }

    public java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> jad_an() {
        return this.jad_dq;
    }

    public synchronized com.jd.ad.sdk.jad_en.jad_hu jad_bo() {
        if (this.jad_iv == null) {
            ((com.jd.ad.sdk.jad_gr.jad_dq.jad_an) this.jad_cp).getClass();
            com.jd.ad.sdk.jad_en.jad_hu jad_huVar = new com.jd.ad.sdk.jad_en.jad_hu();
            jad_huVar.jad_tg = true;
            this.jad_iv = jad_huVar;
        }
        return this.jad_iv;
    }

    public com.jd.ad.sdk.jad_gr.jad_fs jad_cp() {
        return this.jad_jt;
    }
}
