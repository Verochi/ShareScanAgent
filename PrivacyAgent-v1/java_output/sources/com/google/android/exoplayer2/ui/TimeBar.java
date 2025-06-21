package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public interface TimeBar {

    public interface OnScrubListener {
        void onScrubMove(com.google.android.exoplayer2.ui.TimeBar timeBar, long j);

        void onScrubStart(com.google.android.exoplayer2.ui.TimeBar timeBar, long j);

        void onScrubStop(com.google.android.exoplayer2.ui.TimeBar timeBar, long j, boolean z);
    }

    void addListener(com.google.android.exoplayer2.ui.TimeBar.OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void removeListener(com.google.android.exoplayer2.ui.TimeBar.OnScrubListener onScrubListener);

    void setAdGroupTimesMs(@androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setKeyCountIncrement(int i);

    void setKeyTimeIncrement(long j);

    void setPosition(long j);
}
