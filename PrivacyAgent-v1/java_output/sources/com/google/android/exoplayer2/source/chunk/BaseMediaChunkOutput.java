package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public final class BaseMediaChunkOutput implements com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider {
    public final int[] a;
    public final com.google.android.exoplayer2.source.SampleQueue[] b;

    public BaseMediaChunkOutput(int[] iArr, com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr) {
        this.a = iArr;
        this.b = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.b;
            if (i >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i] = sampleQueueArr[i].getWriteIndex();
            i++;
        }
    }

    public void setSampleOffsetUs(long j) {
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.b) {
            sampleQueue.setSampleOffsetUs(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i2);
                com.google.android.exoplayer2.util.Log.e("BaseMediaChunkOutput", sb.toString());
                return new com.google.android.exoplayer2.extractor.DummyTrackOutput();
            }
            if (i2 == iArr[i3]) {
                return this.b[i3];
            }
            i3++;
        }
    }
}
