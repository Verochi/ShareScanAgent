package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class g extends com.bytedance.pangle.res.a.f {
    public g(com.bytedance.pangle.res.a.i iVar) {
        super(iVar);
    }

    public final void a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new java.io.IOException(java.lang.String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, java.lang.Short.valueOf(readShort)));
        }
    }

    public final int[] a(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public final void b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new java.io.IOException(java.lang.String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, java.lang.Byte.valueOf(readByte)));
        }
    }

    public final void b(int i) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i && readInt >= 1835009) {
                break;
            } else {
                i = -1;
            }
        }
        if (readInt != 1835009) {
            throw new java.io.IOException(java.lang.String.format("Expected: 0x%08x, got: 0x%08x", 1835009, java.lang.Integer.valueOf(readInt)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = super.skipBytes(i - i2);
            if (skipBytes <= 0) {
                break;
            }
            i2 += skipBytes;
        }
        return i2;
    }
}
