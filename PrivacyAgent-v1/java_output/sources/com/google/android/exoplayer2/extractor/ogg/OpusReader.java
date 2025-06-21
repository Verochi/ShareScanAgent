package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class OpusReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    public static boolean m(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = o;
        if (bytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return java.util.Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return b(l(parsableByteArray.getData()));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) {
        if (this.n) {
            boolean z = parsableByteArray.readInt() == 1332770163;
            parsableByteArray.setPosition(0);
            return z;
        }
        byte[] copyOf = java.util.Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
        setupData.a = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/opus").setChannelCount(com.google.android.exoplayer2.audio.OpusUtil.getChannelCount(copyOf)).setSampleRate(com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE).setInitializationData(com.google.android.exoplayer2.audio.OpusUtil.buildInitializationData(copyOf)).build();
        this.n = true;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = false;
        }
    }

    public final long l(byte[] bArr) {
        int i;
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = bArr[1] & 63;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        return i * (i4 >= 16 ? 2500 << r1 : i4 >= 12 ? 10000 << (r1 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r1);
    }
}
