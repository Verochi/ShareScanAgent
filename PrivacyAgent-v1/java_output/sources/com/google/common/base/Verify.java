package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Verify {
    public static void verify(boolean z) {
        if (!z) {
            throw new com.google.common.base.VerifyException();
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, char c2) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Character.valueOf(c2)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, int i) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Integer.valueOf(i)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, long j) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), java.lang.Long.valueOf(j)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, char c, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Character.valueOf(c), obj));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, char c) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Character.valueOf(c)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, int i2) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, long j) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Integer.valueOf(i), obj));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, char c) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Character.valueOf(c)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, int i) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Integer.valueOf(i)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, long j2) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, java.lang.Long.valueOf(j), obj));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, char c) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Character.valueOf(c)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Integer.valueOf(i)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, long j) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, java.lang.Long.valueOf(j)));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj4) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void verify(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        if (!z) {
            throw new com.google.common.base.VerifyException(com.google.common.base.Strings.lenientFormat(str, objArr));
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> T verifyNotNull(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) verifyNotNull(t, "expected a non-null reference", new java.lang.Object[0]);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> T verifyNotNull(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        verify(t != null, str, objArr);
        return t;
    }
}
