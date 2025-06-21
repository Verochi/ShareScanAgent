package cn.shuzilm.core;

/* loaded from: classes.dex */
class q implements java.lang.Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ cn.shuzilm.core.DUHelper b;

    public q(cn.shuzilm.core.DUHelper dUHelper, int i) {
        this.b = dUHelper;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            cn.shuzilm.core.DUHelper.getQueryID(cn.shuzilm.core.DUHelper.mContext, "NA", "", false, 1, null, this.a + 100);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
