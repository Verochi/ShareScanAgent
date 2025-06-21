package com.google.android.exoplayer2.text.cea;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements com.google.android.exoplayer2.decoder.OutputBuffer.Owner {
    public final /* synthetic */ com.google.android.exoplayer2.text.cea.CeaDecoder a;

    public /* synthetic */ b(com.google.android.exoplayer2.text.cea.CeaDecoder ceaDecoder) {
        this.a = ceaDecoder;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer.Owner
    public final void releaseOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer outputBuffer) {
        this.a.releaseOutputBuffer((com.google.android.exoplayer2.text.cea.CeaDecoder.CeaOutputBuffer) outputBuffer);
    }
}
