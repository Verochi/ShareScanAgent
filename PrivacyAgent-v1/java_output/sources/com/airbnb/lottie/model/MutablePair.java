package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MutablePair<T> {

    @androidx.annotation.Nullable
    public T a;

    @androidx.annotation.Nullable
    public T b;

    public static boolean a(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.core.util.Pair)) {
            return false;
        }
        androidx.core.util.Pair pair = (androidx.core.util.Pair) obj;
        return a(pair.first, this.a) && a(pair.second, this.b);
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public void set(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public java.lang.String toString() {
        return "Pair{" + java.lang.String.valueOf(this.a) + " " + java.lang.String.valueOf(this.b) + com.alipay.sdk.m.u.i.d;
    }
}
