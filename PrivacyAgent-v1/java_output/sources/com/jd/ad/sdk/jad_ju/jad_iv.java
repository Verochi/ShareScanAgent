package com.jd.ad.sdk.jad_ju;

/* loaded from: classes23.dex */
public final class jad_iv<T> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<java.lang.Object> jad_er = new com.jd.ad.sdk.jad_ju.jad_iv.jad_an();
    public final T jad_an;
    public final com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<T> jad_bo;
    public final java.lang.String jad_cp;
    public volatile byte[] jad_dq;

    public class jad_an implements com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<java.lang.Object> {
        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        }
    }

    public interface jad_bo<T> {
        void jad_an(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull T t, @androidx.annotation.NonNull java.security.MessageDigest messageDigest);
    }

    public jad_iv(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable T t, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<T> jad_boVar) {
        this.jad_cp = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(str);
        this.jad_an = t;
        this.jad_bo = (com.jd.ad.sdk.jad_ju.jad_iv.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
    }

    @androidx.annotation.NonNull
    public static <T> com.jd.ad.sdk.jad_ju.jad_iv<T> jad_an(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull T t) {
        return new com.jd.ad.sdk.jad_ju.jad_iv<>(str, t, jad_er);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_ju.jad_iv) {
            return this.jad_cp.equals(((com.jd.ad.sdk.jad_ju.jad_iv) obj).jad_cp);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_cp.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Option{key='");
        jad_an2.append(this.jad_cp);
        jad_an2.append('\'');
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
