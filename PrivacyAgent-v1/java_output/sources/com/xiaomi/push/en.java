package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class en {
    com.xiaomi.push.er b;
    java.io.OutputStream c;
    int d;
    int e;
    private byte[] h;
    java.nio.ByteBuffer a = java.nio.ByteBuffer.allocate(2048);
    private java.nio.ByteBuffer f = java.nio.ByteBuffer.allocate(4);
    private java.util.zip.Adler32 g = new java.util.zip.Adler32();

    public en(java.io.OutputStream outputStream, com.xiaomi.push.er erVar) {
        this.c = new java.io.BufferedOutputStream(outputStream);
        this.b = erVar;
        java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
        this.d = timeZone.getRawOffset() / 3600000;
        this.e = timeZone.useDaylightTime() ? 1 : 0;
    }

    public final int a(com.xiaomi.push.ek ekVar) {
        int d = ekVar.d();
        if (d > 32768) {
            com.xiaomi.channel.commonutils.logger.b.a("Blob size=" + d + " should be less than 32768 Drop blob chid=" + ekVar.a.a + " id=" + ekVar.a());
            return 0;
        }
        this.a.clear();
        int i = d + 8 + 4;
        if (i > this.a.capacity() || this.a.capacity() > 4096) {
            this.a = java.nio.ByteBuffer.allocate(i);
        }
        this.a.putShort((short) -15618);
        this.a.putShort((short) 5);
        this.a.putInt(d);
        int position = this.a.position();
        this.a = ekVar.a(this.a);
        if (!"CONN".equals(ekVar.a.f)) {
            if (this.h == null) {
                this.h = this.b.a();
            }
            com.xiaomi.push.service.as.a(this.h, this.a.array(), position, d);
        }
        this.g.reset();
        this.g.update(this.a.array(), 0, this.a.position());
        this.f.putInt(0, (int) this.g.getValue());
        this.c.write(this.a.array(), 0, this.a.position());
        this.c.write(this.f.array(), 0, 4);
        this.c.flush();
        int position2 = this.a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + ekVar.a.f + ";chid=" + ekVar.a.a + ";len=" + position2 + com.alipay.sdk.m.u.i.d);
        return position2;
    }
}
