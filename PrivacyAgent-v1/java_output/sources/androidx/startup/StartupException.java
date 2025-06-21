package androidx.startup;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class StartupException extends java.lang.RuntimeException {
    public StartupException(@androidx.annotation.NonNull java.lang.String str) {
        super(str);
    }

    public StartupException(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Throwable th) {
        super(str, th);
    }

    public StartupException(@androidx.annotation.NonNull java.lang.Throwable th) {
        super(th);
    }
}
