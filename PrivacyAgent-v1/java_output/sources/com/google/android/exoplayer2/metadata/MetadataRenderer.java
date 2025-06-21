package com.google.android.exoplayer2.metadata;

/* loaded from: classes22.dex */
public final class MetadataRenderer extends com.google.android.exoplayer2.BaseRenderer implements android.os.Handler.Callback {
    public final com.google.android.exoplayer2.metadata.MetadataDecoderFactory E;
    public final com.google.android.exoplayer2.metadata.MetadataOutput F;

    @androidx.annotation.Nullable
    public final android.os.Handler G;
    public final com.google.android.exoplayer2.metadata.MetadataInputBuffer H;
    public final com.google.android.exoplayer2.metadata.Metadata[] I;
    public final long[] J;
    public int K;
    public int L;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.MetadataDecoder M;
    public boolean N;
    public long O;

    public MetadataRenderer(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, @androidx.annotation.Nullable android.os.Looper looper) {
        this(metadataOutput, looper, com.google.android.exoplayer2.metadata.MetadataDecoderFactory.DEFAULT);
    }

    public MetadataRenderer(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, @androidx.annotation.Nullable android.os.Looper looper, com.google.android.exoplayer2.metadata.MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        this.F = (com.google.android.exoplayer2.metadata.MetadataOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataOutput);
        this.G = looper == null ? null : com.google.android.exoplayer2.util.Util.createHandler(looper, this);
        this.E = (com.google.android.exoplayer2.metadata.MetadataDecoderFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataDecoderFactory);
        this.H = new com.google.android.exoplayer2.metadata.MetadataInputBuffer();
        this.I = new com.google.android.exoplayer2.metadata.Metadata[5];
        this.J = new long[5];
    }

    public final void a(com.google.android.exoplayer2.metadata.Metadata metadata, java.util.List<com.google.android.exoplayer2.metadata.Metadata.Entry> list) {
        for (int i = 0; i < metadata.length(); i++) {
            com.google.android.exoplayer2.Format wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.E.supportsFormat(wrappedMetadataFormat)) {
                list.add(metadata.get(i));
            } else {
                com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder = this.E.createDecoder(wrappedMetadataFormat);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadata.get(i).getWrappedMetadataBytes());
                this.H.clear();
                this.H.ensureSpaceForWrite(bArr.length);
                ((java.nio.ByteBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.H.data)).put(bArr);
                this.H.flip();
                com.google.android.exoplayer2.metadata.Metadata decode = createDecoder.decode(this.H);
                if (decode != null) {
                    a(decode, list);
                }
            }
        }
    }

    public final void b() {
        java.util.Arrays.fill(this.I, (java.lang.Object) null);
        this.K = 0;
        this.L = 0;
    }

    public final void c(com.google.android.exoplayer2.metadata.Metadata metadata) {
        android.os.Handler handler = this.G;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            d(metadata);
        }
    }

    public final void d(com.google.android.exoplayer2.metadata.Metadata metadata) {
        this.F.onMetadata(metadata);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public java.lang.String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 0) {
            throw new java.lang.IllegalStateException();
        }
        d((com.google.android.exoplayer2.metadata.Metadata) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.N;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        b();
        this.M = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        b();
        this.N = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) {
        this.M = this.E.createDecoder(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (!this.N && this.L < 5) {
            this.H.clear();
            com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
            int readSource = readSource(formatHolder, this.H, false);
            if (readSource == -4) {
                if (this.H.isEndOfStream()) {
                    this.N = true;
                } else {
                    com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer = this.H;
                    metadataInputBuffer.subsampleOffsetUs = this.O;
                    metadataInputBuffer.flip();
                    com.google.android.exoplayer2.metadata.Metadata decode = ((com.google.android.exoplayer2.metadata.MetadataDecoder) com.google.android.exoplayer2.util.Util.castNonNull(this.M)).decode(this.H);
                    if (decode != null) {
                        java.util.ArrayList arrayList = new java.util.ArrayList(decode.length());
                        a(decode, arrayList);
                        if (!arrayList.isEmpty()) {
                            com.google.android.exoplayer2.metadata.Metadata metadata = new com.google.android.exoplayer2.metadata.Metadata(arrayList);
                            int i = this.K;
                            int i2 = this.L;
                            int i3 = (i + i2) % 5;
                            this.I[i3] = metadata;
                            this.J[i3] = this.H.timeUs;
                            this.L = i2 + 1;
                        }
                    }
                }
            } else if (readSource == -5) {
                this.O = ((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
            }
        }
        if (this.L > 0) {
            long[] jArr = this.J;
            int i4 = this.K;
            if (jArr[i4] <= j) {
                c((com.google.android.exoplayer2.metadata.Metadata) com.google.android.exoplayer2.util.Util.castNonNull(this.I[i4]));
                com.google.android.exoplayer2.metadata.Metadata[] metadataArr = this.I;
                int i5 = this.K;
                metadataArr[i5] = null;
                this.K = (i5 + 1) % 5;
                this.L--;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (this.E.supportsFormat(format)) {
            return defpackage.ub2.a(format.exoMediaCryptoType == null ? 4 : 2);
        }
        return defpackage.ub2.a(0);
    }
}
