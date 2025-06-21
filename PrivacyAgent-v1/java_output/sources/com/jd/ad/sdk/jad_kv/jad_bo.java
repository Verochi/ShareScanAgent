package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public abstract class jad_bo<T> implements com.jd.ad.sdk.jad_kv.jad_dq<T> {
    public final java.lang.String jad_an;
    public final android.content.res.AssetManager jad_bo;
    public T jad_cp;

    public jad_bo(android.content.res.AssetManager assetManager, java.lang.String str) {
        this.jad_bo = assetManager;
        this.jad_an = str;
    }

    public abstract T jad_an(android.content.res.AssetManager assetManager, java.lang.String str);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super T> jad_anVar) {
        try {
            T jad_an = jad_an(this.jad_bo, this.jad_an);
            this.jad_cp = jad_an;
            jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super T>) jad_an);
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable("AssetPathFetcher", 3)) {
                com.jd.ad.sdk.logger.Logger.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            jad_anVar.jad_an((java.lang.Exception) e);
        }
    }

    public abstract void jad_an(T t);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        T t = this.jad_cp;
        if (t == null) {
            return;
        }
        try {
            jad_an(t);
        } catch (java.io.IOException unused) {
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
    }
}
