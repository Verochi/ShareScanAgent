package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public abstract class TanxCountDownTimer implements com.alimm.tanx.core.utils.NotConfused {
    private static final int MSG = 1;
    private static final java.lang.String TAG = "TanxCountDownTimer";
    public static final int TIMER_CANCELLED = 3;
    public static final int TIMER_FINISH = 4;
    public static final int TIMER_INIT = 0;
    public static final int TIMER_PAUSE = 2;
    public static final int TIMER_START = 1;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mPauseLeftInFuture;
    private long mStopTimeInFuture;
    private volatile int nowType = 0;
    private final android.os.Handler mHandler = new com.alimm.tanx.core.utils.TanxCountDownTimer.AnonymousClass1();

    /* renamed from: com.alimm.tanx.core.utils.TanxCountDownTimer$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            long j;
            synchronized (com.alimm.tanx.core.utils.TanxCountDownTimer.this) {
                if (com.alimm.tanx.core.utils.TanxCountDownTimer.this.nowType == 3) {
                    return;
                }
                if (com.alimm.tanx.core.utils.TanxCountDownTimer.this.nowType == 2) {
                    return;
                }
                long elapsedRealtime = com.alimm.tanx.core.utils.TanxCountDownTimer.this.mStopTimeInFuture - android.os.SystemClock.elapsedRealtime();
                long j2 = 0;
                if (elapsedRealtime <= 0) {
                    com.alimm.tanx.core.utils.TanxCountDownTimer.this.setFinish();
                } else {
                    long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                    com.alimm.tanx.core.utils.TanxCountDownTimer.this.onTick(elapsedRealtime);
                    long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime2;
                    if (elapsedRealtime < com.alimm.tanx.core.utils.TanxCountDownTimer.this.mCountdownInterval) {
                        j = elapsedRealtime - elapsedRealtime3;
                        if (j < 0) {
                            sendMessageDelayed(obtainMessage(1), j2);
                        }
                    } else {
                        j = com.alimm.tanx.core.utils.TanxCountDownTimer.this.mCountdownInterval - elapsedRealtime3;
                        while (j < 0) {
                            j += com.alimm.tanx.core.utils.TanxCountDownTimer.this.mCountdownInterval;
                        }
                    }
                    j2 = j;
                    sendMessageDelayed(obtainMessage(1), j2);
                }
            }
        }
    }

    public TanxCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinish() {
        this.nowType = 4;
        onFinish();
    }

    public final synchronized void cancel() {
        this.nowType = 3;
        this.mHandler.removeMessages(1);
        com.alimm.tanx.core.utils.LogUtils.d("myTimer cancel:", this.mPauseLeftInFuture + "");
    }

    public void finishReStart() {
        this.nowType = 0;
        start();
    }

    public int getNowType() {
        return this.nowType;
    }

    public boolean isCancelled() {
        return this.nowType == 3;
    }

    public boolean isPaused() {
        return this.nowType == 2;
    }

    public boolean isStart() {
        return this.nowType == 1;
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final synchronized void pause() {
        if (this.nowType == 1) {
            this.nowType = 2;
            this.mPauseLeftInFuture = this.mStopTimeInFuture - android.os.SystemClock.elapsedRealtime();
            this.mHandler.removeMessages(1);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "myTimer pause:" + this.mPauseLeftInFuture);
        }
    }

    public final synchronized com.alimm.tanx.core.utils.TanxCountDownTimer resume() {
        if (this.nowType == 2) {
            this.nowType = 1;
            if (this.mPauseLeftInFuture <= 0) {
                setFinish();
                return this;
            }
            this.mStopTimeInFuture = android.os.SystemClock.elapsedRealtime() + this.mPauseLeftInFuture;
            android.os.Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            com.alimm.tanx.core.utils.LogUtils.d("myTimer resume:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized com.alimm.tanx.core.utils.TanxCountDownTimer start() {
        if (this.nowType == 0) {
            this.nowType = 1;
            if (this.mMillisInFuture <= 0) {
                setFinish();
                return this;
            }
            this.mStopTimeInFuture = android.os.SystemClock.elapsedRealtime() + this.mMillisInFuture;
            android.os.Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            com.alimm.tanx.core.utils.LogUtils.d("myTimer start:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized com.alimm.tanx.core.utils.TanxCountDownTimer updateTime(long j) {
        this.mPauseLeftInFuture = j;
        this.mStopTimeInFuture = android.os.SystemClock.elapsedRealtime() + j;
        return this;
    }
}
