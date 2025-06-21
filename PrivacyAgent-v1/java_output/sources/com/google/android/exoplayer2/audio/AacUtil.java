package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class AacUtil {
    public static final int AAC_ELD_MAX_RATE_BYTES_PER_SECOND = 8000;
    public static final int AAC_HE_AUDIO_SAMPLE_COUNT = 2048;
    public static final int AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND = 7000;
    public static final int AAC_LC_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_LC_MAX_RATE_BYTES_PER_SECOND = 100000;
    public static final int AAC_LD_AUDIO_SAMPLE_COUNT = 512;
    public static final int AAC_XHE_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_XHE_MAX_RATE_BYTES_PER_SECOND = 256000;
    public static final int AUDIO_OBJECT_TYPE_AAC_ELD = 23;
    public static final int AUDIO_OBJECT_TYPE_AAC_ER_BSAC = 22;
    public static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    public static final int AUDIO_OBJECT_TYPE_AAC_PS = 29;
    public static final int AUDIO_OBJECT_TYPE_AAC_SBR = 5;
    public static final int AUDIO_OBJECT_TYPE_AAC_XHE = 42;
    public static final int AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND = 16000;
    public static final int[] a = {96000, 88200, 64000, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 44100, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, 24000, 22050, AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};
    public static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AacAudioObjectType {
    }

    public static final class Config {
        public final int channelCount;
        public final java.lang.String codecs;
        public final int sampleRateHz;

        public Config(int i, int i2, java.lang.String str) {
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.codecs = str;
        }

        public /* synthetic */ Config(int i, int i2, java.lang.String str, com.google.android.exoplayer2.audio.AacUtil.AnonymousClass1 anonymousClass1) {
            this(i, i2, str);
        }
    }

    public static int a(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(5);
        return readBits == 31 ? parsableBitArray.readBits(6) + 32 : readBits;
    }

    public static int b(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(readBits < 13);
        return a[readBits];
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = a;
            if (i4 >= iArr.length) {
                break;
            }
            if (i == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = b;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (i != -1 && i6 != -1) {
            return buildAudioSpecificConfig(2, i5, i6);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(67);
        sb.append("Invalid sample rate or number of channels: ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    public static byte[] buildAudioSpecificConfig(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static void c(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i, int i2) {
        if (parsableBitArray.readBit()) {
            com.google.android.exoplayer2.util.Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean readBit = parsableBitArray.readBit();
        if (i2 == 0) {
            throw new java.lang.UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            parsableBitArray.skipBits(3);
        }
        if (readBit) {
            if (i == 22) {
                parsableBitArray.skipBits(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                parsableBitArray.skipBits(3);
            }
            parsableBitArray.skipBits(1);
        }
    }

    public static int getEncodingForAudioObjectType(int i) {
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public static com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, boolean z) throws com.google.android.exoplayer2.ParserException {
        int a2 = a(parsableBitArray);
        int b2 = b(parsableBitArray);
        int readBits = parsableBitArray.readBits(4);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(19);
        sb.append("mp4a.40.");
        sb.append(a2);
        java.lang.String sb2 = sb.toString();
        if (a2 == 5 || a2 == 29) {
            b2 = b(parsableBitArray);
            a2 = a(parsableBitArray);
            if (a2 == 22) {
                readBits = parsableBitArray.readBits(4);
            }
        }
        if (z) {
            if (a2 != 1 && a2 != 2 && a2 != 3 && a2 != 4 && a2 != 6 && a2 != 7 && a2 != 17) {
                switch (a2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder(42);
                        sb3.append("Unsupported audio object type: ");
                        sb3.append(a2);
                        throw new com.google.android.exoplayer2.ParserException(sb3.toString());
                }
            }
            c(parsableBitArray, a2, readBits);
            switch (a2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int readBits2 = parsableBitArray.readBits(2);
                    if (readBits2 == 2 || readBits2 == 3) {
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder(33);
                        sb4.append("Unsupported epConfig: ");
                        sb4.append(readBits2);
                        throw new com.google.android.exoplayer2.ParserException(sb4.toString());
                    }
            }
        }
        int i = b[readBits];
        com.google.android.exoplayer2.util.Assertions.checkArgument(i != -1);
        return new com.google.android.exoplayer2.audio.AacUtil.Config(b2, i, sb2, null);
    }

    public static com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        return parseAudioSpecificConfig(new com.google.android.exoplayer2.util.ParsableBitArray(bArr), false);
    }
}
