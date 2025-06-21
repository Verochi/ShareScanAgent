package com.google.android.exoplayer2.text.cea;

/* loaded from: classes22.dex */
abstract class CeaDecoder implements com.google.android.exoplayer2.text.SubtitleDecoder {
    public final java.util.ArrayDeque<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> a = new java.util.ArrayDeque<>();
    public final java.util.ArrayDeque<com.google.android.exoplayer2.text.SubtitleOutputBuffer> b;
    public final java.util.PriorityQueue<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer d;
    public long e;
    public long f;

    public static final class CeaInputBuffer extends com.google.android.exoplayer2.text.SubtitleInputBuffer implements java.lang.Comparable<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> {
        public long u;

        public CeaInputBuffer() {
        }

        public /* synthetic */ CeaInputBuffer(com.google.android.exoplayer2.text.cea.CeaDecoder.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() != ceaInputBuffer.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j = this.timeUs - ceaInputBuffer.timeUs;
            if (j == 0) {
                j = this.u - ceaInputBuffer.u;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    public static final class CeaOutputBuffer extends com.google.android.exoplayer2.text.SubtitleOutputBuffer {
        public com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaOutputBuffer> u;

        public CeaOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaOutputBuffer> owner) {
            this.u = owner;
        }

        @Override // com.google.android.exoplayer2.decoder.OutputBuffer
        public final void release() {
            this.u.releaseOutputBuffer(this);
        }
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer(null));
        }
        this.b = new java.util.ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new com.google.android.exoplayer2.text.cea.CeaDecoder.CeaOutputBuffer(new com.google.android.exoplayer2.text.cea.b(this)));
        }
        this.c = new java.util.PriorityQueue<>();
    }

    public final void a(com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.a.add(ceaInputBuffer);
    }

    public abstract com.google.android.exoplayer2.text.Subtitle createSubtitle();

    public abstract void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleInputBuffer dequeueInputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer pollFirst = this.a.pollFirst();
        this.d = pollFirst;
        return pollFirst;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.c.peek())).timeUs <= this.e) {
            com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer = (com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.c.poll());
            if (ceaInputBuffer.isEndOfStream()) {
                com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer = (com.google.android.exoplayer2.text.SubtitleOutputBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.b.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                a(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            decode(ceaInputBuffer);
            if (isNewSubtitleDataAvailable()) {
                com.google.android.exoplayer2.text.Subtitle createSubtitle = createSubtitle();
                com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer2 = (com.google.android.exoplayer2.text.SubtitleOutputBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.b.pollFirst());
                subtitleOutputBuffer2.setContent(ceaInputBuffer.timeUs, createSubtitle, Long.MAX_VALUE);
                a(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            a(ceaInputBuffer);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            a((com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.c.poll()));
        }
        com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer = this.d;
        if (ceaInputBuffer != null) {
            a(ceaInputBuffer);
            this.d = null;
        }
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.text.SubtitleOutputBuffer getAvailableOutputBuffer() {
        return this.b.pollFirst();
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract java.lang.String getName();

    public final long getPositionUs() {
        return this.e;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.util.Assertions.checkArgument(subtitleInputBuffer == this.d);
        com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer = (com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.isDecodeOnly()) {
            a(ceaInputBuffer);
        } else {
            long j = this.f;
            this.f = 1 + j;
            ceaInputBuffer.u = j;
            this.c.add(ceaInputBuffer);
        }
        this.d = null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    public void releaseOutputBuffer(com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.b.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.e = j;
    }
}
