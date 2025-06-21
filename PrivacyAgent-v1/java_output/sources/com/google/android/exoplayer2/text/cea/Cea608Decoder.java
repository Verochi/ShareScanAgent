package com.google.android.exoplayer2.text.cea;

/* loaded from: classes22.dex */
public final class Cea608Decoder extends com.google.android.exoplayer2.text.cea.CeaDecoder {
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000;
    public final int h;
    public final int i;
    public final int j;
    public final long k;

    @androidx.annotation.Nullable
    public java.util.List<com.google.android.exoplayer2.text.Cue> n;

    @androidx.annotation.Nullable
    public java.util.List<com.google.android.exoplayer2.text.Cue> o;
    public int p;
    public int q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f359s;
    public byte t;
    public byte u;
    public boolean w;
    public long x;
    public static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, androidx.core.internal.view.SupportMenu.CATEGORY_MASK, androidx.core.view.InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 241, 9632};
    public static final int[] C = {174, 176, com.google.android.exoplayer2.extractor.ts.PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};
    public static final int[] D = {193, 201, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 218, 220, com.getui.gtc.extension.distribution.gbd.d.g.aH, 8216, 161, 42, 39, com.umeng.analytics.pro.q.a.D, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 239, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 204, 236, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 242, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final com.google.android.exoplayer2.util.ParsableByteArray g = new com.google.android.exoplayer2.util.ParsableByteArray();
    public final java.util.ArrayList<com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder> l = new java.util.ArrayList<>();
    public com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder m = new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder(0, 4);
    public int v = 0;

    public static final class CueBuilder {
        public final java.util.List<com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle> a = new java.util.ArrayList();
        public final java.util.List<android.text.SpannableString> b = new java.util.ArrayList();
        public final java.lang.StringBuilder c = new java.lang.StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public static class CueStyle {
            public final int a;
            public final boolean b;
            public int c;

            public CueStyle(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public CueBuilder(int i, int i2) {
            j(i);
            this.h = i2;
        }

        public static void n(android.text.SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(i3), i, i2, 33);
        }

        public static void o(android.text.SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), i, i2, 33);
        }

        public static void q(android.text.SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle cueStyle = this.a.get(size);
                    int i = cueStyle.c;
                    if (i != length) {
                        return;
                    }
                    cueStyle.c = i - 1;
                }
            }
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.text.Cue g(int i) {
            float f;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                spannableStringBuilder.append(com.google.android.exoplayer2.util.Util.truncateAscii(this.b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(com.google.android.exoplayer2.util.Util.truncateAscii(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (java.lang.Math.abs(i5) >= 3 && length >= 0)) ? (this.g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.d;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new com.google.android.exoplayer2.text.Cue.Builder().setText(spannableStringBuilder).setTextAlignment(android.text.Layout.Alignment.ALIGN_NORMAL).setLine(i6, 1).setPosition(f).setPositionAnchor(i).build();
        }

        public final android.text.SpannableString h() {
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            boolean z = false;
            while (i < this.a.size()) {
                com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle cueStyle = this.a.get(i);
                boolean z2 = cueStyle.b;
                int i7 = cueStyle.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = com.google.android.exoplayer2.text.cea.Cea608Decoder.A[i7];
                    }
                    z = z3;
                }
                int i8 = cueStyle.c;
                i++;
                if (i8 != (i < this.a.size() ? this.a.get(i).c : length)) {
                    if (i2 != -1 && !z2) {
                        q(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        o(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        n(spannableStringBuilder, i4, i8, i5);
                        i5 = i6;
                        i4 = i8;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                q(spannableStringBuilder, i2, length);
            }
            if (i3 != -1 && i3 != length) {
                o(spannableStringBuilder, i3, length);
            }
            if (i4 != length) {
                n(spannableStringBuilder, i4, length, i5);
            }
            return new android.text.SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.a.clear();
            int min = java.lang.Math.min(this.h, this.d);
            while (this.b.size() >= min) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle(i, z, this.c.length()));
        }
    }

    public Cea608Decoder(java.lang.String str, int i, long j) {
        this.k = j > 0 ? j * 1000 : -9223372036854775807L;
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i != 4) {
            com.google.android.exoplayer2.util.Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        z(0);
        y();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    public static char c(byte b) {
        return (char) B[(b & Byte.MAX_VALUE) - 32];
    }

    public static int d(byte b) {
        return (b >> 3) & 1;
    }

    public static char f(byte b) {
        return (char) D[b & com.google.common.base.Ascii.US];
    }

    public static char g(byte b) {
        return (char) E[b & com.google.common.base.Ascii.US];
    }

    public static char h(byte b, byte b2) {
        return (b & 1) == 0 ? f(b2) : g(b2);
    }

    public static char i(byte b) {
        return (char) C[b & 15];
    }

    public static boolean m(byte b) {
        return (b & 224) == 0;
    }

    public static boolean n(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    public static boolean o(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    public static boolean p(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    public static boolean q(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    public static boolean r(byte b) {
        return (b & 240) == 16;
    }

    public static boolean t(byte b) {
        return (b & 247) == 20;
    }

    public static boolean u(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    public static boolean v(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    public static boolean w(byte b) {
        return 1 <= b && b <= 15;
    }

    public final void A(int i) {
        this.q = i;
        this.m.m(i);
    }

    public final boolean B() {
        return (this.k == -9223372036854775807L || this.x == -9223372036854775807L || getPositionUs() - this.x < this.k) ? false : true;
    }

    public final boolean C(byte b) {
        if (m(b)) {
            this.v = d(b);
        }
        return this.v == this.j;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public com.google.android.exoplayer2.text.Subtitle createSubtitle() {
        java.util.List<com.google.android.exoplayer2.text.Cue> list = this.n;
        this.o = list;
        return new com.google.android.exoplayer2.text.cea.CeaSubtitle((java.util.List) com.google.android.exoplayer2.util.Assertions.checkNotNull(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0017 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) {
        boolean z2;
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(subtitleInputBuffer.data);
        this.g.reset(byteBuffer.array(), byteBuffer.limit());
        boolean z3 = false;
        while (true) {
            int bytesLeft = this.g.bytesLeft();
            int i = this.h;
            if (bytesLeft < i) {
                break;
            }
            byte readUnsignedByte = i == 2 ? (byte) -4 : (byte) this.g.readUnsignedByte();
            int readUnsignedByte2 = this.g.readUnsignedByte();
            int readUnsignedByte3 = this.g.readUnsignedByte();
            if ((readUnsignedByte & 2) == 0 && (readUnsignedByte & 1) == this.i) {
                byte b = (byte) (readUnsignedByte2 & 127);
                byte b2 = (byte) (readUnsignedByte3 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z4 = this.r;
                    if ((readUnsignedByte & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[readUnsignedByte2] && zArr[readUnsignedByte3]) {
                            z2 = true;
                            this.r = z2;
                            if (!s(z2, b, b2)) {
                                if (this.r) {
                                    x(b, b2);
                                    if (this.w && C(b)) {
                                        if (!m(b)) {
                                            this.m.e(c(b));
                                            if ((b2 & 224) != 0) {
                                                this.m.e(c(b2));
                                            }
                                        } else if (u(b, b2)) {
                                            this.m.e(i(b2));
                                        } else if (n(b, b2)) {
                                            this.m.f();
                                            this.m.e(h(b, b2));
                                        } else if (o(b, b2)) {
                                            j(b2);
                                        } else if (q(b, b2)) {
                                            l(b, b2);
                                        } else if (v(b, b2)) {
                                            this.m.f = b2 - 32;
                                        } else if (p(b, b2)) {
                                            k(b2);
                                        }
                                        z3 = true;
                                    }
                                } else if (z4) {
                                    y();
                                    z3 = true;
                                }
                            }
                        }
                    }
                    z2 = false;
                    this.r = z2;
                    if (!s(z2, b, b2)) {
                    }
                }
            }
        }
        if (z3) {
            int i2 = this.p;
            if (i2 == 1 || i2 == 3) {
                this.n = e();
                this.x = getPositionUs();
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.SubtitleInputBuffer dequeueInputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.text.SubtitleOutputBuffer availableOutputBuffer;
        com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!B() || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.n = java.util.Collections.emptyList();
        this.x = -9223372036854775807L;
        availableOutputBuffer.setContent(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }

    public final java.util.List<com.google.android.exoplayer2.text.Cue> e() {
        int size = this.l.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.text.Cue g = this.l.get(i2).g(Integer.MIN_VALUE);
            arrayList.add(g);
            if (g != null) {
                i = java.lang.Math.min(i, g.positionAnchor);
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.exoplayer2.text.Cue cue = (com.google.android.exoplayer2.text.Cue) arrayList.get(i3);
            if (cue != null) {
                if (cue.positionAnchor != i) {
                    cue = (com.google.android.exoplayer2.text.Cue) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.l.get(i3).g(i));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        z(0);
        A(4);
        y();
        this.r = false;
        this.f359s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.n != this.o;
    }

    public final void j(byte b) {
        this.m.e(' ');
        this.m.p((b >> 1) & 7, (b & 1) == 1);
    }

    public final void k(byte b) {
        if (b == 32) {
            z(2);
            return;
        }
        if (b == 41) {
            z(3);
            return;
        }
        switch (b) {
            case 37:
                z(1);
                A(2);
                break;
            case 38:
                z(1);
                A(3);
                break;
            case 39:
                z(1);
                A(4);
                break;
            default:
                int i = this.p;
                if (i != 0) {
                    if (b == 33) {
                        this.m.f();
                        break;
                    } else {
                        switch (b) {
                            case 44:
                                this.n = java.util.Collections.emptyList();
                                int i2 = this.p;
                                if (i2 == 1 || i2 == 3) {
                                    y();
                                    break;
                                }
                            case 45:
                                if (i == 1 && !this.m.i()) {
                                    this.m.k();
                                    break;
                                }
                                break;
                            case 46:
                                y();
                                break;
                            case 47:
                                this.n = e();
                                y();
                                break;
                        }
                    }
                }
                break;
        }
    }

    public final void l(byte b, byte b2) {
        int i = y[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.m.d) {
            if (this.p != 1 && !this.m.i()) {
                com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder cueBuilder = new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder(this.p, this.q);
                this.m = cueBuilder;
                this.l.add(cueBuilder);
            }
            this.m.d = i;
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.m.p(z2 ? 8 : i2, z3);
        if (z2) {
            this.m.e = z[i2];
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    public final boolean s(boolean z2, byte b, byte b2) {
        if (!z2 || !r(b)) {
            this.f359s = false;
        } else {
            if (this.f359s && this.t == b && this.u == b2) {
                this.f359s = false;
                return true;
            }
            this.f359s = true;
            this.t = b;
            this.u = b2;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public final void x(byte b, byte b2) {
        if (w(b)) {
            this.w = false;
            return;
        }
        if (t(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 42:
                            case 43:
                                this.w = false;
                                break;
                        }
                }
            }
            this.w = true;
        }
    }

    public final void y() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    public final void z(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                this.l.get(i3).l(i);
            }
            return;
        }
        y();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = java.util.Collections.emptyList();
        }
    }
}
