package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes22.dex */
final class AudioTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public AudioTagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException {
        if (this.b) {
            parsableByteArray.skipBytes(1);
        } else {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = (readUnsignedByte >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/mpeg").setChannelCount(1).setSampleRate(e[(readUnsignedByte >> 2) & 3]).build());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").setChannelCount(1).setSampleRate(8000).build());
                this.c = true;
            } else if (i != 10) {
                int i2 = this.d;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
                sb.append("Audio format not supported: ");
                sb.append(i2);
                throw new com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException(sb.toString());
            }
            this.b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) throws com.google.android.exoplayer2.ParserException {
        if (this.d == 2) {
            int bytesLeft = parsableByteArray.bytesLeft();
            this.a.sampleData(parsableByteArray, bytesLeft);
            this.a.sampleMetadata(j, 1, bytesLeft, 0, null);
            return true;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte != 0 || this.c) {
            if (this.d == 10 && readUnsignedByte != 1) {
                return false;
            }
            int bytesLeft2 = parsableByteArray.bytesLeft();
            this.a.sampleData(parsableByteArray, bytesLeft2);
            this.a.sampleMetadata(j, 1, bytesLeft2, 0, null);
            return true;
        }
        int bytesLeft3 = parsableByteArray.bytesLeft();
        byte[] bArr = new byte[bytesLeft3];
        parsableByteArray.readBytes(bArr, 0, bytesLeft3);
        com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(bArr);
        this.a.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/mp4a-latm").setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(java.util.Collections.singletonList(bArr)).build());
        this.c = true;
        return false;
    }
}
