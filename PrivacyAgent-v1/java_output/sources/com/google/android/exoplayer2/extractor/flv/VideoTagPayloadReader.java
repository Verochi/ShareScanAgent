package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes22.dex */
final class VideoTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    public final com.google.android.exoplayer2.util.ParsableByteArray b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public VideoTagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        super(trackOutput);
        this.b = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = (readUnsignedByte >> 4) & 15;
        int i2 = readUnsignedByte & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
        sb.append("Video format not supported: ");
        sb.append(i2);
        throw new com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException(sb.toString());
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) throws com.google.android.exoplayer2.ParserException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        long readInt24 = j + (parsableByteArray.readInt24() * 1000);
        if (readUnsignedByte == 0 && !this.e) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
            parsableByteArray.readBytes(parsableByteArray2.getData(), 0, parsableByteArray.bytesLeft());
            com.google.android.exoplayer2.video.AvcConfig parse = com.google.android.exoplayer2.video.AvcConfig.parse(parsableByteArray2);
            this.d = parse.nalUnitLengthFieldLength;
            this.a.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("video/avc").setWidth(parse.width).setHeight(parse.height).setPixelWidthHeightRatio(parse.pixelWidthAspectRatio).setInitializationData(parse.initializationData).build());
            this.e = true;
            return false;
        }
        if (readUnsignedByte != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] data = this.c.getData();
        data[0] = 0;
        data[1] = 0;
        data[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (parsableByteArray.bytesLeft() > 0) {
            parsableByteArray.readBytes(this.c.getData(), i2, this.d);
            this.c.setPosition(0);
            int readUnsignedIntToInt = this.c.readUnsignedIntToInt();
            this.b.setPosition(0);
            this.a.sampleData(this.b, 4);
            this.a.sampleData(parsableByteArray, readUnsignedIntToInt);
            i3 = i3 + 4 + readUnsignedIntToInt;
        }
        this.a.sampleMetadata(readInt24, i, i3, 0, null);
        this.f = true;
        return true;
    }
}
