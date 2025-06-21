package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006*\u00020\u0000\u001a:\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\u00020\u00002\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\u000e\u001a\n\u0010\u0010\u001a\u00020\u0002*\u00020\u0000\u001a\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u001a\n\u0010\u0019\u001a\u00020\u0018*\u00020\u0017\u0082\u0002\u000f\n\u0005\b\u009920\u0001\n\u0006\b\u0011(\u000b0\u0001¨\u0006\u001a"}, d2 = {"Ljava/io/Reader;", "Lkotlin/Function1;", "", "", "action", "forEachLine", "", "readLines", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "block", "Requires newer compiler version to be inlined correctly.", "useLines", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "lineSequence", "readText", "Ljava/io/Writer;", "out", "", "bufferSize", "", "copyTo", "Ljava/net/URL;", "", "readBytes", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "TextStreamsKt")
/* loaded from: classes14.dex */
public final class TextStreamsKt {
    public static final long copyTo(@org.jetbrains.annotations.NotNull java.io.Reader reader, @org.jetbrains.annotations.NotNull java.io.Writer out, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(java.io.Reader reader, java.io.Writer writer, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    public static final void forEachLine(@org.jetbrains.annotations.NotNull java.io.Reader reader, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.io.BufferedReader bufferedReader = reader instanceof java.io.BufferedReader ? (java.io.BufferedReader) reader : new java.io.BufferedReader(reader, 8192);
        try {
            java.util.Iterator<java.lang.String> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> lineSequence(@org.jetbrains.annotations.NotNull java.io.BufferedReader bufferedReader) {
        kotlin.sequences.Sequence<java.lang.String> constrainOnce;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        constrainOnce = kotlin.sequences.SequencesKt__SequencesKt.constrainOnce(new kotlin.io.LinesSequence(bufferedReader));
        return constrainOnce;
    }

    @org.jetbrains.annotations.NotNull
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.net.URL url) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, "<this>");
        java.io.InputStream it = url.openStream();
        try {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
            byte[] readBytes = kotlin.io.ByteStreamsKt.readBytes(it);
            kotlin.io.CloseableKt.closeFinally(it, null);
            return readBytes;
        } finally {
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> readLines(@org.jetbrains.annotations.NotNull java.io.Reader reader) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reader, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        forEachLine(reader, new kotlin.io.TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String readText(@org.jetbrains.annotations.NotNull java.io.Reader reader) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reader, "<this>");
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        java.lang.String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static final <T> T useLines(@org.jetbrains.annotations.NotNull java.io.Reader reader, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        java.io.BufferedReader bufferedReader = reader instanceof java.io.BufferedReader ? (java.io.BufferedReader) reader : new java.io.BufferedReader(reader, 8192);
        try {
            T invoke = block.invoke(lineSequence(bufferedReader));
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }
}
