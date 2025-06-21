package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class CharSource {

    public final class AsByteSource extends com.google.common.io.ByteSource {
        public final java.nio.charset.Charset a;

        public AsByteSource(java.nio.charset.Charset charset) {
            this.a = (java.nio.charset.Charset) com.google.common.base.Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.io.CharSource asCharSource(java.nio.charset.Charset charset) {
            return charset.equals(this.a) ? com.google.common.io.CharSource.this : super.asCharSource(charset);
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return new com.google.common.io.ReaderInputStream(com.google.common.io.CharSource.this.openStream(), this.a, 8192);
        }

        public java.lang.String toString() {
            return com.google.common.io.CharSource.this.toString() + ".asByteSource(" + this.a + ")";
        }
    }

    public static class CharSequenceCharSource extends com.google.common.io.CharSource {
        public static final com.google.common.base.Splitter b = com.google.common.base.Splitter.onPattern("\r\n|\n|\r");
        public final java.lang.CharSequence a;

        /* renamed from: com.google.common.io.CharSource$CharSequenceCharSource$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.lang.String> {
            public java.util.Iterator<java.lang.String> u;

            public AnonymousClass1() {
                this.u = com.google.common.io.CharSource.CharSequenceCharSource.b.split(com.google.common.io.CharSource.CharSequenceCharSource.this.a).iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.lang.String computeNext() {
                if (this.u.hasNext()) {
                    java.lang.String next = this.u.next();
                    if (this.u.hasNext() || !next.isEmpty()) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        public CharSequenceCharSource(java.lang.CharSequence charSequence) {
            this.a = (java.lang.CharSequence) com.google.common.base.Preconditions.checkNotNull(charSequence);
        }

        public final java.util.Iterator<java.lang.String> c() {
            return new com.google.common.io.CharSource.CharSequenceCharSource.AnonymousClass1();
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            return this.a.length() == 0;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return this.a.length();
        }

        @Override // com.google.common.io.CharSource
        public com.google.common.base.Optional<java.lang.Long> lengthIfKnown() {
            return com.google.common.base.Optional.of(java.lang.Long.valueOf(this.a.length()));
        }

        @Override // com.google.common.io.CharSource
        public java.io.Reader openStream() {
            return new com.google.common.io.CharSequenceReader(this.a);
        }

        @Override // com.google.common.io.CharSource
        public java.lang.String read() {
            return this.a.toString();
        }

        @Override // com.google.common.io.CharSource
        public java.lang.String readFirstLine() {
            java.util.Iterator<java.lang.String> c = c();
            if (c.hasNext()) {
                return c.next();
            }
            return null;
        }

        @Override // com.google.common.io.CharSource
        public com.google.common.collect.ImmutableList<java.lang.String> readLines() {
            return com.google.common.collect.ImmutableList.copyOf(c());
        }

        @Override // com.google.common.io.CharSource
        public <T> T readLines(com.google.common.io.LineProcessor<T> lineProcessor) throws java.io.IOException {
            java.util.Iterator<java.lang.String> c = c();
            while (c.hasNext() && lineProcessor.processLine(c.next())) {
            }
            return lineProcessor.getResult();
        }

        public java.lang.String toString() {
            return "CharSource.wrap(" + com.google.common.base.Ascii.truncate(this.a, 30, "...") + ")";
        }
    }

    public static final class ConcatenatedCharSource extends com.google.common.io.CharSource {
        public final java.lang.Iterable<? extends com.google.common.io.CharSource> a;

        public ConcatenatedCharSource(java.lang.Iterable<? extends com.google.common.io.CharSource> iterable) {
            this.a = (java.lang.Iterable) com.google.common.base.Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws java.io.IOException {
            java.util.Iterator<? extends com.google.common.io.CharSource> it = this.a.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long length() throws java.io.IOException {
            java.util.Iterator<? extends com.google.common.io.CharSource> it = this.a.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().length();
            }
            return j;
        }

        @Override // com.google.common.io.CharSource
        public com.google.common.base.Optional<java.lang.Long> lengthIfKnown() {
            java.util.Iterator<? extends com.google.common.io.CharSource> it = this.a.iterator();
            long j = 0;
            while (it.hasNext()) {
                com.google.common.base.Optional<java.lang.Long> lengthIfKnown = it.next().lengthIfKnown();
                if (!lengthIfKnown.isPresent()) {
                    return com.google.common.base.Optional.absent();
                }
                j += lengthIfKnown.get().longValue();
            }
            return com.google.common.base.Optional.of(java.lang.Long.valueOf(j));
        }

        @Override // com.google.common.io.CharSource
        public java.io.Reader openStream() throws java.io.IOException {
            return new com.google.common.io.MultiReader(this.a.iterator());
        }

        public java.lang.String toString() {
            return "CharSource.concat(" + this.a + ")";
        }
    }

    public static final class EmptyCharSource extends com.google.common.io.CharSource.StringCharSource {
        public static final com.google.common.io.CharSource.EmptyCharSource c = new com.google.common.io.CharSource.EmptyCharSource();

        public EmptyCharSource() {
            super("");
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public java.lang.String toString() {
            return "CharSource.empty()";
        }
    }

    public static class StringCharSource extends com.google.common.io.CharSource.CharSequenceCharSource {
        public StringCharSource(java.lang.String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(com.google.common.io.CharSink charSink) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(charSink);
            try {
                ((java.io.Writer) com.google.common.io.Closer.create().register(charSink.openStream())).write((java.lang.String) this.a);
                return this.a.length();
            } finally {
            }
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(java.lang.Appendable appendable) throws java.io.IOException {
            appendable.append(this.a);
            return this.a.length();
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.io.CharSource
        public java.io.Reader openStream() {
            return new java.io.StringReader((java.lang.String) this.a);
        }
    }

    public static com.google.common.io.CharSource concat(java.lang.Iterable<? extends com.google.common.io.CharSource> iterable) {
        return new com.google.common.io.CharSource.ConcatenatedCharSource(iterable);
    }

    public static com.google.common.io.CharSource concat(java.util.Iterator<? extends com.google.common.io.CharSource> it) {
        return concat(com.google.common.collect.ImmutableList.copyOf(it));
    }

    public static com.google.common.io.CharSource concat(com.google.common.io.CharSource... charSourceArr) {
        return concat(com.google.common.collect.ImmutableList.copyOf(charSourceArr));
    }

    public static com.google.common.io.CharSource empty() {
        return com.google.common.io.CharSource.EmptyCharSource.c;
    }

    public static com.google.common.io.CharSource wrap(java.lang.CharSequence charSequence) {
        return charSequence instanceof java.lang.String ? new com.google.common.io.CharSource.StringCharSource((java.lang.String) charSequence) : new com.google.common.io.CharSource.CharSequenceCharSource(charSequence);
    }

    public final long a(java.io.Reader reader) throws java.io.IOException {
        long j = 0;
        while (true) {
            long skip = reader.skip(Long.MAX_VALUE);
            if (skip == 0) {
                return j;
            }
            j += skip;
        }
    }

    @com.google.common.annotations.Beta
    public com.google.common.io.ByteSource asByteSource(java.nio.charset.Charset charset) {
        return new com.google.common.io.CharSource.AsByteSource(charset);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long copyTo(com.google.common.io.CharSink charSink) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(charSink);
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            return com.google.common.io.CharStreams.copy((java.io.Reader) create.register(openStream()), (java.io.Writer) create.register(charSink.openStream()));
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long copyTo(java.lang.Appendable appendable) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(appendable);
        try {
            return com.google.common.io.CharStreams.copy((java.io.Reader) com.google.common.io.Closer.create().register(openStream()), appendable);
        } finally {
        }
    }

    public boolean isEmpty() throws java.io.IOException {
        com.google.common.base.Optional<java.lang.Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue() == 0;
        }
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            return ((java.io.Reader) create.register(openStream())).read() == -1;
        } catch (java.lang.Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    @com.google.common.annotations.Beta
    public long length() throws java.io.IOException {
        com.google.common.base.Optional<java.lang.Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        try {
            return a((java.io.Reader) com.google.common.io.Closer.create().register(openStream()));
        } finally {
        }
    }

    @com.google.common.annotations.Beta
    public com.google.common.base.Optional<java.lang.Long> lengthIfKnown() {
        return com.google.common.base.Optional.absent();
    }

    public java.io.BufferedReader openBufferedStream() throws java.io.IOException {
        java.io.Reader openStream = openStream();
        return openStream instanceof java.io.BufferedReader ? (java.io.BufferedReader) openStream : new java.io.BufferedReader(openStream);
    }

    public abstract java.io.Reader openStream() throws java.io.IOException;

    public java.lang.String read() throws java.io.IOException {
        try {
            return com.google.common.io.CharStreams.toString((java.io.Reader) com.google.common.io.Closer.create().register(openStream()));
        } finally {
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.lang.String readFirstLine() throws java.io.IOException {
        try {
            return ((java.io.BufferedReader) com.google.common.io.Closer.create().register(openBufferedStream())).readLine();
        } finally {
        }
    }

    public com.google.common.collect.ImmutableList<java.lang.String> readLines() throws java.io.IOException {
        try {
            java.io.BufferedReader bufferedReader = (java.io.BufferedReader) com.google.common.io.Closer.create().register(openBufferedStream());
            java.util.ArrayList newArrayList = com.google.common.collect.Lists.newArrayList();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return com.google.common.collect.ImmutableList.copyOf((java.util.Collection) newArrayList);
                }
                newArrayList.add(readLine);
            }
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public <T> T readLines(com.google.common.io.LineProcessor<T> lineProcessor) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(lineProcessor);
        try {
            return (T) com.google.common.io.CharStreams.readLines((java.io.Reader) com.google.common.io.Closer.create().register(openStream()), lineProcessor);
        } finally {
        }
    }
}
