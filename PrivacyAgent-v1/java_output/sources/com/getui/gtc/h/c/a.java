package com.getui.gtc.h.c;

/* loaded from: classes22.dex */
public final class a {
    public final com.getui.gtc.base.log.Logger a;

    /* renamed from: com.getui.gtc.h.c.a$a, reason: collision with other inner class name */
    public static class C0329a {
        private static final com.getui.gtc.h.c.a a = new com.getui.gtc.h.c.a((byte) 0);
    }

    private a() {
        com.getui.gtc.base.log.Logger logger = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
        this.a = logger;
        logger.setGlobalTag("gtc");
        logger.setFileEnableProperty("gtc.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static void a(java.lang.String str) {
        com.getui.gtc.h.c.a.C0329a.a.a.d(str);
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        com.getui.gtc.h.c.a.C0329a.a.a.e(str, th);
    }

    public static void a(java.lang.Throwable th) {
        com.getui.gtc.h.c.a.C0329a.a.a.d(th);
    }

    public static void b(java.lang.String str) {
        com.getui.gtc.h.c.a.C0329a.a.a.w(str);
    }

    public static void b(java.lang.Throwable th) {
        com.getui.gtc.h.c.a.C0329a.a.a.w(th);
    }

    public static void c(java.lang.String str) {
        com.getui.gtc.h.c.a.C0329a.a.a.e(str);
    }

    public static void c(java.lang.Throwable th) {
        com.getui.gtc.h.c.a.C0329a.a.a.e(th);
    }

    public static void d(java.lang.String str) {
        com.getui.gtc.h.c.a.C0329a.a.a.filelog(2, null, str, null);
    }

    public static void d(java.lang.Throwable th) {
        com.getui.gtc.h.c.a.C0329a.a.a.filelog(2, null, null, th);
    }
}
