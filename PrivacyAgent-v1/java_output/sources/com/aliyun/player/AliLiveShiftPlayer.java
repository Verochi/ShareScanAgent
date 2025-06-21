package com.aliyun.player;

/* loaded from: classes.dex */
public interface AliLiveShiftPlayer extends com.aliyun.player.IPlayer {

    public interface OnSeekLiveCompletionListener {
        void onSeekLiveCompletion(long j);
    }

    public interface OnTimeShiftUpdaterListener {
        void onUpdater(long j, long j2, long j3);
    }

    long getCurrentLiveTime();

    long getCurrentTime();

    void seekToLiveTime(long j);

    void setDataSource(com.aliyun.player.source.LiveShift liveShift);

    void setOnSeekLiveCompletionListener(com.aliyun.player.AliLiveShiftPlayer.OnSeekLiveCompletionListener onSeekLiveCompletionListener);

    void setOnTimeShiftUpdaterListener(com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener);
}
