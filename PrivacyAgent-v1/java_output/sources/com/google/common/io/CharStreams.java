package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class CharStreams {

    public static final class NullWriter extends java.io.Writer {
        public static final com.google.common.io.CharStreams.NullWriter n = new com.google.common.io.CharStreams.NullWriter();

        @Override // java.io.Writer, java.lang.Appendable
        public java.io.Writer append(char c) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public java.io.Writer append(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public java.io.Writer append(java.lang.CharSequence charSequence, int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, charSequence.length());
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public java.lang.String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i) {
        }

        @Override // java.io.Writer
        public void write(java.lang.String str) {
            com.google.common.base.Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer
        public void write(java.lang.String str, int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2 + i, str.length());
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            com.google.common.base.Preconditions.checkNotNull(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long a(java.io.Reader reader, java.lang.StringBuilder sb) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(reader);
        com.google.common.base.Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            sb.append(cArr, 0, read);
            j += read;
        }
    }

    @com.google.common.annotations.Beta
    public static java.io.Writer asWriter(java.lang.Appendable appendable) {
        return appendable instanceof java.io.Writer ? (java.io.Writer) appendable : new com.google.common.io.AppendableWriter(appendable);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long b(java.io.Reader reader, java.io.Writer writer) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(reader);
        com.google.common.base.Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    public static java.nio.CharBuffer c() {
        return java.nio.CharBuffer.allocate(2048);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long copy(java.lang.Readable readable, java.lang.Appendable appendable) throws java.io.IOException {
        if (readable instanceof java.io.Reader) {
            return appendable instanceof java.lang.StringBuilder ? a((java.io.Reader) readable, (java.lang.StringBuilder) appendable) : b((java.io.Reader) readable, asWriter(appendable));
        }
        com.google.common.base.Preconditions.checkNotNull(readable);
        com.google.common.base.Preconditions.checkNotNull(appendable);
        java.nio.CharBuffer c = c();
        long j = 0;
        while (readable.read(c) != -1) {
            c.flip();
            appendable.append(c);
            j += c.remaining();
            c.clear();
        }
        return j;
    }

    public static java.lang.StringBuilder d(java.lang.Readable readable) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (readable instanceof java.io.Reader) {
            a((java.io.Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static long exhaust(java.lang.Readable readable) throws java.io.IOException {
        java.nio.CharBuffer c = c();
        long j = 0;
        while (true) {
            long read = readable.read(c);
            if (read == -1) {
                return j;
            }
            j += read;
            c.clear();
        }
    }

    @com.google.common.annotations.Beta
    public static java.io.Writer nullWriter() {
        return com.google.common.io.CharStreams.NullWriter.n;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static <T> T readLines(java.lang.Readable readable, com.google.common.io.LineProcessor<T> lineProcessor) throws java.io.IOException {
        java.lang.String readLine;
        com.google.common.base.Preconditions.checkNotNull(readable);
        com.google.common.base.Preconditions.checkNotNull(lineProcessor);
        com.google.common.io.LineReader lineReader = new com.google.common.io.LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }

    @com.google.common.annotations.Beta
    public static java.util.List<java.lang.String> readLines(java.lang.Readable readable) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.common.io.LineReader lineReader = new com.google.common.io.LineReader(readable);
        while (true) {
            java.lang.String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @com.google.common.annotations.Beta
    public static void skipFully(java.io.Reader reader, long j) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip == 0) {
                throw new java.io.EOFException();
            }
            j -= skip;
        }
    }

    public static java.lang.String toString(java.lang.Readable readable) throws java.io.IOException {
        return d(readable).toString();
    }
}
