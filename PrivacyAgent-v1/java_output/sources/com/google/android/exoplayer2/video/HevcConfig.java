package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public final class HevcConfig {

    @androidx.annotation.Nullable
    public final java.util.List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    public HevcConfig(@androidx.annotation.Nullable java.util.List<byte[]> list, int i) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
    }

    public static com.google.android.exoplayer2.video.HevcConfig parse(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE;
                    java.lang.System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                    int length = i4 + bArr2.length;
                    java.lang.System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    i4 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                }
            }
            return new com.google.android.exoplayer2.video.HevcConfig(i == 0 ? null : java.util.Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            throw new com.google.android.exoplayer2.ParserException("Error parsing HEVC config", e);
        }
    }
}
