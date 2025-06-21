package com.getui.gtc.base.log.d;

/* loaded from: classes22.dex */
public final class b implements com.getui.gtc.base.log.d.a {
    private final java.util.List<com.getui.gtc.base.log.ILogController> a = new java.util.ArrayList();

    @Override // com.getui.gtc.base.log.d.a
    public final void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        for (com.getui.gtc.base.log.ILogController iLogController : this.a) {
            try {
                if (iLogController.isLoggable(i, str)) {
                    iLogController.log(i, str, str2, th);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void a(com.getui.gtc.base.log.ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.a.add(iLogController);
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void b(com.getui.gtc.base.log.ILogController iLogController) {
        if (this.a.contains(iLogController)) {
            this.a.remove(iLogController);
        }
    }
}
