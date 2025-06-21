package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @androidx.annotation.RequiresApi(17)
    @org.jetbrains.annotations.NotNull
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull android.util.AtomicFile readBytes) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(readBytes, "$this$readBytes");
        byte[] readFully = readBytes.readFully();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return readFully;
    }

    @androidx.annotation.RequiresApi(17)
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String readText(@org.jetbrains.annotations.NotNull android.util.AtomicFile readText, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(readText, "$this$readText");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] readFully = readText.readFully();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return new java.lang.String(readFully, charset);
    }

    public static /* synthetic */ java.lang.String readText$default(android.util.AtomicFile atomicFile, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    @androidx.annotation.RequiresApi(17)
    public static final void tryWrite(@org.jetbrains.annotations.NotNull android.util.AtomicFile tryWrite, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.io.FileOutputStream, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tryWrite, "$this$tryWrite");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        java.io.FileOutputStream stream = tryWrite.startWrite();
        try {
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
            block.invoke(stream);
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            tryWrite.finishWrite(stream);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        } catch (java.lang.Throwable th) {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            tryWrite.failWrite(stream);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @androidx.annotation.RequiresApi(17)
    public static final void writeBytes(@org.jetbrains.annotations.NotNull android.util.AtomicFile writeBytes, @org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(writeBytes, "$this$writeBytes");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(array, "array");
        java.io.FileOutputStream stream = writeBytes.startWrite();
        try {
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
            stream.write(array);
            writeBytes.finishWrite(stream);
        } catch (java.lang.Throwable th) {
            writeBytes.failWrite(stream);
            throw th;
        }
    }

    @androidx.annotation.RequiresApi(17)
    public static final void writeText(@org.jetbrains.annotations.NotNull android.util.AtomicFile writeText, @org.jetbrains.annotations.NotNull java.lang.String text, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(writeText, "$this$writeText");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(writeText, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, java.lang.String str, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}
