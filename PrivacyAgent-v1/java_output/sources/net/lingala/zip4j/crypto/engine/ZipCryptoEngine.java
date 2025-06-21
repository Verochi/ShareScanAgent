package net.lingala.zip4j.crypto.engine;

/* loaded from: classes23.dex */
public class ZipCryptoEngine {
    public static final int[] b = new int[256];
    public final int[] a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            b[i] = i2;
        }
    }

    public final int a(int i, byte b2) {
        return b[(i ^ b2) & 255] ^ (i >>> 8);
    }

    public byte decryptByte() {
        int i = this.a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }

    public void initKeys(char[] cArr) {
        int[] iArr = this.a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (char c : cArr) {
            updateKeys((byte) (c & 255));
        }
    }

    public void updateKeys(byte b2) {
        int[] iArr = this.a;
        iArr[0] = a(iArr[0], b2);
        int[] iArr2 = this.a;
        int i = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = i;
        int i2 = (i * 134775813) + 1;
        iArr2[1] = i2;
        iArr2[2] = a(iArr2[2], (byte) (i2 >> 24));
    }
}
