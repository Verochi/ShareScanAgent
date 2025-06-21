package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public class TanxAdMonitor$1 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
    final /* synthetic */ com.alimm.tanx.core.ad.monitor.tanxc_do this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TanxAdMonitor$1(com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_doVar, long j, long j2) {
        super(j, j2);
        this.this$0 = tanxc_doVar;
    }

    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
    public void onFinish() {
        com.alimm.tanx.core.utils.LogUtils.d("TanxAdMonitor", "initTimer - onFinish");
    }

    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
    public void onTick(long j) {
        com.alimm.tanx.core.utils.LogUtils.d("TanxAdMonitor", "initTimer  onTick exposureCompleted: " + this.this$0.tanxc_byte + " isOnExposure: " + this.this$0.tanxc_try);
        if (this.this$0.tanxc_byte) {
            this.this$0.tanxc_break();
        } else if (this.this$0.tanxc_try) {
            this.this$0.onPreDraw();
        }
    }
}
