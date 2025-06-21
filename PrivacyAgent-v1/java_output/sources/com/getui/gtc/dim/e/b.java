package com.getui.gtc.dim.e;

/* loaded from: classes22.dex */
public final class b {
    private final com.getui.gtc.base.log.Logger a;

    public static class a {
        private static final com.getui.gtc.dim.e.b a = new com.getui.gtc.dim.e.b((byte) 0);
    }

    private b() {
        com.getui.gtc.base.log.Logger logger = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
        this.a = logger;
        logger.setGlobalTag("gtc.dim");
        logger.setFileEnableProperty("dim.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static void a(java.lang.String str) {
        com.getui.gtc.dim.e.b.a.a.a.d(str);
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        com.getui.gtc.dim.e.b.a.a.a.e(str, th);
    }

    public static void a(java.lang.Throwable th) {
        com.getui.gtc.dim.e.b.a.a.a.w(th);
    }

    public static void b(java.lang.String str) {
        com.getui.gtc.dim.e.b.a.a.a.w(str);
    }

    public static void b(java.lang.Throwable th) {
        com.getui.gtc.dim.e.b.a.a.a.e(th);
    }
}
