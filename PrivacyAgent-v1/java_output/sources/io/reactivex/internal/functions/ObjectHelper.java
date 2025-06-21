package io.reactivex.internal.functions;

/* loaded from: classes9.dex */
public final class ObjectHelper {
    public static final io.reactivex.functions.BiPredicate<java.lang.Object, java.lang.Object> a = new io.reactivex.internal.functions.ObjectHelper.BiObjectPredicate();

    public static final class BiObjectPredicate implements io.reactivex.functions.BiPredicate<java.lang.Object, java.lang.Object> {
        @Override // io.reactivex.functions.BiPredicate
        public boolean test(java.lang.Object obj, java.lang.Object obj2) {
            return io.reactivex.internal.functions.ObjectHelper.equals(obj, obj2);
        }
    }

    public ObjectHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> io.reactivex.functions.BiPredicate<T, T> equalsPredicate() {
        return (io.reactivex.functions.BiPredicate<T, T>) a;
    }

    public static int hashCode(java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @java.lang.Deprecated
    public static long requireNonNull(long j, java.lang.String str) {
        throw new java.lang.InternalError("Null check on a primitive: " + str);
    }

    public static <T> T requireNonNull(T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(str);
    }

    public static int verifyPositive(int i, java.lang.String str) {
        if (i > 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    public static long verifyPositive(long j, java.lang.String str) {
        if (j > 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(str + " > 0 required but it was " + j);
    }
}
