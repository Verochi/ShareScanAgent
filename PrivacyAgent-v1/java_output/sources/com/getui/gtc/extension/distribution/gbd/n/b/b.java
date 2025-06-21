package com.getui.gtc.extension.distribution.gbd.n.b;

/* loaded from: classes22.dex */
public final class b {
    private final int[] a = {1732584193, -271733879, -1732584194, 271733878, -1009589776};
    private int[] b = new int[5];
    private int[] c = new int[80];

    private static int a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private static int a(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    private static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            java.lang.String upperCase = java.lang.Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    private void a() {
        for (int i = 16; i <= 79; i++) {
            int[] iArr = this.c;
            iArr[i] = a(((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16], 1);
        }
        int[] iArr2 = new int[5];
        for (int i2 = 0; i2 < 5; i2++) {
            iArr2[i2] = this.b[i2];
        }
        for (int i3 = 0; i3 <= 19; i3++) {
            int a = a(iArr2[0], 5);
            int i4 = iArr2[1];
            int i5 = iArr2[2];
            int i6 = iArr2[3];
            int i7 = a + (((~i4) & i6) | (i4 & i5)) + iArr2[4] + this.c[i3] + 1518500249;
            iArr2[4] = i6;
            iArr2[3] = i5;
            iArr2[2] = a(i4, 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = i7;
        }
        for (int i8 = 20; i8 <= 39; i8++) {
            int a2 = a(iArr2[0], 5);
            int i9 = iArr2[1];
            int i10 = iArr2[2];
            int i11 = iArr2[3];
            int i12 = a2 + ((i9 ^ i10) ^ i11) + iArr2[4] + this.c[i8] + 1859775393;
            iArr2[4] = i11;
            iArr2[3] = i10;
            iArr2[2] = a(i9, 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = i12;
        }
        for (int i13 = 40; i13 <= 59; i13++) {
            int a3 = a(iArr2[0], 5);
            int i14 = iArr2[1];
            int i15 = iArr2[2];
            int i16 = iArr2[3];
            int i17 = (((a3 + (((i14 & i15) | (i14 & i16)) | (i15 & i16))) + iArr2[4]) + this.c[i13]) - 1894007588;
            iArr2[4] = i16;
            iArr2[3] = i15;
            iArr2[2] = a(i14, 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = i17;
        }
        for (int i18 = 60; i18 <= 79; i18++) {
            int a4 = a(iArr2[0], 5);
            int i19 = iArr2[1];
            int i20 = iArr2[2];
            int i21 = iArr2[3];
            int i22 = (((a4 + ((i19 ^ i20) ^ i21)) + iArr2[4]) + this.c[i18]) - 899497514;
            iArr2[4] = i21;
            iArr2[3] = i20;
            iArr2[2] = a(i19, 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = i22;
        }
        for (int i23 = 0; i23 < 5; i23++) {
            int[] iArr3 = this.b;
            iArr3[i23] = iArr3[i23] + iArr2[i23];
        }
        int i24 = 0;
        while (true) {
            int[] iArr4 = this.c;
            if (i24 >= iArr4.length) {
                return;
            }
            iArr4[i24] = 0;
            i24++;
        }
    }

    private static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bArr = new byte[64];
        byte[] bArr2 = new byte[64];
        byte[] bArr3 = new byte[64];
        int length = str2.length();
        com.getui.gtc.extension.distribution.gbd.n.b.b bVar = new com.getui.gtc.extension.distribution.gbd.n.b.b();
        int length2 = str2.length();
        byte[] bytes = str2.getBytes();
        if (length2 > 64) {
            byte[] d = bVar.d(bytes);
            for (int i = 0; i < 20; i++) {
                bArr3[i] = d[i];
            }
            length = 20;
        } else {
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr3[i2] = bytes[i2];
            }
        }
        while (length < 64) {
            bArr3[length] = 0;
            length++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            bArr[i3] = (byte) (bArr3[i3] ^ org.apache.tools.tar.TarConstants.LF_FIFO);
            bArr2[i3] = (byte) (bArr3[i3] ^ 92);
        }
        return bVar.d(a(bArr2, bVar.d(a(bArr, str.getBytes()))));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length + 64];
        for (int i = 0; i < 64; i++) {
            bArr3[i] = bArr[i];
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2 + 64] = bArr2[i2];
        }
        return bArr3;
    }

    private static int b(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int b(byte[] bArr) {
        int i;
        int i2;
        int[] iArr = this.a;
        java.lang.System.arraycopy(iArr, 0, this.b, 0, iArr.length);
        int length = bArr.length;
        int i3 = length % 64;
        if (i3 < 56) {
            i = 55 - i3;
            i2 = (length - i3) + 64;
        } else if (i3 == 56) {
            i2 = length + 8 + 64;
            i = 63;
        } else {
            i = (63 - i3) + 56;
            i2 = ((length + 64) - i3) + 64;
        }
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        int i4 = length + 1;
        bArr2[length] = Byte.MIN_VALUE;
        int i5 = 0;
        while (i5 < i) {
            bArr2[i4] = 0;
            i5++;
            i4++;
        }
        long j = length * 8;
        byte b = (byte) (j & 255);
        byte b2 = (byte) ((j >> 8) & 255);
        byte b3 = (byte) ((j >> 16) & 255);
        byte b4 = (byte) ((j >> 24) & 255);
        byte b5 = (byte) ((j >> 32) & 255);
        byte b6 = (byte) ((j >> 40) & 255);
        byte b7 = (byte) (255 & (j >> 48));
        byte b8 = (byte) (j >> 56);
        int i6 = i4 + 1;
        bArr2[i4] = b8;
        int i7 = i6 + 1;
        bArr2[i6] = b7;
        int i8 = i7 + 1;
        bArr2[i7] = b6;
        int i9 = i8 + 1;
        bArr2[i8] = b5;
        int i10 = i9 + 1;
        bArr2[i9] = b4;
        int i11 = i10 + 1;
        bArr2[i10] = b3;
        bArr2[i11] = b2;
        bArr2[i11 + 1] = b;
        int i12 = i2 / 64;
        int i13 = 0;
        while (true) {
            if (i13 >= i12) {
                return 20;
            }
            for (int i14 = 0; i14 < 16; i14++) {
                int i15 = (i13 * 64) + (i14 * 4);
                this.c[i14] = (bArr2[i15 + 3] & 255) | ((bArr2[i15] & 255) << 24) | ((bArr2[i15 + 1] & 255) << 16) | ((bArr2[i15 + 2] & 255) << 8);
            }
            for (int i16 = 16; i16 <= 79; i16++) {
                int[] iArr2 = this.c;
                iArr2[i16] = a(((iArr2[i16 - 3] ^ iArr2[i16 - 8]) ^ iArr2[i16 - 14]) ^ iArr2[i16 - 16], 1);
            }
            int[] iArr3 = new int[5];
            for (int i17 = 0; i17 < 5; i17++) {
                iArr3[i17] = this.b[i17];
            }
            for (int i18 = 0; i18 <= 19; i18++) {
                int a = a(iArr3[0], 5);
                int i19 = iArr3[1];
                int i20 = iArr3[2];
                int i21 = iArr3[3];
                int i22 = a + ((i19 & i20) | ((~i19) & i21)) + iArr3[4] + this.c[i18] + 1518500249;
                iArr3[4] = i21;
                iArr3[3] = i20;
                iArr3[2] = a(i19, 30);
                iArr3[1] = iArr3[0];
                iArr3[0] = i22;
            }
            char c = 0;
            for (int i23 = 20; i23 <= 39; i23++) {
                int a2 = a(iArr3[c], 5);
                int i24 = iArr3[1];
                int i25 = iArr3[2];
                int i26 = iArr3[3];
                int i27 = a2 + ((i24 ^ i25) ^ i26) + iArr3[4] + this.c[i23] + 1859775393;
                iArr3[4] = i26;
                iArr3[3] = i25;
                iArr3[2] = a(i24, 30);
                c = 0;
                iArr3[1] = iArr3[0];
                iArr3[0] = i27;
            }
            for (int i28 = 40; i28 <= 59; i28++) {
                int a3 = a(iArr3[c], 5);
                int i29 = iArr3[1];
                int i30 = iArr3[2];
                int i31 = iArr3[3];
                int i32 = (((a3 + (((i29 & i30) | (i29 & i31)) | (i30 & i31))) + iArr3[4]) + this.c[i28]) - 1894007588;
                iArr3[4] = i31;
                iArr3[3] = i30;
                iArr3[2] = a(i29, 30);
                c = 0;
                iArr3[1] = iArr3[0];
                iArr3[0] = i32;
            }
            int i33 = 60;
            while (i33 <= 79) {
                int a4 = a(iArr3[c], 5);
                int i34 = iArr3[1];
                int i35 = iArr3[2];
                int i36 = iArr3[3];
                int i37 = (((a4 + ((i34 ^ i35) ^ i36)) + iArr3[4]) + this.c[i33]) - 899497514;
                iArr3[4] = i36;
                iArr3[3] = i35;
                iArr3[2] = a(i34, 30);
                iArr3[1] = iArr3[0];
                iArr3[0] = i37;
                i33++;
                c = 0;
            }
            for (int i38 = 0; i38 < 5; i38++) {
                int[] iArr4 = this.b;
                iArr4[i38] = iArr4[i38] + iArr3[i38];
            }
            int i39 = 0;
            while (true) {
                int[] iArr5 = this.c;
                if (i39 < iArr5.length) {
                    iArr5[i39] = 0;
                    i39++;
                }
            }
            i13++;
        }
    }

    private static int c(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    private static byte[] c(byte[] bArr) {
        int i;
        int i2;
        int length = bArr.length;
        int i3 = length % 64;
        if (i3 < 56) {
            i = 55 - i3;
            i2 = (length - i3) + 64;
        } else if (i3 == 56) {
            i2 = length + 8 + 64;
            i = 63;
        } else {
            i = (63 - i3) + 56;
            i2 = ((length + 64) - i3) + 64;
        }
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        int i4 = length + 1;
        bArr2[length] = Byte.MIN_VALUE;
        int i5 = 0;
        while (i5 < i) {
            bArr2[i4] = 0;
            i5++;
            i4++;
        }
        long j = length * 8;
        byte b = (byte) (j & 255);
        byte b2 = (byte) ((j >> 8) & 255);
        byte b3 = (byte) ((j >> 16) & 255);
        byte b4 = (byte) ((j >> 24) & 255);
        byte b5 = (byte) ((j >> 32) & 255);
        byte b6 = (byte) ((j >> 40) & 255);
        byte b7 = (byte) (255 & (j >> 48));
        byte b8 = (byte) (j >> 56);
        int i6 = i4 + 1;
        bArr2[i4] = b8;
        int i7 = i6 + 1;
        bArr2[i6] = b7;
        int i8 = i7 + 1;
        bArr2[i7] = b6;
        int i9 = i8 + 1;
        bArr2[i8] = b5;
        int i10 = i9 + 1;
        bArr2[i9] = b4;
        int i11 = i10 + 1;
        bArr2[i10] = b3;
        bArr2[i11] = b2;
        bArr2[i11 + 1] = b;
        return bArr2;
    }

    private byte[] d(byte[] bArr) {
        b(bArr);
        byte[] bArr2 = new byte[20];
        int i = 0;
        while (true) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                return bArr2;
            }
            a(iArr[i], bArr2, i * 4);
            i++;
        }
    }
}
