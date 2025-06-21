package okio;

/* loaded from: classes24.dex */
final class Util {
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    private Util() {
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("size=%s offset=%s byteCount=%s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3)));
        }
    }

    public static int reverseBytesInt(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static long reverseBytesLong(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static short reverseBytesShort(short s2) {
        int i = s2 & kotlin.UShort.MAX_VALUE;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static void sneakyRethrow(java.lang.Throwable th) {
        sneakyThrow2(th);
    }

    private static <T extends java.lang.Throwable> void sneakyThrow2(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }
}
