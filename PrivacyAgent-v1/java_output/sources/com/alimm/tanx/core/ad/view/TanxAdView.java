package com.alimm.tanx.core.ad.view;

/* loaded from: classes.dex */
public class TanxAdView extends android.widget.FrameLayout implements com.alimm.tanx.core.utils.NotConfused {
    private long downTime;
    private com.alimm.tanx.core.ad.monitor.ITanxAdMonitor mAdMonitor;
    private long upTime;

    public TanxAdView(android.content.Context context) {
        this(context, null);
    }

    public TanxAdView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public TanxAdView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public TanxAdView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.downTime = 0L;
        this.upTime = 0L;
    }

    private boolean checkClick() {
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("performClickCheckSwitch")) {
            return this.downTime != 0 && java.lang.System.currentTimeMillis() - this.upTime < 200;
        }
        com.alimm.tanx.core.utils.LogUtils.d("TanxAdView", "不做校验");
        return true;
    }

    private void clearTime() {
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public boolean allowSettingViewSize() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.downTime = java.lang.System.currentTimeMillis();
        }
        if (motionEvent.getAction() == 1) {
            this.upTime = java.lang.System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.alimm.tanx.core.ad.monitor.ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.alimm.tanx.core.ad.monitor.ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        com.alimm.tanx.core.ad.monitor.ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onVisibilityAggregated(z);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.alimm.tanx.core.ad.monitor.ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean performClick = checkClick() ? super.performClick() : false;
        clearTime();
        return performClick;
    }

    public void setAdMonitor(com.alimm.tanx.core.ad.monitor.ITanxAdMonitor iTanxAdMonitor) {
        this.mAdMonitor = iTanxAdMonitor;
    }

    public int setViewSize(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        if (!allowSettingViewSize()) {
            return 0;
        }
        int dp2px = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), iTanxAd.getAdSlot().getExpressViewWidth());
        return dp2px > com.alimm.tanx.core.utils.SysUtils.getScreenWidth(getContext()) ? com.alimm.tanx.core.utils.SysUtils.getScreenWidth(getContext()) : dp2px <= 0 ? android.view.View.MeasureSpec.getSize(i) : dp2px;
    }
}
