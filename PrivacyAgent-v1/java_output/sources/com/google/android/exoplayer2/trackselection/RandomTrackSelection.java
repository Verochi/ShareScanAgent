package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public final class RandomTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    public final java.util.Random d;
    public int e;

    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        public final java.util.Random a;

        public Factory() {
            this.a = new java.util.Random();
        }

        public Factory(int i) {
            this.a = new java.util.Random(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ com.google.android.exoplayer2.trackselection.TrackSelection b(com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition) {
            return new com.google.android.exoplayer2.trackselection.RandomTrackSelection(definition.group, definition.tracks, this.a);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            return com.google.android.exoplayer2.trackselection.TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new defpackage.ea2(this));
        }
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        java.util.Random random = new java.util.Random();
        this.d = random;
        this.e = random.nextInt(this.length);
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, long j) {
        this(trackGroup, iArr, new java.util.Random(j));
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, java.util.Random random) {
        super(trackGroup, iArr);
        this.d = random;
        this.e = random.nextInt(this.length);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    @androidx.annotation.Nullable
    public java.lang.Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return 3;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (!isBlacklisted(i2, elapsedRealtime)) {
                i++;
            }
        }
        this.e = this.d.nextInt(i);
        if (i != this.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.length; i4++) {
                if (!isBlacklisted(i4, elapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.e == i3) {
                        this.e = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }
}
