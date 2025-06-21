package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public abstract class SimpleSubtitleDecoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.text.SubtitleInputBuffer, com.google.android.exoplayer2.text.SubtitleOutputBuffer, com.google.android.exoplayer2.text.SubtitleDecoderException> implements com.google.android.exoplayer2.text.SubtitleDecoder {
    public final java.lang.String n;

    public SimpleSubtitleDecoder(java.lang.String str) {
        super(new com.google.android.exoplayer2.text.SubtitleInputBuffer[2], new com.google.android.exoplayer2.text.SubtitleOutputBuffer[2]);
        this.n = str;
        setInitialInputBufferSize(1024);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final com.google.android.exoplayer2.text.SubtitleInputBuffer createInputBuffer() {
        return new com.google.android.exoplayer2.text.SubtitleInputBuffer();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final com.google.android.exoplayer2.text.SubtitleOutputBuffer createOutputBuffer() {
        return new com.google.android.exoplayer2.text.SimpleSubtitleOutputBuffer(new defpackage.xj2(this));
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final com.google.android.exoplayer2.text.SubtitleDecoderException createUnexpectedDecodeException(java.lang.Throwable th) {
        return new com.google.android.exoplayer2.text.SubtitleDecoderException("Unexpected decode error", th);
    }

    public abstract com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.text.SubtitleDecoderException;

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.text.SubtitleDecoderException decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer, com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(subtitleInputBuffer.data);
            subtitleOutputBuffer.setContent(subtitleInputBuffer.timeUs, decode(byteBuffer.array(), byteBuffer.limit(), z), subtitleInputBuffer.subsampleOffsetUs);
            subtitleOutputBuffer.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e) {
            return e;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final java.lang.String getName() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
    }
}
