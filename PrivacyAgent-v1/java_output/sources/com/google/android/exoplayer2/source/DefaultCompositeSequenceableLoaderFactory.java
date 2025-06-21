package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class DefaultCompositeSequenceableLoaderFactory implements com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory {
    @Override // com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory
    public com.google.android.exoplayer2.source.SequenceableLoader createCompositeSequenceableLoader(com.google.android.exoplayer2.source.SequenceableLoader... sequenceableLoaderArr) {
        return new com.google.android.exoplayer2.source.CompositeSequenceableLoader(sequenceableLoaderArr);
    }
}
