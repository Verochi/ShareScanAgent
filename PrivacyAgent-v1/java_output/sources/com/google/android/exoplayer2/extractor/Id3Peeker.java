package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class Id3Peeker {
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray(10);

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata peekId3Data(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) throws java.io.IOException {
        com.google.android.exoplayer2.metadata.Metadata metadata = null;
        int i = 0;
        while (true) {
            try {
                extractorInput.peekFully(this.a.getData(), 0, 10);
                this.a.setPosition(0);
                if (this.a.readUnsignedInt24() != 4801587) {
                    break;
                }
                this.a.skipBytes(3);
                int readSynchSafeInt = this.a.readSynchSafeInt();
                int i2 = readSynchSafeInt + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i2];
                    java.lang.System.arraycopy(this.a.getData(), 0, bArr, 0, 10);
                    extractorInput.peekFully(bArr, 10, readSynchSafeInt);
                    metadata = new com.google.android.exoplayer2.metadata.id3.Id3Decoder(framePredicate).decode(bArr, i2);
                } else {
                    extractorInput.advancePeekPosition(readSynchSafeInt);
                }
                i += i2;
            } catch (java.io.EOFException unused) {
            }
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        return metadata;
    }
}
