package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class h implements java.io.Closeable {
    private final java.io.FileInputStream a;
    private com.bytedance.pangle.e.h.a b;
    private com.bytedance.pangle.e.h.b[] c;
    private com.bytedance.pangle.e.h.c[] d;
    private final java.util.Map<java.lang.String, com.bytedance.pangle.e.h.c> e = new java.util.HashMap();

    public static class a {
        public final byte[] a;
        public final short b;
        public final short c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        private a(java.nio.channels.FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.a = bArr;
            fileChannel.position(0L);
            fileChannel.read(java.nio.ByteBuffer.wrap(bArr));
            if (bArr[0] != Byte.MAX_VALUE || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new java.io.IOException(java.lang.String.format("bad elf magic: %x %x %x %x.", java.lang.Byte.valueOf(bArr[0]), java.lang.Byte.valueOf(bArr[1]), java.lang.Byte.valueOf(bArr[2]), java.lang.Byte.valueOf(bArr[3])));
            }
            com.bytedance.pangle.e.h.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
            com.bytedance.pangle.e.h.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
            java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            allocate.order(bArr[5] == 1 ? java.nio.ByteOrder.LITTLE_ENDIAN : java.nio.ByteOrder.BIG_ENDIAN);
            com.bytedance.pangle.e.h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
            this.b = allocate.getShort();
            this.c = allocate.getShort();
            int i = allocate.getInt();
            this.d = i;
            com.bytedance.pangle.e.h.a(i, 1, "bad elf version: " + i);
            byte b = bArr[4];
            if (b == 1) {
                this.e = allocate.getInt();
                this.f = allocate.getInt();
                this.g = allocate.getInt();
            } else {
                if (b != 2) {
                    throw new java.io.IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.e = allocate.getLong();
                this.f = allocate.getLong();
                this.g = allocate.getLong();
            }
            this.h = allocate.getInt();
            this.i = allocate.getShort();
            this.j = allocate.getShort();
            this.k = allocate.getShort();
            this.l = allocate.getShort();
            this.m = allocate.getShort();
            this.n = allocate.getShort();
        }

        public /* synthetic */ a(java.nio.channels.FileChannel fileChannel, byte b) {
            this(fileChannel);
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final long h;

        private b(java.nio.ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.a = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                return;
            }
            if (i != 2) {
                throw new java.io.IOException("Unexpected elf class: ".concat(java.lang.String.valueOf(i)));
            }
            this.a = byteBuffer.getInt();
            this.b = byteBuffer.getInt();
            this.c = byteBuffer.getLong();
            this.d = byteBuffer.getLong();
            this.e = byteBuffer.getLong();
            this.f = byteBuffer.getLong();
            this.g = byteBuffer.getLong();
            this.h = byteBuffer.getLong();
        }

        public /* synthetic */ b(java.nio.ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    public static class c {
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        public final long i;
        public final long j;
        public java.lang.String k;

        private c(java.nio.ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else {
                if (i != 2) {
                    throw new java.io.IOException("Unexpected elf class: ".concat(java.lang.String.valueOf(i)));
                }
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            }
            this.k = null;
        }

        public /* synthetic */ c(java.nio.ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    private h(java.io.File file) {
        com.bytedance.pangle.e.h.c[] cVarArr;
        this.b = null;
        this.c = null;
        this.d = null;
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        this.a = fileInputStream;
        java.nio.channels.FileChannel channel = fileInputStream.getChannel();
        this.b = new com.bytedance.pangle.e.h.a(channel, (byte) 0);
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(128);
        allocate.limit(this.b.j);
        allocate.order(this.b.a[5] == 1 ? java.nio.ByteOrder.LITTLE_ENDIAN : java.nio.ByteOrder.BIG_ENDIAN);
        channel.position(this.b.f);
        this.c = new com.bytedance.pangle.e.h.b[this.b.k];
        for (int i = 0; i < this.c.length; i++) {
            b(channel, allocate, "failed to read phdr.");
            this.c[i] = new com.bytedance.pangle.e.h.b(allocate, this.b.a[4], (byte) 0);
        }
        channel.position(this.b.g);
        allocate.limit(this.b.l);
        this.d = new com.bytedance.pangle.e.h.c[this.b.m];
        int i2 = 0;
        while (true) {
            cVarArr = this.d;
            if (i2 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.d[i2] = new com.bytedance.pangle.e.h.c(allocate, this.b.a[4], (byte) 0);
            i2++;
        }
        short s2 = this.b.n;
        if (s2 > 0) {
            com.bytedance.pangle.e.h.c cVar = cVarArr[s2];
            java.nio.ByteBuffer allocate2 = java.nio.ByteBuffer.allocate((int) cVar.f);
            this.a.getChannel().position(cVar.e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + cVar.k);
            for (com.bytedance.pangle.e.h.c cVar2 : this.d) {
                allocate2.position(cVar2.a);
                java.lang.String a2 = a(allocate2);
                cVar2.k = a2;
                this.e.put(a2, cVar2);
            }
        }
    }

    private static java.lang.String a(java.nio.ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new java.lang.String(array, position, (byteBuffer.position() - position) - 1, java.nio.charset.Charset.forName("ASCII"));
    }

    public static /* synthetic */ void a(int i, int i2, java.lang.String str) {
        if (i <= 0 || i > i2) {
            throw new java.io.IOException(str);
        }
    }

    public static boolean a(java.io.File file) {
        try {
            com.bytedance.pangle.util.g.a(new com.bytedance.pangle.e.h(file));
            return true;
        } catch (java.io.IOException unused) {
            com.bytedance.pangle.util.g.a((java.io.Closeable) null);
            return false;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.util.g.a((java.io.Closeable) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.nio.channels.FileChannel fileChannel, java.nio.ByteBuffer byteBuffer, java.lang.String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new java.io.IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        this.e.clear();
        this.c = null;
        this.d = null;
    }
}
