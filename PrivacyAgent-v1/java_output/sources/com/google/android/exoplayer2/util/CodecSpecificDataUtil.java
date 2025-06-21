package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class CodecSpecificDataUtil {
    public static final byte[] a = {0, 0, 0, 1};

    public static int a(byte[] bArr, int i) {
        int length = bArr.length - a.length;
        while (i <= length) {
            if (b(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean b(byte[] bArr, int i) {
        if (bArr.length - i <= a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    public static java.lang.String buildAvcCodecString(int i, int i2, int i3) {
        return java.lang.String.format("avc1.%02X%02X%02X", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
    }

    public static java.util.List<byte[]> buildCea708InitializationData(boolean z) {
        return java.util.Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static byte[] buildNalUnit(byte[] bArr, int i, int i2) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        java.lang.System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    public static android.util.Pair<java.lang.Integer, java.lang.Integer> parseAlacAudioSpecificConfig(byte[] bArr) {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return android.util.Pair.create(java.lang.Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), java.lang.Integer.valueOf(readUnsignedByte));
    }

    public static boolean parseCea708InitializationData(java.util.List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    @androidx.annotation.Nullable
    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!b(bArr, 0)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        do {
            arrayList.add(java.lang.Integer.valueOf(i));
            i = a(bArr, i + a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((java.lang.Integer) arrayList.get(i2)).intValue();
            int intValue2 = (i2 < arrayList.size() + (-1) ? ((java.lang.Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            java.lang.System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i2] = bArr3;
            i2++;
        }
        return bArr2;
    }
}
