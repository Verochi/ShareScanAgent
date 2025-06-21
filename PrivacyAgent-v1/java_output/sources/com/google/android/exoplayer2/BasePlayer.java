package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public abstract class BasePlayer implements com.google.android.exoplayer2.Player {
    protected final com.google.android.exoplayer2.Timeline.Window window = new com.google.android.exoplayer2.Timeline.Window();

    public static final class ListenerHolder {
        public boolean a;
        public final com.google.android.exoplayer2.Player.EventListener listener;

        public ListenerHolder(com.google.android.exoplayer2.Player.EventListener eventListener) {
            this.listener = eventListener;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.BasePlayer.ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((com.google.android.exoplayer2.BasePlayer.ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invoke(com.google.android.exoplayer2.BasePlayer.ListenerInvocation listenerInvocation) {
            if (this.a) {
                return;
            }
            listenerInvocation.invokeListener(this.listener);
        }

        public void release() {
            this.a = true;
        }
    }

    public interface ListenerInvocation {
        void invokeListener(com.google.android.exoplayer2.Player.EventListener eventListener);
    }

    public final int a() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItem(int i, com.google.android.exoplayer2.MediaItem mediaItem) {
        addMediaItems(i, java.util.Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItem(com.google.android.exoplayer2.MediaItem mediaItem) {
        addMediaItems(java.util.Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return com.google.android.exoplayer2.util.Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentDuration() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getCurrentLiveOffset() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || currentTimeline.getWindow(getCurrentWindowIndex(), this.window).windowStartTimeMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public final java.lang.Object getCurrentManifest() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).manifest;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaItem getCurrentMediaItem() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public final java.lang.Object getCurrentTag() {
        com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties;
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || (playbackProperties = currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem.playbackProperties) == null) {
            return null;
        }
        return playbackProperties.tag;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getNextWindowIndex() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), a(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), a(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowDynamic() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowLive() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isLive;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void next() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void previous() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem) {
        setMediaItems(java.util.Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, long j) {
        setMediaItems(java.util.Collections.singletonList(mediaItem), 0, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, boolean z) {
        setMediaItems(java.util.Collections.singletonList(mediaItem), z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        setMediaItems(list, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop() {
        stop(false);
    }
}
