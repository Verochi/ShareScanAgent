package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class j {
    public com.getui.gtc.base.log.Logger a;

    public static class a {
        private static com.getui.gtc.extension.distribution.gbd.n.j a = new com.getui.gtc.extension.distribution.gbd.n.j((byte) 0);

        private a() {
        }
    }

    private j() {
        com.getui.gtc.base.log.Logger logger = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
        this.a = logger;
        logger.setGlobalTag("gbd");
        this.a.setFileEnableProperty("gbd.fileLog");
        this.a.setLogcatEnable(false);
        this.a.setLogFileNameSuffix("gbd");
        this.a.setStackOffset(1);
    }

    public /* synthetic */ j(byte b) {
        this();
    }

    private static com.getui.gtc.base.log.Logger a() {
        return com.getui.gtc.extension.distribution.gbd.n.j.a.a.a;
    }

    public static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.w(str);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.d(str + "|", str2);
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.e(str, th);
    }

    public static void a(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.e(th);
    }

    public static void b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.filelog(2, null, str, null);
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.filelog(2, null, str + "|" + str2, null);
    }

    public static void b(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.filelog(2, null, null, th);
    }

    private static void c(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.d(str);
    }

    private static void c(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.d(th);
    }

    private static void d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.e(str);
    }

    private static void d(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.w(th);
    }
}
