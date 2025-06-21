package com.google.android.exoplayer2.text.dvb;

/* loaded from: classes22.dex */
public final class DvbDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public final com.google.android.exoplayer2.text.dvb.DvbParser o;

    public DvbDecoder(java.util.List<byte[]> list) {
        super("DvbDecoder");
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(list.get(0));
        this.o = new com.google.android.exoplayer2.text.dvb.DvbParser(parsableByteArray.readUnsignedShort(), parsableByteArray.readUnsignedShort());
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) {
        if (z) {
            this.o.r();
        }
        return new com.google.android.exoplayer2.text.dvb.DvbSubtitle(this.o.b(bArr, i));
    }
}
