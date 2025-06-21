package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ByteSource {

    public class AsCharSource extends com.google.common.io.CharSource {
        public final java.nio.charset.Charset a;

        public AsCharSource(java.nio.charset.Charset charset) {
            this.a = (java.nio.charset.Charset) com.google.common.base.Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.CharSource
        public com.google.common.io.ByteSource asByteSource(java.nio.charset.Charset charset) {
            return charset.equals(this.a) ? com.google.common.io.ByteSource.this : super.asByteSource(charset);
        }

        @Override // com.google.common.io.CharSource
        public java.io.Reader openStream() throws java.io.IOException {
            return new java.io.InputStreamReader(com.google.common.io.ByteSource.this.openStream(), this.a);
        }

        @Override // com.google.common.io.CharSource
        public java.lang.String read() throws java.io.IOException {
            return new java.lang.String(com.google.common.io.ByteSource.this.read(), this.a);
        }

        public java.lang.String toString() {
            return com.google.common.io.ByteSource.this.toString() + ".asCharSource(" + this.a + ")";
        }
    }

    public static class ByteArrayByteSource extends com.google.common.io.ByteSource {
        public final byte[] a;
        public final int b;
        public final int c;

        public ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public ByteArrayByteSource(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(java.io.OutputStream outputStream) throws java.io.IOException {
            outputStream.write(this.a, this.b, this.c);
            return this.c;
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.hash.HashCode hash(com.google.common.hash.HashFunction hashFunction) throws java.io.IOException {
            return hashFunction.hashBytes(this.a, this.b, this.c);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            return this.c == 0;
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openBufferedStream() throws java.io.IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() {
            return new java.io.ByteArrayInputStream(this.a, this.b, this.c);
        }

        @Override // com.google.common.io.ByteSource
        public <T> T read(com.google.common.io.ByteProcessor<T> byteProcessor) throws java.io.IOException {
            byteProcessor.processBytes(this.a, this.b, this.c);
            return byteProcessor.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] bArr = this.a;
            int i = this.b;
            return java.util.Arrays.copyOfRange(bArr, i, this.c + i);
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.c;
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.base.Optional<java.lang.Long> sizeIfKnown() {
            return com.google.common.base.Optional.of(java.lang.Long.valueOf(this.c));
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.io.ByteSource slice(long j, long j2) {
            com.google.common.base.Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", j2);
            long min = java.lang.Math.min(j, this.c);
            return new com.google.common.io.ByteSource.ByteArrayByteSource(this.a, this.b + ((int) min), (int) java.lang.Math.min(j2, this.c - min));
        }

        public java.lang.String toString() {
            return "ByteSource.wrap(" + com.google.common.base.Ascii.truncate(com.google.common.io.BaseEncoding.base16().encode(this.a, this.b, this.c), 30, "...") + ")";
        }
    }

    public static final class ConcatenatedByteSource extends com.google.common.io.ByteSource {
        public final java.lang.Iterable<? extends com.google.common.io.ByteSource> a;

        public ConcatenatedByteSource(java.lang.Iterable<? extends com.google.common.io.ByteSource> iterable) {
            this.a = (java.lang.Iterable) com.google.common.base.Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws java.io.IOException {
            java.util.Iterator<? extends com.google.common.io.ByteSource> it = this.a.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return new com.google.common.io.MultiInputStream(this.a.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws java.io.IOException {
            java.util.Iterator<? extends com.google.common.io.ByteSource> it = this.a.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().size();
                if (j < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j;
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.base.Optional<java.lang.Long> sizeIfKnown() {
            java.lang.Iterable<? extends com.google.common.io.ByteSource> iterable = this.a;
            if (!(iterable instanceof java.util.Collection)) {
                return com.google.common.base.Optional.absent();
            }
            java.util.Iterator<? extends com.google.common.io.ByteSource> it = iterable.iterator();
            long j = 0;
            while (it.hasNext()) {
                com.google.common.base.Optional<java.lang.Long> sizeIfKnown = it.next().sizeIfKnown();
                if (!sizeIfKnown.isPresent()) {
                    return com.google.common.base.Optional.absent();
                }
                j += sizeIfKnown.get().longValue();
                if (j < 0) {
                    return com.google.common.base.Optional.of(Long.MAX_VALUE);
                }
            }
            return com.google.common.base.Optional.of(java.lang.Long.valueOf(j));
        }

        public java.lang.String toString() {
            return "ByteSource.concat(" + this.a + ")";
        }
    }

    public static final class EmptyByteSource extends com.google.common.io.ByteSource.ByteArrayByteSource {
        public static final com.google.common.io.ByteSource.EmptyByteSource d = new com.google.common.io.ByteSource.EmptyByteSource();

        public EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.io.CharSource asCharSource(java.nio.charset.Charset charset) {
            com.google.common.base.Preconditions.checkNotNull(charset);
            return com.google.common.io.CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.a;
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public java.lang.String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class SlicedByteSource extends com.google.common.io.ByteSource {
        public final long a;
        public final long b;

        public SlicedByteSource(long j, long j2) {
            com.google.common.base.Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", j2);
            this.a = j;
            this.b = j2;
        }

        public final java.io.InputStream b(java.io.InputStream inputStream) throws java.io.IOException {
            long j = this.a;
            if (j > 0) {
                try {
                    if (com.google.common.io.ByteStreams.d(inputStream, j) < this.a) {
                        inputStream.close();
                        return new java.io.ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return com.google.common.io.ByteStreams.limit(inputStream, this.b);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws java.io.IOException {
            return this.b == 0 || super.isEmpty();
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openBufferedStream() throws java.io.IOException {
            return b(com.google.common.io.ByteSource.this.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return b(com.google.common.io.ByteSource.this.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.base.Optional<java.lang.Long> sizeIfKnown() {
            com.google.common.base.Optional<java.lang.Long> sizeIfKnown = com.google.common.io.ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return com.google.common.base.Optional.absent();
            }
            long longValue = sizeIfKnown.get().longValue();
            return com.google.common.base.Optional.of(java.lang.Long.valueOf(java.lang.Math.min(this.b, longValue - java.lang.Math.min(this.a, longValue))));
        }

        @Override // com.google.common.io.ByteSource
        public com.google.common.io.ByteSource slice(long j, long j2) {
            com.google.common.base.Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", j2);
            return com.google.common.io.ByteSource.this.slice(this.a + j, java.lang.Math.min(j2, this.b - j));
        }

        public java.lang.String toString() {
            return com.google.common.io.ByteSource.this.toString() + ".slice(" + this.a + ", " + this.b + ")";
        }
    }

    public static com.google.common.io.ByteSource concat(java.lang.Iterable<? extends com.google.common.io.ByteSource> iterable) {
        return new com.google.common.io.ByteSource.ConcatenatedByteSource(iterable);
    }

    public static com.google.common.io.ByteSource concat(java.util.Iterator<? extends com.google.common.io.ByteSource> it) {
        return concat(com.google.common.collect.ImmutableList.copyOf(it));
    }

    public static com.google.common.io.ByteSource concat(com.google.common.io.ByteSource... byteSourceArr) {
        return concat(com.google.common.collect.ImmutableList.copyOf(byteSourceArr));
    }

    public static com.google.common.io.ByteSource empty() {
        return com.google.common.io.ByteSource.EmptyByteSource.d;
    }

    public static com.google.common.io.ByteSource wrap(byte[] bArr) {
        return new com.google.common.io.ByteSource.ByteArrayByteSource(bArr);
    }

    public final long a(java.io.InputStream inputStream) throws java.io.IOException {
        long j = 0;
        while (true) {
            long d = com.google.common.io.ByteStreams.d(inputStream, 2147483647L);
            if (d <= 0) {
                return j;
            }
            j += d;
        }
    }

    public com.google.common.io.CharSource asCharSource(java.nio.charset.Charset charset) {
        return new com.google.common.io.ByteSource.AsCharSource(charset);
    }

    public boolean contentEquals(com.google.common.io.ByteSource byteSource) throws java.io.IOException {
        int read;
        com.google.common.base.Preconditions.checkNotNull(byteSource);
        byte[] b = com.google.common.io.ByteStreams.b();
        byte[] b2 = com.google.common.io.ByteStreams.b();
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            java.io.InputStream inputStream = (java.io.InputStream) create.register(openStream());
            java.io.InputStream inputStream2 = (java.io.InputStream) create.register(byteSource.openStream());
            do {
                read = com.google.common.io.ByteStreams.read(inputStream, b, 0, b.length);
                if (read == com.google.common.io.ByteStreams.read(inputStream2, b2, 0, b2.length) && java.util.Arrays.equals(b, b2)) {
                }
                return false;
            } while (read == b.length);
            create.close();
            return true;
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long copyTo(com.google.common.io.ByteSink byteSink) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(byteSink);
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            return com.google.common.io.ByteStreams.copy((java.io.InputStream) create.register(openStream()), (java.io.OutputStream) create.register(byteSink.openStream()));
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long copyTo(java.io.OutputStream outputStream) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(outputStream);
        try {
            return com.google.common.io.ByteStreams.copy((java.io.InputStream) com.google.common.io.Closer.create().register(openStream()), outputStream);
        } finally {
        }
    }

    public com.google.common.hash.HashCode hash(com.google.common.hash.HashFunction hashFunction) throws java.io.IOException {
        com.google.common.hash.Hasher newHasher = hashFunction.newHasher();
        copyTo(com.google.common.hash.Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() throws java.io.IOException {
        com.google.common.base.Optional<java.lang.Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue() == 0;
        }
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            return ((java.io.InputStream) create.register(openStream())).read() == -1;
        } catch (java.lang.Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public java.io.InputStream openBufferedStream() throws java.io.IOException {
        java.io.InputStream openStream = openStream();
        return openStream instanceof java.io.BufferedInputStream ? (java.io.BufferedInputStream) openStream : new java.io.BufferedInputStream(openStream);
    }

    public abstract java.io.InputStream openStream() throws java.io.IOException;

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public <T> T read(com.google.common.io.ByteProcessor<T> byteProcessor) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(byteProcessor);
        try {
            return (T) com.google.common.io.ByteStreams.readBytes((java.io.InputStream) com.google.common.io.Closer.create().register(openStream()), byteProcessor);
        } finally {
        }
    }

    public byte[] read() throws java.io.IOException {
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            java.io.InputStream inputStream = (java.io.InputStream) create.register(openStream());
            com.google.common.base.Optional<java.lang.Long> sizeIfKnown = sizeIfKnown();
            return sizeIfKnown.isPresent() ? com.google.common.io.ByteStreams.e(inputStream, sizeIfKnown.get().longValue()) : com.google.common.io.ByteStreams.toByteArray(inputStream);
        } catch (java.lang.Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public long size() throws java.io.IOException {
        com.google.common.base.Optional<java.lang.Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        com.google.common.io.Closer create = com.google.common.io.Closer.create();
        try {
            return a((java.io.InputStream) create.register(openStream()));
        } catch (java.io.IOException unused) {
            create.close();
            try {
                return com.google.common.io.ByteStreams.exhaust((java.io.InputStream) com.google.common.io.Closer.create().register(openStream()));
            } finally {
            }
        } finally {
        }
    }

    @com.google.common.annotations.Beta
    public com.google.common.base.Optional<java.lang.Long> sizeIfKnown() {
        return com.google.common.base.Optional.absent();
    }

    public com.google.common.io.ByteSource slice(long j, long j2) {
        return new com.google.common.io.ByteSource.SlicedByteSource(j, j2);
    }
}
