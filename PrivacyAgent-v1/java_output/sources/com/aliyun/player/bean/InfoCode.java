package com.aliyun.player.bean;

/* loaded from: classes.dex */
public enum InfoCode {
    Unknown(-1),
    LoopingStart(0),
    BufferedPosition(1),
    CurrentPosition(2),
    AutoPlayStart(3),
    CurrentDownloadSpeed(4),
    UtcTime(5),
    LocalCacheLoaded(6),
    SwitchToSoftwareVideoDecoder(100),
    AudioCodecNotSupport(101),
    AudioDecoderDeviceError(102),
    VideoCodecNotSupport(103),
    VideoDecoderDeviceError(104),
    VideoRenderInitError(105),
    DemuxerTraceID(106),
    NetworkRetry(108),
    CacheSuccess(109),
    CacheError(110),
    LowMemory(111),
    NetworkRetrySuccess(113),
    SubtitleSelectError(114),
    DirectComponentMSG(116),
    DemuxerSegmentOpenFailed(119),
    DegradeAsH265Adaptive(121),
    RTSServerMaybeDisconnect(805371905),
    RTSServerRecover(805371906);

    private int value;

    InfoCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
