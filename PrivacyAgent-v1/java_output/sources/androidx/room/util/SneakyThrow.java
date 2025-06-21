package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@androidx.annotation.NonNull java.lang.Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends java.lang.Throwable> void sneakyThrow(@androidx.annotation.NonNull java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }
}
