package com.jd.ad.sdk.jad_js;

/* loaded from: classes23.dex */
public abstract class jad_dq {

    public static class jad_bo extends com.jd.ad.sdk.jad_js.jad_dq {
        public volatile boolean jad_an;

        public jad_bo() {
            super(null);
        }

        @Override // com.jd.ad.sdk.jad_js.jad_dq
        public void jad_bo() {
            if (this.jad_an) {
                throw new java.lang.IllegalStateException("Already released");
            }
        }
    }

    public jad_dq() {
    }

    public /* synthetic */ jad_dq(com.jd.ad.sdk.jad_js.jad_dq.jad_an jad_anVar) {
        this();
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_js.jad_dq jad_an() {
        return new com.jd.ad.sdk.jad_js.jad_dq.jad_bo();
    }

    public abstract void jad_bo();
}
