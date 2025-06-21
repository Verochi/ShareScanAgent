package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public interface MediaClock {
    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);
}
