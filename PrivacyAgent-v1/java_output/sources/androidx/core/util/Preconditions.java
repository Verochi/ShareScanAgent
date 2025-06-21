package androidx.core.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @androidx.annotation.NonNull java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static int checkArgumentInRange(int i, int i2, int i3, @androidx.annotation.NonNull java.lang.String str) {
        if (i < i2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too low)", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
        }
        if (i <= i3) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too high)", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
    }

    @androidx.annotation.IntRange(from = 0)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException();
    }

    @androidx.annotation.IntRange(from = 0)
    public static int checkArgumentNonnegative(int i, @androidx.annotation.Nullable java.lang.String str) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i, int i2) {
        if ((i & i2) == i) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("Requested flags 0x" + java.lang.Integer.toHexString(i) + ", but only 0x" + java.lang.Integer.toHexString(i2) + " are allowed");
    }

    @androidx.annotation.NonNull
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t) {
        t.getClass();
        return t;
    }

    @androidx.annotation.NonNull
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void checkState(boolean z) {
        checkState(z, null);
    }

    public static void checkState(boolean z, @androidx.annotation.Nullable java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    @androidx.annotation.NonNull
    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(@androidx.annotation.Nullable T t) {
        if (android.text.TextUtils.isEmpty(t)) {
            throw new java.lang.IllegalArgumentException();
        }
        return t;
    }

    @androidx.annotation.NonNull
    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(t)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return t;
    }

    @androidx.annotation.NonNull
    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Object... objArr) {
        if (android.text.TextUtils.isEmpty(t)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(str, objArr));
        }
        return t;
    }
}
