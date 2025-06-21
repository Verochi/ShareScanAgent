package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class xj2 implements com.google.android.exoplayer2.decoder.OutputBuffer.Owner {
    public final /* synthetic */ com.google.android.exoplayer2.text.SimpleSubtitleDecoder a;

    public /* synthetic */ xj2(com.google.android.exoplayer2.text.SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.a = simpleSubtitleDecoder;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer.Owner
    public final void releaseOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer outputBuffer) {
        this.a.releaseOutputBuffer((com.google.android.exoplayer2.text.SubtitleOutputBuffer) outputBuffer);
    }
}
