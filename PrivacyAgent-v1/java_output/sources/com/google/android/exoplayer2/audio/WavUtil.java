package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class WavUtil {
    public static final int DATA_FOURCC = 1684108385;
    public static final int FMT_FOURCC = 1718449184;
    public static final int RIFF_FOURCC = 1380533830;
    public static final int TYPE_ALAW = 6;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_IMA_ADPCM = 17;
    public static final int TYPE_MLAW = 7;
    public static final int TYPE_PCM = 1;
    public static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int WAVE_FOURCC = 1463899717;

    public static int getPcmEncodingForType(int i, int i2) {
        if (i != 1) {
            if (i == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (i != 65534) {
                return 0;
            }
        }
        return com.google.android.exoplayer2.util.Util.getPcmEncoding(i2);
    }

    public static int getTypeForPcmEncoding(int i) {
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 536870912 || i == 805306368) {
            return 1;
        }
        throw new java.lang.IllegalArgumentException();
    }
}
