package com.getui.gs.h;

/* loaded from: classes22.dex */
public final class b {
    public final com.getui.gtc.base.log.Logger a;

    public static class a {
        private static final com.getui.gs.h.b a = new com.getui.gs.h.b((byte) 0);
    }

    private b() {
        com.getui.gtc.base.log.Logger logger = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
        this.a = logger;
        logger.setGlobalTag("GsIdo");
        logger.setFileEnableProperty("gs.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gs");
        logger.setStackOffset(1);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static void a(java.lang.String str) {
        com.getui.gs.h.b.a.a.a.d(str);
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        com.getui.gs.h.b.a.a.a.e(str, th);
    }

    public static void a(java.lang.Throwable th) {
        com.getui.gs.h.b.a.a.a.e(th);
    }
}
