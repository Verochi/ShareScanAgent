package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public class jad_jw {
    public java.lang.Class<?> jad_an;
    public java.lang.Class<?> jad_bo;
    public java.lang.Class<?> jad_cp;

    public jad_jw() {
    }

    public jad_jw(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2, @androidx.annotation.Nullable java.lang.Class<?> cls3) {
        jad_an(cls, cls2, cls3);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.jd.ad.sdk.jad_ir.jad_jw.class != obj.getClass()) {
            return false;
        }
        com.jd.ad.sdk.jad_ir.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_ir.jad_jw) obj;
        return this.jad_an.equals(jad_jwVar.jad_an) && this.jad_bo.equals(jad_jwVar.jad_bo) && com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_cp, jad_jwVar.jad_cp);
    }

    public int hashCode() {
        int hashCode = (this.jad_bo.hashCode() + (this.jad_an.hashCode() * 31)) * 31;
        java.lang.Class<?> cls = this.jad_cp;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void jad_an(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2, @androidx.annotation.Nullable java.lang.Class<?> cls3) {
        this.jad_an = cls;
        this.jad_bo = cls2;
        this.jad_cp = cls3;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("MultiClassKey{first=");
        jad_an.append(this.jad_an);
        jad_an.append(", second=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }
}
