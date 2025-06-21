package com.jd.ad.sdk.jad_qz;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes23.dex */
public class jad_jt {
    public static final com.jd.ad.sdk.jad_qz.jad_jt jad_bo = new com.jd.ad.sdk.jad_qz.jad_jt();
    public final androidx.collection.LruCache<java.lang.String, com.jd.ad.sdk.jad_lu.jad_jt> jad_an = new androidx.collection.LruCache<>(20);

    @androidx.annotation.VisibleForTesting
    public jad_jt() {
    }

    public void jad_an(@androidx.annotation.Nullable java.lang.String str, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        if (str == null) {
            return;
        }
        this.jad_an.put(str, jad_jtVar);
    }
}
