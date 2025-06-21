package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
public final class WebvttDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray o;
    public final com.google.android.exoplayer2.text.webvtt.CssParser p;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.o = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.p = new com.google.android.exoplayer2.text.webvtt.CssParser();
    }

    public static int j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = parsableByteArray.getPosition();
            java.lang.String readLine = parsableByteArray.readLine();
            i = readLine == null ? 0 : "STYLE".equals(readLine) ? 2 : readLine.startsWith("NOTE") ? 1 : 3;
        }
        parsableByteArray.setPosition(i2);
        return i;
    }

    public static void k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (!android.text.TextUtils.isEmpty(parsableByteArray.readLine())) {
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.text.webvtt.WebvttCueInfo parseCue;
        this.o.reset(bArr, i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.validateWebvttHeaderLine(this.o);
            while (!android.text.TextUtils.isEmpty(this.o.readLine())) {
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            while (true) {
                int j = j(this.o);
                if (j == 0) {
                    return new com.google.android.exoplayer2.text.webvtt.WebvttSubtitle(arrayList2);
                }
                if (j == 1) {
                    k(this.o);
                } else if (j == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new com.google.android.exoplayer2.text.SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.o.readLine();
                    arrayList.addAll(this.p.d(this.o));
                } else if (j == 3 && (parseCue = com.google.android.exoplayer2.text.webvtt.WebvttCueParser.parseCue(this.o, arrayList)) != null) {
                    arrayList2.add(parseCue);
                }
            }
        } catch (com.google.android.exoplayer2.ParserException e) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException(e);
        }
    }
}
