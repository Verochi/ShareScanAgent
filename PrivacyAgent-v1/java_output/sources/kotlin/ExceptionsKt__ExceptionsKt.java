package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0007\"!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00008F¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\r*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"", "", "stackTraceToString", "exception", "", "addSuppressed", "", "Ljava/lang/StackTraceElement;", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "stackTrace", "", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "getSuppressedExceptions$annotations", "suppressedExceptions", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ExceptionsKt")
/* loaded from: classes14.dex */
public class ExceptionsKt__ExceptionsKt {
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.internal.HidesMembers
    public static void addSuppressed(@org.jetbrains.annotations.NotNull java.lang.Throwable th, @org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        if (th != exception) {
            kotlin.internal.PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.StackTraceElement[] getStackTrace(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "<this>");
        java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void getStackTrace$annotations(java.lang.Throwable th) {
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Throwable> getSuppressedExceptions(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "<this>");
        return kotlin.internal.PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(java.lang.Throwable th) {
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String stackTraceToString(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "<this>");
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        java.lang.String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
