package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class AnsiColorLogger extends org.apache.tools.ant.DefaultLogger {
    public java.lang.String t = "\u001b[2;31m";
    public java.lang.String u = "\u001b[2;35m";
    public java.lang.String v = "\u001b[2;36m";
    public java.lang.String w = "\u001b[2;32m";
    public java.lang.String x = "\u001b[2;34m";
    public boolean y = false;

    public final void b() {
        java.lang.String property = java.lang.System.getProperty("ant.logger.defaults");
        java.io.InputStream inputStream = null;
        try {
            java.util.Properties properties = new java.util.Properties();
            inputStream = property != null ? new java.io.FileInputStream(property) : getClass().getResourceAsStream("/org/apache/tools/ant/listener/defaults.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            }
            java.lang.String property2 = properties.getProperty("AnsiColorLogger.ERROR_COLOR");
            java.lang.String property3 = properties.getProperty("AnsiColorLogger.WARNING_COLOR");
            java.lang.String property4 = properties.getProperty("AnsiColorLogger.INFO_COLOR");
            java.lang.String property5 = properties.getProperty("AnsiColorLogger.VERBOSE_COLOR");
            java.lang.String property6 = properties.getProperty("AnsiColorLogger.DEBUG_COLOR");
            if (property2 != null) {
                this.t = "\u001b[" + property2 + com.anythink.expressad.d.a.b.dH;
            }
            if (property3 != null) {
                this.u = "\u001b[" + property3 + com.anythink.expressad.d.a.b.dH;
            }
            if (property4 != null) {
                this.v = "\u001b[" + property4 + com.anythink.expressad.d.a.b.dH;
            }
            if (property5 != null) {
                this.w = "\u001b[" + property5 + com.anythink.expressad.d.a.b.dH;
            }
            if (property6 != null) {
                this.x = "\u001b[" + property6 + com.anythink.expressad.d.a.b.dH;
            }
        } catch (java.io.IOException unused) {
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
            throw th;
        }
        org.apache.tools.ant.util.FileUtils.close(inputStream);
    }

    @Override // org.apache.tools.ant.DefaultLogger
    public void printMessage(java.lang.String str, java.io.PrintStream printStream, int i) {
        if (str == null || printStream == null) {
            return;
        }
        if (!this.y) {
            b();
            this.y = true;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        if (i == 0) {
            stringBuffer.insert(0, this.t);
            stringBuffer.append("\u001b[m");
        } else if (i == 1) {
            stringBuffer.insert(0, this.u);
            stringBuffer.append("\u001b[m");
        } else if (i == 2) {
            stringBuffer.insert(0, this.v);
            stringBuffer.append("\u001b[m");
        } else if (i != 3) {
            stringBuffer.insert(0, this.x);
            stringBuffer.append("\u001b[m");
        } else {
            stringBuffer.insert(0, this.w);
            stringBuffer.append("\u001b[m");
        }
        printStream.println(stringBuffer.toString());
    }
}
