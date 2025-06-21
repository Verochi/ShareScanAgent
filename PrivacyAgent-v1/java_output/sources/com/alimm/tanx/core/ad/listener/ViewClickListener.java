package com.alimm.tanx.core.ad.listener;

/* loaded from: classes.dex */
public abstract class ViewClickListener implements android.view.View.OnClickListener, com.alimm.tanx.core.utils.NotConfused {
    private long lastClickTime = 0;
    private final long clickInterval = 500;
    private final java.lang.String TAG = "ViewClickListener";

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        try {
            if (java.lang.System.currentTimeMillis() - this.lastClickTime > 500) {
                this.lastClickTime = java.lang.System.currentTimeMillis();
                viewClick(view);
            } else {
                com.alimm.tanx.core.utils.LogUtils.d("ViewClickListener", "点击过快");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.e("ViewClickListener", e.getMessage());
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "ViewClickListener", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public abstract void viewClick(android.view.View view);
}
