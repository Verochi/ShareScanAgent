package com.xiaomi.push;

/* loaded from: classes19.dex */
public class ek {
    private static java.lang.String f = com.xiaomi.push.fy.a() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long g = 0;
    private static final byte[] h = new byte[0];
    public com.xiaomi.push.cx.a a;
    public short b;
    public java.lang.String c;
    int d;
    public com.xiaomi.push.service.s e;
    private byte[] i;

    public ek() {
        this.b = (short) 2;
        this.i = h;
        this.c = null;
        this.e = null;
        this.a = new com.xiaomi.push.cx.a();
        this.d = 1;
    }

    private ek(com.xiaomi.push.cx.a aVar, short s2, byte[] bArr) {
        this.c = null;
        this.e = null;
        this.a = aVar;
        this.b = s2;
        this.i = bArr;
        this.d = 2;
    }

    @java.lang.Deprecated
    public static com.xiaomi.push.ek a(com.xiaomi.push.fn fnVar, java.lang.String str) {
        int i;
        com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
        try {
            i = java.lang.Integer.parseInt(fnVar.t);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        ekVar.a(i);
        ekVar.a(fnVar.d());
        ekVar.b(fnVar.f466s);
        ekVar.c = fnVar.u;
        ekVar.a("XMLMSG", (java.lang.String) null);
        try {
            ekVar.a(fnVar.b().getBytes("utf8"), str);
            if (android.text.TextUtils.isEmpty(str)) {
                ekVar.b = (short) 3;
            } else {
                ekVar.b = (short) 2;
                ekVar.a("SECMSG", (java.lang.String) null);
            }
        } catch (java.io.UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.a("Blob setPayload err： " + e2.getMessage());
        }
        return ekVar;
    }

    public static com.xiaomi.push.ek b(java.nio.ByteBuffer byteBuffer) {
        try {
            java.nio.ByteBuffer slice = byteBuffer.slice();
            short s2 = slice.getShort(0);
            short s3 = slice.getShort(2);
            int i = slice.getInt(4);
            com.xiaomi.push.cx.a aVar = new com.xiaomi.push.cx.a();
            aVar.b(slice.array(), slice.arrayOffset() + 8, s3);
            byte[] bArr = new byte[i];
            slice.position(s3 + 8);
            slice.get(bArr, 0, i);
            return new com.xiaomi.push.ek(aVar, s2, bArr);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("read Blob err :" + e.getMessage());
            throw new java.io.IOException("Malformed Input");
        }
    }

    private static synchronized java.lang.String e() {
        java.lang.String sb;
        synchronized (com.xiaomi.push.ek.class) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(f);
            long j = g;
            g = 1 + j;
            sb2.append(java.lang.Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public final java.lang.String a() {
        java.lang.String str = this.a.j;
        if ("ID_NOT_AVAILABLE".equals(str)) {
            return null;
        }
        if (this.a.i) {
            return str;
        }
        java.lang.String e = e();
        this.a.e(e);
        return e;
    }

    public java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = java.nio.ByteBuffer.allocate(d());
        }
        byteBuffer.putShort(this.b);
        byteBuffer.putShort((short) this.a.a());
        byteBuffer.putInt(this.i.length);
        int position = byteBuffer.position();
        this.a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.a.a());
        byteBuffer.position(position + this.a.a());
        byteBuffer.put(this.i);
        return byteBuffer;
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void a(long j, java.lang.String str, java.lang.String str2) {
        if (j != 0) {
            this.a.a(j);
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.b(str2);
    }

    public final void a(java.lang.String str) {
        this.a.e(str);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("command should not be empty");
        }
        this.a.c(str);
        com.xiaomi.push.cx.a aVar = this.a;
        aVar.g = false;
        aVar.h = "";
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.d(str2);
    }

    public final void a(byte[] bArr, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.a.b(0);
            this.i = bArr;
        } else {
            this.a.b(1);
            this.i = com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(str, a()), bArr);
        }
    }

    public final java.lang.String b() {
        if (!this.a.b) {
            return null;
        }
        return java.lang.Long.toString(this.a.c) + "@" + this.a.d + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.a.e;
    }

    public final void b(int i) {
        com.xiaomi.push.service.s sVar = new com.xiaomi.push.service.s();
        this.e = sVar;
        sVar.a = i;
    }

    public final void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = java.lang.Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, indexOf);
            java.lang.String substring = str.substring(indexOf + 1, indexOf2);
            java.lang.String substring2 = str.substring(indexOf2 + 1);
            this.a.a(parseLong);
            this.a.a(substring);
            this.a.b(substring2);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("Blob parse user err " + e.getMessage());
        }
    }

    public final byte[] c() {
        return com.xiaomi.push.el.a(this, this.i);
    }

    public final byte[] c(java.lang.String str) {
        int i = this.a.k;
        if (i == 1) {
            return com.xiaomi.push.el.a(this, com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(str, a()), this.i));
        }
        if (i == 0) {
            return com.xiaomi.push.el.a(this, this.i);
        }
        com.xiaomi.channel.commonutils.logger.b.a("unknow cipher = " + this.a.k);
        return com.xiaomi.push.el.a(this, this.i);
    }

    public int d() {
        return this.a.b() + 8 + this.i.length;
    }

    public java.lang.String toString() {
        return "Blob [chid=" + this.a.a + "; Id=" + a() + "; cmd=" + this.a.f + "; type=" + ((int) this.b) + "; from=" + b() + " ]";
    }
}
