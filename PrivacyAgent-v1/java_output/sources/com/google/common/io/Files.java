package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Files {
    public static final com.google.common.collect.TreeTraverser<java.io.File> a = new com.google.common.io.Files.AnonymousClass2();
    public static final com.google.common.graph.SuccessorsFunction<java.io.File> b = new com.google.common.io.Files.AnonymousClass3();

    /* renamed from: com.google.common.io.Files$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.io.LineProcessor<java.util.List<java.lang.String>> {
        public final java.util.List<java.lang.String> a = com.google.common.collect.Lists.newArrayList();

        @Override // com.google.common.io.LineProcessor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.List<java.lang.String> getResult() {
            return this.a;
        }

        @Override // com.google.common.io.LineProcessor
        public boolean processLine(java.lang.String str) {
            this.a.add(str);
            return true;
        }
    }

    /* renamed from: com.google.common.io.Files$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.google.common.collect.TreeTraverser<java.io.File> {
        @Override // com.google.common.collect.TreeTraverser
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public java.lang.Iterable<java.io.File> children(java.io.File file) {
            return com.google.common.io.Files.b(file);
        }

        public java.lang.String toString() {
            return "Files.fileTreeTraverser()";
        }
    }

    /* renamed from: com.google.common.io.Files$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.graph.SuccessorsFunction<java.io.File> {
        @Override // com.google.common.graph.SuccessorsFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Iterable<java.io.File> successors(java.io.File file) {
            return com.google.common.io.Files.b(file);
        }
    }

    public static final class FileByteSink extends com.google.common.io.ByteSink {
        public final java.io.File a;
        public final com.google.common.collect.ImmutableSet<com.google.common.io.FileWriteMode> b;

        public FileByteSink(java.io.File file, com.google.common.io.FileWriteMode... fileWriteModeArr) {
            this.a = (java.io.File) com.google.common.base.Preconditions.checkNotNull(file);
            this.b = com.google.common.collect.ImmutableSet.copyOf(fileWriteModeArr);
        }

        public /* synthetic */ FileByteSink(java.io.File file, com.google.common.io.FileWriteMode[] fileWriteModeArr, com.google.common.io.Files.AnonymousClass1 anonymousClass1) {
            this(file, fileWriteModeArr);
        }

        @Override // com.google.common.io.ByteSink
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.io.FileOutputStream openStream() throws java.io.IOException {
            return new java.io.FileOutputStream(this.a, this.b.contains(com.google.common.io.FileWriteMode.APPEND));
        }

        public java.lang.String toString() {
            return "Files.asByteSink(" + this.a + ", " + this.b + ")";
        }
    }

    public static final class FileByteSource extends com.google.common.io.ByteSource {
        public final java.io.File a;

        public FileByteSource(java.io.File file) {
            this.a = (java.io.File) com.google.common.base.Preconditions.checkNotNull(file);
        }

        public /* synthetic */ FileByteSource(java.io.File file, com.google.common.io.Files.AnonymousClass1 anonymousClass1) {
            this(file);
        }

        @Override // com.google.common.io.ByteSource
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.io.FileInputStream openStream() throws java.io.IOException {
            return new java.io.FileInputStream(this.a);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws java.io.IOException {
            try {
                java.io.FileInputStream fileInputStream = (java.io.FileInputStream) com.google.common.io.Closer.create().register(openStream());
                return com.google.common.io.ByteStreams.e(fileInputStream, fileInputStream.getChannel().size());
            } finally {
            }
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws java.io.IOException {
            if (this.a.isFile()) {
                return this.a.length();
            }
            throw new java.io.FileNotFoundException(this.a.toString());
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.base.Optional<java.lang.Long> sizeIfKnown() {
            return this.a.isFile() ? com.google.common.base.Optional.of(java.lang.Long.valueOf(this.a.length())) : com.google.common.base.Optional.absent();
        }

        public java.lang.String toString() {
            return "Files.asByteSource(" + this.a + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class FilePredicate implements com.google.common.base.Predicate<java.io.File> {
        private static final /* synthetic */ com.google.common.io.Files.FilePredicate[] $VALUES;
        public static final com.google.common.io.Files.FilePredicate IS_DIRECTORY;
        public static final com.google.common.io.Files.FilePredicate IS_FILE;

        /* renamed from: com.google.common.io.Files$FilePredicate$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.io.Files.FilePredicate {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(java.io.File file) {
                return file.isDirectory();
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Files.isDirectory()";
            }
        }

        /* renamed from: com.google.common.io.Files$FilePredicate$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.io.Files.FilePredicate {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(java.io.File file) {
                return file.isFile();
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Files.isFile()";
            }
        }

        static {
            com.google.common.io.Files.FilePredicate.AnonymousClass1 anonymousClass1 = new com.google.common.io.Files.FilePredicate.AnonymousClass1("IS_DIRECTORY", 0);
            IS_DIRECTORY = anonymousClass1;
            com.google.common.io.Files.FilePredicate.AnonymousClass2 anonymousClass2 = new com.google.common.io.Files.FilePredicate.AnonymousClass2("IS_FILE", 1);
            IS_FILE = anonymousClass2;
            $VALUES = new com.google.common.io.Files.FilePredicate[]{anonymousClass1, anonymousClass2};
        }

        private FilePredicate(java.lang.String str, int i) {
        }

        public /* synthetic */ FilePredicate(java.lang.String str, int i, com.google.common.io.Files.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.io.Files.FilePredicate valueOf(java.lang.String str) {
            return (com.google.common.io.Files.FilePredicate) java.lang.Enum.valueOf(com.google.common.io.Files.FilePredicate.class, str);
        }

        public static com.google.common.io.Files.FilePredicate[] values() {
            return (com.google.common.io.Files.FilePredicate[]) $VALUES.clone();
        }
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static void append(java.lang.CharSequence charSequence, java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        asCharSink(file, charset, com.google.common.io.FileWriteMode.APPEND).write(charSequence);
    }

    public static com.google.common.io.ByteSink asByteSink(java.io.File file, com.google.common.io.FileWriteMode... fileWriteModeArr) {
        return new com.google.common.io.Files.FileByteSink(file, fileWriteModeArr, null);
    }

    public static com.google.common.io.ByteSource asByteSource(java.io.File file) {
        return new com.google.common.io.Files.FileByteSource(file, null);
    }

    public static com.google.common.io.CharSink asCharSink(java.io.File file, java.nio.charset.Charset charset, com.google.common.io.FileWriteMode... fileWriteModeArr) {
        return asByteSink(file, fileWriteModeArr).asCharSink(charset);
    }

    public static com.google.common.io.CharSource asCharSource(java.io.File file, java.nio.charset.Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    public static java.lang.Iterable<java.io.File> b(java.io.File file) {
        java.io.File[] listFiles;
        return (!file.isDirectory() || (listFiles = file.listFiles()) == null) ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(java.util.Arrays.asList(listFiles));
    }

    public static java.nio.MappedByteBuffer c(java.io.File file, java.nio.channels.FileChannel.MapMode mapMode, long j) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        com.google.common.base.Preconditions.checkNotNull(mapMode);
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            java.nio.channels.FileChannel fileChannel = (java.nio.channels.FileChannel) create.register(((java.io.RandomAccessFile) create.register(new java.io.RandomAccessFile(file, mapMode == java.nio.channels.FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j == -1) {
                j = fileChannel.size();
            }
            return fileChannel.map(mapMode, 0L, j);
        } finally {
        }
    }

    @com.google.common.annotations.Beta
    public static void copy(java.io.File file, java.io.File file2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new com.google.common.io.FileWriteMode[0]));
    }

    @com.google.common.annotations.Beta
    public static void copy(java.io.File file, java.io.OutputStream outputStream) throws java.io.IOException {
        asByteSource(file).copyTo(outputStream);
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static void copy(java.io.File file, java.nio.charset.Charset charset, java.lang.Appendable appendable) throws java.io.IOException {
        asCharSource(file, charset).copyTo(appendable);
    }

    @com.google.common.annotations.Beta
    public static void createParentDirs(java.io.File file) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        java.io.File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        throw new java.io.IOException("Unable to create parent directories of " + file);
    }

    @com.google.common.annotations.Beta
    public static java.io.File createTempDir() {
        java.io.File file = new java.io.File(java.lang.System.getProperty("java.io.tmpdir"));
        java.lang.String str = java.lang.System.currentTimeMillis() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        for (int i = 0; i < 10000; i++) {
            java.io.File file2 = new java.io.File(file, str + i);
            if (file2.mkdir()) {
                return file2;
            }
        }
        throw new java.lang.IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + "9999)");
    }

    @com.google.common.annotations.Beta
    public static boolean equal(java.io.File file, java.io.File file2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        com.google.common.base.Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return asByteSource(file).contentEquals(asByteSource(file2));
        }
        return false;
    }

    @com.google.common.annotations.Beta
    public static com.google.common.graph.Traverser<java.io.File> fileTraverser() {
        return com.google.common.graph.Traverser.forTree(b);
    }

    @com.google.common.annotations.Beta
    public static java.lang.String getFileExtension(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        java.lang.String name = new java.io.File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    @com.google.common.annotations.Beta
    public static java.lang.String getNameWithoutExtension(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        java.lang.String name = new java.io.File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static com.google.common.hash.HashCode hash(java.io.File file, com.google.common.hash.HashFunction hashFunction) throws java.io.IOException {
        return asByteSource(file).hash(hashFunction);
    }

    @com.google.common.annotations.Beta
    public static com.google.common.base.Predicate<java.io.File> isDirectory() {
        return com.google.common.io.Files.FilePredicate.IS_DIRECTORY;
    }

    @com.google.common.annotations.Beta
    public static com.google.common.base.Predicate<java.io.File> isFile() {
        return com.google.common.io.Files.FilePredicate.IS_FILE;
    }

    @com.google.common.annotations.Beta
    public static java.nio.MappedByteBuffer map(java.io.File file) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        return map(file, java.nio.channels.FileChannel.MapMode.READ_ONLY);
    }

    @com.google.common.annotations.Beta
    public static java.nio.MappedByteBuffer map(java.io.File file, java.nio.channels.FileChannel.MapMode mapMode) throws java.io.IOException {
        return c(file, mapMode, -1L);
    }

    @com.google.common.annotations.Beta
    public static java.nio.MappedByteBuffer map(java.io.File file, java.nio.channels.FileChannel.MapMode mapMode, long j) throws java.io.IOException {
        com.google.common.base.Preconditions.checkArgument(j >= 0, "size (%s) may not be negative", j);
        return c(file, mapMode, j);
    }

    @com.google.common.annotations.Beta
    public static void move(java.io.File file, java.io.File file2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        com.google.common.base.Preconditions.checkNotNull(file2);
        com.google.common.base.Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        copy(file, file2);
        if (file.delete()) {
            return;
        }
        if (file2.delete()) {
            throw new java.io.IOException("Unable to delete " + file);
        }
        throw new java.io.IOException("Unable to delete " + file2);
    }

    @com.google.common.annotations.Beta
    public static java.io.BufferedReader newReader(java.io.File file, java.nio.charset.Charset charset) throws java.io.FileNotFoundException {
        com.google.common.base.Preconditions.checkNotNull(file);
        com.google.common.base.Preconditions.checkNotNull(charset);
        return new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), charset));
    }

    @com.google.common.annotations.Beta
    public static java.io.BufferedWriter newWriter(java.io.File file, java.nio.charset.Charset charset) throws java.io.FileNotFoundException {
        com.google.common.base.Preconditions.checkNotNull(file);
        com.google.common.base.Preconditions.checkNotNull(charset);
        return new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), charset));
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> T readBytes(java.io.File file, com.google.common.io.ByteProcessor<T> byteProcessor) throws java.io.IOException {
        return (T) asByteSource(file).read(byteProcessor);
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static java.lang.String readFirstLine(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        return asCharSource(file, charset).readFirstLine();
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> T readLines(java.io.File file, java.nio.charset.Charset charset, com.google.common.io.LineProcessor<T> lineProcessor) throws java.io.IOException {
        return (T) asCharSource(file, charset).readLines(lineProcessor);
    }

    @com.google.common.annotations.Beta
    public static java.util.List<java.lang.String> readLines(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        return (java.util.List) asCharSource(file, charset).readLines(new com.google.common.io.Files.AnonymousClass1());
    }

    @com.google.common.annotations.Beta
    public static java.lang.String simplifyPath(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            return ".";
        }
        java.lang.Iterable<java.lang.String> split = com.google.common.base.Splitter.on('/').omitEmptyStrings().split(str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : split) {
            str2.hashCode();
            if (!str2.equals(".")) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((java.lang.String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        java.lang.String join = com.google.common.base.Joiner.on('/').join(arrayList);
        if (str.charAt(0) == '/') {
            join = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + join;
        }
        while (join.startsWith("/../")) {
            join = join.substring(3);
        }
        return join.equals("/..") ? net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR : "".equals(join) ? "." : join;
    }

    @com.google.common.annotations.Beta
    public static byte[] toByteArray(java.io.File file) throws java.io.IOException {
        return asByteSource(file).read();
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static java.lang.String toString(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        return asCharSource(file, charset).read();
    }

    @com.google.common.annotations.Beta
    public static void touch(java.io.File file) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(file);
        if (file.createNewFile() || file.setLastModified(java.lang.System.currentTimeMillis())) {
            return;
        }
        throw new java.io.IOException("Unable to update modification time of " + file);
    }

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static void write(java.lang.CharSequence charSequence, java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        asCharSink(file, charset, new com.google.common.io.FileWriteMode[0]).write(charSequence);
    }

    @com.google.common.annotations.Beta
    public static void write(byte[] bArr, java.io.File file) throws java.io.IOException {
        asByteSink(file, new com.google.common.io.FileWriteMode[0]).write(bArr);
    }
}
