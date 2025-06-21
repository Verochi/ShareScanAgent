package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

/* loaded from: classes.dex */
public class CountDownComponent {
    private final android.widget.TextView tanxc_do;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.OnFinishListener tanxc_for;
    private int tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
        public AnonymousClass1(long j, long j2) {
            super(j, j2);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            com.alimm.tanx.core.utils.LogUtils.d("CountDownComponent", "onFinish.");
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this.tanxc_for != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this.tanxc_for.onFinish();
            }
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this.tanxc_if = java.lang.Math.round(j / 1000.0f);
            com.alimm.tanx.core.utils.LogUtils.d("CountDownComponent", "onTick: millisUntilFinished = " + j);
            if (com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this.tanxc_if < 1) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this.tanxc_if = 1;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent countDownComponent = com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent.this;
            countDownComponent.tanxc_do(countDownComponent.tanxc_if);
        }
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public void tanxc_do(int i) {
        android.widget.TextView textView = this.tanxc_do;
        if (textView == null || i <= 0) {
            return;
        }
        textView.setText(java.lang.String.valueOf(i));
    }
}
