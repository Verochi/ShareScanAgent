package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
final class Mp4WebvttSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public final java.util.List<com.google.android.exoplayer2.text.Cue> n;

    public Mp4WebvttSubtitle(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        this.n = java.util.Collections.unmodifiableList(list);
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
