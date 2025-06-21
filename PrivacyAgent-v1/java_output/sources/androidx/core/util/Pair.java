package androidx.core.util;

/* loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s2) {
        this.first = f;
        this.second = s2;
    }

    @androidx.annotation.NonNull
    public static <A, B> androidx.core.util.Pair<A, B> create(A a, B b) {
        return new androidx.core.util.Pair<>(a, b);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.core.util.Pair)) {
            return false;
        }
        androidx.core.util.Pair pair = (androidx.core.util.Pair) obj;
        return androidx.core.util.ObjectsCompat.equals(pair.first, this.first) && androidx.core.util.ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int hashCode = f == null ? 0 : f.hashCode();
        S s2 = this.second;
        return hashCode ^ (s2 != null ? s2.hashCode() : 0);
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "Pair{" + this.first + " " + this.second + com.alipay.sdk.m.u.i.d;
    }
}
