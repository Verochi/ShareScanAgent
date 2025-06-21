package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public class OpusUtil {
    public static final int SAMPLE_RATE = 48000;

    public static byte[] a(long j) {
        return java.nio.ByteBuffer.allocate(8).order(java.nio.ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static int b(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static java.util.List<byte[]> buildInitializationData(byte[] bArr) {
        long d = d(b(bArr));
        long d2 = d(3840L);
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(a(d));
        arrayList.add(a(d2));
        return arrayList;
    }

    public static long c(long j) {
        return (j * 48000) / 1000000000;
    }

    public static long d(long j) {
        return (j * 1000000000) / 48000;
    }

    public static int getChannelCount(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int getPreSkipSamples(java.util.List<byte[]> list) {
        return list.size() == 3 ? (int) c(java.nio.ByteBuffer.wrap(list.get(1)).order(java.nio.ByteOrder.nativeOrder()).getLong()) : b(list.get(0));
    }

    public static int getSeekPreRollSamples(java.util.List<byte[]> list) {
        if (list.size() == 3) {
            return (int) c(java.nio.ByteBuffer.wrap(list.get(2)).order(java.nio.ByteOrder.nativeOrder()).getLong());
        }
        return 3840;
    }
}
