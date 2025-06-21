package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public interface Subtitle {
    java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
