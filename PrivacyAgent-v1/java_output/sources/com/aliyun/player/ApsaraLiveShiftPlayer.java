package com.aliyun.player;

/* loaded from: classes.dex */
class ApsaraLiveShiftPlayer extends com.aliyun.player.AVPBase implements com.aliyun.player.AliLiveShiftPlayer {
    public static final int SeekLive = 10;
    private com.aliyun.player.IPlayer.OnLoadingStatusListener innerOnLoadingStatusListener;
    private com.aliyun.player.IPlayer.OnStateChangedListener innerOnStateChangedListener;
    private long liveSeekOffset;
    private long liveSeekToTime;
    private com.aliyun.player.source.LiveShift liveShiftSource;
    private com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater;
    private com.aliyun.player.IPlayer.OnLoadingStatusListener mOnLoadingStatusListener;
    private com.aliyun.player.IPlayer.OnPreparedListener mOnPreparedListener;
    private com.aliyun.player.IPlayer.OnStateChangedListener mOnStateChangedListener;
    private com.aliyun.player.AliLiveShiftPlayer.OnSeekLiveCompletionListener mOutSeekLiveCompletionListener;
    private com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener mOutTimeShiftUpdaterListener;
    private int status;
    private int statusWhenSeek;
    private com.aliyun.player.ApsaraLiveShiftPlayer.InnerTimeShiftUpdaterListener timeShiftUpdaterListener;

    public static class InnerOnLoadingStatusListener implements com.aliyun.player.IPlayer.OnLoadingStatusListener {
        private java.lang.ref.WeakReference<com.aliyun.player.ApsaraLiveShiftPlayer> playerWR;

        public InnerOnLoadingStatusListener(com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new java.lang.ref.WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingBegin();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingEnd();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i, float f) {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingProgress(i, f);
            }
        }
    }

    public static class InnerPreparedListener implements com.aliyun.player.IPlayer.OnPreparedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.ApsaraLiveShiftPlayer> playerWR;

        public InnerPreparedListener(com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new java.lang.ref.WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnPreparedListener
        public void onPrepared() {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onPrepared();
            }
        }
    }

    public static class InnerStateChangedListener implements com.aliyun.player.IPlayer.OnStateChangedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.ApsaraLiveShiftPlayer> playerWR;

        public InnerStateChangedListener(com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new java.lang.ref.WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnStateChangedListener
        public void onStateChanged(int i) {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onStateChanged(i);
            }
        }
    }

    public static class InnerTimeShiftUpdaterListener implements com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener {
        private java.lang.ref.WeakReference<com.aliyun.player.ApsaraLiveShiftPlayer> playerReference;

        public InnerTimeShiftUpdaterListener(com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerReference = new java.lang.ref.WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener
        public void onUpdater(long j, long j2, long j3) {
            com.aliyun.player.ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerReference.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onUpdater(j, j2, j3);
            }
        }
    }

    public ApsaraLiveShiftPlayer(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.liveSeekToTime = -1L;
        this.liveSeekOffset = -1L;
        this.liveShiftSource = null;
        this.liveTimeUpdater = null;
        this.timeShiftUpdaterListener = null;
        this.mOutSeekLiveCompletionListener = null;
        this.mOnPreparedListener = null;
        this.mOnStateChangedListener = null;
        this.innerOnStateChangedListener = new com.aliyun.player.ApsaraLiveShiftPlayer.InnerStateChangedListener(this);
        this.mOnLoadingStatusListener = null;
        this.innerOnLoadingStatusListener = new com.aliyun.player.ApsaraLiveShiftPlayer.InnerOnLoadingStatusListener(this);
        this.mOutTimeShiftUpdaterListener = null;
        this.timeShiftUpdaterListener = new com.aliyun.player.ApsaraLiveShiftPlayer.InnerTimeShiftUpdaterListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingBegin() {
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.pauseUpdater();
        }
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingBegin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingEnd() {
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.resumeUpdater();
        }
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingProgress(int i, float f) {
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingProgress(i, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared() {
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.stopUpdater();
        } else {
            com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater2 = new com.aliyun.liveshift.LiveTimeUpdater(this.mContext, this.liveShiftSource);
            this.liveTimeUpdater = liveTimeUpdater2;
            liveTimeUpdater2.setUpdaterListener(this.timeShiftUpdaterListener);
        }
        this.liveTimeUpdater.setConfig(getConfig());
        this.liveTimeUpdater.setStartPlayTime(this.liveSeekToTime);
        this.liveTimeUpdater.startUpdater();
        int i = this.status;
        this.status = 2;
        if (i != 10) {
            com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
                return;
            }
            return;
        }
        if (this.statusWhenSeek == 3) {
            start();
        } else if (isAutoPlay()) {
            this.liveTimeUpdater.resumeUpdater();
        } else {
            this.liveTimeUpdater.pauseUpdater();
        }
        com.aliyun.player.AliLiveShiftPlayer.OnSeekLiveCompletionListener onSeekLiveCompletionListener = this.mOutSeekLiveCompletionListener;
        if (onSeekLiveCompletionListener != null) {
            onSeekLiveCompletionListener.onSeekLiveCompletion(this.liveSeekToTime);
        }
        this.liveSeekToTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChanged(int i) {
        if (i != 2) {
            this.status = i;
        }
        com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener = this.mOnStateChangedListener;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdater(long j, long j2, long j3) {
        com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener = this.mOutTimeShiftUpdaterListener;
        if (onTimeShiftUpdaterListener != null) {
            onTimeShiftUpdaterListener.onUpdater(j, j2, j3);
        }
    }

    @Override // com.aliyun.player.AVPBase
    public com.aliyun.player.nativeclass.NativePlayerBase createAlivcMediaPlayer(android.content.Context context) {
        return new com.aliyun.player.nativeclass.JniSaasPlayer(context);
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public long getCurrentLiveTime() {
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            return liveTimeUpdater.getLiveTime();
        }
        return 0L;
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public long getCurrentTime() {
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            return liveTimeUpdater.getPlayTime();
        }
        return 0L;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void pause() {
        super.pause();
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.pauseUpdater();
        }
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void seekToLiveTime(long j) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        int i = this.status;
        if (i == 10 || this.liveShiftSource == null) {
            return;
        }
        this.statusWhenSeek = i;
        this.status = 10;
        this.liveSeekToTime = j;
        long currentLiveTime = getCurrentLiveTime() - this.liveSeekToTime;
        this.liveSeekOffset = currentLiveTime;
        if (currentLiveTime < 0) {
            this.liveSeekOffset = 0L;
            this.liveSeekToTime = getCurrentLiveTime();
        }
        java.lang.String url = this.liveShiftSource.getUrl();
        if (this.liveSeekToTime > 0 && this.liveSeekOffset > 0) {
            java.lang.String query = android.net.Uri.parse(url).getQuery();
            if (url.endsWith("?") || url.endsWith("&")) {
                sb = new java.lang.StringBuilder();
                sb.append(url);
                str = "lhs_offset_unix_s_0=";
            } else if (android.text.TextUtils.isEmpty(query)) {
                sb = new java.lang.StringBuilder();
                sb.append(url);
                str = "?lhs_offset_unix_s_0=";
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(url);
                str = "&lhs_offset_unix_s_0=";
            }
            sb.append(str);
            sb.append(this.liveSeekOffset);
            sb.append("&lhs_start=1&aliyunols=on");
            url = sb.toString();
        }
        com.aliyun.player.source.UrlSource urlSource = new com.aliyun.player.source.UrlSource();
        urlSource.setUri(url);
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(urlSource);
            corePlayer.prepare();
        }
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setDataSource(com.aliyun.player.source.LiveShift liveShift) {
        this.liveShiftSource = liveShift;
        com.aliyun.player.source.UrlSource urlSource = new com.aliyun.player.source.UrlSource();
        urlSource.setUri(liveShift.getUrl());
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(urlSource);
        }
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnLoadingStatusListener(com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLoadingStatusListener = onLoadingStatusListener;
        super.setOnLoadingStatusListener(this.innerOnLoadingStatusListener);
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnPreparedListener(com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        super.setOnPreparedListener(new com.aliyun.player.ApsaraLiveShiftPlayer.InnerPreparedListener(this));
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setOnSeekLiveCompletionListener(com.aliyun.player.AliLiveShiftPlayer.OnSeekLiveCompletionListener onSeekLiveCompletionListener) {
        this.mOutSeekLiveCompletionListener = onSeekLiveCompletionListener;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnStateChangedListener(com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener) {
        this.mOnStateChangedListener = onStateChangedListener;
        super.setOnStateChangedListener(this.innerOnStateChangedListener);
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setOnTimeShiftUpdaterListener(com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener) {
        this.mOutTimeShiftUpdaterListener = onTimeShiftUpdaterListener;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void start() {
        super.start();
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.resumeUpdater();
        }
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void stop() {
        super.stop();
        com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.stopUpdater();
        }
    }
}
