package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class CountDownComponent {
    private final android.widget.TextView tanxc_do;
    private final int tanxc_for;
    private final com.alimm.tanx.core.utils.TanxCountDownTimer tanxc_if;
    private int tanxc_int;
    private boolean tanxc_new = false;
    private com.alimm.tanx.core.utils.CountDownComponent.OnFinishListener tanxc_try;

    /* renamed from: com.alimm.tanx.core.utils.CountDownComponent$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
        public AnonymousClass1(long j, long j2) {
            super(j, j2);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            com.alimm.tanx.core.utils.LogUtils.d("CountDownComponent", "onFinish.");
            if (com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_try != null) {
                com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_try.onFinish();
            }
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j) {
            com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_int = java.lang.Math.round(j / 1000.0f);
            com.alimm.tanx.core.utils.LogUtils.d("CountDownComponent", "onTick: millisUntilFinished = " + j + " mCurrentCount :" + com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_int);
            if (com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_int < 1) {
                com.alimm.tanx.core.utils.CountDownComponent.this.tanxc_int = 1;
            }
            com.alimm.tanx.core.utils.CountDownComponent countDownComponent = com.alimm.tanx.core.utils.CountDownComponent.this;
            countDownComponent.tanxc_do(countDownComponent.tanxc_int);
        }
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public CountDownComponent(@androidx.annotation.NonNull android.widget.TextView textView, int i, com.alimm.tanx.core.utils.CountDownComponent.OnFinishListener onFinishListener) {
        this.tanxc_do = textView;
        this.tanxc_for = i;
        this.tanxc_try = onFinishListener;
        this.tanxc_if = new com.alimm.tanx.core.utils.CountDownComponent.AnonymousClass1((i * 1000) + 300, 300L);
    }

    public void tanxc_do() {
        com.alimm.tanx.core.utils.LogUtils.d("CountDownComponent", "startCountDown: mCurrentCount = " + this.tanxc_int + ", mIsTimerStarted = " + this.tanxc_new + ", mCountDownTimer = " + this.tanxc_if);
        if (this.tanxc_new || this.tanxc_if == null) {
            return;
        }
        this.tanxc_do.setText(java.lang.String.valueOf(this.tanxc_for));
        this.tanxc_if.start();
        this.tanxc_new = true;
    }

    public void tanxc_do(int i) {
        android.widget.TextView textView = this.tanxc_do;
        if (textView == null || i <= 0) {
            return;
        }
        textView.setText(java.lang.String.valueOf(i));
    }

    public void tanxc_for() {
        com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.pause();
        }
    }

    public void tanxc_if() {
        com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer;
        if (this.tanxc_new && (tanxCountDownTimer = this.tanxc_if) != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_new = false;
        }
        this.tanxc_try = null;
    }

    public void tanxc_int() {
        com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.resume();
        }
    }
}
