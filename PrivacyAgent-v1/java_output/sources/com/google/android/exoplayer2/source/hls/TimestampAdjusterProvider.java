package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class TimestampAdjusterProvider {
    public final android.util.SparseArray<com.google.android.exoplayer2.util.TimestampAdjuster> a = new android.util.SparseArray<>();

    public com.google.android.exoplayer2.util.TimestampAdjuster getAdjuster(int i) {
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.a.get(i);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster2 = new com.google.android.exoplayer2.util.TimestampAdjuster(Long.MAX_VALUE);
        this.a.put(i, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void reset() {
        this.a.clear();
    }
}
