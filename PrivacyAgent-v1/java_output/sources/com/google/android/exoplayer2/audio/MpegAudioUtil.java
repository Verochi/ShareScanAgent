package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class MpegAudioUtil {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public static final java.lang.String[] a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    public static final int[] b = {44100, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON};
    public static final int[] c = {com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, 64000, 96000, 128000, 160000, com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, com.google.android.exoplayer2.audio.AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};
    public static final int[] d = {com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, com.google.android.exoplayer2.audio.AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};
    public static final int[] e = {com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 160000, com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, com.google.android.exoplayer2.audio.AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};
    public static final int MAX_RATE_BYTES_PER_SECOND = 40000;
    public static final int[] f = {com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, MAX_RATE_BYTES_PER_SECOND, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 160000, com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, com.google.android.exoplayer2.audio.AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};
    public static final int[] g = {8000, com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 24000, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, MAX_RATE_BYTES_PER_SECOND, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class Header {
        public int bitrate;
        public int channels;
        public int frameSize;

        @androidx.annotation.Nullable
        public java.lang.String mimeType;
        public int sampleRate;
        public int samplesPerFrame;
        public int version;

        public boolean setForHeaderData(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!com.google.android.exoplayer2.audio.MpegAudioUtil.k(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.version = i2;
            this.mimeType = com.google.android.exoplayer2.audio.MpegAudioUtil.a[3 - i3];
            int i6 = com.google.android.exoplayer2.audio.MpegAudioUtil.b[i5];
            this.sampleRate = i6;
            if (i2 == 2) {
                this.sampleRate = i6 / 2;
            } else if (i2 == 0) {
                this.sampleRate = i6 / 4;
            }
            int i7 = (i >>> 9) & 1;
            this.samplesPerFrame = com.google.android.exoplayer2.audio.MpegAudioUtil.j(i2, i3);
            if (i3 == 3) {
                int i8 = i2 == 3 ? com.google.android.exoplayer2.audio.MpegAudioUtil.c[i4 - 1] : com.google.android.exoplayer2.audio.MpegAudioUtil.d[i4 - 1];
                this.bitrate = i8;
                this.frameSize = (((i8 * 12) / this.sampleRate) + i7) * 4;
            } else {
                if (i2 == 3) {
                    int i9 = i3 == 2 ? com.google.android.exoplayer2.audio.MpegAudioUtil.e[i4 - 1] : com.google.android.exoplayer2.audio.MpegAudioUtil.f[i4 - 1];
                    this.bitrate = i9;
                    this.frameSize = ((i9 * 144) / this.sampleRate) + i7;
                } else {
                    int i10 = com.google.android.exoplayer2.audio.MpegAudioUtil.g[i4 - 1];
                    this.bitrate = i10;
                    this.frameSize = (((i3 == 1 ? 72 : 144) * i10) / this.sampleRate) + i7;
                }
            }
            this.channels = ((i >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int getFrameSize(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!k(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = b[i5];
        if (i2 == 2) {
            i6 /= 2;
        } else if (i2 == 0) {
            i6 /= 4;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? c[i4 - 1] : d[i4 - 1]) * 12) / i6) + i7) * 4;
        }
        int i8 = i2 == 3 ? i3 == 2 ? e[i4 - 1] : f[i4 - 1] : g[i4 - 1];
        if (i2 == 3) {
            return ((i8 * 144) / i6) + i7;
        }
        return (((i3 == 1 ? 72 : 144) * i8) / i6) + i7;
    }

    public static int j(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static boolean k(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int parseMpegAudioFrameSampleCount(int i) {
        int i2;
        int i3;
        if (!k(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return j(i2, i3);
    }
}
