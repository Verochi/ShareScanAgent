package com.jd.ad.sdk.jad_yh;

/* loaded from: classes23.dex */
public class jad_cp<T> {
    public final com.jd.ad.sdk.jad_yh.jad_bo<T> jad_an;

    @androidx.annotation.Nullable
    public T jad_bo;

    public jad_cp() {
        this.jad_an = new com.jd.ad.sdk.jad_yh.jad_bo<>();
        this.jad_bo = null;
    }

    public jad_cp(@androidx.annotation.Nullable T t) {
        this.jad_an = new com.jd.ad.sdk.jad_yh.jad_bo<>();
        this.jad_bo = t;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public final T jad_an(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        com.jd.ad.sdk.jad_yh.jad_bo<T> jad_boVar = this.jad_an;
        jad_boVar.jad_an = t;
        jad_boVar.jad_bo = t2;
        return jad_an(jad_boVar);
    }

    @androidx.annotation.Nullable
    public T jad_an(com.jd.ad.sdk.jad_yh.jad_bo<T> jad_boVar) {
        return this.jad_bo;
    }
}
