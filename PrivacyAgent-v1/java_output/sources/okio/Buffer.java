package okio;

/* loaded from: classes24.dex */
public final class Buffer implements okio.BufferedSource, okio.BufferedSink, java.lang.Cloneable, java.nio.channels.ByteChannel {
    private static final byte[] DIGITS = {org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;

    @javax.annotation.Nullable
    okio.Segment head;
    long size;

    /* renamed from: okio.Buffer$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.OutputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public java.lang.String toString() {
            return okio.Buffer.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            okio.Buffer.this.writeByte((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            okio.Buffer.this.write(bArr, i, i2);
        }
    }

    /* renamed from: okio.Buffer$2, reason: invalid class name */
    public class AnonymousClass2 extends java.io.InputStream {
        public AnonymousClass2() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) java.lang.Math.min(okio.Buffer.this.size, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            okio.Buffer buffer = okio.Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return okio.Buffer.this.read(bArr, i, i2);
        }

        public java.lang.String toString() {
            return okio.Buffer.this + ".inputStream()";
        }
    }

    public static final class UnsafeCursor implements java.io.Closeable {
        public okio.Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private okio.Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("minByteCount <= 0: " + i);
            }
            if (i > 8192) {
                throw new java.lang.IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
            okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.size;
            okio.Segment writableSegment = buffer.writableSegment(i);
            int i2 = 8192 - writableSegment.limit;
            writableSegment.limit = 8192;
            long j2 = i2;
            this.buffer.size = j + j2;
            this.segment = writableSegment;
            this.offset = j;
            this.data = writableSegment.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.size) {
                return j == -1 ? seek(0L) : seek(j + (this.end - this.start));
            }
            throw new java.lang.IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    throw new java.lang.IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    okio.Buffer buffer2 = this.buffer;
                    okio.Segment segment = buffer2.head.prev;
                    int i = segment.limit;
                    long j4 = i - segment.pos;
                    if (j4 > j3) {
                        segment.limit = (int) (i - j3);
                        break;
                    }
                    buffer2.head = segment.pop();
                    okio.SegmentPool.recycle(segment);
                    j3 -= j4;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    okio.Segment writableSegment = this.buffer.writableSegment(1);
                    int min = (int) java.lang.Math.min(j5, 8192 - writableSegment.limit);
                    int i2 = writableSegment.limit + min;
                    writableSegment.limit = i2;
                    j5 -= min;
                    if (z) {
                        this.segment = writableSegment;
                        this.offset = j2;
                        this.data = writableSegment.data;
                        this.start = i2 - min;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            this.buffer.size = j;
            return j2;
        }

        public final int seek(long j) {
            if (j >= -1) {
                okio.Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    okio.Segment segment = buffer.head;
                    okio.Segment segment2 = this.segment;
                    long j3 = 0;
                    if (segment2 != null) {
                        long j4 = this.offset - (this.start - segment2.pos);
                        if (j4 > j) {
                            j2 = j4;
                            segment2 = segment;
                            segment = segment2;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = segment2.limit;
                            int i2 = segment2.pos;
                            if (j < (i - i2) + j3) {
                                break;
                            }
                            j3 += i - i2;
                            segment2 = segment2.next;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.prev;
                            j2 -= segment.limit - segment.pos;
                        }
                        segment2 = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segment2.shared) {
                        okio.Segment unsharedCopy = segment2.unsharedCopy();
                        okio.Buffer buffer2 = this.buffer;
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        segment2.prev.pop();
                    }
                    this.segment = segment2;
                    this.offset = j;
                    this.data = segment2.data;
                    int i3 = segment2.pos + ((int) (j - j3));
                    this.start = i3;
                    int i4 = segment2.limit;
                    this.end = i4;
                    return i4 - i3;
                }
            }
            throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("offset=%s > size=%s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(this.buffer.size)));
        }
    }

    private okio.ByteString digest(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            okio.Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                messageDigest.update(bArr, i, segment.limit - i);
                okio.Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    messageDigest.update(bArr2, i2, segment2.limit - i2);
                }
            }
            return okio.ByteString.of(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private okio.ByteString hmac(java.lang.String str, okio.ByteString byteString) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            mac.init(new javax.crypto.spec.SecretKeySpec(byteString.toByteArray(), str));
            okio.Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                mac.update(bArr, i, segment.limit - i);
                okio.Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    mac.update(bArr2, i2, segment2.limit - i2);
                }
            }
            return okio.ByteString.of(mac.doFinal());
        } catch (java.security.InvalidKeyException e) {
            throw new java.lang.IllegalArgumentException(e);
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private boolean rangeEquals(okio.Segment segment, int i, okio.ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private void readFrom(java.io.InputStream inputStream, long j, boolean z) throws java.io.IOException {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            okio.Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) java.lang.Math.min(j, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z) {
                    throw new java.io.EOFException();
                }
                return;
            } else {
                writableSegment.limit += read;
                long j2 = read;
                this.size += j2;
                j -= j2;
            }
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public okio.Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public okio.Buffer clone() {
        okio.Buffer buffer = new okio.Buffer();
        if (this.size == 0) {
            return buffer;
        }
        okio.Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        okio.Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        okio.Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j : j - (r3 - segment.pos);
    }

    public final okio.Buffer copyTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final okio.Buffer copyTo(java.io.OutputStream outputStream, long j, long j2) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        okio.Segment segment = this.head;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
        }
        while (j2 > 0) {
            int min = (int) java.lang.Math.min(segment.limit - r10, j2);
            outputStream.write(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public final okio.Buffer copyTo(okio.Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.size += j2;
        okio.Segment segment = this.head;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
        }
        while (j2 > 0) {
            okio.Segment sharedCopy = segment.sharedCopy();
            int i3 = (int) (sharedCopy.pos + j);
            sharedCopy.pos = i3;
            sharedCopy.limit = java.lang.Math.min(i3 + ((int) j2), sharedCopy.limit);
            okio.Segment segment2 = buffer.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer.head = sharedCopy;
            } else {
                segment2.prev.push(sharedCopy);
            }
            j2 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof okio.Buffer)) {
            return false;
        }
        okio.Buffer buffer = (okio.Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        okio.Segment segment = this.head;
        okio.Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        while (j2 < this.size) {
            long min = java.lang.Math.min(segment.limit - i, segment2.limit - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += min;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public okio.Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        okio.Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j <= j) {
            long j3 = j - j2;
            okio.Segment segment = this.head;
            do {
                segment = segment.prev;
                int i2 = segment.limit;
                i = segment.pos;
                j3 += i2 - i;
            } while (j3 < 0);
            return segment.data[i + ((int) j3)];
        }
        okio.Segment segment2 = this.head;
        while (true) {
            int i3 = segment2.limit;
            int i4 = segment2.pos;
            long j4 = i3 - i4;
            if (j < j4) {
                return segment2.data[i4 + ((int) j)];
            }
            j -= j4;
            segment2 = segment2.next;
        }
    }

    public int hashCode() {
        okio.Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public final okio.ByteString hmacSha1(okio.ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final okio.ByteString hmacSha256(okio.ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final okio.ByteString hmacSha512(okio.ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        okio.Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("size=%s fromIndex=%s toIndex=%s", java.lang.Long.valueOf(this.size), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        }
        long j4 = this.size;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (segment = this.head) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j6 = (segment.limit - segment.pos) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.next;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = segment.data;
            int min = (int) java.lang.Math.min(segment.limit, (segment.pos + j5) - j4);
            for (int i = (int) ((segment.pos + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.pos) + j4;
                }
            }
            j4 += segment.limit - segment.pos;
            segment = segment.next;
            j7 = j4;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString) throws java.io.IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString, long j) throws java.io.IOException {
        byte[] bArr;
        if (byteString.size() == 0) {
            throw new java.lang.IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        okio.Segment segment = this.head;
        long j3 = -1;
        if (segment == null) {
            return -1L;
        }
        long j4 = this.size;
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j5 = (segment.limit - segment.pos) + j2;
                if (j5 >= j) {
                    break;
                }
                segment = segment.next;
                j2 = j5;
            }
            j4 = j2;
        }
        byte b = byteString.getByte(0);
        int size = byteString.size();
        long j6 = 1 + (this.size - size);
        long j7 = j;
        okio.Segment segment2 = segment;
        long j8 = j4;
        while (j8 < j6) {
            byte[] bArr2 = segment2.data;
            int min = (int) java.lang.Math.min(segment2.limit, (segment2.pos + j6) - j8);
            int i = (int) ((segment2.pos + j7) - j8);
            while (i < min) {
                if (bArr2[i] == b) {
                    bArr = bArr2;
                    if (rangeEquals(segment2, i + 1, byteString, 1, size)) {
                        return (i - segment2.pos) + j8;
                    }
                } else {
                    bArr = bArr2;
                }
                i++;
                bArr2 = bArr;
            }
            j8 += segment2.limit - segment2.pos;
            segment2 = segment2.next;
            j7 = j8;
            j3 = -1;
        }
        return j3;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.prev;
                j3 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j4 = (segment.limit - segment.pos) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.next;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i = (int) ((segment.pos + j) - j3);
                int i3 = segment.limit;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        i2 = segment.pos;
                        return (i - i2) + j3;
                    }
                    i++;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                j = j3;
            }
            return -1L;
        }
        byte[] internalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i = (int) ((segment.pos + j) - j3);
            int i4 = segment.limit;
            while (i < i4) {
                byte b4 = bArr2[i];
                for (byte b5 : internalArray) {
                    if (b4 == b5) {
                        i2 = segment.pos;
                        return (i - i2) + j3;
                    }
                }
                i++;
            }
            j3 += segment.limit - segment.pos;
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public java.io.InputStream inputStream() {
        return new okio.Buffer.AnonymousClass2();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final okio.ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new okio.Buffer.AnonymousClass1();
    }

    @Override // okio.BufferedSource
    public okio.BufferedSource peek() {
        return okio.Okio.buffer(new okio.PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, okio.ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, okio.ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = java.lang.Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i = segment.pos + min;
        segment.pos = i;
        this.size -= min;
        if (i == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        okio.Util.checkOffsetAndCount(bArr.length, i, i2);
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = java.lang.Math.min(i2, segment.limit - segment.pos);
        java.lang.System.arraycopy(segment.data, segment.pos, bArr, i, min);
        int i3 = segment.pos + min;
        segment.pos = i3;
        this.size -= min;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.size;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(this, j);
        return j;
    }

    @Override // okio.BufferedSource
    public long readAll(okio.Sink sink) throws java.io.IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final okio.Buffer.UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new okio.Buffer.UnsafeCursor());
    }

    public final okio.Buffer.UnsafeCursor readAndWriteUnsafe(okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size = j - 1;
        if (i3 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws java.io.EOFException {
        okio.Util.checkOffsetAndCount(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString() {
        return new okio.ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString(long j) throws java.io.EOFException {
        return new okio.ByteString(readByteArray(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af A[EDGE_INSN: B:46:0x00af->B:40:0x00af BREAK  A[LOOP:0: B:4:0x0011->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        if (this.size == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        int i = 0;
        long j = -7;
        boolean z = false;
        long j2 = 0;
        boolean z2 = false;
        do {
            okio.Segment segment = this.head;
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j2 < -922337203685477580L || (j2 == -922337203685477580L && i4 < j)) {
                        okio.Buffer writeByte = new okio.Buffer().writeDecimalLong(j2).writeByte((int) b);
                        if (!z) {
                            writeByte.readByte();
                        }
                        throw new java.lang.NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    j2 = (j2 * 10) + i4;
                } else if (b == 45 && i == 0) {
                    j--;
                    z = true;
                } else {
                    if (i == 0) {
                        throw new java.lang.NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + java.lang.Integer.toHexString(b));
                    }
                    z2 = true;
                    if (i2 != i3) {
                        this.head = segment.pop();
                        okio.SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i2;
                    }
                    if (!z2) {
                        break;
                    }
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
            }
            if (!z2) {
            }
        } while (this.head != null);
        this.size -= i;
        return z ? j2 : -j2;
    }

    public final okio.Buffer readFrom(java.io.InputStream inputStream) throws java.io.IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final okio.Buffer readFrom(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.BufferedSource
    public void readFully(okio.Buffer buffer, long j) throws java.io.EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new java.io.EOFException();
        }
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws java.io.EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            i += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5 A[EDGE_INSN: B:41:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() {
        int i;
        int i2;
        if (this.size == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        int i3 = 0;
        long j = 0;
        boolean z = false;
        do {
            okio.Segment segment = this.head;
            byte[] bArr = segment.data;
            int i4 = segment.pos;
            int i5 = segment.limit;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else if (b >= 65 && b <= 70) {
                        i = b - 65;
                    } else {
                        if (i3 == 0) {
                            throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + java.lang.Integer.toHexString(b));
                        }
                        z = true;
                        if (i4 != i5) {
                            this.head = segment.pop();
                            okio.SegmentPool.recycle(segment);
                        } else {
                            segment.pos = i4;
                        }
                        if (!z) {
                            break;
                        }
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new java.lang.NumberFormatException("Number too large: " + new okio.Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | i2;
                i4++;
                i3++;
            }
            if (i4 != i5) {
            }
            if (!z) {
            }
        } while (this.head != null);
        this.size -= i3;
        return j;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j < 4) {
            throw new java.lang.IllegalStateException("size < 4: " + this.size);
        }
        okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.size = j - 4;
        if (i8 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return okio.Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j < 8) {
            throw new java.lang.IllegalStateException("size < 8: " + this.size);
        }
        okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((readInt() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) << 32) | (net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT & readInt());
        }
        byte[] bArr = segment.data;
        long j2 = (bArr[i] & 255) << 56;
        long j3 = ((bArr[r11] & 255) << 48) | j2;
        long j4 = j3 | ((bArr[r6] & 255) << 40);
        long j5 = j4 | ((bArr[r11] & 255) << 32) | ((bArr[r6] & 255) << 24);
        long j6 = j5 | ((bArr[r9] & 255) << 16);
        long j7 = j6 | ((bArr[r6] & 255) << 8);
        int i3 = i + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j8 = j7 | (bArr[r9] & 255);
        this.size = j - 8;
        if (i3 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return j8;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return okio.Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j < 2) {
            throw new java.lang.IllegalStateException("size < 2: " + this.size);
        }
        okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.size = j - 2;
        if (i4 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return okio.Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(long j, java.nio.charset.Charset charset) throws java.io.EOFException {
        okio.Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        okio.Segment segment = this.head;
        int i = segment.pos;
        if (i + j > segment.limit) {
            return new java.lang.String(readByteArray(j), charset);
        }
        java.lang.String str = new java.lang.String(segment.data, i, (int) j, charset);
        int i2 = (int) (segment.pos + j);
        segment.pos = i2;
        this.size -= j;
        if (i2 == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(java.nio.charset.Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public final okio.Buffer.UnsafeCursor readUnsafe() {
        return readUnsafe(new okio.Buffer.UnsafeCursor());
    }

    public final okio.Buffer.UnsafeCursor readUnsafe(okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8() {
        try {
            return readString(this.size, okio.Util.UTF_8);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8(long j) throws java.io.EOFException {
        return readString(j, okio.Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws java.io.EOFException {
        int i;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new java.io.EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & com.google.common.base.Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.size < j) {
            throw new java.io.EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + java.lang.Integer.toHexString(b) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        return i > 1114111 ? REPLACEMENT_CHARACTER : ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
    }

    @Override // okio.BufferedSource
    @javax.annotation.Nullable
    public java.lang.String readUtf8Line() throws java.io.EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    public java.lang.String readUtf8Line(long j) throws java.io.EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                java.lang.String readUtf8 = readUtf8(j2);
                skip(2L);
                return readUtf8;
            }
        }
        java.lang.String readUtf82 = readUtf8(j);
        skip(1L);
        return readUtf82;
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict() throws java.io.EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict(long j) throws java.io.EOFException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        okio.Buffer buffer = new okio.Buffer();
        copyTo(buffer, 0L, java.lang.Math.min(32L, size()));
        throw new java.io.EOFException("\\n not found: limit=" + java.lang.Math.min(size(), j) + " content=" + buffer.readByteString().hex() + kotlin.text.Typography.ellipsis);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws java.io.EOFException {
        if (this.size < j) {
            throw new java.io.EOFException();
        }
    }

    public java.util.List<java.lang.Integer> segmentSizes() {
        if (this.head == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        okio.Segment segment = this.head;
        arrayList.add(java.lang.Integer.valueOf(segment.limit - segment.pos));
        okio.Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(java.lang.Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // okio.BufferedSource
    public int select(okio.Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int selectPrefix(okio.Options options, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        okio.Segment segment;
        okio.Segment segment2 = this.head;
        int i5 = -2;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i6 = segment2.pos;
            int i7 = segment2.limit;
            int[] iArr = options.trie;
            okio.Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0: while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 >= 0) {
                    int i14 = i6 + 1;
                    int i15 = bArr[i6] & 255;
                    int i16 = i12 + i11;
                    while (i12 != i16) {
                        if (i15 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i14 == i7) {
                                segment3 = segment3.next;
                                i2 = segment3.pos;
                                bArr = segment3.data;
                                i7 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i2 = i14;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                int i17 = i12 + (i11 * (-1));
                while (true) {
                    int i18 = i6 + 1;
                    int i19 = i12 + 1;
                    if ((bArr[i6] & 255) != iArr[i12]) {
                        return i9;
                    }
                    boolean z2 = i19 == i17;
                    if (i18 == i7) {
                        okio.Segment segment4 = segment3.next;
                        i4 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i3 = segment4.limit;
                        if (segment4 != segment2) {
                            segment = segment4;
                            bArr = bArr2;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        }
                    } else {
                        okio.Segment segment5 = segment3;
                        i3 = i7;
                        i4 = i18;
                        segment = segment5;
                    }
                    if (z2) {
                        i = iArr[i19];
                        i2 = i4;
                        i7 = i3;
                        segment3 = segment;
                        break;
                    }
                    i6 = i4;
                    i7 = i3;
                    i12 = i19;
                    segment3 = segment;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
        } else {
            if (z) {
                return -2;
            }
            return options.indexOf(okio.ByteString.EMPTY);
        }
    }

    public final okio.ByteString sha1() {
        return digest("SHA-1");
    }

    public final okio.ByteString sha256() {
        return digest("SHA-256");
    }

    public final okio.ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws java.io.EOFException {
        while (j > 0) {
            if (this.head == null) {
                throw new java.io.EOFException();
            }
            int min = (int) java.lang.Math.min(j, r0.limit - r0.pos);
            long j2 = min;
            this.size -= j2;
            j -= j2;
            okio.Segment segment = this.head;
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                okio.SegmentPool.recycle(segment);
            }
        }
    }

    public final okio.ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new java.lang.IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final okio.ByteString snapshot(int i) {
        return i == 0 ? okio.ByteString.EMPTY : new okio.SegmentedByteString(this, i);
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return okio.Timeout.NONE;
    }

    public java.lang.String toString() {
        return snapshot().toString();
    }

    public okio.Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new java.lang.IllegalArgumentException();
        }
        okio.Segment segment = this.head;
        if (segment != null) {
            okio.Segment segment2 = segment.prev;
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(okio.SegmentPool.take()) : segment2;
        }
        okio.Segment take = okio.SegmentPool.take();
        this.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (byteBuffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            okio.Segment writableSegment = writableSegment(1);
            int min = java.lang.Math.min(i, 8192 - writableSegment.limit);
            byteBuffer.get(writableSegment.data, writableSegment.limit, min);
            i -= min;
            writableSegment.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(okio.ByteString byteString) {
        if (byteString == null) {
            throw new java.lang.IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = i2;
        okio.Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            okio.Segment writableSegment = writableSegment(1);
            int min = java.lang.Math.min(i3 - i, 8192 - writableSegment.limit);
            java.lang.System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
            i += min;
            writableSegment.limit += min;
        }
        this.size += j;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.Source source, long j) throws java.io.IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new java.lang.IllegalArgumentException("source == this");
        }
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            okio.Segment segment = buffer.head;
            if (j < segment.limit - segment.pos) {
                okio.Segment segment2 = this.head;
                okio.Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((segment3.limit + j) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                        segment.writeTo(segment3, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                buffer.head = segment.split((int) j);
            }
            okio.Segment segment4 = buffer.head;
            long j2 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            okio.Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4).compact();
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // okio.BufferedSink
    public long writeAll(okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeByte(int i) {
        okio.Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        okio.Segment writableSegment = writableSegment(i);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit + i;
        while (j != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        writableSegment.limit += i;
        this.size += i;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (java.lang.Long.numberOfTrailingZeros(java.lang.Long.highestOneBit(j)) / 4) + 1;
        okio.Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeInt(int i) {
        okio.Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeIntLe(int i) {
        return writeInt(okio.Util.reverseBytesInt(i));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeLong(long j) {
        okio.Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        writableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeLongLe(long j) {
        return writeLong(okio.Util.reverseBytesLong(j));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeShort(int i) {
        okio.Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeShortLe(int i) {
        return writeShort((int) okio.Util.reverseBytesShort((short) i));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new java.lang.IllegalArgumentException("charset == null");
            }
            if (charset.equals(okio.Util.UTF_8)) {
                return writeUtf8(str, i, i2);
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeString(java.lang.String str, java.nio.charset.Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final okio.Buffer writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return writeTo(outputStream, this.size);
    }

    public final okio.Buffer writeTo(java.io.OutputStream outputStream, long j) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, 0L, j);
        okio.Segment segment = this.head;
        while (j > 0) {
            int min = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, min);
            int i = segment.pos + min;
            segment.pos = i;
            long j2 = min;
            this.size -= j2;
            j -= j2;
            if (i == segment.limit) {
                okio.Segment pop = segment.pop();
                this.head = pop;
                okio.SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8(java.lang.String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8(java.lang.String str, int i, int i2) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                okio.Segment writableSegment = writableSegment(1);
                byte[] bArr = writableSegment.data;
                int i3 = writableSegment.limit - i;
                int min = java.lang.Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) charAt;
                while (i4 < min) {
                    char charAt2 = str.charAt(i4);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) charAt2;
                    i4++;
                }
                int i5 = writableSegment.limit;
                int i6 = (i3 + i4) - i5;
                writableSegment.limit = i5 + i6;
                this.size += i6;
                i = i4;
            } else {
                if (charAt < 2048) {
                    writeByte((charAt >> 6) | 192);
                    writeByte((charAt & '?') | 128);
                } else if (charAt < 55296 || charAt > 57343) {
                    writeByte((charAt >> '\f') | 224);
                    writeByte(((charAt >> 6) & 63) | 128);
                    writeByte((charAt & '?') | 128);
                } else {
                    int i7 = i + 1;
                    char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i = i7;
                    } else {
                        int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i8 >> 18) | 240);
                        writeByte(((i8 >> 12) & 63) | 128);
                        writeByte(((i8 >> 6) & 63) | 128);
                        writeByte((i8 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i > 1114111) {
                throw new java.lang.IllegalArgumentException("Unexpected code point: " + java.lang.Integer.toHexString(i));
            }
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        }
        return this;
    }
}
