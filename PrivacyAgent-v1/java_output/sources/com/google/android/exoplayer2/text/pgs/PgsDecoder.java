package com.google.android.exoplayer2.text.pgs;

/* loaded from: classes22.dex */
public final class PgsDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray o;
    public final com.google.android.exoplayer2.util.ParsableByteArray p;
    public final com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder q;

    @androidx.annotation.Nullable
    public java.util.zip.Inflater r;

    public static final class CueBuilder {
        public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray();
        public final int[] b = new int[256];
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.text.Cue d() {
            int i;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.a.limit() == 0 || this.a.getPosition() != this.a.limit() || !this.c) {
                return null;
            }
            this.a.setPosition(0);
            int i2 = this.h * this.i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int readUnsignedByte = this.a.readUnsignedByte();
                if (readUnsignedByte != 0) {
                    i = i3 + 1;
                    iArr[i3] = this.b[readUnsignedByte];
                } else {
                    int readUnsignedByte2 = this.a.readUnsignedByte();
                    if (readUnsignedByte2 != 0) {
                        i = ((readUnsignedByte2 & 64) == 0 ? readUnsignedByte2 & 63 : ((readUnsignedByte2 & 63) << 8) | this.a.readUnsignedByte()) + i3;
                        java.util.Arrays.fill(iArr, i3, i, (readUnsignedByte2 & 128) == 0 ? 0 : this.b[this.a.readUnsignedByte()]);
                    }
                }
                i3 = i;
            }
            return new com.google.android.exoplayer2.text.Cue.Builder().setBitmap(android.graphics.Bitmap.createBitmap(iArr, this.h, this.i, android.graphics.Bitmap.Config.ARGB_8888)).setPosition(this.f / this.d).setPositionAnchor(0).setLine(this.g / this.e, 0).setLineAnchor(0).setSize(this.h / this.d).setBitmapHeight(this.i / this.e).build();
        }

        public final void e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            int readUnsignedInt24;
            if (i < 4) {
                return;
            }
            parsableByteArray.skipBytes(3);
            int i2 = i - 4;
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                if (i2 < 7 || (readUnsignedInt24 = parsableByteArray.readUnsignedInt24()) < 4) {
                    return;
                }
                this.h = parsableByteArray.readUnsignedShort();
                this.i = parsableByteArray.readUnsignedShort();
                this.a.reset(readUnsignedInt24 - 4);
                i2 -= 7;
            }
            int position = this.a.getPosition();
            int limit = this.a.limit();
            if (position >= limit || i2 <= 0) {
                return;
            }
            int min = java.lang.Math.min(i2, limit - position);
            parsableByteArray.readBytes(this.a.getData(), position, min);
            this.a.setPosition(position + min);
        }

        public final void f(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            if (i < 19) {
                return;
            }
            this.d = parsableByteArray.readUnsignedShort();
            this.e = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(11);
            this.f = parsableByteArray.readUnsignedShort();
            this.g = parsableByteArray.readUnsignedShort();
        }

        public final void g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            if (i % 5 != 2) {
                return;
            }
            parsableByteArray.skipBytes(2);
            java.util.Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
                double d = readUnsignedByte2;
                double d2 = readUnsignedByte3 + com.alipay.sdk.m.n.a.g;
                double d3 = readUnsignedByte4 + com.alipay.sdk.m.n.a.g;
                this.b[readUnsignedByte] = (com.google.android.exoplayer2.util.Util.constrainValue((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (readUnsignedByte5 << 24) | (com.google.android.exoplayer2.util.Util.constrainValue((int) ((1.402d * d2) + d), 0, 255) << 16) | com.google.android.exoplayer2.util.Util.constrainValue((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.reset(0);
            this.c = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
        this.o = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.p = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.q = new com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder();
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.Cue k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder cueBuilder) {
        int limit = parsableByteArray.limit();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition() + readUnsignedShort;
        com.google.android.exoplayer2.text.Cue cue = null;
        if (position > limit) {
            parsableByteArray.setPosition(limit);
            return null;
        }
        if (readUnsignedByte != 128) {
            switch (readUnsignedByte) {
                case 20:
                    cueBuilder.g(parsableByteArray, readUnsignedShort);
                    break;
                case 21:
                    cueBuilder.e(parsableByteArray, readUnsignedShort);
                    break;
                case 22:
                    cueBuilder.f(parsableByteArray, readUnsignedShort);
                    break;
            }
        } else {
            cue = cueBuilder.d();
            cueBuilder.h();
        }
        parsableByteArray.setPosition(position);
        return cue;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.o.reset(bArr, i);
        j(this.o);
        this.q.h();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (this.o.bytesLeft() >= 3) {
            com.google.android.exoplayer2.text.Cue k = k(this.o, this.q);
            if (k != null) {
                arrayList.add(k);
            }
        }
        return new com.google.android.exoplayer2.text.pgs.PgsSubtitle(java.util.Collections.unmodifiableList(arrayList));
    }

    public final void j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() <= 0 || parsableByteArray.peekUnsignedByte() != 120) {
            return;
        }
        if (this.r == null) {
            this.r = new java.util.zip.Inflater();
        }
        if (com.google.android.exoplayer2.util.Util.inflate(parsableByteArray, this.p, this.r)) {
            parsableByteArray.reset(this.p.getData(), this.p.limit());
        }
    }
}
