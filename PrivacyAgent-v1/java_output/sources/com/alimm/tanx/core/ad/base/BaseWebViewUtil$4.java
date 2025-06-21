package com.alimm.tanx.core.ad.base;

/* loaded from: classes.dex */
public class BaseWebViewUtil$4 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
    final /* synthetic */ com.alimm.tanx.core.ad.base.tanxc_if this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebViewUtil$4(com.alimm.tanx.core.ad.base.tanxc_if tanxc_ifVar, long j, long j2) {
        super(j, j2);
        this.this$0 = tanxc_ifVar;
    }

    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
    public void onFinish() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "startTimer - onFinish");
        this.this$0.tanxc_goto = false;
        com.alimm.tanx.core.ad.base.tanxc_if.tanxc_new(this.this$0);
        this.this$0.tanxc_new();
    }

    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
    public void onTick(long j) {
        com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "startTimer" + java.lang.Math.round(j / 1000.0f) + "");
    }
}
