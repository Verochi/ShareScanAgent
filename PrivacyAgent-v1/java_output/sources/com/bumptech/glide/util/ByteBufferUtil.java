package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class ByteBufferUtil {
    private static final java.util.concurrent.atomic.AtomicReference<byte[]> BUFFER_REF = new java.util.concurrent.atomic.AtomicReference<>();
    private static final int BUFFER_SIZE = 16384;

    public static class ByteBufferStream extends java.io.InputStream {
        private static final int UNSET = -1;

        @androidx.annotation.NonNull
        private final java.nio.ByteBuffer byteBuffer;
        private int markPos = -1;

        public ByteBufferStream(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.markPos = this.byteBuffer.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.byteBuffer.hasRemaining()) {
                return this.byteBuffer.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) throws java.io.IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int min = java.lang.Math.min(i2, available());
            this.byteBuffer.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws java.io.IOException {
            int i = this.markPos;
            if (i == -1) {
                throw new java.io.IOException("Cannot reset to unset mark position");
            }
            this.byteBuffer.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws java.io.IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1L;
            }
            long min = java.lang.Math.min(j, available());
            this.byteBuffer.position((int) (r0.position() + min));
            return min;
        }
    }

    public static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        public SafeArray(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    private ByteBufferUtil() {
    }

    @androidx.annotation.NonNull
    public static java.nio.ByteBuffer fromFile(@androidx.annotation.NonNull java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new java.io.IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new java.io.IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new java.io.RandomAccessFile(file, "r");
            try {
                fileChannel = randomAccessFile.getChannel();
                java.nio.MappedByteBuffer load = fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    fileChannel.close();
                } catch (java.io.IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException unused2) {
                }
                return load;
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (java.io.IOException unused4) {
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @androidx.annotation.NonNull
    public static java.nio.ByteBuffer fromStream(@androidx.annotation.NonNull java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read < 0) {
                BUFFER_REF.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (java.nio.ByteBuffer) java.nio.ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    @androidx.annotation.Nullable
    private static com.bumptech.glide.util.ByteBufferUtil.SafeArray getSafeArray(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new com.bumptech.glide.util.ByteBufferUtil.SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    @androidx.annotation.NonNull
    public static byte[] toBytes(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        com.bumptech.glide.util.ByteBufferUtil.SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
            return byteBuffer.array();
        }
        java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void toFile(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        java.nio.channels.FileChannel fileChannel = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (java.io.IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException unused2) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (java.io.IOException unused4) {
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @androidx.annotation.NonNull
    public static java.io.InputStream toStream(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        return new com.bumptech.glide.util.ByteBufferUtil.ByteBufferStream(byteBuffer);
    }

    public static void toStream(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.OutputStream outputStream) throws java.io.IOException {
        com.bumptech.glide.util.ByteBufferUtil.SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null) {
            byte[] bArr = safeArray.data;
            int i = safeArray.offset;
            outputStream.write(bArr, i, safeArray.limit + i);
            return;
        }
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = java.lang.Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        BUFFER_REF.set(andSet);
    }
}
