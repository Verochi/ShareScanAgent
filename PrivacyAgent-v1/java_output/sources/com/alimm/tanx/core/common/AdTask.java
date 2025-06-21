package com.alimm.tanx.core.common;

/* loaded from: classes.dex */
public class AdTask implements java.lang.Runnable {
    private java.lang.Runnable tanxc_do;
    private com.alimm.tanx.core.common.AdTask.onErrorListener tanxc_for;
    private java.lang.String tanxc_if;

    public interface onErrorListener {
        void onError(java.lang.String str);
    }

    public AdTask(java.lang.Runnable runnable, java.lang.String str) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
    }

    public AdTask(java.lang.Runnable runnable, java.lang.String str, com.alimm.tanx.core.common.AdTask.onErrorListener onerrorlistener) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
        this.tanxc_for = onerrorlistener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.tanxc_do.run();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.common.AdTask.onErrorListener onerrorlistener = this.tanxc_for;
            if (onerrorlistener != null) {
                onerrorlistener.onError(e.getMessage());
            }
            com.alimm.tanx.core.utils.LogUtils.e("AdTask", e, "AdTask");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "AdTask", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "AdTask");
        }
    }
}
