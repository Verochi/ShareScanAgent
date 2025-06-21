package kotlin.io.path;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a9\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Ljava/nio/file/Path;", "Ljava/nio/charset/Charset;", "charset", "", "readText", "", "text", "", "Ljava/nio/file/OpenOption;", "options", "", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "appendText", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes14.dex */
class PathsKt__PathReadWriteKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static final void appendText(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.lang.CharSequence text, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) throws java.io.IOException {
        java.nio.file.StandardOpenOption standardOpenOption;
        java.io.OutputStream newOutputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(text, "text");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        standardOpenOption = java.nio.file.StandardOpenOption.APPEND;
        newOutputStream = java.nio.file.Files.newOutputStream(path, standardOpenOption);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(this, StandardOpenOption.APPEND)");
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void appendText$default(java.nio.file.Path path, java.lang.CharSequence charSequence, java.nio.charset.Charset charset, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 2) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        appendText(path, charSequence, charset);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String readText(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.InputStream newInputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        newInputStream = java.nio.file.Files.newInputStream(path, (java.nio.file.OpenOption[]) java.util.Arrays.copyOf(new java.nio.file.OpenOption[0], 0));
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(newInputStream, charset);
        try {
            java.lang.String readText = kotlin.io.TextStreamsKt.readText(inputStreamReader);
            kotlin.io.CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static /* synthetic */ java.lang.String readText$default(java.nio.file.Path path, java.nio.charset.Charset charset, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 1) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        return readText(path, charset);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static final void writeText(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.lang.CharSequence text, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset, @org.jetbrains.annotations.NotNull java.nio.file.OpenOption... options) throws java.io.IOException {
        java.io.OutputStream newOutputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(text, "text");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        newOutputStream = java.nio.file.Files.newOutputStream(path, (java.nio.file.OpenOption[]) java.util.Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(this, *options)");
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void writeText$default(java.nio.file.Path path, java.lang.CharSequence charSequence, java.nio.charset.Charset charset, java.nio.file.OpenOption[] openOptionArr, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 2) != 0) {
            charset = kotlin.text.Charsets.UTF_8;
        }
        writeText(path, charSequence, charset, openOptionArr);
    }
}
