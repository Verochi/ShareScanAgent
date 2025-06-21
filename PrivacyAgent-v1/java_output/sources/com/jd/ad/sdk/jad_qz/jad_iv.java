package com.jd.ad.sdk.jad_qz;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes23.dex */
public class jad_iv<T> {

    @androidx.annotation.Nullable
    public T jad_an;

    @androidx.annotation.Nullable
    public T jad_bo;

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.core.util.Pair)) {
            return false;
        }
        androidx.core.util.Pair pair = (androidx.core.util.Pair) obj;
        F f = pair.first;
        java.lang.Object obj2 = this.jad_an;
        if (!(f == obj2 || (f != 0 && f.equals(obj2)))) {
            return false;
        }
        S s2 = pair.second;
        java.lang.Object obj3 = this.jad_bo;
        return s2 == obj3 || (s2 != 0 && s2.equals(obj3));
    }

    public int hashCode() {
        T t = this.jad_an;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.jad_bo;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Pair{");
        jad_an.append(this.jad_an);
        jad_an.append(" ");
        jad_an.append(this.jad_bo);
        jad_an.append(com.alipay.sdk.m.u.i.d);
        return jad_an.toString();
    }
}
