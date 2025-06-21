package com.bytedance.pangle.util.a;

/* loaded from: classes.dex */
public final class b {
    private static java.lang.String a = "";

    private static java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer, int i) {
        if (i < 8) {
            throw new java.lang.IllegalArgumentException("end < start: " + i + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            throw new java.lang.IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            byteBuffer.position(8);
            java.nio.ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static java.lang.String[] a(java.io.File file) {
        java.lang.String str;
        java.nio.ByteBuffer b;
        boolean z;
        java.lang.String str2 = "";
        try {
            b = b(file);
        } catch (java.lang.Exception unused) {
            str = "";
        }
        if (b.order() != java.nio.ByteOrder.LITTLE_ENDIAN) {
            throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
        java.nio.ByteBuffer a2 = a(b, b.capacity() - 24);
        int i = 0;
        while (a2.hasRemaining()) {
            i++;
            if (a2.remaining() < 8) {
                throw new java.lang.Exception("Insufficient data to read size of APK Signing Block entry #".concat(java.lang.String.valueOf(i)));
            }
            long j = a2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new java.lang.Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int position = a2.position() + i2;
            if (i2 > a2.remaining()) {
                throw new java.lang.Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
            }
            int i3 = a2.getInt();
            if (i3 == -262969152) {
                a = "V3";
            } else if (i3 == 1896449818) {
                a = "V2";
            } else {
                a2.position(position);
            }
            z = true;
            break;
        }
        z = false;
        if (z) {
            str2 = com.bytedance.pangle.util.f.a(b.array());
            str = "";
        } else {
            str = "without v2 & v3 signature.";
        }
        return new java.lang.String[]{str2, a, str};
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017c A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.nio.ByteBuffer b(java.io.File file) {
        boolean z;
        java.io.RandomAccessFile randomAccessFile = null;
        android.util.Pair<java.nio.ByteBuffer, java.lang.Long> a2 = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "r");
            try {
                if (randomAccessFile2.length() >= 22 && (a2 = com.bytedance.pangle.util.a.c.a(randomAccessFile2, 0)) == null) {
                    a2 = com.bytedance.pangle.util.a.c.a(randomAccessFile2, 65535);
                }
                if (a2 == null) {
                    throw new java.lang.Exception("Not an APK file: ZIP End of Central Directory record not found");
                }
                java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) a2.first;
                long longValue = ((java.lang.Long) a2.second).longValue();
                long j = longValue - 20;
                if (j >= 0) {
                    randomAccessFile2.seek(j);
                    if (randomAccessFile2.readInt() == 1347094023) {
                        z = true;
                        if (!z) {
                            throw new java.lang.Exception("ZIP64 APK not supported");
                        }
                        com.bytedance.pangle.util.a.c.a(byteBuffer);
                        long a3 = com.bytedance.pangle.util.a.c.a(byteBuffer, byteBuffer.position() + 16);
                        if (a3 > longValue) {
                            throw new java.lang.Exception("ZIP Central Directory offset out of range: " + a3 + ". ZIP End of Central Directory offset: " + longValue);
                        }
                        com.bytedance.pangle.util.a.c.a(byteBuffer);
                        if (com.bytedance.pangle.util.a.c.a(byteBuffer, byteBuffer.position() + 12) + a3 != longValue) {
                            throw new java.lang.Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
                        }
                        if (a3 < 32) {
                            throw new java.lang.Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(java.lang.String.valueOf(a3)));
                        }
                        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(24);
                        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
                        allocate.order(byteOrder);
                        randomAccessFile2.seek(a3 - allocate.capacity());
                        randomAccessFile2.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                        if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
                            throw new java.lang.Exception("No APK Signing Block before ZIP Central Directory");
                        }
                        long j2 = allocate.getLong(0);
                        if (j2 < allocate.capacity() || j2 > 2147483639) {
                            throw new java.lang.Exception("APK Signing Block size out of range: ".concat(java.lang.String.valueOf(j2)));
                        }
                        int i = (int) (8 + j2);
                        long j3 = a3 - i;
                        if (j3 < 0) {
                            throw new java.lang.Exception("APK Signing Block offset out of range: ".concat(java.lang.String.valueOf(j3)));
                        }
                        java.nio.ByteBuffer allocate2 = java.nio.ByteBuffer.allocate(i);
                        allocate2.order(byteOrder);
                        randomAccessFile2.seek(j3);
                        randomAccessFile2.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j4 = allocate2.getLong(0);
                        if (j4 == j2) {
                            java.nio.ByteBuffer byteBuffer2 = (java.nio.ByteBuffer) android.util.Pair.create(allocate2, java.lang.Long.valueOf(j3)).first;
                            randomAccessFile2.close();
                            return byteBuffer2;
                        }
                        throw new java.lang.Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                    }
                }
                z = false;
                if (!z) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
