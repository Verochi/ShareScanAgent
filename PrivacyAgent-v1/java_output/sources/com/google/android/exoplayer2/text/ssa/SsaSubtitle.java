package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes22.dex */
final class SsaSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public final java.util.List<java.util.List<com.google.android.exoplayer2.text.Cue>> n;
    public final java.util.List<java.lang.Long> t;

    public SsaSubtitle(java.util.List<java.util.List<com.google.android.exoplayer2.text.Cue>> list, java.util.List<java.lang.Long> list2) {
        this.n = list;
        this.t = list2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor((java.util.List<? extends java.lang.Comparable<? super java.lang.Long>>) this.t, java.lang.Long.valueOf(j), true, false);
        return binarySearchFloor == -1 ? java.util.Collections.emptyList() : this.n.get(binarySearchFloor);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i < this.t.size());
        return this.t.get(i).longValue();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.t.size();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil((java.util.List<? extends java.lang.Comparable<? super java.lang.Long>>) this.t, java.lang.Long.valueOf(j), false, false);
        if (binarySearchCeil < this.t.size()) {
            return binarySearchCeil;
        }
        return -1;
    }
}
