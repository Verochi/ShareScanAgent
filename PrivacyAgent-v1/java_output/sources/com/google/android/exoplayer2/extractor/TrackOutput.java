package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public interface TrackOutput {
    public static final int SAMPLE_DATA_PART_ENCRYPTION = 1;
    public static final int SAMPLE_DATA_PART_MAIN = 0;
    public static final int SAMPLE_DATA_PART_SUPPLEMENTAL = 2;

    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int i, byte[] bArr, int i2, int i3) {
            this.cryptoMode = i;
            this.encryptionKey = bArr;
            this.encryptedBlocks = i2;
            this.clearBlocks = i3;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.extractor.TrackOutput.CryptoData.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData = (com.google.android.exoplayer2.extractor.TrackOutput.CryptoData) obj;
            return this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && java.util.Arrays.equals(this.encryptionKey, cryptoData.encryptionKey);
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + java.util.Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    void format(com.google.android.exoplayer2.Format format);

    int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) throws java.io.IOException;

    int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException;

    void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i);

    void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2);

    void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData);
}
