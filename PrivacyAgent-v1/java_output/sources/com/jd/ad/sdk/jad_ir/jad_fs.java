package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_fs {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class jad_an<T> implements com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<T> {
        public volatile T jad_an;
        public final /* synthetic */ com.jd.ad.sdk.jad_ir.jad_fs.jad_bo jad_bo;

        public jad_an(com.jd.ad.sdk.jad_ir.jad_fs.jad_bo jad_boVar) {
            this.jad_bo = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_ir.jad_fs.jad_bo
        public T get() {
            if (this.jad_an == null) {
                synchronized (this) {
                    if (this.jad_an == null) {
                        this.jad_an = (T) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_bo.get());
                    }
                }
            }
            return this.jad_an;
        }
    }

    public interface jad_bo<T> {
        T get();
    }

    public static <T> com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<T> jad_an(com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<T> jad_boVar) {
        return new com.jd.ad.sdk.jad_ir.jad_fs.jad_an(jad_boVar);
    }
}
