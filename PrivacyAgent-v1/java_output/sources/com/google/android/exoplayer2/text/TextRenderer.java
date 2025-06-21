package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public final class TextRenderer extends com.google.android.exoplayer2.BaseRenderer implements android.os.Handler.Callback {

    @androidx.annotation.Nullable
    public final android.os.Handler E;
    public final com.google.android.exoplayer2.text.TextOutput F;
    public final com.google.android.exoplayer2.text.SubtitleDecoderFactory G;
    public final com.google.android.exoplayer2.FormatHolder H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format M;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleDecoder N;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleInputBuffer O;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleOutputBuffer P;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleOutputBuffer Q;
    public int R;

    public TextRenderer(com.google.android.exoplayer2.text.TextOutput textOutput, @androidx.annotation.Nullable android.os.Looper looper) {
        this(textOutput, looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(com.google.android.exoplayer2.text.TextOutput textOutput, @androidx.annotation.Nullable android.os.Looper looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.F = (com.google.android.exoplayer2.text.TextOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(textOutput);
        this.E = looper == null ? null : com.google.android.exoplayer2.util.Util.createHandler(looper, this);
        this.G = subtitleDecoderFactory;
        this.H = new com.google.android.exoplayer2.FormatHolder();
    }

    public final void a() {
        h(java.util.Collections.emptyList());
    }

    public final long b() {
        if (this.R == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.P);
        if (this.R >= this.P.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.P.getEventTime(this.R);
    }

    public final void c(com.google.android.exoplayer2.text.SubtitleDecoderException subtitleDecoderException) {
        java.lang.String valueOf = java.lang.String.valueOf(this.M);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(valueOf);
        com.google.android.exoplayer2.util.Log.e("TextRenderer", sb.toString(), subtitleDecoderException);
        a();
        g();
    }

    public final void d() {
        this.K = true;
        this.N = this.G.createDecoder((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.M));
    }

    public final void e(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        this.F.onCues(list);
    }

    public final void f() {
        this.O = null;
        this.R = -1;
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer = this.P;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.P = null;
        }
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer2 = this.Q;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.Q = null;
        }
    }

    public final void g() {
        releaseDecoder();
        d();
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public java.lang.String getName() {
        return "TextRenderer";
    }

    public final void h(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        android.os.Handler handler = this.E;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            e(list);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 0) {
            throw new java.lang.IllegalStateException();
        }
        e((java.util.List) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.J;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.M = null;
        a();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        a();
        this.I = false;
        this.J = false;
        if (this.L != 0) {
            g();
        } else {
            f();
            ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) {
        this.M = formatArr[0];
        if (this.N != null) {
            this.L = 1;
        } else {
            d();
        }
    }

    public final void releaseDecoder() {
        f();
        ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).release();
        this.N = null;
        this.L = 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean z;
        if (this.J) {
            return;
        }
        if (this.Q == null) {
            ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).setPositionUs(j);
            try {
                this.Q = ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).dequeueOutputBuffer();
            } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e) {
                c(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.P != null) {
            long b = b();
            z = false;
            while (b <= j) {
                this.R++;
                b = b();
                z = true;
            }
        } else {
            z = false;
        }
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer = this.Q;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.isEndOfStream()) {
                if (!z && b() == Long.MAX_VALUE) {
                    if (this.L == 2) {
                        g();
                    } else {
                        f();
                        this.J = true;
                    }
                }
            } else if (subtitleOutputBuffer.timeUs <= j) {
                com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer2 = this.P;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.release();
                }
                this.R = subtitleOutputBuffer.getNextEventTimeIndex(j);
                this.P = subtitleOutputBuffer;
                this.Q = null;
                z = true;
            }
        }
        if (z) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.P);
            h(this.P.getCues(j));
        }
        if (this.L == 2) {
            return;
        }
        while (!this.I) {
            try {
                com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer = this.O;
                if (subtitleInputBuffer == null) {
                    subtitleInputBuffer = ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).dequeueInputBuffer();
                    if (subtitleInputBuffer == null) {
                        return;
                    } else {
                        this.O = subtitleInputBuffer;
                    }
                }
                if (this.L == 1) {
                    subtitleInputBuffer.setFlags(4);
                    ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).queueInputBuffer(subtitleInputBuffer);
                    this.O = null;
                    this.L = 2;
                    return;
                }
                int readSource = readSource(this.H, subtitleInputBuffer, false);
                if (readSource == -4) {
                    if (subtitleInputBuffer.isEndOfStream()) {
                        this.I = true;
                        this.K = false;
                    } else {
                        com.google.android.exoplayer2.Format format = this.H.format;
                        if (format == null) {
                            return;
                        }
                        subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                        subtitleInputBuffer.flip();
                        this.K &= !subtitleInputBuffer.isKeyFrame();
                    }
                    if (!this.K) {
                        ((com.google.android.exoplayer2.text.SubtitleDecoder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.N)).queueInputBuffer(subtitleInputBuffer);
                        this.O = null;
                    }
                } else if (readSource == -3) {
                    return;
                }
            } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e2) {
                c(e2);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (this.G.supportsFormat(format)) {
            return defpackage.ub2.a(format.exoMediaCryptoType == null ? 4 : 2);
        }
        return com.google.android.exoplayer2.util.MimeTypes.isText(format.sampleMimeType) ? defpackage.ub2.a(1) : defpackage.ub2.a(0);
    }
}
