package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class c {
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private java.io.DataInputStream l;
    private java.lang.String m;

    /* renamed from: s, reason: collision with root package name */
    private byte[] f427s = new byte[512];
    private static com.sijla.mla.a.b.e c = new com.sijla.mla.a.c.a((byte) 0);
    public static final byte[] a = {com.google.common.base.Ascii.ESC, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 117, 97};
    public static final byte[] b = {com.google.common.base.Ascii.EM, -109, 13, 10, com.google.common.base.Ascii.SUB, 10};
    private static final com.sijla.mla.a.r[] n = new com.sijla.mla.a.r[0];
    private static final com.sijla.mla.a.w[] o = new com.sijla.mla.a.w[0];
    private static final com.sijla.mla.b[] p = new com.sijla.mla.b[0];
    private static final com.sijla.h.f[] q = new com.sijla.h.f[0];
    private static final int[] r = new int[0];

    public static final class a implements com.sijla.mla.a.b.e {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.sijla.mla.a.b.e
        public final com.sijla.mla.a.w a(java.io.InputStream inputStream, java.lang.String str) {
            return com.sijla.mla.a.c.a(inputStream, str);
        }
    }

    private c(java.io.InputStream inputStream, java.lang.String str) {
        this.m = str;
        this.l = new java.io.DataInputStream(inputStream);
    }

    private int a() {
        this.l.readFully(this.f427s, 0, 4);
        if (this.f) {
            byte[] bArr = this.f427s;
            return (bArr[0] & 255) | (bArr[3] << com.google.common.base.Ascii.CAN) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
        }
        byte[] bArr2 = this.f427s;
        return (bArr2[3] & 255) | ((bArr2[2] & 255) << 8) | (bArr2[0] << com.google.common.base.Ascii.CAN) | ((bArr2[1] & 255) << 16);
    }

    public static com.sijla.mla.a.w a(java.io.InputStream inputStream, java.lang.String str) {
        int read = inputStream.read();
        byte[] bArr = a;
        if (read != bArr[0] || inputStream.read() != bArr[1] || inputStream.read() != bArr[2] || inputStream.read() != bArr[3]) {
            return null;
        }
        if (str.startsWith("@") || str.startsWith(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)) {
            str = str.substring(1);
        } else if (str.startsWith("\u001b")) {
            str = "binary string";
        }
        com.sijla.mla.a.c cVar = new com.sijla.mla.a.c(inputStream, str);
        cVar.d = cVar.l.readByte();
        cVar.e = cVar.l.readByte();
        cVar.f = cVar.l.readByte() != 0;
        cVar.g = cVar.l.readByte();
        cVar.h = cVar.l.readByte();
        cVar.i = cVar.l.readByte();
        cVar.j = cVar.l.readByte();
        cVar.k = cVar.l.readByte();
        for (int i = 0; i < 6; i++) {
            if (cVar.l.readByte() != b[i]) {
                throw new com.sijla.mla.a.i("Unexpeted byte in luac tail of header, index=".concat(java.lang.String.valueOf(i)));
            }
        }
        int i2 = cVar.k;
        if (i2 != 0 && i2 != 1 && i2 != 4) {
            throw new com.sijla.mla.a.i("unsupported int size");
        }
        com.sijla.mla.a.n.c(str);
        return cVar.e();
    }

    public static void a(com.sijla.mla.a.b bVar) {
        bVar.j = c;
    }

    private void a(com.sijla.mla.a.w wVar) {
        com.sijla.mla.a.r l;
        int i;
        int a2 = a();
        com.sijla.mla.a.r[] rVarArr = a2 > 0 ? new com.sijla.mla.a.r[a2] : n;
        for (int i2 = 0; i2 < a2; i2++) {
            byte readByte = this.l.readByte();
            if (readByte == -2) {
                rVarArr[i2] = com.sijla.mla.a.k.c_(a());
            } else if (readByte == 0) {
                rVarArr[i2] = com.sijla.mla.a.r.k;
            } else if (readByte == 1) {
                rVarArr[i2] = this.l.readUnsignedByte() != 0 ? com.sijla.mla.a.r.l : com.sijla.mla.a.r.m;
            } else if (readByte == 3) {
                if (this.k == 1) {
                    i = a();
                } else {
                    long c2 = c();
                    if ((Long.MAX_VALUE & c2) == 0) {
                        l = com.sijla.mla.a.r.o;
                    } else {
                        int i3 = ((int) ((c2 >> 52) & 2047)) - 1023;
                        if (i3 >= 0 && i3 < 31) {
                            long j = 4503599627370495L & c2;
                            int i4 = 52 - i3;
                            if ((j & ((1 << i4) - 1)) == 0) {
                                i = (1 << i3) | ((int) (j >> i4));
                                if ((c2 >> 63) != 0) {
                                    i = -i;
                                }
                            }
                        }
                        l = com.sijla.mla.a.r.l(java.lang.Double.longBitsToDouble(c2));
                    }
                    rVarArr[i2] = l;
                }
                l = com.sijla.mla.a.k.c_(i);
                rVarArr[i2] = l;
            } else {
                if (readByte != 4) {
                    throw new java.lang.IllegalStateException("bad constant");
                }
                rVarArr[i2] = d();
            }
        }
        wVar.a = rVarArr;
        int a3 = a();
        com.sijla.mla.a.w[] wVarArr = a3 > 0 ? new com.sijla.mla.a.w[a3] : o;
        for (int i5 = 0; i5 < a3; i5++) {
            wVarArr[i5] = e();
        }
        wVar.c = wVarArr;
    }

    private void b(com.sijla.mla.a.w wVar) {
        int a2 = a();
        wVar.f = a2 > 0 ? new com.sijla.h.f[a2] : q;
        for (int i = 0; i < a2; i++) {
            wVar.f[i] = new com.sijla.h.f(null, this.l.readByte() != 0, this.l.readByte() & 255);
        }
    }

    private int[] b() {
        int i;
        byte b2;
        int a2 = a();
        if (a2 == 0) {
            return r;
        }
        int i2 = a2 << 2;
        if (this.f427s.length < i2) {
            this.f427s = new byte[i2];
        }
        int i3 = 0;
        this.l.readFully(this.f427s, 0, i2);
        int[] iArr = new int[a2];
        int i4 = 0;
        while (i3 < a2) {
            if (this.f) {
                byte[] bArr = this.f427s;
                i = (bArr[i4 + 3] << com.google.common.base.Ascii.CAN) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
                b2 = bArr[i4];
            } else {
                byte[] bArr2 = this.f427s;
                i = (bArr2[i4] << com.google.common.base.Ascii.CAN) | ((bArr2[i4 + 1] & 255) << 16) | ((bArr2[i4 + 2] & 255) << 8);
                b2 = bArr2[i4 + 3];
            }
            iArr[i3] = (b2 & 255) | i;
            i3++;
            i4 += 4;
        }
        return iArr;
    }

    private long c() {
        int a2;
        int a3;
        if (this.f) {
            a3 = a();
            a2 = a();
        } else {
            a2 = a();
            a3 = a();
        }
        return (a2 << 32) | (a3 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
    }

    private void c(com.sijla.mla.a.w wVar) {
        wVar.g = d();
        wVar.d = b();
        int a2 = a();
        wVar.e = a2 > 0 ? new com.sijla.mla.b[a2] : p;
        for (int i = 0; i < a2; i++) {
            wVar.e[i] = new com.sijla.mla.b(d(), a(), a());
        }
        int a3 = a();
        for (int i2 = 0; i2 < a3; i2++) {
            wVar.f[i2].a = d();
        }
    }

    private com.sijla.mla.a.n d() {
        int c2 = this.h == 8 ? (int) c() : a();
        if (c2 == 0) {
            return null;
        }
        byte[] bArr = new byte[c2];
        this.l.readFully(bArr, 0, c2);
        return com.sijla.mla.a.n.b(bArr, 0, c2 - 1);
    }

    private com.sijla.mla.a.w e() {
        com.sijla.mla.a.w wVar = new com.sijla.mla.a.w();
        wVar.h = a();
        wVar.i = a();
        wVar.j = this.l.readUnsignedByte();
        wVar.k = this.l.readUnsignedByte();
        wVar.l = this.l.readUnsignedByte();
        wVar.b = b();
        a(wVar);
        b(wVar);
        c(wVar);
        return wVar;
    }
}
