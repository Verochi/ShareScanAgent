package com.qq.e.comm.managers;

/* loaded from: classes19.dex */
class b implements java.lang.Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ com.qq.e.comm.managers.a b;

    public b(com.qq.e.comm.managers.a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.d.getPOFactory(this.a, true);
            this.b.b = true;
        } catch (com.qq.e.comm.managers.plugin.e e) {
            com.qq.e.comm.util.GDTLogger.e(e.getMessage(), e);
        }
    }
}
