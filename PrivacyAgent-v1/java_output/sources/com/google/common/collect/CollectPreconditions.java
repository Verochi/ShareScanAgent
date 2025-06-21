package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class CollectPreconditions {
    public static void a(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            throw new java.lang.NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new java.lang.NullPointerException("null value in entry: " + obj + "=null");
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int b(int i, java.lang.String str) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long c(long j, java.lang.String str) {
        if (j >= 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(str + " cannot be negative but was: " + j);
    }

    public static void d(int i, java.lang.String str) {
        if (i > 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException(str + " must be positive but was: " + i);
    }

    public static void e(boolean z) {
        com.google.common.base.Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }
}
