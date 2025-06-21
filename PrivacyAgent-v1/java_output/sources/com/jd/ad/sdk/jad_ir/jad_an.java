package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_an {
    public static final java.util.concurrent.atomic.AtomicReference<byte[]> jad_an = new java.util.concurrent.atomic.AtomicReference<>();

    /* renamed from: com.jd.ad.sdk.jad_ir.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0381jad_an extends java.io.InputStream {

        @androidx.annotation.NonNull
        public final java.nio.ByteBuffer jad_an;
        public int jad_bo = -1;

        public C0381jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.jad_bo = this.jad_an.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.jad_an.hasRemaining()) {
                return this.jad_an.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
            if (!this.jad_an.hasRemaining()) {
                return -1;
            }
            int min = java.lang.Math.min(i2, this.jad_an.remaining());
            this.jad_an.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i = this.jad_bo;
            if (i == -1) {
                throw new java.io.IOException("Cannot reset to unset mark position");
            }
            this.jad_an.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.jad_an.hasRemaining()) {
                return -1L;
            }
            long min = java.lang.Math.min(j, this.jad_an.remaining());
            this.jad_an.position((int) (r0.position() + min));
            return min;
        }
    }

    public static final class jad_bo {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_bo(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
            this.jad_cp = bArr;
            this.jad_an = i;
            this.jad_bo = i2;
        }
    }

    @androidx.annotation.NonNull
    public static java.nio.ByteBuffer jad_an(@androidx.annotation.NonNull java.io.File file) {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        java.nio.channels.FileChannel fileChannel;
        java.nio.channels.FileChannel fileChannel2 = null;
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
                try {
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
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    java.lang.Throwable th3 = th;
                    fileChannel2 = fileChannel;
                    th = th3;
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
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
            } catch (java.lang.Throwable th4) {
                th = th4;
                fileChannel = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    @androidx.annotation.NonNull
    public static java.nio.ByteBuffer jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        byte[] andSet = jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read < 0) {
                jad_an.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return jad_an(java.nio.ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    public static java.nio.ByteBuffer jad_an(java.nio.ByteBuffer byteBuffer) {
        return (java.nio.ByteBuffer) byteBuffer.position(0);
    }

    public static void jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.File file) {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileChannel fileChannel = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.write(byteBuffer);
                    channel.force(false);
                    channel.close();
                    randomAccessFile.close();
                    try {
                        channel.close();
                    } catch (java.io.IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused2) {
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileChannel = channel;
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
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }
}
