package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class TsUtil {
    public static long a(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }

    public static int findSyncBytePosition(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long readPcrFromPacket(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.setPosition(i);
        if (parsableByteArray.bytesLeft() < 5) {
            return -9223372036854775807L;
        }
        int readInt = parsableByteArray.readInt();
        if ((8388608 & readInt) != 0 || ((2096896 & readInt) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((readInt & 32) != 0) && parsableByteArray.readUnsignedByte() >= 7 && parsableByteArray.bytesLeft() >= 7) {
            if ((parsableByteArray.readUnsignedByte() & 16) == 16) {
                byte[] bArr = new byte[6];
                parsableByteArray.readBytes(bArr, 0, 6);
                return a(bArr);
            }
        }
        return -9223372036854775807L;
    }
}
