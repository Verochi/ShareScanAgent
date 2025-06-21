package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_fs {
    public final java.util.Map<java.lang.Class<?>, java.lang.Object> jad_an;

    public static final class jad_an {
        public final java.util.Map<java.lang.Class<?>, java.lang.Object> jad_an = new java.util.HashMap();
    }

    public jad_fs(com.jd.ad.sdk.jad_gr.jad_fs.jad_an jad_anVar) {
        this.jad_an = java.util.Collections.unmodifiableMap(new java.util.HashMap(jad_anVar.jad_an));
    }

    public boolean jad_an(java.lang.Class<java.lang.Object> cls) {
        return this.jad_an.containsKey(cls);
    }
}
