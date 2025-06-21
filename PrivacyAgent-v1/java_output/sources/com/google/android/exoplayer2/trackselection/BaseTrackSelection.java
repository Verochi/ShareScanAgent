package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public abstract class BaseTrackSelection implements com.google.android.exoplayer2.trackselection.TrackSelection {
    public final com.google.android.exoplayer2.Format[] a;
    public final long[] b;
    public int c;
    protected final com.google.android.exoplayer2.source.TrackGroup group;
    protected final int length;
    protected final int[] tracks;

    public BaseTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.util.Assertions.checkState(iArr.length > 0);
        this.group = (com.google.android.exoplayer2.source.TrackGroup) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.a = new com.google.android.exoplayer2.Format[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.a[i2] = trackGroup.getFormat(iArr[i2]);
        }
        java.util.Arrays.sort(this.a, new defpackage.uh());
        this.tracks = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i >= i3) {
                this.b = new long[i3];
                return;
            } else {
                this.tracks[i] = trackGroup.indexOf(this.a[i]);
                i++;
            }
        }
    }

    public static /* synthetic */ int b(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return format2.bitrate - format.bitrate;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int i, long j) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !isBlacklisted) {
            isBlacklisted = (i2 == i || isBlacklisted(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.b;
        jArr[i] = java.lang.Math.max(jArr[i], com.google.android.exoplayer2.util.Util.addWithOverflowDefault(elapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.BaseTrackSelection baseTrackSelection = (com.google.android.exoplayer2.trackselection.BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && java.util.Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.Format getFormat(int i) {
        return this.a[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.tracks[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.Format getSelectedFormat() {
        return this.a[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.source.TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = (java.lang.System.identityHashCode(this.group) * 31) + java.util.Arrays.hashCode(this.tracks);
        }
        return this.c;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(com.google.android.exoplayer2.Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.a[i] == format) {
                return i;
            }
        }
        return -1;
    }

    public final boolean isBlacklisted(int i, long j) {
        return this.b[i] > j;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public /* synthetic */ void onDiscontinuity() {
        defpackage.q33.a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f) {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public /* synthetic */ boolean shouldCancelChunkLoad(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List list) {
        return defpackage.q33.b(this, j, chunk, list);
    }
}
