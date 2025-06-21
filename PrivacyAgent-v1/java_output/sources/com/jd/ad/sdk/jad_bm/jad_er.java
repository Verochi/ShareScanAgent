package com.jd.ad.sdk.jad_bm;

/* loaded from: classes23.dex */
public class jad_er {
    public final java.util.List<java.lang.String> jad_an = new java.util.ArrayList();
    public final java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>>> jad_bo = new java.util.HashMap();

    public static class jad_an<T, R> {
        public final java.lang.Class<T> jad_an;
        public final java.lang.Class<R> jad_bo;
        public final com.jd.ad.sdk.jad_ju.jad_ly<T, R> jad_cp;

        public jad_an(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull java.lang.Class<R> cls2, com.jd.ad.sdk.jad_ju.jad_ly<T, R> jad_lyVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_lyVar;
        }
    }

    @androidx.annotation.NonNull
    public synchronized <T, R> java.util.List<java.lang.Class<R>> jad_an(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull java.lang.Class<R> cls2) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.String> it = this.jad_an.iterator();
        while (it.hasNext()) {
            java.util.List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>> list = this.jad_bo.get(it.next());
            if (list != null) {
                for (com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?> jad_anVar : list) {
                    if ((jad_anVar.jad_an.isAssignableFrom(cls) && cls2.isAssignableFrom(jad_anVar.jad_bo)) && !arrayList.contains(jad_anVar.jad_bo)) {
                        arrayList.add(jad_anVar.jad_bo);
                    }
                }
            }
        }
        return arrayList;
    }
}
