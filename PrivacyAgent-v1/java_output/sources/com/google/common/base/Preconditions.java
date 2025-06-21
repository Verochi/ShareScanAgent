package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Preconditions {
    public static java.lang.String a(int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        if (i < 0) {
            return com.google.common.base.Strings.lenientFormat("%s (%s) must not be negative", str, java.lang.Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return com.google.common.base.Strings.lenientFormat("%s (%s) must be less than size (%s)", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
        throw new java.lang.IllegalArgumentException("negative size: " + i2);
    }

    public static java.lang.String b(int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        if (i < 0) {
            return com.google.common.base.Strings.lenientFormat("%s (%s) must not be negative", str, java.lang.Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return com.google.common.base.Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
        throw new java.lang.IllegalArgumentException("negative size: " + i2);
    }

    public static java.lang.String c(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? b(i, i3, "start index") : (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : com.google.common.base.Strings.lenientFormat("end index (%s) must not be less than start index (%s)", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i));
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, char c2) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Character.valueOf(c2)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, int i) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, long j) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), obj));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, char c) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, int i2) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, long j) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), obj));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, char c) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, int i) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, long j2) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), obj));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, char c) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, long j) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj4) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkArgument(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(com.google.common.base.Strings.lenientFormat(str, objArr));
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, "index");
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int checkElementIndex(int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        if (i < 0 || i >= i2) {
            throw new java.lang.IndexOutOfBoundsException(a(i, i2, str));
        }
        return i;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t) {
        t.getClass();
        return t;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Character.valueOf(c2)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Integer.valueOf(i)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Long.valueOf(j)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), obj));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Character.valueOf(c)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), obj));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Character.valueOf(c)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Integer.valueOf(i)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), obj));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Character.valueOf(c)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Integer.valueOf(i)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Long.valueOf(j)));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, obj2));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj4) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NonNullDecl
    public static <T> T checkNotNull(@org.checkerframework.checker.nullness.compatqual.NonNullDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(com.google.common.base.Strings.lenientFormat(str, objArr));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, "index");
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int checkPositionIndex(int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        if (i < 0 || i > i2) {
            throw new java.lang.IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new java.lang.IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, char c2) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Character.valueOf(c2)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, int i) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, long j) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), obj));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, char c) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, int i2) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, long j) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), obj));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, char c) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, int i) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, long j2) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), obj));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, char c) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, long j) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj4) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkState(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalStateException(com.google.common.base.Strings.lenientFormat(str, objArr));
        }
    }
}
