package androidx.core.util;

/* loaded from: classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return java.util.Objects.equals(obj, obj2);
    }

    public static int hash(@androidx.annotation.Nullable java.lang.Object... objArr) {
        return java.util.Objects.hash(objArr);
    }

    public static int hashCode(@androidx.annotation.Nullable java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @androidx.annotation.Nullable
    public static java.lang.String toString(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.String str) {
        return obj != null ? obj.toString() : str;
    }
}
