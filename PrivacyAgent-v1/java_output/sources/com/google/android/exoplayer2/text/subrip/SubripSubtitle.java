package com.google.android.exoplayer2.text.subrip;

/* loaded from: classes22.dex */
final class SubripSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public final com.google.android.exoplayer2.text.Cue[] n;
    public final long[] t;

    public SubripSubtitle(com.google.android.exoplayer2.text.Cue[] cueArr, long[] jArr) {
        this.n = cueArr;
        this.t = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        com.google.android.exoplayer2.text.Cue cue;
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.t, j, true, false);
        return (binarySearchFloor == -1 || (cue = this.n[binarySearchFloor]) == com.google.android.exoplayer2.text.Cue.EMPTY) ? java.util.Collections.emptyList() : java.util.Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i < this.t.length);
        return this.t[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.t.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.t, j, false, false);
        if (binarySearchCeil < this.t.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
