package net.lingala.zip4j.crypto.engine;

/* loaded from: classes23.dex */
public class AESEngine {
    public static final byte[] g = {99, 124, 119, 123, -14, 107, 111, -59, org.apache.tools.tar.TarConstants.LF_NORMAL, 1, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, org.apache.tools.tar.TarConstants.LF_FIFO, 63, -9, -52, org.apache.tools.tar.TarConstants.LF_BLK, -91, -27, -15, 113, -40, org.apache.tools.tar.TarConstants.LF_LINK, com.google.common.base.Ascii.NAK, 4, -57, 35, -61, com.google.common.base.Ascii.CAN, -106, 5, -102, 7, com.google.common.base.Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, -49, -48, -17, -86, -5, 67, 77, org.apache.tools.tar.TarConstants.LF_CHR, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, com.google.common.base.Ascii.ETB, -60, -89, 126, 61, 100, 93, com.google.common.base.Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, com.google.common.base.Ascii.DC4, -34, 94, 11, -37, -32, org.apache.tools.tar.TarConstants.LF_SYMLINK, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, org.apache.tools.tar.TarConstants.LF_CONTIG, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 37, 46, com.google.common.base.Ascii.FS, -90, -76, -58, -24, -35, 116, com.google.common.base.Ascii.US, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, org.apache.tools.tar.TarConstants.LF_DIR, 87, -71, -122, -63, com.google.common.base.Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, com.google.common.base.Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, com.google.common.base.Ascii.SYN};
    public static final int[] h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, 99, 198, 151, 53, 106, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 179, 125, 250, 239, 197, 145};
    public static final int[] i = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    public int a;
    public int[][] b = null;
    public int c;
    public int d;
    public int e;
    public int f;

    public AESEngine(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        init(bArr);
    }

    public final void a(int[][] iArr) {
        int i2 = this.c;
        int[] iArr2 = iArr[0];
        this.c = i2 ^ iArr2[0];
        this.d ^= iArr2[1];
        this.e ^= iArr2[2];
        this.f ^= iArr2[3];
        int i3 = 1;
        while (i3 < this.a - 1) {
            int[] iArr3 = i;
            int c = (((iArr3[this.c & 255] ^ c(iArr3[(this.d >> 8) & 255], 24)) ^ c(iArr3[(this.e >> 16) & 255], 16)) ^ c(iArr3[(this.f >> 24) & 255], 8)) ^ iArr[i3][0];
            int c2 = (((iArr3[this.d & 255] ^ c(iArr3[(this.e >> 8) & 255], 24)) ^ c(iArr3[(this.f >> 16) & 255], 16)) ^ c(iArr3[(this.c >> 24) & 255], 8)) ^ iArr[i3][1];
            int c3 = (((iArr3[this.e & 255] ^ c(iArr3[(this.f >> 8) & 255], 24)) ^ c(iArr3[(this.c >> 16) & 255], 16)) ^ c(iArr3[(this.d >> 24) & 255], 8)) ^ iArr[i3][2];
            int i4 = i3 + 1;
            int c4 = iArr[i3][3] ^ (((iArr3[this.f & 255] ^ c(iArr3[(this.c >> 8) & 255], 24)) ^ c(iArr3[(this.d >> 16) & 255], 16)) ^ c(iArr3[(this.e >> 24) & 255], 8));
            this.c = (((iArr3[c & 255] ^ c(iArr3[(c2 >> 8) & 255], 24)) ^ c(iArr3[(c3 >> 16) & 255], 16)) ^ c(iArr3[(c4 >> 24) & 255], 8)) ^ iArr[i4][0];
            this.d = (((iArr3[c2 & 255] ^ c(iArr3[(c3 >> 8) & 255], 24)) ^ c(iArr3[(c4 >> 16) & 255], 16)) ^ c(iArr3[(c >> 24) & 255], 8)) ^ iArr[i4][1];
            this.e = (((iArr3[c3 & 255] ^ c(iArr3[(c4 >> 8) & 255], 24)) ^ c(iArr3[(c >> 16) & 255], 16)) ^ c(iArr3[(c2 >> 24) & 255], 8)) ^ iArr[i4][2];
            this.f = (((iArr3[c4 & 255] ^ c(iArr3[(c >> 8) & 255], 24)) ^ c(iArr3[(c2 >> 16) & 255], 16)) ^ c(iArr3[(c3 >> 24) & 255], 8)) ^ iArr[i4][3];
            i3 = i4 + 1;
        }
        int[] iArr4 = i;
        int c5 = (((iArr4[this.c & 255] ^ c(iArr4[(this.d >> 8) & 255], 24)) ^ c(iArr4[(this.e >> 16) & 255], 16)) ^ c(iArr4[(this.f >> 24) & 255], 8)) ^ iArr[i3][0];
        int c6 = (((iArr4[this.d & 255] ^ c(iArr4[(this.e >> 8) & 255], 24)) ^ c(iArr4[(this.f >> 16) & 255], 16)) ^ c(iArr4[(this.c >> 24) & 255], 8)) ^ iArr[i3][1];
        int c7 = (((iArr4[this.e & 255] ^ c(iArr4[(this.f >> 8) & 255], 24)) ^ c(iArr4[(this.c >> 16) & 255], 16)) ^ c(iArr4[(this.d >> 24) & 255], 8)) ^ iArr[i3][2];
        int i5 = i3 + 1;
        int c8 = iArr[i3][3] ^ (c(iArr4[(this.e >> 24) & 255], 8) ^ ((iArr4[this.f & 255] ^ c(iArr4[(this.c >> 8) & 255], 24)) ^ c(iArr4[(this.d >> 16) & 255], 16)));
        byte[] bArr = g;
        int i6 = (((bArr[c5 & 255] & 255) ^ ((bArr[(c6 >> 8) & 255] & 255) << 8)) ^ ((bArr[(c7 >> 16) & 255] & 255) << 16)) ^ (bArr[(c8 >> 24) & 255] << com.google.common.base.Ascii.CAN);
        int[] iArr5 = iArr[i5];
        this.c = iArr5[0] ^ i6;
        this.d = ((((bArr[c6 & 255] & 255) ^ ((bArr[(c7 >> 8) & 255] & 255) << 8)) ^ ((bArr[(c8 >> 16) & 255] & 255) << 16)) ^ (bArr[(c5 >> 24) & 255] << com.google.common.base.Ascii.CAN)) ^ iArr5[1];
        this.e = ((((bArr[c7 & 255] & 255) ^ ((bArr[(c8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(c5 >> 16) & 255] & 255) << 16)) ^ (bArr[(c6 >> 24) & 255] << com.google.common.base.Ascii.CAN)) ^ iArr5[2];
        this.f = ((((bArr[c8 & 255] & 255) ^ ((bArr[(c5 >> 8) & 255] & 255) << 8)) ^ ((bArr[(c6 >> 16) & 255] & 255) << 16)) ^ (bArr[(c7 >> 24) & 255] << com.google.common.base.Ascii.CAN)) ^ iArr5[3];
    }

    public final int[][] b(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        int length = bArr.length / 4;
        if ((length != 4 && length != 6 && length != 8) || length * 4 != bArr.length) {
            throw new net.lingala.zip4j.exception.ZipException("invalid key length (not 128/192/256)");
        }
        int i2 = length + 6;
        this.a = i2;
        int i3 = 0;
        int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Integer.TYPE, i2 + 1, 4);
        int i4 = 0;
        while (i3 < bArr.length) {
            iArr[i4 >> 2][i4 & 3] = (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | (bArr[i3 + 3] << com.google.common.base.Ascii.CAN);
            i3 += 4;
            i4++;
        }
        int i5 = (this.a + 1) << 2;
        for (int i6 = length; i6 < i5; i6++) {
            int i7 = i6 - 1;
            int i8 = iArr[i7 >> 2][i7 & 3];
            int i9 = i6 % length;
            if (i9 == 0) {
                i8 = f(c(i8, 8)) ^ h[(i6 / length) - 1];
            } else if (length > 6 && i9 == 4) {
                i8 = f(i8);
            }
            int i10 = i6 - length;
            iArr[i6 >> 2][i6 & 3] = i8 ^ iArr[i10 >> 2][i10 & 3];
        }
        return iArr;
    }

    public final int c(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    public final void d(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        int i8 = i6 + 1;
        this.c = i7 | (bArr[i6] << com.google.common.base.Ascii.CAN);
        int i9 = i8 + 1;
        int i10 = bArr[i8] & 255;
        int i11 = i9 + 1;
        int i12 = ((bArr[i9] & 255) << 8) | i10;
        int i13 = i11 + 1;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        int i15 = i13 + 1;
        this.d = i14 | (bArr[i13] << com.google.common.base.Ascii.CAN);
        int i16 = i15 + 1;
        int i17 = bArr[i15] & 255;
        int i18 = i16 + 1;
        int i19 = ((bArr[i16] & 255) << 8) | i17;
        int i20 = i18 + 1;
        int i21 = i19 | ((bArr[i18] & 255) << 16);
        int i22 = i20 + 1;
        this.e = i21 | (bArr[i20] << com.google.common.base.Ascii.CAN);
        int i23 = i22 + 1;
        int i24 = bArr[i22] & 255;
        int i25 = i23 + 1;
        int i26 = ((bArr[i23] & 255) << 8) | i24;
        int i27 = i26 | ((bArr[i25] & 255) << 16);
        this.f = (bArr[i25 + 1] << com.google.common.base.Ascii.CAN) | i27;
    }

    public final void e(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = this.c;
        bArr[i2] = (byte) i4;
        int i5 = i3 + 1;
        bArr[i3] = (byte) (i4 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i4 >> 16);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i4 >> 24);
        int i8 = i7 + 1;
        int i9 = this.d;
        bArr[i7] = (byte) i9;
        int i10 = i8 + 1;
        bArr[i8] = (byte) (i9 >> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >> 16);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i9 >> 24);
        int i13 = i12 + 1;
        int i14 = this.e;
        bArr[i12] = (byte) i14;
        int i15 = i13 + 1;
        bArr[i13] = (byte) (i14 >> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i14 >> 16);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i14 >> 24);
        int i18 = i17 + 1;
        int i19 = this.f;
        bArr[i17] = (byte) i19;
        int i20 = i18 + 1;
        bArr[i18] = (byte) (i19 >> 8);
        bArr[i20] = (byte) (i19 >> 16);
        bArr[i20 + 1] = (byte) (i19 >> 24);
    }

    public final int f(int i2) {
        byte[] bArr = g;
        return (bArr[(i2 >> 24) & 255] << com.google.common.base.Ascii.CAN) | (bArr[i2 & 255] & 255) | ((bArr[(i2 >> 8) & 255] & 255) << 8) | ((bArr[(i2 >> 16) & 255] & 255) << 16);
    }

    public void init(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        this.b = b(bArr);
    }

    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws net.lingala.zip4j.exception.ZipException {
        if (this.b == null) {
            throw new net.lingala.zip4j.exception.ZipException("AES engine not initialised");
        }
        if (i2 + 16 > bArr.length) {
            throw new net.lingala.zip4j.exception.ZipException("input buffer too short");
        }
        if (i3 + 16 > bArr2.length) {
            throw new net.lingala.zip4j.exception.ZipException("output buffer too short");
        }
        d(bArr, i2);
        a(this.b);
        e(bArr2, i3);
        return 16;
    }

    public int processBlock(byte[] bArr, byte[] bArr2) throws net.lingala.zip4j.exception.ZipException {
        return processBlock(bArr, 0, bArr2, 0);
    }
}
