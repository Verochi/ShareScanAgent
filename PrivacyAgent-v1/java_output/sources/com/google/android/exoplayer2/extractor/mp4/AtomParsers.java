package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
final class AtomParsers {
    public static final byte[] a = com.google.android.exoplayer2.util.Util.getUtf8Bytes("OpusHead");

    public static final class ChunkIterator {
        public final int a;
        public int b;
        public int c;
        public long d;
        public final boolean e;
        public final com.google.android.exoplayer2.util.ParsableByteArray f;
        public final com.google.android.exoplayer2.util.ParsableByteArray g;
        public int h;
        public int i;

        public ChunkIterator(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2, boolean z) {
            this.g = parsableByteArray;
            this.f = parsableByteArray2;
            this.e = z;
            parsableByteArray2.setPosition(12);
            this.a = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.i = parsableByteArray.readUnsignedIntToInt();
            com.google.android.exoplayer2.util.Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.readUnsignedLongToLong() : this.f.readUnsignedInt();
            if (this.b == this.h) {
                this.c = this.g.readUnsignedIntToInt();
                this.g.skipBytes(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    public interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    public static final class StsdData {
        public final com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] a;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.Format b;
        public int c;
        public int d = 0;

        public StsdData(int i) {
            this.a = new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[i];
        }
    }

    public static final class StszSampleSizeBox implements com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox {
        public final int a;
        public final int b;
        public final com.google.android.exoplayer2.util.ParsableByteArray c;

        public StszSampleSizeBox(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = leafAtom.b;
            this.c = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            this.a = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.b = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int a() {
            int i = this.a;
            return i == -1 ? this.c.readUnsignedIntToInt() : i;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int b() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int c() {
            return this.a;
        }
    }

    public static final class Stz2SampleSizeBox implements com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox {
        public final com.google.android.exoplayer2.util.ParsableByteArray a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public Stz2SampleSizeBox(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = leafAtom.b;
            this.a = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.c = parsableByteArray.readUnsignedIntToInt() & 255;
            this.b = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int a() {
            int i = this.c;
            if (i == 8) {
                return this.a.readUnsignedByte();
            }
            if (i == 16) {
                return this.a.readUnsignedShort();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int readUnsignedByte = this.a.readUnsignedByte();
            this.e = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int b() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int c() {
            return -1;
        }
    }

    public static final class TkhdData {
        public final int a;
        public final long b;
        public final int c;

        public TkhdData(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static void A(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData stsdData, int i6) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2;
        java.util.List<byte[]> list;
        java.lang.String str;
        java.util.List<byte[]> list2;
        java.lang.String str2;
        int i7 = i2;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData3 = drmInitData;
        parsableByteArray.setPosition(i7 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        java.lang.String str3 = null;
        int i8 = i;
        if (i8 == 1701733238) {
            android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox> q = q(parsableByteArray, i7, i3);
            if (q != null) {
                i8 = ((java.lang.Integer) q.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) q.second).schemeType);
                stsdData.a[i6] = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) q.second;
            }
            parsableByteArray.setPosition(position);
        }
        byte[] bArr = null;
        java.util.List<byte[]> list3 = null;
        java.lang.String str4 = null;
        float f = 1.0f;
        int i9 = -1;
        boolean z = false;
        while (true) {
            if (position - i7 >= i3) {
                drmInitData2 = drmInitData3;
                list = list3;
                break;
            }
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            drmInitData2 = drmInitData3;
            int readInt = parsableByteArray.readInt();
            if (readInt == 0) {
                list = list3;
                if (parsableByteArray.getPosition() - i7 == i3) {
                    break;
                }
            } else {
                list = list3;
            }
            com.google.android.exoplayer2.util.Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                parsableByteArray.setPosition(position2 + 8);
                com.google.android.exoplayer2.video.AvcConfig parse = com.google.android.exoplayer2.video.AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData.c = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str2 = "video/avc";
            } else if (readInt2 == 1752589123) {
                com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                parsableByteArray.setPosition(position2 + 8);
                com.google.android.exoplayer2.video.HevcConfig parse2 = com.google.android.exoplayer2.video.HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData.c = parse2.nalUnitLengthFieldLength;
                str2 = "video/hevc";
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    com.google.android.exoplayer2.video.DolbyVisionConfig parse3 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str3 = parse3.codecs;
                        str4 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION;
                    }
                } else {
                    if (readInt2 == 1987076931) {
                        com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                        str = i8 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    } else if (readInt2 == 1635135811) {
                        com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                        str = com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1;
                    } else if (readInt2 == 1681012275) {
                        com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                        str = "video/3gpp";
                    } else {
                        if (readInt2 == 1702061171) {
                            com.google.android.exoplayer2.util.Assertions.checkState(str4 == null);
                            android.util.Pair<java.lang.String, byte[]> g = g(parsableByteArray, position2);
                            java.lang.String str5 = (java.lang.String) g.first;
                            byte[] bArr2 = (byte[]) g.second;
                            list3 = bArr2 != null ? com.google.common.collect.ImmutableList.of(bArr2) : list;
                            str4 = str5;
                        } else if (readInt2 == 1885434736) {
                            list3 = list;
                            f = o(parsableByteArray, position2);
                            z = true;
                        } else if (readInt2 == 1937126244) {
                            list3 = list;
                            bArr = p(parsableByteArray, position2, readInt);
                        } else if (readInt2 == 1936995172) {
                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                            parsableByteArray.skipBytes(3);
                            if (readUnsignedByte == 0) {
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                if (readUnsignedByte2 == 0) {
                                    list3 = list;
                                    i9 = 0;
                                } else if (readUnsignedByte2 == 1) {
                                    list3 = list;
                                    i9 = 1;
                                } else if (readUnsignedByte2 == 2) {
                                    list3 = list;
                                    i9 = 2;
                                } else if (readUnsignedByte2 == 3) {
                                    list3 = list;
                                    i9 = 3;
                                }
                            }
                        }
                        position += readInt;
                        i7 = i2;
                        drmInitData3 = drmInitData2;
                    }
                    list3 = list;
                    str4 = str;
                    position += readInt;
                    i7 = i2;
                    drmInitData3 = drmInitData2;
                }
                list3 = list;
                position += readInt;
                i7 = i2;
                drmInitData3 = drmInitData2;
            }
            str4 = str2;
            list3 = list2;
            position += readInt;
            i7 = i2;
            drmInitData3 = drmInitData2;
        }
        if (str4 == null) {
            return;
        }
        stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str3).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f).setRotationDegrees(i5).setProjectionData(bArr).setStereoMode(i9).setInitializationData(list).setDrmInitData(drmInitData2).build();
    }

    public static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[com.google.android.exoplayer2.util.Util.constrainValue(4, 0, length)] && jArr[com.google.android.exoplayer2.util.Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    public static int b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            com.google.android.exoplayer2.util.Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    public static int c(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 4 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, java.lang.String str, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData stsdData, int i5) throws com.google.android.exoplayer2.ParserException {
        int i6;
        int i7;
        int i8;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2;
        java.lang.String str2;
        java.lang.String str3;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        parsableByteArray.setPosition(i11 + 8 + 8);
        if (z) {
            i6 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            i6 = 0;
        }
        boolean z2 = true;
        if (i6 == 0 || i6 == 1) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            int readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (i6 == 1) {
                parsableByteArray.skipBytes(16);
            }
            i7 = readUnsignedFixedPoint1616;
            i8 = readUnsignedShort;
        } else {
            if (i6 != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            i7 = (int) java.lang.Math.round(parsableByteArray.readDouble());
            i8 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        }
        int position = parsableByteArray.getPosition();
        int i13 = i;
        if (i13 == 1701733217) {
            android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox> q = q(parsableByteArray, i11, i12);
            if (q != null) {
                i13 = ((java.lang.Integer) q.first).intValue();
                drmInitData2 = drmInitData == null ? null : drmInitData.copyWithSchemeType(((com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) q.second).schemeType);
                stsdData.a[i5] = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) q.second;
            } else {
                drmInitData2 = drmInitData;
            }
            parsableByteArray.setPosition(position);
        } else {
            drmInitData2 = drmInitData;
        }
        if (i13 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i13 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i13 == 1633889588) {
            str2 = com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4;
        } else if (i13 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i13 == 1685353320 || i13 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i13 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i13 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (i13 != 1935767394) {
                str3 = "audio/raw";
                if (i13 == 1819304813 || i13 == 1936684916) {
                    i9 = 2;
                } else if (i13 == 1953984371) {
                    i9 = 268435456;
                } else if (i13 == 778924082 || i13 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (i13 == 1634492771) {
                    str2 = "audio/alac";
                } else if (i13 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (i13 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (i13 == 1332770163) {
                    str2 = "audio/opus";
                } else if (i13 == 1716281667) {
                    str2 = "audio/flac";
                } else {
                    i9 = -1;
                    str3 = null;
                }
                java.lang.String str4 = str3;
                java.lang.String str5 = null;
                java.util.List list = null;
                while (position - i11 < i12) {
                    parsableByteArray.setPosition(position);
                    int readInt = parsableByteArray.readInt();
                    if (readInt <= 0) {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.util.Assertions.checkState(z2, "childAtomSize should be positive");
                    int readInt2 = parsableByteArray.readInt();
                    if (readInt2 == 1702061171) {
                        z2 = true;
                        i10 = 1702061171;
                    } else if (z && readInt2 == 2002876005) {
                        i10 = 1702061171;
                        z2 = true;
                    } else {
                        if (readInt2 == 1684103987) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.b = com.google.android.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(parsableByteArray, java.lang.Integer.toString(i4), str, drmInitData2);
                        } else if (readInt2 == 1684366131) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.b = com.google.android.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, java.lang.Integer.toString(i4), str, drmInitData2);
                        } else if (readInt2 == 1684103988) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.b = com.google.android.exoplayer2.audio.Ac4Util.parseAc4AnnexEFormat(parsableByteArray, java.lang.Integer.toString(i4), str, drmInitData2);
                        } else if (readInt2 == 1684305011) {
                            stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(i8).setSampleRate(i7).setDrmInitData(drmInitData2).setLanguage(str).build();
                        } else {
                            if (readInt2 == 1682927731) {
                                int i14 = readInt - 8;
                                byte[] bArr = a;
                                byte[] copyOf = java.util.Arrays.copyOf(bArr, bArr.length + i14);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(copyOf, bArr.length, i14);
                                list = com.google.android.exoplayer2.audio.OpusUtil.buildInitializationData(copyOf);
                                z2 = true;
                            } else if (readInt2 == 1684425825) {
                                int i15 = readInt - 12;
                                byte[] bArr2 = new byte[i15 + 4];
                                bArr2[0] = 102;
                                z2 = true;
                                bArr2[1] = org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME;
                                bArr2[2] = 97;
                                bArr2[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr2, 4, i15);
                                list = com.google.common.collect.ImmutableList.of(bArr2);
                            } else {
                                z2 = true;
                                if (readInt2 == 1634492771) {
                                    int i16 = readInt - 12;
                                    byte[] bArr3 = new byte[i16];
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr3, 0, i16);
                                    android.util.Pair<java.lang.Integer, java.lang.Integer> parseAlacAudioSpecificConfig = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr3);
                                    i7 = ((java.lang.Integer) parseAlacAudioSpecificConfig.first).intValue();
                                    int intValue = ((java.lang.Integer) parseAlacAudioSpecificConfig.second).intValue();
                                    list = com.google.common.collect.ImmutableList.of(bArr3);
                                    i8 = intValue;
                                }
                            }
                            position += readInt;
                            i11 = i2;
                            i12 = i3;
                        }
                        z2 = true;
                        position += readInt;
                        i11 = i2;
                        i12 = i3;
                    }
                    int b = readInt2 == i10 ? position : b(parsableByteArray, position, readInt);
                    if (b != -1) {
                        android.util.Pair<java.lang.String, byte[]> g = g(parsableByteArray, b);
                        str4 = (java.lang.String) g.first;
                        byte[] bArr4 = (byte[]) g.second;
                        if (bArr4 != null) {
                            if ("audio/mp4a-latm".equals(str4)) {
                                com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(bArr4);
                                i7 = parseAudioSpecificConfig.sampleRateHz;
                                i8 = parseAudioSpecificConfig.channelCount;
                                str5 = parseAudioSpecificConfig.codecs;
                            }
                            list = com.google.common.collect.ImmutableList.of(bArr4);
                        }
                    }
                    position += readInt;
                    i11 = i2;
                    i12 = i3;
                }
                if (stsdData.b == null || str4 == null) {
                }
                stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(i8).setSampleRate(i7).setPcmEncoding(i9).setInitializationData(list).setDrmInitData(drmInitData2).setLanguage(str).build();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i9 = -1;
        java.lang.String str42 = str3;
        java.lang.String str52 = null;
        java.util.List list2 = null;
        while (position - i11 < i12) {
        }
        if (stsdData.b == null) {
        }
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox> e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        java.lang.String str = null;
        java.lang.Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = java.lang.Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(num, "frma atom is mandatory");
        com.google.android.exoplayer2.util.Assertions.checkState(i4 != -1, "schi atom is mandatory");
        return android.util.Pair.create(num, (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(r(parsableByteArray, i4, i5, str), "tenc atom is mandatory"));
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<long[], long[]> f(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) {
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g = containerAtom.g(1701606260);
        if (g == null) {
            return null;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = g.b;
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            jArr[i] = c == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = c == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new java.lang.IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return android.util.Pair.create(jArr, jArr2);
    }

    public static android.util.Pair<java.lang.String, byte[]> g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        h(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        h(parsableByteArray);
        java.lang.String mimeTypeFromMp4ObjectType = com.google.android.exoplayer2.util.MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return android.util.Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int h = h(parsableByteArray);
        byte[] bArr = new byte[h];
        parsableByteArray.readBytes(bArr, 0, h);
        return android.util.Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    public static int h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    public static int i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (parsableByteArray.getPosition() < i) {
            com.google.android.exoplayer2.metadata.Metadata.Entry c = com.google.android.exoplayer2.extractor.mp4.MetadataUtil.c(parsableByteArray);
            if (c != null) {
                arrayList.add(c);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }

    public static android.util.Pair<java.lang.Long, java.lang.String> k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        parsableByteArray.skipBytes(c == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(c == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(3);
        sb.append((char) (((readUnsignedShort >> 10) & 31) + 96));
        sb.append((char) (((readUnsignedShort >> 5) & 31) + 96));
        sb.append((char) ((readUnsignedShort & 31) + 96));
        return android.util.Pair.create(java.lang.Long.valueOf(readUnsignedInt), sb.toString());
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata l(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) {
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g = containerAtom.g(1751411826);
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g2 = containerAtom.g(1801812339);
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g3 = containerAtom.g(1768715124);
        if (g == null || g2 == null || g3 == null || i(g.b) != 1835299937) {
            return null;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = g2.b;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        java.lang.String[] strArr = new java.lang.String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = g3.b;
        parsableByteArray2.setPosition(8);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(readInt4);
                com.google.android.exoplayer2.util.Log.w("AtomParsers", sb.toString());
            } else {
                com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry f = com.google.android.exoplayer2.extractor.mp4.MetadataUtil.f(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (f != null) {
                    arrayList.add(f);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }

    public static void m(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, int i3, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            java.lang.String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i3).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    public static long n(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    public static float o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    @androidx.annotation.Nullable
    public static byte[] p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return java.util.Arrays.copyOfRange(parsableByteArray.getData(), i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox> q(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox> e;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            com.google.android.exoplayer2.util.Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382 && (e = e(parsableByteArray, position, readInt)) != null) {
                return e;
            }
            position += readInt;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, java.lang.String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (c == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x042b A[EDGE_INSN: B:97:0x042b->B:98:0x042b BREAK  A[LOOP:2: B:76:0x03cb->B:92:0x0421], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable s(com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        int c;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int i9;
        com.google.android.exoplayer2.extractor.mp4.Track track2;
        int i10;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int i11;
        int i12;
        long j;
        int[] iArr2;
        int i13;
        int i14;
        long[] jArr3;
        int i15;
        int[] iArr3;
        long j2;
        long[] jArr4;
        long[] jArr5;
        int i16;
        long[] jArr6;
        int i17;
        boolean z4;
        int[] iArr4;
        int i18;
        int[] iArr5;
        int[] iArr6;
        long[] jArr7;
        int[] iArr7;
        int i19;
        long[] jArr8;
        int i20;
        int i21;
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g = containerAtom.g(1937011578);
        if (g != null) {
            stz2SampleSizeBox = new com.google.android.exoplayer2.extractor.mp4.AtomParsers.StszSampleSizeBox(g);
        } else {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g2 = containerAtom.g(1937013298);
            if (g2 == null) {
                throw new com.google.android.exoplayer2.ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new com.google.android.exoplayer2.extractor.mp4.AtomParsers.Stz2SampleSizeBox(g2);
        }
        int b = stz2SampleSizeBox.b();
        if (b == 0) {
            return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g3 = containerAtom.g(1937007471);
        if (g3 == null) {
            g3 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1668232756));
            z = true;
        } else {
            z = false;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = g3.b;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = ((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1937011555))).b;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = ((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1937011827))).b;
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g4 = containerAtom.g(1937011571);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray4 = g4 != null ? g4.b : null;
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g5 = containerAtom.g(1668576371);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray5 = g5 != null ? g5.b : null;
        com.google.android.exoplayer2.extractor.mp4.AtomParsers.ChunkIterator chunkIterator = new com.google.android.exoplayer2.extractor.mp4.AtomParsers.ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i = parsableByteArray5.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            i2 = parsableByteArray4.readUnsignedIntToInt();
            if (i2 > 0) {
                i3 = parsableByteArray4.readUnsignedIntToInt() - 1;
                c = stz2SampleSizeBox.c();
                java.lang.String str = track.format.sampleMimeType;
                if (c == -1 && (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && readUnsignedIntToInt == 0 && i == 0 && i2 == 0)) {
                    i4 = readUnsignedIntToInt;
                    i5 = readUnsignedIntToInt2;
                    z2 = true;
                } else {
                    i4 = readUnsignedIntToInt;
                    i5 = readUnsignedIntToInt2;
                    z2 = false;
                }
                if (z2) {
                    long[] jArr9 = new long[b];
                    int[] iArr8 = new int[b];
                    long[] jArr10 = new long[b];
                    int[] iArr9 = new int[b];
                    int i22 = i3;
                    int i23 = 0;
                    int i24 = 0;
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    long j3 = 0;
                    long j4 = 0;
                    int i28 = i;
                    int i29 = readUnsignedIntToInt3;
                    int i30 = i5;
                    while (true) {
                        if (i23 >= b) {
                            i6 = i30;
                            i7 = i25;
                            i8 = i26;
                            break;
                        }
                        long j5 = j4;
                        int i31 = i26;
                        boolean z5 = true;
                        while (i31 == 0) {
                            z5 = chunkIterator.a();
                            if (!z5) {
                                break;
                            }
                            int i32 = i30;
                            long j6 = chunkIterator.d;
                            i31 = chunkIterator.c;
                            j5 = j6;
                            i30 = i32;
                            i29 = i29;
                            b = b;
                        }
                        int i33 = b;
                        i6 = i30;
                        int i34 = i29;
                        if (!z5) {
                            com.google.android.exoplayer2.util.Log.w("AtomParsers", "Unexpected end of chunk data");
                            jArr9 = java.util.Arrays.copyOf(jArr9, i23);
                            iArr8 = java.util.Arrays.copyOf(iArr8, i23);
                            jArr10 = java.util.Arrays.copyOf(jArr10, i23);
                            iArr9 = java.util.Arrays.copyOf(iArr9, i23);
                            b = i23;
                            i7 = i25;
                            i8 = i31;
                            break;
                        }
                        if (parsableByteArray5 != null) {
                            while (i27 == 0 && i28 > 0) {
                                i27 = parsableByteArray5.readUnsignedIntToInt();
                                i25 = parsableByteArray5.readInt();
                                i28--;
                            }
                            i27--;
                        }
                        int i35 = i25;
                        jArr9[i23] = j5;
                        int a2 = stz2SampleSizeBox.a();
                        iArr8[i23] = a2;
                        if (a2 > i24) {
                            i24 = a2;
                        }
                        jArr10[i23] = j3 + i35;
                        iArr9[i23] = parsableByteArray4 == null ? 1 : 0;
                        if (i23 == i22) {
                            iArr9[i23] = 1;
                            i2--;
                            if (i2 > 0) {
                                i22 = ((com.google.android.exoplayer2.util.ParsableByteArray) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                            }
                        }
                        int i36 = i22;
                        j3 += i34;
                        int i37 = i6 - 1;
                        if (i37 != 0 || i4 <= 0) {
                            i13 = i34;
                            i14 = i4;
                        } else {
                            i37 = parsableByteArray3.readUnsignedIntToInt();
                            i13 = parsableByteArray3.readInt();
                            i14 = i4 - 1;
                        }
                        int i38 = i37;
                        long j7 = j5 + iArr8[i23];
                        i26 = i31 - 1;
                        i23++;
                        j4 = j7;
                        i22 = i36;
                        i29 = i13;
                        b = i33;
                        i25 = i35;
                        int i39 = i14;
                        i30 = i38;
                        i4 = i39;
                    }
                    long j8 = j3 + i7;
                    if (parsableByteArray5 != null) {
                        while (i28 > 0) {
                            if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                                z3 = false;
                                break;
                            }
                            parsableByteArray5.readInt();
                            i28--;
                        }
                    }
                    z3 = true;
                    if (i2 == 0 && i6 == 0 && i8 == 0 && i4 == 0) {
                        i9 = i27;
                        if (i9 == 0 && z3) {
                            track2 = track;
                            i10 = b;
                            jArr = jArr9;
                            iArr = iArr8;
                            jArr2 = jArr10;
                            i11 = i24;
                            i12 = i10;
                            j = j8;
                            iArr2 = iArr9;
                        }
                    } else {
                        i9 = i27;
                    }
                    track2 = track;
                    int i40 = track2.id;
                    java.lang.String str2 = !z3 ? ", ctts invalid" : "";
                    i10 = b;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(str2.length() + 262);
                    sb.append("Inconsistent stbl box for track ");
                    sb.append(i40);
                    sb.append(": remainingSynchronizationSamples ");
                    sb.append(i2);
                    sb.append(", remainingSamplesAtTimestampDelta ");
                    sb.append(i6);
                    sb.append(", remainingSamplesInChunk ");
                    sb.append(i8);
                    sb.append(", remainingTimestampDeltaChanges ");
                    sb.append(i4);
                    sb.append(", remainingSamplesAtTimestampOffset ");
                    sb.append(i9);
                    sb.append(str2);
                    com.google.android.exoplayer2.util.Log.w("AtomParsers", sb.toString());
                    jArr = jArr9;
                    iArr = iArr8;
                    jArr2 = jArr10;
                    i11 = i24;
                    i12 = i10;
                    j = j8;
                    iArr2 = iArr9;
                } else {
                    int i41 = chunkIterator.a;
                    long[] jArr11 = new long[i41];
                    int[] iArr10 = new int[i41];
                    while (chunkIterator.a()) {
                        int i42 = chunkIterator.b;
                        jArr11[i42] = chunkIterator.d;
                        iArr10[i42] = chunkIterator.c;
                    }
                    com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.Results a3 = com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.a(c, jArr11, iArr10, readUnsignedIntToInt3);
                    long[] jArr12 = a3.offsets;
                    int[] iArr11 = a3.sizes;
                    i11 = a3.maximumSize;
                    long[] jArr13 = a3.timestamps;
                    int[] iArr12 = a3.flags;
                    long j9 = a3.duration;
                    i12 = b;
                    jArr = jArr12;
                    iArr = iArr11;
                    jArr2 = jArr13;
                    iArr2 = iArr12;
                    j = j9;
                    track2 = track;
                }
                long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
                jArr3 = track2.editListDurations;
                if (jArr3 != null) {
                    com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, jArr, iArr, i11, jArr2, iArr2, scaleLargeTimestamp);
                }
                if (jArr3.length == 1 && track2.type == 1 && jArr2.length >= 2) {
                    long j10 = ((long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(track2.editListMediaTimes))[0];
                    long scaleLargeTimestamp2 = j10 + com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
                    i15 = i12;
                    if (a(jArr2, j, j10, scaleLargeTimestamp2)) {
                        long scaleLargeTimestamp3 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j10 - jArr2[0], track2.format.sampleRate, track2.timescale);
                        iArr3 = iArr2;
                        j2 = j;
                        long scaleLargeTimestamp4 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j - scaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                        if ((scaleLargeTimestamp3 != 0 || scaleLargeTimestamp4 != 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                            gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                            gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                            return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, jArr, iArr, i11, jArr2, iArr3, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                        }
                        jArr4 = track2.editListDurations;
                        if (jArr4.length != 1 && jArr4[0] == 0) {
                            long j11 = ((long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(track2.editListMediaTimes))[0];
                            for (int i43 = 0; i43 < jArr2.length; i43++) {
                                jArr2[i43] = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(jArr2[i43] - j11, 1000000L, track2.timescale);
                            }
                            return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, jArr, iArr, i11, jArr2, iArr3, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2 - j11, 1000000L, track2.timescale));
                        }
                        boolean z6 = track2.type != 1;
                        int[] iArr13 = new int[jArr4.length];
                        int[] iArr14 = new int[jArr4.length];
                        jArr5 = (long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(track2.editListMediaTimes);
                        i16 = 0;
                        boolean z7 = false;
                        int i44 = 0;
                        int i45 = 0;
                        while (true) {
                            jArr6 = track2.editListDurations;
                            if (i16 < jArr6.length) {
                                break;
                            }
                            long j12 = jArr5[i16];
                            if (j12 != -1) {
                                long j13 = jArr6[i16];
                                i19 = i11;
                                jArr8 = jArr5;
                                jArr7 = jArr;
                                iArr7 = iArr;
                                long scaleLargeTimestamp5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j13, track2.timescale, track2.movieTimescale);
                                iArr13[i16] = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr2, j12, true, true);
                                iArr14[i16] = com.google.android.exoplayer2.util.Util.binarySearchCeil(jArr2, j12 + scaleLargeTimestamp5, z6, false);
                                while (true) {
                                    i20 = iArr13[i16];
                                    i21 = iArr14[i16];
                                    if (i20 >= i21 || (iArr3[i20] & 1) != 0) {
                                        break;
                                    }
                                    iArr13[i16] = i20 + 1;
                                }
                                i44 += i21 - i20;
                                z7 = (i45 != i20) | z7;
                                i45 = i21;
                            } else {
                                jArr7 = jArr;
                                iArr7 = iArr;
                                i19 = i11;
                                jArr8 = jArr5;
                            }
                            i16++;
                            jArr5 = jArr8;
                            i11 = i19;
                            jArr = jArr7;
                            iArr = iArr7;
                        }
                        long[] jArr14 = jArr;
                        int[] iArr15 = iArr;
                        int i46 = i11;
                        i17 = 0;
                        z4 = z7 | (i44 == i15);
                        long[] jArr15 = !z4 ? new long[i44] : jArr14;
                        int[] iArr16 = !z4 ? new int[i44] : iArr15;
                        if (z4) {
                            i46 = 0;
                        }
                        int[] iArr17 = !z4 ? new int[i44] : iArr3;
                        long[] jArr16 = new long[i44];
                        int i47 = 0;
                        long j14 = 0;
                        while (i17 < track2.editListDurations.length) {
                            long j15 = track2.editListMediaTimes[i17];
                            int i48 = iArr13[i17];
                            int i49 = iArr14[i17];
                            int[] iArr18 = iArr14;
                            if (z4) {
                                int i50 = i49 - i48;
                                iArr4 = iArr13;
                                java.lang.System.arraycopy(jArr14, i48, jArr15, i47, i50);
                                iArr5 = iArr15;
                                java.lang.System.arraycopy(iArr5, i48, iArr16, i47, i50);
                                i18 = i46;
                                iArr6 = iArr3;
                                java.lang.System.arraycopy(iArr6, i48, iArr17, i47, i50);
                            } else {
                                iArr4 = iArr13;
                                i18 = i46;
                                iArr5 = iArr15;
                                iArr6 = iArr3;
                            }
                            int i51 = i18;
                            while (i48 < i49) {
                                int[] iArr19 = iArr5;
                                int i52 = i17;
                                long[] jArr17 = jArr2;
                                long[] jArr18 = jArr15;
                                long j16 = j14;
                                jArr16[i47] = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j14, 1000000L, track2.movieTimescale) + com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(java.lang.Math.max(0L, jArr2[i48] - j15), 1000000L, track2.timescale);
                                if (z4 && iArr16[i47] > i51) {
                                    i51 = iArr19[i48];
                                }
                                i47++;
                                i48++;
                                i17 = i52;
                                j14 = j16;
                                jArr2 = jArr17;
                                iArr5 = iArr19;
                                jArr15 = jArr18;
                            }
                            int[] iArr20 = iArr5;
                            int i53 = i17;
                            j14 += track2.editListDurations[i53];
                            i17 = i53 + 1;
                            iArr3 = iArr6;
                            jArr2 = jArr2;
                            iArr13 = iArr4;
                            iArr15 = iArr20;
                            jArr15 = jArr15;
                            i46 = i51;
                            iArr14 = iArr18;
                        }
                        return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, jArr15, iArr16, i46, jArr16, iArr17, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j14, 1000000L, track2.movieTimescale));
                    }
                } else {
                    i15 = i12;
                }
                iArr3 = iArr2;
                j2 = j;
                jArr4 = track2.editListDurations;
                if (jArr4.length != 1) {
                }
                if (track2.type != 1) {
                }
                int[] iArr132 = new int[jArr4.length];
                int[] iArr142 = new int[jArr4.length];
                jArr5 = (long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(track2.editListMediaTimes);
                i16 = 0;
                boolean z72 = false;
                int i442 = 0;
                int i452 = 0;
                while (true) {
                    jArr6 = track2.editListDurations;
                    if (i16 < jArr6.length) {
                    }
                    i16++;
                    jArr5 = jArr8;
                    i11 = i19;
                    jArr = jArr7;
                    iArr = iArr7;
                }
                long[] jArr142 = jArr;
                int[] iArr152 = iArr;
                int i462 = i11;
                i17 = 0;
                z4 = z72 | (i442 == i15);
                if (!z4) {
                }
                if (!z4) {
                }
                if (z4) {
                }
                if (!z4) {
                }
                long[] jArr162 = new long[i442];
                int i472 = 0;
                long j142 = 0;
                while (i17 < track2.editListDurations.length) {
                }
                return new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(track, jArr15, iArr16, i462, jArr162, iArr17, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j142, 1000000L, track2.movieTimescale));
            }
            parsableByteArray4 = null;
        } else {
            i2 = 0;
        }
        i3 = -1;
        c = stz2SampleSizeBox.c();
        java.lang.String str3 = track.format.sampleMimeType;
        if (c == -1) {
        }
        i4 = readUnsignedIntToInt;
        i5 = readUnsignedIntToInt2;
        z2 = false;
        if (z2) {
        }
        long scaleLargeTimestamp6 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        jArr3 = track2.editListDurations;
        if (jArr3 != null) {
        }
    }

    public static com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData t(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, boolean z) throws com.google.android.exoplayer2.ParserException {
        int i3;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData stsdData = new com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            com.google.android.exoplayer2.util.Assertions.checkState(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                i3 = position;
                A(parsableByteArray, readInt3, i3, readInt2, i, i2, drmInitData, stsdData, i4);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                i3 = position;
                d(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i4);
            } else {
                if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                    u(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
                } else if (readInt3 == 1835365492) {
                    m(parsableByteArray, readInt3, position, i, stsdData);
                } else if (readInt3 == 1667329389) {
                    stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
                }
                i3 = position;
            }
            parsableByteArray.setPosition(i3 + readInt2);
        }
        return stsdData;
    }

    public static void u(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, java.lang.String str, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        java.lang.String str2 = "application/ttml+xml";
        com.google.common.collect.ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableList = com.google.common.collect.ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else {
                if (i != 1664495672) {
                    throw new java.lang.IllegalStateException();
                }
                stsdData.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        stsdData.b = new com.google.android.exoplayer2.Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableList).build();
    }

    public static com.google.android.exoplayer2.extractor.mp4.AtomParsers.TkhdData v(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        boolean z;
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        parsableByteArray.skipBytes(c == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i = c == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            }
            if (parsableByteArray.getData()[position + i3] != -1) {
                z = false;
                break;
            }
            i3++;
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = c == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new com.google.android.exoplayer2.extractor.mp4.AtomParsers.TkhdData(readInt, j, i2);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.Track w(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom, long j, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, boolean z, boolean z2) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom2;
        long j2;
        long[] jArr;
        long[] jArr2;
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom f;
        android.util.Pair<long[], long[]> f2;
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.f(1835297121));
        int c = c(i(((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom2.g(1751411826))).b));
        if (c == -1) {
            return null;
        }
        com.google.android.exoplayer2.extractor.mp4.AtomParsers.TkhdData v = v(((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1953196132))).b);
        if (j == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j2 = v.b;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long n = n(leafAtom2.b);
        long scaleLargeTimestamp = j2 != -9223372036854775807L ? com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, n) : -9223372036854775807L;
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom3 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(((com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom2.f(1835626086))).f(1937007212));
        android.util.Pair<java.lang.Long, java.lang.String> k = k(((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom2.g(1835296868))).b);
        com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData t = t(((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom3.g(1937011556))).b, v.a, v.c, (java.lang.String) k.second, drmInitData, z2);
        if (z || (f = containerAtom.f(1701082227)) == null || (f2 = f(f)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) f2.first;
            jArr2 = (long[]) f2.second;
            jArr = jArr3;
        }
        if (t.b == null) {
            return null;
        }
        return new com.google.android.exoplayer2.extractor.mp4.Track(v.a, c, ((java.lang.Long) k.first).longValue(), n, scaleLargeTimestamp, t.b, t.d, t.a, t.c, jArr, jArr2);
    }

    public static java.util.List<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> x(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder, long j, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, boolean z, boolean z2, com.google.common.base.Function<com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Track> function) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.Track apply;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < containerAtom.d.size(); i++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = containerAtom.d.get(i);
            if (containerAtom2.a == 1953653099 && (apply = function.apply(w(containerAtom2, (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(s(apply, (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(((com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(((com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom2.f(1835297121))).f(1835626086))).f(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata y(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = leafAtom.b;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1835365473) {
                parsableByteArray.setPosition(position);
                return z(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata z(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return j(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }
}
