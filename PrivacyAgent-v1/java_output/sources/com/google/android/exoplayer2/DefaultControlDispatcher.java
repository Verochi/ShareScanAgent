package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public class DefaultControlDispatcher implements com.google.android.exoplayer2.ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    public final com.google.android.exoplayer2.Timeline.Window a;
    public long b;
    public long c;

    public DefaultControlDispatcher() {
        this(15000L, 5000L);
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.c = j;
        this.b = j2;
        this.a = new com.google.android.exoplayer2.Timeline.Window();
    }

    public static void a(com.google.android.exoplayer2.Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = java.lang.Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), java.lang.Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchFastForward(com.google.android.exoplayer2.Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        a(player, this.c);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchNext(com.google.android.exoplayer2.Player player) {
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, -9223372036854775807L);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.a).isLive) {
                player.seekTo(currentWindowIndex, -9223372036854775807L);
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r3.isSeekable == false) goto L15;
     */
    @Override // com.google.android.exoplayer2.ControlDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchPrevious(com.google.android.exoplayer2.Player player) {
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.a);
            int previousWindowIndex = player.getPreviousWindowIndex();
            if (previousWindowIndex != -1) {
                if (player.getCurrentPosition() > 3000) {
                    com.google.android.exoplayer2.Timeline.Window window = this.a;
                    if (window.isDynamic) {
                    }
                }
                player.seekTo(previousWindowIndex, -9223372036854775807L);
            }
            player.seekTo(currentWindowIndex, 0L);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchRewind(com.google.android.exoplayer2.Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        a(player, -this.b);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(com.google.android.exoplayer2.Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(com.google.android.exoplayer2.Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(com.google.android.exoplayer2.Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(com.google.android.exoplayer2.Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(com.google.android.exoplayer2.Player player, boolean z) {
        player.stop(z);
        return true;
    }

    public long getFastForwardIncrementMs() {
        return this.c;
    }

    public long getRewindIncrementMs() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isFastForwardEnabled() {
        return this.c > 0;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isRewindEnabled() {
        return this.b > 0;
    }

    @java.lang.Deprecated
    public void setFastForwardIncrementMs(long j) {
        this.c = j;
    }

    @java.lang.Deprecated
    public void setRewindIncrementMs(long j) {
        this.b = j;
    }
}
