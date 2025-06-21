package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes22.dex */
public final class EventMessageDecoder extends com.google.android.exoplayer2.metadata.SimpleMetadataDecoder {
    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer) {
        return new com.google.android.exoplayer2.metadata.Metadata(decode(new com.google.android.exoplayer2.util.ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public com.google.android.exoplayer2.metadata.emsg.EventMessage decode(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return new com.google.android.exoplayer2.metadata.emsg.EventMessage((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt(), java.util.Arrays.copyOfRange(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.limit()));
    }
}
