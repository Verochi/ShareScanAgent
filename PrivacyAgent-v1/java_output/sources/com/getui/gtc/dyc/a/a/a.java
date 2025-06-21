package com.getui.gtc.dyc.a.a;

/* loaded from: classes22.dex */
public class a {
    private com.getui.gtc.base.log.Logger a;

    /* renamed from: com.getui.gtc.dyc.a.a.a$a, reason: collision with other inner class name */
    public static class C0304a {
        private static com.getui.gtc.dyc.a.a.a a = new com.getui.gtc.dyc.a.a.a(null);
    }

    private a() {
        com.getui.gtc.base.log.Logger logger = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
        this.a = logger;
        logger.setGlobalTag("gtc.dyc");
        this.a.setFileEnableProperty("dyc.fileLog");
        this.a.setLogcatEnable(false);
        this.a.setLogFileNameSuffix("gtc");
        this.a.setStackOffset(1);
    }

    public /* synthetic */ a(com.getui.gtc.dyc.a.a.a.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.base.log.Logger a() {
        return com.getui.gtc.dyc.a.a.a.C0304a.a.a;
    }

    public static void a(java.lang.String str) {
        com.getui.gtc.dyc.a.a.a.C0304a.a.a.e(str);
    }

    public static void a(java.lang.Throwable th) {
        com.getui.gtc.dyc.a.a.a.C0304a.a.a.w(th);
    }

    public static void c(java.lang.Throwable th) {
        com.getui.gtc.dyc.a.a.a.C0304a.a.a.e(th);
    }
}
