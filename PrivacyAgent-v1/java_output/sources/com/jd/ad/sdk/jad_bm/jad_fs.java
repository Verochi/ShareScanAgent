package com.jd.ad.sdk.jad_bm;

/* loaded from: classes23.dex */
public class jad_fs {
    public final java.util.List<com.jd.ad.sdk.jad_bm.jad_fs.jad_an<?>> jad_an = new java.util.ArrayList();

    public static final class jad_an<T> {
        public final java.lang.Class<T> jad_an;
        public final com.jd.ad.sdk.jad_ju.jad_mz<T> jad_bo;

        public jad_an(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_mz<T> jad_mzVar) {
            this.jad_an = cls;
            this.jad_bo = jad_mzVar;
        }
    }

    @androidx.annotation.Nullable
    public synchronized <Z> com.jd.ad.sdk.jad_ju.jad_mz<Z> jad_an(@androidx.annotation.NonNull java.lang.Class<Z> cls) {
        int size = this.jad_an.size();
        for (int i = 0; i < size; i++) {
            com.jd.ad.sdk.jad_bm.jad_fs.jad_an<?> jad_anVar = this.jad_an.get(i);
            if (jad_anVar.jad_an.isAssignableFrom(cls)) {
                return (com.jd.ad.sdk.jad_ju.jad_mz<Z>) jad_anVar.jad_bo;
            }
        }
        return null;
    }
}
