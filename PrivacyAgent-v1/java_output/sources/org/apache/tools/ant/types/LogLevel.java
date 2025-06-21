package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class LogLevel extends org.apache.tools.ant.types.EnumeratedAttribute {
    public static final org.apache.tools.ant.types.LogLevel ERR = new org.apache.tools.ant.types.LogLevel("error");
    public static final org.apache.tools.ant.types.LogLevel WARN = new org.apache.tools.ant.types.LogLevel("warn");
    public static final org.apache.tools.ant.types.LogLevel INFO = new org.apache.tools.ant.types.LogLevel("info");
    public static final org.apache.tools.ant.types.LogLevel VERBOSE = new org.apache.tools.ant.types.LogLevel("verbose");
    public static final org.apache.tools.ant.types.LogLevel DEBUG = new org.apache.tools.ant.types.LogLevel("debug");
    public static int[] b = {0, 1, 1, 2, 3, 4};

    public LogLevel() {
    }

    public LogLevel(java.lang.String str) {
        this();
        setValue(str);
    }

    public int getLevel() {
        return b[getIndex()];
    }

    @Override // org.apache.tools.ant.types.EnumeratedAttribute
    public java.lang.String[] getValues() {
        return new java.lang.String[]{"error", "warn", "warning", "info", "verbose", "debug"};
    }
}
