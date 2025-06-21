package com.google.android.exoplayer2.metadata;

/* loaded from: classes22.dex */
public abstract class SimpleMetadataDecoder implements com.google.android.exoplayer2.metadata.MetadataDecoder {
    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer) {
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataInputBuffer.data);
        com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (metadataInputBuffer.isDecodeOnly()) {
            return null;
        }
        return decode(metadataInputBuffer, byteBuffer);
    }

    @androidx.annotation.Nullable
    public abstract com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer);
}
