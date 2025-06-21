package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class FlacStreamMetadata {
    public static final int NOT_IN_LOOKUP_TABLE = -1;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.metadata.Metadata a;
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable seekTable;
    public final long totalSamples;

    public static class SeekTable {
        public final long[] pointOffsets;
        public final long[] pointSampleNumbers;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.pointSampleNumbers = jArr;
            this.pointOffsets = jArr2;
        }
    }

    public FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable seekTable, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        this.minBlockSizeSamples = i;
        this.maxBlockSizeSamples = i2;
        this.minFrameSize = i3;
        this.maxFrameSize = i4;
        this.sampleRate = i5;
        this.sampleRateLookupKey = c(i5);
        this.channels = i6;
        this.bitsPerSample = i7;
        this.bitsPerSampleLookupKey = b(i7);
        this.totalSamples = j;
        this.seekTable = seekTable;
        this.a = metadata;
    }

    public FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<com.google.android.exoplayer2.metadata.flac.PictureFrame> arrayList2) {
        this(i, i2, i3, i4, i5, i6, i7, j, (com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable) null, a(arrayList, arrayList2));
    }

    public FlacStreamMetadata(byte[] bArr, int i) {
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(bArr);
        parsableBitArray.setPosition(i * 8);
        this.minBlockSizeSamples = parsableBitArray.readBits(16);
        this.maxBlockSizeSamples = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        int readBits = parsableBitArray.readBits(20);
        this.sampleRate = readBits;
        this.sampleRateLookupKey = c(readBits);
        this.channels = parsableBitArray.readBits(3) + 1;
        int readBits2 = parsableBitArray.readBits(5) + 1;
        this.bitsPerSample = readBits2;
        this.bitsPerSampleLookupKey = b(readBits2);
        this.totalSamples = parsableBitArray.readBitsToLong(36);
        this.seekTable = null;
        this.a = null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata a(java.util.List<java.lang.String> list, java.util.List<com.google.android.exoplayer2.metadata.flac.PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            java.lang.String str = list.get(i);
            java.lang.String[] splitAtFirst = com.google.android.exoplayer2.util.Util.splitAtFirst(str, com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (splitAtFirst.length != 2) {
                java.lang.String valueOf = java.lang.String.valueOf(str);
                com.google.android.exoplayer2.util.Log.w("FlacStreamMetadata", valueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(valueOf) : new java.lang.String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new com.google.android.exoplayer2.metadata.flac.VorbisComment(splitAtFirst[0], splitAtFirst[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }

    public static int b(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int c(int i) {
        switch (i) {
            case 8000:
                return 4;
            case com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND /* 16000 */:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON /* 32000 */:
                return 8;
            case 44100:
                return 9;
            case com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE /* 48000 */:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND /* 192000 */:
                return 3;
            default:
                return -1;
        }
    }

    public com.google.android.exoplayer2.extractor.FlacStreamMetadata copyWithPictureFrames(java.util.List<com.google.android.exoplayer2.metadata.flac.PictureFrame> list) {
        return new com.google.android.exoplayer2.extractor.FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(a(java.util.Collections.emptyList(), list)));
    }

    public com.google.android.exoplayer2.extractor.FlacStreamMetadata copyWithSeekTable(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable seekTable) {
        return new com.google.android.exoplayer2.extractor.FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, seekTable, this.a);
    }

    public com.google.android.exoplayer2.extractor.FlacStreamMetadata copyWithVorbisComments(java.util.List<java.lang.String> list) {
        return new com.google.android.exoplayer2.extractor.FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(a(list, java.util.Collections.emptyList())));
    }

    public long getApproxBytesPerFrame() {
        long j;
        long j2;
        int i = this.maxFrameSize;
        if (i > 0) {
            j = (i + this.minFrameSize) / 2;
            j2 = 1;
        } else {
            int i2 = this.minBlockSizeSamples;
            j = ((((i2 != this.maxBlockSizeSamples || i2 <= 0) ? 4096L : i2) * this.channels) * this.bitsPerSample) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public int getDecodedBitrate() {
        return this.bitsPerSample * this.sampleRate * this.channels;
    }

    public long getDurationUs() {
        long j = this.totalSamples;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.sampleRate;
    }

    public com.google.android.exoplayer2.Format getFormat(byte[] bArr, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        bArr[4] = Byte.MIN_VALUE;
        int i = this.maxFrameSize;
        if (i <= 0) {
            i = -1;
        }
        return new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/flac").setMaxInputSize(i).setChannelCount(this.channels).setSampleRate(this.sampleRate).setInitializationData(java.util.Collections.singletonList(bArr)).setMetadata(getMetadataCopyWithAppendedEntriesFrom(metadata)).build();
    }

    public int getMaxDecodedFrameSize() {
        return this.maxBlockSizeSamples * this.channels * (this.bitsPerSample / 8);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata getMetadataCopyWithAppendedEntriesFrom(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        com.google.android.exoplayer2.metadata.Metadata metadata2 = this.a;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long getSampleNumber(long j) {
        return com.google.android.exoplayer2.util.Util.constrainValue((j * this.sampleRate) / 1000000, 0L, this.totalSamples - 1);
    }
}
