package com.aliyun.liveshift;

/* loaded from: classes.dex */
public class LiveTimeUpdater {
    private static final java.lang.String TAG = "LiveTimeUpdater";
    private static int WHAT_UPDATE_LIVE_TIME = 0;
    private static int WHAT_UPDATE_PLAY_TIME = 1;
    private java.lang.ref.WeakReference<android.content.Context> contextWeak;
    private long liveTime;
    private final com.aliyun.player.source.LiveShift mTimeShift;
    private long playTime;
    private com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener timeShiftUpdaterListener;
    private com.aliyun.player.nativeclass.PlayerConfig mConfig = null;
    private android.os.Handler timer = new com.aliyun.liveshift.LiveTimeUpdater.AnonymousClass1(android.os.Looper.getMainLooper());
    private boolean needPause = false;

    /* renamed from: com.aliyun.liveshift.LiveTimeUpdater$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == com.aliyun.liveshift.LiveTimeUpdater.WHAT_UPDATE_LIVE_TIME) {
                com.aliyun.liveshift.LiveTimeUpdater.this.updateLiveTimer();
                com.aliyun.liveshift.LiveTimeUpdater.this.startUpdateLiveTimerDelay(60);
            } else if (message.what == com.aliyun.liveshift.LiveTimeUpdater.WHAT_UPDATE_PLAY_TIME) {
                if (!com.aliyun.liveshift.LiveTimeUpdater.this.needPause) {
                    com.aliyun.liveshift.LiveTimeUpdater.access$508(com.aliyun.liveshift.LiveTimeUpdater.this);
                }
                com.aliyun.liveshift.LiveTimeUpdater.access$608(com.aliyun.liveshift.LiveTimeUpdater.this);
                com.aliyun.liveshift.LiveTimeUpdater.this.startUpdatePlayTimerDelay(1);
            }
        }
    }

    /* renamed from: com.aliyun.liveshift.LiveTimeUpdater$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.utils.b.d<com.aliyun.liveshift.bean.TimeLineContent> {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.utils.b.d
        public void onFail(int i, java.lang.String str, java.lang.String str2) {
        }

        @Override // com.aliyun.utils.b.d
        public void onSuccess(com.aliyun.liveshift.bean.TimeLineContent timeLineContent, java.lang.String str) {
            if (com.aliyun.liveshift.LiveTimeUpdater.this.timeShiftUpdaterListener != null) {
                long j = timeLineContent.current;
                long startTime = com.aliyun.liveshift.LiveTimeUpdater.this.getStartTime(timeLineContent);
                long endTime = com.aliyun.liveshift.LiveTimeUpdater.this.getEndTime(timeLineContent);
                com.aliyun.liveshift.LiveTimeUpdater.this.liveTime = j;
                if (com.aliyun.liveshift.LiveTimeUpdater.this.playTime < 0) {
                    com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater = com.aliyun.liveshift.LiveTimeUpdater.this;
                    liveTimeUpdater.playTime = liveTimeUpdater.liveTime;
                }
                com.aliyun.liveshift.LiveTimeUpdater.this.startUpdatePlayTimerDelay(0);
                com.aliyun.liveshift.LiveTimeUpdater.this.timeShiftUpdaterListener.onUpdater(j, startTime, endTime);
            }
        }
    }

    public LiveTimeUpdater(android.content.Context context, com.aliyun.player.source.LiveShift liveShift) {
        this.contextWeak = new java.lang.ref.WeakReference<>(context);
        this.mTimeShift = liveShift;
    }

    public static /* synthetic */ long access$508(com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater) {
        long j = liveTimeUpdater.playTime;
        liveTimeUpdater.playTime = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$608(com.aliyun.liveshift.LiveTimeUpdater liveTimeUpdater) {
        long j = liveTimeUpdater.liveTime;
        liveTimeUpdater.liveTime = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEndTime(com.aliyun.liveshift.bean.TimeLineContent timeLineContent) {
        java.util.List<com.aliyun.liveshift.bean.TimeLineInfo> list = timeLineContent.timelines;
        if (list == null || list.size() <= 0) {
            return 0L;
        }
        return list.get(list.size() - 1).end;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getStartTime(com.aliyun.liveshift.bean.TimeLineContent timeLineContent) {
        java.util.List<com.aliyun.liveshift.bean.TimeLineInfo> list = timeLineContent.timelines;
        if (list == null || list.size() <= 0) {
            return 0L;
        }
        return list.get(0).start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateLiveTimerDelay(int i) {
        stopUpdateLiveTimer();
        this.timer.sendEmptyMessageDelayed(WHAT_UPDATE_LIVE_TIME, i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdatePlayTimerDelay(int i) {
        stopUpdatePlayTimer();
        this.timer.sendEmptyMessageDelayed(WHAT_UPDATE_PLAY_TIME, i * 1000);
    }

    private void stopUpdateLiveTimer() {
        this.timer.removeMessages(WHAT_UPDATE_LIVE_TIME);
    }

    private void stopUpdatePlayTimer() {
        this.timer.removeMessages(WHAT_UPDATE_PLAY_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLiveTimer() {
        com.aliyun.liveshift.request.GetTimeShiftRequest getTimeShiftRequest = new com.aliyun.liveshift.request.GetTimeShiftRequest(this.contextWeak.get(), this.mTimeShift, new com.aliyun.liveshift.LiveTimeUpdater.AnonymousClass2());
        com.aliyun.player.nativeclass.PlayerConfig playerConfig = this.mConfig;
        if (playerConfig != null) {
            getTimeShiftRequest.setRefer(playerConfig.mReferrer);
            getTimeShiftRequest.setTimeout(this.mConfig.mNetworkTimeout);
            getTimeShiftRequest.setHttpProxy(this.mConfig.mHttpProxy);
            getTimeShiftRequest.setUerAgent(this.mConfig.mUserAgent);
            getTimeShiftRequest.setCustomHeaders(this.mConfig.getCustomHeaders());
        }
        getTimeShiftRequest.getAsync();
    }

    public long getLiveTime() {
        return this.liveTime;
    }

    public long getPlayTime() {
        return this.playTime;
    }

    public void pauseUpdater() {
        this.needPause = true;
    }

    public void resumeUpdater() {
        this.needPause = false;
    }

    public void setConfig(com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        this.mConfig = playerConfig;
    }

    public void setStartPlayTime(long j) {
        this.playTime = j;
    }

    public void setUpdaterListener(com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener) {
        this.timeShiftUpdaterListener = onTimeShiftUpdaterListener;
    }

    public void startUpdater() {
        stopUpdater();
        startUpdateLiveTimerDelay(0);
    }

    public void stopUpdater() {
        stopUpdateLiveTimer();
        stopUpdatePlayTimer();
    }
}
