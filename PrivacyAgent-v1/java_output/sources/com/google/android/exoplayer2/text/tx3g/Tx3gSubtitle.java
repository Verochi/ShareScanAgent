package com.google.android.exoplayer2.text.tx3g;

/* loaded from: classes22.dex */
final class Tx3gSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public static final com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle t = new com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle();
    public final java.util.List<com.google.android.exoplayer2.text.Cue> n;

    public Tx3gSubtitle() {
        this.n = java.util.Collections.emptyList();
    }

    public Tx3gSubtitle(com.google.android.exoplayer2.text.Cue cue) {
        this.n = java.util.Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        return j >= 0 ? this.n : java.util.Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }
}
