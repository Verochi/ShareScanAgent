package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public interface TrackSelection {

    public static final class Definition {

        @androidx.annotation.Nullable
        public final java.lang.Object data;
        public final com.google.android.exoplayer2.source.TrackGroup group;
        public final int reason;
        public final int[] tracks;

        public Definition(com.google.android.exoplayer2.source.TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0, null);
        }

        public Definition(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i, @androidx.annotation.Nullable java.lang.Object obj) {
            this.group = trackGroup;
            this.tracks = iArr;
            this.reason = i;
            this.data = obj;
        }
    }

    public interface Factory {
        com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter);
    }

    boolean blacklist(int i, long j);

    void disable();

    void enable();

    int evaluateQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);

    com.google.android.exoplayer2.Format getFormat(int i);

    int getIndexInTrackGroup(int i);

    com.google.android.exoplayer2.Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @androidx.annotation.Nullable
    java.lang.Object getSelectionData();

    int getSelectionReason();

    com.google.android.exoplayer2.source.TrackGroup getTrackGroup();

    int indexOf(int i);

    int indexOf(com.google.android.exoplayer2.Format format);

    int length();

    void onDiscontinuity();

    void onPlaybackSpeed(float f);

    boolean shouldCancelChunkLoad(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);

    void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr);
}
