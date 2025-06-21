package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public abstract class SubtitleOutputBuffer extends com.google.android.exoplayer2.decoder.OutputBuffer implements com.google.android.exoplayer2.text.Subtitle {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.text.Subtitle n;
    public long t;

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.n = null;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        return ((com.google.android.exoplayer2.text.Subtitle) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).getCues(j - this.t);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return ((com.google.android.exoplayer2.text.Subtitle) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).getEventTime(i) + this.t;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return ((com.google.android.exoplayer2.text.Subtitle) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).getEventTimeCount();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return ((com.google.android.exoplayer2.text.Subtitle) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).getNextEventTimeIndex(j - this.t);
    }

    public void setContent(long j, com.google.android.exoplayer2.text.Subtitle subtitle, long j2) {
        this.timeUs = j;
        this.n = subtitle;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.t = j;
    }
}
