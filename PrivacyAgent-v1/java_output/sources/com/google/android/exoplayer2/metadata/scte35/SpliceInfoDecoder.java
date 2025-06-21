package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes22.dex */
public final class SpliceInfoDecoder extends com.google.android.exoplayer2.metadata.SimpleMetadataDecoder {
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray();
    public final com.google.android.exoplayer2.util.ParsableBitArray b = new com.google.android.exoplayer2.util.ParsableBitArray();
    public com.google.android.exoplayer2.util.TimestampAdjuster c;

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer) {
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.c;
        if (timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster2 = new com.google.android.exoplayer2.util.TimestampAdjuster(metadataInputBuffer.timeUs);
            this.c = timestampAdjuster2;
            timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.a.reset(array, limit);
        this.b.reset(array, limit);
        this.b.skipBits(39);
        long readBits = (this.b.readBits(1) << 32) | this.b.readBits(32);
        this.b.skipBits(20);
        int readBits2 = this.b.readBits(12);
        int readBits3 = this.b.readBits(8);
        this.a.skipBytes(14);
        com.google.android.exoplayer2.metadata.Metadata.Entry parseFromSection = readBits3 != 0 ? readBits3 != 255 ? readBits3 != 4 ? readBits3 != 5 ? readBits3 != 6 ? null : com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.parseFromSection(this.a, readBits, this.c) : com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.parseFromSection(this.a, readBits, this.c) : com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.parseFromSection(this.a) : com.google.android.exoplayer2.metadata.scte35.PrivateCommand.parseFromSection(this.a, readBits2, readBits) : new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand();
        return parseFromSection == null ? new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.metadata.Metadata.Entry[0]) : new com.google.android.exoplayer2.metadata.Metadata(parseFromSection);
    }
}
