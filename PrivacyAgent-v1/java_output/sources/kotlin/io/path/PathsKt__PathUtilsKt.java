package kotlin.io.path;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u0014\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0001\u001aM\u0010\u0014\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u001a\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011\"\u0006\u0012\u0002\b\u00030\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aA\u0010\u0016\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u001a\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011\"\u0006\u0012\u0002\b\u00030\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\"\u001e\u0010\u001c\u001a\u00020\u0005*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\"\u001e\u0010\u001f\u001a\u00020\u0005*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019\"\u001e\u0010\"\u001a\u00020\u0005*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b \u0010\u0019\"\u001e\u0010%\u001a\u00020\u0005*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001b\u001a\u0004\b#\u0010\u0019¨\u0006&"}, d2 = {"Ljava/nio/file/Path;", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "", "glob", "", "listDirectoryEntries", "path", "Ljava/lang/Class;", "attributeViewClass", "", "fileAttributeViewNotAvailable", org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DIRECTORY, com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, "suffix", "", "Ljava/nio/file/attribute/FileAttribute;", "attributes", "createTempFile", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempDirectory", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "getName", "(Ljava/nio/file/Path;)Ljava/lang/String;", "getName$annotations", "(Ljava/nio/file/Path;)V", "name", "getNameWithoutExtension", "getNameWithoutExtension$annotations", "nameWithoutExtension", "getExtension", "getExtension$annotations", "extension", "getInvariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "invariantSeparatorsPathString", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes14.dex */
class PathsKt__PathUtilsKt extends kotlin.io.path.PathsKt__PathReadWriteKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static final java.nio.file.Path createTempDirectory(@org.jetbrains.annotations.Nullable java.nio.file.Path path, @org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.NotNull java.nio.file.attribute.FileAttribute<?>... attributes) throws java.io.IOException {
        java.nio.file.Path createTempDirectory;
        java.nio.file.Path createTempDirectory2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            createTempDirectory2 = java.nio.file.Files.createTempDirectory(path, str, (java.nio.file.attribute.FileAttribute[]) java.util.Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createTempDirectory2, "createTempDirectory(dire…ory, prefix, *attributes)");
            return createTempDirectory2;
        }
        createTempDirectory = java.nio.file.Files.createTempDirectory(str, (java.nio.file.attribute.FileAttribute[]) java.util.Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createTempDirectory, "createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    public static /* synthetic */ java.nio.file.Path createTempDirectory$default(java.nio.file.Path path, java.lang.String str, java.nio.file.attribute.FileAttribute[] fileAttributeArr, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static final java.nio.file.Path createTempFile(@org.jetbrains.annotations.Nullable java.nio.file.Path path, @org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2, @org.jetbrains.annotations.NotNull java.nio.file.attribute.FileAttribute<?>... attributes) throws java.io.IOException {
        java.nio.file.Path createTempFile;
        java.nio.file.Path createTempFile2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            createTempFile2 = java.nio.file.Files.createTempFile(path, str, str2, (java.nio.file.attribute.FileAttribute[]) java.util.Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createTempFile2, "createTempFile(directory…fix, suffix, *attributes)");
            return createTempFile2;
        }
        createTempFile = java.nio.file.Files.createTempFile(str, str2, (java.nio.file.attribute.FileAttribute[]) java.util.Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    public static /* synthetic */ java.nio.file.Path createTempFile$default(java.nio.file.Path path, java.lang.String str, java.lang.String str2, java.nio.file.attribute.FileAttribute[] fileAttributeArr, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Void fileAttributeViewNotAvailable(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.lang.Class<?> attributeViewClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        throw new java.lang.UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getExtension(@org.jetbrains.annotations.NotNull java.nio.file.Path path) {
        java.nio.file.Path fileName;
        java.lang.String obj;
        java.lang.String substringAfterLast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringAfterLast = kotlin.text.StringsKt__StringsKt.substringAfterLast(obj, '.', "")) == null) ? "" : substringAfterLast;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static /* synthetic */ void getExtension$annotations(java.nio.file.Path path) {
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.internal.InlineOnly
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @kotlin.ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @kotlin.io.path.ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(java.nio.file.Path path) {
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getInvariantSeparatorsPathString(@org.jetbrains.annotations.NotNull java.nio.file.Path path) {
        java.nio.file.FileSystem fileSystem;
        java.lang.String separator;
        java.lang.String replace$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        fileSystem = path.getFileSystem();
        separator = fileSystem.getSeparator();
        if (kotlin.jvm.internal.Intrinsics.areEqual(separator, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return path.toString();
        }
        java.lang.String obj = path.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(separator, "separator");
        replace$default = kotlin.text.StringsKt__StringsJVMKt.replace$default(obj, separator, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, false, 4, (java.lang.Object) null);
        return replace$default;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(java.nio.file.Path path) {
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getName(@org.jetbrains.annotations.NotNull java.nio.file.Path path) {
        java.nio.file.Path fileName;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        java.lang.String obj = fileName != null ? fileName.toString() : null;
        return obj == null ? "" : obj;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static /* synthetic */ void getName$annotations(java.nio.file.Path path) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r3 = kotlin.text.StringsKt__StringsKt.substringBeforeLast$default(r3, ".", (java.lang.String) null, 2, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.String getNameWithoutExtension(@org.jetbrains.annotations.NotNull java.nio.file.Path path) {
        java.nio.file.Path fileName;
        java.lang.String substringBeforeLast$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        return (fileName == null || (r3 = fileName.toString()) == null || substringBeforeLast$default == null) ? "" : substringBeforeLast$default;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static /* synthetic */ void getNameWithoutExtension$annotations(java.nio.file.Path path) {
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getPathString$annotations(java.nio.file.Path path) {
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    public static final java.util.List<java.nio.file.Path> listDirectoryEntries(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.lang.String glob) throws java.io.IOException {
        java.nio.file.DirectoryStream it;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(glob, "glob");
        it = java.nio.file.Files.newDirectoryStream(path, glob);
        try {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
            java.util.List<java.nio.file.Path> list = kotlin.collections.CollectionsKt___CollectionsKt.toList(it);
            kotlin.io.CloseableKt.closeFinally(it, null);
            return list;
        } finally {
        }
    }

    public static /* synthetic */ java.util.List listDirectoryEntries$default(java.nio.file.Path path, java.lang.String str, int i, java.lang.Object obj) throws java.io.IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return listDirectoryEntries(path, str);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.nio.file.Path relativeTo(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.nio.file.Path base) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        try {
            return kotlin.io.path.PathRelativizer.a.a(path, base);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.lang.IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e);
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.nio.file.Path relativeToOrNull(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.nio.file.Path base) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        try {
            return kotlin.io.path.PathRelativizer.a.a(path, base);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.nio.file.Path relativeToOrSelf(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.nio.file.Path base) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        java.nio.file.Path relativeToOrNull = relativeToOrNull(path, base);
        return relativeToOrNull == null ? path : relativeToOrNull;
    }
}
