package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
public final class WebvttCueInfo {
    public final com.google.android.exoplayer2.text.Cue cue;
    public final long endTimeUs;
    public final long startTimeUs;

    public WebvttCueInfo(com.google.android.exoplayer2.text.Cue cue, long j, long j2) {
        this.cue = cue;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }
}
