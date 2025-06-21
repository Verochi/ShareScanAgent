package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
final class SimpleSubtitleOutputBuffer extends com.google.android.exoplayer2.text.SubtitleOutputBuffer {
    public final com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.text.SubtitleOutputBuffer> u;

    public SimpleSubtitleOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.text.SubtitleOutputBuffer> owner) {
        this.u = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.u.releaseOutputBuffer(this);
    }
}
