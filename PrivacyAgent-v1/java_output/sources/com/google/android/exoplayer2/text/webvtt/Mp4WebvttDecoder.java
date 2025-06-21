package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
public final class Mp4WebvttDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray o;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.o = new com.google.android.exoplayer2.util.ParsableByteArray();
    }

    public static com.google.android.exoplayer2.text.Cue j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        java.lang.CharSequence charSequence = null;
        com.google.android.exoplayer2.text.Cue.Builder builder = null;
        while (i > 0) {
            if (i < 8) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            int i2 = readInt - 8;
            java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(parsableByteArray.getData(), parsableByteArray.getPosition(), i2);
            parsableByteArray.skipBytes(i2);
            i = (i - 8) - i2;
            if (readInt2 == 1937011815) {
                builder = com.google.android.exoplayer2.text.webvtt.WebvttCueParser.n(fromUtf8Bytes);
            } else if (readInt2 == 1885436268) {
                charSequence = com.google.android.exoplayer2.text.webvtt.WebvttCueParser.p(null, fromUtf8Bytes.trim(), java.util.Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return builder != null ? builder.setText(charSequence).build() : com.google.android.exoplayer2.text.webvtt.WebvttCueParser.l(charSequence);
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.o.reset(bArr, i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (this.o.bytesLeft() > 0) {
            if (this.o.bytesLeft() < 8) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int readInt = this.o.readInt();
            if (this.o.readInt() == 1987343459) {
                arrayList.add(j(this.o, readInt - 8));
            } else {
                this.o.skipBytes(readInt - 8);
            }
        }
        return new com.google.android.exoplayer2.text.webvtt.Mp4WebvttSubtitle(arrayList);
    }
}
