package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class Id3Decoder extends com.google.android.exoplayer2.metadata.SimpleMetadataDecoder {
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    public static final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate NO_FRAMES_PREDICATE = new defpackage.ar0();

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate a;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public static final class Id3Header {
        public final int a;
        public final boolean b;
        public final int c;

        public Id3Header(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) {
        this.a = framePredicate;
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        return i2 <= i ? com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY : java.util.Arrays.copyOfRange(bArr, i, i2);
    }

    public static com.google.android.exoplayer2.metadata.id3.ApicFrame c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) throws java.io.UnsupportedEncodingException {
        int v;
        java.lang.String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.util.Util.toLowerInvariant(new java.lang.String(bArr, 0, 3, "ISO-8859-1")));
            str = valueOf.length() != 0 ? "image/".concat(valueOf) : new java.lang.String("image/");
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            v = 2;
        } else {
            v = v(bArr, 0);
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(new java.lang.String(bArr, 0, v, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                if (lowerInvariant.length() != 0) {
                    str = "image/".concat(lowerInvariant);
                } else {
                    lowerInvariant = new java.lang.String("image/");
                }
            }
            str = lowerInvariant;
        }
        int i4 = bArr[v + 1] & 255;
        int i5 = v + 2;
        int u = u(bArr, i5, readUnsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.ApicFrame(str, new java.lang.String(bArr, i5, u - i5, s2), i4, b(bArr, u + r(readUnsignedByte), i3));
    }

    public static com.google.android.exoplayer2.metadata.id3.BinaryFrame d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, java.lang.String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new com.google.android.exoplayer2.metadata.id3.BinaryFrame(str, bArr);
    }

    public static com.google.android.exoplayer2.metadata.id3.ChapterFrame e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) throws java.io.UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int v = v(parsableByteArray.getData(), position);
        java.lang.String str = new java.lang.String(parsableByteArray.getData(), position, v - position, "ISO-8859-1");
        parsableByteArray.setPosition(v + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT ? -1L : readUnsignedInt;
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        long j2 = readUnsignedInt2 == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT ? -1L : readUnsignedInt2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame h = h(i2, parsableByteArray, z, i3, framePredicate);
            if (h != null) {
                arrayList.add(h);
            }
        }
        return new com.google.android.exoplayer2.metadata.id3.ChapterFrame(str, readInt, readInt2, j, j2, (com.google.android.exoplayer2.metadata.id3.Id3Frame[]) arrayList.toArray(new com.google.android.exoplayer2.metadata.id3.Id3Frame[0]));
    }

    public static com.google.android.exoplayer2.metadata.id3.ChapterTocFrame f(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) throws java.io.UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int v = v(parsableByteArray.getData(), position);
        java.lang.String str = new java.lang.String(parsableByteArray.getData(), position, v - position, "ISO-8859-1");
        parsableByteArray.setPosition(v + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        java.lang.String[] strArr = new java.lang.String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int v2 = v(parsableByteArray.getData(), position2);
            strArr[i4] = new java.lang.String(parsableByteArray.getData(), position2, v2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(v2 + 1);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame h = h(i2, parsableByteArray, z, i3, framePredicate);
            if (h != null) {
                arrayList.add(h);
            }
        }
        return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame(str, z2, z3, strArr, (com.google.android.exoplayer2.metadata.id3.Id3Frame[]) arrayList.toArray(new com.google.android.exoplayer2.metadata.id3.Id3Frame[0]));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.CommentFrame g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws java.io.UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        java.lang.String str = new java.lang.String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int u = u(bArr2, 0, readUnsignedByte);
        java.lang.String str2 = new java.lang.String(bArr2, 0, u, s2);
        int r = u + r(readUnsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.CommentFrame(str, str2, m(bArr2, r, u(bArr2, r, readUnsignedByte), s2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0190, code lost:
    
        if (r13 == 67) goto L132;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame h(int i, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) {
        int readUnsignedIntToInt;
        java.lang.String str;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        com.google.android.exoplayer2.metadata.id3.Id3Frame g;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? parsableByteArray.readUnsignedByte() : 0;
        if (i == 4) {
            readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (!z) {
                readUnsignedIntToInt = (((readUnsignedIntToInt >> 24) & 255) << 21) | (readUnsignedIntToInt & 255) | (((readUnsignedIntToInt >> 8) & 255) << 7) | (((readUnsignedIntToInt >> 16) & 255) << 14);
            }
        } else {
            readUnsignedIntToInt = i == 3 ? parsableByteArray.readUnsignedIntToInt() : parsableByteArray.readUnsignedInt24();
        }
        int i5 = readUnsignedIntToInt;
        int readUnsignedShort = i >= 3 ? parsableByteArray.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && i5 == 0 && readUnsignedShort == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i5;
        if (position > parsableByteArray.limit()) {
            com.google.android.exoplayer2.util.Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            str = "Id3Decoder";
            i3 = position;
            i4 = readUnsignedShort;
            if (!framePredicate.evaluate(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
                parsableByteArray.setPosition(i3);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i3 = position;
            i4 = readUnsignedShort;
        }
        if (i == 3) {
            int i6 = i4;
            z3 = (i6 & 128) != 0;
            z4 = (i6 & 64) != 0;
            z2 = (i6 & 32) != 0;
            z6 = z3;
            z5 = false;
        } else {
            int i7 = i4;
            if (i == 4) {
                boolean z7 = (i7 & 64) != 0;
                boolean z8 = (i7 & 8) != 0;
                boolean z9 = (i7 & 4) != 0;
                z5 = (i7 & 2) != 0;
                boolean z10 = (i7 & 1) != 0;
                z2 = z7;
                z3 = z10;
                z6 = z8;
                z4 = z9;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z6 || z4) {
            com.google.android.exoplayer2.util.Log.w(str, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.setPosition(i3);
            return null;
        }
        if (z2) {
            i5--;
            parsableByteArray.skipBytes(1);
        }
        if (z3) {
            i5 -= 4;
            parsableByteArray.skipBytes(4);
        }
        if (z5) {
            i5 = x(parsableByteArray, i5);
        }
        try {
            try {
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    g = o(parsableByteArray, i5);
                } else if (readUnsignedByte == 84) {
                    g = n(parsableByteArray, i5, t(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    g = q(parsableByteArray, i5);
                } else if (readUnsignedByte == 87) {
                    g = p(parsableByteArray, i5, t(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    g = l(parsableByteArray, i5);
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    g = i(parsableByteArray, i5);
                } else if (i == 2) {
                    if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                        g = c(parsableByteArray, i5, i);
                    }
                    g = (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) ? g(parsableByteArray, i5) : (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) ? e(parsableByteArray, i5, i, z, i2, framePredicate) : (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) ? f(parsableByteArray, i5, i, z, i2, framePredicate) : (readUnsignedByte != 77 && readUnsignedByte2 == 76 && readUnsignedByte3 == 76 && readUnsignedByte4 == 84) ? k(parsableByteArray, i5) : d(parsableByteArray, i5, t(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else {
                    if (readUnsignedByte == 65) {
                        if (readUnsignedByte2 == 80) {
                            if (readUnsignedByte3 == 73) {
                            }
                        }
                    }
                    if (readUnsignedByte != 67) {
                    }
                }
                if (g == null) {
                    java.lang.String t = t(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(t).length() + 50);
                    sb.append("Failed to decode frame: id=");
                    sb.append(t);
                    sb.append(", frameSize=");
                    sb.append(i5);
                    com.google.android.exoplayer2.util.Log.w(str, sb.toString());
                }
                parsableByteArray.setPosition(i3);
                return g;
            } catch (java.io.UnsupportedEncodingException unused) {
                com.google.android.exoplayer2.util.Log.w(str, "Unsupported character encoding");
                parsableByteArray.setPosition(i3);
                return null;
            }
        } catch (java.lang.Throwable th) {
            parsableByteArray.setPosition(i3);
            throw th;
        }
    }

    public static com.google.android.exoplayer2.metadata.id3.GeobFrame i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws java.io.UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int v = v(bArr, 0);
        java.lang.String str = new java.lang.String(bArr, 0, v, "ISO-8859-1");
        int i3 = v + 1;
        int u = u(bArr, i3, readUnsignedByte);
        java.lang.String m = m(bArr, i3, u, s2);
        int r = u + r(readUnsignedByte);
        int u2 = u(bArr, r, readUnsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.GeobFrame(str, m, m(bArr, r, u2, s2), b(bArr, u2 + r(readUnsignedByte), i2));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            com.google.android.exoplayer2.util.Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        boolean z = false;
        if (readUnsignedInt24 != 4801587) {
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.String.format("%06X", java.lang.Integer.valueOf(readUnsignedInt24)));
            com.google.android.exoplayer2.util.Log.w("Id3Decoder", valueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf) : new java.lang.String("Unexpected first three bytes of ID3 tag header: 0x"));
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                com.google.android.exoplayer2.util.Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else {
            if (readUnsignedByte != 4) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(57);
                sb.append("Skipped ID3 tag with unsupported majorVersion=");
                sb.append(readUnsignedByte);
                com.google.android.exoplayer2.util.Log.w("Id3Decoder", sb.toString());
                return null;
            }
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        }
        if (readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0) {
            z = true;
        }
        return new com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header(readUnsignedByte, z, readSynchSafeInt);
    }

    public static com.google.android.exoplayer2.metadata.id3.MlltFrame k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        int readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i2 = ((i - 10) * 8) / (readUnsignedByte + readUnsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int readBits = parsableBitArray.readBits(readUnsignedByte);
            int readBits2 = parsableBitArray.readBits(readUnsignedByte2);
            iArr[i3] = readBits;
            iArr2[i3] = readBits2;
        }
        return new com.google.android.exoplayer2.metadata.id3.MlltFrame(readUnsignedShort, readUnsignedInt24, readUnsignedInt242, iArr, iArr2);
    }

    public static com.google.android.exoplayer2.metadata.id3.PrivFrame l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws java.io.UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int v = v(bArr, 0);
        return new com.google.android.exoplayer2.metadata.id3.PrivFrame(new java.lang.String(bArr, 0, v, "ISO-8859-1"), b(bArr, v + 1, i));
    }

    public static java.lang.String m(byte[] bArr, int i, int i2, java.lang.String str) throws java.io.UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new java.lang.String(bArr, i, i2 - i, str);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame n(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, java.lang.String str) throws java.io.UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, new java.lang.String(bArr, 0, u(bArr, 0, readUnsignedByte), s2));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws java.io.UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int u = u(bArr, 0, readUnsignedByte);
        java.lang.String str = new java.lang.String(bArr, 0, u, s2);
        int r = u + r(readUnsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TXXX", str, m(bArr, r, u(bArr, r, readUnsignedByte), s2));
    }

    public static com.google.android.exoplayer2.metadata.id3.UrlLinkFrame p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, java.lang.String str) throws java.io.UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame(str, null, new java.lang.String(bArr, 0, v(bArr, 0), "ISO-8859-1"));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.UrlLinkFrame q(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws java.io.UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String s2 = s(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int u = u(bArr, 0, readUnsignedByte);
        java.lang.String str = new java.lang.String(bArr, 0, u, s2);
        int r = u + r(readUnsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame("WXXX", str, m(bArr, r, v(bArr, r), "ISO-8859-1"));
    }

    public static int r(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static java.lang.String s(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : org.apache.commons.codec.CharEncoding.UTF_16BE : "UTF-16";
    }

    public static java.lang.String t(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? java.lang.String.format(java.util.Locale.US, "%c%c%c", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4)) : java.lang.String.format(java.util.Locale.US, "%c%c%c%c", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5));
    }

    public static int u(byte[] bArr, int i, int i2) {
        int v = v(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return v;
        }
        while (v < bArr.length - 1) {
            if (v % 2 == 0 && bArr[v + 1] == 0) {
                return v;
            }
            v = v(bArr, v + 1);
        }
        return bArr.length;
    }

    public static int v(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static /* synthetic */ boolean w(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public static int x(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int i2 = position;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= position + i) {
                return i;
            }
            if ((data[i2] & 255) == 255 && data[i3] == 0) {
                java.lang.System.arraycopy(data, i2 + 2, data, i3, (i - (i2 - position)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean y(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i3;
        int i4;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                boolean z2 = true;
                if (parsableByteArray.bytesLeft() < i2) {
                    return true;
                }
                if (i >= 3) {
                    readUnsignedInt24 = parsableByteArray.readInt();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                    i3 = parsableByteArray.readUnsignedShort();
                } else {
                    readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                    i3 = 0;
                }
                if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i3 == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & readUnsignedInt242) != 0) {
                        return false;
                    }
                    readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i4 = (i3 & 64) != 0 ? 1 : 0;
                } else {
                    if (i == 3) {
                        i4 = (i3 & 32) != 0 ? 1 : 0;
                    } else {
                        i4 = 0;
                    }
                    z2 = false;
                    if (z2) {
                        i4 += 4;
                    }
                    if (readUnsignedInt242 < i4) {
                        return false;
                    }
                    if (parsableByteArray.bytesLeft() < readUnsignedInt242) {
                        return false;
                    }
                    parsableByteArray.skipBytes((int) readUnsignedInt242);
                }
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata decode(byte[] bArr, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i);
        com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header j = j(parsableByteArray);
        if (j == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = j.a == 2 ? 6 : 10;
        int i3 = j.c;
        if (j.b) {
            i3 = x(parsableByteArray, j.c);
        }
        parsableByteArray.setLimit(position + i3);
        boolean z = false;
        if (!y(parsableByteArray, j.a, i2, false)) {
            if (j.a != 4 || !y(parsableByteArray, 4, i2, true)) {
                int i4 = j.a;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(56);
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(i4);
                com.google.android.exoplayer2.util.Log.w("Id3Decoder", sb.toString());
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame h = h(j.a, parsableByteArray, z, i2, this.a);
            if (h != null) {
                arrayList.add(h);
            }
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }
}
