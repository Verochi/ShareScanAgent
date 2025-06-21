package com.xiaomi.push;

/* loaded from: classes19.dex */
final class em {
    com.xiaomi.push.er b;
    volatile boolean c;
    byte[] d;
    android.content.Context e;
    private java.io.InputStream i;
    private java.nio.ByteBuffer f = java.nio.ByteBuffer.allocate(2048);
    private java.nio.ByteBuffer g = java.nio.ByteBuffer.allocate(4);
    private java.util.zip.Adler32 h = new java.util.zip.Adler32();
    com.xiaomi.push.ep a = new com.xiaomi.push.ep();

    public em(java.io.InputStream inputStream, com.xiaomi.push.er erVar, android.content.Context context) {
        this.i = new java.io.BufferedInputStream(inputStream);
        this.b = erVar;
        this.e = context;
    }

    private void a(java.nio.ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.i.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00be A[Catch: IOException -> 0x014e, TryCatch #0 {IOException -> 0x014e, blocks: (B:3:0x0001, B:7:0x0021, B:9:0x0033, B:11:0x003d, B:12:0x0059, B:13:0x0085, B:15:0x00be, B:17:0x00c2, B:18:0x00cb, B:20:0x00d9, B:21:0x00e7, B:24:0x00df, B:25:0x0116, B:26:0x013d, B:27:0x005c, B:31:0x006a, B:32:0x013e, B:33:0x0145, B:34:0x0146, B:35:0x014d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0116 A[Catch: IOException -> 0x014e, TryCatch #0 {IOException -> 0x014e, blocks: (B:3:0x0001, B:7:0x0021, B:9:0x0033, B:11:0x003d, B:12:0x0059, B:13:0x0085, B:15:0x00be, B:17:0x00c2, B:18:0x00cb, B:20:0x00d9, B:21:0x00e7, B:24:0x00df, B:25:0x0116, B:26:0x013d, B:27:0x005c, B:31:0x006a, B:32:0x013e, B:33:0x0145, B:34:0x0146, B:35:0x014d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.xiaomi.push.ek a() {
        java.nio.ByteBuffer allocate;
        int i;
        try {
            this.f.clear();
            a(this.f, 8);
            short s2 = this.f.getShort(0);
            short s3 = this.f.getShort(2);
            if (s2 != -15618 || s3 != 5) {
                throw new java.io.IOException("Malformed Input");
            }
            int i2 = this.f.getInt(4);
            int position = this.f.position();
            if (i2 > 32768) {
                throw new java.io.IOException("Blob size too large");
            }
            if (i2 + 4 <= this.f.remaining()) {
                if (this.f.capacity() > 4096 && i2 < 2048) {
                    allocate = java.nio.ByteBuffer.allocate(2048);
                    allocate.put(this.f.array(), 0, this.f.arrayOffset() + this.f.position());
                }
                a(this.f, i2);
                this.g.clear();
                a(this.g, 4);
                this.g.position(0);
                i = this.g.getInt();
                this.h.reset();
                this.h.update(this.f.array(), 0, this.f.position());
                if (i == ((int) this.h.getValue())) {
                    com.xiaomi.channel.commonutils.logger.b.a("CRC = " + ((int) this.h.getValue()) + " and " + i);
                    throw new java.io.IOException("Corrupted Blob bad CRC");
                }
                byte[] bArr = this.d;
                if (bArr != null) {
                    com.xiaomi.push.service.as.a(bArr, this.f.array(), position, i2);
                }
                java.nio.ByteBuffer byteBuffer = this.f;
                int position2 = byteBuffer.position();
                byteBuffer.flip();
                byteBuffer.position(8);
                com.xiaomi.push.ek eqVar = position2 == 8 ? new com.xiaomi.push.eq() : com.xiaomi.push.ek.b(byteBuffer.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + eqVar.a.f + ";chid=" + eqVar.a.a + ";len=" + position2 + com.alipay.sdk.m.u.i.d);
                return eqVar;
            }
            allocate = java.nio.ByteBuffer.allocate(i2 + 2048);
            allocate.put(this.f.array(), 0, this.f.arrayOffset() + this.f.position());
            this.f = allocate;
            a(this.f, i2);
            this.g.clear();
            a(this.g, 4);
            this.g.position(0);
            i = this.g.getInt();
            this.h.reset();
            this.h.update(this.f.array(), 0, this.f.position());
            if (i == ((int) this.h.getValue())) {
            }
        } catch (java.io.IOException e) {
            int position3 = 0 == 0 ? this.f.position() : 0;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("[Slim] read Blob [");
            byte[] array = this.f.array();
            if (position3 > 128) {
                position3 = 128;
            }
            sb.append(com.xiaomi.push.j.a(array, position3));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
            throw e;
        }
    }
}
