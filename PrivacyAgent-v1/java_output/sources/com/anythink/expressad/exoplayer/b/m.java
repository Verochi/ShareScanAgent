package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class m {
    private static final int a = 2147385345;
    private static final int b = 536864768;
    private static final int c = -25230976;
    private static final int d = -14745368;
    private static final byte e = Byte.MAX_VALUE;
    private static final byte f = 31;
    private static final byte g = -2;
    private static final byte h = -1;
    private static final int[] i = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] j = {-1, 8000, com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, -1, -1};
    private static final int[] k = {64, 112, 128, 192, 224, 256, 384, com.anythink.expressad.foundation.h.m.a.a, 512, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, com.badlogic.gdx.graphics.GL30.GL_COLOR, com.badlogic.gdx.graphics.GL20.GL_KEEP};

    private m() {
    }

    public static int a(java.nio.ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(position + 4) & 7) << 4;
                b3 = byteBuffer.get(position + 7);
            } else if (b4 != 31) {
                i2 = (byteBuffer.get(position + 4) & 1) << 6;
                b2 = byteBuffer.get(position + 5);
            } else {
                i2 = (byteBuffer.get(position + 5) & 7) << 4;
                b3 = byteBuffer.get(position + 6);
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (byteBuffer.get(position + 5) & 1) << 6;
        b2 = byteBuffer.get(position + 4);
        i3 = b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.warn;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static int a(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.warn;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static com.anythink.expressad.exoplayer.m a(byte[] bArr, java.lang.String str, java.lang.String str2, com.anythink.expressad.exoplayer.d.e eVar) {
        com.anythink.expressad.exoplayer.k.r rVar;
        if (bArr[0] == Byte.MAX_VALUE) {
            rVar = new com.anythink.expressad.exoplayer.k.r(bArr);
        } else {
            byte[] copyOf = java.util.Arrays.copyOf(bArr, bArr.length);
            byte b2 = copyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                    byte b3 = copyOf[i2];
                    int i3 = i2 + 1;
                    copyOf[i2] = copyOf[i3];
                    copyOf[i3] = b3;
                }
            }
            rVar = new com.anythink.expressad.exoplayer.k.r(copyOf);
            if (copyOf[0] == 31) {
                com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(copyOf);
                while (rVar2.a() >= 16) {
                    rVar2.b(2);
                    rVar.d(rVar2.c(14));
                }
            }
            rVar.a(copyOf, copyOf.length);
        }
        rVar.b(60);
        int i4 = i[rVar.c(6)];
        int i5 = j[rVar.c(4)];
        int c2 = rVar.c(5);
        int[] iArr = k;
        int i6 = c2 >= iArr.length ? -1 : (iArr[c2] * 1000) / 2;
        rVar.b(10);
        return com.anythink.expressad.exoplayer.m.a(str, "audio/vnd.dts", null, i6, i4 + (rVar.c(2) > 0 ? 1 : 0), i5, null, eVar, str2);
    }

    private static boolean a(int i2) {
        return i2 == a || i2 == c || i2 == b || i2 == d;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int b(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        int i4;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i4 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b3 = bArr[9];
            } else if (b4 != 31) {
                i2 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[7];
            } else {
                i4 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b3 = bArr[8];
            }
            i3 = (((b3 & 60) >> 2) | i4) + 1;
            z = true;
            return !z ? (i3 * 16) / 14 : i3;
        }
        i2 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b2 = bArr[6];
        i3 = (((b2 & 240) >> 4) | i2) + 1;
        if (!z) {
        }
    }

    private static com.anythink.expressad.exoplayer.k.r c(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.anythink.expressad.exoplayer.k.r(bArr);
        }
        byte[] copyOf = java.util.Arrays.copyOf(bArr, bArr.length);
        byte b2 = copyOf[0];
        if (b2 == -2 || b2 == -1) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte b3 = copyOf[i2];
                int i3 = i2 + 1;
                copyOf[i2] = copyOf[i3];
                copyOf[i3] = b3;
            }
        }
        com.anythink.expressad.exoplayer.k.r rVar = new com.anythink.expressad.exoplayer.k.r(copyOf);
        if (copyOf[0] == 31) {
            com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(copyOf);
            while (rVar2.a() >= 16) {
                rVar2.b(2);
                rVar.d(rVar2.c(14));
            }
        }
        rVar.a(copyOf, copyOf.length);
        return rVar;
    }

    private static boolean d(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }
}
