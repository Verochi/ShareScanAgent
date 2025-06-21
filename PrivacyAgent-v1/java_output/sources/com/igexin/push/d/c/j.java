package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class j extends com.igexin.push.d.c.c {
    public byte a;
    public java.lang.Object b;

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte b = this.a;
        byte[] bytes = (b == 1 || b == 2 || (b != 3 && (b == 4 || b == 5 || b == 6 || b == 7))) ? ((java.lang.String) this.b).getBytes() : null;
        if (bytes == null) {
            return null;
        }
        byte[] bArr = new byte[bytes.length + 2];
        bArr[0] = this.a;
        bArr[1] = (byte) bytes.length;
        java.lang.System.arraycopy(bytes, 0, bArr, 2, bytes.length);
        return bArr;
    }
}
