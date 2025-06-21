package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
abstract class g {
    private static final byte[] a = new byte[8];

    public static class a {
        public final java.nio.ByteBuffer a;
        public final byte[] b;

        public a(java.nio.ByteBuffer byteBuffer, byte[] bArr) {
            this.a = byteBuffer;
            this.b = bArr;
        }
    }

    public static class b implements com.bytedance.pangle.g.j {
        private int a;
        private final java.nio.ByteBuffer b;
        private final java.security.MessageDigest c;
        private final byte[] d;
        private final byte[] e;

        private b(byte[] bArr, java.nio.ByteBuffer byteBuffer) {
            this.d = new byte[32];
            this.e = bArr;
            this.b = byteBuffer.slice();
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            this.c = messageDigest;
            messageDigest.update(bArr);
            this.a = 0;
        }

        public /* synthetic */ b(byte[] bArr, java.nio.ByteBuffer byteBuffer, byte b) {
            this(bArr, byteBuffer);
        }

        public final void a() {
            if (this.a == 0) {
                return;
            }
            throw new java.lang.IllegalStateException("Buffer is not empty: " + this.a);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(java.nio.ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = java.lang.Math.min(remaining, 4096 - this.a);
                byteBuffer.limit(byteBuffer.position() + min);
                this.c.update(byteBuffer);
                remaining -= min;
                int i = this.a + min;
                this.a = i;
                if (i == 4096) {
                    java.security.MessageDigest messageDigest = this.c;
                    byte[] bArr = this.d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.b.put(this.d);
                    this.c.update(this.e);
                    this.a = 0;
                }
            }
        }

        public final void b() {
            int position = this.b.position() % 4096;
            if (position == 0) {
                return;
            }
            this.b.put(java.nio.ByteBuffer.allocate(4096 - position));
        }
    }

    public static com.bytedance.pangle.g.g.a a(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.g.m mVar, com.bytedance.pangle.g.i iVar) {
        int[] a2 = a(randomAccessFile.length() - (mVar.c - mVar.b));
        int i = a2[a2.length - 1];
        int i2 = i + 4096;
        java.nio.ByteBuffer a3 = iVar.a(i2);
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        a3.order(byteOrder);
        java.nio.ByteBuffer a4 = a(a3, 0, i);
        int i3 = i + 64;
        java.nio.ByteBuffer a5 = a(a3, i, i3);
        java.nio.ByteBuffer a6 = a(a3, i3, i2);
        byte[] bArr = new byte[32];
        java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        long j = mVar.b;
        if (j % 4096 != 0) {
            throw new java.lang.IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.b);
        }
        long j2 = mVar.c;
        if ((j2 - j) % 4096 != 0) {
            throw new java.lang.IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.c - mVar.b));
        }
        long j3 = j2 - j;
        int[] a7 = a(randomAccessFile.length() - j3);
        if (a4 != null) {
            wrap.put(a(randomAccessFile, mVar, a, a7, a4));
            wrap.flip();
        }
        if (a5 != null) {
            a5.order(byteOrder);
            long length = randomAccessFile.length();
            byte[] bArr2 = a;
            if (bArr2.length != 8) {
                throw new java.lang.IllegalArgumentException("salt is not 8 bytes long");
            }
            a5.put("TrueBrew".getBytes());
            a5.put((byte) 1);
            a5.put((byte) 0);
            a5.put((byte) 12);
            a5.put((byte) 7);
            a5.putShort((short) 1);
            a5.putShort((short) 1);
            a5.putInt(0);
            a5.putInt(0);
            a5.putLong(length);
            a5.put((byte) 2);
            a5.put((byte) 0);
            a5.put(bArr2);
            a(a5, 22);
            a5.flip();
        }
        if (a6 != null) {
            a6.order(byteOrder);
            long j4 = mVar.b;
            long j5 = mVar.d;
            a6.putInt(24);
            a6.putShort((short) 1);
            a(a6, 2);
            a6.putLong(j4);
            a6.putLong(j3);
            a6.putInt(20);
            a6.putShort((short) 2);
            a(a6, 2);
            a6.putLong(j5 + 16);
            a6.putInt(c(j4));
            a(a6, 4);
            a6.flip();
        }
        a3.position(i3 + a6.limit());
        a3.putInt(a6.limit() + 64 + 4);
        a3.flip();
        return new com.bytedance.pangle.g.g.a(a3, bArr);
    }

    private static java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer, int i, int i2) {
        java.nio.ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    private static void a(com.bytedance.pangle.g.j jVar, com.bytedance.pangle.g.k kVar, int i) {
        long a2 = kVar.a();
        long j = 0;
        while (a2 > 0) {
            int min = (int) java.lang.Math.min(a2, i);
            kVar.a(jVar, j, min);
            long j2 = min;
            j += j2;
            a2 -= j2;
        }
    }

    private static void a(java.nio.ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static byte[] a(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.g.m mVar, byte[] bArr, int[] iArr, java.nio.ByteBuffer byteBuffer) {
        com.bytedance.pangle.g.g.b bVar = new com.bytedance.pangle.g.g.b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
        a(bVar, new com.bytedance.pangle.g.l(randomAccessFile.getFD(), 0L, mVar.b), 1048576);
        long j = mVar.d + 16;
        java.io.FileDescriptor fd = randomAccessFile.getFD();
        long j2 = mVar.c;
        a(bVar, new com.bytedance.pangle.g.l(fd, j2, j - j2), 1048576);
        java.nio.ByteBuffer order = java.nio.ByteBuffer.allocate(4).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        order.putInt(c(mVar.b));
        order.flip();
        bVar.a(order);
        long j3 = j + 4;
        a(bVar, new com.bytedance.pangle.g.l(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            bVar.a(java.nio.ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i = length2 + 1;
            java.nio.ByteBuffer a2 = a(byteBuffer, iArr[i], iArr[length2 + 2]);
            java.nio.ByteBuffer a3 = a(byteBuffer, iArr[length2], iArr[i]);
            com.bytedance.pangle.g.h hVar = new com.bytedance.pangle.g.h(a2);
            com.bytedance.pangle.g.g.b bVar2 = new com.bytedance.pangle.g.g.b(bArr, a3, (byte) 0);
            a(bVar2, hVar, 4096);
            bVar2.a();
            bVar2.b();
        }
        byte[] bArr2 = new byte[32];
        com.bytedance.pangle.g.g.b bVar3 = new com.bytedance.pangle.g.g.b(bArr, java.nio.ByteBuffer.wrap(bArr2), (byte) 0);
        bVar3.a(a(byteBuffer, 0, 4096));
        bVar3.a();
        return bArr2;
    }

    private static int[] a(long j) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        do {
            j = b(j) * 32;
            arrayList.add(java.lang.Long.valueOf(b(j) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + c(((java.lang.Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static long b(long j) {
        return ((j + 4096) - 1) / 4096;
    }

    private static int c(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new java.lang.ArithmeticException("integer overflow");
    }
}
