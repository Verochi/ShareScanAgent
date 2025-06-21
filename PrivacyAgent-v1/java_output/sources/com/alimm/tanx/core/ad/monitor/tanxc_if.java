package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.monitor.tanxc_do {
    private boolean tanxc_break;
    private float tanxc_catch;
    private int tanxc_class;
    private int tanxc_const;
    private long tanxc_this;
    private long tanxc_void;

    public tanxc_if(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.monitor.ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 2);
        com.alimm.tanx.core.orange.bean.OrangeUtBean orangeUtBean;
        com.alimm.tanx.core.orange.bean.FeedMonitorBean feedMonitorBean;
        this.tanxc_break = true;
        this.tanxc_catch = 0.2f;
        com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (feedMonitorBean = orangeUtBean.feedMonitor) == null) {
            return;
        }
        this.tanxc_catch = feedMonitorBean.getMinRatio();
    }

    private void tanxc_long() {
        if (com.alimm.tanx.core.ut.impl.TanxMonitorUt.isOpenFeedMonitor()) {
            if ((this.tanxc_for && this.tanxc_int && this.tanxc_new && this.tanxc_goto.width() > 0 && this.tanxc_goto.height() > 0) || this.tanxc_this == 0 || !this.tanxc_break) {
                return;
            }
            this.tanxc_break = false;
            this.tanxc_void = android.os.SystemClock.elapsedRealtime() - this.tanxc_this;
            this.tanxc_this = 0L;
            if (this.tanxc_if != null) {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("exposure_time", java.lang.String.valueOf(this.tanxc_void));
                hashMap.put("min_ratio", java.lang.String.valueOf(this.tanxc_catch));
                hashMap.put("width", java.lang.String.valueOf(this.tanxc_class));
                hashMap.put("height", java.lang.String.valueOf(this.tanxc_const));
                this.tanxc_if.onMonitor(hashMap);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_long();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (java.lang.Math.abs(this.tanxc_goto.height()) > this.tanxc_do.getHeight() * this.tanxc_catch && java.lang.Math.abs(this.tanxc_goto.width()) > this.tanxc_do.getWidth() * this.tanxc_catch && this.tanxc_this == 0) {
            this.tanxc_this = android.os.SystemClock.elapsedRealtime();
        }
        this.tanxc_class = this.tanxc_do.getWidth();
        this.tanxc_const = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_try() {
        super.tanxc_try();
    }
}
