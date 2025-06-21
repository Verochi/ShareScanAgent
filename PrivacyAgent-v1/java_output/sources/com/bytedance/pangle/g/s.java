package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
abstract class s {
    public static long a(java.nio.ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }

    public static android.util.Pair<java.nio.ByteBuffer, java.lang.Long> a(java.io.RandomAccessFile randomAccessFile, int i) {
        if (i < 0 || i > 65535) {
            throw new java.lang.IllegalArgumentException("maxCommentSize: ".concat(java.lang.String.valueOf(i)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(((int) java.lang.Math.min(i, length - 22)) + 22);
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int b = b(allocate);
        if (b == -1) {
            return null;
        }
        allocate.position(b);
        java.nio.ByteBuffer slice = allocate.slice();
        slice.order(byteOrder);
        return android.util.Pair.create(slice, java.lang.Long.valueOf(capacity + b));
    }

    public static void a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.order() != java.nio.ByteOrder.LITTLE_ENDIAN) {
            throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int b(java.nio.ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = java.lang.Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && (byteBuffer.getShort(i3 + 20) & kotlin.UShort.MAX_VALUE) == i2) {
                return i3;
            }
        }
        return -1;
    }
}
