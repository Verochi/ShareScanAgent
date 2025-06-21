package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class p extends com.igexin.push.d.c.c {
    public static final int a = 9;
    public long b;
    public java.lang.String c = "";
    public java.lang.String d = "";
    public java.lang.String e = "";

    public p() {
        this.m = 9;
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
        int i = 8;
        if (bArr.length > 8) {
            int i2 = bArr[8] & 255;
            i = 9;
            if (i2 > 0) {
                this.c = a(bArr, 9, i2);
                i = 9 + i2;
            }
        }
        if (bArr.length > i) {
            int i3 = i + 1;
            int i4 = bArr[i] & 255;
            if (i4 > 0) {
                this.d = a(bArr, i3, i4);
                i = i4 + i3;
            } else {
                i = i3;
            }
        }
        if (bArr.length > i) {
            int i5 = i + 1;
            int i6 = bArr[i] & 255;
            if (i6 > 0) {
                this.e = a(bArr, i5, i6);
            }
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        if (android.text.TextUtils.isEmpty(this.d) || android.text.TextUtils.isEmpty(this.e)) {
            byte[] bytes = this.c.getBytes();
            byte[] bArr = new byte[bytes.length + 8 + 1];
            com.igexin.c.a.b.g.a(this.b, bArr, 0);
            bArr[8] = (byte) bytes.length;
            java.lang.System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        byte[] bytes2 = this.c.getBytes();
        byte[] bytes3 = this.d.getBytes();
        byte[] bytes4 = this.e.getBytes();
        byte[] bArr2 = new byte[bytes2.length + 8 + bytes3.length + bytes4.length + 3];
        com.igexin.c.a.b.g.a(this.b, bArr2, 0);
        bArr2[8] = (byte) bytes2.length;
        java.lang.System.arraycopy(bytes2, 0, bArr2, 9, bytes2.length);
        int length = bytes2.length + 9;
        int i = length + 1;
        bArr2[length] = (byte) bytes3.length;
        java.lang.System.arraycopy(bytes3, 0, bArr2, i, bytes3.length);
        int length2 = i + bytes3.length;
        bArr2[length2] = (byte) bytes4.length;
        java.lang.System.arraycopy(bytes4, 0, bArr2, length2 + 1, bytes4.length);
        return bArr2;
    }
}
