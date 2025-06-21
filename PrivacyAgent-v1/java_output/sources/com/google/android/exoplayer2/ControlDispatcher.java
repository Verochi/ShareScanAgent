package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public interface ControlDispatcher {
    boolean dispatchFastForward(com.google.android.exoplayer2.Player player);

    boolean dispatchNext(com.google.android.exoplayer2.Player player);

    boolean dispatchPrevious(com.google.android.exoplayer2.Player player);

    boolean dispatchRewind(com.google.android.exoplayer2.Player player);

    boolean dispatchSeekTo(com.google.android.exoplayer2.Player player, int i, long j);

    boolean dispatchSetPlayWhenReady(com.google.android.exoplayer2.Player player, boolean z);

    boolean dispatchSetRepeatMode(com.google.android.exoplayer2.Player player, int i);

    boolean dispatchSetShuffleModeEnabled(com.google.android.exoplayer2.Player player, boolean z);

    boolean dispatchStop(com.google.android.exoplayer2.Player player, boolean z);

    boolean isFastForwardEnabled();

    boolean isRewindEnabled();
}
