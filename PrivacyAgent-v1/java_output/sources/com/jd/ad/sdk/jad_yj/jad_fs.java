package com.jd.ad.sdk.jad_yj;

/* loaded from: classes23.dex */
public class jad_fs {
    public final java.util.List<com.jd.ad.sdk.jad_yj.jad_fs.jad_an<?, ?>> jad_an = new java.util.ArrayList();

    public static final class jad_an<Z, R> {
        public final java.lang.Class<Z> jad_an;
        public final java.lang.Class<R> jad_bo;
        public final com.jd.ad.sdk.jad_yj.jad_er<Z, R> jad_cp;

        public jad_an(@androidx.annotation.NonNull java.lang.Class<Z> cls, @androidx.annotation.NonNull java.lang.Class<R> cls2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_yj.jad_er<Z, R> jad_erVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_erVar;
        }
    }

    @androidx.annotation.NonNull
    public synchronized <Z, R> java.util.List<java.lang.Class<R>> jad_an(@androidx.annotation.NonNull java.lang.Class<Z> cls, @androidx.annotation.NonNull java.lang.Class<R> cls2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (com.jd.ad.sdk.jad_yj.jad_fs.jad_an<?, ?> jad_anVar : this.jad_an) {
            if ((jad_anVar.jad_an.isAssignableFrom(cls) && cls2.isAssignableFrom(jad_anVar.jad_bo)) && !arrayList.contains(jad_anVar.jad_bo)) {
                arrayList.add(jad_anVar.jad_bo);
            }
        }
        return arrayList;
    }
}
