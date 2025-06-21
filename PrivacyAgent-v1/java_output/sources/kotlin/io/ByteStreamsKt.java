package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\f\u001a\u00020\u000b*\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0003H\u0007¨\u0006\r"}, d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/ByteIterator;", "iterator", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "out", "", "bufferSize", "", "copyTo", "estimatedSize", "", "readBytes", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "ByteStreamsKt")
/* loaded from: classes14.dex */
public final class ByteStreamsKt {
    public static final long copyTo(@org.jetbrains.annotations.NotNull java.io.InputStream inputStream, @org.jetbrains.annotations.NotNull java.io.OutputStream out, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(out, "out");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j += read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(inputStream, outputStream, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.ByteIterator iterator(@org.jetbrains.annotations.NotNull java.io.BufferedInputStream bufferedInputStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bufferedInputStream, "<this>");
        return new kotlin.io.ByteStreamsKt$iterator$1(bufferedInputStream);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.io.InputStream inputStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "<this>");
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(java.lang.Math.max(8192, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @kotlin.Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @kotlin.ReplaceWith(expression = "readBytes()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.io.InputStream inputStream, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "<this>");
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(java.lang.Math.max(i, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] readBytes$default(java.io.InputStream inputStream, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return readBytes(inputStream, i);
    }
}
