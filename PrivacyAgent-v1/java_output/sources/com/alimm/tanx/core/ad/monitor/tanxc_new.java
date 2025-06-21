package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public class tanxc_new extends com.alimm.tanx.core.ad.monitor.tanxc_do {
    private long tanxc_break;
    private long tanxc_catch;
    private long tanxc_class;
    private float tanxc_const;
    private long tanxc_final;
    private float tanxc_this;
    private final java.util.List<java.util.Map<java.lang.String, java.lang.Object>> tanxc_void;

    public tanxc_new(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.monitor.ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 1);
        com.alimm.tanx.core.orange.bean.OrangeUtBean orangeUtBean;
        com.alimm.tanx.core.orange.bean.SplashMonitorBean splashMonitorBean;
        this.tanxc_this = 0.2f;
        this.tanxc_void = new java.util.ArrayList();
        com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (splashMonitorBean = orangeUtBean.splashMonitor) == null) {
            return;
        }
        this.tanxc_this = splashMonitorBean.getCoverRatio();
    }

    private void tanxc_do(float f) {
        if (com.alimm.tanx.core.ut.impl.TanxMonitorUt.isOpenSplashMonitor()) {
            if (this.tanxc_void.size() <= 0) {
                this.tanxc_const = f;
                this.tanxc_break = android.os.SystemClock.elapsedRealtime();
                this.tanxc_void.add(tanxc_if(f));
            } else {
                java.util.Map<java.lang.String, java.lang.Object> map = this.tanxc_void.get(r0.size() - 1);
                if (map != null && map.get("cover_percent") != null) {
                    this.tanxc_const = ((java.lang.Float) map.get("cover_percent")).floatValue();
                }
                if (java.lang.Math.abs(f - this.tanxc_const) > 0.05d) {
                    this.tanxc_void.add(tanxc_if(f));
                }
            }
            if (this.tanxc_final == 0) {
                this.tanxc_final = android.os.SystemClock.elapsedRealtime();
            }
            float f2 = this.tanxc_const;
            float f3 = this.tanxc_this;
            if (f2 < f3 && f < f3) {
                this.tanxc_catch += android.os.SystemClock.elapsedRealtime() - this.tanxc_final;
            }
            this.tanxc_final = android.os.SystemClock.elapsedRealtime();
            this.tanxc_const = f;
            this.tanxc_class = android.os.SystemClock.elapsedRealtime() - this.tanxc_break;
        }
    }

    private java.util.Map<java.lang.String, java.lang.Object> tanxc_if(float f) {
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        arrayMap.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        arrayMap.put("width", java.lang.Integer.valueOf(this.tanxc_do.getWidth()));
        arrayMap.put("height", java.lang.Integer.valueOf(this.tanxc_do.getHeight()));
        arrayMap.put("cover_percent", java.lang.Float.valueOf(f));
        return arrayMap;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tanxc_if == null || !com.alimm.tanx.core.ut.impl.TanxMonitorUt.isOpenSplashMonitor()) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("monitors", com.alibaba.fastjson.JSON.toJSONString(this.tanxc_void));
        hashMap.put("total_time", java.lang.String.valueOf(this.tanxc_class));
        hashMap.put("exposure_time", java.lang.String.valueOf(this.tanxc_catch));
        this.tanxc_if.onMonitor(hashMap);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        return super.onPreDraw();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            return;
        }
        tanxc_do(1.0f);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_do() {
        this.tanxc_char = 0L;
        this.tanxc_case = 0.5f;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_for() {
        super.tanxc_for();
        float tanxc_else = tanxc_else();
        if (this.tanxc_int) {
            tanxc_do(tanxc_else);
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }
}
