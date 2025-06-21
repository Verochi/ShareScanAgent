package com.getui.gtc.base.log.a;

/* loaded from: classes22.dex */
public final class b implements com.getui.gtc.base.log.ILogController {
    public boolean a;
    private com.getui.gtc.base.log.ILogFormatter b;

    public b() {
        this(new com.getui.gtc.base.log.c.b());
    }

    public b(com.getui.gtc.base.log.ILogFormatter iLogFormatter) {
        this.a = true;
        this.b = (com.getui.gtc.base.log.ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final boolean isLoggable(int i, java.lang.String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.a;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final void log(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.b.log(i, str, str2, th);
    }
}
