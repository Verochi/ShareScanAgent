package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class Intrinsics {

    @kotlin.SinceKotlin(version = "1.4")
    public static class Kotlin {
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(double d, java.lang.Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(float f, java.lang.Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(java.lang.Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(java.lang.Double d, java.lang.Double d2) {
        if (d == null) {
            if (d2 == null) {
                return true;
            }
        } else if (d2 != null && d.doubleValue() == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(java.lang.Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static boolean areEqual(java.lang.Float f, java.lang.Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean areEqual(java.lang.Object obj, java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static <T extends java.lang.Throwable> T b(T t) {
        return (T) c(t, kotlin.jvm.internal.Intrinsics.class.getName());
    }

    public static <T extends java.lang.Throwable> T c(T t, java.lang.String str) {
        java.lang.StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((java.lang.StackTraceElement[]) java.util.Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void checkExpressionValueIsNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException(str + " must not be null")));
    }

    public static void checkFieldIsNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException(str)));
        }
    }

    public static void checkFieldIsNotNull(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    public static void checkHasClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        java.lang.String replace = str.replace('/', '.');
        try {
            java.lang.Class.forName(replace);
        } catch (java.lang.ClassNotFoundException e) {
            throw ((java.lang.ClassNotFoundException) b(new java.lang.ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e)));
        }
    }

    public static void checkHasClass(java.lang.String str, java.lang.String str2) throws java.lang.ClassNotFoundException {
        java.lang.String replace = str.replace('/', '.');
        try {
            java.lang.Class.forName(replace);
        } catch (java.lang.ClassNotFoundException e) {
            throw ((java.lang.ClassNotFoundException) b(new java.lang.ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e)));
        }
    }

    public static void checkNotNull(java.lang.Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void checkNotNullExpressionValue(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.NullPointerException) b(new java.lang.NullPointerException(str + " must not be null")));
    }

    public static void checkNotNullParameter(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            e(str);
        }
    }

    public static void checkParameterIsNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            d(str);
        }
    }

    public static void checkReturnedValueIsNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException(str)));
        }
    }

    public static void checkReturnedValueIsNotNull(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static void d(java.lang.String str) {
        throw ((java.lang.IllegalArgumentException) b(new java.lang.IllegalArgumentException(a(str))));
    }

    public static void e(java.lang.String str) {
        throw ((java.lang.NullPointerException) b(new java.lang.NullPointerException(a(str))));
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(java.lang.String str) {
        throwUndefinedForReified(str);
    }

    public static void reifiedOperationMarker(int i, java.lang.String str) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, java.lang.String str, java.lang.String str2) {
        throwUndefinedForReified(str2);
    }

    public static java.lang.String stringPlus(java.lang.String str, java.lang.Object obj) {
        return str + obj;
    }

    public static void throwAssert() {
        throw ((java.lang.AssertionError) b(new java.lang.AssertionError()));
    }

    public static void throwAssert(java.lang.String str) {
        throw ((java.lang.AssertionError) b(new java.lang.AssertionError(str)));
    }

    public static void throwIllegalArgument() {
        throw ((java.lang.IllegalArgumentException) b(new java.lang.IllegalArgumentException()));
    }

    public static void throwIllegalArgument(java.lang.String str) {
        throw ((java.lang.IllegalArgumentException) b(new java.lang.IllegalArgumentException(str)));
    }

    public static void throwIllegalState() {
        throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException()));
    }

    public static void throwIllegalState(java.lang.String str) {
        throw ((java.lang.IllegalStateException) b(new java.lang.IllegalStateException(str)));
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static void throwJavaNpe() {
        throw ((java.lang.NullPointerException) b(new java.lang.NullPointerException()));
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static void throwJavaNpe(java.lang.String str) {
        throw ((java.lang.NullPointerException) b(new java.lang.NullPointerException(str)));
    }

    public static void throwNpe() {
        throw ((kotlin.KotlinNullPointerException) b(new kotlin.KotlinNullPointerException()));
    }

    public static void throwNpe(java.lang.String str) {
        throw ((kotlin.KotlinNullPointerException) b(new kotlin.KotlinNullPointerException(str)));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(java.lang.String str) {
        throw new java.lang.UnsupportedOperationException(str);
    }

    public static void throwUninitializedProperty(java.lang.String str) {
        throw ((kotlin.UninitializedPropertyAccessException) b(new kotlin.UninitializedPropertyAccessException(str)));
    }

    public static void throwUninitializedPropertyAccessException(java.lang.String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }
}
