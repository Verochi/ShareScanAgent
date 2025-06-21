package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public final class FixedTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    public final int d;

    @androidx.annotation.Nullable
    public final java.lang.Object e;

    @java.lang.Deprecated
    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        public final int a;

        @androidx.annotation.Nullable
        public final java.lang.Object b;

        public Factory() {
            this.a = 0;
            this.b = null;
        }

        public Factory(int i, @androidx.annotation.Nullable java.lang.Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ com.google.android.exoplayer2.trackselection.TrackSelection b(com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition) {
            return new com.google.android.exoplayer2.trackselection.FixedTrackSelection(definition.group, definition.tracks[0], this.a, this.b);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            return com.google.android.exoplayer2.trackselection.TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new defpackage.af0(this));
        }
    }

    public FixedTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0, null);
    }

    public FixedTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        super(trackGroup, i);
        this.d = i2;
        this.e = obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    @androidx.annotation.Nullable
    public java.lang.Object getSelectionData() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
    }
}
