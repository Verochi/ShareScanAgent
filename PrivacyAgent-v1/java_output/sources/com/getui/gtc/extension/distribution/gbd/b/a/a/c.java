package com.getui.gtc.extension.distribution.gbd.b.a.a;

/* loaded from: classes22.dex */
public final class c {
    public static final int a = 4;
    public static final int b = 32768;
    public short c;
    public short d;
    public byte[] e;

    public c() {
        this.c = (short) 4;
    }

    private c(short s2, byte b2) {
        this.c = (short) 4;
        this.d = s2;
        a(new byte[1]);
        this.e[0] = b2;
    }

    private c(short s2, int i) {
        this(s2, i, java.nio.ByteOrder.nativeOrder());
    }

    private c(short s2, int i, java.nio.ByteOrder byteOrder) {
        this.c = (short) 4;
        this.d = s2;
        a(new byte[4]);
        java.nio.ByteBuffer a2 = a();
        java.nio.ByteOrder order = a2.order();
        try {
            a2.order(byteOrder);
            a2.putInt(i);
        } finally {
            a2.order(order);
        }
    }

    private c(short s2, android.net.MacAddress macAddress) {
        byte[] byteArray;
        this.c = (short) 4;
        this.d = s2;
        byteArray = macAddress.toByteArray();
        a(byteArray);
    }

    private c(short s2, java.lang.String str) {
        this.c = (short) 4;
        this.d = s2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(java.util.Arrays.copyOf(bytes, bytes.length + 1));
        } catch (java.io.UnsupportedEncodingException unused) {
            a((byte[]) null);
        } catch (java.lang.Throwable th) {
            a((byte[]) null);
            throw th;
        }
    }

    private c(short s2, java.net.InetAddress inetAddress) {
        this.c = (short) 4;
        this.d = s2;
        a(inetAddress.getAddress());
    }

    private c(short s2, short s3) {
        this(s2, s3, java.nio.ByteOrder.nativeOrder());
    }

    private c(short s2, short s3, java.nio.ByteOrder byteOrder) {
        this.c = (short) 4;
        this.d = s2;
        a(new byte[2]);
        java.nio.ByteBuffer a2 = a();
        java.nio.ByteOrder order = a2.order();
        try {
            a2.order(byteOrder);
            a2.putShort(s3);
        } finally {
            a2.order(order);
        }
    }

    private c(short s2, byte[] bArr) {
        this.c = (short) 4;
        this.d = s2;
        a(bArr);
    }

    private c(short s2, com.getui.gtc.extension.distribution.gbd.b.a.a.c... cVarArr) {
        this();
        this.d = (short) (s2 | kotlin.jvm.internal.ShortCompanionObject.MIN_VALUE);
        int i = 0;
        for (com.getui.gtc.extension.distribution.gbd.b.a.a.c cVar : cVarArr) {
            i += com.getui.gtc.extension.distribution.gbd.b.a.b.a(cVar.c);
        }
        a(new byte[i]);
        java.nio.ByteBuffer a2 = a();
        for (com.getui.gtc.extension.distribution.gbd.b.a.a.c cVar2 : cVarArr) {
            java.nio.ByteOrder order = a2.order();
            int position = a2.position();
            a2.order(java.nio.ByteOrder.nativeOrder());
            try {
                a2.putShort(cVar2.c);
                a2.putShort(cVar2.d);
                byte[] bArr = cVar2.e;
                if (bArr != null) {
                    a2.put(bArr);
                }
                a2.order(order);
                a2.position(position + com.getui.gtc.extension.distribution.gbd.b.a.b.a(cVar2.c));
            } catch (java.lang.Throwable th) {
                a2.order(order);
                throw th;
            }
        }
    }

    private byte a(byte b2) {
        java.nio.ByteBuffer a2 = a();
        return (a2 == null || a2.remaining() != 1) ? b2 : a().get();
    }

    private int a(int i) {
        java.nio.ByteBuffer a2 = a();
        if (a2 == null || a2.remaining() != 4) {
            return i;
        }
        java.nio.ByteOrder order = a2.order();
        try {
            a2.order(java.nio.ByteOrder.BIG_ENDIAN);
            return a2.getInt();
        } finally {
            a2.order(order);
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.a.c a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.remaining() < 4) {
            return null;
        }
        int position = byteBuffer.position();
        com.getui.gtc.extension.distribution.gbd.b.a.a.c cVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.c();
        java.nio.ByteOrder order = byteBuffer.order();
        byteBuffer.order(java.nio.ByteOrder.nativeOrder());
        try {
            cVar.c = byteBuffer.getShort();
            cVar.d = byteBuffer.getShort();
            byteBuffer.order(order);
            byteBuffer.position(position);
            if (cVar.c < 4) {
                return null;
            }
            return cVar;
        } catch (java.lang.Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.b.a.a.c a(short s2, java.nio.ByteBuffer byteBuffer) {
        while (byteBuffer != null && byteBuffer.remaining() > 0) {
            com.getui.gtc.extension.distribution.gbd.b.a.a.c a2 = a(byteBuffer);
            if (a2 == null) {
                return null;
            }
            if (a2.d == s2) {
                return b(byteBuffer);
            }
            if (byteBuffer.remaining() < com.getui.gtc.extension.distribution.gbd.b.a.b.a(a2.c)) {
                return null;
            }
            byteBuffer.position(byteBuffer.position() + com.getui.gtc.extension.distribution.gbd.b.a.b.a(a2.c));
        }
        return null;
    }

    private static short a(short s2) {
        return (short) (s2 | kotlin.jvm.internal.ShortCompanionObject.MIN_VALUE);
    }

    private void a(byte[] bArr) {
        this.e = bArr;
        this.c = (short) ((bArr != null ? bArr.length : 0) + 4);
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.a.c b(java.nio.ByteBuffer byteBuffer) {
        com.getui.gtc.extension.distribution.gbd.b.a.a.c a2 = a(byteBuffer);
        if (a2 == null || byteBuffer.remaining() < com.getui.gtc.extension.distribution.gbd.b.a.b.a(a2.c)) {
            return null;
        }
        int position = byteBuffer.position();
        byteBuffer.position(position + 4);
        int i = (a2.c & kotlin.UShort.MAX_VALUE) - 4;
        if (i > 0) {
            byte[] bArr = new byte[i];
            a2.e = bArr;
            byteBuffer.get(bArr, 0, i);
            byteBuffer.position(position + com.getui.gtc.extension.distribution.gbd.b.a.b.a(a2.c));
        }
        return a2;
    }

    private short b(short s2) {
        java.nio.ByteBuffer a2 = a();
        if (a2 == null || a2.remaining() != 2) {
            return s2;
        }
        java.nio.ByteOrder order = a2.order();
        try {
            a2.order(java.nio.ByteOrder.BIG_ENDIAN);
            return a2.getShort();
        } finally {
            a2.order(order);
        }
    }

    private int c() {
        return com.getui.gtc.extension.distribution.gbd.b.a.b.a(this.c);
    }

    private void c(java.nio.ByteBuffer byteBuffer) {
        java.nio.ByteOrder order = byteBuffer.order();
        int position = byteBuffer.position();
        byteBuffer.order(java.nio.ByteOrder.nativeOrder());
        try {
            byteBuffer.putShort(this.c);
            byteBuffer.putShort(this.d);
            byte[] bArr = this.e;
            if (bArr != null) {
                byteBuffer.put(bArr);
            }
            byteBuffer.order(order);
            byteBuffer.position(position + com.getui.gtc.extension.distribution.gbd.b.a.b.a(this.c));
        } catch (java.lang.Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }

    private java.lang.Integer d() {
        java.nio.ByteBuffer a2 = a();
        if (a2 == null || a2.remaining() != 4) {
            return null;
        }
        return java.lang.Integer.valueOf(a2.getInt());
    }

    private int e() {
        java.nio.ByteBuffer a2 = a();
        java.lang.Integer valueOf = (a2 == null || a2.remaining() != 4) ? null : java.lang.Integer.valueOf(a2.getInt());
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    private android.net.MacAddress f() {
        android.net.MacAddress fromBytes;
        byte[] bArr = this.e;
        if (bArr == null) {
            return null;
        }
        try {
            fromBytes = android.net.MacAddress.fromBytes(bArr);
            return fromBytes;
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    private java.lang.String g() {
        byte[] bArr = this.e;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        short s2 = this.c;
        if (length < (s2 - 4) - 1) {
            return null;
        }
        try {
            return new java.lang.String(java.util.Arrays.copyOf(bArr, (s2 - 4) - 1), "UTF-8");
        } catch (java.io.UnsupportedEncodingException | java.lang.NegativeArraySizeException unused) {
            return null;
        }
    }

    public final java.nio.ByteBuffer a() {
        byte[] bArr = this.e;
        if (bArr == null) {
            return null;
        }
        java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
        wrap.order(java.nio.ByteOrder.nativeOrder());
        return wrap;
    }

    public final java.net.InetAddress b() {
        byte[] bArr = this.e;
        if (bArr == null) {
            return null;
        }
        try {
            return java.net.InetAddress.getByAddress(bArr);
        } catch (java.net.UnknownHostException unused) {
            return null;
        }
    }

    public final java.lang.String toString() {
        return "StructNlAttr{ nla_len{" + ((int) this.c) + "}, nla_type{" + ((int) this.d) + "}, nla_value{" + com.getui.gtc.extension.distribution.gbd.b.a.b.a(this.e) + "}, }";
    }
}
