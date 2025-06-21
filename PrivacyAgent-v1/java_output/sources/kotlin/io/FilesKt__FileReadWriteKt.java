package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007\u001aB\u0010\u0015\u001a\u00020\u0004*\u00020\u000026\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000e\u001aJ\u0010\u0015\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u001226\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000e\u001a7\u0010\u0019\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0017\u001a\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007\u001aD\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001d\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u0082\u0002\u000f\n\u0005\b\u009920\u0001\n\u0006\b\u0011(\u001f0\u0001¨\u0006\""}, d2 = {"Ljava/io/File;", "", "readBytes", "array", "", "writeBytes", "appendBytes", "Ljava/nio/charset/Charset;", "charset", "", "readText", "text", "writeText", "appendText", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "", "bytesRead", "action", "forEachBlock", "blockSize", "Lkotlin/Function1;", "line", "forEachLine", "", "readLines", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "block", "Requires newer compiler version to be inlined correctly.", "useLines", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/FilesKt")
/* loaded from: classes14.dex */
class FilesKt__FileReadWriteKt extends kotlin.io.FilesKt__FilePathComponentsKt {
    public static final void appendBytes(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            kotlin.io.CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static final void appendText(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.lang.String text, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(text, "text");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        appendBytes(file, bytes);
    }

    public static /* synthetic */ void appendText$default(java.io.File file, java.lang.String str, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        appendText(file, str, charset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void forEachBlock(@org.jetbrains.annotations.NotNull java.io.File file, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super byte[], ? super java.lang.Integer, kotlin.Unit> action) {
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i, 512);
        ?? r2 = new byte[coerceAtLeast];
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r2);
                if (read <= 0) {
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    kotlin.io.CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
                action.mo5invoke(r2, java.lang.Integer.valueOf(read));
            } finally {
            }
        }
    }

    public static final void forEachBlock(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super byte[], ? super java.lang.Integer, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        forEachBlock(file, 4096, action);
    }

    public static final void forEachLine(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.io.TextStreamsKt.forEachLine(new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ void forEachLine$default(java.io.File file, java.nio.charset.Charset charset, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        forEachLine(file, charset, function1);
    }

    @org.jetbrains.annotations.NotNull
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new java.lang.OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int read = fileInputStream.read(bArr, i3, i2);
                if (read < 0) {
                    break;
                }
                i2 -= read;
                i3 += read;
            }
            if (i2 > 0) {
                bArr = java.util.Arrays.copyOf(bArr, i3);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr, "copyOf(this, newSize)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    kotlin.io.ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new kotlin.io.ExposingBufferByteArrayOutputStream(com.umeng.analytics.pro.q.a.r);
                    exposingBufferByteArrayOutputStream.write(read2);
                    kotlin.io.ByteStreamsKt.copyTo$default(fileInputStream, exposingBufferByteArrayOutputStream, 0, 2, null);
                    int size = exposingBufferByteArrayOutputStream.size() + i;
                    if (size < 0) {
                        throw new java.lang.OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] a = exposingBufferByteArrayOutputStream.a();
                    byte[] copyOf = java.util.Arrays.copyOf(bArr, size);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    bArr = kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(a, copyOf, i, 0, exposingBufferByteArrayOutputStream.size());
                }
            }
            kotlin.io.CloseableKt.closeFinally(fileInputStream, null);
            return bArr;
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Throwable th2) {
                kotlin.io.CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    @org.jetbrains.annotations.NotNull
    public static java.util.List<java.lang.String> readLines(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        forEachLine(file, charset, new kotlin.io.FilesKt__FileReadWriteKt$readLines$1(arrayList));
        return arrayList;
    }

    public static /* synthetic */ java.util.List readLines$default(java.io.File file, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        return readLines(file, charset);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String readText(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(file), charset);
        try {
            java.lang.String readText = kotlin.io.TextStreamsKt.readText(inputStreamReader);
            kotlin.io.CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static /* synthetic */ java.lang.String readText$default(java.io.File file, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        return readText(file, charset);
    }

    public static final <T> T useLines(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        java.io.Reader inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(file), charset);
        java.io.BufferedReader bufferedReader = inputStreamReader instanceof java.io.BufferedReader ? (java.io.BufferedReader) inputStreamReader : new java.io.BufferedReader(inputStreamReader, 8192);
        try {
            T invoke = block.invoke(kotlin.io.TextStreamsKt.lineSequence(bufferedReader));
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    public static /* synthetic */ java.lang.Object useLines$default(java.io.File file, java.nio.charset.Charset charset, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        java.io.Reader inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(file), charset);
        java.io.BufferedReader bufferedReader = inputStreamReader instanceof java.io.BufferedReader ? (java.io.BufferedReader) inputStreamReader : new java.io.BufferedReader(inputStreamReader, 8192);
        try {
            java.lang.Object invoke = function1.invoke(kotlin.io.TextStreamsKt.lineSequence(bufferedReader));
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    public static final void writeBytes(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            kotlin.io.CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static final void writeText(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull java.lang.String text, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(text, "text");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(file, bytes);
    }

    public static /* synthetic */ void writeText$default(java.io.File file, java.lang.String str, java.nio.charset.Charset charset, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        writeText(file, str, charset);
    }
}
