package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ByteStreams {
    public static final java.io.OutputStream a = new com.google.common.io.ByteStreams.AnonymousClass1();

    /* renamed from: com.google.common.io.ByteStreams$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.io.OutputStream {
        public java.lang.String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            com.google.common.base.Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            com.google.common.base.Preconditions.checkNotNull(bArr);
        }
    }

    public static class ByteArrayDataInputStream implements com.google.common.io.ByteArrayDataInput {
        public final java.io.DataInput n;

        public ByteArrayDataInputStream(java.io.ByteArrayInputStream byteArrayInputStream) {
            this.n = new java.io.DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.n.readBoolean();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.n.readByte();
            } catch (java.io.EOFException e) {
                throw new java.lang.IllegalStateException(e);
            } catch (java.io.IOException e2) {
                throw new java.lang.AssertionError(e2);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.n.readChar();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.n.readDouble();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.n.readFloat();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.n.readFully(bArr);
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            try {
                this.n.readFully(bArr, i, i2);
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.n.readInt();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public java.lang.String readLine() {
            try {
                return this.n.readLine();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.n.readLong();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.n.readShort();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public java.lang.String readUTF() {
            try {
                return this.n.readUTF();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.n.readUnsignedByte();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.n.readUnsignedShort();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i) {
            try {
                return this.n.skipBytes(i);
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }
    }

    public static class ByteArrayDataOutputStream implements com.google.common.io.ByteArrayDataOutput {
        public final java.io.DataOutput n;
        public final java.io.ByteArrayOutputStream t;

        public ByteArrayDataOutputStream(java.io.ByteArrayOutputStream byteArrayOutputStream) {
            this.t = byteArrayOutputStream;
            this.n = new java.io.DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.t.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i) {
            try {
                this.n.write(i);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.n.write(bArr);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i, int i2) {
            try {
                this.n.write(bArr, i, i2);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z) {
            try {
                this.n.writeBoolean(z);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i) {
            try {
                this.n.writeByte(i);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(java.lang.String str) {
            try {
                this.n.writeBytes(str);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i) {
            try {
                this.n.writeChar(i);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(java.lang.String str) {
            try {
                this.n.writeChars(str);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d) {
            try {
                this.n.writeDouble(d);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f) {
            try {
                this.n.writeFloat(f);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i) {
            try {
                this.n.writeInt(i);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j) {
            try {
                this.n.writeLong(j);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i) {
            try {
                this.n.writeShort(i);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(java.lang.String str) {
            try {
                this.n.writeUTF(str);
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public static final class LimitedInputStream extends java.io.FilterInputStream {
        public long n;
        public long t;

        public LimitedInputStream(java.io.InputStream inputStream, long j) {
            super(inputStream);
            this.t = -1L;
            com.google.common.base.Preconditions.checkNotNull(inputStream);
            com.google.common.base.Preconditions.checkArgument(j >= 0, "limit must be non-negative");
            this.n = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws java.io.IOException {
            return (int) java.lang.Math.min(((java.io.FilterInputStream) this).in.available(), this.n);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            ((java.io.FilterInputStream) this).in.mark(i);
            this.t = this.n;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws java.io.IOException {
            if (this.n == 0) {
                return -1;
            }
            int read = ((java.io.FilterInputStream) this).in.read();
            if (read != -1) {
                this.n--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            long j = this.n;
            if (j == 0) {
                return -1;
            }
            int read = ((java.io.FilterInputStream) this).in.read(bArr, i, (int) java.lang.Math.min(i2, j));
            if (read != -1) {
                this.n -= read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws java.io.IOException {
            if (!((java.io.FilterInputStream) this).in.markSupported()) {
                throw new java.io.IOException("Mark not supported");
            }
            if (this.t == -1) {
                throw new java.io.IOException("Mark not set");
            }
            ((java.io.FilterInputStream) this).in.reset();
            this.n = this.t;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws java.io.IOException {
            long skip = ((java.io.FilterInputStream) this).in.skip(java.lang.Math.min(j, this.n));
            this.n -= skip;
            return skip;
        }
    }

    public static byte[] a(java.util.Deque<byte[]> deque, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] removeFirst = deque.removeFirst();
            int min = java.lang.Math.min(i2, removeFirst.length);
            java.lang.System.arraycopy(removeFirst, 0, bArr, i - i2, min);
            i2 -= min;
        }
        return bArr;
    }

    public static byte[] b() {
        return new byte[8192];
    }

    public static long c(java.io.InputStream inputStream, long j) throws java.io.IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(java.lang.Math.min(available, j));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        com.google.common.base.Preconditions.checkNotNull(outputStream);
        byte[] b = b();
        long j = 0;
        while (true) {
            int read = inputStream.read(b);
            if (read == -1) {
                return j;
            }
            outputStream.write(b, 0, read);
            j += read;
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long copy(java.nio.channels.ReadableByteChannel readableByteChannel, java.nio.channels.WritableByteChannel writableByteChannel) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(readableByteChannel);
        com.google.common.base.Preconditions.checkNotNull(writableByteChannel);
        long j = 0;
        if (!(readableByteChannel instanceof java.nio.channels.FileChannel)) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(b());
            while (readableByteChannel.read(wrap) != -1) {
                wrap.flip();
                while (wrap.hasRemaining()) {
                    j += writableByteChannel.write(wrap);
                }
                wrap.clear();
            }
            return j;
        }
        java.nio.channels.FileChannel fileChannel = (java.nio.channels.FileChannel) readableByteChannel;
        long position = fileChannel.position();
        long j2 = position;
        while (true) {
            long transferTo = fileChannel.transferTo(j2, android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
            j2 += transferTo;
            fileChannel.position(j2);
            if (transferTo <= 0 && j2 >= fileChannel.size()) {
                return j2 - position;
            }
        }
    }

    public static long d(java.io.InputStream inputStream, long j) throws java.io.IOException {
        byte[] b = b();
        long j2 = 0;
        while (j2 < j) {
            long j3 = j - j2;
            long c = c(inputStream, j3);
            if (c == 0) {
                c = inputStream.read(b, 0, (int) java.lang.Math.min(j3, b.length));
                if (c == -1) {
                    break;
                }
            }
            j2 += c;
        }
        return j2;
    }

    public static byte[] e(java.io.InputStream inputStream, long j) throws java.io.IOException {
        com.google.common.base.Preconditions.checkArgument(j >= 0, "expectedSize (%s) must be non-negative", j);
        if (j > 2147483639) {
            throw new java.lang.OutOfMemoryError(j + " bytes is too large to fit in a byte array");
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int read = inputStream.read(bArr, i3, i2);
            if (read == -1) {
                return java.util.Arrays.copyOf(bArr, i3);
            }
            i2 -= read;
        }
        int read2 = inputStream.read();
        if (read2 == -1) {
            return bArr;
        }
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) read2});
        return f(inputStream, arrayDeque, i + 1);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static long exhaust(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] b = b();
        long j = 0;
        while (true) {
            long read = inputStream.read(b);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public static byte[] f(java.io.InputStream inputStream, java.util.Deque<byte[]> deque, int i) throws java.io.IOException {
        int i2 = 8192;
        while (i < 2147483639) {
            int min = java.lang.Math.min(i2, 2147483639 - i);
            byte[] bArr = new byte[min];
            deque.add(bArr);
            int i3 = 0;
            while (i3 < min) {
                int read = inputStream.read(bArr, i3, min - i3);
                if (read == -1) {
                    return a(deque, i);
                }
                i3 += read;
                i += read;
            }
            i2 = com.google.common.math.IntMath.saturatedMultiply(i2, 2);
        }
        if (inputStream.read() == -1) {
            return a(deque, 2147483639);
        }
        throw new java.lang.OutOfMemoryError("input is too large to fit in a byte array");
    }

    @com.google.common.annotations.Beta
    public static java.io.InputStream limit(java.io.InputStream inputStream, long j) {
        return new com.google.common.io.ByteStreams.LimitedInputStream(inputStream, j);
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataInput newDataInput(java.io.ByteArrayInputStream byteArrayInputStream) {
        return new com.google.common.io.ByteStreams.ByteArrayDataInputStream((java.io.ByteArrayInputStream) com.google.common.base.Preconditions.checkNotNull(byteArrayInputStream));
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new java.io.ByteArrayInputStream(bArr));
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataInput newDataInput(byte[] bArr, int i) {
        com.google.common.base.Preconditions.checkPositionIndex(i, bArr.length);
        return newDataInput(new java.io.ByteArrayInputStream(bArr, i, bArr.length - i));
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new java.io.ByteArrayOutputStream());
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataOutput newDataOutput(int i) {
        if (i >= 0) {
            return newDataOutput(new java.io.ByteArrayOutputStream(i));
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Invalid size: %s", java.lang.Integer.valueOf(i)));
    }

    @com.google.common.annotations.Beta
    public static com.google.common.io.ByteArrayDataOutput newDataOutput(java.io.ByteArrayOutputStream byteArrayOutputStream) {
        return new com.google.common.io.ByteStreams.ByteArrayDataOutputStream((java.io.ByteArrayOutputStream) com.google.common.base.Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @com.google.common.annotations.Beta
    public static java.io.OutputStream nullOutputStream() {
        return a;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static int read(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        com.google.common.base.Preconditions.checkNotNull(bArr);
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static <T> T readBytes(java.io.InputStream inputStream, com.google.common.io.ByteProcessor<T> byteProcessor) throws java.io.IOException {
        int read;
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        com.google.common.base.Preconditions.checkNotNull(byteProcessor);
        byte[] b = b();
        do {
            read = inputStream.read(b);
            if (read == -1) {
                break;
            }
        } while (byteProcessor.processBytes(b, 0, read));
        return byteProcessor.getResult();
    }

    @com.google.common.annotations.Beta
    public static void readFully(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @com.google.common.annotations.Beta
    public static void readFully(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = read(inputStream, bArr, i, i2);
        if (read == i2) {
            return;
        }
        throw new java.io.EOFException("reached end of stream after reading " + read + " bytes; " + i2 + " bytes expected");
    }

    @com.google.common.annotations.Beta
    public static void skipFully(java.io.InputStream inputStream, long j) throws java.io.IOException {
        long d = d(inputStream, j);
        if (d >= j) {
            return;
        }
        throw new java.io.EOFException("reached end of stream after skipping " + d + " bytes; " + j + " bytes expected");
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        return f(inputStream, new java.util.ArrayDeque(20), 0);
    }
}
