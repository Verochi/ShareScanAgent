package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final java.lang.Object a = new java.lang.Object();
    public static int[] b = new int[10];

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z, boolean z2, int i7, int i8, int i9, boolean z3) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.width = i5;
            this.height = i6;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i7;
            this.picOrderCountType = i8;
            this.picOrderCntLsbLength = i9;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static int a(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static void b(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(java.nio.ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= position) {
                byteBuffer.clear();
                return;
            }
            int i4 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3) & com.google.common.base.Ascii.US) == 7) {
                    java.nio.ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
            i = i3;
        }
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        com.google.android.exoplayer2.util.Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            clearPrefixFlags(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.paused) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    clearPrefixFlags(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & com.google.common.base.Ascii.US;
    }

    public static boolean isNalUnitSei(@androidx.annotation.Nullable java.lang.String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & com.google.common.base.Ascii.US) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    public static com.google.android.exoplayer2.util.NalUnitUtil.PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new com.google.android.exoplayer2.util.NalUnitUtil.PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        int readUnsignedExpGolombCodedInt;
        boolean readBit;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        boolean readBit2;
        float f;
        int readBits;
        int i5;
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        int readBits4 = parsableNalUnitBitArray.readBits(8);
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readBits2 == 100 || readBits2 == 110 || readBits2 == 122 || readBits2 == 244 || readBits2 == 44 || readBits2 == 83 || readBits2 == 86 || readBits2 == 118 || readBits2 == 128 || readBits2 == 138) {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readBit = readUnsignedExpGolombCodedInt == 3 ? parsableNalUnitBitArray.readBit() : false;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i6 = readUnsignedExpGolombCodedInt != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (parsableNalUnitBitArray.readBit()) {
                        b(parsableNalUnitBitArray, i7 < 6 ? 16 : 64);
                    }
                    i7++;
                }
            }
        } else {
            readUnsignedExpGolombCodedInt = 1;
            readBit = false;
        }
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt4 == 0) {
            i4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            i3 = readUnsignedExpGolombCodedInt;
            z = readBit;
        } else {
            if (readUnsignedExpGolombCodedInt4 == 1) {
                boolean readBit3 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                z = readBit;
                long readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i3 = readUnsignedExpGolombCodedInt;
                for (int i8 = 0; i8 < readUnsignedExpGolombCodedInt5; i8++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z2 = readBit3;
                i4 = 0;
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                readBit2 = parsableNalUnitBitArray.readBit();
                int i9 = (2 - (readBit2 ? 1 : 0)) * readUnsignedExpGolombCodedInt7;
                if (!readBit2) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i10 = readUnsignedExpGolombCodedInt6 * 16;
                int i11 = i9 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (i3 == 0) {
                        i5 = 2 - (readBit2 ? 1 : 0);
                    } else {
                        int i12 = i3;
                        r9 = i12 == 3 ? 1 : 2;
                        i5 = (2 - (readBit2 ? 1 : 0)) * (i12 == 1 ? 2 : 1);
                    }
                    i10 -= (readUnsignedExpGolombCodedInt8 + readUnsignedExpGolombCodedInt9) * r9;
                    i11 -= (readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11) * i5;
                }
                int i13 = i10;
                int i14 = i11;
                float f2 = 1.0f;
                if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                    readBits = parsableNalUnitBitArray.readBits(8);
                    if (readBits != 255) {
                        int readBits5 = parsableNalUnitBitArray.readBits(16);
                        int readBits6 = parsableNalUnitBitArray.readBits(16);
                        if (readBits5 != 0 && readBits6 != 0) {
                            f2 = readBits5 / readBits6;
                        }
                        f = f2;
                    } else {
                        float[] fArr = ASPECT_RATIO_IDC_VALUES;
                        if (readBits < fArr.length) {
                            f = fArr[readBits];
                        } else {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
                            sb.append("Unexpected aspect_ratio_idc value: ");
                            sb.append(readBits);
                            com.google.android.exoplayer2.util.Log.w("NalUnitUtil", sb.toString());
                        }
                    }
                    return new com.google.android.exoplayer2.util.NalUnitUtil.SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, i13, i14, f, z, readBit2, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i4, z2);
                }
                f = 1.0f;
                return new com.google.android.exoplayer2.util.NalUnitUtil.SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, i13, i14, f, z, readBit2, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i4, z2);
            }
            i3 = readUnsignedExpGolombCodedInt;
            z = readBit;
            i4 = 0;
        }
        z2 = false;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt62 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int readUnsignedExpGolombCodedInt72 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        readBit2 = parsableNalUnitBitArray.readBit();
        int i92 = (2 - (readBit2 ? 1 : 0)) * readUnsignedExpGolombCodedInt72;
        if (!readBit2) {
        }
        parsableNalUnitBitArray.skipBit();
        int i102 = readUnsignedExpGolombCodedInt62 * 16;
        int i112 = i92 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i132 = i102;
        int i142 = i112;
        float f22 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            readBits = parsableNalUnitBitArray.readBits(8);
            if (readBits != 255) {
            }
            return new com.google.android.exoplayer2.util.NalUnitUtil.SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, i132, i142, f, z, readBit2, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i4, z2);
        }
        f = 1.0f;
        return new com.google.android.exoplayer2.util.NalUnitUtil.SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, i132, i142, f, z, readBit2, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i4, z2);
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (a) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = a(bArr, i3, i);
                    if (i3 < i) {
                        int[] iArr = b;
                        if (iArr.length <= i4) {
                            b = java.util.Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        b[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = b[i7] - i6;
                java.lang.System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            java.lang.System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }
}
