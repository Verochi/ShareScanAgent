package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class i extends com.igexin.push.d.c.c {
    public static final int a = 4;
    public long b;
    public byte c;
    public int d;
    public java.lang.String e;
    public java.util.List<com.igexin.push.d.c.j> f;

    public i() {
        this.m = 4;
        this.n = com.google.common.base.Ascii.DC4;
    }

    private static java.lang.String a(byte[] bArr, int i, int i2) {
        try {
            return new java.lang.String(bArr, i, i2, "UTF-8");
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        this.b = com.igexin.c.a.b.g.d(bArr, 0);
        this.c = bArr[8];
        this.d = com.igexin.c.a.b.g.c(bArr, 9) & (-1);
        int i = 13;
        if (bArr.length > 13) {
            int i2 = bArr[13] & 255;
            i = 14;
            if (i2 > 0) {
                this.f = new java.util.ArrayList();
                int i3 = i2 + 14;
                while (i < i3) {
                    com.igexin.push.d.c.j jVar = new com.igexin.push.d.c.j();
                    this.f.add(jVar);
                    int i4 = i + 1;
                    int i5 = bArr[i] & 255 & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255 & 255;
                    jVar.a = (byte) i5;
                    if ((i5 == 1 || i5 == 4) && i7 > 0) {
                        try {
                            jVar.b = new java.lang.String(bArr, i6, i7, "UTF-8");
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                    i = i6 + i7;
                }
            }
        }
        if (bArr.length > i) {
            this.e = a(bArr, i + 1, bArr[i] & 255);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        int i;
        int i2;
        java.util.List<com.igexin.push.d.c.j> list = this.f;
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.util.Iterator<com.igexin.push.d.c.j> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    byteArrayOutputStream.write(it.next().b());
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (java.io.IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (java.io.IOException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (bArr != null) {
            i = bArr.length;
            i2 = i + 1;
        } else {
            i = 0;
            i2 = 1;
        }
        byte[] bArr2 = new byte[i2 + 12 + this.e.getBytes().length + 1];
        com.igexin.c.a.b.g.a(this.b, bArr2, 0);
        com.igexin.c.a.b.g.a(((this.c & 255) << 24) | this.d, bArr2, 8);
        bArr2[12] = (byte) i;
        int a2 = i > 0 ? 13 + com.igexin.c.a.b.g.a(bArr, bArr2, 13, i) : 13;
        byte[] bytes = this.e.getBytes();
        bArr2[a2] = (byte) bytes.length;
        java.lang.System.arraycopy(bytes, 0, bArr2, a2 + 1, bytes.length);
        return bArr2;
    }
}
