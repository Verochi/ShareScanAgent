package com.getui.gtc.base.log;

/* loaded from: classes22.dex */
public class Logger {
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;
    private com.getui.gtc.base.log.a.a fileLogController;
    private com.getui.gtc.base.log.b.a fileLogDestination;
    private com.getui.gtc.base.log.c.a fileLogFormatter;
    private final com.getui.gtc.base.log.d.a logPrinter;
    private final com.getui.gtc.base.log.a.b logcatLogController;
    private final com.getui.gtc.base.log.c.b logcatLogFormatter;

    public Logger() {
        this(null);
    }

    public Logger(android.content.Context context) {
        com.getui.gtc.base.log.d.b bVar = new com.getui.gtc.base.log.d.b();
        this.logPrinter = bVar;
        if (context != null) {
            com.getui.gtc.base.GtcProvider.setContext(context);
        }
        android.content.Context context2 = com.getui.gtc.base.GtcProvider.context();
        context2 = context2 == null ? com.getui.gtc.base.util.CommonUtil.findAppContext() : context2;
        if (context2 != null) {
            com.getui.gtc.base.log.b.a aVar = new com.getui.gtc.base.log.b.a(context2);
            this.fileLogDestination = aVar;
            com.getui.gtc.base.log.c.a aVar2 = new com.getui.gtc.base.log.c.a(aVar);
            this.fileLogFormatter = aVar2;
            com.getui.gtc.base.log.a.a aVar3 = new com.getui.gtc.base.log.a.a(context2, aVar2);
            this.fileLogController = aVar3;
            bVar.a(aVar3);
        }
        com.getui.gtc.base.log.c.b bVar2 = new com.getui.gtc.base.log.c.b(new com.getui.gtc.base.log.b.b());
        this.logcatLogFormatter = bVar2;
        com.getui.gtc.base.log.a.b bVar3 = new com.getui.gtc.base.log.a.b(bVar2);
        this.logcatLogController = bVar3;
        bVar.a(bVar3);
    }

    public void addController(com.getui.gtc.base.log.ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.logPrinter.a(iLogController);
    }

    public void d(java.lang.String str) {
        this.logPrinter.a(2, null, str, null);
    }

    public void d(java.lang.String str, java.lang.String str2) {
        this.logPrinter.a(2, str, str2, null);
    }

    public void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(2, str, str2, th);
    }

    public void d(java.lang.String str, java.lang.Throwable th) {
        this.logPrinter.a(2, str, null, th);
    }

    public void d(java.lang.Throwable th) {
        this.logPrinter.a(2, null, null, th);
    }

    public void e(java.lang.String str) {
        this.logPrinter.a(5, null, str, null);
    }

    public void e(java.lang.String str, java.lang.String str2) {
        this.logPrinter.a(5, str, str2, null);
    }

    public void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(5, str, str2, th);
    }

    public void e(java.lang.String str, java.lang.Throwable th) {
        this.logPrinter.a(5, null, str, th);
    }

    public void e(java.lang.Throwable th) {
        this.logPrinter.a(5, null, null, th);
    }

    public void filelog(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(i | 32, str, str2, th);
    }

    public void i(java.lang.String str) {
        this.logPrinter.a(3, null, str, null);
    }

    public void i(java.lang.String str, java.lang.String str2) {
        this.logPrinter.a(3, str, str2, null);
    }

    public void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(3, str, str2, th);
    }

    public void i(java.lang.String str, java.lang.Throwable th) {
        this.logPrinter.a(3, str, null, th);
    }

    public void i(java.lang.Throwable th) {
        this.logPrinter.a(3, null, null, th);
    }

    public void logcat(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(i | 16, str, str2, th);
    }

    public void removeController(com.getui.gtc.base.log.ILogController iLogController) {
        this.logPrinter.b(iLogController);
    }

    public void setFileEnableProperty(java.lang.String str) {
        com.getui.gtc.base.log.a.a aVar = this.fileLogController;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setGlobalTag(java.lang.String str) {
        this.logcatLogFormatter.a = str;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.a = str;
        }
    }

    public void setLogFileNameSuffix(java.lang.String str) {
        com.getui.gtc.base.log.b.a aVar = this.fileLogDestination;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setLogcatEnable(boolean z) {
        this.logcatLogController.a = z;
    }

    public void setStackOffset(int i) {
        int i2 = i + 8;
        this.logcatLogFormatter.b = i2;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.b = i2;
        }
    }

    public void v(java.lang.String str) {
        this.logPrinter.a(1, null, str, null);
    }

    public void v(java.lang.String str, java.lang.String str2) {
        this.logPrinter.a(1, str, str2, null);
    }

    public void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(1, str, str2, th);
    }

    public void v(java.lang.String str, java.lang.Throwable th) {
        this.logPrinter.a(1, str, null, th);
    }

    public void v(java.lang.Throwable th) {
        this.logPrinter.a(1, null, null, th);
    }

    public void w(java.lang.String str) {
        this.logPrinter.a(4, null, str, null);
    }

    public void w(java.lang.String str, java.lang.String str2) {
        this.logPrinter.a(4, str, str2, null);
    }

    public void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        this.logPrinter.a(4, str, str2, th);
    }

    public void w(java.lang.String str, java.lang.Throwable th) {
        this.logPrinter.a(4, null, str, th);
    }

    public void w(java.lang.Throwable th) {
        this.logPrinter.a(4, null, null, th);
    }
}
