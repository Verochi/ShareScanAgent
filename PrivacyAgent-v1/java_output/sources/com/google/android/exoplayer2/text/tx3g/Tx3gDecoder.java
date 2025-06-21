package com.google.android.exoplayer2.text.tx3g;

/* loaded from: classes22.dex */
public final class Tx3gDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray o;
    public boolean p;
    public int q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f363s;
    public float t;
    public int u;

    public Tx3gDecoder(java.util.List<byte[]> list) {
        super("Tx3gDecoder");
        this.o = new com.google.android.exoplayer2.util.ParsableByteArray();
        if (list == null || list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.q = 0;
            this.r = -1;
            this.f363s = "sans-serif";
            this.p = false;
            this.t = 0.85f;
            return;
        }
        byte[] bArr = list.get(0);
        this.q = bArr[24];
        this.r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f363s = "Serif".equals(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * com.google.common.base.Ascii.DC4;
        this.u = i;
        boolean z = (bArr[0] & 32) != 0;
        this.p = z;
        if (!z) {
            this.t = 0.85f;
            return;
        }
        float f = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i;
        this.t = f;
        this.t = com.google.android.exoplayer2.util.Util.constrainValue(f, 0.0f, 0.95f);
    }

    public static void k(boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        if (!z) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void l(android.text.SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    public static void m(android.text.SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(0), i3, i4, i6);
        }
    }

    public static void n(android.text.SpannableStringBuilder spannableStringBuilder, java.lang.String str, java.lang.String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new android.text.style.TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    public static java.lang.String o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        char peekChar;
        k(parsableByteArray.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return readUnsignedShort == 0 ? "" : (parsableByteArray.bytesLeft() < 2 || !((peekChar = parsableByteArray.peekChar()) == 65279 || peekChar == 65534)) ? parsableByteArray.readString(readUnsignedShort, com.google.common.base.Charsets.UTF_8) : parsableByteArray.readString(readUnsignedShort, com.google.common.base.Charsets.UTF_16);
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.o.reset(bArr, i);
        java.lang.String o = o(this.o);
        if (o.isEmpty()) {
            return com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle.t;
        }
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(o);
        m(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        l(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        n(spannableStringBuilder, this.f363s, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f = this.t;
        while (true) {
            if (this.o.bytesLeft() < 8) {
                return new com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle(new com.google.android.exoplayer2.text.Cue.Builder().setText(spannableStringBuilder).setLine(f, 0).setLineAnchor(0).build());
            }
            int position = this.o.getPosition();
            int readInt = this.o.readInt();
            int readInt2 = this.o.readInt();
            if (readInt2 == 1937013100) {
                k(this.o.bytesLeft() >= 2);
                int readUnsignedShort = this.o.readUnsignedShort();
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    j(this.o, spannableStringBuilder);
                }
            } else if (readInt2 == 1952608120 && this.p) {
                k(this.o.bytesLeft() >= 2);
                f = com.google.android.exoplayer2.util.Util.constrainValue(this.o.readUnsignedShort() / this.u, 0.0f, 0.95f);
            }
            this.o.setPosition(position + readInt);
        }
    }

    public final void j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, android.text.SpannableStringBuilder spannableStringBuilder) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        k(parsableByteArray.bytesLeft() >= 12);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readInt = parsableByteArray.readInt();
        m(spannableStringBuilder, readUnsignedByte, this.q, readUnsignedShort, readUnsignedShort2, 0);
        l(spannableStringBuilder, readInt, this.r, readUnsignedShort, readUnsignedShort2, 0);
    }
}
