package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class DefaultTsPayloadReaderFactory implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory {
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    public final int a;
    public final java.util.List<com.google.android.exoplayer2.Format> b;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, com.google.common.collect.ImmutableList.of());
    }

    public DefaultTsPayloadReaderFactory(int i, java.util.List<com.google.android.exoplayer2.Format> list) {
        this.a = i;
        this.b = list;
    }

    public final com.google.android.exoplayer2.extractor.ts.SeiReader a(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        return new com.google.android.exoplayer2.extractor.ts.SeiReader(c(esInfo));
    }

    public final com.google.android.exoplayer2.extractor.ts.UserDataReader b(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        return new com.google.android.exoplayer2.extractor.ts.UserDataReader(c(esInfo));
    }

    public final java.util.List<com.google.android.exoplayer2.Format> c(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        java.lang.String str;
        int i;
        if (d(32)) {
            return this.b;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(esInfo.descriptorBytes);
        java.util.List<com.google.android.exoplayer2.Format> list = this.b;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                list = new java.util.ArrayList<>();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    java.lang.String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = (readUnsignedByte3 & 128) != 0;
                    if (z) {
                        i = readUnsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte readUnsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    list.add(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(str).setLanguage(readString).setAccessibilityChannel(i).setInitializationData(z ? com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildCea708InitializationData((readUnsignedByte4 & com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO) != 0) : null).build());
                }
            }
            parsableByteArray.setPosition(position);
        }
        return list;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> createInitialPayloadReaders() {
        return new android.util.SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ts.TsPayloadReader createPayloadReader(int i, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        if (i == 2) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H262Reader(b(esInfo)));
        }
        if (i == 3 || i == 4) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.MpegAudioReader(esInfo.language));
        }
        if (i == 21) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Id3Reader());
        }
        if (i == 27) {
            if (d(4)) {
                return null;
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H264Reader(a(esInfo), d(1), d(8)));
        }
        if (i == 36) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H265Reader(a(esInfo)));
        }
        if (i == 89) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.DvbSubtitleReader(esInfo.dvbSubtitleInfos));
        }
        if (i != 138) {
            if (i == 172) {
                return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Ac4Reader(esInfo.language));
            }
            if (i == 257) {
                return new com.google.android.exoplayer2.extractor.ts.SectionReader(new com.google.android.exoplayer2.extractor.ts.PassthroughSectionPayloadReader(com.google.android.exoplayer2.util.MimeTypes.APPLICATION_AIT));
            }
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (d(16)) {
                            return null;
                        }
                        return new com.google.android.exoplayer2.extractor.ts.SectionReader(new com.google.android.exoplayer2.extractor.ts.PassthroughSectionPayloadReader("application/x-scte35"));
                    }
                    if (i != 135) {
                        switch (i) {
                            case 15:
                                if (d(2)) {
                                    return null;
                                }
                                return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.AdtsReader(false, esInfo.language));
                            case 16:
                                return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H263Reader(b(esInfo)));
                            case 17:
                                if (d(2)) {
                                    return null;
                                }
                                return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.LatmReader(esInfo.language));
                            default:
                                return null;
                        }
                    }
                } else if (!d(64)) {
                    return null;
                }
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Ac3Reader(esInfo.language));
        }
        return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.DtsReader(esInfo.language));
    }

    public final boolean d(int i) {
        return (i & this.a) != 0;
    }
}
