package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0007\u001a\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000¨\u0006\u0004"}, d2 = {"", "readln", "readlnOrNull", "readLine", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "ConsoleKt")
/* loaded from: classes14.dex */
public final class ConsoleKt {
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String readLine() {
        kotlin.io.LineReader lineReader = kotlin.io.LineReader.INSTANCE;
        java.io.InputStream inputStream = java.lang.System.in;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStream, "`in`");
        java.nio.charset.Charset defaultCharset = java.nio.charset.Charset.defaultCharset();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String readln() {
        java.lang.String readlnOrNull = readlnOrNull();
        if (readlnOrNull != null) {
            return readlnOrNull;
        }
        throw new kotlin.io.ReadAfterEOFException("EOF has already been reached");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String readlnOrNull() {
        return readLine();
    }
}
