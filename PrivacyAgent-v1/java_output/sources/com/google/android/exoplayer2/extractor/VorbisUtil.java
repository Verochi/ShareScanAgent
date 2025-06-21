package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class VorbisUtil {

    public static final class CodeBook {
        public final int a;
        public final int b;
        public final long[] c;
        public final int d;
        public final boolean e;

        public CodeBook(int i, int i2, long[] jArr, int i3, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = jArr;
            this.d = i3;
            this.e = z;
        }
    }

    public static final class CommentHeader {
        public final java.lang.String[] comments;
        public final int length;
        public final java.lang.String vendor;

        public CommentHeader(java.lang.String str, java.lang.String[] strArr, int i) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int i, int i2, int i3) {
            this.blockFlag = z;
            this.windowType = i;
            this.transformType = i2;
            this.mapping = i3;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMaximum;
        public final int bitrateMinimum;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final int sampleRate;
        public final int version;

        public VorbisIdHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.version = i;
            this.channels = i2;
            this.sampleRate = i3;
            this.bitrateMaximum = i4;
            this.bitrateNominal = i5;
            this.bitrateMinimum = i6;
            this.blockSize0 = i7;
            this.blockSize1 = i8;
            this.framingFlag = z;
            this.data = bArr;
        }
    }

    public static long a(long j, long j2) {
        return (long) java.lang.Math.floor(java.lang.Math.pow(j, 1.0d / j2));
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.CodeBook b(com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        if (vorbisBitArray.readBits(24) != 5653314) {
            int position = vorbisBitArray.getPosition();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(66);
            sb.append("expected code book to start with [0x56, 0x43, 0x42] at ");
            sb.append(position);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
        int readBits = vorbisBitArray.readBits(16);
        int readBits2 = vorbisBitArray.readBits(24);
        long[] jArr = new long[readBits2];
        boolean readBit = vorbisBitArray.readBit();
        long j = 0;
        if (readBit) {
            int readBits3 = vorbisBitArray.readBits(5) + 1;
            int i = 0;
            while (i < readBits2) {
                int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i));
                for (int i2 = 0; i2 < readBits4 && i < readBits2; i2++) {
                    jArr[i] = readBits3;
                    i++;
                }
                readBits3++;
            }
        } else {
            boolean readBit2 = vorbisBitArray.readBit();
            for (int i3 = 0; i3 < readBits2; i3++) {
                if (!readBit2) {
                    jArr[i3] = vorbisBitArray.readBits(5) + 1;
                } else if (vorbisBitArray.readBit()) {
                    jArr[i3] = vorbisBitArray.readBits(5) + 1;
                } else {
                    jArr[i3] = 0;
                }
            }
        }
        int readBits5 = vorbisBitArray.readBits(4);
        if (readBits5 > 2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(53);
            sb2.append("lookup type greater than 2 not decodable: ");
            sb2.append(readBits5);
            throw new com.google.android.exoplayer2.ParserException(sb2.toString());
        }
        if (readBits5 == 1 || readBits5 == 2) {
            vorbisBitArray.skipBits(32);
            vorbisBitArray.skipBits(32);
            int readBits6 = vorbisBitArray.readBits(4) + 1;
            vorbisBitArray.skipBits(1);
            if (readBits5 != 1) {
                j = readBits2 * readBits;
            } else if (readBits != 0) {
                j = a(readBits2, readBits);
            }
            vorbisBitArray.skipBits((int) (j * readBits6));
        }
        return new com.google.android.exoplayer2.extractor.VorbisUtil.CodeBook(readBits, readBits2, jArr, readBits5, readBit);
    }

    public static void c(com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i = 0; i < readBits; i++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits3 = vorbisBitArray.readBits(4) + 1;
                for (int i2 = 0; i2 < readBits3; i2++) {
                    vorbisBitArray.skipBits(8);
                }
            } else {
                if (readBits2 != 1) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(52);
                    sb.append("floor type greater than 1 not decodable: ");
                    sb.append(readBits2);
                    throw new com.google.android.exoplayer2.ParserException(sb.toString());
                }
                int readBits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[readBits4];
                int i3 = -1;
                for (int i4 = 0; i4 < readBits4; i4++) {
                    int readBits5 = vorbisBitArray.readBits(4);
                    iArr[i4] = readBits5;
                    if (readBits5 > i3) {
                        i3 = readBits5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = vorbisBitArray.readBits(3) + 1;
                    int readBits6 = vorbisBitArray.readBits(2);
                    if (readBits6 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i7 = 0; i7 < (1 << readBits6); i7++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int readBits7 = vorbisBitArray.readBits(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < readBits4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        vorbisBitArray.skipBits(readBits7);
                        i9++;
                    }
                }
            }
        }
    }

    public static void d(int i, com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i2 = 0; i2 < readBits; i2++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(52);
                sb.append("mapping type other than 0 not supported: ");
                sb.append(readBits2);
                com.google.android.exoplayer2.util.Log.e("VorbisUtil", sb.toString());
            } else {
                int readBits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                if (vorbisBitArray.readBit()) {
                    int readBits4 = vorbisBitArray.readBits(8) + 1;
                    for (int i3 = 0; i3 < readBits4; i3++) {
                        int i4 = i - 1;
                        vorbisBitArray.skipBits(iLog(i4));
                        vorbisBitArray.skipBits(iLog(i4));
                    }
                }
                if (vorbisBitArray.readBits(2) != 0) {
                    throw new com.google.android.exoplayer2.ParserException("to reserved bits must be zero after mapping coupling steps");
                }
                if (readBits3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        vorbisBitArray.skipBits(4);
                    }
                }
                for (int i6 = 0; i6 < readBits3; i6++) {
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                }
            }
        }
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] e(com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] modeArr = new com.google.android.exoplayer2.extractor.VorbisUtil.Mode[readBits];
        for (int i = 0; i < readBits; i++) {
            modeArr[i] = new com.google.android.exoplayer2.extractor.VorbisUtil.Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    public static void f(com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i = 0; i < readBits; i++) {
            if (vorbisBitArray.readBits(16) > 2) {
                throw new com.google.android.exoplayer2.ParserException("residueType greater than 2 is not decodable");
            }
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            int readBits2 = vorbisBitArray.readBits(6) + 1;
            vorbisBitArray.skipBits(8);
            int[] iArr = new int[readBits2];
            for (int i2 = 0; i2 < readBits2; i2++) {
                iArr[i2] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
            }
            for (int i3 = 0; i3 < readBits2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        vorbisBitArray.skipBits(8);
                    }
                }
            }
        }
    }

    public static int iLog(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader readVorbisCommentHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        return readVorbisCommentHeader(parsableByteArray, true, true);
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader readVorbisCommentHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z, boolean z2) throws com.google.android.exoplayer2.ParserException {
        if (z) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        }
        java.lang.String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = 11 + readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        java.lang.String[] strArr = new java.lang.String[(int) readLittleEndianUnsignedInt];
        int i = length + 4;
        for (int i2 = 0; i2 < readLittleEndianUnsignedInt; i2++) {
            java.lang.String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i2] = readString2;
            i = i + 4 + readString2.length();
        }
        if (z2 && (parsableByteArray.readUnsignedByte() & 1) == 0) {
            throw new com.google.android.exoplayer2.ParserException("framing bit expected to be set");
        }
        return new com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader(readString, strArr, i + 1);
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader readVorbisIdentificationHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt <= 0) {
            readLittleEndianInt = -1;
        }
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt2 <= 0) {
            readLittleEndianInt2 = -1;
        }
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt3 <= 0) {
            readLittleEndianInt3 = -1;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        return new com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader(readLittleEndianUnsignedIntToInt, readUnsignedByte, readLittleEndianUnsignedIntToInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, (int) java.lang.Math.pow(2.0d, readUnsignedByte2 & 15), (int) java.lang.Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4), (parsableByteArray.readUnsignedByte() & 1) > 0, java.util.Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit()));
    }

    public static com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] readVorbisModes(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws com.google.android.exoplayer2.ParserException {
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        com.google.android.exoplayer2.extractor.VorbisBitArray vorbisBitArray = new com.google.android.exoplayer2.extractor.VorbisBitArray(parsableByteArray.getData());
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i2 = 0; i2 < readUnsignedByte; i2++) {
            b(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i3 = 0; i3 < readBits; i3++) {
            if (vorbisBitArray.readBits(16) != 0) {
                throw new com.google.android.exoplayer2.ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        c(vorbisBitArray);
        f(vorbisBitArray);
        d(i, vorbisBitArray);
        com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] e = e(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return e;
        }
        throw new com.google.android.exoplayer2.ParserException("framing bit after modes not set as expected");
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z) throws com.google.android.exoplayer2.ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z) {
                return false;
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(29);
            sb.append("too short header: ");
            sb.append(bytesLeft);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
        if (parsableByteArray.readUnsignedByte() != i) {
            if (z) {
                return false;
            }
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.Integer.toHexString(i));
            throw new com.google.android.exoplayer2.ParserException(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new java.lang.String("expected header type "));
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw new com.google.android.exoplayer2.ParserException("expected characters 'vorbis'");
    }
}
