package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class DtsUtil {
    public static final int DTS_HD_MAX_RATE_BYTES_PER_SECOND = 2250000;
    public static final int DTS_MAX_RATE_BYTES_PER_SECOND = 192000;
    public static final int[] a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int[] b = {-1, 8000, com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, -1, -1};
    public static final int[] c = {64, 112, 128, 192, 224, 256, 384, com.anythink.expressad.foundation.h.m.a.a, 512, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, com.badlogic.gdx.graphics.GL30.GL_COLOR, com.badlogic.gdx.graphics.GL20.GL_KEEP};

    public static com.google.android.exoplayer2.util.ParsableBitArray a(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.google.android.exoplayer2.util.ParsableBitArray(bArr);
        }
        byte[] copyOf = java.util.Arrays.copyOf(bArr, bArr.length);
        if (b(copyOf)) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b2 = copyOf[i];
                int i2 = i + 1;
                copyOf[i] = copyOf[i2];
                copyOf[i2] = b2;
            }
        }
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray2 = new com.google.android.exoplayer2.util.ParsableBitArray(copyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(copyOf);
        return parsableBitArray;
    }

    public static boolean b(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getDtsFrameSize(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        int i3;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i3 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b3 = bArr[9];
            } else if (b4 != 31) {
                i = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[7];
            } else {
                i3 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b3 = bArr[8];
            }
            i2 = (((b3 & 60) >> 2) | i3) + 1;
            z = true;
            return !z ? (i2 * 16) / 14 : i2;
        }
        i = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b2 = bArr[6];
        i2 = (((b2 & 240) >> 4) | i) + 1;
        if (!z) {
        }
    }

    public static boolean isSyncWord(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static int parseDtsAudioSampleCount(java.nio.ByteBuffer byteBuffer) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                i = (byteBuffer.get(position + 4) & 7) << 4;
                b3 = byteBuffer.get(position + 7);
            } else if (b4 != 31) {
                i = (byteBuffer.get(position + 4) & 1) << 6;
                b2 = byteBuffer.get(position + 5);
            } else {
                i = (byteBuffer.get(position + 5) & 7) << 4;
                b3 = byteBuffer.get(position + 6);
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (byteBuffer.get(position + 5) & 1) << 6;
        b2 = byteBuffer.get(position + 4);
        i2 = b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.warn;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.warn;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static com.google.android.exoplayer2.Format parseDtsFormat(byte[] bArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        com.google.android.exoplayer2.util.ParsableBitArray a2 = a(bArr);
        a2.skipBits(60);
        int i = a[a2.readBits(6)];
        int i2 = b[a2.readBits(4)];
        int readBits = a2.readBits(5);
        int[] iArr = c;
        int i3 = readBits >= iArr.length ? -1 : (iArr[readBits] * 1000) / 2;
        a2.skipBits(10);
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType("audio/vnd.dts").setAverageBitrate(i3).setChannelCount(i + (a2.readBits(2) > 0 ? 1 : 0)).setSampleRate(i2).setDrmInitData(drmInitData).setLanguage(str2).build();
    }
}
