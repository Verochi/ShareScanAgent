package com.google.android.exoplayer2.text.cea;

/* loaded from: classes22.dex */
public final class Cea708Decoder extends com.google.android.exoplayer2.text.cea.CeaDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray g = new com.google.android.exoplayer2.util.ParsableByteArray();
    public final com.google.android.exoplayer2.util.ParsableBitArray h = new com.google.android.exoplayer2.util.ParsableBitArray();
    public final boolean i;
    public final int j;
    public final com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder[] k;
    public com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder l;

    @androidx.annotation.Nullable
    public java.util.List<com.google.android.exoplayer2.text.Cue> m;

    @androidx.annotation.Nullable
    public java.util.List<com.google.android.exoplayer2.text.Cue> n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket o;
    public int p;

    public static final class Cea708CueInfo {
        public final com.google.android.exoplayer2.text.Cue a;
        public final int b;

        public Cea708CueInfo(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            com.google.android.exoplayer2.text.Cue.Builder size = new com.google.android.exoplayer2.text.Cue.Builder().setText(charSequence).setTextAlignment(alignment).setLine(f, i).setLineAnchor(i2).setPosition(f2).setPositionAnchor(i3).setSize(f3);
            if (z) {
                size.setWindowColor(i4);
            }
            this.a = size.build();
            this.b = i5;
        }
    }

    public static final class CueInfoBuilder {
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;
        public static final int w = h(2, 2, 2, 0);
        public static final int x;
        public static final int y;
        public static final int[] z;
        public final java.util.List<android.text.SpannableString> a = new java.util.ArrayList();
        public final android.text.SpannableStringBuilder b = new android.text.SpannableStringBuilder();
        public boolean c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public int f360s;
        public int t;
        public int u;
        public int v;

        static {
            int h = h(0, 0, 0, 0);
            x = h;
            int h2 = h(0, 0, 0, 3);
            y = h2;
            z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h, h2, h, h, h2, h, h};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h, h, h, h, h, h2, h2};
        }

        public CueInfoBuilder() {
            l();
        }

        public static int g(int i, int i2, int i3) {
            return h(i, i2, i3, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int h(int i, int i2, int i3, int i4) {
            int i5;
            com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, 4);
            com.google.android.exoplayer2.util.Assertions.checkIndex(i2, 0, 4);
            com.google.android.exoplayer2.util.Assertions.checkIndex(i3, 0, 4);
            com.google.android.exoplayer2.util.Assertions.checkIndex(i4, 0, 4);
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    i5 = 127;
                } else if (i4 == 3) {
                    i5 = 0;
                }
                return android.graphics.Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
            }
            i5 = 255;
            return android.graphics.Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        public void a(char c) {
            if (c != '\n') {
                this.b.append(c);
                return;
            }
            this.a.add(d());
            this.b.clear();
            if (this.p != -1) {
                this.p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.r != -1) {
                this.r = 0;
            }
            if (this.t != -1) {
                this.t = 0;
            }
            while (true) {
                if ((!this.k || this.a.size() < this.j) && this.a.size() < 15) {
                    return;
                } else {
                    this.a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.b.length();
            if (length > 0) {
                this.b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo c() {
            android.text.Layout.Alignment alignment;
            float f;
            float f2;
            if (j()) {
                return null;
            }
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            for (int i = 0; i < this.a.size(); i++) {
                spannableStringBuilder.append((java.lang.CharSequence) this.a.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((java.lang.CharSequence) d());
            int i2 = this.l;
            if (i2 != 0) {
                if (i2 == 1) {
                    alignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
                } else if (i2 == 2) {
                    alignment = android.text.Layout.Alignment.ALIGN_CENTER;
                } else if (i2 != 3) {
                    int i3 = this.l;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(43);
                    sb.append("Unexpected justification value: ");
                    sb.append(i3);
                    throw new java.lang.IllegalArgumentException(sb.toString());
                }
                android.text.Layout.Alignment alignment2 = alignment;
                if (this.f) {
                    f = this.h / 209.0f;
                    f2 = this.g / 74.0f;
                } else {
                    f = this.h / 99.0f;
                    f2 = this.g / 99.0f;
                }
                float f3 = (f * 0.9f) + 0.05f;
                float f4 = (f2 * 0.9f) + 0.05f;
                int i4 = this.i;
                int i5 = i4 % 3 != 0 ? 0 : i4 % 3 == 1 ? 1 : 2;
                int i6 = i4 / 3 != 0 ? 0 : i4 / 3 == 1 ? 1 : 2;
                int i7 = this.o;
                return new com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo(spannableStringBuilder, alignment2, f4, 0, i5, f3, i6, -3.4028235E38f, i7 != x, i7, this.e);
            }
            alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
            android.text.Layout.Alignment alignment22 = alignment;
            if (this.f) {
            }
            float f32 = (f * 0.9f) + 0.05f;
            float f42 = (f2 * 0.9f) + 0.05f;
            int i42 = this.i;
            if (i42 % 3 != 0) {
            }
            if (i42 / 3 != 0) {
            }
            int i72 = this.o;
            return new com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo(spannableStringBuilder, alignment22, f42, 0, i5, f32, i6, -3.4028235E38f, i72 != x, i72, this.e);
        }

        public android.text.SpannableString d() {
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(this.f360s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new android.text.SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i, boolean z5, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.c = true;
            this.d = z2;
            this.k = z3;
            this.e = i;
            this.f = z5;
            this.g = i2;
            this.h = i3;
            this.i = i6;
            int i9 = i4 + 1;
            if (this.j != i9) {
                this.j = i9;
                while (true) {
                    if ((!z3 || this.a.size() < this.j) && this.a.size() < 15) {
                        break;
                    } else {
                        this.a.remove(0);
                    }
                }
            }
            if (i7 != 0 && this.m != i7) {
                this.m = i7;
                int i10 = i7 - 1;
                q(D[i10], y, C[i10], 0, A[i10], B[i10], z[i10]);
            }
            if (i8 == 0 || this.n == i8) {
                return;
            }
            this.n = i8;
            int i11 = i8 - 1;
            m(0, 1, 1, false, false, F[i11], E[i11]);
            n(w, G[i11], x);
        }

        public boolean i() {
            return this.c;
        }

        public boolean j() {
            return !i() || (this.a.isEmpty() && this.b.length() == 0);
        }

        public boolean k() {
            return this.d;
        }

        public void l() {
            e();
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i = x;
            this.o = i;
            this.f360s = w;
            this.u = i;
        }

        public void m(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            if (this.p != -1) {
                if (!z2) {
                    this.b.setSpan(new android.text.style.StyleSpan(2), this.p, this.b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.b.length();
            }
            if (this.q == -1) {
                if (z3) {
                    this.q = this.b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.b.setSpan(new android.text.style.UnderlineSpan(), this.q, this.b.length(), 33);
                this.q = -1;
            }
        }

        public void n(int i, int i2, int i3) {
            if (this.r != -1 && this.f360s != i) {
                this.b.setSpan(new android.text.style.ForegroundColorSpan(this.f360s), this.r, this.b.length(), 33);
            }
            if (i != w) {
                this.r = this.b.length();
                this.f360s = i;
            }
            if (this.t != -1 && this.u != i2) {
                this.b.setSpan(new android.text.style.BackgroundColorSpan(this.u), this.t, this.b.length(), 33);
            }
            if (i2 != x) {
                this.t = this.b.length();
                this.u = i2;
            }
        }

        public void o(int i, int i2) {
            if (this.v != i) {
                a('\n');
            }
            this.v = i;
        }

        public void p(boolean z2) {
            this.d = z2;
        }

        public void q(int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
            this.o = i;
            this.l = i6;
        }
    }

    public static final class DtvCcPacket {
        public final int a;
        public final int b;
        public final byte[] c;
        public int d = 0;

        public DtvCcPacket(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }

    public Cea708Decoder(int i, @androidx.annotation.Nullable java.util.List<byte[]> list) {
        this.j = i == -1 ? 1 : i;
        this.i = list != null && com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseCea708InitializationData(list);
        this.k = new com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.k[i2] = new com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder();
        }
        this.l = this.k[0];
    }

    public static /* synthetic */ int r(com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo cea708CueInfo, com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo cea708CueInfo2) {
        return java.lang.Integer.compare(cea708CueInfo.b, cea708CueInfo2.b);
    }

    public final void c() {
        if (this.o == null) {
            return;
        }
        s();
        this.o = null;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public com.google.android.exoplayer2.text.Subtitle createSubtitle() {
        java.util.List<com.google.android.exoplayer2.text.Cue> list = this.m;
        this.n = list;
        return new com.google.android.exoplayer2.text.cea.CeaSubtitle((java.util.List) com.google.android.exoplayer2.util.Assertions.checkNotNull(list));
    }

    public final java.util.List<com.google.android.exoplayer2.text.Cue> d() {
        com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo c;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.k[i].j() && this.k[i].k() && (c = this.k[i].c()) != null) {
                arrayList.add(c);
            }
        }
        java.util.Collections.sort(arrayList, new com.google.android.exoplayer2.text.cea.a());
        java.util.ArrayList arrayList2 = new java.util.ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo) arrayList.get(i2)).a);
        }
        return java.util.Collections.unmodifiableList(arrayList2);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) {
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(subtitleInputBuffer.data);
        this.g.reset(byteBuffer.array(), byteBuffer.limit());
        while (this.g.bytesLeft() >= 3) {
            int readUnsignedByte = this.g.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.g.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.g.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        c();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket = new com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket(i2, i3);
                        this.o = dtvCcPacket;
                        byte[] bArr = dtvCcPacket.c;
                        int i4 = dtvCcPacket.d;
                        dtvCcPacket.d = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.Assertions.checkArgument(i == 2);
                        com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket2 = this.o;
                        if (dtvCcPacket2 == null) {
                            com.google.android.exoplayer2.util.Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = dtvCcPacket2.c;
                            int i5 = dtvCcPacket2.d;
                            int i6 = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            dtvCcPacket2.d = i6 + 1;
                            bArr2[i6] = readUnsignedByte3;
                        }
                    }
                    com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket3 = this.o;
                    if (dtvCcPacket3.d == (dtvCcPacket3.b * 2) - 1) {
                        c();
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.SubtitleInputBuffer dequeueInputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    public final void e(int i) {
        if (i != 0) {
            if (i == 3) {
                this.m = d();
            }
            if (i == 8) {
                this.l.b();
                return;
            }
            switch (i) {
                case 12:
                    t();
                    break;
                case 13:
                    this.l.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i >= 17 && i <= 23) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(55);
                        sb.append("Currently unsupported COMMAND_EXT1 Command: ");
                        sb.append(i);
                        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb.toString());
                        this.h.skipBits(8);
                        break;
                    } else if (i >= 24 && i <= 31) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(54);
                        sb2.append("Currently unsupported COMMAND_P16 Command: ");
                        sb2.append(i);
                        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb2.toString());
                        this.h.skipBits(16);
                        break;
                    } else {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder(31);
                        sb3.append("Invalid C0 command: ");
                        sb3.append(i);
                        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb3.toString());
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void f(int i) {
        int i2 = 1;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
            case 134:
            case 135:
                int i3 = i + com.alipay.sdk.m.n.a.g;
                if (this.p != i3) {
                    this.p = i3;
                    this.l = this.k[i3];
                    break;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                while (i2 <= 8) {
                    if (this.h.readBit()) {
                        this.k[8 - i2].e();
                    }
                    i2++;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.h.readBit()) {
                        this.k[8 - i4].p(true);
                    }
                }
                break;
            case 138:
                while (i2 <= 8) {
                    if (this.h.readBit()) {
                        this.k[8 - i2].p(false);
                    }
                    i2++;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.h.readBit()) {
                        this.k[8 - i5].p(!r0.k());
                    }
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL /* 140 */:
                while (i2 <= 8) {
                    if (this.h.readBit()) {
                        this.k[8 - i2].l();
                    }
                    i2++;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS /* 141 */:
                this.h.skipBits(8);
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL /* 142 */:
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE /* 143 */:
                t();
                break;
            case 144:
                if (this.l.i()) {
                    n();
                    break;
                } else {
                    this.h.skipBits(16);
                    break;
                }
            case 145:
                if (this.l.i()) {
                    o();
                    break;
                } else {
                    this.h.skipBits(24);
                    break;
                }
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH /* 146 */:
                if (this.l.i()) {
                    p();
                    break;
                } else {
                    this.h.skipBits(16);
                    break;
                }
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME /* 147 */:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS /* 148 */:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE /* 149 */:
            case 150:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(31);
                sb.append("Invalid C1 command: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb.toString());
                break;
            case 151:
                if (this.l.i()) {
                    q();
                    break;
                } else {
                    this.h.skipBits(32);
                    break;
                }
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION /* 152 */:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE /* 153 */:
            case 154:
            case org.apache.tools.tar.TarConstants.PREFIXLEN /* 155 */:
            case 156:
            case 157:
            case com.aliyun.svideosdk.facearengine.FaceARFaceResult.YUNOS_FL51PT_FACE_3D_KEY_POINT_NUM /* 158 */:
            case 159:
                int i6 = i - 152;
                i(i6);
                if (this.p != i6) {
                    this.p = i6;
                    this.l = this.k[i6];
                    break;
                }
                break;
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.m = null;
        this.n = null;
        this.p = 0;
        this.l = this.k[0];
        t();
        this.o = null;
    }

    public final void g(int i) {
        if (i <= 7) {
            return;
        }
        if (i <= 15) {
            this.h.skipBits(8);
        } else if (i <= 23) {
            this.h.skipBits(16);
        } else if (i <= 31) {
            this.h.skipBits(24);
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "Cea708Decoder";
    }

    public final void h(int i) {
        if (i <= 135) {
            this.h.skipBits(32);
            return;
        }
        if (i <= 143) {
            this.h.skipBits(40);
        } else if (i <= 159) {
            this.h.skipBits(2);
            this.h.skipBits(this.h.readBits(6) * 8);
        }
    }

    public final void i(int i) {
        com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder cueInfoBuilder = this.k[i];
        this.h.skipBits(2);
        boolean readBit = this.h.readBit();
        boolean readBit2 = this.h.readBit();
        boolean readBit3 = this.h.readBit();
        int readBits = this.h.readBits(3);
        boolean readBit4 = this.h.readBit();
        int readBits2 = this.h.readBits(7);
        int readBits3 = this.h.readBits(8);
        int readBits4 = this.h.readBits(4);
        int readBits5 = this.h.readBits(4);
        this.h.skipBits(2);
        int readBits6 = this.h.readBits(6);
        this.h.skipBits(2);
        cueInfoBuilder.f(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.h.readBits(3), this.h.readBits(3));
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.m != this.n;
    }

    public final void j(int i) {
        if (i == 127) {
            this.l.a((char) 9835);
        } else {
            this.l.a((char) (i & 255));
        }
    }

    public final void k(int i) {
        this.l.a((char) (i & 255));
    }

    public final void l(int i) {
        if (i == 32) {
            this.l.a(' ');
        }
        if (i == 33) {
            this.l.a(kotlin.text.Typography.nbsp);
            return;
        }
        if (i == 37) {
            this.l.a(kotlin.text.Typography.ellipsis);
            return;
        }
        if (i == 42) {
            this.l.a((char) 352);
            return;
        }
        if (i == 44) {
            this.l.a((char) 338);
            return;
        }
        if (i == 63) {
            this.l.a((char) 376);
            return;
        }
        if (i == 57) {
            this.l.a(kotlin.text.Typography.tm);
            return;
        }
        if (i == 58) {
            this.l.a((char) 353);
            return;
        }
        if (i == 60) {
            this.l.a((char) 339);
            return;
        }
        if (i == 61) {
            this.l.a((char) 8480);
            return;
        }
        switch (i) {
            case 48:
                this.l.a((char) 9608);
                break;
            case 49:
                this.l.a(kotlin.text.Typography.leftSingleQuote);
                break;
            case 50:
                this.l.a(kotlin.text.Typography.rightSingleQuote);
                break;
            case 51:
                this.l.a(kotlin.text.Typography.leftDoubleQuote);
                break;
            case 52:
                this.l.a(kotlin.text.Typography.rightDoubleQuote);
                break;
            case 53:
                this.l.a(kotlin.text.Typography.bullet);
                break;
            default:
                switch (i) {
                    case 118:
                        this.l.a((char) 8539);
                        break;
                    case 119:
                        this.l.a((char) 8540);
                        break;
                    case 120:
                        this.l.a((char) 8541);
                        break;
                    case 121:
                        this.l.a((char) 8542);
                        break;
                    case 122:
                        this.l.a((char) 9474);
                        break;
                    case 123:
                        this.l.a((char) 9488);
                        break;
                    case 124:
                        this.l.a((char) 9492);
                        break;
                    case 125:
                        this.l.a((char) 9472);
                        break;
                    case 126:
                        this.l.a((char) 9496);
                        break;
                    case 127:
                        this.l.a((char) 9484);
                        break;
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
                        sb.append("Invalid G2 character: ");
                        sb.append(i);
                        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb.toString());
                        break;
                }
        }
    }

    public final void m(int i) {
        if (i == 160) {
            this.l.a((char) 13252);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
        sb.append("Invalid G3 character: ");
        sb.append(i);
        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb.toString());
        this.l.a('_');
    }

    public final void n() {
        this.l.m(this.h.readBits(4), this.h.readBits(2), this.h.readBits(2), this.h.readBit(), this.h.readBit(), this.h.readBits(3), this.h.readBits(3));
    }

    public final void o() {
        int h = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.h(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
        int h2 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.h(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
        this.h.skipBits(2);
        this.l.n(h, h2, com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.g(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2)));
    }

    public final void p() {
        this.h.skipBits(4);
        int readBits = this.h.readBits(4);
        this.h.skipBits(2);
        this.l.o(readBits, this.h.readBits(6));
    }

    public final void q() {
        int h = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.h(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
        int readBits = this.h.readBits(2);
        int g = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.g(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
        if (this.h.readBit()) {
            readBits |= 4;
        }
        boolean readBit = this.h.readBit();
        int readBits2 = this.h.readBits(2);
        int readBits3 = this.h.readBits(2);
        int readBits4 = this.h.readBits(2);
        this.h.skipBits(8);
        this.l.q(h, g, readBit, readBits, readBits2, readBits3, readBits4);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"currentDtvCcPacket"})
    public final void s() {
        com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket = this.o;
        int i = dtvCcPacket.d;
        int i2 = dtvCcPacket.b;
        if (i != (i2 * 2) - 1) {
            int i3 = dtvCcPacket.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(131);
            sb.append("DtvCcPacket ended prematurely; size is ");
            sb.append((i2 * 2) - 1);
            sb.append(", but current index is ");
            sb.append(i);
            sb.append(" (sequence number ");
            sb.append(i3);
            sb.append("); ignoring packet");
            com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb.toString());
            return;
        }
        this.h.reset(dtvCcPacket.c, i);
        int readBits = this.h.readBits(3);
        int readBits2 = this.h.readBits(5);
        if (readBits == 7) {
            this.h.skipBits(2);
            readBits = this.h.readBits(6);
            if (readBits < 7) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(44);
                sb2.append("Invalid extended service number: ");
                sb2.append(readBits);
                com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb2.toString());
            }
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(59);
                sb3.append("serviceNumber is non-zero (");
                sb3.append(readBits);
                sb3.append(") when blockSize is 0");
                com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb3.toString());
                return;
            }
            return;
        }
        if (readBits != this.j) {
            return;
        }
        boolean z = false;
        while (this.h.bitsLeft() > 0) {
            int readBits3 = this.h.readBits(8);
            if (readBits3 == 16) {
                int readBits4 = this.h.readBits(8);
                if (readBits4 <= 31) {
                    g(readBits4);
                } else {
                    if (readBits4 <= 127) {
                        l(readBits4);
                    } else if (readBits4 <= 159) {
                        h(readBits4);
                    } else if (readBits4 <= 255) {
                        m(readBits4);
                    } else {
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder(37);
                        sb4.append("Invalid extended command: ");
                        sb4.append(readBits4);
                        com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb4.toString());
                    }
                    z = true;
                }
            } else if (readBits3 <= 31) {
                e(readBits3);
            } else {
                if (readBits3 <= 127) {
                    j(readBits3);
                } else if (readBits3 <= 159) {
                    f(readBits3);
                } else if (readBits3 <= 255) {
                    k(readBits3);
                } else {
                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder(33);
                    sb5.append("Invalid base command: ");
                    sb5.append(readBits3);
                    com.google.android.exoplayer2.util.Log.w("Cea708Decoder", sb5.toString());
                }
                z = true;
            }
        }
        if (z) {
            this.m = d();
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public final void t() {
        for (int i = 0; i < 8; i++) {
            this.k[i].l();
        }
    }
}
