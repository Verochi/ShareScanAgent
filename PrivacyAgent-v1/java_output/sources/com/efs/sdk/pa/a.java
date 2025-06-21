package com.efs.sdk.pa;

/* loaded from: classes22.dex */
public final class a implements com.efs.sdk.pa.PAANRListener {
    private com.efs.sdk.pa.PAFactory a;
    private com.efs.sdk.pa.PATraceListener b;

    public a(com.efs.sdk.pa.PAFactory pAFactory) {
        this.a = pAFactory;
        this.b = pAFactory.getTraceListener();
        boolean enableTracer = pAFactory.getConfigManager().enableTracer();
        com.efs.sdk.pa.PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(enableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(java.lang.String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        com.efs.sdk.pa.c.a(this.a, "patrace", str);
        com.efs.sdk.pa.PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(java.lang.Object obj) {
        com.efs.sdk.pa.PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
